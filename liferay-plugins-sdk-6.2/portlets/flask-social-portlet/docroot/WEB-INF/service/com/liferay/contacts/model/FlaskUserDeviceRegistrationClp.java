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
import com.liferay.contacts.service.FlaskUserDeviceRegistrationLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class FlaskUserDeviceRegistrationClp extends BaseModelImpl<FlaskUserDeviceRegistration>
	implements FlaskUserDeviceRegistration {
	public FlaskUserDeviceRegistrationClp() {
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
	public long getPrimaryKey() {
		return _userDeviceRegistrationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserDeviceRegistrationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userDeviceRegistrationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getUserDeviceRegistrationId() {
		return _userDeviceRegistrationId;
	}

	@Override
	public void setUserDeviceRegistrationId(long userDeviceRegistrationId) {
		_userDeviceRegistrationId = userDeviceRegistrationId;

		if (_flaskUserDeviceRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _flaskUserDeviceRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserDeviceRegistrationId",
						long.class);

				method.invoke(_flaskUserDeviceRegistrationRemoteModel,
					userDeviceRegistrationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_flaskUserDeviceRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _flaskUserDeviceRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_flaskUserDeviceRegistrationRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserEmail() {
		return _userEmail;
	}

	@Override
	public void setUserEmail(String userEmail) {
		_userEmail = userEmail;

		if (_flaskUserDeviceRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _flaskUserDeviceRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserEmail", String.class);

				method.invoke(_flaskUserDeviceRegistrationRemoteModel, userEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDevicePlatform() {
		return _devicePlatform;
	}

	@Override
	public void setDevicePlatform(String devicePlatform) {
		_devicePlatform = devicePlatform;

		if (_flaskUserDeviceRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _flaskUserDeviceRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setDevicePlatform",
						String.class);

				method.invoke(_flaskUserDeviceRegistrationRemoteModel,
					devicePlatform);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeviceDetails() {
		return _deviceDetails;
	}

	@Override
	public void setDeviceDetails(String deviceDetails) {
		_deviceDetails = deviceDetails;

		if (_flaskUserDeviceRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _flaskUserDeviceRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setDeviceDetails", String.class);

				method.invoke(_flaskUserDeviceRegistrationRemoteModel,
					deviceDetails);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeviceToken() {
		return _deviceToken;
	}

	@Override
	public void setDeviceToken(String deviceToken) {
		_deviceToken = deviceToken;

		if (_flaskUserDeviceRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _flaskUserDeviceRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setDeviceToken", String.class);

				method.invoke(_flaskUserDeviceRegistrationRemoteModel,
					deviceToken);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getRegistrationTime() {
		return _registrationTime;
	}

	@Override
	public void setRegistrationTime(Date registrationTime) {
		_registrationTime = registrationTime;

		if (_flaskUserDeviceRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _flaskUserDeviceRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setRegistrationTime",
						Date.class);

				method.invoke(_flaskUserDeviceRegistrationRemoteModel,
					registrationTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_flaskUserDeviceRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _flaskUserDeviceRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_flaskUserDeviceRegistrationRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastNotificationTime() {
		return _lastNotificationTime;
	}

	@Override
	public void setLastNotificationTime(Date lastNotificationTime) {
		_lastNotificationTime = lastNotificationTime;

		if (_flaskUserDeviceRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _flaskUserDeviceRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setLastNotificationTime",
						Date.class);

				method.invoke(_flaskUserDeviceRegistrationRemoteModel,
					lastNotificationTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastNotificationMsg() {
		return _lastNotificationMsg;
	}

	@Override
	public void setLastNotificationMsg(String lastNotificationMsg) {
		_lastNotificationMsg = lastNotificationMsg;

		if (_flaskUserDeviceRegistrationRemoteModel != null) {
			try {
				Class<?> clazz = _flaskUserDeviceRegistrationRemoteModel.getClass();

				Method method = clazz.getMethod("setLastNotificationMsg",
						String.class);

				method.invoke(_flaskUserDeviceRegistrationRemoteModel,
					lastNotificationMsg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFlaskUserDeviceRegistrationRemoteModel() {
		return _flaskUserDeviceRegistrationRemoteModel;
	}

	public void setFlaskUserDeviceRegistrationRemoteModel(
		BaseModel<?> flaskUserDeviceRegistrationRemoteModel) {
		_flaskUserDeviceRegistrationRemoteModel = flaskUserDeviceRegistrationRemoteModel;
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

		Class<?> remoteModelClass = _flaskUserDeviceRegistrationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_flaskUserDeviceRegistrationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FlaskUserDeviceRegistrationLocalServiceUtil.addFlaskUserDeviceRegistration(this);
		}
		else {
			FlaskUserDeviceRegistrationLocalServiceUtil.updateFlaskUserDeviceRegistration(this);
		}
	}

	@Override
	public FlaskUserDeviceRegistration toEscapedModel() {
		return (FlaskUserDeviceRegistration)ProxyUtil.newProxyInstance(FlaskUserDeviceRegistration.class.getClassLoader(),
			new Class[] { FlaskUserDeviceRegistration.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FlaskUserDeviceRegistrationClp clone = new FlaskUserDeviceRegistrationClp();

		clone.setUserDeviceRegistrationId(getUserDeviceRegistrationId());
		clone.setUserId(getUserId());
		clone.setUserEmail(getUserEmail());
		clone.setDevicePlatform(getDevicePlatform());
		clone.setDeviceDetails(getDeviceDetails());
		clone.setDeviceToken(getDeviceToken());
		clone.setRegistrationTime(getRegistrationTime());
		clone.setActive(getActive());
		clone.setLastNotificationTime(getLastNotificationTime());
		clone.setLastNotificationMsg(getLastNotificationMsg());

		return clone;
	}

	@Override
	public int compareTo(
		FlaskUserDeviceRegistration flaskUserDeviceRegistration) {
		long primaryKey = flaskUserDeviceRegistration.getPrimaryKey();

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

		if (!(obj instanceof FlaskUserDeviceRegistrationClp)) {
			return false;
		}

		FlaskUserDeviceRegistrationClp flaskUserDeviceRegistration = (FlaskUserDeviceRegistrationClp)obj;

		long primaryKey = flaskUserDeviceRegistration.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{userDeviceRegistrationId=");
		sb.append(getUserDeviceRegistrationId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userEmail=");
		sb.append(getUserEmail());
		sb.append(", devicePlatform=");
		sb.append(getDevicePlatform());
		sb.append(", deviceDetails=");
		sb.append(getDeviceDetails());
		sb.append(", deviceToken=");
		sb.append(getDeviceToken());
		sb.append(", registrationTime=");
		sb.append(getRegistrationTime());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", lastNotificationTime=");
		sb.append(getLastNotificationTime());
		sb.append(", lastNotificationMsg=");
		sb.append(getLastNotificationMsg());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.contacts.model.FlaskUserDeviceRegistration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userDeviceRegistrationId</column-name><column-value><![CDATA[");
		sb.append(getUserDeviceRegistrationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userEmail</column-name><column-value><![CDATA[");
		sb.append(getUserEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>devicePlatform</column-name><column-value><![CDATA[");
		sb.append(getDevicePlatform());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deviceDetails</column-name><column-value><![CDATA[");
		sb.append(getDeviceDetails());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deviceToken</column-name><column-value><![CDATA[");
		sb.append(getDeviceToken());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>registrationTime</column-name><column-value><![CDATA[");
		sb.append(getRegistrationTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastNotificationTime</column-name><column-value><![CDATA[");
		sb.append(getLastNotificationTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastNotificationMsg</column-name><column-value><![CDATA[");
		sb.append(getLastNotificationMsg());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userDeviceRegistrationId;
	private long _userId;
	private String _userUuid;
	private String _userEmail;
	private String _devicePlatform;
	private String _deviceDetails;
	private String _deviceToken;
	private Date _registrationTime;
	private boolean _active;
	private Date _lastNotificationTime;
	private String _lastNotificationMsg;
	private BaseModel<?> _flaskUserDeviceRegistrationRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.contacts.service.ClpSerializer.class;
}