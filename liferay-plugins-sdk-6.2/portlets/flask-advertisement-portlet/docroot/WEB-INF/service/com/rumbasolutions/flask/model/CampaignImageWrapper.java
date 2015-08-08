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
 * This class is a wrapper for {@link CampaignImage}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignImage
 * @generated
 */
public class CampaignImageWrapper implements CampaignImage,
	ModelWrapper<CampaignImage> {
	public CampaignImageWrapper(CampaignImage campaignImage) {
		_campaignImage = campaignImage;
	}

	@Override
	public Class<?> getModelClass() {
		return CampaignImage.class;
	}

	@Override
	public String getModelClassName() {
		return CampaignImage.class.getName();
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
	* Returns the primary key of this campaign image.
	*
	* @return the primary key of this campaign image
	*/
	@Override
	public long getPrimaryKey() {
		return _campaignImage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this campaign image.
	*
	* @param primaryKey the primary key of this campaign image
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_campaignImage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the campaign image ID of this campaign image.
	*
	* @return the campaign image ID of this campaign image
	*/
	@Override
	public long getCampaignImageId() {
		return _campaignImage.getCampaignImageId();
	}

	/**
	* Sets the campaign image ID of this campaign image.
	*
	* @param campaignImageId the campaign image ID of this campaign image
	*/
	@Override
	public void setCampaignImageId(long campaignImageId) {
		_campaignImage.setCampaignImageId(campaignImageId);
	}

	/**
	* Returns the user ID of this campaign image.
	*
	* @return the user ID of this campaign image
	*/
	@Override
	public long getUserId() {
		return _campaignImage.getUserId();
	}

	/**
	* Sets the user ID of this campaign image.
	*
	* @param userId the user ID of this campaign image
	*/
	@Override
	public void setUserId(long userId) {
		_campaignImage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this campaign image.
	*
	* @return the user uuid of this campaign image
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignImage.getUserUuid();
	}

	/**
	* Sets the user uuid of this campaign image.
	*
	* @param userUuid the user uuid of this campaign image
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_campaignImage.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this campaign image.
	*
	* @return the created date of this campaign image
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _campaignImage.getCreatedDate();
	}

	/**
	* Sets the created date of this campaign image.
	*
	* @param createdDate the created date of this campaign image
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_campaignImage.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this campaign image.
	*
	* @return the modified date of this campaign image
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _campaignImage.getModifiedDate();
	}

	/**
	* Sets the modified date of this campaign image.
	*
	* @param modifiedDate the modified date of this campaign image
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_campaignImage.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the image title of this campaign image.
	*
	* @return the image title of this campaign image
	*/
	@Override
	public java.lang.String getImageTitle() {
		return _campaignImage.getImageTitle();
	}

	/**
	* Sets the image title of this campaign image.
	*
	* @param imageTitle the image title of this campaign image
	*/
	@Override
	public void setImageTitle(java.lang.String imageTitle) {
		_campaignImage.setImageTitle(imageTitle);
	}

	/**
	* Returns the image desc of this campaign image.
	*
	* @return the image desc of this campaign image
	*/
	@Override
	public java.lang.String getImageDesc() {
		return _campaignImage.getImageDesc();
	}

	/**
	* Sets the image desc of this campaign image.
	*
	* @param imageDesc the image desc of this campaign image
	*/
	@Override
	public void setImageDesc(java.lang.String imageDesc) {
		_campaignImage.setImageDesc(imageDesc);
	}

	/**
	* Returns the image u u i d of this campaign image.
	*
	* @return the image u u i d of this campaign image
	*/
	@Override
	public java.lang.String getImageUUID() {
		return _campaignImage.getImageUUID();
	}

	/**
	* Sets the image u u i d of this campaign image.
	*
	* @param imageUUID the image u u i d of this campaign image
	*/
	@Override
	public void setImageUUID(java.lang.String imageUUID) {
		_campaignImage.setImageUUID(imageUUID);
	}

	/**
	* Returns the image group ID of this campaign image.
	*
	* @return the image group ID of this campaign image
	*/
	@Override
	public long getImageGroupId() {
		return _campaignImage.getImageGroupId();
	}

	/**
	* Sets the image group ID of this campaign image.
	*
	* @param imageGroupId the image group ID of this campaign image
	*/
	@Override
	public void setImageGroupId(long imageGroupId) {
		_campaignImage.setImageGroupId(imageGroupId);
	}

	@Override
	public boolean isNew() {
		return _campaignImage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_campaignImage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _campaignImage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_campaignImage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _campaignImage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _campaignImage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_campaignImage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _campaignImage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_campaignImage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_campaignImage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_campaignImage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CampaignImageWrapper((CampaignImage)_campaignImage.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.CampaignImage campaignImage) {
		return _campaignImage.compareTo(campaignImage);
	}

	@Override
	public int hashCode() {
		return _campaignImage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.CampaignImage> toCacheModel() {
		return _campaignImage.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.CampaignImage toEscapedModel() {
		return new CampaignImageWrapper(_campaignImage.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.CampaignImage toUnescapedModel() {
		return new CampaignImageWrapper(_campaignImage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _campaignImage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _campaignImage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignImage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CampaignImageWrapper)) {
			return false;
		}

		CampaignImageWrapper campaignImageWrapper = (CampaignImageWrapper)obj;

		if (Validator.equals(_campaignImage, campaignImageWrapper._campaignImage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CampaignImage getWrappedCampaignImage() {
		return _campaignImage;
	}

	@Override
	public CampaignImage getWrappedModel() {
		return _campaignImage;
	}

	@Override
	public void resetOriginalValues() {
		_campaignImage.resetOriginalValues();
	}

	private CampaignImage _campaignImage;
}