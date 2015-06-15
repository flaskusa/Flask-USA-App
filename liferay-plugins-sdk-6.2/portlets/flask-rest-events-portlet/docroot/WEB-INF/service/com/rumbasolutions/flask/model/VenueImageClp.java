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
import com.rumbasolutions.flask.service.VenueImageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashutosh Rai
 */
public class VenueImageClp extends BaseModelImpl<VenueImage>
	implements VenueImage {
	public VenueImageClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VenueImage.class;
	}

	@Override
	public String getModelClassName() {
		return VenueImage.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _venueImageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVenueImageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _venueImageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("venueImageId", getVenueImageId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("venueImagePath", getVenueImagePath());
		attributes.put("venueId", getVenueId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long venueImageId = (Long)attributes.get("venueImageId");

		if (venueImageId != null) {
			setVenueImageId(venueImageId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String venueImagePath = (String)attributes.get("venueImagePath");

		if (venueImagePath != null) {
			setVenueImagePath(venueImagePath);
		}

		Long venueId = (Long)attributes.get("venueId");

		if (venueId != null) {
			setVenueId(venueId);
		}
	}

	@Override
	public long getVenueImageId() {
		return _venueImageId;
	}

	@Override
	public void setVenueImageId(long venueImageId) {
		_venueImageId = venueImageId;

		if (_venueImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueImageRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueImageId", long.class);

				method.invoke(_venueImageRemoteModel, venueImageId);
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

		if (_venueImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueImageRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_venueImageRemoteModel, companyId);
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

		if (_venueImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueImageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_venueImageRemoteModel, userId);
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

		if (_venueImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueImageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_venueImageRemoteModel, createdDate);
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

		if (_venueImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueImageRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_venueImageRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_venueImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueImageRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_venueImageRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueImagePath() {
		return _venueImagePath;
	}

	@Override
	public void setVenueImagePath(String venueImagePath) {
		_venueImagePath = venueImagePath;

		if (_venueImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueImageRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueImagePath",
						String.class);

				method.invoke(_venueImageRemoteModel, venueImagePath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVenueId() {
		return _venueId;
	}

	@Override
	public void setVenueId(long venueId) {
		_venueId = venueId;

		if (_venueImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueImageRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueId", long.class);

				method.invoke(_venueImageRemoteModel, venueId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVenueImageRemoteModel() {
		return _venueImageRemoteModel;
	}

	public void setVenueImageRemoteModel(BaseModel<?> venueImageRemoteModel) {
		_venueImageRemoteModel = venueImageRemoteModel;
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

		Class<?> remoteModelClass = _venueImageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_venueImageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VenueImageLocalServiceUtil.addVenueImage(this);
		}
		else {
			VenueImageLocalServiceUtil.updateVenueImage(this);
		}
	}

	@Override
	public VenueImage toEscapedModel() {
		return (VenueImage)ProxyUtil.newProxyInstance(VenueImage.class.getClassLoader(),
			new Class[] { VenueImage.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VenueImageClp clone = new VenueImageClp();

		clone.setVenueImageId(getVenueImageId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTitle(getTitle());
		clone.setVenueImagePath(getVenueImagePath());
		clone.setVenueId(getVenueId());

		return clone;
	}

	@Override
	public int compareTo(VenueImage venueImage) {
		int value = 0;

		value = getTitle().compareTo(venueImage.getTitle());

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

		if (!(obj instanceof VenueImageClp)) {
			return false;
		}

		VenueImageClp venueImage = (VenueImageClp)obj;

		long primaryKey = venueImage.getPrimaryKey();

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

		sb.append("{venueImageId=");
		sb.append(getVenueImageId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", venueImagePath=");
		sb.append(getVenueImagePath());
		sb.append(", venueId=");
		sb.append(getVenueId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.VenueImage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>venueImageId</column-name><column-value><![CDATA[");
		sb.append(getVenueImageId());
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
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueImagePath</column-name><column-value><![CDATA[");
		sb.append(getVenueImagePath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueId</column-name><column-value><![CDATA[");
		sb.append(getVenueId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _venueImageId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _title;
	private String _venueImagePath;
	private long _venueId;
	private BaseModel<?> _venueImageRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}