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
 * This class is a wrapper for {@link FlaskGroup}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroup
 * @generated
 */
public class FlaskGroupWrapper implements FlaskGroup, ModelWrapper<FlaskGroup> {
	public FlaskGroupWrapper(FlaskGroup flaskGroup) {
		_flaskGroup = flaskGroup;
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskGroup.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskGroup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupId", getGroupId());
		attributes.put("groupName", getGroupName());
		attributes.put("groupDescription", getGroupDescription());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("isActive", getIsActive());
		attributes.put("isDelete", getIsDelete());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String groupName = (String)attributes.get("groupName");

		if (groupName != null) {
			setGroupName(groupName);
		}

		String groupDescription = (String)attributes.get("groupDescription");

		if (groupDescription != null) {
			setGroupDescription(groupDescription);
		}

		String createdDate = (String)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Integer isActive = (Integer)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		Integer isDelete = (Integer)attributes.get("isDelete");

		if (isDelete != null) {
			setIsDelete(isDelete);
		}
	}

	/**
	* Returns the primary key of this flask group.
	*
	* @return the primary key of this flask group
	*/
	@Override
	public long getPrimaryKey() {
		return _flaskGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this flask group.
	*
	* @param primaryKey the primary key of this flask group
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_flaskGroup.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the group ID of this flask group.
	*
	* @return the group ID of this flask group
	*/
	@Override
	public long getGroupId() {
		return _flaskGroup.getGroupId();
	}

	/**
	* Sets the group ID of this flask group.
	*
	* @param groupId the group ID of this flask group
	*/
	@Override
	public void setGroupId(long groupId) {
		_flaskGroup.setGroupId(groupId);
	}

	/**
	* Returns the group name of this flask group.
	*
	* @return the group name of this flask group
	*/
	@Override
	public java.lang.String getGroupName() {
		return _flaskGroup.getGroupName();
	}

	/**
	* Sets the group name of this flask group.
	*
	* @param groupName the group name of this flask group
	*/
	@Override
	public void setGroupName(java.lang.String groupName) {
		_flaskGroup.setGroupName(groupName);
	}

	/**
	* Returns the group description of this flask group.
	*
	* @return the group description of this flask group
	*/
	@Override
	public java.lang.String getGroupDescription() {
		return _flaskGroup.getGroupDescription();
	}

	/**
	* Sets the group description of this flask group.
	*
	* @param groupDescription the group description of this flask group
	*/
	@Override
	public void setGroupDescription(java.lang.String groupDescription) {
		_flaskGroup.setGroupDescription(groupDescription);
	}

	/**
	* Returns the created date of this flask group.
	*
	* @return the created date of this flask group
	*/
	@Override
	public java.lang.String getCreatedDate() {
		return _flaskGroup.getCreatedDate();
	}

	/**
	* Sets the created date of this flask group.
	*
	* @param createdDate the created date of this flask group
	*/
	@Override
	public void setCreatedDate(java.lang.String createdDate) {
		_flaskGroup.setCreatedDate(createdDate);
	}

	/**
	* Returns the created by of this flask group.
	*
	* @return the created by of this flask group
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _flaskGroup.getCreatedBy();
	}

	/**
	* Sets the created by of this flask group.
	*
	* @param createdBy the created by of this flask group
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_flaskGroup.setCreatedBy(createdBy);
	}

	/**
	* Returns the is active of this flask group.
	*
	* @return the is active of this flask group
	*/
	@Override
	public int getIsActive() {
		return _flaskGroup.getIsActive();
	}

	/**
	* Sets the is active of this flask group.
	*
	* @param isActive the is active of this flask group
	*/
	@Override
	public void setIsActive(int isActive) {
		_flaskGroup.setIsActive(isActive);
	}

	/**
	* Returns the is delete of this flask group.
	*
	* @return the is delete of this flask group
	*/
	@Override
	public int getIsDelete() {
		return _flaskGroup.getIsDelete();
	}

	/**
	* Sets the is delete of this flask group.
	*
	* @param isDelete the is delete of this flask group
	*/
	@Override
	public void setIsDelete(int isDelete) {
		_flaskGroup.setIsDelete(isDelete);
	}

	@Override
	public boolean isNew() {
		return _flaskGroup.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_flaskGroup.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _flaskGroup.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_flaskGroup.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _flaskGroup.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _flaskGroup.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_flaskGroup.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _flaskGroup.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_flaskGroup.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_flaskGroup.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flaskGroup.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FlaskGroupWrapper((FlaskGroup)_flaskGroup.clone());
	}

	@Override
	public int compareTo(com.rumbasolutions.flask.model.FlaskGroup flaskGroup) {
		return _flaskGroup.compareTo(flaskGroup);
	}

	@Override
	public int hashCode() {
		return _flaskGroup.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.FlaskGroup> toCacheModel() {
		return _flaskGroup.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskGroup toEscapedModel() {
		return new FlaskGroupWrapper(_flaskGroup.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskGroup toUnescapedModel() {
		return new FlaskGroupWrapper(_flaskGroup.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _flaskGroup.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _flaskGroup.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_flaskGroup.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlaskGroupWrapper)) {
			return false;
		}

		FlaskGroupWrapper flaskGroupWrapper = (FlaskGroupWrapper)obj;

		if (Validator.equals(_flaskGroup, flaskGroupWrapper._flaskGroup)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FlaskGroup getWrappedFlaskGroup() {
		return _flaskGroup;
	}

	@Override
	public FlaskGroup getWrappedModel() {
		return _flaskGroup;
	}

	@Override
	public void resetOriginalValues() {
		_flaskGroup.resetOriginalValues();
	}

	private FlaskGroup _flaskGroup;
}