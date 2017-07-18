/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.contacts.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.apigateway.model.NotFoundException;
import com.amazonaws.services.cognitosync.model.Platform;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.GetEndpointAttributesRequest;
import com.amazonaws.services.sns.model.GetEndpointAttributesResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SetEndpointAttributesRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.contacts.model.DeviceAwsEndpoint;
import com.liferay.contacts.model.FlaskMessages;
import com.liferay.contacts.model.FlaskRecipients;
import com.liferay.contacts.model.FlaskUserDeviceRegistration;
import com.liferay.contacts.model.impl.FlaskRecipientsImpl;
import com.liferay.contacts.service.DeviceAwsEndpointServiceUtil;
import com.liferay.contacts.service.EntryServiceUtil;
import com.liferay.contacts.service.FlaskGroupMessagesServiceUtil;
import com.liferay.contacts.service.FlaskMessagesLocalServiceUtil;
import com.liferay.contacts.service.FlaskMessagesServiceUtil;
import com.liferay.contacts.service.FlaskRecipientsLocalServiceUtil;
import com.liferay.contacts.service.FlaskRecipientsServiceUtil;
import com.liferay.contacts.service.FlaskUserDeviceRegistrationServiceUtil;
import com.liferay.contacts.service.base.FlaskMessagesServiceBaseImpl;
import com.liferay.contacts.service.persistence.DeviceAwsEndpointUtil;
import com.liferay.contacts.service.persistence.FlaskRecipientsUtil;
import com.liferay.contacts.service.persistence.FlaskUserDeviceRegistrationUtil;
import com.liferay.contacts.util.ContactsUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.rumbasolutions.flask.model.FlaskGroup;
import com.rumbasolutions.flask.service.FlaskGroupServiceUtil;

/**
 * The implementation of the flask messages remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contacts.service.FlaskMessagesService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Kiran
 * @see com.liferay.contacts.service.base.FlaskMessagesServiceBaseImpl
 * @see com.liferay.contacts.service.FlaskMessagesServiceUtil
 */
public class FlaskMessagesServiceImpl extends FlaskMessagesServiceBaseImpl {

	private static Log LOGGER = LogFactoryUtil.getLog(FlaskMessagesServiceImpl.class);
	
