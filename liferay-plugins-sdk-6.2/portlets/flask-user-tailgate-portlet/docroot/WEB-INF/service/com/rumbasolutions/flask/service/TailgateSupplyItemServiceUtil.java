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
 * Provides the remote service utility for TailgateSupplyItem. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.TailgateSupplyItemServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TailgateSupplyItemService
 * @see com.rumbasolutions.flask.service.base.TailgateSupplyItemServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.TailgateSupplyItemServiceImpl
 * @generated
 */
public class TailgateSupplyItemServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.TailgateSupplyItemServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.rumbasolutions.flask.model.TailgateSupplyItem addTailgateSupplyItem(
		java.lang.String supplyListItemName, long tailgateId,
		long itemAssignedUserId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addTailgateSupplyItem(supplyListItemName, tailgateId,
			itemAssignedUserId, serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> addTailgateSupplyItems(
		java.lang.String[] supplyListItemNames, long tailgateId,
		long itemAssignedUserId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addTailgateSupplyItems(supplyListItemNames, tailgateId,
			itemAssignedUserId, serviceContext);
	}

	public static com.rumbasolutions.flask.model.TailgateSupplyItem updateTailgateSupplyItem(
		long tailgateSupplyItemId, java.lang.String supplyListItemName,
		long tailgateId, long itemAssignedUserId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateTailgateSupplyItem(tailgateSupplyItemId,
			supplyListItemName, tailgateId, itemAssignedUserId, serviceContext);
	}

	public static com.rumbasolutions.flask.model.TailgateSupplyItem getTailgateSupplyItem(
		long tailgateSupplyItemId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .getTailgateSupplyItem(tailgateSupplyItemId, serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> getItemsByTailgateId(
		long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getItemsByTailgateId(tailgateId, serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> getMyTailgateSupplyItems(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getMyTailgateSupplyItems(serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> getAllTailgateSupplyItems(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getAllTailgateSupplyItems(serviceContext);
	}

	public static void deleteTailgateSupplyItem(long tailgateSupplyItemId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService()
			.deleteTailgateSupplyItem(tailgateSupplyItemId, serviceContext);
	}

	public static void deleteItemsByTailgateId(long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteItemsByTailgateId(tailgateId, serviceContext);
	}

	public static void deleteMyItems(
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteMyItems(serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static TailgateSupplyItemService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TailgateSupplyItemService.class.getName());

			if (invokableService instanceof TailgateSupplyItemService) {
				_service = (TailgateSupplyItemService)invokableService;
			}
			else {
				_service = new TailgateSupplyItemServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(TailgateSupplyItemServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TailgateSupplyItemService service) {
	}

	private static TailgateSupplyItemService _service;
}