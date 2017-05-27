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
 * This class is a wrapper for {@link FlaskGroupRecipients}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupRecipients
 * @generated
 */
public class FlaskGroupRecipientsWrapper implements FlaskGroupRecipients,
	ModelWrapper<FlaskGroupRecipients> {
	public FlaskGroupRecipientsWrapper(
		FlaskGroupRecipients flaskGroupRecipients) {
		_flaskGroupRecipients = flaskGroupRecipients;
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskGroupRecipients.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskGroupRecipients.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupRecipientId", getGroupRecipientId());
		attributes.put("groupId", getGroupId());
		attributes.put("recipients", getRecipients());
		attributes.put("groupMessageId", getGroupMessageId());
		attributes.put("read", getRead());
		attributes.put("receivedDateTime", getReceivedDateTime());
		attributes.put("senderId", getSenderId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupRecipientId = (Long)attributes.get("groupRecipientId");

		if (groupRecipientId != null) {
			setGroupRecipientId(groupRecipientId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String recipients = (String)attributes.get("recipients");

		if (recipients != null) {
			setRecipients(recipients);
		}

		Long groupMessageId = (Long)attributes.get("groupMessageId");

		if (groupMessageId != null) {
			setGroupMessageId(groupMessageId);
		}

		String read = (String)attributes.get("read");

		if (read != null) {
			setRead(read);
		}

		Date receivedDateTime = (Date)attributes.get("receivedDateTime");

		if (receivedDateTime != null) {
			setReceivedDateTime(receivedDateTime);
		}

		Long senderId = (Long)attributes.get("senderId");

		if (senderId != null) {
			setSenderId(senderId);
		}
	}

	/**
	* Returns the primary key of this flask group recipients.
	*
	* @return the primary key of this flask group recipients
	*/
	@Override
	public long getPrimaryKey() {
		return _flaskGroupRecipients.getPrimaryKey();
	}

	/**
	* Sets the primary key of this flask group recipients.
	*
	* @param primaryKey the primary key of this flask group recipients
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_flaskGroupRecipients.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the group recipient ID of this flask group recipients.
	*
	* @return the group recipient ID of this flask group recipients
	*/
	@Override
	public long getGroupRecipientId() {
		return _flaskGroupRecipients.getGroupRecipientId();
	}

	/**
	* Sets the group recipient ID of this flask group recipients.
	*
	* @param groupRecipientId the group recipient ID of this flask group recipients
	*/
	@Override
	public void setGroupRecipientId(long groupRecipientId) {
		_flaskGroupRecipients.setGroupRecipientId(groupRecipientId);
	}

	/**
	* Returns the group ID of this flask group recipients.
	*
	* @return the group ID of this flask group recipients
	*/
	@Override
	public long getGroupId() {
		return _flaskGroupRecipients.getGroupId();
	}

	/**
	* Sets the group ID of this flask group recipients.
	*
	* @param groupId the group ID of this flask group recipients
	*/
	@Override
	public void setGroupId(long groupId) {
		_flaskGroupRecipients.setGroupId(groupId);
	}

	/**
	* Returns the recipients of this flask group recipients.
	*
	* @return the recipients of this flask group recipients
	*/
	@Override
	public java.lang.String getRecipients() {
		return _flaskGroupRecipients.getRecipients();
	}

	/**
	* Sets the recipients of this flask group recipients.
	*
	* @param recipients the recipients of this flask group recipients
	*/
	@Override
	public void setRecipients(java.lang.String recipients) {
		_flaskGroupRecipients.setRecipients(recipients);
	}

	/**
	* Returns the group message ID of this flask group recipients.
	*
	* @return the group message ID of this flask group recipients
	*/
	@Override
	public long getGroupMessageId() {
		return _flaskGroupRecipients.getGroupMessageId();
	}

	/**
	* Sets the group message ID of this flask group recipients.
	*
	* @param groupMessageId the group message ID of this flask group recipients
	*/
	@Override
	public void setGroupMessageId(long groupMessageId) {
		_flaskGroupRecipients.setGroupMessageId(groupMessageId);
	}

	/**
	* Returns the read of this flask group recipients.
	*
	* @return the read of this flask group recipients
	*/
	@Override
	public java.lang.String getRead() {
		return _flaskGroupRecipients.getRead();
	}

	/**
	* Sets the read of this flask group recipients.
	*
	* @param read the read of this flask group recipients
	*/
	@Override
	public void setRead(java.lang.String read) {
		_flaskGroupRecipients.setRead(read);
	}

	/**
	* Returns the received date time of this flask group recipients.
	*
	* @return the received date time of this flask group recipients
	*/
	@Override
	public java.util.Date getReceivedDateTime() {
		return _flaskGroupRecipients.getReceivedDateTime();
	}

	/**
	* Sets the received date time of this flask group recipients.
	*
	* @param receivedDateTime the received date time of this flask group recipients
	*/
	@Override
	public void setReceivedDateTime(java.util.Date receivedDateTime) {
		_flaskGroupRecipients.setReceivedDateTime(receivedDateTime);
	}

	/**
	* Returns the sender ID of this flask group recipients.
	*
	* @return the sender ID of this flask group recipients
	*/
	@Override
	public long getSenderId() {
		return _flaskGroupRecipients.getSenderId();
	}

	/**
	* Sets the sender ID of this flask group recipients.
	*
	* @param senderId the sender ID of this flask group recipients
	*/
	@Override
	public void setSenderId(long senderId) {
		_flaskGroupRecipients.setSenderId(senderId);
	}

	@Override
	public boolean isNew() {
		return _flaskGroupRecipients.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_flaskGroupRecipients.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _flaskGroupRecipients.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_flaskGroupRecipients.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _flaskGroupRecipients.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _flaskGroupRecipients.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_flaskGroupRecipients.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _flaskGroupRecipients.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_flaskGroupRecipients.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_flaskGroupRecipients.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flaskGroupRecipients.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FlaskGroupRecipientsWrapper((FlaskGroupRecipients)_flaskGroupRecipients.clone());
	}

	@Override
	public int compareTo(
		com.liferay.contacts.model.FlaskGroupRecipients flaskGroupRecipients) {
		return _flaskGroupRecipients.compareTo(flaskGroupRecipients);
	}

	@Override
	public int hashCode() {
		return _flaskGroupRecipients.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.contacts.model.FlaskGroupRecipients> toCacheModel() {
		return _flaskGroupRecipients.toCacheModel();
	}

	@Override
	public com.liferay.contacts.model.FlaskGroupRecipients toEscapedModel() {
		return new FlaskGroupRecipientsWrapper(_flaskGroupRecipients.toEscapedModel());
	}

	@Override
	public com.liferay.contacts.model.FlaskGroupRecipients toUnescapedModel() {
		return new FlaskGroupRecipientsWrapper(_flaskGroupRecipients.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _flaskGroupRecipients.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _flaskGroupRecipients.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_flaskGroupRecipients.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlaskGroupRecipientsWrapper)) {
			return false;
		}

		FlaskGroupRecipientsWrapper flaskGroupRecipientsWrapper = (FlaskGroupRecipientsWrapper)obj;

		if (Validator.equals(_flaskGroupRecipients,
					flaskGroupRecipientsWrapper._flaskGroupRecipients)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FlaskGroupRecipients getWrappedFlaskGroupRecipients() {
		return _flaskGroupRecipients;
	}

	@Override
	public FlaskGroupRecipients getWrappedModel() {
		return _flaskGroupRecipients;
	}

	@Override
	public void resetOriginalValues() {
		_flaskGroupRecipients.resetOriginalValues();
	}

	private FlaskGroupRecipients _flaskGroupRecipients;
}