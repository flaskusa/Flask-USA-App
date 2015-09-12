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

import com.rumbasolutions.flask.model.TailgateUsers;

import java.util.List;

/**
 * The persistence utility for the tailgate users service. This utility wraps {@link TailgateUsersPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TailgateUsersPersistence
 * @see TailgateUsersPersistenceImpl
 * @generated
 */
public class TailgateUsersUtil {
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
	public static void clearCache(TailgateUsers tailgateUsers) {
		getPersistence().clearCache(tailgateUsers);
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
	public static List<TailgateUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TailgateUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TailgateUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TailgateUsers update(TailgateUsers tailgateUsers)
		throws SystemException {
		return getPersistence().update(tailgateUsers);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TailgateUsers update(TailgateUsers tailgateUsers,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tailgateUsers, serviceContext);
	}

	/**
	* Returns all the tailgate userses where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @return the matching tailgate userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateUsers> findBytailgateGroups(
		long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytailgateGroups(tailgateId);
	}

	/**
	* Returns a range of all the tailgate userses where tailgateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tailgateId the tailgate ID
	* @param start the lower bound of the range of tailgate userses
	* @param end the upper bound of the range of tailgate userses (not inclusive)
	* @return the range of matching tailgate userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateUsers> findBytailgateGroups(
		long tailgateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytailgateGroups(tailgateId, start, end);
	}

	/**
	* Returns an ordered range of all the tailgate userses where tailgateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tailgateId the tailgate ID
	* @param start the lower bound of the range of tailgate userses
	* @param end the upper bound of the range of tailgate userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tailgate userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateUsers> findBytailgateGroups(
		long tailgateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBytailgateGroups(tailgateId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first tailgate users in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate users
	* @throws com.rumbasolutions.flask.NoSuchTailgateUsersException if a matching tailgate users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateUsers findBytailgateGroups_First(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateUsersException {
		return getPersistence()
				   .findBytailgateGroups_First(tailgateId, orderByComparator);
	}

	/**
	* Returns the first tailgate users in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate users, or <code>null</code> if a matching tailgate users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateUsers fetchBytailgateGroups_First(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBytailgateGroups_First(tailgateId, orderByComparator);
	}

	/**
	* Returns the last tailgate users in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate users
	* @throws com.rumbasolutions.flask.NoSuchTailgateUsersException if a matching tailgate users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateUsers findBytailgateGroups_Last(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateUsersException {
		return getPersistence()
				   .findBytailgateGroups_Last(tailgateId, orderByComparator);
	}

	/**
	* Returns the last tailgate users in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate users, or <code>null</code> if a matching tailgate users could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateUsers fetchBytailgateGroups_Last(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBytailgateGroups_Last(tailgateId, orderByComparator);
	}

	/**
	* Returns the tailgate userses before and after the current tailgate users in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateUserId the primary key of the current tailgate users
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tailgate users
	* @throws com.rumbasolutions.flask.NoSuchTailgateUsersException if a tailgate users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateUsers[] findBytailgateGroups_PrevAndNext(
		long tailgateUserId, long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateUsersException {
		return getPersistence()
				   .findBytailgateGroups_PrevAndNext(tailgateUserId,
			tailgateId, orderByComparator);
	}

	/**
	* Removes all the tailgate userses where tailgateId = &#63; from the database.
	*
	* @param tailgateId the tailgate ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBytailgateGroups(long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBytailgateGroups(tailgateId);
	}

	/**
	* Returns the number of tailgate userses where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @return the number of matching tailgate userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBytailgateGroups(long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBytailgateGroups(tailgateId);
	}

	/**
	* Caches the tailgate users in the entity cache if it is enabled.
	*
	* @param tailgateUsers the tailgate users
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.TailgateUsers tailgateUsers) {
		getPersistence().cacheResult(tailgateUsers);
	}

	/**
	* Caches the tailgate userses in the entity cache if it is enabled.
	*
	* @param tailgateUserses the tailgate userses
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.TailgateUsers> tailgateUserses) {
		getPersistence().cacheResult(tailgateUserses);
	}

	/**
	* Creates a new tailgate users with the primary key. Does not add the tailgate users to the database.
	*
	* @param tailgateUserId the primary key for the new tailgate users
	* @return the new tailgate users
	*/
	public static com.rumbasolutions.flask.model.TailgateUsers create(
		long tailgateUserId) {
		return getPersistence().create(tailgateUserId);
	}

	/**
	* Removes the tailgate users with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateUserId the primary key of the tailgate users
	* @return the tailgate users that was removed
	* @throws com.rumbasolutions.flask.NoSuchTailgateUsersException if a tailgate users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateUsers remove(
		long tailgateUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateUsersException {
		return getPersistence().remove(tailgateUserId);
	}

	public static com.rumbasolutions.flask.model.TailgateUsers updateImpl(
		com.rumbasolutions.flask.model.TailgateUsers tailgateUsers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tailgateUsers);
	}

	/**
	* Returns the tailgate users with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchTailgateUsersException} if it could not be found.
	*
	* @param tailgateUserId the primary key of the tailgate users
	* @return the tailgate users
	* @throws com.rumbasolutions.flask.NoSuchTailgateUsersException if a tailgate users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateUsers findByPrimaryKey(
		long tailgateUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateUsersException {
		return getPersistence().findByPrimaryKey(tailgateUserId);
	}

	/**
	* Returns the tailgate users with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tailgateUserId the primary key of the tailgate users
	* @return the tailgate users, or <code>null</code> if a tailgate users with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateUsers fetchByPrimaryKey(
		long tailgateUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tailgateUserId);
	}

	/**
	* Returns all the tailgate userses.
	*
	* @return the tailgate userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateUsers> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tailgate userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tailgate userses
	* @param end the upper bound of the range of tailgate userses (not inclusive)
	* @return the range of tailgate userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateUsers> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tailgate userses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tailgate userses
	* @param end the upper bound of the range of tailgate userses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tailgate userses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateUsers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tailgate userses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tailgate userses.
	*
	* @return the number of tailgate userses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TailgateUsersPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TailgateUsersPersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					TailgateUsersPersistence.class.getName());

			ReferenceRegistry.registerReference(TailgateUsersUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TailgateUsersPersistence persistence) {
	}

	private static TailgateUsersPersistence _persistence;
}