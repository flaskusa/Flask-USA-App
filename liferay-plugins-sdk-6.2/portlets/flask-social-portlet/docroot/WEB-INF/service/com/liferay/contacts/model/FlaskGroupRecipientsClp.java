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
import com.liferay.contacts.service.FlaskGroupRecipientsLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class FlaskGroupRecipientsClp extends BaseModelImpl<FlaskGroupRecipients>
	implements FlaskGroupRecipients {
	public FlaskGroupRecipientsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskGroupRecipients.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskGroupRecipients.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _groupRecipientId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGroupRecipientId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _groupRecipientId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupRecipientId", getGroupRecipientId());
		attributes.put("groupId", getGroupId());
		attributes.put("recipients", getRecipients());
		attributes.put("groupMessageId", getGroupMessageId());
		attributes.put("read", getRead());
		attributes.put("receivedDateTime", getReceivedDateTime());
		attributes.put("senderId", getSenderId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupRecipientId = (Long)attributes.get("groupRecipientId");

		if (groupRecipientId != null) {
			setGroupRecipientId(groupRecipientId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String recipients = (String)attributes.get("recipients");

		if (recipients != null) {
			setRecipients(recipients);
		}

		Long groupMessageId = (Long)attributes.get("groupMessageId");

		if (groupMessageId != null) {
			setGroupMessageId(groupMessageId);
		}

		String read = (String)attributes.get("read");

		if (read != null) {
			setRead(read);
		}

		Date receivedDateTime = (Date)attributes.get("receivedDateTime");

		if (receivedDateTime != null) {
			setReceivedDateTime(receivedDateTime);
		}

		Long senderId = (Long)attributes.get("senderId");

		if (senderId != null) {
			setSenderId(senderId);
		}
	}

	@Override
	public long getGroupRecipientId() {
		return _groupRecipientId;
	}

	@Override
	public void setGroupRecipientId(long groupRecipientId) {
		_groupRecipientId = groupRecipientId;

		if (_flaskGroupRecipientsRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupRecipientsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupRecipientId",
						long.class);

				method.invoke(_flaskGroupRecipientsRemoteModel, groupRecipientId);
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

		if (_flaskGroupRecipientsRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupRecipientsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_flaskGroupRecipientsRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRecipients() {
		return _recipients;
	}

	@Override
	public void setRecipients(String recipients) {
		_recipients = recipients;

		if (_flaskGroupRecipientsRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupRecipientsRemoteModel.getClass();

				Method method = clazz.getMethod("setRecipients", String.class);

				method.invoke(_flaskGroupRecipientsRemoteModel, recipients);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupMessageId() {
		return _groupMessageId;
	}

	@Override
	public void setGroupMessageId(long groupMessageId) {
		_groupMessageId = groupMessageId;

		if (_flaskGroupRecipientsRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupRecipientsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupMessageId", long.class);

				method.invoke(_flaskGroupRecipientsRemoteModel, groupMessageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRead() {
		return _read;
	}

	@Override
	public void setRead(String read) {
		_read = read;

		if (_flaskGroupRecipientsRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupRecipientsRemoteModel.getClass();

				Method method = clazz.getMethod("setRead", String.class);

				method.invoke(_flaskGroupRecipientsRemoteModel, read);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getReceivedDateTime() {
		return _receivedDateTime;
	}

	@Override
	public void setReceivedDateTime(Date receivedDateTime) {
		_receivedDateTime = receivedDateTime;

		if (_flaskGroupRecipientsRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupRecipientsRemoteModel.getClass();

				Method method = clazz.getMethod("setReceivedDateTime",
						Date.class);

				method.invoke(_flaskGroupRecipientsRemoteModel, receivedDateTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSenderId() {
		return _senderId;
	}

	@Override
	public void setSenderId(long senderId) {
		_senderId = senderId;

		if (_flaskGroupRecipientsRemoteModel != null) {
			try {
				Class<?> clazz = _flaskGroupRecipientsRemoteModel.getClass();

				Method method = clazz.getMethod("setSenderId", long.class);

				method.invoke(_flaskGroupRecipientsRemoteModel, senderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFlaskGroupRecipientsRemoteModel() {
		return _flaskGroupRecipientsRemoteModel;
	}

	public void setFlaskGroupRecipientsRemoteModel(
		BaseModel<?> flaskGroupRecipientsRemoteModel) {
		_flaskGroupRecipientsRemoteModel = flaskGroupRecipientsRemoteModel;
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

		Class<?> remoteModelClass = _flaskGroupRecipientsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_flaskGroupRecipientsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FlaskGroupRecipientsLocalServiceUtil.addFlaskGroupRecipients(this);
		}
		else {
			FlaskGroupRecipientsLocalServiceUtil.updateFlaskGroupRecipients(this);
		}
	}

	@Override
	public FlaskGroupRecipients toEscapedModel() {
		return (FlaskGroupRecipients)ProxyUtil.newProxyInstance(FlaskGroupRecipients.class.getClassLoader(),
			new Class[] { FlaskGroupRecipients.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FlaskGroupRecipientsClp clone = new FlaskGroupRecipientsClp();

		clone.setGroupRecipientId(getGroupRecipientId());
		clone.setGroupId(getGroupId());
		clone.setRecipients(getRecipients());
		clone.setGroupMessageId(getGroupMessageId());
		clone.setRead(getRead());
		clone.setReceivedDateTime(getReceivedDateTime());
		clone.setSenderId(getSenderId());

		return clone;
	}

	@Override
	public int compareTo(FlaskGroupRecipients flaskGroupRecipients) {
		int value = 0;

		value = DateUtil.compareTo(getReceivedDateTime(),
				flaskGroupRecipients.getReceivedDateTime());

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

		if (!(obj instanceof FlaskGroupRecipientsClp)) {
			return false;
		}

		FlaskGroupRecipientsClp flaskGroupRecipients = (FlaskGroupRecipientsClp)obj;

		long primaryKey = flaskGroupRecipients.getPrimaryKey();

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

		sb.append("{groupRecipientId=");
		sb.append(getGroupRecipientId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", recipients=");
		sb.append(getRecipients());
		sb.append(", groupMessageId=");
		sb.append(getGroupMessageId());
		sb.append(", read=");
		sb.append(getRead());
		sb.append(", receivedDateTime=");
		sb.append(getReceivedDateTime());
		sb.append(", senderId=");
		sb.append(getSenderId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.liferay.contacts.model.FlaskGroupRecipients");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>groupRecipientId</column-name><column-value><![CDATA[");
		sb.append(getGroupRecipientId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recipients</column-name><column-value><![CDATA[");
		sb.append(getRecipients());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupMessageId</column-name><column-value><![CDATA[");
		sb.append(getGroupMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>read</column-name><column-value><![CDATA[");
		sb.append(getRead());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receivedDateTime</column-name><column-value><![CDATA[");
		sb.append(getReceivedDateTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderId</column-name><column-value><![CDATA[");
		sb.append(getSenderId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _groupRecipientId;
	private long _groupId;
	private String _recipients;
	private long _groupMessageId;
	private String _read;
	private Date _receivedDateTime;
	private long _senderId;
	private BaseModel<?> _flaskGroupRecipientsRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.contacts.service.ClpSerializer.class;
}