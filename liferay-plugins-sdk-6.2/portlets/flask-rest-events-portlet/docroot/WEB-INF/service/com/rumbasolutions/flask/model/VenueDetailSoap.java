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
		soapModel.setInfoTypeCategoryId(model.getInfoTypeCategoryId());
		soapModel.setVenueDetailInfoName(model.getVenueDetailInfoName());
		soapModel.setVenueDetailInfoDesc(model.getVenueDetailInfoDesc());
		soapModel.setVenueDetailInfoComment(model.getVenueDetailInfoComment());
		soapModel.setVenueDetailAddressLine1(model.getVenueDetailAddressLine1());
		soapModel.setVenueDetailAddressLine2(model.getVenueDetailAddressLine2());
		soapModel.setVenueDetailCity(model.getVenueDetailCity());
		soapModel.setVenueDetailState(model.getVenueDetailState());
		soapModel.setVenueDetailCountry(model.getVenueDetailCountry());
		soapModel.setVenueDetailLatitude(model.getVenueDetailLatitude());
		soapModel.setVenueDetailLongitude(model.getVenueDetailLongitude());
		soapModel.setVenueDetailPhone(model.getVenueDetailPhone());
		soapModel.setVenueDetailWebsite(model.getVenueDetailWebsite());
		soapModel.setVenueDetailCost(model.getVenueDetailCost());
		soapModel.setVenueDetailhoursOfOperation(model.getVenueDetailhoursOfOperation());

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

	public long getInfoTypeCategoryId() {
		return _infoTypeCategoryId;
	}

	public void setInfoTypeCategoryId(long infoTypeCategoryId) {
		_infoTypeCategoryId = infoTypeCategoryId;
	}

	public String getVenueDetailInfoName() {
		return _venueDetailInfoName;
	}

	public void setVenueDetailInfoName(String venueDetailInfoName) {
		_venueDetailInfoName = venueDetailInfoName;
	}

	public String getVenueDetailInfoDesc() {
		return _venueDetailInfoDesc;
	}

	public void setVenueDetailInfoDesc(String venueDetailInfoDesc) {
		_venueDetailInfoDesc = venueDetailInfoDesc;
	}

	public String getVenueDetailInfoComment() {
		return _venueDetailInfoComment;
	}

	public void setVenueDetailInfoComment(String venueDetailInfoComment) {
		_venueDetailInfoComment = venueDetailInfoComment;
	}

	public String getVenueDetailAddressLine1() {
		return _venueDetailAddressLine1;
	}

	public void setVenueDetailAddressLine1(String venueDetailAddressLine1) {
		_venueDetailAddressLine1 = venueDetailAddressLine1;
	}

	public String getVenueDetailAddressLine2() {
		return _venueDetailAddressLine2;
	}

	public void setVenueDetailAddressLine2(String venueDetailAddressLine2) {
		_venueDetailAddressLine2 = venueDetailAddressLine2;
	}

	public String getVenueDetailCity() {
		return _venueDetailCity;
	}

	public void setVenueDetailCity(String venueDetailCity) {
		_venueDetailCity = venueDetailCity;
	}

	public String getVenueDetailState() {
		return _venueDetailState;
	}

	public void setVenueDetailState(String venueDetailState) {
		_venueDetailState = venueDetailState;
	}

	public String getVenueDetailCountry() {
		return _venueDetailCountry;
	}

	public void setVenueDetailCountry(String venueDetailCountry) {
		_venueDetailCountry = venueDetailCountry;
	}

	public String getVenueDetailLatitude() {
		return _venueDetailLatitude;
	}

	public void setVenueDetailLatitude(String venueDetailLatitude) {
		_venueDetailLatitude = venueDetailLatitude;
	}

	public String getVenueDetailLongitude() {
		return _venueDetailLongitude;
	}

	public void setVenueDetailLongitude(String venueDetailLongitude) {
		_venueDetailLongitude = venueDetailLongitude;
	}

	public String getVenueDetailPhone() {
		return _venueDetailPhone;
	}

	public void setVenueDetailPhone(String venueDetailPhone) {
		_venueDetailPhone = venueDetailPhone;
	}

	public String getVenueDetailWebsite() {
		return _venueDetailWebsite;
	}

	public void setVenueDetailWebsite(String venueDetailWebsite) {
		_venueDetailWebsite = venueDetailWebsite;
	}

	public double getVenueDetailCost() {
		return _venueDetailCost;
	}

	public void setVenueDetailCost(double venueDetailCost) {
		_venueDetailCost = venueDetailCost;
	}

	public String getVenueDetailhoursOfOperation() {
		return _venueDetailhoursOfOperation;
	}

	public void setVenueDetailhoursOfOperation(
		String venueDetailhoursOfOperation) {
		_venueDetailhoursOfOperation = venueDetailhoursOfOperation;
	}

	private long _venueDetailId;
	private long _companyId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _venueId;
	private long _infoTypeId;
	private long _infoTypeCategoryId;
	private String _venueDetailInfoName;
	private String _venueDetailInfoDesc;
	private String _venueDetailInfoComment;
	private String _venueDetailAddressLine1;
	private String _venueDetailAddressLine2;
	private String _venueDetailCity;
	private String _venueDetailState;
	private String _venueDetailCountry;
	private String _venueDetailLatitude;
	private String _venueDetailLongitude;
	private String _venueDetailPhone;
	private String _venueDetailWebsite;
	private double _venueDetailCost;
	private String _venueDetailhoursOfOperation;
}