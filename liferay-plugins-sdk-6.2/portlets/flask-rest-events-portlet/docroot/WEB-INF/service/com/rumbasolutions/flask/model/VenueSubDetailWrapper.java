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
 * This class is a wrapper for {@link VenueSubDetail}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueSubDetail
 * @generated
 */
public class VenueSubDetailWrapper implements VenueSubDetail,
	ModelWrapper<VenueSubDetail> {
	public VenueSubDetailWrapper(VenueSubDetail venueSubDetail) {
		_venueSubDetail = venueSubDetail;
	}

	@Override
	public Class<?> getModelClass() {
		return VenueSubDetail.class;
	}

	@Override
	public String getModelClassName() {
		return VenueSubDetail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("venueSubDetailId", getVenueSubDetailId());
		attributes.put("venueDetailId", getVenueDetailId());
		attributes.put("venueSubDetailTitle", getVenueSubDetailTitle());
		attributes.put("venueSubDetailDesc", getVenueSubDetailDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long venueSubDetailId = (Long)attributes.get("venueSubDetailId");

		if (venueSubDetailId != null) {
			setVenueSubDetailId(venueSubDetailId);
		}

		Long venueDetailId = (Long)attributes.get("venueDetailId");

		if (venueDetailId != null) {
			setVenueDetailId(venueDetailId);
		}

		String venueSubDetailTitle = (String)attributes.get(
				"venueSubDetailTitle");

		if (venueSubDetailTitle != null) {
			setVenueSubDetailTitle(venueSubDetailTitle);
		}

		String venueSubDetailDesc = (String)attributes.get("venueSubDetailDesc");

		if (venueSubDetailDesc != null) {
			setVenueSubDetailDesc(venueSubDetailDesc);
		}
	}

	/**
	* Returns the primary key of this venue sub detail.
	*
	* @return the primary key of this venue sub detail
	*/
	@Override
	public long getPrimaryKey() {
		return _venueSubDetail.getPrimaryKey();
	}

	/**
	* Sets the primary key of this venue sub detail.
	*
	* @param primaryKey the primary key of this venue sub detail
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_venueSubDetail.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the venue sub detail ID of this venue sub detail.
	*
	* @return the venue sub detail ID of this venue sub detail
	*/
	@Override
	public long getVenueSubDetailId() {
		return _venueSubDetail.getVenueSubDetailId();
	}

	/**
	* Sets the venue sub detail ID of this venue sub detail.
	*
	* @param venueSubDetailId the venue sub detail ID of this venue sub detail
	*/
	@Override
	public void setVenueSubDetailId(long venueSubDetailId) {
		_venueSubDetail.setVenueSubDetailId(venueSubDetailId);
	}

	/**
	* Returns the venue detail ID of this venue sub detail.
	*
	* @return the venue detail ID of this venue sub detail
	*/
	@Override
	public long getVenueDetailId() {
		return _venueSubDetail.getVenueDetailId();
	}

	/**
	* Sets the venue detail ID of this venue sub detail.
	*
	* @param venueDetailId the venue detail ID of this venue sub detail
	*/
	@Override
	public void setVenueDetailId(long venueDetailId) {
		_venueSubDetail.setVenueDetailId(venueDetailId);
	}

	/**
	* Returns the venue sub detail title of this venue sub detail.
	*
	* @return the venue sub detail title of this venue sub detail
	*/
	@Override
	public java.lang.String getVenueSubDetailTitle() {
		return _venueSubDetail.getVenueSubDetailTitle();
	}

	/**
	* Sets the venue sub detail title of this venue sub detail.
	*
	* @param venueSubDetailTitle the venue sub detail title of this venue sub detail
	*/
	@Override
	public void setVenueSubDetailTitle(java.lang.String venueSubDetailTitle) {
		_venueSubDetail.setVenueSubDetailTitle(venueSubDetailTitle);
	}

	/**
	* Returns the venue sub detail desc of this venue sub detail.
	*
	* @return the venue sub detail desc of this venue sub detail
	*/
	@Override
	public java.lang.String getVenueSubDetailDesc() {
		return _venueSubDetail.getVenueSubDetailDesc();
	}

	/**
	* Sets the venue sub detail desc of this venue sub detail.
	*
	* @param venueSubDetailDesc the venue sub detail desc of this venue sub detail
	*/
	@Override
	public void setVenueSubDetailDesc(java.lang.String venueSubDetailDesc) {
		_venueSubDetail.setVenueSubDetailDesc(venueSubDetailDesc);
	}

	@Override
	public boolean isNew() {
		return _venueSubDetail.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_venueSubDetail.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _venueSubDetail.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_venueSubDetail.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _venueSubDetail.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _venueSubDetail.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_venueSubDetail.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _venueSubDetail.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_venueSubDetail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_venueSubDetail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_venueSubDetail.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VenueSubDetailWrapper((VenueSubDetail)_venueSubDetail.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.VenueSubDetail venueSubDetail) {
		return _venueSubDetail.compareTo(venueSubDetail);
	}

	@Override
	public int hashCode() {
		return _venueSubDetail.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.VenueSubDetail> toCacheModel() {
		return _venueSubDetail.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.VenueSubDetail toEscapedModel() {
		return new VenueSubDetailWrapper(_venueSubDetail.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.VenueSubDetail toUnescapedModel() {
		return new VenueSubDetailWrapper(_venueSubDetail.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _venueSubDetail.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _venueSubDetail.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_venueSubDetail.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VenueSubDetailWrapper)) {
			return false;
		}

		VenueSubDetailWrapper venueSubDetailWrapper = (VenueSubDetailWrapper)obj;

		if (Validator.equals(_venueSubDetail,
					venueSubDetailWrapper._venueSubDetail)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VenueSubDetail getWrappedVenueSubDetail() {
		return _venueSubDetail;
	}

	@Override
	public VenueSubDetail getWrappedModel() {
		return _venueSubDetail;
	}

	@Override
	public void resetOriginalValues() {
		_venueSubDetail.resetOriginalValues();
	}

	private VenueSubDetail _venueSubDetail;
}