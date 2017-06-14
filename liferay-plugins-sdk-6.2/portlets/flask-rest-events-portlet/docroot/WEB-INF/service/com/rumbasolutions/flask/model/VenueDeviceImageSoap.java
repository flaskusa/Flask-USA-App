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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.VenueDeviceImageServiceSoap}.
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.http.VenueDeviceImageServiceSoap
 * @generated
 */
public class VenueDeviceImageSoap implements Serializable {
	public static VenueDeviceImageSoap toSoapModel(VenueDeviceImage model) {
		VenueDeviceImageSoap soapModel = new VenueDeviceImageSoap();

		soapModel.setVenueDeviceImageId(model.getVenueDeviceImageId());
		soapModel.setVenueDetailImageId(model.getVenueDetailImageId());
		soapModel.setVenueId(model.getVenueId());
		soapModel.setDeviceType(model.getDeviceType());
		soapModel.setVenueDeviceImageUUID(model.getVenueDeviceImageUUID());
		soapModel.setAspectRatio(model.getAspectRatio());

		return soapModel;
	}

	public static VenueDeviceImageSoap[] toSoapModels(VenueDeviceImage[] models) {
		VenueDeviceImageSoap[] soapModels = new VenueDeviceImageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VenueDeviceImageSoap[][] toSoapModels(
		VenueDeviceImage[][] models) {
		VenueDeviceImageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VenueDeviceImageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VenueDeviceImageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VenueDeviceImageSoap[] toSoapModels(
		List<VenueDeviceImage> models) {
		List<VenueDeviceImageSoap> soapModels = new ArrayList<VenueDeviceImageSoap>(models.size());

		for (VenueDeviceImage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VenueDeviceImageSoap[soapModels.size()]);
	}

	public VenueDeviceImageSoap() {
	}

	public long getPrimaryKey() {
		return _venueDeviceImageId;
	}

	public void setPrimaryKey(long pk) {
		setVenueDeviceImageId(pk);
	}

	public long getVenueDeviceImageId() {
		return _venueDeviceImageId;
	}

	public void setVenueDeviceImageId(long venueDeviceImageId) {
		_venueDeviceImageId = venueDeviceImageId;
	}

	public long getVenueDetailImageId() {
		return _venueDetailImageId;
	}

	public void setVenueDetailImageId(long venueDetailImageId) {
		_venueDetailImageId = venueDetailImageId;
	}

	public long getVenueId() {
		return _venueId;
	}

	public void setVenueId(long venueId) {
		_venueId = venueId;
	}

	public String getDeviceType() {
		return _deviceType;
	}

	public void setDeviceType(String deviceType) {
		_deviceType = deviceType;
	}

	public String getVenueDeviceImageUUID() {
		return _venueDeviceImageUUID;
	}

	public void setVenueDeviceImageUUID(String venueDeviceImageUUID) {
		_venueDeviceImageUUID = venueDeviceImageUUID;
	}

	public String getAspectRatio() {
		return _aspectRatio;
	}

	public void setAspectRatio(String aspectRatio) {
		_aspectRatio = aspectRatio;
	}

	private long _venueDeviceImageId;
	private long _venueDetailImageId;
	private long _venueId;
	private String _deviceType;
	private String _venueDeviceImageUUID;
	private String _aspectRatio;
}