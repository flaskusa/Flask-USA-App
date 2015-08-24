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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link InvitationInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvitationInfo
 * @generated
 */
public class InvitationInfoWrapper implements InvitationInfo,
	ModelWrapper<InvitationInfo> {
	public InvitationInfoWrapper(InvitationInfo invitationInfo) {
		_invitationInfo = invitationInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return InvitationInfo.class;
	}

	@Override
	public String getModelClassName() {
		return InvitationInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("inviationId", getInviationId());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("description", getDescription());
		attributes.put("invitedDate", getInvitedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long inviationId = (Long)attributes.get("inviationId");

		if (inviationId != null) {
			setInviationId(inviationId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String invitedDate = (String)attributes.get("invitedDate");

		if (invitedDate != null) {
			setInvitedDate(invitedDate);
		}
	}

	/**
	* Returns the primary key of this invitation info.
	*
	* @return the primary key of this invitation info
	*/
	@Override
	public long getPrimaryKey() {
		return _invitationInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this invitation info.
	*
	* @param primaryKey the primary key of this invitation info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_invitationInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the inviation ID of this invitation info.
	*
	* @return the inviation ID of this invitation info
	*/
	@Override
	public long getInviationId() {
		return _invitationInfo.getInviationId();
	}

	/**
	* Sets the inviation ID of this invitation info.
	*
	* @param inviationId the inviation ID of this invitation info
	*/
	@Override
	public void setInviationId(long inviationId) {
		_invitationInfo.setInviationId(inviationId);
	}

	/**
	* Returns the name of this invitation info.
	*
	* @return the name of this invitation info
	*/
	@Override
	public java.lang.String getName() {
		return _invitationInfo.getName();
	}

	/**
	* Sets the name of this invitation info.
	*
	* @param name the name of this invitation info
	*/
	@Override
	public void setName(java.lang.String name) {
		_invitationInfo.setName(name);
	}

	/**
	* Returns the email of this invitation info.
	*
	* @return the email of this invitation info
	*/
	@Override
	public java.lang.String getEmail() {
		return _invitationInfo.getEmail();
	}

	/**
	* Sets the email of this invitation info.
	*
	* @param email the email of this invitation info
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_invitationInfo.setEmail(email);
	}

	/**
	* Returns the description of this invitation info.
	*
	* @return the description of this invitation info
	*/
	@Override
	public java.lang.String getDescription() {
		return _invitationInfo.getDescription();
	}

	/**
	* Sets the description of this invitation info.
	*
	* @param description the description of this invitation info
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_invitationInfo.setDescription(description);
	}

	/**
	* Returns the invited date of this invitation info.
	*
	* @return the invited date of this invitation info
	*/
	@Override
	public java.lang.String getInvitedDate() {
		return _invitationInfo.getInvitedDate();
	}

	/**
	* Sets the invited date of this invitation info.
	*
	* @param invitedDate the invited date of this invitation info
	*/
	@Override
	public void setInvitedDate(java.lang.String invitedDate) {
		_invitationInfo.setInvitedDate(invitedDate);
	}

	@Override
	public boolean isNew() {
		return _invitationInfo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_invitationInfo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _invitationInfo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_invitationInfo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _invitationInfo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _invitationInfo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_invitationInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _invitationInfo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_invitationInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_invitationInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_invitationInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InvitationInfoWrapper((InvitationInfo)_invitationInfo.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.InvitationInfo invitationInfo) {
		return _invitationInfo.compareTo(invitationInfo);
	}

	@Override
	public int hashCode() {
		return _invitationInfo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.InvitationInfo> toCacheModel() {
		return _invitationInfo.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.InvitationInfo toEscapedModel() {
		return new InvitationInfoWrapper(_invitationInfo.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.InvitationInfo toUnescapedModel() {
		return new InvitationInfoWrapper(_invitationInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _invitationInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _invitationInfo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_invitationInfo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InvitationInfoWrapper)) {
			return false;
		}

		InvitationInfoWrapper invitationInfoWrapper = (InvitationInfoWrapper)obj;

		if (Validator.equals(_invitationInfo,
					invitationInfoWrapper._invitationInfo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public InvitationInfo getWrappedInvitationInfo() {
		return _invitationInfo;
	}

	@Override
	public InvitationInfo getWrappedModel() {
		return _invitationInfo;
	}

	@Override
	public void resetOriginalValues() {
		_invitationInfo.resetOriginalValues();
	}

	private InvitationInfo _invitationInfo;
}