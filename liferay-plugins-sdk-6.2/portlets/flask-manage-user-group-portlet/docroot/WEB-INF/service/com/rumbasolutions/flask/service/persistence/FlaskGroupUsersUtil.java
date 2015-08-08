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

import com.rumbasolutions.flask.model.FlaskGroupUsers;

import java.util.List;

/**
 * The persistence utility for the flask group users service. This utility wraps {@link FlaskGroupUsersPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupUsersPersistence
 * @see FlaskGroupUsersPersistenceImpl
 * @generated
 */
public class FlaskGroupUsersUtil {
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
	public static void clearCache(FlaskGroupUsers flaskGroupUsers) {
		getPersistence().clearCache(flaskGroupUsers);
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
	public static List<FlaskGroupUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FlaskGroupUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FlaskGroupUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FlaskGroupUsers update(FlaskGroupUsers flaskGroupUsers)
		throws SystemException {
		return getPersistence().update(flaskGroupUsers);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FlaskGroupUsers update(FlaskGroupUsers flaskGroupUsers,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(flaskGroupUsers, serviceContext);
	}

	/**
	* Returns all the flask group userses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching flask group userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> findByUserGroups(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserGroups(groupId);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> findByUserGroups(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserGroups(groupId, start, end);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> findByUserGroups(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserGroups(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first flask group users in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask group users
	* @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a matching flask group users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.FlaskGroupUsers findByUserGroups_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskGroupUsersException {
		return getPersistence()
				   .findByUserGroups_First(groupId, orderByComparator);
	}

	/**
	* Returns the first flask group users in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask group users, or <code>null</code> if a matching flask group users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.FlaskGroupUsers fetchByUserGroups_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserGroups_First(groupId, orderByComparator);
	}

	/**
	* Returns the last flask group users in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask group users
	* @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a matching flask group users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.FlaskGroupUsers findByUserGroups_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskGroupUsersException {
		return getPersistence().findByUserGroups_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last flask group users in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask group users, or <code>null</code> if a matching flask group users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.FlaskGroupUsers fetchByUserGroups_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserGroups_Last(groupId, orderByComparator);
	}

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
	public static com.rumbasolutions.flask.model.FlaskGroupUsers[] findByUserGroups_PrevAndNext(
		long groupUserId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskGroupUsersException {
		return getPersistence()
				   .findByUserGroups_PrevAndNext(groupUserId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the flask group userses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserGroups(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserGroups(groupId);
	}

	/**
	* Returns the number of flask group userses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching flask group userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserGroups(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserGroups(groupId);
	}

	/**
	* Caches the flask group users in the entity cache if it is enabled.
	*
	* @param flaskGroupUsers the flask group users
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.FlaskGroupUsers flaskGroupUsers) {
		getPersistence().cacheResult(flaskGroupUsers);
	}

	/**
	* Caches the flask group userses in the entity cache if it is enabled.
	*
	* @param flaskGroupUserses the flask group userses
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> flaskGroupUserses) {
		getPersistence().cacheResult(flaskGroupUserses);
	}

	/**
	* Creates a new flask group users with the primary key. Does not add the flask group users to the database.
	*
	* @param groupUserId the primary key for the new flask group users
	* @return the new flask group users
	*/
	public static com.rumbasolutions.flask.model.FlaskGroupUsers create(
		long groupUserId) {
		return getPersistence().create(groupUserId);
	}

	/**
	* Removes the flask group users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupUserId the primary key of the flask group users
	* @return the flask group users that was removed
	* @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a flask group users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.FlaskGroupUsers remove(
		long groupUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskGroupUsersException {
		return getPersistence().remove(groupUserId);
	}

	public static com.rumbasolutions.flask.model.FlaskGroupUsers updateImpl(
		com.rumbasolutions.flask.model.FlaskGroupUsers flaskGroupUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(flaskGroupUsers);
	}

	/**
	* Returns the flask group users with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchFlaskGroupUsersException} if it could not be found.
	*
	* @param groupUserId the primary key of the flask group users
	* @return the flask group users
	* @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a flask group users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.FlaskGroupUsers findByPrimaryKey(
		long groupUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskGroupUsersException {
		return getPersistence().findByPrimaryKey(groupUserId);
	}

	/**
	* Returns the flask group users with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param groupUserId the primary key of the flask group users
	* @return the flask group users, or <code>null</code> if a flask group users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.FlaskGroupUsers fetchByPrimaryKey(
		long groupUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(groupUserId);
	}

	/**
	* Returns all the flask group userses.
	*
	* @return the flask group userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the flask group userses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of flask group userses.
	*
	* @return the number of flask group userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FlaskGroupUsersPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FlaskGroupUsersPersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					FlaskGroupUsersPersistence.class.getName());

			ReferenceRegistry.registerReference(FlaskGroupUsersUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FlaskGroupUsersPersistence persistence) {
	}

	private static FlaskGroupUsersPersistence _persistence;
}