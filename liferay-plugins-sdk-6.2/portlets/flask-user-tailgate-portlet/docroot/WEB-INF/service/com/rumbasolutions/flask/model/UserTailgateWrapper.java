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
 * This class is a wrapper for {@link UserTailgate}.
 * </p>
 *
 * @author rajeshj
 * @see UserTailgate
 * @generated
 */
public class UserTailgateWrapper implements UserTailgate,
	ModelWrapper<UserTailgate> {
	public UserTailgateWrapper(UserTailgate userTailgate) {
		_userTailgate = userTailgate;
	}

	@Override
	public Class<?> getModelClass() {
		return UserTailgate.class;
	}

	@Override
	public String getModelClassName() {
		return UserTailgate.class.getName();
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
	}

	/**
	* Returns the primary key of this user tailgate.
	*
	* @return the primary key of this user tailgate
	*/
	@Override
	public long getPrimaryKey() {
		return _userTailgate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user tailgate.
	*
	* @param primaryKey the primary key of this user tailgate
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userTailgate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tailgate ID of this user tailgate.
	*
	* @return the tailgate ID of this user tailgate
	*/
	@Override
	public long getTailgateId() {
		return _userTailgate.getTailgateId();
	}

	/**
	* Sets the tailgate ID of this user tailgate.
	*
	* @param tailgateId the tailgate ID of this user tailgate
	*/
	@Override
	public void setTailgateId(long tailgateId) {
		_userTailgate.setTailgateId(tailgateId);
	}

	/**
	* Returns the company ID of this user tailgate.
	*
	* @return the company ID of this user tailgate
	*/
	@Override
	public long getCompanyId() {
		return _userTailgate.getCompanyId();
	}

	/**
	* Sets the company ID of this user tailgate.
	*
	* @param companyId the company ID of this user tailgate
	*/
	@Override
	public void setCompanyId(long companyId) {
		_userTailgate.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this user tailgate.
	*
	* @return the user ID of this user tailgate
	*/
	@Override
	public long getUserId() {
		return _userTailgate.getUserId();
	}

	/**
	* Sets the user ID of this user tailgate.
	*
	* @param userId the user ID of this user tailgate
	*/
	@Override
	public void setUserId(long userId) {
		_userTailgate.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user tailgate.
	*
	* @return the user uuid of this user tailgate
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userTailgate.getUserUuid();
	}

	/**
	* Sets the user uuid of this user tailgate.
	*
	* @param userUuid the user uuid of this user tailgate
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userTailgate.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this user tailgate.
	*
	* @return the created date of this user tailgate
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _userTailgate.getCreatedDate();
	}

	/**
	* Sets the created date of this user tailgate.
	*
	* @param createdDate the created date of this user tailgate
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_userTailgate.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this user tailgate.
	*
	* @return the modified date of this user tailgate
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _userTailgate.getModifiedDate();
	}

	/**
	* Sets the modified date of this user tailgate.
	*
	* @param modifiedDate the modified date of this user tailgate
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_userTailgate.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the tailgate name of this user tailgate.
	*
	* @return the tailgate name of this user tailgate
	*/
	@Override
	public java.lang.String getTailgateName() {
		return _userTailgate.getTailgateName();
	}

	/**
	* Sets the tailgate name of this user tailgate.
	*
	* @param tailgateName the tailgate name of this user tailgate
	*/
	@Override
	public void setTailgateName(java.lang.String tailgateName) {
		_userTailgate.setTailgateName(tailgateName);
	}

	/**
	* Returns the tailgate description of this user tailgate.
	*
	* @return the tailgate description of this user tailgate
	*/
	@Override
	public java.lang.String getTailgateDescription() {
		return _userTailgate.getTailgateDescription();
	}

	/**
	* Sets the tailgate description of this user tailgate.
	*
	* @param tailgateDescription the tailgate description of this user tailgate
	*/
	@Override
	public void setTailgateDescription(java.lang.String tailgateDescription) {
		_userTailgate.setTailgateDescription(tailgateDescription);
	}

	/**
	* Returns the event ID of this user tailgate.
	*
	* @return the event ID of this user tailgate
	*/
	@Override
	public long getEventId() {
		return _userTailgate.getEventId();
	}

	/**
	* Sets the event ID of this user tailgate.
	*
	* @param eventId the event ID of this user tailgate
	*/
	@Override
	public void setEventId(long eventId) {
		_userTailgate.setEventId(eventId);
	}

	/**
	* Returns the event name of this user tailgate.
	*
	* @return the event name of this user tailgate
	*/
	@Override
	public java.lang.String getEventName() {
		return _userTailgate.getEventName();
	}

	/**
	* Sets the event name of this user tailgate.
	*
	* @param eventName the event name of this user tailgate
	*/
	@Override
	public void setEventName(java.lang.String eventName) {
		_userTailgate.setEventName(eventName);
	}

	/**
	* Returns the tailgate date of this user tailgate.
	*
	* @return the tailgate date of this user tailgate
	*/
	@Override
	public java.util.Date getTailgateDate() {
		return _userTailgate.getTailgateDate();
	}

	/**
	* Sets the tailgate date of this user tailgate.
	*
	* @param tailgateDate the tailgate date of this user tailgate
	*/
	@Override
	public void setTailgateDate(java.util.Date tailgateDate) {
		_userTailgate.setTailgateDate(tailgateDate);
	}

	/**
	* Returns the start time of this user tailgate.
	*
	* @return the start time of this user tailgate
	*/
	@Override
	public java.util.Date getStartTime() {
		return _userTailgate.getStartTime();
	}

	/**
	* Sets the start time of this user tailgate.
	*
	* @param startTime the start time of this user tailgate
	*/
	@Override
	public void setStartTime(java.util.Date startTime) {
		_userTailgate.setStartTime(startTime);
	}

	/**
	* Returns the end time of this user tailgate.
	*
	* @return the end time of this user tailgate
	*/
	@Override
	public java.util.Date getEndTime() {
		return _userTailgate.getEndTime();
	}

	/**
	* Sets the end time of this user tailgate.
	*
	* @param endTime the end time of this user tailgate
	*/
	@Override
	public void setEndTime(java.util.Date endTime) {
		_userTailgate.setEndTime(endTime);
	}

	@Override
	public boolean isNew() {
		return _userTailgate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userTailgate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userTailgate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userTailgate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userTailgate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userTailgate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userTailgate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userTailgate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userTailgate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userTailgate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userTailgate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserTailgateWrapper((UserTailgate)_userTailgate.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.UserTailgate userTailgate) {
		return _userTailgate.compareTo(userTailgate);
	}

	@Override
	public int hashCode() {
		return _userTailgate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.UserTailgate> toCacheModel() {
		return _userTailgate.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.UserTailgate toEscapedModel() {
		return new UserTailgateWrapper(_userTailgate.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.UserTailgate toUnescapedModel() {
		return new UserTailgateWrapper(_userTailgate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userTailgate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userTailgate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userTailgate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserTailgateWrapper)) {
			return false;
		}

		UserTailgateWrapper userTailgateWrapper = (UserTailgateWrapper)obj;

		if (Validator.equals(_userTailgate, userTailgateWrapper._userTailgate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserTailgate getWrappedUserTailgate() {
		return _userTailgate;
	}

	@Override
	public UserTailgate getWrappedModel() {
		return _userTailgate;
	}

	@Override
	public void resetOriginalValues() {
		_userTailgate.resetOriginalValues();
	}

	private UserTailgate _userTailgate;
}