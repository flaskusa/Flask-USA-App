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

package com.liferay.contacts.service.base;

import com.liferay.contacts.service.DeviceAwsEndpointServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DeviceAwsEndpointServiceClpInvoker {
	public DeviceAwsEndpointServiceClpInvoker() {
		_methodName62 = "getBeanIdentifier";

		_methodParameterTypes62 = new String[] {  };

		_methodName63 = "setBeanIdentifier";

		_methodParameterTypes63 = new String[] { "java.lang.String" };

		_methodName68 = "addDeviceAwsEndpoint";

		_methodParameterTypes68 = new String[] { "java.lang.String", "long" };

		_methodName69 = "getAllDeviceAwsEndpoint";

		_methodParameterTypes69 = new String[] {  };

		_methodName70 = "getDeviceAwsEndpoint";

		_methodParameterTypes70 = new String[] { "long" };

		_methodName71 = "getAllDeviceAwsEndpointsByUserDeviceRegistrationId";

		_methodParameterTypes71 = new String[] { "long" };

		_methodName72 = "updateDeviceAwsEndpoint";

		_methodParameterTypes72 = new String[] {
				"long", "java.lang.String", "long"
			};

		_methodName73 = "deleteDeviceAwsEndpoint";

		_methodParameterTypes73 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return DeviceAwsEndpointServiceUtil.getBeanIdentifier();
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			DeviceAwsEndpointServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return DeviceAwsEndpointServiceUtil.addDeviceAwsEndpoint((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return DeviceAwsEndpointServiceUtil.getAllDeviceAwsEndpoint();
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return DeviceAwsEndpointServiceUtil.getDeviceAwsEndpoint(((Long)arguments[0]).longValue());
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return DeviceAwsEndpointServiceUtil.getAllDeviceAwsEndpointsByUserDeviceRegistrationId(((Long)arguments[0]).longValue());
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return DeviceAwsEndpointServiceUtil.updateDeviceAwsEndpoint(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], ((Long)arguments[2]).longValue());
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			DeviceAwsEndpointServiceUtil.deleteDeviceAwsEndpoint(((Long)arguments[0]).longValue());

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
}