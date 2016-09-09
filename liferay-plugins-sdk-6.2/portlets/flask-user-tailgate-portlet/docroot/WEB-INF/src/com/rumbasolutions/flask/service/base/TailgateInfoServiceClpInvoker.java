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

import com.rumbasolutions.flask.service.TailgateInfoServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TailgateInfoServiceClpInvoker {
	public TailgateInfoServiceClpInvoker() {
		_methodName66 = "getBeanIdentifier";

		_methodParameterTypes66 = new String[] {  };

		_methodName67 = "setBeanIdentifier";

		_methodParameterTypes67 = new String[] { "java.lang.String" };

		_methodName72 = "addTailgateInfo";

		_methodParameterTypes72 = new String[] {
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.util.Date", "long", "long",
				"java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName73 = "getAllTailgate";

		_methodParameterTypes73 = new String[] {  };

		_methodName74 = "getAllMyTailgate";

		_methodParameterTypes74 = new String[] { "long" };

		_methodName75 = "getAllTailgeteByUserId";

		_methodParameterTypes75 = new String[] { "long" };

		_methodName76 = "getTailgate";

		_methodParameterTypes76 = new String[] { "int" };

		_methodName77 = "updateTailgateInfo";

		_methodParameterTypes77 = new String[] {
				"long", "java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.util.Date", "long", "long",
				"java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName78 = "deleteTailgateInfo";

		_methodParameterTypes78 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return TailgateInfoServiceUtil.getBeanIdentifier();
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			TailgateInfoServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return TailgateInfoServiceUtil.addTailgateInfo((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.util.Date)arguments[4],
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(),
				(java.lang.String)arguments[7],
				((Long)arguments[8]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[9]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return TailgateInfoServiceUtil.getAllTailgate();
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return TailgateInfoServiceUtil.getAllMyTailgate(((Long)arguments[0]).longValue());
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return TailgateInfoServiceUtil.getAllTailgeteByUserId(((Long)arguments[0]).longValue());
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return TailgateInfoServiceUtil.getTailgate(((Integer)arguments[0]).intValue());
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return TailgateInfoServiceUtil.updateTailgateInfo(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], (java.util.Date)arguments[5],
				((Long)arguments[6]).longValue(),
				((Long)arguments[7]).longValue(),
				(java.lang.String)arguments[8],
				((Long)arguments[9]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[10]);
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			TailgateInfoServiceUtil.deleteTailgateInfo(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);

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
}