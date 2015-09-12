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
 * This class is a wrapper for {@link TailgateMarker}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TailgateMarker
 * @generated
 */
public class TailgateMarkerWrapper implements TailgateMarker,
	ModelWrapper<TailgateMarker> {
	public TailgateMarkerWrapper(TailgateMarker tailgateMarker) {
		_tailgateMarker = tailgateMarker;
	}

	@Override
	public Class<?> getModelClass() {
		return TailgateMarker.class;
	}

	@Override
	public String getModelClassName() {
		return TailgateMarker.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tailgatemarkerid", getTailgatemarkerid());
		attributes.put("tailgateid", getTailgateid());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tailgatemarkerid = (Long)attributes.get("tailgatemarkerid");

		if (tailgatemarkerid != null) {
			setTailgatemarkerid(tailgatemarkerid);
		}

		Long tailgateid = (Long)attributes.get("tailgateid");

		if (tailgateid != null) {
			setTailgateid(tailgateid);
		}

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this tailgate marker.
	*
	* @return the primary key of this tailgate marker
	*/
	@Override
	public long getPrimaryKey() {
		return _tailgateMarker.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tailgate marker.
	*
	* @param primaryKey the primary key of this tailgate marker
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_tailgateMarker.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tailgatemarkerid of this tailgate marker.
	*
	* @return the tailgatemarkerid of this tailgate marker
	*/
	@Override
	public long getTailgatemarkerid() {
		return _tailgateMarker.getTailgatemarkerid();
	}

	/**
	* Sets the tailgatemarkerid of this tailgate marker.
	*
	* @param tailgatemarkerid the tailgatemarkerid of this tailgate marker
	*/
	@Override
	public void setTailgatemarkerid(long tailgatemarkerid) {
		_tailgateMarker.setTailgatemarkerid(tailgatemarkerid);
	}

	/**
	* Returns the tailgateid of this tailgate marker.
	*
	* @return the tailgateid of this tailgate marker
	*/
	@Override
	public long getTailgateid() {
		return _tailgateMarker.getTailgateid();
	}

	/**
	* Sets the tailgateid of this tailgate marker.
	*
	* @param tailgateid the tailgateid of this tailgate marker
	*/
	@Override
	public void setTailgateid(long tailgateid) {
		_tailgateMarker.setTailgateid(tailgateid);
	}

	/**
	* Returns the latitude of this tailgate marker.
	*
	* @return the latitude of this tailgate marker
	*/
	@Override
	public java.lang.String getLatitude() {
		return _tailgateMarker.getLatitude();
	}

	/**
	* Sets the latitude of this tailgate marker.
	*
	* @param latitude the latitude of this tailgate marker
	*/
	@Override
	public void setLatitude(java.lang.String latitude) {
		_tailgateMarker.setLatitude(latitude);
	}

	/**
	* Returns the longitude of this tailgate marker.
	*
	* @return the longitude of this tailgate marker
	*/
	@Override
	public java.lang.String getLongitude() {
		return _tailgateMarker.getLongitude();
	}

	/**
	* Sets the longitude of this tailgate marker.
	*
	* @param longitude the longitude of this tailgate marker
	*/
	@Override
	public void setLongitude(java.lang.String longitude) {
		_tailgateMarker.setLongitude(longitude);
	}

	/**
	* Returns the name of this tailgate marker.
	*
	* @return the name of this tailgate marker
	*/
	@Override
	public java.lang.String getName() {
		return _tailgateMarker.getName();
	}

	/**
	* Sets the name of this tailgate marker.
	*
	* @param name the name of this tailgate marker
	*/
	@Override
	public void setName(java.lang.String name) {
		_tailgateMarker.setName(name);
	}

	/**
	* Returns the description of this tailgate marker.
	*
	* @return the description of this tailgate marker
	*/
	@Override
	public java.lang.String getDescription() {
		return _tailgateMarker.getDescription();
	}

	/**
	* Sets the description of this tailgate marker.
	*
	* @param description the description of this tailgate marker
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_tailgateMarker.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _tailgateMarker.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_tailgateMarker.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _tailgateMarker.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_tailgateMarker.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _tailgateMarker.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _tailgateMarker.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tailgateMarker.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tailgateMarker.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_tailgateMarker.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_tailgateMarker.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tailgateMarker.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TailgateMarkerWrapper((TailgateMarker)_tailgateMarker.clone());
	}

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.TailgateMarker tailgateMarker) {
		return _tailgateMarker.compareTo(tailgateMarker);
	}

	@Override
	public int hashCode() {
		return _tailgateMarker.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.TailgateMarker> toCacheModel() {
		return _tailgateMarker.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateMarker toEscapedModel() {
		return new TailgateMarkerWrapper(_tailgateMarker.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateMarker toUnescapedModel() {
		return new TailgateMarkerWrapper(_tailgateMarker.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tailgateMarker.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _tailgateMarker.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tailgateMarker.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TailgateMarkerWrapper)) {
			return false;
		}

		TailgateMarkerWrapper tailgateMarkerWrapper = (TailgateMarkerWrapper)obj;

		if (Validator.equals(_tailgateMarker,
					tailgateMarkerWrapper._tailgateMarker)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TailgateMarker getWrappedTailgateMarker() {
		return _tailgateMarker;
	}

	@Override
	public TailgateMarker getWrappedModel() {
		return _tailgateMarker;
	}

	@Override
	public void resetOriginalValues() {
		_tailgateMarker.resetOriginalValues();
	}

	private TailgateMarker _tailgateMarker;
}