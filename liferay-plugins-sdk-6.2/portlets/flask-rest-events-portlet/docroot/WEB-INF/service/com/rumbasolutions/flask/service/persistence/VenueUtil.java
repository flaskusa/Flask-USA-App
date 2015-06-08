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

import com.rumbasolutions.flask.model.Venue;

import java.util.List;

/**
 * The persistence utility for the venue service. This utility wraps {@link VenuePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenuePersistence
 * @see VenuePersistenceImpl
 * @generated
 */
public class VenueUtil {
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
	public static void clearCache(Venue venue) {
		getPersistence().clearCache(venue);
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
	public static List<Venue> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Venue> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Venue> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Venue update(Venue venue) throws SystemException {
		return getPersistence().update(venue);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Venue update(Venue venue, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(venue, serviceContext);
	}

	/**
	* Returns all the venues where venueMetroArea = &#63;.
	*
	* @param venueMetroArea the venue metro area
	* @return the matching venues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.Venue> findByvenueMetroArea(
		java.lang.String venueMetroArea)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByvenueMetroArea(venueMetroArea);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.Venue> findByvenueMetroArea(
		java.lang.String venueMetroArea, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByvenueMetroArea(venueMetroArea, start, end);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.Venue> findByvenueMetroArea(
		java.lang.String venueMetroArea, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByvenueMetroArea(venueMetroArea, start, end,
			orderByComparator);
	}

	/**
	* Returns the first venue in the ordered set where venueMetroArea = &#63;.
	*
	* @param venueMetroArea the venue metro area
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue
	* @throws com.rumbasolutions.flask.NoSuchVenueException if a matching venue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.Venue findByvenueMetroArea_First(
		java.lang.String venueMetroArea,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueException {
		return getPersistence()
				   .findByvenueMetroArea_First(venueMetroArea, orderByComparator);
	}

	/**
	* Returns the first venue in the ordered set where venueMetroArea = &#63;.
	*
	* @param venueMetroArea the venue metro area
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue, or <code>null</code> if a matching venue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.Venue fetchByvenueMetroArea_First(
		java.lang.String venueMetroArea,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByvenueMetroArea_First(venueMetroArea,
			orderByComparator);
	}

	/**
	* Returns the last venue in the ordered set where venueMetroArea = &#63;.
	*
	* @param venueMetroArea the venue metro area
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue
	* @throws com.rumbasolutions.flask.NoSuchVenueException if a matching venue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.Venue findByvenueMetroArea_Last(
		java.lang.String venueMetroArea,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueException {
		return getPersistence()
				   .findByvenueMetroArea_Last(venueMetroArea, orderByComparator);
	}

	/**
	* Returns the last venue in the ordered set where venueMetroArea = &#63;.
	*
	* @param venueMetroArea the venue metro area
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue, or <code>null</code> if a matching venue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.Venue fetchByvenueMetroArea_Last(
		java.lang.String venueMetroArea,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByvenueMetroArea_Last(venueMetroArea, orderByComparator);
	}

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
	public static com.rumbasolutions.flask.model.Venue[] findByvenueMetroArea_PrevAndNext(
		long venueId, java.lang.String venueMetroArea,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueException {
		return getPersistence()
				   .findByvenueMetroArea_PrevAndNext(venueId, venueMetroArea,
			orderByComparator);
	}

	/**
	* Removes all the venues where venueMetroArea = &#63; from the database.
	*
	* @param venueMetroArea the venue metro area
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByvenueMetroArea(java.lang.String venueMetroArea)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByvenueMetroArea(venueMetroArea);
	}

	/**
	* Returns the number of venues where venueMetroArea = &#63;.
	*
	* @param venueMetroArea the venue metro area
	* @return the number of matching venues
	* @throws SystemException if a system exception occurred
	*/
	public static int countByvenueMetroArea(java.lang.String venueMetroArea)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByvenueMetroArea(venueMetroArea);
	}

	/**
	* Caches the venue in the entity cache if it is enabled.
	*
	* @param venue the venue
	*/
	public static void cacheResult(com.rumbasolutions.flask.model.Venue venue) {
		getPersistence().cacheResult(venue);
	}

	/**
	* Caches the venues in the entity cache if it is enabled.
	*
	* @param venues the venues
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.Venue> venues) {
		getPersistence().cacheResult(venues);
	}

	/**
	* Creates a new venue with the primary key. Does not add the venue to the database.
	*
	* @param venueId the primary key for the new venue
	* @return the new venue
	*/
	public static com.rumbasolutions.flask.model.Venue create(long venueId) {
		return getPersistence().create(venueId);
	}

	/**
	* Removes the venue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueId the primary key of the venue
	* @return the venue that was removed
	* @throws com.rumbasolutions.flask.NoSuchVenueException if a venue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.Venue remove(long venueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueException {
		return getPersistence().remove(venueId);
	}

	public static com.rumbasolutions.flask.model.Venue updateImpl(
		com.rumbasolutions.flask.model.Venue venue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(venue);
	}

	/**
	* Returns the venue with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueException} if it could not be found.
	*
	* @param venueId the primary key of the venue
	* @return the venue
	* @throws com.rumbasolutions.flask.NoSuchVenueException if a venue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.Venue findByPrimaryKey(
		long venueId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueException {
		return getPersistence().findByPrimaryKey(venueId);
	}

	/**
	* Returns the venue with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param venueId the primary key of the venue
	* @return the venue, or <code>null</code> if a venue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.Venue fetchByPrimaryKey(
		long venueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(venueId);
	}

	/**
	* Returns all the venues.
	*
	* @return the venues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.Venue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.Venue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.Venue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the venues from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of venues.
	*
	* @return the number of venues
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VenuePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VenuePersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					VenuePersistence.class.getName());

			ReferenceRegistry.registerReference(VenueUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VenuePersistence persistence) {
	}

	private static VenuePersistence _persistence;
}