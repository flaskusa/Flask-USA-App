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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UploadFile}.
 * </p>
 *
 * @author Manisha
 * @see UploadFile
 * @generated
 */
public class UploadFileWrapper implements UploadFile, ModelWrapper<UploadFile> {
	public UploadFileWrapper(UploadFile uploadFile) {
		_uploadFile = uploadFile;
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

	/**
	* Returns the primary key of this upload file.
	*
	* @return the primary key of this upload file
	*/
	@Override
	public long getPrimaryKey() {
		return _uploadFile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this upload file.
	*
	* @param primaryKey the primary key of this upload file
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_uploadFile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the file upload ID of this upload file.
	*
	* @return the file upload ID of this upload file
	*/
	@Override
	public long getFileUploadId() {
		return _uploadFile.getFileUploadId();
	}

	/**
	* Sets the file upload ID of this upload file.
	*
	* @param fileUploadId the file upload ID of this upload file
	*/
	@Override
	public void setFileUploadId(long fileUploadId) {
		_uploadFile.setFileUploadId(fileUploadId);
	}

	/**
	* Returns the file entry ID of this upload file.
	*
	* @return the file entry ID of this upload file
	*/
	@Override
	public long getFileEntryId() {
		return _uploadFile.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this upload file.
	*
	* @param fileEntryId the file entry ID of this upload file
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_uploadFile.setFileEntryId(fileEntryId);
	}

	/**
	* Returns the title of this upload file.
	*
	* @return the title of this upload file
	*/
	@Override
	public java.lang.String getTitle() {
		return _uploadFile.getTitle();
	}

	/**
	* Sets the title of this upload file.
	*
	* @param title the title of this upload file
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_uploadFile.setTitle(title);
	}

	/**
	* Returns the description of this upload file.
	*
	* @return the description of this upload file
	*/
	@Override
	public java.lang.String getDescription() {
		return _uploadFile.getDescription();
	}

	/**
	* Sets the description of this upload file.
	*
	* @param description the description of this upload file
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_uploadFile.setDescription(description);
	}

	/**
	* Returns the size of this upload file.
	*
	* @return the size of this upload file
	*/
	@Override
	public long getSize() {
		return _uploadFile.getSize();
	}

	/**
	* Sets the size of this upload file.
	*
	* @param size the size of this upload file
	*/
	@Override
	public void setSize(long size) {
		_uploadFile.setSize(size);
	}

	@Override
	public boolean isNew() {
		return _uploadFile.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_uploadFile.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _uploadFile.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_uploadFile.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _uploadFile.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _uploadFile.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_uploadFile.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _uploadFile.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_uploadFile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_uploadFile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_uploadFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UploadFileWrapper((UploadFile)_uploadFile.clone());
	}

	@Override
	public int compareTo(com.fl.uploadfile.model.UploadFile uploadFile) {
		return _uploadFile.compareTo(uploadFile);
	}

	@Override
	public int hashCode() {
		return _uploadFile.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.fl.uploadfile.model.UploadFile> toCacheModel() {
		return _uploadFile.toCacheModel();
	}

	@Override
	public com.fl.uploadfile.model.UploadFile toEscapedModel() {
		return new UploadFileWrapper(_uploadFile.toEscapedModel());
	}

	@Override
	public com.fl.uploadfile.model.UploadFile toUnescapedModel() {
		return new UploadFileWrapper(_uploadFile.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _uploadFile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _uploadFile.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_uploadFile.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UploadFileWrapper)) {
			return false;
		}

		UploadFileWrapper uploadFileWrapper = (UploadFileWrapper)obj;

		if (Validator.equals(_uploadFile, uploadFileWrapper._uploadFile)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UploadFile getWrappedUploadFile() {
		return _uploadFile;
	}

	@Override
	public UploadFile getWrappedModel() {
		return _uploadFile;
	}

	@Override
	public void resetOriginalValues() {
		_uploadFile.resetOriginalValues();
	}

	private UploadFile _uploadFile;
}