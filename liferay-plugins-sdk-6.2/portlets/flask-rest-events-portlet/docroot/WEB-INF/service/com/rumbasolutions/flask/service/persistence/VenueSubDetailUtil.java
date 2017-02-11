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

import com.rumbasolutions.flask.model.VenueSubDetail;

import java.util.List;

/**
 * The persistence utility for the venue sub detail service. This utility wraps {@link VenueSubDetailPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueSubDetailPersistence
 * @see VenueSubDetailPersistenceImpl
 * @generated
 */
public class VenueSubDetailUtil {
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
	public static void clearCache(VenueSubDetail venueSubDetail) {
		getPersistence().clearCache(venueSubDetail);
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
	public static List<VenueSubDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VenueSubDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VenueSubDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VenueSubDetail update(VenueSubDetail venueSubDetail)
		throws SystemException {
		return getPersistence().update(venueSubDetail);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VenueSubDetail update(VenueSubDetail venueSubDetail,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(venueSubDetail, serviceContext);
	}

	/**
	* Returns all the venue sub details where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @return the matching venue sub details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> findByVenueDetailId(
		long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVenueDetailId(venueDetailId);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> findByVenueDetailId(
		long venueDetailId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVenueDetailId(venueDetailId, start, end);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> findByVenueDetailId(
		long venueDetailId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVenueDetailId(venueDetailId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first venue sub detail in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue sub detail
	* @throws com.rumbasolutions.flask.NoSuchVenueSubDetailException if a matching venue sub detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueSubDetail findByVenueDetailId_First(
		long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueSubDetailException {
		return getPersistence()
				   .findByVenueDetailId_First(venueDetailId, orderByComparator);
	}

	/**
	* Returns the first venue sub detail in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue sub detail, or <code>null</code> if a matching venue sub detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueSubDetail fetchByVenueDetailId_First(
		long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVenueDetailId_First(venueDetailId, orderByComparator);
	}

	/**
	* Returns the last venue sub detail in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue sub detail
	* @throws com.rumbasolutions.flask.NoSuchVenueSubDetailException if a matching venue sub detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueSubDetail findByVenueDetailId_Last(
		long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueSubDetailException {
		return getPersistence()
				   .findByVenueDetailId_Last(venueDetailId, orderByComparator);
	}

	/**
	* Returns the last venue sub detail in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue sub detail, or <code>null</code> if a matching venue sub detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueSubDetail fetchByVenueDetailId_Last(
		long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVenueDetailId_Last(venueDetailId, orderByComparator);
	}

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
	public static com.rumbasolutions.flask.model.VenueSubDetail[] findByVenueDetailId_PrevAndNext(
		long venueSubDetailId, long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueSubDetailException {
		return getPersistence()
				   .findByVenueDetailId_PrevAndNext(venueSubDetailId,
			venueDetailId, orderByComparator);
	}

	/**
	* Removes all the venue sub details where venueDetailId = &#63; from the database.
	*
	* @param venueDetailId the venue detail ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVenueDetailId(long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVenueDetailId(venueDetailId);
	}

	/**
	* Returns the number of venue sub details where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @return the number of matching venue sub details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVenueDetailId(long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVenueDetailId(venueDetailId);
	}

	/**
	* Caches the venue sub detail in the entity cache if it is enabled.
	*
	* @param venueSubDetail the venue sub detail
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.VenueSubDetail venueSubDetail) {
		getPersistence().cacheResult(venueSubDetail);
	}

	/**
	* Caches the venue sub details in the entity cache if it is enabled.
	*
	* @param venueSubDetails the venue sub details
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> venueSubDetails) {
		getPersistence().cacheResult(venueSubDetails);
	}

	/**
	* Creates a new venue sub detail with the primary key. Does not add the venue sub detail to the database.
	*
	* @param venueSubDetailId the primary key for the new venue sub detail
	* @return the new venue sub detail
	*/
	public static com.rumbasolutions.flask.model.VenueSubDetail create(
		long venueSubDetailId) {
		return getPersistence().create(venueSubDetailId);
	}

	/**
	* Removes the venue sub detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueSubDetailId the primary key of the venue sub detail
	* @return the venue sub detail that was removed
	* @throws com.rumbasolutions.flask.NoSuchVenueSubDetailException if a venue sub detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueSubDetail remove(
		long venueSubDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueSubDetailException {
		return getPersistence().remove(venueSubDetailId);
	}

	public static com.rumbasolutions.flask.model.VenueSubDetail updateImpl(
		com.rumbasolutions.flask.model.VenueSubDetail venueSubDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(venueSubDetail);
	}

	/**
	* Returns the venue sub detail with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueSubDetailException} if it could not be found.
	*
	* @param venueSubDetailId the primary key of the venue sub detail
	* @return the venue sub detail
	* @throws com.rumbasolutions.flask.NoSuchVenueSubDetailException if a venue sub detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueSubDetail findByPrimaryKey(
		long venueSubDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueSubDetailException {
		return getPersistence().findByPrimaryKey(venueSubDetailId);
	}

	/**
	* Returns the venue sub detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param venueSubDetailId the primary key of the venue sub detail
	* @return the venue sub detail, or <code>null</code> if a venue sub detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueSubDetail fetchByPrimaryKey(
		long venueSubDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(venueSubDetailId);
	}

	/**
	* Returns all the venue sub details.
	*
	* @return the venue sub details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the venue sub details from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of venue sub details.
	*
	* @return the number of venue sub details
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VenueSubDetailPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VenueSubDetailPersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					VenueSubDetailPersistence.class.getName());

			ReferenceRegistry.registerReference(VenueSubDetailUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VenueSubDetailPersistence persistence) {
	}

	private static VenueSubDetailPersistence _persistence;
}