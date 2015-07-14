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

import com.rumbasolutions.flask.model.InfoTypeCategory;

import java.util.List;

/**
 * The persistence utility for the info type category service. This utility wraps {@link InfoTypeCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see InfoTypeCategoryPersistence
 * @see InfoTypeCategoryPersistenceImpl
 * @generated
 */
public class InfoTypeCategoryUtil {
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
	public static void clearCache(InfoTypeCategory infoTypeCategory) {
		getPersistence().clearCache(infoTypeCategory);
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
	public static List<InfoTypeCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<InfoTypeCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<InfoTypeCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static InfoTypeCategory update(InfoTypeCategory infoTypeCategory)
		throws SystemException {
		return getPersistence().update(infoTypeCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static InfoTypeCategory update(InfoTypeCategory infoTypeCategory,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(infoTypeCategory, serviceContext);
	}

	/**
	* Caches the info type category in the entity cache if it is enabled.
	*
	* @param infoTypeCategory the info type category
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.InfoTypeCategory infoTypeCategory) {
		getPersistence().cacheResult(infoTypeCategory);
	}

	/**
	* Caches the info type categories in the entity cache if it is enabled.
	*
	* @param infoTypeCategories the info type categories
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.InfoTypeCategory> infoTypeCategories) {
		getPersistence().cacheResult(infoTypeCategories);
	}

	/**
	* Creates a new info type category with the primary key. Does not add the info type category to the database.
	*
	* @param infoTypeCategoryId the primary key for the new info type category
	* @return the new info type category
	*/
	public static com.rumbasolutions.flask.model.InfoTypeCategory create(
		long infoTypeCategoryId) {
		return getPersistence().create(infoTypeCategoryId);
	}

	/**
	* Removes the info type category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param infoTypeCategoryId the primary key of the info type category
	* @return the info type category that was removed
	* @throws com.rumbasolutions.flask.NoSuchInfoTypeCategoryException if a info type category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.InfoTypeCategory remove(
		long infoTypeCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchInfoTypeCategoryException {
		return getPersistence().remove(infoTypeCategoryId);
	}

	public static com.rumbasolutions.flask.model.InfoTypeCategory updateImpl(
		com.rumbasolutions.flask.model.InfoTypeCategory infoTypeCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(infoTypeCategory);
	}

	/**
	* Returns the info type category with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchInfoTypeCategoryException} if it could not be found.
	*
	* @param infoTypeCategoryId the primary key of the info type category
	* @return the info type category
	* @throws com.rumbasolutions.flask.NoSuchInfoTypeCategoryException if a info type category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.InfoTypeCategory findByPrimaryKey(
		long infoTypeCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchInfoTypeCategoryException {
		return getPersistence().findByPrimaryKey(infoTypeCategoryId);
	}

	/**
	* Returns the info type category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param infoTypeCategoryId the primary key of the info type category
	* @return the info type category, or <code>null</code> if a info type category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.InfoTypeCategory fetchByPrimaryKey(
		long infoTypeCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(infoTypeCategoryId);
	}

	/**
	* Returns all the info type categories.
	*
	* @return the info type categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.InfoTypeCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the info type categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InfoTypeCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of info type categories
	* @param end the upper bound of the range of info type categories (not inclusive)
	* @return the range of info type categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.InfoTypeCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the info type categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InfoTypeCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of info type categories
	* @param end the upper bound of the range of info type categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of info type categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.InfoTypeCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the info type categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of info type categories.
	*
	* @return the number of info type categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static InfoTypeCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (InfoTypeCategoryPersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					InfoTypeCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(InfoTypeCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(InfoTypeCategoryPersistence persistence) {
	}

	private static InfoTypeCategoryPersistence _persistence;
}