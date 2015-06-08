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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.InfoTypeServiceSoap}.
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.http.InfoTypeServiceSoap
 * @generated
 */
public class InfoTypeSoap implements Serializable {
	public static InfoTypeSoap toSoapModel(InfoType model) {
		InfoTypeSoap soapModel = new InfoTypeSoap();

		soapModel.setInfoTypeId(model.getInfoTypeId());
		soapModel.setInfoTypeName(model.getInfoTypeName());

		return soapModel;
	}

	public static InfoTypeSoap[] toSoapModels(InfoType[] models) {
		InfoTypeSoap[] soapModels = new InfoTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InfoTypeSoap[][] toSoapModels(InfoType[][] models) {
		InfoTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InfoTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InfoTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InfoTypeSoap[] toSoapModels(List<InfoType> models) {
		List<InfoTypeSoap> soapModels = new ArrayList<InfoTypeSoap>(models.size());

		for (InfoType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InfoTypeSoap[soapModels.size()]);
	}

	public InfoTypeSoap() {
	}

	public long getPrimaryKey() {
		return _infoTypeId;
	}

	public void setPrimaryKey(long pk) {
		setInfoTypeId(pk);
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

	private long _infoTypeId;
	private String _infoTypeName;
}