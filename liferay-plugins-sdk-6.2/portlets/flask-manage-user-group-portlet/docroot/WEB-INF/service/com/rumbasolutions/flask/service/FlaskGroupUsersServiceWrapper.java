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
 * Provides a wrapper for {@link FlaskGroupUsersService}.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupUsersService
 * @generated
 */
public class FlaskGroupUsersServiceWrapper implements FlaskGroupUsersService,
	ServiceWrapper<FlaskGroupUsersService> {
	public FlaskGroupUsersServiceWrapper(
		FlaskGroupUsersService flaskGroupUsersService) {
		_flaskGroupUsersService = flaskGroupUsersService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _flaskGroupUsersService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_flaskGroupUsersService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _flaskGroupUsersService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> getAllGroupUsers(
		long groupId) {
		return _flaskGroupUsersService.getAllGroupUsers(groupId);
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskGroupUsers addGroupUser(
		long groupId, long userId, java.lang.String userName,
		java.lang.String emailAddress, int isAdmin) {
		return _flaskGroupUsersService.addGroupUser(groupId, userId, userName,
			emailAddress, isAdmin);
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskGroupUsers updateGroupUser(
		long groupUserId, long groupId, long userId, java.lang.String userName,
		java.lang.String emailAddress, int isAdmin) {
		return _flaskGroupUsersService.updateGroupUser(groupUserId, groupId,
			userId, userName, emailAddress, isAdmin);
	}

	@Override
	public int addGroupOwner(long groupId, long userId) {
		return _flaskGroupUsersService.addGroupOwner(groupId, userId);
	}

	@Override
	public void removeGroupOwner(long groupId, long userId) {
		_flaskGroupUsersService.removeGroupOwner(groupId, userId);
	}

	@Override
	public void deleteGroupUser(long groupId, long userId) {
		_flaskGroupUsersService.deleteGroupUser(groupId, userId);
	}

	@Override
	public void deleteGroupUsers(long groupId, java.lang.String userIds) {
		_flaskGroupUsersService.deleteGroupUsers(groupId, userIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FlaskGroupUsersService getWrappedFlaskGroupUsersService() {
		return _flaskGroupUsersService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFlaskGroupUsersService(
		FlaskGroupUsersService flaskGroupUsersService) {
		_flaskGroupUsersService = flaskGroupUsersService;
	}

	@Override
	public FlaskGroupUsersService getWrappedService() {
		return _flaskGroupUsersService;
	}

	@Override
	public void setWrappedService(FlaskGroupUsersService flaskGroupUsersService) {
		_flaskGroupUsersService = flaskGroupUsersService;
	}

	private FlaskGroupUsersService _flaskGroupUsersService;
}