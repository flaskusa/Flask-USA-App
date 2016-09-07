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
 * This class is a wrapper for {@link TailgateSupplyItem}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TailgateSupplyItem
 * @generated
 */
public class TailgateSupplyItemWrapper implements TailgateSupplyItem,
	ModelWrapper<TailgateSupplyItem> {
	public TailgateSupplyItemWrapper(TailgateSupplyItem tailgateSupplyItem) {
		_tailgateSupplyItem = tailgateSupplyItem;
	}

	@Override
	public Class<?> getModelClass() {
		return TailgateSupplyItem.class;
	}

	@Override
	public String getModelClassName() {
		return TailgateSupplyItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tailgateSupplyItemId", getTailgateSupplyItemId());
		attributes.put("supplyListItemName", getSupplyListItemName());
		attributes.put("tailgateId", getTailgateId());
		attributes.put("itemAssignedUserId", getItemAssignedUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tailgateSupplyItemId = (Long)attributes.get("tailgateSupplyItemId");

		if (tailgateSupplyItemId != null) {
			setTailgateSupplyItemId(tailgateSupplyItemId);
		}

		String supplyListItemName = (String)attributes.get("supplyListItemName");

		if (supplyListItemName != null) {
			setSupplyListItemName(supplyListItemName);
		}

		Long tailgateId = (Long)attributes.get("tailgateId");

		if (tailgateId != null) {
			setTailgateId(tailgateId);
		}

		Long itemAssignedUserId = (Long)attributes.get("itemAssignedUserId");

		if (itemAssignedUserId != null) {
			setItemAssignedUserId(itemAssignedUserId);
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
	* Returns the primary key of this tailgate supply item.
	*
	* @return the primary key of this tailgate supply item
	*/
	@Override
	public long getPrimaryKey() {
		return _tailgateSupplyItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tailgate supply item.
	*
	* @param primaryKey the primary key of this tailgate supply item
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tailgateSupplyItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tailgate supply item ID of this tailgate supply item.
	*
	* @return the tailgate supply item ID of this tailgate supply item
	*/
	@Override
	public long getTailgateSupplyItemId() {
		return _tailgateSupplyItem.getTailgateSupplyItemId();
	}

	/**
	* Sets the tailgate supply item ID of this tailgate supply item.
	*
	* @param tailgateSupplyItemId the tailgate supply item ID of this tailgate supply item
	*/
	@Override
	public void setTailgateSupplyItemId(long tailgateSupplyItemId) {
		_tailgateSupplyItem.setTailgateSupplyItemId(tailgateSupplyItemId);
	}

	/**
	* Returns the supply list item name of this tailgate supply item.
	*
	* @return the supply list item name of this tailgate supply item
	*/
	@Override
	public java.lang.String getSupplyListItemName() {
		return _tailgateSupplyItem.getSupplyListItemName();
	}

	/**
	* Sets the supply list item name of this tailgate supply item.
	*
	* @param supplyListItemName the supply list item name of this tailgate supply item
	*/
	@Override
	public void setSupplyListItemName(java.lang.String supplyListItemName) {
		_tailgateSupplyItem.setSupplyListItemName(supplyListItemName);
	}

	/**
	* Returns the tailgate ID of this tailgate supply item.
	*
	* @return the tailgate ID of this tailgate supply item
	*/
	@Override
	public long getTailgateId() {
		return _tailgateSupplyItem.getTailgateId();
	}

	/**
	* Sets the tailgate ID of this tailgate supply item.
	*
	* @param tailgateId the tailgate ID of this tailgate supply item
	*/
	@Override
	public void setTailgateId(long tailgateId) {
		_tailgateSupplyItem.setTailgateId(tailgateId);
	}

	/**
	* Returns the item assigned user ID of this tailgate supply item.
	*
	* @return the item assigned user ID of this tailgate supply item
	*/
	@Override
	public long getItemAssignedUserId() {
		return _tailgateSupplyItem.getItemAssignedUserId();
	}

	/**
	* Sets the item assigned user ID of this tailgate supply item.
	*
	* @param itemAssignedUserId the item assigned user ID of this tailgate supply item
	*/
	@Override
	public void setItemAssignedUserId(long itemAssignedUserId) {
		_tailgateSupplyItem.setItemAssignedUserId(itemAssignedUserId);
	}

	/**
	* Returns the item assigned user uuid of this tailgate supply item.
	*
	* @return the item assigned user uuid of this tailgate supply item
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getItemAssignedUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateSupplyItem.getItemAssignedUserUuid();
	}

	/**
	* Sets the item assigned user uuid of this tailgate supply item.
	*
	* @param itemAssignedUserUuid the item assigned user uuid of this tailgate supply item
	*/
	@Override
	public void setItemAssignedUserUuid(java.lang.String itemAssignedUserUuid) {
		_tailgateSupplyItem.setItemAssignedUserUuid(itemAssignedUserUuid);
	}

	/**
	* Returns the company ID of this tailgate supply item.
	*
	* @return the company ID of this tailgate supply item
	*/
	@Override
	public long getCompanyId() {
		return _tailgateSupplyItem.getCompanyId();
	}

	/**
	* Sets the company ID of this tailgate supply item.
	*
	* @param companyId the company ID of this tailgate supply item
	*/
	@Override
	public void setCompanyId(long companyId) {
		_tailgateSupplyItem.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this tailgate supply item.
	*
	* @return the user ID of this tailgate supply item
	*/
	@Override
	public long getUserId() {
		return _tailgateSupplyItem.getUserId();
	}

	/**
	* Sets the user ID of this tailgate supply item.
	*
	* @param userId the user ID of this tailgate supply item
	*/
	@Override
	public void setUserId(long userId) {
		_tailgateSupplyItem.setUserId(userId);
	}

	/**
	* Returns the user uuid of this tailgate supply item.
	*
	* @return the user uuid of this tailgate supply item
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateSupplyItem.getUserUuid();
	}

	/**
	* Sets the user uuid of this tailgate supply item.
	*
	* @param userUuid the user uuid of this tailgate supply item
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_tailgateSupplyItem.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this tailgate supply item.
	*
	* @return the created date of this tailgate supply item
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _tailgateSupplyItem.getCreatedDate();
	}

	/**
	* Sets the created date of this tailgate supply item.
	*
	* @param createdDate the created date of this tailgate supply item
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_tailgateSupplyItem.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this tailgate supply item.
	*
	* @return the modified date of this tailgate supply item
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _tailgateSupplyItem.getModifiedDate();
	}

	/**
	* Sets the modified date of this tailgate supply item.
	*
	* @param modifiedDate the modified date of this tailgate supply item
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_tailgateSupplyItem.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _tailgateSupplyItem.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tailgateSupplyItem.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tailgateSupplyItem.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tailgateSupplyItem.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tailgateSupplyItem.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tailgateSupplyItem.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tailgateSupplyItem.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tailgateSupplyItem.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tailgateSupplyItem.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tailgateSupplyItem.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tailgateSupplyItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TailgateSupplyItemWrapper((TailgateSupplyItem)_tailgateSupplyItem.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.TailgateSupplyItem tailgateSupplyItem) {
		return _tailgateSupplyItem.compareTo(tailgateSupplyItem);
	}

	@Override
	public int hashCode() {
		return _tailgateSupplyItem.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.TailgateSupplyItem> toCacheModel() {
		return _tailgateSupplyItem.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateSupplyItem toEscapedModel() {
		return new TailgateSupplyItemWrapper(_tailgateSupplyItem.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateSupplyItem toUnescapedModel() {
		return new TailgateSupplyItemWrapper(_tailgateSupplyItem.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tailgateSupplyItem.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tailgateSupplyItem.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tailgateSupplyItem.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TailgateSupplyItemWrapper)) {
			return false;
		}

		TailgateSupplyItemWrapper tailgateSupplyItemWrapper = (TailgateSupplyItemWrapper)obj;

		if (Validator.equals(_tailgateSupplyItem,
					tailgateSupplyItemWrapper._tailgateSupplyItem)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TailgateSupplyItem getWrappedTailgateSupplyItem() {
		return _tailgateSupplyItem;
	}

	@Override
	public TailgateSupplyItem getWrappedModel() {
		return _tailgateSupplyItem;
	}

	@Override
	public void resetOriginalValues() {
		_tailgateSupplyItem.resetOriginalValues();
	}

	private TailgateSupplyItem _tailgateSupplyItem;
}