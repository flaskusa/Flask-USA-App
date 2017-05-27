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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for NotificationAuditLog. This utility wraps
 * {@link com.liferay.contacts.service.impl.NotificationAuditLogServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see NotificationAuditLogService
 * @see com.liferay.contacts.service.base.NotificationAuditLogServiceBaseImpl
 * @see com.liferay.contacts.service.impl.NotificationAuditLogServiceImpl
 * @generated
 */
public class NotificationAuditLogServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.contacts.service.impl.NotificationAuditLogServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.contacts.model.NotificationAuditLog addNotificationAuditLog(
		java.lang.String senderEmail, java.lang.String receiverEmail,
		java.lang.String messageReason, java.lang.String message,
		java.util.Date notificationTime) {
		return getService()
				   .addNotificationAuditLog(senderEmail, receiverEmail,
			messageReason, message, notificationTime);
	}

	public static java.util.List<com.liferay.contacts.model.NotificationAuditLog> getAllNotificationAuditLog() {
		return getService().getAllNotificationAuditLog();
	}

	public static com.liferay.contacts.model.NotificationAuditLog getNotificationAuditLog(
		long notificationAuditLogId) {
		return getService().getNotificationAuditLog(notificationAuditLogId);
	}

	public static java.util.List<com.liferay.contacts.model.NotificationAuditLog> getAllNotificationAuditLogBySenderEmail(
		java.lang.String senderEmail) {
		return getService().getAllNotificationAuditLogBySenderEmail(senderEmail);
	}

	public static java.util.List<com.liferay.contacts.model.NotificationAuditLog> getAllNotificationAuditLogByReceiverEmail(
		java.lang.String receiverEmail) {
		return getService()
				   .getAllNotificationAuditLogByReceiverEmail(receiverEmail);
	}

	public static com.liferay.contacts.model.NotificationAuditLog updateNotificationAuditLog(
		long notificationAuditLogId, java.lang.String senderEmail,
		java.lang.String receiverEmail, java.lang.String messageReason,
		java.lang.String message, java.util.Date notificationTime) {
		return getService()
				   .updateNotificationAuditLog(notificationAuditLogId,
			senderEmail, receiverEmail, messageReason, message, notificationTime);
	}

	public static void deleteNotificationAuditLog(long notificationAuditLogId) {
		getService().deleteNotificationAuditLog(notificationAuditLogId);
	}

	public static void clearService() {
		_service = null;
	}

	public static NotificationAuditLogService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					NotificationAuditLogService.class.getName());

			if (invokableService instanceof NotificationAuditLogService) {
				_service = (NotificationAuditLogService)invokableService;
			}
			else {
				_service = new NotificationAuditLogServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(NotificationAuditLogServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(NotificationAuditLogService service) {
	}

	private static NotificationAuditLogService _service;
}