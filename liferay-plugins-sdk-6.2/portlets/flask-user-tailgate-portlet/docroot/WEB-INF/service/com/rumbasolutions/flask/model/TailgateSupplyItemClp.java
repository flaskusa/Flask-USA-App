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
import com.rumbasolutions.flask.service.TailgateSupplyItemLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class TailgateSupplyItemClp extends BaseModelImpl<TailgateSupplyItem>
	implements TailgateSupplyItem {
	public TailgateSupplyItemClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TailgateSupplyItem.class;
	}

	@Override
	public String getModelClassName() {
		return TailgateSupplyItem.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _tailgateSupplyItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTailgateSupplyItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tailgateSupplyItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tailgateSupplyItemId", getTailgateSupplyItemId());
		attributes.put("supplyListItemName", getSupplyListItemName());
		attributes.put("tailgateId", getTailgateId());
		attributes.put("itemAssignedUserId", getItemAssignedUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tailgateSupplyItemId = (Long)attributes.get("tailgateSupplyItemId");

		if (tailgateSupplyItemId != null) {
			setTailgateSupplyItemId(tailgateSupplyItemId);
		}

		String supplyListItemName = (String)attributes.get("supplyListItemName");

		if (supplyListItemName != null) {
			setSupplyListItemName(supplyListItemName);
		}

		Long tailgateId = (Long)attributes.get("tailgateId");

		if (tailgateId != null) {
			setTailgateId(tailgateId);
		}

		Long itemAssignedUserId = (Long)attributes.get("itemAssignedUserId");

		if (itemAssignedUserId != null) {
			setItemAssignedUserId(itemAssignedUserId);
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
	public long getTailgateSupplyItemId() {
		return _tailgateSupplyItemId;
	}

	@Override
	public void setTailgateSupplyItemId(long tailgateSupplyItemId) {
		_tailgateSupplyItemId = tailgateSupplyItemId;

		if (_tailgateSupplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateSupplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgateSupplyItemId",
						long.class);

				method.invoke(_tailgateSupplyItemRemoteModel,
					tailgateSupplyItemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSupplyListItemName() {
		return _supplyListItemName;
	}

	@Override
	public void setSupplyListItemName(String supplyListItemName) {
		_supplyListItemName = supplyListItemName;

		if (_tailgateSupplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateSupplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setSupplyListItemName",
						String.class);

				method.invoke(_tailgateSupplyItemRemoteModel, supplyListItemName);
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

		if (_tailgateSupplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateSupplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgateId", long.class);

				method.invoke(_tailgateSupplyItemRemoteModel, tailgateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getItemAssignedUserId() {
		return _itemAssignedUserId;
	}

	@Override
	public void setItemAssignedUserId(long itemAssignedUserId) {
		_itemAssignedUserId = itemAssignedUserId;

		if (_tailgateSupplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateSupplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setItemAssignedUserId",
						long.class);

				method.invoke(_tailgateSupplyItemRemoteModel, itemAssignedUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemAssignedUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getItemAssignedUserId(), "uuid",
			_itemAssignedUserUuid);
	}

	@Override
	public void setItemAssignedUserUuid(String itemAssignedUserUuid) {
		_itemAssignedUserUuid = itemAssignedUserUuid;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_tailgateSupplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateSupplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_tailgateSupplyItemRemoteModel, companyId);
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

		if (_tailgateSupplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateSupplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_tailgateSupplyItemRemoteModel, userId);
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

		if (_tailgateSupplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateSupplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_tailgateSupplyItemRemoteModel, createdDate);
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

		if (_tailgateSupplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateSupplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_tailgateSupplyItemRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTailgateSupplyItemRemoteModel() {
		return _tailgateSupplyItemRemoteModel;
	}

	public void setTailgateSupplyItemRemoteModel(
		BaseModel<?> tailgateSupplyItemRemoteModel) {
		_tailgateSupplyItemRemoteModel = tailgateSupplyItemRemoteModel;
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

		Class<?> remoteModelClass = _tailgateSupplyItemRemoteModel.getClass();

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

		Object returnValue = method.invoke(_tailgateSupplyItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TailgateSupplyItemLocalServiceUtil.addTailgateSupplyItem(this);
		}
		else {
			TailgateSupplyItemLocalServiceUtil.updateTailgateSupplyItem(this);
		}
	}

	@Override
	public TailgateSupplyItem toEscapedModel() {
		return (TailgateSupplyItem)ProxyUtil.newProxyInstance(TailgateSupplyItem.class.getClassLoader(),
			new Class[] { TailgateSupplyItem.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TailgateSupplyItemClp clone = new TailgateSupplyItemClp();

		clone.setTailgateSupplyItemId(getTailgateSupplyItemId());
		clone.setSupplyListItemName(getSupplyListItemName());
		clone.setTailgateId(getTailgateId());
		clone.setItemAssignedUserId(getItemAssignedUserId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(TailgateSupplyItem tailgateSupplyItem) {
		long primaryKey = tailgateSupplyItem.getPrimaryKey();

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

		if (!(obj instanceof TailgateSupplyItemClp)) {
			return false;
		}

		TailgateSupplyItemClp tailgateSupplyItem = (TailgateSupplyItemClp)obj;

		long primaryKey = tailgateSupplyItem.getPrimaryKey();

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

		sb.append("{tailgateSupplyItemId=");
		sb.append(getTailgateSupplyItemId());
		sb.append(", supplyListItemName=");
		sb.append(getSupplyListItemName());
		sb.append(", tailgateId=");
		sb.append(getTailgateId());
		sb.append(", itemAssignedUserId=");
		sb.append(getItemAssignedUserId());
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
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.TailgateSupplyItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tailgateSupplyItemId</column-name><column-value><![CDATA[");
		sb.append(getTailgateSupplyItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supplyListItemName</column-name><column-value><![CDATA[");
		sb.append(getSupplyListItemName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tailgateId</column-name><column-value><![CDATA[");
		sb.append(getTailgateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemAssignedUserId</column-name><column-value><![CDATA[");
		sb.append(getItemAssignedUserId());
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

	private long _tailgateSupplyItemId;
	private String _supplyListItemName;
	private long _tailgateId;
	private long _itemAssignedUserId;
	private String _itemAssignedUserUuid;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private BaseModel<?> _tailgateSupplyItemRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}