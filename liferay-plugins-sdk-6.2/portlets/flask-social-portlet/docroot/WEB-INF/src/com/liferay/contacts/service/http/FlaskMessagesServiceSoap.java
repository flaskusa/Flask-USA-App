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

import com.liferay.contacts.service.FlaskMessagesServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.contacts.service.FlaskMessagesServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.contacts.model.FlaskMessagesSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.contacts.model.FlaskMessages}, that is translated to a
 * {@link com.liferay.contacts.model.FlaskMessagesSoap}. Methods that SOAP cannot
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
 * @see FlaskMessagesServiceHttp
 * @see com.liferay.contacts.model.FlaskMessagesSoap
 * @see com.liferay.contacts.service.FlaskMessagesServiceUtil
 * @generated
 */
public class FlaskMessagesServiceSoap {
	public static com.liferay.contacts.model.FlaskMessagesSoap sendFlaskMessage(
		java.lang.String recipients, java.lang.String message,
		boolean sendEmail,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.contacts.model.FlaskMessages returnValue = FlaskMessagesServiceUtil.sendFlaskMessage(recipients,
					message, sendEmail, serviceContext);

			return com.liferay.contacts.model.FlaskMessagesSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean sendSnsEmail(java.lang.String subject,
		java.lang.String message) throws RemoteException {
		try {
			boolean returnValue = FlaskMessagesServiceUtil.sendSnsEmail(subject,
					message);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getAllMyFlaskMessages(long receiverId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = FlaskMessagesServiceUtil.getAllMyFlaskMessages(receiverId,
					serviceContext);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contacts.model.FlaskMessagesSoap[] getMyUnreadFlaskMessages(
		long receiverId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.liferay.contacts.model.FlaskMessages> returnValue =
				FlaskMessagesServiceUtil.getMyUnreadFlaskMessages(receiverId,
					serviceContext);

			return com.liferay.contacts.model.FlaskMessagesSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getMyFlaskMessagesCount(long receiverId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			int returnValue = FlaskMessagesServiceUtil.getMyFlaskMessagesCount(receiverId,
					serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getMyUnreadFlaskMessagesCount(long receiverId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			int returnValue = FlaskMessagesServiceUtil.getMyUnreadFlaskMessagesCount(receiverId,
					serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getTotalUnreadChatCount(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			int returnValue = FlaskMessagesServiceUtil.getTotalUnreadChatCount(serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteMessage(long messageId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			FlaskMessagesServiceUtil.deleteMessage(messageId, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteMessagesByDateRange(java.util.Date startDate,
		java.util.Date endDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			FlaskMessagesServiceUtil.deleteMessagesByDateRange(startDate,
				endDate, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean deleteMyChatMessages(java.lang.Long[] messageIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			boolean returnValue = FlaskMessagesServiceUtil.deleteMyChatMessages(messageIds,
					serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean registerWithSNS(long userId,
		java.lang.String userEmail, java.lang.String devicePlatform,
		java.lang.String deviceDetails, java.lang.String deviceToken,
		java.util.Date registrationTime, java.lang.Boolean active,
		java.util.Date lastNotificationTime,
		java.lang.String lastNotificationMsg,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			boolean returnValue = FlaskMessagesServiceUtil.registerWithSNS(userId,
					userEmail, devicePlatform, deviceDetails, deviceToken,
					registrationTime, active, lastNotificationTime,
					lastNotificationMsg, serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FlaskMessagesServiceSoap.class);
}