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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EventType}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventType
 * @generated
 */
public class EventTypeWrapper implements EventType, ModelWrapper<EventType> {
	public EventTypeWrapper(EventType eventType) {
		_eventType = eventType;
	}

	@Override
	public Class<?> getModelClass() {
		return EventType.class;
	}

	@Override
	public String getModelClassName() {
		return EventType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventTypeId", getEventTypeId());
		attributes.put("eventTypeKey", getEventTypeKey());
		attributes.put("eventTypeName", getEventTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventTypeId = (Long)attributes.get("eventTypeId");

		if (eventTypeId != null) {
			setEventTypeId(eventTypeId);
		}

		String eventTypeKey = (String)attributes.get("eventTypeKey");

		if (eventTypeKey != null) {
			setEventTypeKey(eventTypeKey);
		}

		String eventTypeName = (String)attributes.get("eventTypeName");

		if (eventTypeName != null) {
			setEventTypeName(eventTypeName);
		}
	}

	/**
	* Returns the primary key of this event type.
	*
	* @return the primary key of this event type
	*/
	@Override
	public long getPrimaryKey() {
		return _eventType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this event type.
	*
	* @param primaryKey the primary key of this event type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eventType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the event type ID of this event type.
	*
	* @return the event type ID of this event type
	*/
	@Override
	public long getEventTypeId() {
		return _eventType.getEventTypeId();
	}

	/**
	* Sets the event type ID of this event type.
	*
	* @param eventTypeId the event type ID of this event type
	*/
	@Override
	public void setEventTypeId(long eventTypeId) {
		_eventType.setEventTypeId(eventTypeId);
	}

	/**
	* Returns the event type key of this event type.
	*
	* @return the event type key of this event type
	*/
	@Override
	public java.lang.String getEventTypeKey() {
		return _eventType.getEventTypeKey();
	}

	/**
	* Sets the event type key of this event type.
	*
	* @param eventTypeKey the event type key of this event type
	*/
	@Override
	public void setEventTypeKey(java.lang.String eventTypeKey) {
		_eventType.setEventTypeKey(eventTypeKey);
	}

	/**
	* Returns the event type name of this event type.
	*
	* @return the event type name of this event type
	*/
	@Override
	public java.lang.String getEventTypeName() {
		return _eventType.getEventTypeName();
	}

	/**
	* Sets the event type name of this event type.
	*
	* @param eventTypeName the event type name of this event type
	*/
	@Override
	public void setEventTypeName(java.lang.String eventTypeName) {
		_eventType.setEventTypeName(eventTypeName);
	}

	@Override
	public boolean isNew() {
		return _eventType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_eventType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _eventType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eventType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _eventType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _eventType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eventType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eventType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_eventType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_eventType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EventTypeWrapper((EventType)_eventType.clone());
	}

	@Override
	public int compareTo(com.rumbasolutions.flask.model.EventType eventType) {
		return _eventType.compareTo(eventType);
	}

	@Override
	public int hashCode() {
		return _eventType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.EventType> toCacheModel() {
		return _eventType.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.EventType toEscapedModel() {
		return new EventTypeWrapper(_eventType.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.EventType toUnescapedModel() {
		return new EventTypeWrapper(_eventType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eventType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eventType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eventType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventTypeWrapper)) {
			return false;
		}

		EventTypeWrapper eventTypeWrapper = (EventTypeWrapper)obj;

		if (Validator.equals(_eventType, eventTypeWrapper._eventType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EventType getWrappedEventType() {
		return _eventType;
	}

	@Override
	public EventType getWrappedModel() {
		return _eventType;
	}

	@Override
	public void resetOriginalValues() {
		_eventType.resetOriginalValues();
	}

	private EventType _eventType;
}