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
 * This class is a wrapper for {@link SupplyItem}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplyItem
 * @generated
 */
public class SupplyItemWrapper implements SupplyItem, ModelWrapper<SupplyItem> {
	public SupplyItemWrapper(SupplyItem supplyItem) {
		_supplyItem = supplyItem;
	}

	@Override
	public Class<?> getModelClass() {
		return SupplyItem.class;
	}

	@Override
	public String getModelClassName() {
		return SupplyItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("supplyItemId", getSupplyItemId());
		attributes.put("supplyItemName", getSupplyItemName());
		attributes.put("supplyListId", getSupplyListId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long supplyItemId = (Long)attributes.get("supplyItemId");

		if (supplyItemId != null) {
			setSupplyItemId(supplyItemId);
		}

		String supplyItemName = (String)attributes.get("supplyItemName");

		if (supplyItemName != null) {
			setSupplyItemName(supplyItemName);
		}

		Long supplyListId = (Long)attributes.get("supplyListId");

		if (supplyListId != null) {
			setSupplyListId(supplyListId);
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
	* Returns the primary key of this supply item.
	*
	* @return the primary key of this supply item
	*/
	@Override
	public long getPrimaryKey() {
		return _supplyItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this supply item.
	*
	* @param primaryKey the primary key of this supply item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_supplyItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the supply item ID of this supply item.
	*
	* @return the supply item ID of this supply item
	*/
	@Override
	public long getSupplyItemId() {
		return _supplyItem.getSupplyItemId();
	}

	/**
	* Sets the supply item ID of this supply item.
	*
	* @param supplyItemId the supply item ID of this supply item
	*/
	@Override
	public void setSupplyItemId(long supplyItemId) {
		_supplyItem.setSupplyItemId(supplyItemId);
	}

	/**
	* Returns the supply item name of this supply item.
	*
	* @return the supply item name of this supply item
	*/
	@Override
	public java.lang.String getSupplyItemName() {
		return _supplyItem.getSupplyItemName();
	}

	/**
	* Sets the supply item name of this supply item.
	*
	* @param supplyItemName the supply item name of this supply item
	*/
	@Override
	public void setSupplyItemName(java.lang.String supplyItemName) {
		_supplyItem.setSupplyItemName(supplyItemName);
	}

	/**
	* Returns the supply list ID of this supply item.
	*
	* @return the supply list ID of this supply item
	*/
	@Override
	public long getSupplyListId() {
		return _supplyItem.getSupplyListId();
	}

	/**
	* Sets the supply list ID of this supply item.
	*
	* @param supplyListId the supply list ID of this supply item
	*/
	@Override
	public void setSupplyListId(long supplyListId) {
		_supplyItem.setSupplyListId(supplyListId);
	}

	/**
	* Returns the created date of this supply item.
	*
	* @return the created date of this supply item
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _supplyItem.getCreatedDate();
	}

	/**
	* Sets the created date of this supply item.
	*
	* @param createdDate the created date of this supply item
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_supplyItem.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this supply item.
	*
	* @return the modified date of this supply item
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _supplyItem.getModifiedDate();
	}

	/**
	* Sets the modified date of this supply item.
	*
	* @param modifiedDate the modified date of this supply item
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_supplyItem.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _supplyItem.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_supplyItem.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _supplyItem.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_supplyItem.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _supplyItem.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _supplyItem.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_supplyItem.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _supplyItem.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_supplyItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_supplyItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_supplyItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SupplyItemWrapper((SupplyItem)_supplyItem.clone());
	}

	@Override
	public int compareTo(com.rumbasolutions.flask.model.SupplyItem supplyItem) {
		return _supplyItem.compareTo(supplyItem);
	}

	@Override
	public int hashCode() {
		return _supplyItem.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.SupplyItem> toCacheModel() {
		return _supplyItem.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.SupplyItem toEscapedModel() {
		return new SupplyItemWrapper(_supplyItem.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.SupplyItem toUnescapedModel() {
		return new SupplyItemWrapper(_supplyItem.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _supplyItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _supplyItem.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_supplyItem.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SupplyItemWrapper)) {
			return false;
		}

		SupplyItemWrapper supplyItemWrapper = (SupplyItemWrapper)obj;

		if (Validator.equals(_supplyItem, supplyItemWrapper._supplyItem)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SupplyItem getWrappedSupplyItem() {
		return _supplyItem;
	}

	@Override
	public SupplyItem getWrappedModel() {
		return _supplyItem;
	}

	@Override
	public void resetOriginalValues() {
		_supplyItem.resetOriginalValues();
	}

	private SupplyItem _supplyItem;
}