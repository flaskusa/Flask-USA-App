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
		attributes.put("infoTypeName", getInfoTypeName());
		attributes.put("infoTypeCategoryId", getInfoTypeCategoryId());
		attributes.put("infoTypeCategoryName", getInfoTypeCategoryName());
		attributes.put("infoTitle", getInfoTitle());
		attributes.put("infoDesc", getInfoDesc());
		attributes.put("addrLine1", getAddrLine1());
		attributes.put("addrLine2", getAddrLine2());
		attributes.put("city", getCity());
		attributes.put("zipCode", getZipCode());
		attributes.put("stateId", getStateId());
		attributes.put("stateName", getStateName());
		attributes.put("countryId", getCountryId());
		attributes.put("countryName", getCountryName());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("phone", getPhone());
		attributes.put("website", getWebsite());
		attributes.put("cost", getCost());
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

		String infoTypeName = (String)attributes.get("infoTypeName");

		if (infoTypeName != null) {
			setInfoTypeName(infoTypeName);
		}

		Long infoTypeCategoryId = (Long)attributes.get("infoTypeCategoryId");

		if (infoTypeCategoryId != null) {
			setInfoTypeCategoryId(infoTypeCategoryId);
		}

		String infoTypeCategoryName = (String)attributes.get(
				"infoTypeCategoryName");

		if (infoTypeCategoryName != null) {
			setInfoTypeCategoryName(infoTypeCategoryName);
		}

		String infoTitle = (String)attributes.get("infoTitle");

		if (infoTitle != null) {
			setInfoTitle(infoTitle);
		}

		String infoDesc = (String)attributes.get("infoDesc");

		if (infoDesc != null) {
			setInfoDesc(infoDesc);
		}

		String addrLine1 = (String)attributes.get("addrLine1");

		if (addrLine1 != null) {
			setAddrLine1(addrLine1);
		}

		String addrLine2 = (String)attributes.get("addrLine2");

		if (addrLine2 != null) {
			setAddrLine2(addrLine2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		String stateName = (String)attributes.get("stateName");

		if (stateName != null) {
			setStateName(stateName);
		}

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		String countryName = (String)attributes.get("countryName");

		if (countryName != null) {
			setCountryName(countryName);
		}

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}

		Double cost = (Double)attributes.get("cost");

		if (cost != null) {
			setCost(cost);
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
	* Returns the info type name of this event detail.
	*
	* @return the info type name of this event detail
	*/
	@Override
	public java.lang.String getInfoTypeName() {
		return _eventDetail.getInfoTypeName();
	}

	/**
	* Sets the info type name of this event detail.
	*
	* @param infoTypeName the info type name of this event detail
	*/
	@Override
	public void setInfoTypeName(java.lang.String infoTypeName) {
		_eventDetail.setInfoTypeName(infoTypeName);
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
	* Returns the info type category name of this event detail.
	*
	* @return the info type category name of this event detail
	*/
	@Override
	public java.lang.String getInfoTypeCategoryName() {
		return _eventDetail.getInfoTypeCategoryName();
	}

	/**
	* Sets the info type category name of this event detail.
	*
	* @param infoTypeCategoryName the info type category name of this event detail
	*/
	@Override
	public void setInfoTypeCategoryName(java.lang.String infoTypeCategoryName) {
		_eventDetail.setInfoTypeCategoryName(infoTypeCategoryName);
	}

	/**
	* Returns the info title of this event detail.
	*
	* @return the info title of this event detail
	*/
	@Override
	public java.lang.String getInfoTitle() {
		return _eventDetail.getInfoTitle();
	}

	/**
	* Sets the info title of this event detail.
	*
	* @param infoTitle the info title of this event detail
	*/
	@Override
	public void setInfoTitle(java.lang.String infoTitle) {
		_eventDetail.setInfoTitle(infoTitle);
	}

	/**
	* Returns the info desc of this event detail.
	*
	* @return the info desc of this event detail
	*/
	@Override
	public java.lang.String getInfoDesc() {
		return _eventDetail.getInfoDesc();
	}

	/**
	* Sets the info desc of this event detail.
	*
	* @param infoDesc the info desc of this event detail
	*/
	@Override
	public void setInfoDesc(java.lang.String infoDesc) {
		_eventDetail.setInfoDesc(infoDesc);
	}

	/**
	* Returns the addr line1 of this event detail.
	*
	* @return the addr line1 of this event detail
	*/
	@Override
	public java.lang.String getAddrLine1() {
		return _eventDetail.getAddrLine1();
	}

	/**
	* Sets the addr line1 of this event detail.
	*
	* @param addrLine1 the addr line1 of this event detail
	*/
	@Override
	public void setAddrLine1(java.lang.String addrLine1) {
		_eventDetail.setAddrLine1(addrLine1);
	}

	/**
	* Returns the addr line2 of this event detail.
	*
	* @return the addr line2 of this event detail
	*/
	@Override
	public java.lang.String getAddrLine2() {
		return _eventDetail.getAddrLine2();
	}

	/**
	* Sets the addr line2 of this event detail.
	*
	* @param addrLine2 the addr line2 of this event detail
	*/
	@Override
	public void setAddrLine2(java.lang.String addrLine2) {
		_eventDetail.setAddrLine2(addrLine2);
	}

	/**
	* Returns the city of this event detail.
	*
	* @return the city of this event detail
	*/
	@Override
	public java.lang.String getCity() {
		return _eventDetail.getCity();
	}

	/**
	* Sets the city of this event detail.
	*
	* @param city the city of this event detail
	*/
	@Override
	public void setCity(java.lang.String city) {
		_eventDetail.setCity(city);
	}

	/**
	* Returns the zip code of this event detail.
	*
	* @return the zip code of this event detail
	*/
	@Override
	public java.lang.String getZipCode() {
		return _eventDetail.getZipCode();
	}

	/**
	* Sets the zip code of this event detail.
	*
	* @param zipCode the zip code of this event detail
	*/
	@Override
	public void setZipCode(java.lang.String zipCode) {
		_eventDetail.setZipCode(zipCode);
	}

	/**
	* Returns the state ID of this event detail.
	*
	* @return the state ID of this event detail
	*/
	@Override
	public long getStateId() {
		return _eventDetail.getStateId();
	}

	/**
	* Sets the state ID of this event detail.
	*
	* @param stateId the state ID of this event detail
	*/
	@Override
	public void setStateId(long stateId) {
		_eventDetail.setStateId(stateId);
	}

	/**
	* Returns the state name of this event detail.
	*
	* @return the state name of this event detail
	*/
	@Override
	public java.lang.String getStateName() {
		return _eventDetail.getStateName();
	}

	/**
	* Sets the state name of this event detail.
	*
	* @param stateName the state name of this event detail
	*/
	@Override
	public void setStateName(java.lang.String stateName) {
		_eventDetail.setStateName(stateName);
	}

	/**
	* Returns the country ID of this event detail.
	*
	* @return the country ID of this event detail
	*/
	@Override
	public long getCountryId() {
		return _eventDetail.getCountryId();
	}

	/**
	* Sets the country ID of this event detail.
	*
	* @param countryId the country ID of this event detail
	*/
	@Override
	public void setCountryId(long countryId) {
		_eventDetail.setCountryId(countryId);
	}

	/**
	* Returns the country name of this event detail.
	*
	* @return the country name of this event detail
	*/
	@Override
	public java.lang.String getCountryName() {
		return _eventDetail.getCountryName();
	}

	/**
	* Sets the country name of this event detail.
	*
	* @param countryName the country name of this event detail
	*/
	@Override
	public void setCountryName(java.lang.String countryName) {
		_eventDetail.setCountryName(countryName);
	}

	/**
	* Returns the latitude of this event detail.
	*
	* @return the latitude of this event detail
	*/
	@Override
	public java.lang.String getLatitude() {
		return _eventDetail.getLatitude();
	}

	/**
	* Sets the latitude of this event detail.
	*
	* @param latitude the latitude of this event detail
	*/
	@Override
	public void setLatitude(java.lang.String latitude) {
		_eventDetail.setLatitude(latitude);
	}

	/**
	* Returns the longitude of this event detail.
	*
	* @return the longitude of this event detail
	*/
	@Override
	public java.lang.String getLongitude() {
		return _eventDetail.getLongitude();
	}

	/**
	* Sets the longitude of this event detail.
	*
	* @param longitude the longitude of this event detail
	*/
	@Override
	public void setLongitude(java.lang.String longitude) {
		_eventDetail.setLongitude(longitude);
	}

	/**
	* Returns the phone of this event detail.
	*
	* @return the phone of this event detail
	*/
	@Override
	public java.lang.String getPhone() {
		return _eventDetail.getPhone();
	}

	/**
	* Sets the phone of this event detail.
	*
	* @param phone the phone of this event detail
	*/
	@Override
	public void setPhone(java.lang.String phone) {
		_eventDetail.setPhone(phone);
	}

	/**
	* Returns the website of this event detail.
	*
	* @return the website of this event detail
	*/
	@Override
	public java.lang.String getWebsite() {
		return _eventDetail.getWebsite();
	}

	/**
	* Sets the website of this event detail.
	*
	* @param website the website of this event detail
	*/
	@Override
	public void setWebsite(java.lang.String website) {
		_eventDetail.setWebsite(website);
	}

	/**
	* Returns the cost of this event detail.
	*
	* @return the cost of this event detail
	*/
	@Override
	public double getCost() {
		return _eventDetail.getCost();
	}

	/**
	* Sets the cost of this event detail.
	*
	* @param cost the cost of this event detail
	*/
	@Override
	public void setCost(double cost) {
		_eventDetail.setCost(cost);
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