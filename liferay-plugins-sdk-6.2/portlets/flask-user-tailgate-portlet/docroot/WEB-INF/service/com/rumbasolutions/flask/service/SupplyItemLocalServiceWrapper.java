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
 * Provides a wrapper for {@link SupplyItemLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SupplyItemLocalService
 * @generated
 */
public class SupplyItemLocalServiceWrapper implements SupplyItemLocalService,
	ServiceWrapper<SupplyItemLocalService> {
	public SupplyItemLocalServiceWrapper(
		SupplyItemLocalService supplyItemLocalService) {
		_supplyItemLocalService = supplyItemLocalService;
	}

	/**
	* Adds the supply item to the database. Also notifies the appropriate model listeners.
	*
	* @param supplyItem the supply item
	* @return the supply item that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.SupplyItem addSupplyItem(
		com.rumbasolutions.flask.model.SupplyItem supplyItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _supplyItemLocalService.addSupplyItem(supplyItem);
	}

	/**
	* Creates a new supply item with the primary key. Does not add the supply item to the database.
	*
	* @param supplyItemId the primary key for the new supply item
	* @return the new supply item
	*/
	@Override
	public com.rumbasolutions.flask.model.SupplyItem createSupplyItem(
		long supplyItemId) {
		return _supplyItemLocalService.createSupplyItem(supplyItemId);
	}

	/**
	* Deletes the supply item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param supplyItemId the primary key of the supply item
	* @return the supply item that was removed
	* @throws PortalException if a supply item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.SupplyItem deleteSupplyItem(
		long supplyItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _supplyItemLocalService.deleteSupplyItem(supplyItemId);
	}

	/**
	* Deletes the supply item from the database. Also notifies the appropriate model listeners.
	*
	* @param supplyItem the supply item
	* @return the supply item that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.SupplyItem deleteSupplyItem(
		com.rumbasolutions.flask.model.SupplyItem supplyItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _supplyItemLocalService.deleteSupplyItem(supplyItem);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _supplyItemLocalService.dynamicQuery();
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
		return _supplyItemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _supplyItemLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _supplyItemLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _supplyItemLocalService.dynamicQueryCount(dynamicQuery);
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
		return _supplyItemLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rumbasolutions.flask.model.SupplyItem fetchSupplyItem(
		long supplyItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _supplyItemLocalService.fetchSupplyItem(supplyItemId);
	}

	/**
	* Returns the supply item with the primary key.
	*
	* @param supplyItemId the primary key of the supply item
	* @return the supply item
	* @throws PortalException if a supply item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.SupplyItem getSupplyItem(
		long supplyItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _supplyItemLocalService.getSupplyItem(supplyItemId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _supplyItemLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the supply items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of supply items
	* @param end the upper bound of the range of supply items (not inclusive)
	* @return the range of supply items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rumbasolutions.flask.model.SupplyItem> getSupplyItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _supplyItemLocalService.getSupplyItems(start, end);
	}

	/**
	* Returns the number of supply items.
	*
	* @return the number of supply items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSupplyItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _supplyItemLocalService.getSupplyItemsCount();
	}

	/**
	* Updates the supply item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param supplyItem the supply item
	* @return the supply item that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.SupplyItem updateSupplyItem(
		com.rumbasolutions.flask.model.SupplyItem supplyItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _supplyItemLocalService.updateSupplyItem(supplyItem);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _supplyItemLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_supplyItemLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _supplyItemLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SupplyItemLocalService getWrappedSupplyItemLocalService() {
		return _supplyItemLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSupplyItemLocalService(
		SupplyItemLocalService supplyItemLocalService) {
		_supplyItemLocalService = supplyItemLocalService;
	}

	@Override
	public SupplyItemLocalService getWrappedService() {
		return _supplyItemLocalService;
	}

	@Override
	public void setWrappedService(SupplyItemLocalService supplyItemLocalService) {
		_supplyItemLocalService = supplyItemLocalService;
	}

	private SupplyItemLocalService _supplyItemLocalService;
}