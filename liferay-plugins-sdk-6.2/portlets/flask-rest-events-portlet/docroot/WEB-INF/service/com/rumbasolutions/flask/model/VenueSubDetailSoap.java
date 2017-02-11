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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.VenueSubDetailServiceSoap}.
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.http.VenueSubDetailServiceSoap
 * @generated
 */
public class VenueSubDetailSoap implements Serializable {
	public static VenueSubDetailSoap toSoapModel(VenueSubDetail model) {
		VenueSubDetailSoap soapModel = new VenueSubDetailSoap();

		soapModel.setVenueSubDetailId(model.getVenueSubDetailId());
		soapModel.setVenueDetailId(model.getVenueDetailId());
		soapModel.setVenueSubDetailTitle(model.getVenueSubDetailTitle());
		soapModel.setVenueSubDetailDesc(model.getVenueSubDetailDesc());

		return soapModel;
	}

	public static VenueSubDetailSoap[] toSoapModels(VenueSubDetail[] models) {
		VenueSubDetailSoap[] soapModels = new VenueSubDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VenueSubDetailSoap[][] toSoapModels(VenueSubDetail[][] models) {
		VenueSubDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VenueSubDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VenueSubDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VenueSubDetailSoap[] toSoapModels(List<VenueSubDetail> models) {
		List<VenueSubDetailSoap> soapModels = new ArrayList<VenueSubDetailSoap>(models.size());

		for (VenueSubDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VenueSubDetailSoap[soapModels.size()]);
	}

	public VenueSubDetailSoap() {
	}

	public long getPrimaryKey() {
		return _venueSubDetailId;
	}

	public void setPrimaryKey(long pk) {
		setVenueSubDetailId(pk);
	}

	public long getVenueSubDetailId() {
		return _venueSubDetailId;
	}

	public void setVenueSubDetailId(long venueSubDetailId) {
		_venueSubDetailId = venueSubDetailId;
	}

	public long getVenueDetailId() {
		return _venueDetailId;
	}

	public void setVenueDetailId(long venueDetailId) {
		_venueDetailId = venueDetailId;
	}

	public String getVenueSubDetailTitle() {
		return _venueSubDetailTitle;
	}

	public void setVenueSubDetailTitle(String venueSubDetailTitle) {
		_venueSubDetailTitle = venueSubDetailTitle;
	}

	public String getVenueSubDetailDesc() {
		return _venueSubDetailDesc;
	}

	public void setVenueSubDetailDesc(String venueSubDetailDesc) {
		_venueSubDetailDesc = venueSubDetailDesc;
	}

	private long _venueSubDetailId;
	private long _venueDetailId;
	private String _venueSubDetailTitle;
	private String _venueSubDetailDesc;
}