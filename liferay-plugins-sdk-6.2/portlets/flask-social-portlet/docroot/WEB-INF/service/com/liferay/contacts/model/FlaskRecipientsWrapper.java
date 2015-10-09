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
 * This class is a wrapper for {@link FlaskRecipients}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskRecipients
 * @generated
 */
public class FlaskRecipientsWrapper implements FlaskRecipients,
	ModelWrapper<FlaskRecipients> {
	public FlaskRecipientsWrapper(FlaskRecipients flaskRecipients) {
		_flaskRecipients = flaskRecipients;
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskRecipients.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskRecipients.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recipientId", getRecipientId());
		attributes.put("userId", getUserId());
		attributes.put("email", getEmail());
		attributes.put("messageId", getMessageId());
		attributes.put("read", getRead());
		attributes.put("receivedDateTime", getReceivedDateTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long recipientId = (Long)attributes.get("recipientId");

		if (recipientId != null) {
			setRecipientId(recipientId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		Boolean read = (Boolean)attributes.get("read");

		if (read != null) {
			setRead(read);
		}

		Date receivedDateTime = (Date)attributes.get("receivedDateTime");

		if (receivedDateTime != null) {
			setReceivedDateTime(receivedDateTime);
		}
	}

	/**
	* Returns the primary key of this flask recipients.
	*
	* @return the primary key of this flask recipients
	*/
	@Override
	public long getPrimaryKey() {
		return _flaskRecipients.getPrimaryKey();
	}

	/**
	* Sets the primary key of this flask recipients.
	*
	* @param primaryKey the primary key of this flask recipients
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_flaskRecipients.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the recipient ID of this flask recipients.
	*
	* @return the recipient ID of this flask recipients
	*/
	@Override
	public long getRecipientId() {
		return _flaskRecipients.getRecipientId();
	}

	/**
	* Sets the recipient ID of this flask recipients.
	*
	* @param recipientId the recipient ID of this flask recipients
	*/
	@Override
	public void setRecipientId(long recipientId) {
		_flaskRecipients.setRecipientId(recipientId);
	}

	/**
	* Returns the user ID of this flask recipients.
	*
	* @return the user ID of this flask recipients
	*/
	@Override
	public long getUserId() {
		return _flaskRecipients.getUserId();
	}

	/**
	* Sets the user ID of this flask recipients.
	*
	* @param userId the user ID of this flask recipients
	*/
	@Override
	public void setUserId(long userId) {
		_flaskRecipients.setUserId(userId);
	}

	/**
	* Returns the user uuid of this flask recipients.
	*
	* @return the user uuid of this flask recipients
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskRecipients.getUserUuid();
	}

	/**
	* Sets the user uuid of this flask recipients.
	*
	* @param userUuid the user uuid of this flask recipients
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_flaskRecipients.setUserUuid(userUuid);
	}

	/**
	* Returns the email of this flask recipients.
	*
	* @return the email of this flask recipients
	*/
	@Override
	public java.lang.String getEmail() {
		return _flaskRecipients.getEmail();
	}

	/**
	* Sets the email of this flask recipients.
	*
	* @param email the email of this flask recipients
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_flaskRecipients.setEmail(email);
	}

	/**
	* Returns the message ID of this flask recipients.
	*
	* @return the message ID of this flask recipients
	*/
	@Override
	public long getMessageId() {
		return _flaskRecipients.getMessageId();
	}

	/**
	* Sets the message ID of this flask recipients.
	*
	* @param messageId the message ID of this flask recipients
	*/
	@Override
	public void setMessageId(long messageId) {
		_flaskRecipients.setMessageId(messageId);
	}

	/**
	* Returns the read of this flask recipients.
	*
	* @return the read of this flask recipients
	*/
	@Override
	public boolean getRead() {
		return _flaskRecipients.getRead();
	}

	/**
	* Returns <code>true</code> if this flask recipients is read.
	*
	* @return <code>true</code> if this flask recipients is read; <code>false</code> otherwise
	*/
	@Override
	public boolean isRead() {
		return _flaskRecipients.isRead();
	}

	/**
	* Sets whether this flask recipients is read.
	*
	* @param read the read of this flask recipients
	*/
	@Override
	public void setRead(boolean read) {
		_flaskRecipients.setRead(read);
	}

	/**
	* Returns the received date time of this flask recipients.
	*
	* @return the received date time of this flask recipients
	*/
	@Override
	public java.util.Date getReceivedDateTime() {
		return _flaskRecipients.getReceivedDateTime();
	}

	/**
	* Sets the received date time of this flask recipients.
	*
	* @param receivedDateTime the received date time of this flask recipients
	*/
	@Override
	public void setReceivedDateTime(java.util.Date receivedDateTime) {
		_flaskRecipients.setReceivedDateTime(receivedDateTime);
	}

	@Override
	public boolean isNew() {
		return _flaskRecipients.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_flaskRecipients.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _flaskRecipients.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_flaskRecipients.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _flaskRecipients.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _flaskRecipients.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_flaskRecipients.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _flaskRecipients.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_flaskRecipients.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_flaskRecipients.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flaskRecipients.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FlaskRecipientsWrapper((FlaskRecipients)_flaskRecipients.clone());
	}

	@Override
	public int compareTo(
		com.liferay.contacts.model.FlaskRecipients flaskRecipients) {
		return _flaskRecipients.compareTo(flaskRecipients);
	}

	@Override
	public int hashCode() {
		return _flaskRecipients.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.contacts.model.FlaskRecipients> toCacheModel() {
		return _flaskRecipients.toCacheModel();
	}

	@Override
	public com.liferay.contacts.model.FlaskRecipients toEscapedModel() {
		return new FlaskRecipientsWrapper(_flaskRecipients.toEscapedModel());
	}

	@Override
	public com.liferay.contacts.model.FlaskRecipients toUnescapedModel() {
		return new FlaskRecipientsWrapper(_flaskRecipients.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _flaskRecipients.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _flaskRecipients.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_flaskRecipients.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlaskRecipientsWrapper)) {
			return false;
		}

		FlaskRecipientsWrapper flaskRecipientsWrapper = (FlaskRecipientsWrapper)obj;

		if (Validator.equals(_flaskRecipients,
					flaskRecipientsWrapper._flaskRecipients)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FlaskRecipients getWrappedFlaskRecipients() {
		return _flaskRecipients;
	}

	@Override
	public FlaskRecipients getWrappedModel() {
		return _flaskRecipients;
	}

	@Override
	public void resetOriginalValues() {
		_flaskRecipients.resetOriginalValues();
	}

	private FlaskRecipients _flaskRecipients;
}