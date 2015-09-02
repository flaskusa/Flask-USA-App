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

package com.rumbasolutions.flask.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.rumbasolutions.flask.service.EventServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.rumbasolutions.flask.service.EventServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.rumbasolutions.flask.model.EventSoap}.
 * If the method in the service utility returns a
 * {@link com.rumbasolutions.flask.model.Event}, that is translated to a
 * {@link com.rumbasolutions.flask.model.EventSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventServiceHttp
 * @see com.rumbasolutions.flask.model.EventSoap
 * @see com.rumbasolutions.flask.service.EventServiceUtil
 * @generated
 */
public class EventServiceSoap {
	public static java.lang.String getAllEvents(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = EventServiceUtil.getAllEvents(serviceContext);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getSimpleFilteredEvents(
		java.lang.String eventTypeIds, java.lang.String startDate,
		java.lang.String endDate, java.lang.String searchString,
		java.lang.String latitude, java.lang.String longitude,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = EventServiceUtil.getSimpleFilteredEvents(eventTypeIds,
					startDate, endDate, searchString, latitude, longitude,
					serviceContext);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getUserSelectedEvents(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = EventServiceUtil.getUserSelectedEvents(serviceContext);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.EventSoap getEvent(
		long eventId, com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.Event returnValue = EventServiceUtil.getEvent(eventId,
					serviceContext);

			return com.rumbasolutions.flask.model.EventSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.EventSoap addEvent(
		java.lang.String eventName, java.lang.String description,
		java.lang.String eventDate, java.util.Date startTime,
		java.util.Date endTime, long eventTypeId, long venueId,
		java.lang.String eventImageUUID, long eventImageGroupId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.Event returnValue = EventServiceUtil.addEvent(eventName,
					description, eventDate, startTime, endTime, eventTypeId,
					venueId, eventImageUUID, eventImageGroupId, serviceContext);

			return com.rumbasolutions.flask.model.EventSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.EventSoap updateEvent(
		long eventId, java.lang.String eventName, java.lang.String description,
		java.lang.String eventDate, java.util.Date startTime,
		java.util.Date endTime, long eventTypeId, long venueId,
		java.lang.String eventImageUUID, long eventImageGroupId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.Event returnValue = EventServiceUtil.updateEvent(eventId,
					eventName, description, eventDate, startTime, endTime,
					eventTypeId, venueId, eventImageUUID, eventImageGroupId,
					serviceContext);

			return com.rumbasolutions.flask.model.EventSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteEvent(long eventId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			EventServiceUtil.deleteEvent(eventId, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteEvents(java.lang.String eventIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			EventServiceUtil.deleteEvents(eventIds, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.EventDetailSoap addEventDetail(
		long eventId, long infoTypeId, long infoTypeCategoryId,
		java.lang.String infoTitle, java.lang.String infoDesc,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String zipCode, java.lang.String city, long stateId,
		long countryId, java.lang.String latitude, java.lang.String longitude,
		java.lang.String phone, java.lang.String website,
		java.lang.Double cost, java.lang.String hoursOfOperation,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.EventDetail returnValue = EventServiceUtil.addEventDetail(eventId,
					infoTypeId, infoTypeCategoryId, infoTitle, infoDesc,
					addrLine1, addrLine2, zipCode, city, stateId, countryId,
					latitude, longitude, phone, website, cost,
					hoursOfOperation, serviceContext);

			return com.rumbasolutions.flask.model.EventDetailSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.EventDetailSoap updateEventDetail(
		long eventDetailId, long infoTypeId, long infoTypeCategoryId,
		java.lang.String infoTitle, java.lang.String infoDesc,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String zipCode, java.lang.String city, long stateId,
		long countryId, java.lang.String latitude, java.lang.String longitude,
		java.lang.String phone, java.lang.String website,
		java.lang.Double cost, java.lang.String hoursOfOperation,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.EventDetail returnValue = EventServiceUtil.updateEventDetail(eventDetailId,
					infoTypeId, infoTypeCategoryId, infoTitle, infoDesc,
					addrLine1, addrLine2, zipCode, city, stateId, countryId,
					latitude, longitude, phone, website, cost,
					hoursOfOperation, serviceContext);

			return com.rumbasolutions.flask.model.EventDetailSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.EventDetailSoap getEventDetail(
		long eventDetailId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.EventDetail returnValue = EventServiceUtil.getEventDetail(eventDetailId,
					serviceContext);

			return com.rumbasolutions.flask.model.EventDetailSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.EventDetailSoap[] getEventDetails(
		long eventId, com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.EventDetail> returnValue =
				EventServiceUtil.getEventDetails(eventId, serviceContext);

			return com.rumbasolutions.flask.model.EventDetailSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getEventDetailsWithImages(long eventId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = EventServiceUtil.getEventDetailsWithImages(eventId,
					serviceContext);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getEventVenueDetailsWithImages(
		long eventId, com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = EventServiceUtil.getEventVenueDetailsWithImages(eventId,
					serviceContext);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteEventDetail(long eventDetailId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			EventServiceUtil.deleteEventDetail(eventDetailId, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteAllEventDetails(long eventId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			EventServiceUtil.deleteAllEventDetails(eventId, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.EventDetailImageSoap addEventDetailImage(
		long eventDetailId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID, long groupId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.EventDetailImage returnValue = EventServiceUtil.addEventDetailImage(eventDetailId,
					imageTitle, imageDesc, imageUUID, groupId, serviceContext);

			return com.rumbasolutions.flask.model.EventDetailImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.EventDetailImageSoap updateEventDetailImage(
		long eventDetailImageId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID, long groupId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.EventDetailImage returnValue = EventServiceUtil.updateEventDetailImage(eventDetailImageId,
					imageTitle, imageDesc, imageUUID, groupId, serviceContext);

			return com.rumbasolutions.flask.model.EventDetailImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.EventDetailImageSoap getEventDetailImage(
		long eventDetailImageId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.EventDetailImage returnValue = EventServiceUtil.getEventDetailImage(eventDetailImageId,
					serviceContext);

			return com.rumbasolutions.flask.model.EventDetailImageSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.EventDetailImageSoap[] getEventDetailImages(
		long eventDetailId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.EventDetailImage> returnValue =
				EventServiceUtil.getEventDetailImages(eventDetailId,
					serviceContext);

			return com.rumbasolutions.flask.model.EventDetailImageSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteEventDetailImage(long eventDetailImageId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			EventServiceUtil.deleteEventDetailImage(eventDetailImageId,
				serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addUserEvent(long eventId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			EventServiceUtil.addUserEvent(eventId, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void removeUserEvent(long eventId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			EventServiceUtil.removeUserEvent(eventId, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.Long[] getUserEventIds(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<java.lang.Long> returnValue = EventServiceUtil.getUserEventIds(serviceContext);

			return returnValue.toArray(new java.lang.Long[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EventServiceSoap.class);
}