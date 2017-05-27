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

package com.liferay.contacts.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.contacts.service.http.FlaskGroupMessagesServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contacts.service.http.FlaskGroupMessagesServiceSoap
 * @generated
 */
public class FlaskGroupMessagesSoap implements Serializable {
	public static FlaskGroupMessagesSoap toSoapModel(FlaskGroupMessages model) {
		FlaskGroupMessagesSoap soapModel = new FlaskGroupMessagesSoap();

		soapModel.setGroupMessagesId(model.getGroupMessagesId());
		soapModel.setSenderEmail(model.getSenderEmail());
		soapModel.setSenderUserId(model.getSenderUserId());
		soapModel.setSenderName(model.getSenderName());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setMessage(model.getMessage());
		soapModel.setSendEmail(model.getSendEmail());
		soapModel.setDateTime(model.getDateTime());

		return soapModel;
	}

	public static FlaskGroupMessagesSoap[] toSoapModels(
		FlaskGroupMessages[] models) {
		FlaskGroupMessagesSoap[] soapModels = new FlaskGroupMessagesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FlaskGroupMessagesSoap[][] toSoapModels(
		FlaskGroupMessages[][] models) {
		FlaskGroupMessagesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FlaskGroupMessagesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FlaskGroupMessagesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FlaskGroupMessagesSoap[] toSoapModels(
		List<FlaskGroupMessages> models) {
		List<FlaskGroupMessagesSoap> soapModels = new ArrayList<FlaskGroupMessagesSoap>(models.size());

		for (FlaskGroupMessages model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FlaskGroupMessagesSoap[soapModels.size()]);
	}

	public FlaskGroupMessagesSoap() {
	}

	public long getPrimaryKey() {
		return _groupMessagesId;
	}

	public void setPrimaryKey(long pk) {
		setGroupMessagesId(pk);
	}

	public long getGroupMessagesId() {
		return _groupMessagesId;
	}

	public void setGroupMessagesId(long groupMessagesId) {
		_groupMessagesId = groupMessagesId;
	}

	public String getSenderEmail() {
		return _senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		_senderEmail = senderEmail;
	}

	public long getSenderUserId() {
		return _senderUserId;
	}

	public void setSenderUserId(long senderUserId) {
		_senderUserId = senderUserId;
	}

	public String getSenderName() {
		return _senderName;
	}

	public void setSenderName(String senderName) {
		_senderName = senderName;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public boolean getSendEmail() {
		return _sendEmail;
	}

	public boolean isSendEmail() {
		return _sendEmail;
	}

	public void setSendEmail(boolean sendEmail) {
		_sendEmail = sendEmail;
	}

	public Date getDateTime() {
		return _dateTime;
	}

	public void setDateTime(Date dateTime) {
		_dateTime = dateTime;
	}

	private long _groupMessagesId;
	private String _senderEmail;
	private long _senderUserId;
	private String _senderName;
	private long _groupId;
	private String _message;
	private boolean _sendEmail;
	private Date _dateTime;
}