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

import com.rumbasolutions.flask.service.CampaignImageLocalServiceUtil;
import com.rumbasolutions.flask.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class CampaignImageClp extends BaseModelImpl<CampaignImage>
	implements CampaignImage {
	public CampaignImageClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CampaignImage.class;
	}

	@Override
	public String getModelClassName() {
		return CampaignImage.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _campaignImageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCampaignImageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _campaignImageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campaignImageId", getCampaignImageId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("imageTitle", getImageTitle());
		attributes.put("imageDesc", getImageDesc());
		attributes.put("imageUUID", getImageUUID());
		attributes.put("imageGroupId", getImageGroupId());
		attributes.put("campaignId", getCampaignId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long campaignImageId = (Long)attributes.get("campaignImageId");

		if (campaignImageId != null) {
			setCampaignImageId(campaignImageId);
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

		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}
	}

	@Override
	public long getCampaignImageId() {
		return _campaignImageId;
	}

	@Override
	public void setCampaignImageId(long campaignImageId) {
		_campaignImageId = campaignImageId;

		if (_campaignImageRemoteModel != null) {
			try {
				Class<?> clazz = _campaignImageRemoteModel.getClass();

				Method method = clazz.getMethod("setCampaignImageId", long.class);

				method.invoke(_campaignImageRemoteModel, campaignImageId);
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

		if (_campaignImageRemoteModel != null) {
			try {
				Class<?> clazz = _campaignImageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_campaignImageRemoteModel, userId);
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

		if (_campaignImageRemoteModel != null) {
			try {
				Class<?> clazz = _campaignImageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_campaignImageRemoteModel, createdDate);
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

		if (_campaignImageRemoteModel != null) {
			try {
				Class<?> clazz = _campaignImageRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_campaignImageRemoteModel, modifiedDate);
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

		if (_campaignImageRemoteModel != null) {
			try {
				Class<?> clazz = _campaignImageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageTitle", String.class);

				method.invoke(_campaignImageRemoteModel, imageTitle);
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

		if (_campaignImageRemoteModel != null) {
			try {
				Class<?> clazz = _campaignImageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageDesc", String.class);

				method.invoke(_campaignImageRemoteModel, imageDesc);
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

		if (_campaignImageRemoteModel != null) {
			try {
				Class<?> clazz = _campaignImageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageUUID", String.class);

				method.invoke(_campaignImageRemoteModel, imageUUID);
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

		if (_campaignImageRemoteModel != null) {
			try {
				Class<?> clazz = _campaignImageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageGroupId", long.class);

				method.invoke(_campaignImageRemoteModel, imageGroupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCampaignId() {
		return _campaignId;
	}

	@Override
	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;

		if (_campaignImageRemoteModel != null) {
			try {
				Class<?> clazz = _campaignImageRemoteModel.getClass();

				Method method = clazz.getMethod("setCampaignId", long.class);

				method.invoke(_campaignImageRemoteModel, campaignId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCampaignImageRemoteModel() {
		return _campaignImageRemoteModel;
	}

	public void setCampaignImageRemoteModel(
		BaseModel<?> campaignImageRemoteModel) {
		_campaignImageRemoteModel = campaignImageRemoteModel;
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

		Class<?> remoteModelClass = _campaignImageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_campaignImageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CampaignImageLocalServiceUtil.addCampaignImage(this);
		}
		else {
			CampaignImageLocalServiceUtil.updateCampaignImage(this);
		}
	}

	@Override
	public CampaignImage toEscapedModel() {
		return (CampaignImage)ProxyUtil.newProxyInstance(CampaignImage.class.getClassLoader(),
			new Class[] { CampaignImage.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CampaignImageClp clone = new CampaignImageClp();

		clone.setCampaignImageId(getCampaignImageId());
		clone.setUserId(getUserId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setImageTitle(getImageTitle());
		clone.setImageDesc(getImageDesc());
		clone.setImageUUID(getImageUUID());
		clone.setImageGroupId(getImageGroupId());
		clone.setCampaignId(getCampaignId());

		return clone;
	}

	@Override
	public int compareTo(CampaignImage campaignImage) {
		long primaryKey = campaignImage.getPrimaryKey();

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

		if (!(obj instanceof CampaignImageClp)) {
			return false;
		}

		CampaignImageClp campaignImage = (CampaignImageClp)obj;

		long primaryKey = campaignImage.getPrimaryKey();

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

		sb.append("{campaignImageId=");
		sb.append(getCampaignImageId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", imageTitle=");
		sb.append(getImageTitle());
		sb.append(", imageDesc=");
		sb.append(getImageDesc());
		sb.append(", imageUUID=");
		sb.append(getImageUUID());
		sb.append(", imageGroupId=");
		sb.append(getImageGroupId());
		sb.append(", campaignId=");
		sb.append(getCampaignId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.CampaignImage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>campaignImageId</column-name><column-value><![CDATA[");
		sb.append(getCampaignImageId());
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
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _campaignImageId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _imageTitle;
	private String _imageDesc;
	private String _imageUUID;
	private long _imageGroupId;
	private long _campaignId;
	private BaseModel<?> _campaignImageRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}