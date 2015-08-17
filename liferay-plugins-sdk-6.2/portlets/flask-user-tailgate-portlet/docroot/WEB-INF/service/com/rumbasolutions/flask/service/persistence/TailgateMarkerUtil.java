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

import com.rumbasolutions.flask.model.TailgateMarker;

import java.util.List;

/**
 * The persistence utility for the tailgate marker service. This utility wraps {@link TailgateMarkerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rajeshj
 * @see TailgateMarkerPersistence
 * @see TailgateMarkerPersistenceImpl
 * @generated
 */
public class TailgateMarkerUtil {
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
	public static void clearCache(TailgateMarker tailgateMarker) {
		getPersistence().clearCache(tailgateMarker);
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
	public static List<TailgateMarker> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TailgateMarker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TailgateMarker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TailgateMarker update(TailgateMarker tailgateMarker)
		throws SystemException {
		return getPersistence().update(tailgateMarker);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TailgateMarker update(TailgateMarker tailgateMarker,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tailgateMarker, serviceContext);
	}

	/**
	* Returns all the tailgate markers where tailgateid = &#63;.
	*
	* @param tailgateid the tailgateid
	* @return the matching tailgate markers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateMarker> findBytailgateid(
		long tailgateid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytailgateid(tailgateid);
	}

	/**
	* Returns a range of all the tailgate markers where tailgateid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateMarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tailgateid the tailgateid
	* @param start the lower bound of the range of tailgate markers
	* @param end the upper bound of the range of tailgate markers (not inclusive)
	* @return the range of matching tailgate markers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateMarker> findBytailgateid(
		long tailgateid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytailgateid(tailgateid, start, end);
	}

	/**
	* Returns an ordered range of all the tailgate markers where tailgateid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateMarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tailgateid the tailgateid
	* @param start the lower bound of the range of tailgate markers
	* @param end the upper bound of the range of tailgate markers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tailgate markers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateMarker> findBytailgateid(
		long tailgateid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBytailgateid(tailgateid, start, end, orderByComparator);
	}

	/**
	* Returns the first tailgate marker in the ordered set where tailgateid = &#63;.
	*
	* @param tailgateid the tailgateid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate marker
	* @throws com.rumbasolutions.flask.NoSuchTailgateMarkerException if a matching tailgate marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateMarker findBytailgateid_First(
		long tailgateid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMarkerException {
		return getPersistence()
				   .findBytailgateid_First(tailgateid, orderByComparator);
	}

	/**
	* Returns the first tailgate marker in the ordered set where tailgateid = &#63;.
	*
	* @param tailgateid the tailgateid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate marker, or <code>null</code> if a matching tailgate marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateMarker fetchBytailgateid_First(
		long tailgateid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBytailgateid_First(tailgateid, orderByComparator);
	}

	/**
	* Returns the last tailgate marker in the ordered set where tailgateid = &#63;.
	*
	* @param tailgateid the tailgateid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate marker
	* @throws com.rumbasolutions.flask.NoSuchTailgateMarkerException if a matching tailgate marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateMarker findBytailgateid_Last(
		long tailgateid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMarkerException {
		return getPersistence()
				   .findBytailgateid_Last(tailgateid, orderByComparator);
	}

	/**
	* Returns the last tailgate marker in the ordered set where tailgateid = &#63;.
	*
	* @param tailgateid the tailgateid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate marker, or <code>null</code> if a matching tailgate marker could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateMarker fetchBytailgateid_Last(
		long tailgateid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBytailgateid_Last(tailgateid, orderByComparator);
	}

	/**
	* Returns the tailgate markers before and after the current tailgate marker in the ordered set where tailgateid = &#63;.
	*
	* @param tailgatemarkerid the primary key of the current tailgate marker
	* @param tailgateid the tailgateid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tailgate marker
	* @throws com.rumbasolutions.flask.NoSuchTailgateMarkerException if a tailgate marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateMarker[] findBytailgateid_PrevAndNext(
		long tailgatemarkerid, long tailgateid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMarkerException {
		return getPersistence()
				   .findBytailgateid_PrevAndNext(tailgatemarkerid, tailgateid,
			orderByComparator);
	}

	/**
	* Removes all the tailgate markers where tailgateid = &#63; from the database.
	*
	* @param tailgateid the tailgateid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBytailgateid(long tailgateid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBytailgateid(tailgateid);
	}

	/**
	* Returns the number of tailgate markers where tailgateid = &#63;.
	*
	* @param tailgateid the tailgateid
	* @return the number of matching tailgate markers
	* @throws SystemException if a system exception occurred
	*/
	public static int countBytailgateid(long tailgateid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBytailgateid(tailgateid);
	}

	/**
	* Caches the tailgate marker in the entity cache if it is enabled.
	*
	* @param tailgateMarker the tailgate marker
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.TailgateMarker tailgateMarker) {
		getPersistence().cacheResult(tailgateMarker);
	}

	/**
	* Caches the tailgate markers in the entity cache if it is enabled.
	*
	* @param tailgateMarkers the tailgate markers
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.TailgateMarker> tailgateMarkers) {
		getPersistence().cacheResult(tailgateMarkers);
	}

	/**
	* Creates a new tailgate marker with the primary key. Does not add the tailgate marker to the database.
	*
	* @param tailgatemarkerid the primary key for the new tailgate marker
	* @return the new tailgate marker
	*/
	public static com.rumbasolutions.flask.model.TailgateMarker create(
		long tailgatemarkerid) {
		return getPersistence().create(tailgatemarkerid);
	}

	/**
	* Removes the tailgate marker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgatemarkerid the primary key of the tailgate marker
	* @return the tailgate marker that was removed
	* @throws com.rumbasolutions.flask.NoSuchTailgateMarkerException if a tailgate marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateMarker remove(
		long tailgatemarkerid)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMarkerException {
		return getPersistence().remove(tailgatemarkerid);
	}

	public static com.rumbasolutions.flask.model.TailgateMarker updateImpl(
		com.rumbasolutions.flask.model.TailgateMarker tailgateMarker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tailgateMarker);
	}

	/**
	* Returns the tailgate marker with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchTailgateMarkerException} if it could not be found.
	*
	* @param tailgatemarkerid the primary key of the tailgate marker
	* @return the tailgate marker
	* @throws com.rumbasolutions.flask.NoSuchTailgateMarkerException if a tailgate marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateMarker findByPrimaryKey(
		long tailgatemarkerid)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMarkerException {
		return getPersistence().findByPrimaryKey(tailgatemarkerid);
	}

	/**
	* Returns the tailgate marker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tailgatemarkerid the primary key of the tailgate marker
	* @return the tailgate marker, or <code>null</code> if a tailgate marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateMarker fetchByPrimaryKey(
		long tailgatemarkerid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tailgatemarkerid);
	}

	/**
	* Returns all the tailgate markers.
	*
	* @return the tailgate markers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateMarker> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tailgate markers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateMarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tailgate markers
	* @param end the upper bound of the range of tailgate markers (not inclusive)
	* @return the range of tailgate markers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateMarker> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tailgate markers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateMarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tailgate markers
	* @param end the upper bound of the range of tailgate markers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tailgate markers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateMarker> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tailgate markers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tailgate markers.
	*
	* @return the number of tailgate markers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TailgateMarkerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TailgateMarkerPersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					TailgateMarkerPersistence.class.getName());

			ReferenceRegistry.registerReference(TailgateMarkerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TailgateMarkerPersistence persistence) {
	}

	private static TailgateMarkerPersistence _persistence;
}