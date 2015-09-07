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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.VenueDetailServiceSoap}.
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.http.VenueDetailServiceSoap
 * @generated
 */
public class VenueDetailSoap implements Serializable {
	public static VenueDetailSoap toSoapModel(VenueDetail model) {
		VenueDetailSoap soapModel = new VenueDetailSoap();

		soapModel.setVenueDetailId(model.getVenueDetailId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setVenueId(model.getVenueId());
		soapModel.setInfoTypeId(model.getInfoTypeId());
		soapModel.setInfoTypeName(model.getInfoTypeName());
		soapModel.setInfoTypeCategoryId(model.getInfoTypeCategoryId());
		soapModel.setInfoTypeCategoryName(model.getInfoTypeCategoryName());
		soapModel.setInfoTitle(model.getInfoTitle());
		soapModel.setInfoDesc(model.getInfoDesc());
		soapModel.setAddrLine1(model.getAddrLine1());
		soapModel.setAddrLine2(model.getAddrLine2());
		soapModel.setCity(model.getCity());
		soapModel.setZipCode(model.getZipCode());
		soapModel.setStateId(model.getStateId());
		soapModel.setStateName(model.getStateName());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setCountryName(model.getCountryName());
		soapModel.setLatitude(model.getLatitude());
		soapModel.setLongitude(model.getLongitude());
		soapModel.setPhone(model.getPhone());
		soapModel.setWebsite(model.getWebsite());
		soapModel.setCost(model.getCost());
		soapModel.setHoursOfOperation(model.getHoursOfOperation());
		soapModel.setShowDescription(model.getShowDescription());

		return soapModel;
	}

	public static VenueDetailSoap[] toSoapModels(VenueDetail[] models) {
		VenueDetailSoap[] soapModels = new VenueDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VenueDetailSoap[][] toSoapModels(VenueDetail[][] models) {
		VenueDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VenueDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VenueDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VenueDetailSoap[] toSoapModels(List<VenueDetail> models) {
		List<VenueDetailSoap> soapModels = new ArrayList<VenueDetailSoap>(models.size());

		for (VenueDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VenueDetailSoap[soapModels.size()]);
	}

	public VenueDetailSoap() {
	}

	public long getPrimaryKey() {
		return _venueDetailId;
	}

	public void setPrimaryKey(long pk) {
		setVenueDetailId(pk);
	}

	public long getVenueDetailId() {
		return _venueDetailId;
	}

	public void setVenueDetailId(long venueDetailId) {
		_venueDetailId = venueDetailId;
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

	public long getVenueId() {
		return _venueId;
	}

	public void setVenueId(long venueId) {
		_venueId = venueId;
	}

	public long getInfoTypeId() {
		return _infoTypeId;
	}

	public void setInfoTypeId(long infoTypeId) {
		_infoTypeId = infoTypeId;
	}

	public String getInfoTypeName() {
		return _infoTypeName;
	}

	public void setInfoTypeName(String infoTypeName) {
		_infoTypeName = infoTypeName;
	}

	public long getInfoTypeCategoryId() {
		return _infoTypeCategoryId;
	}

	public void setInfoTypeCategoryId(long infoTypeCategoryId) {
		_infoTypeCategoryId = infoTypeCategoryId;
	}

	public String getInfoTypeCategoryName() {
		return _infoTypeCategoryName;
	}

	public void setInfoTypeCategoryName(String infoTypeCategoryName) {
		_infoTypeCategoryName = infoTypeCategoryName;
	}

	public String getInfoTitle() {
		return _infoTitle;
	}

	public void setInfoTitle(String infoTitle) {
		_infoTitle = infoTitle;
	}

	public String getInfoDesc() {
		return _infoDesc;
	}

	public void setInfoDesc(String infoDesc) {
		_infoDesc = infoDesc;
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

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getZipCode() {
		return _zipCode;
	}

	public void setZipCode(String zipCode) {
		_zipCode = zipCode;
	}

	public long getStateId() {
		return _stateId;
	}

	public void setStateId(long stateId) {
		_stateId = stateId;
	}

	public String getStateName() {
		return _stateName;
	}

	public void setStateName(String stateName) {
		_stateName = stateName;
	}

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public String getCountryName() {
		return _countryName;
	}

	public void setCountryName(String countryName) {
		_countryName = countryName;
	}

	public String getLatitude() {
		return _latitude;
	}

	public void setLatitude(String latitude) {
		_latitude = latitude;
	}

	public String getLongitude() {
		return _longitude;
	}

	public void setLongitude(String longitude) {
		_longitude = longitude;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public double getCost() {
		return _cost;
	}

	public void setCost(double cost) {
		_cost = cost;
	}

	public String getHoursOfOperation() {
		return _hoursOfOperation;
	}

	public void setHoursOfOperation(String hoursOfOperation) {
		_hoursOfOperation = hoursOfOperation;
	}

	public boolean getShowDescription() {
		return _showDescription;
	}

	public boolean isShowDescription() {
		return _showDescription;
	}

	public void setShowDescription(boolean showDescription) {
		_showDescription = showDescription;
	}

	private long _venueDetailId;
	private long _companyId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _venueId;
	private long _infoTypeId;
	private String _infoTypeName;
	private long _infoTypeCategoryId;
	private String _infoTypeCategoryName;
	private String _infoTitle;
	private String _infoDesc;
	private String _addrLine1;
	private String _addrLine2;
	private String _city;
	private String _zipCode;
	private long _stateId;
	private String _stateName;
	private long _countryId;
	private String _countryName;
	private String _latitude;
	private String _longitude;
	private String _phone;
	private String _website;
	private double _cost;
	private String _hoursOfOperation;
	private boolean _showDescription;
}