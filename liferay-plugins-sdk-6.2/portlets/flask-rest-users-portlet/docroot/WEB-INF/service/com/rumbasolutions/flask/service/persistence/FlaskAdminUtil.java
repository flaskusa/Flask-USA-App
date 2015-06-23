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

import com.rumbasolutions.flask.model.FlaskAdmin;

import java.util.List;

/**
 * The persistence utility for the flask admin service. This utility wraps {@link FlaskAdminPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see FlaskAdminPersistence
 * @see FlaskAdminPersistenceImpl
 * @generated
 */
public class FlaskAdminUtil {
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
	public static void clearCache(FlaskAdmin flaskAdmin) {
		getPersistence().clearCache(flaskAdmin);
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
	public static List<FlaskAdmin> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FlaskAdmin> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FlaskAdmin> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FlaskAdmin update(FlaskAdmin flaskAdmin)
		throws SystemException {
		return getPersistence().update(flaskAdmin);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FlaskAdmin update(FlaskAdmin flaskAdmin,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(flaskAdmin, serviceContext);
	}

	/**
	* Caches the flask admin in the entity cache if it is enabled.
	*
	* @param flaskAdmin the flask admin
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.FlaskAdmin flaskAdmin) {
		getPersistence().cacheResult(flaskAdmin);
	}

	/**
	* Caches the flask admins in the entity cache if it is enabled.
	*
	* @param flaskAdmins the flask admins
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> flaskAdmins) {
		getPersistence().cacheResult(flaskAdmins);
	}

	/**
	* Creates a new flask admin with the primary key. Does not add the flask admin to the database.
	*
	* @param userId the primary key for the new flask admin
	* @return the new flask admin
	*/
	public static com.rumbasolutions.flask.model.FlaskAdmin create(long userId) {
		return getPersistence().create(userId);
	}

	/**
	* Removes the flask admin with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the flask admin
	* @return the flask admin that was removed
	* @throws com.rumbasolutions.flask.NoSuchFlaskAdminException if a flask admin with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.FlaskAdmin remove(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskAdminException {
		return getPersistence().remove(userId);
	}

	public static com.rumbasolutions.flask.model.FlaskAdmin updateImpl(
		com.rumbasolutions.flask.model.FlaskAdmin flaskAdmin)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(flaskAdmin);
	}

	/**
	* Returns the flask admin with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchFlaskAdminException} if it could not be found.
	*
	* @param userId the primary key of the flask admin
	* @return the flask admin
	* @throws com.rumbasolutions.flask.NoSuchFlaskAdminException if a flask admin with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.FlaskAdmin findByPrimaryKey(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskAdminException {
		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	* Returns the flask admin with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the flask admin
	* @return the flask admin, or <code>null</code> if a flask admin with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.FlaskAdmin fetchByPrimaryKey(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	/**
	* Returns all the flask admins.
	*
	* @return the flask admins
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the flask admins.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskAdminModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask admins
	* @param end the upper bound of the range of flask admins (not inclusive)
	* @return the range of flask admins
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the flask admins.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskAdminModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask admins
	* @param end the upper bound of the range of flask admins (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of flask admins
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the flask admins from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of flask admins.
	*
	* @return the number of flask admins
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FlaskAdminPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FlaskAdminPersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					FlaskAdminPersistence.class.getName());

			ReferenceRegistry.registerReference(FlaskAdminUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FlaskAdminPersistence persistence) {
	}

	private static FlaskAdminPersistence _persistence;
}