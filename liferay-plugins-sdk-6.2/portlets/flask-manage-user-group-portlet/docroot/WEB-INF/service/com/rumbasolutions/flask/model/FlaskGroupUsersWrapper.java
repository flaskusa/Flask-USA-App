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
 * This class is a wrapper for {@link FlaskGroupUsers}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupUsers
 * @generated
 */
public class FlaskGroupUsersWrapper implements FlaskGroupUsers,
	ModelWrapper<FlaskGroupUsers> {
	public FlaskGroupUsersWrapper(FlaskGroupUsers flaskGroupUsers) {
		_flaskGroupUsers = flaskGroupUsers;
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskGroupUsers.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskGroupUsers.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupUserId", getGroupUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("isAdmin", getIsAdmin());
		attributes.put("emailAddress", getEmailAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupUserId = (Long)attributes.get("groupUserId");

		if (groupUserId != null) {
			setGroupUserId(groupUserId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Integer isAdmin = (Integer)attributes.get("isAdmin");

		if (isAdmin != null) {
			setIsAdmin(isAdmin);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}
	}

	/**
	* Returns the primary key of this flask group users.
	*
	* @return the primary key of this flask group users
	*/
	@Override
	public long getPrimaryKey() {
		return _flaskGroupUsers.getPrimaryKey();
	}

	/**
	* Sets the primary key of this flask group users.
	*
	* @param primaryKey the primary key of this flask group users
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_flaskGroupUsers.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the group user ID of this flask group users.
	*
	* @return the group user ID of this flask group users
	*/
	@Override
	public long getGroupUserId() {
		return _flaskGroupUsers.getGroupUserId();
	}

	/**
	* Sets the group user ID of this flask group users.
	*
	* @param groupUserId the group user ID of this flask group users
	*/
	@Override
	public void setGroupUserId(long groupUserId) {
		_flaskGroupUsers.setGroupUserId(groupUserId);
	}

	/**
	* Returns the group user uuid of this flask group users.
	*
	* @return the group user uuid of this flask group users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getGroupUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupUsers.getGroupUserUuid();
	}

	/**
	* Sets the group user uuid of this flask group users.
	*
	* @param groupUserUuid the group user uuid of this flask group users
	*/
	@Override
	public void setGroupUserUuid(java.lang.String groupUserUuid) {
		_flaskGroupUsers.setGroupUserUuid(groupUserUuid);
	}

	/**
	* Returns the group ID of this flask group users.
	*
	* @return the group ID of this flask group users
	*/
	@Override
	public long getGroupId() {
		return _flaskGroupUsers.getGroupId();
	}

	/**
	* Sets the group ID of this flask group users.
	*
	* @param groupId the group ID of this flask group users
	*/
	@Override
	public void setGroupId(long groupId) {
		_flaskGroupUsers.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this flask group users.
	*
	* @return the user ID of this flask group users
	*/
	@Override
	public long getUserId() {
		return _flaskGroupUsers.getUserId();
	}

	/**
	* Sets the user ID of this flask group users.
	*
	* @param userId the user ID of this flask group users
	*/
	@Override
	public void setUserId(long userId) {
		_flaskGroupUsers.setUserId(userId);
	}

	/**
	* Returns the user uuid of this flask group users.
	*
	* @return the user uuid of this flask group users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupUsers.getUserUuid();
	}

	/**
	* Sets the user uuid of this flask group users.
	*
	* @param userUuid the user uuid of this flask group users
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_flaskGroupUsers.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this flask group users.
	*
	* @return the user name of this flask group users
	*/
	@Override
	public java.lang.String getUserName() {
		return _flaskGroupUsers.getUserName();
	}

	/**
	* Sets the user name of this flask group users.
	*
	* @param userName the user name of this flask group users
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_flaskGroupUsers.setUserName(userName);
	}

	/**
	* Returns the is admin of this flask group users.
	*
	* @return the is admin of this flask group users
	*/
	@Override
	public int getIsAdmin() {
		return _flaskGroupUsers.getIsAdmin();
	}

	/**
	* Sets the is admin of this flask group users.
	*
	* @param isAdmin the is admin of this flask group users
	*/
	@Override
	public void setIsAdmin(int isAdmin) {
		_flaskGroupUsers.setIsAdmin(isAdmin);
	}

	/**
	* Returns the email address of this flask group users.
	*
	* @return the email address of this flask group users
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _flaskGroupUsers.getEmailAddress();
	}

	/**
	* Sets the email address of this flask group users.
	*
	* @param emailAddress the email address of this flask group users
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_flaskGroupUsers.setEmailAddress(emailAddress);
	}

	@Override
	public boolean isNew() {
		return _flaskGroupUsers.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_flaskGroupUsers.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _flaskGroupUsers.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_flaskGroupUsers.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _flaskGroupUsers.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _flaskGroupUsers.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_flaskGroupUsers.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _flaskGroupUsers.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_flaskGroupUsers.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_flaskGroupUsers.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flaskGroupUsers.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FlaskGroupUsersWrapper((FlaskGroupUsers)_flaskGroupUsers.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.FlaskGroupUsers flaskGroupUsers) {
		return _flaskGroupUsers.compareTo(flaskGroupUsers);
	}

	@Override
	public int hashCode() {
		return _flaskGroupUsers.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.FlaskGroupUsers> toCacheModel() {
		return _flaskGroupUsers.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskGroupUsers toEscapedModel() {
		return new FlaskGroupUsersWrapper(_flaskGroupUsers.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskGroupUsers toUnescapedModel() {
		return new FlaskGroupUsersWrapper(_flaskGroupUsers.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _flaskGroupUsers.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _flaskGroupUsers.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_flaskGroupUsers.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlaskGroupUsersWrapper)) {
			return false;
		}

		FlaskGroupUsersWrapper flaskGroupUsersWrapper = (FlaskGroupUsersWrapper)obj;

		if (Validator.equals(_flaskGroupUsers,
					flaskGroupUsersWrapper._flaskGroupUsers)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FlaskGroupUsers getWrappedFlaskGroupUsers() {
		return _flaskGroupUsers;
	}

	@Override
	public FlaskGroupUsers getWrappedModel() {
		return _flaskGroupUsers;
	}

	@Override
	public void resetOriginalValues() {
		_flaskGroupUsers.resetOriginalValues();
	}

	private FlaskGroupUsers _flaskGroupUsers;
}