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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.rumbasolutions.flask.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashutosh Rai
 */
public class FlaskRoleClp extends BaseModelImpl<FlaskRole> implements FlaskRole {
	public FlaskRoleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskRole.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskRole.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _roleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRoleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _roleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("roleId", getRoleId());
		attributes.put("roleName", getRoleName());
		attributes.put("roleDesc", getRoleDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		String roleName = (String)attributes.get("roleName");

		if (roleName != null) {
			setRoleName(roleName);
		}

		String roleDesc = (String)attributes.get("roleDesc");

		if (roleDesc != null) {
			setRoleDesc(roleDesc);
		}
	}

	@Override
	public long getRoleId() {
		return _roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		_roleId = roleId;

		if (_flaskRoleRemoteModel != null) {
			try {
				Class<?> clazz = _flaskRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setRoleId", long.class);

				method.invoke(_flaskRoleRemoteModel, roleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRoleName() {
		return _roleName;
	}

	@Override
	public void setRoleName(String roleName) {
		_roleName = roleName;

		if (_flaskRoleRemoteModel != null) {
			try {
				Class<?> clazz = _flaskRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setRoleName", String.class);

				method.invoke(_flaskRoleRemoteModel, roleName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRoleDesc() {
		return _roleDesc;
	}

	@Override
	public void setRoleDesc(String roleDesc) {
		_roleDesc = roleDesc;

		if (_flaskRoleRemoteModel != null) {
			try {
				Class<?> clazz = _flaskRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setRoleDesc", String.class);

				method.invoke(_flaskRoleRemoteModel, roleDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFlaskRoleRemoteModel() {
		return _flaskRoleRemoteModel;
	}

	public void setFlaskRoleRemoteModel(BaseModel<?> flaskRoleRemoteModel) {
		_flaskRoleRemoteModel = flaskRoleRemoteModel;
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

		Class<?> remoteModelClass = _flaskRoleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_flaskRoleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public FlaskRole toEscapedModel() {
		return (FlaskRole)ProxyUtil.newProxyInstance(FlaskRole.class.getClassLoader(),
			new Class[] { FlaskRole.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FlaskRoleClp clone = new FlaskRoleClp();

		clone.setRoleId(getRoleId());
		clone.setRoleName(getRoleName());
		clone.setRoleDesc(getRoleDesc());

		return clone;
	}

	@Override
	public int compareTo(FlaskRole flaskRole) {
		long primaryKey = flaskRole.getPrimaryKey();

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

		if (!(obj instanceof FlaskRoleClp)) {
			return false;
		}

		FlaskRoleClp flaskRole = (FlaskRoleClp)obj;

		long primaryKey = flaskRole.getPrimaryKey();

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

		sb.append("{roleId=");
		sb.append(getRoleId());
		sb.append(", roleName=");
		sb.append(getRoleName());
		sb.append(", roleDesc=");
		sb.append(getRoleDesc());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.FlaskRole");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleName</column-name><column-value><![CDATA[");
		sb.append(getRoleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleDesc</column-name><column-value><![CDATA[");
		sb.append(getRoleDesc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _roleId;
	private String _roleName;
	private String _roleDesc;
	private BaseModel<?> _flaskRoleRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}