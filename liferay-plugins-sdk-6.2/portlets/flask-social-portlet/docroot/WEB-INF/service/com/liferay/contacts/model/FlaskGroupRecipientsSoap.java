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
 * This class is used by SOAP remote services, specifically {@link com.liferay.contacts.service.http.FlaskGroupRecipientsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contacts.service.http.FlaskGroupRecipientsServiceSoap
 * @generated
 */
public class FlaskGroupRecipientsSoap implements Serializable {
	public static FlaskGroupRecipientsSoap toSoapModel(
		FlaskGroupRecipients model) {
		FlaskGroupRecipientsSoap soapModel = new FlaskGroupRecipientsSoap();

		soapModel.setGroupRecipientId(model.getGroupRecipientId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setRecipients(model.getRecipients());
		soapModel.setGroupMessageId(model.getGroupMessageId());
		soapModel.setRead(model.getRead());
		soapModel.setReceivedDateTime(model.getReceivedDateTime());
		soapModel.setSenderId(model.getSenderId());
		soapModel.setMessageStatusInfo(model.getMessageStatusInfo());

		return soapModel;
	}

	public static FlaskGroupRecipientsSoap[] toSoapModels(
		FlaskGroupRecipients[] models) {
		FlaskGroupRecipientsSoap[] soapModels = new FlaskGroupRecipientsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FlaskGroupRecipientsSoap[][] toSoapModels(
		FlaskGroupRecipients[][] models) {
		FlaskGroupRecipientsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FlaskGroupRecipientsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FlaskGroupRecipientsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FlaskGroupRecipientsSoap[] toSoapModels(
		List<FlaskGroupRecipients> models) {
		List<FlaskGroupRecipientsSoap> soapModels = new ArrayList<FlaskGroupRecipientsSoap>(models.size());

		for (FlaskGroupRecipients model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FlaskGroupRecipientsSoap[soapModels.size()]);
	}

	public FlaskGroupRecipientsSoap() {
	}

	public long getPrimaryKey() {
		return _groupRecipientId;
	}

	public void setPrimaryKey(long pk) {
		setGroupRecipientId(pk);
	}

	public long getGroupRecipientId() {
		return _groupRecipientId;
	}

	public void setGroupRecipientId(long groupRecipientId) {
		_groupRecipientId = groupRecipientId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getRecipients() {
		return _recipients;
	}

	public void setRecipients(String recipients) {
		_recipients = recipients;
	}

	public long getGroupMessageId() {
		return _groupMessageId;
	}

	public void setGroupMessageId(long groupMessageId) {
		_groupMessageId = groupMessageId;
	}

	public String getRead() {
		return _read;
	}

	public void setRead(String read) {
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

	public String getMessageStatusInfo() {
		return _messageStatusInfo;
	}

	public void setMessageStatusInfo(String messageStatusInfo) {
		_messageStatusInfo = messageStatusInfo;
	}

	private long _groupRecipientId;
	private long _groupId;
	private String _recipients;
	private long _groupMessageId;
	private String _read;
	private Date _receivedDateTime;
	private long _senderId;
	private String _messageStatusInfo;
}