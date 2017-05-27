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

package com.liferay.contacts.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FlaskUserDeviceRegistration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskUserDeviceRegistration
 * @generated
 */
public class FlaskUserDeviceRegistrationWrapper
	implements FlaskUserDeviceRegistration,
		ModelWrapper<FlaskUserDeviceRegistration> {
	public FlaskUserDeviceRegistrationWrapper(
		FlaskUserDeviceRegistration flaskUserDeviceRegistration) {
		_flaskUserDeviceRegistration = flaskUserDeviceRegistration;
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskUserDeviceRegistration.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskUserDeviceRegistration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userDeviceRegistrationId", getUserDeviceRegistrationId());
		attributes.put("userId", getUserId());
		attributes.put("userEmail", getUserEmail());
		attributes.put("devicePlatform", getDevicePlatform());
		attributes.put("deviceDetails", getDeviceDetails());
		attributes.put("deviceToken", getDeviceToken());
		attributes.put("registrationTime", getRegistrationTime());
		attributes.put("active", getActive());
		attributes.put("lastNotificationTime", getLastNotificationTime());
		attributes.put("lastNotificationMsg", getLastNotificationMsg());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userDeviceRegistrationId = (Long)attributes.get(
				"userDeviceRegistrationId");

		if (userDeviceRegistrationId != null) {
			setUserDeviceRegistrationId(userDeviceRegistrationId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userEmail = (String)attributes.get("userEmail");

		if (userEmail != null) {
			setUserEmail(userEmail);
		}

		String devicePlatform = (String)attributes.get("devicePlatform");

		if (devicePlatform != null) {
			setDevicePlatform(devicePlatform);
		}

		String deviceDetails = (String)attributes.get("deviceDetails");

		if (deviceDetails != null) {
			setDeviceDetails(deviceDetails);
		}

		String deviceToken = (String)attributes.get("deviceToken");

		if (deviceToken != null) {
			setDeviceToken(deviceToken);
		}

		Date registrationTime = (Date)attributes.get("registrationTime");

		if (registrationTime != null) {
			setRegistrationTime(registrationTime);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Date lastNotificationTime = (Date)attributes.get("lastNotificationTime");

		if (lastNotificationTime != null) {
			setLastNotificationTime(lastNotificationTime);
		}

		String lastNotificationMsg = (String)attributes.get(
				"lastNotificationMsg");

		if (lastNotificationMsg != null) {
			setLastNotificationMsg(lastNotificationMsg);
		}
	}

	/**
	* Returns the primary key of this flask user device registration.
	*
	* @return the primary key of this flask user device registration
	*/
	@Override
	public long getPrimaryKey() {
		return _flaskUserDeviceRegistration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this flask user device registration.
	*
	* @param primaryKey the primary key of this flask user device registration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_flaskUserDeviceRegistration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user device registration ID of this flask user device registration.
	*
	* @return the user device registration ID of this flask user device registration
	*/
	@Override
	public long getUserDeviceRegistrationId() {
		return _flaskUserDeviceRegistration.getUserDeviceRegistrationId();
	}

	/**
	* Sets the user device registration ID of this flask user device registration.
	*
	* @param userDeviceRegistrationId the user device registration ID of this flask user device registration
	*/
	@Override
	public void setUserDeviceRegistrationId(long userDeviceRegistrationId) {
		_flaskUserDeviceRegistration.setUserDeviceRegistrationId(userDeviceRegistrationId);
	}

	/**
	* Returns the user ID of this flask user device registration.
	*
	* @return the user ID of this flask user device registration
	*/
	@Override
	public long getUserId() {
		return _flaskUserDeviceRegistration.getUserId();
	}

	/**
	* Sets the user ID of this flask user device registration.
	*
	* @param userId the user ID of this flask user device registration
	*/
	@Override
	public void setUserId(long userId) {
		_flaskUserDeviceRegistration.setUserId(userId);
	}

	/**
	* Returns the user uuid of this flask user device registration.
	*
	* @return the user uuid of this flask user device registration
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskUserDeviceRegistration.getUserUuid();
	}

	/**
	* Sets the user uuid of this flask user device registration.
	*
	* @param userUuid the user uuid of this flask user device registration
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_flaskUserDeviceRegistration.setUserUuid(userUuid);
	}

	/**
	* Returns the user email of this flask user device registration.
	*
	* @return the user email of this flask user device registration
	*/
	@Override
	public java.lang.String getUserEmail() {
		return _flaskUserDeviceRegistration.getUserEmail();
	}

	/**
	* Sets the user email of this flask user device registration.
	*
	* @param userEmail the user email of this flask user device registration
	*/
	@Override
	public void setUserEmail(java.lang.String userEmail) {
		_flaskUserDeviceRegistration.setUserEmail(userEmail);
	}

	/**
	* Returns the device platform of this flask user device registration.
	*
	* @return the device platform of this flask user device registration
	*/
	@Override
	public java.lang.String getDevicePlatform() {
		return _flaskUserDeviceRegistration.getDevicePlatform();
	}

	/**
	* Sets the device platform of this flask user device registration.
	*
	* @param devicePlatform the device platform of this flask user device registration
	*/
	@Override
	public void setDevicePlatform(java.lang.String devicePlatform) {
		_flaskUserDeviceRegistration.setDevicePlatform(devicePlatform);
	}

	/**
	* Returns the device details of this flask user device registration.
	*
	* @return the device details of this flask user device registration
	*/
	@Override
	public java.lang.String getDeviceDetails() {
		return _flaskUserDeviceRegistration.getDeviceDetails();
	}

	/**
	* Sets the device details of this flask user device registration.
	*
	* @param deviceDetails the device details of this flask user device registration
	*/
	@Override
	public void setDeviceDetails(java.lang.String deviceDetails) {
		_flaskUserDeviceRegistration.setDeviceDetails(deviceDetails);
	}

	/**
	* Returns the device token of this flask user device registration.
	*
	* @return the device token of this flask user device registration
	*/
	@Override
	public java.lang.String getDeviceToken() {
		return _flaskUserDeviceRegistration.getDeviceToken();
	}

	/**
	* Sets the device token of this flask user device registration.
	*
	* @param deviceToken the device token of this flask user device registration
	*/
	@Override
	public void setDeviceToken(java.lang.String deviceToken) {
		_flaskUserDeviceRegistration.setDeviceToken(deviceToken);
	}

	/**
	* Returns the registration time of this flask user device registration.
	*
	* @return the registration time of this flask user device registration
	*/
	@Override
	public java.util.Date getRegistrationTime() {
		return _flaskUserDeviceRegistration.getRegistrationTime();
	}

	/**
	* Sets the registration time of this flask user device registration.
	*
	* @param registrationTime the registration time of this flask user device registration
	*/
	@Override
	public void setRegistrationTime(java.util.Date registrationTime) {
		_flaskUserDeviceRegistration.setRegistrationTime(registrationTime);
	}

	/**
	* Returns the active of this flask user device registration.
	*
	* @return the active of this flask user device registration
	*/
	@Override
	public boolean getActive() {
		return _flaskUserDeviceRegistration.getActive();
	}

	/**
	* Returns <code>true</code> if this flask user device registration is active.
	*
	* @return <code>true</code> if this flask user device registration is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _flaskUserDeviceRegistration.isActive();
	}

	/**
	* Sets whether this flask user device registration is active.
	*
	* @param active the active of this flask user device registration
	*/
	@Override
	public void setActive(boolean active) {
		_flaskUserDeviceRegistration.setActive(active);
	}

	/**
	* Returns the last notification time of this flask user device registration.
	*
	* @return the last notification time of this flask user device registration
	*/
	@Override
	public java.util.Date getLastNotificationTime() {
		return _flaskUserDeviceRegistration.getLastNotificationTime();
	}

	/**
	* Sets the last notification time of this flask user device registration.
	*
	* @param lastNotificationTime the last notification time of this flask user device registration
	*/
	@Override
	public void setLastNotificationTime(java.util.Date lastNotificationTime) {
		_flaskUserDeviceRegistration.setLastNotificationTime(lastNotificationTime);
	}

	/**
	* Returns the last notification msg of this flask user device registration.
	*
	* @return the last notification msg of this flask user device registration
	*/
	@Override
	public java.lang.String getLastNotificationMsg() {
		return _flaskUserDeviceRegistration.getLastNotificationMsg();
	}

	/**
	* Sets the last notification msg of this flask user device registration.
	*
	* @param lastNotificationMsg the last notification msg of this flask user device registration
	*/
	@Override
	public void setLastNotificationMsg(java.lang.String lastNotificationMsg) {
		_flaskUserDeviceRegistration.setLastNotificationMsg(lastNotificationMsg);
	}

	@Override
	public boolean isNew() {
		return _flaskUserDeviceRegistration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_flaskUserDeviceRegistration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _flaskUserDeviceRegistration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_flaskUserDeviceRegistration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _flaskUserDeviceRegistration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _flaskUserDeviceRegistration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_flaskUserDeviceRegistration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _flaskUserDeviceRegistration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_flaskUserDeviceRegistration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_flaskUserDeviceRegistration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flaskUserDeviceRegistration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FlaskUserDeviceRegistrationWrapper((FlaskUserDeviceRegistration)_flaskUserDeviceRegistration.clone());
	}

	@Override
	public int compareTo(
		com.liferay.contacts.model.FlaskUserDeviceRegistration flaskUserDeviceRegistration) {
		return _flaskUserDeviceRegistration.compareTo(flaskUserDeviceRegistration);
	}

	@Override
	public int hashCode() {
		return _flaskUserDeviceRegistration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.contacts.model.FlaskUserDeviceRegistration> toCacheModel() {
		return _flaskUserDeviceRegistration.toCacheModel();
	}

	@Override
	public com.liferay.contacts.model.FlaskUserDeviceRegistration toEscapedModel() {
		return new FlaskUserDeviceRegistrationWrapper(_flaskUserDeviceRegistration.toEscapedModel());
	}

	@Override
	public com.liferay.contacts.model.FlaskUserDeviceRegistration toUnescapedModel() {
		return new FlaskUserDeviceRegistrationWrapper(_flaskUserDeviceRegistration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _flaskUserDeviceRegistration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _flaskUserDeviceRegistration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_flaskUserDeviceRegistration.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlaskUserDeviceRegistrationWrapper)) {
			return false;
		}

		FlaskUserDeviceRegistrationWrapper flaskUserDeviceRegistrationWrapper = (FlaskUserDeviceRegistrationWrapper)obj;

		if (Validator.equals(_flaskUserDeviceRegistration,
					flaskUserDeviceRegistrationWrapper._flaskUserDeviceRegistration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FlaskUserDeviceRegistration getWrappedFlaskUserDeviceRegistration() {
		return _flaskUserDeviceRegistration;
	}

	@Override
	public FlaskUserDeviceRegistration getWrappedModel() {
		return _flaskUserDeviceRegistration;
	}

	@Override
	public void resetOriginalValues() {
		_flaskUserDeviceRegistration.resetOriginalValues();
	}

	private FlaskUserDeviceRegistration _flaskUserDeviceRegistration;
}