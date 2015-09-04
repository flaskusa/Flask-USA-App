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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.TailgateUsersServiceSoap}.
 *
 * @author rajeshj
 * @see com.rumbasolutions.flask.service.http.TailgateUsersServiceSoap
 * @generated
 */
public class TailgateUsersSoap implements Serializable {
	public static TailgateUsersSoap toSoapModel(TailgateUsers model) {
		TailgateUsersSoap soapModel = new TailgateUsersSoap();

		soapModel.setTailgateUserId(model.getTailgateUserId());
		soapModel.setTailgateId(model.getTailgateId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setIsAdmin(model.getIsAdmin());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setIsPaid(model.getIsPaid());
		soapModel.setPaymentMode(model.getPaymentMode());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static TailgateUsersSoap[] toSoapModels(TailgateUsers[] models) {
		TailgateUsersSoap[] soapModels = new TailgateUsersSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TailgateUsersSoap[][] toSoapModels(TailgateUsers[][] models) {
		TailgateUsersSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TailgateUsersSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TailgateUsersSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TailgateUsersSoap[] toSoapModels(List<TailgateUsers> models) {
		List<TailgateUsersSoap> soapModels = new ArrayList<TailgateUsersSoap>(models.size());

		for (TailgateUsers model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TailgateUsersSoap[soapModels.size()]);
	}

	public TailgateUsersSoap() {
	}

	public long getPrimaryKey() {
		return _tailgateUserId;
	}

	public void setPrimaryKey(long pk) {
		setTailgateUserId(pk);
	}

	public long getTailgateUserId() {
		return _tailgateUserId;
	}

	public void setTailgateUserId(long tailgateUserId) {
		_tailgateUserId = tailgateUserId;
	}

	public long getTailgateId() {
		return _tailgateId;
	}

	public void setTailgateId(long tailgateId) {
		_tailgateId = tailgateId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public int getIsAdmin() {
		return _isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		_isAdmin = isAdmin;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public boolean getIsPaid() {
		return _isPaid;
	}

	public boolean isIsPaid() {
		return _isPaid;
	}

	public void setIsPaid(boolean isPaid) {
		_isPaid = isPaid;
	}

	public String getPaymentMode() {
		return _paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		_paymentMode = paymentMode;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _tailgateUserId;
	private long _tailgateId;
	private long _userId;
	private String _userName;
	private int _isAdmin;
	private long _groupId;
	private String _emailAddress;
	private boolean _isPaid;
	private String _paymentMode;
	private String _description;
}