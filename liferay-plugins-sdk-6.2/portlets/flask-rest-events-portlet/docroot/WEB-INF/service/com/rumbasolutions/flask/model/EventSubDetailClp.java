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
import com.rumbasolutions.flask.service.EventSubDetailLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashutosh Rai
 */
public class EventSubDetailClp extends BaseModelImpl<EventSubDetail>
	implements EventSubDetail {
	public EventSubDetailClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EventSubDetail.class;
	}

	@Override
	public String getModelClassName() {
		return EventSubDetail.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _eventSubDetailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventSubDetailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventSubDetailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventSubDetailId", getEventSubDetailId());
		attributes.put("eventDetailId", getEventDetailId());
		attributes.put("eventSubDetailTitle", getEventSubDetailTitle());
		attributes.put("eventSubDetailDesc", getEventSubDetailDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventSubDetailId = (Long)attributes.get("eventSubDetailId");

		if (eventSubDetailId != null) {
			setEventSubDetailId(eventSubDetailId);
		}

		Long eventDetailId = (Long)attributes.get("eventDetailId");

		if (eventDetailId != null) {
			setEventDetailId(eventDetailId);
		}

		String eventSubDetailTitle = (String)attributes.get(
				"eventSubDetailTitle");

		if (eventSubDetailTitle != null) {
			setEventSubDetailTitle(eventSubDetailTitle);
		}

		String eventSubDetailDesc = (String)attributes.get("eventSubDetailDesc");

		if (eventSubDetailDesc != null) {
			setEventSubDetailDesc(eventSubDetailDesc);
		}
	}

	@Override
	public long getEventSubDetailId() {
		return _eventSubDetailId;
	}

	@Override
	public void setEventSubDetailId(long eventSubDetailId) {
		_eventSubDetailId = eventSubDetailId;

		if (_eventSubDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventSubDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventSubDetailId",
						long.class);

				method.invoke(_eventSubDetailRemoteModel, eventSubDetailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEventDetailId() {
		return _eventDetailId;
	}

	@Override
	public void setEventDetailId(long eventDetailId) {
		_eventDetailId = eventDetailId;

		if (_eventSubDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventSubDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailId", long.class);

				method.invoke(_eventSubDetailRemoteModel, eventDetailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventSubDetailTitle() {
		return _eventSubDetailTitle;
	}

	@Override
	public void setEventSubDetailTitle(String eventSubDetailTitle) {
		_eventSubDetailTitle = eventSubDetailTitle;

		if (_eventSubDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventSubDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventSubDetailTitle",
						String.class);

				method.invoke(_eventSubDetailRemoteModel, eventSubDetailTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventSubDetailDesc() {
		return _eventSubDetailDesc;
	}

	@Override
	public void setEventSubDetailDesc(String eventSubDetailDesc) {
		_eventSubDetailDesc = eventSubDetailDesc;

		if (_eventSubDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventSubDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventSubDetailDesc",
						String.class);

				method.invoke(_eventSubDetailRemoteModel, eventSubDetailDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEventSubDetailRemoteModel() {
		return _eventSubDetailRemoteModel;
	}

	public void setEventSubDetailRemoteModel(
		BaseModel<?> eventSubDetailRemoteModel) {
		_eventSubDetailRemoteModel = eventSubDetailRemoteModel;
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

		Class<?> remoteModelClass = _eventSubDetailRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eventSubDetailRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EventSubDetailLocalServiceUtil.addEventSubDetail(this);
		}
		else {
			EventSubDetailLocalServiceUtil.updateEventSubDetail(this);
		}
	}

	@Override
	public EventSubDetail toEscapedModel() {
		return (EventSubDetail)ProxyUtil.newProxyInstance(EventSubDetail.class.getClassLoader(),
			new Class[] { EventSubDetail.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EventSubDetailClp clone = new EventSubDetailClp();

		clone.setEventSubDetailId(getEventSubDetailId());
		clone.setEventDetailId(getEventDetailId());
		clone.setEventSubDetailTitle(getEventSubDetailTitle());
		clone.setEventSubDetailDesc(getEventSubDetailDesc());

		return clone;
	}

	@Override
	public int compareTo(EventSubDetail eventSubDetail) {
		long primaryKey = eventSubDetail.getPrimaryKey();

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

		if (!(obj instanceof EventSubDetailClp)) {
			return false;
		}

		EventSubDetailClp eventSubDetail = (EventSubDetailClp)obj;

		long primaryKey = eventSubDetail.getPrimaryKey();

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

		sb.append("{eventSubDetailId=");
		sb.append(getEventSubDetailId());
		sb.append(", eventDetailId=");
		sb.append(getEventDetailId());
		sb.append(", eventSubDetailTitle=");
		sb.append(getEventSubDetailTitle());
		sb.append(", eventSubDetailDesc=");
		sb.append(getEventSubDetailDesc());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.EventSubDetail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventSubDetailId</column-name><column-value><![CDATA[");
		sb.append(getEventSubDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailId</column-name><column-value><![CDATA[");
		sb.append(getEventDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventSubDetailTitle</column-name><column-value><![CDATA[");
		sb.append(getEventSubDetailTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventSubDetailDesc</column-name><column-value><![CDATA[");
		sb.append(getEventSubDetailDesc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eventSubDetailId;
	private long _eventDetailId;
	private String _eventSubDetailTitle;
	private String _eventSubDetailDesc;
	private BaseModel<?> _eventSubDetailRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}