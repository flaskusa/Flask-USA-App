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

package com.rumbasolutions.flask.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rumbasolutions.flask.model.VenueDeviceImage;

import java.util.List;

/**
 * The persistence utility for the venue device image service. This utility wraps {@link VenueDeviceImagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueDeviceImagePersistence
 * @see VenueDeviceImagePersistenceImpl
 * @generated
 */
public class VenueDeviceImageUtil {
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
	public static void clearCache(VenueDeviceImage venueDeviceImage) {
		getPersistence().clearCache(venueDeviceImage);
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
	public static List<VenueDeviceImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VenueDeviceImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VenueDeviceImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VenueDeviceImage update(VenueDeviceImage venueDeviceImage)
		throws SystemException {
		return getPersistence().update(venueDeviceImage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VenueDeviceImage update(VenueDeviceImage venueDeviceImage,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(venueDeviceImage, serviceContext);
	}

	/**
	* Returns all the venue device images where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @return the matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueId(
		long venueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVenueId(venueId);
	}

	/**
	* Returns a range of all the venue device images where venueId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueId the venue ID
	* @param start the lower bound of the range of venue device images
	* @param end the upper bound of the range of venue device images (not inclusive)
	* @return the range of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueId(
		long venueId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVenueId(venueId, start, end);
	}

	/**
	* Returns an ordered range of all the venue device images where venueId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueId the venue ID
	* @param start the lower bound of the range of venue device images
	* @param end the upper bound of the range of venue device images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueId(
		long venueId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVenueId(venueId, start, end, orderByComparator);
	}

	/**
	* Returns the first venue device image in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage findByVenueId_First(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException {
		return getPersistence().findByVenueId_First(venueId, orderByComparator);
	}

	/**
	* Returns the first venue device image in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage fetchByVenueId_First(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVenueId_First(venueId, orderByComparator);
	}

	/**
	* Returns the last venue device image in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage findByVenueId_Last(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException {
		return getPersistence().findByVenueId_Last(venueId, orderByComparator);
	}

	/**
	* Returns the last venue device image in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage fetchByVenueId_Last(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByVenueId_Last(venueId, orderByComparator);
	}

	/**
	* Returns the venue device images before and after the current venue device image in the ordered set where venueId = &#63;.
	*
	* @param venueDeviceImageId the primary key of the current venue device image
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage[] findByVenueId_PrevAndNext(
		long venueDeviceImageId, long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException {
		return getPersistence()
				   .findByVenueId_PrevAndNext(venueDeviceImageId, venueId,
			orderByComparator);
	}

	/**
	* Removes all the venue device images where venueId = &#63; from the database.
	*
	* @param venueId the venue ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVenueId(long venueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVenueId(venueId);
	}

	/**
	* Returns the number of venue device images where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @return the number of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVenueId(long venueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVenueId(venueId);
	}

	/**
	* Returns all the venue device images where deviceType = &#63;.
	*
	* @param deviceType the device type
	* @return the matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByDeviceType(
		java.lang.String deviceType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeviceType(deviceType);
	}

	/**
	* Returns a range of all the venue device images where deviceType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param deviceType the device type
	* @param start the lower bound of the range of venue device images
	* @param end the upper bound of the range of venue device images (not inclusive)
	* @return the range of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByDeviceType(
		java.lang.String deviceType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDeviceType(deviceType, start, end);
	}

	/**
	* Returns an ordered range of all the venue device images where deviceType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param deviceType the device type
	* @param start the lower bound of the range of venue device images
	* @param end the upper bound of the range of venue device images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByDeviceType(
		java.lang.String deviceType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDeviceType(deviceType, start, end, orderByComparator);
	}

	/**
	* Returns the first venue device image in the ordered set where deviceType = &#63;.
	*
	* @param deviceType the device type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage findByDeviceType_First(
		java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException {
		return getPersistence()
				   .findByDeviceType_First(deviceType, orderByComparator);
	}

	/**
	* Returns the first venue device image in the ordered set where deviceType = &#63;.
	*
	* @param deviceType the device type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage fetchByDeviceType_First(
		java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDeviceType_First(deviceType, orderByComparator);
	}

	/**
	* Returns the last venue device image in the ordered set where deviceType = &#63;.
	*
	* @param deviceType the device type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage findByDeviceType_Last(
		java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException {
		return getPersistence()
				   .findByDeviceType_Last(deviceType, orderByComparator);
	}

	/**
	* Returns the last venue device image in the ordered set where deviceType = &#63;.
	*
	* @param deviceType the device type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage fetchByDeviceType_Last(
		java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDeviceType_Last(deviceType, orderByComparator);
	}

	/**
	* Returns the venue device images before and after the current venue device image in the ordered set where deviceType = &#63;.
	*
	* @param venueDeviceImageId the primary key of the current venue device image
	* @param deviceType the device type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage[] findByDeviceType_PrevAndNext(
		long venueDeviceImageId, java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException {
		return getPersistence()
				   .findByDeviceType_PrevAndNext(venueDeviceImageId,
			deviceType, orderByComparator);
	}

	/**
	* Removes all the venue device images where deviceType = &#63; from the database.
	*
	* @param deviceType the device type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDeviceType(java.lang.String deviceType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDeviceType(deviceType);
	}

	/**
	* Returns the number of venue device images where deviceType = &#63;.
	*
	* @param deviceType the device type
	* @return the number of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDeviceType(java.lang.String deviceType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDeviceType(deviceType);
	}

	/**
	* Returns all the venue device images where venueId = &#63; and deviceType = &#63;.
	*
	* @param venueId the venue ID
	* @param deviceType the device type
	* @return the matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueDevice(
		long venueId, java.lang.String deviceType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVenueDevice(venueId, deviceType);
	}

	/**
	* Returns a range of all the venue device images where venueId = &#63; and deviceType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueId the venue ID
	* @param deviceType the device type
	* @param start the lower bound of the range of venue device images
	* @param end the upper bound of the range of venue device images (not inclusive)
	* @return the range of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueDevice(
		long venueId, java.lang.String deviceType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVenueDevice(venueId, deviceType, start, end);
	}

	/**
	* Returns an ordered range of all the venue device images where venueId = &#63; and deviceType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueId the venue ID
	* @param deviceType the device type
	* @param start the lower bound of the range of venue device images
	* @param end the upper bound of the range of venue device images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueDevice(
		long venueId, java.lang.String deviceType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVenueDevice(venueId, deviceType, start, end,
			orderByComparator);
	}

	/**
	* Returns the first venue device image in the ordered set where venueId = &#63; and deviceType = &#63;.
	*
	* @param venueId the venue ID
	* @param deviceType the device type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage findByVenueDevice_First(
		long venueId, java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException {
		return getPersistence()
				   .findByVenueDevice_First(venueId, deviceType,
			orderByComparator);
	}

	/**
	* Returns the first venue device image in the ordered set where venueId = &#63; and deviceType = &#63;.
	*
	* @param venueId the venue ID
	* @param deviceType the device type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage fetchByVenueDevice_First(
		long venueId, java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVenueDevice_First(venueId, deviceType,
			orderByComparator);
	}

	/**
	* Returns the last venue device image in the ordered set where venueId = &#63; and deviceType = &#63;.
	*
	* @param venueId the venue ID
	* @param deviceType the device type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage findByVenueDevice_Last(
		long venueId, java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException {
		return getPersistence()
				   .findByVenueDevice_Last(venueId, deviceType,
			orderByComparator);
	}

	/**
	* Returns the last venue device image in the ordered set where venueId = &#63; and deviceType = &#63;.
	*
	* @param venueId the venue ID
	* @param deviceType the device type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage fetchByVenueDevice_Last(
		long venueId, java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVenueDevice_Last(venueId, deviceType,
			orderByComparator);
	}

	/**
	* Returns the venue device images before and after the current venue device image in the ordered set where venueId = &#63; and deviceType = &#63;.
	*
	* @param venueDeviceImageId the primary key of the current venue device image
	* @param venueId the venue ID
	* @param deviceType the device type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage[] findByVenueDevice_PrevAndNext(
		long venueDeviceImageId, long venueId, java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException {
		return getPersistence()
				   .findByVenueDevice_PrevAndNext(venueDeviceImageId, venueId,
			deviceType, orderByComparator);
	}

	/**
	* Removes all the venue device images where venueId = &#63; and deviceType = &#63; from the database.
	*
	* @param venueId the venue ID
	* @param deviceType the device type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVenueDevice(long venueId,
		java.lang.String deviceType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVenueDevice(venueId, deviceType);
	}

	/**
	* Returns the number of venue device images where venueId = &#63; and deviceType = &#63;.
	*
	* @param venueId the venue ID
	* @param deviceType the device type
	* @return the number of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVenueDevice(long venueId,
		java.lang.String deviceType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVenueDevice(venueId, deviceType);
	}

	/**
	* Returns all the venue device images where venueDetailImageId = &#63;.
	*
	* @param venueDetailImageId the venue detail image ID
	* @return the matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueDetailImageId(
		long venueDetailImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVenueDetailImageId(venueDetailImageId);
	}

	/**
	* Returns a range of all the venue device images where venueDetailImageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueDetailImageId the venue detail image ID
	* @param start the lower bound of the range of venue device images
	* @param end the upper bound of the range of venue device images (not inclusive)
	* @return the range of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueDetailImageId(
		long venueDetailImageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVenueDetailImageId(venueDetailImageId, start, end);
	}

	/**
	* Returns an ordered range of all the venue device images where venueDetailImageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueDetailImageId the venue detail image ID
	* @param start the lower bound of the range of venue device images
	* @param end the upper bound of the range of venue device images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueDetailImageId(
		long venueDetailImageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVenueDetailImageId(venueDetailImageId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first venue device image in the ordered set where venueDetailImageId = &#63;.
	*
	* @param venueDetailImageId the venue detail image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage findByVenueDetailImageId_First(
		long venueDetailImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException {
		return getPersistence()
				   .findByVenueDetailImageId_First(venueDetailImageId,
			orderByComparator);
	}

	/**
	* Returns the first venue device image in the ordered set where venueDetailImageId = &#63;.
	*
	* @param venueDetailImageId the venue detail image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage fetchByVenueDetailImageId_First(
		long venueDetailImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVenueDetailImageId_First(venueDetailImageId,
			orderByComparator);
	}

	/**
	* Returns the last venue device image in the ordered set where venueDetailImageId = &#63;.
	*
	* @param venueDetailImageId the venue detail image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage findByVenueDetailImageId_Last(
		long venueDetailImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException {
		return getPersistence()
				   .findByVenueDetailImageId_Last(venueDetailImageId,
			orderByComparator);
	}

	/**
	* Returns the last venue device image in the ordered set where venueDetailImageId = &#63;.
	*
	* @param venueDetailImageId the venue detail image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage fetchByVenueDetailImageId_Last(
		long venueDetailImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVenueDetailImageId_Last(venueDetailImageId,
			orderByComparator);
	}

	/**
	* Returns the venue device images before and after the current venue device image in the ordered set where venueDetailImageId = &#63;.
	*
	* @param venueDeviceImageId the primary key of the current venue device image
	* @param venueDetailImageId the venue detail image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage[] findByVenueDetailImageId_PrevAndNext(
		long venueDeviceImageId, long venueDetailImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException {
		return getPersistence()
				   .findByVenueDetailImageId_PrevAndNext(venueDeviceImageId,
			venueDetailImageId, orderByComparator);
	}

	/**
	* Removes all the venue device images where venueDetailImageId = &#63; from the database.
	*
	* @param venueDetailImageId the venue detail image ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVenueDetailImageId(long venueDetailImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVenueDetailImageId(venueDetailImageId);
	}

	/**
	* Returns the number of venue device images where venueDetailImageId = &#63;.
	*
	* @param venueDetailImageId the venue detail image ID
	* @return the number of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVenueDetailImageId(long venueDetailImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVenueDetailImageId(venueDetailImageId);
	}

	/**
	* Returns all the venue device images where venueId = &#63; and aspectRatio = &#63;.
	*
	* @param venueId the venue ID
	* @param aspectRatio the aspect ratio
	* @return the matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueRatio(
		long venueId, java.lang.String aspectRatio)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVenueRatio(venueId, aspectRatio);
	}

	/**
	* Returns a range of all the venue device images where venueId = &#63; and aspectRatio = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueId the venue ID
	* @param aspectRatio the aspect ratio
	* @param start the lower bound of the range of venue device images
	* @param end the upper bound of the range of venue device images (not inclusive)
	* @return the range of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueRatio(
		long venueId, java.lang.String aspectRatio, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVenueRatio(venueId, aspectRatio, start, end);
	}

	/**
	* Returns an ordered range of all the venue device images where venueId = &#63; and aspectRatio = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueId the venue ID
	* @param aspectRatio the aspect ratio
	* @param start the lower bound of the range of venue device images
	* @param end the upper bound of the range of venue device images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueRatio(
		long venueId, java.lang.String aspectRatio, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVenueRatio(venueId, aspectRatio, start, end,
			orderByComparator);
	}

	/**
	* Returns the first venue device image in the ordered set where venueId = &#63; and aspectRatio = &#63;.
	*
	* @param venueId the venue ID
	* @param aspectRatio the aspect ratio
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage findByVenueRatio_First(
		long venueId, java.lang.String aspectRatio,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException {
		return getPersistence()
				   .findByVenueRatio_First(venueId, aspectRatio,
			orderByComparator);
	}

	/**
	* Returns the first venue device image in the ordered set where venueId = &#63; and aspectRatio = &#63;.
	*
	* @param venueId the venue ID
	* @param aspectRatio the aspect ratio
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage fetchByVenueRatio_First(
		long venueId, java.lang.String aspectRatio,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVenueRatio_First(venueId, aspectRatio,
			orderByComparator);
	}

	/**
	* Returns the last venue device image in the ordered set where venueId = &#63; and aspectRatio = &#63;.
	*
	* @param venueId the venue ID
	* @param aspectRatio the aspect ratio
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage findByVenueRatio_Last(
		long venueId, java.lang.String aspectRatio,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException {
		return getPersistence()
				   .findByVenueRatio_Last(venueId, aspectRatio,
			orderByComparator);
	}

	/**
	* Returns the last venue device image in the ordered set where venueId = &#63; and aspectRatio = &#63;.
	*
	* @param venueId the venue ID
	* @param aspectRatio the aspect ratio
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage fetchByVenueRatio_Last(
		long venueId, java.lang.String aspectRatio,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVenueRatio_Last(venueId, aspectRatio,
			orderByComparator);
	}

	/**
	* Returns the venue device images before and after the current venue device image in the ordered set where venueId = &#63; and aspectRatio = &#63;.
	*
	* @param venueDeviceImageId the primary key of the current venue device image
	* @param venueId the venue ID
	* @param aspectRatio the aspect ratio
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage[] findByVenueRatio_PrevAndNext(
		long venueDeviceImageId, long venueId, java.lang.String aspectRatio,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException {
		return getPersistence()
				   .findByVenueRatio_PrevAndNext(venueDeviceImageId, venueId,
			aspectRatio, orderByComparator);
	}

	/**
	* Removes all the venue device images where venueId = &#63; and aspectRatio = &#63; from the database.
	*
	* @param venueId the venue ID
	* @param aspectRatio the aspect ratio
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVenueRatio(long venueId,
		java.lang.String aspectRatio)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVenueRatio(venueId, aspectRatio);
	}

	/**
	* Returns the number of venue device images where venueId = &#63; and aspectRatio = &#63;.
	*
	* @param venueId the venue ID
	* @param aspectRatio the aspect ratio
	* @return the number of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVenueRatio(long venueId,
		java.lang.String aspectRatio)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVenueRatio(venueId, aspectRatio);
	}

	/**
	* Caches the venue device image in the entity cache if it is enabled.
	*
	* @param venueDeviceImage the venue device image
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.VenueDeviceImage venueDeviceImage) {
		getPersistence().cacheResult(venueDeviceImage);
	}

	/**
	* Caches the venue device images in the entity cache if it is enabled.
	*
	* @param venueDeviceImages the venue device images
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> venueDeviceImages) {
		getPersistence().cacheResult(venueDeviceImages);
	}

	/**
	* Creates a new venue device image with the primary key. Does not add the venue device image to the database.
	*
	* @param venueDeviceImageId the primary key for the new venue device image
	* @return the new venue device image
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage create(
		long venueDeviceImageId) {
		return getPersistence().create(venueDeviceImageId);
	}

	/**
	* Removes the venue device image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueDeviceImageId the primary key of the venue device image
	* @return the venue device image that was removed
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage remove(
		long venueDeviceImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException {
		return getPersistence().remove(venueDeviceImageId);
	}

	public static com.rumbasolutions.flask.model.VenueDeviceImage updateImpl(
		com.rumbasolutions.flask.model.VenueDeviceImage venueDeviceImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(venueDeviceImage);
	}

	/**
	* Returns the venue device image with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueDeviceImageException} if it could not be found.
	*
	* @param venueDeviceImageId the primary key of the venue device image
	* @return the venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage findByPrimaryKey(
		long venueDeviceImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException {
		return getPersistence().findByPrimaryKey(venueDeviceImageId);
	}

	/**
	* Returns the venue device image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param venueDeviceImageId the primary key of the venue device image
	* @return the venue device image, or <code>null</code> if a venue device image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDeviceImage fetchByPrimaryKey(
		long venueDeviceImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(venueDeviceImageId);
	}

	/**
	* Returns all the venue device images.
	*
	* @return the venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the venue device images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue device images
	* @param end the upper bound of the range of venue device images (not inclusive)
	* @return the range of venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the venue device images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue device images
	* @param end the upper bound of the range of venue device images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the venue device images from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of venue device images.
	*
	* @return the number of venue device images
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VenueDeviceImagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VenueDeviceImagePersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					VenueDeviceImagePersistence.class.getName());

			ReferenceRegistry.registerReference(VenueDeviceImageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VenueDeviceImagePersistence persistence) {
	}

	private static VenueDeviceImagePersistence _persistence;
}