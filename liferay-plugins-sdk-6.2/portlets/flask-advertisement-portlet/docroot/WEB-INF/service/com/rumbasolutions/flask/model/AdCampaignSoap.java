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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.AdCampaignServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.http.AdCampaignServiceSoap
 * @generated
 */
public class AdCampaignSoap implements Serializable {
	public static AdCampaignSoap toSoapModel(AdCampaign model) {
		AdCampaignSoap soapModel = new AdCampaignSoap();

		soapModel.setCampaignId(model.getCampaignId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCampaignName(model.getCampaignName());
		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setDisplayGeneral(model.getDisplayGeneral());
		soapModel.setDisplayPreEvent(model.getDisplayPreEvent());
		soapModel.setDisplayDuringEvent(model.getDisplayDuringEvent());
		soapModel.setDisplayPostEvent(model.getDisplayPostEvent());
		soapModel.setFrequencyPerHour(model.getFrequencyPerHour());

		return soapModel;
	}

	public static AdCampaignSoap[] toSoapModels(AdCampaign[] models) {
		AdCampaignSoap[] soapModels = new AdCampaignSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdCampaignSoap[][] toSoapModels(AdCampaign[][] models) {
		AdCampaignSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdCampaignSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdCampaignSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdCampaignSoap[] toSoapModels(List<AdCampaign> models) {
		List<AdCampaignSoap> soapModels = new ArrayList<AdCampaignSoap>(models.size());

		for (AdCampaign model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdCampaignSoap[soapModels.size()]);
	}

	public AdCampaignSoap() {
	}

	public long getPrimaryKey() {
		return _campaignId;
	}

	public void setPrimaryKey(long pk) {
		setCampaignId(pk);
	}

	public long getCampaignId() {
		return _campaignId;
	}

	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;
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

	public String getCampaignName() {
		return _campaignName;
	}

	public void setCampaignName(String campaignName) {
		_campaignName = campaignName;
	}

	public long getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(long customerId) {
		_customerId = customerId;
	}

	public boolean getDisplayGeneral() {
		return _displayGeneral;
	}

	public boolean isDisplayGeneral() {
		return _displayGeneral;
	}

	public void setDisplayGeneral(boolean displayGeneral) {
		_displayGeneral = displayGeneral;
	}

	public boolean getDisplayPreEvent() {
		return _displayPreEvent;
	}

	public boolean isDisplayPreEvent() {
		return _displayPreEvent;
	}

	public void setDisplayPreEvent(boolean displayPreEvent) {
		_displayPreEvent = displayPreEvent;
	}

	public boolean getDisplayDuringEvent() {
		return _displayDuringEvent;
	}

	public boolean isDisplayDuringEvent() {
		return _displayDuringEvent;
	}

	public void setDisplayDuringEvent(boolean displayDuringEvent) {
		_displayDuringEvent = displayDuringEvent;
	}

	public boolean getDisplayPostEvent() {
		return _displayPostEvent;
	}

	public boolean isDisplayPostEvent() {
		return _displayPostEvent;
	}

	public void setDisplayPostEvent(boolean displayPostEvent) {
		_displayPostEvent = displayPostEvent;
	}

	public long getFrequencyPerHour() {
		return _frequencyPerHour;
	}

	public void setFrequencyPerHour(long frequencyPerHour) {
		_frequencyPerHour = frequencyPerHour;
	}

	private long _campaignId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _campaignName;
	private long _customerId;
	private boolean _displayGeneral;
	private boolean _displayPreEvent;
	private boolean _displayDuringEvent;
	private boolean _displayPostEvent;
	private long _frequencyPerHour;
}