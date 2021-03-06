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

import com.liferay.contacts.service.EntryServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.contacts.service.EntryServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.contacts.model.EntrySoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.contacts.model.Entry}, that is translated to a
 * {@link com.liferay.contacts.model.EntrySoap}. Methods that SOAP cannot
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
 * @see EntryServiceHttp
 * @see com.liferay.contacts.model.EntrySoap
 * @see com.liferay.contacts.service.EntryServiceUtil
 * @generated
 */
public class EntryServiceSoap {
	public static java.lang.String searchUsersAndContacts(long companyId,
		java.lang.String keywords, int start, int end,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = EntryServiceUtil.searchUsersAndContacts(companyId,
					keywords, start, end, serviceContext);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.social.model.SocialRequestSoap[] getRequestsToConfirm(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.liferay.portlet.social.model.SocialRequest> returnValue =
				EntryServiceUtil.getRequestsToConfirm(serviceContext);

			return com.liferay.portlet.social.model.SocialRequestSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.social.model.SocialRequest deleteRequest(
		long receiverUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portlet.social.model.SocialRequest returnValue = EntryServiceUtil.deleteRequest(receiverUserId,
					serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getRequestingUsers(long companyId,
		java.lang.String keywords,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = EntryServiceUtil.getRequestingUsers(companyId,
					keywords, serviceContext);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean blockUser(long blockUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			boolean returnValue = EntryServiceUtil.blockUser(blockUserId,
					serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean unblockUser(long unblockUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			boolean returnValue = EntryServiceUtil.unblockUser(unblockUserId,
					serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getUsersAndContactsCount(long companyId,
		java.lang.String keywords,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			int returnValue = EntryServiceUtil.getUsersAndContactsCount(companyId,
					keywords, serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String searchMyFriends(long companyId,
		java.lang.String keywords,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = EntryServiceUtil.searchMyFriends(companyId,
					keywords, serviceContext);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.kernel.repository.model.FileEntrySoap getMyFileEntry(
		long portraitId, long companyId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.repository.model.FileEntry returnValue = EntryServiceUtil.getMyFileEntry(portraitId,
					companyId, serviceContext);

			return com.liferay.portal.kernel.repository.model.FileEntrySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.User getUserById(long userId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portal.model.User returnValue = EntryServiceUtil.getUserById(userId,
					serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addSocialRelation(long receiverUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			EntryServiceUtil.addSocialRelation(receiverUserId, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void requestSocialRelation(long receiverUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			EntryServiceUtil.requestSocialRelation(receiverUserId,
				serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getRequestsCount(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			int returnValue = EntryServiceUtil.getRequestsCount(serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteSocialRelation(long receiverUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			EntryServiceUtil.deleteSocialRelation(receiverUserId, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EntryServiceSoap.class);
}