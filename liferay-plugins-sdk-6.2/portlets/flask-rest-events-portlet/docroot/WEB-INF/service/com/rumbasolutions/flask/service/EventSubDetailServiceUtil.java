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
 * Provides the remote service utility for EventSubDetail. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.EventSubDetailServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Ashutosh Rai
 * @see EventSubDetailService
 * @see com.rumbasolutions.flask.service.base.EventSubDetailServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.EventSubDetailServiceImpl
 * @generated
 */
public class EventSubDetailServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.EventSubDetailServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.rumbasolutions.flask.model.EventSubDetail addEventSubDetail(
		long eventDetailId, java.lang.String eventSubDetailTitle,
		java.lang.String eventSubDetailDesc) {
		return getService()
				   .addEventSubDetail(eventDetailId, eventSubDetailTitle,
			eventSubDetailDesc);
	}

	public static java.util.List<com.rumbasolutions.flask.model.EventSubDetail> addEventSubDetailsByJsonArray(
		long eventDetailId, java.lang.String subDetailJson) {
		return getService()
				   .addEventSubDetailsByJsonArray(eventDetailId, subDetailJson);
	}

	public static com.rumbasolutions.flask.model.EventSubDetail updateEventSubDetail(
		long eventSubDetailId, long eventDetailId,
		java.lang.String eventSubDetailTitle,
		java.lang.String eventSubDetailDesc) {
		return getService()
				   .updateEventSubDetail(eventSubDetailId, eventDetailId,
			eventSubDetailTitle, eventSubDetailDesc);
	}

	public static com.rumbasolutions.flask.model.EventSubDetail getEventSubDetailById(
		long eventSubDetailId) {
		return getService().getEventSubDetailById(eventSubDetailId);
	}

	public static java.util.List<com.rumbasolutions.flask.model.EventSubDetail> getEventSubDetailByEventDetailId(
		long eventDetailId) {
		return getService().getEventSubDetailByEventDetailId(eventDetailId);
	}

	public static java.util.List<com.rumbasolutions.flask.model.EventSubDetail> getAllEventSubDetails() {
		return getService().getAllEventSubDetails();
	}

	public static void deleteEventSubDetailById(long eventSubDetailId) {
		getService().deleteEventSubDetailById(eventSubDetailId);
	}

	public static void clearService() {
		_service = null;
	}

	public static EventSubDetailService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EventSubDetailService.class.getName());

			if (invokableService instanceof EventSubDetailService) {
				_service = (EventSubDetailService)invokableService;
			}
			else {
				_service = new EventSubDetailServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(EventSubDetailServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EventSubDetailService service) {
	}

	private static EventSubDetailService _service;
}