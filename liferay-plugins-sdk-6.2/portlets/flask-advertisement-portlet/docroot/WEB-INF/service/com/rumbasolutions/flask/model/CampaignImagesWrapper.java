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
 * This class is a wrapper for {@link CampaignImages}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignImages
 * @generated
 */
public class CampaignImagesWrapper implements CampaignImages,
	ModelWrapper<CampaignImages> {
	public CampaignImagesWrapper(CampaignImages campaignImages) {
		_campaignImages = campaignImages;
	}

	@Override
	public Class<?> getModelClass() {
		return CampaignImages.class;
	}

	@Override
	public String getModelClassName() {
		return CampaignImages.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campaignImageId", getCampaignImageId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("imageTitle", getImageTitle());
		attributes.put("imageDesc", getImageDesc());
		attributes.put("imageUUID", getImageUUID());
		attributes.put("imageGroupId", getImageGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long campaignImageId = (Long)attributes.get("campaignImageId");

		if (campaignImageId != null) {
			setCampaignImageId(campaignImageId);
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
	}

	/**
	* Returns the primary key of this campaign images.
	*
	* @return the primary key of this campaign images
	*/
	@Override
	public long getPrimaryKey() {
		return _campaignImages.getPrimaryKey();
	}

	/**
	* Sets the primary key of this campaign images.
	*
	* @param primaryKey the primary key of this campaign images
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_campaignImages.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the campaign image ID of this campaign images.
	*
	* @return the campaign image ID of this campaign images
	*/
	@Override
	public long getCampaignImageId() {
		return _campaignImages.getCampaignImageId();
	}

	/**
	* Sets the campaign image ID of this campaign images.
	*
	* @param campaignImageId the campaign image ID of this campaign images
	*/
	@Override
	public void setCampaignImageId(long campaignImageId) {
		_campaignImages.setCampaignImageId(campaignImageId);
	}

	/**
	* Returns the user ID of this campaign images.
	*
	* @return the user ID of this campaign images
	*/
	@Override
	public long getUserId() {
		return _campaignImages.getUserId();
	}

	/**
	* Sets the user ID of this campaign images.
	*
	* @param userId the user ID of this campaign images
	*/
	@Override
	public void setUserId(long userId) {
		_campaignImages.setUserId(userId);
	}

	/**
	* Returns the user uuid of this campaign images.
	*
	* @return the user uuid of this campaign images
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignImages.getUserUuid();
	}

	/**
	* Sets the user uuid of this campaign images.
	*
	* @param userUuid the user uuid of this campaign images
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_campaignImages.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this campaign images.
	*
	* @return the created date of this campaign images
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _campaignImages.getCreatedDate();
	}

	/**
	* Sets the created date of this campaign images.
	*
	* @param createdDate the created date of this campaign images
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_campaignImages.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this campaign images.
	*
	* @return the modified date of this campaign images
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _campaignImages.getModifiedDate();
	}

	/**
	* Sets the modified date of this campaign images.
	*
	* @param modifiedDate the modified date of this campaign images
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_campaignImages.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the image title of this campaign images.
	*
	* @return the image title of this campaign images
	*/
	@Override
	public java.lang.String getImageTitle() {
		return _campaignImages.getImageTitle();
	}

	/**
	* Sets the image title of this campaign images.
	*
	* @param imageTitle the image title of this campaign images
	*/
	@Override
	public void setImageTitle(java.lang.String imageTitle) {
		_campaignImages.setImageTitle(imageTitle);
	}

	/**
	* Returns the image desc of this campaign images.
	*
	* @return the image desc of this campaign images
	*/
	@Override
	public java.lang.String getImageDesc() {
		return _campaignImages.getImageDesc();
	}

	/**
	* Sets the image desc of this campaign images.
	*
	* @param imageDesc the image desc of this campaign images
	*/
	@Override
	public void setImageDesc(java.lang.String imageDesc) {
		_campaignImages.setImageDesc(imageDesc);
	}

	/**
	* Returns the image u u i d of this campaign images.
	*
	* @return the image u u i d of this campaign images
	*/
	@Override
	public java.lang.String getImageUUID() {
		return _campaignImages.getImageUUID();
	}

	/**
	* Sets the image u u i d of this campaign images.
	*
	* @param imageUUID the image u u i d of this campaign images
	*/
	@Override
	public void setImageUUID(java.lang.String imageUUID) {
		_campaignImages.setImageUUID(imageUUID);
	}

	/**
	* Returns the image group ID of this campaign images.
	*
	* @return the image group ID of this campaign images
	*/
	@Override
	public long getImageGroupId() {
		return _campaignImages.getImageGroupId();
	}

	/**
	* Sets the image group ID of this campaign images.
	*
	* @param imageGroupId the image group ID of this campaign images
	*/
	@Override
	public void setImageGroupId(long imageGroupId) {
		_campaignImages.setImageGroupId(imageGroupId);
	}

	@Override
	public boolean isNew() {
		return _campaignImages.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_campaignImages.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _campaignImages.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_campaignImages.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _campaignImages.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _campaignImages.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_campaignImages.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _campaignImages.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_campaignImages.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_campaignImages.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_campaignImages.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CampaignImagesWrapper((CampaignImages)_campaignImages.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.CampaignImages campaignImages) {
		return _campaignImages.compareTo(campaignImages);
	}

	@Override
	public int hashCode() {
		return _campaignImages.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.CampaignImages> toCacheModel() {
		return _campaignImages.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.CampaignImages toEscapedModel() {
		return new CampaignImagesWrapper(_campaignImages.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.CampaignImages toUnescapedModel() {
		return new CampaignImagesWrapper(_campaignImages.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _campaignImages.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _campaignImages.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignImages.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CampaignImagesWrapper)) {
			return false;
		}

		CampaignImagesWrapper campaignImagesWrapper = (CampaignImagesWrapper)obj;

		if (Validator.equals(_campaignImages,
					campaignImagesWrapper._campaignImages)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CampaignImages getWrappedCampaignImages() {
		return _campaignImages;
	}

	@Override
	public CampaignImages getWrappedModel() {
		return _campaignImages;
	}

	@Override
	public void resetOriginalValues() {
		_campaignImages.resetOriginalValues();
	}

	private CampaignImages _campaignImages;
}