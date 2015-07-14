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

import com.rumbasolutions.flask.model.InfoTypeCategory;

/**
 * The persistence interface for the info type category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see InfoTypeCategoryPersistenceImpl
 * @see InfoTypeCategoryUtil
 * @generated
 */
public interface InfoTypeCategoryPersistence extends BasePersistence<InfoTypeCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InfoTypeCategoryUtil} to access the info type category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the info type category in the entity cache if it is enabled.
	*
	* @param infoTypeCategory the info type category
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.InfoTypeCategory infoTypeCategory);

	/**
	* Caches the info type categories in the entity cache if it is enabled.
	*
	* @param infoTypeCategories the info type categories
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.InfoTypeCategory> infoTypeCategories);

	/**
	* Creates a new info type category with the primary key. Does not add the info type category to the database.
	*
	* @param infoTypeCategoryId the primary key for the new info type category
	* @return the new info type category
	*/
	public com.rumbasolutions.flask.model.InfoTypeCategory create(
		long infoTypeCategoryId);

	/**
	* Removes the info type category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param infoTypeCategoryId the primary key of the info type category
	* @return the info type category that was removed
	* @throws com.rumbasolutions.flask.NoSuchInfoTypeCategoryException if a info type category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.InfoTypeCategory remove(
		long infoTypeCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchInfoTypeCategoryException;

	public com.rumbasolutions.flask.model.InfoTypeCategory updateImpl(
		com.rumbasolutions.flask.model.InfoTypeCategory infoTypeCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the info type category with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchInfoTypeCategoryException} if it could not be found.
	*
	* @param infoTypeCategoryId the primary key of the info type category
	* @return the info type category
	* @throws com.rumbasolutions.flask.NoSuchInfoTypeCategoryException if a info type category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.InfoTypeCategory findByPrimaryKey(
		long infoTypeCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchInfoTypeCategoryException;

	/**
	* Returns the info type category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param infoTypeCategoryId the primary key of the info type category
	* @return the info type category, or <code>null</code> if a info type category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.InfoTypeCategory fetchByPrimaryKey(
		long infoTypeCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the info type categories.
	*
	* @return the info type categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.InfoTypeCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.InfoTypeCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.InfoTypeCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the info type categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of info type categories.
	*
	* @return the number of info type categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}