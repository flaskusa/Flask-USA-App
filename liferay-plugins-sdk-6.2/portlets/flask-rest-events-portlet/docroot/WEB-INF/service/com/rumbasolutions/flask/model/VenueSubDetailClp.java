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
import com.rumbasolutions.flask.service.VenueSubDetailLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashutosh Rai
 */
public class VenueSubDetailClp extends BaseModelImpl<VenueSubDetail>
	implements VenueSubDetail {
	public VenueSubDetailClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VenueSubDetail.class;
	}

	@Override
	public String getModelClassName() {
		return VenueSubDetail.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _venueSubDetailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVenueSubDetailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _venueSubDetailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("venueSubDetailId", getVenueSubDetailId());
		attributes.put("venueDetailId", getVenueDetailId());
		attributes.put("venueSubDetailTitle", getVenueSubDetailTitle());
		attributes.put("venueSubDetailDesc", getVenueSubDetailDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long venueSubDetailId = (Long)attributes.get("venueSubDetailId");

		if (venueSubDetailId != null) {
			setVenueSubDetailId(venueSubDetailId);
		}

		Long venueDetailId = (Long)attributes.get("venueDetailId");

		if (venueDetailId != null) {
			setVenueDetailId(venueDetailId);
		}

		String venueSubDetailTitle = (String)attributes.get(
				"venueSubDetailTitle");

		if (venueSubDetailTitle != null) {
			setVenueSubDetailTitle(venueSubDetailTitle);
		}

		String venueSubDetailDesc = (String)attributes.get("venueSubDetailDesc");

		if (venueSubDetailDesc != null) {
			setVenueSubDetailDesc(venueSubDetailDesc);
		}
	}

	@Override
	public long getVenueSubDetailId() {
		return _venueSubDetailId;
	}

	@Override
	public void setVenueSubDetailId(long venueSubDetailId) {
		_venueSubDetailId = venueSubDetailId;

		if (_venueSubDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueSubDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueSubDetailId",
						long.class);

				method.invoke(_venueSubDetailRemoteModel, venueSubDetailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVenueDetailId() {
		return _venueDetailId;
	}

	@Override
	public void setVenueDetailId(long venueDetailId) {
		_venueDetailId = venueDetailId;

		if (_venueSubDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueSubDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailId", long.class);

				method.invoke(_venueSubDetailRemoteModel, venueDetailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueSubDetailTitle() {
		return _venueSubDetailTitle;
	}

	@Override
	public void setVenueSubDetailTitle(String venueSubDetailTitle) {
		_venueSubDetailTitle = venueSubDetailTitle;

		if (_venueSubDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueSubDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueSubDetailTitle",
						String.class);

				method.invoke(_venueSubDetailRemoteModel, venueSubDetailTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueSubDetailDesc() {
		return _venueSubDetailDesc;
	}

	@Override
	public void setVenueSubDetailDesc(String venueSubDetailDesc) {
		_venueSubDetailDesc = venueSubDetailDesc;

		if (_venueSubDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueSubDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueSubDetailDesc",
						String.class);

				method.invoke(_venueSubDetailRemoteModel, venueSubDetailDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVenueSubDetailRemoteModel() {
		return _venueSubDetailRemoteModel;
	}

	public void setVenueSubDetailRemoteModel(
		BaseModel<?> venueSubDetailRemoteModel) {
		_venueSubDetailRemoteModel = venueSubDetailRemoteModel;
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

		Class<?> remoteModelClass = _venueSubDetailRemoteModel.getClass();

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

		Object returnValue = method.invoke(_venueSubDetailRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VenueSubDetailLocalServiceUtil.addVenueSubDetail(this);
		}
		else {
			VenueSubDetailLocalServiceUtil.updateVenueSubDetail(this);
		}
	}

	@Override
	public VenueSubDetail toEscapedModel() {
		return (VenueSubDetail)ProxyUtil.newProxyInstance(VenueSubDetail.class.getClassLoader(),
			new Class[] { VenueSubDetail.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VenueSubDetailClp clone = new VenueSubDetailClp();

		clone.setVenueSubDetailId(getVenueSubDetailId());
		clone.setVenueDetailId(getVenueDetailId());
		clone.setVenueSubDetailTitle(getVenueSubDetailTitle());
		clone.setVenueSubDetailDesc(getVenueSubDetailDesc());

		return clone;
	}

	@Override
	public int compareTo(VenueSubDetail venueSubDetail) {
		long primaryKey = venueSubDetail.getPrimaryKey();

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

		if (!(obj instanceof VenueSubDetailClp)) {
			return false;
		}

		VenueSubDetailClp venueSubDetail = (VenueSubDetailClp)obj;

		long primaryKey = venueSubDetail.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{venueSubDetailId=");
		sb.append(getVenueSubDetailId());
		sb.append(", venueDetailId=");
		sb.append(getVenueDetailId());
		sb.append(", venueSubDetailTitle=");
		sb.append(getVenueSubDetailTitle());
		sb.append(", venueSubDetailDesc=");
		sb.append(getVenueSubDetailDesc());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.VenueSubDetail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>venueSubDetailId</column-name><column-value><![CDATA[");
		sb.append(getVenueSubDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDetailId</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueSubDetailTitle</column-name><column-value><![CDATA[");
		sb.append(getVenueSubDetailTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueSubDetailDesc</column-name><column-value><![CDATA[");
		sb.append(getVenueSubDetailDesc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _venueSubDetailId;
	private long _venueDetailId;
	private String _venueSubDetailTitle;
	private String _venueSubDetailDesc;
	private BaseModel<?> _venueSubDetailRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}