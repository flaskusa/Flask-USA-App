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

import com.rumbasolutions.flask.model.UserTailgate;

import java.util.List;

/**
 * The persistence utility for the user tailgate service. This utility wraps {@link UserTailgatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rajeshj
 * @see UserTailgatePersistence
 * @see UserTailgatePersistenceImpl
 * @generated
 */
public class UserTailgateUtil {
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
	public static void clearCache(UserTailgate userTailgate) {
		getPersistence().clearCache(userTailgate);
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
	public static List<UserTailgate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserTailgate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserTailgate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UserTailgate update(UserTailgate userTailgate)
		throws SystemException {
		return getPersistence().update(userTailgate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UserTailgate update(UserTailgate userTailgate,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userTailgate, serviceContext);
	}

	/**
	* Caches the user tailgate in the entity cache if it is enabled.
	*
	* @param userTailgate the user tailgate
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.UserTailgate userTailgate) {
		getPersistence().cacheResult(userTailgate);
	}

	/**
	* Caches the user tailgates in the entity cache if it is enabled.
	*
	* @param userTailgates the user tailgates
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.UserTailgate> userTailgates) {
		getPersistence().cacheResult(userTailgates);
	}

	/**
	* Creates a new user tailgate with the primary key. Does not add the user tailgate to the database.
	*
	* @param tailgateId the primary key for the new user tailgate
	* @return the new user tailgate
	*/
	public static com.rumbasolutions.flask.model.UserTailgate create(
		long tailgateId) {
		return getPersistence().create(tailgateId);
	}

	/**
	* Removes the user tailgate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateId the primary key of the user tailgate
	* @return the user tailgate that was removed
	* @throws com.rumbasolutions.flask.NoSuchUserTailgateException if a user tailgate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.UserTailgate remove(
		long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchUserTailgateException {
		return getPersistence().remove(tailgateId);
	}

	public static com.rumbasolutions.flask.model.UserTailgate updateImpl(
		com.rumbasolutions.flask.model.UserTailgate userTailgate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userTailgate);
	}

	/**
	* Returns the user tailgate with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchUserTailgateException} if it could not be found.
	*
	* @param tailgateId the primary key of the user tailgate
	* @return the user tailgate
	* @throws com.rumbasolutions.flask.NoSuchUserTailgateException if a user tailgate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.UserTailgate findByPrimaryKey(
		long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchUserTailgateException {
		return getPersistence().findByPrimaryKey(tailgateId);
	}

	/**
	* Returns the user tailgate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tailgateId the primary key of the user tailgate
	* @return the user tailgate, or <code>null</code> if a user tailgate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.UserTailgate fetchByPrimaryKey(
		long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tailgateId);
	}

	/**
	* Returns all the user tailgates.
	*
	* @return the user tailgates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.UserTailgate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user tailgates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.UserTailgateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user tailgates
	* @param end the upper bound of the range of user tailgates (not inclusive)
	* @return the range of user tailgates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.UserTailgate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user tailgates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.UserTailgateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user tailgates
	* @param end the upper bound of the range of user tailgates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user tailgates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.UserTailgate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user tailgates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user tailgates.
	*
	* @return the number of user tailgates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserTailgatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserTailgatePersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					UserTailgatePersistence.class.getName());

			ReferenceRegistry.registerReference(UserTailgateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UserTailgatePersistence persistence) {
	}

	private static UserTailgatePersistence _persistence;
}