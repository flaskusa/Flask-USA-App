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

		_methodName69 = "sendSnsEmail";

		_methodParameterTypes69 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName70 = "getAllMyFlaskMessages";

		_methodParameterTypes70 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName71 = "getMyUnreadFlaskMessages";

		_methodParameterTypes71 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName72 = "getMyFlaskMessagesCount";

		_methodParameterTypes72 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName73 = "getMyUnreadFlaskMessagesCount";

		_methodParameterTypes73 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName74 = "getTotalUnreadChatCount";

		_methodParameterTypes74 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName75 = "deleteMessage";

		_methodParameterTypes75 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName76 = "deleteMessagesByDateRange";

		_methodParameterTypes76 = new String[] {
				"java.util.Date", "java.util.Date",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName77 = "registerWithSNS";

		_methodParameterTypes77 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.util.Date",
				"java.lang.Boolean", "java.util.Date", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName78 = "sendPush";

		_methodParameterTypes78 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Map", "long"
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
			return FlaskMessagesServiceUtil.sendSnsEmail((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName70.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
			return FlaskMessagesServiceUtil.getAllMyFlaskMessages(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName71.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
			return FlaskMessagesServiceUtil.getMyUnreadFlaskMessages(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return FlaskMessagesServiceUtil.getMyFlaskMessagesCount(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return FlaskMessagesServiceUtil.getMyUnreadFlaskMessagesCount(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return FlaskMessagesServiceUtil.getTotalUnreadChatCount((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			FlaskMessagesServiceUtil.deleteMessage(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			FlaskMessagesServiceUtil.deleteMessagesByDateRange((java.util.Date)arguments[0],
				(java.util.Date)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);

			return null;
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return FlaskMessagesServiceUtil.registerWithSNS(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.util.Date)arguments[5], (java.lang.Boolean)arguments[6],
				(java.util.Date)arguments[7], (java.lang.String)arguments[8],
				(com.liferay.portal.service.ServiceContext)arguments[9]);
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return FlaskMessagesServiceUtil.sendPush(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[4],
				((Long)arguments[5]).longValue());
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
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
}