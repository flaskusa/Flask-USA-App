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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.TailgateMessageBoardServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.http.TailgateMessageBoardServiceSoap
 * @generated
 */
public class TailgateMessageBoardSoap implements Serializable {
	public static TailgateMessageBoardSoap toSoapModel(
		TailgateMessageBoard model) {
		TailgateMessageBoardSoap soapModel = new TailgateMessageBoardSoap();

		soapModel.setTailgateMessageId(model.getTailgateMessageId());
		soapModel.setMessageText(model.getMessageText());
		soapModel.setTailgateId(model.getTailgateId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static TailgateMessageBoardSoap[] toSoapModels(
		TailgateMessageBoard[] models) {
		TailgateMessageBoardSoap[] soapModels = new TailgateMessageBoardSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TailgateMessageBoardSoap[][] toSoapModels(
		TailgateMessageBoard[][] models) {
		TailgateMessageBoardSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TailgateMessageBoardSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TailgateMessageBoardSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TailgateMessageBoardSoap[] toSoapModels(
		List<TailgateMessageBoard> models) {
		List<TailgateMessageBoardSoap> soapModels = new ArrayList<TailgateMessageBoardSoap>(models.size());

		for (TailgateMessageBoard model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TailgateMessageBoardSoap[soapModels.size()]);
	}

	public TailgateMessageBoardSoap() {
	}

	public long getPrimaryKey() {
		return _tailgateMessageId;
	}

	public void setPrimaryKey(long pk) {
		setTailgateMessageId(pk);
	}

	public long getTailgateMessageId() {
		return _tailgateMessageId;
	}

	public void setTailgateMessageId(long tailgateMessageId) {
		_tailgateMessageId = tailgateMessageId;
	}

	public String getMessageText() {
		return _messageText;
	}

	public void setMessageText(String messageText) {
		_messageText = messageText;
	}

	public long getTailgateId() {
		return _tailgateId;
	}

	public void setTailgateId(long tailgateId) {
		_tailgateId = tailgateId;
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

	private long _tailgateMessageId;
	private String _messageText;
	private long _tailgateId;
	private long _companyId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
}