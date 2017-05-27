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

import com.liferay.contacts.service.DeviceAwsEndpointServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.contacts.service.DeviceAwsEndpointServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.contacts.model.DeviceAwsEndpointSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.contacts.model.DeviceAwsEndpoint}, that is translated to a
 * {@link com.liferay.contacts.model.DeviceAwsEndpointSoap}. Methods that SOAP cannot
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
 * @see DeviceAwsEndpointServiceHttp
 * @see com.liferay.contacts.model.DeviceAwsEndpointSoap
 * @see com.liferay.contacts.service.DeviceAwsEndpointServiceUtil
 * @generated
 */
public class DeviceAwsEndpointServiceSoap {
	public static com.liferay.contacts.model.DeviceAwsEndpointSoap addDeviceAwsEndpoint(
		java.lang.String awsEndpoint, long userDeviceRegistrationId)
		throws RemoteException {
		try {
			com.liferay.contacts.model.DeviceAwsEndpoint returnValue = DeviceAwsEndpointServiceUtil.addDeviceAwsEndpoint(awsEndpoint,
					userDeviceRegistrationId);

			return com.liferay.contacts.model.DeviceAwsEndpointSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contacts.model.DeviceAwsEndpointSoap[] getAllDeviceAwsEndpoint()
		throws RemoteException {
		try {
			java.util.List<com.liferay.contacts.model.DeviceAwsEndpoint> returnValue =
				DeviceAwsEndpointServiceUtil.getAllDeviceAwsEndpoint();

			return com.liferay.contacts.model.DeviceAwsEndpointSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contacts.model.DeviceAwsEndpointSoap getDeviceAwsEndpoint(
		long deviceEndPointId) throws RemoteException {
		try {
			com.liferay.contacts.model.DeviceAwsEndpoint returnValue = DeviceAwsEndpointServiceUtil.getDeviceAwsEndpoint(deviceEndPointId);

			return com.liferay.contacts.model.DeviceAwsEndpointSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contacts.model.DeviceAwsEndpointSoap[] getAllDeviceAwsEndpointsByUserDeviceRegistrationId(
		long userDeviceRegistrationId) throws RemoteException {
		try {
			java.util.List<com.liferay.contacts.model.DeviceAwsEndpoint> returnValue =
				DeviceAwsEndpointServiceUtil.getAllDeviceAwsEndpointsByUserDeviceRegistrationId(userDeviceRegistrationId);

			return com.liferay.contacts.model.DeviceAwsEndpointSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.contacts.model.DeviceAwsEndpointSoap updateDeviceAwsEndpoint(
		long deviceEndPointId, java.lang.String awsEndpoint,
		long userDeviceRegistrationId) throws RemoteException {
		try {
			com.liferay.contacts.model.DeviceAwsEndpoint returnValue = DeviceAwsEndpointServiceUtil.updateDeviceAwsEndpoint(deviceEndPointId,
					awsEndpoint, userDeviceRegistrationId);

			return com.liferay.contacts.model.DeviceAwsEndpointSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteDeviceAwsEndpoint(long deviceEndPointId)
		throws RemoteException {
		try {
			DeviceAwsEndpointServiceUtil.deleteDeviceAwsEndpoint(deviceEndPointId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DeviceAwsEndpointServiceSoap.class);
}