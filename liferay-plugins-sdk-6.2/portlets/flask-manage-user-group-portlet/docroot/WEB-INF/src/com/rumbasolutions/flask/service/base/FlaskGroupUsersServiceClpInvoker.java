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

import com.rumbasolutions.flask.service.FlaskGroupUsersServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FlaskGroupUsersServiceClpInvoker {
	public FlaskGroupUsersServiceClpInvoker() {
		_methodName28 = "getBeanIdentifier";

		_methodParameterTypes28 = new String[] {  };

		_methodName29 = "setBeanIdentifier";

		_methodParameterTypes29 = new String[] { "java.lang.String" };

		_methodName34 = "getAllGroupUsers";

		_methodParameterTypes34 = new String[] { "long" };

		_methodName35 = "getGroupUsersCount";

		_methodParameterTypes35 = new String[] { "long" };

		_methodName36 = "addGroupUser";

		_methodParameterTypes36 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String", "int"
			};

		_methodName37 = "updateGroupUser";

		_methodParameterTypes37 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"int"
			};

		_methodName38 = "addGroupOwner";

		_methodParameterTypes38 = new String[] { "long", "long" };

		_methodName39 = "removeGroupOwner";

		_methodParameterTypes39 = new String[] { "long", "long" };

		_methodName40 = "deleteGroupUser";

		_methodParameterTypes40 = new String[] { "long", "long" };

		_methodName41 = "deleteGroupUsers";

		_methodParameterTypes41 = new String[] { "long", "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return FlaskGroupUsersServiceUtil.getBeanIdentifier();
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			FlaskGroupUsersServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return FlaskGroupUsersServiceUtil.getAllGroupUsers(((Long)arguments[0]).longValue());
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			return FlaskGroupUsersServiceUtil.getGroupUsersCount(((Long)arguments[0]).longValue());
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return FlaskGroupUsersServiceUtil.addGroupUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue());
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			return FlaskGroupUsersServiceUtil.updateGroupUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Integer)arguments[5]).intValue());
		}

		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return FlaskGroupUsersServiceUtil.addGroupOwner(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			FlaskGroupUsersServiceUtil.removeGroupOwner(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return FlaskGroupUsersServiceUtil.deleteGroupUser(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			return FlaskGroupUsersServiceUtil.deleteGroupUsers(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
}