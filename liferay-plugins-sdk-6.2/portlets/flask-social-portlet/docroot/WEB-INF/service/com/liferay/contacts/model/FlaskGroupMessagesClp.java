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

package com.liferay.contacts.model;

import com.liferay.contacts.service.ClpSerializer;
import com.liferay.contacts.service.FlaskGroupMessagesLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class FlaskGroupMessagesClp extends BaseModelImpl<FlaskGroupMessages>
	implements FlaskGroupMessages {
	public FlaskGroupMessagesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskGroupMessages.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskGroupMessages.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _groupMessagesId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGroupMessagesId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _groupMessagesId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupMessagesId", getGroupMessagesId());
		attributes.put("senderEmail", getSenderEmail());
		attributes.put("senderUserId", getSenderUserId());
		attributes.put("senderName", getSenderName());
		attributes.put("groupId", getGroupId());
		attributes.put("message", getMessage());
		attributes.put("sendEmail", getSendEmail());
		attributes.put("dateTime", getDateTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupMessagesId = (Long)attributes.get("groupMessagesId");

		if (groupMessagesId != null) {
			setGroupMessagesId(groupMessagesId);
		}

		String senderEmail = (String)attributes.get("senderEmail");

		if (senderEmail != null) {
			setSenderEmail(senderEmail);
		}

		Long senderUserId = (Long)attributes.get("senderUserId");

		if (senderUserId != null) {
			setSenderUserId(senderUserId);
		}

		String senderName = (String)attributes.get("senderName");

		if (senderName != null) {
			setSenderName(senderName);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Boolean sendEmail = (Boolean)attributes.get("sendEmail");

		if (sendEmail != null) {
			setSendEmail(sendEmail);
		}

		Date dateTime = (Date)attributes.get("dateTime");

		if (dateTime != null) {
			setDateTime(dateTime);
		}
	}

	@Override
	public long getGroupMessagesId() {
		return _groupMessagesId;
	}

	@Override
	public void setGroupMessagesId(long groupMessagesId) {
		_groupMessagesId = groupMessagesId;

		if (_flaskGroupMessagesRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupMessagesRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupMessagesId", long.class);

				method.invoke(_flaskGroupMessagesRemoteModel, groupMessagesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSenderEmail() {
		return _senderEmail;
	}

	@Override
	public void setSenderEmail(String senderEmail) {
		_senderEmail = senderEmail;

		if (_flaskGroupMessagesRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupMessagesRemoteModel.getClass();

				Method method = clazz.getMethod("setSenderEmail", String.class);

				method.invoke(_flaskGroupMessagesRemoteModel, senderEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSenderUserId() {
		return _senderUserId;
	}

	@Override
	public void setSenderUserId(long senderUserId) {
		_senderUserId = senderUserId;

		if (_flaskGroupMessagesRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupMessagesRemoteModel.getClass();

				Method method = clazz.getMethod("setSenderUserId", long.class);

				method.invoke(_flaskGroupMessagesRemoteModel, senderUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSenderUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getSenderUserId(), "uuid",
			_senderUserUuid);
	}

	@Override
	public void setSenderUserUuid(String senderUserUuid) {
		_senderUserUuid = senderUserUuid;
	}

	@Override
	public String getSenderName() {
		return _senderName;
	}

	@Override
	public void setSenderName(String senderName) {
		_senderName = senderName;

		if (_flaskGroupMessagesRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupMessagesRemoteModel.getClass();

				Method method = clazz.getMethod("setSenderName", String.class);

				method.invoke(_flaskGroupMessagesRemoteModel, senderName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_flaskGroupMessagesRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupMessagesRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_flaskGroupMessagesRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMessage() {
		return _message;
	}

	@Override
	public void setMessage(String message) {
		_message = message;

		if (_flaskGroupMessagesRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupMessagesRemoteModel.getClass();

				Method method = clazz.getMethod("setMessage", String.class);

				method.invoke(_flaskGroupMessagesRemoteModel, message);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getSendEmail() {
		return _sendEmail;
	}

	@Override
	public boolean isSendEmail() {
		return _sendEmail;
	}

	@Override
	public void setSendEmail(boolean sendEmail) {
		_sendEmail = sendEmail;

		if (_flaskGroupMessagesRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupMessagesRemoteModel.getClass();

				Method method = clazz.getMethod("setSendEmail", boolean.class);

				method.invoke(_flaskGroupMessagesRemoteModel, sendEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateTime() {
		return _dateTime;
	}

	@Override
	public void setDateTime(Date dateTime) {
		_dateTime = dateTime;

		if (_flaskGroupMessagesRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupMessagesRemoteModel.getClass();

				Method method = clazz.getMethod("setDateTime", Date.class);

				method.invoke(_flaskGroupMessagesRemoteModel, dateTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFlaskGroupMessagesRemoteModel() {
		return _flaskGroupMessagesRemoteModel;
	}

	public void setFlaskGroupMessagesRemoteModel(
		BaseModel<?> flaskGroupMessagesRemoteModel) {
		_flaskGroupMessagesRemoteModel = flaskGroupMessagesRemoteModel;
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

		Class<?> remoteModelClass = _flaskGroupMessagesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_flaskGroupMessagesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FlaskGroupMessagesLocalServiceUtil.addFlaskGroupMessages(this);
		}
		else {
			FlaskGroupMessagesLocalServiceUtil.updateFlaskGroupMessages(this);
		}
	}

	@Override
	public FlaskGroupMessages toEscapedModel() {
		return (FlaskGroupMessages)ProxyUtil.newProxyInstance(FlaskGroupMessages.class.getClassLoader(),
			new Class[] { FlaskGroupMessages.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FlaskGroupMessagesClp clone = new FlaskGroupMessagesClp();

		clone.setGroupMessagesId(getGroupMessagesId());
		clone.setSenderEmail(getSenderEmail());
		clone.setSenderUserId(getSenderUserId());
		clone.setSenderName(getSenderName());
		clone.setGroupId(getGroupId());
		clone.setMessage(getMessage());
		clone.setSendEmail(getSendEmail());
		clone.setDateTime(getDateTime());

		return clone;
	}

	@Override
	public int compareTo(FlaskGroupMessages flaskGroupMessages) {
		int value = 0;

		value = DateUtil.compareTo(getDateTime(),
				flaskGroupMessages.getDateTime());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlaskGroupMessagesClp)) {
			return false;
		}

		FlaskGroupMessagesClp flaskGroupMessages = (FlaskGroupMessagesClp)obj;

		long primaryKey = flaskGroupMessages.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{groupMessagesId=");
		sb.append(getGroupMessagesId());
		sb.append(", senderEmail=");
		sb.append(getSenderEmail());
		sb.append(", senderUserId=");
		sb.append(getSenderUserId());
		sb.append(", senderName=");
		sb.append(getSenderName());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", sendEmail=");
		sb.append(getSendEmail());
		sb.append(", dateTime=");
		sb.append(getDateTime());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.contacts.model.FlaskGroupMessages");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>groupMessagesId</column-name><column-value><![CDATA[");
		sb.append(getGroupMessagesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderEmail</column-name><column-value><![CDATA[");
		sb.append(getSenderEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderUserId</column-name><column-value><![CDATA[");
		sb.append(getSenderUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderName</column-name><column-value><![CDATA[");
		sb.append(getSenderName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sendEmail</column-name><column-value><![CDATA[");
		sb.append(getSendEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateTime</column-name><column-value><![CDATA[");
		sb.append(getDateTime());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _groupMessagesId;
	private String _senderEmail;
	private long _senderUserId;
	private String _senderUserUuid;
	private String _senderName;
	private long _groupId;
	private String _message;
	private boolean _sendEmail;
	private Date _dateTime;
	private BaseModel<?> _flaskGroupMessagesRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.contacts.service.ClpSerializer.class;
}