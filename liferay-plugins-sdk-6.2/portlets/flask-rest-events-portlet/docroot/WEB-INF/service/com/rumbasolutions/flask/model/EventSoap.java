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

package com.rumbasolutions.flask.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.EventServiceSoap}.
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.http.EventServiceSoap
 * @generated
 */
public class EventSoap implements Serializable {
	public static EventSoap toSoapModel(Event model) {
		EventSoap soapModel = new EventSoap();

		soapModel.setEventId(model.getEventId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEventName(model.getEventName());
		soapModel.setDescription(model.getDescription());
		soapModel.setEventDate(model.getEventDate());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setEventTypeId(model.getEventTypeId());
		soapModel.setEventTypeName(model.getEventTypeName());
		soapModel.setEventImageUUID(model.getEventImageUUID());
		soapModel.setEventImageGroupId(model.getEventImageGroupId());
		soapModel.setVenueId(model.getVenueId());
		soapModel.setVenueName(model.getVenueName());

		return soapModel;
	}

	public static EventSoap[] toSoapModels(Event[] models) {
		EventSoap[] soapModels = new EventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventSoap[][] toSoapModels(Event[][] models) {
		EventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventSoap[] toSoapModels(List<Event> models) {
		List<EventSoap> soapModels = new ArrayList<EventSoap>(models.size());

		for (Event model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventSoap[soapModels.size()]);
	}

	public EventSoap() {
	}

	public long getPrimaryKey() {
		return _eventId;
	}

	public void setPrimaryKey(long pk) {
		setEventId(pk);
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getEventName() {
		return _eventName;
	}

	public void setEventName(String eventName) {
		_eventName = eventName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getEventDate() {
		return _eventDate;
	}

	public void setEventDate(Date eventDate) {
		_eventDate = eventDate;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public long getEventTypeId() {
		return _eventTypeId;
	}

	public void setEventTypeId(long eventTypeId) {
		_eventTypeId = eventTypeId;
	}

	public String getEventTypeName() {
		return _eventTypeName;
	}

	public void setEventTypeName(String eventTypeName) {
		_eventTypeName = eventTypeName;
	}

	public String getEventImageUUID() {
		return _eventImageUUID;
	}

	public void setEventImageUUID(String eventImageUUID) {
		_eventImageUUID = eventImageUUID;
	}

	public long getEventImageGroupId() {
		return _eventImageGroupId;
	}

	public void setEventImageGroupId(long eventImageGroupId) {
		_eventImageGroupId = eventImageGroupId;
	}

	public long getVenueId() {
		return _venueId;
	}

	public void setVenueId(long venueId) {
		_venueId = venueId;
	}

	public String getVenueName() {
		return _venueName;
	}

	public void setVenueName(String venueName) {
		_venueName = venueName;
	}

	private long _eventId;
	private long _companyId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _eventName;
	private String _description;
	private Date _eventDate;
	private Date _startTime;
	private Date _endTime;
	private long _eventTypeId;
	private String _eventTypeName;
	private String _eventImageUUID;
	private long _eventImageGroupId;
	private long _venueId;
	private String _venueName;
}