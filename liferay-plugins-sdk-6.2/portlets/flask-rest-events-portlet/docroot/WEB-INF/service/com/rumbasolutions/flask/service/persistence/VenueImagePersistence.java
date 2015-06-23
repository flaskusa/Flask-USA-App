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

import com.rumbasolutions.flask.model.VenueImage;

/**
 * The persistence interface for the venue image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueImagePersistenceImpl
 * @see VenueImageUtil
 * @generated
 */
public interface VenueImagePersistence extends BasePersistence<VenueImage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VenueImageUtil} to access the venue image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the venue images where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @return the matching venue images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueImage> findByvenueId(
		long venueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the venue images where venueId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueId the venue ID
	* @param start the lower bound of the range of venue images
	* @param end the upper bound of the range of venue images (not inclusive)
	* @return the range of matching venue images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueImage> findByvenueId(
		long venueId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the venue images where venueId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueId the venue ID
	* @param start the lower bound of the range of venue images
	* @param end the upper bound of the range of venue images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching venue images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueImage> findByvenueId(
		long venueId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first venue image in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue image
	* @throws com.rumbasolutions.flask.NoSuchVenueImageException if a matching venue image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueImage findByvenueId_First(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueImageException;

	/**
	* Returns the first venue image in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue image, or <code>null</code> if a matching venue image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueImage fetchByvenueId_First(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last venue image in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue image
	* @throws com.rumbasolutions.flask.NoSuchVenueImageException if a matching venue image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueImage findByvenueId_Last(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueImageException;

	/**
	* Returns the last venue image in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue image, or <code>null</code> if a matching venue image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueImage fetchByvenueId_Last(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the venue images before and after the current venue image in the ordered set where venueId = &#63;.
	*
	* @param venueImageId the primary key of the current venue image
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue image
	* @throws com.rumbasolutions.flask.NoSuchVenueImageException if a venue image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueImage[] findByvenueId_PrevAndNext(
		long venueImageId, long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueImageException;

	/**
	* Removes all the venue images where venueId = &#63; from the database.
	*
	* @param venueId the venue ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByvenueId(long venueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of venue images where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @return the number of matching venue images
	* @throws SystemException if a system exception occurred
	*/
	public int countByvenueId(long venueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the venue image in the entity cache if it is enabled.
	*
	* @param venueImage the venue image
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.VenueImage venueImage);

	/**
	* Caches the venue images in the entity cache if it is enabled.
	*
	* @param venueImages the venue images
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.VenueImage> venueImages);

	/**
	* Creates a new venue image with the primary key. Does not add the venue image to the database.
	*
	* @param venueImageId the primary key for the new venue image
	* @return the new venue image
	*/
	public com.rumbasolutions.flask.model.VenueImage create(long venueImageId);

	/**
	* Removes the venue image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueImageId the primary key of the venue image
	* @return the venue image that was removed
	* @throws com.rumbasolutions.flask.NoSuchVenueImageException if a venue image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueImage remove(long venueImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueImageException;

	public com.rumbasolutions.flask.model.VenueImage updateImpl(
		com.rumbasolutions.flask.model.VenueImage venueImage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the venue image with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueImageException} if it could not be found.
	*
	* @param venueImageId the primary key of the venue image
	* @return the venue image
	* @throws com.rumbasolutions.flask.NoSuchVenueImageException if a venue image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueImage findByPrimaryKey(
		long venueImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueImageException;

	/**
	* Returns the venue image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param venueImageId the primary key of the venue image
	* @return the venue image, or <code>null</code> if a venue image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueImage fetchByPrimaryKey(
		long venueImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the venue images.
	*
	* @return the venue images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueImage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the venue images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue images
	* @param end the upper bound of the range of venue images (not inclusive)
	* @return the range of venue images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueImage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the venue images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue images
	* @param end the upper bound of the range of venue images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of venue images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the venue images from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of venue images.
	*
	* @return the number of venue images
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}