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

import com.liferay.contacts.service.FlaskUserDeviceRegistrationServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.contacts.service.FlaskUserDeviceRegistrationServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.contacts.model.FlaskUserDeviceRegistrationSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.contacts.model.FlaskUserDeviceRegistration}, that is translated to a
 * {@link com.liferay.contacts.model.FlaskUserDeviceRegistrationSoap}. Methods that SOAP cannot
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
 * @see FlaskUserDeviceRegistrationServiceHttp
 * @see com.liferay.contacts.model.FlaskUserDeviceRegistrationSoap
 * @see com.liferay.contacts.service.FlaskUserDeviceRegistrationServiceUtil
 * @generated
 */
public class FlaskUserDeviceRegistrationServiceSoap {
	public static com.liferay.contacts.model.FlaskUserDeviceRegistrationSoap addUserDevice(
		long userId, java.lang.String userEmail,
		java.lang.String devicePlatform, java.lang.String deviceDetails,
		java.lang.String deviceToken, java.util.Date registrationTime,
		java.lang.Boolean active, java.util.Date lastNotificationTime,
		java.lang.String lastNotificationMsg,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.contacts.model.FlaskUserDeviceRegistration returnValue = FlaskUserDeviceRegistrationServiceUtil.addUserDevice(userId,
					userEmail, devicePlatform, deviceDetails, deviceToken,
					registrationTime, active, lastNotificationTime,
					lastNotificationMsg, serviceContext);

			return com.liferay.contacts.model.FlaskUserDeviceRegistrationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contacts.model.FlaskUserDeviceRegistrationSoap[] getAllUserDevices()
		throws RemoteException {
		try {
			java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> returnValue =
				FlaskUserDeviceRegistrationServiceUtil.getAllUserDevices();

			return com.liferay.contacts.model.FlaskUserDeviceRegistrationSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contacts.model.FlaskUserDeviceRegistrationSoap getUserDevice(
		long userDeviceRegistrationId) throws RemoteException {
		try {
			com.liferay.contacts.model.FlaskUserDeviceRegistration returnValue = FlaskUserDeviceRegistrationServiceUtil.getUserDevice(userDeviceRegistrationId);

			return com.liferay.contacts.model.FlaskUserDeviceRegistrationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contacts.model.FlaskUserDeviceRegistrationSoap[] getUserDevicesByUserId(
		long userId) throws RemoteException {
		try {
			java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> returnValue =
				FlaskUserDeviceRegistrationServiceUtil.getUserDevicesByUserId(userId);

			return com.liferay.contacts.model.FlaskUserDeviceRegistrationSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contacts.model.FlaskUserDeviceRegistrationSoap[] getUserDevicesByUserEmail(
		java.lang.String userEmail) throws RemoteException {
		try {
			java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> returnValue =
				FlaskUserDeviceRegistrationServiceUtil.getUserDevicesByUserEmail(userEmail);

			return com.liferay.contacts.model.FlaskUserDeviceRegistrationSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contacts.model.FlaskUserDeviceRegistrationSoap[] getUserDevicesByDeviceToken(
		java.lang.String deviceToken) throws RemoteException {
		try {
			java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> returnValue =
				FlaskUserDeviceRegistrationServiceUtil.getUserDevicesByDeviceToken(deviceToken);

			return com.liferay.contacts.model.FlaskUserDeviceRegistrationSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contacts.model.FlaskUserDeviceRegistrationSoap updateUserDevices(
		long userDeviceRegistrationId, long userId, java.lang.String userEmail,
		java.lang.String devicePlatform, java.lang.String deviceDetails,
		java.lang.String deviceToken, java.util.Date registrationTime,
		java.lang.Boolean active, java.util.Date lastNotificationTime,
		java.lang.String lastNotificationMsg,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.contacts.model.FlaskUserDeviceRegistration returnValue = FlaskUserDeviceRegistrationServiceUtil.updateUserDevices(userDeviceRegistrationId,
					userId, userEmail, devicePlatform, deviceDetails,
					deviceToken, registrationTime, active,
					lastNotificationTime, lastNotificationMsg, serviceContext);

			return com.liferay.contacts.model.FlaskUserDeviceRegistrationSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteUserDevice(long userDeviceRegistrationId)
		throws RemoteException {
		try {
			FlaskUserDeviceRegistrationServiceUtil.deleteUserDevice(userDeviceRegistrationId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FlaskUserDeviceRegistrationServiceSoap.class);
}