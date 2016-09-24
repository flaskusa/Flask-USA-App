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

import com.rumbasolutions.flask.service.SupplyListServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SupplyListServiceClpInvoker {
	public SupplyListServiceClpInvoker() {
		_methodName66 = "getBeanIdentifier";

		_methodParameterTypes66 = new String[] {  };

		_methodName67 = "setBeanIdentifier";

		_methodParameterTypes67 = new String[] { "java.lang.String" };

		_methodName72 = "addSupplyList";

		_methodParameterTypes72 = new String[] {
				"java.lang.String", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName73 = "updateSupplyList";

		_methodParameterTypes73 = new String[] {
				"long", "java.lang.String", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName74 = "getSupplyList";

		_methodParameterTypes74 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName75 = "getAllSupplyLists";

		_methodParameterTypes75 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName76 = "getMySupplyLists";

		_methodParameterTypes76 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName77 = "getGameDayNeeds";

		_methodParameterTypes77 = new String[] {  };

		_methodName78 = "deleteSupplyList";

		_methodParameterTypes78 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName79 = "deleteMySupplyLists";

		_methodParameterTypes79 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return SupplyListServiceUtil.getBeanIdentifier();
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			SupplyListServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return SupplyListServiceUtil.addSupplyList((java.lang.String)arguments[0],
				((Boolean)arguments[1]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return SupplyListServiceUtil.updateSupplyList(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Boolean)arguments[2]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return SupplyListServiceUtil.getSupplyList(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return SupplyListServiceUtil.getAllSupplyLists((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return SupplyListServiceUtil.getMySupplyLists((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return SupplyListServiceUtil.getGameDayNeeds();
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			SupplyListServiceUtil.deleteSupplyList(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			SupplyListServiceUtil.deleteMySupplyLists((com.liferay.portal.service.ServiceContext)arguments[0]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
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
	private String _methodName79;
	private String[] _methodParameterTypes79;
}