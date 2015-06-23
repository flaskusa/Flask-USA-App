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
 * This class is a wrapper for {@link FlaskRole}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see FlaskRole
 * @generated
 */
public class FlaskRoleWrapper implements FlaskRole, ModelWrapper<FlaskRole> {
	public FlaskRoleWrapper(FlaskRole flaskRole) {
		_flaskRole = flaskRole;
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskRole.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskRole.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("roleId", getRoleId());
		attributes.put("roleName", getRoleName());
		attributes.put("roleDesc", getRoleDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		String roleName = (String)attributes.get("roleName");

		if (roleName != null) {
			setRoleName(roleName);
		}

		String roleDesc = (String)attributes.get("roleDesc");

		if (roleDesc != null) {
			setRoleDesc(roleDesc);
		}
	}

	/**
	* Returns the primary key of this flask role.
	*
	* @return the primary key of this flask role
	*/
	@Override
	public long getPrimaryKey() {
		return _flaskRole.getPrimaryKey();
	}

	/**
	* Sets the primary key of this flask role.
	*
	* @param primaryKey the primary key of this flask role
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_flaskRole.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the role ID of this flask role.
	*
	* @return the role ID of this flask role
	*/
	@Override
	public long getRoleId() {
		return _flaskRole.getRoleId();
	}

	/**
	* Sets the role ID of this flask role.
	*
	* @param roleId the role ID of this flask role
	*/
	@Override
	public void setRoleId(long roleId) {
		_flaskRole.setRoleId(roleId);
	}

	/**
	* Returns the role name of this flask role.
	*
	* @return the role name of this flask role
	*/
	@Override
	public java.lang.String getRoleName() {
		return _flaskRole.getRoleName();
	}

	/**
	* Sets the role name of this flask role.
	*
	* @param roleName the role name of this flask role
	*/
	@Override
	public void setRoleName(java.lang.String roleName) {
		_flaskRole.setRoleName(roleName);
	}

	/**
	* Returns the role desc of this flask role.
	*
	* @return the role desc of this flask role
	*/
	@Override
	public java.lang.String getRoleDesc() {
		return _flaskRole.getRoleDesc();
	}

	/**
	* Sets the role desc of this flask role.
	*
	* @param roleDesc the role desc of this flask role
	*/
	@Override
	public void setRoleDesc(java.lang.String roleDesc) {
		_flaskRole.setRoleDesc(roleDesc);
	}

	@Override
	public boolean isNew() {
		return _flaskRole.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_flaskRole.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _flaskRole.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_flaskRole.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _flaskRole.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _flaskRole.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_flaskRole.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _flaskRole.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_flaskRole.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_flaskRole.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flaskRole.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FlaskRoleWrapper((FlaskRole)_flaskRole.clone());
	}

	@Override
	public int compareTo(com.rumbasolutions.flask.model.FlaskRole flaskRole) {
		return _flaskRole.compareTo(flaskRole);
	}

	@Override
	public int hashCode() {
		return _flaskRole.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.FlaskRole> toCacheModel() {
		return _flaskRole.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskRole toEscapedModel() {
		return new FlaskRoleWrapper(_flaskRole.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskRole toUnescapedModel() {
		return new FlaskRoleWrapper(_flaskRole.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _flaskRole.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _flaskRole.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlaskRoleWrapper)) {
			return false;
		}

		FlaskRoleWrapper flaskRoleWrapper = (FlaskRoleWrapper)obj;

		if (Validator.equals(_flaskRole, flaskRoleWrapper._flaskRole)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FlaskRole getWrappedFlaskRole() {
		return _flaskRole;
	}

	@Override
	public FlaskRole getWrappedModel() {
		return _flaskRole;
	}

	@Override
	public void resetOriginalValues() {
		_flaskRole.resetOriginalValues();
	}

	private FlaskRole _flaskRole;
}