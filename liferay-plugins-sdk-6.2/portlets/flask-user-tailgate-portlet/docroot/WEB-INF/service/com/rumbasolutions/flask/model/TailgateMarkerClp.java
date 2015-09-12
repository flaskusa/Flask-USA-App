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
import com.rumbasolutions.flask.service.TailgateMarkerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class TailgateMarkerClp extends BaseModelImpl<TailgateMarker>
	implements TailgateMarker {
	public TailgateMarkerClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TailgateMarker.class;
	}

	@Override
	public String getModelClassName() {
		return TailgateMarker.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _tailgatemarkerid;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTailgatemarkerid(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tailgatemarkerid;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tailgatemarkerid", getTailgatemarkerid());
		attributes.put("tailgateid", getTailgateid());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tailgatemarkerid = (Long)attributes.get("tailgatemarkerid");

		if (tailgatemarkerid != null) {
			setTailgatemarkerid(tailgatemarkerid);
		}

		Long tailgateid = (Long)attributes.get("tailgateid");

		if (tailgateid != null) {
			setTailgateid(tailgateid);
		}

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public long getTailgatemarkerid() {
		return _tailgatemarkerid;
	}

	@Override
	public void setTailgatemarkerid(long tailgatemarkerid) {
		_tailgatemarkerid = tailgatemarkerid;

		if (_tailgateMarkerRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateMarkerRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgatemarkerid",
						long.class);

				method.invoke(_tailgateMarkerRemoteModel, tailgatemarkerid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTailgateid() {
		return _tailgateid;
	}

	@Override
	public void setTailgateid(long tailgateid) {
		_tailgateid = tailgateid;

		if (_tailgateMarkerRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateMarkerRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgateid", long.class);

				method.invoke(_tailgateMarkerRemoteModel, tailgateid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLatitude() {
		return _latitude;
	}

	@Override
	public void setLatitude(String latitude) {
		_latitude = latitude;

		if (_tailgateMarkerRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateMarkerRemoteModel.getClass();

				Method method = clazz.getMethod("setLatitude", String.class);

				method.invoke(_tailgateMarkerRemoteModel, latitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLongitude() {
		return _longitude;
	}

	@Override
	public void setLongitude(String longitude) {
		_longitude = longitude;

		if (_tailgateMarkerRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateMarkerRemoteModel.getClass();

				Method method = clazz.getMethod("setLongitude", String.class);

				method.invoke(_tailgateMarkerRemoteModel, longitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_tailgateMarkerRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateMarkerRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_tailgateMarkerRemoteModel, name);
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

		if (_tailgateMarkerRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateMarkerRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_tailgateMarkerRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTailgateMarkerRemoteModel() {
		return _tailgateMarkerRemoteModel;
	}

	public void setTailgateMarkerRemoteModel(
		BaseModel<?> tailgateMarkerRemoteModel) {
		_tailgateMarkerRemoteModel = tailgateMarkerRemoteModel;
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

		Class<?> remoteModelClass = _tailgateMarkerRemoteModel.getClass();

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

		Object returnValue = method.invoke(_tailgateMarkerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TailgateMarkerLocalServiceUtil.addTailgateMarker(this);
		}
		else {
			TailgateMarkerLocalServiceUtil.updateTailgateMarker(this);
		}
	}

	@Override
	public TailgateMarker toEscapedModel() {
		return (TailgateMarker)ProxyUtil.newProxyInstance(TailgateMarker.class.getClassLoader(),
			new Class[] { TailgateMarker.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TailgateMarkerClp clone = new TailgateMarkerClp();

		clone.setTailgatemarkerid(getTailgatemarkerid());
		clone.setTailgateid(getTailgateid());
		clone.setLatitude(getLatitude());
		clone.setLongitude(getLongitude());
		clone.setName(getName());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(TailgateMarker tailgateMarker) {
		long primaryKey = tailgateMarker.getPrimaryKey();

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

		if (!(obj instanceof TailgateMarkerClp)) {
			return false;
		}

		TailgateMarkerClp tailgateMarker = (TailgateMarkerClp)obj;

		long primaryKey = tailgateMarker.getPrimaryKey();

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

		sb.append("{tailgatemarkerid=");
		sb.append(getTailgatemarkerid());
		sb.append(", tailgateid=");
		sb.append(getTailgateid());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.TailgateMarker");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tailgatemarkerid</column-name><column-value><![CDATA[");
		sb.append(getTailgatemarkerid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tailgateid</column-name><column-value><![CDATA[");
		sb.append(getTailgateid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitude</column-name><column-value><![CDATA[");
		sb.append(getLatitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longitude</column-name><column-value><![CDATA[");
		sb.append(getLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _tailgatemarkerid;
	private long _tailgateid;
	private String _latitude;
	private String _longitude;
	private String _name;
	private String _description;
	private BaseModel<?> _tailgateMarkerRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}