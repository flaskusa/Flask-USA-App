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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link NotificationAuditLog}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationAuditLog
 * @generated
 */
public class NotificationAuditLogWrapper implements NotificationAuditLog,
	ModelWrapper<NotificationAuditLog> {
	public NotificationAuditLogWrapper(
		NotificationAuditLog notificationAuditLog) {
		_notificationAuditLog = notificationAuditLog;
	}

	@Override
	public Class<?> getModelClass() {
		return NotificationAuditLog.class;
	}

	@Override
	public String getModelClassName() {
		return NotificationAuditLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("notificationAuditLogId", getNotificationAuditLogId());
		attributes.put("senderEmail", getSenderEmail());
		attributes.put("receiverEmail", getReceiverEmail());
		attributes.put("messageReason", getMessageReason());
		attributes.put("message", getMessage());
		attributes.put("notificationTime", getNotificationTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long notificationAuditLogId = (Long)attributes.get(
				"notificationAuditLogId");

		if (notificationAuditLogId != null) {
			setNotificationAuditLogId(notificationAuditLogId);
		}

		String senderEmail = (String)attributes.get("senderEmail");

		if (senderEmail != null) {
			setSenderEmail(senderEmail);
		}

		String receiverEmail = (String)attributes.get("receiverEmail");

		if (receiverEmail != null) {
			setReceiverEmail(receiverEmail);
		}

		String messageReason = (String)attributes.get("messageReason");

		if (messageReason != null) {
			setMessageReason(messageReason);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Date notificationTime = (Date)attributes.get("notificationTime");

		if (notificationTime != null) {
			setNotificationTime(notificationTime);
		}
	}

	/**
	* Returns the primary key of this notification audit log.
	*
	* @return the primary key of this notification audit log
	*/
	@Override
	public long getPrimaryKey() {
		return _notificationAuditLog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this notification audit log.
	*
	* @param primaryKey the primary key of this notification audit log
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_notificationAuditLog.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the notification audit log ID of this notification audit log.
	*
	* @return the notification audit log ID of this notification audit log
	*/
	@Override
	public long getNotificationAuditLogId() {
		return _notificationAuditLog.getNotificationAuditLogId();
	}

	/**
	* Sets the notification audit log ID of this notification audit log.
	*
	* @param notificationAuditLogId the notification audit log ID of this notification audit log
	*/
	@Override
	public void setNotificationAuditLogId(long notificationAuditLogId) {
		_notificationAuditLog.setNotificationAuditLogId(notificationAuditLogId);
	}

	/**
	* Returns the sender email of this notification audit log.
	*
	* @return the sender email of this notification audit log
	*/
	@Override
	public java.lang.String getSenderEmail() {
		return _notificationAuditLog.getSenderEmail();
	}

	/**
	* Sets the sender email of this notification audit log.
	*
	* @param senderEmail the sender email of this notification audit log
	*/
	@Override
	public void setSenderEmail(java.lang.String senderEmail) {
		_notificationAuditLog.setSenderEmail(senderEmail);
	}

	/**
	* Returns the receiver email of this notification audit log.
	*
	* @return the receiver email of this notification audit log
	*/
	@Override
	public java.lang.String getReceiverEmail() {
		return _notificationAuditLog.getReceiverEmail();
	}

	/**
	* Sets the receiver email of this notification audit log.
	*
	* @param receiverEmail the receiver email of this notification audit log
	*/
	@Override
	public void setReceiverEmail(java.lang.String receiverEmail) {
		_notificationAuditLog.setReceiverEmail(receiverEmail);
	}

	/**
	* Returns the message reason of this notification audit log.
	*
	* @return the message reason of this notification audit log
	*/
	@Override
	public java.lang.String getMessageReason() {
		return _notificationAuditLog.getMessageReason();
	}

	/**
	* Sets the message reason of this notification audit log.
	*
	* @param messageReason the message reason of this notification audit log
	*/
	@Override
	public void setMessageReason(java.lang.String messageReason) {
		_notificationAuditLog.setMessageReason(messageReason);
	}

	/**
	* Returns the message of this notification audit log.
	*
	* @return the message of this notification audit log
	*/
	@Override
	public java.lang.String getMessage() {
		return _notificationAuditLog.getMessage();
	}

	/**
	* Sets the message of this notification audit log.
	*
	* @param message the message of this notification audit log
	*/
	@Override
	public void setMessage(java.lang.String message) {
		_notificationAuditLog.setMessage(message);
	}

	/**
	* Returns the notification time of this notification audit log.
	*
	* @return the notification time of this notification audit log
	*/
	@Override
	public java.util.Date getNotificationTime() {
		return _notificationAuditLog.getNotificationTime();
	}

	/**
	* Sets the notification time of this notification audit log.
	*
	* @param notificationTime the notification time of this notification audit log
	*/
	@Override
	public void setNotificationTime(java.util.Date notificationTime) {
		_notificationAuditLog.setNotificationTime(notificationTime);
	}

	@Override
	public boolean isNew() {
		return _notificationAuditLog.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_notificationAuditLog.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _notificationAuditLog.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_notificationAuditLog.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _notificationAuditLog.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _notificationAuditLog.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_notificationAuditLog.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _notificationAuditLog.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_notificationAuditLog.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_notificationAuditLog.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_notificationAuditLog.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NotificationAuditLogWrapper((NotificationAuditLog)_notificationAuditLog.clone());
	}

	@Override
	public int compareTo(
		com.liferay.contacts.model.NotificationAuditLog notificationAuditLog) {
		return _notificationAuditLog.compareTo(notificationAuditLog);
	}

	@Override
	public int hashCode() {
		return _notificationAuditLog.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.contacts.model.NotificationAuditLog> toCacheModel() {
		return _notificationAuditLog.toCacheModel();
	}

	@Override
	public com.liferay.contacts.model.NotificationAuditLog toEscapedModel() {
		return new NotificationAuditLogWrapper(_notificationAuditLog.toEscapedModel());
	}

	@Override
	public com.liferay.contacts.model.NotificationAuditLog toUnescapedModel() {
		return new NotificationAuditLogWrapper(_notificationAuditLog.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _notificationAuditLog.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _notificationAuditLog.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_notificationAuditLog.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NotificationAuditLogWrapper)) {
			return false;
		}

		NotificationAuditLogWrapper notificationAuditLogWrapper = (NotificationAuditLogWrapper)obj;

		if (Validator.equals(_notificationAuditLog,
					notificationAuditLogWrapper._notificationAuditLog)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public NotificationAuditLog getWrappedNotificationAuditLog() {
		return _notificationAuditLog;
	}

	@Override
	public NotificationAuditLog getWrappedModel() {
		return _notificationAuditLog;
	}

	@Override
	public void resetOriginalValues() {
		_notificationAuditLog.resetOriginalValues();
	}

	private NotificationAuditLog _notificationAuditLog;
}