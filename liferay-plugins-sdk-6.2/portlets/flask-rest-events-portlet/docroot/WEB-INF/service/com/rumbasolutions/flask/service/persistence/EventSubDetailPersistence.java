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

import com.rumbasolutions.flask.model.EventSubDetail;

/**
 * The persistence interface for the event sub detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventSubDetailPersistenceImpl
 * @see EventSubDetailUtil
 * @generated
 */
public interface EventSubDetailPersistence extends BasePersistence<EventSubDetail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventSubDetailUtil} to access the event sub detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the event sub details where eventDetailId = &#63;.
	*
	* @param eventDetailId the event detail ID
	* @return the matching event sub details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.EventSubDetail> findByEventDetailId(
		long eventDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the event sub details where eventDetailId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventDetailId the event detail ID
	* @param start the lower bound of the range of event sub details
	* @param end the upper bound of the range of event sub details (not inclusive)
	* @return the range of matching event sub details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.EventSubDetail> findByEventDetailId(
		long eventDetailId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the event sub details where eventDetailId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventDetailId the event detail ID
	* @param start the lower bound of the range of event sub details
	* @param end the upper bound of the range of event sub details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event sub details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.EventSubDetail> findByEventDetailId(
		long eventDetailId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first event sub detail in the ordered set where eventDetailId = &#63;.
	*
	* @param eventDetailId the event detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event sub detail
	* @throws com.rumbasolutions.flask.NoSuchEventSubDetailException if a matching event sub detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventSubDetail findByEventDetailId_First(
		long eventDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventSubDetailException;

	/**
	* Returns the first event sub detail in the ordered set where eventDetailId = &#63;.
	*
	* @param eventDetailId the event detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event sub detail, or <code>null</code> if a matching event sub detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventSubDetail fetchByEventDetailId_First(
		long eventDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last event sub detail in the ordered set where eventDetailId = &#63;.
	*
	* @param eventDetailId the event detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event sub detail
	* @throws com.rumbasolutions.flask.NoSuchEventSubDetailException if a matching event sub detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventSubDetail findByEventDetailId_Last(
		long eventDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventSubDetailException;

	/**
	* Returns the last event sub detail in the ordered set where eventDetailId = &#63;.
	*
	* @param eventDetailId the event detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event sub detail, or <code>null</code> if a matching event sub detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventSubDetail fetchByEventDetailId_Last(
		long eventDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event sub details before and after the current event sub detail in the ordered set where eventDetailId = &#63;.
	*
	* @param eventSubDetailId the primary key of the current event sub detail
	* @param eventDetailId the event detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event sub detail
	* @throws com.rumbasolutions.flask.NoSuchEventSubDetailException if a event sub detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventSubDetail[] findByEventDetailId_PrevAndNext(
		long eventSubDetailId, long eventDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventSubDetailException;

	/**
	* Removes all the event sub details where eventDetailId = &#63; from the database.
	*
	* @param eventDetailId the event detail ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEventDetailId(long eventDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event sub details where eventDetailId = &#63;.
	*
	* @param eventDetailId the event detail ID
	* @return the number of matching event sub details
	* @throws SystemException if a system exception occurred
	*/
	public int countByEventDetailId(long eventDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the event sub detail in the entity cache if it is enabled.
	*
	* @param eventSubDetail the event sub detail
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.EventSubDetail eventSubDetail);

	/**
	* Caches the event sub details in the entity cache if it is enabled.
	*
	* @param eventSubDetails the event sub details
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.EventSubDetail> eventSubDetails);

	/**
	* Creates a new event sub detail with the primary key. Does not add the event sub detail to the database.
	*
	* @param eventSubDetailId the primary key for the new event sub detail
	* @return the new event sub detail
	*/
	public com.rumbasolutions.flask.model.EventSubDetail create(
		long eventSubDetailId);

	/**
	* Removes the event sub detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventSubDetailId the primary key of the event sub detail
	* @return the event sub detail that was removed
	* @throws com.rumbasolutions.flask.NoSuchEventSubDetailException if a event sub detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventSubDetail remove(
		long eventSubDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventSubDetailException;

	public com.rumbasolutions.flask.model.EventSubDetail updateImpl(
		com.rumbasolutions.flask.model.EventSubDetail eventSubDetail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event sub detail with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchEventSubDetailException} if it could not be found.
	*
	* @param eventSubDetailId the primary key of the event sub detail
	* @return the event sub detail
	* @throws com.rumbasolutions.flask.NoSuchEventSubDetailException if a event sub detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventSubDetail findByPrimaryKey(
		long eventSubDetailId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventSubDetailException;

	/**
	* Returns the event sub detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventSubDetailId the primary key of the event sub detail
	* @return the event sub detail, or <code>null</code> if a event sub detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventSubDetail fetchByPrimaryKey(
		long eventSubDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the event sub details.
	*
	* @return the event sub details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.EventSubDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the event sub details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event sub details
	* @param end the upper bound of the range of event sub details (not inclusive)
	* @return the range of event sub details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.EventSubDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the event sub details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event sub details
	* @param end the upper bound of the range of event sub details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of event sub details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.EventSubDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the event sub details from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event sub details.
	*
	* @return the number of event sub details
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}