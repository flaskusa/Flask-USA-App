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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.TailgateMarkerServiceSoap}.
 *
 * @author rajeshj
 * @see com.rumbasolutions.flask.service.http.TailgateMarkerServiceSoap
 * @generated
 */
public class TailgateMarkerSoap implements Serializable {
	public static TailgateMarkerSoap toSoapModel(TailgateMarker model) {
		TailgateMarkerSoap soapModel = new TailgateMarkerSoap();

		soapModel.setTailgatemarkerid(model.getTailgatemarkerid());
		soapModel.setTailgateid(model.getTailgateid());
		soapModel.setLatitude(model.getLatitude());
		soapModel.setLongitude(model.getLongitude());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static TailgateMarkerSoap[] toSoapModels(TailgateMarker[] models) {
		TailgateMarkerSoap[] soapModels = new TailgateMarkerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TailgateMarkerSoap[][] toSoapModels(TailgateMarker[][] models) {
		TailgateMarkerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TailgateMarkerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TailgateMarkerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TailgateMarkerSoap[] toSoapModels(List<TailgateMarker> models) {
		List<TailgateMarkerSoap> soapModels = new ArrayList<TailgateMarkerSoap>(models.size());

		for (TailgateMarker model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TailgateMarkerSoap[soapModels.size()]);
	}

	public TailgateMarkerSoap() {
	}

	public long getPrimaryKey() {
		return _tailgatemarkerid;
	}

	public void setPrimaryKey(long pk) {
		setTailgatemarkerid(pk);
	}

	public long getTailgatemarkerid() {
		return _tailgatemarkerid;
	}

	public void setTailgatemarkerid(long tailgatemarkerid) {
		_tailgatemarkerid = tailgatemarkerid;
	}

	public long getTailgateid() {
		return _tailgateid;
	}

	public void setTailgateid(long tailgateid) {
		_tailgateid = tailgateid;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _tailgatemarkerid;
	private long _tailgateid;
	private String _latitude;
	private String _longitude;
	private String _name;
	private String _description;
}