	@Override
	 public FlaskMessages sendFlaskMessage(String recipients, String message, boolean sendEmail, ServiceContext serviceContext){
	  FlaskMessages flaskMessage = null;
	  try {
	   User user = UserLocalServiceUtil.getUserById(serviceContext.getUserId());
	   flaskMessage = FlaskMessagesLocalServiceUtil.createFlaskMessages(CounterLocalServiceUtil.increment());
	   flaskMessage.setSenderEmail(user.getEmailAddress());
	   flaskMessage.setSenderName(user.getFullName());
	   flaskMessage.setRecipients(recipients);
	   flaskMessage.setSenderUserId(user.getUserId());
	   flaskMessage.setMessage(message);
	   flaskMessage.setSendEmail(sendEmail);
	   Date date = new Date();
	   flaskMessage.setDateTime(serviceContext.getCreateDate(date));
	   flaskMessage = FlaskMessagesLocalServiceUtil.addFlaskMessages(flaskMessage);
	   String[] rec = recipients.split(",");
	   for (String userId : rec){
		   if(Long.parseLong(userId) > 0){
			   FlaskRecipientsServiceUtil.addFlaskRecipient(Long.parseLong(userId), flaskMessage.getMessageId(), false, serviceContext);
			   FlaskMessagesServiceUtil.sendPush(Long.parseLong(userId), "Flask Message", "You have a message from "+user.getFullName(), "Friend_Message", user.getModelAttributes(), user.getUserId());
//			   if(sendEmail)
//			        EmailInvitationUtil.emailMessage(user.getFullName(), user.getEmailAddress(), recp.getEmail(), message, serviceContext);
		   }
	   }
	  } catch (Exception e) {
		  LOGGER.error("Exception in sendFlaskMessage: "+e.getMessage());
	  }
	  return flaskMessage;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean sendSnsEmail(String subject, String message){
		boolean mailSent = false;
		try {
			PublishRequest req = new PublishRequest(PropsUtil.get("flask.push.arn"), message, subject);
			AWSCredentials cred = new BasicAWSCredentials(PropsUtil.get("flask.push.accessKey"), PropsUtil.get("flask.push.secretKey"));
			AmazonSNSClient client = new AmazonSNSClient(cred);
			client.publish(req);
			mailSent = true;
		} catch (Exception e) {
			LOGGER.error("Exception in sendSnsEmail: "+e.getMessage());
		}
		return mailSent;
	}
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public JSONArray getAllMyFlaskMessages(long receiverId, ServiceContext serviceContext){
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		try {
			DynamicQuery recipientQuery = DynamicQueryFactoryUtil.forClass(FlaskRecipientsImpl.class);
			Criterion criterion1 = RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("userId", receiverId), RestrictionsFactoryUtil.eq("senderId", serviceContext.getUserId()));
			Criterion criterion2 = RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("senderId", receiverId), RestrictionsFactoryUtil.eq("userId", serviceContext.getUserId()));
			Criterion criterion = RestrictionsFactoryUtil.or(criterion1, criterion2);
			recipientQuery.add(criterion);
			recipientQuery.addOrder(OrderFactoryUtil.desc("receivedDateTime"));
			recipientQuery.setLimit(0, 100);
			List<FlaskRecipients> flaskRecipients = FlaskRecipientsLocalServiceUtil.dynamicQuery(recipientQuery);
			for(FlaskRecipients recp: flaskRecipients){
				if(!recp.getDeletedBy().equals("")){
					List<String> deletedBy = Arrays.asList(recp.getDeletedBy().split(","));
					if(deletedBy.contains(String.valueOf(serviceContext.getUserId())))
						continue;
				}
					
				
				JSONObject jsonObj =  JSONFactoryUtil.createJSONObject();
				FlaskMessages msg = FlaskMessagesLocalServiceUtil.getFlaskMessages(recp.getMessageId());
				jsonObj.put("dateTime", msg.getDateTime().getTime());
				jsonObj.put("message", msg.getMessage());
				jsonObj.put("messageId", msg.getMessageId());
				jsonObj.put("recipients", msg.getRecipients());
				jsonObj.put("sendEmail", msg.getSendEmail());
				jsonObj.put("senderEmail", msg.getSenderEmail());
				jsonObj.put("senderName", msg.getSenderName());
				jsonObj.put("senderUserId", msg.getSenderUserId());
				jsonObj.put("read", recp.isRead());
				jsonObj.put("portraitId", UserLocalServiceUtil.getUserById(msg.getSenderUserId()).getPortraitId());
				jsonArray.put(jsonObj);
			}
		} catch (Exception e) {
			LOGGER.error("Exception in getAllMyFlaskMessages: "+e.getMessage());
		}
		return jsonArray;
	}
	
	@Override
	public List<FlaskMessages> getMyUnreadFlaskMessages(long receiverId, ServiceContext serviceContext){
		List<FlaskMessages> flaskMessages = new ArrayList<FlaskMessages>();
		try {
			List<FlaskRecipients> flaskRecipients = FlaskRecipientsUtil.findByreadFlag(serviceContext.getUserId(), false, receiverId);
			for(FlaskRecipients recp: flaskRecipients){
				List<String> deletedBy = Arrays.asList(recp.getDeletedBy().split(","));
				if(!deletedBy.contains(String.valueOf(serviceContext.getUserId())))
					flaskMessages.add(FlaskMessagesLocalServiceUtil.getFlaskMessages(recp.getMessageId()));
			}
		} catch (Exception e) {
			LOGGER.error("Exception in getMyUnreadFlaskMessages: "+e.getMessage());
		}
		return flaskMessages;
	}
	
	@Override
	public int getMyFlaskMessagesCount(long receiverId, ServiceContext serviceContext){
		int count = 0;
		try {
			List<FlaskRecipients> flaskRecipients = FlaskRecipientsUtil.findByUserIdSenderId(serviceContext.getUserId(), receiverId);
			for(FlaskRecipients recp: flaskRecipients){
				List<String> deletedBy = Arrays.asList(recp.getDeletedBy().split(","));
				if(!deletedBy.contains(String.valueOf(serviceContext.getUserId())))
					count++;
			}
		} catch (Exception e) {
			LOGGER.error("Exception in getMyFlaskMessagesCount: "+e.getMessage());
		}
		return count;
	}
	
	@Override
	public int getMyUnreadFlaskMessagesCount(long receiverId, ServiceContext serviceContext){
		int count = 0;
		try {
			List<FlaskRecipients> flaskRecipients = FlaskRecipientsUtil.findByUserIdSenderId(serviceContext.getUserId(), receiverId);
			for(FlaskRecipients recp: flaskRecipients){
				List<String> deletedBy = new ArrayList<String>();
				if(!recp.getDeletedBy().equals("")){
					deletedBy = Arrays.asList(recp.getDeletedBy().split(","));
				}
					
				if(!deletedBy.contains(String.valueOf(serviceContext.getUserId())) && !recp.getRead()){
					count++;
				}
			}
		} catch (Exception e) {
			LOGGER.error("Exception in getMyUnreadFlaskMessagesCount: "+e.getMessage());
		}
		return count;
	}
	
	@Override
	public int getTotalUnreadChatCount(ServiceContext serviceContext){
		int count = 0;
		try {
			JSONArray myFriends = EntryServiceUtil.searchMyFriends(serviceContext.getCompanyId(), " ", serviceContext);
			List<FlaskGroup> flaskGroups = FlaskGroupServiceUtil.getGroups(serviceContext.getUserId());
			for(int i =0; i<myFriends.length(); i++ ){
				int userMessageCount = 0;
				userMessageCount = FlaskMessagesServiceUtil.getMyUnreadFlaskMessagesCount(myFriends.getJSONObject(i).getLong("userId"), serviceContext);
				if(userMessageCount > 0){
					count = count + userMessageCount;
				}
			}
			for(FlaskGroup flaskgroup: flaskGroups){
				int groupMessageCount = 0;
				groupMessageCount = FlaskGroupMessagesServiceUtil.getMyUnreadFlaskGroupMessagesCount(flaskgroup.getGroupId(), serviceContext);
				if(groupMessageCount > 0){
					count = count + groupMessageCount;
				}
			}
		} catch (Exception e) {
			LOGGER.error("Exception in getTotalUnreadChatCount: "+e.getMessage());
		}
		return count;
	}
	
	@Override
	public void deleteMessage(long messageId, ServiceContext serviceContext){
		try {
			List<FlaskRecipients> recipients = FlaskRecipientsUtil.findByreadOrNot(serviceContext.getUserId(), messageId);
			FlaskRecipientsLocalServiceUtil.deleteFlaskRecipients(recipients.get(0));
			int recCount = FlaskRecipientsUtil.countBymessageId(messageId);
			if(recCount <= 0){
				FlaskMessages msg = FlaskMessagesLocalServiceUtil.getFlaskMessages(messageId);
				FlaskMessagesLocalServiceUtil.deleteFlaskMessages(msg);
			}
		} catch (Exception e) {
			LOGGER.error("Exception in deleteMessage: "+e.getMessage());
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void deleteMessagesByDateRange(Date startDate, Date endDate, ServiceContext serviceContext){
		try {
			List<FlaskMessages> messages =  FlaskMessagesLocalServiceUtil.getFlaskMessageses(0, FlaskMessagesLocalServiceUtil.getFlaskMessagesesCount());
			for(FlaskMessages msg: messages){
				Date msgDate = new Date(msg.getDateTime().getDate());
				Date stDate = new Date(startDate.getDate());
				Date enDate = new Date(endDate.getDate());
				if(stDate.compareTo(msgDate) <= 0 && enDate.compareTo(msgDate) >= 0){
					FlaskMessagesLocalServiceUtil.deleteFlaskMessages(msg);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Exception in deleteMessagesByDateRange: "+e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteMyChatMessages(Long[] messageIds, ServiceContext serviceContext){
		boolean done = false;
		try {
			DynamicQuery recipientQuery = DynamicQueryFactoryUtil.forClass(FlaskRecipientsImpl.class);
			Criterion criterion = RestrictionsFactoryUtil.in("messageId", Arrays.asList(messageIds));
			recipientQuery.add(criterion);
			recipientQuery.addOrder(OrderFactoryUtil.desc("receivedDateTime"));
			List<FlaskRecipients> flaskRecipients = FlaskRecipientsLocalServiceUtil.dynamicQuery(recipientQuery);
			for(FlaskRecipients rec: flaskRecipients){
				String deletedBy = rec.getDeletedBy();
				if(deletedBy.isEmpty() || deletedBy=="")
					deletedBy = deletedBy+String.valueOf(serviceContext.getUserId());
				else
					deletedBy = deletedBy+","+String.valueOf(serviceContext.getUserId());
				rec.setDeletedBy(deletedBy);
				FlaskRecipientsLocalServiceUtil.updateFlaskRecipients(rec);
			}
			done = true;
		} catch (Exception e) {
			LOGGER.error("Error in deleteMyChatMessages: " + e.getMessage());
		}
		return done;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	@Override
	public boolean registerWithSNS(long userId, String userEmail, String devicePlatform, 
   		 String deviceDetails, String deviceToken, Date registrationTime, Boolean active, 
   		 Date lastNotificationTime, String lastNotificationMsg, ServiceContext  serviceContext) {
		boolean done = false;
		String endpointArn = null;
		boolean updateNeeded = false;
	    boolean createNeeded = false;
		try {
			LOGGER.debug("Started registring with SNS");
			AWSCredentials cred = new BasicAWSCredentials(PropsUtil.get("flask.push.accessKey"), PropsUtil.get("flask.push.secretKey"));
			AmazonSNSClient client = new AmazonSNSClient(cred);
			long userDeviceRegistrationId = 0;
			List<FlaskUserDeviceRegistration> registeredDevices = FlaskUserDeviceRegistrationUtil.findByUserIdDeviceToken(userId, deviceToken);
			if(registeredDevices.size()<=0){
				LOGGER.debug("Creating platform endpoint");
				endpointArn = ContactsUtil.createPlatformEndpoint(client, deviceToken, devicePlatform);
			    createNeeded = false;
				userDeviceRegistrationId = FlaskUserDeviceRegistrationServiceUtil.addUserDevice(userId, userEmail, devicePlatform, deviceDetails, deviceToken, 
						registrationTime, active, lastNotificationTime, lastNotificationMsg, serviceContext).getUserDeviceRegistrationId();
				DeviceAwsEndpointServiceUtil.addDeviceAwsEndpoint(endpointArn, userDeviceRegistrationId);
			}else{
				LOGGER.debug("Retrieving platform endpoint");
				userDeviceRegistrationId = registeredDevices.get(0).getUserDeviceRegistrationId();
				FlaskUserDeviceRegistrationServiceUtil.activateUserForUserDevice(userDeviceRegistrationId);
				DeviceAwsEndpoint deviceAwsEndpoint = DeviceAwsEndpointUtil.findByendpointsByRegistrationId(userDeviceRegistrationId).get(0);
				endpointArn = deviceAwsEndpoint.getAwsEndpoint();
			}
		    // Look up the platform endpoint and make sure the data in it is current, even if
		    // it was just created.
		    try {
		      GetEndpointAttributesRequest geaReq = new GetEndpointAttributesRequest().withEndpointArn(endpointArn);
		      GetEndpointAttributesResult geaRes = client.getEndpointAttributes(geaReq);
		   
		      updateNeeded = !geaRes.getAttributes().get("Token").equals(deviceToken)
		        || !geaRes.getAttributes().get("Enabled").equalsIgnoreCase("true");
		   
		    } catch (NotFoundException nfe) {
		      // We had a stored ARN, but the platform endpoint associated with it
		      // disappeared. Recreate it.
		        createNeeded = true;
		    }
		    if (createNeeded) {		    	
		    	LOGGER.debug("Creating platform endpoint");
		    	endpointArn = ContactsUtil.createPlatformEndpoint(client, deviceToken, devicePlatform);
		    	DeviceAwsEndpointServiceUtil.addDeviceAwsEndpoint(endpointArn, userDeviceRegistrationId);
		    }
		    if (updateNeeded) {
//		    	The platform endpoint is out of sync with the current data;
//		    	update the token and enable it.
		    	LOGGER.debug("Updating platform endpoint");
		    	Map attribs = new HashMap();
		    	attribs.put("Token", deviceToken);
		    	attribs.put("Enabled", "true");
		    	SetEndpointAttributesRequest saeReq = new SetEndpointAttributesRequest()
		    		.withEndpointArn(endpointArn)
		    		.withAttributes(attribs);
		    	client.setEndpointAttributes(saeReq);
		    }
		    LOGGER.debug("Registration with SNS is done");
		    done = true;
		} catch (Exception e) {
			LOGGER.error("Exception in registerWithSNS: "+e.getMessage());
		}
		return done;
	}
	
	@SuppressWarnings({ "deprecation" })
	@Override
	public boolean sendPush(long userId, String title, String message, String infoType, Map<String, Object> infoDataMap, long notId){
		boolean done = true;
		try {
			List<FlaskUserDeviceRegistration> registeredUserDevices = FlaskUserDeviceRegistrationUtil.findByUserId(userId);
			boolean send = false;
			AWSCredentials cred = new BasicAWSCredentials(PropsUtil.get("flask.push.accessKey"), PropsUtil.get("flask.push.secretKey"));
			AmazonSNSClient client = new AmazonSNSClient(cred);
			String jsonStringInfoData = new ObjectMapper().writeValueAsString(infoDataMap);
			for(FlaskUserDeviceRegistration device: registeredUserDevices){
				if(device.getActive()){
					client = new AmazonSNSClient(cred);
					PublishRequest req = new PublishRequest();
					req.setMessageStructure("json");
					Map<String, Object> messageMap = new HashMap<String, Object>();
					Map<String, Object> payload = new HashMap<String, Object>();
					payload.put("title", title);
					payload.put("image", PropsUtil.get("flask.push.notification.image"));
					Map<String, String> map = new HashMap<String, String>();
					if(device.getDevicePlatform().equals("Android")){
						payload.put("message", message);	
						payload.put("infoType", infoType);
						payload.put("notId", notId);
						payload.put("infoData", jsonStringInfoData);
						int[] led = {0, 0, 25, 0};
						payload.put("ledColor", led);
						messageMap.put("data", payload);
						map.put(Platform.GCM.name(), ContactsUtil.jsonify(messageMap));
					}
					if(device.getDevicePlatform().equals("iOS")){
						payload.put("alert", message);
						payload.put("sound", "default");
						payload.put("badge", true);
						payload.put("content-available", "1");
						messageMap.put("aps", payload);
						messageMap.put("notId", notId);
						messageMap.put("infoType", infoType);
						messageMap.put("infoData", infoDataMap);
						map.put(Platform.APNS.name(), ContactsUtil.jsonify(messageMap));
						map.put(Platform.APNS_SANDBOX.name(), ContactsUtil.jsonify(messageMap));
					}
					String jsonMessage = ContactsUtil.jsonify(map);
					req.setMessage(jsonMessage);
					send = false;
					try {
						req.setTargetArn(DeviceAwsEndpointUtil.findByendpointsByRegistrationId(device.getUserDeviceRegistrationId()).get(0).getAwsEndpoint());
						Map<String, String> attribs = new HashMap<String, String>();
				    	attribs.put("Enabled", "true");
						SetEndpointAttributesRequest saeReq = new SetEndpointAttributesRequest()
			    		.withEndpointArn(DeviceAwsEndpointUtil.findByendpointsByRegistrationId(device.getUserDeviceRegistrationId()).get(0).getAwsEndpoint())
			    		.withAttributes(attribs);
						client.setEndpointAttributes(saeReq);
						send = true;
					} catch (Exception e) {						
						send = false;
					}finally{
						if(send)
							client.publish(req);
					}
				}
			}
			done = true;
		} catch (Exception e) {
			LOGGER.error("Exception in sendPush: "+e.getMessage());
		}
		return done;
	}
}