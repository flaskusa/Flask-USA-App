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
 * Provides the remote service utility for TailgateInfo. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.TailgateInfoServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author rajeshj
 * @see TailgateInfoService
 * @see com.rumbasolutions.flask.service.base.TailgateInfoServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.TailgateInfoServiceImpl
 * @generated
 */
public class TailgateInfoServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.TailgateInfoServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.rumbasolutions.flask.model.TailgateInfo addTailgateInfo(
		java.lang.String tailgateName, java.lang.String tailgateDescription,
		long eventId, java.lang.String eventName, java.util.Date tailgateDate,
		java.util.Date startTime, java.util.Date endTime, boolean showMembers,
		long amountToPay,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addTailgateInfo(tailgateName, tailgateDescription, eventId,
			eventName, tailgateDate, startTime, endTime, showMembers,
			amountToPay, serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.TailgateInfo> getAllTailgate() {
		return getService().getAllTailgate();
	}

	public static java.util.List<com.rumbasolutions.flask.model.TailgateInfo> getAllMyTailgate(
		long userId) {
		return getService().getAllMyTailgate(userId);
	}

	public static java.util.List<com.rumbasolutions.flask.model.TailgateInfo> getAllTailgeteByUserId(
		long userId) {
		return getService().getAllTailgeteByUserId(userId);
	}

	public static com.rumbasolutions.flask.model.TailgateInfo getTailgate(
		int tailgateId) {
		return getService().getTailgate(tailgateId);
	}

	public static com.rumbasolutions.flask.model.TailgateInfo updateTailgateInfo(
		long tailgateId, java.lang.String tailgateName,
		java.lang.String tailgateDescription, long eventId,
		java.lang.String eventName, java.util.Date tailgateDate,
		java.util.Date startTime, java.util.Date endTime, boolean showMembers,
		long amountToPay,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateTailgateInfo(tailgateId, tailgateName,
			tailgateDescription, eventId, eventName, tailgateDate, startTime,
			endTime, showMembers, amountToPay, serviceContext);
	}

	public static void deleteTailgateInfo(long tailgateId) {
		getService().deleteTailgateInfo(tailgateId);
	}

	public static void clearService() {
		_service = null;
	}

	public static TailgateInfoService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TailgateInfoService.class.getName());

			if (invokableService instanceof TailgateInfoService) {
				_service = (TailgateInfoService)invokableService;
			}
			else {
				_service = new TailgateInfoServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(TailgateInfoServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TailgateInfoService service) {
	}

	private static TailgateInfoService _service;
}