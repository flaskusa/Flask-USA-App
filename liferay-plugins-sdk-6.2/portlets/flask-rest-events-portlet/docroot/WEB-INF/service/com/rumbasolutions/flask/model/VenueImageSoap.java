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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.VenueImageServiceSoap}.
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.http.VenueImageServiceSoap
 * @generated
 */
public class VenueImageSoap implements Serializable {
	public static VenueImageSoap toSoapModel(VenueImage model) {
		VenueImageSoap soapModel = new VenueImageSoap();

		soapModel.setVenueImageId(model.getVenueImageId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setVenueImageUUId(model.getVenueImageUUId());
		soapModel.setVenueImageGroupId(model.getVenueImageGroupId());
		soapModel.setVenueId(model.getVenueId());

		return soapModel;
	}

	public static VenueImageSoap[] toSoapModels(VenueImage[] models) {
		VenueImageSoap[] soapModels = new VenueImageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VenueImageSoap[][] toSoapModels(VenueImage[][] models) {
		VenueImageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VenueImageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VenueImageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VenueImageSoap[] toSoapModels(List<VenueImage> models) {
		List<VenueImageSoap> soapModels = new ArrayList<VenueImageSoap>(models.size());

		for (VenueImage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VenueImageSoap[soapModels.size()]);
	}

	public VenueImageSoap() {
	}

	public long getPrimaryKey() {
		return _venueImageId;
	}

	public void setPrimaryKey(long pk) {
		setVenueImageId(pk);
	}

	public long getVenueImageId() {
		return _venueImageId;
	}

	public void setVenueImageId(long venueImageId) {
		_venueImageId = venueImageId;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getVenueImageUUId() {
		return _venueImageUUId;
	}

	public void setVenueImageUUId(String venueImageUUId) {
		_venueImageUUId = venueImageUUId;
	}

	public long getVenueImageGroupId() {
		return _venueImageGroupId;
	}

	public void setVenueImageGroupId(long venueImageGroupId) {
		_venueImageGroupId = venueImageGroupId;
	}

	public long getVenueId() {
		return _venueId;
	}

	public void setVenueId(long venueId) {
		_venueId = venueId;
	}

	private long _venueImageId;
	private long _companyId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _title;
	private String _venueImageUUId;
	private long _venueImageGroupId;
	private long _venueId;
}