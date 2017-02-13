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
 * Provides a wrapper for {@link FlaskMessagesService}.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskMessagesService
 * @generated
 */
public class FlaskMessagesServiceWrapper implements FlaskMessagesService,
	ServiceWrapper<FlaskMessagesService> {
	public FlaskMessagesServiceWrapper(
		FlaskMessagesService flaskMessagesService) {
		_flaskMessagesService = flaskMessagesService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _flaskMessagesService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_flaskMessagesService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _flaskMessagesService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.contacts.model.FlaskMessages sendFlaskMessage(
		java.lang.String recipients, java.lang.String message,
		boolean sendEmail,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskMessagesService.sendFlaskMessage(recipients, message,
			sendEmail, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getAllMyFlaskMessages(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskMessagesService.getAllMyFlaskMessages(serviceContext);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.FlaskMessages> getMyUnreadFlaskMessages(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskMessagesService.getMyUnreadFlaskMessages(serviceContext);
	}

	@Override
	public int getMyFlaskMessagesCount(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskMessagesService.getMyFlaskMessagesCount(serviceContext);
	}

	@Override
	public void deleteMessage(long messageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flaskMessagesService.deleteMessage(messageId, serviceContext);
	}

	@Override
	public void deleteMessagesByDateRange(java.util.Date startDate,
		java.util.Date endDate,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flaskMessagesService.deleteMessagesByDateRange(startDate, endDate,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FlaskMessagesService getWrappedFlaskMessagesService() {
		return _flaskMessagesService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFlaskMessagesService(
		FlaskMessagesService flaskMessagesService) {
		_flaskMessagesService = flaskMessagesService;
	}

	@Override
	public FlaskMessagesService getWrappedService() {
		return _flaskMessagesService;
	}

	@Override
	public void setWrappedService(FlaskMessagesService flaskMessagesService) {
		_flaskMessagesService = flaskMessagesService;
	}

	private FlaskMessagesService _flaskMessagesService;
}