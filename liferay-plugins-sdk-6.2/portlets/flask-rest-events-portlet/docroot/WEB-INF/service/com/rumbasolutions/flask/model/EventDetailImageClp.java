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
import com.rumbasolutions.flask.service.EventDetailImageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashutosh Rai
 */
public class EventDetailImageClp extends BaseModelImpl<EventDetailImage>
	implements EventDetailImage {
	public EventDetailImageClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EventDetailImage.class;
	}

	@Override
	public String getModelClassName() {
		return EventDetailImage.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _eventDetailImageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventDetailImageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventDetailImageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventDetailImageId", getEventDetailImageId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventDetailId", getEventDetailId());
		attributes.put("eventDetailImagetitle", getEventDetailImagetitle());
		attributes.put("eventDetailImageDesc", getEventDetailImageDesc());
		attributes.put("eventDetailImageData", getEventDetailImageData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventDetailImageId = (Long)attributes.get("eventDetailImageId");

		if (eventDetailImageId != null) {
			setEventDetailImageId(eventDetailImageId);
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

		Long eventDetailId = (Long)attributes.get("eventDetailId");

		if (eventDetailId != null) {
			setEventDetailId(eventDetailId);
		}

		String eventDetailImagetitle = (String)attributes.get(
				"eventDetailImagetitle");

		if (eventDetailImagetitle != null) {
			setEventDetailImagetitle(eventDetailImagetitle);
		}

		String eventDetailImageDesc = (String)attributes.get(
				"eventDetailImageDesc");

		if (eventDetailImageDesc != null) {
			setEventDetailImageDesc(eventDetailImageDesc);
		}

		Blob eventDetailImageData = (Blob)attributes.get("eventDetailImageData");

		if (eventDetailImageData != null) {
			setEventDetailImageData(eventDetailImageData);
		}
	}

	@Override
	public long getEventDetailImageId() {
		return _eventDetailImageId;
	}

	@Override
	public void setEventDetailImageId(long eventDetailImageId) {
		_eventDetailImageId = eventDetailImageId;

		if (_eventDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailImageId",
						long.class);

				method.invoke(_eventDetailImageRemoteModel, eventDetailImageId);
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

		if (_eventDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_eventDetailImageRemoteModel, companyId);
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

		if (_eventDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_eventDetailImageRemoteModel, userId);
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

		if (_eventDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_eventDetailImageRemoteModel, createdDate);
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

		if (_eventDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_eventDetailImageRemoteModel, modifiedDate);
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

		if (_eventDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailId", long.class);

				method.invoke(_eventDetailImageRemoteModel, eventDetailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventDetailImagetitle() {
		return _eventDetailImagetitle;
	}

	@Override
	public void setEventDetailImagetitle(String eventDetailImagetitle) {
		_eventDetailImagetitle = eventDetailImagetitle;

		if (_eventDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailImagetitle",
						String.class);

				method.invoke(_eventDetailImageRemoteModel,
					eventDetailImagetitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventDetailImageDesc() {
		return _eventDetailImageDesc;
	}

	@Override
	public void setEventDetailImageDesc(String eventDetailImageDesc) {
		_eventDetailImageDesc = eventDetailImageDesc;

		if (_eventDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailImageDesc",
						String.class);

				method.invoke(_eventDetailImageRemoteModel, eventDetailImageDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Blob getEventDetailImageData() {
		return _eventDetailImageData;
	}

	@Override
	public void setEventDetailImageData(Blob eventDetailImageData) {
		_eventDetailImageData = eventDetailImageData;

		if (_eventDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailImageData",
						Blob.class);

				method.invoke(_eventDetailImageRemoteModel, eventDetailImageData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEventDetailImageRemoteModel() {
		return _eventDetailImageRemoteModel;
	}

	public void setEventDetailImageRemoteModel(
		BaseModel<?> eventDetailImageRemoteModel) {
		_eventDetailImageRemoteModel = eventDetailImageRemoteModel;
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

		Class<?> remoteModelClass = _eventDetailImageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eventDetailImageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EventDetailImageLocalServiceUtil.addEventDetailImage(this);
		}
		else {
			EventDetailImageLocalServiceUtil.updateEventDetailImage(this);
		}
	}

	@Override
	public EventDetailImage toEscapedModel() {
		return (EventDetailImage)ProxyUtil.newProxyInstance(EventDetailImage.class.getClassLoader(),
			new Class[] { EventDetailImage.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EventDetailImageClp clone = new EventDetailImageClp();

		clone.setEventDetailImageId(getEventDetailImageId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEventDetailId(getEventDetailId());
		clone.setEventDetailImagetitle(getEventDetailImagetitle());
		clone.setEventDetailImageDesc(getEventDetailImageDesc());
		clone.setEventDetailImageData(getEventDetailImageData());

		return clone;
	}

	@Override
	public int compareTo(EventDetailImage eventDetailImage) {
		long primaryKey = eventDetailImage.getPrimaryKey();

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

		if (!(obj instanceof EventDetailImageClp)) {
			return false;
		}

		EventDetailImageClp eventDetailImage = (EventDetailImageClp)obj;

		long primaryKey = eventDetailImage.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{eventDetailImageId=");
		sb.append(getEventDetailImageId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", eventDetailId=");
		sb.append(getEventDetailId());
		sb.append(", eventDetailImagetitle=");
		sb.append(getEventDetailImagetitle());
		sb.append(", eventDetailImageDesc=");
		sb.append(getEventDetailImageDesc());
		sb.append(", eventDetailImageData=");
		sb.append(getEventDetailImageData());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.EventDetailImage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventDetailImageId</column-name><column-value><![CDATA[");
		sb.append(getEventDetailImageId());
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
			"<column><column-name>eventDetailId</column-name><column-value><![CDATA[");
		sb.append(getEventDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailImagetitle</column-name><column-value><![CDATA[");
		sb.append(getEventDetailImagetitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailImageDesc</column-name><column-value><![CDATA[");
		sb.append(getEventDetailImageDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailImageData</column-name><column-value><![CDATA[");
		sb.append(getEventDetailImageData());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eventDetailImageId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _eventDetailId;
	private String _eventDetailImagetitle;
	private String _eventDetailImageDesc;
	private Blob _eventDetailImageData;
	private BaseModel<?> _eventDetailImageRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}