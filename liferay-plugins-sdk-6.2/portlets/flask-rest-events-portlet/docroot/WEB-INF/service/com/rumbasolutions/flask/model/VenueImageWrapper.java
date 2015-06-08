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
 * This class is a wrapper for {@link VenueImage}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueImage
 * @generated
 */
public class VenueImageWrapper implements VenueImage, ModelWrapper<VenueImage> {
	public VenueImageWrapper(VenueImage venueImage) {
		_venueImage = venueImage;
	}

	@Override
	public Class<?> getModelClass() {
		return VenueImage.class;
	}

	@Override
	public String getModelClassName() {
		return VenueImage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("venueImageId", getVenueImageId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("venueImage", getVenueImage());
		attributes.put("venueId", getVenueId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long venueImageId = (Long)attributes.get("venueImageId");

		if (venueImageId != null) {
			setVenueImageId(venueImageId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Blob venueImage = (Blob)attributes.get("venueImage");

		if (venueImage != null) {
			setVenueImage(venueImage);
		}

		Long venueId = (Long)attributes.get("venueId");

		if (venueId != null) {
			setVenueId(venueId);
		}
	}

	/**
	* Returns the primary key of this venue image.
	*
	* @return the primary key of this venue image
	*/
	@Override
	public long getPrimaryKey() {
		return _venueImage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this venue image.
	*
	* @param primaryKey the primary key of this venue image
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_venueImage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the venue image ID of this venue image.
	*
	* @return the venue image ID of this venue image
	*/
	@Override
	public long getVenueImageId() {
		return _venueImage.getVenueImageId();
	}

	/**
	* Sets the venue image ID of this venue image.
	*
	* @param venueImageId the venue image ID of this venue image
	*/
	@Override
	public void setVenueImageId(long venueImageId) {
		_venueImage.setVenueImageId(venueImageId);
	}

	/**
	* Returns the company ID of this venue image.
	*
	* @return the company ID of this venue image
	*/
	@Override
	public long getCompanyId() {
		return _venueImage.getCompanyId();
	}

	/**
	* Sets the company ID of this venue image.
	*
	* @param companyId the company ID of this venue image
	*/
	@Override
	public void setCompanyId(long companyId) {
		_venueImage.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this venue image.
	*
	* @return the user ID of this venue image
	*/
	@Override
	public long getUserId() {
		return _venueImage.getUserId();
	}

	/**
	* Sets the user ID of this venue image.
	*
	* @param userId the user ID of this venue image
	*/
	@Override
	public void setUserId(long userId) {
		_venueImage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this venue image.
	*
	* @return the user uuid of this venue image
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueImage.getUserUuid();
	}

	/**
	* Sets the user uuid of this venue image.
	*
	* @param userUuid the user uuid of this venue image
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_venueImage.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this venue image.
	*
	* @return the created date of this venue image
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _venueImage.getCreatedDate();
	}

	/**
	* Sets the created date of this venue image.
	*
	* @param createdDate the created date of this venue image
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_venueImage.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this venue image.
	*
	* @return the modified date of this venue image
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _venueImage.getModifiedDate();
	}

	/**
	* Sets the modified date of this venue image.
	*
	* @param modifiedDate the modified date of this venue image
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_venueImage.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this venue image.
	*
	* @return the title of this venue image
	*/
	@Override
	public java.lang.String getTitle() {
		return _venueImage.getTitle();
	}

	/**
	* Sets the title of this venue image.
	*
	* @param title the title of this venue image
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_venueImage.setTitle(title);
	}

	/**
	* Returns the venue image of this venue image.
	*
	* @return the venue image of this venue image
	*/
	@Override
	public java.sql.Blob getVenueImage() {
		return _venueImage.getVenueImage();
	}

	/**
	* Sets the venue image of this venue image.
	*
	* @param venueImage the venue image of this venue image
	*/
	@Override
	public void setVenueImage(java.sql.Blob venueImage) {
		_venueImage.setVenueImage(venueImage);
	}

	/**
	* Returns the venue ID of this venue image.
	*
	* @return the venue ID of this venue image
	*/
	@Override
	public long getVenueId() {
		return _venueImage.getVenueId();
	}

	/**
	* Sets the venue ID of this venue image.
	*
	* @param venueId the venue ID of this venue image
	*/
	@Override
	public void setVenueId(long venueId) {
		_venueImage.setVenueId(venueId);
	}

	@Override
	public boolean isNew() {
		return _venueImage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_venueImage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _venueImage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_venueImage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _venueImage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _venueImage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_venueImage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _venueImage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_venueImage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_venueImage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_venueImage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VenueImageWrapper((VenueImage)_venueImage.clone());
	}

	@Override
	public int compareTo(com.rumbasolutions.flask.model.VenueImage venueImage) {
		return _venueImage.compareTo(venueImage);
	}

	@Override
	public int hashCode() {
		return _venueImage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.VenueImage> toCacheModel() {
		return _venueImage.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.VenueImage toEscapedModel() {
		return new VenueImageWrapper(_venueImage.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.VenueImage toUnescapedModel() {
		return new VenueImageWrapper(_venueImage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _venueImage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _venueImage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_venueImage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VenueImageWrapper)) {
			return false;
		}

		VenueImageWrapper venueImageWrapper = (VenueImageWrapper)obj;

		if (Validator.equals(_venueImage, venueImageWrapper._venueImage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VenueImage getWrappedVenueImage() {
		return _venueImage;
	}

	@Override
	public VenueImage getWrappedModel() {
		return _venueImage;
	}

	@Override
	public void resetOriginalValues() {
		_venueImage.resetOriginalValues();
	}

	private VenueImage _venueImage;
}