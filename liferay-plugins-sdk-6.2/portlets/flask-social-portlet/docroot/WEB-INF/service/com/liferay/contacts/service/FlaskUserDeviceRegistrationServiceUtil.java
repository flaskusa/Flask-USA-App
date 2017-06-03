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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for FlaskUserDeviceRegistration. This utility wraps
 * {@link com.liferay.contacts.service.impl.FlaskUserDeviceRegistrationServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskUserDeviceRegistrationService
 * @see com.liferay.contacts.service.base.FlaskUserDeviceRegistrationServiceBaseImpl
 * @see com.liferay.contacts.service.impl.FlaskUserDeviceRegistrationServiceImpl
 * @generated
 */
public class FlaskUserDeviceRegistrationServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.contacts.service.impl.FlaskUserDeviceRegistrationServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.contacts.model.FlaskUserDeviceRegistration addUserDevice(
		long userId, java.lang.String userEmail,
		java.lang.String devicePlatform, java.lang.String deviceDetails,
		java.lang.String deviceToken, java.util.Date registrationTime,
		java.lang.Boolean active, java.util.Date lastNotificationTime,
		java.lang.String lastNotificationMsg,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addUserDevice(userId, userEmail, devicePlatform,
			deviceDetails, deviceToken, registrationTime, active,
			lastNotificationTime, lastNotificationMsg, serviceContext);
	}

	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> getAllUserDevices() {
		return getService().getAllUserDevices();
	}

	public static com.liferay.contacts.model.FlaskUserDeviceRegistration getUserDevice(
		long userDeviceRegistrationId) {
		return getService().getUserDevice(userDeviceRegistrationId);
	}

	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> getUserDevicesByUserId(
		long userId) {
		return getService().getUserDevicesByUserId(userId);
	}

	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> getUserDevicesByUserEmail(
		java.lang.String userEmail) {
		return getService().getUserDevicesByUserEmail(userEmail);
	}

	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> getUserDevicesByDeviceToken(
		java.lang.String deviceToken) {
		return getService().getUserDevicesByDeviceToken(deviceToken);
	}

	public static com.liferay.contacts.model.FlaskUserDeviceRegistration updateUserDevices(
		long userDeviceRegistrationId, long userId, java.lang.String userEmail,
		java.lang.String devicePlatform, java.lang.String deviceDetails,
		java.lang.String deviceToken, java.util.Date registrationTime,
		java.lang.Boolean active, java.util.Date lastNotificationTime,
		java.lang.String lastNotificationMsg,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateUserDevices(userDeviceRegistrationId, userId,
			userEmail, devicePlatform, deviceDetails, deviceToken,
			registrationTime, active, lastNotificationTime,
			lastNotificationMsg, serviceContext);
	}

	public static void deleteUserDevice(long userDeviceRegistrationId) {
		getService().deleteUserDevice(userDeviceRegistrationId);
	}

	public static boolean deactivateUserForUserDevice(long userId,
		java.lang.String deviceToken) {
		return getService().deactivateUserForUserDevice(userId, deviceToken);
	}

	public static boolean activateUserForUserDevice(
		long userDeviceRegistrationId) {
		return getService().activateUserForUserDevice(userDeviceRegistrationId);
	}

	public static void clearService() {
		_service = null;
	}

	public static FlaskUserDeviceRegistrationService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FlaskUserDeviceRegistrationService.class.getName());

			if (invokableService instanceof FlaskUserDeviceRegistrationService) {
				_service = (FlaskUserDeviceRegistrationService)invokableService;
			}
			else {
				_service = new FlaskUserDeviceRegistrationServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(FlaskUserDeviceRegistrationServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FlaskUserDeviceRegistrationService service) {
	}

	private static FlaskUserDeviceRegistrationService _service;
}