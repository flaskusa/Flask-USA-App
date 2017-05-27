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
import com.liferay.contacts.service.NotificationAuditLogLocalServiceUtil;

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
public class NotificationAuditLogClp extends BaseModelImpl<NotificationAuditLog>
	implements NotificationAuditLog {
	public NotificationAuditLogClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return NotificationAuditLog.class;
	}

	@Override
	public String getModelClassName() {
		return NotificationAuditLog.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _notificationAuditLogId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNotificationAuditLogId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _notificationAuditLogId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("notificationAuditLogId", getNotificationAuditLogId());
		attributes.put("senderEmail", getSenderEmail());
		attributes.put("receiverEmail", getReceiverEmail());
		attributes.put("messageReason", getMessageReason());
		attributes.put("message", getMessage());
		attributes.put("notificationTime", getNotificationTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long notificationAuditLogId = (Long)attributes.get(
				"notificationAuditLogId");

		if (notificationAuditLogId != null) {
			setNotificationAuditLogId(notificationAuditLogId);
		}

		String senderEmail = (String)attributes.get("senderEmail");

		if (senderEmail != null) {
			setSenderEmail(senderEmail);
		}

		String receiverEmail = (String)attributes.get("receiverEmail");

		if (receiverEmail != null) {
			setReceiverEmail(receiverEmail);
		}

		String messageReason = (String)attributes.get("messageReason");

		if (messageReason != null) {
			setMessageReason(messageReason);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Date notificationTime = (Date)attributes.get("notificationTime");

		if (notificationTime != null) {
			setNotificationTime(notificationTime);
		}
	}

	@Override
	public long getNotificationAuditLogId() {
		return _notificationAuditLogId;
	}

	@Override
	public void setNotificationAuditLogId(long notificationAuditLogId) {
		_notificationAuditLogId = notificationAuditLogId;

		if (_notificationAuditLogRemoteModel != null) {
			try {
				Class<?> clazz = _notificationAuditLogRemoteModel.getClass();

				Method method = clazz.getMethod("setNotificationAuditLogId",
						long.class);

				method.invoke(_notificationAuditLogRemoteModel,
					notificationAuditLogId);
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

		if (_notificationAuditLogRemoteModel != null) {
			try {
				Class<?> clazz = _notificationAuditLogRemoteModel.getClass();

				Method method = clazz.getMethod("setSenderEmail", String.class);

				method.invoke(_notificationAuditLogRemoteModel, senderEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReceiverEmail() {
		return _receiverEmail;
	}

	@Override
	public void setReceiverEmail(String receiverEmail) {
		_receiverEmail = receiverEmail;

		if (_notificationAuditLogRemoteModel != null) {
			try {
				Class<?> clazz = _notificationAuditLogRemoteModel.getClass();

				Method method = clazz.getMethod("setReceiverEmail", String.class);

				method.invoke(_notificationAuditLogRemoteModel, receiverEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMessageReason() {
		return _messageReason;
	}

	@Override
	public void setMessageReason(String messageReason) {
		_messageReason = messageReason;

		if (_notificationAuditLogRemoteModel != null) {
			try {
				Class<?> clazz = _notificationAuditLogRemoteModel.getClass();

				Method method = clazz.getMethod("setMessageReason", String.class);

				method.invoke(_notificationAuditLogRemoteModel, messageReason);
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

		if (_notificationAuditLogRemoteModel != null) {
			try {
				Class<?> clazz = _notificationAuditLogRemoteModel.getClass();

				Method method = clazz.getMethod("setMessage", String.class);

				method.invoke(_notificationAuditLogRemoteModel, message);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getNotificationTime() {
		return _notificationTime;
	}

	@Override
	public void setNotificationTime(Date notificationTime) {
		_notificationTime = notificationTime;

		if (_notificationAuditLogRemoteModel != null) {
			try {
				Class<?> clazz = _notificationAuditLogRemoteModel.getClass();

				Method method = clazz.getMethod("setNotificationTime",
						Date.class);

				method.invoke(_notificationAuditLogRemoteModel, notificationTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getNotificationAuditLogRemoteModel() {
		return _notificationAuditLogRemoteModel;
	}

	public void setNotificationAuditLogRemoteModel(
		BaseModel<?> notificationAuditLogRemoteModel) {
		_notificationAuditLogRemoteModel = notificationAuditLogRemoteModel;
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

		Class<?> remoteModelClass = _notificationAuditLogRemoteModel.getClass();

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

		Object returnValue = method.invoke(_notificationAuditLogRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			NotificationAuditLogLocalServiceUtil.addNotificationAuditLog(this);
		}
		else {
			NotificationAuditLogLocalServiceUtil.updateNotificationAuditLog(this);
		}
	}

	@Override
	public NotificationAuditLog toEscapedModel() {
		return (NotificationAuditLog)ProxyUtil.newProxyInstance(NotificationAuditLog.class.getClassLoader(),
			new Class[] { NotificationAuditLog.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NotificationAuditLogClp clone = new NotificationAuditLogClp();

		clone.setNotificationAuditLogId(getNotificationAuditLogId());
		clone.setSenderEmail(getSenderEmail());
		clone.setReceiverEmail(getReceiverEmail());
		clone.setMessageReason(getMessageReason());
		clone.setMessage(getMessage());
		clone.setNotificationTime(getNotificationTime());

		return clone;
	}

	@Override
	public int compareTo(NotificationAuditLog notificationAuditLog) {
		int value = 0;

		value = DateUtil.compareTo(getNotificationTime(),
				notificationAuditLog.getNotificationTime());

		value = value * -1;

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

		if (!(obj instanceof NotificationAuditLogClp)) {
			return false;
		}

		NotificationAuditLogClp notificationAuditLog = (NotificationAuditLogClp)obj;

		long primaryKey = notificationAuditLog.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{notificationAuditLogId=");
		sb.append(getNotificationAuditLogId());
		sb.append(", senderEmail=");
		sb.append(getSenderEmail());
		sb.append(", receiverEmail=");
		sb.append(getReceiverEmail());
		sb.append(", messageReason=");
		sb.append(getMessageReason());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", notificationTime=");
		sb.append(getNotificationTime());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.contacts.model.NotificationAuditLog");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>notificationAuditLogId</column-name><column-value><![CDATA[");
		sb.append(getNotificationAuditLogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderEmail</column-name><column-value><![CDATA[");
		sb.append(getSenderEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receiverEmail</column-name><column-value><![CDATA[");
		sb.append(getReceiverEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageReason</column-name><column-value><![CDATA[");
		sb.append(getMessageReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notificationTime</column-name><column-value><![CDATA[");
		sb.append(getNotificationTime());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _notificationAuditLogId;
	private String _senderEmail;
	private String _receiverEmail;
	private String _messageReason;
	private String _message;
	private Date _notificationTime;
	private BaseModel<?> _notificationAuditLogRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.contacts.service.ClpSerializer.class;
}