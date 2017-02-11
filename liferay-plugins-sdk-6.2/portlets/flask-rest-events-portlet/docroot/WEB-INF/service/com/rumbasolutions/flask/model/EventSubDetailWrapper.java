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
 * This class is a wrapper for {@link EventSubDetail}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventSubDetail
 * @generated
 */
public class EventSubDetailWrapper implements EventSubDetail,
	ModelWrapper<EventSubDetail> {
	public EventSubDetailWrapper(EventSubDetail eventSubDetail) {
		_eventSubDetail = eventSubDetail;
	}

	@Override
	public Class<?> getModelClass() {
		return EventSubDetail.class;
	}

	@Override
	public String getModelClassName() {
		return EventSubDetail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventSubDetailId", getEventSubDetailId());
		attributes.put("eventDetailId", getEventDetailId());
		attributes.put("eventSubDetailTitle", getEventSubDetailTitle());
		attributes.put("eventSubDetailDesc", getEventSubDetailDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventSubDetailId = (Long)attributes.get("eventSubDetailId");

		if (eventSubDetailId != null) {
			setEventSubDetailId(eventSubDetailId);
		}

		Long eventDetailId = (Long)attributes.get("eventDetailId");

		if (eventDetailId != null) {
			setEventDetailId(eventDetailId);
		}

		String eventSubDetailTitle = (String)attributes.get(
				"eventSubDetailTitle");

		if (eventSubDetailTitle != null) {
			setEventSubDetailTitle(eventSubDetailTitle);
		}

		String eventSubDetailDesc = (String)attributes.get("eventSubDetailDesc");

		if (eventSubDetailDesc != null) {
			setEventSubDetailDesc(eventSubDetailDesc);
		}
	}

	/**
	* Returns the primary key of this event sub detail.
	*
	* @return the primary key of this event sub detail
	*/
	@Override
	public long getPrimaryKey() {
		return _eventSubDetail.getPrimaryKey();
	}

	/**
	* Sets the primary key of this event sub detail.
	*
	* @param primaryKey the primary key of this event sub detail
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eventSubDetail.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the event sub detail ID of this event sub detail.
	*
	* @return the event sub detail ID of this event sub detail
	*/
	@Override
	public long getEventSubDetailId() {
		return _eventSubDetail.getEventSubDetailId();
	}

	/**
	* Sets the event sub detail ID of this event sub detail.
	*
	* @param eventSubDetailId the event sub detail ID of this event sub detail
	*/
	@Override
	public void setEventSubDetailId(long eventSubDetailId) {
		_eventSubDetail.setEventSubDetailId(eventSubDetailId);
	}

	/**
	* Returns the event detail ID of this event sub detail.
	*
	* @return the event detail ID of this event sub detail
	*/
	@Override
	public long getEventDetailId() {
		return _eventSubDetail.getEventDetailId();
	}

	/**
	* Sets the event detail ID of this event sub detail.
	*
	* @param eventDetailId the event detail ID of this event sub detail
	*/
	@Override
	public void setEventDetailId(long eventDetailId) {
		_eventSubDetail.setEventDetailId(eventDetailId);
	}

	/**
	* Returns the event sub detail title of this event sub detail.
	*
	* @return the event sub detail title of this event sub detail
	*/
	@Override
	public java.lang.String getEventSubDetailTitle() {
		return _eventSubDetail.getEventSubDetailTitle();
	}

	/**
	* Sets the event sub detail title of this event sub detail.
	*
	* @param eventSubDetailTitle the event sub detail title of this event sub detail
	*/
	@Override
	public void setEventSubDetailTitle(java.lang.String eventSubDetailTitle) {
		_eventSubDetail.setEventSubDetailTitle(eventSubDetailTitle);
	}

	/**
	* Returns the event sub detail desc of this event sub detail.
	*
	* @return the event sub detail desc of this event sub detail
	*/
	@Override
	public java.lang.String getEventSubDetailDesc() {
		return _eventSubDetail.getEventSubDetailDesc();
	}

	/**
	* Sets the event sub detail desc of this event sub detail.
	*
	* @param eventSubDetailDesc the event sub detail desc of this event sub detail
	*/
	@Override
	public void setEventSubDetailDesc(java.lang.String eventSubDetailDesc) {
		_eventSubDetail.setEventSubDetailDesc(eventSubDetailDesc);
	}

	@Override
	public boolean isNew() {
		return _eventSubDetail.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_eventSubDetail.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _eventSubDetail.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eventSubDetail.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _eventSubDetail.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _eventSubDetail.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eventSubDetail.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eventSubDetail.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_eventSubDetail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_eventSubDetail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventSubDetail.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EventSubDetailWrapper((EventSubDetail)_eventSubDetail.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.EventSubDetail eventSubDetail) {
		return _eventSubDetail.compareTo(eventSubDetail);
	}

	@Override
	public int hashCode() {
		return _eventSubDetail.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.EventSubDetail> toCacheModel() {
		return _eventSubDetail.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.EventSubDetail toEscapedModel() {
		return new EventSubDetailWrapper(_eventSubDetail.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.EventSubDetail toUnescapedModel() {
		return new EventSubDetailWrapper(_eventSubDetail.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eventSubDetail.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eventSubDetail.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eventSubDetail.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventSubDetailWrapper)) {
			return false;
		}

		EventSubDetailWrapper eventSubDetailWrapper = (EventSubDetailWrapper)obj;

		if (Validator.equals(_eventSubDetail,
					eventSubDetailWrapper._eventSubDetail)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EventSubDetail getWrappedEventSubDetail() {
		return _eventSubDetail;
	}

	@Override
	public EventSubDetail getWrappedModel() {
		return _eventSubDetail;
	}

	@Override
	public void resetOriginalValues() {
		_eventSubDetail.resetOriginalValues();
	}

	private EventSubDetail _eventSubDetail;
}