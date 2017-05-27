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
 * This class is a wrapper for {@link FlaskGroupMessages}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupMessages
 * @generated
 */
public class FlaskGroupMessagesWrapper implements FlaskGroupMessages,
	ModelWrapper<FlaskGroupMessages> {
	public FlaskGroupMessagesWrapper(FlaskGroupMessages flaskGroupMessages) {
		_flaskGroupMessages = flaskGroupMessages;
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskGroupMessages.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskGroupMessages.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupMessagesId", getGroupMessagesId());
		attributes.put("senderEmail", getSenderEmail());
		attributes.put("senderUserId", getSenderUserId());
		attributes.put("senderName", getSenderName());
		attributes.put("groupId", getGroupId());
		attributes.put("message", getMessage());
		attributes.put("sendEmail", getSendEmail());
		attributes.put("dateTime", getDateTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupMessagesId = (Long)attributes.get("groupMessagesId");

		if (groupMessagesId != null) {
			setGroupMessagesId(groupMessagesId);
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

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Boolean sendEmail = (Boolean)attributes.get("sendEmail");

		if (sendEmail != null) {
			setSendEmail(sendEmail);
		}

		Date dateTime = (Date)attributes.get("dateTime");

		if (dateTime != null) {
			setDateTime(dateTime);
		}
	}

	/**
	* Returns the primary key of this flask group messages.
	*
	* @return the primary key of this flask group messages
	*/
	@Override
	public long getPrimaryKey() {
		return _flaskGroupMessages.getPrimaryKey();
	}

	/**
	* Sets the primary key of this flask group messages.
	*
	* @param primaryKey the primary key of this flask group messages
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_flaskGroupMessages.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the group messages ID of this flask group messages.
	*
	* @return the group messages ID of this flask group messages
	*/
	@Override
	public long getGroupMessagesId() {
		return _flaskGroupMessages.getGroupMessagesId();
	}

	/**
	* Sets the group messages ID of this flask group messages.
	*
	* @param groupMessagesId the group messages ID of this flask group messages
	*/
	@Override
	public void setGroupMessagesId(long groupMessagesId) {
		_flaskGroupMessages.setGroupMessagesId(groupMessagesId);
	}

	/**
	* Returns the sender email of this flask group messages.
	*
	* @return the sender email of this flask group messages
	*/
	@Override
	public java.lang.String getSenderEmail() {
		return _flaskGroupMessages.getSenderEmail();
	}

	/**
	* Sets the sender email of this flask group messages.
	*
	* @param senderEmail the sender email of this flask group messages
	*/
	@Override
	public void setSenderEmail(java.lang.String senderEmail) {
		_flaskGroupMessages.setSenderEmail(senderEmail);
	}

	/**
	* Returns the sender user ID of this flask group messages.
	*
	* @return the sender user ID of this flask group messages
	*/
	@Override
	public long getSenderUserId() {
		return _flaskGroupMessages.getSenderUserId();
	}

	/**
	* Sets the sender user ID of this flask group messages.
	*
	* @param senderUserId the sender user ID of this flask group messages
	*/
	@Override
	public void setSenderUserId(long senderUserId) {
		_flaskGroupMessages.setSenderUserId(senderUserId);
	}

	/**
	* Returns the sender user uuid of this flask group messages.
	*
	* @return the sender user uuid of this flask group messages
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getSenderUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupMessages.getSenderUserUuid();
	}

	/**
	* Sets the sender user uuid of this flask group messages.
	*
	* @param senderUserUuid the sender user uuid of this flask group messages
	*/
	@Override
	public void setSenderUserUuid(java.lang.String senderUserUuid) {
		_flaskGroupMessages.setSenderUserUuid(senderUserUuid);
	}

	/**
	* Returns the sender name of this flask group messages.
	*
	* @return the sender name of this flask group messages
	*/
	@Override
	public java.lang.String getSenderName() {
		return _flaskGroupMessages.getSenderName();
	}

	/**
	* Sets the sender name of this flask group messages.
	*
	* @param senderName the sender name of this flask group messages
	*/
	@Override
	public void setSenderName(java.lang.String senderName) {
		_flaskGroupMessages.setSenderName(senderName);
	}

	/**
	* Returns the group ID of this flask group messages.
	*
	* @return the group ID of this flask group messages
	*/
	@Override
	public long getGroupId() {
		return _flaskGroupMessages.getGroupId();
	}

	/**
	* Sets the group ID of this flask group messages.
	*
	* @param groupId the group ID of this flask group messages
	*/
	@Override
	public void setGroupId(long groupId) {
		_flaskGroupMessages.setGroupId(groupId);
	}

	/**
	* Returns the message of this flask group messages.
	*
	* @return the message of this flask group messages
	*/
	@Override
	public java.lang.String getMessage() {
		return _flaskGroupMessages.getMessage();
	}

	/**
	* Sets the message of this flask group messages.
	*
	* @param message the message of this flask group messages
	*/
	@Override
	public void setMessage(java.lang.String message) {
		_flaskGroupMessages.setMessage(message);
	}

	/**
	* Returns the send email of this flask group messages.
	*
	* @return the send email of this flask group messages
	*/
	@Override
	public boolean getSendEmail() {
		return _flaskGroupMessages.getSendEmail();
	}

	/**
	* Returns <code>true</code> if this flask group messages is send email.
	*
	* @return <code>true</code> if this flask group messages is send email; <code>false</code> otherwise
	*/
	@Override
	public boolean isSendEmail() {
		return _flaskGroupMessages.isSendEmail();
	}

	/**
	* Sets whether this flask group messages is send email.
	*
	* @param sendEmail the send email of this flask group messages
	*/
	@Override
	public void setSendEmail(boolean sendEmail) {
		_flaskGroupMessages.setSendEmail(sendEmail);
	}

	/**
	* Returns the date time of this flask group messages.
	*
	* @return the date time of this flask group messages
	*/
	@Override
	public java.util.Date getDateTime() {
		return _flaskGroupMessages.getDateTime();
	}

	/**
	* Sets the date time of this flask group messages.
	*
	* @param dateTime the date time of this flask group messages
	*/
	@Override
	public void setDateTime(java.util.Date dateTime) {
		_flaskGroupMessages.setDateTime(dateTime);
	}

	@Override
	public boolean isNew() {
		return _flaskGroupMessages.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_flaskGroupMessages.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _flaskGroupMessages.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_flaskGroupMessages.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _flaskGroupMessages.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _flaskGroupMessages.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_flaskGroupMessages.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _flaskGroupMessages.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_flaskGroupMessages.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_flaskGroupMessages.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flaskGroupMessages.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FlaskGroupMessagesWrapper((FlaskGroupMessages)_flaskGroupMessages.clone());
	}

	@Override
	public int compareTo(
		com.liferay.contacts.model.FlaskGroupMessages flaskGroupMessages) {
		return _flaskGroupMessages.compareTo(flaskGroupMessages);
	}

	@Override
	public int hashCode() {
		return _flaskGroupMessages.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.contacts.model.FlaskGroupMessages> toCacheModel() {
		return _flaskGroupMessages.toCacheModel();
	}

	@Override
	public com.liferay.contacts.model.FlaskGroupMessages toEscapedModel() {
		return new FlaskGroupMessagesWrapper(_flaskGroupMessages.toEscapedModel());
	}

	@Override
	public com.liferay.contacts.model.FlaskGroupMessages toUnescapedModel() {
		return new FlaskGroupMessagesWrapper(_flaskGroupMessages.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _flaskGroupMessages.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _flaskGroupMessages.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_flaskGroupMessages.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlaskGroupMessagesWrapper)) {
			return false;
		}

		FlaskGroupMessagesWrapper flaskGroupMessagesWrapper = (FlaskGroupMessagesWrapper)obj;

		if (Validator.equals(_flaskGroupMessages,
					flaskGroupMessagesWrapper._flaskGroupMessages)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FlaskGroupMessages getWrappedFlaskGroupMessages() {
		return _flaskGroupMessages;
	}

	@Override
	public FlaskGroupMessages getWrappedModel() {
		return _flaskGroupMessages;
	}

	@Override
	public void resetOriginalValues() {
		_flaskGroupMessages.resetOriginalValues();
	}

	private FlaskGroupMessages _flaskGroupMessages;
}