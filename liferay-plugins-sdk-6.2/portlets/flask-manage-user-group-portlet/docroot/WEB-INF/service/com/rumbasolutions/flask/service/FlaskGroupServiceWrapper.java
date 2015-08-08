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
 * Provides a wrapper for {@link FlaskGroupService}.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupService
 * @generated
 */
public class FlaskGroupServiceWrapper implements FlaskGroupService,
	ServiceWrapper<FlaskGroupService> {
	public FlaskGroupServiceWrapper(FlaskGroupService flaskGroupService) {
		_flaskGroupService = flaskGroupService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _flaskGroupService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_flaskGroupService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _flaskGroupService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroup> getAllGroups() {
		return _flaskGroupService.getAllGroups();
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroup> getAllMyGroups(
		long userId) {
		return _flaskGroupService.getAllMyGroups(userId);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroup> getMyGroups(
		long userId) {
		return _flaskGroupService.getMyGroups(userId);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroup> getParticipatingGroups(
		long userId) {
		return _flaskGroupService.getParticipatingGroups(userId);
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskGroup getGroup(long groupId) {
		return _flaskGroupService.getGroup(groupId);
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskGroup addGroup(
		java.lang.String groupName, java.lang.String groupDescription,
		java.lang.String createdBy, java.lang.String createdDate, int isActive,
		int isDelete) {
		return _flaskGroupService.addGroup(groupName, groupDescription,
			createdBy, createdDate, isActive, isDelete);
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskGroup updateGroup(long groupId,
		java.lang.String groupName, java.lang.String groupDescription,
		java.lang.String createdDate, java.lang.String createdBy, int isActive,
		int isDelete) {
		return _flaskGroupService.updateGroup(groupId, groupName,
			groupDescription, createdDate, createdBy, isActive, isDelete);
	}

	@Override
	public void deleteGroup(long groupId) {
		_flaskGroupService.deleteGroup(groupId);
	}

	@Override
	public void deleteGroups(java.lang.String groupList) {
		_flaskGroupService.deleteGroups(groupList);
	}

	@Override
	public void deactivateGroup(long groupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flaskGroupService.deactivateGroup(groupId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FlaskGroupService getWrappedFlaskGroupService() {
		return _flaskGroupService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFlaskGroupService(FlaskGroupService flaskGroupService) {
		_flaskGroupService = flaskGroupService;
	}

	@Override
	public FlaskGroupService getWrappedService() {
		return _flaskGroupService;
	}

	@Override
	public void setWrappedService(FlaskGroupService flaskGroupService) {
		_flaskGroupService = flaskGroupService;
	}

	private FlaskGroupService _flaskGroupService;
}