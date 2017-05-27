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
 * Provides a wrapper for {@link DeviceAwsEndpointService}.
 *
 * @author Brian Wing Shun Chan
 * @see DeviceAwsEndpointService
 * @generated
 */
public class DeviceAwsEndpointServiceWrapper implements DeviceAwsEndpointService,
	ServiceWrapper<DeviceAwsEndpointService> {
	public DeviceAwsEndpointServiceWrapper(
		DeviceAwsEndpointService deviceAwsEndpointService) {
		_deviceAwsEndpointService = deviceAwsEndpointService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _deviceAwsEndpointService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_deviceAwsEndpointService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _deviceAwsEndpointService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.contacts.model.DeviceAwsEndpoint addDeviceAwsEndpoint(
		java.lang.String awsEndpoint, long userDeviceRegistrationId) {
		return _deviceAwsEndpointService.addDeviceAwsEndpoint(awsEndpoint,
			userDeviceRegistrationId);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.DeviceAwsEndpoint> getAllDeviceAwsEndpoint() {
		return _deviceAwsEndpointService.getAllDeviceAwsEndpoint();
	}

	@Override
	public com.liferay.contacts.model.DeviceAwsEndpoint getDeviceAwsEndpoint(
		long deviceEndPointId) {
		return _deviceAwsEndpointService.getDeviceAwsEndpoint(deviceEndPointId);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.DeviceAwsEndpoint> getAllDeviceAwsEndpointsByUserDeviceRegistrationId(
		long userDeviceRegistrationId) {
		return _deviceAwsEndpointService.getAllDeviceAwsEndpointsByUserDeviceRegistrationId(userDeviceRegistrationId);
	}

	@Override
	public com.liferay.contacts.model.DeviceAwsEndpoint updateDeviceAwsEndpoint(
		long deviceEndPointId, java.lang.String awsEndpoint,
		long userDeviceRegistrationId) {
		return _deviceAwsEndpointService.updateDeviceAwsEndpoint(deviceEndPointId,
			awsEndpoint, userDeviceRegistrationId);
	}

	@Override
	public void deleteDeviceAwsEndpoint(long deviceEndPointId) {
		_deviceAwsEndpointService.deleteDeviceAwsEndpoint(deviceEndPointId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DeviceAwsEndpointService getWrappedDeviceAwsEndpointService() {
		return _deviceAwsEndpointService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDeviceAwsEndpointService(
		DeviceAwsEndpointService deviceAwsEndpointService) {
		_deviceAwsEndpointService = deviceAwsEndpointService;
	}

	@Override
	public DeviceAwsEndpointService getWrappedService() {
		return _deviceAwsEndpointService;
	}

	@Override
	public void setWrappedService(
		DeviceAwsEndpointService deviceAwsEndpointService) {
		_deviceAwsEndpointService = deviceAwsEndpointService;
	}

	private DeviceAwsEndpointService _deviceAwsEndpointService;
}