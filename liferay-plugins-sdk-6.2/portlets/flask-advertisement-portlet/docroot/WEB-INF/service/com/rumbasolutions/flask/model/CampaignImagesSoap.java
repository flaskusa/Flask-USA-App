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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.CampaignImagesServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.http.CampaignImagesServiceSoap
 * @generated
 */
public class CampaignImagesSoap implements Serializable {
	public static CampaignImagesSoap toSoapModel(CampaignImages model) {
		CampaignImagesSoap soapModel = new CampaignImagesSoap();

		soapModel.setCampaignImageId(model.getCampaignImageId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setImageTitle(model.getImageTitle());
		soapModel.setImageDesc(model.getImageDesc());
		soapModel.setImageUUID(model.getImageUUID());
		soapModel.setImageGroupId(model.getImageGroupId());

		return soapModel;
	}

	public static CampaignImagesSoap[] toSoapModels(CampaignImages[] models) {
		CampaignImagesSoap[] soapModels = new CampaignImagesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CampaignImagesSoap[][] toSoapModels(CampaignImages[][] models) {
		CampaignImagesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CampaignImagesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CampaignImagesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CampaignImagesSoap[] toSoapModels(List<CampaignImages> models) {
		List<CampaignImagesSoap> soapModels = new ArrayList<CampaignImagesSoap>(models.size());

		for (CampaignImages model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CampaignImagesSoap[soapModels.size()]);
	}

	public CampaignImagesSoap() {
	}

	public long getPrimaryKey() {
		return _campaignImageId;
	}

	public void setPrimaryKey(long pk) {
		setCampaignImageId(pk);
	}

	public long getCampaignImageId() {
		return _campaignImageId;
	}

	public void setCampaignImageId(long campaignImageId) {
		_campaignImageId = campaignImageId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	private long _campaignImageId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _imageTitle;
	private String _imageDesc;
	private String _imageUUID;
	private long _imageGroupId;
}