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

import com.rumbasolutions.flask.service.FlaskAdminServiceUtil;

import java.util.Arrays;

/**
 * @author Ashutosh Rai
 * @generated
 */
public class FlaskAdminServiceClpInvoker {
	public FlaskAdminServiceClpInvoker() {
		_methodName20 = "getBeanIdentifier";

		_methodParameterTypes20 = new String[] {  };

		_methodName21 = "setBeanIdentifier";

		_methodParameterTypes21 = new String[] { "java.lang.String" };

		_methodName26 = "getFlaskAdmins";

		_methodParameterTypes26 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName27 = "getFlaskRegularUsers";

		_methodParameterTypes27 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName29 = "addFlaskAdmin";

		_methodParameterTypes29 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long", "java.lang.String",
				"java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName30 = "signUp";

		_methodParameterTypes30 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "boolean", "java.lang.String",
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName31 = "updateFlaskAdmin";

		_methodParameterTypes31 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"boolean", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "long", "long",
				"java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName32 = "deleteFlaskAdmins";

		_methodParameterTypes32 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName33 = "getUserIdForScreenName";

		_methodParameterTypes33 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName34 = "getUserIdForEmail";

		_methodParameterTypes34 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName35 = "getUserById";

		_methodParameterTypes35 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName42 = "addFlaskUser";

		_methodParameterTypes42 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long", "java.lang.String",
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName43 = "updateFlaskUser";

		_methodParameterTypes43 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"boolean", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "long", "long",
				"java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName44 = "updateLoggedInUser";

		_methodParameterTypes44 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "boolean",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long", "java.lang.String",
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName45 = "getCountryByName";

		_methodParameterTypes45 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName46 = "getCountries";

		_methodParameterTypes46 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName47 = "getRegion";

		_methodParameterTypes47 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName48 = "getUSARegions";

		_methodParameterTypes48 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName49 = "addMyFileEntry";

		_methodParameterTypes49 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"byte[][]", "com.liferay.portal.service.ServiceContext"
			};

		_methodName50 = "getMyFileEntry";

		_methodParameterTypes50 = new String[] { "long" };

		_methodName51 = "deleteMyFileEntry";

		_methodParameterTypes51 = new String[] { "long" };

		_methodName52 = "updateUserForFileEntry";

		_methodParameterTypes52 = new String[] {
				"long", "long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName53 = "getUserForEmail";

		_methodParameterTypes53 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName54 = "getUserForScreenName";

		_methodParameterTypes54 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName55 = "uploadUserProfile";

		_methodParameterTypes55 = new String[] {
				"java.io.File", "com.liferay.portal.service.ServiceContext"
			};

		_methodName56 = "getCompanyId";

		_methodParameterTypes56 = new String[] {  };

		_methodName57 = "isUserContentAdmin";

		_methodParameterTypes57 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName20.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes20, parameterTypes)) {
			return FlaskAdminServiceUtil.getBeanIdentifier();
		}

		if (_methodName21.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes21, parameterTypes)) {
			FlaskAdminServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName26.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
			return FlaskAdminServiceUtil.getFlaskAdmins((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName27.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
			return FlaskAdminServiceUtil.getFlaskRegularUsers((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return FlaskAdminServiceUtil.addFlaskAdmin((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7],
				((Boolean)arguments[8]).booleanValue(),
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				((Long)arguments[13]).longValue(),
				((Long)arguments[14]).longValue(),
				(java.lang.String)arguments[15],
				(java.lang.String)arguments[16],
				((Long)arguments[17]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[18]);
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return FlaskAdminServiceUtil.signUp((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				((Boolean)arguments[7]).booleanValue(),
				(java.lang.String)arguments[8], (java.lang.String)arguments[9],
				(com.liferay.portal.service.ServiceContext)arguments[10]);
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			return FlaskAdminServiceUtil.updateFlaskAdmin(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				((Boolean)arguments[9]).booleanValue(),
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				((Long)arguments[14]).longValue(),
				((Long)arguments[15]).longValue(),
				(java.lang.String)arguments[16],
				(java.lang.String)arguments[17],
				(com.liferay.portal.service.ServiceContext)arguments[18]);
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			FlaskAdminServiceUtil.deleteFlaskAdmins(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return FlaskAdminServiceUtil.getUserIdForScreenName((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return FlaskAdminServiceUtil.getUserIdForEmail((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			return FlaskAdminServiceUtil.getUserById(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return FlaskAdminServiceUtil.addFlaskUser((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7],
				((Boolean)arguments[8]).booleanValue(),
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				((Long)arguments[13]).longValue(),
				((Long)arguments[14]).longValue(),
				(java.lang.String)arguments[15],
				(java.lang.String)arguments[16],
				(com.liferay.portal.service.ServiceContext)arguments[17]);
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return FlaskAdminServiceUtil.updateFlaskUser(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				((Boolean)arguments[9]).booleanValue(),
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				(java.lang.String)arguments[13],
				((Long)arguments[14]).longValue(),
				((Long)arguments[15]).longValue(),
				(java.lang.String)arguments[16],
				(java.lang.String)arguments[17],
				(com.liferay.portal.service.ServiceContext)arguments[18]);
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return FlaskAdminServiceUtil.updateLoggedInUser((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7],
				((Boolean)arguments[8]).booleanValue(),
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				((Long)arguments[13]).longValue(),
				((Long)arguments[14]).longValue(),
				(java.lang.String)arguments[15],
				(java.lang.String)arguments[16],
				(com.liferay.portal.service.ServiceContext)arguments[17]);
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return FlaskAdminServiceUtil.getCountryByName((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return FlaskAdminServiceUtil.getCountries((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return FlaskAdminServiceUtil.getRegion(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return FlaskAdminServiceUtil.getUSARegions((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return FlaskAdminServiceUtil.addMyFileEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7], (byte[])arguments[8],
				(com.liferay.portal.service.ServiceContext)arguments[9]);
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return FlaskAdminServiceUtil.getMyFileEntry(((Long)arguments[0]).longValue());
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			FlaskAdminServiceUtil.deleteMyFileEntry(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			FlaskAdminServiceUtil.updateUserForFileEntry(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);

			return null;
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return FlaskAdminServiceUtil.getUserForEmail((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return FlaskAdminServiceUtil.getUserForScreenName((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return FlaskAdminServiceUtil.uploadUserProfile((java.io.File)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return FlaskAdminServiceUtil.getCompanyId();
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return FlaskAdminServiceUtil.isUserContentAdmin(((Long)arguments[0]).longValue());
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
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
}