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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.FlaskUserServiceSoap}.
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.http.FlaskUserServiceSoap
 * @generated
 */
public class FlaskUserSoap implements Serializable {
	public static FlaskUserSoap toSoapModel(FlaskUser model) {
		FlaskUserSoap soapModel = new FlaskUserSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setMiddleName(model.getMiddleName());
		soapModel.setLastName(model.getLastName());
		soapModel.setScreenName(model.getScreenName());
		soapModel.setEmail(model.getEmail());
		soapModel.setDOB(model.getDOB());

		return soapModel;
	}

	public static FlaskUserSoap[] toSoapModels(FlaskUser[] models) {
		FlaskUserSoap[] soapModels = new FlaskUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FlaskUserSoap[][] toSoapModels(FlaskUser[][] models) {
		FlaskUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FlaskUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FlaskUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FlaskUserSoap[] toSoapModels(List<FlaskUser> models) {
		List<FlaskUserSoap> soapModels = new ArrayList<FlaskUserSoap>(models.size());

		for (FlaskUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FlaskUserSoap[soapModels.size()]);
	}

	public FlaskUserSoap() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getMiddleName() {
		return _middleName;
	}

	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getScreenName() {
		return _screenName;
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public Date getDOB() {
		return _DOB;
	}

	public void setDOB(Date DOB) {
		_DOB = DOB;
	}

	private long _userId;
	private long _roleId;
	private String _firstName;
	private String _middleName;
	private String _lastName;
	private String _screenName;
	private String _email;
	private Date _DOB;
}