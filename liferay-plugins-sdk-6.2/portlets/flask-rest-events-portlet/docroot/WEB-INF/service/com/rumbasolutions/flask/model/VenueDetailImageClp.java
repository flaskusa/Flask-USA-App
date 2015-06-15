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
import com.rumbasolutions.flask.service.VenueDetailImageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashutosh Rai
 */
public class VenueDetailImageClp extends BaseModelImpl<VenueDetailImage>
	implements VenueDetailImage {
	public VenueDetailImageClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VenueDetailImage.class;
	}

	@Override
	public String getModelClassName() {
		return VenueDetailImage.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _venueDetailImageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVenueDetailImageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _venueDetailImageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("venueDetailImageId", getVenueDetailImageId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("venueDetailId", getVenueDetailId());
		attributes.put("imageTitle", getImageTitle());
		attributes.put("imageDesc", getImageDesc());
		attributes.put("imagePath", getImagePath());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long venueDetailImageId = (Long)attributes.get("venueDetailImageId");

		if (venueDetailImageId != null) {
			setVenueDetailImageId(venueDetailImageId);
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

		Long venueDetailId = (Long)attributes.get("venueDetailId");

		if (venueDetailId != null) {
			setVenueDetailId(venueDetailId);
		}

		String imageTitle = (String)attributes.get("imageTitle");

		if (imageTitle != null) {
			setImageTitle(imageTitle);
		}

		String imageDesc = (String)attributes.get("imageDesc");

		if (imageDesc != null) {
			setImageDesc(imageDesc);
		}

		String imagePath = (String)attributes.get("imagePath");

		if (imagePath != null) {
			setImagePath(imagePath);
		}
	}

	@Override
	public long getVenueDetailImageId() {
		return _venueDetailImageId;
	}

	@Override
	public void setVenueDetailImageId(long venueDetailImageId) {
		_venueDetailImageId = venueDetailImageId;

		if (_venueDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailImageId",
						long.class);

				method.invoke(_venueDetailImageRemoteModel, venueDetailImageId);
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

		if (_venueDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_venueDetailImageRemoteModel, companyId);
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

		if (_venueDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_venueDetailImageRemoteModel, userId);
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

		if (_venueDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_venueDetailImageRemoteModel, createdDate);
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

		if (_venueDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_venueDetailImageRemoteModel, modifiedDate);
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

		if (_venueDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailId", long.class);

				method.invoke(_venueDetailImageRemoteModel, venueDetailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageTitle() {
		return _imageTitle;
	}

	@Override
	public void setImageTitle(String imageTitle) {
		_imageTitle = imageTitle;

		if (_venueDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageTitle", String.class);

				method.invoke(_venueDetailImageRemoteModel, imageTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageDesc() {
		return _imageDesc;
	}

	@Override
	public void setImageDesc(String imageDesc) {
		_imageDesc = imageDesc;

		if (_venueDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageDesc", String.class);

				method.invoke(_venueDetailImageRemoteModel, imageDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImagePath() {
		return _imagePath;
	}

	@Override
	public void setImagePath(String imagePath) {
		_imagePath = imagePath;

		if (_venueDetailImageRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailImageRemoteModel.getClass();

				Method method = clazz.getMethod("setImagePath", String.class);

				method.invoke(_venueDetailImageRemoteModel, imagePath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVenueDetailImageRemoteModel() {
		return _venueDetailImageRemoteModel;
	}

	public void setVenueDetailImageRemoteModel(
		BaseModel<?> venueDetailImageRemoteModel) {
		_venueDetailImageRemoteModel = venueDetailImageRemoteModel;
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

		Class<?> remoteModelClass = _venueDetailImageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_venueDetailImageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VenueDetailImageLocalServiceUtil.addVenueDetailImage(this);
		}
		else {
			VenueDetailImageLocalServiceUtil.updateVenueDetailImage(this);
		}
	}

	@Override
	public VenueDetailImage toEscapedModel() {
		return (VenueDetailImage)ProxyUtil.newProxyInstance(VenueDetailImage.class.getClassLoader(),
			new Class[] { VenueDetailImage.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VenueDetailImageClp clone = new VenueDetailImageClp();

		clone.setVenueDetailImageId(getVenueDetailImageId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setVenueDetailId(getVenueDetailId());
		clone.setImageTitle(getImageTitle());
		clone.setImageDesc(getImageDesc());
		clone.setImagePath(getImagePath());

		return clone;
	}

	@Override
	public int compareTo(VenueDetailImage venueDetailImage) {
		long primaryKey = venueDetailImage.getPrimaryKey();

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

		if (!(obj instanceof VenueDetailImageClp)) {
			return false;
		}

		VenueDetailImageClp venueDetailImage = (VenueDetailImageClp)obj;

		long primaryKey = venueDetailImage.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{venueDetailImageId=");
		sb.append(getVenueDetailImageId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", venueDetailId=");
		sb.append(getVenueDetailId());
		sb.append(", imageTitle=");
		sb.append(getImageTitle());
		sb.append(", imageDesc=");
		sb.append(getImageDesc());
		sb.append(", imagePath=");
		sb.append(getImagePath());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.VenueDetailImage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>venueDetailImageId</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailImageId());
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
			"<column><column-name>venueDetailId</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageTitle</column-name><column-value><![CDATA[");
		sb.append(getImageTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageDesc</column-name><column-value><![CDATA[");
		sb.append(getImageDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imagePath</column-name><column-value><![CDATA[");
		sb.append(getImagePath());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _venueDetailImageId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _venueDetailId;
	private String _imageTitle;
	private String _imageDesc;
	private String _imagePath;
	private BaseModel<?> _venueDetailImageRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}