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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the FlaskRecipients service. Represents a row in the &quot;Contacts_FlaskRecipients&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.contacts.model.impl.FlaskRecipientsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskRecipients
 * @see com.liferay.contacts.model.impl.FlaskRecipientsImpl
 * @see com.liferay.contacts.model.impl.FlaskRecipientsModelImpl
 * @generated
 */
public interface FlaskRecipientsModel extends BaseModel<FlaskRecipients> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a flask recipients model instance should use the {@link FlaskRecipients} interface instead.
	 */

	/**
	 * Returns the primary key of this flask recipients.
	 *
	 * @return the primary key of this flask recipients
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this flask recipients.
	 *
	 * @param primaryKey the primary key of this flask recipients
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the recipient ID of this flask recipients.
	 *
	 * @return the recipient ID of this flask recipients
	 */
	public long getRecipientId();

	/**
	 * Sets the recipient ID of this flask recipients.
	 *
	 * @param recipientId the recipient ID of this flask recipients
	 */
	public void setRecipientId(long recipientId);

	/**
	 * Returns the user ID of this flask recipients.
	 *
	 * @return the user ID of this flask recipients
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this flask recipients.
	 *
	 * @param userId the user ID of this flask recipients
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this flask recipients.
	 *
	 * @return the user uuid of this flask recipients
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this flask recipients.
	 *
	 * @param userUuid the user uuid of this flask recipients
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the email of this flask recipients.
	 *
	 * @return the email of this flask recipients
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this flask recipients.
	 *
	 * @param email the email of this flask recipients
	 */
	public void setEmail(String email);

	/**
	 * Returns the message ID of this flask recipients.
	 *
	 * @return the message ID of this flask recipients
	 */
	public long getMessageId();

	/**
	 * Sets the message ID of this flask recipients.
	 *
	 * @param messageId the message ID of this flask recipients
	 */
	public void setMessageId(long messageId);

	/**
	 * Returns the read of this flask recipients.
	 *
	 * @return the read of this flask recipients
	 */
	public boolean getRead();

	/**
	 * Returns <code>true</code> if this flask recipients is read.
	 *
	 * @return <code>true</code> if this flask recipients is read; <code>false</code> otherwise
	 */
	public boolean isRead();

	/**
	 * Sets whether this flask recipients is read.
	 *
	 * @param read the read of this flask recipients
	 */
	public void setRead(boolean read);

	/**
	 * Returns the received date time of this flask recipients.
	 *
	 * @return the received date time of this flask recipients
	 */
	public Date getReceivedDateTime();

	/**
	 * Sets the received date time of this flask recipients.
	 *
	 * @param receivedDateTime the received date time of this flask recipients
	 */
	public void setReceivedDateTime(Date receivedDateTime);

	/**
	 * Returns the sender ID of this flask recipients.
	 *
	 * @return the sender ID of this flask recipients
	 */
	public long getSenderId();

	/**
	 * Sets the sender ID of this flask recipients.
	 *
	 * @param senderId the sender ID of this flask recipients
	 */
	public void setSenderId(long senderId);

	/**
	 * Returns the deleted by of this flask recipients.
	 *
	 * @return the deleted by of this flask recipients
	 */
	@AutoEscape
	public String getDeletedBy();

	/**
	 * Sets the deleted by of this flask recipients.
	 *
	 * @param deletedBy the deleted by of this flask recipients
	 */
	public void setDeletedBy(String deletedBy);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.liferay.contacts.model.FlaskRecipients flaskRecipients);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.liferay.contacts.model.FlaskRecipients> toCacheModel();

	@Override
	public com.liferay.contacts.model.FlaskRecipients toEscapedModel();

	@Override
	public com.liferay.contacts.model.FlaskRecipients toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}