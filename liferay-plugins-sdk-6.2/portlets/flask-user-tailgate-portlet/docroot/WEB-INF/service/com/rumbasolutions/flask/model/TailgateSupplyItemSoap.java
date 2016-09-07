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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.TailgateSupplyItemServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.http.TailgateSupplyItemServiceSoap
 * @generated
 */
public class TailgateSupplyItemSoap implements Serializable {
	public static TailgateSupplyItemSoap toSoapModel(TailgateSupplyItem model) {
		TailgateSupplyItemSoap soapModel = new TailgateSupplyItemSoap();

		soapModel.setTailgateSupplyItemId(model.getTailgateSupplyItemId());
		soapModel.setSupplyListItemName(model.getSupplyListItemName());
		soapModel.setTailgateId(model.getTailgateId());
		soapModel.setItemAssignedUserId(model.getItemAssignedUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static TailgateSupplyItemSoap[] toSoapModels(
		TailgateSupplyItem[] models) {
		TailgateSupplyItemSoap[] soapModels = new TailgateSupplyItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TailgateSupplyItemSoap[][] toSoapModels(
		TailgateSupplyItem[][] models) {
		TailgateSupplyItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TailgateSupplyItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TailgateSupplyItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TailgateSupplyItemSoap[] toSoapModels(
		List<TailgateSupplyItem> models) {
		List<TailgateSupplyItemSoap> soapModels = new ArrayList<TailgateSupplyItemSoap>(models.size());

		for (TailgateSupplyItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TailgateSupplyItemSoap[soapModels.size()]);
	}

	public TailgateSupplyItemSoap() {
	}

	public long getPrimaryKey() {
		return _tailgateSupplyItemId;
	}

	public void setPrimaryKey(long pk) {
		setTailgateSupplyItemId(pk);
	}

	public long getTailgateSupplyItemId() {
		return _tailgateSupplyItemId;
	}

	public void setTailgateSupplyItemId(long tailgateSupplyItemId) {
		_tailgateSupplyItemId = tailgateSupplyItemId;
	}

	public String getSupplyListItemName() {
		return _supplyListItemName;
	}

	public void setSupplyListItemName(String supplyListItemName) {
		_supplyListItemName = supplyListItemName;
	}

	public long getTailgateId() {
		return _tailgateId;
	}

	public void setTailgateId(long tailgateId) {
		_tailgateId = tailgateId;
	}

	public long getItemAssignedUserId() {
		return _itemAssignedUserId;
	}

	public void setItemAssignedUserId(long itemAssignedUserId) {
		_itemAssignedUserId = itemAssignedUserId;
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

	private long _tailgateSupplyItemId;
	private String _supplyListItemName;
	private long _tailgateId;
	private long _itemAssignedUserId;
	private long _companyId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
}