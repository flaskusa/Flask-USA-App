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

package com.rumbasolutions.flask.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.rumbasolutions.flask.model.FlaskAdmin;
import com.rumbasolutions.flask.model.FlaskAdminModel;
import com.rumbasolutions.flask.model.FlaskAdminSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the FlaskAdmin service. Represents a row in the &quot;flaskusers_FlaskAdmin&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rumbasolutions.flask.model.FlaskAdminModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FlaskAdminImpl}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see FlaskAdminImpl
 * @see com.rumbasolutions.flask.model.FlaskAdmin
 * @see com.rumbasolutions.flask.model.FlaskAdminModel
 * @generated
 */
@JSON(strict = true)
public class FlaskAdminModelImpl extends BaseModelImpl<FlaskAdmin>
	implements FlaskAdminModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a flask admin model instance should use the {@link com.rumbasolutions.flask.model.FlaskAdmin} interface instead.
	 */
	public static final String TABLE_NAME = "flaskusers_FlaskAdmin";
	public static final Object[][] TABLE_COLUMNS = {
			{ "userId", Types.BIGINT },
			{ "roleId", Types.BIGINT },
			{ "firstName", Types.VARCHAR },
			{ "middleName", Types.VARCHAR },
			{ "lastName", Types.VARCHAR },
			{ "screenName", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "DOB", Types.TIMESTAMP },
			{ "isMale", Types.BOOLEAN },
			{ "streetName", Types.VARCHAR },
			{ "aptNo", Types.VARCHAR },
			{ "areaCode", Types.VARCHAR },
			{ "city", Types.VARCHAR },
			{ "state_", Types.VARCHAR },
			{ "country", Types.VARCHAR },
			{ "mobileNumber", Types.VARCHAR },
			{ "portraitURL", Types.VARCHAR },
			{ "userInterests", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table flaskusers_FlaskAdmin (userId LONG not null primary key,roleId LONG,firstName VARCHAR(75) null,middleName VARCHAR(75) null,lastName VARCHAR(75) null,screenName VARCHAR(75) null,email VARCHAR(75) null,DOB DATE null,isMale BOOLEAN,streetName VARCHAR(75) null,aptNo VARCHAR(75) null,areaCode VARCHAR(75) null,city VARCHAR(75) null,state_ VARCHAR(75) null,country VARCHAR(75) null,mobileNumber VARCHAR(75) null,portraitURL VARCHAR(75) null,userInterests VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table flaskusers_FlaskAdmin";
	public static final String ORDER_BY_JPQL = " ORDER BY flaskAdmin.userId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY flaskusers_FlaskAdmin.userId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rumbasolutions.flask.model.FlaskAdmin"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rumbasolutions.flask.model.FlaskAdmin"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static FlaskAdmin toModel(FlaskAdminSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		FlaskAdmin model = new FlaskAdminImpl();

		model.setUserId(soapModel.getUserId());
		model.setRoleId(soapModel.getRoleId());
		model.setFirstName(soapModel.getFirstName());
		model.setMiddleName(soapModel.getMiddleName());
		model.setLastName(soapModel.getLastName());
		model.setScreenName(soapModel.getScreenName());
		model.setEmail(soapModel.getEmail());
		model.setDOB(soapModel.getDOB());
		model.setIsMale(soapModel.getIsMale());
		model.setStreetName(soapModel.getStreetName());
		model.setAptNo(soapModel.getAptNo());
		model.setAreaCode(soapModel.getAreaCode());
		model.setCity(soapModel.getCity());
		model.setState(soapModel.getState());
		model.setCountry(soapModel.getCountry());
		model.setMobileNumber(soapModel.getMobileNumber());
		model.setPortraitURL(soapModel.getPortraitURL());
		model.setUserInterests(soapModel.getUserInterests());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<FlaskAdmin> toModels(FlaskAdminSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<FlaskAdmin> models = new ArrayList<FlaskAdmin>(soapModels.length);

		for (FlaskAdminSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rumbasolutions.flask.model.FlaskAdmin"));

	public FlaskAdminModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _userId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskAdmin.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskAdmin.class.getName();
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

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public long getRoleId() {
		return _roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	@JSON
	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return StringPool.BLANK;
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@JSON
	@Override
	public String getMiddleName() {
		if (_middleName == null) {
			return StringPool.BLANK;
		}
		else {
			return _middleName;
		}
	}

	@Override
	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return StringPool.BLANK;
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@JSON
	@Override
	public String getScreenName() {
		if (_screenName == null) {
			return StringPool.BLANK;
		}
		else {
			return _screenName;
		}
	}

	@Override
	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@JSON
	@Override
	public Date getDOB() {
		return _DOB;
	}

	@Override
	public void setDOB(Date DOB) {
		_DOB = DOB;
	}

	@JSON
	@Override
	public Boolean getIsMale() {
		return _isMale;
	}

	@Override
	public void setIsMale(Boolean isMale) {
		_isMale = isMale;
	}

	@JSON
	@Override
	public String getStreetName() {
		if (_streetName == null) {
			return StringPool.BLANK;
		}
		else {
			return _streetName;
		}
	}

	@Override
	public void setStreetName(String streetName) {
		_streetName = streetName;
	}

	@JSON
	@Override
	public String getAptNo() {
		if (_aptNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _aptNo;
		}
	}

	@Override
	public void setAptNo(String aptNo) {
		_aptNo = aptNo;
	}

	@JSON
	@Override
	public String getAreaCode() {
		if (_areaCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _areaCode;
		}
	}

	@Override
	public void setAreaCode(String areaCode) {
		_areaCode = areaCode;
	}

	@JSON
	@Override
	public String getCity() {
		if (_city == null) {
			return StringPool.BLANK;
		}
		else {
			return _city;
		}
	}

	@Override
	public void setCity(String city) {
		_city = city;
	}

	@JSON
	@Override
	public String getState() {
		if (_state == null) {
			return StringPool.BLANK;
		}
		else {
			return _state;
		}
	}

	@Override
	public void setState(String state) {
		_state = state;
	}

	@JSON
	@Override
	public String getCountry() {
		if (_country == null) {
			return StringPool.BLANK;
		}
		else {
			return _country;
		}
	}

	@Override
	public void setCountry(String country) {
		_country = country;
	}

	@JSON
	@Override
	public String getMobileNumber() {
		if (_mobileNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _mobileNumber;
		}
	}

	@Override
	public void setMobileNumber(String mobileNumber) {
		_mobileNumber = mobileNumber;
	}

	@JSON
	@Override
	public String getPortraitURL() {
		if (_portraitURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _portraitURL;
		}
	}

	@Override
	public void setPortraitURL(String portraitURL) {
		_portraitURL = portraitURL;
	}

	@JSON
	@Override
	public String getUserInterests() {
		if (_userInterests == null) {
			return StringPool.BLANK;
		}
		else {
			return _userInterests;
		}
	}

	@Override
	public void setUserInterests(String userInterests) {
		_userInterests = userInterests;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			FlaskAdmin.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FlaskAdmin toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FlaskAdmin)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FlaskAdminImpl flaskAdminImpl = new FlaskAdminImpl();

		flaskAdminImpl.setUserId(getUserId());
		flaskAdminImpl.setRoleId(getRoleId());
		flaskAdminImpl.setFirstName(getFirstName());
		flaskAdminImpl.setMiddleName(getMiddleName());
		flaskAdminImpl.setLastName(getLastName());
		flaskAdminImpl.setScreenName(getScreenName());
		flaskAdminImpl.setEmail(getEmail());
		flaskAdminImpl.setDOB(getDOB());
		flaskAdminImpl.setIsMale(getIsMale());
		flaskAdminImpl.setStreetName(getStreetName());
		flaskAdminImpl.setAptNo(getAptNo());
		flaskAdminImpl.setAreaCode(getAreaCode());
		flaskAdminImpl.setCity(getCity());
		flaskAdminImpl.setState(getState());
		flaskAdminImpl.setCountry(getCountry());
		flaskAdminImpl.setMobileNumber(getMobileNumber());
		flaskAdminImpl.setPortraitURL(getPortraitURL());
		flaskAdminImpl.setUserInterests(getUserInterests());

		flaskAdminImpl.resetOriginalValues();

		return flaskAdminImpl;
	}

	@Override
	public int compareTo(FlaskAdmin flaskAdmin) {
		long primaryKey = flaskAdmin.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlaskAdmin)) {
			return false;
		}

		FlaskAdmin flaskAdmin = (FlaskAdmin)obj;

		long primaryKey = flaskAdmin.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<FlaskAdmin> toCacheModel() {
		FlaskAdminCacheModel flaskAdminCacheModel = new FlaskAdminCacheModel();

		flaskAdminCacheModel.userId = getUserId();

		flaskAdminCacheModel.roleId = getRoleId();

		flaskAdminCacheModel.firstName = getFirstName();

		String firstName = flaskAdminCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			flaskAdminCacheModel.firstName = null;
		}

		flaskAdminCacheModel.middleName = getMiddleName();

		String middleName = flaskAdminCacheModel.middleName;

		if ((middleName != null) && (middleName.length() == 0)) {
			flaskAdminCacheModel.middleName = null;
		}

		flaskAdminCacheModel.lastName = getLastName();

		String lastName = flaskAdminCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			flaskAdminCacheModel.lastName = null;
		}

		flaskAdminCacheModel.screenName = getScreenName();

		String screenName = flaskAdminCacheModel.screenName;

		if ((screenName != null) && (screenName.length() == 0)) {
			flaskAdminCacheModel.screenName = null;
		}

		flaskAdminCacheModel.email = getEmail();

		String email = flaskAdminCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			flaskAdminCacheModel.email = null;
		}

		Date DOB = getDOB();

		if (DOB != null) {
			flaskAdminCacheModel.DOB = DOB.getTime();
		}
		else {
			flaskAdminCacheModel.DOB = Long.MIN_VALUE;
		}

		flaskAdminCacheModel.isMale = getIsMale();

		flaskAdminCacheModel.streetName = getStreetName();

		String streetName = flaskAdminCacheModel.streetName;

		if ((streetName != null) && (streetName.length() == 0)) {
			flaskAdminCacheModel.streetName = null;
		}

		flaskAdminCacheModel.aptNo = getAptNo();

		String aptNo = flaskAdminCacheModel.aptNo;

		if ((aptNo != null) && (aptNo.length() == 0)) {
			flaskAdminCacheModel.aptNo = null;
		}

		flaskAdminCacheModel.areaCode = getAreaCode();

		String areaCode = flaskAdminCacheModel.areaCode;

		if ((areaCode != null) && (areaCode.length() == 0)) {
			flaskAdminCacheModel.areaCode = null;
		}

		flaskAdminCacheModel.city = getCity();

		String city = flaskAdminCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			flaskAdminCacheModel.city = null;
		}

		flaskAdminCacheModel.state = getState();

		String state = flaskAdminCacheModel.state;

		if ((state != null) && (state.length() == 0)) {
			flaskAdminCacheModel.state = null;
		}

		flaskAdminCacheModel.country = getCountry();

		String country = flaskAdminCacheModel.country;

		if ((country != null) && (country.length() == 0)) {
			flaskAdminCacheModel.country = null;
		}

		flaskAdminCacheModel.mobileNumber = getMobileNumber();

		String mobileNumber = flaskAdminCacheModel.mobileNumber;

		if ((mobileNumber != null) && (mobileNumber.length() == 0)) {
			flaskAdminCacheModel.mobileNumber = null;
		}

		flaskAdminCacheModel.portraitURL = getPortraitURL();

		String portraitURL = flaskAdminCacheModel.portraitURL;

		if ((portraitURL != null) && (portraitURL.length() == 0)) {
			flaskAdminCacheModel.portraitURL = null;
		}

		flaskAdminCacheModel.userInterests = getUserInterests();

		String userInterests = flaskAdminCacheModel.userInterests;

		if ((userInterests != null) && (userInterests.length() == 0)) {
			flaskAdminCacheModel.userInterests = null;
		}

		return flaskAdminCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", middleName=");
		sb.append(getMiddleName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", screenName=");
		sb.append(getScreenName());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", DOB=");
		sb.append(getDOB());
		sb.append(", isMale=");
		sb.append(getIsMale());
		sb.append(", streetName=");
		sb.append(getStreetName());
		sb.append(", aptNo=");
		sb.append(getAptNo());
		sb.append(", areaCode=");
		sb.append(getAreaCode());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", mobileNumber=");
		sb.append(getMobileNumber());
		sb.append(", portraitURL=");
		sb.append(getPortraitURL());
		sb.append(", userInterests=");
		sb.append(getUserInterests());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.FlaskAdmin");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>middleName</column-name><column-value><![CDATA[");
		sb.append(getMiddleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>screenName</column-name><column-value><![CDATA[");
		sb.append(getScreenName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>DOB</column-name><column-value><![CDATA[");
		sb.append(getDOB());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isMale</column-name><column-value><![CDATA[");
		sb.append(getIsMale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>streetName</column-name><column-value><![CDATA[");
		sb.append(getStreetName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aptNo</column-name><column-value><![CDATA[");
		sb.append(getAptNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>areaCode</column-name><column-value><![CDATA[");
		sb.append(getAreaCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobileNumber</column-name><column-value><![CDATA[");
		sb.append(getMobileNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portraitURL</column-name><column-value><![CDATA[");
		sb.append(getPortraitURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userInterests</column-name><column-value><![CDATA[");
		sb.append(getUserInterests());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = FlaskAdmin.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			FlaskAdmin.class
		};
	private long _userId;
	private String _userUuid;
	private long _roleId;
	private String _firstName;
	private String _middleName;
	private String _lastName;
	private String _screenName;
	private String _email;
	private Date _DOB;
	private Boolean _isMale;
	private String _streetName;
	private String _aptNo;
	private String _areaCode;
	private String _city;
	private String _state;
	private String _country;
	private String _mobileNumber;
	private String _portraitURL;
	private String _userInterests;
	private FlaskAdmin _escapedModel;
}