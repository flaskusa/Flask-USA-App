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
 * Provides a wrapper for {@link FlaskAdminService}.
 *
 * @author Ashutosh Rai
 * @see FlaskAdminService
 * @generated
 */
public class FlaskAdminServiceWrapper implements FlaskAdminService,
	ServiceWrapper<FlaskAdminService> {
	public FlaskAdminServiceWrapper(FlaskAdminService flaskAdminService) {
		_flaskAdminService = flaskAdminService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _flaskAdminService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_flaskAdminService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _flaskAdminService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> getFlaskAdmins() {
		return _flaskAdminService.getFlaskAdmins();
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> getFlaskContentManagers() {
		return _flaskAdminService.getFlaskContentManagers();
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskAdmin addFlaskAdmin(
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskAdminService.addFlaskAdmin(firstName, middleName,
			lastName, email, screenName, password1, password2, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskAdmin updateFlaskAdmin(
		long userId, java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskAdminService.updateFlaskAdmin(userId, firstName,
			middleName, lastName, email, screenName, password1, password2,
			serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskAdmin addFlaskContentManager(
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskAdminService.addFlaskContentManager(firstName, middleName,
			lastName, email, screenName, password1, password2, serviceContext);
	}

	/**
	* Update content managers
	*/
	@Override
	public com.rumbasolutions.flask.model.FlaskAdmin updateFlaskContentManager(
		long userId, java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskAdminService.updateFlaskContentManager(userId, firstName,
			middleName, lastName, email, screenName, password1, password2,
			serviceContext);
	}

	@Override
	public void deleteFlaskAdmins(long userId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_flaskAdminService.deleteFlaskAdmins(userId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FlaskAdminService getWrappedFlaskAdminService() {
		return _flaskAdminService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFlaskAdminService(FlaskAdminService flaskAdminService) {
		_flaskAdminService = flaskAdminService;
	}

	@Override
	public FlaskAdminService getWrappedService() {
		return _flaskAdminService;
	}

	@Override
	public void setWrappedService(FlaskAdminService flaskAdminService) {
		_flaskAdminService = flaskAdminService;
	}

	private FlaskAdminService _flaskAdminService;
}