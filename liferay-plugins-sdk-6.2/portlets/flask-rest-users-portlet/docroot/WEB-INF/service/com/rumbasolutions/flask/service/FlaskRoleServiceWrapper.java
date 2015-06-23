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
 * Provides a wrapper for {@link FlaskRoleService}.
 *
 * @author Ashutosh Rai
 * @see FlaskRoleService
 * @generated
 */
public class FlaskRoleServiceWrapper implements FlaskRoleService,
	ServiceWrapper<FlaskRoleService> {
	public FlaskRoleServiceWrapper(FlaskRoleService flaskRoleService) {
		_flaskRoleService = flaskRoleService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _flaskRoleService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_flaskRoleService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _flaskRoleService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.FlaskRole> getFlaskRoles() {
		return _flaskRoleService.getFlaskRoles();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FlaskRoleService getWrappedFlaskRoleService() {
		return _flaskRoleService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFlaskRoleService(FlaskRoleService flaskRoleService) {
		_flaskRoleService = flaskRoleService;
	}

	@Override
	public FlaskRoleService getWrappedService() {
		return _flaskRoleService;
	}

	@Override
	public void setWrappedService(FlaskRoleService flaskRoleService) {
		_flaskRoleService = flaskRoleService;
	}

	private FlaskRoleService _flaskRoleService;
}