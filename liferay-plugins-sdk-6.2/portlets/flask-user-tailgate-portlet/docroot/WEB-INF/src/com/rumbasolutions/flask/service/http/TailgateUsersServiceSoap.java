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

package com.rumbasolutions.flask.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.rumbasolutions.flask.service.TailgateUsersServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.rumbasolutions.flask.service.TailgateUsersServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.rumbasolutions.flask.model.TailgateUsersSoap}.
 * If the method in the service utility returns a
 * {@link com.rumbasolutions.flask.model.TailgateUsers}, that is translated to a
 * {@link com.rumbasolutions.flask.model.TailgateUsersSoap}. Methods that SOAP cannot
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
 * @see TailgateUsersServiceHttp
 * @see com.rumbasolutions.flask.model.TailgateUsersSoap
 * @see com.rumbasolutions.flask.service.TailgateUsersServiceUtil
 * @generated
 */
public class TailgateUsersServiceSoap {
	public static com.rumbasolutions.flask.model.TailgateUsersSoap[] getTailgateMembers(
		long tailgateId) throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.TailgateUsers> returnValue =
				TailgateUsersServiceUtil.getTailgateMembers(tailgateId);

			return com.rumbasolutions.flask.model.TailgateUsersSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.TailgateUsersSoap[] getTailgateGroups(
		long tailgateId, long groupId) throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.TailgateUsers> returnValue =
				TailgateUsersServiceUtil.getTailgateGroups(tailgateId, groupId);

			return com.rumbasolutions.flask.model.TailgateUsersSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean checkTailgateUserExist(long tailgateId, long userId)
		throws RemoteException {
		try {
			boolean returnValue = TailgateUsersServiceUtil.checkTailgateUserExist(tailgateId,
					userId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.TailgateUsersSoap addTailgateUser(
		long tailgateId, long userId, java.lang.String userName,
		java.lang.String emailAddress, int isAdmin, boolean isPaid,
		java.lang.String paymentMode, int groupId) throws RemoteException {
		try {
			com.rumbasolutions.flask.model.TailgateUsers returnValue = TailgateUsersServiceUtil.addTailgateUser(tailgateId,
					userId, userName, emailAddress, isAdmin, isPaid,
					paymentMode, groupId);

			return com.rumbasolutions.flask.model.TailgateUsersSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.TailgateUsersSoap updateTailgateUser(
		long userId, long tailgateId, boolean isPaid,
		java.lang.String paymentMode, java.lang.String description)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.TailgateUsers returnValue = TailgateUsersServiceUtil.updateTailgateUser(userId,
					tailgateId, isPaid, paymentMode, description);

			return com.rumbasolutions.flask.model.TailgateUsersSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteTailgateUser(long tailgateId, long userId)
		throws RemoteException {
		try {
			TailgateUsersServiceUtil.deleteTailgateUser(tailgateId, userId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TailgateUsersServiceSoap.class);
}