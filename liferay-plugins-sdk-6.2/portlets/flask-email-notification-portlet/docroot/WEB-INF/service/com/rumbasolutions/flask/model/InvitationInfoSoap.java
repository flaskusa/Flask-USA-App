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
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.InvitationInfoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.http.InvitationInfoServiceSoap
 * @generated
 */
public class InvitationInfoSoap implements Serializable {
	public static InvitationInfoSoap toSoapModel(InvitationInfo model) {
		InvitationInfoSoap soapModel = new InvitationInfoSoap();

		soapModel.setInviationId(model.getInviationId());
		soapModel.setName(model.getName());
		soapModel.setEmail(model.getEmail());
		soapModel.setDescription(model.getDescription());
		soapModel.setInvitedDate(model.getInvitedDate());

		return soapModel;
	}

	public static InvitationInfoSoap[] toSoapModels(InvitationInfo[] models) {
		InvitationInfoSoap[] soapModels = new InvitationInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InvitationInfoSoap[][] toSoapModels(InvitationInfo[][] models) {
		InvitationInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InvitationInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InvitationInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InvitationInfoSoap[] toSoapModels(List<InvitationInfo> models) {
		List<InvitationInfoSoap> soapModels = new ArrayList<InvitationInfoSoap>(models.size());

		for (InvitationInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InvitationInfoSoap[soapModels.size()]);
	}

	public InvitationInfoSoap() {
	}

	public long getPrimaryKey() {
		return _inviationId;
	}

	public void setPrimaryKey(long pk) {
		setInviationId(pk);
	}

	public long getInviationId() {
		return _inviationId;
	}

	public void setInviationId(long inviationId) {
		_inviationId = inviationId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getInvitedDate() {
		return _invitedDate;
	}

	public void setInvitedDate(String invitedDate) {
		_invitedDate = invitedDate;
	}

	private long _inviationId;
	private String _name;
	private String _email;
	private String _description;
	private String _invitedDate;
}