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
 * Provides the remote service utility for SupplyItem. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.SupplyItemServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SupplyItemService
 * @see com.rumbasolutions.flask.service.base.SupplyItemServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.SupplyItemServiceImpl
 * @generated
 */
public class SupplyItemServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.SupplyItemServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.rumbasolutions.flask.model.SupplyItem addSupplyItem(
		java.lang.String supplyItemName, long supplyListId,
		java.util.Date createdDate, java.util.Date modifiedDate,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addSupplyItem(supplyItemName, supplyListId, createdDate,
			modifiedDate, serviceContext);
	}

	public static com.rumbasolutions.flask.model.SupplyItem updateSupplyItem(
		long supplyItemId, java.lang.String supplyItemName, long supplyListId,
		java.util.Date createdDate, java.util.Date modifiedDate,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateSupplyItem(supplyItemId, supplyItemName,
			supplyListId, createdDate, modifiedDate, serviceContext);
	}

	public static com.rumbasolutions.flask.model.SupplyItem getSupplyItem(
		long supplyItemId) {
		return getService().getSupplyItem(supplyItemId);
	}

	public static java.util.List<com.rumbasolutions.flask.model.SupplyItem> getAllSupplyItems() {
		return getService().getAllSupplyItems();
	}

	public static java.util.List<com.rumbasolutions.flask.model.SupplyItem> getItemsByListId(
		long supplyListId) {
		return getService().getItemsByListId(supplyListId);
	}

	public static void deleteSupplyItem(long supplyItemId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteSupplyItem(supplyItemId, serviceContext);
	}

	public static void deleteItemsByListId(long supplyListId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteItemsByListId(supplyListId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static SupplyItemService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SupplyItemService.class.getName());

			if (invokableService instanceof SupplyItemService) {
				_service = (SupplyItemService)invokableService;
			}
			else {
				_service = new SupplyItemServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SupplyItemServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SupplyItemService service) {
	}

	private static SupplyItemService _service;
}