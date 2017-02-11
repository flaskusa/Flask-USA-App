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
 * Provides a wrapper for {@link EventSubDetailService}.
 *
 * @author Ashutosh Rai
 * @see EventSubDetailService
 * @generated
 */
public class EventSubDetailServiceWrapper implements EventSubDetailService,
	ServiceWrapper<EventSubDetailService> {
	public EventSubDetailServiceWrapper(
		EventSubDetailService eventSubDetailService) {
		_eventSubDetailService = eventSubDetailService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _eventSubDetailService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eventSubDetailService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eventSubDetailService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.rumbasolutions.flask.model.EventSubDetail addEventSubDetail(
		long eventDetailId, java.lang.String eventSubDetailTitle,
		java.lang.String eventSubDetailDesc) {
		return _eventSubDetailService.addEventSubDetail(eventDetailId,
			eventSubDetailTitle, eventSubDetailDesc);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.EventSubDetail> addEventSubDetailsByJsonArray(
		long eventDetailId, java.lang.String subDetailJson) {
		return _eventSubDetailService.addEventSubDetailsByJsonArray(eventDetailId,
			subDetailJson);
	}

	@Override
	public com.rumbasolutions.flask.model.EventSubDetail updateEventSubDetail(
		long eventSubDetailId, long eventDetailId,
		java.lang.String eventSubDetailTitle,
		java.lang.String eventSubDetailDesc) {
		return _eventSubDetailService.updateEventSubDetail(eventSubDetailId,
			eventDetailId, eventSubDetailTitle, eventSubDetailDesc);
	}

	@Override
	public com.rumbasolutions.flask.model.EventSubDetail getEventSubDetailById(
		long eventSubDetailId) {
		return _eventSubDetailService.getEventSubDetailById(eventSubDetailId);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.EventSubDetail> getAllEventSubDetails() {
		return _eventSubDetailService.getAllEventSubDetails();
	}

	@Override
	public void deleteEventSubDetailById(long eventSubDetailId) {
		_eventSubDetailService.deleteEventSubDetailById(eventSubDetailId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EventSubDetailService getWrappedEventSubDetailService() {
		return _eventSubDetailService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEventSubDetailService(
		EventSubDetailService eventSubDetailService) {
		_eventSubDetailService = eventSubDetailService;
	}

	@Override
	public EventSubDetailService getWrappedService() {
		return _eventSubDetailService;
	}

	@Override
	public void setWrappedService(EventSubDetailService eventSubDetailService) {
		_eventSubDetailService = eventSubDetailService;
	}

	private EventSubDetailService _eventSubDetailService;
}