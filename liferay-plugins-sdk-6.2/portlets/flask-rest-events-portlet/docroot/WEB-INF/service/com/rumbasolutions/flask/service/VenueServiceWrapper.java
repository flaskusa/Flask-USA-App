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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VenueService}.
 *
 * @author Ashutosh Rai
 * @see VenueService
 * @generated
 */
public class VenueServiceWrapper implements VenueService,
	ServiceWrapper<VenueService> {
	public VenueServiceWrapper(VenueService venueService) {
		_venueService = venueService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _venueService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_venueService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _venueService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.Venue> getAllVenues(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _venueService.getAllVenues(serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.Venue addVenue(
		java.lang.String venueName, java.lang.String venueDescription,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String venueZipCode, java.lang.String venueCity,
		java.lang.String venueMetroArea, long venueStateId,
		long venueCountryId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _venueService.addVenue(venueName, venueDescription, addrLine1,
			addrLine2, venueZipCode, venueCity, venueMetroArea, venueStateId,
			venueCountryId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.Venue updateVenue(long venueId,
		java.lang.String venueName, java.lang.String venueDescription,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String venueZipCode, java.lang.String venueCity,
		java.lang.String venueMetroArea, long venueStateId,
		long venueCountryId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _venueService.updateVenue(venueId, venueName, venueDescription,
			addrLine1, addrLine2, venueZipCode, venueCity, venueMetroArea,
			venueStateId, venueCountryId, serviceContext);
	}

	@Override
	public void deleteVenue(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_venueService.deleteVenue(venueId, serviceContext);
	}

	/**
	* @param venueList comms seperated venueId list
	* @param serviceContext
	* @return
	*/
	@Override
	public void deleteVenues(java.lang.String venueList,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_venueService.deleteVenues(venueList, serviceContext);
	}

	@Override
	public void addVenueImage(long venueId, java.lang.String title,
		java.sql.Blob venueImageData,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_venueService.addVenueImage(venueId, title, venueImageData,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VenueService getWrappedVenueService() {
		return _venueService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVenueService(VenueService venueService) {
		_venueService = venueService;
	}

	@Override
	public VenueService getWrappedService() {
		return _venueService;
	}

	@Override
	public void setWrappedService(VenueService venueService) {
		_venueService = venueService;
	}

	private VenueService _venueService;
}