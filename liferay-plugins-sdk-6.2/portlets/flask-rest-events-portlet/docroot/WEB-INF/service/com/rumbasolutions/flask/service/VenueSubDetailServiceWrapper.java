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
 * Provides a wrapper for {@link VenueSubDetailService}.
 *
 * @author Ashutosh Rai
 * @see VenueSubDetailService
 * @generated
 */
public class VenueSubDetailServiceWrapper implements VenueSubDetailService,
	ServiceWrapper<VenueSubDetailService> {
	public VenueSubDetailServiceWrapper(
		VenueSubDetailService venueSubDetailService) {
		_venueSubDetailService = venueSubDetailService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _venueSubDetailService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_venueSubDetailService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _venueSubDetailService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueSubDetail addVenueSubDetail(
		long venueDetailId, java.lang.String venueSubDetailTitle,
		java.lang.String venueSubDetailDesc) {
		return _venueSubDetailService.addVenueSubDetail(venueDetailId,
			venueSubDetailTitle, venueSubDetailDesc);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> addVenueSubDetailsByJsonArray(
		long venueDetailId, java.lang.String subDetailJson) {
		return _venueSubDetailService.addVenueSubDetailsByJsonArray(venueDetailId,
			subDetailJson);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueSubDetail updateVenueSubDetail(
		long venueSubDetailId, long venueDetailId,
		java.lang.String venueSubDetailTitle,
		java.lang.String venueSubDetailDesc) {
		return _venueSubDetailService.updateVenueSubDetail(venueSubDetailId,
			venueDetailId, venueSubDetailTitle, venueSubDetailDesc);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueSubDetail getVenueSubDetailById(
		long venueSubDetailId) {
		return _venueSubDetailService.getVenueSubDetailById(venueSubDetailId);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> getVenueSubDetailByVenueDetailId(
		long venueDetailId) {
		return _venueSubDetailService.getVenueSubDetailByVenueDetailId(venueDetailId);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> getAllVenueSubDetails() {
		return _venueSubDetailService.getAllVenueSubDetails();
	}

	@Override
	public void deletevenueSubDetailById(long venueSubDetailId) {
		_venueSubDetailService.deletevenueSubDetailById(venueSubDetailId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VenueSubDetailService getWrappedVenueSubDetailService() {
		return _venueSubDetailService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVenueSubDetailService(
		VenueSubDetailService venueSubDetailService) {
		_venueSubDetailService = venueSubDetailService;
	}

	@Override
	public VenueSubDetailService getWrappedService() {
		return _venueSubDetailService;
	}

	@Override
	public void setWrappedService(VenueSubDetailService venueSubDetailService) {
		_venueSubDetailService = venueSubDetailService;
	}

	private VenueSubDetailService _venueSubDetailService;
}