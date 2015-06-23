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
 * This class is a wrapper for {@link InfoType}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see InfoType
 * @generated
 */
public class InfoTypeWrapper implements InfoType, ModelWrapper<InfoType> {
	public InfoTypeWrapper(InfoType infoType) {
		_infoType = infoType;
	}

	@Override
	public Class<?> getModelClass() {
		return InfoType.class;
	}

	@Override
	public String getModelClassName() {
		return InfoType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("infoTypeId", getInfoTypeId());
		attributes.put("infoTypeName", getInfoTypeName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long infoTypeId = (Long)attributes.get("infoTypeId");

		if (infoTypeId != null) {
			setInfoTypeId(infoTypeId);
		}

		String infoTypeName = (String)attributes.get("infoTypeName");

		if (infoTypeName != null) {
			setInfoTypeName(infoTypeName);
		}
	}

	/**
	* Returns the primary key of this info type.
	*
	* @return the primary key of this info type
	*/
	@Override
	public long getPrimaryKey() {
		return _infoType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this info type.
	*
	* @param primaryKey the primary key of this info type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_infoType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the info type ID of this info type.
	*
	* @return the info type ID of this info type
	*/
	@Override
	public long getInfoTypeId() {
		return _infoType.getInfoTypeId();
	}

	/**
	* Sets the info type ID of this info type.
	*
	* @param infoTypeId the info type ID of this info type
	*/
	@Override
	public void setInfoTypeId(long infoTypeId) {
		_infoType.setInfoTypeId(infoTypeId);
	}

	/**
	* Returns the info type name of this info type.
	*
	* @return the info type name of this info type
	*/
	@Override
	public java.lang.String getInfoTypeName() {
		return _infoType.getInfoTypeName();
	}

	/**
	* Sets the info type name of this info type.
	*
	* @param infoTypeName the info type name of this info type
	*/
	@Override
	public void setInfoTypeName(java.lang.String infoTypeName) {
		_infoType.setInfoTypeName(infoTypeName);
	}

	@Override
	public boolean isNew() {
		return _infoType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_infoType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _infoType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_infoType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _infoType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _infoType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_infoType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _infoType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_infoType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_infoType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_infoType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InfoTypeWrapper((InfoType)_infoType.clone());
	}

	@Override
	public int compareTo(com.rumbasolutions.flask.model.InfoType infoType) {
		return _infoType.compareTo(infoType);
	}

	@Override
	public int hashCode() {
		return _infoType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.InfoType> toCacheModel() {
		return _infoType.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.InfoType toEscapedModel() {
		return new InfoTypeWrapper(_infoType.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.InfoType toUnescapedModel() {
		return new InfoTypeWrapper(_infoType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _infoType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _infoType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_infoType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InfoTypeWrapper)) {
			return false;
		}

		InfoTypeWrapper infoTypeWrapper = (InfoTypeWrapper)obj;

		if (Validator.equals(_infoType, infoTypeWrapper._infoType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public InfoType getWrappedInfoType() {
		return _infoType;
	}

	@Override
	public InfoType getWrappedModel() {
		return _infoType;
	}

	@Override
	public void resetOriginalValues() {
		_infoType.resetOriginalValues();
	}

	private InfoType _infoType;
}