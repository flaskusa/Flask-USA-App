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
import com.rumbasolutions.flask.service.InfoTypeCategoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashutosh Rai
 */
public class InfoTypeCategoryClp extends BaseModelImpl<InfoTypeCategory>
	implements InfoTypeCategory {
	public InfoTypeCategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return InfoTypeCategory.class;
	}

	@Override
	public String getModelClassName() {
		return InfoTypeCategory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _infoTypeCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInfoTypeCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _infoTypeCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("infoTypeCategoryId", getInfoTypeCategoryId());
		attributes.put("infoTypeCategoryName", getInfoTypeCategoryName());
		attributes.put("displayTemplate", getDisplayTemplate());
		attributes.put("infoTypeId", getInfoTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long infoTypeCategoryId = (Long)attributes.get("infoTypeCategoryId");

		if (infoTypeCategoryId != null) {
			setInfoTypeCategoryId(infoTypeCategoryId);
		}

		String infoTypeCategoryName = (String)attributes.get(
				"infoTypeCategoryName");

		if (infoTypeCategoryName != null) {
			setInfoTypeCategoryName(infoTypeCategoryName);
		}

		String displayTemplate = (String)attributes.get("displayTemplate");

		if (displayTemplate != null) {
			setDisplayTemplate(displayTemplate);
		}

		Long infoTypeId = (Long)attributes.get("infoTypeId");

		if (infoTypeId != null) {
			setInfoTypeId(infoTypeId);
		}
	}

	@Override
	public long getInfoTypeCategoryId() {
		return _infoTypeCategoryId;
	}

	@Override
	public void setInfoTypeCategoryId(long infoTypeCategoryId) {
		_infoTypeCategoryId = infoTypeCategoryId;

		if (_infoTypeCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _infoTypeCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setInfoTypeCategoryId",
						long.class);

				method.invoke(_infoTypeCategoryRemoteModel, infoTypeCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInfoTypeCategoryName() {
		return _infoTypeCategoryName;
	}

	@Override
	public void setInfoTypeCategoryName(String infoTypeCategoryName) {
		_infoTypeCategoryName = infoTypeCategoryName;

		if (_infoTypeCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _infoTypeCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setInfoTypeCategoryName",
						String.class);

				method.invoke(_infoTypeCategoryRemoteModel, infoTypeCategoryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisplayTemplate() {
		return _displayTemplate;
	}

	@Override
	public void setDisplayTemplate(String displayTemplate) {
		_displayTemplate = displayTemplate;

		if (_infoTypeCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _infoTypeCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayTemplate",
						String.class);

				method.invoke(_infoTypeCategoryRemoteModel, displayTemplate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInfoTypeId() {
		return _infoTypeId;
	}

	@Override
	public void setInfoTypeId(long infoTypeId) {
		_infoTypeId = infoTypeId;

		if (_infoTypeCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _infoTypeCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setInfoTypeId", long.class);

				method.invoke(_infoTypeCategoryRemoteModel, infoTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getInfoTypeCategoryRemoteModel() {
		return _infoTypeCategoryRemoteModel;
	}

	public void setInfoTypeCategoryRemoteModel(
		BaseModel<?> infoTypeCategoryRemoteModel) {
		_infoTypeCategoryRemoteModel = infoTypeCategoryRemoteModel;
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

		Class<?> remoteModelClass = _infoTypeCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_infoTypeCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			InfoTypeCategoryLocalServiceUtil.addInfoTypeCategory(this);
		}
		else {
			InfoTypeCategoryLocalServiceUtil.updateInfoTypeCategory(this);
		}
	}

	@Override
	public InfoTypeCategory toEscapedModel() {
		return (InfoTypeCategory)ProxyUtil.newProxyInstance(InfoTypeCategory.class.getClassLoader(),
			new Class[] { InfoTypeCategory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InfoTypeCategoryClp clone = new InfoTypeCategoryClp();

		clone.setInfoTypeCategoryId(getInfoTypeCategoryId());
		clone.setInfoTypeCategoryName(getInfoTypeCategoryName());
		clone.setDisplayTemplate(getDisplayTemplate());
		clone.setInfoTypeId(getInfoTypeId());

		return clone;
	}

	@Override
	public int compareTo(InfoTypeCategory infoTypeCategory) {
		long primaryKey = infoTypeCategory.getPrimaryKey();

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

		if (!(obj instanceof InfoTypeCategoryClp)) {
			return false;
		}

		InfoTypeCategoryClp infoTypeCategory = (InfoTypeCategoryClp)obj;

		long primaryKey = infoTypeCategory.getPrimaryKey();

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

		sb.append("{infoTypeCategoryId=");
		sb.append(getInfoTypeCategoryId());
		sb.append(", infoTypeCategoryName=");
		sb.append(getInfoTypeCategoryName());
		sb.append(", displayTemplate=");
		sb.append(getDisplayTemplate());
		sb.append(", infoTypeId=");
		sb.append(getInfoTypeId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.InfoTypeCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>infoTypeCategoryId</column-name><column-value><![CDATA[");
		sb.append(getInfoTypeCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoTypeCategoryName</column-name><column-value><![CDATA[");
		sb.append(getInfoTypeCategoryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayTemplate</column-name><column-value><![CDATA[");
		sb.append(getDisplayTemplate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoTypeId</column-name><column-value><![CDATA[");
		sb.append(getInfoTypeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _infoTypeCategoryId;
	private String _infoTypeCategoryName;
	private String _displayTemplate;
	private long _infoTypeId;
	private BaseModel<?> _infoTypeCategoryRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}