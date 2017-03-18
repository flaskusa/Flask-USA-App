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

import com.liferay.contacts.service.FlaskMessagesServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FlaskMessagesServiceClpInvoker {
	public FlaskMessagesServiceClpInvoker() {
		_methodName62 = "getBeanIdentifier";

		_methodParameterTypes62 = new String[] {  };

		_methodName63 = "setBeanIdentifier";

		_methodParameterTypes63 = new String[] { "java.lang.String" };

		_methodName68 = "sendFlaskMessage";

		_methodParameterTypes68 = new String[] {
				"java.lang.String", "java.lang.String", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName69 = "getAllMyFlaskMessages";

		_methodParameterTypes69 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName70 = "getMyUnreadFlaskMessages";

		_methodParameterTypes70 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName71 = "getMyFlaskMessagesCount";

		_methodParameterTypes71 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName72 = "getMyUnreadFlaskMessagesCount";

		_methodParameterTypes72 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName73 = "getTotalUnreadChatCount";

		_methodParameterTypes73 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName74 = "deleteMessage";

		_methodParameterTypes74 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName75 = "deleteMessagesByDateRange";

		_methodParameterTypes75 = new String[] {
				"java.util.Date", "java.util.Date",
				"com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return FlaskMessagesServiceUtil.getBeanIdentifier();
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			FlaskMessagesServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName68.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
			return FlaskMessagesServiceUtil.sendFlaskMessage((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Boolean)arguments[2]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName69.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
			return FlaskMessagesServiceUtil.getAllMyFlaskMessages(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return FlaskMessagesServiceUtil.getMyUnreadFlaskMessages(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return FlaskMessagesServiceUtil.getMyFlaskMessagesCount(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return FlaskMessagesServiceUtil.getMyUnreadFlaskMessagesCount(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return FlaskMessagesServiceUtil.getTotalUnreadChatCount((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			FlaskMessagesServiceUtil.deleteMessage(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			FlaskMessagesServiceUtil.deleteMessagesByDateRange((java.util.Date)arguments[0],
				(java.util.Date)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);

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
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
}