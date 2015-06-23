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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rumbasolutions.flask.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashutosh Rai
 */
public class FlaskAdminClp extends BaseModelImpl<FlaskAdmin>
	implements FlaskAdmin {
	public FlaskAdminClp() {
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
		attributes.put("stateId", getStateId());
		attributes.put("stateName", getStateName());
		attributes.put("countryId", getCountryId());
		attributes.put("countryName", getCountryName());
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

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		String stateName = (String)attributes.get("stateName");

		if (stateName != null) {
			setStateName(stateName);
		}

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		String countryName = (String)attributes.get("countryName");

		if (countryName != null) {
			setCountryName(countryName);
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

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_flaskAdminRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getRoleId() {
		return _roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		_roleId = roleId;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setRoleId", long.class);

				method.invoke(_flaskAdminRemoteModel, roleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_flaskAdminRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMiddleName() {
		return _middleName;
	}

	@Override
	public void setMiddleName(String middleName) {
		_middleName = middleName;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setMiddleName", String.class);

				method.invoke(_flaskAdminRemoteModel, middleName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_flaskAdminRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getScreenName() {
		return _screenName;
	}

	@Override
	public void setScreenName(String screenName) {
		_screenName = screenName;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setScreenName", String.class);

				method.invoke(_flaskAdminRemoteModel, screenName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_flaskAdminRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDOB() {
		return _DOB;
	}

	@Override
	public void setDOB(Date DOB) {
		_DOB = DOB;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setDOB", Date.class);

				method.invoke(_flaskAdminRemoteModel, DOB);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Boolean getIsMale() {
		return _isMale;
	}

	@Override
	public void setIsMale(Boolean isMale) {
		_isMale = isMale;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setIsMale", Boolean.class);

				method.invoke(_flaskAdminRemoteModel, isMale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStreetName() {
		return _streetName;
	}

	@Override
	public void setStreetName(String streetName) {
		_streetName = streetName;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setStreetName", String.class);

				method.invoke(_flaskAdminRemoteModel, streetName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAptNo() {
		return _aptNo;
	}

	@Override
	public void setAptNo(String aptNo) {
		_aptNo = aptNo;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setAptNo", String.class);

				method.invoke(_flaskAdminRemoteModel, aptNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAreaCode() {
		return _areaCode;
	}

	@Override
	public void setAreaCode(String areaCode) {
		_areaCode = areaCode;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setAreaCode", String.class);

				method.invoke(_flaskAdminRemoteModel, areaCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCity() {
		return _city;
	}

	@Override
	public void setCity(String city) {
		_city = city;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_flaskAdminRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStateId() {
		return _stateId;
	}

	@Override
	public void setStateId(long stateId) {
		_stateId = stateId;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setStateId", long.class);

				method.invoke(_flaskAdminRemoteModel, stateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStateName() {
		return _stateName;
	}

	@Override
	public void setStateName(String stateName) {
		_stateName = stateName;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setStateName", String.class);

				method.invoke(_flaskAdminRemoteModel, stateName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCountryId() {
		return _countryId;
	}

	@Override
	public void setCountryId(long countryId) {
		_countryId = countryId;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryId", long.class);

				method.invoke(_flaskAdminRemoteModel, countryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryName() {
		return _countryName;
	}

	@Override
	public void setCountryName(String countryName) {
		_countryName = countryName;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryName", String.class);

				method.invoke(_flaskAdminRemoteModel, countryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMobileNumber() {
		return _mobileNumber;
	}

	@Override
	public void setMobileNumber(String mobileNumber) {
		_mobileNumber = mobileNumber;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setMobileNumber", String.class);

				method.invoke(_flaskAdminRemoteModel, mobileNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPortraitURL() {
		return _portraitURL;
	}

	@Override
	public void setPortraitURL(String portraitURL) {
		_portraitURL = portraitURL;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setPortraitURL", String.class);

				method.invoke(_flaskAdminRemoteModel, portraitURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserInterests() {
		return _userInterests;
	}

	@Override
	public void setUserInterests(String userInterests) {
		_userInterests = userInterests;

		if (_flaskAdminRemoteModel != null) {
			try {
				Class<?> clazz = _flaskAdminRemoteModel.getClass();

				Method method = clazz.getMethod("setUserInterests", String.class);

				method.invoke(_flaskAdminRemoteModel, userInterests);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFlaskAdminRemoteModel() {
		return _flaskAdminRemoteModel;
	}

	public void setFlaskAdminRemoteModel(BaseModel<?> flaskAdminRemoteModel) {
		_flaskAdminRemoteModel = flaskAdminRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _flaskAdminRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_flaskAdminRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public FlaskAdmin toEscapedModel() {
		return (FlaskAdmin)ProxyUtil.newProxyInstance(FlaskAdmin.class.getClassLoader(),
			new Class[] { FlaskAdmin.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FlaskAdminClp clone = new FlaskAdminClp();

		clone.setUserId(getUserId());
		clone.setRoleId(getRoleId());
		clone.setFirstName(getFirstName());
		clone.setMiddleName(getMiddleName());
		clone.setLastName(getLastName());
		clone.setScreenName(getScreenName());
		clone.setEmail(getEmail());
		clone.setDOB(getDOB());
		clone.setIsMale(getIsMale());
		clone.setStreetName(getStreetName());
		clone.setAptNo(getAptNo());
		clone.setAreaCode(getAreaCode());
		clone.setCity(getCity());
		clone.setStateId(getStateId());
		clone.setStateName(getStateName());
		clone.setCountryId(getCountryId());
		clone.setCountryName(getCountryName());
		clone.setMobileNumber(getMobileNumber());
		clone.setPortraitURL(getPortraitURL());
		clone.setUserInterests(getUserInterests());

		return clone;
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

		if (!(obj instanceof FlaskAdminClp)) {
			return false;
		}

		FlaskAdminClp flaskAdmin = (FlaskAdminClp)obj;

		long primaryKey = flaskAdmin.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

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
		sb.append(", stateId=");
		sb.append(getStateId());
		sb.append(", stateName=");
		sb.append(getStateName());
		sb.append(", countryId=");
		sb.append(getCountryId());
		sb.append(", countryName=");
		sb.append(getCountryName());
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
		StringBundler sb = new StringBundler(64);

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
			"<column><column-name>stateId</column-name><column-value><![CDATA[");
		sb.append(getStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stateName</column-name><column-value><![CDATA[");
		sb.append(getStateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryId</column-name><column-value><![CDATA[");
		sb.append(getCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryName</column-name><column-value><![CDATA[");
		sb.append(getCountryName());
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
	private long _stateId;
	private String _stateName;
	private long _countryId;
	private String _countryName;
	private String _mobileNumber;
	private String _portraitURL;
	private String _userInterests;
	private BaseModel<?> _flaskAdminRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}