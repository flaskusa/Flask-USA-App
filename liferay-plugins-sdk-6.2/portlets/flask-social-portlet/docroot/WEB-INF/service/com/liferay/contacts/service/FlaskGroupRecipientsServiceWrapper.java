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
 * Provides a wrapper for {@link FlaskGroupRecipientsService}.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupRecipientsService
 * @generated
 */
public class FlaskGroupRecipientsServiceWrapper
	implements FlaskGroupRecipientsService,
		ServiceWrapper<FlaskGroupRecipientsService> {
	public FlaskGroupRecipientsServiceWrapper(
		FlaskGroupRecipientsService flaskGroupRecipientsService) {
		_flaskGroupRecipientsService = flaskGroupRecipientsService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _flaskGroupRecipientsService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_flaskGroupRecipientsService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _flaskGroupRecipientsService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.contacts.model.FlaskGroupRecipients addFlaskGroupRecipients(
		long groupId, java.lang.String senderEmailId, long groupMessageId,
		java.lang.String message, java.lang.Boolean sendEmail,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskGroupRecipientsService.addFlaskGroupRecipients(groupId,
			senderEmailId, groupMessageId, message, sendEmail, serviceContext);
	}

	@Override
	public boolean setGroupMessageRead(java.lang.Long[] groupMessageIds,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _flaskGroupRecipientsService.setGroupMessageRead(groupMessageIds,
			serviceContext);
	}

	@Override
	public java.util.List<com.liferay.contacts.model.FlaskGroupRecipients> getGroupRecipientsByGroupId(
		long groupId) {
		return _flaskGroupRecipientsService.getGroupRecipientsByGroupId(groupId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FlaskGroupRecipientsService getWrappedFlaskGroupRecipientsService() {
		return _flaskGroupRecipientsService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFlaskGroupRecipientsService(
		FlaskGroupRecipientsService flaskGroupRecipientsService) {
		_flaskGroupRecipientsService = flaskGroupRecipientsService;
	}

	@Override
	public FlaskGroupRecipientsService getWrappedService() {
		return _flaskGroupRecipientsService;
	}

	@Override
	public void setWrappedService(
		FlaskGroupRecipientsService flaskGroupRecipientsService) {
		_flaskGroupRecipientsService = flaskGroupRecipientsService;
	}

	private FlaskGroupRecipientsService _flaskGroupRecipientsService;
}