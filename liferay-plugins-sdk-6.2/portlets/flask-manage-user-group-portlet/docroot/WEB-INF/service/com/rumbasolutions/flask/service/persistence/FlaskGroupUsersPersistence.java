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

import com.rumbasolutions.flask.model.FlaskGroupUsers;

/**
 * The persistence interface for the flask group users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupUsersPersistenceImpl
 * @see FlaskGroupUsersUtil
 * @generated
 */
public interface FlaskGroupUsersPersistence extends BasePersistence<FlaskGroupUsers> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FlaskGroupUsersUtil} to access the flask group users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the flask group userses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching flask group userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> findByUserGroups(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flask group userses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of flask group userses
	* @param end the upper bound of the range of flask group userses (not inclusive)
	* @return the range of matching flask group userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> findByUserGroups(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flask group userses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of flask group userses
	* @param end the upper bound of the range of flask group userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flask group userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> findByUserGroups(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask group users in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask group users
	* @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a matching flask group users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers findByUserGroups_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskGroupUsersException;

	/**
	* Returns the first flask group users in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask group users, or <code>null</code> if a matching flask group users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers fetchByUserGroups_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask group users in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask group users
	* @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a matching flask group users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers findByUserGroups_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskGroupUsersException;

	/**
	* Returns the last flask group users in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask group users, or <code>null</code> if a matching flask group users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers fetchByUserGroups_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask group userses before and after the current flask group users in the ordered set where groupId = &#63;.
	*
	* @param groupUserId the primary key of the current flask group users
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flask group users
	* @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a flask group users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers[] findByUserGroups_PrevAndNext(
		long groupUserId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskGroupUsersException;

	/**
	* Removes all the flask group userses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserGroups(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask group userses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching flask group userses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserGroups(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flask group userses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching flask group userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flask group userses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of flask group userses
	* @param end the upper bound of the range of flask group userses (not inclusive)
	* @return the range of matching flask group userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flask group userses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of flask group userses
	* @param end the upper bound of the range of flask group userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flask group userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask group users in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask group users
	* @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a matching flask group users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskGroupUsersException;

	/**
	* Returns the first flask group users in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask group users, or <code>null</code> if a matching flask group users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask group users in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask group users
	* @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a matching flask group users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskGroupUsersException;

	/**
	* Returns the last flask group users in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask group users, or <code>null</code> if a matching flask group users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask group userses before and after the current flask group users in the ordered set where userId = &#63;.
	*
	* @param groupUserId the primary key of the current flask group users
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flask group users
	* @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a flask group users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers[] findByUserId_PrevAndNext(
		long groupUserId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskGroupUsersException;

	/**
	* Removes all the flask group userses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask group userses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching flask group userses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask group users where userId = &#63; and groupId = &#63; or throws a {@link com.rumbasolutions.flask.NoSuchFlaskGroupUsersException} if it could not be found.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching flask group users
	* @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a matching flask group users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers findByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskGroupUsersException;

	/**
	* Returns the flask group users where userId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching flask group users, or <code>null</code> if a matching flask group users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers fetchByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask group users where userId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching flask group users, or <code>null</code> if a matching flask group users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers fetchByUserIdGroupId(
		long userId, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the flask group users where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the flask group users that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers removeByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskGroupUsersException;

	/**
	* Returns the number of flask group userses where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching flask group userses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the flask group users in the entity cache if it is enabled.
	*
	* @param flaskGroupUsers the flask group users
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.FlaskGroupUsers flaskGroupUsers);

	/**
	* Caches the flask group userses in the entity cache if it is enabled.
	*
	* @param flaskGroupUserses the flask group userses
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> flaskGroupUserses);

	/**
	* Creates a new flask group users with the primary key. Does not add the flask group users to the database.
	*
	* @param groupUserId the primary key for the new flask group users
	* @return the new flask group users
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers create(
		long groupUserId);

	/**
	* Removes the flask group users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupUserId the primary key of the flask group users
	* @return the flask group users that was removed
	* @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a flask group users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers remove(
		long groupUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskGroupUsersException;

	public com.rumbasolutions.flask.model.FlaskGroupUsers updateImpl(
		com.rumbasolutions.flask.model.FlaskGroupUsers flaskGroupUsers)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask group users with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchFlaskGroupUsersException} if it could not be found.
	*
	* @param groupUserId the primary key of the flask group users
	* @return the flask group users
	* @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a flask group users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers findByPrimaryKey(
		long groupUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskGroupUsersException;

	/**
	* Returns the flask group users with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param groupUserId the primary key of the flask group users
	* @return the flask group users, or <code>null</code> if a flask group users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroupUsers fetchByPrimaryKey(
		long groupUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flask group userses.
	*
	* @return the flask group userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flask group userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask group userses
	* @param end the upper bound of the range of flask group userses (not inclusive)
	* @return the range of flask group userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flask group userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask group userses
	* @param end the upper bound of the range of flask group userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of flask group userses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flask group userses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask group userses.
	*
	* @return the number of flask group userses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}