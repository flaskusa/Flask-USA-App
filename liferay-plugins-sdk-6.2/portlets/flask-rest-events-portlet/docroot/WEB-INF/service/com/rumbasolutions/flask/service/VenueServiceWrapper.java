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
		java.lang.String venueImagePath,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_venueService.addVenueImage(venueId, title, venueImagePath,
			serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueImage> getVenueImages(
		long venueId, com.liferay.portal.service.ServiceContext serviceContext) {
		return _venueService.getVenueImages(venueId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueImage getVenueImage(
		long venueImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _venueService.getVenueImage(venueImageId, serviceContext);
	}

	@Override
	public void updateVenueImage(long venueImageId, java.lang.String title,
		java.lang.String venueImagePath,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_venueService.updateVenueImage(venueImageId, title, venueImagePath,
			serviceContext);
	}

	@Override
	public void deleteVenueImage(long venueImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_venueService.deleteVenueImage(venueImageId, serviceContext);
	}

	@Override
	public void deleteAllVenueImages(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_venueService.deleteAllVenueImages(venueId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDetail addVenueDetail(
		long venueId, long infoTypeId, long infoTypeCategoryId,
		java.lang.String infoTitle, java.lang.String infoDesc,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String zipCode, java.lang.String city, long stateId,
		long countryId, java.lang.String lattitude, java.lang.String longitude,
		java.lang.String phone, java.lang.String website,
		java.lang.Double cost, java.lang.String hoursOfOperation,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _venueService.addVenueDetail(venueId, infoTypeId,
			infoTypeCategoryId, infoTitle, infoDesc, addrLine1, addrLine2,
			zipCode, city, stateId, countryId, lattitude, longitude, phone,
			website, cost, hoursOfOperation, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDetail updateVenueDetail(
		long venueDetailId, long infoTypeId, long infoTypeCategoryId,
		java.lang.String infoTitle, java.lang.String infoDesc,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String zipCode, java.lang.String city, long stateId,
		long countryId, java.lang.String lattitude, java.lang.String longitude,
		java.lang.String phone, java.lang.String website,
		java.lang.Double cost, java.lang.String hoursOfOperation,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _venueService.updateVenueDetail(venueDetailId, infoTypeId,
			infoTypeCategoryId, infoTitle, infoDesc, addrLine1, addrLine2,
			zipCode, city, stateId, countryId, lattitude, longitude, phone,
			website, cost, hoursOfOperation, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDetail getVenueDetail(
		long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _venueService.getVenueDetail(venueDetailId, serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueDetail> getVenueDetails(
		long venueId, com.liferay.portal.service.ServiceContext serviceContext) {
		return _venueService.getVenueDetails(venueId, serviceContext);
	}

	@Override
	public void deleteVenueDetail(long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_venueService.deleteVenueDetail(venueDetailId, serviceContext);
	}

	@Override
	public void deleteAllVenueDetails(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_venueService.deleteAllVenueDetails(venueId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDetailImage addVenueDetailImage(
		long venueDetailId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imagePath,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _venueService.addVenueDetailImage(venueDetailId, imageTitle,
			imageDesc, imagePath, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDetailImage updateVenueDetailImage(
		long venueDetailImageId, long venueDetailId,
		java.lang.String imageTitle, java.lang.String imageDesc,
		java.lang.String imagePath,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _venueService.updateVenueDetailImage(venueDetailImageId,
			venueDetailId, imageTitle, imageDesc, imagePath, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDetailImage getVenueDetailImage(
		long venueDetailImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _venueService.getVenueDetailImage(venueDetailImageId,
			serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> getVenueDetailImages(
		long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _venueService.getVenueDetailImages(venueDetailId, serviceContext);
	}

	@Override
	public void deleteVenueDetailImage(long venueDetailImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_venueService.deleteVenueDetailImage(venueDetailImageId, serviceContext);
	}

	@Override
	public void deleteAllVenueDetailImages(long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_venueService.deleteAllVenueDetailImages(venueDetailId, serviceContext);
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