/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */

package com.liferay.contacts.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import com.liferay.contacts.model.Entry;
import com.liferay.contacts.model.FlaskGroupRecipients;
import com.liferay.contacts.model.FlaskRecipients;
import com.liferay.contacts.model.impl.FlaskGroupRecipientsImpl;
import com.liferay.contacts.model.impl.FlaskRecipientsImpl;
import com.liferay.contacts.service.FlaskMessagesServiceUtil;
import com.liferay.contacts.service.base.EntryServiceBaseImpl;
import com.liferay.contacts.service.persistence.FlaskGroupRecipientsUtil;
import com.liferay.contacts.service.persistence.FlaskRecipientsUtil;
import com.liferay.contacts.util.ContactsUtil;
import com.liferay.contacts.util.PortletKeys;
import com.liferay.contacts.util.SocialRelationConstants;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.notifications.NotificationEvent;
import com.liferay.portal.kernel.notifications.NotificationEventFactoryUtil;
import com.liferay.portal.kernel.notifications.UserNotificationManagerUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserNotificationDeliveryConstants;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.social.NoSuchRelationException;
import com.liferay.portlet.social.model.SocialRelation;
import com.liferay.portlet.social.model.SocialRequest;
import com.liferay.portlet.social.model.SocialRequestConstants;
import com.liferay.portlet.social.service.SocialRelationLocalServiceUtil;
import com.liferay.portlet.social.service.SocialRequestLocalServiceUtil;
import com.rumbasolutions.flask.model.FlaskGroup;
import com.rumbasolutions.flask.service.FlaskGroupServiceUtil;

/**
 * @author Kiran
 */
public class EntryServiceImpl extends EntryServiceBaseImpl {
	
	private static Log LOGGER = LogFactoryUtil.getLog(EntryServiceImpl.class);
	
