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

import com.rumbasolutions.flask.model.EventDetail;

/**
 * The persistence interface for the event detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventDetailPersistenceImpl
 * @see EventDetailUtil
 * @generated
 */
public interface EventDetailPersistence extends BasePersistence<EventDetail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventDetailUtil} to access the event detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the event details where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the matching event details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.EventDetail> findByEventId(
		long eventId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.EventDetail> findByEventId(
		long eventId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.EventDetail> findByEventId(
		long eventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first event detail in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event detail
	* @throws com.rumbasolutions.flask.NoSuchEventDetailException if a matching event detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventDetail findByEventId_First(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailException;

	/**
	* Returns the first event detail in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event detail, or <code>null</code> if a matching event detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventDetail fetchByEventId_First(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last event detail in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event detail
	* @throws com.rumbasolutions.flask.NoSuchEventDetailException if a matching event detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventDetail findByEventId_Last(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailException;

	/**
	* Returns the last event detail in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event detail, or <code>null</code> if a matching event detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventDetail fetchByEventId_Last(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rumbasolutions.flask.model.EventDetail[] findByEventId_PrevAndNext(
		long eventDetailId, long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailException;

	/**
	* Removes all the event details where eventId = &#63; from the database.
	*
	* @param eventId the event ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEventId(long eventId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event details where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the number of matching event details
	* @throws SystemException if a system exception occurred
	*/
	public int countByEventId(long eventId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the event details where infoTypeId = &#63;.
	*
	* @param infoTypeId the info type ID
	* @return the matching event details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.EventDetail> findByEventInfoType(
		long infoTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the event details where infoTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param infoTypeId the info type ID
	* @param start the lower bound of the range of event details
	* @param end the upper bound of the range of event details (not inclusive)
	* @return the range of matching event details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.EventDetail> findByEventInfoType(
		long infoTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the event details where infoTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param infoTypeId the info type ID
	* @param start the lower bound of the range of event details
	* @param end the upper bound of the range of event details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.EventDetail> findByEventInfoType(
		long infoTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first event detail in the ordered set where infoTypeId = &#63;.
	*
	* @param infoTypeId the info type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event detail
	* @throws com.rumbasolutions.flask.NoSuchEventDetailException if a matching event detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventDetail findByEventInfoType_First(
		long infoTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailException;

	/**
	* Returns the first event detail in the ordered set where infoTypeId = &#63;.
	*
	* @param infoTypeId the info type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event detail, or <code>null</code> if a matching event detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventDetail fetchByEventInfoType_First(
		long infoTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last event detail in the ordered set where infoTypeId = &#63;.
	*
	* @param infoTypeId the info type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event detail
	* @throws com.rumbasolutions.flask.NoSuchEventDetailException if a matching event detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventDetail findByEventInfoType_Last(
		long infoTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailException;

	/**
	* Returns the last event detail in the ordered set where infoTypeId = &#63;.
	*
	* @param infoTypeId the info type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event detail, or <code>null</code> if a matching event detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventDetail fetchByEventInfoType_Last(
		long infoTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event details before and after the current event detail in the ordered set where infoTypeId = &#63;.
	*
	* @param eventDetailId the primary key of the current event detail
	* @param infoTypeId the info type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event detail
	* @throws com.rumbasolutions.flask.NoSuchEventDetailException if a event detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventDetail[] findByEventInfoType_PrevAndNext(
		long eventDetailId, long infoTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailException;

	/**
	* Removes all the event details where infoTypeId = &#63; from the database.
	*
	* @param infoTypeId the info type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEventInfoType(long infoTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event details where infoTypeId = &#63;.
	*
	* @param infoTypeId the info type ID
	* @return the number of matching event details
	* @throws SystemException if a system exception occurred
	*/
	public int countByEventInfoType(long infoTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the event details where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	*
	* @param infoTypeId the info type ID
	* @param infoTypeCategoryId the info type category ID
	* @return the matching event details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.EventDetail> findByEventInfoTypeCategory(
		long infoTypeId, long infoTypeCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the event details where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param infoTypeId the info type ID
	* @param infoTypeCategoryId the info type category ID
	* @param start the lower bound of the range of event details
	* @param end the upper bound of the range of event details (not inclusive)
	* @return the range of matching event details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.EventDetail> findByEventInfoTypeCategory(
		long infoTypeId, long infoTypeCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the event details where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param infoTypeId the info type ID
	* @param infoTypeCategoryId the info type category ID
	* @param start the lower bound of the range of event details
	* @param end the upper bound of the range of event details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.EventDetail> findByEventInfoTypeCategory(
		long infoTypeId, long infoTypeCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first event detail in the ordered set where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	*
	* @param infoTypeId the info type ID
	* @param infoTypeCategoryId the info type category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event detail
	* @throws com.rumbasolutions.flask.NoSuchEventDetailException if a matching event detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventDetail findByEventInfoTypeCategory_First(
		long infoTypeId, long infoTypeCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailException;

	/**
	* Returns the first event detail in the ordered set where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	*
	* @param infoTypeId the info type ID
	* @param infoTypeCategoryId the info type category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event detail, or <code>null</code> if a matching event detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventDetail fetchByEventInfoTypeCategory_First(
		long infoTypeId, long infoTypeCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last event detail in the ordered set where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	*
	* @param infoTypeId the info type ID
	* @param infoTypeCategoryId the info type category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event detail
	* @throws com.rumbasolutions.flask.NoSuchEventDetailException if a matching event detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventDetail findByEventInfoTypeCategory_Last(
		long infoTypeId, long infoTypeCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailException;

	/**
	* Returns the last event detail in the ordered set where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	*
	* @param infoTypeId the info type ID
	* @param infoTypeCategoryId the info type category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event detail, or <code>null</code> if a matching event detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventDetail fetchByEventInfoTypeCategory_Last(
		long infoTypeId, long infoTypeCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event details before and after the current event detail in the ordered set where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	*
	* @param eventDetailId the primary key of the current event detail
	* @param infoTypeId the info type ID
	* @param infoTypeCategoryId the info type category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event detail
	* @throws com.rumbasolutions.flask.NoSuchEventDetailException if a event detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventDetail[] findByEventInfoTypeCategory_PrevAndNext(
		long eventDetailId, long infoTypeId, long infoTypeCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailException;

	/**
	* Removes all the event details where infoTypeId = &#63; and infoTypeCategoryId = &#63; from the database.
	*
	* @param infoTypeId the info type ID
	* @param infoTypeCategoryId the info type category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEventInfoTypeCategory(long infoTypeId,
		long infoTypeCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event details where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	*
	* @param infoTypeId the info type ID
	* @param infoTypeCategoryId the info type category ID
	* @return the number of matching event details
	* @throws SystemException if a system exception occurred
	*/
	public int countByEventInfoTypeCategory(long infoTypeId,
		long infoTypeCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the event detail in the entity cache if it is enabled.
	*
	* @param eventDetail the event detail
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.EventDetail eventDetail);

	/**
	* Caches the event details in the entity cache if it is enabled.
	*
	* @param eventDetails the event details
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.EventDetail> eventDetails);

	/**
	* Creates a new event detail with the primary key. Does not add the event detail to the database.
	*
	* @param eventDetailId the primary key for the new event detail
	* @return the new event detail
	*/
	public com.rumbasolutions.flask.model.EventDetail create(long eventDetailId);

	/**
	* Removes the event detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventDetailId the primary key of the event detail
	* @return the event detail that was removed
	* @throws com.rumbasolutions.flask.NoSuchEventDetailException if a event detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventDetail remove(long eventDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailException;

	public com.rumbasolutions.flask.model.EventDetail updateImpl(
		com.rumbasolutions.flask.model.EventDetail eventDetail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event detail with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchEventDetailException} if it could not be found.
	*
	* @param eventDetailId the primary key of the event detail
	* @return the event detail
	* @throws com.rumbasolutions.flask.NoSuchEventDetailException if a event detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventDetail findByPrimaryKey(
		long eventDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailException;

	/**
	* Returns the event detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventDetailId the primary key of the event detail
	* @return the event detail, or <code>null</code> if a event detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventDetail fetchByPrimaryKey(
		long eventDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the event details.
	*
	* @return the event details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.EventDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.EventDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.EventDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the event details from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event details.
	*
	* @return the number of event details
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}