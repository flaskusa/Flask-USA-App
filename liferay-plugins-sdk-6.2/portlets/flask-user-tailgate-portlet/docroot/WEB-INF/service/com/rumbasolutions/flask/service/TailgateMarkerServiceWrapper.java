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
 * Provides a wrapper for {@link TailgateMarkerService}.
 *
 * @author Brian Wing Shun Chan
 * @see TailgateMarkerService
 * @generated
 */
public class TailgateMarkerServiceWrapper implements TailgateMarkerService,
	ServiceWrapper<TailgateMarkerService> {
	public TailgateMarkerServiceWrapper(
		TailgateMarkerService tailgateMarkerService) {
		_tailgateMarkerService = tailgateMarkerService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tailgateMarkerService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tailgateMarkerService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tailgateMarkerService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateMarker getTailgateMarker(
		long tailgateId) {
		return _tailgateMarkerService.getTailgateMarker(tailgateId);
	}

	@Override
	public void deleteTailgateMarker(long tailgateId) {
		_tailgateMarkerService.deleteTailgateMarker(tailgateId);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateMarker addTailgateMarker(
		long tailgateId, java.lang.String latitude, java.lang.String longitude,
		java.lang.String name, java.lang.String description) {
		return _tailgateMarkerService.addTailgateMarker(tailgateId, latitude,
			longitude, name, description);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TailgateMarkerService getWrappedTailgateMarkerService() {
		return _tailgateMarkerService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTailgateMarkerService(
		TailgateMarkerService tailgateMarkerService) {
		_tailgateMarkerService = tailgateMarkerService;
	}

	@Override
	public TailgateMarkerService getWrappedService() {
		return _tailgateMarkerService;
	}

	@Override
	public void setWrappedService(TailgateMarkerService tailgateMarkerService) {
		_tailgateMarkerService = tailgateMarkerService;
	}

	private TailgateMarkerService _tailgateMarkerService;
}