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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FlaskMessages}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskMessages
 * @generated
 */
public class FlaskMessagesWrapper implements FlaskMessages,
	ModelWrapper<FlaskMessages> {
	public FlaskMessagesWrapper(FlaskMessages flaskMessages) {
		_flaskMessages = flaskMessages;
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskMessages.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskMessages.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("messageId", getMessageId());
		attributes.put("senderEmail", getSenderEmail());
		attributes.put("senderUserId", getSenderUserId());
		attributes.put("senderName", getSenderName());
		attributes.put("recipients", getRecipients());
		attributes.put("message", getMessage());
		attributes.put("sendEmail", getSendEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		String senderEmail = (String)attributes.get("senderEmail");

		if (senderEmail != null) {
			setSenderEmail(senderEmail);
		}

		Long senderUserId = (Long)attributes.get("senderUserId");

		if (senderUserId != null) {
			setSenderUserId(senderUserId);
		}

		String senderName = (String)attributes.get("senderName");

		if (senderName != null) {
			setSenderName(senderName);
		}

		String recipients = (String)attributes.get("recipients");

		if (recipients != null) {
			setRecipients(recipients);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Boolean sendEmail = (Boolean)attributes.get("sendEmail");

		if (sendEmail != null) {
			setSendEmail(sendEmail);
		}
	}

	/**
	* Returns the primary key of this flask messages.
	*
	* @return the primary key of this flask messages
	*/
	@Override
	public long getPrimaryKey() {
		return _flaskMessages.getPrimaryKey();
	}

	/**
	* Sets the primary key of this flask messages.
	*
	* @param primaryKey the primary key of this flask messages
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_flaskMessages.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the message ID of this flask messages.
	*
	* @return the message ID of this flask messages
	*/
	@Override
	public long getMessageId() {
		return _flaskMessages.getMessageId();
	}

	/**
	* Sets the message ID of this flask messages.
	*
	* @param messageId the message ID of this flask messages
	*/
	@Override
	public void setMessageId(long messageId) {
		_flaskMessages.setMessageId(messageId);
	}

	/**
	* Returns the sender email of this flask messages.
	*
	* @return the sender email of this flask messages
	*/
	@Override
	public java.lang.String getSenderEmail() {
		return _flaskMessages.getSenderEmail();
	}

	/**
	* Sets the sender email of this flask messages.
	*
	* @param senderEmail the sender email of this flask messages
	*/
	@Override
	public void setSenderEmail(java.lang.String senderEmail) {
		_flaskMessages.setSenderEmail(senderEmail);
	}

	/**
	* Returns the sender user ID of this flask messages.
	*
	* @return the sender user ID of this flask messages
	*/
	@Override
	public long getSenderUserId() {
		return _flaskMessages.getSenderUserId();
	}

	/**
	* Sets the sender user ID of this flask messages.
	*
	* @param senderUserId the sender user ID of this flask messages
	*/
	@Override
	public void setSenderUserId(long senderUserId) {
		_flaskMessages.setSenderUserId(senderUserId);
	}

	/**
	* Returns the sender user uuid of this flask messages.
	*
	* @return the sender user uuid of this flask messages
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getSenderUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskMessages.getSenderUserUuid();
	}

	/**
	* Sets the sender user uuid of this flask messages.
	*
	* @param senderUserUuid the sender user uuid of this flask messages
	*/
	@Override
	public void setSenderUserUuid(java.lang.String senderUserUuid) {
		_flaskMessages.setSenderUserUuid(senderUserUuid);
	}

	/**
	* Returns the sender name of this flask messages.
	*
	* @return the sender name of this flask messages
	*/
	@Override
	public java.lang.String getSenderName() {
		return _flaskMessages.getSenderName();
	}

	/**
	* Sets the sender name of this flask messages.
	*
	* @param senderName the sender name of this flask messages
	*/
	@Override
	public void setSenderName(java.lang.String senderName) {
		_flaskMessages.setSenderName(senderName);
	}

	/**
	* Returns the recipients of this flask messages.
	*
	* @return the recipients of this flask messages
	*/
	@Override
	public java.lang.String getRecipients() {
		return _flaskMessages.getRecipients();
	}

	/**
	* Sets the recipients of this flask messages.
	*
	* @param recipients the recipients of this flask messages
	*/
	@Override
	public void setRecipients(java.lang.String recipients) {
		_flaskMessages.setRecipients(recipients);
	}

	/**
	* Returns the message of this flask messages.
	*
	* @return the message of this flask messages
	*/
	@Override
	public java.lang.String getMessage() {
		return _flaskMessages.getMessage();
	}

	/**
	* Sets the message of this flask messages.
	*
	* @param message the message of this flask messages
	*/
	@Override
	public void setMessage(java.lang.String message) {
		_flaskMessages.setMessage(message);
	}

	/**
	* Returns the send email of this flask messages.
	*
	* @return the send email of this flask messages
	*/
	@Override
	public boolean getSendEmail() {
		return _flaskMessages.getSendEmail();
	}

	/**
	* Returns <code>true</code> if this flask messages is send email.
	*
	* @return <code>true</code> if this flask messages is send email; <code>false</code> otherwise
	*/
	@Override
	public boolean isSendEmail() {
		return _flaskMessages.isSendEmail();
	}

	/**
	* Sets whether this flask messages is send email.
	*
	* @param sendEmail the send email of this flask messages
	*/
	@Override
	public void setSendEmail(boolean sendEmail) {
		_flaskMessages.setSendEmail(sendEmail);
	}

	@Override
	public boolean isNew() {
		return _flaskMessages.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_flaskMessages.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _flaskMessages.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_flaskMessages.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _flaskMessages.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _flaskMessages.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_flaskMessages.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _flaskMessages.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_flaskMessages.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_flaskMessages.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flaskMessages.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FlaskMessagesWrapper((FlaskMessages)_flaskMessages.clone());
	}

	@Override
	public int compareTo(com.liferay.contacts.model.FlaskMessages flaskMessages) {
		return _flaskMessages.compareTo(flaskMessages);
	}

	@Override
	public int hashCode() {
		return _flaskMessages.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.contacts.model.FlaskMessages> toCacheModel() {
		return _flaskMessages.toCacheModel();
	}

	@Override
	public com.liferay.contacts.model.FlaskMessages toEscapedModel() {
		return new FlaskMessagesWrapper(_flaskMessages.toEscapedModel());
	}

	@Override
	public com.liferay.contacts.model.FlaskMessages toUnescapedModel() {
		return new FlaskMessagesWrapper(_flaskMessages.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _flaskMessages.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _flaskMessages.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_flaskMessages.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlaskMessagesWrapper)) {
			return false;
		}

		FlaskMessagesWrapper flaskMessagesWrapper = (FlaskMessagesWrapper)obj;

		if (Validator.equals(_flaskMessages, flaskMessagesWrapper._flaskMessages)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FlaskMessages getWrappedFlaskMessages() {
		return _flaskMessages;
	}

	@Override
	public FlaskMessages getWrappedModel() {
		return _flaskMessages;
	}

	@Override
	public void resetOriginalValues() {
		_flaskMessages.resetOriginalValues();
	}

	private FlaskMessages _flaskMessages;
}