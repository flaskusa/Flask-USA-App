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
 * This class is a wrapper for {@link AdCampaign}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdCampaign
 * @generated
 */
public class AdCampaignWrapper implements AdCampaign, ModelWrapper<AdCampaign> {
	public AdCampaignWrapper(AdCampaign adCampaign) {
		_adCampaign = adCampaign;
	}

	@Override
	public Class<?> getModelClass() {
		return AdCampaign.class;
	}

	@Override
	public String getModelClassName() {
		return AdCampaign.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campaignId", getCampaignId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("campaignName", getCampaignName());
		attributes.put("customerId", getCustomerId());
		attributes.put("displayGeneral", getDisplayGeneral());
		attributes.put("displayPreEvent", getDisplayPreEvent());
		attributes.put("displayDuringEvent", getDisplayDuringEvent());
		attributes.put("displayPostEvent", getDisplayPostEvent());
		attributes.put("frequencyPerHour", getFrequencyPerHour());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
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

		String campaignName = (String)attributes.get("campaignName");

		if (campaignName != null) {
			setCampaignName(campaignName);
		}

		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		Boolean displayGeneral = (Boolean)attributes.get("displayGeneral");

		if (displayGeneral != null) {
			setDisplayGeneral(displayGeneral);
		}

		Boolean displayPreEvent = (Boolean)attributes.get("displayPreEvent");

		if (displayPreEvent != null) {
			setDisplayPreEvent(displayPreEvent);
		}

		Boolean displayDuringEvent = (Boolean)attributes.get(
				"displayDuringEvent");

		if (displayDuringEvent != null) {
			setDisplayDuringEvent(displayDuringEvent);
		}

		Boolean displayPostEvent = (Boolean)attributes.get("displayPostEvent");

		if (displayPostEvent != null) {
			setDisplayPostEvent(displayPostEvent);
		}

		Long frequencyPerHour = (Long)attributes.get("frequencyPerHour");

		if (frequencyPerHour != null) {
			setFrequencyPerHour(frequencyPerHour);
		}
	}

