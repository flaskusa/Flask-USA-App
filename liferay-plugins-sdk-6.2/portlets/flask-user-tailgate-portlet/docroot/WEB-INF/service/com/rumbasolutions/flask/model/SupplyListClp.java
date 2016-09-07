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
import com.rumbasolutions.flask.service.SupplyListLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class SupplyListClp extends BaseModelImpl<SupplyList>
	implements SupplyList {
	public SupplyListClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SupplyList.class;
	}

	@Override
	public String getModelClassName() {
		return SupplyList.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _supplyListId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSupplyListId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _supplyListId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("supplyListId", getSupplyListId());
		attributes.put("supplyListName", getSupplyListName());
		attributes.put("isSystem", getIsSystem());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long supplyListId = (Long)attributes.get("supplyListId");

		if (supplyListId != null) {
			setSupplyListId(supplyListId);
		}

		String supplyListName = (String)attributes.get("supplyListName");

		if (supplyListName != null) {
			setSupplyListName(supplyListName);
		}

		Boolean isSystem = (Boolean)attributes.get("isSystem");

		if (isSystem != null) {
			setIsSystem(isSystem);
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
	public long getSupplyListId() {
		return _supplyListId;
	}

	@Override
	public void setSupplyListId(long supplyListId) {
		_supplyListId = supplyListId;

		if (_supplyListRemoteModel != null) {
			try {
				Class<?> clazz = _supplyListRemoteModel.getClass();

				Method method = clazz.getMethod("setSupplyListId", long.class);

				method.invoke(_supplyListRemoteModel, supplyListId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSupplyListName() {
		return _supplyListName;
	}

	@Override
	public void setSupplyListName(String supplyListName) {
		_supplyListName = supplyListName;

		if (_supplyListRemoteModel != null) {
			try {
				Class<?> clazz = _supplyListRemoteModel.getClass();

				Method method = clazz.getMethod("setSupplyListName",
						String.class);

				method.invoke(_supplyListRemoteModel, supplyListName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsSystem() {
		return _isSystem;
	}

	@Override
	public boolean isIsSystem() {
		return _isSystem;
	}

	@Override
	public void setIsSystem(boolean isSystem) {
		_isSystem = isSystem;

		if (_supplyListRemoteModel != null) {
			try {
				Class<?> clazz = _supplyListRemoteModel.getClass();

				Method method = clazz.getMethod("setIsSystem", boolean.class);

				method.invoke(_supplyListRemoteModel, isSystem);
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

		if (_supplyListRemoteModel != null) {
			try {
				Class<?> clazz = _supplyListRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_supplyListRemoteModel, companyId);
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

		if (_supplyListRemoteModel != null) {
			try {
				Class<?> clazz = _supplyListRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_supplyListRemoteModel, userId);
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

		if (_supplyListRemoteModel != null) {
			try {
				Class<?> clazz = _supplyListRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_supplyListRemoteModel, createdDate);
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

		if (_supplyListRemoteModel != null) {
			try {
				Class<?> clazz = _supplyListRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_supplyListRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSupplyListRemoteModel() {
		return _supplyListRemoteModel;
	}

	public void setSupplyListRemoteModel(BaseModel<?> supplyListRemoteModel) {
		_supplyListRemoteModel = supplyListRemoteModel;
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

		Class<?> remoteModelClass = _supplyListRemoteModel.getClass();

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

		Object returnValue = method.invoke(_supplyListRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SupplyListLocalServiceUtil.addSupplyList(this);
		}
		else {
			SupplyListLocalServiceUtil.updateSupplyList(this);
		}
	}

	@Override
	public SupplyList toEscapedModel() {
		return (SupplyList)ProxyUtil.newProxyInstance(SupplyList.class.getClassLoader(),
			new Class[] { SupplyList.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SupplyListClp clone = new SupplyListClp();

		clone.setSupplyListId(getSupplyListId());
		clone.setSupplyListName(getSupplyListName());
		clone.setIsSystem(getIsSystem());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SupplyList supplyList) {
		long primaryKey = supplyList.getPrimaryKey();

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

		if (!(obj instanceof SupplyListClp)) {
			return false;
		}

		SupplyListClp supplyList = (SupplyListClp)obj;

		long primaryKey = supplyList.getPrimaryKey();

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

		sb.append("{supplyListId=");
		sb.append(getSupplyListId());
		sb.append(", supplyListName=");
		sb.append(getSupplyListName());
		sb.append(", isSystem=");
		sb.append(getIsSystem());
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
		sb.append("com.rumbasolutions.flask.model.SupplyList");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>supplyListId</column-name><column-value><![CDATA[");
		sb.append(getSupplyListId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supplyListName</column-name><column-value><![CDATA[");
		sb.append(getSupplyListName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isSystem</column-name><column-value><![CDATA[");
		sb.append(getIsSystem());
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

	private long _supplyListId;
	private String _supplyListName;
	private boolean _isSystem;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private BaseModel<?> _supplyListRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}