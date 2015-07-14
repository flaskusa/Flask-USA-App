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
 * This class is a wrapper for {@link VenueDetail}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueDetail
 * @generated
 */
public class VenueDetailWrapper implements VenueDetail,
	ModelWrapper<VenueDetail> {
	public VenueDetailWrapper(VenueDetail venueDetail) {
		_venueDetail = venueDetail;
	}

	@Override
	public Class<?> getModelClass() {
		return VenueDetail.class;
	}

	@Override
	public String getModelClassName() {
		return VenueDetail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("venueDetailId", getVenueDetailId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("venueId", getVenueId());
		attributes.put("infoTypeId", getInfoTypeId());
		attributes.put("infoTypeName", getInfoTypeName());
		attributes.put("infoTypeCategoryId", getInfoTypeCategoryId());
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
		Long venueDetailId = (Long)attributes.get("venueDetailId");

		if (venueDetailId != null) {
			setVenueDetailId(venueDetailId);
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

		Long venueId = (Long)attributes.get("venueId");

		if (venueId != null) {
			setVenueId(venueId);
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
	* Returns the primary key of this venue detail.
	*
	* @return the primary key of this venue detail
	*/
	@Override
	public long getPrimaryKey() {
		return _venueDetail.getPrimaryKey();
	}

	/**
	* Sets the primary key of this venue detail.
	*
	* @param primaryKey the primary key of this venue detail
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_venueDetail.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the venue detail ID of this venue detail.
	*
	* @return the venue detail ID of this venue detail
	*/
	@Override
	public long getVenueDetailId() {
		return _venueDetail.getVenueDetailId();
	}

	/**
	* Sets the venue detail ID of this venue detail.
	*
	* @param venueDetailId the venue detail ID of this venue detail
	*/
	@Override
	public void setVenueDetailId(long venueDetailId) {
		_venueDetail.setVenueDetailId(venueDetailId);
	}

	/**
	* Returns the company ID of this venue detail.
	*
	* @return the company ID of this venue detail
	*/
	@Override
	public long getCompanyId() {
		return _venueDetail.getCompanyId();
	}

	/**
	* Sets the company ID of this venue detail.
	*
	* @param companyId the company ID of this venue detail
	*/
	@Override
	public void setCompanyId(long companyId) {
		_venueDetail.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this venue detail.
	*
	* @return the user ID of this venue detail
	*/
	@Override
	public long getUserId() {
		return _venueDetail.getUserId();
	}

	/**
	* Sets the user ID of this venue detail.
	*
	* @param userId the user ID of this venue detail
	*/
	@Override
	public void setUserId(long userId) {
		_venueDetail.setUserId(userId);
	}

	/**
	* Returns the user uuid of this venue detail.
	*
	* @return the user uuid of this venue detail
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDetail.getUserUuid();
	}

	/**
	* Sets the user uuid of this venue detail.
	*
	* @param userUuid the user uuid of this venue detail
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_venueDetail.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this venue detail.
	*
	* @return the created date of this venue detail
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _venueDetail.getCreatedDate();
	}

	/**
	* Sets the created date of this venue detail.
	*
	* @param createdDate the created date of this venue detail
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_venueDetail.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this venue detail.
	*
	* @return the modified date of this venue detail
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _venueDetail.getModifiedDate();
	}

	/**
	* Sets the modified date of this venue detail.
	*
	* @param modifiedDate the modified date of this venue detail
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_venueDetail.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the venue ID of this venue detail.
	*
	* @return the venue ID of this venue detail
	*/
	@Override
	public long getVenueId() {
		return _venueDetail.getVenueId();
	}

	/**
	* Sets the venue ID of this venue detail.
	*
	* @param venueId the venue ID of this venue detail
	*/
	@Override
	public void setVenueId(long venueId) {
		_venueDetail.setVenueId(venueId);
	}

	/**
	* Returns the info type ID of this venue detail.
	*
	* @return the info type ID of this venue detail
	*/
	@Override
	public long getInfoTypeId() {
		return _venueDetail.getInfoTypeId();
	}

	/**
	* Sets the info type ID of this venue detail.
	*
	* @param infoTypeId the info type ID of this venue detail
	*/
	@Override
	public void setInfoTypeId(long infoTypeId) {
		_venueDetail.setInfoTypeId(infoTypeId);
	}

	/**
	* Returns the info type name of this venue detail.
	*
	* @return the info type name of this venue detail
	*/
	@Override
	public java.lang.String getInfoTypeName() {
		return _venueDetail.getInfoTypeName();
	}

	/**
	* Sets the info type name of this venue detail.
	*
	* @param infoTypeName the info type name of this venue detail
	*/
	@Override
	public void setInfoTypeName(java.lang.String infoTypeName) {
		_venueDetail.setInfoTypeName(infoTypeName);
	}

	/**
	* Returns the info type category ID of this venue detail.
	*
	* @return the info type category ID of this venue detail
	*/
	@Override
	public long getInfoTypeCategoryId() {
		return _venueDetail.getInfoTypeCategoryId();
	}

	/**
	* Sets the info type category ID of this venue detail.
	*
	* @param infoTypeCategoryId the info type category ID of this venue detail
	*/
	@Override
	public void setInfoTypeCategoryId(long infoTypeCategoryId) {
		_venueDetail.setInfoTypeCategoryId(infoTypeCategoryId);
	}

	/**
	* Returns the info title of this venue detail.
	*
	* @return the info title of this venue detail
	*/
	@Override
	public java.lang.String getInfoTitle() {
		return _venueDetail.getInfoTitle();
	}

	/**
	* Sets the info title of this venue detail.
	*
	* @param infoTitle the info title of this venue detail
	*/
	@Override
	public void setInfoTitle(java.lang.String infoTitle) {
		_venueDetail.setInfoTitle(infoTitle);
	}

	/**
	* Returns the info desc of this venue detail.
	*
	* @return the info desc of this venue detail
	*/
	@Override
	public java.lang.String getInfoDesc() {
		return _venueDetail.getInfoDesc();
	}

	/**
	* Sets the info desc of this venue detail.
	*
	* @param infoDesc the info desc of this venue detail
	*/
	@Override
	public void setInfoDesc(java.lang.String infoDesc) {
		_venueDetail.setInfoDesc(infoDesc);
	}

	/**
	* Returns the addr line1 of this venue detail.
	*
	* @return the addr line1 of this venue detail
	*/
	@Override
	public java.lang.String getAddrLine1() {
		return _venueDetail.getAddrLine1();
	}

	/**
	* Sets the addr line1 of this venue detail.
	*
	* @param addrLine1 the addr line1 of this venue detail
	*/
	@Override
	public void setAddrLine1(java.lang.String addrLine1) {
		_venueDetail.setAddrLine1(addrLine1);
	}

	/**
	* Returns the addr line2 of this venue detail.
	*
	* @return the addr line2 of this venue detail
	*/
	@Override
	public java.lang.String getAddrLine2() {
		return _venueDetail.getAddrLine2();
	}

	/**
	* Sets the addr line2 of this venue detail.
	*
	* @param addrLine2 the addr line2 of this venue detail
	*/
	@Override
	public void setAddrLine2(java.lang.String addrLine2) {
		_venueDetail.setAddrLine2(addrLine2);
	}

	/**
	* Returns the city of this venue detail.
	*
	* @return the city of this venue detail
	*/
	@Override
	public java.lang.String getCity() {
		return _venueDetail.getCity();
	}

	/**
	* Sets the city of this venue detail.
	*
	* @param city the city of this venue detail
	*/
	@Override
	public void setCity(java.lang.String city) {
		_venueDetail.setCity(city);
	}

	/**
	* Returns the zip code of this venue detail.
	*
	* @return the zip code of this venue detail
	*/
	@Override
	public java.lang.String getZipCode() {
		return _venueDetail.getZipCode();
	}

	/**
	* Sets the zip code of this venue detail.
	*
	* @param zipCode the zip code of this venue detail
	*/
	@Override
	public void setZipCode(java.lang.String zipCode) {
		_venueDetail.setZipCode(zipCode);
	}

	/**
	* Returns the state ID of this venue detail.
	*
	* @return the state ID of this venue detail
	*/
	@Override
	public long getStateId() {
		return _venueDetail.getStateId();
	}

	/**
	* Sets the state ID of this venue detail.
	*
	* @param stateId the state ID of this venue detail
	*/
	@Override
	public void setStateId(long stateId) {
		_venueDetail.setStateId(stateId);
	}

	/**
	* Returns the state name of this venue detail.
	*
	* @return the state name of this venue detail
	*/
	@Override
	public java.lang.String getStateName() {
		return _venueDetail.getStateName();
	}

	/**
	* Sets the state name of this venue detail.
	*
	* @param stateName the state name of this venue detail
	*/
	@Override
	public void setStateName(java.lang.String stateName) {
		_venueDetail.setStateName(stateName);
	}

	/**
	* Returns the country ID of this venue detail.
	*
	* @return the country ID of this venue detail
	*/
	@Override
	public long getCountryId() {
		return _venueDetail.getCountryId();
	}

	/**
	* Sets the country ID of this venue detail.
	*
	* @param countryId the country ID of this venue detail
	*/
	@Override
	public void setCountryId(long countryId) {
		_venueDetail.setCountryId(countryId);
	}

	/**
	* Returns the country name of this venue detail.
	*
	* @return the country name of this venue detail
	*/
	@Override
	public java.lang.String getCountryName() {
		return _venueDetail.getCountryName();
	}

	/**
	* Sets the country name of this venue detail.
	*
	* @param countryName the country name of this venue detail
	*/
	@Override
	public void setCountryName(java.lang.String countryName) {
		_venueDetail.setCountryName(countryName);
	}

	/**
	* Returns the latitude of this venue detail.
	*
	* @return the latitude of this venue detail
	*/
	@Override
	public java.lang.String getLatitude() {
		return _venueDetail.getLatitude();
	}

	/**
	* Sets the latitude of this venue detail.
	*
	* @param latitude the latitude of this venue detail
	*/
	@Override
	public void setLatitude(java.lang.String latitude) {
		_venueDetail.setLatitude(latitude);
	}

	/**
	* Returns the longitude of this venue detail.
	*
	* @return the longitude of this venue detail
	*/
	@Override
	public java.lang.String getLongitude() {
		return _venueDetail.getLongitude();
	}

	/**
	* Sets the longitude of this venue detail.
	*
	* @param longitude the longitude of this venue detail
	*/
	@Override
	public void setLongitude(java.lang.String longitude) {
		_venueDetail.setLongitude(longitude);
	}

	/**
	* Returns the phone of this venue detail.
	*
	* @return the phone of this venue detail
	*/
	@Override
	public java.lang.String getPhone() {
		return _venueDetail.getPhone();
	}

	/**
	* Sets the phone of this venue detail.
	*
	* @param phone the phone of this venue detail
	*/
	@Override
	public void setPhone(java.lang.String phone) {
		_venueDetail.setPhone(phone);
	}

	/**
	* Returns the website of this venue detail.
	*
	* @return the website of this venue detail
	*/
	@Override
	public java.lang.String getWebsite() {
		return _venueDetail.getWebsite();
	}

	/**
	* Sets the website of this venue detail.
	*
	* @param website the website of this venue detail
	*/
	@Override
	public void setWebsite(java.lang.String website) {
		_venueDetail.setWebsite(website);
	}

	/**
	* Returns the cost of this venue detail.
	*
	* @return the cost of this venue detail
	*/
	@Override
	public double getCost() {
		return _venueDetail.getCost();
	}

	/**
	* Sets the cost of this venue detail.
	*
	* @param cost the cost of this venue detail
	*/
	@Override
	public void setCost(double cost) {
		_venueDetail.setCost(cost);
	}

	/**
	* Returns the hours of operation of this venue detail.
	*
	* @return the hours of operation of this venue detail
	*/
	@Override
	public java.lang.String getHoursOfOperation() {
		return _venueDetail.getHoursOfOperation();
	}

	/**
	* Sets the hours of operation of this venue detail.
	*
	* @param hoursOfOperation the hours of operation of this venue detail
	*/
	@Override
	public void setHoursOfOperation(java.lang.String hoursOfOperation) {
		_venueDetail.setHoursOfOperation(hoursOfOperation);
	}

	@Override
	public boolean isNew() {
		return _venueDetail.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_venueDetail.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _venueDetail.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_venueDetail.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _venueDetail.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _venueDetail.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_venueDetail.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _venueDetail.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_venueDetail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_venueDetail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_venueDetail.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VenueDetailWrapper((VenueDetail)_venueDetail.clone());
	}

	@Override
	public int compareTo(com.rumbasolutions.flask.model.VenueDetail venueDetail) {
		return _venueDetail.compareTo(venueDetail);
	}

	@Override
	public int hashCode() {
		return _venueDetail.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.VenueDetail> toCacheModel() {
		return _venueDetail.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDetail toEscapedModel() {
		return new VenueDetailWrapper(_venueDetail.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDetail toUnescapedModel() {
		return new VenueDetailWrapper(_venueDetail.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _venueDetail.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _venueDetail.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_venueDetail.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VenueDetailWrapper)) {
			return false;
		}

		VenueDetailWrapper venueDetailWrapper = (VenueDetailWrapper)obj;

		if (Validator.equals(_venueDetail, venueDetailWrapper._venueDetail)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VenueDetail getWrappedVenueDetail() {
		return _venueDetail;
	}

	@Override
	public VenueDetail getWrappedModel() {
		return _venueDetail;
	}

	@Override
	public void resetOriginalValues() {
		_venueDetail.resetOriginalValues();
	}

	private VenueDetail _venueDetail;
}