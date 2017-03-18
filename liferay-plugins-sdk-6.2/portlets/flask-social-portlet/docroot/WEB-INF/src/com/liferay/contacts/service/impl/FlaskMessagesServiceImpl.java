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
import java.util.Date;
import java.util.List;

import com.liferay.contacts.model.FlaskMessages;
import com.liferay.contacts.model.FlaskRecipients;
import com.liferay.contacts.model.impl.FlaskRecipientsImpl;
import com.liferay.contacts.service.EntryServiceUtil;
import com.liferay.contacts.service.FlaskGroupMessagesServiceUtil;
import com.liferay.contacts.service.FlaskMessagesLocalServiceUtil;
import com.liferay.contacts.service.FlaskMessagesServiceUtil;
import com.liferay.contacts.service.FlaskRecipientsLocalServiceUtil;
import com.liferay.contacts.service.FlaskRecipientsServiceUtil;
import com.liferay.contacts.service.base.FlaskMessagesServiceBaseImpl;
import com.liferay.contacts.service.persistence.FlaskRecipientsUtil;
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
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.rumbasolutions.flask.email.util.EmailInvitationUtil;
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

	private static Log LOGGER = LogFactoryUtil
			.getLog(FlaskMessagesServiceImpl.class);
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
			   FlaskRecipients recp = FlaskRecipientsServiceUtil.addFlaskRecipient(Long.parseLong(userId), flaskMessage.getMessageId(), false, serviceContext);
			   if(sendEmail)
			        EmailInvitationUtil.emailMessage(user.getFullName(), user.getEmailAddress(), recp.getEmail(), message, serviceContext);
		   }
	   }
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	  return flaskMessage;
	}
	
	@SuppressWarnings("unchecked")
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
				JSONObject jsonObj =  JSONFactoryUtil.createJSONObject();
				FlaskMessages msg = FlaskMessagesLocalServiceUtil.getFlaskMessages(recp.getMessageId());
				jsonObj.put("dateTime", msg.getDateTime());
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
			e.printStackTrace();
		}
		return jsonArray;
	}
	
	@Override
	public List<FlaskMessages> getMyUnreadFlaskMessages(long receiverId, ServiceContext serviceContext){
		List<FlaskMessages> flaskMessages = new ArrayList<FlaskMessages>();
		try {
			List<FlaskRecipients> flaskRecipients = FlaskRecipientsUtil.findByreadFlag(serviceContext.getUserId(), false, receiverId);
			for(FlaskRecipients recp: flaskRecipients){
				flaskMessages.add(FlaskMessagesLocalServiceUtil.getFlaskMessages(recp.getMessageId()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flaskMessages;
	}
	
	@Override
	public int getMyFlaskMessagesCount(long receiverId, ServiceContext serviceContext){
		int count = 0;
		try {
			List<FlaskRecipients> flaskRecipients = FlaskRecipientsUtil.findByUserIdSenderId(serviceContext.getUserId(), receiverId);
			for(@SuppressWarnings("unused") FlaskRecipients recp: flaskRecipients){
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public int getMyUnreadFlaskMessagesCount(long receiverId, ServiceContext serviceContext){
		int count = 0;
		try {
			List<FlaskRecipients> flaskRecipients = FlaskRecipientsUtil.findByUserIdSenderId(serviceContext.getUserId(), receiverId);
			for(FlaskRecipients recp: flaskRecipients){
				if(!recp.getRead()){
					count++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
					count++;
				}
			}
			for(FlaskGroup flaskgroup: flaskGroups){
				int groupMessageCount = 0;
				groupMessageCount = FlaskGroupMessagesServiceUtil.getMyUnreadFlaskGroupMessagesCount(flaskgroup.getGroupId(), serviceContext);
				if(groupMessageCount > 0){
					count++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}
}