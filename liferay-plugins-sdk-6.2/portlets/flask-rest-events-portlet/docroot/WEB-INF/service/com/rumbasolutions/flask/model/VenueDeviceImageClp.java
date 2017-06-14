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
import com.rumbasolutions.flask.service.VenueDeviceImageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashutosh Rai
 */
public class VenueDeviceImageClp extends BaseModelImpl<VenueDeviceImage>
	implements VenueDeviceImage {
	public VenueDeviceImageClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VenueDeviceImage.class;
	}

	@Override
	public String getModelClassName() {
		return VenueDeviceImage.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _venueDeviceImageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVenueDeviceImageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _venueDeviceImageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("venueDeviceImageId", getVenueDeviceImageId());
		attributes.put("venueDetailImageId", getVenueDetailImageId());
		attributes.put("venueId", getVenueId());
		attributes.put("deviceType", getDeviceType());
		attributes.put("venueDeviceImageUUID", getVenueDeviceImageUUID());
		attributes.put("aspectRatio", getAspectRatio());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long venueDeviceImageId = (Long)attributes.get("venueDeviceImageId");

		if (venueDeviceImageId != null) {
			setVenueDeviceImageId(venueDeviceImageId);
		}

		Long venueDetailImageId = (Long)attributes.get("venueDetailImageId");

		if (venueDetailImageId != null) {
			setVenueDetailImageId(venueDetailImageId);
		}

		Long venueId = (Long)attributes.get("venueId");

		if (venueId != null) {
			setVenueId(venueId);
		}

		String deviceType = (String)attributes.get("deviceType");

		if (deviceType != null) {
			setDeviceType(deviceType);
		}

		String venueDeviceImageUUID = (String)attributes.get(
				"venueDeviceImageUUID");

		if (venueDeviceImageUUID != null) {
			setVenueDeviceImageUUID(venueDeviceImageUUID);
		}

		String aspectRatio = (String)attributes.get("aspectRatio");

		if (aspectRatio != null) {
			setAspectRatio(aspectRatio);
		}
	}

	@Override
	public long getVenueDeviceImageId() {
		return _venueDeviceImageId;
	}

	@Override
	public void setVenueDeviceImageId(long venueDeviceImageId) {
		_venueDeviceImageId = venueDeviceImageId;

		if (_venueDeviceImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueDeviceImageRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDeviceImageId",
						long.class);

				method.invoke(_venueDeviceImageRemoteModel, venueDeviceImageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVenueDetailImageId() {
		return _venueDetailImageId;
	}

	@Override
	public void setVenueDetailImageId(long venueDetailImageId) {
		_venueDetailImageId = venueDetailImageId;

		if (_venueDeviceImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueDeviceImageRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailImageId",
						long.class);

				method.invoke(_venueDeviceImageRemoteModel, venueDetailImageId);
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

		if (_venueDeviceImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueDeviceImageRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueId", long.class);

				method.invoke(_venueDeviceImageRemoteModel, venueId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeviceType() {
		return _deviceType;
	}

	@Override
	public void setDeviceType(String deviceType) {
		_deviceType = deviceType;

		if (_venueDeviceImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueDeviceImageRemoteModel.getClass();

				Method method = clazz.getMethod("setDeviceType", String.class);

				method.invoke(_venueDeviceImageRemoteModel, deviceType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueDeviceImageUUID() {
		return _venueDeviceImageUUID;
	}

	@Override
	public void setVenueDeviceImageUUID(String venueDeviceImageUUID) {
		_venueDeviceImageUUID = venueDeviceImageUUID;

		if (_venueDeviceImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueDeviceImageRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDeviceImageUUID",
						String.class);

				method.invoke(_venueDeviceImageRemoteModel, venueDeviceImageUUID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAspectRatio() {
		return _aspectRatio;
	}

	@Override
	public void setAspectRatio(String aspectRatio) {
		_aspectRatio = aspectRatio;

		if (_venueDeviceImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueDeviceImageRemoteModel.getClass();

				Method method = clazz.getMethod("setAspectRatio", String.class);

				method.invoke(_venueDeviceImageRemoteModel, aspectRatio);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVenueDeviceImageRemoteModel() {
		return _venueDeviceImageRemoteModel;
	}

	public void setVenueDeviceImageRemoteModel(
		BaseModel<?> venueDeviceImageRemoteModel) {
		_venueDeviceImageRemoteModel = venueDeviceImageRemoteModel;
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

		Class<?> remoteModelClass = _venueDeviceImageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_venueDeviceImageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VenueDeviceImageLocalServiceUtil.addVenueDeviceImage(this);
		}
		else {
			VenueDeviceImageLocalServiceUtil.updateVenueDeviceImage(this);
		}
	}

	@Override
	public VenueDeviceImage toEscapedModel() {
		return (VenueDeviceImage)ProxyUtil.newProxyInstance(VenueDeviceImage.class.getClassLoader(),
			new Class[] { VenueDeviceImage.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VenueDeviceImageClp clone = new VenueDeviceImageClp();

		clone.setVenueDeviceImageId(getVenueDeviceImageId());
		clone.setVenueDetailImageId(getVenueDetailImageId());
		clone.setVenueId(getVenueId());
		clone.setDeviceType(getDeviceType());
		clone.setVenueDeviceImageUUID(getVenueDeviceImageUUID());
		clone.setAspectRatio(getAspectRatio());

		return clone;
	}

	@Override
	public int compareTo(VenueDeviceImage venueDeviceImage) {
		long primaryKey = venueDeviceImage.getPrimaryKey();

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

		if (!(obj instanceof VenueDeviceImageClp)) {
			return false;
		}

		VenueDeviceImageClp venueDeviceImage = (VenueDeviceImageClp)obj;

		long primaryKey = venueDeviceImage.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{venueDeviceImageId=");
		sb.append(getVenueDeviceImageId());
		sb.append(", venueDetailImageId=");
		sb.append(getVenueDetailImageId());
		sb.append(", venueId=");
		sb.append(getVenueId());
		sb.append(", deviceType=");
		sb.append(getDeviceType());
		sb.append(", venueDeviceImageUUID=");
		sb.append(getVenueDeviceImageUUID());
		sb.append(", aspectRatio=");
		sb.append(getAspectRatio());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.VenueDeviceImage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>venueDeviceImageId</column-name><column-value><![CDATA[");
		sb.append(getVenueDeviceImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDetailImageId</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueId</column-name><column-value><![CDATA[");
		sb.append(getVenueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deviceType</column-name><column-value><![CDATA[");
		sb.append(getDeviceType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDeviceImageUUID</column-name><column-value><![CDATA[");
		sb.append(getVenueDeviceImageUUID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aspectRatio</column-name><column-value><![CDATA[");
		sb.append(getAspectRatio());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _venueDeviceImageId;
	private long _venueDetailImageId;
	private long _venueId;
	private String _deviceType;
	private String _venueDeviceImageUUID;
	private String _aspectRatio;
	private BaseModel<?> _venueDeviceImageRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}