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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.UserTailgateServiceSoap}.
 *
 * @author rajeshj
 * @see com.rumbasolutions.flask.service.http.UserTailgateServiceSoap
 * @generated
 */
public class UserTailgateSoap implements Serializable {
	public static UserTailgateSoap toSoapModel(UserTailgate model) {
		UserTailgateSoap soapModel = new UserTailgateSoap();

		soapModel.setTailgateId(model.getTailgateId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTailgateName(model.getTailgateName());
		soapModel.setTailgateDescription(model.getTailgateDescription());
		soapModel.setEventId(model.getEventId());
		soapModel.setEventName(model.getEventName());
		soapModel.setTailgateDate(model.getTailgateDate());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());

		return soapModel;
	}

	public static UserTailgateSoap[] toSoapModels(UserTailgate[] models) {
		UserTailgateSoap[] soapModels = new UserTailgateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserTailgateSoap[][] toSoapModels(UserTailgate[][] models) {
		UserTailgateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserTailgateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserTailgateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserTailgateSoap[] toSoapModels(List<UserTailgate> models) {
		List<UserTailgateSoap> soapModels = new ArrayList<UserTailgateSoap>(models.size());

		for (UserTailgate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserTailgateSoap[soapModels.size()]);
	}

	public UserTailgateSoap() {
	}

	public long getPrimaryKey() {
		return _tailgateId;
	}

	public void setPrimaryKey(long pk) {
		setTailgateId(pk);
	}

	public long getTailgateId() {
		return _tailgateId;
	}

	public void setTailgateId(long tailgateId) {
		_tailgateId = tailgateId;
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

	public String getTailgateName() {
		return _tailgateName;
	}

	public void setTailgateName(String tailgateName) {
		_tailgateName = tailgateName;
	}

	public String getTailgateDescription() {
		return _tailgateDescription;
	}

	public void setTailgateDescription(String tailgateDescription) {
		_tailgateDescription = tailgateDescription;
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public String getEventName() {
		return _eventName;
	}

	public void setEventName(String eventName) {
		_eventName = eventName;
	}

	public Date getTailgateDate() {
		return _tailgateDate;
	}

	public void setTailgateDate(Date tailgateDate) {
		_tailgateDate = tailgateDate;
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

	private long _tailgateId;
	private long _companyId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _tailgateName;
	private String _tailgateDescription;
	private long _eventId;
	private String _eventName;
	private Date _tailgateDate;
	private Date _startTime;
	private Date _endTime;
}