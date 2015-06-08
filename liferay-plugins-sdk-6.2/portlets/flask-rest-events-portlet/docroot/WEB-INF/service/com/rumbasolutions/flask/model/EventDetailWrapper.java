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
 * This class is a wrapper for {@link EventDetail}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventDetail
 * @generated
 */
public class EventDetailWrapper implements EventDetail,
	ModelWrapper<EventDetail> {
	public EventDetailWrapper(EventDetail eventDetail) {
		_eventDetail = eventDetail;
	}

	@Override
	public Class<?> getModelClass() {
		return EventDetail.class;
	}

	@Override
	public String getModelClassName() {
		return EventDetail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventDetailId", getEventDetailId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventId", getEventId());
		attributes.put("infoTypeId", getInfoTypeId());
		attributes.put("infoTypeCategoryId", getInfoTypeCategoryId());
		attributes.put("eventDetailInfoName", getEventDetailInfoName());
		attributes.put("eventDetailInfoDesc", getEventDetailInfoDesc());
		attributes.put("eventDetailInfoComment", getEventDetailInfoComment());
		attributes.put("eventDetailAddressLine1", getEventDetailAddressLine1());
		attributes.put("eventDetailAddressLine2", getEventDetailAddressLine2());
		attributes.put("eventDetailInfocity", getEventDetailInfocity());
		attributes.put("eventDetailZip", getEventDetailZip());
		attributes.put("eventDetailState", getEventDetailState());
		attributes.put("eventDetailCountry", getEventDetailCountry());
		attributes.put("eventDetailLatitude", getEventDetailLatitude());
		attributes.put("eventDetailLongitude", getEventDetailLongitude());
		attributes.put("eventDetailPhone", getEventDetailPhone());
		attributes.put("eventDetailWebsite", getEventDetailWebsite());
		attributes.put("eventDetailCost", getEventDetailCost());
		attributes.put("hoursOfOperation", getHoursOfOperation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventDetailId = (Long)attributes.get("eventDetailId");

		if (eventDetailId != null) {
			setEventDetailId(eventDetailId);
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

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Long infoTypeId = (Long)attributes.get("infoTypeId");

		if (infoTypeId != null) {
			setInfoTypeId(infoTypeId);
		}

		Long infoTypeCategoryId = (Long)attributes.get("infoTypeCategoryId");

		if (infoTypeCategoryId != null) {
			setInfoTypeCategoryId(infoTypeCategoryId);
		}

		String eventDetailInfoName = (String)attributes.get(
				"eventDetailInfoName");

		if (eventDetailInfoName != null) {
			setEventDetailInfoName(eventDetailInfoName);
		}

		String eventDetailInfoDesc = (String)attributes.get(
				"eventDetailInfoDesc");

		if (eventDetailInfoDesc != null) {
			setEventDetailInfoDesc(eventDetailInfoDesc);
		}

		String eventDetailInfoComment = (String)attributes.get(
				"eventDetailInfoComment");

		if (eventDetailInfoComment != null) {
			setEventDetailInfoComment(eventDetailInfoComment);
		}

		String eventDetailAddressLine1 = (String)attributes.get(
				"eventDetailAddressLine1");

		if (eventDetailAddressLine1 != null) {
			setEventDetailAddressLine1(eventDetailAddressLine1);
		}

		String eventDetailAddressLine2 = (String)attributes.get(
				"eventDetailAddressLine2");

		if (eventDetailAddressLine2 != null) {
			setEventDetailAddressLine2(eventDetailAddressLine2);
		}

		String eventDetailInfocity = (String)attributes.get(
				"eventDetailInfocity");

		if (eventDetailInfocity != null) {
			setEventDetailInfocity(eventDetailInfocity);
		}

		String eventDetailZip = (String)attributes.get("eventDetailZip");

		if (eventDetailZip != null) {
			setEventDetailZip(eventDetailZip);
		}

		String eventDetailState = (String)attributes.get("eventDetailState");

		if (eventDetailState != null) {
			setEventDetailState(eventDetailState);
		}

		String eventDetailCountry = (String)attributes.get("eventDetailCountry");

		if (eventDetailCountry != null) {
			setEventDetailCountry(eventDetailCountry);
		}

		String eventDetailLatitude = (String)attributes.get(
				"eventDetailLatitude");

		if (eventDetailLatitude != null) {
			setEventDetailLatitude(eventDetailLatitude);
		}

		String eventDetailLongitude = (String)attributes.get(
				"eventDetailLongitude");

		if (eventDetailLongitude != null) {
			setEventDetailLongitude(eventDetailLongitude);
		}

		String eventDetailPhone = (String)attributes.get("eventDetailPhone");

		if (eventDetailPhone != null) {
			setEventDetailPhone(eventDetailPhone);
		}

		String eventDetailWebsite = (String)attributes.get("eventDetailWebsite");

		if (eventDetailWebsite != null) {
			setEventDetailWebsite(eventDetailWebsite);
		}

		Double eventDetailCost = (Double)attributes.get("eventDetailCost");

		if (eventDetailCost != null) {
			setEventDetailCost(eventDetailCost);
		}

		String hoursOfOperation = (String)attributes.get("hoursOfOperation");

		if (hoursOfOperation != null) {
			setHoursOfOperation(hoursOfOperation);
		}
	}

	/**
	* Returns the primary key of this event detail.
	*
	* @return the primary key of this event detail
	*/
	@Override
	public long getPrimaryKey() {
		return _eventDetail.getPrimaryKey();
	}

	/**
	* Sets the primary key of this event detail.
	*
	* @param primaryKey the primary key of this event detail
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eventDetail.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the event detail ID of this event detail.
	*
	* @return the event detail ID of this event detail
	*/
	@Override
	public long getEventDetailId() {
		return _eventDetail.getEventDetailId();
	}

	/**
	* Sets the event detail ID of this event detail.
	*
	* @param eventDetailId the event detail ID of this event detail
	*/
	@Override
	public void setEventDetailId(long eventDetailId) {
		_eventDetail.setEventDetailId(eventDetailId);
	}

	/**
	* Returns the company ID of this event detail.
	*
	* @return the company ID of this event detail
	*/
	@Override
	public long getCompanyId() {
		return _eventDetail.getCompanyId();
	}

	/**
	* Sets the company ID of this event detail.
	*
	* @param companyId the company ID of this event detail
	*/
	@Override
	public void setCompanyId(long companyId) {
		_eventDetail.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this event detail.
	*
	* @return the user ID of this event detail
	*/
	@Override
	public long getUserId() {
		return _eventDetail.getUserId();
	}

	/**
	* Sets the user ID of this event detail.
	*
	* @param userId the user ID of this event detail
	*/
	@Override
	public void setUserId(long userId) {
		_eventDetail.setUserId(userId);
	}

	/**
	* Returns the user uuid of this event detail.
	*
	* @return the user uuid of this event detail
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventDetail.getUserUuid();
	}

	/**
	* Sets the user uuid of this event detail.
	*
	* @param userUuid the user uuid of this event detail
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_eventDetail.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this event detail.
	*
	* @return the created date of this event detail
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _eventDetail.getCreatedDate();
	}

	/**
	* Sets the created date of this event detail.
	*
	* @param createdDate the created date of this event detail
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_eventDetail.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this event detail.
	*
	* @return the modified date of this event detail
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _eventDetail.getModifiedDate();
	}

	/**
	* Sets the modified date of this event detail.
	*
	* @param modifiedDate the modified date of this event detail
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_eventDetail.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the event ID of this event detail.
	*
	* @return the event ID of this event detail
	*/
	@Override
	public long getEventId() {
		return _eventDetail.getEventId();
	}

	/**
	* Sets the event ID of this event detail.
	*
	* @param eventId the event ID of this event detail
	*/
	@Override
	public void setEventId(long eventId) {
		_eventDetail.setEventId(eventId);
	}

	/**
	* Returns the info type ID of this event detail.
	*
	* @return the info type ID of this event detail
	*/
	@Override
	public long getInfoTypeId() {
		return _eventDetail.getInfoTypeId();
	}

	/**
	* Sets the info type ID of this event detail.
	*
	* @param infoTypeId the info type ID of this event detail
	*/
	@Override
	public void setInfoTypeId(long infoTypeId) {
		_eventDetail.setInfoTypeId(infoTypeId);
	}

	/**
	* Returns the info type category ID of this event detail.
	*
	* @return the info type category ID of this event detail
	*/
	@Override
	public long getInfoTypeCategoryId() {
		return _eventDetail.getInfoTypeCategoryId();
	}

	/**
	* Sets the info type category ID of this event detail.
	*
	* @param infoTypeCategoryId the info type category ID of this event detail
	*/
	@Override
	public void setInfoTypeCategoryId(long infoTypeCategoryId) {
		_eventDetail.setInfoTypeCategoryId(infoTypeCategoryId);
	}

	/**
	* Returns the event detail info name of this event detail.
	*
	* @return the event detail info name of this event detail
	*/
	@Override
	public java.lang.String getEventDetailInfoName() {
		return _eventDetail.getEventDetailInfoName();
	}

	/**
	* Sets the event detail info name of this event detail.
	*
	* @param eventDetailInfoName the event detail info name of this event detail
	*/
	@Override
	public void setEventDetailInfoName(java.lang.String eventDetailInfoName) {
		_eventDetail.setEventDetailInfoName(eventDetailInfoName);
	}

	/**
	* Returns the event detail info desc of this event detail.
	*
	* @return the event detail info desc of this event detail
	*/
	@Override
	public java.lang.String getEventDetailInfoDesc() {
		return _eventDetail.getEventDetailInfoDesc();
	}

	/**
	* Sets the event detail info desc of this event detail.
	*
	* @param eventDetailInfoDesc the event detail info desc of this event detail
	*/
	@Override
	public void setEventDetailInfoDesc(java.lang.String eventDetailInfoDesc) {
		_eventDetail.setEventDetailInfoDesc(eventDetailInfoDesc);
	}

	/**
	* Returns the event detail info comment of this event detail.
	*
	* @return the event detail info comment of this event detail
	*/
	@Override
	public java.lang.String getEventDetailInfoComment() {
		return _eventDetail.getEventDetailInfoComment();
	}

	/**
	* Sets the event detail info comment of this event detail.
	*
	* @param eventDetailInfoComment the event detail info comment of this event detail
	*/
	@Override
	public void setEventDetailInfoComment(
		java.lang.String eventDetailInfoComment) {
		_eventDetail.setEventDetailInfoComment(eventDetailInfoComment);
	}

	/**
	* Returns the event detail address line1 of this event detail.
	*
	* @return the event detail address line1 of this event detail
	*/
	@Override
	public java.lang.String getEventDetailAddressLine1() {
		return _eventDetail.getEventDetailAddressLine1();
	}

	/**
	* Sets the event detail address line1 of this event detail.
	*
	* @param eventDetailAddressLine1 the event detail address line1 of this event detail
	*/
	@Override
	public void setEventDetailAddressLine1(
		java.lang.String eventDetailAddressLine1) {
		_eventDetail.setEventDetailAddressLine1(eventDetailAddressLine1);
	}

	/**
	* Returns the event detail address line2 of this event detail.
	*
	* @return the event detail address line2 of this event detail
	*/
	@Override
	public java.lang.String getEventDetailAddressLine2() {
		return _eventDetail.getEventDetailAddressLine2();
	}

	/**
	* Sets the event detail address line2 of this event detail.
	*
	* @param eventDetailAddressLine2 the event detail address line2 of this event detail
	*/
	@Override
	public void setEventDetailAddressLine2(
		java.lang.String eventDetailAddressLine2) {
		_eventDetail.setEventDetailAddressLine2(eventDetailAddressLine2);
	}

	/**
	* Returns the event detail infocity of this event detail.
	*
	* @return the event detail infocity of this event detail
	*/
	@Override
	public java.lang.String getEventDetailInfocity() {
		return _eventDetail.getEventDetailInfocity();
	}

	/**
	* Sets the event detail infocity of this event detail.
	*
	* @param eventDetailInfocity the event detail infocity of this event detail
	*/
	@Override
	public void setEventDetailInfocity(java.lang.String eventDetailInfocity) {
		_eventDetail.setEventDetailInfocity(eventDetailInfocity);
	}

	/**
	* Returns the event detail zip of this event detail.
	*
	* @return the event detail zip of this event detail
	*/
	@Override
	public java.lang.String getEventDetailZip() {
		return _eventDetail.getEventDetailZip();
	}

	/**
	* Sets the event detail zip of this event detail.
	*
	* @param eventDetailZip the event detail zip of this event detail
	*/
	@Override
	public void setEventDetailZip(java.lang.String eventDetailZip) {
		_eventDetail.setEventDetailZip(eventDetailZip);
	}

	/**
	* Returns the event detail state of this event detail.
	*
	* @return the event detail state of this event detail
	*/
	@Override
	public java.lang.String getEventDetailState() {
		return _eventDetail.getEventDetailState();
	}

	/**
	* Sets the event detail state of this event detail.
	*
	* @param eventDetailState the event detail state of this event detail
	*/
	@Override
	public void setEventDetailState(java.lang.String eventDetailState) {
		_eventDetail.setEventDetailState(eventDetailState);
	}

	/**
	* Returns the event detail country of this event detail.
	*
	* @return the event detail country of this event detail
	*/
	@Override
	public java.lang.String getEventDetailCountry() {
		return _eventDetail.getEventDetailCountry();
	}

	/**
	* Sets the event detail country of this event detail.
	*
	* @param eventDetailCountry the event detail country of this event detail
	*/
	@Override
	public void setEventDetailCountry(java.lang.String eventDetailCountry) {
		_eventDetail.setEventDetailCountry(eventDetailCountry);
	}

	/**
	* Returns the event detail latitude of this event detail.
	*
	* @return the event detail latitude of this event detail
	*/
	@Override
	public java.lang.String getEventDetailLatitude() {
		return _eventDetail.getEventDetailLatitude();
	}

	/**
	* Sets the event detail latitude of this event detail.
	*
	* @param eventDetailLatitude the event detail latitude of this event detail
	*/
	@Override
	public void setEventDetailLatitude(java.lang.String eventDetailLatitude) {
		_eventDetail.setEventDetailLatitude(eventDetailLatitude);
	}

	/**
	* Returns the event detail longitude of this event detail.
	*
	* @return the event detail longitude of this event detail
	*/
	@Override
	public java.lang.String getEventDetailLongitude() {
		return _eventDetail.getEventDetailLongitude();
	}

	/**
	* Sets the event detail longitude of this event detail.
	*
	* @param eventDetailLongitude the event detail longitude of this event detail
	*/
	@Override
	public void setEventDetailLongitude(java.lang.String eventDetailLongitude) {
		_eventDetail.setEventDetailLongitude(eventDetailLongitude);
	}

	/**
	* Returns the event detail phone of this event detail.
	*
	* @return the event detail phone of this event detail
	*/
	@Override
	public java.lang.String getEventDetailPhone() {
		return _eventDetail.getEventDetailPhone();
	}

	/**
	* Sets the event detail phone of this event detail.
	*
	* @param eventDetailPhone the event detail phone of this event detail
	*/
	@Override
	public void setEventDetailPhone(java.lang.String eventDetailPhone) {
		_eventDetail.setEventDetailPhone(eventDetailPhone);
	}

	/**
	* Returns the event detail website of this event detail.
	*
	* @return the event detail website of this event detail
	*/
	@Override
	public java.lang.String getEventDetailWebsite() {
		return _eventDetail.getEventDetailWebsite();
	}

	/**
	* Sets the event detail website of this event detail.
	*
	* @param eventDetailWebsite the event detail website of this event detail
	*/
	@Override
	public void setEventDetailWebsite(java.lang.String eventDetailWebsite) {
		_eventDetail.setEventDetailWebsite(eventDetailWebsite);
	}

	/**
	* Returns the event detail cost of this event detail.
	*
	* @return the event detail cost of this event detail
	*/
	@Override
	public double getEventDetailCost() {
		return _eventDetail.getEventDetailCost();
	}

	/**
	* Sets the event detail cost of this event detail.
	*
	* @param eventDetailCost the event detail cost of this event detail
	*/
	@Override
	public void setEventDetailCost(double eventDetailCost) {
		_eventDetail.setEventDetailCost(eventDetailCost);
	}

	/**
	* Returns the hours of operation of this event detail.
	*
	* @return the hours of operation of this event detail
	*/
	@Override
	public java.lang.String getHoursOfOperation() {
		return _eventDetail.getHoursOfOperation();
	}

	/**
	* Sets the hours of operation of this event detail.
	*
	* @param hoursOfOperation the hours of operation of this event detail
	*/
	@Override
	public void setHoursOfOperation(java.lang.String hoursOfOperation) {
		_eventDetail.setHoursOfOperation(hoursOfOperation);
	}

	@Override
	public boolean isNew() {
		return _eventDetail.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_eventDetail.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _eventDetail.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eventDetail.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _eventDetail.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _eventDetail.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_eventDetail.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _eventDetail.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_eventDetail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_eventDetail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_eventDetail.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EventDetailWrapper((EventDetail)_eventDetail.clone());
	}

	@Override
	public int compareTo(com.rumbasolutions.flask.model.EventDetail eventDetail) {
		return _eventDetail.compareTo(eventDetail);
	}

	@Override
	public int hashCode() {
		return _eventDetail.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.EventDetail> toCacheModel() {
		return _eventDetail.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.EventDetail toEscapedModel() {
		return new EventDetailWrapper(_eventDetail.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.EventDetail toUnescapedModel() {
		return new EventDetailWrapper(_eventDetail.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _eventDetail.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _eventDetail.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_eventDetail.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventDetailWrapper)) {
			return false;
		}

		EventDetailWrapper eventDetailWrapper = (EventDetailWrapper)obj;

		if (Validator.equals(_eventDetail, eventDetailWrapper._eventDetail)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EventDetail getWrappedEventDetail() {
		return _eventDetail;
	}

	@Override
	public EventDetail getWrappedModel() {
		return _eventDetail;
	}

	@Override
	public void resetOriginalValues() {
		_eventDetail.resetOriginalValues();
	}

	private EventDetail _eventDetail;
}