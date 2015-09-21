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
 * Provides a wrapper for {@link CampaignEventService}.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignEventService
 * @generated
 */
public class CampaignEventServiceWrapper implements CampaignEventService,
	ServiceWrapper<CampaignEventService> {
	public CampaignEventServiceWrapper(
		CampaignEventService campaignEventService) {
		_campaignEventService = campaignEventService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _campaignEventService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_campaignEventService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _campaignEventService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.CampaignEvent> getCampaignEvents(
		long campaignId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _campaignEventService.getCampaignEvents(campaignId,
			serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.CampaignEvent> getEventCampaigns(
		long eventId, com.liferay.portal.service.ServiceContext serviceContext) {
		return _campaignEventService.getEventCampaigns(eventId, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getEventCampaignImages(
		java.lang.String eventIdList,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _campaignEventService.getEventCampaignImages(eventIdList,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CampaignEventService getWrappedCampaignEventService() {
		return _campaignEventService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCampaignEventService(
		CampaignEventService campaignEventService) {
		_campaignEventService = campaignEventService;
	}

	@Override
	public CampaignEventService getWrappedService() {
		return _campaignEventService;
	}

	@Override
	public void setWrappedService(CampaignEventService campaignEventService) {
		_campaignEventService = campaignEventService;
	}

	private CampaignEventService _campaignEventService;
}