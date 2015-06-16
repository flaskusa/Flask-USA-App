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
 * Provides a wrapper for {@link InfoTypeCategoryService}.
 *
 * @author Ashutosh Rai
 * @see InfoTypeCategoryService
 * @generated
 */
public class InfoTypeCategoryServiceWrapper implements InfoTypeCategoryService,
	ServiceWrapper<InfoTypeCategoryService> {
	public InfoTypeCategoryServiceWrapper(
		InfoTypeCategoryService infoTypeCategoryService) {
		_infoTypeCategoryService = infoTypeCategoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _infoTypeCategoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_infoTypeCategoryService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _infoTypeCategoryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.InfoTypeCategory> getInfoTypeCategories(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _infoTypeCategoryService.getInfoTypeCategories(serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.InfoTypeCategory getInfoTypeCategory(
		long InfoTypeCategoryId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _infoTypeCategoryService.getInfoTypeCategory(InfoTypeCategoryId,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public InfoTypeCategoryService getWrappedInfoTypeCategoryService() {
		return _infoTypeCategoryService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedInfoTypeCategoryService(
		InfoTypeCategoryService infoTypeCategoryService) {
		_infoTypeCategoryService = infoTypeCategoryService;
	}

	@Override
	public InfoTypeCategoryService getWrappedService() {
		return _infoTypeCategoryService;
	}

	@Override
	public void setWrappedService(
		InfoTypeCategoryService infoTypeCategoryService) {
		_infoTypeCategoryService = infoTypeCategoryService;
	}

	private InfoTypeCategoryService _infoTypeCategoryService;
}