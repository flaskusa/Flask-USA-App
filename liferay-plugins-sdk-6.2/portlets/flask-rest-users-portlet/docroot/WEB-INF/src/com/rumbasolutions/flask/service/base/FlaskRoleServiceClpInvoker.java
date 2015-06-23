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

package com.rumbasolutions.flask.service.base;

import com.rumbasolutions.flask.service.FlaskRoleServiceUtil;

import java.util.Arrays;

/**
 * @author Ashutosh Rai
 * @generated
 */
public class FlaskRoleServiceClpInvoker {
	public FlaskRoleServiceClpInvoker() {
		_methodName20 = "getBeanIdentifier";

		_methodParameterTypes20 = new String[] {  };

		_methodName21 = "setBeanIdentifier";

		_methodParameterTypes21 = new String[] { "java.lang.String" };

		_methodName26 = "getFlaskRoles";

		_methodParameterTypes26 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			return FlaskRoleServiceUtil.getBeanIdentifier();
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			FlaskRoleServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return FlaskRoleServiceUtil.getFlaskRoles();
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName26;
	private String[] _methodParameterTypes26;
}