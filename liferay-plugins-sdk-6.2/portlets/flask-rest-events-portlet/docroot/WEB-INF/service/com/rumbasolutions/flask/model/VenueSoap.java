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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.VenueServiceSoap}.
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.http.VenueServiceSoap
 * @generated
 */
public class VenueSoap implements Serializable {
	public static VenueSoap toSoapModel(Venue model) {
		VenueSoap soapModel = new VenueSoap();

		soapModel.setVenueId(model.getVenueId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setVenueName(model.getVenueName());
		soapModel.setVenueDescription(model.getVenueDescription());
		soapModel.setVenueZipCode(model.getVenueZipCode());
		soapModel.setAddrLine1(model.getAddrLine1());
		soapModel.setAddrLine2(model.getAddrLine2());
		soapModel.setVenueCity(model.getVenueCity());
		soapModel.setVenueStateId(model.getVenueStateId());
		soapModel.setVenueStateName(model.getVenueStateName());
		soapModel.setVenueCountryId(model.getVenueCountryId());
		soapModel.setVenueCountryName(model.getVenueCountryName());
		soapModel.setVenueMetroArea(model.getVenueMetroArea());

		return soapModel;
	}

	public static VenueSoap[] toSoapModels(Venue[] models) {
		VenueSoap[] soapModels = new VenueSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VenueSoap[][] toSoapModels(Venue[][] models) {
		VenueSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VenueSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VenueSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VenueSoap[] toSoapModels(List<Venue> models) {
		List<VenueSoap> soapModels = new ArrayList<VenueSoap>(models.size());

		for (Venue model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VenueSoap[soapModels.size()]);
	}

	public VenueSoap() {
	}

	public long getPrimaryKey() {
		return _venueId;
	}

	public void setPrimaryKey(long pk) {
		setVenueId(pk);
	}

	public long getVenueId() {
		return _venueId;
	}

	public void setVenueId(long venueId) {
		_venueId = venueId;
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

	public String getVenueName() {
		return _venueName;
	}

	public void setVenueName(String venueName) {
		_venueName = venueName;
	}

	public String getVenueDescription() {
		return _venueDescription;
	}

	public void setVenueDescription(String venueDescription) {
		_venueDescription = venueDescription;
	}

	public String getVenueZipCode() {
		return _venueZipCode;
	}

	public void setVenueZipCode(String venueZipCode) {
		_venueZipCode = venueZipCode;
	}

	public String getAddrLine1() {
		return _addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		_addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return _addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		_addrLine2 = addrLine2;
	}

	public String getVenueCity() {
		return _venueCity;
	}

	public void setVenueCity(String venueCity) {
		_venueCity = venueCity;
	}

	public long getVenueStateId() {
		return _venueStateId;
	}

	public void setVenueStateId(long venueStateId) {
		_venueStateId = venueStateId;
	}

	public String getVenueStateName() {
		return _venueStateName;
	}

	public void setVenueStateName(String venueStateName) {
		_venueStateName = venueStateName;
	}

	public long getVenueCountryId() {
		return _venueCountryId;
	}

	public void setVenueCountryId(long venueCountryId) {
		_venueCountryId = venueCountryId;
	}

	public String getVenueCountryName() {
		return _venueCountryName;
	}

	public void setVenueCountryName(String venueCountryName) {
		_venueCountryName = venueCountryName;
	}

	public String getVenueMetroArea() {
		return _venueMetroArea;
	}

	public void setVenueMetroArea(String venueMetroArea) {
		_venueMetroArea = venueMetroArea;
	}

	private long _venueId;
	private long _companyId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _venueName;
	private String _venueDescription;
	private String _venueZipCode;
	private String _addrLine1;
	private String _addrLine2;
	private String _venueCity;
	private long _venueStateId;
	private String _venueStateName;
	private long _venueCountryId;
	private String _venueCountryName;
	private String _venueMetroArea;
}