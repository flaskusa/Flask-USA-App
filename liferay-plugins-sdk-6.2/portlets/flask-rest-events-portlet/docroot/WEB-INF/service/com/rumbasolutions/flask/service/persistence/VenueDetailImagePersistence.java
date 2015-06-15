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

import com.rumbasolutions.flask.model.VenueDetailImage;

/**
 * The persistence interface for the venue detail image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueDetailImagePersistenceImpl
 * @see VenueDetailImageUtil
 * @generated
 */
public interface VenueDetailImagePersistence extends BasePersistence<VenueDetailImage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VenueDetailImageUtil} to access the venue detail image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the venue detail images where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @return the matching venue detail images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> findByVenueDetailId(
		long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the venue detail images where venueDetailId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueDetailId the venue detail ID
	* @param start the lower bound of the range of venue detail images
	* @param end the upper bound of the range of venue detail images (not inclusive)
	* @return the range of matching venue detail images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> findByVenueDetailId(
		long venueDetailId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the venue detail images where venueDetailId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueDetailId the venue detail ID
	* @param start the lower bound of the range of venue detail images
	* @param end the upper bound of the range of venue detail images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching venue detail images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> findByVenueDetailId(
		long venueDetailId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first venue detail image in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue detail image
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailImageException if a matching venue detail image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDetailImage findByVenueDetailId_First(
		long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailImageException;

	/**
	* Returns the first venue detail image in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue detail image, or <code>null</code> if a matching venue detail image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDetailImage fetchByVenueDetailId_First(
		long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last venue detail image in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue detail image
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailImageException if a matching venue detail image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDetailImage findByVenueDetailId_Last(
		long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailImageException;

	/**
	* Returns the last venue detail image in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue detail image, or <code>null</code> if a matching venue detail image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDetailImage fetchByVenueDetailId_Last(
		long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the venue detail images before and after the current venue detail image in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailImageId the primary key of the current venue detail image
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue detail image
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailImageException if a venue detail image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDetailImage[] findByVenueDetailId_PrevAndNext(
		long venueDetailImageId, long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailImageException;

	/**
	* Removes all the venue detail images where venueDetailId = &#63; from the database.
	*
	* @param venueDetailId the venue detail ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVenueDetailId(long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of venue detail images where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @return the number of matching venue detail images
	* @throws SystemException if a system exception occurred
	*/
	public int countByVenueDetailId(long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the venue detail image in the entity cache if it is enabled.
	*
	* @param venueDetailImage the venue detail image
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.VenueDetailImage venueDetailImage);

	/**
	* Caches the venue detail images in the entity cache if it is enabled.
	*
	* @param venueDetailImages the venue detail images
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> venueDetailImages);

	/**
	* Creates a new venue detail image with the primary key. Does not add the venue detail image to the database.
	*
	* @param venueDetailImageId the primary key for the new venue detail image
	* @return the new venue detail image
	*/
	public com.rumbasolutions.flask.model.VenueDetailImage create(
		long venueDetailImageId);

	/**
	* Removes the venue detail image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueDetailImageId the primary key of the venue detail image
	* @return the venue detail image that was removed
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailImageException if a venue detail image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDetailImage remove(
		long venueDetailImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailImageException;

	public com.rumbasolutions.flask.model.VenueDetailImage updateImpl(
		com.rumbasolutions.flask.model.VenueDetailImage venueDetailImage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the venue detail image with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueDetailImageException} if it could not be found.
	*
	* @param venueDetailImageId the primary key of the venue detail image
	* @return the venue detail image
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailImageException if a venue detail image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDetailImage findByPrimaryKey(
		long venueDetailImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailImageException;

	/**
	* Returns the venue detail image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param venueDetailImageId the primary key of the venue detail image
	* @return the venue detail image, or <code>null</code> if a venue detail image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueDetailImage fetchByPrimaryKey(
		long venueDetailImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the venue detail images.
	*
	* @return the venue detail images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the venue detail images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue detail images
	* @param end the upper bound of the range of venue detail images (not inclusive)
	* @return the range of venue detail images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the venue detail images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue detail images
	* @param end the upper bound of the range of venue detail images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of venue detail images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the venue detail images from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of venue detail images.
	*
	* @return the number of venue detail images
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}