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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.FlaskGroupUsersServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.http.FlaskGroupUsersServiceSoap
 * @generated
 */
public class FlaskGroupUsersSoap implements Serializable {
	public static FlaskGroupUsersSoap toSoapModel(FlaskGroupUsers model) {
		FlaskGroupUsersSoap soapModel = new FlaskGroupUsersSoap();

		soapModel.setGroupUserId(model.getGroupUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setIsAdmin(model.getIsAdmin());

		return soapModel;
	}

	public static FlaskGroupUsersSoap[] toSoapModels(FlaskGroupUsers[] models) {
		FlaskGroupUsersSoap[] soapModels = new FlaskGroupUsersSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FlaskGroupUsersSoap[][] toSoapModels(
		FlaskGroupUsers[][] models) {
		FlaskGroupUsersSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FlaskGroupUsersSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FlaskGroupUsersSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FlaskGroupUsersSoap[] toSoapModels(
		List<FlaskGroupUsers> models) {
		List<FlaskGroupUsersSoap> soapModels = new ArrayList<FlaskGroupUsersSoap>(models.size());

		for (FlaskGroupUsers model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FlaskGroupUsersSoap[soapModels.size()]);
	}

	public FlaskGroupUsersSoap() {
	}

	public long getPrimaryKey() {
		return _groupUserId;
	}

	public void setPrimaryKey(long pk) {
		setGroupUserId(pk);
	}

	public long getGroupUserId() {
		return _groupUserId;
	}

	public void setGroupUserId(long groupUserId) {
		_groupUserId = groupUserId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public int getIsAdmin() {
		return _isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		_isAdmin = isAdmin;
	}

	private long _groupUserId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private int _isAdmin;
}