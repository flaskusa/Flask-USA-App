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
 * This class is a wrapper for {@link VenueDeviceImage}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueDeviceImage
 * @generated
 */
public class VenueDeviceImageWrapper implements VenueDeviceImage,
	ModelWrapper<VenueDeviceImage> {
	public VenueDeviceImageWrapper(VenueDeviceImage venueDeviceImage) {
		_venueDeviceImage = venueDeviceImage;
	}

	@Override
	public Class<?> getModelClass() {
		return VenueDeviceImage.class;
	}

	@Override
	public String getModelClassName() {
		return VenueDeviceImage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("venueDeviceImageId", getVenueDeviceImageId());
		attributes.put("venueDetailImageId", getVenueDetailImageId());
		attributes.put("venueId", getVenueId());
		attributes.put("deviceType", getDeviceType());
		attributes.put("venueDeviceImageUUID", getVenueDeviceImageUUID());
		attributes.put("aspectRatio", getAspectRatio());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long venueDeviceImageId = (Long)attributes.get("venueDeviceImageId");

		if (venueDeviceImageId != null) {
			setVenueDeviceImageId(venueDeviceImageId);
		}

		Long venueDetailImageId = (Long)attributes.get("venueDetailImageId");

		if (venueDetailImageId != null) {
			setVenueDetailImageId(venueDetailImageId);
		}

		Long venueId = (Long)attributes.get("venueId");

		if (venueId != null) {
			setVenueId(venueId);
		}

		String deviceType = (String)attributes.get("deviceType");

		if (deviceType != null) {
			setDeviceType(deviceType);
		}

		String venueDeviceImageUUID = (String)attributes.get(
				"venueDeviceImageUUID");

		if (venueDeviceImageUUID != null) {
			setVenueDeviceImageUUID(venueDeviceImageUUID);
		}

		String aspectRatio = (String)attributes.get("aspectRatio");

		if (aspectRatio != null) {
			setAspectRatio(aspectRatio);
		}
	}

	/**
	* Returns the primary key of this venue device image.
	*
	* @return the primary key of this venue device image
	*/
	@Override
	public long getPrimaryKey() {
		return _venueDeviceImage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this venue device image.
	*
	* @param primaryKey the primary key of this venue device image
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_venueDeviceImage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the venue device image ID of this venue device image.
	*
	* @return the venue device image ID of this venue device image
	*/
	@Override
	public long getVenueDeviceImageId() {
		return _venueDeviceImage.getVenueDeviceImageId();
	}

	/**
	* Sets the venue device image ID of this venue device image.
	*
	* @param venueDeviceImageId the venue device image ID of this venue device image
	*/
	@Override
	public void setVenueDeviceImageId(long venueDeviceImageId) {
		_venueDeviceImage.setVenueDeviceImageId(venueDeviceImageId);
	}

	/**
	* Returns the venue detail image ID of this venue device image.
	*
	* @return the venue detail image ID of this venue device image
	*/
	@Override
	public long getVenueDetailImageId() {
		return _venueDeviceImage.getVenueDetailImageId();
	}

	/**
	* Sets the venue detail image ID of this venue device image.
	*
	* @param venueDetailImageId the venue detail image ID of this venue device image
	*/
	@Override
	public void setVenueDetailImageId(long venueDetailImageId) {
		_venueDeviceImage.setVenueDetailImageId(venueDetailImageId);
	}

	/**
	* Returns the venue ID of this venue device image.
	*
	* @return the venue ID of this venue device image
	*/
	@Override
	public long getVenueId() {
		return _venueDeviceImage.getVenueId();
	}

	/**
	* Sets the venue ID of this venue device image.
	*
	* @param venueId the venue ID of this venue device image
	*/
	@Override
	public void setVenueId(long venueId) {
		_venueDeviceImage.setVenueId(venueId);
	}

	/**
	* Returns the device type of this venue device image.
	*
	* @return the device type of this venue device image
	*/
	@Override
	public java.lang.String getDeviceType() {
		return _venueDeviceImage.getDeviceType();
	}

	/**
	* Sets the device type of this venue device image.
	*
	* @param deviceType the device type of this venue device image
	*/
	@Override
	public void setDeviceType(java.lang.String deviceType) {
		_venueDeviceImage.setDeviceType(deviceType);
	}

	/**
	* Returns the venue device image u u i d of this venue device image.
	*
	* @return the venue device image u u i d of this venue device image
	*/
	@Override
	public java.lang.String getVenueDeviceImageUUID() {
		return _venueDeviceImage.getVenueDeviceImageUUID();
	}

	/**
	* Sets the venue device image u u i d of this venue device image.
	*
	* @param venueDeviceImageUUID the venue device image u u i d of this venue device image
	*/
	@Override
	public void setVenueDeviceImageUUID(java.lang.String venueDeviceImageUUID) {
		_venueDeviceImage.setVenueDeviceImageUUID(venueDeviceImageUUID);
	}

	/**
	* Returns the aspect ratio of this venue device image.
	*
	* @return the aspect ratio of this venue device image
	*/
	@Override
	public java.lang.String getAspectRatio() {
		return _venueDeviceImage.getAspectRatio();
	}

	/**
	* Sets the aspect ratio of this venue device image.
	*
	* @param aspectRatio the aspect ratio of this venue device image
	*/
	@Override
	public void setAspectRatio(java.lang.String aspectRatio) {
		_venueDeviceImage.setAspectRatio(aspectRatio);
	}

	@Override
	public boolean isNew() {
		return _venueDeviceImage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_venueDeviceImage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _venueDeviceImage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_venueDeviceImage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _venueDeviceImage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _venueDeviceImage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_venueDeviceImage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _venueDeviceImage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_venueDeviceImage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_venueDeviceImage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_venueDeviceImage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VenueDeviceImageWrapper((VenueDeviceImage)_venueDeviceImage.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.VenueDeviceImage venueDeviceImage) {
		return _venueDeviceImage.compareTo(venueDeviceImage);
	}

	@Override
	public int hashCode() {
		return _venueDeviceImage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.VenueDeviceImage> toCacheModel() {
		return _venueDeviceImage.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDeviceImage toEscapedModel() {
		return new VenueDeviceImageWrapper(_venueDeviceImage.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDeviceImage toUnescapedModel() {
		return new VenueDeviceImageWrapper(_venueDeviceImage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _venueDeviceImage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _venueDeviceImage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_venueDeviceImage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VenueDeviceImageWrapper)) {
			return false;
		}

		VenueDeviceImageWrapper venueDeviceImageWrapper = (VenueDeviceImageWrapper)obj;

		if (Validator.equals(_venueDeviceImage,
					venueDeviceImageWrapper._venueDeviceImage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VenueDeviceImage getWrappedVenueDeviceImage() {
		return _venueDeviceImage;
	}

	@Override
	public VenueDeviceImage getWrappedModel() {
		return _venueDeviceImage;
	}

	@Override
	public void resetOriginalValues() {
		_venueDeviceImage.resetOriginalValues();
	}

	private VenueDeviceImage _venueDeviceImage;
}