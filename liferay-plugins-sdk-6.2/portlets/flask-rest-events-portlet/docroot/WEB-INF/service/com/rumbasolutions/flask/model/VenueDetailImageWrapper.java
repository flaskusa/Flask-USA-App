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
 * This class is a wrapper for {@link VenueDetailImage}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueDetailImage
 * @generated
 */
public class VenueDetailImageWrapper implements VenueDetailImage,
	ModelWrapper<VenueDetailImage> {
	public VenueDetailImageWrapper(VenueDetailImage venueDetailImage) {
		_venueDetailImage = venueDetailImage;
	}

	@Override
	public Class<?> getModelClass() {
		return VenueDetailImage.class;
	}

	@Override
	public String getModelClassName() {
		return VenueDetailImage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("venueDetailImageId", getVenueDetailImageId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("venueDetailId", getVenueDetailId());
		attributes.put("venueDetailImageTitle", getVenueDetailImageTitle());
		attributes.put("venueDetailImageDesc", getVenueDetailImageDesc());
		attributes.put("venueDetailImageData", getVenueDetailImageData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long venueDetailImageId = (Long)attributes.get("venueDetailImageId");

		if (venueDetailImageId != null) {
			setVenueDetailImageId(venueDetailImageId);
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

		Long venueDetailId = (Long)attributes.get("venueDetailId");

		if (venueDetailId != null) {
			setVenueDetailId(venueDetailId);
		}

		String venueDetailImageTitle = (String)attributes.get(
				"venueDetailImageTitle");

		if (venueDetailImageTitle != null) {
			setVenueDetailImageTitle(venueDetailImageTitle);
		}

		String venueDetailImageDesc = (String)attributes.get(
				"venueDetailImageDesc");

		if (venueDetailImageDesc != null) {
			setVenueDetailImageDesc(venueDetailImageDesc);
		}

		Blob venueDetailImageData = (Blob)attributes.get("venueDetailImageData");

		if (venueDetailImageData != null) {
			setVenueDetailImageData(venueDetailImageData);
		}
	}

	/**
	* Returns the primary key of this venue detail image.
	*
	* @return the primary key of this venue detail image
	*/
	@Override
	public long getPrimaryKey() {
		return _venueDetailImage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this venue detail image.
	*
	* @param primaryKey the primary key of this venue detail image
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_venueDetailImage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the venue detail image ID of this venue detail image.
	*
	* @return the venue detail image ID of this venue detail image
	*/
	@Override
	public long getVenueDetailImageId() {
		return _venueDetailImage.getVenueDetailImageId();
	}

	/**
	* Sets the venue detail image ID of this venue detail image.
	*
	* @param venueDetailImageId the venue detail image ID of this venue detail image
	*/
	@Override
	public void setVenueDetailImageId(long venueDetailImageId) {
		_venueDetailImage.setVenueDetailImageId(venueDetailImageId);
	}

	/**
	* Returns the company ID of this venue detail image.
	*
	* @return the company ID of this venue detail image
	*/
	@Override
	public long getCompanyId() {
		return _venueDetailImage.getCompanyId();
	}

	/**
	* Sets the company ID of this venue detail image.
	*
	* @param companyId the company ID of this venue detail image
	*/
	@Override
	public void setCompanyId(long companyId) {
		_venueDetailImage.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this venue detail image.
	*
	* @return the user ID of this venue detail image
	*/
	@Override
	public long getUserId() {
		return _venueDetailImage.getUserId();
	}

	/**
	* Sets the user ID of this venue detail image.
	*
	* @param userId the user ID of this venue detail image
	*/
	@Override
	public void setUserId(long userId) {
		_venueDetailImage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this venue detail image.
	*
	* @return the user uuid of this venue detail image
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDetailImage.getUserUuid();
	}

	/**
	* Sets the user uuid of this venue detail image.
	*
	* @param userUuid the user uuid of this venue detail image
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_venueDetailImage.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this venue detail image.
	*
	* @return the created date of this venue detail image
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _venueDetailImage.getCreatedDate();
	}

	/**
	* Sets the created date of this venue detail image.
	*
	* @param createdDate the created date of this venue detail image
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_venueDetailImage.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this venue detail image.
	*
	* @return the modified date of this venue detail image
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _venueDetailImage.getModifiedDate();
	}

	/**
	* Sets the modified date of this venue detail image.
	*
	* @param modifiedDate the modified date of this venue detail image
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_venueDetailImage.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the venue detail ID of this venue detail image.
	*
	* @return the venue detail ID of this venue detail image
	*/
	@Override
	public long getVenueDetailId() {
		return _venueDetailImage.getVenueDetailId();
	}

	/**
	* Sets the venue detail ID of this venue detail image.
	*
	* @param venueDetailId the venue detail ID of this venue detail image
	*/
	@Override
	public void setVenueDetailId(long venueDetailId) {
		_venueDetailImage.setVenueDetailId(venueDetailId);
	}

	/**
	* Returns the venue detail image title of this venue detail image.
	*
	* @return the venue detail image title of this venue detail image
	*/
	@Override
	public java.lang.String getVenueDetailImageTitle() {
		return _venueDetailImage.getVenueDetailImageTitle();
	}

	/**
	* Sets the venue detail image title of this venue detail image.
	*
	* @param venueDetailImageTitle the venue detail image title of this venue detail image
	*/
	@Override
	public void setVenueDetailImageTitle(java.lang.String venueDetailImageTitle) {
		_venueDetailImage.setVenueDetailImageTitle(venueDetailImageTitle);
	}

	/**
	* Returns the venue detail image desc of this venue detail image.
	*
	* @return the venue detail image desc of this venue detail image
	*/
	@Override
	public java.lang.String getVenueDetailImageDesc() {
		return _venueDetailImage.getVenueDetailImageDesc();
	}

	/**
	* Sets the venue detail image desc of this venue detail image.
	*
	* @param venueDetailImageDesc the venue detail image desc of this venue detail image
	*/
	@Override
	public void setVenueDetailImageDesc(java.lang.String venueDetailImageDesc) {
		_venueDetailImage.setVenueDetailImageDesc(venueDetailImageDesc);
	}

	/**
	* Returns the venue detail image data of this venue detail image.
	*
	* @return the venue detail image data of this venue detail image
	*/
	@Override
	public java.sql.Blob getVenueDetailImageData() {
		return _venueDetailImage.getVenueDetailImageData();
	}

	/**
	* Sets the venue detail image data of this venue detail image.
	*
	* @param venueDetailImageData the venue detail image data of this venue detail image
	*/
	@Override
	public void setVenueDetailImageData(java.sql.Blob venueDetailImageData) {
		_venueDetailImage.setVenueDetailImageData(venueDetailImageData);
	}

	@Override
	public boolean isNew() {
		return _venueDetailImage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_venueDetailImage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _venueDetailImage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_venueDetailImage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _venueDetailImage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _venueDetailImage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_venueDetailImage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _venueDetailImage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_venueDetailImage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_venueDetailImage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_venueDetailImage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VenueDetailImageWrapper((VenueDetailImage)_venueDetailImage.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.VenueDetailImage venueDetailImage) {
		return _venueDetailImage.compareTo(venueDetailImage);
	}

	@Override
	public int hashCode() {
		return _venueDetailImage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.VenueDetailImage> toCacheModel() {
		return _venueDetailImage.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDetailImage toEscapedModel() {
		return new VenueDetailImageWrapper(_venueDetailImage.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDetailImage toUnescapedModel() {
		return new VenueDetailImageWrapper(_venueDetailImage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _venueDetailImage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _venueDetailImage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_venueDetailImage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VenueDetailImageWrapper)) {
			return false;
		}

		VenueDetailImageWrapper venueDetailImageWrapper = (VenueDetailImageWrapper)obj;

		if (Validator.equals(_venueDetailImage,
					venueDetailImageWrapper._venueDetailImage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VenueDetailImage getWrappedVenueDetailImage() {
		return _venueDetailImage;
	}

	@Override
	public VenueDetailImage getWrappedModel() {
		return _venueDetailImage;
	}

	@Override
	public void resetOriginalValues() {
		_venueDetailImage.resetOriginalValues();
	}

	private VenueDetailImage _venueDetailImage;
}