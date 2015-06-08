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
	public java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> getFlaskAdmins(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskAdminService.getFlaskAdmins(serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> getFlaskContentManagers(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskAdminService.getFlaskContentManagers(serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> getAllUsers(
		java.lang.String userType,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskAdminService.getAllUsers(userType, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskAdmin addFlaskAdmin(
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.lang.String DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city, long stateId,
		long countryId, java.lang.String mobileNumber,
		java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskAdminService.addFlaskAdmin(firstName, middleName,
			lastName, email, screenName, password1, password2, DOB, isMale,
			streetName, aptNo, areaCode, city, stateId, countryId,
			mobileNumber, userInterests, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskAdmin updateFlaskAdmin(
		long userId, java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.lang.String DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city, long stateId,
		long countryId, java.lang.String mobileNumber,
		java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskAdminService.updateFlaskAdmin(userId, firstName,
			middleName, lastName, email, screenName, password1, password2, DOB,
			isMale, streetName, aptNo, areaCode, city, stateId, countryId,
			mobileNumber, userInterests, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskAdmin addFlaskContentManager(
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.lang.String DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city, long stateId,
		long countryId, java.lang.String mobileNumber,
		java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskAdminService.addFlaskContentManager(firstName, middleName,
			lastName, email, screenName, password1, password2, DOB, isMale,
			streetName, aptNo, areaCode, city, stateId, countryId,
			mobileNumber, userInterests, serviceContext);
	}

	/**
	* Update content managers
	*/
	@Override
	public com.rumbasolutions.flask.model.FlaskAdmin updateFlaskContentManager(
		long userId, java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.lang.String DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city, long state,
		long country, java.lang.String mobileNumber,
		java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskAdminService.updateFlaskContentManager(userId, firstName,
			middleName, lastName, email, screenName, password1, password2, DOB,
			isMale, streetName, aptNo, areaCode, city, state, country,
			mobileNumber, userInterests, serviceContext);
	}

	@Override
	public void deleteFlaskAdmins(long userId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_flaskAdminService.deleteFlaskAdmins(userId, serviceContext);
	}

	/**
	* Returns valid user id if user found else 0. -1 when there is unknown system exception
	*/
	@Override
	public long getUserIdForScreenName(java.lang.String screenName,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskAdminService.getUserIdForScreenName(screenName,
			serviceContext);
	}

	/**
	* Returns valid user id if user found else 0. -1 when there is unknown system exception
	*/
	@Override
	public long getUserIdForEmail(java.lang.String emailAddress,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskAdminService.getUserIdForEmail(emailAddress, serviceContext);
	}

	/**
	* Returns valid user id if user found else 0. -1 when there is unknown system exception
	*/
	@Override
	public com.rumbasolutions.flask.model.FlaskAdmin getUserById(long userId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskAdminService.getUserById(userId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskAdmin addFlaskUser(
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.lang.String DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city, long stateId,
		long countryId, java.lang.String mobileNumber,
		java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskAdminService.addFlaskUser(firstName, middleName, lastName,
			email, screenName, password1, password2, DOB, isMale, streetName,
			aptNo, areaCode, city, stateId, countryId, mobileNumber,
			userInterests, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskAdmin updateLoggedInUser(
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.lang.String DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city, long stateId,
		long countryId, java.lang.String mobileNumber,
		java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskAdminService.updateLoggedInUser(firstName, middleName,
			lastName, email, screenName, password1, password2, DOB, isMale,
			streetName, aptNo, areaCode, city, stateId, countryId,
			mobileNumber, userInterests, serviceContext);
	}

	@Override
	public com.liferay.portal.model.Country getCountryByName(
		java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskAdminService.getCountryByName(name, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.portal.model.Country> getCountries(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskAdminService.getCountries(serviceContext);
	}

	@Override
	public java.util.List<com.liferay.portal.model.Region> getRegion(
		long countryId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskAdminService.getRegion(countryId, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.portal.model.Region> getUSARegions(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskAdminService.getUSARegions(serviceContext);
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