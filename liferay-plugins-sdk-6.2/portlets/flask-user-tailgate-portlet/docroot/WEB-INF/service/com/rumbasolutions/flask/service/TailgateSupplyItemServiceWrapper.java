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
 * Provides a wrapper for {@link TailgateSupplyItemService}.
 *
 * @author Brian Wing Shun Chan
 * @see TailgateSupplyItemService
 * @generated
 */
public class TailgateSupplyItemServiceWrapper
	implements TailgateSupplyItemService,
		ServiceWrapper<TailgateSupplyItemService> {
	public TailgateSupplyItemServiceWrapper(
		TailgateSupplyItemService tailgateSupplyItemService) {
		_tailgateSupplyItemService = tailgateSupplyItemService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tailgateSupplyItemService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tailgateSupplyItemService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tailgateSupplyItemService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateSupplyItem addTailgateSupplyItem(
		java.lang.String supplyListItemName, long tailgateId,
		long itemAssignedUserId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _tailgateSupplyItemService.addTailgateSupplyItem(supplyListItemName,
			tailgateId, itemAssignedUserId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateSupplyItem updateTailgateSupplyItem(
		long tailgateSupplyItemId, java.lang.String supplyListItemName,
		long tailgateId, long itemAssignedUserId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _tailgateSupplyItemService.updateTailgateSupplyItem(tailgateSupplyItemId,
			supplyListItemName, tailgateId, itemAssignedUserId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateSupplyItem getTailgateSupplyItem(
		long tailgateSupplyItemId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _tailgateSupplyItemService.getTailgateSupplyItem(tailgateSupplyItemId,
			serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> getItemsByTailgateId(
		long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _tailgateSupplyItemService.getItemsByTailgateId(tailgateId,
			serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> getMyTailgateSupplyItems(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _tailgateSupplyItemService.getMyTailgateSupplyItems(serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> getAllTailgateSupplyItems(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _tailgateSupplyItemService.getAllTailgateSupplyItems(serviceContext);
	}

	@Override
	public void deleteTailgateSupplyItem(long tailgateSupplyItemId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tailgateSupplyItemService.deleteTailgateSupplyItem(tailgateSupplyItemId,
			serviceContext);
	}

	@Override
	public void deleteItemsByTailgateId(long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tailgateSupplyItemService.deleteItemsByTailgateId(tailgateId,
			serviceContext);
	}

	@Override
	public void deleteMyItems(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tailgateSupplyItemService.deleteMyItems(serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TailgateSupplyItemService getWrappedTailgateSupplyItemService() {
		return _tailgateSupplyItemService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTailgateSupplyItemService(
		TailgateSupplyItemService tailgateSupplyItemService) {
		_tailgateSupplyItemService = tailgateSupplyItemService;
	}

	@Override
	public TailgateSupplyItemService getWrappedService() {
		return _tailgateSupplyItemService;
	}

	@Override
	public void setWrappedService(
		TailgateSupplyItemService tailgateSupplyItemService) {
		_tailgateSupplyItemService = tailgateSupplyItemService;
	}

	private TailgateSupplyItemService _tailgateSupplyItemService;
}