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

import com.rumbasolutions.flask.service.AdCampaignServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AdCampaignServiceClpInvoker {
	public AdCampaignServiceClpInvoker() {
		_methodName38 = "getBeanIdentifier";

		_methodParameterTypes38 = new String[] {  };

		_methodName39 = "setBeanIdentifier";

		_methodParameterTypes39 = new String[] { "java.lang.String" };

		_methodName44 = "getAllCampaign";

		_methodParameterTypes44 = new String[] {  };

		_methodName46 = "getCampaign";

		_methodParameterTypes46 = new String[] { "long" };

		_methodName47 = "addCampaign";

		_methodParameterTypes47 = new String[] {
				"java.lang.String", "long", "boolean", "boolean", "boolean",
				"boolean", "long", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName49 = "updateCampaign";

		_methodParameterTypes49 = new String[] {
				"long", "java.lang.String", "long", "boolean", "boolean",
				"boolean", "boolean", "long", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName50 = "deleteCampaign";

		_methodParameterTypes50 = new String[] { "long" };

		_methodName51 = "deleteCampaigns";

		_methodParameterTypes51 = new String[] { "java.lang.String" };

		_methodName52 = "addCampaignImage";

		_methodParameterTypes52 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName53 = "updateCampaignImage";

		_methodParameterTypes53 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName54 = "getCampaignImage";

		_methodParameterTypes54 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName55 = "getCampaignImages";

		_methodParameterTypes55 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName56 = "deleteCampaignImage";

		_methodParameterTypes56 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName57 = "getCampaignWithImages";

		_methodParameterTypes57 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName38.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
			return AdCampaignServiceUtil.getBeanIdentifier();
		}

		if (_methodName39.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
			AdCampaignServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return AdCampaignServiceUtil.getAllCampaign();
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return AdCampaignServiceUtil.getCampaign(((Long)arguments[0]).longValue());
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return AdCampaignServiceUtil.addCampaign((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue(),
				((Boolean)arguments[3]).booleanValue(),
				((Boolean)arguments[4]).booleanValue(),
				((Boolean)arguments[5]).booleanValue(),
				((Long)arguments[6]).longValue(),
				(java.lang.String)arguments[7],
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return AdCampaignServiceUtil.updateCampaign(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Boolean)arguments[3]).booleanValue(),
				((Boolean)arguments[4]).booleanValue(),
				((Boolean)arguments[5]).booleanValue(),
				((Boolean)arguments[6]).booleanValue(),
				((Long)arguments[7]).longValue(),
				(java.lang.String)arguments[8],
				(com.liferay.portal.service.ServiceContext)arguments[9]);
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			AdCampaignServiceUtil.deleteCampaign(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			AdCampaignServiceUtil.deleteCampaigns((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return AdCampaignServiceUtil.addCampaignImage(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[5]);
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return AdCampaignServiceUtil.updateCampaignImage(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[5]);
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return AdCampaignServiceUtil.getCampaignImage(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return AdCampaignServiceUtil.getCampaignImages(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			AdCampaignServiceUtil.deleteCampaignImage(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return AdCampaignServiceUtil.getCampaignWithImages(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
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