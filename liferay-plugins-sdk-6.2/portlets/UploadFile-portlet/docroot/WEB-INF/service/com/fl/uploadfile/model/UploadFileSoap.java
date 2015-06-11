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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Manisha
 * @generated
 */
public class UploadFileSoap implements Serializable {
	public static UploadFileSoap toSoapModel(UploadFile model) {
		UploadFileSoap soapModel = new UploadFileSoap();

		soapModel.setFileUploadId(model.getFileUploadId());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setSize(model.getSize());

		return soapModel;
	}

	public static UploadFileSoap[] toSoapModels(UploadFile[] models) {
		UploadFileSoap[] soapModels = new UploadFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UploadFileSoap[][] toSoapModels(UploadFile[][] models) {
		UploadFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UploadFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UploadFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UploadFileSoap[] toSoapModels(List<UploadFile> models) {
		List<UploadFileSoap> soapModels = new ArrayList<UploadFileSoap>(models.size());

		for (UploadFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UploadFileSoap[soapModels.size()]);
	}

	public UploadFileSoap() {
	}

	public long getPrimaryKey() {
		return _fileUploadId;
	}

	public void setPrimaryKey(long pk) {
		setFileUploadId(pk);
	}

	public long getFileUploadId() {
		return _fileUploadId;
	}

	public void setFileUploadId(long fileUploadId) {
		_fileUploadId = fileUploadId;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getSize() {
		return _size;
	}

	public void setSize(long size) {
		_size = size;
	}

	private long _fileUploadId;
	private long _fileEntryId;
	private String _title;
	private String _description;
	private long _size;
}