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
 * This class is used by SOAP remote services, specifically {@link com.liferay.contacts.service.http.FlaskRecipientsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contacts.service.http.FlaskRecipientsServiceSoap
 * @generated
 */
public class FlaskRecipientsSoap implements Serializable {
	public static FlaskRecipientsSoap toSoapModel(FlaskRecipients model) {
		FlaskRecipientsSoap soapModel = new FlaskRecipientsSoap();

		soapModel.setRecipientId(model.getRecipientId());
		soapModel.setUserId(model.getUserId());
		soapModel.setEmail(model.getEmail());
		soapModel.setMessageId(model.getMessageId());
		soapModel.setRead(model.getRead());
		soapModel.setReceivedDateTime(model.getReceivedDateTime());
		soapModel.setSenderId(model.getSenderId());

		return soapModel;
	}

	public static FlaskRecipientsSoap[] toSoapModels(FlaskRecipients[] models) {
		FlaskRecipientsSoap[] soapModels = new FlaskRecipientsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FlaskRecipientsSoap[][] toSoapModels(
		FlaskRecipients[][] models) {
		FlaskRecipientsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FlaskRecipientsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FlaskRecipientsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FlaskRecipientsSoap[] toSoapModels(
		List<FlaskRecipients> models) {
		List<FlaskRecipientsSoap> soapModels = new ArrayList<FlaskRecipientsSoap>(models.size());

		for (FlaskRecipients model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FlaskRecipientsSoap[soapModels.size()]);
	}

	public FlaskRecipientsSoap() {
	}

	public long getPrimaryKey() {
		return _recipientId;
	}

	public void setPrimaryKey(long pk) {
		setRecipientId(pk);
	}

	public long getRecipientId() {
		return _recipientId;
	}

	public void setRecipientId(long recipientId) {
		_recipientId = recipientId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	public boolean getRead() {
		return _read;
	}

	public boolean isRead() {
		return _read;
	}

	public void setRead(boolean read) {
		_read = read;
	}

	public Date getReceivedDateTime() {
		return _receivedDateTime;
	}

	public void setReceivedDateTime(Date receivedDateTime) {
		_receivedDateTime = receivedDateTime;
	}

	public long getSenderId() {
		return _senderId;
	}

	public void setSenderId(long senderId) {
		_senderId = senderId;
	}

	private long _recipientId;
	private long _userId;
	private String _email;
	private long _messageId;
	private boolean _read;
	private Date _receivedDateTime;
	private long _senderId;
}