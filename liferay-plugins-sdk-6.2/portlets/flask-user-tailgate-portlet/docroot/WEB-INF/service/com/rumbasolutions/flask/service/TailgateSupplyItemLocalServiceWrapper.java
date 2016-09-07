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
 * Provides a wrapper for {@link TailgateSupplyItemLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TailgateSupplyItemLocalService
 * @generated
 */
public class TailgateSupplyItemLocalServiceWrapper
	implements TailgateSupplyItemLocalService,
		ServiceWrapper<TailgateSupplyItemLocalService> {
	public TailgateSupplyItemLocalServiceWrapper(
		TailgateSupplyItemLocalService tailgateSupplyItemLocalService) {
		_tailgateSupplyItemLocalService = tailgateSupplyItemLocalService;
	}

	/**
	* Adds the tailgate supply item to the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateSupplyItem the tailgate supply item
	* @return the tailgate supply item that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateSupplyItem addTailgateSupplyItem(
		com.rumbasolutions.flask.model.TailgateSupplyItem tailgateSupplyItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateSupplyItemLocalService.addTailgateSupplyItem(tailgateSupplyItem);
	}

	/**
	* Creates a new tailgate supply item with the primary key. Does not add the tailgate supply item to the database.
	*
	* @param tailgateSupplyItemId the primary key for the new tailgate supply item
	* @return the new tailgate supply item
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateSupplyItem createTailgateSupplyItem(
		long tailgateSupplyItemId) {
		return _tailgateSupplyItemLocalService.createTailgateSupplyItem(tailgateSupplyItemId);
	}

	/**
	* Deletes the tailgate supply item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateSupplyItemId the primary key of the tailgate supply item
	* @return the tailgate supply item that was removed
	* @throws PortalException if a tailgate supply item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateSupplyItem deleteTailgateSupplyItem(
		long tailgateSupplyItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tailgateSupplyItemLocalService.deleteTailgateSupplyItem(tailgateSupplyItemId);
	}

	/**
	* Deletes the tailgate supply item from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateSupplyItem the tailgate supply item
	* @return the tailgate supply item that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateSupplyItem deleteTailgateSupplyItem(
		com.rumbasolutions.flask.model.TailgateSupplyItem tailgateSupplyItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateSupplyItemLocalService.deleteTailgateSupplyItem(tailgateSupplyItem);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tailgateSupplyItemLocalService.dynamicQuery();
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
		return _tailgateSupplyItemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateSupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tailgateSupplyItemLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateSupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tailgateSupplyItemLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _tailgateSupplyItemLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tailgateSupplyItemLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateSupplyItem fetchTailgateSupplyItem(
		long tailgateSupplyItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateSupplyItemLocalService.fetchTailgateSupplyItem(tailgateSupplyItemId);
	}

	/**
	* Returns the tailgate supply item with the primary key.
	*
	* @param tailgateSupplyItemId the primary key of the tailgate supply item
	* @return the tailgate supply item
	* @throws PortalException if a tailgate supply item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateSupplyItem getTailgateSupplyItem(
		long tailgateSupplyItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tailgateSupplyItemLocalService.getTailgateSupplyItem(tailgateSupplyItemId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tailgateSupplyItemLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tailgate supply items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateSupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tailgate supply items
	* @param end the upper bound of the range of tailgate supply items (not inclusive)
	* @return the range of tailgate supply items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> getTailgateSupplyItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateSupplyItemLocalService.getTailgateSupplyItems(start, end);
	}

	/**
	* Returns the number of tailgate supply items.
	*
	* @return the number of tailgate supply items
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTailgateSupplyItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateSupplyItemLocalService.getTailgateSupplyItemsCount();
	}

	/**
	* Updates the tailgate supply item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tailgateSupplyItem the tailgate supply item
	* @return the tailgate supply item that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateSupplyItem updateTailgateSupplyItem(
		com.rumbasolutions.flask.model.TailgateSupplyItem tailgateSupplyItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateSupplyItemLocalService.updateTailgateSupplyItem(tailgateSupplyItem);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tailgateSupplyItemLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tailgateSupplyItemLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tailgateSupplyItemLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TailgateSupplyItemLocalService getWrappedTailgateSupplyItemLocalService() {
		return _tailgateSupplyItemLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTailgateSupplyItemLocalService(
		TailgateSupplyItemLocalService tailgateSupplyItemLocalService) {
		_tailgateSupplyItemLocalService = tailgateSupplyItemLocalService;
	}

	@Override
	public TailgateSupplyItemLocalService getWrappedService() {
		return _tailgateSupplyItemLocalService;
	}

	@Override
	public void setWrappedService(
		TailgateSupplyItemLocalService tailgateSupplyItemLocalService) {
		_tailgateSupplyItemLocalService = tailgateSupplyItemLocalService;
	}

	private TailgateSupplyItemLocalService _tailgateSupplyItemLocalService;
}