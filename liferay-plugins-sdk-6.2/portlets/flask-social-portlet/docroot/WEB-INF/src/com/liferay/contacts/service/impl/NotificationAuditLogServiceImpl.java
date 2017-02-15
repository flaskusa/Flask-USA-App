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

import java.util.Date;
import java.util.List;

import com.liferay.contacts.model.NotificationAuditLog;
import com.liferay.contacts.service.NotificationAuditLogLocalServiceUtil;
import com.liferay.contacts.service.base.NotificationAuditLogServiceBaseImpl;
import com.liferay.contacts.service.persistence.NotificationAuditLogUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the notification audit log remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contacts.service.NotificationAuditLogService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contacts.service.base.NotificationAuditLogServiceBaseImpl
 * @see com.liferay.contacts.service.NotificationAuditLogServiceUtil
 */
public class NotificationAuditLogServiceImpl
	extends NotificationAuditLogServiceBaseImpl {

	private static Log LOGGER = LogFactoryUtil.getLog(NotificationAuditLogServiceImpl.class);
	
	@Override
    public NotificationAuditLog addNotificationAuditLog(String senderEmail, String receiverEmail, String messageReason, String message, Date notificationTime){
    	NotificationAuditLog notificationAuditLog = null;
		try{
			notificationAuditLog = NotificationAuditLogLocalServiceUtil.createNotificationAuditLog(CounterLocalServiceUtil.increment());
			notificationAuditLog.setSenderEmail(senderEmail);
			notificationAuditLog.setReceiverEmail(receiverEmail);
			notificationAuditLog.setMessageReason(messageReason);
			notificationAuditLog.setMessage(message);
			notificationAuditLog.setNotificationTime(notificationTime);
			notificationAuditLog = NotificationAuditLogLocalServiceUtil.addNotificationAuditLog(notificationAuditLog);
		}catch(Exception e){
			LOGGER.error("Exception in Add Notification Audit Log: " + e.getMessage());
		}
		return notificationAuditLog;
	}
    
	@Override
    public List<NotificationAuditLog> getAllNotificationAuditLog(){
    	List<NotificationAuditLog> notificationAuditLog = null;
    	try{
    		notificationAuditLog = NotificationAuditLogUtil.findAll();
    	}catch(Exception e){
    		LOGGER.error("Exception in Get All Notification Audit Log: "+e.getMessage());
    	}
    	return notificationAuditLog;
    }
    
	@Override
    public NotificationAuditLog getNotificationAuditLog(long notificationAuditLogId){
    	NotificationAuditLog notificationAuditLog = null;
    	try{
    		notificationAuditLog = NotificationAuditLogLocalServiceUtil.getNotificationAuditLog(notificationAuditLogId);
    	}catch(Exception e){
    		LOGGER.error("Exception in get Notification Audit Log: "+e.getMessage());
    	}
    	return notificationAuditLog;
    }
    
	@Override
    public List<NotificationAuditLog> getAllNotificationAuditLogBySenderEmail(String senderEmail){
    	List<NotificationAuditLog> notificationAuditLog = null;
    	try{
    		notificationAuditLog = NotificationAuditLogUtil.findBynotificationBySenderEmail(senderEmail);
    	}catch(Exception e){
    		LOGGER.error("Exception in Get All Notification Audit Log By senderEmail: "+e.getMessage());
    	}
    	return notificationAuditLog;
    }
    
	@Override
    public List<NotificationAuditLog> getAllNotificationAuditLogByReceiverEmail(String receiverEmail){
    	List<NotificationAuditLog> notificationAuditLog = null;
    	try{
    		notificationAuditLog = NotificationAuditLogUtil.findBynotificationReceiverEmail(receiverEmail);
    	}catch(Exception e){
    		LOGGER.error("Exception in Get All Notification Audit Log By receiverEmail: "+e.getMessage());
    	}
    	return notificationAuditLog;
    }
    
	@Override
    public NotificationAuditLog updateNotificationAuditLog(long notificationAuditLogId, String senderEmail, String receiverEmail, String messageReason, String message, Date notificationTime){
    	NotificationAuditLog notificationAuditLog = null;
		try{
			notificationAuditLog = NotificationAuditLogLocalServiceUtil.getNotificationAuditLog(notificationAuditLogId);
			notificationAuditLog.setSenderEmail(senderEmail);
			notificationAuditLog.setReceiverEmail(receiverEmail);
			notificationAuditLog.setMessageReason(messageReason);
			notificationAuditLog.setMessage(message);
			notificationAuditLog.setNotificationTime(notificationTime);
			
			notificationAuditLog = NotificationAuditLogLocalServiceUtil.updateNotificationAuditLog(notificationAuditLog);
		}catch(Exception e){
			LOGGER.error("Exception in Update Notification Audit Log: " + e.getMessage());
		}
		return notificationAuditLog;
	}
    
	@Override
    public void deleteNotificationAuditLog(long notificationAuditLogId){
    	try {
			NotificationAuditLogLocalServiceUtil.deleteNotificationAuditLog(notificationAuditLogId);
		}  catch (Exception e) {
			LOGGER.error("Exception in Delete Notification Audit Log: " + e.getMessage());
		}
    }
}