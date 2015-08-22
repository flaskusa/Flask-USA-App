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

import com.liferay.contacts.service.EntryServiceUtil;

import java.util.Arrays;

/**
 * @author Kiran
 * @generated
 */
public class EntryServiceClpInvoker {
	public EntryServiceClpInvoker() {
		_methodName20 = "getBeanIdentifier";

		_methodParameterTypes20 = new String[] {  };

		_methodName21 = "setBeanIdentifier";

		_methodParameterTypes21 = new String[] { "java.lang.String" };

		_methodName26 = "searchUsersAndContacts";

		_methodParameterTypes26 = new String[] {
				"long", "java.lang.String", "int", "int",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName27 = "getRequestsToConfirm";

		_methodParameterTypes27 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName28 = "blockUser";

		_methodParameterTypes28 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName29 = "unblockUser";

		_methodParameterTypes29 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName30 = "getUsersAndContactsCount";

		_methodParameterTypes30 = new String[] {
				"long", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName31 = "searchMyFriends";

		_methodParameterTypes31 = new String[] {
				"long", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName32 = "addSocialRelation";

		_methodParameterTypes32 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName33 = "requestSocialRelation";

		_methodParameterTypes33 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName35 = "deleteSocialRelation";

		_methodParameterTypes35 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			return EntryServiceUtil.getBeanIdentifier();
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			EntryServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return EntryServiceUtil.searchUsersAndContacts(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return EntryServiceUtil.getRequestsToConfirm((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			EntryServiceUtil.blockUser(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			EntryServiceUtil.unblockUser(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return EntryServiceUtil.getUsersAndContactsCount(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			return EntryServiceUtil.searchMyFriends(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			EntryServiceUtil.addSocialRelation(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			EntryServiceUtil.requestSocialRelation(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			EntryServiceUtil.deleteSocialRelation(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName35;
	private String[] _methodParameterTypes35;
}