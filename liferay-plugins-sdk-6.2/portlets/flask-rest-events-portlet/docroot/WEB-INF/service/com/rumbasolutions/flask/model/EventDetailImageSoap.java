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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.EventDetailImageServiceSoap}.
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.http.EventDetailImageServiceSoap
 * @generated
 */
public class EventDetailImageSoap implements Serializable {
	public static EventDetailImageSoap toSoapModel(EventDetailImage model) {
		EventDetailImageSoap soapModel = new EventDetailImageSoap();

		soapModel.setEventDetailImageId(model.getEventDetailImageId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEventDetailId(model.getEventDetailId());
		soapModel.setImageTitle(model.getImageTitle());
		soapModel.setImageDesc(model.getImageDesc());
		soapModel.setImageUUID(model.getImageUUID());
		soapModel.setImageGroupId(model.getImageGroupId());

		return soapModel;
	}

	public static EventDetailImageSoap[] toSoapModels(EventDetailImage[] models) {
		EventDetailImageSoap[] soapModels = new EventDetailImageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventDetailImageSoap[][] toSoapModels(
		EventDetailImage[][] models) {
		EventDetailImageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventDetailImageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventDetailImageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventDetailImageSoap[] toSoapModels(
		List<EventDetailImage> models) {
		List<EventDetailImageSoap> soapModels = new ArrayList<EventDetailImageSoap>(models.size());

		for (EventDetailImage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventDetailImageSoap[soapModels.size()]);
	}

	public EventDetailImageSoap() {
	}

	public long getPrimaryKey() {
		return _eventDetailImageId;
	}

	public void setPrimaryKey(long pk) {
		setEventDetailImageId(pk);
	}

	public long getEventDetailImageId() {
		return _eventDetailImageId;
	}

	public void setEventDetailImageId(long eventDetailImageId) {
		_eventDetailImageId = eventDetailImageId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getEventDetailId() {
		return _eventDetailId;
	}

	public void setEventDetailId(long eventDetailId) {
		_eventDetailId = eventDetailId;
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

	private long _eventDetailImageId;
	private long _companyId;
	private long _userId;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _eventDetailId;
	private String _imageTitle;
	private String _imageDesc;
	private String _imageUUID;
	private long _imageGroupId;
}