	long socialRequestId;
	public JSONArray searchUsersAndContacts(
			long companyId, String keywords, int start, int end, ServiceContext serviceContext){
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		try {
			long userId = getUserId();
			List<BaseModel<?>> contacts = entryLocalService.searchUsersAndContacts(
				companyId, userId, keywords, start, end);
			for (BaseModel<?> contact : contacts) {
				JSONObject jsonObject = null;
				if (contact instanceof User) {
					if(((User) contact).getContact().getUserId() == serviceContext.getUserId()){
						continue;
					}
					jsonObject = ContactsUtil.getUserJSONObject(
						userId, (User)contact);
					jsonObject.put("portraitId", ((User) contact).getPortraitId());
				}
				else {
					jsonObject = ContactsUtil.getEntryJSONObject((Entry)contact);
					jsonObject.put("portraitId", ((User) contact).getPortraitId());
				}
				jsonArray.put(jsonObject);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return jsonArray;
	}

	public List<SocialRequest> getRequestsToConfirm(ServiceContext serviceContext)throws PortalException, SystemException {
		
		 int requestCount = SocialRequestLocalServiceUtil.getReceiverUserRequestsCount(serviceContext.getUserId());
		  List<SocialRequest> requests = SocialRequestLocalServiceUtil.getReceiverUserRequests(serviceContext.getUserId(), SocialRequestConstants.STATUS_PENDING, 0, requestCount);
		  
		  return requests;
	}
	
	public SocialRequest deleteRequest(long receiverUserId, ServiceContext serviceContext)throws Exception {
			SocialRequest sRequest = null;
			int cnt = SocialRequestLocalServiceUtil.getReceiverUserRequestsCount(serviceContext.getUserId());
			List<SocialRequest> request = SocialRequestLocalServiceUtil.getReceiverUserRequests(serviceContext.getUserId(), 3, 0, cnt);
			for(SocialRequest socialRequest: request ){
				if(socialRequest.getUserId() == receiverUserId){
					socialRequestId = socialRequest.getRequestId();
					sRequest = SocialRequestLocalServiceUtil.getSocialRequest(socialRequestId);
					sendNotificationEvent(sRequest);
					//SocialRequestLocalServiceUtil.updateRequest(socialRequestId, 1, themeDisplay);
					SocialRequestLocalServiceUtil.deleteRequest(socialRequestId);
				}
			}
			return sRequest;
	}
	
	public JSONArray getRequestingUsers(long companyId, String keywords, ServiceContext serviceContext)
			throws PortalException, SystemException{
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		long userId = getUserId();
		int cnt = entryLocalService.searchUsersAndContactsCount(companyId, userId, keywords);
		List<BaseModel<?>> contacts = entryLocalService.searchUsersAndContacts(
			companyId, userId, keywords, 0, cnt);
		int requestCount = SocialRequestLocalServiceUtil.getReceiverUserRequestsCount(serviceContext.getUserId());
		  List<SocialRequest> requests = SocialRequestLocalServiceUtil.getReceiverUserRequests(serviceContext.getUserId(), SocialRequestConstants.STATUS_PENDING, 0, requestCount);
		for (BaseModel<?> contact : contacts) {
			JSONObject jsonObject = null;
			for(SocialRequest req: requests){
				if(req.getUserId() == ((User) contact).getContact().getUserId()){
					if (contact instanceof User) {
						jsonObject = ContactsUtil.getUserJSONObject(
							userId, (User)contact);
						jsonObject.put("portraitId", ((User) contact).getPortraitId());
					}
					else {
						jsonObject = ContactsUtil.getEntryJSONObject((Entry)contact);
						jsonObject.put("portraitId", ((User) contact).getPortraitId());
					}
					jsonArray.put(jsonObject);
				}
			}
		}
		return jsonArray;
	}
	
	@Override
	public boolean blockUser(long blockUserId, ServiceContext serviceContext){
		  boolean done = false;
		  try {
			  SocialRelation socialRelation = SocialRelationLocalServiceUtil.getRelation(serviceContext.getUserId(), blockUserId, SocialRelationConstants.TYPE_BI_CONNECTION);
			  SocialRelationLocalServiceUtil.deleteRelation(socialRelation);
			  SocialRelationLocalServiceUtil.addRelation(serviceContext.getUserId(), blockUserId, SocialRelationConstants.TYPE_UNI_ENEMY);
			  done = true;
		  } catch (Exception e) {
			  LOGGER.error("Exception in blockUser: "+e.getMessage());
		  }
		  return done;
	}
	
	@Override
	public boolean unblockUser(long unblockUserId, ServiceContext serviceContext){
		 boolean done = false;
		 try {
			 SocialRelation socialRelation = SocialRelationLocalServiceUtil.getRelation(serviceContext.getUserId(), unblockUserId, SocialRelationConstants.TYPE_UNI_ENEMY);
			 SocialRelationLocalServiceUtil.deleteRelation(socialRelation);
		 } catch (Exception e) {
			 LOGGER.error("Exception in blockUser: "+e.getMessage());
		 }
		 return done;
	}
	
	public int getUsersAndContactsCount(long companyId, String keywords, ServiceContext serviceContext)throws PortalException, SystemException {
		return entryLocalService.searchUsersAndContactsCount(companyId, serviceContext.getUserId(), keywords);
	}
	
	public JSONArray searchMyFriends(long companyId, String keywords, ServiceContext serviceContext){
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		try {
			long userId = getUserId();
		  int cnt = SocialRelationLocalServiceUtil.getRelationsCount(userId, SocialRelationConstants.TYPE_BI_CONNECTION);
		  List<SocialRelation> relation = SocialRelationLocalServiceUtil.getRelations(userId, SocialRelationConstants.TYPE_BI_CONNECTION, 0, cnt);
		  for(SocialRelation relObj: relation){
			  List<FlaskRecipients> flaskRecipients = new ArrayList<FlaskRecipients>();
			  String lastMsgTime ="";
			  int unread = 0;
			  JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			  if(!keywords.equals("")){
				  int cnt1 = entryLocalService.searchUsersAndContactsCount(companyId, userId, keywords);
				  List<BaseModel<?>> contacts = entryLocalService.searchUsersAndContacts(companyId, userId, keywords, 0, cnt1);
				  for (BaseModel<?> contact : contacts) {
					  flaskRecipients = FlaskRecipientsUtil.findByUserIdSenderId(serviceContext.getUserId(), ((User) contact).getUserId());
					  int msgCount = flaskRecipients.size();
					  if(msgCount>0){
						  lastMsgTime = String.valueOf(flaskRecipients.get(0).getReceivedDateTime());
						  for(FlaskRecipients recp: flaskRecipients){
							  List<String> deletedBy = new ArrayList<String>();
							  if(!recp.getDeletedBy().equals("")){
								  deletedBy = Arrays.asList(recp.getDeletedBy().split(","));
								  if(!deletedBy.contains(String.valueOf(serviceContext.getUserId())) && !recp.getRead()){
									  unread++;
								  }
							  }
						  }
					  }
					  if(relObj.getUserId2() == ((User) contact).getContact().getUserId()){
						  if (contact instanceof User) {
							  jsonObject = ContactsUtil.getUserJSONObject(userId, (User)contact);
							  jsonObject.put("portraitId", ((User) contact).getPortraitId());
						  }
						  else {
							  jsonObject = ContactsUtil.getEntryJSONObject((Entry)contact);
							  jsonObject.put("portraitId", ((User) contact).getPortraitId());
						  }
						  if(lastMsgTime.equals("")){
							  jsonObject.put("lastMessageDateTime", "0000-00-00 00:00:00:0");
						  }else{
							  jsonObject.put("lastMessageDateTime", lastMsgTime);
						  }
						  if(jsonObject.getLong("portraitId")>0){
							  FileEntry fileEntry = getMyFileEntry(jsonObject.getLong("portraitId"), companyId, serviceContext);
							  if(fileEntry != null){
								  jsonObject.put("portraitUuid", fileEntry.getUuid());
								  jsonObject.put("portraitGroupId", fileEntry.getGroupId());
							  }else{
								  jsonObject.put("portraitUuid", "");
								  jsonObject.put("portraitGroupId", 0);
							  }
							    
						  }else{
							  jsonObject.put("portraitUuid", "");
							  jsonObject.put("portraitGroupId", 0);  
						  }
						  jsonObject.put("unreadMessageCount", unread);
						  jsonArray.put(jsonObject);
					  }
				  }
			  }else{
					if(relObj.getUserId1()==userId){
						User user2 = UserLocalServiceUtil.getUserById(relObj.getUserId2());
						DynamicQuery recipientQuery = DynamicQueryFactoryUtil.forClass(FlaskRecipientsImpl.class);
						Criterion criterion1 = RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("userId", relObj.getUserId2()), RestrictionsFactoryUtil.eq("senderId", serviceContext.getUserId()));
						Criterion criterion2 = RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("senderId", relObj.getUserId2()), RestrictionsFactoryUtil.eq("userId", serviceContext.getUserId()));
						Criterion criterion = RestrictionsFactoryUtil.or(criterion1, criterion2);
						recipientQuery.add(criterion);
						recipientQuery.addOrder(OrderFactoryUtil.desc("receivedDateTime"));
						recipientQuery.setLimit(0, 100);
						flaskRecipients = FlaskRecipientsUtil.findWithDynamicQuery(recipientQuery);
						int msgCount = flaskRecipients.size();
						if(msgCount>0){
							lastMsgTime = String.valueOf(flaskRecipients.get(0).getReceivedDateTime());
							for(FlaskRecipients recp: flaskRecipients){
								List<String> deletedBy = new ArrayList<String>();
								if(!recp.getDeletedBy().equals("")){
									deletedBy = Arrays.asList(recp.getDeletedBy().split(","));
									if(!deletedBy.contains(String.valueOf(serviceContext.getUserId()))){
										if(!recp.getRead() && recp.getUserId()==serviceContext.getUserId())
											unread++;
									}
								}else{
									if(!recp.getRead() && recp.getUserId()==serviceContext.getUserId())
										unread++;
								}
							}
						}
						jsonObject = ContactsUtil.getUserJSONObject(userId, user2);
						jsonObject.put("portraitId", getUserById(relObj.getUserId2(), serviceContext).getPortraitId());
						if(lastMsgTime.equals("")){
							  jsonObject.put("lastMessageDateTime", "0000-00-00 00:00:00:0");
						  }else{
							  jsonObject.put("lastMessageDateTime", lastMsgTime);
						  }
						  if(jsonObject.getLong("portraitId")>0){
							  FileEntry fileEntry = getMyFileEntry(jsonObject.getLong("portraitId"), companyId, serviceContext);
							  if(fileEntry != null){
								  jsonObject.put("portraitUuid", fileEntry.getUuid());
								  jsonObject.put("portraitGroupId", fileEntry.getGroupId());
							  }else{
								  jsonObject.put("portraitUuid", "");
								  jsonObject.put("portraitGroupId", 0);
							  }
							    
						  }else{
							  jsonObject.put("portraitUuid", "");
							  jsonObject.put("portraitGroupId", 0);  
						  }
						  jsonObject.put("unreadMessageCount", unread);
						  jsonArray.put(jsonObject);
					}
			  }
		  }
		} catch (Exception e) {
			LOGGER.error("Exception in searchMyFriends: "+e.getMessage());
		}
		return jsonArray;
	}
	
