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

package com.liferay.contacts.service.persistence;

import com.liferay.contacts.model.DeviceAwsEndpoint;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the device aws endpoint service. This utility wraps {@link DeviceAwsEndpointPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DeviceAwsEndpointPersistence
 * @see DeviceAwsEndpointPersistenceImpl
 * @generated
 */
public class DeviceAwsEndpointUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(DeviceAwsEndpoint deviceAwsEndpoint) {
		getPersistence().clearCache(deviceAwsEndpoint);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DeviceAwsEndpoint> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DeviceAwsEndpoint> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DeviceAwsEndpoint> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DeviceAwsEndpoint update(DeviceAwsEndpoint deviceAwsEndpoint)
		throws SystemException {
		return getPersistence().update(deviceAwsEndpoint);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DeviceAwsEndpoint update(
		DeviceAwsEndpoint deviceAwsEndpoint, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(deviceAwsEndpoint, serviceContext);
	}

	/**
	* Returns all the device aws endpoints where userDeviceRegistrationId = &#63;.
	*
	* @param userDeviceRegistrationId the user device registration ID
	* @return the matching device aws endpoints
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.DeviceAwsEndpoint> findByendpointsByRegistrationId(
		long userDeviceRegistrationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByendpointsByRegistrationId(userDeviceRegistrationId);
	}

	/**
	* Returns a range of all the device aws endpoints where userDeviceRegistrationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.DeviceAwsEndpointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userDeviceRegistrationId the user device registration ID
	* @param start the lower bound of the range of device aws endpoints
	* @param end the upper bound of the range of device aws endpoints (not inclusive)
	* @return the range of matching device aws endpoints
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.DeviceAwsEndpoint> findByendpointsByRegistrationId(
		long userDeviceRegistrationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByendpointsByRegistrationId(userDeviceRegistrationId,
			start, end);
	}

	/**
	* Returns an ordered range of all the device aws endpoints where userDeviceRegistrationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.DeviceAwsEndpointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userDeviceRegistrationId the user device registration ID
	* @param start the lower bound of the range of device aws endpoints
	* @param end the upper bound of the range of device aws endpoints (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching device aws endpoints
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.DeviceAwsEndpoint> findByendpointsByRegistrationId(
		long userDeviceRegistrationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByendpointsByRegistrationId(userDeviceRegistrationId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first device aws endpoint in the ordered set where userDeviceRegistrationId = &#63;.
	*
	* @param userDeviceRegistrationId the user device registration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching device aws endpoint
	* @throws com.liferay.contacts.NoSuchDeviceAwsEndpointException if a matching device aws endpoint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.DeviceAwsEndpoint findByendpointsByRegistrationId_First(
		long userDeviceRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchDeviceAwsEndpointException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByendpointsByRegistrationId_First(userDeviceRegistrationId,
			orderByComparator);
	}

	/**
	* Returns the first device aws endpoint in the ordered set where userDeviceRegistrationId = &#63;.
	*
	* @param userDeviceRegistrationId the user device registration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching device aws endpoint, or <code>null</code> if a matching device aws endpoint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.DeviceAwsEndpoint fetchByendpointsByRegistrationId_First(
		long userDeviceRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByendpointsByRegistrationId_First(userDeviceRegistrationId,
			orderByComparator);
	}

	/**
	* Returns the last device aws endpoint in the ordered set where userDeviceRegistrationId = &#63;.
	*
	* @param userDeviceRegistrationId the user device registration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching device aws endpoint
	* @throws com.liferay.contacts.NoSuchDeviceAwsEndpointException if a matching device aws endpoint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.DeviceAwsEndpoint findByendpointsByRegistrationId_Last(
		long userDeviceRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchDeviceAwsEndpointException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByendpointsByRegistrationId_Last(userDeviceRegistrationId,
			orderByComparator);
	}

	/**
	* Returns the last device aws endpoint in the ordered set where userDeviceRegistrationId = &#63;.
	*
	* @param userDeviceRegistrationId the user device registration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching device aws endpoint, or <code>null</code> if a matching device aws endpoint could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.DeviceAwsEndpoint fetchByendpointsByRegistrationId_Last(
		long userDeviceRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByendpointsByRegistrationId_Last(userDeviceRegistrationId,
			orderByComparator);
	}

	/**
	* Returns the device aws endpoints before and after the current device aws endpoint in the ordered set where userDeviceRegistrationId = &#63;.
	*
	* @param deviceEndPointId the primary key of the current device aws endpoint
	* @param userDeviceRegistrationId the user device registration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next device aws endpoint
	* @throws com.liferay.contacts.NoSuchDeviceAwsEndpointException if a device aws endpoint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.DeviceAwsEndpoint[] findByendpointsByRegistrationId_PrevAndNext(
		long deviceEndPointId, long userDeviceRegistrationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchDeviceAwsEndpointException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByendpointsByRegistrationId_PrevAndNext(deviceEndPointId,
			userDeviceRegistrationId, orderByComparator);
	}

	/**
	* Removes all the device aws endpoints where userDeviceRegistrationId = &#63; from the database.
	*
	* @param userDeviceRegistrationId the user device registration ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByendpointsByRegistrationId(
		long userDeviceRegistrationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByendpointsByRegistrationId(userDeviceRegistrationId);
	}

	/**
	* Returns the number of device aws endpoints where userDeviceRegistrationId = &#63;.
	*
	* @param userDeviceRegistrationId the user device registration ID
	* @return the number of matching device aws endpoints
	* @throws SystemException if a system exception occurred
	*/
	public static int countByendpointsByRegistrationId(
		long userDeviceRegistrationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByendpointsByRegistrationId(userDeviceRegistrationId);
	}

	/**
	* Caches the device aws endpoint in the entity cache if it is enabled.
	*
	* @param deviceAwsEndpoint the device aws endpoint
	*/
	public static void cacheResult(
		com.liferay.contacts.model.DeviceAwsEndpoint deviceAwsEndpoint) {
		getPersistence().cacheResult(deviceAwsEndpoint);
	}

	/**
	* Caches the device aws endpoints in the entity cache if it is enabled.
	*
	* @param deviceAwsEndpoints the device aws endpoints
	*/
	public static void cacheResult(
		java.util.List<com.liferay.contacts.model.DeviceAwsEndpoint> deviceAwsEndpoints) {
		getPersistence().cacheResult(deviceAwsEndpoints);
	}

	/**
	* Creates a new device aws endpoint with the primary key. Does not add the device aws endpoint to the database.
	*
	* @param deviceEndPointId the primary key for the new device aws endpoint
	* @return the new device aws endpoint
	*/
	public static com.liferay.contacts.model.DeviceAwsEndpoint create(
		long deviceEndPointId) {
		return getPersistence().create(deviceEndPointId);
	}

	/**
	* Removes the device aws endpoint with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param deviceEndPointId the primary key of the device aws endpoint
	* @return the device aws endpoint that was removed
	* @throws com.liferay.contacts.NoSuchDeviceAwsEndpointException if a device aws endpoint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.DeviceAwsEndpoint remove(
		long deviceEndPointId)
		throws com.liferay.contacts.NoSuchDeviceAwsEndpointException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(deviceEndPointId);
	}

	public static com.liferay.contacts.model.DeviceAwsEndpoint updateImpl(
		com.liferay.contacts.model.DeviceAwsEndpoint deviceAwsEndpoint)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(deviceAwsEndpoint);
	}

	/**
	* Returns the device aws endpoint with the primary key or throws a {@link com.liferay.contacts.NoSuchDeviceAwsEndpointException} if it could not be found.
	*
	* @param deviceEndPointId the primary key of the device aws endpoint
	* @return the device aws endpoint
	* @throws com.liferay.contacts.NoSuchDeviceAwsEndpointException if a device aws endpoint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.DeviceAwsEndpoint findByPrimaryKey(
		long deviceEndPointId)
		throws com.liferay.contacts.NoSuchDeviceAwsEndpointException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(deviceEndPointId);
	}

	/**
	* Returns the device aws endpoint with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param deviceEndPointId the primary key of the device aws endpoint
	* @return the device aws endpoint, or <code>null</code> if a device aws endpoint with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.DeviceAwsEndpoint fetchByPrimaryKey(
		long deviceEndPointId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(deviceEndPointId);
	}

	/**
	* Returns all the device aws endpoints.
	*
	* @return the device aws endpoints
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.DeviceAwsEndpoint> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.contacts.model.DeviceAwsEndpoint> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the device aws endpoints.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.DeviceAwsEndpointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of device aws endpoints
	* @param end the upper bound of the range of device aws endpoints (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of device aws endpoints
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.DeviceAwsEndpoint> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the device aws endpoints from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of device aws endpoints.
	*
	* @return the number of device aws endpoints
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DeviceAwsEndpointPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DeviceAwsEndpointPersistence)PortletBeanLocatorUtil.locate(com.liferay.contacts.service.ClpSerializer.getServletContextName(),
					DeviceAwsEndpointPersistence.class.getName());

			ReferenceRegistry.registerReference(DeviceAwsEndpointUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DeviceAwsEndpointPersistence persistence) {
	}

	private static DeviceAwsEndpointPersistence _persistence;
}