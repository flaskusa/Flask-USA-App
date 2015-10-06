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
 * This class is used by SOAP remote services, specifically {@link com.liferay.contacts.service.http.FlaskMessagesServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contacts.service.http.FlaskMessagesServiceSoap
 * @generated
 */
public class FlaskMessagesSoap implements Serializable {
	public static FlaskMessagesSoap toSoapModel(FlaskMessages model) {
		FlaskMessagesSoap soapModel = new FlaskMessagesSoap();

		soapModel.setMessageId(model.getMessageId());
		soapModel.setSenderEmail(model.getSenderEmail());
		soapModel.setSenderUserId(model.getSenderUserId());
		soapModel.setSenderName(model.getSenderName());
		soapModel.setRecipients(model.getRecipients());
		soapModel.setMessage(model.getMessage());
		soapModel.setSendEmail(model.getSendEmail());
		soapModel.setDateTime(model.getDateTime());

		return soapModel;
	}

	public static FlaskMessagesSoap[] toSoapModels(FlaskMessages[] models) {
		FlaskMessagesSoap[] soapModels = new FlaskMessagesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FlaskMessagesSoap[][] toSoapModels(FlaskMessages[][] models) {
		FlaskMessagesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FlaskMessagesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FlaskMessagesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FlaskMessagesSoap[] toSoapModels(List<FlaskMessages> models) {
		List<FlaskMessagesSoap> soapModels = new ArrayList<FlaskMessagesSoap>(models.size());

		for (FlaskMessages model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FlaskMessagesSoap[soapModels.size()]);
	}

	public FlaskMessagesSoap() {
	}

	public long getPrimaryKey() {
		return _messageId;
	}

	public void setPrimaryKey(long pk) {
		setMessageId(pk);
	}

	public long getMessageId() {
		return _messageId;
	}

	public void setMessageId(long messageId) {
		_messageId = messageId;
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

	public String getRecipients() {
		return _recipients;
	}

	public void setRecipients(String recipients) {
		_recipients = recipients;
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

	private long _messageId;
	private String _senderEmail;
	private long _senderUserId;
	private String _senderName;
	private String _recipients;
	private String _message;
	private boolean _sendEmail;
	private Date _dateTime;
}