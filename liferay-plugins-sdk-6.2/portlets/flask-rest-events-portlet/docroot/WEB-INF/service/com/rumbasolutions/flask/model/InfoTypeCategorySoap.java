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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.InfoTypeCategoryServiceSoap}.
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.http.InfoTypeCategoryServiceSoap
 * @generated
 */
public class InfoTypeCategorySoap implements Serializable {
	public static InfoTypeCategorySoap toSoapModel(InfoTypeCategory model) {
		InfoTypeCategorySoap soapModel = new InfoTypeCategorySoap();

		soapModel.setInfoTypeCategoryId(model.getInfoTypeCategoryId());
		soapModel.setInfoTypeCategoryName(model.getInfoTypeCategoryName());
		soapModel.setDisplayTemplate(model.getDisplayTemplate());
		soapModel.setInfoTypeId(model.getInfoTypeId());

		return soapModel;
	}

	public static InfoTypeCategorySoap[] toSoapModels(InfoTypeCategory[] models) {
		InfoTypeCategorySoap[] soapModels = new InfoTypeCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InfoTypeCategorySoap[][] toSoapModels(
		InfoTypeCategory[][] models) {
		InfoTypeCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InfoTypeCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new InfoTypeCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InfoTypeCategorySoap[] toSoapModels(
		List<InfoTypeCategory> models) {
		List<InfoTypeCategorySoap> soapModels = new ArrayList<InfoTypeCategorySoap>(models.size());

		for (InfoTypeCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InfoTypeCategorySoap[soapModels.size()]);
	}

	public InfoTypeCategorySoap() {
	}

	public long getPrimaryKey() {
		return _infoTypeCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setInfoTypeCategoryId(pk);
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

	public String getDisplayTemplate() {
		return _displayTemplate;
	}

	public void setDisplayTemplate(String displayTemplate) {
		_displayTemplate = displayTemplate;
	}

	public long getInfoTypeId() {
		return _infoTypeId;
	}

	public void setInfoTypeId(long infoTypeId) {
		_infoTypeId = infoTypeId;
	}

	private long _infoTypeCategoryId;
	private String _infoTypeCategoryName;
	private String _displayTemplate;
	private long _infoTypeId;
}