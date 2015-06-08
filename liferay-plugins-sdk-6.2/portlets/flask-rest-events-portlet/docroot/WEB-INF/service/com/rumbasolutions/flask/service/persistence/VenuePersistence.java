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

import com.rumbasolutions.flask.model.Venue;

/**
 * The persistence interface for the venue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenuePersistenceImpl
 * @see VenueUtil
 * @generated
 */
public interface VenuePersistence extends BasePersistence<Venue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VenueUtil} to access the venue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the venues where venueMetroArea = &#63;.
	*
	* @param venueMetroArea the venue metro area
	* @return the matching venues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.Venue> findByvenueMetroArea(
		java.lang.String venueMetroArea)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the venues where venueMetroArea = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueMetroArea the venue metro area
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @return the range of matching venues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.Venue> findByvenueMetroArea(
		java.lang.String venueMetroArea, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the venues where venueMetroArea = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueMetroArea the venue metro area
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching venues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.Venue> findByvenueMetroArea(
		java.lang.String venueMetroArea, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first venue in the ordered set where venueMetroArea = &#63;.
	*
	* @param venueMetroArea the venue metro area
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue
	* @throws com.rumbasolutions.flask.NoSuchVenueException if a matching venue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.Venue findByvenueMetroArea_First(
		java.lang.String venueMetroArea,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueException;

	/**
	* Returns the first venue in the ordered set where venueMetroArea = &#63;.
	*
	* @param venueMetroArea the venue metro area
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue, or <code>null</code> if a matching venue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.Venue fetchByvenueMetroArea_First(
		java.lang.String venueMetroArea,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last venue in the ordered set where venueMetroArea = &#63;.
	*
	* @param venueMetroArea the venue metro area
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue
	* @throws com.rumbasolutions.flask.NoSuchVenueException if a matching venue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.Venue findByvenueMetroArea_Last(
		java.lang.String venueMetroArea,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueException;

	/**
	* Returns the last venue in the ordered set where venueMetroArea = &#63;.
	*
	* @param venueMetroArea the venue metro area
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue, or <code>null</code> if a matching venue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.Venue fetchByvenueMetroArea_Last(
		java.lang.String venueMetroArea,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the venues before and after the current venue in the ordered set where venueMetroArea = &#63;.
	*
	* @param venueId the primary key of the current venue
	* @param venueMetroArea the venue metro area
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue
	* @throws com.rumbasolutions.flask.NoSuchVenueException if a venue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.Venue[] findByvenueMetroArea_PrevAndNext(
		long venueId, java.lang.String venueMetroArea,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueException;

	/**
	* Removes all the venues where venueMetroArea = &#63; from the database.
	*
	* @param venueMetroArea the venue metro area
	* @throws SystemException if a system exception occurred
	*/
	public void removeByvenueMetroArea(java.lang.String venueMetroArea)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of venues where venueMetroArea = &#63;.
	*
	* @param venueMetroArea the venue metro area
	* @return the number of matching venues
	* @throws SystemException if a system exception occurred
	*/
	public int countByvenueMetroArea(java.lang.String venueMetroArea)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the venue in the entity cache if it is enabled.
	*
	* @param venue the venue
	*/
	public void cacheResult(com.rumbasolutions.flask.model.Venue venue);

	/**
	* Caches the venues in the entity cache if it is enabled.
	*
	* @param venues the venues
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.Venue> venues);

	/**
	* Creates a new venue with the primary key. Does not add the venue to the database.
	*
	* @param venueId the primary key for the new venue
	* @return the new venue
	*/
	public com.rumbasolutions.flask.model.Venue create(long venueId);

	/**
	* Removes the venue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueId the primary key of the venue
	* @return the venue that was removed
	* @throws com.rumbasolutions.flask.NoSuchVenueException if a venue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.Venue remove(long venueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueException;

	public com.rumbasolutions.flask.model.Venue updateImpl(
		com.rumbasolutions.flask.model.Venue venue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the venue with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueException} if it could not be found.
	*
	* @param venueId the primary key of the venue
	* @return the venue
	* @throws com.rumbasolutions.flask.NoSuchVenueException if a venue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.Venue findByPrimaryKey(long venueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueException;

	/**
	* Returns the venue with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param venueId the primary key of the venue
	* @return the venue, or <code>null</code> if a venue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.Venue fetchByPrimaryKey(long venueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the venues.
	*
	* @return the venues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.Venue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the venues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @return the range of venues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.Venue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the venues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venues
	* @param end the upper bound of the range of venues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of venues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.Venue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the venues from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of venues.
	*
	* @return the number of venues
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}