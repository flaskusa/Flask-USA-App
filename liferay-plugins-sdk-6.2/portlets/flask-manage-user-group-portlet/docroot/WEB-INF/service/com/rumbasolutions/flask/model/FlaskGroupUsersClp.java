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
import com.rumbasolutions.flask.service.FlaskGroupUsersLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class FlaskGroupUsersClp extends BaseModelImpl<FlaskGroupUsers>
	implements FlaskGroupUsers {
	public FlaskGroupUsersClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskGroupUsers.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskGroupUsers.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _groupUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGroupUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _groupUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupUserId", getGroupUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("isAdmin", getIsAdmin());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupUserId = (Long)attributes.get("groupUserId");

		if (groupUserId != null) {
			setGroupUserId(groupUserId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Integer isAdmin = (Integer)attributes.get("isAdmin");

		if (isAdmin != null) {
			setIsAdmin(isAdmin);
		}
	}

	@Override
	public long getGroupUserId() {
		return _groupUserId;
	}

	@Override
	public void setGroupUserId(long groupUserId) {
		_groupUserId = groupUserId;

		if (_flaskGroupUsersRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupUserId", long.class);

				method.invoke(_flaskGroupUsersRemoteModel, groupUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGroupUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getGroupUserId(), "uuid", _groupUserUuid);
	}

	@Override
	public void setGroupUserUuid(String groupUserUuid) {
		_groupUserUuid = groupUserUuid;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_flaskGroupUsersRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_flaskGroupUsersRemoteModel, groupId);
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

		if (_flaskGroupUsersRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_flaskGroupUsersRemoteModel, userId);
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
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_flaskGroupUsersRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_flaskGroupUsersRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIsAdmin() {
		return _isAdmin;
	}

	@Override
	public void setIsAdmin(int isAdmin) {
		_isAdmin = isAdmin;

		if (_flaskGroupUsersRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setIsAdmin", int.class);

				method.invoke(_flaskGroupUsersRemoteModel, isAdmin);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFlaskGroupUsersRemoteModel() {
		return _flaskGroupUsersRemoteModel;
	}

	public void setFlaskGroupUsersRemoteModel(
		BaseModel<?> flaskGroupUsersRemoteModel) {
		_flaskGroupUsersRemoteModel = flaskGroupUsersRemoteModel;
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

		Class<?> remoteModelClass = _flaskGroupUsersRemoteModel.getClass();

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

		Object returnValue = method.invoke(_flaskGroupUsersRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FlaskGroupUsersLocalServiceUtil.addFlaskGroupUsers(this);
		}
		else {
			FlaskGroupUsersLocalServiceUtil.updateFlaskGroupUsers(this);
		}
	}

	@Override
	public FlaskGroupUsers toEscapedModel() {
		return (FlaskGroupUsers)ProxyUtil.newProxyInstance(FlaskGroupUsers.class.getClassLoader(),
			new Class[] { FlaskGroupUsers.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FlaskGroupUsersClp clone = new FlaskGroupUsersClp();

		clone.setGroupUserId(getGroupUserId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setIsAdmin(getIsAdmin());

		return clone;
	}

	@Override
	public int compareTo(FlaskGroupUsers flaskGroupUsers) {
		long primaryKey = flaskGroupUsers.getPrimaryKey();

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

		if (!(obj instanceof FlaskGroupUsersClp)) {
			return false;
		}

		FlaskGroupUsersClp flaskGroupUsers = (FlaskGroupUsersClp)obj;

		long primaryKey = flaskGroupUsers.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{groupUserId=");
		sb.append(getGroupUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", isAdmin=");
		sb.append(getIsAdmin());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.FlaskGroupUsers");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>groupUserId</column-name><column-value><![CDATA[");
		sb.append(getGroupUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isAdmin</column-name><column-value><![CDATA[");
		sb.append(getIsAdmin());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _groupUserId;
	private String _groupUserUuid;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private int _isAdmin;
	private BaseModel<?> _flaskGroupUsersRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}