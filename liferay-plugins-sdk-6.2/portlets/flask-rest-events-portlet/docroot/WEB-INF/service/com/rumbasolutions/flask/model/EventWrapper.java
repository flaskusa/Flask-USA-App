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
 * This class is a wrapper for {@link Event}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see Event
 * @generated
 */
public class EventWrapper implements Event, ModelWrapper<Event> {
	public EventWrapper(Event event) {
		_event = event;
	}

	@Override
	public Class<?> getModelClass() {
		return Event.class;
	}

	@Override
	public String getModelClassName() {
		return Event.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventId", getEventId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventName", getEventName());
		attributes.put("description", getDescription());
		attributes.put("eventDate", getEventDate());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("eventTypeId", getEventTypeId());
		attributes.put("eventTypeName", getEventTypeName());
		attributes.put("eventImagePath", getEventImagePath());
		attributes.put("venueId", getVenueId());
		attributes.put("venueName", getVenueName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String eventName = (String)attributes.get("eventName");

		if (eventName != null) {
			setEventName(eventName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date eventDate = (Date)attributes.get("eventDate");

		if (eventDate != null) {
			setEventDate(eventDate);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Long eventTypeId = (Long)attributes.get("eventTypeId");

		if (eventTypeId != null) {
			setEventTypeId(eventTypeId);
		}

		String eventTypeName = (String)attributes.get("eventTypeName");

		if (eventTypeName != null) {
			setEventTypeName(eventTypeName);
		}

		String eventImagePath = (String)attributes.get("eventImagePath");

		if (eventImagePath != null) {
			setEventImagePath(eventImagePath);
		}

		Long venueId = (Long)attributes.get("venueId");

		if (venueId != null) {
			setVenueId(venueId);
		}

		String venueName = (String)attributes.get("venueName");

		if (venueName != null) {
			setVenueName(venueName);
		}
	}

	/**
	* Returns the primary key of this event.
	*
	* @return the primary key of this event
	*/
	@Override
	public long getPrimaryKey() {
		return _event.getPrimaryKey();
	}

	/**
	* Sets the primary key of this event.
	*
	* @param primaryKey the primary key of this event
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_event.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the event ID of this event.
	*
	* @return the event ID of this event
	*/
	@Override
	public long getEventId() {
		return _event.getEventId();
	}

	/**
	* Sets the event ID of this event.
	*
	* @param eventId the event ID of this event
	*/
	@Override
	public void setEventId(long eventId) {
		_event.setEventId(eventId);
	}

	/**
	* Returns the company ID of this event.
	*
	* @return the company ID of this event
	*/
	@Override
	public long getCompanyId() {
		return _event.getCompanyId();
	}

	/**
	* Sets the company ID of this event.
	*
	* @param companyId the company ID of this event
	*/
	@Override
	public void setCompanyId(long companyId) {
		_event.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this event.
	*
	* @return the user ID of this event
	*/
	@Override
	public long getUserId() {
		return _event.getUserId();
	}

	/**
	* Sets the user ID of this event.
	*
	* @param userId the user ID of this event
	*/
	@Override
	public void setUserId(long userId) {
		_event.setUserId(userId);
	}

	/**
	* Returns the user uuid of this event.
	*
	* @return the user uuid of this event
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _event.getUserUuid();
	}

	/**
	* Sets the user uuid of this event.
	*
	* @param userUuid the user uuid of this event
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_event.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this event.
	*
	* @return the created date of this event
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _event.getCreatedDate();
	}

	/**
	* Sets the created date of this event.
	*
	* @param createdDate the created date of this event
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_event.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this event.
	*
	* @return the modified date of this event
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _event.getModifiedDate();
	}

	/**
	* Sets the modified date of this event.
	*
	* @param modifiedDate the modified date of this event
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_event.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the event name of this event.
	*
	* @return the event name of this event
	*/
	@Override
	public java.lang.String getEventName() {
		return _event.getEventName();
	}

	/**
	* Sets the event name of this event.
	*
	* @param eventName the event name of this event
	*/
	@Override
	public void setEventName(java.lang.String eventName) {
		_event.setEventName(eventName);
	}

	/**
	* Returns the description of this event.
	*
	* @return the description of this event
	*/
	@Override
	public java.lang.String getDescription() {
		return _event.getDescription();
	}

	/**
	* Sets the description of this event.
	*
	* @param description the description of this event
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_event.setDescription(description);
	}

	/**
	* Returns the event date of this event.
	*
	* @return the event date of this event
	*/
	@Override
	public java.util.Date getEventDate() {
		return _event.getEventDate();
	}

	/**
	* Sets the event date of this event.
	*
	* @param eventDate the event date of this event
	*/
	@Override
	public void setEventDate(java.util.Date eventDate) {
		_event.setEventDate(eventDate);
	}

	/**
	* Returns the start time of this event.
	*
	* @return the start time of this event
	*/
	@Override
	public java.util.Date getStartTime() {
		return _event.getStartTime();
	}

	/**
	* Sets the start time of this event.
	*
	* @param startTime the start time of this event
	*/
	@Override
	public void setStartTime(java.util.Date startTime) {
		_event.setStartTime(startTime);
	}

	/**
	* Returns the end time of this event.
	*
	* @return the end time of this event
	*/
	@Override
	public java.util.Date getEndTime() {
		return _event.getEndTime();
	}

	/**
	* Sets the end time of this event.
	*
	* @param endTime the end time of this event
	*/
	@Override
	public void setEndTime(java.util.Date endTime) {
		_event.setEndTime(endTime);
	}

	/**
	* Returns the event type ID of this event.
	*
	* @return the event type ID of this event
	*/
	@Override
	public long getEventTypeId() {
		return _event.getEventTypeId();
	}

	/**
	* Sets the event type ID of this event.
	*
	* @param eventTypeId the event type ID of this event
	*/
	@Override
	public void setEventTypeId(long eventTypeId) {
		_event.setEventTypeId(eventTypeId);
	}

	/**
	* Returns the event type name of this event.
	*
	* @return the event type name of this event
	*/
	@Override
	public java.lang.String getEventTypeName() {
		return _event.getEventTypeName();
	}

	/**
	* Sets the event type name of this event.
	*
	* @param eventTypeName the event type name of this event
	*/
	@Override
	public void setEventTypeName(java.lang.String eventTypeName) {
		_event.setEventTypeName(eventTypeName);
	}

	/**
	* Returns the event image path of this event.
	*
	* @return the event image path of this event
	*/
	@Override
	public java.lang.String getEventImagePath() {
		return _event.getEventImagePath();
	}

	/**
	* Sets the event image path of this event.
	*
	* @param eventImagePath the event image path of this event
	*/
	@Override
	public void setEventImagePath(java.lang.String eventImagePath) {
		_event.setEventImagePath(eventImagePath);
	}

	/**
	* Returns the venue ID of this event.
	*
	* @return the venue ID of this event
	*/
	@Override
	public long getVenueId() {
		return _event.getVenueId();
	}

	/**
	* Sets the venue ID of this event.
	*
	* @param venueId the venue ID of this event
	*/
	@Override
	public void setVenueId(long venueId) {
		_event.setVenueId(venueId);
	}

	/**
	* Returns the venue name of this event.
	*
	* @return the venue name of this event
	*/
	@Override
	public java.lang.String getVenueName() {
		return _event.getVenueName();
	}

	/**
	* Sets the venue name of this event.
	*
	* @param venueName the venue name of this event
	*/
	@Override
	public void setVenueName(java.lang.String venueName) {
		_event.setVenueName(venueName);
	}

	@Override
	public boolean isNew() {
		return _event.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_event.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _event.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_event.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _event.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _event.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_event.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _event.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_event.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_event.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_event.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EventWrapper((Event)_event.clone());
	}

	@Override
	public int compareTo(com.rumbasolutions.flask.model.Event event) {
		return _event.compareTo(event);
	}

	@Override
	public int hashCode() {
		return _event.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.Event> toCacheModel() {
		return _event.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.Event toEscapedModel() {
		return new EventWrapper(_event.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.Event toUnescapedModel() {
		return new EventWrapper(_event.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _event.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _event.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_event.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventWrapper)) {
			return false;
		}

		EventWrapper eventWrapper = (EventWrapper)obj;

		if (Validator.equals(_event, eventWrapper._event)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Event getWrappedEvent() {
		return _event;
	}

	@Override
	public Event getWrappedModel() {
		return _event;
	}

	@Override
	public void resetOriginalValues() {
		_event.resetOriginalValues();
	}

	private Event _event;
}