	@AccessControlled(guestAccessEnabled =true)
	public FileEntry getMyFileEntry(long portraitId, long companyId, ServiceContext serviceContext)throws PortalException, SystemException{
		FileEntry fileEntry=null;	
		try{	
				fileEntry = DLAppLocalServiceUtil.getFileEntry(portraitId);
				ContactsUtil.setAllRoleViewPermission(fileEntry, serviceContext);
				
			}catch(Exception ex){
				
			}
		return fileEntry;
	}
	
	@Override
	public  User getUserById(long userId, ServiceContext serviceContext)
	{
		User user=null;
		try{
			user = UserLocalServiceUtil.getUser(userId);
		}catch(PortalException  ex){
			ex.printStackTrace();
		}catch(SystemException ex){
			ex.printStackTrace();
		}
		return user;
	}
	
	public void addSocialRelation(long receiverUserId, ServiceContext serviceContext)
		throws Exception {
			int cnt = SocialRequestLocalServiceUtil.getReceiverUserRequestsCount(serviceContext.getUserId());
			List<SocialRequest> request = SocialRequestLocalServiceUtil.getReceiverUserRequests(serviceContext.getUserId(), 3, 0, cnt);
			for(SocialRequest socialRequest: request ){
				SocialRequest sRequest;
				if(socialRequest.getUserId() == receiverUserId){
					socialRequestId = socialRequest.getRequestId();
					sRequest = SocialRequestLocalServiceUtil.getSocialRequest(socialRequestId);
					sendNotificationEvent(sRequest);
					//SocialRequestLocalServiceUtil.updateRequest(socialRequestId, 1, themeDisplay);
					SocialRequestLocalServiceUtil.deleteRequest(socialRequestId);
				}
			}
			SocialRelationLocalServiceUtil.addRelation(serviceContext.getUserId(), receiverUserId, SocialRelationConstants.TYPE_BI_CONNECTION);
	}