	/**
	* Returns the primary key of this ad campaign.
	*
	* @return the primary key of this ad campaign
	*/
	@Override
	public long getPrimaryKey() {
		return _adCampaign.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ad campaign.
	*
	* @param primaryKey the primary key of this ad campaign
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_adCampaign.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the campaign ID of this ad campaign.
	*
	* @return the campaign ID of this ad campaign
	*/
	@Override
	public long getCampaignId() {
		return _adCampaign.getCampaignId();
	}

	/**
	* Sets the campaign ID of this ad campaign.
	*
	* @param campaignId the campaign ID of this ad campaign
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_adCampaign.setCampaignId(campaignId);
	}

	/**
	* Returns the user ID of this ad campaign.
	*
	* @return the user ID of this ad campaign
	*/
	@Override
	public long getUserId() {
		return _adCampaign.getUserId();
	}

	/**
	* Sets the user ID of this ad campaign.
	*
	* @param userId the user ID of this ad campaign
	*/
	@Override
	public void setUserId(long userId) {
		_adCampaign.setUserId(userId);
	}

	/**
	* Returns the user uuid of this ad campaign.
	*
	* @return the user uuid of this ad campaign
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adCampaign.getUserUuid();
	}

	/**
	* Sets the user uuid of this ad campaign.
	*
	* @param userUuid the user uuid of this ad campaign
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_adCampaign.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this ad campaign.
	*
	* @return the created date of this ad campaign
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _adCampaign.getCreatedDate();
	}

	/**
	* Sets the created date of this ad campaign.
	*
	* @param createdDate the created date of this ad campaign
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_adCampaign.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this ad campaign.
	*
	* @return the modified date of this ad campaign
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _adCampaign.getModifiedDate();
	}

	/**
	* Sets the modified date of this ad campaign.
	*
	* @param modifiedDate the modified date of this ad campaign
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_adCampaign.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the campaign name of this ad campaign.
	*
	* @return the campaign name of this ad campaign
	*/
	@Override
	public java.lang.String getCampaignName() {
		return _adCampaign.getCampaignName();
	}

	/**
	* Sets the campaign name of this ad campaign.
	*
	* @param campaignName the campaign name of this ad campaign
	*/
	@Override
	public void setCampaignName(java.lang.String campaignName) {
		_adCampaign.setCampaignName(campaignName);
	}

	/**
	* Returns the customer ID of this ad campaign.
	*
	* @return the customer ID of this ad campaign
	*/
	@Override
	public long getCustomerId() {
		return _adCampaign.getCustomerId();
	}

	/**
	* Sets the customer ID of this ad campaign.
	*
	* @param customerId the customer ID of this ad campaign
	*/
	@Override
	public void setCustomerId(long customerId) {
		_adCampaign.setCustomerId(customerId);
	}

	/**
	* Returns the display general of this ad campaign.
	*
	* @return the display general of this ad campaign
	*/
	@Override
	public boolean getDisplayGeneral() {
		return _adCampaign.getDisplayGeneral();
	}

	/**
	* Returns <code>true</code> if this ad campaign is display general.
	*
	* @return <code>true</code> if this ad campaign is display general; <code>false</code> otherwise
	*/
	@Override
	public boolean isDisplayGeneral() {
		return _adCampaign.isDisplayGeneral();
	}

	/**
	* Sets whether this ad campaign is display general.
	*
	* @param displayGeneral the display general of this ad campaign
	*/
	@Override
	public void setDisplayGeneral(boolean displayGeneral) {
		_adCampaign.setDisplayGeneral(displayGeneral);
	}

	/**
	* Returns the display pre event of this ad campaign.
	*
	* @return the display pre event of this ad campaign
	*/
	@Override
	public boolean getDisplayPreEvent() {
		return _adCampaign.getDisplayPreEvent();
	}

	/**
	* Returns <code>true</code> if this ad campaign is display pre event.
	*
	* @return <code>true</code> if this ad campaign is display pre event; <code>false</code> otherwise
	*/
	@Override
	public boolean isDisplayPreEvent() {
		return _adCampaign.isDisplayPreEvent();
	}

	/**
	* Sets whether this ad campaign is display pre event.
	*
	* @param displayPreEvent the display pre event of this ad campaign
	*/
	@Override
	public void setDisplayPreEvent(boolean displayPreEvent) {
		_adCampaign.setDisplayPreEvent(displayPreEvent);
	}

	/**
	* Returns the display during event of this ad campaign.
	*
	* @return the display during event of this ad campaign
	*/
	@Override
	public boolean getDisplayDuringEvent() {
		return _adCampaign.getDisplayDuringEvent();
	}

	/**
	* Returns <code>true</code> if this ad campaign is display during event.
	*
	* @return <code>true</code> if this ad campaign is display during event; <code>false</code> otherwise
	*/
	@Override
	public boolean isDisplayDuringEvent() {
		return _adCampaign.isDisplayDuringEvent();
	}

	/**
	* Sets whether this ad campaign is display during event.
	*
	* @param displayDuringEvent the display during event of this ad campaign
	*/
	@Override
	public void setDisplayDuringEvent(boolean displayDuringEvent) {
		_adCampaign.setDisplayDuringEvent(displayDuringEvent);
	}

	/**
	* Returns the display post event of this ad campaign.
	*
	* @return the display post event of this ad campaign
	*/
	@Override
	public boolean getDisplayPostEvent() {
		return _adCampaign.getDisplayPostEvent();
	}

	/**
	* Returns <code>true</code> if this ad campaign is display post event.
	*
	* @return <code>true</code> if this ad campaign is display post event; <code>false</code> otherwise
	*/
	@Override
	public boolean isDisplayPostEvent() {
		return _adCampaign.isDisplayPostEvent();
	}

	/**
	* Sets whether this ad campaign is display post event.
	*
	* @param displayPostEvent the display post event of this ad campaign
	*/
	@Override
	public void setDisplayPostEvent(boolean displayPostEvent) {
		_adCampaign.setDisplayPostEvent(displayPostEvent);
	}

	/**
	* Returns the frequency per hour of this ad campaign.
	*
	* @return the frequency per hour of this ad campaign
	*/
	@Override
	public long getFrequencyPerHour() {
		return _adCampaign.getFrequencyPerHour();
	}

	/**
	* Sets the frequency per hour of this ad campaign.
	*
	* @param frequencyPerHour the frequency per hour of this ad campaign
	*/
	@Override
	public void setFrequencyPerHour(long frequencyPerHour) {
		_adCampaign.setFrequencyPerHour(frequencyPerHour);
	}

	@Override
	public boolean isNew() {
		return _adCampaign.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_adCampaign.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _adCampaign.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_adCampaign.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _adCampaign.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _adCampaign.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_adCampaign.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _adCampaign.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_adCampaign.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_adCampaign.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_adCampaign.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AdCampaignWrapper((AdCampaign)_adCampaign.clone());
	}

	@Override
	public int compareTo(com.rumbasolutions.flask.model.AdCampaign adCampaign) {
		return _adCampaign.compareTo(adCampaign);
	}

	@Override
	public int hashCode() {
		return _adCampaign.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.AdCampaign> toCacheModel() {
		return _adCampaign.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.AdCampaign toEscapedModel() {
		return new AdCampaignWrapper(_adCampaign.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.AdCampaign toUnescapedModel() {
		return new AdCampaignWrapper(_adCampaign.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _adCampaign.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _adCampaign.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_adCampaign.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdCampaignWrapper)) {
			return false;
		}

		AdCampaignWrapper adCampaignWrapper = (AdCampaignWrapper)obj;

		if (Validator.equals(_adCampaign, adCampaignWrapper._adCampaign)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AdCampaign getWrappedAdCampaign() {
		return _adCampaign;
	}

	@Override
	public AdCampaign getWrappedModel() {
		return _adCampaign;
	}

	@Override
	public void resetOriginalValues() {
		_adCampaign.resetOriginalValues();
	}

	private AdCampaign _adCampaign;
}