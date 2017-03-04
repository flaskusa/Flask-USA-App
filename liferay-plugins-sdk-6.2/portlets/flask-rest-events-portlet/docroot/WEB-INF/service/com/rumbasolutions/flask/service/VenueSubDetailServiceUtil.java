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
 * Provides the remote service utility for VenueSubDetail. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.VenueSubDetailServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Ashutosh Rai
 * @see VenueSubDetailService
 * @see com.rumbasolutions.flask.service.base.VenueSubDetailServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.VenueSubDetailServiceImpl
 * @generated
 */
public class VenueSubDetailServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.VenueSubDetailServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.rumbasolutions.flask.model.VenueSubDetail addVenueSubDetail(
		long venueDetailId, java.lang.String venueSubDetailTitle,
		java.lang.String venueSubDetailDesc) {
		return getService()
				   .addVenueSubDetail(venueDetailId, venueSubDetailTitle,
			venueSubDetailDesc);
	}

	public static java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> addVenueSubDetailsByJsonArray(
		long venueDetailId, java.lang.String subDetailJson) {
		return getService()
				   .addVenueSubDetailsByJsonArray(venueDetailId, subDetailJson);
	}

	public static com.rumbasolutions.flask.model.VenueSubDetail updateVenueSubDetail(
		long venueSubDetailId, long venueDetailId,
		java.lang.String venueSubDetailTitle,
		java.lang.String venueSubDetailDesc) {
		return getService()
				   .updateVenueSubDetail(venueSubDetailId, venueDetailId,
			venueSubDetailTitle, venueSubDetailDesc);
	}

	public static com.rumbasolutions.flask.model.VenueSubDetail getVenueSubDetailById(
		long venueSubDetailId) {
		return getService().getVenueSubDetailById(venueSubDetailId);
	}

	public static java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> getVenueSubDetailByVenueDetailId(
		long venueDetailId) {
		return getService().getVenueSubDetailByVenueDetailId(venueDetailId);
	}

	public static java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> getAllVenueSubDetails() {
		return getService().getAllVenueSubDetails();
	}

	public static void deletevenueSubDetailById(long venueSubDetailId) {
		getService().deletevenueSubDetailById(venueSubDetailId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VenueSubDetailService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VenueSubDetailService.class.getName());

			if (invokableService instanceof VenueSubDetailService) {
				_service = (VenueSubDetailService)invokableService;
			}
			else {
				_service = new VenueSubDetailServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(VenueSubDetailServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VenueSubDetailService service) {
	}

	private static VenueSubDetailService _service;
}