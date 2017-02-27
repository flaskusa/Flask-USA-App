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
 * Provides a wrapper for {@link TailgateUsersService}.
 *
 * @author Brian Wing Shun Chan
 * @see TailgateUsersService
 * @generated
 */
public class TailgateUsersServiceWrapper implements TailgateUsersService,
	ServiceWrapper<TailgateUsersService> {
	public TailgateUsersServiceWrapper(
		TailgateUsersService tailgateUsersService) {
		_tailgateUsersService = tailgateUsersService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tailgateUsersService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tailgateUsersService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tailgateUsersService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateUsers> getTailgateMembers(
		long tailgateId) {
		return _tailgateUsersService.getTailgateMembers(tailgateId);
	}

	@Override
	public boolean isTailgateAdmin(long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _tailgateUsersService.isTailgateAdmin(tailgateId, serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateUsers> getTailgateGroups(
		long tailgateId, long groupId) {
		return _tailgateUsersService.getTailgateGroups(tailgateId, groupId);
	}

	@Override
	public boolean checkTailgateUserExist(long tailgateId, long userId) {
		return _tailgateUsersService.checkTailgateUserExist(tailgateId, userId);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateUsers addTailgateUser(
		long tailgateId, long userId, java.lang.String userName,
		java.lang.String emailAddress, int isAdmin, boolean isPaid,
		java.lang.String paymentMode, int groupId) {
		return _tailgateUsersService.addTailgateUser(tailgateId, userId,
			userName, emailAddress, isAdmin, isPaid, paymentMode, groupId);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateUsers updateTailgateUser(
		long userId, long tailgateId, boolean isPaid,
		java.lang.String paymentMode, java.lang.String description) {
		return _tailgateUsersService.updateTailgateUser(userId, tailgateId,
			isPaid, paymentMode, description);
	}

	@Override
	public int updateTailgateUserRole(long userId, long tailgateId) {
		return _tailgateUsersService.updateTailgateUserRole(userId, tailgateId);
	}

	@Override
	public void deleteTailgateUser(long tailgateId, long userId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tailgateUsersService.deleteTailgateUser(tailgateId, userId,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TailgateUsersService getWrappedTailgateUsersService() {
		return _tailgateUsersService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTailgateUsersService(
		TailgateUsersService tailgateUsersService) {
		_tailgateUsersService = tailgateUsersService;
	}

	@Override
	public TailgateUsersService getWrappedService() {
		return _tailgateUsersService;
	}

	@Override
	public void setWrappedService(TailgateUsersService tailgateUsersService) {
		_tailgateUsersService = tailgateUsersService;
	}

	private TailgateUsersService _tailgateUsersService;
}