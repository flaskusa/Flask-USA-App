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
 * This class is a wrapper for {@link FlaskUser}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see FlaskUser
 * @generated
 */
public class FlaskUserWrapper implements FlaskUser, ModelWrapper<FlaskUser> {
	public FlaskUserWrapper(FlaskUser flaskUser) {
		_flaskUser = flaskUser;
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskUser.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("roleId", getRoleId());
		attributes.put("firstName", getFirstName());
		attributes.put("middleName", getMiddleName());
		attributes.put("lastName", getLastName());
		attributes.put("screenName", getScreenName());
		attributes.put("email", getEmail());
		attributes.put("DOB", getDOB());
		attributes.put("isMale", getIsMale());
		attributes.put("streetName", getStreetName());
		attributes.put("aptNo", getAptNo());
		attributes.put("areaCode", getAreaCode());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("country", getCountry());
		attributes.put("mobileNumber", getMobileNumber());
		attributes.put("portraitURL", getPortraitURL());
		attributes.put("userInterests", getUserInterests());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String screenName = (String)attributes.get("screenName");

		if (screenName != null) {
			setScreenName(screenName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date DOB = (Date)attributes.get("DOB");

		if (DOB != null) {
			setDOB(DOB);
		}

		Boolean isMale = (Boolean)attributes.get("isMale");

		if (isMale != null) {
			setIsMale(isMale);
		}

		String streetName = (String)attributes.get("streetName");

		if (streetName != null) {
			setStreetName(streetName);
		}

		String aptNo = (String)attributes.get("aptNo");

		if (aptNo != null) {
			setAptNo(aptNo);
		}

		String areaCode = (String)attributes.get("areaCode");

		if (areaCode != null) {
			setAreaCode(areaCode);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String mobileNumber = (String)attributes.get("mobileNumber");

		if (mobileNumber != null) {
			setMobileNumber(mobileNumber);
		}

		String portraitURL = (String)attributes.get("portraitURL");

		if (portraitURL != null) {
			setPortraitURL(portraitURL);
		}

		String userInterests = (String)attributes.get("userInterests");

		if (userInterests != null) {
			setUserInterests(userInterests);
		}
	}

	/**
	* Returns the primary key of this flask user.
	*
	* @return the primary key of this flask user
	*/
	@Override
	public long getPrimaryKey() {
		return _flaskUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this flask user.
	*
	* @param primaryKey the primary key of this flask user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_flaskUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this flask user.
	*
	* @return the user ID of this flask user
	*/
	@Override
	public long getUserId() {
		return _flaskUser.getUserId();
	}

	/**
	* Sets the user ID of this flask user.
	*
	* @param userId the user ID of this flask user
	*/
	@Override
	public void setUserId(long userId) {
		_flaskUser.setUserId(userId);
	}

	/**
	* Returns the user uuid of this flask user.
	*
	* @return the user uuid of this flask user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskUser.getUserUuid();
	}

	/**
	* Sets the user uuid of this flask user.
	*
	* @param userUuid the user uuid of this flask user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_flaskUser.setUserUuid(userUuid);
	}

	/**
	* Returns the role ID of this flask user.
	*
	* @return the role ID of this flask user
	*/
	@Override
	public long getRoleId() {
		return _flaskUser.getRoleId();
	}

	/**
	* Sets the role ID of this flask user.
	*
	* @param roleId the role ID of this flask user
	*/
	@Override
	public void setRoleId(long roleId) {
		_flaskUser.setRoleId(roleId);
	}

	/**
	* Returns the first name of this flask user.
	*
	* @return the first name of this flask user
	*/
	@Override
	public java.lang.String getFirstName() {
		return _flaskUser.getFirstName();
	}

	/**
	* Sets the first name of this flask user.
	*
	* @param firstName the first name of this flask user
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_flaskUser.setFirstName(firstName);
	}

	/**
	* Returns the middle name of this flask user.
	*
	* @return the middle name of this flask user
	*/
	@Override
	public java.lang.String getMiddleName() {
		return _flaskUser.getMiddleName();
	}

	/**
	* Sets the middle name of this flask user.
	*
	* @param middleName the middle name of this flask user
	*/
	@Override
	public void setMiddleName(java.lang.String middleName) {
		_flaskUser.setMiddleName(middleName);
	}

	/**
	* Returns the last name of this flask user.
	*
	* @return the last name of this flask user
	*/
	@Override
	public java.lang.String getLastName() {
		return _flaskUser.getLastName();
	}

	/**
	* Sets the last name of this flask user.
	*
	* @param lastName the last name of this flask user
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_flaskUser.setLastName(lastName);
	}

	/**
	* Returns the screen name of this flask user.
	*
	* @return the screen name of this flask user
	*/
	@Override
	public java.lang.String getScreenName() {
		return _flaskUser.getScreenName();
	}

	/**
	* Sets the screen name of this flask user.
	*
	* @param screenName the screen name of this flask user
	*/
	@Override
	public void setScreenName(java.lang.String screenName) {
		_flaskUser.setScreenName(screenName);
	}

	/**
	* Returns the email of this flask user.
	*
	* @return the email of this flask user
	*/
	@Override
	public java.lang.String getEmail() {
		return _flaskUser.getEmail();
	}

	/**
	* Sets the email of this flask user.
	*
	* @param email the email of this flask user
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_flaskUser.setEmail(email);
	}

	/**
	* Returns the d o b of this flask user.
	*
	* @return the d o b of this flask user
	*/
	@Override
	public java.util.Date getDOB() {
		return _flaskUser.getDOB();
	}

	/**
	* Sets the d o b of this flask user.
	*
	* @param DOB the d o b of this flask user
	*/
	@Override
	public void setDOB(java.util.Date DOB) {
		_flaskUser.setDOB(DOB);
	}

	/**
	* Returns the is male of this flask user.
	*
	* @return the is male of this flask user
	*/
	@Override
	public java.lang.Boolean getIsMale() {
		return _flaskUser.getIsMale();
	}

	/**
	* Sets the is male of this flask user.
	*
	* @param isMale the is male of this flask user
	*/
	@Override
	public void setIsMale(java.lang.Boolean isMale) {
		_flaskUser.setIsMale(isMale);
	}

	/**
	* Returns the street name of this flask user.
	*
	* @return the street name of this flask user
	*/
	@Override
	public java.lang.String getStreetName() {
		return _flaskUser.getStreetName();
	}

	/**
	* Sets the street name of this flask user.
	*
	* @param streetName the street name of this flask user
	*/
	@Override
	public void setStreetName(java.lang.String streetName) {
		_flaskUser.setStreetName(streetName);
	}

	/**
	* Returns the apt no of this flask user.
	*
	* @return the apt no of this flask user
	*/
	@Override
	public java.lang.String getAptNo() {
		return _flaskUser.getAptNo();
	}

	/**
	* Sets the apt no of this flask user.
	*
	* @param aptNo the apt no of this flask user
	*/
	@Override
	public void setAptNo(java.lang.String aptNo) {
		_flaskUser.setAptNo(aptNo);
	}

	/**
	* Returns the area code of this flask user.
	*
	* @return the area code of this flask user
	*/
	@Override
	public java.lang.String getAreaCode() {
		return _flaskUser.getAreaCode();
	}

	/**
	* Sets the area code of this flask user.
	*
	* @param areaCode the area code of this flask user
	*/
	@Override
	public void setAreaCode(java.lang.String areaCode) {
		_flaskUser.setAreaCode(areaCode);
	}

	/**
	* Returns the city of this flask user.
	*
	* @return the city of this flask user
	*/
	@Override
	public java.lang.String getCity() {
		return _flaskUser.getCity();
	}

	/**
	* Sets the city of this flask user.
	*
	* @param city the city of this flask user
	*/
	@Override
	public void setCity(java.lang.String city) {
		_flaskUser.setCity(city);
	}

	/**
	* Returns the state of this flask user.
	*
	* @return the state of this flask user
	*/
	@Override
	public java.lang.String getState() {
		return _flaskUser.getState();
	}

	/**
	* Sets the state of this flask user.
	*
	* @param state the state of this flask user
	*/
	@Override
	public void setState(java.lang.String state) {
		_flaskUser.setState(state);
	}

	/**
	* Returns the country of this flask user.
	*
	* @return the country of this flask user
	*/
	@Override
	public java.lang.String getCountry() {
		return _flaskUser.getCountry();
	}

	/**
	* Sets the country of this flask user.
	*
	* @param country the country of this flask user
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_flaskUser.setCountry(country);
	}

	/**
	* Returns the mobile number of this flask user.
	*
	* @return the mobile number of this flask user
	*/
	@Override
	public java.lang.String getMobileNumber() {
		return _flaskUser.getMobileNumber();
	}

	/**
	* Sets the mobile number of this flask user.
	*
	* @param mobileNumber the mobile number of this flask user
	*/
	@Override
	public void setMobileNumber(java.lang.String mobileNumber) {
		_flaskUser.setMobileNumber(mobileNumber);
	}

	/**
	* Returns the portrait u r l of this flask user.
	*
	* @return the portrait u r l of this flask user
	*/
	@Override
	public java.lang.String getPortraitURL() {
		return _flaskUser.getPortraitURL();
	}

	/**
	* Sets the portrait u r l of this flask user.
	*
	* @param portraitURL the portrait u r l of this flask user
	*/
	@Override
	public void setPortraitURL(java.lang.String portraitURL) {
		_flaskUser.setPortraitURL(portraitURL);
	}

	/**
	* Returns the user interests of this flask user.
	*
	* @return the user interests of this flask user
	*/
	@Override
	public java.lang.String getUserInterests() {
		return _flaskUser.getUserInterests();
	}

	/**
	* Sets the user interests of this flask user.
	*
	* @param userInterests the user interests of this flask user
	*/
	@Override
	public void setUserInterests(java.lang.String userInterests) {
		_flaskUser.setUserInterests(userInterests);
	}

	@Override
	public boolean isNew() {
		return _flaskUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_flaskUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _flaskUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_flaskUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _flaskUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _flaskUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_flaskUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _flaskUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_flaskUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_flaskUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flaskUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FlaskUserWrapper((FlaskUser)_flaskUser.clone());
	}

	@Override
	public int compareTo(com.rumbasolutions.flask.model.FlaskUser flaskUser) {
		return _flaskUser.compareTo(flaskUser);
	}

	@Override
	public int hashCode() {
		return _flaskUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.FlaskUser> toCacheModel() {
		return _flaskUser.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskUser toEscapedModel() {
		return new FlaskUserWrapper(_flaskUser.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskUser toUnescapedModel() {
		return new FlaskUserWrapper(_flaskUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _flaskUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _flaskUser.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlaskUserWrapper)) {
			return false;
		}

		FlaskUserWrapper flaskUserWrapper = (FlaskUserWrapper)obj;

		if (Validator.equals(_flaskUser, flaskUserWrapper._flaskUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FlaskUser getWrappedFlaskUser() {
		return _flaskUser;
	}

	@Override
	public FlaskUser getWrappedModel() {
		return _flaskUser;
	}

	@Override
	public void resetOriginalValues() {
		_flaskUser.resetOriginalValues();
	}

	private FlaskUser _flaskUser;
}