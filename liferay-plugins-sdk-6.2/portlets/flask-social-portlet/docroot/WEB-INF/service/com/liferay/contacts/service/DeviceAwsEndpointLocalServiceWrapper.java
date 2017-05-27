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
 * Provides a wrapper for {@link DeviceAwsEndpointLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see DeviceAwsEndpointLocalService
 * @generated
 */
public class DeviceAwsEndpointLocalServiceWrapper
	implements DeviceAwsEndpointLocalService,
		ServiceWrapper<DeviceAwsEndpointLocalService> {
	public DeviceAwsEndpointLocalServiceWrapper(
		DeviceAwsEndpointLocalService deviceAwsEndpointLocalService) {
		_deviceAwsEndpointLocalService = deviceAwsEndpointLocalService;
	}

	/**
	* Adds the device aws endpoint to the database. Also notifies the appropriate model listeners.
	*
	* @param deviceAwsEndpoint the device aws endpoint
	* @return the device aws endpoint that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.DeviceAwsEndpoint addDeviceAwsEndpoint(
		com.liferay.contacts.model.DeviceAwsEndpoint deviceAwsEndpoint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deviceAwsEndpointLocalService.addDeviceAwsEndpoint(deviceAwsEndpoint);
	}

	/**
	* Creates a new device aws endpoint with the primary key. Does not add the device aws endpoint to the database.
	*
	* @param deviceEndPointId the primary key for the new device aws endpoint
	* @return the new device aws endpoint
	*/
	@Override
	public com.liferay.contacts.model.DeviceAwsEndpoint createDeviceAwsEndpoint(
		long deviceEndPointId) {
		return _deviceAwsEndpointLocalService.createDeviceAwsEndpoint(deviceEndPointId);
	}

	/**
	* Deletes the device aws endpoint with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param deviceEndPointId the primary key of the device aws endpoint
	* @return the device aws endpoint that was removed
	* @throws PortalException if a device aws endpoint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.DeviceAwsEndpoint deleteDeviceAwsEndpoint(
		long deviceEndPointId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _deviceAwsEndpointLocalService.deleteDeviceAwsEndpoint(deviceEndPointId);
	}

	/**
	* Deletes the device aws endpoint from the database. Also notifies the appropriate model listeners.
	*
	* @param deviceAwsEndpoint the device aws endpoint
	* @return the device aws endpoint that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.DeviceAwsEndpoint deleteDeviceAwsEndpoint(
		com.liferay.contacts.model.DeviceAwsEndpoint deviceAwsEndpoint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deviceAwsEndpointLocalService.deleteDeviceAwsEndpoint(deviceAwsEndpoint);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _deviceAwsEndpointLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deviceAwsEndpointLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.DeviceAwsEndpointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _deviceAwsEndpointLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.DeviceAwsEndpointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deviceAwsEndpointLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deviceAwsEndpointLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deviceAwsEndpointLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.contacts.model.DeviceAwsEndpoint fetchDeviceAwsEndpoint(
		long deviceEndPointId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deviceAwsEndpointLocalService.fetchDeviceAwsEndpoint(deviceEndPointId);
	}

	/**
	* Returns the device aws endpoint with the primary key.
	*
	* @param deviceEndPointId the primary key of the device aws endpoint
	* @return the device aws endpoint
	* @throws PortalException if a device aws endpoint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.DeviceAwsEndpoint getDeviceAwsEndpoint(
		long deviceEndPointId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _deviceAwsEndpointLocalService.getDeviceAwsEndpoint(deviceEndPointId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _deviceAwsEndpointLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the device aws endpoints.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.DeviceAwsEndpointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of device aws endpoints
	* @param end the upper bound of the range of device aws endpoints (not inclusive)
	* @return the range of device aws endpoints
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.contacts.model.DeviceAwsEndpoint> getDeviceAwsEndpoints(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deviceAwsEndpointLocalService.getDeviceAwsEndpoints(start, end);
	}

	/**
	* Returns the number of device aws endpoints.
	*
	* @return the number of device aws endpoints
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDeviceAwsEndpointsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deviceAwsEndpointLocalService.getDeviceAwsEndpointsCount();
	}

	/**
	* Updates the device aws endpoint in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param deviceAwsEndpoint the device aws endpoint
	* @return the device aws endpoint that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.DeviceAwsEndpoint updateDeviceAwsEndpoint(
		com.liferay.contacts.model.DeviceAwsEndpoint deviceAwsEndpoint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _deviceAwsEndpointLocalService.updateDeviceAwsEndpoint(deviceAwsEndpoint);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _deviceAwsEndpointLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_deviceAwsEndpointLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _deviceAwsEndpointLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DeviceAwsEndpointLocalService getWrappedDeviceAwsEndpointLocalService() {
		return _deviceAwsEndpointLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDeviceAwsEndpointLocalService(
		DeviceAwsEndpointLocalService deviceAwsEndpointLocalService) {
		_deviceAwsEndpointLocalService = deviceAwsEndpointLocalService;
	}

	@Override
	public DeviceAwsEndpointLocalService getWrappedService() {
		return _deviceAwsEndpointLocalService;
	}

	@Override
	public void setWrappedService(
		DeviceAwsEndpointLocalService deviceAwsEndpointLocalService) {
		_deviceAwsEndpointLocalService = deviceAwsEndpointLocalService;
	}

	private DeviceAwsEndpointLocalService _deviceAwsEndpointLocalService;
}