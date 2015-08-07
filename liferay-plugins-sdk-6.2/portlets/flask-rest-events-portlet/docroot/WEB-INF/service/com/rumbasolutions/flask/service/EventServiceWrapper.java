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
 * Provides a wrapper for {@link EventService}.
 *
 * @author Ashutosh Rai
 * @see EventService
 * @generated
 */
public class EventServiceWrapper implements EventService,
	ServiceWrapper<EventService> {
	public EventServiceWrapper(EventService eventService) {
		_eventService = eventService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _eventService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eventService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eventService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getAllEvents(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _eventService.getAllEvents(serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getUserSelectedEvents(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _eventService.getUserSelectedEvents(serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.Event getEvent(long eventId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _eventService.getEvent(eventId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.Event addEvent(
		java.lang.String eventName, java.lang.String description,
		java.lang.String eventDate, java.util.Date startTime,
		java.util.Date endTime, long eventTypeId, long venueId,
		java.lang.String eventImageUUID, long eventImageGroupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _eventService.addEvent(eventName, description, eventDate,
			startTime, endTime, eventTypeId, venueId, eventImageUUID,
			eventImageGroupId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.Event updateEvent(long eventId,
		java.lang.String eventName, java.lang.String description,
		java.lang.String eventDate, java.util.Date startTime,
		java.util.Date endTime, long eventTypeId, long venueId,
		java.lang.String eventImageUUID, long groupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _eventService.updateEvent(eventId, eventName, description,
			eventDate, startTime, endTime, eventTypeId, venueId,
			eventImageUUID, groupId, serviceContext);
	}

	@Override
	public void deleteEvent(long eventId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventService.deleteEvent(eventId, serviceContext);
	}

	@Override
	public void deleteEvents(java.lang.String eventIds,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventService.deleteEvents(eventIds, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.EventDetail addEventDetail(
		long eventId, long infoTypeId, long infoTypeCategoryId,
		java.lang.String infoTitle, java.lang.String infoDesc,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String zipCode, java.lang.String city, long stateId,
		long countryId, java.lang.String latitude, java.lang.String longitude,
		java.lang.String phone, java.lang.String website,
		java.lang.Double cost, java.lang.String hoursOfOperation,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _eventService.addEventDetail(eventId, infoTypeId,
			infoTypeCategoryId, infoTitle, infoDesc, addrLine1, addrLine2,
			zipCode, city, stateId, countryId, latitude, longitude, phone,
			website, cost, hoursOfOperation, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.EventDetail updateEventDetail(
		long eventDetailId, long infoTypeId, long infoTypeCategoryId,
		java.lang.String infoTitle, java.lang.String infoDesc,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String zipCode, java.lang.String city, long stateId,
		long countryId, java.lang.String latitude, java.lang.String longitude,
		java.lang.String phone, java.lang.String website,
		java.lang.Double cost, java.lang.String hoursOfOperation,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _eventService.updateEventDetail(eventDetailId, infoTypeId,
			infoTypeCategoryId, infoTitle, infoDesc, addrLine1, addrLine2,
			zipCode, city, stateId, countryId, latitude, longitude, phone,
			website, cost, hoursOfOperation, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.EventDetail getEventDetail(
		long eventDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _eventService.getEventDetail(eventDetailId, serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.EventDetail> getEventDetails(
		long eventId, com.liferay.portal.service.ServiceContext serviceContext) {
		return _eventService.getEventDetails(eventId, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getEventDetailsWithImages(
		long eventId, com.liferay.portal.service.ServiceContext serviceContext) {
		return _eventService.getEventDetailsWithImages(eventId, serviceContext);
	}

	@Override
	public void deleteEventDetail(long eventDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventService.deleteEventDetail(eventDetailId, serviceContext);
	}

	@Override
	public void deleteAllEventDetails(long eventId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventService.deleteAllEventDetails(eventId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.EventDetailImage addEventDetailImage(
		long eventDetailId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID, long groupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _eventService.addEventDetailImage(eventDetailId, imageTitle,
			imageDesc, imageUUID, groupId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.EventDetailImage updateEventDetailImage(
		long eventDetailImageId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID, long groupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _eventService.updateEventDetailImage(eventDetailImageId,
			imageTitle, imageDesc, imageUUID, groupId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.EventDetailImage getEventDetailImage(
		long eventDetailImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _eventService.getEventDetailImage(eventDetailImageId,
			serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.EventDetailImage> getEventDetailImages(
		long eventDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _eventService.getEventDetailImages(eventDetailId, serviceContext);
	}

	@Override
	public void deleteEventDetailImage(long eventDetailImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventService.deleteEventDetailImage(eventDetailImageId, serviceContext);
	}

	@Override
	public void addUserEvent(long eventId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventService.addUserEvent(eventId, serviceContext);
	}

	@Override
	public void removeUserEvent(long eventId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventService.removeUserEvent(eventId, serviceContext);
	}

	@Override
	public java.util.List<java.lang.Long> getUserEventIds(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _eventService.getUserEventIds(serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EventService getWrappedEventService() {
		return _eventService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEventService(EventService eventService) {
		_eventService = eventService;
	}

	@Override
	public EventService getWrappedService() {
		return _eventService;
	}

	@Override
	public void setWrappedService(EventService eventService) {
		_eventService = eventService;
	}

	private EventService _eventService;
}