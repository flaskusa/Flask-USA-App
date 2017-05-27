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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.contacts.service.http.DeviceAwsEndpointServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contacts.service.http.DeviceAwsEndpointServiceSoap
 * @generated
 */
public class DeviceAwsEndpointSoap implements Serializable {
	public static DeviceAwsEndpointSoap toSoapModel(DeviceAwsEndpoint model) {
		DeviceAwsEndpointSoap soapModel = new DeviceAwsEndpointSoap();

		soapModel.setDeviceEndPointId(model.getDeviceEndPointId());
		soapModel.setAwsEndpoint(model.getAwsEndpoint());
		soapModel.setUserDeviceRegistrationId(model.getUserDeviceRegistrationId());

		return soapModel;
	}

	public static DeviceAwsEndpointSoap[] toSoapModels(
		DeviceAwsEndpoint[] models) {
		DeviceAwsEndpointSoap[] soapModels = new DeviceAwsEndpointSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DeviceAwsEndpointSoap[][] toSoapModels(
		DeviceAwsEndpoint[][] models) {
		DeviceAwsEndpointSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DeviceAwsEndpointSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DeviceAwsEndpointSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DeviceAwsEndpointSoap[] toSoapModels(
		List<DeviceAwsEndpoint> models) {
		List<DeviceAwsEndpointSoap> soapModels = new ArrayList<DeviceAwsEndpointSoap>(models.size());

		for (DeviceAwsEndpoint model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DeviceAwsEndpointSoap[soapModels.size()]);
	}

	public DeviceAwsEndpointSoap() {
	}

	public long getPrimaryKey() {
		return _deviceEndPointId;
	}

	public void setPrimaryKey(long pk) {
		setDeviceEndPointId(pk);
	}

	public long getDeviceEndPointId() {
		return _deviceEndPointId;
	}

	public void setDeviceEndPointId(long deviceEndPointId) {
		_deviceEndPointId = deviceEndPointId;
	}

	public String getAwsEndpoint() {
		return _awsEndpoint;
	}

	public void setAwsEndpoint(String awsEndpoint) {
		_awsEndpoint = awsEndpoint;
	}

	public long getUserDeviceRegistrationId() {
		return _userDeviceRegistrationId;
	}

	public void setUserDeviceRegistrationId(long userDeviceRegistrationId) {
		_userDeviceRegistrationId = userDeviceRegistrationId;
	}

	private long _deviceEndPointId;
	private String _awsEndpoint;
	private long _userDeviceRegistrationId;
}