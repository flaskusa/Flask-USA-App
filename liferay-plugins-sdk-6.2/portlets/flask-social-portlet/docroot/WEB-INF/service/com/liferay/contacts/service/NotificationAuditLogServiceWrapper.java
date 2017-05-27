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

package com.liferay.contacts.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NotificationAuditLogService}.
 *
 * @author Brian Wing Shun Chan
 * @see NotificationAuditLogService
 * @generated
 */
public class NotificationAuditLogServiceWrapper
	implements NotificationAuditLogService,
		ServiceWrapper<NotificationAuditLogService> {
	public NotificationAuditLogServiceWrapper(
		NotificationAuditLogService notificationAuditLogService) {
		_notificationAuditLogService = notificationAuditLogService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _notificationAuditLogService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_notificationAuditLogService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _notificationAuditLogService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.contacts.model.NotificationAuditLog addNotificationAuditLog(
		java.lang.String senderEmail, java.lang.String receiverEmail,
		java.lang.String messageReason, java.lang.String message,
		java.util.Date notificationTime) {
		return _notificationAuditLogService.addNotificationAuditLog(senderEmail,
			receiverEmail, messageReason, message, notificationTime);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> getAllNotificationAuditLog() {
		return _notificationAuditLogService.getAllNotificationAuditLog();
	}

	@Override
	public com.liferay.contacts.model.NotificationAuditLog getNotificationAuditLog(
		long notificationAuditLogId) {
		return _notificationAuditLogService.getNotificationAuditLog(notificationAuditLogId);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> getAllNotificationAuditLogBySenderEmail(
		java.lang.String senderEmail) {
		return _notificationAuditLogService.getAllNotificationAuditLogBySenderEmail(senderEmail);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> getAllNotificationAuditLogByReceiverEmail(
		java.lang.String receiverEmail) {
		return _notificationAuditLogService.getAllNotificationAuditLogByReceiverEmail(receiverEmail);
	}

	@Override
	public com.liferay.contacts.model.NotificationAuditLog updateNotificationAuditLog(
		long notificationAuditLogId, java.lang.String senderEmail,
		java.lang.String receiverEmail, java.lang.String messageReason,
		java.lang.String message, java.util.Date notificationTime) {
		return _notificationAuditLogService.updateNotificationAuditLog(notificationAuditLogId,
			senderEmail, receiverEmail, messageReason, message, notificationTime);
	}

	@Override
	public void deleteNotificationAuditLog(long notificationAuditLogId) {
		_notificationAuditLogService.deleteNotificationAuditLog(notificationAuditLogId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public NotificationAuditLogService getWrappedNotificationAuditLogService() {
		return _notificationAuditLogService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedNotificationAuditLogService(
		NotificationAuditLogService notificationAuditLogService) {
		_notificationAuditLogService = notificationAuditLogService;
	}

	@Override
	public NotificationAuditLogService getWrappedService() {
		return _notificationAuditLogService;
	}

	@Override
	public void setWrappedService(
		NotificationAuditLogService notificationAuditLogService) {
		_notificationAuditLogService = notificationAuditLogService;
	}

	private NotificationAuditLogService _notificationAuditLogService;
}