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
import com.rumbasolutions.flask.service.FlaskGroupLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class FlaskGroupClp extends BaseModelImpl<FlaskGroup>
	implements FlaskGroup {
	public FlaskGroupClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskGroup.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskGroup.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _groupId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGroupId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _groupId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupId", getGroupId());
		attributes.put("groupName", getGroupName());
		attributes.put("groupDescription", getGroupDescription());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("isActive", getIsActive());
		attributes.put("isDelete", getIsDelete());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String groupName = (String)attributes.get("groupName");

		if (groupName != null) {
			setGroupName(groupName);
		}

		String groupDescription = (String)attributes.get("groupDescription");

		if (groupDescription != null) {
			setGroupDescription(groupDescription);
		}

		String createdDate = (String)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Integer isActive = (Integer)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		Integer isDelete = (Integer)attributes.get("isDelete");

		if (isDelete != null) {
			setIsDelete(isDelete);
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_flaskGroupRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_flaskGroupRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGroupName() {
		return _groupName;
	}

	@Override
	public void setGroupName(String groupName) {
		_groupName = groupName;

		if (_flaskGroupRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupName", String.class);

				method.invoke(_flaskGroupRemoteModel, groupName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGroupDescription() {
		return _groupDescription;
	}

	@Override
	public void setGroupDescription(String groupDescription) {
		_groupDescription = groupDescription;

		if (_flaskGroupRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupDescription",
						String.class);

				method.invoke(_flaskGroupRemoteModel, groupDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(String createdDate) {
		_createdDate = createdDate;

		if (_flaskGroupRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", String.class);

				method.invoke(_flaskGroupRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;

		if (_flaskGroupRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", String.class);

				method.invoke(_flaskGroupRemoteModel, createdBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIsActive() {
		return _isActive;
	}

	@Override
	public void setIsActive(int isActive) {
		_isActive = isActive;

		if (_flaskGroupRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setIsActive", int.class);

				method.invoke(_flaskGroupRemoteModel, isActive);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIsDelete() {
		return _isDelete;
	}

	@Override
	public void setIsDelete(int isDelete) {
		_isDelete = isDelete;

		if (_flaskGroupRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setIsDelete", int.class);

				method.invoke(_flaskGroupRemoteModel, isDelete);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFlaskGroupRemoteModel() {
		return _flaskGroupRemoteModel;
	}

	public void setFlaskGroupRemoteModel(BaseModel<?> flaskGroupRemoteModel) {
		_flaskGroupRemoteModel = flaskGroupRemoteModel;
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

		Class<?> remoteModelClass = _flaskGroupRemoteModel.getClass();

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

		Object returnValue = method.invoke(_flaskGroupRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FlaskGroupLocalServiceUtil.addFlaskGroup(this);
		}
		else {
			FlaskGroupLocalServiceUtil.updateFlaskGroup(this);
		}
	}

	@Override
	public FlaskGroup toEscapedModel() {
		return (FlaskGroup)ProxyUtil.newProxyInstance(FlaskGroup.class.getClassLoader(),
			new Class[] { FlaskGroup.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FlaskGroupClp clone = new FlaskGroupClp();

		clone.setGroupId(getGroupId());
		clone.setGroupName(getGroupName());
		clone.setGroupDescription(getGroupDescription());
		clone.setCreatedDate(getCreatedDate());
		clone.setCreatedBy(getCreatedBy());
		clone.setIsActive(getIsActive());
		clone.setIsDelete(getIsDelete());

		return clone;
	}

	@Override
	public int compareTo(FlaskGroup flaskGroup) {
		long primaryKey = flaskGroup.getPrimaryKey();

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

		if (!(obj instanceof FlaskGroupClp)) {
			return false;
		}

		FlaskGroupClp flaskGroup = (FlaskGroupClp)obj;

		long primaryKey = flaskGroup.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{groupId=");
		sb.append(getGroupId());
		sb.append(", groupName=");
		sb.append(getGroupName());
		sb.append(", groupDescription=");
		sb.append(getGroupDescription());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", isActive=");
		sb.append(getIsActive());
		sb.append(", isDelete=");
		sb.append(getIsDelete());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.FlaskGroup");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupName</column-name><column-value><![CDATA[");
		sb.append(getGroupName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupDescription</column-name><column-value><![CDATA[");
		sb.append(getGroupDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isActive</column-name><column-value><![CDATA[");
		sb.append(getIsActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isDelete</column-name><column-value><![CDATA[");
		sb.append(getIsDelete());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _groupId;
	private String _groupName;
	private String _groupDescription;
	private String _createdDate;
	private String _createdBy;
	private int _isActive;
	private int _isDelete;
	private BaseModel<?> _flaskGroupRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}