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

package com.rumbasolutions.flask.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.rumbasolutions.flask.service.AdCampaignServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.rumbasolutions.flask.service.AdCampaignServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.rumbasolutions.flask.model.AdCampaignSoap}.
 * If the method in the service utility returns a
 * {@link com.rumbasolutions.flask.model.AdCampaign}, that is translated to a
 * {@link com.rumbasolutions.flask.model.AdCampaignSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdCampaignServiceHttp
 * @see com.rumbasolutions.flask.model.AdCampaignSoap
 * @see com.rumbasolutions.flask.service.AdCampaignServiceUtil
 * @generated
 */
public class AdCampaignServiceSoap {
	public static java.lang.String getAllCampaign() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = AdCampaignServiceUtil.getAllCampaign();

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.AdCampaignSoap getCampaign(
		long campaignId) throws RemoteException {
		try {
			com.rumbasolutions.flask.model.AdCampaign returnValue = AdCampaignServiceUtil.getCampaign(campaignId);

			return com.rumbasolutions.flask.model.AdCampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.AdCampaignSoap addCampaign(
		java.lang.String campaignName, long customerId, boolean displayGeneral,
		boolean displayPreEvent, boolean displayDuringEvent,
		boolean displayPostEvent, long frequencyPerHour, long eventTypeId,
		java.lang.String events, boolean showAlways,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.AdCampaign returnValue = AdCampaignServiceUtil.addCampaign(campaignName,
					customerId, displayGeneral, displayPreEvent,
					displayDuringEvent, displayPostEvent, frequencyPerHour,
					eventTypeId, events, showAlways, serviceContext);

			return com.rumbasolutions.flask.model.AdCampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.AdCampaignSoap updateCampaign(
		long campaignId, java.lang.String campaignName, long customerId,
		boolean displayGeneral, boolean displayPreEvent,
		boolean displayDuringEvent, boolean displayPostEvent,
		long frequencyPerHour, java.lang.String events, boolean showAlways,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.AdCampaign returnValue = AdCampaignServiceUtil.updateCampaign(campaignId,
					campaignName, customerId, displayGeneral, displayPreEvent,
					displayDuringEvent, displayPostEvent, frequencyPerHour,
					events, showAlways, serviceContext);

			return com.rumbasolutions.flask.model.AdCampaignSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteCampaign(long campaignId)
		throws RemoteException {
		try {
			AdCampaignServiceUtil.deleteCampaign(campaignId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteCampaigns(java.lang.String campaignList)
		throws RemoteException {
		try {
			AdCampaignServiceUtil.deleteCampaigns(campaignList);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.CampaignImageSoap addCampaignImage(
		long campaignId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID,
		long imageGroupId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.CampaignImage returnValue = AdCampaignServiceUtil.addCampaignImage(campaignId,
					imageTitle, imageDesc, imageUUID, imageGroupId,
					serviceContext);

			return com.rumbasolutions.flask.model.CampaignImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.CampaignImageSoap updateCampaignImage(
		long campaignImageId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID,
		long imageGroupId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.CampaignImage returnValue = AdCampaignServiceUtil.updateCampaignImage(campaignImageId,
					imageTitle, imageDesc, imageUUID, imageGroupId,
					serviceContext);

			return com.rumbasolutions.flask.model.CampaignImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.CampaignImageSoap getCampaignImage(
		long campaignImageId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.CampaignImage returnValue = AdCampaignServiceUtil.getCampaignImage(campaignImageId,
					serviceContext);

			return com.rumbasolutions.flask.model.CampaignImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.CampaignImageSoap[] getCampaignImages(
		long campaignId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.CampaignImage> returnValue =
				AdCampaignServiceUtil.getCampaignImages(campaignId,
					serviceContext);

			return com.rumbasolutions.flask.model.CampaignImageSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteCampaignImage(long campaignImageId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			AdCampaignServiceUtil.deleteCampaignImage(campaignImageId,
				serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getCampaignWithImages(long campaignId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = AdCampaignServiceUtil.getCampaignWithImages(campaignId,
					serviceContext);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AdCampaignServiceSoap.class);
}