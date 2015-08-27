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
 * This class is a wrapper for {@link TailgateImages}.
 * </p>
 *
 * @author rajeshj
 * @see TailgateImages
 * @generated
 */
public class TailgateImagesWrapper implements TailgateImages,
	ModelWrapper<TailgateImages> {
	public TailgateImagesWrapper(TailgateImages tailgateImages) {
		_tailgateImages = tailgateImages;
	}

	@Override
	public Class<?> getModelClass() {
		return TailgateImages.class;
	}

	@Override
	public String getModelClassName() {
		return TailgateImages.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tailgateImageId", getTailgateImageId());
		attributes.put("tailgateId", getTailgateId());
		attributes.put("userId", getUserId());
		attributes.put("imageTitle", getImageTitle());
		attributes.put("imageDesc", getImageDesc());
		attributes.put("imageUUID", getImageUUID());
		attributes.put("imageGroupId", getImageGroupId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tailgateImageId = (Long)attributes.get("tailgateImageId");

		if (tailgateImageId != null) {
			setTailgateImageId(tailgateImageId);
		}

		Long tailgateId = (Long)attributes.get("tailgateId");

		if (tailgateId != null) {
			setTailgateId(tailgateId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String imageTitle = (String)attributes.get("imageTitle");

		if (imageTitle != null) {
			setImageTitle(imageTitle);
		}

		String imageDesc = (String)attributes.get("imageDesc");

		if (imageDesc != null) {
			setImageDesc(imageDesc);
		}

		String imageUUID = (String)attributes.get("imageUUID");

		if (imageUUID != null) {
			setImageUUID(imageUUID);
		}

		Long imageGroupId = (Long)attributes.get("imageGroupId");

		if (imageGroupId != null) {
			setImageGroupId(imageGroupId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this tailgate images.
	*
	* @return the primary key of this tailgate images
	*/
	@Override
	public long getPrimaryKey() {
		return _tailgateImages.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tailgate images.
	*
	* @param primaryKey the primary key of this tailgate images
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tailgateImages.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tailgate image ID of this tailgate images.
	*
	* @return the tailgate image ID of this tailgate images
	*/
	@Override
	public long getTailgateImageId() {
		return _tailgateImages.getTailgateImageId();
	}

	/**
	* Sets the tailgate image ID of this tailgate images.
	*
	* @param tailgateImageId the tailgate image ID of this tailgate images
	*/
	@Override
	public void setTailgateImageId(long tailgateImageId) {
		_tailgateImages.setTailgateImageId(tailgateImageId);
	}

	/**
	* Returns the tailgate ID of this tailgate images.
	*
	* @return the tailgate ID of this tailgate images
	*/
	@Override
	public long getTailgateId() {
		return _tailgateImages.getTailgateId();
	}

	/**
	* Sets the tailgate ID of this tailgate images.
	*
	* @param tailgateId the tailgate ID of this tailgate images
	*/
	@Override
	public void setTailgateId(long tailgateId) {
		_tailgateImages.setTailgateId(tailgateId);
	}

	/**
	* Returns the user ID of this tailgate images.
	*
	* @return the user ID of this tailgate images
	*/
	@Override
	public long getUserId() {
		return _tailgateImages.getUserId();
	}

	/**
	* Sets the user ID of this tailgate images.
	*
	* @param userId the user ID of this tailgate images
	*/
	@Override
	public void setUserId(long userId) {
		_tailgateImages.setUserId(userId);
	}

	/**
	* Returns the user uuid of this tailgate images.
	*
	* @return the user uuid of this tailgate images
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateImages.getUserUuid();
	}

	/**
	* Sets the user uuid of this tailgate images.
	*
	* @param userUuid the user uuid of this tailgate images
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tailgateImages.setUserUuid(userUuid);
	}

	/**
	* Returns the image title of this tailgate images.
	*
	* @return the image title of this tailgate images
	*/
	@Override
	public java.lang.String getImageTitle() {
		return _tailgateImages.getImageTitle();
	}

	/**
	* Sets the image title of this tailgate images.
	*
	* @param imageTitle the image title of this tailgate images
	*/
	@Override
	public void setImageTitle(java.lang.String imageTitle) {
		_tailgateImages.setImageTitle(imageTitle);
	}

	/**
	* Returns the image desc of this tailgate images.
	*
	* @return the image desc of this tailgate images
	*/
	@Override
	public java.lang.String getImageDesc() {
		return _tailgateImages.getImageDesc();
	}

	/**
	* Sets the image desc of this tailgate images.
	*
	* @param imageDesc the image desc of this tailgate images
	*/
	@Override
	public void setImageDesc(java.lang.String imageDesc) {
		_tailgateImages.setImageDesc(imageDesc);
	}

	/**
	* Returns the image u u i d of this tailgate images.
	*
	* @return the image u u i d of this tailgate images
	*/
	@Override
	public java.lang.String getImageUUID() {
		return _tailgateImages.getImageUUID();
	}

	/**
	* Sets the image u u i d of this tailgate images.
	*
	* @param imageUUID the image u u i d of this tailgate images
	*/
	@Override
	public void setImageUUID(java.lang.String imageUUID) {
		_tailgateImages.setImageUUID(imageUUID);
	}

	/**
	* Returns the image group ID of this tailgate images.
	*
	* @return the image group ID of this tailgate images
	*/
	@Override
	public long getImageGroupId() {
		return _tailgateImages.getImageGroupId();
	}

	/**
	* Sets the image group ID of this tailgate images.
	*
	* @param imageGroupId the image group ID of this tailgate images
	*/
	@Override
	public void setImageGroupId(long imageGroupId) {
		_tailgateImages.setImageGroupId(imageGroupId);
	}

	/**
	* Returns the created date of this tailgate images.
	*
	* @return the created date of this tailgate images
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _tailgateImages.getCreatedDate();
	}

	/**
	* Sets the created date of this tailgate images.
	*
	* @param createdDate the created date of this tailgate images
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_tailgateImages.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this tailgate images.
	*
	* @return the modified date of this tailgate images
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _tailgateImages.getModifiedDate();
	}

	/**
	* Sets the modified date of this tailgate images.
	*
	* @param modifiedDate the modified date of this tailgate images
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tailgateImages.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _tailgateImages.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tailgateImages.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tailgateImages.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tailgateImages.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tailgateImages.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tailgateImages.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tailgateImages.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tailgateImages.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tailgateImages.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tailgateImages.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tailgateImages.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TailgateImagesWrapper((TailgateImages)_tailgateImages.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.TailgateImages tailgateImages) {
		return _tailgateImages.compareTo(tailgateImages);
	}

	@Override
	public int hashCode() {
		return _tailgateImages.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.TailgateImages> toCacheModel() {
		return _tailgateImages.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateImages toEscapedModel() {
		return new TailgateImagesWrapper(_tailgateImages.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateImages toUnescapedModel() {
		return new TailgateImagesWrapper(_tailgateImages.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tailgateImages.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tailgateImages.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tailgateImages.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TailgateImagesWrapper)) {
			return false;
		}

		TailgateImagesWrapper tailgateImagesWrapper = (TailgateImagesWrapper)obj;

		if (Validator.equals(_tailgateImages,
					tailgateImagesWrapper._tailgateImages)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TailgateImages getWrappedTailgateImages() {
		return _tailgateImages;
	}

	@Override
	public TailgateImages getWrappedModel() {
		return _tailgateImages;
	}

	@Override
	public void resetOriginalValues() {
		_tailgateImages.resetOriginalValues();
	}

	private TailgateImages _tailgateImages;
}