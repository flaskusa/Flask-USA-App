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
		attributes.put("infoTypeCategoryId", getInfoTypeCategoryId());
		attributes.put("venueDetailInfoName", getVenueDetailInfoName());
		attributes.put("venueDetailInfoDesc", getVenueDetailInfoDesc());
		attributes.put("venueDetailInfoComment", getVenueDetailInfoComment());
		attributes.put("venueDetailAddressLine1", getVenueDetailAddressLine1());
		attributes.put("venueDetailAddressLine2", getVenueDetailAddressLine2());
		attributes.put("venueDetailCity", getVenueDetailCity());
		attributes.put("venueDetailState", getVenueDetailState());
		attributes.put("venueDetailCountry", getVenueDetailCountry());
		attributes.put("venueDetailLatitude", getVenueDetailLatitude());
		attributes.put("venueDetailLongitude", getVenueDetailLongitude());
		attributes.put("venueDetailPhone", getVenueDetailPhone());
		attributes.put("venueDetailWebsite", getVenueDetailWebsite());
		attributes.put("venueDetailCost", getVenueDetailCost());
		attributes.put("venueDetailhoursOfOperation",
			getVenueDetailhoursOfOperation());

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

		Long infoTypeCategoryId = (Long)attributes.get("infoTypeCategoryId");

		if (infoTypeCategoryId != null) {
			setInfoTypeCategoryId(infoTypeCategoryId);
		}

		String venueDetailInfoName = (String)attributes.get(
				"venueDetailInfoName");

		if (venueDetailInfoName != null) {
			setVenueDetailInfoName(venueDetailInfoName);
		}

		String venueDetailInfoDesc = (String)attributes.get(
				"venueDetailInfoDesc");

		if (venueDetailInfoDesc != null) {
			setVenueDetailInfoDesc(venueDetailInfoDesc);
		}

		String venueDetailInfoComment = (String)attributes.get(
				"venueDetailInfoComment");

		if (venueDetailInfoComment != null) {
			setVenueDetailInfoComment(venueDetailInfoComment);
		}

		String venueDetailAddressLine1 = (String)attributes.get(
				"venueDetailAddressLine1");

		if (venueDetailAddressLine1 != null) {
			setVenueDetailAddressLine1(venueDetailAddressLine1);
		}

		String venueDetailAddressLine2 = (String)attributes.get(
				"venueDetailAddressLine2");

		if (venueDetailAddressLine2 != null) {
			setVenueDetailAddressLine2(venueDetailAddressLine2);
		}

		String venueDetailCity = (String)attributes.get("venueDetailCity");

		if (venueDetailCity != null) {
			setVenueDetailCity(venueDetailCity);
		}

		String venueDetailState = (String)attributes.get("venueDetailState");

		if (venueDetailState != null) {
			setVenueDetailState(venueDetailState);
		}

		String venueDetailCountry = (String)attributes.get("venueDetailCountry");

		if (venueDetailCountry != null) {
			setVenueDetailCountry(venueDetailCountry);
		}

		String venueDetailLatitude = (String)attributes.get(
				"venueDetailLatitude");

		if (venueDetailLatitude != null) {
			setVenueDetailLatitude(venueDetailLatitude);
		}

		String venueDetailLongitude = (String)attributes.get(
				"venueDetailLongitude");

		if (venueDetailLongitude != null) {
			setVenueDetailLongitude(venueDetailLongitude);
		}

		String venueDetailPhone = (String)attributes.get("venueDetailPhone");

		if (venueDetailPhone != null) {
			setVenueDetailPhone(venueDetailPhone);
		}

		String venueDetailWebsite = (String)attributes.get("venueDetailWebsite");

		if (venueDetailWebsite != null) {
			setVenueDetailWebsite(venueDetailWebsite);
		}

		Double venueDetailCost = (Double)attributes.get("venueDetailCost");

		if (venueDetailCost != null) {
			setVenueDetailCost(venueDetailCost);
		}

		String venueDetailhoursOfOperation = (String)attributes.get(
				"venueDetailhoursOfOperation");

		if (venueDetailhoursOfOperation != null) {
			setVenueDetailhoursOfOperation(venueDetailhoursOfOperation);
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
	* Returns the venue detail info name of this venue detail.
	*
	* @return the venue detail info name of this venue detail
	*/
	@Override
	public java.lang.String getVenueDetailInfoName() {
		return _venueDetail.getVenueDetailInfoName();
	}

	/**
	* Sets the venue detail info name of this venue detail.
	*
	* @param venueDetailInfoName the venue detail info name of this venue detail
	*/
	@Override
	public void setVenueDetailInfoName(java.lang.String venueDetailInfoName) {
		_venueDetail.setVenueDetailInfoName(venueDetailInfoName);
	}

	/**
	* Returns the venue detail info desc of this venue detail.
	*
	* @return the venue detail info desc of this venue detail
	*/
	@Override
	public java.lang.String getVenueDetailInfoDesc() {
		return _venueDetail.getVenueDetailInfoDesc();
	}

	/**
	* Sets the venue detail info desc of this venue detail.
	*
	* @param venueDetailInfoDesc the venue detail info desc of this venue detail
	*/
	@Override
	public void setVenueDetailInfoDesc(java.lang.String venueDetailInfoDesc) {
		_venueDetail.setVenueDetailInfoDesc(venueDetailInfoDesc);
	}

	/**
	* Returns the venue detail info comment of this venue detail.
	*
	* @return the venue detail info comment of this venue detail
	*/
	@Override
	public java.lang.String getVenueDetailInfoComment() {
		return _venueDetail.getVenueDetailInfoComment();
	}

	/**
	* Sets the venue detail info comment of this venue detail.
	*
	* @param venueDetailInfoComment the venue detail info comment of this venue detail
	*/
	@Override
	public void setVenueDetailInfoComment(
		java.lang.String venueDetailInfoComment) {
		_venueDetail.setVenueDetailInfoComment(venueDetailInfoComment);
	}

	/**
	* Returns the venue detail address line1 of this venue detail.
	*
	* @return the venue detail address line1 of this venue detail
	*/
	@Override
	public java.lang.String getVenueDetailAddressLine1() {
		return _venueDetail.getVenueDetailAddressLine1();
	}

	/**
	* Sets the venue detail address line1 of this venue detail.
	*
	* @param venueDetailAddressLine1 the venue detail address line1 of this venue detail
	*/
	@Override
	public void setVenueDetailAddressLine1(
		java.lang.String venueDetailAddressLine1) {
		_venueDetail.setVenueDetailAddressLine1(venueDetailAddressLine1);
	}

	/**
	* Returns the venue detail address line2 of this venue detail.
	*
	* @return the venue detail address line2 of this venue detail
	*/
	@Override
	public java.lang.String getVenueDetailAddressLine2() {
		return _venueDetail.getVenueDetailAddressLine2();
	}

	/**
	* Sets the venue detail address line2 of this venue detail.
	*
	* @param venueDetailAddressLine2 the venue detail address line2 of this venue detail
	*/
	@Override
	public void setVenueDetailAddressLine2(
		java.lang.String venueDetailAddressLine2) {
		_venueDetail.setVenueDetailAddressLine2(venueDetailAddressLine2);
	}

	/**
	* Returns the venue detail city of this venue detail.
	*
	* @return the venue detail city of this venue detail
	*/
	@Override
	public java.lang.String getVenueDetailCity() {
		return _venueDetail.getVenueDetailCity();
	}

	/**
	* Sets the venue detail city of this venue detail.
	*
	* @param venueDetailCity the venue detail city of this venue detail
	*/
	@Override
	public void setVenueDetailCity(java.lang.String venueDetailCity) {
		_venueDetail.setVenueDetailCity(venueDetailCity);
	}

	/**
	* Returns the venue detail state of this venue detail.
	*
	* @return the venue detail state of this venue detail
	*/
	@Override
	public java.lang.String getVenueDetailState() {
		return _venueDetail.getVenueDetailState();
	}

	/**
	* Sets the venue detail state of this venue detail.
	*
	* @param venueDetailState the venue detail state of this venue detail
	*/
	@Override
	public void setVenueDetailState(java.lang.String venueDetailState) {
		_venueDetail.setVenueDetailState(venueDetailState);
	}

	/**
	* Returns the venue detail country of this venue detail.
	*
	* @return the venue detail country of this venue detail
	*/
	@Override
	public java.lang.String getVenueDetailCountry() {
		return _venueDetail.getVenueDetailCountry();
	}

	/**
	* Sets the venue detail country of this venue detail.
	*
	* @param venueDetailCountry the venue detail country of this venue detail
	*/
	@Override
	public void setVenueDetailCountry(java.lang.String venueDetailCountry) {
		_venueDetail.setVenueDetailCountry(venueDetailCountry);
	}

	/**
	* Returns the venue detail latitude of this venue detail.
	*
	* @return the venue detail latitude of this venue detail
	*/
	@Override
	public java.lang.String getVenueDetailLatitude() {
		return _venueDetail.getVenueDetailLatitude();
	}

	/**
	* Sets the venue detail latitude of this venue detail.
	*
	* @param venueDetailLatitude the venue detail latitude of this venue detail
	*/
	@Override
	public void setVenueDetailLatitude(java.lang.String venueDetailLatitude) {
		_venueDetail.setVenueDetailLatitude(venueDetailLatitude);
	}

	/**
	* Returns the venue detail longitude of this venue detail.
	*
	* @return the venue detail longitude of this venue detail
	*/
	@Override
	public java.lang.String getVenueDetailLongitude() {
		return _venueDetail.getVenueDetailLongitude();
	}

	/**
	* Sets the venue detail longitude of this venue detail.
	*
	* @param venueDetailLongitude the venue detail longitude of this venue detail
	*/
	@Override
	public void setVenueDetailLongitude(java.lang.String venueDetailLongitude) {
		_venueDetail.setVenueDetailLongitude(venueDetailLongitude);
	}

	/**
	* Returns the venue detail phone of this venue detail.
	*
	* @return the venue detail phone of this venue detail
	*/
	@Override
	public java.lang.String getVenueDetailPhone() {
		return _venueDetail.getVenueDetailPhone();
	}

	/**
	* Sets the venue detail phone of this venue detail.
	*
	* @param venueDetailPhone the venue detail phone of this venue detail
	*/
	@Override
	public void setVenueDetailPhone(java.lang.String venueDetailPhone) {
		_venueDetail.setVenueDetailPhone(venueDetailPhone);
	}

	/**
	* Returns the venue detail website of this venue detail.
	*
	* @return the venue detail website of this venue detail
	*/
	@Override
	public java.lang.String getVenueDetailWebsite() {
		return _venueDetail.getVenueDetailWebsite();
	}

	/**
	* Sets the venue detail website of this venue detail.
	*
	* @param venueDetailWebsite the venue detail website of this venue detail
	*/
	@Override
	public void setVenueDetailWebsite(java.lang.String venueDetailWebsite) {
		_venueDetail.setVenueDetailWebsite(venueDetailWebsite);
	}

	/**
	* Returns the venue detail cost of this venue detail.
	*
	* @return the venue detail cost of this venue detail
	*/
	@Override
	public double getVenueDetailCost() {
		return _venueDetail.getVenueDetailCost();
	}

	/**
	* Sets the venue detail cost of this venue detail.
	*
	* @param venueDetailCost the venue detail cost of this venue detail
	*/
	@Override
	public void setVenueDetailCost(double venueDetailCost) {
		_venueDetail.setVenueDetailCost(venueDetailCost);
	}

	/**
	* Returns the venue detailhours of operation of this venue detail.
	*
	* @return the venue detailhours of operation of this venue detail
	*/
	@Override
	public java.lang.String getVenueDetailhoursOfOperation() {
		return _venueDetail.getVenueDetailhoursOfOperation();
	}

	/**
	* Sets the venue detailhours of operation of this venue detail.
	*
	* @param venueDetailhoursOfOperation the venue detailhours of operation of this venue detail
	*/
	@Override
	public void setVenueDetailhoursOfOperation(
		java.lang.String venueDetailhoursOfOperation) {
		_venueDetail.setVenueDetailhoursOfOperation(venueDetailhoursOfOperation);
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