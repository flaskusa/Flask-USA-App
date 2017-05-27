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
 * This class is used by SOAP remote services, specifically {@link com.liferay.contacts.service.http.NotificationAuditLogServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contacts.service.http.NotificationAuditLogServiceSoap
 * @generated
 */
public class NotificationAuditLogSoap implements Serializable {
	public static NotificationAuditLogSoap toSoapModel(
		NotificationAuditLog model) {
		NotificationAuditLogSoap soapModel = new NotificationAuditLogSoap();

		soapModel.setNotificationAuditLogId(model.getNotificationAuditLogId());
		soapModel.setSenderEmail(model.getSenderEmail());
		soapModel.setReceiverEmail(model.getReceiverEmail());
		soapModel.setMessageReason(model.getMessageReason());
		soapModel.setMessage(model.getMessage());
		soapModel.setNotificationTime(model.getNotificationTime());

		return soapModel;
	}

	public static NotificationAuditLogSoap[] toSoapModels(
		NotificationAuditLog[] models) {
		NotificationAuditLogSoap[] soapModels = new NotificationAuditLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NotificationAuditLogSoap[][] toSoapModels(
		NotificationAuditLog[][] models) {
		NotificationAuditLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NotificationAuditLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NotificationAuditLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NotificationAuditLogSoap[] toSoapModels(
		List<NotificationAuditLog> models) {
		List<NotificationAuditLogSoap> soapModels = new ArrayList<NotificationAuditLogSoap>(models.size());

		for (NotificationAuditLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NotificationAuditLogSoap[soapModels.size()]);
	}

	public NotificationAuditLogSoap() {
	}

	public long getPrimaryKey() {
		return _notificationAuditLogId;
	}

	public void setPrimaryKey(long pk) {
		setNotificationAuditLogId(pk);
	}

	public long getNotificationAuditLogId() {
		return _notificationAuditLogId;
	}

	public void setNotificationAuditLogId(long notificationAuditLogId) {
		_notificationAuditLogId = notificationAuditLogId;
	}

	public String getSenderEmail() {
		return _senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		_senderEmail = senderEmail;
	}

	public String getReceiverEmail() {
		return _receiverEmail;
	}

	public void setReceiverEmail(String receiverEmail) {
		_receiverEmail = receiverEmail;
	}

	public String getMessageReason() {
		return _messageReason;
	}

	public void setMessageReason(String messageReason) {
		_messageReason = messageReason;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public Date getNotificationTime() {
		return _notificationTime;
	}

	public void setNotificationTime(Date notificationTime) {
		_notificationTime = notificationTime;
	}

	private long _notificationAuditLogId;
	private String _senderEmail;
	private String _receiverEmail;
	private String _messageReason;
	private String _message;
	private Date _notificationTime;
}