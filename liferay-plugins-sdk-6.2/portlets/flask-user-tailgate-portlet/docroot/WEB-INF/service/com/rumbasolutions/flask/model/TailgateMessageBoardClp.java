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
import com.rumbasolutions.flask.service.TailgateMessageBoardLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class TailgateMessageBoardClp extends BaseModelImpl<TailgateMessageBoard>
	implements TailgateMessageBoard {
	public TailgateMessageBoardClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TailgateMessageBoard.class;
	}

	@Override
	public String getModelClassName() {
		return TailgateMessageBoard.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _tailgateMessageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTailgateMessageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tailgateMessageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tailgateMessageId", getTailgateMessageId());
		attributes.put("messageText", getMessageText());
		attributes.put("tailgateId", getTailgateId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tailgateMessageId = (Long)attributes.get("tailgateMessageId");

		if (tailgateMessageId != null) {
			setTailgateMessageId(tailgateMessageId);
		}

		String messageText = (String)attributes.get("messageText");

		if (messageText != null) {
			setMessageText(messageText);
		}

		Long tailgateId = (Long)attributes.get("tailgateId");

		if (tailgateId != null) {
			setTailgateId(tailgateId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public long getTailgateMessageId() {
		return _tailgateMessageId;
	}

	@Override
	public void setTailgateMessageId(long tailgateMessageId) {
		_tailgateMessageId = tailgateMessageId;

		if (_tailgateMessageBoardRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateMessageBoardRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgateMessageId",
						long.class);

				method.invoke(_tailgateMessageBoardRemoteModel,
					tailgateMessageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMessageText() {
		return _messageText;
	}

	@Override
	public void setMessageText(String messageText) {
		_messageText = messageText;

		if (_tailgateMessageBoardRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateMessageBoardRemoteModel.getClass();

				Method method = clazz.getMethod("setMessageText", String.class);

				method.invoke(_tailgateMessageBoardRemoteModel, messageText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTailgateId() {
		return _tailgateId;
	}

	@Override
	public void setTailgateId(long tailgateId) {
		_tailgateId = tailgateId;

		if (_tailgateMessageBoardRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateMessageBoardRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgateId", long.class);

				method.invoke(_tailgateMessageBoardRemoteModel, tailgateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_tailgateMessageBoardRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateMessageBoardRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_tailgateMessageBoardRemoteModel, companyId);
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

		if (_tailgateMessageBoardRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateMessageBoardRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_tailgateMessageBoardRemoteModel, userId);
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
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_tailgateMessageBoardRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateMessageBoardRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_tailgateMessageBoardRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_tailgateMessageBoardRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateMessageBoardRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_tailgateMessageBoardRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTailgateMessageBoardRemoteModel() {
		return _tailgateMessageBoardRemoteModel;
	}

	public void setTailgateMessageBoardRemoteModel(
		BaseModel<?> tailgateMessageBoardRemoteModel) {
		_tailgateMessageBoardRemoteModel = tailgateMessageBoardRemoteModel;
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

		Class<?> remoteModelClass = _tailgateMessageBoardRemoteModel.getClass();

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

		Object returnValue = method.invoke(_tailgateMessageBoardRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TailgateMessageBoardLocalServiceUtil.addTailgateMessageBoard(this);
		}
		else {
			TailgateMessageBoardLocalServiceUtil.updateTailgateMessageBoard(this);
		}
	}

	@Override
	public TailgateMessageBoard toEscapedModel() {
		return (TailgateMessageBoard)ProxyUtil.newProxyInstance(TailgateMessageBoard.class.getClassLoader(),
			new Class[] { TailgateMessageBoard.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TailgateMessageBoardClp clone = new TailgateMessageBoardClp();

		clone.setTailgateMessageId(getTailgateMessageId());
		clone.setMessageText(getMessageText());
		clone.setTailgateId(getTailgateId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(TailgateMessageBoard tailgateMessageBoard) {
		long primaryKey = tailgateMessageBoard.getPrimaryKey();

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

		if (!(obj instanceof TailgateMessageBoardClp)) {
			return false;
		}

		TailgateMessageBoardClp tailgateMessageBoard = (TailgateMessageBoardClp)obj;

		long primaryKey = tailgateMessageBoard.getPrimaryKey();

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

		sb.append("{tailgateMessageId=");
		sb.append(getTailgateMessageId());
		sb.append(", messageText=");
		sb.append(getMessageText());
		sb.append(", tailgateId=");
		sb.append(getTailgateId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.TailgateMessageBoard");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tailgateMessageId</column-name><column-value><![CDATA[");
		sb.append(getTailgateMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageText</column-name><column-value><![CDATA[");
		sb.append(getMessageText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tailgateId</column-name><column-value><![CDATA[");
		sb.append(getTailgateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _tailgateMessageId;
	private String _messageText;
	private long _tailgateId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private BaseModel<?> _tailgateMessageBoardRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}