	public void requestSocialRelation(long receiverUserId, ServiceContext serviceContext)throws Exception {
			SocialRequest socialRequest = SocialRequestLocalServiceUtil.addRequest(serviceContext.getUserId(), 0, User.class.getName(),serviceContext.getUserId(),
					SocialRelationConstants.TYPE_BI_CONNECTION, "", receiverUserId);
			sendNotificationEvent(socialRequest);
			String senderName = UserLocalServiceUtil.getUser(serviceContext.getUserId()).getFullName();
			FlaskMessagesServiceUtil.sendPush(receiverUserId, "Flask Friend Request", "You have a friend request from "+senderName, "Friend_Request", socialRequest.getModelAttributes(), serviceContext.getUserId());
	}
	
	public int getRequestsCount(ServiceContext serviceContext)throws PortalException, SystemException{
		return SocialRequestLocalServiceUtil.getReceiverUserRequestsCount(serviceContext.getUserId(), 3);
	}
	
	protected void sendNotificationEvent(SocialRequest socialRequest)
			throws Exception {

			if (UserNotificationManagerUtil.isDeliver(
					socialRequest.getReceiverUserId(), PortletKeys.CONTACTS_CENTER,
					0, SocialRelationConstants.SOCIAL_RELATION_REQUEST,
					UserNotificationDeliveryConstants.TYPE_WEBSITE)) {

				JSONObject notificationEventJSONObject =
					JSONFactoryUtil.createJSONObject();

				notificationEventJSONObject.put("actionRequired", true);
				notificationEventJSONObject.put(
					"classPK", socialRequest.getRequestId());
				notificationEventJSONObject.put(
					"userId", socialRequest.getUserId());

				NotificationEvent notificationEvent =
					NotificationEventFactoryUtil.createNotificationEvent(
						System.currentTimeMillis(), PortletKeys.CONTACTS_CENTER,
						notificationEventJSONObject);

				notificationEvent.setDeliveryRequired(0);

				UserNotificationEventLocalServiceUtil.addUserNotificationEvent(
					socialRequest.getReceiverUserId(), notificationEvent);
			}
		}
	public void deleteSocialRelation(long receiverUserId, ServiceContext serviceContext)
		throws Exception {

		int type = SocialRelationConstants.TYPE_BI_CONNECTION;
			try {
				SocialRelationLocalServiceUtil.deleteRelation(
					serviceContext.getUserId(), receiverUserId, type);
			}
			catch (NoSuchRelationException nsre) {
			}
	}

