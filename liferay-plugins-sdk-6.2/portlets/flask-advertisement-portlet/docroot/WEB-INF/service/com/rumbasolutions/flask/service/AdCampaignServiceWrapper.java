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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AdCampaignService}.
 *
 * @author Brian Wing Shun Chan
 * @see AdCampaignService
 * @generated
 */
public class AdCampaignServiceWrapper implements AdCampaignService,
	ServiceWrapper<AdCampaignService> {
	public AdCampaignServiceWrapper(AdCampaignService adCampaignService) {
		_adCampaignService = adCampaignService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _adCampaignService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_adCampaignService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _adCampaignService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getAllCampaign() {
		return _adCampaignService.getAllCampaign();
	}

	@Override
	public com.rumbasolutions.flask.model.AdCampaign getCampaign(
		long campaignId) {
		return _adCampaignService.getCampaign(campaignId);
	}

	@Override
	public com.rumbasolutions.flask.model.AdCampaign addCampaign(
		java.lang.String campaignName, long customerId, boolean displayGeneral,
		boolean displayPreEvent, boolean displayDuringEvent,
		boolean displayPostEvent, long frequencyPerHour, long eventTypeId,
		java.lang.String events,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _adCampaignService.addCampaign(campaignName, customerId,
			displayGeneral, displayPreEvent, displayDuringEvent,
			displayPostEvent, frequencyPerHour, eventTypeId, events,
			serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.AdCampaign updateCampaign(
		long campaignId, java.lang.String campaignName, long customerId,
		boolean displayGeneral, boolean displayPreEvent,
		boolean displayDuringEvent, boolean displayPostEvent,
		long frequencyPerHour, java.lang.String events,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _adCampaignService.updateCampaign(campaignId, campaignName,
			customerId, displayGeneral, displayPreEvent, displayDuringEvent,
			displayPostEvent, frequencyPerHour, events, serviceContext);
	}

	@Override
	public void deleteCampaign(long campaignId) {
		_adCampaignService.deleteCampaign(campaignId);
	}

	@Override
	public void deleteCampaigns(java.lang.String campaignList) {
		_adCampaignService.deleteCampaigns(campaignList);
	}

	@Override
	public com.rumbasolutions.flask.model.CampaignImage addCampaignImage(
		long campaignId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID,
		long imageGroupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _adCampaignService.addCampaignImage(campaignId, imageTitle,
			imageDesc, imageUUID, imageGroupId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.CampaignImage updateCampaignImage(
		long campaignImageId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID,
		long imageGroupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _adCampaignService.updateCampaignImage(campaignImageId,
			imageTitle, imageDesc, imageUUID, imageGroupId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.CampaignImage getCampaignImage(
		long campaignImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _adCampaignService.getCampaignImage(campaignImageId,
			serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.CampaignImage> getCampaignImages(
		long campaignId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _adCampaignService.getCampaignImages(campaignId, serviceContext);
	}

	@Override
	public void deleteCampaignImage(long campaignImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_adCampaignService.deleteCampaignImage(campaignImageId, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getCampaignWithImages(
		long campaignId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _adCampaignService.getCampaignWithImages(campaignId,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AdCampaignService getWrappedAdCampaignService() {
		return _adCampaignService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAdCampaignService(AdCampaignService adCampaignService) {
		_adCampaignService = adCampaignService;
	}

	@Override
	public AdCampaignService getWrappedService() {
		return _adCampaignService;
	}

	@Override
	public void setWrappedService(AdCampaignService adCampaignService) {
		_adCampaignService = adCampaignService;
	}

	private AdCampaignService _adCampaignService;
}