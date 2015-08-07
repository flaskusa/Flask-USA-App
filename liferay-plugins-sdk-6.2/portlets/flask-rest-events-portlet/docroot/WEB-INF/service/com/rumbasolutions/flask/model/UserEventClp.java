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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rumbasolutions.flask.service.ClpSerializer;
import com.rumbasolutions.flask.service.UserEventLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashutosh Rai
 */
public class UserEventClp extends BaseModelImpl<UserEvent> implements UserEvent {
	public UserEventClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UserEvent.class;
	}

	@Override
	public String getModelClassName() {
		return UserEvent.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _userEventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userEventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userEventId", getUserEventId());
		attributes.put("userId", getUserId());
		attributes.put("eventId", getEventId());
		attributes.put("createdDate", getCreatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userEventId = (Long)attributes.get("userEventId");

		if (userEventId != null) {
			setUserEventId(userEventId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}
	}

	@Override
	public long getUserEventId() {
		return _userEventId;
	}

	@Override
	public void setUserEventId(long userEventId) {
		_userEventId = userEventId;

		if (_userEventRemoteModel != null) {
			try {
				Class<?> clazz = _userEventRemoteModel.getClass();

				Method method = clazz.getMethod("setUserEventId", long.class);

				method.invoke(_userEventRemoteModel, userEventId);
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

		if (_userEventRemoteModel != null) {
			try {
				Class<?> clazz = _userEventRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_userEventRemoteModel, userId);
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
	public long getEventId() {
		return _eventId;
	}

	@Override
	public void setEventId(long eventId) {
		_eventId = eventId;

		if (_userEventRemoteModel != null) {
			try {
				Class<?> clazz = _userEventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventId", long.class);

				method.invoke(_userEventRemoteModel, eventId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_userEventRemoteModel != null) {
			try {
				Class<?> clazz = _userEventRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_userEventRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserEventRemoteModel() {
		return _userEventRemoteModel;
	}

	public void setUserEventRemoteModel(BaseModel<?> userEventRemoteModel) {
		_userEventRemoteModel = userEventRemoteModel;
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

		Class<?> remoteModelClass = _userEventRemoteModel.getClass();

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

		Object returnValue = method.invoke(_userEventRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserEventLocalServiceUtil.addUserEvent(this);
		}
		else {
			UserEventLocalServiceUtil.updateUserEvent(this);
		}
	}

	@Override
	public UserEvent toEscapedModel() {
		return (UserEvent)ProxyUtil.newProxyInstance(UserEvent.class.getClassLoader(),
			new Class[] { UserEvent.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserEventClp clone = new UserEventClp();

		clone.setUserEventId(getUserEventId());
		clone.setUserId(getUserId());
		clone.setEventId(getEventId());
		clone.setCreatedDate(getCreatedDate());

		return clone;
	}

	@Override
	public int compareTo(UserEvent userEvent) {
		long primaryKey = userEvent.getPrimaryKey();

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

		if (!(obj instanceof UserEventClp)) {
			return false;
		}

		UserEventClp userEvent = (UserEventClp)obj;

		long primaryKey = userEvent.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{userEventId=");
		sb.append(getUserEventId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", eventId=");
		sb.append(getEventId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.UserEvent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userEventId</column-name><column-value><![CDATA[");
		sb.append(getUserEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userEventId;
	private long _userId;
	private String _userUuid;
	private long _eventId;
	private Date _createdDate;
	private BaseModel<?> _userEventRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}