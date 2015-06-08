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
 * Provides the remote service utility for Venue. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.VenueServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Ashutosh Rai
 * @see VenueService
 * @see com.rumbasolutions.flask.service.base.VenueServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.VenueServiceImpl
 * @generated
 */
public class VenueServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.VenueServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static java.util.List<com.rumbasolutions.flask.model.Venue> getAllVenues(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getAllVenues(serviceContext);
	}

	public static com.rumbasolutions.flask.model.Venue addVenue(
		java.lang.String venueName, java.lang.String venueDescription,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String venueZipCode, java.lang.String venueCity,
		long venueStateId, long venueCountryId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addVenue(venueName, venueDescription, addrLine1, addrLine2,
			venueZipCode, venueCity, venueStateId, venueCountryId,
			serviceContext);
	}

	public static void addVenueImage(long venueId, java.lang.String title,
		java.sql.Blob venueImageData,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService()
			.addVenueImage(venueId, title, venueImageData, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static VenueService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VenueService.class.getName());

			if (invokableService instanceof VenueService) {
				_service = (VenueService)invokableService;
			}
			else {
				_service = new VenueServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(VenueServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VenueService service) {
	}

	private static VenueService _service;
}