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

package com.liferay.contacts.service.http;

import com.liferay.contacts.service.NotificationAuditLogServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.contacts.service.NotificationAuditLogServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.contacts.model.NotificationAuditLogSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.contacts.model.NotificationAuditLog}, that is translated to a
 * {@link com.liferay.contacts.model.NotificationAuditLogSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationAuditLogServiceHttp
 * @see com.liferay.contacts.model.NotificationAuditLogSoap
 * @see com.liferay.contacts.service.NotificationAuditLogServiceUtil
 * @generated
 */
public class NotificationAuditLogServiceSoap {
	public static com.liferay.contacts.model.NotificationAuditLogSoap addNotificationAuditLog(
		java.lang.String senderEmail, java.lang.String receiverEmail,
		java.lang.String messageReason, java.lang.String message,
		java.util.Date notificationTime) throws RemoteException {
		try {
			com.liferay.contacts.model.NotificationAuditLog returnValue = NotificationAuditLogServiceUtil.addNotificationAuditLog(senderEmail,
					receiverEmail, messageReason, message, notificationTime);

			return com.liferay.contacts.model.NotificationAuditLogSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contacts.model.NotificationAuditLogSoap[] getAllNotificationAuditLog()
		throws RemoteException {
		try {
			java.util.List<com.liferay.contacts.model.NotificationAuditLog> returnValue =
				NotificationAuditLogServiceUtil.getAllNotificationAuditLog();

			return com.liferay.contacts.model.NotificationAuditLogSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contacts.model.NotificationAuditLogSoap getNotificationAuditLog(
		long notificationAuditLogId) throws RemoteException {
		try {
			com.liferay.contacts.model.NotificationAuditLog returnValue = NotificationAuditLogServiceUtil.getNotificationAuditLog(notificationAuditLogId);

			return com.liferay.contacts.model.NotificationAuditLogSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contacts.model.NotificationAuditLogSoap[] getAllNotificationAuditLogBySenderEmail(
		java.lang.String senderEmail) throws RemoteException {
		try {
			java.util.List<com.liferay.contacts.model.NotificationAuditLog> returnValue =
				NotificationAuditLogServiceUtil.getAllNotificationAuditLogBySenderEmail(senderEmail);

			return com.liferay.contacts.model.NotificationAuditLogSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contacts.model.NotificationAuditLogSoap[] getAllNotificationAuditLogByReceiverEmail(
		java.lang.String receiverEmail) throws RemoteException {
		try {
			java.util.List<com.liferay.contacts.model.NotificationAuditLog> returnValue =
				NotificationAuditLogServiceUtil.getAllNotificationAuditLogByReceiverEmail(receiverEmail);

			return com.liferay.contacts.model.NotificationAuditLogSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contacts.model.NotificationAuditLogSoap updateNotificationAuditLog(
		long notificationAuditLogId, java.lang.String senderEmail,
		java.lang.String receiverEmail, java.lang.String messageReason,
		java.lang.String message, java.util.Date notificationTime)
		throws RemoteException {
		try {
			com.liferay.contacts.model.NotificationAuditLog returnValue = NotificationAuditLogServiceUtil.updateNotificationAuditLog(notificationAuditLogId,
					senderEmail, receiverEmail, messageReason, message,
					notificationTime);

			return com.liferay.contacts.model.NotificationAuditLogSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteNotificationAuditLog(long notificationAuditLogId)
		throws RemoteException {
		try {
			NotificationAuditLogServiceUtil.deleteNotificationAuditLog(notificationAuditLogId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(NotificationAuditLogServiceSoap.class);
}