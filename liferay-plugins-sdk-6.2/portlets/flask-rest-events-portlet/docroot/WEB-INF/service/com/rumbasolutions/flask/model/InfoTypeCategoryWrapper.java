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
 * This class is a wrapper for {@link InfoTypeCategory}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see InfoTypeCategory
 * @generated
 */
public class InfoTypeCategoryWrapper implements InfoTypeCategory,
	ModelWrapper<InfoTypeCategory> {
	public InfoTypeCategoryWrapper(InfoTypeCategory infoTypeCategory) {
		_infoTypeCategory = infoTypeCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return InfoTypeCategory.class;
	}

	@Override
	public String getModelClassName() {
		return InfoTypeCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("infoTypeCategoryId", getInfoTypeCategoryId());
		attributes.put("infoTypeCategoryName", getInfoTypeCategoryName());
		attributes.put("displayTemplate", getDisplayTemplate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long infoTypeCategoryId = (Long)attributes.get("infoTypeCategoryId");

		if (infoTypeCategoryId != null) {
			setInfoTypeCategoryId(infoTypeCategoryId);
		}

		String infoTypeCategoryName = (String)attributes.get(
				"infoTypeCategoryName");

		if (infoTypeCategoryName != null) {
			setInfoTypeCategoryName(infoTypeCategoryName);
		}

		String displayTemplate = (String)attributes.get("displayTemplate");

		if (displayTemplate != null) {
			setDisplayTemplate(displayTemplate);
		}
	}

	/**
	* Returns the primary key of this info type category.
	*
	* @return the primary key of this info type category
	*/
	@Override
	public long getPrimaryKey() {
		return _infoTypeCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this info type category.
	*
	* @param primaryKey the primary key of this info type category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_infoTypeCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the info type category ID of this info type category.
	*
	* @return the info type category ID of this info type category
	*/
	@Override
	public long getInfoTypeCategoryId() {
		return _infoTypeCategory.getInfoTypeCategoryId();
	}

	/**
	* Sets the info type category ID of this info type category.
	*
	* @param infoTypeCategoryId the info type category ID of this info type category
	*/
	@Override
	public void setInfoTypeCategoryId(long infoTypeCategoryId) {
		_infoTypeCategory.setInfoTypeCategoryId(infoTypeCategoryId);
	}

	/**
	* Returns the info type category name of this info type category.
	*
	* @return the info type category name of this info type category
	*/
	@Override
	public java.lang.String getInfoTypeCategoryName() {
		return _infoTypeCategory.getInfoTypeCategoryName();
	}

	/**
	* Sets the info type category name of this info type category.
	*
	* @param infoTypeCategoryName the info type category name of this info type category
	*/
	@Override
	public void setInfoTypeCategoryName(java.lang.String infoTypeCategoryName) {
		_infoTypeCategory.setInfoTypeCategoryName(infoTypeCategoryName);
	}

	/**
	* Returns the display template of this info type category.
	*
	* @return the display template of this info type category
	*/
	@Override
	public java.lang.String getDisplayTemplate() {
		return _infoTypeCategory.getDisplayTemplate();
	}

	/**
	* Sets the display template of this info type category.
	*
	* @param displayTemplate the display template of this info type category
	*/
	@Override
	public void setDisplayTemplate(java.lang.String displayTemplate) {
		_infoTypeCategory.setDisplayTemplate(displayTemplate);
	}

	@Override
	public boolean isNew() {
		return _infoTypeCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_infoTypeCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _infoTypeCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_infoTypeCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _infoTypeCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _infoTypeCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_infoTypeCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _infoTypeCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_infoTypeCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_infoTypeCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_infoTypeCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InfoTypeCategoryWrapper((InfoTypeCategory)_infoTypeCategory.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.InfoTypeCategory infoTypeCategory) {
		return _infoTypeCategory.compareTo(infoTypeCategory);
	}

	@Override
	public int hashCode() {
		return _infoTypeCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.InfoTypeCategory> toCacheModel() {
		return _infoTypeCategory.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.InfoTypeCategory toEscapedModel() {
		return new InfoTypeCategoryWrapper(_infoTypeCategory.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.InfoTypeCategory toUnescapedModel() {
		return new InfoTypeCategoryWrapper(_infoTypeCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _infoTypeCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _infoTypeCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_infoTypeCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InfoTypeCategoryWrapper)) {
			return false;
		}

		InfoTypeCategoryWrapper infoTypeCategoryWrapper = (InfoTypeCategoryWrapper)obj;

		if (Validator.equals(_infoTypeCategory,
					infoTypeCategoryWrapper._infoTypeCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public InfoTypeCategory getWrappedInfoTypeCategory() {
		return _infoTypeCategory;
	}

	@Override
	public InfoTypeCategory getWrappedModel() {
		return _infoTypeCategory;
	}

	@Override
	public void resetOriginalValues() {
		_infoTypeCategory.resetOriginalValues();
	}

	private InfoTypeCategory _infoTypeCategory;
}