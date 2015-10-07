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
import com.liferay.contacts.service.FlaskMessagesLocalServiceUtil;
import com.liferay.contacts.service.FlaskRecipientsServiceUtil;
import com.liferay.contacts.service.base.FlaskMessagesServiceBaseImpl;
import com.liferay.contacts.service.persistence.FlaskRecipientsUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.rumbasolutions.flask.email.util.EmailInvitationUtil;

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
			   FlaskRecipients recp = FlaskRecipientsServiceUtil.addFlaskRecipient(Long.parseLong(userId), flaskMessage.getMessageId(), false);
			   if(sendEmail)
			        EmailInvitationUtil.emailMessage(user.getFullName(), user.getEmailAddress(), recp.getEmail(), message, serviceContext);
		   }
	   }
	  } catch (Exception e) {
	   // TODO: handle exception
	   e.printStackTrace();
	  }
	  return flaskMessage;
	}
	
	@Override
	public JSONArray getAllMyFlaskMessages(ServiceContext serviceContext){
		List<FlaskMessages> flaskMessages = new ArrayList<FlaskMessages>();
		List<FlaskRecipients> flaskRecipients = null;
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		try {
			flaskRecipients = FlaskRecipientsUtil.findByUserId(serviceContext.getUserId());
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
				//flaskMessages.add(FlaskMessagesLocalServiceUtil.getFlaskMessages(recp.getMessageId()));
				jsonArray.put(jsonObj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return jsonArray;
	}
	
	@Override
	public List<FlaskMessages> getMyUnreadFlaskMessages(ServiceContext serviceContext){
		List<FlaskMessages> flaskMessages = new ArrayList<FlaskMessages>();
		List<FlaskRecipients> flaskRecipients = new ArrayList<FlaskRecipients>();
		try {
			flaskRecipients = FlaskRecipientsUtil.findByreadFlag(serviceContext.getUserId(), false);
			for(FlaskRecipients recp: flaskRecipients){
				flaskMessages.add(FlaskMessagesLocalServiceUtil.getFlaskMessages(recp.getMessageId()));
				//flaskMessages.get(0).getSenderUserId();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flaskMessages;
	}
	
}