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
 * Provides a wrapper for {@link CampaignImagesService}.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignImagesService
 * @generated
 */
public class CampaignImagesServiceWrapper implements CampaignImagesService,
	ServiceWrapper<CampaignImagesService> {
	public CampaignImagesServiceWrapper(
		CampaignImagesService campaignImagesService) {
		_campaignImagesService = campaignImagesService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _campaignImagesService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_campaignImagesService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _campaignImagesService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CampaignImagesService getWrappedCampaignImagesService() {
		return _campaignImagesService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCampaignImagesService(
		CampaignImagesService campaignImagesService) {
		_campaignImagesService = campaignImagesService;
	}

	@Override
	public CampaignImagesService getWrappedService() {
		return _campaignImagesService;
	}

	@Override
	public void setWrappedService(CampaignImagesService campaignImagesService) {
		_campaignImagesService = campaignImagesService;
	}

	private CampaignImagesService _campaignImagesService;
}