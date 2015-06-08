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

import com.rumbasolutions.flask.model.VenueDetail;

import java.util.List;

/**
 * The persistence utility for the venue detail service. This utility wraps {@link VenueDetailPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueDetailPersistence
 * @see VenueDetailPersistenceImpl
 * @generated
 */
public class VenueDetailUtil {
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
	public static void clearCache(VenueDetail venueDetail) {
		getPersistence().clearCache(venueDetail);
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
	public static List<VenueDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VenueDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VenueDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VenueDetail update(VenueDetail venueDetail)
		throws SystemException {
		return getPersistence().update(venueDetail);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VenueDetail update(VenueDetail venueDetail,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(venueDetail, serviceContext);
	}

	/**
	* Returns all the venue details where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @return the matching venue details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDetail> findByvenueId(
		long venueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByvenueId(venueId);
	}

	/**
	* Returns a range of all the venue details where venueId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueId the venue ID
	* @param start the lower bound of the range of venue details
	* @param end the upper bound of the range of venue details (not inclusive)
	* @return the range of matching venue details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDetail> findByvenueId(
		long venueId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByvenueId(venueId, start, end);
	}

	/**
	* Returns an ordered range of all the venue details where venueId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueId the venue ID
	* @param start the lower bound of the range of venue details
	* @param end the upper bound of the range of venue details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching venue details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDetail> findByvenueId(
		long venueId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByvenueId(venueId, start, end, orderByComparator);
	}

	/**
	* Returns the first venue detail in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue detail
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailException if a matching venue detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDetail findByvenueId_First(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailException {
		return getPersistence().findByvenueId_First(venueId, orderByComparator);
	}

	/**
	* Returns the first venue detail in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue detail, or <code>null</code> if a matching venue detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDetail fetchByvenueId_First(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByvenueId_First(venueId, orderByComparator);
	}

	/**
	* Returns the last venue detail in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue detail
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailException if a matching venue detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDetail findByvenueId_Last(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailException {
		return getPersistence().findByvenueId_Last(venueId, orderByComparator);
	}

	/**
	* Returns the last venue detail in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue detail, or <code>null</code> if a matching venue detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDetail fetchByvenueId_Last(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByvenueId_Last(venueId, orderByComparator);
	}

	/**
	* Returns the venue details before and after the current venue detail in the ordered set where venueId = &#63;.
	*
	* @param venueDetailId the primary key of the current venue detail
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue detail
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailException if a venue detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDetail[] findByvenueId_PrevAndNext(
		long venueDetailId, long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailException {
		return getPersistence()
				   .findByvenueId_PrevAndNext(venueDetailId, venueId,
			orderByComparator);
	}

	/**
	* Removes all the venue details where venueId = &#63; from the database.
	*
	* @param venueId the venue ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByvenueId(long venueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByvenueId(venueId);
	}

	/**
	* Returns the number of venue details where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @return the number of matching venue details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByvenueId(long venueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByvenueId(venueId);
	}

	/**
	* Caches the venue detail in the entity cache if it is enabled.
	*
	* @param venueDetail the venue detail
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.VenueDetail venueDetail) {
		getPersistence().cacheResult(venueDetail);
	}

	/**
	* Caches the venue details in the entity cache if it is enabled.
	*
	* @param venueDetails the venue details
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.VenueDetail> venueDetails) {
		getPersistence().cacheResult(venueDetails);
	}

	/**
	* Creates a new venue detail with the primary key. Does not add the venue detail to the database.
	*
	* @param venueDetailId the primary key for the new venue detail
	* @return the new venue detail
	*/
	public static com.rumbasolutions.flask.model.VenueDetail create(
		long venueDetailId) {
		return getPersistence().create(venueDetailId);
	}

	/**
	* Removes the venue detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueDetailId the primary key of the venue detail
	* @return the venue detail that was removed
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailException if a venue detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDetail remove(
		long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailException {
		return getPersistence().remove(venueDetailId);
	}

	public static com.rumbasolutions.flask.model.VenueDetail updateImpl(
		com.rumbasolutions.flask.model.VenueDetail venueDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(venueDetail);
	}

	/**
	* Returns the venue detail with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueDetailException} if it could not be found.
	*
	* @param venueDetailId the primary key of the venue detail
	* @return the venue detail
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailException if a venue detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDetail findByPrimaryKey(
		long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailException {
		return getPersistence().findByPrimaryKey(venueDetailId);
	}

	/**
	* Returns the venue detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param venueDetailId the primary key of the venue detail
	* @return the venue detail, or <code>null</code> if a venue detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDetail fetchByPrimaryKey(
		long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(venueDetailId);
	}

	/**
	* Returns all the venue details.
	*
	* @return the venue details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the venue details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue details
	* @param end the upper bound of the range of venue details (not inclusive)
	* @return the range of venue details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the venue details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue details
	* @param end the upper bound of the range of venue details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of venue details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the venue details from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of venue details.
	*
	* @return the number of venue details
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VenueDetailPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VenueDetailPersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					VenueDetailPersistence.class.getName());

			ReferenceRegistry.registerReference(VenueDetailUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VenueDetailPersistence persistence) {
	}

	private static VenueDetailPersistence _persistence;
}