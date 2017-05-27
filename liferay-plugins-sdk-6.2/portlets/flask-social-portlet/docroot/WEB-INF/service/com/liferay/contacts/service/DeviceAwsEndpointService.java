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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for DeviceAwsEndpoint. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DeviceAwsEndpointServiceUtil
 * @see com.liferay.contacts.service.base.DeviceAwsEndpointServiceBaseImpl
 * @see com.liferay.contacts.service.impl.DeviceAwsEndpointServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface DeviceAwsEndpointService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DeviceAwsEndpointServiceUtil} to access the device aws endpoint remote service. Add custom service methods to {@link com.liferay.contacts.service.impl.DeviceAwsEndpointServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public com.liferay.contacts.model.DeviceAwsEndpoint addDeviceAwsEndpoint(
		java.lang.String awsEndpoint, long userDeviceRegistrationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.contacts.model.DeviceAwsEndpoint> getAllDeviceAwsEndpoint();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.contacts.model.DeviceAwsEndpoint getDeviceAwsEndpoint(
		long deviceEndPointId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.contacts.model.DeviceAwsEndpoint> getAllDeviceAwsEndpointsByUserDeviceRegistrationId(
		long userDeviceRegistrationId);

	public com.liferay.contacts.model.DeviceAwsEndpoint updateDeviceAwsEndpoint(
		long deviceEndPointId, java.lang.String awsEndpoint,
		long userDeviceRegistrationId);

	public void deleteDeviceAwsEndpoint(long deviceEndPointId);
}