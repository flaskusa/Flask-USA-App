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

package com.rumbasolutions.flask.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InfoTypeCategoryLocalService}.
 *
 * @author Ashutosh Rai
 * @see InfoTypeCategoryLocalService
 * @generated
 */
public class InfoTypeCategoryLocalServiceWrapper
	implements InfoTypeCategoryLocalService,
		ServiceWrapper<InfoTypeCategoryLocalService> {
	public InfoTypeCategoryLocalServiceWrapper(
		InfoTypeCategoryLocalService infoTypeCategoryLocalService) {
		_infoTypeCategoryLocalService = infoTypeCategoryLocalService;
	}

	/**
	* Adds the info type category to the database. Also notifies the appropriate model listeners.
	*
	* @param infoTypeCategory the info type category
	* @return the info type category that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.InfoTypeCategory addInfoTypeCategory(
		com.rumbasolutions.flask.model.InfoTypeCategory infoTypeCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _infoTypeCategoryLocalService.addInfoTypeCategory(infoTypeCategory);
	}

	/**
	* Creates a new info type category with the primary key. Does not add the info type category to the database.
	*
	* @param infoTypeCategoryId the primary key for the new info type category
	* @return the new info type category
	*/
	@Override
	public com.rumbasolutions.flask.model.InfoTypeCategory createInfoTypeCategory(
		long infoTypeCategoryId) {
		return _infoTypeCategoryLocalService.createInfoTypeCategory(infoTypeCategoryId);
	}

	/**
	* Deletes the info type category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param infoTypeCategoryId the primary key of the info type category
	* @return the info type category that was removed
	* @throws PortalException if a info type category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.InfoTypeCategory deleteInfoTypeCategory(
		long infoTypeCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _infoTypeCategoryLocalService.deleteInfoTypeCategory(infoTypeCategoryId);
	}

	/**
	* Deletes the info type category from the database. Also notifies the appropriate model listeners.
	*
	* @param infoTypeCategory the info type category
	* @return the info type category that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.InfoTypeCategory deleteInfoTypeCategory(
		com.rumbasolutions.flask.model.InfoTypeCategory infoTypeCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _infoTypeCategoryLocalService.deleteInfoTypeCategory(infoTypeCategory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _infoTypeCategoryLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _infoTypeCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InfoTypeCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _infoTypeCategoryLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InfoTypeCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _infoTypeCategoryLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _infoTypeCategoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _infoTypeCategoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rumbasolutions.flask.model.InfoTypeCategory fetchInfoTypeCategory(
		long infoTypeCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _infoTypeCategoryLocalService.fetchInfoTypeCategory(infoTypeCategoryId);
	}

	/**
	* Returns the info type category with the primary key.
	*
	* @param infoTypeCategoryId the primary key of the info type category
	* @return the info type category
	* @throws PortalException if a info type category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.InfoTypeCategory getInfoTypeCategory(
		long infoTypeCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _infoTypeCategoryLocalService.getInfoTypeCategory(infoTypeCategoryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _infoTypeCategoryLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.rumbasolutions.flask.model.InfoTypeCategory> getInfoTypeCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _infoTypeCategoryLocalService.getInfoTypeCategories(start, end);
	}

	/**
	* Returns the number of info type categories.
	*
	* @return the number of info type categories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getInfoTypeCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _infoTypeCategoryLocalService.getInfoTypeCategoriesCount();
	}

	/**
	* Updates the info type category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param infoTypeCategory the info type category
	* @return the info type category that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.InfoTypeCategory updateInfoTypeCategory(
		com.rumbasolutions.flask.model.InfoTypeCategory infoTypeCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _infoTypeCategoryLocalService.updateInfoTypeCategory(infoTypeCategory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _infoTypeCategoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_infoTypeCategoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _infoTypeCategoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public InfoTypeCategoryLocalService getWrappedInfoTypeCategoryLocalService() {
		return _infoTypeCategoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedInfoTypeCategoryLocalService(
		InfoTypeCategoryLocalService infoTypeCategoryLocalService) {
		_infoTypeCategoryLocalService = infoTypeCategoryLocalService;
	}

	@Override
	public InfoTypeCategoryLocalService getWrappedService() {
		return _infoTypeCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		InfoTypeCategoryLocalService infoTypeCategoryLocalService) {
		_infoTypeCategoryLocalService = infoTypeCategoryLocalService;
	}

	private InfoTypeCategoryLocalService _infoTypeCategoryLocalService;
}