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
 * Provides the remote service utility for SupplyList. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.SupplyListServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SupplyListService
 * @see com.rumbasolutions.flask.service.base.SupplyListServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.SupplyListServiceImpl
 * @generated
 */
public class SupplyListServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.SupplyListServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.rumbasolutions.flask.model.SupplyList addSupplyList(
		java.lang.String supplyListName, boolean isSystem,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addSupplyList(supplyListName, isSystem, serviceContext);
	}

	public static com.rumbasolutions.flask.model.SupplyList updateSupplyList(
		long supplyListId, java.lang.String supplyListName, boolean isSystem,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateSupplyList(supplyListId, supplyListName, isSystem,
			serviceContext);
	}

	public static com.rumbasolutions.flask.model.SupplyList getSupplyList(
		long supplyListId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getSupplyList(supplyListId, serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.SupplyList> getAllSupplyLists(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getAllSupplyLists(serviceContext);
	}

	public static com.liferay.portal.kernel.json.JSONArray getMySupplyLists(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getMySupplyLists(serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.SupplyItem> getGameDayNeeds() {
		return getService().getGameDayNeeds();
	}

	public static void deleteSupplyList(long supplyListId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteSupplyList(supplyListId, serviceContext);
	}

	public static void deleteMySupplyLists(
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteMySupplyLists(serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static SupplyListService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SupplyListService.class.getName());

			if (invokableService instanceof SupplyListService) {
				_service = (SupplyListService)invokableService;
			}
			else {
				_service = new SupplyListServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SupplyListServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SupplyListService service) {
	}

	private static SupplyListService _service;
}