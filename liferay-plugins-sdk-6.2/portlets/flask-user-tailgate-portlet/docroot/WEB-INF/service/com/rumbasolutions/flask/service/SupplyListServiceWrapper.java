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
 * Provides a wrapper for {@link SupplyListService}.
 *
 * @author Brian Wing Shun Chan
 * @see SupplyListService
 * @generated
 */
public class SupplyListServiceWrapper implements SupplyListService,
	ServiceWrapper<SupplyListService> {
	public SupplyListServiceWrapper(SupplyListService supplyListService) {
		_supplyListService = supplyListService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _supplyListService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_supplyListService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _supplyListService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.rumbasolutions.flask.model.SupplyList addSupplyList(
		java.lang.String supplyListName, boolean isSystem, long companyId,
		java.util.Date createdDate, java.util.Date modifiedDate,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _supplyListService.addSupplyList(supplyListName, isSystem,
			companyId, createdDate, modifiedDate, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.SupplyList updateSupplyList(
		long supplyListId, java.lang.String supplyListName, boolean isSystem,
		long companyId, long userId, java.util.Date createdDate,
		java.util.Date modifiedDate,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _supplyListService.updateSupplyList(supplyListId,
			supplyListName, isSystem, companyId, userId, createdDate,
			modifiedDate, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.SupplyList getSupplyList(
		long supplyListId) {
		return _supplyListService.getSupplyList(supplyListId);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.SupplyList> getAllSupplyLists() {
		return _supplyListService.getAllSupplyLists();
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.SupplyList> getMySupplyLists(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _supplyListService.getMySupplyLists(serviceContext);
	}

	@Override
	public void deleteSupplyList(long supplyListId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_supplyListService.deleteSupplyList(supplyListId, serviceContext);
	}

	@Override
	public void deleteMySupplyLists(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_supplyListService.deleteMySupplyLists(serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SupplyListService getWrappedSupplyListService() {
		return _supplyListService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSupplyListService(SupplyListService supplyListService) {
		_supplyListService = supplyListService;
	}

	@Override
	public SupplyListService getWrappedService() {
		return _supplyListService;
	}

	@Override
	public void setWrappedService(SupplyListService supplyListService) {
		_supplyListService = supplyListService;
	}

	private SupplyListService _supplyListService;
}