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
 * This class is a wrapper for {@link SupplyList}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplyList
 * @generated
 */
public class SupplyListWrapper implements SupplyList, ModelWrapper<SupplyList> {
	public SupplyListWrapper(SupplyList supplyList) {
		_supplyList = supplyList;
	}

	@Override
	public Class<?> getModelClass() {
		return SupplyList.class;
	}

	@Override
	public String getModelClassName() {
		return SupplyList.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("supplyListId", getSupplyListId());
		attributes.put("supplyListName", getSupplyListName());
		attributes.put("isSystem", getIsSystem());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long supplyListId = (Long)attributes.get("supplyListId");

		if (supplyListId != null) {
			setSupplyListId(supplyListId);
		}

		String supplyListName = (String)attributes.get("supplyListName");

		if (supplyListName != null) {
			setSupplyListName(supplyListName);
		}

		Boolean isSystem = (Boolean)attributes.get("isSystem");

		if (isSystem != null) {
			setIsSystem(isSystem);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this supply list.
	*
	* @return the primary key of this supply list
	*/
	@Override
	public long getPrimaryKey() {
		return _supplyList.getPrimaryKey();
	}

	/**
	* Sets the primary key of this supply list.
	*
	* @param primaryKey the primary key of this supply list
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_supplyList.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the supply list ID of this supply list.
	*
	* @return the supply list ID of this supply list
	*/
	@Override
	public long getSupplyListId() {
		return _supplyList.getSupplyListId();
	}

	/**
	* Sets the supply list ID of this supply list.
	*
	* @param supplyListId the supply list ID of this supply list
	*/
	@Override
	public void setSupplyListId(long supplyListId) {
		_supplyList.setSupplyListId(supplyListId);
	}

	/**
	* Returns the supply list name of this supply list.
	*
	* @return the supply list name of this supply list
	*/
	@Override
	public java.lang.String getSupplyListName() {
		return _supplyList.getSupplyListName();
	}

	/**
	* Sets the supply list name of this supply list.
	*
	* @param supplyListName the supply list name of this supply list
	*/
	@Override
	public void setSupplyListName(java.lang.String supplyListName) {
		_supplyList.setSupplyListName(supplyListName);
	}

	/**
	* Returns the is system of this supply list.
	*
	* @return the is system of this supply list
	*/
	@Override
	public boolean getIsSystem() {
		return _supplyList.getIsSystem();
	}

	/**
	* Returns <code>true</code> if this supply list is is system.
	*
	* @return <code>true</code> if this supply list is is system; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsSystem() {
		return _supplyList.isIsSystem();
	}

	/**
	* Sets whether this supply list is is system.
	*
	* @param isSystem the is system of this supply list
	*/
	@Override
	public void setIsSystem(boolean isSystem) {
		_supplyList.setIsSystem(isSystem);
	}

	/**
	* Returns the company ID of this supply list.
	*
	* @return the company ID of this supply list
	*/
	@Override
	public long getCompanyId() {
		return _supplyList.getCompanyId();
	}

	/**
	* Sets the company ID of this supply list.
	*
	* @param companyId the company ID of this supply list
	*/
	@Override
	public void setCompanyId(long companyId) {
		_supplyList.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this supply list.
	*
	* @return the user ID of this supply list
	*/
	@Override
	public long getUserId() {
		return _supplyList.getUserId();
	}

	/**
	* Sets the user ID of this supply list.
	*
	* @param userId the user ID of this supply list
	*/
	@Override
	public void setUserId(long userId) {
		_supplyList.setUserId(userId);
	}

	/**
	* Returns the user uuid of this supply list.
	*
	* @return the user uuid of this supply list
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _supplyList.getUserUuid();
	}

	/**
	* Sets the user uuid of this supply list.
	*
	* @param userUuid the user uuid of this supply list
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_supplyList.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this supply list.
	*
	* @return the created date of this supply list
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _supplyList.getCreatedDate();
	}

	/**
	* Sets the created date of this supply list.
	*
	* @param createdDate the created date of this supply list
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_supplyList.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this supply list.
	*
	* @return the modified date of this supply list
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _supplyList.getModifiedDate();
	}

	/**
	* Sets the modified date of this supply list.
	*
	* @param modifiedDate the modified date of this supply list
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_supplyList.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _supplyList.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_supplyList.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _supplyList.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_supplyList.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _supplyList.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _supplyList.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_supplyList.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _supplyList.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_supplyList.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_supplyList.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_supplyList.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SupplyListWrapper((SupplyList)_supplyList.clone());
	}

	@Override
	public int compareTo(com.rumbasolutions.flask.model.SupplyList supplyList) {
		return _supplyList.compareTo(supplyList);
	}

	@Override
	public int hashCode() {
		return _supplyList.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.SupplyList> toCacheModel() {
		return _supplyList.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.SupplyList toEscapedModel() {
		return new SupplyListWrapper(_supplyList.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.SupplyList toUnescapedModel() {
		return new SupplyListWrapper(_supplyList.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _supplyList.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _supplyList.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_supplyList.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SupplyListWrapper)) {
			return false;
		}

		SupplyListWrapper supplyListWrapper = (SupplyListWrapper)obj;

		if (Validator.equals(_supplyList, supplyListWrapper._supplyList)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SupplyList getWrappedSupplyList() {
		return _supplyList;
	}

	@Override
	public SupplyList getWrappedModel() {
		return _supplyList;
	}

	@Override
	public void resetOriginalValues() {
		_supplyList.resetOriginalValues();
	}

	private SupplyList _supplyList;
}