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

import com.liferay.contacts.service.ClpSerializer;
import com.liferay.contacts.service.DeviceAwsEndpointLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class DeviceAwsEndpointClp extends BaseModelImpl<DeviceAwsEndpoint>
	implements DeviceAwsEndpoint {
	public DeviceAwsEndpointClp() {
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
	public long getPrimaryKey() {
		return _deviceEndPointId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDeviceEndPointId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _deviceEndPointId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getDeviceEndPointId() {
		return _deviceEndPointId;
	}

	@Override
	public void setDeviceEndPointId(long deviceEndPointId) {
		_deviceEndPointId = deviceEndPointId;

		if (_deviceAwsEndpointRemoteModel != null) {
			try {
				Class<?> clazz = _deviceAwsEndpointRemoteModel.getClass();

				Method method = clazz.getMethod("setDeviceEndPointId",
						long.class);

				method.invoke(_deviceAwsEndpointRemoteModel, deviceEndPointId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAwsEndpoint() {
		return _awsEndpoint;
	}

	@Override
	public void setAwsEndpoint(String awsEndpoint) {
		_awsEndpoint = awsEndpoint;

		if (_deviceAwsEndpointRemoteModel != null) {
			try {
				Class<?> clazz = _deviceAwsEndpointRemoteModel.getClass();

				Method method = clazz.getMethod("setAwsEndpoint", String.class);

				method.invoke(_deviceAwsEndpointRemoteModel, awsEndpoint);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserDeviceRegistrationId() {
		return _userDeviceRegistrationId;
	}

	@Override
	public void setUserDeviceRegistrationId(long userDeviceRegistrationId) {
		_userDeviceRegistrationId = userDeviceRegistrationId;

		if (_deviceAwsEndpointRemoteModel != null) {
			try {
				Class<?> clazz = _deviceAwsEndpointRemoteModel.getClass();

				Method method = clazz.getMethod("setUserDeviceRegistrationId",
						long.class);

				method.invoke(_deviceAwsEndpointRemoteModel,
					userDeviceRegistrationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDeviceAwsEndpointRemoteModel() {
		return _deviceAwsEndpointRemoteModel;
	}

	public void setDeviceAwsEndpointRemoteModel(
		BaseModel<?> deviceAwsEndpointRemoteModel) {
		_deviceAwsEndpointRemoteModel = deviceAwsEndpointRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _deviceAwsEndpointRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_deviceAwsEndpointRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DeviceAwsEndpointLocalServiceUtil.addDeviceAwsEndpoint(this);
		}
		else {
			DeviceAwsEndpointLocalServiceUtil.updateDeviceAwsEndpoint(this);
		}
	}

	@Override
	public DeviceAwsEndpoint toEscapedModel() {
		return (DeviceAwsEndpoint)ProxyUtil.newProxyInstance(DeviceAwsEndpoint.class.getClassLoader(),
			new Class[] { DeviceAwsEndpoint.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DeviceAwsEndpointClp clone = new DeviceAwsEndpointClp();

		clone.setDeviceEndPointId(getDeviceEndPointId());
		clone.setAwsEndpoint(getAwsEndpoint());
		clone.setUserDeviceRegistrationId(getUserDeviceRegistrationId());

		return clone;
	}

	@Override
	public int compareTo(DeviceAwsEndpoint deviceAwsEndpoint) {
		long primaryKey = deviceAwsEndpoint.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DeviceAwsEndpointClp)) {
			return false;
		}

		DeviceAwsEndpointClp deviceAwsEndpoint = (DeviceAwsEndpointClp)obj;

		long primaryKey = deviceAwsEndpoint.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{deviceEndPointId=");
		sb.append(getDeviceEndPointId());
		sb.append(", awsEndpoint=");
		sb.append(getAwsEndpoint());
		sb.append(", userDeviceRegistrationId=");
		sb.append(getUserDeviceRegistrationId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.contacts.model.DeviceAwsEndpoint");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>deviceEndPointId</column-name><column-value><![CDATA[");
		sb.append(getDeviceEndPointId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>awsEndpoint</column-name><column-value><![CDATA[");
		sb.append(getAwsEndpoint());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userDeviceRegistrationId</column-name><column-value><![CDATA[");
		sb.append(getUserDeviceRegistrationId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _deviceEndPointId;
	private String _awsEndpoint;
	private long _userDeviceRegistrationId;
	private BaseModel<?> _deviceAwsEndpointRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.contacts.service.ClpSerializer.class;
}