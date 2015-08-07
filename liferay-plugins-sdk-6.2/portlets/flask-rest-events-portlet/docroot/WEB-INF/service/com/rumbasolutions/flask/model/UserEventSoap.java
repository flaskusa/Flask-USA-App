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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.UserEventServiceSoap}.
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.http.UserEventServiceSoap
 * @generated
 */
public class UserEventSoap implements Serializable {
	public static UserEventSoap toSoapModel(UserEvent model) {
		UserEventSoap soapModel = new UserEventSoap();

		soapModel.setUserEventId(model.getUserEventId());
		soapModel.setUserId(model.getUserId());
		soapModel.setEventId(model.getEventId());
		soapModel.setCreatedDate(model.getCreatedDate());

		return soapModel;
	}

	public static UserEventSoap[] toSoapModels(UserEvent[] models) {
		UserEventSoap[] soapModels = new UserEventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserEventSoap[][] toSoapModels(UserEvent[][] models) {
		UserEventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserEventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserEventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserEventSoap[] toSoapModels(List<UserEvent> models) {
		List<UserEventSoap> soapModels = new ArrayList<UserEventSoap>(models.size());

		for (UserEvent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserEventSoap[soapModels.size()]);
	}

	public UserEventSoap() {
	}

	public long getPrimaryKey() {
		return _userEventId;
	}

	public void setPrimaryKey(long pk) {
		setUserEventId(pk);
	}

	public long getUserEventId() {
		return _userEventId;
	}

	public void setUserEventId(long userEventId) {
		_userEventId = userEventId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	private long _userEventId;
	private long _userId;
	private long _eventId;
	private Date _createdDate;
}