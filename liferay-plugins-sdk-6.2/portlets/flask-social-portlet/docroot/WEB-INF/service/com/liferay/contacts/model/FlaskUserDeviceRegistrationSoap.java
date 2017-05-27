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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.contacts.service.http.FlaskUserDeviceRegistrationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contacts.service.http.FlaskUserDeviceRegistrationServiceSoap
 * @generated
 */
public class FlaskUserDeviceRegistrationSoap implements Serializable {
	public static FlaskUserDeviceRegistrationSoap toSoapModel(
		FlaskUserDeviceRegistration model) {
		FlaskUserDeviceRegistrationSoap soapModel = new FlaskUserDeviceRegistrationSoap();

		soapModel.setUserDeviceRegistrationId(model.getUserDeviceRegistrationId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserEmail(model.getUserEmail());
		soapModel.setDevicePlatform(model.getDevicePlatform());
		soapModel.setDeviceDetails(model.getDeviceDetails());
		soapModel.setDeviceToken(model.getDeviceToken());
		soapModel.setRegistrationTime(model.getRegistrationTime());
		soapModel.setActive(model.getActive());
		soapModel.setLastNotificationTime(model.getLastNotificationTime());
		soapModel.setLastNotificationMsg(model.getLastNotificationMsg());

		return soapModel;
	}

	public static FlaskUserDeviceRegistrationSoap[] toSoapModels(
		FlaskUserDeviceRegistration[] models) {
		FlaskUserDeviceRegistrationSoap[] soapModels = new FlaskUserDeviceRegistrationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FlaskUserDeviceRegistrationSoap[][] toSoapModels(
		FlaskUserDeviceRegistration[][] models) {
		FlaskUserDeviceRegistrationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FlaskUserDeviceRegistrationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FlaskUserDeviceRegistrationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FlaskUserDeviceRegistrationSoap[] toSoapModels(
		List<FlaskUserDeviceRegistration> models) {
		List<FlaskUserDeviceRegistrationSoap> soapModels = new ArrayList<FlaskUserDeviceRegistrationSoap>(models.size());

		for (FlaskUserDeviceRegistration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FlaskUserDeviceRegistrationSoap[soapModels.size()]);
	}

	public FlaskUserDeviceRegistrationSoap() {
	}

	public long getPrimaryKey() {
		return _userDeviceRegistrationId;
	}

	public void setPrimaryKey(long pk) {
		setUserDeviceRegistrationId(pk);
	}

	public long getUserDeviceRegistrationId() {
		return _userDeviceRegistrationId;
	}

	public void setUserDeviceRegistrationId(long userDeviceRegistrationId) {
		_userDeviceRegistrationId = userDeviceRegistrationId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserEmail() {
		return _userEmail;
	}

	public void setUserEmail(String userEmail) {
		_userEmail = userEmail;
	}

	public String getDevicePlatform() {
		return _devicePlatform;
	}

	public void setDevicePlatform(String devicePlatform) {
		_devicePlatform = devicePlatform;
	}

	public String getDeviceDetails() {
		return _deviceDetails;
	}

	public void setDeviceDetails(String deviceDetails) {
		_deviceDetails = deviceDetails;
	}

	public String getDeviceToken() {
		return _deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		_deviceToken = deviceToken;
	}

	public Date getRegistrationTime() {
		return _registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		_registrationTime = registrationTime;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public Date getLastNotificationTime() {
		return _lastNotificationTime;
	}

	public void setLastNotificationTime(Date lastNotificationTime) {
		_lastNotificationTime = lastNotificationTime;
	}

	public String getLastNotificationMsg() {
		return _lastNotificationMsg;
	}

	public void setLastNotificationMsg(String lastNotificationMsg) {
		_lastNotificationMsg = lastNotificationMsg;
	}

	private long _userDeviceRegistrationId;
	private long _userId;
	private String _userEmail;
	private String _devicePlatform;
	private String _deviceDetails;
	private String _deviceToken;
	private Date _registrationTime;
	private boolean _active;
	private Date _lastNotificationTime;
	private String _lastNotificationMsg;
}