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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rumbasolutions.flask.service.ClpSerializer;
import com.rumbasolutions.flask.service.EventLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashutosh Rai
 */
public class EventClp extends BaseModelImpl<Event> implements Event {
	public EventClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Event.class;
	}

	@Override
	public String getModelClassName() {
		return Event.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _eventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventId", getEventId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventName", getEventName());
		attributes.put("description", getDescription());
		attributes.put("eventDate", getEventDate());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("eventTypeId", getEventTypeId());
		attributes.put("eventTypeName", getEventTypeName());
		attributes.put("eventImagePath", getEventImagePath());
		attributes.put("venueId", getVenueId());
		attributes.put("venueName", getVenueName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
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

		String eventName = (String)attributes.get("eventName");

		if (eventName != null) {
			setEventName(eventName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date eventDate = (Date)attributes.get("eventDate");

		if (eventDate != null) {
			setEventDate(eventDate);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Long eventTypeId = (Long)attributes.get("eventTypeId");

		if (eventTypeId != null) {
			setEventTypeId(eventTypeId);
		}

		String eventTypeName = (String)attributes.get("eventTypeName");

		if (eventTypeName != null) {
			setEventTypeName(eventTypeName);
		}

		String eventImagePath = (String)attributes.get("eventImagePath");

		if (eventImagePath != null) {
			setEventImagePath(eventImagePath);
		}

		Long venueId = (Long)attributes.get("venueId");

		if (venueId != null) {
			setVenueId(venueId);
		}

		String venueName = (String)attributes.get("venueName");

		if (venueName != null) {
			setVenueName(venueName);
		}
	}

	@Override
	public long getEventId() {
		return _eventId;
	}

	@Override
	public void setEventId(long eventId) {
		_eventId = eventId;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventId", long.class);

				method.invoke(_eventRemoteModel, eventId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_eventRemoteModel, companyId);
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

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_eventRemoteModel, userId);
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
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_eventRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_eventRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventName() {
		return _eventName;
	}

	@Override
	public void setEventName(String eventName) {
		_eventName = eventName;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventName", String.class);

				method.invoke(_eventRemoteModel, eventName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_eventRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEventDate() {
		return _eventDate;
	}

	@Override
	public void setEventDate(Date eventDate) {
		_eventDate = eventDate;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDate", Date.class);

				method.invoke(_eventRemoteModel, eventDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(Date startTime) {
		_startTime = startTime;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setStartTime", Date.class);

				method.invoke(_eventRemoteModel, startTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		_endTime = endTime;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setEndTime", Date.class);

				method.invoke(_eventRemoteModel, endTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEventTypeId() {
		return _eventTypeId;
	}

	@Override
	public void setEventTypeId(long eventTypeId) {
		_eventTypeId = eventTypeId;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventTypeId", long.class);

				method.invoke(_eventRemoteModel, eventTypeId);
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

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventTypeName", String.class);

				method.invoke(_eventRemoteModel, eventTypeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventImagePath() {
		return _eventImagePath;
	}

	@Override
	public void setEventImagePath(String eventImagePath) {
		_eventImagePath = eventImagePath;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setEventImagePath",
						String.class);

				method.invoke(_eventRemoteModel, eventImagePath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVenueId() {
		return _venueId;
	}

	@Override
	public void setVenueId(long venueId) {
		_venueId = venueId;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueId", long.class);

				method.invoke(_eventRemoteModel, venueId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueName() {
		return _venueName;
	}

	@Override
	public void setVenueName(String venueName) {
		_venueName = venueName;

		if (_eventRemoteModel != null) {
			try {
				Class<?> clazz = _eventRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueName", String.class);

				method.invoke(_eventRemoteModel, venueName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEventRemoteModel() {
		return _eventRemoteModel;
	}

	public void setEventRemoteModel(BaseModel<?> eventRemoteModel) {
		_eventRemoteModel = eventRemoteModel;
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

		Class<?> remoteModelClass = _eventRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eventRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EventLocalServiceUtil.addEvent(this);
		}
		else {
			EventLocalServiceUtil.updateEvent(this);
		}
	}

	@Override
	public Event toEscapedModel() {
		return (Event)ProxyUtil.newProxyInstance(Event.class.getClassLoader(),
			new Class[] { Event.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EventClp clone = new EventClp();

		clone.setEventId(getEventId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEventName(getEventName());
		clone.setDescription(getDescription());
		clone.setEventDate(getEventDate());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setEventTypeId(getEventTypeId());
		clone.setEventTypeName(getEventTypeName());
		clone.setEventImagePath(getEventImagePath());
		clone.setVenueId(getVenueId());
		clone.setVenueName(getVenueName());

		return clone;
	}

	@Override
	public int compareTo(Event event) {
		int value = 0;

		value = DateUtil.compareTo(getEventDate(), event.getEventDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventClp)) {
			return false;
		}

		EventClp event = (EventClp)obj;

		long primaryKey = event.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{eventId=");
		sb.append(getEventId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", eventName=");
		sb.append(getEventName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", eventDate=");
		sb.append(getEventDate());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", eventTypeId=");
		sb.append(getEventTypeId());
		sb.append(", eventTypeName=");
		sb.append(getEventTypeName());
		sb.append(", eventImagePath=");
		sb.append(getEventImagePath());
		sb.append(", venueId=");
		sb.append(getVenueId());
		sb.append(", venueName=");
		sb.append(getVenueName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.Event");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventName</column-name><column-value><![CDATA[");
		sb.append(getEventName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDate</column-name><column-value><![CDATA[");
		sb.append(getEventDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventTypeId</column-name><column-value><![CDATA[");
		sb.append(getEventTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventTypeName</column-name><column-value><![CDATA[");
		sb.append(getEventTypeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventImagePath</column-name><column-value><![CDATA[");
		sb.append(getEventImagePath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueId</column-name><column-value><![CDATA[");
		sb.append(getVenueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueName</column-name><column-value><![CDATA[");
		sb.append(getVenueName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eventId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _eventName;
	private String _description;
	private Date _eventDate;
	private Date _startTime;
	private Date _endTime;
	private long _eventTypeId;
	private String _eventTypeName;
	private String _eventImagePath;
	private long _venueId;
	private String _venueName;
	private BaseModel<?> _eventRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}