	protected long[] getUserIds(HttpServletRequest request) {
		long[] userIds;

		long userId = ParamUtil.getLong(request, "userId", 0);

		if (userId > 0) {
			userIds = new long[] {userId};
		}
		else {
			userIds = StringUtil.split(
				ParamUtil.getString(request, "userIds"), 0L);
		}

		return userIds;
	}
	
	@Override
	public Map<Date, JSONObject> getAllMyMessages(ServiceContext serviceContext){
		Map<Date, JSONObject> treeMap = new TreeMap<Date, JSONObject>(new Comparator<Date>() {
                    @Override
                    public int compare(Date o1, Date o2) {
                        return o2.compareTo(o1);
                    }
                });
		try {
			long userId = getUserId();
			int cnt = SocialRelationLocalServiceUtil.getRelationsCount(userId, SocialRelationConstants.TYPE_BI_CONNECTION);
			List<SocialRelation> relation = SocialRelationLocalServiceUtil.getRelations(userId, SocialRelationConstants.TYPE_BI_CONNECTION, 0, cnt);
			for(SocialRelation relObj: relation){
				if(relObj.getUserId1()==userId){
					User user2 = UserLocalServiceUtil.getUserById(relObj.getUserId2());
					DynamicQuery recipientQuery = DynamicQueryFactoryUtil.forClass(FlaskRecipientsImpl.class);
					Criterion criterion1 = RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("userId", relObj.getUserId2()), RestrictionsFactoryUtil.eq("senderId", serviceContext.getUserId()));
					Criterion criterion2 = RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("senderId", relObj.getUserId2()), RestrictionsFactoryUtil.eq("userId", serviceContext.getUserId()));
					Criterion criterion = RestrictionsFactoryUtil.or(criterion1, criterion2);
					recipientQuery.add(criterion);
					recipientQuery.addOrder(OrderFactoryUtil.desc("receivedDateTime"));
					recipientQuery.setLimit(0, 100);
					List<FlaskRecipients> flaskRecipients = FlaskRecipientsUtil.findWithDynamicQuery(recipientQuery);
					int msgCount = flaskRecipients.size();
					int count = 0;
					int unread = 0;
					if(msgCount>0){
						Date receivedDate = flaskRecipients.get(0).getReceivedDateTime();
						try{
							for(FlaskRecipients recp: flaskRecipients){
								List<String> deletedBy = new ArrayList<String>();
								if(!recp.getDeletedBy().equals("")){
									deletedBy = Arrays.asList(recp.getDeletedBy().split(","));
									if(!deletedBy.contains(String.valueOf(serviceContext.getUserId()))){
										count++;
										if(!recp.getRead() && recp.getUserId()==serviceContext.getUserId())
											unread++;
									}
								}else{
									count++;
									if(!recp.getRead() && recp.getUserId()==serviceContext.getUserId())
										unread++;
								}
							}
						}finally{
							if(count>0){
								JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
								jsonObject.put("name", user2.getFullName());
								jsonObject.put("portraitId", user2.getPortraitId());
								jsonObject.put("uuid", user2.getUuid());
								jsonObject.put("createdBy", "");
								jsonObject.put("isUser", 1);
								jsonObject.put("description", "");
								jsonObject.put("id", user2.getUserId());
								jsonObject.put("lastMessageDateTime", receivedDate);
								jsonObject.put("unreadMessageCount", unread);
								treeMap.put(receivedDate, jsonObject);
							}
						}
					}
				}
			}
			
