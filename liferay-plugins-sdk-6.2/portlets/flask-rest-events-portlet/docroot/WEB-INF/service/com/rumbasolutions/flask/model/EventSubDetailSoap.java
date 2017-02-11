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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.EventSubDetailServiceSoap}.
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.http.EventSubDetailServiceSoap
 * @generated
 */
public class EventSubDetailSoap implements Serializable {
	public static EventSubDetailSoap toSoapModel(EventSubDetail model) {
		EventSubDetailSoap soapModel = new EventSubDetailSoap();

		soapModel.setEventSubDetailId(model.getEventSubDetailId());
		soapModel.setEventDetailId(model.getEventDetailId());
		soapModel.setEventSubDetailTitle(model.getEventSubDetailTitle());
		soapModel.setEventSubDetailDesc(model.getEventSubDetailDesc());

		return soapModel;
	}

	public static EventSubDetailSoap[] toSoapModels(EventSubDetail[] models) {
		EventSubDetailSoap[] soapModels = new EventSubDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventSubDetailSoap[][] toSoapModels(EventSubDetail[][] models) {
		EventSubDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventSubDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventSubDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventSubDetailSoap[] toSoapModels(List<EventSubDetail> models) {
		List<EventSubDetailSoap> soapModels = new ArrayList<EventSubDetailSoap>(models.size());

		for (EventSubDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventSubDetailSoap[soapModels.size()]);
	}

	public EventSubDetailSoap() {
	}

	public long getPrimaryKey() {
		return _eventSubDetailId;
	}

	public void setPrimaryKey(long pk) {
		setEventSubDetailId(pk);
	}

	public long getEventSubDetailId() {
		return _eventSubDetailId;
	}

	public void setEventSubDetailId(long eventSubDetailId) {
		_eventSubDetailId = eventSubDetailId;
	}

	public long getEventDetailId() {
		return _eventDetailId;
	}

	public void setEventDetailId(long eventDetailId) {
		_eventDetailId = eventDetailId;
	}

	public String getEventSubDetailTitle() {
		return _eventSubDetailTitle;
	}

	public void setEventSubDetailTitle(String eventSubDetailTitle) {
		_eventSubDetailTitle = eventSubDetailTitle;
	}

	public String getEventSubDetailDesc() {
		return _eventSubDetailDesc;
	}

	public void setEventSubDetailDesc(String eventSubDetailDesc) {
		_eventSubDetailDesc = eventSubDetailDesc;
	}

	private long _eventSubDetailId;
	private long _eventDetailId;
	private String _eventSubDetailTitle;
	private String _eventSubDetailDesc;
}