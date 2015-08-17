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

package com.rumbasolutions.flask.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for AdCampaign. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.AdCampaignServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AdCampaignService
 * @see com.rumbasolutions.flask.service.base.AdCampaignServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.AdCampaignServiceImpl
 * @generated
 */
public class AdCampaignServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.AdCampaignServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.portal.kernel.json.JSONArray getAllCampaign() {
		return getService().getAllCampaign();
	}

	public static com.rumbasolutions.flask.model.AdCampaign getCampaign(
		long campaignId) {
		return getService().getCampaign(campaignId);
	}

	public static com.rumbasolutions.flask.model.AdCampaign addCampaign(
		java.lang.String campaignName, long customerId, boolean displayGeneral,
		boolean displayPreEvent, boolean displayDuringEvent,
		boolean displayPostEvent, long frequencyPerHour,
		java.lang.String events,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addCampaign(campaignName, customerId, displayGeneral,
			displayPreEvent, displayDuringEvent, displayPostEvent,
			frequencyPerHour, events, serviceContext);
	}

	public static com.rumbasolutions.flask.model.AdCampaign updateCampaign(
		long campaignId, java.lang.String campaignName, long customerId,
		boolean displayGeneral, boolean displayPreEvent,
		boolean displayDuringEvent, boolean displayPostEvent,
		long frequencyPerHour, java.lang.String events,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateCampaign(campaignId, campaignName, customerId,
			displayGeneral, displayPreEvent, displayDuringEvent,
			displayPostEvent, frequencyPerHour, events, serviceContext);
	}

	public static void deleteCampaign(long campaignId) {
		getService().deleteCampaign(campaignId);
	}

	public static void deleteCampaigns(java.lang.String campaignList) {
		getService().deleteCampaigns(campaignList);
	}

	public static com.rumbasolutions.flask.model.CampaignImage addCampaignImage(
		long campaignId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID,
		long imageGroupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addCampaignImage(campaignId, imageTitle, imageDesc,
			imageUUID, imageGroupId, serviceContext);
	}

	public static com.rumbasolutions.flask.model.CampaignImage updateCampaignImage(
		long campaignImageId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID,
		long imageGroupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateCampaignImage(campaignImageId, imageTitle, imageDesc,
			imageUUID, imageGroupId, serviceContext);
	}

	public static com.rumbasolutions.flask.model.CampaignImage getCampaignImage(
		long campaignImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getCampaignImage(campaignImageId, serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.CampaignImage> getCampaignImages(
		long campaignId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getCampaignImages(campaignId, serviceContext);
	}

	public static void deleteCampaignImage(long campaignImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteCampaignImage(campaignImageId, serviceContext);
	}

	public static com.liferay.portal.kernel.json.JSONObject getCampaignWithImages(
		long campaignId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getCampaignWithImages(campaignId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static AdCampaignService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AdCampaignService.class.getName());

			if (invokableService instanceof AdCampaignService) {
				_service = (AdCampaignService)invokableService;
			}
			else {
				_service = new AdCampaignServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(AdCampaignServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AdCampaignService service) {
	}

	private static AdCampaignService _service;
}