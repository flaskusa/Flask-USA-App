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
		attributes.put("imageTitle", getImageTitle());
		attributes.put("imageDesc", getImageDesc());
		attributes.put("imageUUID", getImageUUID());
		attributes.put("imageGroupId", getImageGroupId());

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

		String imageTitle = (String)attributes.get("imageTitle");

		if (imageTitle != null) {
			setImageTitle(imageTitle);
		}

		String imageDesc = (String)attributes.get("imageDesc");

		if (imageDesc != null) {
			setImageDesc(imageDesc);
		}

		String imageUUID = (String)attributes.get("imageUUID");

		if (imageUUID != null) {
			setImageUUID(imageUUID);
		}

		Long imageGroupId = (Long)attributes.get("imageGroupId");

		if (imageGroupId != null) {
			setImageGroupId(imageGroupId);
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
	public String getImageTitle() {
		return _imageTitle;
	}

	@Override
	public void setImageTitle(String imageTitle) {
		_imageTitle = imageTitle;

		if (_eventDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageTitle", String.class);

				method.invoke(_eventDetailImageRemoteModel, imageTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageDesc() {
		return _imageDesc;
	}

	@Override
	public void setImageDesc(String imageDesc) {
		_imageDesc = imageDesc;

		if (_eventDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageDesc", String.class);

				method.invoke(_eventDetailImageRemoteModel, imageDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageUUID() {
		return _imageUUID;
	}

	@Override
	public void setImageUUID(String imageUUID) {
		_imageUUID = imageUUID;

		if (_eventDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageUUID", String.class);

				method.invoke(_eventDetailImageRemoteModel, imageUUID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getImageGroupId() {
		return _imageGroupId;
	}

	@Override
	public void setImageGroupId(long imageGroupId) {
		_imageGroupId = imageGroupId;

		if (_eventDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageGroupId", long.class);

				method.invoke(_eventDetailImageRemoteModel, imageGroupId);
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
		clone.setImageTitle(getImageTitle());
		clone.setImageDesc(getImageDesc());
		clone.setImageUUID(getImageUUID());
		clone.setImageGroupId(getImageGroupId());

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
		StringBundler sb = new StringBundler(21);

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
		sb.append(", imageTitle=");
		sb.append(getImageTitle());
		sb.append(", imageDesc=");
		sb.append(getImageDesc());
		sb.append(", imageUUID=");
		sb.append(getImageUUID());
		sb.append(", imageGroupId=");
		sb.append(getImageGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

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
			"<column><column-name>imageTitle</column-name><column-value><![CDATA[");
		sb.append(getImageTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageDesc</column-name><column-value><![CDATA[");
		sb.append(getImageDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageUUID</column-name><column-value><![CDATA[");
		sb.append(getImageUUID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageGroupId</column-name><column-value><![CDATA[");
		sb.append(getImageGroupId());
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
	private String _imageTitle;
	private String _imageDesc;
	private String _imageUUID;
	private long _imageGroupId;
	private BaseModel<?> _eventDetailImageRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}