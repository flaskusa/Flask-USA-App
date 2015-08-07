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

import com.rumbasolutions.flask.model.UserEvent;

/**
 * The persistence interface for the user event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see UserEventPersistenceImpl
 * @see UserEventUtil
 * @generated
 */
public interface UserEventPersistence extends BasePersistence<UserEvent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserEventUtil} to access the user event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the user events where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.UserEvent> findByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user events where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.UserEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user events
	* @param end the upper bound of the range of user events (not inclusive)
	* @return the range of matching user events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.UserEvent> findByuserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user events where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.UserEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user events
	* @param end the upper bound of the range of user events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.UserEvent> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user event in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user event
	* @throws com.rumbasolutions.flask.NoSuchUserEventException if a matching user event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.UserEvent findByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchUserEventException;

	/**
	* Returns the first user event in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user event, or <code>null</code> if a matching user event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.UserEvent fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last user event in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user event
	* @throws com.rumbasolutions.flask.NoSuchUserEventException if a matching user event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.UserEvent findByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchUserEventException;

	/**
	* Returns the last user event in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user event, or <code>null</code> if a matching user event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.UserEvent fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user events before and after the current user event in the ordered set where userId = &#63;.
	*
	* @param userEventId the primary key of the current user event
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user event
	* @throws com.rumbasolutions.flask.NoSuchUserEventException if a user event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.UserEvent[] findByuserId_PrevAndNext(
		long userEventId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchUserEventException;

	/**
	* Removes all the user events where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user events where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user events
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user event where userId = &#63; and eventId = &#63; or throws a {@link com.rumbasolutions.flask.NoSuchUserEventException} if it could not be found.
	*
	* @param userId the user ID
	* @param eventId the event ID
	* @return the matching user event
	* @throws com.rumbasolutions.flask.NoSuchUserEventException if a matching user event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.UserEvent findByuserEvent(
		long userId, long eventId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchUserEventException;

	/**
	* Returns the user event where userId = &#63; and eventId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param eventId the event ID
	* @return the matching user event, or <code>null</code> if a matching user event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.UserEvent fetchByuserEvent(
		long userId, long eventId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user event where userId = &#63; and eventId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param eventId the event ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user event, or <code>null</code> if a matching user event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.UserEvent fetchByuserEvent(
		long userId, long eventId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user event where userId = &#63; and eventId = &#63; from the database.
	*
	* @param userId the user ID
	* @param eventId the event ID
	* @return the user event that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.UserEvent removeByuserEvent(
		long userId, long eventId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchUserEventException;

	/**
	* Returns the number of user events where userId = &#63; and eventId = &#63;.
	*
	* @param userId the user ID
	* @param eventId the event ID
	* @return the number of matching user events
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserEvent(long userId, long eventId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the user event in the entity cache if it is enabled.
	*
	* @param userEvent the user event
	*/
	public void cacheResult(com.rumbasolutions.flask.model.UserEvent userEvent);

	/**
	* Caches the user events in the entity cache if it is enabled.
	*
	* @param userEvents the user events
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.UserEvent> userEvents);

	/**
	* Creates a new user event with the primary key. Does not add the user event to the database.
	*
	* @param userEventId the primary key for the new user event
	* @return the new user event
	*/
	public com.rumbasolutions.flask.model.UserEvent create(long userEventId);

	/**
	* Removes the user event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userEventId the primary key of the user event
	* @return the user event that was removed
	* @throws com.rumbasolutions.flask.NoSuchUserEventException if a user event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.UserEvent remove(long userEventId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchUserEventException;

	public com.rumbasolutions.flask.model.UserEvent updateImpl(
		com.rumbasolutions.flask.model.UserEvent userEvent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user event with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchUserEventException} if it could not be found.
	*
	* @param userEventId the primary key of the user event
	* @return the user event
	* @throws com.rumbasolutions.flask.NoSuchUserEventException if a user event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.UserEvent findByPrimaryKey(
		long userEventId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchUserEventException;

	/**
	* Returns the user event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userEventId the primary key of the user event
	* @return the user event, or <code>null</code> if a user event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.UserEvent fetchByPrimaryKey(
		long userEventId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user events.
	*
	* @return the user events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.UserEvent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.UserEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user events
	* @param end the upper bound of the range of user events (not inclusive)
	* @return the range of user events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.UserEvent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.UserEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user events
	* @param end the upper bound of the range of user events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user events
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.UserEvent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user events from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user events.
	*
	* @return the number of user events
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}