			List<FlaskGroup> userGroups = FlaskGroupServiceUtil.getGroups(serviceContext.getUserId());
			for(FlaskGroup myGroup: userGroups){
				if(myGroup != null){
					DynamicQuery groupQuery = DynamicQueryFactoryUtil.forClass(FlaskGroupRecipientsImpl.class);
					groupQuery.add(PropertyFactoryUtil.forName("groupId").eq(myGroup.getGroupId()));
					groupQuery.addOrder(OrderFactoryUtil.desc("receivedDateTime"));
					groupQuery.setLimit(0, 100);
					List<FlaskGroupRecipients> flaskGroupRecipients = FlaskGroupRecipientsUtil.findWithDynamicQuery(groupQuery);
					int msgSize = flaskGroupRecipients.size();
					if(msgSize>0){
						int grpMsgCount = 0;
						int count = 0;
						for(FlaskGroupRecipients recp: flaskGroupRecipients){
							JSONObject recpInfo = JSONFactoryUtil.createJSONObject(recp.getMessageStatusInfo());				
							if(recpInfo.has(String.valueOf(serviceContext.getUserId()))){
								JSONObject recpObj = recpInfo.getJSONObject(String.valueOf(serviceContext.getUserId()));
								if(!recpObj.getBoolean("deleted")){
									count++;
									if(!recpObj.getBoolean("read"))
										grpMsgCount++;
								}
							}
						}
						
						if(count>0){
							JSONObject obj= JSONFactoryUtil.createJSONObject();
							obj.put("name", myGroup.getGroupName());
							obj.put("portraitId", 0);
							obj.put("uuid", "");
							obj.put("createdBy", myGroup.getCreatedBy());
							obj.put("isUser", 0);
							obj.put("description", myGroup.getGroupDescription());
							obj.put("id", myGroup.getGroupId());
							
							Date receivedDate = flaskGroupRecipients.get(msgSize-1).getReceivedDateTime();
							obj.put("lastMessageDateTime", receivedDate);
							obj.put("unreadMessageCount", grpMsgCount);
							treeMap.put(receivedDate, obj);
						}
					}
				}
			}
		}catch(Exception e){
			LOGGER.error("Exception in getAllMyMessages: "+e.getMessage());
		}
		return treeMap;
	}
}