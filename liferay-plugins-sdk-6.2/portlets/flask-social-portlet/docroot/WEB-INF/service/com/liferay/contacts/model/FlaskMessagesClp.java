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
import com.liferay.contacts.service.FlaskMessagesLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
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
public class FlaskMessagesClp extends BaseModelImpl<FlaskMessages>
	implements FlaskMessages {
	public FlaskMessagesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskMessages.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskMessages.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _messageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMessageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _messageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("messageId", getMessageId());
		attributes.put("senderEmail", getSenderEmail());
		attributes.put("senderUserId", getSenderUserId());
		attributes.put("senderName", getSenderName());
		attributes.put("recipients", getRecipients());
		attributes.put("message", getMessage());
		attributes.put("sendEmail", getSendEmail());
		attributes.put("dateTime", getDateTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
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

		String recipients = (String)attributes.get("recipients");

		if (recipients != null) {
			setRecipients(recipients);
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
	public long getMessageId() {
		return _messageId;
	}

	@Override
	public void setMessageId(long messageId) {
		_messageId = messageId;

		if (_flaskMessagesRemoteModel != null) {
			try {
				Class<?> clazz = _flaskMessagesRemoteModel.getClass();

				Method method = clazz.getMethod("setMessageId", long.class);

				method.invoke(_flaskMessagesRemoteModel, messageId);
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

		if (_flaskMessagesRemoteModel != null) {
			try {
				Class<?> clazz = _flaskMessagesRemoteModel.getClass();

				Method method = clazz.getMethod("setSenderEmail", String.class);

				method.invoke(_flaskMessagesRemoteModel, senderEmail);
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

		if (_flaskMessagesRemoteModel != null) {
			try {
				Class<?> clazz = _flaskMessagesRemoteModel.getClass();

				Method method = clazz.getMethod("setSenderUserId", long.class);

				method.invoke(_flaskMessagesRemoteModel, senderUserId);
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

		if (_flaskMessagesRemoteModel != null) {
			try {
				Class<?> clazz = _flaskMessagesRemoteModel.getClass();

				Method method = clazz.getMethod("setSenderName", String.class);

				method.invoke(_flaskMessagesRemoteModel, senderName);
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

		if (_flaskMessagesRemoteModel != null) {
			try {
				Class<?> clazz = _flaskMessagesRemoteModel.getClass();

				Method method = clazz.getMethod("setRecipients", String.class);

				method.invoke(_flaskMessagesRemoteModel, recipients);
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

		if (_flaskMessagesRemoteModel != null) {
			try {
				Class<?> clazz = _flaskMessagesRemoteModel.getClass();

				Method method = clazz.getMethod("setMessage", String.class);

				method.invoke(_flaskMessagesRemoteModel, message);
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

		if (_flaskMessagesRemoteModel != null) {
			try {
				Class<?> clazz = _flaskMessagesRemoteModel.getClass();

				Method method = clazz.getMethod("setSendEmail", boolean.class);

				method.invoke(_flaskMessagesRemoteModel, sendEmail);
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

		if (_flaskMessagesRemoteModel != null) {
			try {
				Class<?> clazz = _flaskMessagesRemoteModel.getClass();

				Method method = clazz.getMethod("setDateTime", Date.class);

				method.invoke(_flaskMessagesRemoteModel, dateTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFlaskMessagesRemoteModel() {
		return _flaskMessagesRemoteModel;
	}

	public void setFlaskMessagesRemoteModel(
		BaseModel<?> flaskMessagesRemoteModel) {
		_flaskMessagesRemoteModel = flaskMessagesRemoteModel;
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

		Class<?> remoteModelClass = _flaskMessagesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_flaskMessagesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FlaskMessagesLocalServiceUtil.addFlaskMessages(this);
		}
		else {
			FlaskMessagesLocalServiceUtil.updateFlaskMessages(this);
		}
	}

	@Override
	public FlaskMessages toEscapedModel() {
		return (FlaskMessages)ProxyUtil.newProxyInstance(FlaskMessages.class.getClassLoader(),
			new Class[] { FlaskMessages.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FlaskMessagesClp clone = new FlaskMessagesClp();

		clone.setMessageId(getMessageId());
		clone.setSenderEmail(getSenderEmail());
		clone.setSenderUserId(getSenderUserId());
		clone.setSenderName(getSenderName());
		clone.setRecipients(getRecipients());
		clone.setMessage(getMessage());
		clone.setSendEmail(getSendEmail());
		clone.setDateTime(getDateTime());

		return clone;
	}

	@Override
	public int compareTo(FlaskMessages flaskMessages) {
		long primaryKey = flaskMessages.getPrimaryKey();

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

		if (!(obj instanceof FlaskMessagesClp)) {
			return false;
		}

		FlaskMessagesClp flaskMessages = (FlaskMessagesClp)obj;

		long primaryKey = flaskMessages.getPrimaryKey();

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

		sb.append("{messageId=");
		sb.append(getMessageId());
		sb.append(", senderEmail=");
		sb.append(getSenderEmail());
		sb.append(", senderUserId=");
		sb.append(getSenderUserId());
		sb.append(", senderName=");
		sb.append(getSenderName());
		sb.append(", recipients=");
		sb.append(getRecipients());
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
		sb.append("com.liferay.contacts.model.FlaskMessages");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
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
			"<column><column-name>recipients</column-name><column-value><![CDATA[");
		sb.append(getRecipients());
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

	private long _messageId;
	private String _senderEmail;
	private long _senderUserId;
	private String _senderUserUuid;
	private String _senderName;
	private String _recipients;
	private String _message;
	private boolean _sendEmail;
	private Date _dateTime;
	private BaseModel<?> _flaskMessagesRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.contacts.service.ClpSerializer.class;
}