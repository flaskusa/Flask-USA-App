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

import com.rumbasolutions.flask.model.VenueSubDetail;

/**
 * The persistence interface for the venue sub detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueSubDetailPersistenceImpl
 * @see VenueSubDetailUtil
 * @generated
 */
public interface VenueSubDetailPersistence extends BasePersistence<VenueSubDetail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VenueSubDetailUtil} to access the venue sub detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the venue sub details where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @return the matching venue sub details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> findByVenueDetailId(
		long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the venue sub details where venueDetailId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueDetailId the venue detail ID
	* @param start the lower bound of the range of venue sub details
	* @param end the upper bound of the range of venue sub details (not inclusive)
	* @return the range of matching venue sub details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> findByVenueDetailId(
		long venueDetailId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the venue sub details where venueDetailId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueDetailId the venue detail ID
	* @param start the lower bound of the range of venue sub details
	* @param end the upper bound of the range of venue sub details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching venue sub details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> findByVenueDetailId(
		long venueDetailId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first venue sub detail in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue sub detail
	* @throws com.rumbasolutions.flask.NoSuchVenueSubDetailException if a matching venue sub detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueSubDetail findByVenueDetailId_First(
		long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueSubDetailException;

	/**
	* Returns the first venue sub detail in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue sub detail, or <code>null</code> if a matching venue sub detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueSubDetail fetchByVenueDetailId_First(
		long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last venue sub detail in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue sub detail
	* @throws com.rumbasolutions.flask.NoSuchVenueSubDetailException if a matching venue sub detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueSubDetail findByVenueDetailId_Last(
		long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueSubDetailException;

	/**
	* Returns the last venue sub detail in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue sub detail, or <code>null</code> if a matching venue sub detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueSubDetail fetchByVenueDetailId_Last(
		long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the venue sub details before and after the current venue sub detail in the ordered set where venueDetailId = &#63;.
	*
	* @param venueSubDetailId the primary key of the current venue sub detail
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue sub detail
	* @throws com.rumbasolutions.flask.NoSuchVenueSubDetailException if a venue sub detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueSubDetail[] findByVenueDetailId_PrevAndNext(
		long venueSubDetailId, long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueSubDetailException;

	/**
	* Removes all the venue sub details where venueDetailId = &#63; from the database.
	*
	* @param venueDetailId the venue detail ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVenueDetailId(long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of venue sub details where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @return the number of matching venue sub details
	* @throws SystemException if a system exception occurred
	*/
	public int countByVenueDetailId(long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the venue sub detail in the entity cache if it is enabled.
	*
	* @param venueSubDetail the venue sub detail
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.VenueSubDetail venueSubDetail);

	/**
	* Caches the venue sub details in the entity cache if it is enabled.
	*
	* @param venueSubDetails the venue sub details
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> venueSubDetails);

	/**
	* Creates a new venue sub detail with the primary key. Does not add the venue sub detail to the database.
	*
	* @param venueSubDetailId the primary key for the new venue sub detail
	* @return the new venue sub detail
	*/
	public com.rumbasolutions.flask.model.VenueSubDetail create(
		long venueSubDetailId);

	/**
	* Removes the venue sub detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueSubDetailId the primary key of the venue sub detail
	* @return the venue sub detail that was removed
	* @throws com.rumbasolutions.flask.NoSuchVenueSubDetailException if a venue sub detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueSubDetail remove(
		long venueSubDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueSubDetailException;

	public com.rumbasolutions.flask.model.VenueSubDetail updateImpl(
		com.rumbasolutions.flask.model.VenueSubDetail venueSubDetail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the venue sub detail with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueSubDetailException} if it could not be found.
	*
	* @param venueSubDetailId the primary key of the venue sub detail
	* @return the venue sub detail
	* @throws com.rumbasolutions.flask.NoSuchVenueSubDetailException if a venue sub detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueSubDetail findByPrimaryKey(
		long venueSubDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueSubDetailException;

	/**
	* Returns the venue sub detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param venueSubDetailId the primary key of the venue sub detail
	* @return the venue sub detail, or <code>null</code> if a venue sub detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.VenueSubDetail fetchByPrimaryKey(
		long venueSubDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the venue sub details.
	*
	* @return the venue sub details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the venue sub details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue sub details
	* @param end the upper bound of the range of venue sub details (not inclusive)
	* @return the range of venue sub details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the venue sub details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue sub details
	* @param end the upper bound of the range of venue sub details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of venue sub details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the venue sub details from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of venue sub details.
	*
	* @return the number of venue sub details
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}