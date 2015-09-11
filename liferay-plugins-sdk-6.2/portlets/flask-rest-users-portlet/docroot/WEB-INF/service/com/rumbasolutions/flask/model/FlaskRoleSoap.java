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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.FlaskRoleServiceSoap}.
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.http.FlaskRoleServiceSoap
 * @generated
 */
public class FlaskRoleSoap implements Serializable {
	public static FlaskRoleSoap toSoapModel(FlaskRole model) {
		FlaskRoleSoap soapModel = new FlaskRoleSoap();

		soapModel.setRoleId(model.getRoleId());
		soapModel.setRoleName(model.getRoleName());
		soapModel.setRoleDesc(model.getRoleDesc());

		return soapModel;
	}

	public static FlaskRoleSoap[] toSoapModels(FlaskRole[] models) {
		FlaskRoleSoap[] soapModels = new FlaskRoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FlaskRoleSoap[][] toSoapModels(FlaskRole[][] models) {
		FlaskRoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FlaskRoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FlaskRoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FlaskRoleSoap[] toSoapModels(List<FlaskRole> models) {
		List<FlaskRoleSoap> soapModels = new ArrayList<FlaskRoleSoap>(models.size());

		for (FlaskRole model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FlaskRoleSoap[soapModels.size()]);
	}

	public FlaskRoleSoap() {
	}

	public long getPrimaryKey() {
		return _roleId;
	}

	public void setPrimaryKey(long pk) {
		setRoleId(pk);
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	public String getRoleName() {
		return _roleName;
	}

	public void setRoleName(String roleName) {
		_roleName = roleName;
	}

	public String getRoleDesc() {
		return _roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		_roleDesc = roleDesc;
	}

	private long _roleId;
	private String _roleName;
	private String _roleDesc;
}