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

import com.liferay.contacts.model.FlaskGroupRecipients;
import com.liferay.contacts.model.impl.FlaskGroupRecipientsImpl;
import com.liferay.contacts.service.FlaskGroupRecipientsLocalServiceUtil;
import com.liferay.contacts.service.FlaskMessagesServiceUtil;
import com.liferay.contacts.service.FlaskRecipientsLocalServiceUtil;
import com.liferay.contacts.service.base.FlaskGroupRecipientsServiceBaseImpl;
import com.liferay.contacts.service.persistence.FlaskGroupRecipientsUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.email.util.EmailInvitationUtil;
import com.rumbasolutions.flask.model.FlaskGroup;
import com.rumbasolutions.flask.model.FlaskGroupUsers;
import com.rumbasolutions.flask.service.FlaskGroupServiceUtil;
import com.rumbasolutions.flask.service.FlaskGroupUsersServiceUtil;

/**
 * The implementation of the flask group recipients remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contacts.service.FlaskGroupRecipientsService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contacts.service.base.FlaskGroupRecipientsServiceBaseImpl
 * @see com.liferay.contacts.service.FlaskGroupRecipientsServiceUtil
 */
public class FlaskGroupRecipientsServiceImpl
	extends FlaskGroupRecipientsServiceBaseImpl {
	
	private static Log LOGGER = LogFactoryUtil
			.getLog(FlaskGroupRecipientsServiceImpl.class);
	
	@Override
	public FlaskGroupRecipients addFlaskGroupRecipients(long groupId, String senderEmailId, long groupMessageId, String message, Boolean sendEmail, ServiceContext serviceContext){
		FlaskGroupRecipients flaskGroupRecipients = null;
		try {
			flaskGroupRecipients = FlaskGroupRecipientsLocalServiceUtil.createFlaskGroupRecipients(CounterLocalServiceUtil.increment());
			List<FlaskGroupUsers> groupUsers= FlaskGroupUsersServiceUtil.getAllGroupUsers(groupId);
			FlaskGroup group = FlaskGroupServiceUtil.getGroup(groupId);
			String recipients ="";
			String read ="";
			   for (FlaskGroupUsers groupUser : groupUsers){
				   if((recipients == null || recipients == "") && (read == null || read == "")){
					   recipients = String.valueOf(groupUser.getUserId());
					   read = "0";
				   }else{
					   recipients = recipients+ "," +groupUser.getUserId();
					   read = read+ "," + "0";
				   }
				   if(groupUser.getUserId() != serviceContext.getUserId())
					   FlaskMessagesServiceUtil.sendPush(groupUser.getUserId(), "Flask Group Message", " You have a message from Group "+group.getGroupName(), "Group_Message", group.getModelAttributes(),
							   group.getGroupId());
				   try {
					   EmailInvitationUtil.emailMessage(groupUser.getUserName(), senderEmailId, groupUser.getEmailAddress(), message, serviceContext);
					} catch (Exception e) {
					}
			   }
			flaskGroupRecipients.setRecipients(recipients);
			flaskGroupRecipients.setRead(read);
			flaskGroupRecipients.setGroupId(groupId);
			flaskGroupRecipients.setGroupMessageId(groupMessageId);
			flaskGroupRecipients.setRead(read);
			flaskGroupRecipients.setSenderId(serviceContext.getUserId());
			Date date = new Date();
			flaskGroupRecipients.setReceivedDateTime(serviceContext.getCreateDate(date));
			flaskGroupRecipients = FlaskGroupRecipientsLocalServiceUtil.addFlaskGroupRecipients(flaskGroupRecipients);
			setGroupMessageRead(groupMessageId, serviceContext);
		} catch (Exception e) {
			LOGGER.error("Exception in addFlaskGroupRecipients:"+e.getMessage());
		}
		return flaskGroupRecipients;
	}
	
	@Override
	 public boolean setGroupMessageRead(long groupMessageId, ServiceContext serviceContext){
	  boolean ret = false;
	  try {
		   List<FlaskGroupRecipients> flaskGroupRecipients = FlaskGroupRecipientsUtil.findByMessageId(groupMessageId);
		   for(FlaskGroupRecipients recp: flaskGroupRecipients){
			    String recipient = recp.getRecipients();
			    String read = recp.getRead();
				String[] recpPart = recipient.split(",");
				String[] readPart = read.split(","); 
				String updateRead ="";
				for(int i = 0; i <= recpPart.length-1; i++){
					if((serviceContext.getUserId() == Long.parseLong(recpPart[i])) && (Long.parseLong(readPart[i]) == 0)){
						readPart[i] = "1"; 
						ret = true;
					}
					if(updateRead == null || updateRead == ""){
						updateRead = readPart[i];
					}else{
						updateRead = updateRead+ "," + readPart[i];
					}
				}
				if(ret){
					recp.setRead(updateRead);
					FlaskGroupRecipientsLocalServiceUtil.updateFlaskGroupRecipients(recp);
				}
		   }
	  } catch (Exception e) {
		  LOGGER.error("Exception in setGroupMessageRead:"+e.getMessage());
	  }
	  return ret;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FlaskGroupRecipients> getGroupRecipientsByGroupId(long groupId){
		List<FlaskGroupRecipients> flaskGroupRecipients = new ArrayList<FlaskGroupRecipients>();
		try {
			DynamicQuery groupQuery = DynamicQueryFactoryUtil.forClass(FlaskGroupRecipientsImpl.class);
			groupQuery.add(PropertyFactoryUtil.forName("groupId").eq(new Long(groupId)));
			flaskGroupRecipients = FlaskRecipientsLocalServiceUtil.dynamicQuery(groupQuery);
		} catch (Exception e) {
			LOGGER.error("Exception in getGroupRecipientsByGroupId:"+e.getMessage());
		}
		return flaskGroupRecipients;
	}
}