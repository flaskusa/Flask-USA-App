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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.SupplyListServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.http.SupplyListServiceSoap
 * @generated
 */
public class SupplyListSoap implements Serializable {
	public static SupplyListSoap toSoapModel(SupplyList model) {
		SupplyListSoap soapModel = new SupplyListSoap();

		soapModel.setSupplyListId(model.getSupplyListId());
		soapModel.setSupplyListName(model.getSupplyListName());
		soapModel.setIsSystem(model.getIsSystem());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SupplyListSoap[] toSoapModels(SupplyList[] models) {
		SupplyListSoap[] soapModels = new SupplyListSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SupplyListSoap[][] toSoapModels(SupplyList[][] models) {
		SupplyListSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SupplyListSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SupplyListSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SupplyListSoap[] toSoapModels(List<SupplyList> models) {
		List<SupplyListSoap> soapModels = new ArrayList<SupplyListSoap>(models.size());

		for (SupplyList model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SupplyListSoap[soapModels.size()]);
	}

	public SupplyListSoap() {
	}

	public long getPrimaryKey() {
		return _supplyListId;
	}

	public void setPrimaryKey(long pk) {
		setSupplyListId(pk);
	}

	public long getSupplyListId() {
		return _supplyListId;
	}

	public void setSupplyListId(long supplyListId) {
		_supplyListId = supplyListId;
	}

	public String getSupplyListName() {
		return _supplyListName;
	}

	public void setSupplyListName(String supplyListName) {
		_supplyListName = supplyListName;
	}

	public boolean getIsSystem() {
		return _isSystem;
	}

	public boolean isIsSystem() {
		return _isSystem;
	}

	public void setIsSystem(boolean isSystem) {
		_isSystem = isSystem;
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

	private long _supplyListId;
	private String _supplyListName;
	private boolean _isSystem;
	private long _companyId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
}