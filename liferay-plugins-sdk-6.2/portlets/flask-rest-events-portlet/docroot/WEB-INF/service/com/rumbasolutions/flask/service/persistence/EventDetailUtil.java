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

import com.rumbasolutions.flask.model.EventDetail;

import java.util.List;

/**
 * The persistence utility for the event detail service. This utility wraps {@link EventDetailPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventDetailPersistence
 * @see EventDetailPersistenceImpl
 * @generated
 */
public class EventDetailUtil {
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
	public static void clearCache(EventDetail eventDetail) {
		getPersistence().clearCache(eventDetail);
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
	public static List<EventDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EventDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EventDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EventDetail update(EventDetail eventDetail)
		throws SystemException {
		return getPersistence().update(eventDetail);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EventDetail update(EventDetail eventDetail,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(eventDetail, serviceContext);
	}

	/**
	* Returns all the event details where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the matching event details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.EventDetail> findByeventId(
		long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByeventId(eventId);
	}

	/**
	* Returns a range of all the event details where eventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventId the event ID
	* @param start the lower bound of the range of event details
	* @param end the upper bound of the range of event details (not inclusive)
	* @return the range of matching event details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.EventDetail> findByeventId(
		long eventId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByeventId(eventId, start, end);
	}

	/**
	* Returns an ordered range of all the event details where eventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventId the event ID
	* @param start the lower bound of the range of event details
	* @param end the upper bound of the range of event details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.EventDetail> findByeventId(
		long eventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByeventId(eventId, start, end, orderByComparator);
	}

	/**
	* Returns the first event detail in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event detail
	* @throws com.rumbasolutions.flask.NoSuchEventDetailException if a matching event detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.EventDetail findByeventId_First(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailException {
		return getPersistence().findByeventId_First(eventId, orderByComparator);
	}

	/**
	* Returns the first event detail in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event detail, or <code>null</code> if a matching event detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.EventDetail fetchByeventId_First(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByeventId_First(eventId, orderByComparator);
	}

	/**
	* Returns the last event detail in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event detail
	* @throws com.rumbasolutions.flask.NoSuchEventDetailException if a matching event detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.EventDetail findByeventId_Last(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailException {
		return getPersistence().findByeventId_Last(eventId, orderByComparator);
	}

	/**
	* Returns the last event detail in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event detail, or <code>null</code> if a matching event detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.EventDetail fetchByeventId_Last(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByeventId_Last(eventId, orderByComparator);
	}

	/**
	* Returns the event details before and after the current event detail in the ordered set where eventId = &#63;.
	*
	* @param eventDetailId the primary key of the current event detail
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event detail
	* @throws com.rumbasolutions.flask.NoSuchEventDetailException if a event detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.EventDetail[] findByeventId_PrevAndNext(
		long eventDetailId, long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailException {
		return getPersistence()
				   .findByeventId_PrevAndNext(eventDetailId, eventId,
			orderByComparator);
	}

	/**
	* Removes all the event details where eventId = &#63; from the database.
	*
	* @param eventId the event ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByeventId(long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByeventId(eventId);
	}

	/**
	* Returns the number of event details where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the number of matching event details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByeventId(long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByeventId(eventId);
	}

	/**
	* Caches the event detail in the entity cache if it is enabled.
	*
	* @param eventDetail the event detail
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.EventDetail eventDetail) {
		getPersistence().cacheResult(eventDetail);
	}

	/**
	* Caches the event details in the entity cache if it is enabled.
	*
	* @param eventDetails the event details
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.EventDetail> eventDetails) {
		getPersistence().cacheResult(eventDetails);
	}

	/**
	* Creates a new event detail with the primary key. Does not add the event detail to the database.
	*
	* @param eventDetailId the primary key for the new event detail
	* @return the new event detail
	*/
	public static com.rumbasolutions.flask.model.EventDetail create(
		long eventDetailId) {
		return getPersistence().create(eventDetailId);
	}

	/**
	* Removes the event detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventDetailId the primary key of the event detail
	* @return the event detail that was removed
	* @throws com.rumbasolutions.flask.NoSuchEventDetailException if a event detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.EventDetail remove(
		long eventDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailException {
		return getPersistence().remove(eventDetailId);
	}

	public static com.rumbasolutions.flask.model.EventDetail updateImpl(
		com.rumbasolutions.flask.model.EventDetail eventDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(eventDetail);
	}

	/**
	* Returns the event detail with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchEventDetailException} if it could not be found.
	*
	* @param eventDetailId the primary key of the event detail
	* @return the event detail
	* @throws com.rumbasolutions.flask.NoSuchEventDetailException if a event detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.EventDetail findByPrimaryKey(
		long eventDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailException {
		return getPersistence().findByPrimaryKey(eventDetailId);
	}

	/**
	* Returns the event detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventDetailId the primary key of the event detail
	* @return the event detail, or <code>null</code> if a event detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.EventDetail fetchByPrimaryKey(
		long eventDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eventDetailId);
	}

	/**
	* Returns all the event details.
	*
	* @return the event details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.EventDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the event details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event details
	* @param end the upper bound of the range of event details (not inclusive)
	* @return the range of event details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.EventDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the event details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event details
	* @param end the upper bound of the range of event details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of event details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.EventDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the event details from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of event details.
	*
	* @return the number of event details
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EventDetailPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EventDetailPersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					EventDetailPersistence.class.getName());

			ReferenceRegistry.registerReference(EventDetailUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EventDetailPersistence persistence) {
	}

	private static EventDetailPersistence _persistence;
}