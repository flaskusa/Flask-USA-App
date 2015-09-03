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
 * Provides the remote service utility for FlaskGroupUsers. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.FlaskGroupUsersServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupUsersService
 * @see com.rumbasolutions.flask.service.base.FlaskGroupUsersServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.FlaskGroupUsersServiceImpl
 * @generated
 */
public class FlaskGroupUsersServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.FlaskGroupUsersServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> getAllGroupUsers(
		long groupId) {
		return getService().getAllGroupUsers(groupId);
	}

	public static com.rumbasolutions.flask.model.FlaskGroupUsers addGroupUser(
		long groupId, long userId, java.lang.String userName,
		java.lang.String emailAddress, int isAdmin) {
		return getService()
				   .addGroupUser(groupId, userId, userName, emailAddress,
			isAdmin);
	}

	public static com.rumbasolutions.flask.model.FlaskGroupUsers updateGroupUser(
		long groupUserId, long groupId, long userId, java.lang.String userName,
		java.lang.String emailAddress, int isAdmin) {
		return getService()
				   .updateGroupUser(groupUserId, groupId, userId, userName,
			emailAddress, isAdmin);
	}

	public static void addGroupOwner(long groupId, long userId) {
		getService().addGroupOwner(groupId, userId);
	}

	public static void deleteGroupUser(long groupId, long userId) {
		getService().deleteGroupUser(groupId, userId);
	}

	public static void deleteGroupUsers(long groupId, java.lang.String userIds) {
		getService().deleteGroupUsers(groupId, userIds);
	}

	public static void clearService() {
		_service = null;
	}

	public static FlaskGroupUsersService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FlaskGroupUsersService.class.getName());

			if (invokableService instanceof FlaskGroupUsersService) {
				_service = (FlaskGroupUsersService)invokableService;
			}
			else {
				_service = new FlaskGroupUsersServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(FlaskGroupUsersServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FlaskGroupUsersService service) {
	}

	private static FlaskGroupUsersService _service;
}