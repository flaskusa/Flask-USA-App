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
import com.rumbasolutions.flask.service.InvitationInfoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class InvitationInfoClp extends BaseModelImpl<InvitationInfo>
	implements InvitationInfo {
	public InvitationInfoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return InvitationInfo.class;
	}

	@Override
	public String getModelClassName() {
		return InvitationInfo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _inviationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInviationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _inviationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("inviationId", getInviationId());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("description", getDescription());
		attributes.put("invitedDate", getInvitedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long inviationId = (Long)attributes.get("inviationId");

		if (inviationId != null) {
			setInviationId(inviationId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String invitedDate = (String)attributes.get("invitedDate");

		if (invitedDate != null) {
			setInvitedDate(invitedDate);
		}
	}

	@Override
	public long getInviationId() {
		return _inviationId;
	}

	@Override
	public void setInviationId(long inviationId) {
		_inviationId = inviationId;

		if (_invitationInfoRemoteModel != null) {
			try {
				Class<?> clazz = _invitationInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setInviationId", long.class);

				method.invoke(_invitationInfoRemoteModel, inviationId);
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

		if (_invitationInfoRemoteModel != null) {
			try {
				Class<?> clazz = _invitationInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_invitationInfoRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_invitationInfoRemoteModel != null) {
			try {
				Class<?> clazz = _invitationInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_invitationInfoRemoteModel, email);
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

		if (_invitationInfoRemoteModel != null) {
			try {
				Class<?> clazz = _invitationInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_invitationInfoRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInvitedDate() {
		return _invitedDate;
	}

	@Override
	public void setInvitedDate(String invitedDate) {
		_invitedDate = invitedDate;

		if (_invitationInfoRemoteModel != null) {
			try {
				Class<?> clazz = _invitationInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setInvitedDate", String.class);

				method.invoke(_invitationInfoRemoteModel, invitedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getInvitationInfoRemoteModel() {
		return _invitationInfoRemoteModel;
	}

	public void setInvitationInfoRemoteModel(
		BaseModel<?> invitationInfoRemoteModel) {
		_invitationInfoRemoteModel = invitationInfoRemoteModel;
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

		Class<?> remoteModelClass = _invitationInfoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_invitationInfoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			InvitationInfoLocalServiceUtil.addInvitationInfo(this);
		}
		else {
			InvitationInfoLocalServiceUtil.updateInvitationInfo(this);
		}
	}

	@Override
	public InvitationInfo toEscapedModel() {
		return (InvitationInfo)ProxyUtil.newProxyInstance(InvitationInfo.class.getClassLoader(),
			new Class[] { InvitationInfo.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InvitationInfoClp clone = new InvitationInfoClp();

		clone.setInviationId(getInviationId());
		clone.setName(getName());
		clone.setEmail(getEmail());
		clone.setDescription(getDescription());
		clone.setInvitedDate(getInvitedDate());

		return clone;
	}

	@Override
	public int compareTo(InvitationInfo invitationInfo) {
		long primaryKey = invitationInfo.getPrimaryKey();

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

		if (!(obj instanceof InvitationInfoClp)) {
			return false;
		}

		InvitationInfoClp invitationInfo = (InvitationInfoClp)obj;

		long primaryKey = invitationInfo.getPrimaryKey();

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

		sb.append("{inviationId=");
		sb.append(getInviationId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", invitedDate=");
		sb.append(getInvitedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.InvitationInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>inviationId</column-name><column-value><![CDATA[");
		sb.append(getInviationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>invitedDate</column-name><column-value><![CDATA[");
		sb.append(getInvitedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _inviationId;
	private String _name;
	private String _email;
	private String _description;
	private String _invitedDate;
	private BaseModel<?> _invitationInfoRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}