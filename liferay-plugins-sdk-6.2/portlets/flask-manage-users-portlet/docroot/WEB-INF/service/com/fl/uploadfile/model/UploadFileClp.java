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

package com.fl.uploadfile.model;

import com.fl.uploadfile.service.ClpSerializer;
import com.fl.uploadfile.service.UploadFileLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rumba Solutions
 */
public class UploadFileClp extends BaseModelImpl<UploadFile>
	implements UploadFile {
	public UploadFileClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UploadFile.class;
	}

	@Override
	public String getModelClassName() {
		return UploadFile.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _fileUploadId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFileUploadId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fileUploadId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fileUploadId", getFileUploadId());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("size", getSize());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fileUploadId = (Long)attributes.get("fileUploadId");

		if (fileUploadId != null) {
			setFileUploadId(fileUploadId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long size = (Long)attributes.get("size");

		if (size != null) {
			setSize(size);
		}
	}

	@Override
	public long getFileUploadId() {
		return _fileUploadId;
	}

	@Override
	public void setFileUploadId(long fileUploadId) {
		_fileUploadId = fileUploadId;

		if (_uploadFileRemoteModel != null) {
			try {
				Class<?> clazz = _uploadFileRemoteModel.getClass();

				Method method = clazz.getMethod("setFileUploadId", long.class);

				method.invoke(_uploadFileRemoteModel, fileUploadId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;

		if (_uploadFileRemoteModel != null) {
			try {
				Class<?> clazz = _uploadFileRemoteModel.getClass();

				Method method = clazz.getMethod("setFileEntryId", long.class);

				method.invoke(_uploadFileRemoteModel, fileEntryId);
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

		if (_uploadFileRemoteModel != null) {
			try {
				Class<?> clazz = _uploadFileRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_uploadFileRemoteModel, title);
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

		if (_uploadFileRemoteModel != null) {
			try {
				Class<?> clazz = _uploadFileRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_uploadFileRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSize() {
		return _size;
	}

	@Override
	public void setSize(long size) {
		_size = size;

		if (_uploadFileRemoteModel != null) {
			try {
				Class<?> clazz = _uploadFileRemoteModel.getClass();

				Method method = clazz.getMethod("setSize", long.class);

				method.invoke(_uploadFileRemoteModel, size);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUploadFileRemoteModel() {
		return _uploadFileRemoteModel;
	}

	public void setUploadFileRemoteModel(BaseModel<?> uploadFileRemoteModel) {
		_uploadFileRemoteModel = uploadFileRemoteModel;
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

		Class<?> remoteModelClass = _uploadFileRemoteModel.getClass();

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

		Object returnValue = method.invoke(_uploadFileRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UploadFileLocalServiceUtil.addUploadFile(this);
		}
		else {
			UploadFileLocalServiceUtil.updateUploadFile(this);
		}
	}

	@Override
	public UploadFile toEscapedModel() {
		return (UploadFile)ProxyUtil.newProxyInstance(UploadFile.class.getClassLoader(),
			new Class[] { UploadFile.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UploadFileClp clone = new UploadFileClp();

		clone.setFileUploadId(getFileUploadId());
		clone.setFileEntryId(getFileEntryId());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setSize(getSize());

		return clone;
	}

	@Override
	public int compareTo(UploadFile uploadFile) {
		int value = 0;

		value = getTitle().compareTo(uploadFile.getTitle());

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

		if (!(obj instanceof UploadFileClp)) {
			return false;
		}

		UploadFileClp uploadFile = (UploadFileClp)obj;

		long primaryKey = uploadFile.getPrimaryKey();

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

		sb.append("{fileUploadId=");
		sb.append(getFileUploadId());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", size=");
		sb.append(getSize());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.fl.uploadfile.model.UploadFile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>fileUploadId</column-name><column-value><![CDATA[");
		sb.append(getFileUploadId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>size</column-name><column-value><![CDATA[");
		sb.append(getSize());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _fileUploadId;
	private long _fileEntryId;
	private String _title;
	private String _description;
	private long _size;
	private BaseModel<?> _uploadFileRemoteModel;
	private Class<?> _clpSerializerClass = com.fl.uploadfile.service.ClpSerializer.class;
}