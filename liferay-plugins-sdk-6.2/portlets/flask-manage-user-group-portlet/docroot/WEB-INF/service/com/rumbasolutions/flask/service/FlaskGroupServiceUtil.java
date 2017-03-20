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
 * Provides the remote service utility for FlaskGroup. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.FlaskGroupServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupService
 * @see com.rumbasolutions.flask.service.base.FlaskGroupServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.FlaskGroupServiceImpl
 * @generated
 */
public class FlaskGroupServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.FlaskGroupServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static java.util.List<com.rumbasolutions.flask.model.FlaskGroup> getAllGroups() {
		return getService().getAllGroups();
	}

	public static com.liferay.portal.kernel.json.JSONArray getAllMyGroups(
		long userId) {
		return getService().getAllMyGroups(userId);
	}

	public static java.util.List<com.rumbasolutions.flask.model.FlaskGroup> getGroups(
		long userId) {
		return getService().getGroups(userId);
	}

	public static java.util.List<com.rumbasolutions.flask.model.FlaskGroup> getMyGroups(
		long userId) {
		return getService().getMyGroups(userId);
	}

	public static java.util.List<com.rumbasolutions.flask.model.FlaskGroup> getParticipatingGroups(
		long userId) {
		return getService().getParticipatingGroups(userId);
	}

	public static com.rumbasolutions.flask.model.FlaskGroup getGroup(
		long groupId) {
		return getService().getGroup(groupId);
	}

	public static com.rumbasolutions.flask.model.FlaskGroup addGroup(
		java.lang.String groupName, java.lang.String groupDescription,
		java.lang.String createdBy, java.lang.String createdDate, int isActive,
		int isDelete, com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addGroup(groupName, groupDescription, createdBy,
			createdDate, isActive, isDelete, serviceContext);
	}

	public static com.rumbasolutions.flask.model.FlaskGroup updateGroup(
		long groupId, java.lang.String groupName,
		java.lang.String groupDescription, java.lang.String createdDate,
		java.lang.String createdBy, int isActive, int isDelete) {
		return getService()
				   .updateGroup(groupId, groupName, groupDescription,
			createdDate, createdBy, isActive, isDelete);
	}

	public static void deleteGroup(long groupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteGroup(groupId, serviceContext);
	}

	public static void deleteGroups(java.lang.String groupList,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteGroups(groupList, serviceContext);
	}

	public static void deactivateGroup(long groupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deactivateGroup(groupId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static FlaskGroupService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FlaskGroupService.class.getName());

			if (invokableService instanceof FlaskGroupService) {
				_service = (FlaskGroupService)invokableService;
			}
			else {
				_service = new FlaskGroupServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(FlaskGroupServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FlaskGroupService service) {
	}

	private static FlaskGroupService _service;
}