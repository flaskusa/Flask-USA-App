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

import com.rumbasolutions.flask.model.SupplyList;

import java.util.List;

/**
 * The persistence utility for the supply list service. This utility wraps {@link SupplyListPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplyListPersistence
 * @see SupplyListPersistenceImpl
 * @generated
 */
public class SupplyListUtil {
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
	public static void clearCache(SupplyList supplyList) {
		getPersistence().clearCache(supplyList);
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
	public static List<SupplyList> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SupplyList> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SupplyList> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SupplyList update(SupplyList supplyList)
		throws SystemException {
		return getPersistence().update(supplyList);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SupplyList update(SupplyList supplyList,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(supplyList, serviceContext);
	}

	/**
	* Returns all the supply lists where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching supply lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.SupplyList> findByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserId(userId);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.SupplyList> findByuserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserId(userId, start, end);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.SupplyList> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first supply list in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supply list
	* @throws com.rumbasolutions.flask.NoSuchSupplyListException if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.SupplyList findByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException {
		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first supply list in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supply list, or <code>null</code> if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.SupplyList fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last supply list in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supply list
	* @throws com.rumbasolutions.flask.NoSuchSupplyListException if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.SupplyList findByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException {
		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last supply list in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supply list, or <code>null</code> if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.SupplyList fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

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
	public static com.rumbasolutions.flask.model.SupplyList[] findByuserId_PrevAndNext(
		long supplyListId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException {
		return getPersistence()
				   .findByuserId_PrevAndNext(supplyListId, userId,
			orderByComparator);
	}

	/**
	* Removes all the supply lists where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByuserId(userId);
	}

	/**
	* Returns the number of supply lists where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching supply lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByuserId(userId);
	}

	/**
	* Returns all the supply lists where isSystem = &#63;.
	*
	* @param isSystem the is system
	* @return the matching supply lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.SupplyList> findByisSystem(
		boolean isSystem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByisSystem(isSystem);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.SupplyList> findByisSystem(
		boolean isSystem, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByisSystem(isSystem, start, end);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.SupplyList> findByisSystem(
		boolean isSystem, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByisSystem(isSystem, start, end, orderByComparator);
	}

	/**
	* Returns the first supply list in the ordered set where isSystem = &#63;.
	*
	* @param isSystem the is system
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supply list
	* @throws com.rumbasolutions.flask.NoSuchSupplyListException if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.SupplyList findByisSystem_First(
		boolean isSystem,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException {
		return getPersistence().findByisSystem_First(isSystem, orderByComparator);
	}

	/**
	* Returns the first supply list in the ordered set where isSystem = &#63;.
	*
	* @param isSystem the is system
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching supply list, or <code>null</code> if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.SupplyList fetchByisSystem_First(
		boolean isSystem,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByisSystem_First(isSystem, orderByComparator);
	}

	/**
	* Returns the last supply list in the ordered set where isSystem = &#63;.
	*
	* @param isSystem the is system
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supply list
	* @throws com.rumbasolutions.flask.NoSuchSupplyListException if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.SupplyList findByisSystem_Last(
		boolean isSystem,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException {
		return getPersistence().findByisSystem_Last(isSystem, orderByComparator);
	}

	/**
	* Returns the last supply list in the ordered set where isSystem = &#63;.
	*
	* @param isSystem the is system
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching supply list, or <code>null</code> if a matching supply list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.SupplyList fetchByisSystem_Last(
		boolean isSystem,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByisSystem_Last(isSystem, orderByComparator);
	}

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
	public static com.rumbasolutions.flask.model.SupplyList[] findByisSystem_PrevAndNext(
		long supplyListId, boolean isSystem,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException {
		return getPersistence()
				   .findByisSystem_PrevAndNext(supplyListId, isSystem,
			orderByComparator);
	}

	/**
	* Removes all the supply lists where isSystem = &#63; from the database.
	*
	* @param isSystem the is system
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByisSystem(boolean isSystem)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByisSystem(isSystem);
	}

	/**
	* Returns the number of supply lists where isSystem = &#63;.
	*
	* @param isSystem the is system
	* @return the number of matching supply lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countByisSystem(boolean isSystem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByisSystem(isSystem);
	}

	/**
	* Caches the supply list in the entity cache if it is enabled.
	*
	* @param supplyList the supply list
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.SupplyList supplyList) {
		getPersistence().cacheResult(supplyList);
	}

	/**
	* Caches the supply lists in the entity cache if it is enabled.
	*
	* @param supplyLists the supply lists
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.SupplyList> supplyLists) {
		getPersistence().cacheResult(supplyLists);
	}

	/**
	* Creates a new supply list with the primary key. Does not add the supply list to the database.
	*
	* @param supplyListId the primary key for the new supply list
	* @return the new supply list
	*/
	public static com.rumbasolutions.flask.model.SupplyList create(
		long supplyListId) {
		return getPersistence().create(supplyListId);
	}

	/**
	* Removes the supply list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param supplyListId the primary key of the supply list
	* @return the supply list that was removed
	* @throws com.rumbasolutions.flask.NoSuchSupplyListException if a supply list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.SupplyList remove(
		long supplyListId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException {
		return getPersistence().remove(supplyListId);
	}

	public static com.rumbasolutions.flask.model.SupplyList updateImpl(
		com.rumbasolutions.flask.model.SupplyList supplyList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(supplyList);
	}

	/**
	* Returns the supply list with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchSupplyListException} if it could not be found.
	*
	* @param supplyListId the primary key of the supply list
	* @return the supply list
	* @throws com.rumbasolutions.flask.NoSuchSupplyListException if a supply list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.SupplyList findByPrimaryKey(
		long supplyListId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchSupplyListException {
		return getPersistence().findByPrimaryKey(supplyListId);
	}

	/**
	* Returns the supply list with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param supplyListId the primary key of the supply list
	* @return the supply list, or <code>null</code> if a supply list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.SupplyList fetchByPrimaryKey(
		long supplyListId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(supplyListId);
	}

	/**
	* Returns all the supply lists.
	*
	* @return the supply lists
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.SupplyList> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.SupplyList> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.SupplyList> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the supply lists from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of supply lists.
	*
	* @return the number of supply lists
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SupplyListPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SupplyListPersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					SupplyListPersistence.class.getName());

			ReferenceRegistry.registerReference(SupplyListUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SupplyListPersistence persistence) {
	}

	private static SupplyListPersistence _persistence;
}