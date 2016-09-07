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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.SupplyItemServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.http.SupplyItemServiceSoap
 * @generated
 */
public class SupplyItemSoap implements Serializable {
	public static SupplyItemSoap toSoapModel(SupplyItem model) {
		SupplyItemSoap soapModel = new SupplyItemSoap();

		soapModel.setSupplyItemId(model.getSupplyItemId());
		soapModel.setSupplyItemName(model.getSupplyItemName());
		soapModel.setSupplyListId(model.getSupplyListId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SupplyItemSoap[] toSoapModels(SupplyItem[] models) {
		SupplyItemSoap[] soapModels = new SupplyItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SupplyItemSoap[][] toSoapModels(SupplyItem[][] models) {
		SupplyItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SupplyItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SupplyItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SupplyItemSoap[] toSoapModels(List<SupplyItem> models) {
		List<SupplyItemSoap> soapModels = new ArrayList<SupplyItemSoap>(models.size());

		for (SupplyItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SupplyItemSoap[soapModels.size()]);
	}

	public SupplyItemSoap() {
	}

	public long getPrimaryKey() {
		return _supplyItemId;
	}

	public void setPrimaryKey(long pk) {
		setSupplyItemId(pk);
	}

	public long getSupplyItemId() {
		return _supplyItemId;
	}

	public void setSupplyItemId(long supplyItemId) {
		_supplyItemId = supplyItemId;
	}

	public String getSupplyItemName() {
		return _supplyItemName;
	}

	public void setSupplyItemName(String supplyItemName) {
		_supplyItemName = supplyItemName;
	}

	public long getSupplyListId() {
		return _supplyListId;
	}

	public void setSupplyListId(long supplyListId) {
		_supplyListId = supplyListId;
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

	private long _supplyItemId;
	private String _supplyItemName;
	private long _supplyListId;
	private Date _createdDate;
	private Date _modifiedDate;
}