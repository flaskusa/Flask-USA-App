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
 * This class is a wrapper for {@link TailgateUsers}.
 * </p>
 *
 * @author rajeshj
 * @see TailgateUsers
 * @generated
 */
public class TailgateUsersWrapper implements TailgateUsers,
	ModelWrapper<TailgateUsers> {
	public TailgateUsersWrapper(TailgateUsers tailgateUsers) {
		_tailgateUsers = tailgateUsers;
	}

	@Override
	public Class<?> getModelClass() {
		return TailgateUsers.class;
	}

	@Override
	public String getModelClassName() {
		return TailgateUsers.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tailgateUserId", getTailgateUserId());
		attributes.put("tailgateId", getTailgateId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("isAdmin", getIsAdmin());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tailgateUserId = (Long)attributes.get("tailgateUserId");

		if (tailgateUserId != null) {
			setTailgateUserId(tailgateUserId);
		}

		Long tailgateId = (Long)attributes.get("tailgateId");

		if (tailgateId != null) {
			setTailgateId(tailgateId);
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

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	/**
	* Returns the primary key of this tailgate users.
	*
	* @return the primary key of this tailgate users
	*/
	@Override
	public long getPrimaryKey() {
		return _tailgateUsers.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tailgate users.
	*
	* @param primaryKey the primary key of this tailgate users
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tailgateUsers.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tailgate user ID of this tailgate users.
	*
	* @return the tailgate user ID of this tailgate users
	*/
	@Override
	public long getTailgateUserId() {
		return _tailgateUsers.getTailgateUserId();
	}

	/**
	* Sets the tailgate user ID of this tailgate users.
	*
	* @param tailgateUserId the tailgate user ID of this tailgate users
	*/
	@Override
	public void setTailgateUserId(long tailgateUserId) {
		_tailgateUsers.setTailgateUserId(tailgateUserId);
	}

	/**
	* Returns the tailgate user uuid of this tailgate users.
	*
	* @return the tailgate user uuid of this tailgate users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getTailgateUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateUsers.getTailgateUserUuid();
	}

	/**
	* Sets the tailgate user uuid of this tailgate users.
	*
	* @param tailgateUserUuid the tailgate user uuid of this tailgate users
	*/
	@Override
	public void setTailgateUserUuid(java.lang.String tailgateUserUuid) {
		_tailgateUsers.setTailgateUserUuid(tailgateUserUuid);
	}

	/**
	* Returns the tailgate ID of this tailgate users.
	*
	* @return the tailgate ID of this tailgate users
	*/
	@Override
	public long getTailgateId() {
		return _tailgateUsers.getTailgateId();
	}

	/**
	* Sets the tailgate ID of this tailgate users.
	*
	* @param tailgateId the tailgate ID of this tailgate users
	*/
	@Override
	public void setTailgateId(long tailgateId) {
		_tailgateUsers.setTailgateId(tailgateId);
	}

	/**
	* Returns the user ID of this tailgate users.
	*
	* @return the user ID of this tailgate users
	*/
	@Override
	public long getUserId() {
		return _tailgateUsers.getUserId();
	}

	/**
	* Sets the user ID of this tailgate users.
	*
	* @param userId the user ID of this tailgate users
	*/
	@Override
	public void setUserId(long userId) {
		_tailgateUsers.setUserId(userId);
	}

	/**
	* Returns the user uuid of this tailgate users.
	*
	* @return the user uuid of this tailgate users
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateUsers.getUserUuid();
	}

	/**
	* Sets the user uuid of this tailgate users.
	*
	* @param userUuid the user uuid of this tailgate users
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tailgateUsers.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this tailgate users.
	*
	* @return the user name of this tailgate users
	*/
	@Override
	public java.lang.String getUserName() {
		return _tailgateUsers.getUserName();
	}

	/**
	* Sets the user name of this tailgate users.
	*
	* @param userName the user name of this tailgate users
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_tailgateUsers.setUserName(userName);
	}

	/**
	* Returns the is admin of this tailgate users.
	*
	* @return the is admin of this tailgate users
	*/
	@Override
	public int getIsAdmin() {
		return _tailgateUsers.getIsAdmin();
	}

	/**
	* Sets the is admin of this tailgate users.
	*
	* @param isAdmin the is admin of this tailgate users
	*/
	@Override
	public void setIsAdmin(int isAdmin) {
		_tailgateUsers.setIsAdmin(isAdmin);
	}

	/**
	* Returns the group ID of this tailgate users.
	*
	* @return the group ID of this tailgate users
	*/
	@Override
	public long getGroupId() {
		return _tailgateUsers.getGroupId();
	}

	/**
	* Sets the group ID of this tailgate users.
	*
	* @param groupId the group ID of this tailgate users
	*/
	@Override
	public void setGroupId(long groupId) {
		_tailgateUsers.setGroupId(groupId);
	}

	@Override
	public boolean isNew() {
		return _tailgateUsers.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tailgateUsers.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tailgateUsers.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tailgateUsers.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tailgateUsers.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tailgateUsers.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tailgateUsers.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tailgateUsers.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tailgateUsers.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tailgateUsers.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tailgateUsers.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TailgateUsersWrapper((TailgateUsers)_tailgateUsers.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.TailgateUsers tailgateUsers) {
		return _tailgateUsers.compareTo(tailgateUsers);
	}

	@Override
	public int hashCode() {
		return _tailgateUsers.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.TailgateUsers> toCacheModel() {
		return _tailgateUsers.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateUsers toEscapedModel() {
		return new TailgateUsersWrapper(_tailgateUsers.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateUsers toUnescapedModel() {
		return new TailgateUsersWrapper(_tailgateUsers.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tailgateUsers.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tailgateUsers.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tailgateUsers.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TailgateUsersWrapper)) {
			return false;
		}

		TailgateUsersWrapper tailgateUsersWrapper = (TailgateUsersWrapper)obj;

		if (Validator.equals(_tailgateUsers, tailgateUsersWrapper._tailgateUsers)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TailgateUsers getWrappedTailgateUsers() {
		return _tailgateUsers;
	}

	@Override
	public TailgateUsers getWrappedModel() {
		return _tailgateUsers;
	}

	@Override
	public void resetOriginalValues() {
		_tailgateUsers.resetOriginalValues();
	}

	private TailgateUsers _tailgateUsers;
}