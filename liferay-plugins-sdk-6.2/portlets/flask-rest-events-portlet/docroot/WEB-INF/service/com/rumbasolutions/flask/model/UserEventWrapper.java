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

package com.rumbasolutions.flask.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserEvent}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see UserEvent
 * @generated
 */
public class UserEventWrapper implements UserEvent, ModelWrapper<UserEvent> {
	public UserEventWrapper(UserEvent userEvent) {
		_userEvent = userEvent;
	}

	@Override
	public Class<?> getModelClass() {
		return UserEvent.class;
	}

	@Override
	public String getModelClassName() {
		return UserEvent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userEventId", getUserEventId());
		attributes.put("userId", getUserId());
		attributes.put("eventId", getEventId());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userEventId = (Long)attributes.get("userEventId");

		if (userEventId != null) {
			setUserEventId(userEventId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	/**
	* Returns the primary key of this user event.
	*
	* @return the primary key of this user event
	*/
	@Override
	public long getPrimaryKey() {
		return _userEvent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user event.
	*
	* @param primaryKey the primary key of this user event
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userEvent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user event ID of this user event.
	*
	* @return the user event ID of this user event
	*/
	@Override
	public long getUserEventId() {
		return _userEvent.getUserEventId();
	}

	/**
	* Sets the user event ID of this user event.
	*
	* @param userEventId the user event ID of this user event
	*/
	@Override
	public void setUserEventId(long userEventId) {
		_userEvent.setUserEventId(userEventId);
	}

	/**
	* Returns the user ID of this user event.
	*
	* @return the user ID of this user event
	*/
	@Override
	public long getUserId() {
		return _userEvent.getUserId();
	}

	/**
	* Sets the user ID of this user event.
	*
	* @param userId the user ID of this user event
	*/
	@Override
	public void setUserId(long userId) {
		_userEvent.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user event.
	*
	* @return the user uuid of this user event
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEvent.getUserUuid();
	}

	/**
	* Sets the user uuid of this user event.
	*
	* @param userUuid the user uuid of this user event
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userEvent.setUserUuid(userUuid);
	}

	/**
	* Returns the event ID of this user event.
	*
	* @return the event ID of this user event
	*/
	@Override
	public long getEventId() {
		return _userEvent.getEventId();
	}

	/**
	* Sets the event ID of this user event.
	*
	* @param eventId the event ID of this user event
	*/
	@Override
	public void setEventId(long eventId) {
		_userEvent.setEventId(eventId);
	}

	/**
	* Returns the created date of this user event.
	*
	* @return the created date of this user event
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _userEvent.getCreatedDate();
	}

	/**
	* Sets the created date of this user event.
	*
	* @param createdDate the created date of this user event
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_userEvent.setCreatedDate(createdDate);
	}

	@Override
	public boolean isNew() {
		return _userEvent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userEvent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userEvent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userEvent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userEvent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userEvent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userEvent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userEvent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userEvent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userEvent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userEvent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserEventWrapper((UserEvent)_userEvent.clone());
	}

	@Override
	public int compareTo(com.rumbasolutions.flask.model.UserEvent userEvent) {
		return _userEvent.compareTo(userEvent);
	}

	@Override
	public int hashCode() {
		return _userEvent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.UserEvent> toCacheModel() {
		return _userEvent.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.UserEvent toEscapedModel() {
		return new UserEventWrapper(_userEvent.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.UserEvent toUnescapedModel() {
		return new UserEventWrapper(_userEvent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userEvent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userEvent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userEvent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserEventWrapper)) {
			return false;
		}

		UserEventWrapper userEventWrapper = (UserEventWrapper)obj;

		if (Validator.equals(_userEvent, userEventWrapper._userEvent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserEvent getWrappedUserEvent() {
		return _userEvent;
	}

	@Override
	public UserEvent getWrappedModel() {
		return _userEvent;
	}

	@Override
	public void resetOriginalValues() {
		_userEvent.resetOriginalValues();
	}

	private UserEvent _userEvent;
}