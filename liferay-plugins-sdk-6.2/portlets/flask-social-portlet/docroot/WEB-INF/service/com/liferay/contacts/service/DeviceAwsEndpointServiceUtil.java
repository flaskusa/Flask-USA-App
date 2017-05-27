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
 * Provides the remote service utility for DeviceAwsEndpoint. This utility wraps
 * {@link com.liferay.contacts.service.impl.DeviceAwsEndpointServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DeviceAwsEndpointService
 * @see com.liferay.contacts.service.base.DeviceAwsEndpointServiceBaseImpl
 * @see com.liferay.contacts.service.impl.DeviceAwsEndpointServiceImpl
 * @generated
 */
public class DeviceAwsEndpointServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.contacts.service.impl.DeviceAwsEndpointServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.contacts.model.DeviceAwsEndpoint addDeviceAwsEndpoint(
		java.lang.String awsEndpoint, long userDeviceRegistrationId) {
		return getService()
				   .addDeviceAwsEndpoint(awsEndpoint, userDeviceRegistrationId);
	}

	public static java.util.List<com.liferay.contacts.model.DeviceAwsEndpoint> getAllDeviceAwsEndpoint() {
		return getService().getAllDeviceAwsEndpoint();
	}

	public static com.liferay.contacts.model.DeviceAwsEndpoint getDeviceAwsEndpoint(
		long deviceEndPointId) {
		return getService().getDeviceAwsEndpoint(deviceEndPointId);
	}

	public static java.util.List<com.liferay.contacts.model.DeviceAwsEndpoint> getAllDeviceAwsEndpointsByUserDeviceRegistrationId(
		long userDeviceRegistrationId) {
		return getService()
				   .getAllDeviceAwsEndpointsByUserDeviceRegistrationId(userDeviceRegistrationId);
	}

	public static com.liferay.contacts.model.DeviceAwsEndpoint updateDeviceAwsEndpoint(
		long deviceEndPointId, java.lang.String awsEndpoint,
		long userDeviceRegistrationId) {
		return getService()
				   .updateDeviceAwsEndpoint(deviceEndPointId, awsEndpoint,
			userDeviceRegistrationId);
	}

	public static void deleteDeviceAwsEndpoint(long deviceEndPointId) {
		getService().deleteDeviceAwsEndpoint(deviceEndPointId);
	}

	public static void clearService() {
		_service = null;
	}

	public static DeviceAwsEndpointService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DeviceAwsEndpointService.class.getName());

			if (invokableService instanceof DeviceAwsEndpointService) {
				_service = (DeviceAwsEndpointService)invokableService;
			}
			else {
				_service = new DeviceAwsEndpointServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(DeviceAwsEndpointServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(DeviceAwsEndpointService service) {
	}

	private static DeviceAwsEndpointService _service;
}