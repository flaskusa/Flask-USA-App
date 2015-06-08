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

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EventDetailImage}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventDetailImage
 * @generated
 */
public class EventDetailImageWrapper implements EventDetailImage,
	ModelWrapper<EventDetailImage> {
	public EventDetailImageWrapper(EventDetailImage eventDetailImage) {
		_eventDetailImage = eventDetailImage;
	}

	@Override
	public Class<?> getModelClass() {
		return EventDetailImage.class;
	}

	@Override
	public String getModelClassName() {
		return EventDetailImage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventDetailImageId", getEventDetailImageId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventDetailId", getEventDetailId());
		attributes.put("eventDetailImagetitle", getEventDetailImagetitle());
		attributes.put("eventDetailImageDesc", getEventDetailImageDesc());
		attributes.put("eventDetailImageData", getEventDetailImageData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventDetailImageId = (Long)attributes.get("eventDetailImageId");

		if (eventDetailImageId != null) {
			setEventDetailImageId(eventDetailImageId);
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

		Long eventDetailId = (Long)attributes.get("eventDetailId");

		if (eventDetailId != null) {
			setEventDetailId(eventDetailId);
		}

		String eventDetailImagetitle = (String)attributes.get(
				"eventDetailImagetitle");

		if (eventDetailImagetitle != null) {
			setEventDetailImagetitle(eventDetailImagetitle);
		}

		String eventDetailImageDesc = (String)attributes.get(
				"eventDetailImageDesc");

		if (eventDetailImageDesc != null) {
			setEventDetailImageDesc(eventDetailImageDesc);
		}

		Blob eventDetailImageData = (Blob)attributes.get("eventDetailImageData");

		if (eventDetailImageData != null) {
			setEventDetailImageData(eventDetailImageData);
		}
	}

	/**
	* Returns the primary key of this event detail image.
	*
	* @return the primary key of this event detail image
	*/
	@Override
	public long getPrimaryKey() {
		return _eventDetailImage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this event detail image.
	*
	* @param primaryKey the primary key of this event detail image
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eventDetailImage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the event detail image ID of this event detail image.
	*
	* @return the event detail image ID of this event detail image
	*/
	@Override
	public long getEventDetailImageId() {
		return _eventDetailImage.getEventDetailImageId();
	}

	/**
	* Sets the event detail image ID of this event detail image.
	*
	* @param eventDetailImageId the event detail image ID of this event detail image
	*/
	@Override
	public void setEventDetailImageId(long eventDetailImageId) {
		_eventDetailImage.setEventDetailImageId(eventDetailImageId);
	}

	/**
	* Returns the company ID of this event detail image.
	*
	* @return the company ID of this event detail image
	*/
	@Override
	public long getCompanyId() {
		return _eventDetailImage.getCompanyId();
	}

	/**
	* Sets the company ID of this event detail image.
	*
	* @param companyId the company ID of this event detail image
	*/
	@Override
	public void setCompanyId(long companyId) {
		_eventDetailImage.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this event detail image.
	*
	* @return the user ID of this event detail image
	*/
	@Override
	public long getUserId() {
		return _eventDetailImage.getUserId();
	}

	/**
	* Sets the user ID of this event detail image.
	*
	* @param userId the user ID of this event detail image
	*/
	@Override
	public void setUserId(long userId) {
		_eventDetailImage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this event detail image.
	*
	* @return the user uuid of this event detail image
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventDetailImage.getUserUuid();
	}

	/**
	* Sets the user uuid of this event detail image.
	*
	* @param userUuid the user uuid of this event detail image
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_eventDetailImage.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this event detail image.
	*
	* @return the created date of this event detail image
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _eventDetailImage.getCreatedDate();
	}

	/**
	* Sets the created date of this event detail image.
	*
	* @param createdDate the created date of this event detail image
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_eventDetailImage.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this event detail image.
	*
	* @return the modified date of this event detail image
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _eventDetailImage.getModifiedDate();
	}

	/**
	* Sets the modified date of this event detail image.
	*
	* @param modifiedDate the modified date of this event detail image
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_eventDetailImage.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the event detail ID of this event detail image.
	*
	* @return the event detail ID of this event detail image
	*/
	@Override
	public long getEventDetailId() {
		return _eventDetailImage.getEventDetailId();
	}

	/**
	* Sets the event detail ID of this event detail image.
	*
	* @param eventDetailId the event detail ID of this event detail image
	*/
	@Override
	public void setEventDetailId(long eventDetailId) {
		_eventDetailImage.setEventDetailId(eventDetailId);
	}

	/**
	* Returns the event detail imagetitle of this event detail image.
	*
	* @return the event detail imagetitle of this event detail image
	*/
	@Override
	public java.lang.String getEventDetailImagetitle() {
		return _eventDetailImage.getEventDetailImagetitle();
	}

	/**
	* Sets the event detail imagetitle of this event detail image.
	*
	* @param eventDetailImagetitle the event detail imagetitle of this event detail image
	*/
	@Override
	public void setEventDetailImagetitle(java.lang.String eventDetailImagetitle) {
		_eventDetailImage.setEventDetailImagetitle(eventDetailImagetitle);
	}

	/**
	* Returns the event detail image desc of this event detail image.
	*
	* @return the event detail image desc of this event detail image
	*/
	@Override
	public java.lang.String getEventDetailImageDesc() {
		return _eventDetailImage.getEventDetailImageDesc();
	}

	/**
	* Sets the event detail image desc of this event detail image.
	*
	* @param eventDetailImageDesc the event detail image desc of this event detail image
	*/
	@Override
	public void setEventDetailImageDesc(java.lang.String eventDetailImageDesc) {
		_eventDetailImage.setEventDetailImageDesc(eventDetailImageDesc);
	}

	/**
	* Returns the event detail image data of this event detail image.
	*
	* @return the event detail image data of this event detail image
	*/
	@Override
	public java.sql.Blob getEventDetailImageData() {
		return _eventDetailImage.getEventDetailImageData();
	}

	/**
	* Sets the event detail image data of this event detail image.
	*
	* @param eventDetailImageData the event detail image data of this event detail image
	*/
	@Override
	public void setEventDetailImageData(java.sql.Blob eventDetailImageData) {
		_eventDetailImage.setEventDetailImageData(eventDetailImageData);
	}

	@Override
	public boolean isNew() {
		return _eventDetailImage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_eventDetailImage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _eventDetailImage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eventDetailImage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _eventDetailImage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _eventDetailImage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eventDetailImage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eventDetailImage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_eventDetailImage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_eventDetailImage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventDetailImage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EventDetailImageWrapper((EventDetailImage)_eventDetailImage.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.EventDetailImage eventDetailImage) {
		return _eventDetailImage.compareTo(eventDetailImage);
	}

	@Override
	public int hashCode() {
		return _eventDetailImage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.EventDetailImage> toCacheModel() {
		return _eventDetailImage.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.EventDetailImage toEscapedModel() {
		return new EventDetailImageWrapper(_eventDetailImage.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.EventDetailImage toUnescapedModel() {
		return new EventDetailImageWrapper(_eventDetailImage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eventDetailImage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eventDetailImage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eventDetailImage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventDetailImageWrapper)) {
			return false;
		}

		EventDetailImageWrapper eventDetailImageWrapper = (EventDetailImageWrapper)obj;

		if (Validator.equals(_eventDetailImage,
					eventDetailImageWrapper._eventDetailImage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EventDetailImage getWrappedEventDetailImage() {
		return _eventDetailImage;
	}

	@Override
	public EventDetailImage getWrappedModel() {
		return _eventDetailImage;
	}

	@Override
	public void resetOriginalValues() {
		_eventDetailImage.resetOriginalValues();
	}

	private EventDetailImage _eventDetailImage;
}