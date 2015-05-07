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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FlaskAdmin}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see FlaskAdmin
 * @generated
 */
public class FlaskAdminWrapper implements FlaskAdmin, ModelWrapper<FlaskAdmin> {
	public FlaskAdminWrapper(FlaskAdmin flaskAdmin) {
		_flaskAdmin = flaskAdmin;
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskAdmin.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskAdmin.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("roleId", getRoleId());
		attributes.put("firstName", getFirstName());
		attributes.put("middleName", getMiddleName());
		attributes.put("lastName", getLastName());
		attributes.put("screenName", getScreenName());
		attributes.put("email", getEmail());
		attributes.put("DOB", getDOB());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String screenName = (String)attributes.get("screenName");

		if (screenName != null) {
			setScreenName(screenName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date DOB = (Date)attributes.get("DOB");

		if (DOB != null) {
			setDOB(DOB);
		}
	}

	/**
	* Returns the primary key of this flask admin.
	*
	* @return the primary key of this flask admin
	*/
	@Override
	public long getPrimaryKey() {
		return _flaskAdmin.getPrimaryKey();
	}

	/**
	* Sets the primary key of this flask admin.
	*
	* @param primaryKey the primary key of this flask admin
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_flaskAdmin.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this flask admin.
	*
	* @return the user ID of this flask admin
	*/
	@Override
	public long getUserId() {
		return _flaskAdmin.getUserId();
	}

	/**
	* Sets the user ID of this flask admin.
	*
	* @param userId the user ID of this flask admin
	*/
	@Override
	public void setUserId(long userId) {
		_flaskAdmin.setUserId(userId);
	}

	/**
	* Returns the user uuid of this flask admin.
	*
	* @return the user uuid of this flask admin
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskAdmin.getUserUuid();
	}

	/**
	* Sets the user uuid of this flask admin.
	*
	* @param userUuid the user uuid of this flask admin
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_flaskAdmin.setUserUuid(userUuid);
	}

	/**
	* Returns the role ID of this flask admin.
	*
	* @return the role ID of this flask admin
	*/
	@Override
	public long getRoleId() {
		return _flaskAdmin.getRoleId();
	}

	/**
	* Sets the role ID of this flask admin.
	*
	* @param roleId the role ID of this flask admin
	*/
	@Override
	public void setRoleId(long roleId) {
		_flaskAdmin.setRoleId(roleId);
	}

	/**
	* Returns the first name of this flask admin.
	*
	* @return the first name of this flask admin
	*/
	@Override
	public java.lang.String getFirstName() {
		return _flaskAdmin.getFirstName();
	}

	/**
	* Sets the first name of this flask admin.
	*
	* @param firstName the first name of this flask admin
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_flaskAdmin.setFirstName(firstName);
	}

	/**
	* Returns the middle name of this flask admin.
	*
	* @return the middle name of this flask admin
	*/
	@Override
	public java.lang.String getMiddleName() {
		return _flaskAdmin.getMiddleName();
	}

	/**
	* Sets the middle name of this flask admin.
	*
	* @param middleName the middle name of this flask admin
	*/
	@Override
	public void setMiddleName(java.lang.String middleName) {
		_flaskAdmin.setMiddleName(middleName);
	}

	/**
	* Returns the last name of this flask admin.
	*
	* @return the last name of this flask admin
	*/
	@Override
	public java.lang.String getLastName() {
		return _flaskAdmin.getLastName();
	}

	/**
	* Sets the last name of this flask admin.
	*
	* @param lastName the last name of this flask admin
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_flaskAdmin.setLastName(lastName);
	}

	/**
	* Returns the screen name of this flask admin.
	*
	* @return the screen name of this flask admin
	*/
	@Override
	public java.lang.String getScreenName() {
		return _flaskAdmin.getScreenName();
	}

	/**
	* Sets the screen name of this flask admin.
	*
	* @param screenName the screen name of this flask admin
	*/
	@Override
	public void setScreenName(java.lang.String screenName) {
		_flaskAdmin.setScreenName(screenName);
	}

	/**
	* Returns the email of this flask admin.
	*
	* @return the email of this flask admin
	*/
	@Override
	public java.lang.String getEmail() {
		return _flaskAdmin.getEmail();
	}

	/**
	* Sets the email of this flask admin.
	*
	* @param email the email of this flask admin
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_flaskAdmin.setEmail(email);
	}

	/**
	* Returns the d o b of this flask admin.
	*
	* @return the d o b of this flask admin
	*/
	@Override
	public java.util.Date getDOB() {
		return _flaskAdmin.getDOB();
	}

	/**
	* Sets the d o b of this flask admin.
	*
	* @param DOB the d o b of this flask admin
	*/
	@Override
	public void setDOB(java.util.Date DOB) {
		_flaskAdmin.setDOB(DOB);
	}

	@Override
	public boolean isNew() {
		return _flaskAdmin.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_flaskAdmin.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _flaskAdmin.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_flaskAdmin.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _flaskAdmin.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _flaskAdmin.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_flaskAdmin.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _flaskAdmin.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_flaskAdmin.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_flaskAdmin.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flaskAdmin.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FlaskAdminWrapper((FlaskAdmin)_flaskAdmin.clone());
	}

	@Override
	public int compareTo(com.rumbasolutions.flask.model.FlaskAdmin flaskAdmin) {
		return _flaskAdmin.compareTo(flaskAdmin);
	}

	@Override
	public int hashCode() {
		return _flaskAdmin.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.FlaskAdmin> toCacheModel() {
		return _flaskAdmin.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskAdmin toEscapedModel() {
		return new FlaskAdminWrapper(_flaskAdmin.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskAdmin toUnescapedModel() {
		return new FlaskAdminWrapper(_flaskAdmin.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _flaskAdmin.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _flaskAdmin.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlaskAdminWrapper)) {
			return false;
		}

		FlaskAdminWrapper flaskAdminWrapper = (FlaskAdminWrapper)obj;

		if (Validator.equals(_flaskAdmin, flaskAdminWrapper._flaskAdmin)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FlaskAdmin getWrappedFlaskAdmin() {
		return _flaskAdmin;
	}

	@Override
	public FlaskAdmin getWrappedModel() {
		return _flaskAdmin;
	}

	@Override
	public void resetOriginalValues() {
		_flaskAdmin.resetOriginalValues();
	}

	private FlaskAdmin _flaskAdmin;
}