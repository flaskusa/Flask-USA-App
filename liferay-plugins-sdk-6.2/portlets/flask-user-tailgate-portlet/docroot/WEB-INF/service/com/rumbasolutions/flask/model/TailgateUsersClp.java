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
import com.rumbasolutions.flask.service.TailgateUsersLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rajeshj
 */
public class TailgateUsersClp extends BaseModelImpl<TailgateUsers>
	implements TailgateUsers {
	public TailgateUsersClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TailgateUsers.class;
	}

	@Override
	public String getModelClassName() {
		return TailgateUsers.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _tailgateUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTailgateUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tailgateUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tailgateUserId", getTailgateUserId());
		attributes.put("tailgateId", getTailgateId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("isAdmin", getIsAdmin());
		attributes.put("groupId", getGroupId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("isPaid", getIsPaid());
		attributes.put("paymentMode", getPaymentMode());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tailgateUserId = (Long)attributes.get("tailgateUserId");

		if (tailgateUserId != null) {
			setTailgateUserId(tailgateUserId);
		}

		Long tailgateId = (Long)attributes.get("tailgateId");

		if (tailgateId != null) {
			setTailgateId(tailgateId);
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

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Boolean isPaid = (Boolean)attributes.get("isPaid");

		if (isPaid != null) {
			setIsPaid(isPaid);
		}

		String paymentMode = (String)attributes.get("paymentMode");

		if (paymentMode != null) {
			setPaymentMode(paymentMode);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public long getTailgateUserId() {
		return _tailgateUserId;
	}

	@Override
	public void setTailgateUserId(long tailgateUserId) {
		_tailgateUserId = tailgateUserId;

		if (_tailgateUsersRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgateUserId", long.class);

				method.invoke(_tailgateUsersRemoteModel, tailgateUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTailgateUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getTailgateUserId(), "uuid",
			_tailgateUserUuid);
	}

	@Override
	public void setTailgateUserUuid(String tailgateUserUuid) {
		_tailgateUserUuid = tailgateUserUuid;
	}

	@Override
	public long getTailgateId() {
		return _tailgateId;
	}

	@Override
	public void setTailgateId(long tailgateId) {
		_tailgateId = tailgateId;

		if (_tailgateUsersRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgateId", long.class);

				method.invoke(_tailgateUsersRemoteModel, tailgateId);
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

		if (_tailgateUsersRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_tailgateUsersRemoteModel, userId);
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

		if (_tailgateUsersRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_tailgateUsersRemoteModel, userName);
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

		if (_tailgateUsersRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setIsAdmin", int.class);

				method.invoke(_tailgateUsersRemoteModel, isAdmin);
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

		if (_tailgateUsersRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_tailgateUsersRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;

		if (_tailgateUsersRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_tailgateUsersRemoteModel, emailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsPaid() {
		return _isPaid;
	}

	@Override
	public boolean isIsPaid() {
		return _isPaid;
	}

	@Override
	public void setIsPaid(boolean isPaid) {
		_isPaid = isPaid;

		if (_tailgateUsersRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setIsPaid", boolean.class);

				method.invoke(_tailgateUsersRemoteModel, isPaid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPaymentMode() {
		return _paymentMode;
	}

	@Override
	public void setPaymentMode(String paymentMode) {
		_paymentMode = paymentMode;

		if (_tailgateUsersRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setPaymentMode", String.class);

				method.invoke(_tailgateUsersRemoteModel, paymentMode);
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

		if (_tailgateUsersRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateUsersRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_tailgateUsersRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTailgateUsersRemoteModel() {
		return _tailgateUsersRemoteModel;
	}

	public void setTailgateUsersRemoteModel(
		BaseModel<?> tailgateUsersRemoteModel) {
		_tailgateUsersRemoteModel = tailgateUsersRemoteModel;
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

		Class<?> remoteModelClass = _tailgateUsersRemoteModel.getClass();

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

		Object returnValue = method.invoke(_tailgateUsersRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TailgateUsersLocalServiceUtil.addTailgateUsers(this);
		}
		else {
			TailgateUsersLocalServiceUtil.updateTailgateUsers(this);
		}
	}

	@Override
	public TailgateUsers toEscapedModel() {
		return (TailgateUsers)ProxyUtil.newProxyInstance(TailgateUsers.class.getClassLoader(),
			new Class[] { TailgateUsers.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TailgateUsersClp clone = new TailgateUsersClp();

		clone.setTailgateUserId(getTailgateUserId());
		clone.setTailgateId(getTailgateId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setIsAdmin(getIsAdmin());
		clone.setGroupId(getGroupId());
		clone.setEmailAddress(getEmailAddress());
		clone.setIsPaid(getIsPaid());
		clone.setPaymentMode(getPaymentMode());
		clone.setDescription(getDescription());

		return clone;
	}

	@Override
	public int compareTo(TailgateUsers tailgateUsers) {
		long primaryKey = tailgateUsers.getPrimaryKey();

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

		if (!(obj instanceof TailgateUsersClp)) {
			return false;
		}

		TailgateUsersClp tailgateUsers = (TailgateUsersClp)obj;

		long primaryKey = tailgateUsers.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{tailgateUserId=");
		sb.append(getTailgateUserId());
		sb.append(", tailgateId=");
		sb.append(getTailgateId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", isAdmin=");
		sb.append(getIsAdmin());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", isPaid=");
		sb.append(getIsPaid());
		sb.append(", paymentMode=");
		sb.append(getPaymentMode());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.TailgateUsers");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tailgateUserId</column-name><column-value><![CDATA[");
		sb.append(getTailgateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tailgateId</column-name><column-value><![CDATA[");
		sb.append(getTailgateId());
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
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPaid</column-name><column-value><![CDATA[");
		sb.append(getIsPaid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentMode</column-name><column-value><![CDATA[");
		sb.append(getPaymentMode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _tailgateUserId;
	private String _tailgateUserUuid;
	private long _tailgateId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private int _isAdmin;
	private long _groupId;
	private String _emailAddress;
	private boolean _isPaid;
	private String _paymentMode;
	private String _description;
	private BaseModel<?> _tailgateUsersRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}