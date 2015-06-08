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
		attributes.put("infoTypeCategoryId", getInfoTypeCategoryId());
		attributes.put("venueDetailInfoName", getVenueDetailInfoName());
		attributes.put("venueDetailInfoDesc", getVenueDetailInfoDesc());
		attributes.put("venueDetailInfoComment", getVenueDetailInfoComment());
		attributes.put("venueDetailAddressLine1", getVenueDetailAddressLine1());
		attributes.put("venueDetailAddressLine2", getVenueDetailAddressLine2());
		attributes.put("venueDetailCity", getVenueDetailCity());
		attributes.put("venueDetailState", getVenueDetailState());
		attributes.put("venueDetailCountry", getVenueDetailCountry());
		attributes.put("venueDetailLatitude", getVenueDetailLatitude());
		attributes.put("venueDetailLongitude", getVenueDetailLongitude());
		attributes.put("venueDetailPhone", getVenueDetailPhone());
		attributes.put("venueDetailWebsite", getVenueDetailWebsite());
		attributes.put("venueDetailCost", getVenueDetailCost());
		attributes.put("venueDetailhoursOfOperation",
			getVenueDetailhoursOfOperation());

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

		Long infoTypeCategoryId = (Long)attributes.get("infoTypeCategoryId");

		if (infoTypeCategoryId != null) {
			setInfoTypeCategoryId(infoTypeCategoryId);
		}

		String venueDetailInfoName = (String)attributes.get(
				"venueDetailInfoName");

		if (venueDetailInfoName != null) {
			setVenueDetailInfoName(venueDetailInfoName);
		}

		String venueDetailInfoDesc = (String)attributes.get(
				"venueDetailInfoDesc");

		if (venueDetailInfoDesc != null) {
			setVenueDetailInfoDesc(venueDetailInfoDesc);
		}

		String venueDetailInfoComment = (String)attributes.get(
				"venueDetailInfoComment");

		if (venueDetailInfoComment != null) {
			setVenueDetailInfoComment(venueDetailInfoComment);
		}

		String venueDetailAddressLine1 = (String)attributes.get(
				"venueDetailAddressLine1");

		if (venueDetailAddressLine1 != null) {
			setVenueDetailAddressLine1(venueDetailAddressLine1);
		}

		String venueDetailAddressLine2 = (String)attributes.get(
				"venueDetailAddressLine2");

		if (venueDetailAddressLine2 != null) {
			setVenueDetailAddressLine2(venueDetailAddressLine2);
		}

		String venueDetailCity = (String)attributes.get("venueDetailCity");

		if (venueDetailCity != null) {
			setVenueDetailCity(venueDetailCity);
		}

		String venueDetailState = (String)attributes.get("venueDetailState");

		if (venueDetailState != null) {
			setVenueDetailState(venueDetailState);
		}

		String venueDetailCountry = (String)attributes.get("venueDetailCountry");

		if (venueDetailCountry != null) {
			setVenueDetailCountry(venueDetailCountry);
		}

		String venueDetailLatitude = (String)attributes.get(
				"venueDetailLatitude");

		if (venueDetailLatitude != null) {
			setVenueDetailLatitude(venueDetailLatitude);
		}

		String venueDetailLongitude = (String)attributes.get(
				"venueDetailLongitude");

		if (venueDetailLongitude != null) {
			setVenueDetailLongitude(venueDetailLongitude);
		}

		String venueDetailPhone = (String)attributes.get("venueDetailPhone");

		if (venueDetailPhone != null) {
			setVenueDetailPhone(venueDetailPhone);
		}

		String venueDetailWebsite = (String)attributes.get("venueDetailWebsite");

		if (venueDetailWebsite != null) {
			setVenueDetailWebsite(venueDetailWebsite);
		}

		Double venueDetailCost = (Double)attributes.get("venueDetailCost");

		if (venueDetailCost != null) {
			setVenueDetailCost(venueDetailCost);
		}

		String venueDetailhoursOfOperation = (String)attributes.get(
				"venueDetailhoursOfOperation");

		if (venueDetailhoursOfOperation != null) {
			setVenueDetailhoursOfOperation(venueDetailhoursOfOperation);
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
	public String getVenueDetailInfoName() {
		return _venueDetailInfoName;
	}

	@Override
	public void setVenueDetailInfoName(String venueDetailInfoName) {
		_venueDetailInfoName = venueDetailInfoName;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailInfoName",
						String.class);

				method.invoke(_venueDetailRemoteModel, venueDetailInfoName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueDetailInfoDesc() {
		return _venueDetailInfoDesc;
	}

	@Override
	public void setVenueDetailInfoDesc(String venueDetailInfoDesc) {
		_venueDetailInfoDesc = venueDetailInfoDesc;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailInfoDesc",
						String.class);

				method.invoke(_venueDetailRemoteModel, venueDetailInfoDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueDetailInfoComment() {
		return _venueDetailInfoComment;
	}

	@Override
	public void setVenueDetailInfoComment(String venueDetailInfoComment) {
		_venueDetailInfoComment = venueDetailInfoComment;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailInfoComment",
						String.class);

				method.invoke(_venueDetailRemoteModel, venueDetailInfoComment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueDetailAddressLine1() {
		return _venueDetailAddressLine1;
	}

	@Override
	public void setVenueDetailAddressLine1(String venueDetailAddressLine1) {
		_venueDetailAddressLine1 = venueDetailAddressLine1;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailAddressLine1",
						String.class);

				method.invoke(_venueDetailRemoteModel, venueDetailAddressLine1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueDetailAddressLine2() {
		return _venueDetailAddressLine2;
	}

	@Override
	public void setVenueDetailAddressLine2(String venueDetailAddressLine2) {
		_venueDetailAddressLine2 = venueDetailAddressLine2;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailAddressLine2",
						String.class);

				method.invoke(_venueDetailRemoteModel, venueDetailAddressLine2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueDetailCity() {
		return _venueDetailCity;
	}

	@Override
	public void setVenueDetailCity(String venueDetailCity) {
		_venueDetailCity = venueDetailCity;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailCity",
						String.class);

				method.invoke(_venueDetailRemoteModel, venueDetailCity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueDetailState() {
		return _venueDetailState;
	}

	@Override
	public void setVenueDetailState(String venueDetailState) {
		_venueDetailState = venueDetailState;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailState",
						String.class);

				method.invoke(_venueDetailRemoteModel, venueDetailState);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueDetailCountry() {
		return _venueDetailCountry;
	}

	@Override
	public void setVenueDetailCountry(String venueDetailCountry) {
		_venueDetailCountry = venueDetailCountry;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailCountry",
						String.class);

				method.invoke(_venueDetailRemoteModel, venueDetailCountry);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueDetailLatitude() {
		return _venueDetailLatitude;
	}

	@Override
	public void setVenueDetailLatitude(String venueDetailLatitude) {
		_venueDetailLatitude = venueDetailLatitude;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailLatitude",
						String.class);

				method.invoke(_venueDetailRemoteModel, venueDetailLatitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueDetailLongitude() {
		return _venueDetailLongitude;
	}

	@Override
	public void setVenueDetailLongitude(String venueDetailLongitude) {
		_venueDetailLongitude = venueDetailLongitude;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailLongitude",
						String.class);

				method.invoke(_venueDetailRemoteModel, venueDetailLongitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueDetailPhone() {
		return _venueDetailPhone;
	}

	@Override
	public void setVenueDetailPhone(String venueDetailPhone) {
		_venueDetailPhone = venueDetailPhone;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailPhone",
						String.class);

				method.invoke(_venueDetailRemoteModel, venueDetailPhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueDetailWebsite() {
		return _venueDetailWebsite;
	}

	@Override
	public void setVenueDetailWebsite(String venueDetailWebsite) {
		_venueDetailWebsite = venueDetailWebsite;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailWebsite",
						String.class);

				method.invoke(_venueDetailRemoteModel, venueDetailWebsite);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getVenueDetailCost() {
		return _venueDetailCost;
	}

	@Override
	public void setVenueDetailCost(double venueDetailCost) {
		_venueDetailCost = venueDetailCost;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailCost",
						double.class);

				method.invoke(_venueDetailRemoteModel, venueDetailCost);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueDetailhoursOfOperation() {
		return _venueDetailhoursOfOperation;
	}

	@Override
	public void setVenueDetailhoursOfOperation(
		String venueDetailhoursOfOperation) {
		_venueDetailhoursOfOperation = venueDetailhoursOfOperation;

		if (_venueDetailRemoteModel != null) {
			try {
				Class<?> clazz = _venueDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDetailhoursOfOperation",
						String.class);

				method.invoke(_venueDetailRemoteModel,
					venueDetailhoursOfOperation);
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
		clone.setInfoTypeCategoryId(getInfoTypeCategoryId());
		clone.setVenueDetailInfoName(getVenueDetailInfoName());
		clone.setVenueDetailInfoDesc(getVenueDetailInfoDesc());
		clone.setVenueDetailInfoComment(getVenueDetailInfoComment());
		clone.setVenueDetailAddressLine1(getVenueDetailAddressLine1());
		clone.setVenueDetailAddressLine2(getVenueDetailAddressLine2());
		clone.setVenueDetailCity(getVenueDetailCity());
		clone.setVenueDetailState(getVenueDetailState());
		clone.setVenueDetailCountry(getVenueDetailCountry());
		clone.setVenueDetailLatitude(getVenueDetailLatitude());
		clone.setVenueDetailLongitude(getVenueDetailLongitude());
		clone.setVenueDetailPhone(getVenueDetailPhone());
		clone.setVenueDetailWebsite(getVenueDetailWebsite());
		clone.setVenueDetailCost(getVenueDetailCost());
		clone.setVenueDetailhoursOfOperation(getVenueDetailhoursOfOperation());

		return clone;
	}

	@Override
	public int compareTo(VenueDetail venueDetail) {
		long primaryKey = venueDetail.getPrimaryKey();

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
		StringBundler sb = new StringBundler(45);

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
		sb.append(", infoTypeCategoryId=");
		sb.append(getInfoTypeCategoryId());
		sb.append(", venueDetailInfoName=");
		sb.append(getVenueDetailInfoName());
		sb.append(", venueDetailInfoDesc=");
		sb.append(getVenueDetailInfoDesc());
		sb.append(", venueDetailInfoComment=");
		sb.append(getVenueDetailInfoComment());
		sb.append(", venueDetailAddressLine1=");
		sb.append(getVenueDetailAddressLine1());
		sb.append(", venueDetailAddressLine2=");
		sb.append(getVenueDetailAddressLine2());
		sb.append(", venueDetailCity=");
		sb.append(getVenueDetailCity());
		sb.append(", venueDetailState=");
		sb.append(getVenueDetailState());
		sb.append(", venueDetailCountry=");
		sb.append(getVenueDetailCountry());
		sb.append(", venueDetailLatitude=");
		sb.append(getVenueDetailLatitude());
		sb.append(", venueDetailLongitude=");
		sb.append(getVenueDetailLongitude());
		sb.append(", venueDetailPhone=");
		sb.append(getVenueDetailPhone());
		sb.append(", venueDetailWebsite=");
		sb.append(getVenueDetailWebsite());
		sb.append(", venueDetailCost=");
		sb.append(getVenueDetailCost());
		sb.append(", venueDetailhoursOfOperation=");
		sb.append(getVenueDetailhoursOfOperation());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

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
			"<column><column-name>infoTypeCategoryId</column-name><column-value><![CDATA[");
		sb.append(getInfoTypeCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDetailInfoName</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailInfoName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDetailInfoDesc</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailInfoDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDetailInfoComment</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailInfoComment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDetailAddressLine1</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailAddressLine1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDetailAddressLine2</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailAddressLine2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDetailCity</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDetailState</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDetailCountry</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDetailLatitude</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailLatitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDetailLongitude</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDetailPhone</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDetailWebsite</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDetailCost</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailCost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDetailhoursOfOperation</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailhoursOfOperation());
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
	private long _infoTypeCategoryId;
	private String _venueDetailInfoName;
	private String _venueDetailInfoDesc;
	private String _venueDetailInfoComment;
	private String _venueDetailAddressLine1;
	private String _venueDetailAddressLine2;
	private String _venueDetailCity;
	private String _venueDetailState;
	private String _venueDetailCountry;
	private String _venueDetailLatitude;
	private String _venueDetailLongitude;
	private String _venueDetailPhone;
	private String _venueDetailWebsite;
	private double _venueDetailCost;
	private String _venueDetailhoursOfOperation;
	private BaseModel<?> _venueDetailRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}