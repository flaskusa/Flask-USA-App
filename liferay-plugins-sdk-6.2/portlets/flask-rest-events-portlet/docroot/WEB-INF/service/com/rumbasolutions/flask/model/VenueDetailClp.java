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
import com.rumbasolutions.flask.service.VenueDetailLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashutosh Rai
 */
public class VenueDetailClp extends BaseModelImpl<VenueDetail>
	implements VenueDetail {
	public VenueDetailClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VenueDetail.class;
	}

	@Override
	public String getModelClassName() {
		return VenueDetail.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _venueDetailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVenueDetailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _venueDetailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("venueDetailId", getVenueDetailId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("venueId", getVenueId());
		attributes.put("infoTypeId", getInfoTypeId());
		attributes.put("infoTypeName", getInfoTypeName());
		attributes.put("infoTypeCategoryId", getInfoTypeCategoryId());
		attributes.put("infoTypeCategoryName", getInfoTypeCategoryName());
		attributes.put("infoTitle", getInfoTitle());
		attributes.put("infoShortDesc", getInfoShortDesc());
		attributes.put("infoDesc", getInfoDesc());
		attributes.put("addrLine1", getAddrLine1());
		attributes.put("addrLine2", getAddrLine2());
		attributes.put("city", getCity());
		attributes.put("zipCode", getZipCode());
		attributes.put("stateId", getStateId());
		attributes.put("stateName", getStateName());
		attributes.put("countryId", getCountryId());
		attributes.put("countryName", getCountryName());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("phone", getPhone());
		attributes.put("mobileAppName", getMobileAppName());
		attributes.put("website", getWebsite());
		attributes.put("cost", getCost());
		attributes.put("hoursOfOperation", getHoursOfOperation());
		attributes.put("showDescription", getShowDescription());
		attributes.put("premiumDisplayEnabled", getPremiumDisplayEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long venueDetailId = (Long)attributes.get("venueDetailId");

		if (venueDetailId != null) {
			setVenueDetailId(venueDetailId);
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

		Long venueId = (Long)attributes.get("venueId");

		if (venueId != null) {
			setVenueId(venueId);
		}

		Long infoTypeId = (Long)attributes.get("infoTypeId");

		if (infoTypeId != null) {
			setInfoTypeId(infoTypeId);
		}

		String infoTypeName = (String)attributes.get("infoTypeName");

		if (infoTypeName != null) {
			setInfoTypeName(infoTypeName);
		}

		Long infoTypeCategoryId = (Long)attributes.get("infoTypeCategoryId");

		if (infoTypeCategoryId != null) {
			setInfoTypeCategoryId(infoTypeCategoryId);
		}

		String infoTypeCategoryName = (String)attributes.get(
				"infoTypeCategoryName");

		if (infoTypeCategoryName != null) {
			setInfoTypeCategoryName(infoTypeCategoryName);
		}

		String infoTitle = (String)attributes.get("infoTitle");

		if (infoTitle != null) {
			setInfoTitle(infoTitle);
		}

		String infoShortDesc = (String)attributes.get("infoShortDesc");

		if (infoShortDesc != null) {
			setInfoShortDesc(infoShortDesc);
		}

		String infoDesc = (String)attributes.get("infoDesc");

		if (infoDesc != null) {
			setInfoDesc(infoDesc);
		}

		String addrLine1 = (String)attributes.get("addrLine1");

		if (addrLine1 != null) {
			setAddrLine1(addrLine1);
		}

		String addrLine2 = (String)attributes.get("addrLine2");

		if (addrLine2 != null) {
			setAddrLine2(addrLine2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
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

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String mobileAppName = (String)attributes.get("mobileAppName");

		if (mobileAppName != null) {
			setMobileAppName(mobileAppName);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}

		Double cost = (Double)attributes.get("cost");

		if (cost != null) {
			setCost(cost);
		}

		String hoursOfOperation = (String)attributes.get("hoursOfOperation");

		if (hoursOfOperation != null) {
			setHoursOfOperation(hoursOfOperation);
		}

		Boolean showDescription = (Boolean)attributes.get("showDescription");

		if (showDescription != null) {
			setShowDescription(showDescription);
		}

		Boolean premiumDisplayEnabled = (Boolean)attributes.get(
				"premiumDisplayEnabled");

		if (premiumDisplayEnabled != null) {
			setPremiumDisplayEnabled(premiumDisplayEnabled);
		}
	}

	@Override
	public long getVenueDetailId() {
		return _venueDetailId;
	}

	@Override
	public void setVenueDetailId(long venueDetailId) {
		_venueDetailId = venueDetailId;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailId", long.class);

				method.invoke(_venueDetailRemoteModel, venueDetailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_venueDetailRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_venueDetailRemoteModel, userId);
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
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_venueDetailRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_venueDetailRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVenueId() {
		return _venueId;
	}

	@Override
	public void setVenueId(long venueId) {
		_venueId = venueId;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueId", long.class);

				method.invoke(_venueDetailRemoteModel, venueId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInfoTypeId() {
		return _infoTypeId;
	}

	@Override
	public void setInfoTypeId(long infoTypeId) {
		_infoTypeId = infoTypeId;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setInfoTypeId", long.class);

				method.invoke(_venueDetailRemoteModel, infoTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInfoTypeName() {
		return _infoTypeName;
	}

	@Override
	public void setInfoTypeName(String infoTypeName) {
		_infoTypeName = infoTypeName;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setInfoTypeName", String.class);

				method.invoke(_venueDetailRemoteModel, infoTypeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInfoTypeCategoryId() {
		return _infoTypeCategoryId;
	}

	@Override
	public void setInfoTypeCategoryId(long infoTypeCategoryId) {
		_infoTypeCategoryId = infoTypeCategoryId;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setInfoTypeCategoryId",
						long.class);

				method.invoke(_venueDetailRemoteModel, infoTypeCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInfoTypeCategoryName() {
		return _infoTypeCategoryName;
	}

	@Override
	public void setInfoTypeCategoryName(String infoTypeCategoryName) {
		_infoTypeCategoryName = infoTypeCategoryName;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setInfoTypeCategoryName",
						String.class);

				method.invoke(_venueDetailRemoteModel, infoTypeCategoryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInfoTitle() {
		return _infoTitle;
	}

	@Override
	public void setInfoTitle(String infoTitle) {
		_infoTitle = infoTitle;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setInfoTitle", String.class);

				method.invoke(_venueDetailRemoteModel, infoTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInfoShortDesc() {
		return _infoShortDesc;
	}

	@Override
	public void setInfoShortDesc(String infoShortDesc) {
		_infoShortDesc = infoShortDesc;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setInfoShortDesc", String.class);

				method.invoke(_venueDetailRemoteModel, infoShortDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInfoDesc() {
		return _infoDesc;
	}

	@Override
	public void setInfoDesc(String infoDesc) {
		_infoDesc = infoDesc;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setInfoDesc", String.class);

				method.invoke(_venueDetailRemoteModel, infoDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddrLine1() {
		return _addrLine1;
	}

	@Override
	public void setAddrLine1(String addrLine1) {
		_addrLine1 = addrLine1;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setAddrLine1", String.class);

				method.invoke(_venueDetailRemoteModel, addrLine1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddrLine2() {
		return _addrLine2;
	}

	@Override
	public void setAddrLine2(String addrLine2) {
		_addrLine2 = addrLine2;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setAddrLine2", String.class);

				method.invoke(_venueDetailRemoteModel, addrLine2);
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

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_venueDetailRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getZipCode() {
		return _zipCode;
	}

	@Override
	public void setZipCode(String zipCode) {
		_zipCode = zipCode;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setZipCode", String.class);

				method.invoke(_venueDetailRemoteModel, zipCode);
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

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setStateId", long.class);

				method.invoke(_venueDetailRemoteModel, stateId);
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

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setStateName", String.class);

				method.invoke(_venueDetailRemoteModel, stateName);
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

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryId", long.class);

				method.invoke(_venueDetailRemoteModel, countryId);
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

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryName", String.class);

				method.invoke(_venueDetailRemoteModel, countryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLatitude() {
		return _latitude;
	}

	@Override
	public void setLatitude(String latitude) {
		_latitude = latitude;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setLatitude", String.class);

				method.invoke(_venueDetailRemoteModel, latitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLongitude() {
		return _longitude;
	}

	@Override
	public void setLongitude(String longitude) {
		_longitude = longitude;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setLongitude", String.class);

				method.invoke(_venueDetailRemoteModel, longitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhone() {
		return _phone;
	}

	@Override
	public void setPhone(String phone) {
		_phone = phone;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setPhone", String.class);

				method.invoke(_venueDetailRemoteModel, phone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMobileAppName() {
		return _mobileAppName;
	}

	@Override
	public void setMobileAppName(String mobileAppName) {
		_mobileAppName = mobileAppName;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setMobileAppName", String.class);

				method.invoke(_venueDetailRemoteModel, mobileAppName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWebsite() {
		return _website;
	}

	@Override
	public void setWebsite(String website) {
		_website = website;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setWebsite", String.class);

				method.invoke(_venueDetailRemoteModel, website);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCost() {
		return _cost;
	}

	@Override
	public void setCost(double cost) {
		_cost = cost;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCost", double.class);

				method.invoke(_venueDetailRemoteModel, cost);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHoursOfOperation() {
		return _hoursOfOperation;
	}

	@Override
	public void setHoursOfOperation(String hoursOfOperation) {
		_hoursOfOperation = hoursOfOperation;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setHoursOfOperation",
						String.class);

				method.invoke(_venueDetailRemoteModel, hoursOfOperation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getShowDescription() {
		return _showDescription;
	}

	@Override
	public boolean isShowDescription() {
		return _showDescription;
	}

	@Override
	public void setShowDescription(boolean showDescription) {
		_showDescription = showDescription;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setShowDescription",
						boolean.class);

				method.invoke(_venueDetailRemoteModel, showDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPremiumDisplayEnabled() {
		return _premiumDisplayEnabled;
	}

	@Override
	public boolean isPremiumDisplayEnabled() {
		return _premiumDisplayEnabled;
	}

	@Override
	public void setPremiumDisplayEnabled(boolean premiumDisplayEnabled) {
		_premiumDisplayEnabled = premiumDisplayEnabled;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setPremiumDisplayEnabled",
						boolean.class);

				method.invoke(_venueDetailRemoteModel, premiumDisplayEnabled);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVenueDetailRemoteModel() {
		return _venueDetailRemoteModel;
	}

	public void setVenueDetailRemoteModel(BaseModel<?> venueDetailRemoteModel) {
		_venueDetailRemoteModel = venueDetailRemoteModel;
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

		Class<?> remoteModelClass = _venueDetailRemoteModel.getClass();

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

		Object returnValue = method.invoke(_venueDetailRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VenueDetailLocalServiceUtil.addVenueDetail(this);
		}
		else {
			VenueDetailLocalServiceUtil.updateVenueDetail(this);
		}
	}

	@Override
	public VenueDetail toEscapedModel() {
		return (VenueDetail)ProxyUtil.newProxyInstance(VenueDetail.class.getClassLoader(),
			new Class[] { VenueDetail.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VenueDetailClp clone = new VenueDetailClp();

		clone.setVenueDetailId(getVenueDetailId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setVenueId(getVenueId());
		clone.setInfoTypeId(getInfoTypeId());
		clone.setInfoTypeName(getInfoTypeName());
		clone.setInfoTypeCategoryId(getInfoTypeCategoryId());
		clone.setInfoTypeCategoryName(getInfoTypeCategoryName());
		clone.setInfoTitle(getInfoTitle());
		clone.setInfoShortDesc(getInfoShortDesc());
		clone.setInfoDesc(getInfoDesc());
		clone.setAddrLine1(getAddrLine1());
		clone.setAddrLine2(getAddrLine2());
		clone.setCity(getCity());
		clone.setZipCode(getZipCode());
		clone.setStateId(getStateId());
		clone.setStateName(getStateName());
		clone.setCountryId(getCountryId());
		clone.setCountryName(getCountryName());
		clone.setLatitude(getLatitude());
		clone.setLongitude(getLongitude());
		clone.setPhone(getPhone());
		clone.setMobileAppName(getMobileAppName());
		clone.setWebsite(getWebsite());
		clone.setCost(getCost());
		clone.setHoursOfOperation(getHoursOfOperation());
		clone.setShowDescription(getShowDescription());
		clone.setPremiumDisplayEnabled(getPremiumDisplayEnabled());

		return clone;
	}

	@Override
	public int compareTo(VenueDetail venueDetail) {
		int value = 0;

		if (getInfoTypeId() < venueDetail.getInfoTypeId()) {
			value = -1;
		}
		else if (getInfoTypeId() > venueDetail.getInfoTypeId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getInfoTypeCategoryId() < venueDetail.getInfoTypeCategoryId()) {
			value = -1;
		}
		else if (getInfoTypeCategoryId() > venueDetail.getInfoTypeCategoryId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VenueDetailClp)) {
			return false;
		}

		VenueDetailClp venueDetail = (VenueDetailClp)obj;

		long primaryKey = venueDetail.getPrimaryKey();

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
		StringBundler sb = new StringBundler(61);

		sb.append("{venueDetailId=");
		sb.append(getVenueDetailId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", venueId=");
		sb.append(getVenueId());
		sb.append(", infoTypeId=");
		sb.append(getInfoTypeId());
		sb.append(", infoTypeName=");
		sb.append(getInfoTypeName());
		sb.append(", infoTypeCategoryId=");
		sb.append(getInfoTypeCategoryId());
		sb.append(", infoTypeCategoryName=");
		sb.append(getInfoTypeCategoryName());
		sb.append(", infoTitle=");
		sb.append(getInfoTitle());
		sb.append(", infoShortDesc=");
		sb.append(getInfoShortDesc());
		sb.append(", infoDesc=");
		sb.append(getInfoDesc());
		sb.append(", addrLine1=");
		sb.append(getAddrLine1());
		sb.append(", addrLine2=");
		sb.append(getAddrLine2());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", zipCode=");
		sb.append(getZipCode());
		sb.append(", stateId=");
		sb.append(getStateId());
		sb.append(", stateName=");
		sb.append(getStateName());
		sb.append(", countryId=");
		sb.append(getCountryId());
		sb.append(", countryName=");
		sb.append(getCountryName());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", mobileAppName=");
		sb.append(getMobileAppName());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", cost=");
		sb.append(getCost());
		sb.append(", hoursOfOperation=");
		sb.append(getHoursOfOperation());
		sb.append(", showDescription=");
		sb.append(getShowDescription());
		sb.append(", premiumDisplayEnabled=");
		sb.append(getPremiumDisplayEnabled());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(94);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.VenueDetail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>venueDetailId</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueId</column-name><column-value><![CDATA[");
		sb.append(getVenueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoTypeId</column-name><column-value><![CDATA[");
		sb.append(getInfoTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoTypeName</column-name><column-value><![CDATA[");
		sb.append(getInfoTypeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoTypeCategoryId</column-name><column-value><![CDATA[");
		sb.append(getInfoTypeCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoTypeCategoryName</column-name><column-value><![CDATA[");
		sb.append(getInfoTypeCategoryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoTitle</column-name><column-value><![CDATA[");
		sb.append(getInfoTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoShortDesc</column-name><column-value><![CDATA[");
		sb.append(getInfoShortDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoDesc</column-name><column-value><![CDATA[");
		sb.append(getInfoDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addrLine1</column-name><column-value><![CDATA[");
		sb.append(getAddrLine1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addrLine2</column-name><column-value><![CDATA[");
		sb.append(getAddrLine2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zipCode</column-name><column-value><![CDATA[");
		sb.append(getZipCode());
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
			"<column><column-name>latitude</column-name><column-value><![CDATA[");
		sb.append(getLatitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longitude</column-name><column-value><![CDATA[");
		sb.append(getLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobileAppName</column-name><column-value><![CDATA[");
		sb.append(getMobileAppName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cost</column-name><column-value><![CDATA[");
		sb.append(getCost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoursOfOperation</column-name><column-value><![CDATA[");
		sb.append(getHoursOfOperation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>showDescription</column-name><column-value><![CDATA[");
		sb.append(getShowDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>premiumDisplayEnabled</column-name><column-value><![CDATA[");
		sb.append(getPremiumDisplayEnabled());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _venueDetailId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _venueId;
	private long _infoTypeId;
	private String _infoTypeName;
	private long _infoTypeCategoryId;
	private String _infoTypeCategoryName;
	private String _infoTitle;
	private String _infoShortDesc;
	private String _infoDesc;
	private String _addrLine1;
	private String _addrLine2;
	private String _city;
	private String _zipCode;
	private long _stateId;
	private String _stateName;
	private long _countryId;
	private String _countryName;
	private String _latitude;
	private String _longitude;
	private String _phone;
	private String _mobileAppName;
	private String _website;
	private double _cost;
	private String _hoursOfOperation;
	private boolean _showDescription;
	private boolean _premiumDisplayEnabled;
	private BaseModel<?> _venueDetailRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}