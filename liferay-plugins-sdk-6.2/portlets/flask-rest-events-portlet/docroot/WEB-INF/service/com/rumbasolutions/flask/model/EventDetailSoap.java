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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.EventDetailServiceSoap}.
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.http.EventDetailServiceSoap
 * @generated
 */
public class EventDetailSoap implements Serializable {
	public static EventDetailSoap toSoapModel(EventDetail model) {
		EventDetailSoap soapModel = new EventDetailSoap();

		soapModel.setEventDetailId(model.getEventDetailId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEventId(model.getEventId());
		soapModel.setInfoTypeId(model.getInfoTypeId());
		soapModel.setInfoTypeCategoryId(model.getInfoTypeCategoryId());
		soapModel.setEventDetailInfoName(model.getEventDetailInfoName());
		soapModel.setEventDetailInfoDesc(model.getEventDetailInfoDesc());
		soapModel.setEventDetailInfoComment(model.getEventDetailInfoComment());
		soapModel.setEventDetailAddressLine1(model.getEventDetailAddressLine1());
		soapModel.setEventDetailAddressLine2(model.getEventDetailAddressLine2());
		soapModel.setEventDetailInfocity(model.getEventDetailInfocity());
		soapModel.setEventDetailZip(model.getEventDetailZip());
		soapModel.setEventDetailState(model.getEventDetailState());
		soapModel.setEventDetailCountry(model.getEventDetailCountry());
		soapModel.setEventDetailLatitude(model.getEventDetailLatitude());
		soapModel.setEventDetailLongitude(model.getEventDetailLongitude());
		soapModel.setEventDetailPhone(model.getEventDetailPhone());
		soapModel.setEventDetailWebsite(model.getEventDetailWebsite());
		soapModel.setEventDetailCost(model.getEventDetailCost());
		soapModel.setHoursOfOperation(model.getHoursOfOperation());

		return soapModel;
	}

	public static EventDetailSoap[] toSoapModels(EventDetail[] models) {
		EventDetailSoap[] soapModels = new EventDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventDetailSoap[][] toSoapModels(EventDetail[][] models) {
		EventDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventDetailSoap[] toSoapModels(List<EventDetail> models) {
		List<EventDetailSoap> soapModels = new ArrayList<EventDetailSoap>(models.size());

		for (EventDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventDetailSoap[soapModels.size()]);
	}

	public EventDetailSoap() {
	}

	public long getPrimaryKey() {
		return _eventDetailId;
	}

	public void setPrimaryKey(long pk) {
		setEventDetailId(pk);
	}

	public long getEventDetailId() {
		return _eventDetailId;
	}

	public void setEventDetailId(long eventDetailId) {
		_eventDetailId = eventDetailId;
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

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public long getInfoTypeId() {
		return _infoTypeId;
	}

	public void setInfoTypeId(long infoTypeId) {
		_infoTypeId = infoTypeId;
	}

	public long getInfoTypeCategoryId() {
		return _infoTypeCategoryId;
	}

	public void setInfoTypeCategoryId(long infoTypeCategoryId) {
		_infoTypeCategoryId = infoTypeCategoryId;
	}

	public String getEventDetailInfoName() {
		return _eventDetailInfoName;
	}

	public void setEventDetailInfoName(String eventDetailInfoName) {
		_eventDetailInfoName = eventDetailInfoName;
	}

	public String getEventDetailInfoDesc() {
		return _eventDetailInfoDesc;
	}

	public void setEventDetailInfoDesc(String eventDetailInfoDesc) {
		_eventDetailInfoDesc = eventDetailInfoDesc;
	}

	public String getEventDetailInfoComment() {
		return _eventDetailInfoComment;
	}

	public void setEventDetailInfoComment(String eventDetailInfoComment) {
		_eventDetailInfoComment = eventDetailInfoComment;
	}

	public String getEventDetailAddressLine1() {
		return _eventDetailAddressLine1;
	}

	public void setEventDetailAddressLine1(String eventDetailAddressLine1) {
		_eventDetailAddressLine1 = eventDetailAddressLine1;
	}

	public String getEventDetailAddressLine2() {
		return _eventDetailAddressLine2;
	}

	public void setEventDetailAddressLine2(String eventDetailAddressLine2) {
		_eventDetailAddressLine2 = eventDetailAddressLine2;
	}

	public String getEventDetailInfocity() {
		return _eventDetailInfocity;
	}

	public void setEventDetailInfocity(String eventDetailInfocity) {
		_eventDetailInfocity = eventDetailInfocity;
	}

	public String getEventDetailZip() {
		return _eventDetailZip;
	}

	public void setEventDetailZip(String eventDetailZip) {
		_eventDetailZip = eventDetailZip;
	}

	public String getEventDetailState() {
		return _eventDetailState;
	}

	public void setEventDetailState(String eventDetailState) {
		_eventDetailState = eventDetailState;
	}

	public String getEventDetailCountry() {
		return _eventDetailCountry;
	}

	public void setEventDetailCountry(String eventDetailCountry) {
		_eventDetailCountry = eventDetailCountry;
	}

	public String getEventDetailLatitude() {
		return _eventDetailLatitude;
	}

	public void setEventDetailLatitude(String eventDetailLatitude) {
		_eventDetailLatitude = eventDetailLatitude;
	}

	public String getEventDetailLongitude() {
		return _eventDetailLongitude;
	}

	public void setEventDetailLongitude(String eventDetailLongitude) {
		_eventDetailLongitude = eventDetailLongitude;
	}

	public String getEventDetailPhone() {
		return _eventDetailPhone;
	}

	public void setEventDetailPhone(String eventDetailPhone) {
		_eventDetailPhone = eventDetailPhone;
	}

	public String getEventDetailWebsite() {
		return _eventDetailWebsite;
	}

	public void setEventDetailWebsite(String eventDetailWebsite) {
		_eventDetailWebsite = eventDetailWebsite;
	}

	public double getEventDetailCost() {
		return _eventDetailCost;
	}

	public void setEventDetailCost(double eventDetailCost) {
		_eventDetailCost = eventDetailCost;
	}

	public String getHoursOfOperation() {
		return _hoursOfOperation;
	}

	public void setHoursOfOperation(String hoursOfOperation) {
		_hoursOfOperation = hoursOfOperation;
	}

	private long _eventDetailId;
	private long _companyId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _eventId;
	private long _infoTypeId;
	private long _infoTypeCategoryId;
	private String _eventDetailInfoName;
	private String _eventDetailInfoDesc;
	private String _eventDetailInfoComment;
	private String _eventDetailAddressLine1;
	private String _eventDetailAddressLine2;
	private String _eventDetailInfocity;
	private String _eventDetailZip;
	private String _eventDetailState;
	private String _eventDetailCountry;
	private String _eventDetailLatitude;
	private String _eventDetailLongitude;
	private String _eventDetailPhone;
	private String _eventDetailWebsite;
	private double _eventDetailCost;
	private String _hoursOfOperation;
}