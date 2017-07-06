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

import com.liferay.contacts.model.FlaskGroupMessages;
import com.liferay.contacts.model.FlaskGroupRecipients;
import com.liferay.contacts.model.impl.FlaskGroupRecipientsImpl;
import com.liferay.contacts.service.FlaskGroupMessagesLocalServiceUtil;
import com.liferay.contacts.service.FlaskGroupRecipientsLocalServiceUtil;
import com.liferay.contacts.service.FlaskGroupRecipientsServiceUtil;
import com.liferay.contacts.service.FlaskRecipientsLocalServiceUtil;
import com.liferay.contacts.service.base.FlaskGroupMessagesServiceBaseImpl;
import com.liferay.contacts.service.persistence.FlaskGroupMessagesUtil;
import com.liferay.contacts.service.persistence.FlaskGroupRecipientsUtil;
import com.liferay.contacts.service.persistence.FlaskRecipientsUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the flask group messages remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contacts.service.FlaskGroupMessagesService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contacts.service.base.FlaskGroupMessagesServiceBaseImpl
 * @see com.liferay.contacts.service.FlaskGroupMessagesServiceUtil
 */
public class FlaskGroupMessagesServiceImpl
	extends FlaskGroupMessagesServiceBaseImpl {
	
	@Override
	 public FlaskGroupMessages sendFlaskGroupMessage(long groupId, String message, boolean sendEmail, ServiceContext serviceContext){
	  FlaskGroupMessages flaskGroupMessage = null;
	  try {
		   User user = UserLocalServiceUtil.getUserById(serviceContext.getUserId());
		   flaskGroupMessage = FlaskGroupMessagesLocalServiceUtil.createFlaskGroupMessages(CounterLocalServiceUtil.increment());
		   flaskGroupMessage.setSenderEmail(user.getEmailAddress());
		   flaskGroupMessage.setSenderName(user.getFullName());
		   flaskGroupMessage.setGroupId(groupId);
		   flaskGroupMessage.setSenderUserId(user.getUserId());
		   flaskGroupMessage.setMessage(message);
		   flaskGroupMessage.setSendEmail(sendEmail);
		   Date date = new Date();
		   flaskGroupMessage.setDateTime(serviceContext.getCreateDate(date));
		   flaskGroupMessage = FlaskGroupMessagesLocalServiceUtil.addFlaskGroupMessages(flaskGroupMessage);
		   FlaskGroupRecipientsServiceUtil.addFlaskGroupRecipients(groupId, user.getEmailAddress(), flaskGroupMessage.getGroupMessagesId(), flaskGroupMessage.getMessage(), flaskGroupMessage.getSendEmail(), serviceContext);
	   } catch (Exception e) {
	   e.printStackTrace();
	  }
	  return flaskGroupMessage;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public JSONArray getAllMyFlaskGroupMessages(long groupId, ServiceContext serviceContext){
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		try {
			DynamicQuery groupQuery = DynamicQueryFactoryUtil.forClass(FlaskGroupRecipientsImpl.class);
			groupQuery.add(PropertyFactoryUtil.forName("groupId").eq(new Long(groupId)));
			groupQuery.addOrder(OrderFactoryUtil.desc("receivedDateTime"));
			groupQuery.setLimit(0, 100);
			List<FlaskGroupRecipients> flaskGroupRecipients = FlaskRecipientsLocalServiceUtil.dynamicQuery(groupQuery);
			for(FlaskGroupRecipients recp: flaskGroupRecipients){
				JSONObject recpInfo = JSONFactoryUtil.createJSONObject(recp.getMessageStatusInfo());				
				if(recpInfo.has(String.valueOf(serviceContext.getUserId()))){
					if(!recpInfo.getJSONObject(String.valueOf(serviceContext.getUserId())).getBoolean("deleted")){
						JSONObject jsonObj =  JSONFactoryUtil.createJSONObject();
						FlaskGroupMessages msg = FlaskGroupMessagesLocalServiceUtil.getFlaskGroupMessages(recp.getGroupMessageId());
						jsonObj.put("dateTime", msg.getDateTime());
						jsonObj.put("message", msg.getMessage());
						jsonObj.put("messageId", msg.getGroupMessagesId());
						jsonObj.put("recipients", recp.getRecipients());
						jsonObj.put("read", recp.getRead());
						jsonObj.put("sendEmail", msg.getSendEmail());
						jsonObj.put("senderEmail", msg.getSenderEmail());
						jsonObj.put("senderName", msg.getSenderName());
						jsonObj.put("senderUserId", msg.getSenderUserId());
						jsonObj.put("portraitId", UserLocalServiceUtil.getUserById(msg.getSenderUserId()).getPortraitId());
						jsonArray.put(jsonObj);
					}
				}					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonArray;
	}
	
	@Override
	public List<FlaskGroupMessages> getGroupMessages(long groupId){
		List<FlaskGroupMessages> flaskGroupMessages = new ArrayList<FlaskGroupMessages>();
		try {
			flaskGroupMessages = FlaskGroupMessagesUtil.findBygroupId(groupId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flaskGroupMessages;
	}
	
	@Override
	public int getMyFlaskGroupMessagesCount(long groupId, ServiceContext serviceContext){
		int count = 0;
		try {
			List<FlaskGroupRecipients> flaskGroupRecipients = FlaskGroupRecipientsUtil.findByGroupId(groupId);
			for(FlaskGroupRecipients recp: flaskGroupRecipients){
				JSONObject recpInfo = JSONFactoryUtil.createJSONObject(recp.getMessageStatusInfo());				
				if(recpInfo.has(String.valueOf(serviceContext.getUserId()))){
					if(!recpInfo.getJSONObject(String.valueOf(serviceContext.getUserId())).getBoolean("deleted")){
						count++;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public int getMyUnreadFlaskGroupMessagesCount(long groupId, ServiceContext serviceContext){
		int count = 0;
		try {
			List<FlaskGroupRecipients> flaskGroupRecipients = FlaskGroupRecipientsUtil.findByGroupId(groupId);
			for(FlaskGroupRecipients recp: flaskGroupRecipients){
				JSONObject recpInfo = JSONFactoryUtil.createJSONObject(recp.getMessageStatusInfo());				
				if(recpInfo.has(String.valueOf(serviceContext.getUserId()))){
					JSONObject recpObj = recpInfo.getJSONObject(String.valueOf(serviceContext.getUserId()));
					if(!recpObj.getBoolean("deleted") && !recpObj.getBoolean("read")){
						count++;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteMyGroupChatMessages(List<Long> groupMessageIds, ServiceContext serviceContext){
		boolean done = false;
		try {
			DynamicQuery recipientQuery = DynamicQueryFactoryUtil.forClass(FlaskGroupRecipientsImpl.class);
			Criterion criterion = RestrictionsFactoryUtil.in("groupMessageId", groupMessageIds);
			recipientQuery.add(criterion);
			recipientQuery.addOrder(OrderFactoryUtil.desc("receivedDateTime"));
			List<FlaskGroupRecipients> flaskGroupRecipients = FlaskGroupMessagesLocalServiceUtil.dynamicQuery(recipientQuery);
			for(FlaskGroupRecipients recp: flaskGroupRecipients){
				JSONObject recpInfo = JSONFactoryUtil.createJSONObject(recp.getMessageStatusInfo());				
				if(recpInfo.has(String.valueOf(serviceContext.getUserId()))){
					JSONObject recpObj = recpInfo.getJSONObject(String.valueOf(serviceContext.getUserId()));
					JSONObject newObj = JSONFactoryUtil.createJSONObject();
					newObj.put("deleted", true);
					newObj.put("read", recpObj.getBoolean("read"));
					recpInfo.remove(String.valueOf(serviceContext.getUserId()));
					recpInfo.put(String.valueOf(serviceContext.getUserId()), newObj);
					recp.setMessageStatusInfo(recpInfo.toString());
					FlaskGroupRecipientsLocalServiceUtil.updateFlaskGroupRecipients(recp);
				}
			}
			done = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return done;
	}
	
	@Override
	public void deleteGroupMessage(long groupMessageId, ServiceContext serviceContext){
		try {
			List<FlaskGroupRecipients> recipients =  FlaskGroupRecipientsUtil.findByMessageId(groupMessageId);
			FlaskGroupRecipientsLocalServiceUtil.deleteFlaskGroupRecipients(recipients.get(0));
			int recCount = FlaskRecipientsUtil.countBymessageId(groupMessageId);
			if(recCount <= 0){
				FlaskGroupMessages msg = FlaskGroupMessagesLocalServiceUtil.getFlaskGroupMessages(groupMessageId);
				FlaskGroupMessagesLocalServiceUtil.deleteFlaskGroupMessages(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void deleteGroupMessagesByDateRange(Date startDate, Date endDate, ServiceContext serviceContext){
		try {
			List<FlaskGroupMessages> messages =  FlaskGroupMessagesLocalServiceUtil.getFlaskGroupMessageses(0, FlaskGroupMessagesLocalServiceUtil.getFlaskGroupMessagesesCount());
			for(FlaskGroupMessages msg: messages){
				Date msgDate = new Date(msg.getDateTime().getDate());
				Date stDate = new Date(startDate.getDate());
				Date enDate = new Date(endDate.getDate());
				if(stDate.compareTo(msgDate) <= 0 && enDate.compareTo(msgDate) >= 0){
					List<FlaskGroupRecipients> recipients = new ArrayList<FlaskGroupRecipients>();
					recipients =  FlaskGroupRecipientsUtil.findByMessageId(msg.getGroupMessagesId());
					FlaskGroupRecipientsLocalServiceUtil.deleteFlaskGroupRecipients(recipients.get(0));
					FlaskGroupMessagesLocalServiceUtil.deleteFlaskGroupMessages(msg);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}