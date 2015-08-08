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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.FlaskGroupServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.http.FlaskGroupServiceSoap
 * @generated
 */
public class FlaskGroupSoap implements Serializable {
	public static FlaskGroupSoap toSoapModel(FlaskGroup model) {
		FlaskGroupSoap soapModel = new FlaskGroupSoap();

		soapModel.setGroupId(model.getGroupId());
		soapModel.setGroupName(model.getGroupName());
		soapModel.setGroupDescription(model.getGroupDescription());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setIsActive(model.getIsActive());
		soapModel.setIsDelete(model.getIsDelete());

		return soapModel;
	}

	public static FlaskGroupSoap[] toSoapModels(FlaskGroup[] models) {
		FlaskGroupSoap[] soapModels = new FlaskGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FlaskGroupSoap[][] toSoapModels(FlaskGroup[][] models) {
		FlaskGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FlaskGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FlaskGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FlaskGroupSoap[] toSoapModels(List<FlaskGroup> models) {
		List<FlaskGroupSoap> soapModels = new ArrayList<FlaskGroupSoap>(models.size());

		for (FlaskGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FlaskGroupSoap[soapModels.size()]);
	}

	public FlaskGroupSoap() {
	}

	public long getPrimaryKey() {
		return _groupId;
	}

	public void setPrimaryKey(long pk) {
		setGroupId(pk);
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getGroupName() {
		return _groupName;
	}

	public void setGroupName(String groupName) {
		_groupName = groupName;
	}

	public String getGroupDescription() {
		return _groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		_groupDescription = groupDescription;
	}

	public String getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(String createdDate) {
		_createdDate = createdDate;
	}

	public String getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	public int getIsActive() {
		return _isActive;
	}

	public void setIsActive(int isActive) {
		_isActive = isActive;
	}

	public int getIsDelete() {
		return _isDelete;
	}

	public void setIsDelete(int isDelete) {
		_isDelete = isDelete;
	}

	private long _groupId;
	private String _groupName;
	private String _groupDescription;
	private String _createdDate;
	private String _createdBy;
	private int _isActive;
	private int _isDelete;
}