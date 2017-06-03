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

package com.liferay.contacts.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FlaskUserDeviceRegistrationService}.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskUserDeviceRegistrationService
 * @generated
 */
public class FlaskUserDeviceRegistrationServiceWrapper
	implements FlaskUserDeviceRegistrationService,
		ServiceWrapper<FlaskUserDeviceRegistrationService> {
	public FlaskUserDeviceRegistrationServiceWrapper(
		FlaskUserDeviceRegistrationService flaskUserDeviceRegistrationService) {
		_flaskUserDeviceRegistrationService = flaskUserDeviceRegistrationService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _flaskUserDeviceRegistrationService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_flaskUserDeviceRegistrationService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _flaskUserDeviceRegistrationService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.liferay.contacts.model.FlaskUserDeviceRegistration addUserDevice(
		long userId, java.lang.String userEmail,
		java.lang.String devicePlatform, java.lang.String deviceDetails,
		java.lang.String deviceToken, java.util.Date registrationTime,
		java.lang.Boolean active, java.util.Date lastNotificationTime,
		java.lang.String lastNotificationMsg,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskUserDeviceRegistrationService.addUserDevice(userId,
			userEmail, devicePlatform, deviceDetails, deviceToken,
			registrationTime, active, lastNotificationTime,
			lastNotificationMsg, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> getAllUserDevices() {
		return _flaskUserDeviceRegistrationService.getAllUserDevices();
	}

	@Override
	public com.liferay.contacts.model.FlaskUserDeviceRegistration getUserDevice(
		long userDeviceRegistrationId) {
		return _flaskUserDeviceRegistrationService.getUserDevice(userDeviceRegistrationId);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> getUserDevicesByUserId(
		long userId) {
		return _flaskUserDeviceRegistrationService.getUserDevicesByUserId(userId);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> getUserDevicesByUserEmail(
		java.lang.String userEmail) {
		return _flaskUserDeviceRegistrationService.getUserDevicesByUserEmail(userEmail);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> getUserDevicesByDeviceToken(
		java.lang.String deviceToken) {
		return _flaskUserDeviceRegistrationService.getUserDevicesByDeviceToken(deviceToken);
	}

	@Override
	public com.liferay.contacts.model.FlaskUserDeviceRegistration updateUserDevices(
		long userDeviceRegistrationId, long userId, java.lang.String userEmail,
		java.lang.String devicePlatform, java.lang.String deviceDetails,
		java.lang.String deviceToken, java.util.Date registrationTime,
		java.lang.Boolean active, java.util.Date lastNotificationTime,
		java.lang.String lastNotificationMsg,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskUserDeviceRegistrationService.updateUserDevices(userDeviceRegistrationId,
			userId, userEmail, devicePlatform, deviceDetails, deviceToken,
			registrationTime, active, lastNotificationTime,
			lastNotificationMsg, serviceContext);
	}

	@Override
	public void deleteUserDevice(long userDeviceRegistrationId) {
		_flaskUserDeviceRegistrationService.deleteUserDevice(userDeviceRegistrationId);
	}

	@Override
	public boolean deactivateUserForUserDevice(long userId,
		java.lang.String deviceToken) {
		return _flaskUserDeviceRegistrationService.deactivateUserForUserDevice(userId,
			deviceToken);
	}

	@Override
	public boolean activateUserForUserDevice(long userDeviceRegistrationId) {
		return _flaskUserDeviceRegistrationService.activateUserForUserDevice(userDeviceRegistrationId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FlaskUserDeviceRegistrationService getWrappedFlaskUserDeviceRegistrationService() {
		return _flaskUserDeviceRegistrationService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFlaskUserDeviceRegistrationService(
		FlaskUserDeviceRegistrationService flaskUserDeviceRegistrationService) {
		_flaskUserDeviceRegistrationService = flaskUserDeviceRegistrationService;
	}

	@Override
	public FlaskUserDeviceRegistrationService getWrappedService() {
		return _flaskUserDeviceRegistrationService;
	}

	@Override
	public void setWrappedService(
		FlaskUserDeviceRegistrationService flaskUserDeviceRegistrationService) {
		_flaskUserDeviceRegistrationService = flaskUserDeviceRegistrationService;
	}

	private FlaskUserDeviceRegistrationService _flaskUserDeviceRegistrationService;
}