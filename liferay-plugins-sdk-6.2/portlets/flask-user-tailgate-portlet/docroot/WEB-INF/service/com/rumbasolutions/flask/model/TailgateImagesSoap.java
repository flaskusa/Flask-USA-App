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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.TailgateImagesServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.http.TailgateImagesServiceSoap
 * @generated
 */
public class TailgateImagesSoap implements Serializable {
	public static TailgateImagesSoap toSoapModel(TailgateImages model) {
		TailgateImagesSoap soapModel = new TailgateImagesSoap();

		soapModel.setTailgateImageId(model.getTailgateImageId());
		soapModel.setTailgateId(model.getTailgateId());
		soapModel.setUserId(model.getUserId());
		soapModel.setImageTitle(model.getImageTitle());
		soapModel.setImageDesc(model.getImageDesc());
		soapModel.setImageUUID(model.getImageUUID());
		soapModel.setImageGroupId(model.getImageGroupId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static TailgateImagesSoap[] toSoapModels(TailgateImages[] models) {
		TailgateImagesSoap[] soapModels = new TailgateImagesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TailgateImagesSoap[][] toSoapModels(TailgateImages[][] models) {
		TailgateImagesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TailgateImagesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TailgateImagesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TailgateImagesSoap[] toSoapModels(List<TailgateImages> models) {
		List<TailgateImagesSoap> soapModels = new ArrayList<TailgateImagesSoap>(models.size());

		for (TailgateImages model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TailgateImagesSoap[soapModels.size()]);
	}

	public TailgateImagesSoap() {
	}

	public long getPrimaryKey() {
		return _tailgateImageId;
	}

	public void setPrimaryKey(long pk) {
		setTailgateImageId(pk);
	}

	public long getTailgateImageId() {
		return _tailgateImageId;
	}

	public void setTailgateImageId(long tailgateImageId) {
		_tailgateImageId = tailgateImageId;
	}

	public long getTailgateId() {
		return _tailgateId;
	}

	public void setTailgateId(long tailgateId) {
		_tailgateId = tailgateId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getImageTitle() {
		return _imageTitle;
	}

	public void setImageTitle(String imageTitle) {
		_imageTitle = imageTitle;
	}

	public String getImageDesc() {
		return _imageDesc;
	}

	public void setImageDesc(String imageDesc) {
		_imageDesc = imageDesc;
	}

	public String getImageUUID() {
		return _imageUUID;
	}

	public void setImageUUID(String imageUUID) {
		_imageUUID = imageUUID;
	}

	public long getImageGroupId() {
		return _imageGroupId;
	}

	public void setImageGroupId(long imageGroupId) {
		_imageGroupId = imageGroupId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _tailgateImageId;
	private long _tailgateId;
	private long _userId;
	private String _imageTitle;
	private String _imageDesc;
	private String _imageUUID;
	private long _imageGroupId;
	private Date _createdDate;
	private Date _modifiedDate;
}