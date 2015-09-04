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
 * This class is a wrapper for {@link TailgateInfo}.
 * </p>
 *
 * @author rajeshj
 * @see TailgateInfo
 * @generated
 */
public class TailgateInfoWrapper implements TailgateInfo,
	ModelWrapper<TailgateInfo> {
	public TailgateInfoWrapper(TailgateInfo tailgateInfo) {
		_tailgateInfo = tailgateInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return TailgateInfo.class;
	}

	@Override
	public String getModelClassName() {
		return TailgateInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tailgateId", getTailgateId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("tailgateName", getTailgateName());
		attributes.put("tailgateDescription", getTailgateDescription());
		attributes.put("eventId", getEventId());
		attributes.put("eventName", getEventName());
		attributes.put("tailgateDate", getTailgateDate());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("isActive", getIsActive());
		attributes.put("isDelete", getIsDelete());
		attributes.put("amountToPay", getAmountToPay());
		attributes.put("showMembers", getShowMembers());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tailgateId = (Long)attributes.get("tailgateId");

		if (tailgateId != null) {
			setTailgateId(tailgateId);
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

		String tailgateName = (String)attributes.get("tailgateName");

		if (tailgateName != null) {
			setTailgateName(tailgateName);
		}

		String tailgateDescription = (String)attributes.get(
				"tailgateDescription");

		if (tailgateDescription != null) {
			setTailgateDescription(tailgateDescription);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		String eventName = (String)attributes.get("eventName");

		if (eventName != null) {
			setEventName(eventName);
		}

		Date tailgateDate = (Date)attributes.get("tailgateDate");

		if (tailgateDate != null) {
			setTailgateDate(tailgateDate);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Integer isActive = (Integer)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		Integer isDelete = (Integer)attributes.get("isDelete");

		if (isDelete != null) {
			setIsDelete(isDelete);
		}

		Long amountToPay = (Long)attributes.get("amountToPay");

		if (amountToPay != null) {
			setAmountToPay(amountToPay);
		}

		Boolean showMembers = (Boolean)attributes.get("showMembers");

		if (showMembers != null) {
			setShowMembers(showMembers);
		}
	}

	/**
	* Returns the primary key of this tailgate info.
	*
	* @return the primary key of this tailgate info
	*/
	@Override
	public long getPrimaryKey() {
		return _tailgateInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tailgate info.
	*
	* @param primaryKey the primary key of this tailgate info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tailgateInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tailgate ID of this tailgate info.
	*
	* @return the tailgate ID of this tailgate info
	*/
	@Override
	public long getTailgateId() {
		return _tailgateInfo.getTailgateId();
	}

	/**
	* Sets the tailgate ID of this tailgate info.
	*
	* @param tailgateId the tailgate ID of this tailgate info
	*/
	@Override
	public void setTailgateId(long tailgateId) {
		_tailgateInfo.setTailgateId(tailgateId);
	}

	/**
	* Returns the company ID of this tailgate info.
	*
	* @return the company ID of this tailgate info
	*/
	@Override
	public long getCompanyId() {
		return _tailgateInfo.getCompanyId();
	}

	/**
	* Sets the company ID of this tailgate info.
	*
	* @param companyId the company ID of this tailgate info
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tailgateInfo.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this tailgate info.
	*
	* @return the user ID of this tailgate info
	*/
	@Override
	public long getUserId() {
		return _tailgateInfo.getUserId();
	}

	/**
	* Sets the user ID of this tailgate info.
	*
	* @param userId the user ID of this tailgate info
	*/
	@Override
	public void setUserId(long userId) {
		_tailgateInfo.setUserId(userId);
	}

	/**
	* Returns the user uuid of this tailgate info.
	*
	* @return the user uuid of this tailgate info
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateInfo.getUserUuid();
	}

	/**
	* Sets the user uuid of this tailgate info.
	*
	* @param userUuid the user uuid of this tailgate info
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tailgateInfo.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this tailgate info.
	*
	* @return the created date of this tailgate info
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _tailgateInfo.getCreatedDate();
	}

	/**
	* Sets the created date of this tailgate info.
	*
	* @param createdDate the created date of this tailgate info
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_tailgateInfo.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this tailgate info.
	*
	* @return the modified date of this tailgate info
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _tailgateInfo.getModifiedDate();
	}

	/**
	* Sets the modified date of this tailgate info.
	*
	* @param modifiedDate the modified date of this tailgate info
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tailgateInfo.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the tailgate name of this tailgate info.
	*
	* @return the tailgate name of this tailgate info
	*/
	@Override
	public java.lang.String getTailgateName() {
		return _tailgateInfo.getTailgateName();
	}

	/**
	* Sets the tailgate name of this tailgate info.
	*
	* @param tailgateName the tailgate name of this tailgate info
	*/
	@Override
	public void setTailgateName(java.lang.String tailgateName) {
		_tailgateInfo.setTailgateName(tailgateName);
	}

	/**
	* Returns the tailgate description of this tailgate info.
	*
	* @return the tailgate description of this tailgate info
	*/
	@Override
	public java.lang.String getTailgateDescription() {
		return _tailgateInfo.getTailgateDescription();
	}

	/**
	* Sets the tailgate description of this tailgate info.
	*
	* @param tailgateDescription the tailgate description of this tailgate info
	*/
	@Override
	public void setTailgateDescription(java.lang.String tailgateDescription) {
		_tailgateInfo.setTailgateDescription(tailgateDescription);
	}

	/**
	* Returns the event ID of this tailgate info.
	*
	* @return the event ID of this tailgate info
	*/
	@Override
	public long getEventId() {
		return _tailgateInfo.getEventId();
	}

	/**
	* Sets the event ID of this tailgate info.
	*
	* @param eventId the event ID of this tailgate info
	*/
	@Override
	public void setEventId(long eventId) {
		_tailgateInfo.setEventId(eventId);
	}

	/**
	* Returns the event name of this tailgate info.
	*
	* @return the event name of this tailgate info
	*/
	@Override
	public java.lang.String getEventName() {
		return _tailgateInfo.getEventName();
	}

	/**
	* Sets the event name of this tailgate info.
	*
	* @param eventName the event name of this tailgate info
	*/
	@Override
	public void setEventName(java.lang.String eventName) {
		_tailgateInfo.setEventName(eventName);
	}

	/**
	* Returns the tailgate date of this tailgate info.
	*
	* @return the tailgate date of this tailgate info
	*/
	@Override
	public java.util.Date getTailgateDate() {
		return _tailgateInfo.getTailgateDate();
	}

	/**
	* Sets the tailgate date of this tailgate info.
	*
	* @param tailgateDate the tailgate date of this tailgate info
	*/
	@Override
	public void setTailgateDate(java.util.Date tailgateDate) {
		_tailgateInfo.setTailgateDate(tailgateDate);
	}

	/**
	* Returns the start time of this tailgate info.
	*
	* @return the start time of this tailgate info
	*/
	@Override
	public java.util.Date getStartTime() {
		return _tailgateInfo.getStartTime();
	}

	/**
	* Sets the start time of this tailgate info.
	*
	* @param startTime the start time of this tailgate info
	*/
	@Override
	public void setStartTime(java.util.Date startTime) {
		_tailgateInfo.setStartTime(startTime);
	}

	/**
	* Returns the end time of this tailgate info.
	*
	* @return the end time of this tailgate info
	*/
	@Override
	public java.util.Date getEndTime() {
		return _tailgateInfo.getEndTime();
	}

	/**
	* Sets the end time of this tailgate info.
	*
	* @param endTime the end time of this tailgate info
	*/
	@Override
	public void setEndTime(java.util.Date endTime) {
		_tailgateInfo.setEndTime(endTime);
	}

	/**
	* Returns the is active of this tailgate info.
	*
	* @return the is active of this tailgate info
	*/
	@Override
	public int getIsActive() {
		return _tailgateInfo.getIsActive();
	}

	/**
	* Sets the is active of this tailgate info.
	*
	* @param isActive the is active of this tailgate info
	*/
	@Override
	public void setIsActive(int isActive) {
		_tailgateInfo.setIsActive(isActive);
	}

	/**
	* Returns the is delete of this tailgate info.
	*
	* @return the is delete of this tailgate info
	*/
	@Override
	public int getIsDelete() {
		return _tailgateInfo.getIsDelete();
	}

	/**
	* Sets the is delete of this tailgate info.
	*
	* @param isDelete the is delete of this tailgate info
	*/
	@Override
	public void setIsDelete(int isDelete) {
		_tailgateInfo.setIsDelete(isDelete);
	}

	/**
	* Returns the amount to pay of this tailgate info.
	*
	* @return the amount to pay of this tailgate info
	*/
	@Override
	public long getAmountToPay() {
		return _tailgateInfo.getAmountToPay();
	}

	/**
	* Sets the amount to pay of this tailgate info.
	*
	* @param amountToPay the amount to pay of this tailgate info
	*/
	@Override
	public void setAmountToPay(long amountToPay) {
		_tailgateInfo.setAmountToPay(amountToPay);
	}

	/**
	* Returns the show members of this tailgate info.
	*
	* @return the show members of this tailgate info
	*/
	@Override
	public boolean getShowMembers() {
		return _tailgateInfo.getShowMembers();
	}

	/**
	* Returns <code>true</code> if this tailgate info is show members.
	*
	* @return <code>true</code> if this tailgate info is show members; <code>false</code> otherwise
	*/
	@Override
	public boolean isShowMembers() {
		return _tailgateInfo.isShowMembers();
	}

	/**
	* Sets whether this tailgate info is show members.
	*
	* @param showMembers the show members of this tailgate info
	*/
	@Override
	public void setShowMembers(boolean showMembers) {
		_tailgateInfo.setShowMembers(showMembers);
	}

	@Override
	public boolean isNew() {
		return _tailgateInfo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tailgateInfo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tailgateInfo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tailgateInfo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tailgateInfo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tailgateInfo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tailgateInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tailgateInfo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tailgateInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tailgateInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tailgateInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TailgateInfoWrapper((TailgateInfo)_tailgateInfo.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.TailgateInfo tailgateInfo) {
		return _tailgateInfo.compareTo(tailgateInfo);
	}

	@Override
	public int hashCode() {
		return _tailgateInfo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.TailgateInfo> toCacheModel() {
		return _tailgateInfo.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateInfo toEscapedModel() {
		return new TailgateInfoWrapper(_tailgateInfo.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateInfo toUnescapedModel() {
		return new TailgateInfoWrapper(_tailgateInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tailgateInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tailgateInfo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tailgateInfo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TailgateInfoWrapper)) {
			return false;
		}

		TailgateInfoWrapper tailgateInfoWrapper = (TailgateInfoWrapper)obj;

		if (Validator.equals(_tailgateInfo, tailgateInfoWrapper._tailgateInfo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TailgateInfo getWrappedTailgateInfo() {
		return _tailgateInfo;
	}

	@Override
	public TailgateInfo getWrappedModel() {
		return _tailgateInfo;
	}

	@Override
	public void resetOriginalValues() {
		_tailgateInfo.resetOriginalValues();
	}

	private TailgateInfo _tailgateInfo;
}