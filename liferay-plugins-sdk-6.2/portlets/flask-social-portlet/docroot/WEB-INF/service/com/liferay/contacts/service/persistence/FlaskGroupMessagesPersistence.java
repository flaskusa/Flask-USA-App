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

package com.liferay.contacts.service.persistence;

import com.liferay.contacts.model.FlaskGroupMessages;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the flask group messages service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupMessagesPersistenceImpl
 * @see FlaskGroupMessagesUtil
 * @generated
 */
public interface FlaskGroupMessagesPersistence extends BasePersistence<FlaskGroupMessages> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FlaskGroupMessagesUtil} to access the flask group messages persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the flask group messageses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching flask group messageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskGroupMessages> findBygroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flask group messageses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupMessagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of flask group messageses
	* @param end the upper bound of the range of flask group messageses (not inclusive)
	* @return the range of matching flask group messageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskGroupMessages> findBygroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flask group messageses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupMessagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of flask group messageses
	* @param end the upper bound of the range of flask group messageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flask group messageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskGroupMessages> findBygroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask group messages in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask group messages
	* @throws com.liferay.contacts.NoSuchFlaskGroupMessagesException if a matching flask group messages could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskGroupMessages findBygroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskGroupMessagesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask group messages in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask group messages, or <code>null</code> if a matching flask group messages could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskGroupMessages fetchBygroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask group messages in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask group messages
	* @throws com.liferay.contacts.NoSuchFlaskGroupMessagesException if a matching flask group messages could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskGroupMessages findBygroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskGroupMessagesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask group messages in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask group messages, or <code>null</code> if a matching flask group messages could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskGroupMessages fetchBygroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask group messageses before and after the current flask group messages in the ordered set where groupId = &#63;.
	*
	* @param groupMessagesId the primary key of the current flask group messages
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flask group messages
	* @throws com.liferay.contacts.NoSuchFlaskGroupMessagesException if a flask group messages with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskGroupMessages[] findBygroupId_PrevAndNext(
		long groupMessagesId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskGroupMessagesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flask group messageses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask group messageses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching flask group messageses
	* @throws SystemException if a system exception occurred
	*/
	public int countBygroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the flask group messages in the entity cache if it is enabled.
	*
	* @param flaskGroupMessages the flask group messages
	*/
	public void cacheResult(
		com.liferay.contacts.model.FlaskGroupMessages flaskGroupMessages);

	/**
	* Caches the flask group messageses in the entity cache if it is enabled.
	*
	* @param flaskGroupMessageses the flask group messageses
	*/
	public void cacheResult(
		java.util.List<com.liferay.contacts.model.FlaskGroupMessages> flaskGroupMessageses);

	/**
	* Creates a new flask group messages with the primary key. Does not add the flask group messages to the database.
	*
	* @param groupMessagesId the primary key for the new flask group messages
	* @return the new flask group messages
	*/
	public com.liferay.contacts.model.FlaskGroupMessages create(
		long groupMessagesId);

	/**
	* Removes the flask group messages with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupMessagesId the primary key of the flask group messages
	* @return the flask group messages that was removed
	* @throws com.liferay.contacts.NoSuchFlaskGroupMessagesException if a flask group messages with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskGroupMessages remove(
		long groupMessagesId)
		throws com.liferay.contacts.NoSuchFlaskGroupMessagesException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.contacts.model.FlaskGroupMessages updateImpl(
		com.liferay.contacts.model.FlaskGroupMessages flaskGroupMessages)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask group messages with the primary key or throws a {@link com.liferay.contacts.NoSuchFlaskGroupMessagesException} if it could not be found.
	*
	* @param groupMessagesId the primary key of the flask group messages
	* @return the flask group messages
	* @throws com.liferay.contacts.NoSuchFlaskGroupMessagesException if a flask group messages with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskGroupMessages findByPrimaryKey(
		long groupMessagesId)
		throws com.liferay.contacts.NoSuchFlaskGroupMessagesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask group messages with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param groupMessagesId the primary key of the flask group messages
	* @return the flask group messages, or <code>null</code> if a flask group messages with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskGroupMessages fetchByPrimaryKey(
		long groupMessagesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flask group messageses.
	*
	* @return the flask group messageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskGroupMessages> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flask group messageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupMessagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask group messageses
	* @param end the upper bound of the range of flask group messageses (not inclusive)
	* @return the range of flask group messageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskGroupMessages> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flask group messageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupMessagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask group messageses
	* @param end the upper bound of the range of flask group messageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of flask group messageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskGroupMessages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flask group messageses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask group messageses.
	*
	* @return the number of flask group messageses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}