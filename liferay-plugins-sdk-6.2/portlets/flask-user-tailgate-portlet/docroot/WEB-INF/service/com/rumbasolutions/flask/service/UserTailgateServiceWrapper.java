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
 * Provides a wrapper for {@link UserTailgateService}.
 *
 * @author rajeshj
 * @see UserTailgateService
 * @generated
 */
public class UserTailgateServiceWrapper implements UserTailgateService,
	ServiceWrapper<UserTailgateService> {
	public UserTailgateServiceWrapper(UserTailgateService userTailgateService) {
		_userTailgateService = userTailgateService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userTailgateService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userTailgateService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userTailgateService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.rumbasolutions.flask.model.UserTailgate addUserTailgate(
		java.lang.String tailgateName, java.lang.String tailgateDescription,
		long eventId, java.lang.String eventName, java.util.Date tailgateDate,
		java.util.Date startTime, java.util.Date endTime,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _userTailgateService.addUserTailgate(tailgateName,
			tailgateDescription, eventId, eventName, tailgateDate, startTime,
			endTime, serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.UserTailgate> getAllTailgate() {
		return _userTailgateService.getAllTailgate();
	}

	@Override
	public com.rumbasolutions.flask.model.UserTailgate getTailgate(
		int tailgateId) {
		return _userTailgateService.getTailgate(tailgateId);
	}

	@Override
	public com.rumbasolutions.flask.model.UserTailgate updateUserTailgate(
		long tailgateId, java.lang.String tailgateName,
		java.lang.String tailgateDescription, long eventId,
		java.lang.String eventName, java.util.Date tailgateDate,
		java.util.Date startTime, java.util.Date endTime,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _userTailgateService.updateUserTailgate(tailgateId,
			tailgateName, tailgateDescription, eventId, eventName,
			tailgateDate, startTime, endTime, serviceContext);
	}

	@Override
	public void deleteUserTailgate(long tailgateId) {
		_userTailgateService.deleteUserTailgate(tailgateId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserTailgateService getWrappedUserTailgateService() {
		return _userTailgateService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserTailgateService(
		UserTailgateService userTailgateService) {
		_userTailgateService = userTailgateService;
	}

	@Override
	public UserTailgateService getWrappedService() {
		return _userTailgateService;
	}

	@Override
	public void setWrappedService(UserTailgateService userTailgateService) {
		_userTailgateService = userTailgateService;
	}

	private UserTailgateService _userTailgateService;
}