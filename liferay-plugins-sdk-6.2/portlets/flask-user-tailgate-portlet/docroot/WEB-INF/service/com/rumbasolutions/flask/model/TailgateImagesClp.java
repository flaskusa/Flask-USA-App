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
import com.rumbasolutions.flask.service.TailgateImagesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class TailgateImagesClp extends BaseModelImpl<TailgateImages>
	implements TailgateImages {
	public TailgateImagesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TailgateImages.class;
	}

	@Override
	public String getModelClassName() {
		return TailgateImages.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _tailgateImageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTailgateImageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tailgateImageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tailgateImageId", getTailgateImageId());
		attributes.put("tailgateId", getTailgateId());
		attributes.put("userId", getUserId());
		attributes.put("imageTitle", getImageTitle());
		attributes.put("imageDesc", getImageDesc());
		attributes.put("imageUUID", getImageUUID());
		attributes.put("imageGroupId", getImageGroupId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tailgateImageId = (Long)attributes.get("tailgateImageId");

		if (tailgateImageId != null) {
			setTailgateImageId(tailgateImageId);
		}

		Long tailgateId = (Long)attributes.get("tailgateId");

		if (tailgateId != null) {
			setTailgateId(tailgateId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String imageTitle = (String)attributes.get("imageTitle");

		if (imageTitle != null) {
			setImageTitle(imageTitle);
		}

		String imageDesc = (String)attributes.get("imageDesc");

		if (imageDesc != null) {
			setImageDesc(imageDesc);
		}

		String imageUUID = (String)attributes.get("imageUUID");

		if (imageUUID != null) {
			setImageUUID(imageUUID);
		}

		Long imageGroupId = (Long)attributes.get("imageGroupId");

		if (imageGroupId != null) {
			setImageGroupId(imageGroupId);
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
	public long getTailgateImageId() {
		return _tailgateImageId;
	}

	@Override
	public void setTailgateImageId(long tailgateImageId) {
		_tailgateImageId = tailgateImageId;

		if (_tailgateImagesRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgateImageId", long.class);

				method.invoke(_tailgateImagesRemoteModel, tailgateImageId);
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

		if (_tailgateImagesRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgateId", long.class);

				method.invoke(_tailgateImagesRemoteModel, tailgateId);
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

		if (_tailgateImagesRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_tailgateImagesRemoteModel, userId);
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
	public String getImageTitle() {
		return _imageTitle;
	}

	@Override
	public void setImageTitle(String imageTitle) {
		_imageTitle = imageTitle;

		if (_tailgateImagesRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setImageTitle", String.class);

				method.invoke(_tailgateImagesRemoteModel, imageTitle);
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

		if (_tailgateImagesRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setImageDesc", String.class);

				method.invoke(_tailgateImagesRemoteModel, imageDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageUUID() {
		return _imageUUID;
	}

	@Override
	public void setImageUUID(String imageUUID) {
		_imageUUID = imageUUID;

		if (_tailgateImagesRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setImageUUID", String.class);

				method.invoke(_tailgateImagesRemoteModel, imageUUID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getImageGroupId() {
		return _imageGroupId;
	}

	@Override
	public void setImageGroupId(long imageGroupId) {
		_imageGroupId = imageGroupId;

		if (_tailgateImagesRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setImageGroupId", long.class);

				method.invoke(_tailgateImagesRemoteModel, imageGroupId);
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

		if (_tailgateImagesRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_tailgateImagesRemoteModel, createdDate);
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

		if (_tailgateImagesRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_tailgateImagesRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTailgateImagesRemoteModel() {
		return _tailgateImagesRemoteModel;
	}

	public void setTailgateImagesRemoteModel(
		BaseModel<?> tailgateImagesRemoteModel) {
		_tailgateImagesRemoteModel = tailgateImagesRemoteModel;
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

		Class<?> remoteModelClass = _tailgateImagesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_tailgateImagesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TailgateImagesLocalServiceUtil.addTailgateImages(this);
		}
		else {
			TailgateImagesLocalServiceUtil.updateTailgateImages(this);
		}
	}

	@Override
	public TailgateImages toEscapedModel() {
		return (TailgateImages)ProxyUtil.newProxyInstance(TailgateImages.class.getClassLoader(),
			new Class[] { TailgateImages.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TailgateImagesClp clone = new TailgateImagesClp();

		clone.setTailgateImageId(getTailgateImageId());
		clone.setTailgateId(getTailgateId());
		clone.setUserId(getUserId());
		clone.setImageTitle(getImageTitle());
		clone.setImageDesc(getImageDesc());
		clone.setImageUUID(getImageUUID());
		clone.setImageGroupId(getImageGroupId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(TailgateImages tailgateImages) {
		long primaryKey = tailgateImages.getPrimaryKey();

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

		if (!(obj instanceof TailgateImagesClp)) {
			return false;
		}

		TailgateImagesClp tailgateImages = (TailgateImagesClp)obj;

		long primaryKey = tailgateImages.getPrimaryKey();

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

		sb.append("{tailgateImageId=");
		sb.append(getTailgateImageId());
		sb.append(", tailgateId=");
		sb.append(getTailgateId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", imageTitle=");
		sb.append(getImageTitle());
		sb.append(", imageDesc=");
		sb.append(getImageDesc());
		sb.append(", imageUUID=");
		sb.append(getImageUUID());
		sb.append(", imageGroupId=");
		sb.append(getImageGroupId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.TailgateImages");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tailgateImageId</column-name><column-value><![CDATA[");
		sb.append(getTailgateImageId());
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
			"<column><column-name>imageTitle</column-name><column-value><![CDATA[");
		sb.append(getImageTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageDesc</column-name><column-value><![CDATA[");
		sb.append(getImageDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageUUID</column-name><column-value><![CDATA[");
		sb.append(getImageUUID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageGroupId</column-name><column-value><![CDATA[");
		sb.append(getImageGroupId());
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

	private long _tailgateImageId;
	private long _tailgateId;
	private long _userId;
	private String _userUuid;
	private String _imageTitle;
	private String _imageDesc;
	private String _imageUUID;
	private long _imageGroupId;
	private Date _createdDate;
	private Date _modifiedDate;
	private BaseModel<?> _tailgateImagesRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}