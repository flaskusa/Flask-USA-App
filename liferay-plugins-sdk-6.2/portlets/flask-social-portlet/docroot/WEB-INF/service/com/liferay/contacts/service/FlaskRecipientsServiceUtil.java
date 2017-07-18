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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for FlaskRecipients. This utility wraps
 * {@link com.liferay.contacts.service.impl.FlaskRecipientsServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskRecipientsService
 * @see com.liferay.contacts.service.base.FlaskRecipientsServiceBaseImpl
 * @see com.liferay.contacts.service.impl.FlaskRecipientsServiceImpl
 * @generated
 */
public class FlaskRecipientsServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.contacts.service.impl.FlaskRecipientsServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.contacts.model.FlaskRecipients addFlaskRecipient(
		long userId, long messageId, boolean read,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addFlaskRecipient(userId, messageId, read, serviceContext);
	}

	public static boolean setRead(java.lang.Long[] messageIds,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().setRead(messageIds, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static FlaskRecipientsService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FlaskRecipientsService.class.getName());

			if (invokableService instanceof FlaskRecipientsService) {
				_service = (FlaskRecipientsService)invokableService;
			}
			else {
				_service = new FlaskRecipientsServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(FlaskRecipientsServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FlaskRecipientsService service) {
	}

	private static FlaskRecipientsService _service;
}