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

import com.liferay.contacts.service.FlaskGroupMessagesServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.contacts.service.FlaskGroupMessagesServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.contacts.model.FlaskGroupMessagesSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.contacts.model.FlaskGroupMessages}, that is translated to a
 * {@link com.liferay.contacts.model.FlaskGroupMessagesSoap}. Methods that SOAP cannot
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
 * @see FlaskGroupMessagesServiceHttp
 * @see com.liferay.contacts.model.FlaskGroupMessagesSoap
 * @see com.liferay.contacts.service.FlaskGroupMessagesServiceUtil
 * @generated
 */
public class FlaskGroupMessagesServiceSoap {
	public static com.liferay.contacts.model.FlaskGroupMessagesSoap sendFlaskGroupMessage(
		long groupId, java.lang.String message, boolean sendEmail,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.contacts.model.FlaskGroupMessages returnValue = FlaskGroupMessagesServiceUtil.sendFlaskGroupMessage(groupId,
					message, sendEmail, serviceContext);

			return com.liferay.contacts.model.FlaskGroupMessagesSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getAllMyFlaskGroupMessages(long groupId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = FlaskGroupMessagesServiceUtil.getAllMyFlaskGroupMessages(groupId,
					serviceContext);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contacts.model.FlaskGroupMessagesSoap[] getGroupMessages(
		long groupId) throws RemoteException {
		try {
			java.util.List<com.liferay.contacts.model.FlaskGroupMessages> returnValue =
				FlaskGroupMessagesServiceUtil.getGroupMessages(groupId);

			return com.liferay.contacts.model.FlaskGroupMessagesSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getMyFlaskGroupMessagesCount(long groupId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			int returnValue = FlaskGroupMessagesServiceUtil.getMyFlaskGroupMessagesCount(groupId,
					serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getMyUnreadFlaskGroupMessagesCount(long groupId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			int returnValue = FlaskGroupMessagesServiceUtil.getMyUnreadFlaskGroupMessagesCount(groupId,
					serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean deleteMyGroupChatMessages(Long[] groupMessageIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			boolean returnValue = FlaskGroupMessagesServiceUtil.deleteMyGroupChatMessages(ListUtil.toList(
						groupMessageIds), serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteGroupMessage(long groupMessageId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			FlaskGroupMessagesServiceUtil.deleteGroupMessage(groupMessageId,
				serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteGroupMessagesByDateRange(
		java.util.Date startDate, java.util.Date endDate,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			FlaskGroupMessagesServiceUtil.deleteGroupMessagesByDateRange(startDate,
				endDate, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FlaskGroupMessagesServiceSoap.class);
}