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

import com.rumbasolutions.flask.model.EventType;

/**
 * The persistence interface for the event type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventTypePersistenceImpl
 * @see EventTypeUtil
 * @generated
 */
public interface EventTypePersistence extends BasePersistence<EventType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventTypeUtil} to access the event type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the event type in the entity cache if it is enabled.
	*
	* @param eventType the event type
	*/
	public void cacheResult(com.rumbasolutions.flask.model.EventType eventType);

	/**
	* Caches the event types in the entity cache if it is enabled.
	*
	* @param eventTypes the event types
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.EventType> eventTypes);

	/**
	* Creates a new event type with the primary key. Does not add the event type to the database.
	*
	* @param eventTypeId the primary key for the new event type
	* @return the new event type
	*/
	public com.rumbasolutions.flask.model.EventType create(long eventTypeId);

	/**
	* Removes the event type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventTypeId the primary key of the event type
	* @return the event type that was removed
	* @throws com.rumbasolutions.flask.NoSuchEventTypeException if a event type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventType remove(long eventTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventTypeException;

	public com.rumbasolutions.flask.model.EventType updateImpl(
		com.rumbasolutions.flask.model.EventType eventType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the event type with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchEventTypeException} if it could not be found.
	*
	* @param eventTypeId the primary key of the event type
	* @return the event type
	* @throws com.rumbasolutions.flask.NoSuchEventTypeException if a event type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventType findByPrimaryKey(
		long eventTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventTypeException;

	/**
	* Returns the event type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventTypeId the primary key of the event type
	* @return the event type, or <code>null</code> if a event type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.EventType fetchByPrimaryKey(
		long eventTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the event types.
	*
	* @return the event types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.EventType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the event types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event types
	* @param end the upper bound of the range of event types (not inclusive)
	* @return the range of event types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.EventType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the event types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event types
	* @param end the upper bound of the range of event types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of event types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.EventType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the event types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of event types.
	*
	* @return the number of event types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}