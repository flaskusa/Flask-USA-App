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
 * Provides a wrapper for {@link SupplyItemService}.
 *
 * @author Brian Wing Shun Chan
 * @see SupplyItemService
 * @generated
 */
public class SupplyItemServiceWrapper implements SupplyItemService,
	ServiceWrapper<SupplyItemService> {
	public SupplyItemServiceWrapper(SupplyItemService supplyItemService) {
		_supplyItemService = supplyItemService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _supplyItemService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_supplyItemService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _supplyItemService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.rumbasolutions.flask.model.SupplyItem addSupplyItem(
		java.lang.String supplyItemName, long supplyListId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _supplyItemService.addSupplyItem(supplyItemName, supplyListId,
			serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.SupplyItem> addSupplyItems(
		java.lang.String[] supplyItemNames, long supplyListId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _supplyItemService.addSupplyItems(supplyItemNames, supplyListId,
			serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.SupplyItem updateSupplyItem(
		long supplyItemId, java.lang.String supplyItemName, long supplyListId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _supplyItemService.updateSupplyItem(supplyItemId,
			supplyItemName, supplyListId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.SupplyItem getSupplyItem(
		long supplyItemId) {
		return _supplyItemService.getSupplyItem(supplyItemId);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.SupplyItem> getAllSupplyItems(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _supplyItemService.getAllSupplyItems(serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.SupplyItem> getItemsByListId(
		long supplyListId) {
		return _supplyItemService.getItemsByListId(supplyListId);
	}

	@Override
	public void deleteSupplyItem(long supplyItemId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_supplyItemService.deleteSupplyItem(supplyItemId, serviceContext);
	}

	@Override
	public void deleteItemsByListId(long supplyListId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_supplyItemService.deleteItemsByListId(supplyListId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SupplyItemService getWrappedSupplyItemService() {
		return _supplyItemService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSupplyItemService(SupplyItemService supplyItemService) {
		_supplyItemService = supplyItemService;
	}

	@Override
	public SupplyItemService getWrappedService() {
		return _supplyItemService;
	}

	@Override
	public void setWrappedService(SupplyItemService supplyItemService) {
		_supplyItemService = supplyItemService;
	}

	private SupplyItemService _supplyItemService;
}