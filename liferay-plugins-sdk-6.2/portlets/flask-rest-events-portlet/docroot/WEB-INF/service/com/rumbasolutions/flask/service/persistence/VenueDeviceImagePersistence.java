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

import com.liferay.portal.service.persistence.BasePersistence;

import com.rumbasolutions.flask.model.VenueDeviceImage;

/**
 * The persistence interface for the venue device image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueDeviceImagePersistenceImpl
 * @see VenueDeviceImageUtil
 * @generated
 */
public interface VenueDeviceImagePersistence extends BasePersistence<VenueDeviceImage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VenueDeviceImageUtil} to access the venue device image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the venue device images where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @return the matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueId(
		long venueId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueId(
		long venueId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueId(
		long venueId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first venue device image in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage findByVenueId_First(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException;

	/**
	* Returns the first venue device image in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage fetchByVenueId_First(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last venue device image in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage findByVenueId_Last(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException;

	/**
	* Returns the last venue device image in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage fetchByVenueId_Last(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rumbasolutions.flask.model.VenueDeviceImage[] findByVenueId_PrevAndNext(
		long venueDeviceImageId, long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException;

	/**
	* Removes all the venue device images where venueId = &#63; from the database.
	*
	* @param venueId the venue ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVenueId(long venueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of venue device images where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @return the number of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public int countByVenueId(long venueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the venue device images where deviceType = &#63;.
	*
	* @param deviceType the device type
	* @return the matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByDeviceType(
		java.lang.String deviceType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByDeviceType(
		java.lang.String deviceType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByDeviceType(
		java.lang.String deviceType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first venue device image in the ordered set where deviceType = &#63;.
	*
	* @param deviceType the device type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage findByDeviceType_First(
		java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException;

	/**
	* Returns the first venue device image in the ordered set where deviceType = &#63;.
	*
	* @param deviceType the device type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage fetchByDeviceType_First(
		java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last venue device image in the ordered set where deviceType = &#63;.
	*
	* @param deviceType the device type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage findByDeviceType_Last(
		java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException;

	/**
	* Returns the last venue device image in the ordered set where deviceType = &#63;.
	*
	* @param deviceType the device type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage fetchByDeviceType_Last(
		java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rumbasolutions.flask.model.VenueDeviceImage[] findByDeviceType_PrevAndNext(
		long venueDeviceImageId, java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException;

	/**
	* Removes all the venue device images where deviceType = &#63; from the database.
	*
	* @param deviceType the device type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDeviceType(java.lang.String deviceType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of venue device images where deviceType = &#63;.
	*
	* @param deviceType the device type
	* @return the number of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public int countByDeviceType(java.lang.String deviceType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the venue device images where venueId = &#63; and deviceType = &#63;.
	*
	* @param venueId the venue ID
	* @param deviceType the device type
	* @return the matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueDevice(
		long venueId, java.lang.String deviceType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueDevice(
		long venueId, java.lang.String deviceType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueDevice(
		long venueId, java.lang.String deviceType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rumbasolutions.flask.model.VenueDeviceImage findByVenueDevice_First(
		long venueId, java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException;

	/**
	* Returns the first venue device image in the ordered set where venueId = &#63; and deviceType = &#63;.
	*
	* @param venueId the venue ID
	* @param deviceType the device type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage fetchByVenueDevice_First(
		long venueId, java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rumbasolutions.flask.model.VenueDeviceImage findByVenueDevice_Last(
		long venueId, java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException;

	/**
	* Returns the last venue device image in the ordered set where venueId = &#63; and deviceType = &#63;.
	*
	* @param venueId the venue ID
	* @param deviceType the device type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage fetchByVenueDevice_Last(
		long venueId, java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rumbasolutions.flask.model.VenueDeviceImage[] findByVenueDevice_PrevAndNext(
		long venueDeviceImageId, long venueId, java.lang.String deviceType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException;

	/**
	* Removes all the venue device images where venueId = &#63; and deviceType = &#63; from the database.
	*
	* @param venueId the venue ID
	* @param deviceType the device type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVenueDevice(long venueId, java.lang.String deviceType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of venue device images where venueId = &#63; and deviceType = &#63;.
	*
	* @param venueId the venue ID
	* @param deviceType the device type
	* @return the number of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public int countByVenueDevice(long venueId, java.lang.String deviceType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the venue device images where venueDetailImageId = &#63;.
	*
	* @param venueDetailImageId the venue detail image ID
	* @return the matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueDetailImageId(
		long venueDetailImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueDetailImageId(
		long venueDetailImageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueDetailImageId(
		long venueDetailImageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first venue device image in the ordered set where venueDetailImageId = &#63;.
	*
	* @param venueDetailImageId the venue detail image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage findByVenueDetailImageId_First(
		long venueDetailImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException;

	/**
	* Returns the first venue device image in the ordered set where venueDetailImageId = &#63;.
	*
	* @param venueDetailImageId the venue detail image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage fetchByVenueDetailImageId_First(
		long venueDetailImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last venue device image in the ordered set where venueDetailImageId = &#63;.
	*
	* @param venueDetailImageId the venue detail image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage findByVenueDetailImageId_Last(
		long venueDetailImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException;

	/**
	* Returns the last venue device image in the ordered set where venueDetailImageId = &#63;.
	*
	* @param venueDetailImageId the venue detail image ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage fetchByVenueDetailImageId_Last(
		long venueDetailImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rumbasolutions.flask.model.VenueDeviceImage[] findByVenueDetailImageId_PrevAndNext(
		long venueDeviceImageId, long venueDetailImageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException;

	/**
	* Removes all the venue device images where venueDetailImageId = &#63; from the database.
	*
	* @param venueDetailImageId the venue detail image ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVenueDetailImageId(long venueDetailImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of venue device images where venueDetailImageId = &#63;.
	*
	* @param venueDetailImageId the venue detail image ID
	* @return the number of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public int countByVenueDetailImageId(long venueDetailImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the venue device images where venueId = &#63; and aspectRatio = &#63;.
	*
	* @param venueId the venue ID
	* @param aspectRatio the aspect ratio
	* @return the matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueRatio(
		long venueId, java.lang.String aspectRatio)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueRatio(
		long venueId, java.lang.String aspectRatio, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findByVenueRatio(
		long venueId, java.lang.String aspectRatio, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rumbasolutions.flask.model.VenueDeviceImage findByVenueRatio_First(
		long venueId, java.lang.String aspectRatio,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException;

	/**
	* Returns the first venue device image in the ordered set where venueId = &#63; and aspectRatio = &#63;.
	*
	* @param venueId the venue ID
	* @param aspectRatio the aspect ratio
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage fetchByVenueRatio_First(
		long venueId, java.lang.String aspectRatio,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rumbasolutions.flask.model.VenueDeviceImage findByVenueRatio_Last(
		long venueId, java.lang.String aspectRatio,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException;

	/**
	* Returns the last venue device image in the ordered set where venueId = &#63; and aspectRatio = &#63;.
	*
	* @param venueId the venue ID
	* @param aspectRatio the aspect ratio
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue device image, or <code>null</code> if a matching venue device image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage fetchByVenueRatio_Last(
		long venueId, java.lang.String aspectRatio,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rumbasolutions.flask.model.VenueDeviceImage[] findByVenueRatio_PrevAndNext(
		long venueDeviceImageId, long venueId, java.lang.String aspectRatio,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException;

	/**
	* Removes all the venue device images where venueId = &#63; and aspectRatio = &#63; from the database.
	*
	* @param venueId the venue ID
	* @param aspectRatio the aspect ratio
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVenueRatio(long venueId, java.lang.String aspectRatio)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of venue device images where venueId = &#63; and aspectRatio = &#63;.
	*
	* @param venueId the venue ID
	* @param aspectRatio the aspect ratio
	* @return the number of matching venue device images
	* @throws SystemException if a system exception occurred
	*/
	public int countByVenueRatio(long venueId, java.lang.String aspectRatio)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the venue device image in the entity cache if it is enabled.
	*
	* @param venueDeviceImage the venue device image
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.VenueDeviceImage venueDeviceImage);

	/**
	* Caches the venue device images in the entity cache if it is enabled.
	*
	* @param venueDeviceImages the venue device images
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> venueDeviceImages);

	/**
	* Creates a new venue device image with the primary key. Does not add the venue device image to the database.
	*
	* @param venueDeviceImageId the primary key for the new venue device image
	* @return the new venue device image
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage create(
		long venueDeviceImageId);

	/**
	* Removes the venue device image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueDeviceImageId the primary key of the venue device image
	* @return the venue device image that was removed
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage remove(
		long venueDeviceImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException;

	public com.rumbasolutions.flask.model.VenueDeviceImage updateImpl(
		com.rumbasolutions.flask.model.VenueDeviceImage venueDeviceImage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the venue device image with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueDeviceImageException} if it could not be found.
	*
	* @param venueDeviceImageId the primary key of the venue device image
	* @return the venue device image
	* @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage findByPrimaryKey(
		long venueDeviceImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDeviceImageException;

	/**
	* Returns the venue device image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param venueDeviceImageId the primary key of the venue device image
	* @return the venue device image, or <code>null</code> if a venue device image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDeviceImage fetchByPrimaryKey(
		long venueDeviceImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the venue device images.
	*
	* @return the venue device images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the venue device images from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of venue device images.
	*
	* @return the number of venue device images
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}