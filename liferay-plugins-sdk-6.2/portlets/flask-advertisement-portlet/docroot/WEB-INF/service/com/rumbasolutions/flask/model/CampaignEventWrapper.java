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
 * This class is a wrapper for {@link CampaignEvent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignEvent
 * @generated
 */
public class CampaignEventWrapper implements CampaignEvent,
	ModelWrapper<CampaignEvent> {
	public CampaignEventWrapper(CampaignEvent campaignEvent) {
		_campaignEvent = campaignEvent;
	}

	@Override
	public Class<?> getModelClass() {
		return CampaignEvent.class;
	}

	@Override
	public String getModelClassName() {
		return CampaignEvent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campaignEventId", getCampaignEventId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("campaignId", getCampaignId());
		attributes.put("eventId", getEventId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long campaignEventId = (Long)attributes.get("campaignEventId");

		if (campaignEventId != null) {
			setCampaignEventId(campaignEventId);
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

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}
	}

	/**
	* Returns the primary key of this campaign event.
	*
	* @return the primary key of this campaign event
	*/
	@Override
	public long getPrimaryKey() {
		return _campaignEvent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this campaign event.
	*
	* @param primaryKey the primary key of this campaign event
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_campaignEvent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the campaign event ID of this campaign event.
	*
	* @return the campaign event ID of this campaign event
	*/
	@Override
	public long getCampaignEventId() {
		return _campaignEvent.getCampaignEventId();
	}

	/**
	* Sets the campaign event ID of this campaign event.
	*
	* @param campaignEventId the campaign event ID of this campaign event
	*/
	@Override
	public void setCampaignEventId(long campaignEventId) {
		_campaignEvent.setCampaignEventId(campaignEventId);
	}

	/**
	* Returns the user ID of this campaign event.
	*
	* @return the user ID of this campaign event
	*/
	@Override
	public long getUserId() {
		return _campaignEvent.getUserId();
	}

	/**
	* Sets the user ID of this campaign event.
	*
	* @param userId the user ID of this campaign event
	*/
	@Override
	public void setUserId(long userId) {
		_campaignEvent.setUserId(userId);
	}

	/**
	* Returns the user uuid of this campaign event.
	*
	* @return the user uuid of this campaign event
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignEvent.getUserUuid();
	}

	/**
	* Sets the user uuid of this campaign event.
	*
	* @param userUuid the user uuid of this campaign event
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_campaignEvent.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this campaign event.
	*
	* @return the created date of this campaign event
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _campaignEvent.getCreatedDate();
	}

	/**
	* Sets the created date of this campaign event.
	*
	* @param createdDate the created date of this campaign event
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_campaignEvent.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this campaign event.
	*
	* @return the modified date of this campaign event
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _campaignEvent.getModifiedDate();
	}

	/**
	* Sets the modified date of this campaign event.
	*
	* @param modifiedDate the modified date of this campaign event
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_campaignEvent.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the campaign ID of this campaign event.
	*
	* @return the campaign ID of this campaign event
	*/
	@Override
	public long getCampaignId() {
		return _campaignEvent.getCampaignId();
	}

	/**
	* Sets the campaign ID of this campaign event.
	*
	* @param campaignId the campaign ID of this campaign event
	*/
	@Override
	public void setCampaignId(long campaignId) {
		_campaignEvent.setCampaignId(campaignId);
	}

	/**
	* Returns the event ID of this campaign event.
	*
	* @return the event ID of this campaign event
	*/
	@Override
	public long getEventId() {
		return _campaignEvent.getEventId();
	}

	/**
	* Sets the event ID of this campaign event.
	*
	* @param eventId the event ID of this campaign event
	*/
	@Override
	public void setEventId(long eventId) {
		_campaignEvent.setEventId(eventId);
	}

	@Override
	public boolean isNew() {
		return _campaignEvent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_campaignEvent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _campaignEvent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_campaignEvent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _campaignEvent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _campaignEvent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_campaignEvent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _campaignEvent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_campaignEvent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_campaignEvent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_campaignEvent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CampaignEventWrapper((CampaignEvent)_campaignEvent.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.CampaignEvent campaignEvent) {
		return _campaignEvent.compareTo(campaignEvent);
	}

	@Override
	public int hashCode() {
		return _campaignEvent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.CampaignEvent> toCacheModel() {
		return _campaignEvent.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.CampaignEvent toEscapedModel() {
		return new CampaignEventWrapper(_campaignEvent.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.CampaignEvent toUnescapedModel() {
		return new CampaignEventWrapper(_campaignEvent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _campaignEvent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _campaignEvent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_campaignEvent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CampaignEventWrapper)) {
			return false;
		}

		CampaignEventWrapper campaignEventWrapper = (CampaignEventWrapper)obj;

		if (Validator.equals(_campaignEvent, campaignEventWrapper._campaignEvent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CampaignEvent getWrappedCampaignEvent() {
		return _campaignEvent;
	}

	@Override
	public CampaignEvent getWrappedModel() {
		return _campaignEvent;
	}

	@Override
	public void resetOriginalValues() {
		_campaignEvent.resetOriginalValues();
	}

	private CampaignEvent _campaignEvent;
}