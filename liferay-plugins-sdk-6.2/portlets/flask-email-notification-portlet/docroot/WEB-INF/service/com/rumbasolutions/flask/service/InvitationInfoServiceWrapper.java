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
 * Provides a wrapper for {@link InvitationInfoService}.
 *
 * @author Brian Wing Shun Chan
 * @see InvitationInfoService
 * @generated
 */
public class InvitationInfoServiceWrapper implements InvitationInfoService,
	ServiceWrapper<InvitationInfoService> {
	public InvitationInfoServiceWrapper(
		InvitationInfoService invitationInfoService) {
		_invitationInfoService = invitationInfoService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _invitationInfoService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_invitationInfoService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _invitationInfoService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void sendInivitation(java.lang.String email, java.lang.String name,
		java.lang.String description, java.lang.String invitedDate,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_invitationInfoService.sendInivitation(email, name, description,
			invitedDate, serviceContext);
	}

	@Override
	public void askUs(java.lang.String fromMail, java.lang.String subject,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_invitationInfoService.askUs(fromMail, subject, description,
			serviceContext);
	}

	@Override
	public void replyToFeedback(java.lang.String name, java.lang.String email,
		java.lang.String mobile, java.lang.String comment,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_invitationInfoService.replyToFeedback(name, email, mobile, comment,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public InvitationInfoService getWrappedInvitationInfoService() {
		return _invitationInfoService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedInvitationInfoService(
		InvitationInfoService invitationInfoService) {
		_invitationInfoService = invitationInfoService;
	}

	@Override
	public InvitationInfoService getWrappedService() {
		return _invitationInfoService;
	}

	@Override
	public void setWrappedService(InvitationInfoService invitationInfoService) {
		_invitationInfoService = invitationInfoService;
	}

	private InvitationInfoService _invitationInfoService;
}