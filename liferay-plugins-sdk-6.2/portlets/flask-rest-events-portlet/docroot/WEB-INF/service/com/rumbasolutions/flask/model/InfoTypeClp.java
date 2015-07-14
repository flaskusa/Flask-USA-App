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
import com.rumbasolutions.flask.service.InfoTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashutosh Rai
 */
public class InfoTypeClp extends BaseModelImpl<InfoType> implements InfoType {
	public InfoTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return InfoType.class;
	}

	@Override
	public String getModelClassName() {
		return InfoType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _infoTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInfoTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _infoTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("infoTypeId", getInfoTypeId());
		attributes.put("infoTypeName", getInfoTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long infoTypeId = (Long)attributes.get("infoTypeId");

		if (infoTypeId != null) {
			setInfoTypeId(infoTypeId);
		}

		String infoTypeName = (String)attributes.get("infoTypeName");

		if (infoTypeName != null) {
			setInfoTypeName(infoTypeName);
		}
	}

	@Override
	public long getInfoTypeId() {
		return _infoTypeId;
	}

	@Override
	public void setInfoTypeId(long infoTypeId) {
		_infoTypeId = infoTypeId;

		if (_infoTypeRemoteModel != null) {
			try {
				Class<?> clazz = _infoTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setInfoTypeId", long.class);

				method.invoke(_infoTypeRemoteModel, infoTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInfoTypeName() {
		return _infoTypeName;
	}

	@Override
	public void setInfoTypeName(String infoTypeName) {
		_infoTypeName = infoTypeName;

		if (_infoTypeRemoteModel != null) {
			try {
				Class<?> clazz = _infoTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setInfoTypeName", String.class);

				method.invoke(_infoTypeRemoteModel, infoTypeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getInfoTypeRemoteModel() {
		return _infoTypeRemoteModel;
	}

	public void setInfoTypeRemoteModel(BaseModel<?> infoTypeRemoteModel) {
		_infoTypeRemoteModel = infoTypeRemoteModel;
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

		Class<?> remoteModelClass = _infoTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_infoTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			InfoTypeLocalServiceUtil.addInfoType(this);
		}
		else {
			InfoTypeLocalServiceUtil.updateInfoType(this);
		}
	}

	@Override
	public InfoType toEscapedModel() {
		return (InfoType)ProxyUtil.newProxyInstance(InfoType.class.getClassLoader(),
			new Class[] { InfoType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InfoTypeClp clone = new InfoTypeClp();

		clone.setInfoTypeId(getInfoTypeId());
		clone.setInfoTypeName(getInfoTypeName());

		return clone;
	}

	@Override
	public int compareTo(InfoType infoType) {
		long primaryKey = infoType.getPrimaryKey();

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

		if (!(obj instanceof InfoTypeClp)) {
			return false;
		}

		InfoTypeClp infoType = (InfoTypeClp)obj;

		long primaryKey = infoType.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{infoTypeId=");
		sb.append(getInfoTypeId());
		sb.append(", infoTypeName=");
		sb.append(getInfoTypeName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.InfoType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>infoTypeId</column-name><column-value><![CDATA[");
		sb.append(getInfoTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoTypeName</column-name><column-value><![CDATA[");
		sb.append(getInfoTypeName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _infoTypeId;
	private String _infoTypeName;
	private BaseModel<?> _infoTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}