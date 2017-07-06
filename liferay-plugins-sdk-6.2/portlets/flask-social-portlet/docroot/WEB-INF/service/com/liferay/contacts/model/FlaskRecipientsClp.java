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
import com.liferay.contacts.service.FlaskRecipientsLocalServiceUtil;

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
public class FlaskRecipientsClp extends BaseModelImpl<FlaskRecipients>
	implements FlaskRecipients {
	public FlaskRecipientsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskRecipients.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskRecipients.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _recipientId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRecipientId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _recipientId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("recipientId", getRecipientId());
		attributes.put("userId", getUserId());
		attributes.put("email", getEmail());
		attributes.put("messageId", getMessageId());
		attributes.put("read", getRead());
		attributes.put("receivedDateTime", getReceivedDateTime());
		attributes.put("senderId", getSenderId());
		attributes.put("deletedBy", getDeletedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long recipientId = (Long)attributes.get("recipientId");

		if (recipientId != null) {
			setRecipientId(recipientId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		Boolean read = (Boolean)attributes.get("read");

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

		String deletedBy = (String)attributes.get("deletedBy");

		if (deletedBy != null) {
			setDeletedBy(deletedBy);
		}
	}

	@Override
	public long getRecipientId() {
		return _recipientId;
	}

	@Override
	public void setRecipientId(long recipientId) {
		_recipientId = recipientId;

		if (_flaskRecipientsRemoteModel != null) {
			try {
				Class<?> clazz = _flaskRecipientsRemoteModel.getClass();

				Method method = clazz.getMethod("setRecipientId", long.class);

				method.invoke(_flaskRecipientsRemoteModel, recipientId);
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

		if (_flaskRecipientsRemoteModel != null) {
			try {
				Class<?> clazz = _flaskRecipientsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_flaskRecipientsRemoteModel, userId);
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
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_flaskRecipientsRemoteModel != null) {
			try {
				Class<?> clazz = _flaskRecipientsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_flaskRecipientsRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMessageId() {
		return _messageId;
	}

	@Override
	public void setMessageId(long messageId) {
		_messageId = messageId;

		if (_flaskRecipientsRemoteModel != null) {
			try {
				Class<?> clazz = _flaskRecipientsRemoteModel.getClass();

				Method method = clazz.getMethod("setMessageId", long.class);

				method.invoke(_flaskRecipientsRemoteModel, messageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRead() {
		return _read;
	}

	@Override
	public boolean isRead() {
		return _read;
	}

	@Override
	public void setRead(boolean read) {
		_read = read;

		if (_flaskRecipientsRemoteModel != null) {
			try {
				Class<?> clazz = _flaskRecipientsRemoteModel.getClass();

				Method method = clazz.getMethod("setRead", boolean.class);

				method.invoke(_flaskRecipientsRemoteModel, read);
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

		if (_flaskRecipientsRemoteModel != null) {
			try {
				Class<?> clazz = _flaskRecipientsRemoteModel.getClass();

				Method method = clazz.getMethod("setReceivedDateTime",
						Date.class);

				method.invoke(_flaskRecipientsRemoteModel, receivedDateTime);
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

		if (_flaskRecipientsRemoteModel != null) {
			try {
				Class<?> clazz = _flaskRecipientsRemoteModel.getClass();

				Method method = clazz.getMethod("setSenderId", long.class);

				method.invoke(_flaskRecipientsRemoteModel, senderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeletedBy() {
		return _deletedBy;
	}

	@Override
	public void setDeletedBy(String deletedBy) {
		_deletedBy = deletedBy;

		if (_flaskRecipientsRemoteModel != null) {
			try {
				Class<?> clazz = _flaskRecipientsRemoteModel.getClass();

				Method method = clazz.getMethod("setDeletedBy", String.class);

				method.invoke(_flaskRecipientsRemoteModel, deletedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFlaskRecipientsRemoteModel() {
		return _flaskRecipientsRemoteModel;
	}

	public void setFlaskRecipientsRemoteModel(
		BaseModel<?> flaskRecipientsRemoteModel) {
		_flaskRecipientsRemoteModel = flaskRecipientsRemoteModel;
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

		Class<?> remoteModelClass = _flaskRecipientsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_flaskRecipientsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FlaskRecipientsLocalServiceUtil.addFlaskRecipients(this);
		}
		else {
			FlaskRecipientsLocalServiceUtil.updateFlaskRecipients(this);
		}
	}

	@Override
	public FlaskRecipients toEscapedModel() {
		return (FlaskRecipients)ProxyUtil.newProxyInstance(FlaskRecipients.class.getClassLoader(),
			new Class[] { FlaskRecipients.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FlaskRecipientsClp clone = new FlaskRecipientsClp();

		clone.setRecipientId(getRecipientId());
		clone.setUserId(getUserId());
		clone.setEmail(getEmail());
		clone.setMessageId(getMessageId());
		clone.setRead(getRead());
		clone.setReceivedDateTime(getReceivedDateTime());
		clone.setSenderId(getSenderId());
		clone.setDeletedBy(getDeletedBy());

		return clone;
	}

	@Override
	public int compareTo(FlaskRecipients flaskRecipients) {
		int value = 0;

		value = DateUtil.compareTo(getReceivedDateTime(),
				flaskRecipients.getReceivedDateTime());

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

		if (!(obj instanceof FlaskRecipientsClp)) {
			return false;
		}

		FlaskRecipientsClp flaskRecipients = (FlaskRecipientsClp)obj;

		long primaryKey = flaskRecipients.getPrimaryKey();

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

		sb.append("{recipientId=");
		sb.append(getRecipientId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", messageId=");
		sb.append(getMessageId());
		sb.append(", read=");
		sb.append(getRead());
		sb.append(", receivedDateTime=");
		sb.append(getReceivedDateTime());
		sb.append(", senderId=");
		sb.append(getSenderId());
		sb.append(", deletedBy=");
		sb.append(getDeletedBy());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.contacts.model.FlaskRecipients");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>recipientId</column-name><column-value><![CDATA[");
		sb.append(getRecipientId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
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
		sb.append(
			"<column><column-name>deletedBy</column-name><column-value><![CDATA[");
		sb.append(getDeletedBy());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _recipientId;
	private long _userId;
	private String _userUuid;
	private String _email;
	private long _messageId;
	private boolean _read;
	private Date _receivedDateTime;
	private long _senderId;
	private String _deletedBy;
	private BaseModel<?> _flaskRecipientsRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.contacts.service.ClpSerializer.class;
}