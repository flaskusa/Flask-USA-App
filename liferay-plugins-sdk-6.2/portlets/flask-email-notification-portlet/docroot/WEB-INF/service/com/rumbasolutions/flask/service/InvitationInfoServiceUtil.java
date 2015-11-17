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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for InvitationInfo. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.InvitationInfoServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see InvitationInfoService
 * @see com.rumbasolutions.flask.service.base.InvitationInfoServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.InvitationInfoServiceImpl
 * @generated
 */
public class InvitationInfoServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.InvitationInfoServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void sendInivitation(java.lang.String email,
		java.lang.String name, java.lang.String description,
		java.lang.String invitedDate,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService()
			.sendInivitation(email, name, description, invitedDate,
			serviceContext);
	}

	public static void askUs(java.lang.String fromMail,
		java.lang.String subject, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().askUs(fromMail, subject, description, serviceContext);
	}

	public static void replyToFeedback(java.lang.String name,
		java.lang.String email, java.lang.String mobile,
		java.lang.String comment,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService()
			.replyToFeedback(name, email, mobile, comment, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static InvitationInfoService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					InvitationInfoService.class.getName());

			if (invokableService instanceof InvitationInfoService) {
				_service = (InvitationInfoService)invokableService;
			}
			else {
				_service = new InvitationInfoServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(InvitationInfoServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(InvitationInfoService service) {
	}

	private static InvitationInfoService _service;
}