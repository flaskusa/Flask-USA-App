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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.CampaignEventServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.http.CampaignEventServiceSoap
 * @generated
 */
public class CampaignEventSoap implements Serializable {
	public static CampaignEventSoap toSoapModel(CampaignEvent model) {
		CampaignEventSoap soapModel = new CampaignEventSoap();

		soapModel.setCampaignEventId(model.getCampaignEventId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCampaignId(model.getCampaignId());
		soapModel.setEventId(model.getEventId());

		return soapModel;
	}

	public static CampaignEventSoap[] toSoapModels(CampaignEvent[] models) {
		CampaignEventSoap[] soapModels = new CampaignEventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CampaignEventSoap[][] toSoapModels(CampaignEvent[][] models) {
		CampaignEventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CampaignEventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CampaignEventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CampaignEventSoap[] toSoapModels(List<CampaignEvent> models) {
		List<CampaignEventSoap> soapModels = new ArrayList<CampaignEventSoap>(models.size());

		for (CampaignEvent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CampaignEventSoap[soapModels.size()]);
	}

	public CampaignEventSoap() {
	}

	public long getPrimaryKey() {
		return _campaignEventId;
	}

	public void setPrimaryKey(long pk) {
		setCampaignEventId(pk);
	}

	public long getCampaignEventId() {
		return _campaignEventId;
	}

	public void setCampaignEventId(long campaignEventId) {
		_campaignEventId = campaignEventId;
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

	public long getCampaignId() {
		return _campaignId;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	private long _campaignEventId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _campaignId;
	private long _eventId;
}