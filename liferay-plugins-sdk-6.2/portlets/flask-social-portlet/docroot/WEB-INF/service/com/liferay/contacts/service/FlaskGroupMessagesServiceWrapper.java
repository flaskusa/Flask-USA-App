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

package com.liferay.contacts.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FlaskGroupMessagesService}.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupMessagesService
 * @generated
 */
public class FlaskGroupMessagesServiceWrapper
	implements FlaskGroupMessagesService,
		ServiceWrapper<FlaskGroupMessagesService> {
	public FlaskGroupMessagesServiceWrapper(
		FlaskGroupMessagesService flaskGroupMessagesService) {
		_flaskGroupMessagesService = flaskGroupMessagesService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _flaskGroupMessagesService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_flaskGroupMessagesService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _flaskGroupMessagesService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.contacts.model.FlaskGroupMessages sendFlaskGroupMessage(
		long groupId, java.lang.String message, boolean sendEmail,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskGroupMessagesService.sendFlaskGroupMessage(groupId,
			message, sendEmail, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getAllMyFlaskGroupMessages(
		long groupId, com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskGroupMessagesService.getAllMyFlaskGroupMessages(groupId,
			serviceContext);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.FlaskGroupMessages> getGroupMessages(
		long groupId) {
		return _flaskGroupMessagesService.getGroupMessages(groupId);
	}

	@Override
	public int getMyFlaskGroupMessagesCount(long groupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskGroupMessagesService.getMyFlaskGroupMessagesCount(groupId,
			serviceContext);
	}

	@Override
	public int getMyUnreadFlaskGroupMessagesCount(long groupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskGroupMessagesService.getMyUnreadFlaskGroupMessagesCount(groupId,
			serviceContext);
	}

	@Override
	public void deleteGroupMessage(long groupMessageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flaskGroupMessagesService.deleteGroupMessage(groupMessageId,
			serviceContext);
	}

	@Override
	public void deleteGroupMessagesByDateRange(java.util.Date startDate,
		java.util.Date endDate,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flaskGroupMessagesService.deleteGroupMessagesByDateRange(startDate,
			endDate, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FlaskGroupMessagesService getWrappedFlaskGroupMessagesService() {
		return _flaskGroupMessagesService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFlaskGroupMessagesService(
		FlaskGroupMessagesService flaskGroupMessagesService) {
		_flaskGroupMessagesService = flaskGroupMessagesService;
	}

	@Override
	public FlaskGroupMessagesService getWrappedService() {
		return _flaskGroupMessagesService;
	}

	@Override
	public void setWrappedService(
		FlaskGroupMessagesService flaskGroupMessagesService) {
		_flaskGroupMessagesService = flaskGroupMessagesService;
	}

	private FlaskGroupMessagesService _flaskGroupMessagesService;
}