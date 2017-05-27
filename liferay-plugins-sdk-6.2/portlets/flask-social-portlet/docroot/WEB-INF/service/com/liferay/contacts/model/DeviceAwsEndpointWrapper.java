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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DeviceAwsEndpoint}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DeviceAwsEndpoint
 * @generated
 */
public class DeviceAwsEndpointWrapper implements DeviceAwsEndpoint,
	ModelWrapper<DeviceAwsEndpoint> {
	public DeviceAwsEndpointWrapper(DeviceAwsEndpoint deviceAwsEndpoint) {
		_deviceAwsEndpoint = deviceAwsEndpoint;
	}

	@Override
	public Class<?> getModelClass() {
		return DeviceAwsEndpoint.class;
	}

	@Override
	public String getModelClassName() {
		return DeviceAwsEndpoint.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("deviceEndPointId", getDeviceEndPointId());
		attributes.put("awsEndpoint", getAwsEndpoint());
		attributes.put("userDeviceRegistrationId", getUserDeviceRegistrationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long deviceEndPointId = (Long)attributes.get("deviceEndPointId");

		if (deviceEndPointId != null) {
			setDeviceEndPointId(deviceEndPointId);
		}

		String awsEndpoint = (String)attributes.get("awsEndpoint");

		if (awsEndpoint != null) {
			setAwsEndpoint(awsEndpoint);
		}

		Long userDeviceRegistrationId = (Long)attributes.get(
				"userDeviceRegistrationId");

		if (userDeviceRegistrationId != null) {
			setUserDeviceRegistrationId(userDeviceRegistrationId);
		}
	}

	/**
	* Returns the primary key of this device aws endpoint.
	*
	* @return the primary key of this device aws endpoint
	*/
	@Override
	public long getPrimaryKey() {
		return _deviceAwsEndpoint.getPrimaryKey();
	}

	/**
	* Sets the primary key of this device aws endpoint.
	*
	* @param primaryKey the primary key of this device aws endpoint
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_deviceAwsEndpoint.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the device end point ID of this device aws endpoint.
	*
	* @return the device end point ID of this device aws endpoint
	*/
	@Override
	public long getDeviceEndPointId() {
		return _deviceAwsEndpoint.getDeviceEndPointId();
	}

	/**
	* Sets the device end point ID of this device aws endpoint.
	*
	* @param deviceEndPointId the device end point ID of this device aws endpoint
	*/
	@Override
	public void setDeviceEndPointId(long deviceEndPointId) {
		_deviceAwsEndpoint.setDeviceEndPointId(deviceEndPointId);
	}

	/**
	* Returns the aws endpoint of this device aws endpoint.
	*
	* @return the aws endpoint of this device aws endpoint
	*/
	@Override
	public java.lang.String getAwsEndpoint() {
		return _deviceAwsEndpoint.getAwsEndpoint();
	}

	/**
	* Sets the aws endpoint of this device aws endpoint.
	*
	* @param awsEndpoint the aws endpoint of this device aws endpoint
	*/
	@Override
	public void setAwsEndpoint(java.lang.String awsEndpoint) {
		_deviceAwsEndpoint.setAwsEndpoint(awsEndpoint);
	}

	/**
	* Returns the user device registration ID of this device aws endpoint.
	*
	* @return the user device registration ID of this device aws endpoint
	*/
	@Override
	public long getUserDeviceRegistrationId() {
		return _deviceAwsEndpoint.getUserDeviceRegistrationId();
	}

	/**
	* Sets the user device registration ID of this device aws endpoint.
	*
	* @param userDeviceRegistrationId the user device registration ID of this device aws endpoint
	*/
	@Override
	public void setUserDeviceRegistrationId(long userDeviceRegistrationId) {
		_deviceAwsEndpoint.setUserDeviceRegistrationId(userDeviceRegistrationId);
	}

	@Override
	public boolean isNew() {
		return _deviceAwsEndpoint.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_deviceAwsEndpoint.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _deviceAwsEndpoint.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_deviceAwsEndpoint.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _deviceAwsEndpoint.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _deviceAwsEndpoint.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_deviceAwsEndpoint.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _deviceAwsEndpoint.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_deviceAwsEndpoint.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_deviceAwsEndpoint.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_deviceAwsEndpoint.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DeviceAwsEndpointWrapper((DeviceAwsEndpoint)_deviceAwsEndpoint.clone());
	}

	@Override
	public int compareTo(
		com.liferay.contacts.model.DeviceAwsEndpoint deviceAwsEndpoint) {
		return _deviceAwsEndpoint.compareTo(deviceAwsEndpoint);
	}

	@Override
	public int hashCode() {
		return _deviceAwsEndpoint.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.contacts.model.DeviceAwsEndpoint> toCacheModel() {
		return _deviceAwsEndpoint.toCacheModel();
	}

	@Override
	public com.liferay.contacts.model.DeviceAwsEndpoint toEscapedModel() {
		return new DeviceAwsEndpointWrapper(_deviceAwsEndpoint.toEscapedModel());
	}

	@Override
	public com.liferay.contacts.model.DeviceAwsEndpoint toUnescapedModel() {
		return new DeviceAwsEndpointWrapper(_deviceAwsEndpoint.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _deviceAwsEndpoint.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _deviceAwsEndpoint.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_deviceAwsEndpoint.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DeviceAwsEndpointWrapper)) {
			return false;
		}

		DeviceAwsEndpointWrapper deviceAwsEndpointWrapper = (DeviceAwsEndpointWrapper)obj;

		if (Validator.equals(_deviceAwsEndpoint,
					deviceAwsEndpointWrapper._deviceAwsEndpoint)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DeviceAwsEndpoint getWrappedDeviceAwsEndpoint() {
		return _deviceAwsEndpoint;
	}

	@Override
	public DeviceAwsEndpoint getWrappedModel() {
		return _deviceAwsEndpoint;
	}

	@Override
	public void resetOriginalValues() {
		_deviceAwsEndpoint.resetOriginalValues();
	}

	private DeviceAwsEndpoint _deviceAwsEndpoint;
}