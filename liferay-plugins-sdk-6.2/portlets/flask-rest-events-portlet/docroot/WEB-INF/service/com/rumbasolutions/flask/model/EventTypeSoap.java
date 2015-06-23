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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.EventTypeServiceSoap}.
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.http.EventTypeServiceSoap
 * @generated
 */
public class EventTypeSoap implements Serializable {
	public static EventTypeSoap toSoapModel(EventType model) {
		EventTypeSoap soapModel = new EventTypeSoap();

		soapModel.setEventTypeId(model.getEventTypeId());
		soapModel.setEventTypeKey(model.getEventTypeKey());
		soapModel.setEventTypeName(model.getEventTypeName());

		return soapModel;
	}

	public static EventTypeSoap[] toSoapModels(EventType[] models) {
		EventTypeSoap[] soapModels = new EventTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventTypeSoap[][] toSoapModels(EventType[][] models) {
		EventTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventTypeSoap[] toSoapModels(List<EventType> models) {
		List<EventTypeSoap> soapModels = new ArrayList<EventTypeSoap>(models.size());

		for (EventType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventTypeSoap[soapModels.size()]);
	}

	public EventTypeSoap() {
	}

	public long getPrimaryKey() {
		return _eventTypeId;
	}

	public void setPrimaryKey(long pk) {
		setEventTypeId(pk);
	}

	public long getEventTypeId() {
		return _eventTypeId;
	}

	public void setEventTypeId(long eventTypeId) {
		_eventTypeId = eventTypeId;
	}

	public String getEventTypeKey() {
		return _eventTypeKey;
	}

	public void setEventTypeKey(String eventTypeKey) {
		_eventTypeKey = eventTypeKey;
	}

	public String getEventTypeName() {
		return _eventTypeName;
	}

	public void setEventTypeName(String eventTypeName) {
		_eventTypeName = eventTypeName;
	}

	private long _eventTypeId;
	private String _eventTypeKey;
	private String _eventTypeName;
}