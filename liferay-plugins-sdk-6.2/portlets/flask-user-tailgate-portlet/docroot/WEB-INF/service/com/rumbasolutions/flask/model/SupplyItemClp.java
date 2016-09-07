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
import com.rumbasolutions.flask.service.SupplyItemLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class SupplyItemClp extends BaseModelImpl<SupplyItem>
	implements SupplyItem {
	public SupplyItemClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SupplyItem.class;
	}

	@Override
	public String getModelClassName() {
		return SupplyItem.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _supplyItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSupplyItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _supplyItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("supplyItemId", getSupplyItemId());
		attributes.put("supplyItemName", getSupplyItemName());
		attributes.put("supplyListId", getSupplyListId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long supplyItemId = (Long)attributes.get("supplyItemId");

		if (supplyItemId != null) {
			setSupplyItemId(supplyItemId);
		}

		String supplyItemName = (String)attributes.get("supplyItemName");

		if (supplyItemName != null) {
			setSupplyItemName(supplyItemName);
		}

		Long supplyListId = (Long)attributes.get("supplyListId");

		if (supplyListId != null) {
			setSupplyListId(supplyListId);
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
	public long getSupplyItemId() {
		return _supplyItemId;
	}

	@Override
	public void setSupplyItemId(long supplyItemId) {
		_supplyItemId = supplyItemId;

		if (_supplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _supplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setSupplyItemId", long.class);

				method.invoke(_supplyItemRemoteModel, supplyItemId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSupplyItemName() {
		return _supplyItemName;
	}

	@Override
	public void setSupplyItemName(String supplyItemName) {
		_supplyItemName = supplyItemName;

		if (_supplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _supplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setSupplyItemName",
						String.class);

				method.invoke(_supplyItemRemoteModel, supplyItemName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSupplyListId() {
		return _supplyListId;
	}

	@Override
	public void setSupplyListId(long supplyListId) {
		_supplyListId = supplyListId;

		if (_supplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _supplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setSupplyListId", long.class);

				method.invoke(_supplyItemRemoteModel, supplyListId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_supplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _supplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_supplyItemRemoteModel, createdDate);
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

		if (_supplyItemRemoteModel != null) {
			try {
				Class<?> clazz = _supplyItemRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_supplyItemRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSupplyItemRemoteModel() {
		return _supplyItemRemoteModel;
	}

	public void setSupplyItemRemoteModel(BaseModel<?> supplyItemRemoteModel) {
		_supplyItemRemoteModel = supplyItemRemoteModel;
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

		Class<?> remoteModelClass = _supplyItemRemoteModel.getClass();

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

		Object returnValue = method.invoke(_supplyItemRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SupplyItemLocalServiceUtil.addSupplyItem(this);
		}
		else {
			SupplyItemLocalServiceUtil.updateSupplyItem(this);
		}
	}

	@Override
	public SupplyItem toEscapedModel() {
		return (SupplyItem)ProxyUtil.newProxyInstance(SupplyItem.class.getClassLoader(),
			new Class[] { SupplyItem.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SupplyItemClp clone = new SupplyItemClp();

		clone.setSupplyItemId(getSupplyItemId());
		clone.setSupplyItemName(getSupplyItemName());
		clone.setSupplyListId(getSupplyListId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SupplyItem supplyItem) {
		long primaryKey = supplyItem.getPrimaryKey();

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

		if (!(obj instanceof SupplyItemClp)) {
			return false;
		}

		SupplyItemClp supplyItem = (SupplyItemClp)obj;

		long primaryKey = supplyItem.getPrimaryKey();

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

		sb.append("{supplyItemId=");
		sb.append(getSupplyItemId());
		sb.append(", supplyItemName=");
		sb.append(getSupplyItemName());
		sb.append(", supplyListId=");
		sb.append(getSupplyListId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.SupplyItem");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>supplyItemId</column-name><column-value><![CDATA[");
		sb.append(getSupplyItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supplyItemName</column-name><column-value><![CDATA[");
		sb.append(getSupplyItemName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>supplyListId</column-name><column-value><![CDATA[");
		sb.append(getSupplyListId());
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

	private long _supplyItemId;
	private String _supplyItemName;
	private long _supplyListId;
	private Date _createdDate;
	private Date _modifiedDate;
	private BaseModel<?> _supplyItemRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}