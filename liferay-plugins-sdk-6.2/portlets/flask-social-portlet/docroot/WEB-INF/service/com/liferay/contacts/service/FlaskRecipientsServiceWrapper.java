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
 * Provides a wrapper for {@link FlaskRecipientsService}.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskRecipientsService
 * @generated
 */
public class FlaskRecipientsServiceWrapper implements FlaskRecipientsService,
	ServiceWrapper<FlaskRecipientsService> {
	public FlaskRecipientsServiceWrapper(
		FlaskRecipientsService flaskRecipientsService) {
		_flaskRecipientsService = flaskRecipientsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _flaskRecipientsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_flaskRecipientsService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _flaskRecipientsService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.contacts.model.FlaskRecipients addFlaskRecipient(
		long userId, long messageId, boolean read) {
		return _flaskRecipientsService.addFlaskRecipient(userId, messageId, read);
	}

	@Override
	public boolean setRead(long messageId) {
		return _flaskRecipientsService.setRead(messageId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FlaskRecipientsService getWrappedFlaskRecipientsService() {
		return _flaskRecipientsService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFlaskRecipientsService(
		FlaskRecipientsService flaskRecipientsService) {
		_flaskRecipientsService = flaskRecipientsService;
	}

	@Override
	public FlaskRecipientsService getWrappedService() {
		return _flaskRecipientsService;
	}

	@Override
	public void setWrappedService(FlaskRecipientsService flaskRecipientsService) {
		_flaskRecipientsService = flaskRecipientsService;
	}

	private FlaskRecipientsService _flaskRecipientsService;
}