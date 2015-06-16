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
 * Provides a wrapper for {@link InfoTypeService}.
 *
 * @author Ashutosh Rai
 * @see InfoTypeService
 * @generated
 */
public class InfoTypeServiceWrapper implements InfoTypeService,
	ServiceWrapper<InfoTypeService> {
	public InfoTypeServiceWrapper(InfoTypeService infoTypeService) {
		_infoTypeService = infoTypeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _infoTypeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_infoTypeService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _infoTypeService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.InfoType> getInfoTypes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _infoTypeService.getInfoTypes(serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.InfoType getInfoType(
		long infoTypeId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _infoTypeService.getInfoType(infoTypeId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public InfoTypeService getWrappedInfoTypeService() {
		return _infoTypeService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedInfoTypeService(InfoTypeService infoTypeService) {
		_infoTypeService = infoTypeService;
	}

	@Override
	public InfoTypeService getWrappedService() {
		return _infoTypeService;
	}

	@Override
	public void setWrappedService(InfoTypeService infoTypeService) {
		_infoTypeService = infoTypeService;
	}

	private InfoTypeService _infoTypeService;
}