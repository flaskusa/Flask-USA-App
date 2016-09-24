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

import com.rumbasolutions.flask.model.SupplyList;

/**
 * The persistence interface for the supply list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplyListPersistenceImpl
 * @see SupplyListUtil
 * @generated
 */
public interface SupplyListPersistence extends BasePersistence<SupplyList> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SupplyListUtil} to access the supply list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the supply lists where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching supply lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.SupplyList> findByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the supply lists where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of supply lists
	* @param end the upper bound of the range of supply lists (not inclusive)
	* @return the range of matching supply lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.SupplyList> findByuserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the supply lists where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of supply lists
	* @param end the upper bound of the range of supply lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching supply lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.SupplyList> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first supply list in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supply list
	* @throws com.rumbasolutions.flask.NoSuchSupplyListException if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList findByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException;

	/**
	* Returns the first supply list in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supply list, or <code>null</code> if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last supply list in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supply list
	* @throws com.rumbasolutions.flask.NoSuchSupplyListException if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList findByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException;

	/**
	* Returns the last supply list in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supply list, or <code>null</code> if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the supply lists before and after the current supply list in the ordered set where userId = &#63;.
	*
	* @param supplyListId the primary key of the current supply list
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next supply list
	* @throws com.rumbasolutions.flask.NoSuchSupplyListException if a supply list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList[] findByuserId_PrevAndNext(
		long supplyListId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException;

	/**
	* Removes all the supply lists where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of supply lists where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching supply lists
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the supply lists where isSystem = &#63;.
	*
	* @param isSystem the is system
	* @return the matching supply lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.SupplyList> findByisSystem(
		boolean isSystem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the supply lists where isSystem = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isSystem the is system
	* @param start the lower bound of the range of supply lists
	* @param end the upper bound of the range of supply lists (not inclusive)
	* @return the range of matching supply lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.SupplyList> findByisSystem(
		boolean isSystem, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the supply lists where isSystem = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isSystem the is system
	* @param start the lower bound of the range of supply lists
	* @param end the upper bound of the range of supply lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching supply lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.SupplyList> findByisSystem(
		boolean isSystem, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first supply list in the ordered set where isSystem = &#63;.
	*
	* @param isSystem the is system
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supply list
	* @throws com.rumbasolutions.flask.NoSuchSupplyListException if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList findByisSystem_First(
		boolean isSystem,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException;

	/**
	* Returns the first supply list in the ordered set where isSystem = &#63;.
	*
	* @param isSystem the is system
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supply list, or <code>null</code> if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList fetchByisSystem_First(
		boolean isSystem,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last supply list in the ordered set where isSystem = &#63;.
	*
	* @param isSystem the is system
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supply list
	* @throws com.rumbasolutions.flask.NoSuchSupplyListException if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList findByisSystem_Last(
		boolean isSystem,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException;

	/**
	* Returns the last supply list in the ordered set where isSystem = &#63;.
	*
	* @param isSystem the is system
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supply list, or <code>null</code> if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList fetchByisSystem_Last(
		boolean isSystem,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the supply lists before and after the current supply list in the ordered set where isSystem = &#63;.
	*
	* @param supplyListId the primary key of the current supply list
	* @param isSystem the is system
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next supply list
	* @throws com.rumbasolutions.flask.NoSuchSupplyListException if a supply list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList[] findByisSystem_PrevAndNext(
		long supplyListId, boolean isSystem,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException;

	/**
	* Removes all the supply lists where isSystem = &#63; from the database.
	*
	* @param isSystem the is system
	* @throws SystemException if a system exception occurred
	*/
	public void removeByisSystem(boolean isSystem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of supply lists where isSystem = &#63;.
	*
	* @param isSystem the is system
	* @return the number of matching supply lists
	* @throws SystemException if a system exception occurred
	*/
	public int countByisSystem(boolean isSystem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the supply lists where supplyListName = &#63;.
	*
	* @param supplyListName the supply list name
	* @return the matching supply lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.SupplyList> findBysupplyListName(
		java.lang.String supplyListName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the supply lists where supplyListName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param supplyListName the supply list name
	* @param start the lower bound of the range of supply lists
	* @param end the upper bound of the range of supply lists (not inclusive)
	* @return the range of matching supply lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.SupplyList> findBysupplyListName(
		java.lang.String supplyListName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the supply lists where supplyListName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param supplyListName the supply list name
	* @param start the lower bound of the range of supply lists
	* @param end the upper bound of the range of supply lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching supply lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.SupplyList> findBysupplyListName(
		java.lang.String supplyListName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first supply list in the ordered set where supplyListName = &#63;.
	*
	* @param supplyListName the supply list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supply list
	* @throws com.rumbasolutions.flask.NoSuchSupplyListException if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList findBysupplyListName_First(
		java.lang.String supplyListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException;

	/**
	* Returns the first supply list in the ordered set where supplyListName = &#63;.
	*
	* @param supplyListName the supply list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supply list, or <code>null</code> if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList fetchBysupplyListName_First(
		java.lang.String supplyListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last supply list in the ordered set where supplyListName = &#63;.
	*
	* @param supplyListName the supply list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supply list
	* @throws com.rumbasolutions.flask.NoSuchSupplyListException if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList findBysupplyListName_Last(
		java.lang.String supplyListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException;

	/**
	* Returns the last supply list in the ordered set where supplyListName = &#63;.
	*
	* @param supplyListName the supply list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supply list, or <code>null</code> if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList fetchBysupplyListName_Last(
		java.lang.String supplyListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the supply lists before and after the current supply list in the ordered set where supplyListName = &#63;.
	*
	* @param supplyListId the primary key of the current supply list
	* @param supplyListName the supply list name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next supply list
	* @throws com.rumbasolutions.flask.NoSuchSupplyListException if a supply list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList[] findBysupplyListName_PrevAndNext(
		long supplyListId, java.lang.String supplyListName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException;

	/**
	* Removes all the supply lists where supplyListName = &#63; from the database.
	*
	* @param supplyListName the supply list name
	* @throws SystemException if a system exception occurred
	*/
	public void removeBysupplyListName(java.lang.String supplyListName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of supply lists where supplyListName = &#63;.
	*
	* @param supplyListName the supply list name
	* @return the number of matching supply lists
	* @throws SystemException if a system exception occurred
	*/
	public int countBysupplyListName(java.lang.String supplyListName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the supply list in the entity cache if it is enabled.
	*
	* @param supplyList the supply list
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.SupplyList supplyList);

	/**
	* Caches the supply lists in the entity cache if it is enabled.
	*
	* @param supplyLists the supply lists
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.SupplyList> supplyLists);

	/**
	* Creates a new supply list with the primary key. Does not add the supply list to the database.
	*
	* @param supplyListId the primary key for the new supply list
	* @return the new supply list
	*/
	public com.rumbasolutions.flask.model.SupplyList create(long supplyListId);

	/**
	* Removes the supply list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param supplyListId the primary key of the supply list
	* @return the supply list that was removed
	* @throws com.rumbasolutions.flask.NoSuchSupplyListException if a supply list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList remove(long supplyListId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException;

	public com.rumbasolutions.flask.model.SupplyList updateImpl(
		com.rumbasolutions.flask.model.SupplyList supplyList)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the supply list with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchSupplyListException} if it could not be found.
	*
	* @param supplyListId the primary key of the supply list
	* @return the supply list
	* @throws com.rumbasolutions.flask.NoSuchSupplyListException if a supply list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList findByPrimaryKey(
		long supplyListId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException;

	/**
	* Returns the supply list with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param supplyListId the primary key of the supply list
	* @return the supply list, or <code>null</code> if a supply list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.SupplyList fetchByPrimaryKey(
		long supplyListId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the supply lists.
	*
	* @return the supply lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.SupplyList> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the supply lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of supply lists
	* @param end the upper bound of the range of supply lists (not inclusive)
	* @return the range of supply lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.SupplyList> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the supply lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of supply lists
	* @param end the upper bound of the range of supply lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of supply lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.SupplyList> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the supply lists from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of supply lists.
	*
	* @return the number of supply lists
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}