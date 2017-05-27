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
 * Provides the remote service utility for FlaskGroupMessages. This utility wraps
 * {@link com.liferay.contacts.service.impl.FlaskGroupMessagesServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupMessagesService
 * @see com.liferay.contacts.service.base.FlaskGroupMessagesServiceBaseImpl
 * @see com.liferay.contacts.service.impl.FlaskGroupMessagesServiceImpl
 * @generated
 */
public class FlaskGroupMessagesServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.contacts.service.impl.FlaskGroupMessagesServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.contacts.model.FlaskGroupMessages sendFlaskGroupMessage(
		long groupId, java.lang.String message, boolean sendEmail,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .sendFlaskGroupMessage(groupId, message, sendEmail,
			serviceContext);
	}

	public static com.liferay.portal.kernel.json.JSONArray getAllMyFlaskGroupMessages(
		long groupId, com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getAllMyFlaskGroupMessages(groupId, serviceContext);
	}

	public static java.util.List<com.liferay.contacts.model.FlaskGroupMessages> getGroupMessages(
		long groupId) {
		return getService().getGroupMessages(groupId);
	}

	public static int getMyFlaskGroupMessagesCount(long groupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getMyFlaskGroupMessagesCount(groupId, serviceContext);
	}

	public static int getMyUnreadFlaskGroupMessagesCount(long groupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .getMyUnreadFlaskGroupMessagesCount(groupId, serviceContext);
	}

	public static void deleteGroupMessage(long groupMessageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteGroupMessage(groupMessageId, serviceContext);
	}

	public static void deleteGroupMessagesByDateRange(
		java.util.Date startDate, java.util.Date endDate,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService()
			.deleteGroupMessagesByDateRange(startDate, endDate, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static FlaskGroupMessagesService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FlaskGroupMessagesService.class.getName());

			if (invokableService instanceof FlaskGroupMessagesService) {
				_service = (FlaskGroupMessagesService)invokableService;
			}
			else {
				_service = new FlaskGroupMessagesServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(FlaskGroupMessagesServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FlaskGroupMessagesService service) {
	}

	private static FlaskGroupMessagesService _service;
}