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

import com.rumbasolutions.flask.service.ClpSerializer;
import com.rumbasolutions.flask.service.EventTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashutosh Rai
 */
public class EventTypeClp extends BaseModelImpl<EventType> implements EventType {
	public EventTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EventType.class;
	}

	@Override
	public String getModelClassName() {
		return EventType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _eventTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventTypeId", getEventTypeId());
		attributes.put("eventTypeKey", getEventTypeKey());
		attributes.put("eventTypeName", getEventTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventTypeId = (Long)attributes.get("eventTypeId");

		if (eventTypeId != null) {
			setEventTypeId(eventTypeId);
		}

		String eventTypeKey = (String)attributes.get("eventTypeKey");

		if (eventTypeKey != null) {
			setEventTypeKey(eventTypeKey);
		}

		String eventTypeName = (String)attributes.get("eventTypeName");

		if (eventTypeName != null) {
			setEventTypeName(eventTypeName);
		}
	}

	@Override
	public long getEventTypeId() {
		return _eventTypeId;
	}

	@Override
	public void setEventTypeId(long eventTypeId) {
		_eventTypeId = eventTypeId;

		if (_eventTypeRemoteModel != null) {
			try {
				Class<?> clazz = _eventTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setEventTypeId", long.class);

				method.invoke(_eventTypeRemoteModel, eventTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventTypeKey() {
		return _eventTypeKey;
	}

	@Override
	public void setEventTypeKey(String eventTypeKey) {
		_eventTypeKey = eventTypeKey;

		if (_eventTypeRemoteModel != null) {
			try {
				Class<?> clazz = _eventTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setEventTypeKey", String.class);

				method.invoke(_eventTypeRemoteModel, eventTypeKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventTypeName() {
		return _eventTypeName;
	}

	@Override
	public void setEventTypeName(String eventTypeName) {
		_eventTypeName = eventTypeName;

		if (_eventTypeRemoteModel != null) {
			try {
				Class<?> clazz = _eventTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setEventTypeName", String.class);

				method.invoke(_eventTypeRemoteModel, eventTypeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEventTypeRemoteModel() {
		return _eventTypeRemoteModel;
	}

	public void setEventTypeRemoteModel(BaseModel<?> eventTypeRemoteModel) {
		_eventTypeRemoteModel = eventTypeRemoteModel;
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

		Class<?> remoteModelClass = _eventTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eventTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EventTypeLocalServiceUtil.addEventType(this);
		}
		else {
			EventTypeLocalServiceUtil.updateEventType(this);
		}
	}

	@Override
	public EventType toEscapedModel() {
		return (EventType)ProxyUtil.newProxyInstance(EventType.class.getClassLoader(),
			new Class[] { EventType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EventTypeClp clone = new EventTypeClp();

		clone.setEventTypeId(getEventTypeId());
		clone.setEventTypeKey(getEventTypeKey());
		clone.setEventTypeName(getEventTypeName());

		return clone;
	}

	@Override
	public int compareTo(EventType eventType) {
		long primaryKey = eventType.getPrimaryKey();

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

		if (!(obj instanceof EventTypeClp)) {
			return false;
		}

		EventTypeClp eventType = (EventTypeClp)obj;

		long primaryKey = eventType.getPrimaryKey();

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

		sb.append("{eventTypeId=");
		sb.append(getEventTypeId());
		sb.append(", eventTypeKey=");
		sb.append(getEventTypeKey());
		sb.append(", eventTypeName=");
		sb.append(getEventTypeName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.EventType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventTypeId</column-name><column-value><![CDATA[");
		sb.append(getEventTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventTypeKey</column-name><column-value><![CDATA[");
		sb.append(getEventTypeKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventTypeName</column-name><column-value><![CDATA[");
		sb.append(getEventTypeName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eventTypeId;
	private String _eventTypeKey;
	private String _eventTypeName;
	private BaseModel<?> _eventTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}