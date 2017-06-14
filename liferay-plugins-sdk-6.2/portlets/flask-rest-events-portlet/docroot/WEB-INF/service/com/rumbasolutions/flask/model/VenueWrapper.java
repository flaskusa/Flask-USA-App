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
 * This class is a wrapper for {@link Venue}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see Venue
 * @generated
 */
public class VenueWrapper implements Venue, ModelWrapper<Venue> {
	public VenueWrapper(Venue venue) {
		_venue = venue;
	}

	@Override
	public Class<?> getModelClass() {
		return Venue.class;
	}

	@Override
	public String getModelClassName() {
		return Venue.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("venueId", getVenueId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("venueName", getVenueName());
		attributes.put("venueDescription", getVenueDescription());
		attributes.put("venueZipCode", getVenueZipCode());
		attributes.put("addrLine1", getAddrLine1());
		attributes.put("addrLine2", getAddrLine2());
		attributes.put("venueCity", getVenueCity());
		attributes.put("venueStateId", getVenueStateId());
		attributes.put("venueStateName", getVenueStateName());
		attributes.put("venueCountryId", getVenueCountryId());
		attributes.put("venueCountryName", getVenueCountryName());
		attributes.put("venueMetroArea", getVenueMetroArea());
		attributes.put("longitude", getLongitude());
		attributes.put("latitude", getLatitude());
		attributes.put("venueDetailsDistRange", getVenueDetailsDistRange());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long venueId = (Long)attributes.get("venueId");

		if (venueId != null) {
			setVenueId(venueId);
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

		String venueName = (String)attributes.get("venueName");

		if (venueName != null) {
			setVenueName(venueName);
		}

		String venueDescription = (String)attributes.get("venueDescription");

		if (venueDescription != null) {
			setVenueDescription(venueDescription);
		}

		String venueZipCode = (String)attributes.get("venueZipCode");

		if (venueZipCode != null) {
			setVenueZipCode(venueZipCode);
		}

		String addrLine1 = (String)attributes.get("addrLine1");

		if (addrLine1 != null) {
			setAddrLine1(addrLine1);
		}

		String addrLine2 = (String)attributes.get("addrLine2");

		if (addrLine2 != null) {
			setAddrLine2(addrLine2);
		}

		String venueCity = (String)attributes.get("venueCity");

		if (venueCity != null) {
			setVenueCity(venueCity);
		}

		Long venueStateId = (Long)attributes.get("venueStateId");

		if (venueStateId != null) {
			setVenueStateId(venueStateId);
		}

		String venueStateName = (String)attributes.get("venueStateName");

		if (venueStateName != null) {
			setVenueStateName(venueStateName);
		}

		Long venueCountryId = (Long)attributes.get("venueCountryId");

		if (venueCountryId != null) {
			setVenueCountryId(venueCountryId);
		}

		String venueCountryName = (String)attributes.get("venueCountryName");

		if (venueCountryName != null) {
			setVenueCountryName(venueCountryName);
		}

		String venueMetroArea = (String)attributes.get("venueMetroArea");

		if (venueMetroArea != null) {
			setVenueMetroArea(venueMetroArea);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		Integer venueDetailsDistRange = (Integer)attributes.get(
				"venueDetailsDistRange");

		if (venueDetailsDistRange != null) {
			setVenueDetailsDistRange(venueDetailsDistRange);
		}
	}

	/**
	* Returns the primary key of this venue.
	*
	* @return the primary key of this venue
	*/
	@Override
	public long getPrimaryKey() {
		return _venue.getPrimaryKey();
	}

	/**
	* Sets the primary key of this venue.
	*
	* @param primaryKey the primary key of this venue
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_venue.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the venue ID of this venue.
	*
	* @return the venue ID of this venue
	*/
	@Override
	public long getVenueId() {
		return _venue.getVenueId();
	}

	/**
	* Sets the venue ID of this venue.
	*
	* @param venueId the venue ID of this venue
	*/
	@Override
	public void setVenueId(long venueId) {
		_venue.setVenueId(venueId);
	}

	/**
	* Returns the company ID of this venue.
	*
	* @return the company ID of this venue
	*/
	@Override
	public long getCompanyId() {
		return _venue.getCompanyId();
	}

	/**
	* Sets the company ID of this venue.
	*
	* @param companyId the company ID of this venue
	*/
	@Override
	public void setCompanyId(long companyId) {
		_venue.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this venue.
	*
	* @return the user ID of this venue
	*/
	@Override
	public long getUserId() {
		return _venue.getUserId();
	}

	/**
	* Sets the user ID of this venue.
	*
	* @param userId the user ID of this venue
	*/
	@Override
	public void setUserId(long userId) {
		_venue.setUserId(userId);
	}

	/**
	* Returns the user uuid of this venue.
	*
	* @return the user uuid of this venue
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venue.getUserUuid();
	}

	/**
	* Sets the user uuid of this venue.
	*
	* @param userUuid the user uuid of this venue
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_venue.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this venue.
	*
	* @return the created date of this venue
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _venue.getCreatedDate();
	}

	/**
	* Sets the created date of this venue.
	*
	* @param createdDate the created date of this venue
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_venue.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this venue.
	*
	* @return the modified date of this venue
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _venue.getModifiedDate();
	}

	/**
	* Sets the modified date of this venue.
	*
	* @param modifiedDate the modified date of this venue
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_venue.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the venue name of this venue.
	*
	* @return the venue name of this venue
	*/
	@Override
	public java.lang.String getVenueName() {
		return _venue.getVenueName();
	}

	/**
	* Sets the venue name of this venue.
	*
	* @param venueName the venue name of this venue
	*/
	@Override
	public void setVenueName(java.lang.String venueName) {
		_venue.setVenueName(venueName);
	}

	/**
	* Returns the venue description of this venue.
	*
	* @return the venue description of this venue
	*/
	@Override
	public java.lang.String getVenueDescription() {
		return _venue.getVenueDescription();
	}

	/**
	* Sets the venue description of this venue.
	*
	* @param venueDescription the venue description of this venue
	*/
	@Override
	public void setVenueDescription(java.lang.String venueDescription) {
		_venue.setVenueDescription(venueDescription);
	}

	/**
	* Returns the venue zip code of this venue.
	*
	* @return the venue zip code of this venue
	*/
	@Override
	public java.lang.String getVenueZipCode() {
		return _venue.getVenueZipCode();
	}

	/**
	* Sets the venue zip code of this venue.
	*
	* @param venueZipCode the venue zip code of this venue
	*/
	@Override
	public void setVenueZipCode(java.lang.String venueZipCode) {
		_venue.setVenueZipCode(venueZipCode);
	}

	/**
	* Returns the addr line1 of this venue.
	*
	* @return the addr line1 of this venue
	*/
	@Override
	public java.lang.String getAddrLine1() {
		return _venue.getAddrLine1();
	}

	/**
	* Sets the addr line1 of this venue.
	*
	* @param addrLine1 the addr line1 of this venue
	*/
	@Override
	public void setAddrLine1(java.lang.String addrLine1) {
		_venue.setAddrLine1(addrLine1);
	}

	/**
	* Returns the addr line2 of this venue.
	*
	* @return the addr line2 of this venue
	*/
	@Override
	public java.lang.String getAddrLine2() {
		return _venue.getAddrLine2();
	}

	/**
	* Sets the addr line2 of this venue.
	*
	* @param addrLine2 the addr line2 of this venue
	*/
	@Override
	public void setAddrLine2(java.lang.String addrLine2) {
		_venue.setAddrLine2(addrLine2);
	}

	/**
	* Returns the venue city of this venue.
	*
	* @return the venue city of this venue
	*/
	@Override
	public java.lang.String getVenueCity() {
		return _venue.getVenueCity();
	}

	/**
	* Sets the venue city of this venue.
	*
	* @param venueCity the venue city of this venue
	*/
	@Override
	public void setVenueCity(java.lang.String venueCity) {
		_venue.setVenueCity(venueCity);
	}

	/**
	* Returns the venue state ID of this venue.
	*
	* @return the venue state ID of this venue
	*/
	@Override
	public long getVenueStateId() {
		return _venue.getVenueStateId();
	}

	/**
	* Sets the venue state ID of this venue.
	*
	* @param venueStateId the venue state ID of this venue
	*/
	@Override
	public void setVenueStateId(long venueStateId) {
		_venue.setVenueStateId(venueStateId);
	}

	/**
	* Returns the venue state name of this venue.
	*
	* @return the venue state name of this venue
	*/
	@Override
	public java.lang.String getVenueStateName() {
		return _venue.getVenueStateName();
	}

	/**
	* Sets the venue state name of this venue.
	*
	* @param venueStateName the venue state name of this venue
	*/
	@Override
	public void setVenueStateName(java.lang.String venueStateName) {
		_venue.setVenueStateName(venueStateName);
	}

	/**
	* Returns the venue country ID of this venue.
	*
	* @return the venue country ID of this venue
	*/
	@Override
	public long getVenueCountryId() {
		return _venue.getVenueCountryId();
	}

	/**
	* Sets the venue country ID of this venue.
	*
	* @param venueCountryId the venue country ID of this venue
	*/
	@Override
	public void setVenueCountryId(long venueCountryId) {
		_venue.setVenueCountryId(venueCountryId);
	}

	/**
	* Returns the venue country name of this venue.
	*
	* @return the venue country name of this venue
	*/
	@Override
	public java.lang.String getVenueCountryName() {
		return _venue.getVenueCountryName();
	}

	/**
	* Sets the venue country name of this venue.
	*
	* @param venueCountryName the venue country name of this venue
	*/
	@Override
	public void setVenueCountryName(java.lang.String venueCountryName) {
		_venue.setVenueCountryName(venueCountryName);
	}

	/**
	* Returns the venue metro area of this venue.
	*
	* @return the venue metro area of this venue
	*/
	@Override
	public java.lang.String getVenueMetroArea() {
		return _venue.getVenueMetroArea();
	}

	/**
	* Sets the venue metro area of this venue.
	*
	* @param venueMetroArea the venue metro area of this venue
	*/
	@Override
	public void setVenueMetroArea(java.lang.String venueMetroArea) {
		_venue.setVenueMetroArea(venueMetroArea);
	}

	/**
	* Returns the longitude of this venue.
	*
	* @return the longitude of this venue
	*/
	@Override
	public java.lang.String getLongitude() {
		return _venue.getLongitude();
	}

	/**
	* Sets the longitude of this venue.
	*
	* @param longitude the longitude of this venue
	*/
	@Override
	public void setLongitude(java.lang.String longitude) {
		_venue.setLongitude(longitude);
	}

	/**
	* Returns the latitude of this venue.
	*
	* @return the latitude of this venue
	*/
	@Override
	public java.lang.String getLatitude() {
		return _venue.getLatitude();
	}

	/**
	* Sets the latitude of this venue.
	*
	* @param latitude the latitude of this venue
	*/
	@Override
	public void setLatitude(java.lang.String latitude) {
		_venue.setLatitude(latitude);
	}

	/**
	* Returns the venue details dist range of this venue.
	*
	* @return the venue details dist range of this venue
	*/
	@Override
	public int getVenueDetailsDistRange() {
		return _venue.getVenueDetailsDistRange();
	}

	/**
	* Sets the venue details dist range of this venue.
	*
	* @param venueDetailsDistRange the venue details dist range of this venue
	*/
	@Override
	public void setVenueDetailsDistRange(int venueDetailsDistRange) {
		_venue.setVenueDetailsDistRange(venueDetailsDistRange);
	}

	@Override
	public boolean isNew() {
		return _venue.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_venue.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _venue.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_venue.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _venue.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _venue.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_venue.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _venue.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_venue.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_venue.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_venue.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VenueWrapper((Venue)_venue.clone());
	}

	@Override
	public int compareTo(com.rumbasolutions.flask.model.Venue venue) {
		return _venue.compareTo(venue);
	}

	@Override
	public int hashCode() {
		return _venue.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.Venue> toCacheModel() {
		return _venue.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.Venue toEscapedModel() {
		return new VenueWrapper(_venue.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.Venue toUnescapedModel() {
		return new VenueWrapper(_venue.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _venue.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _venue.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_venue.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VenueWrapper)) {
			return false;
		}

		VenueWrapper venueWrapper = (VenueWrapper)obj;

		if (Validator.equals(_venue, venueWrapper._venue)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Venue getWrappedVenue() {
		return _venue;
	}

	@Override
	public Venue getWrappedModel() {
		return _venue;
	}

	@Override
	public void resetOriginalValues() {
		_venue.resetOriginalValues();
	}

	private Venue _venue;
}