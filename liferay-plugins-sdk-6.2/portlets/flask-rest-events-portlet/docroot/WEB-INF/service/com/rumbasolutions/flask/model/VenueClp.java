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
import com.rumbasolutions.flask.service.VenueLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashutosh Rai
 */
public class VenueClp extends BaseModelImpl<Venue> implements Venue {
	public VenueClp() {
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
	public long getPrimaryKey() {
		return _venueId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVenueId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _venueId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
	}

	@Override
	public long getVenueId() {
		return _venueId;
	}

	@Override
	public void setVenueId(long venueId) {
		_venueId = venueId;

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueId", long.class);

				method.invoke(_venueRemoteModel, venueId);
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

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_venueRemoteModel, companyId);
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

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_venueRemoteModel, userId);
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

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_venueRemoteModel, createdDate);
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

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_venueRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueName() {
		return _venueName;
	}

	@Override
	public void setVenueName(String venueName) {
		_venueName = venueName;

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueName", String.class);

				method.invoke(_venueRemoteModel, venueName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueDescription() {
		return _venueDescription;
	}

	@Override
	public void setVenueDescription(String venueDescription) {
		_venueDescription = venueDescription;

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueDescription",
						String.class);

				method.invoke(_venueRemoteModel, venueDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueZipCode() {
		return _venueZipCode;
	}

	@Override
	public void setVenueZipCode(String venueZipCode) {
		_venueZipCode = venueZipCode;

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueZipCode", String.class);

				method.invoke(_venueRemoteModel, venueZipCode);
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

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setAddrLine1", String.class);

				method.invoke(_venueRemoteModel, addrLine1);
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

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setAddrLine2", String.class);

				method.invoke(_venueRemoteModel, addrLine2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueCity() {
		return _venueCity;
	}

	@Override
	public void setVenueCity(String venueCity) {
		_venueCity = venueCity;

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueCity", String.class);

				method.invoke(_venueRemoteModel, venueCity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVenueStateId() {
		return _venueStateId;
	}

	@Override
	public void setVenueStateId(long venueStateId) {
		_venueStateId = venueStateId;

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueStateId", long.class);

				method.invoke(_venueRemoteModel, venueStateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueStateName() {
		return _venueStateName;
	}

	@Override
	public void setVenueStateName(String venueStateName) {
		_venueStateName = venueStateName;

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueStateName",
						String.class);

				method.invoke(_venueRemoteModel, venueStateName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVenueCountryId() {
		return _venueCountryId;
	}

	@Override
	public void setVenueCountryId(long venueCountryId) {
		_venueCountryId = venueCountryId;

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueCountryId", long.class);

				method.invoke(_venueRemoteModel, venueCountryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueCountryName() {
		return _venueCountryName;
	}

	@Override
	public void setVenueCountryName(String venueCountryName) {
		_venueCountryName = venueCountryName;

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueCountryName",
						String.class);

				method.invoke(_venueRemoteModel, venueCountryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenueMetroArea() {
		return _venueMetroArea;
	}

	@Override
	public void setVenueMetroArea(String venueMetroArea) {
		_venueMetroArea = venueMetroArea;

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setVenueMetroArea",
						String.class);

				method.invoke(_venueRemoteModel, venueMetroArea);
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

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setLongitude", String.class);

				method.invoke(_venueRemoteModel, longitude);
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

		if (_venueRemoteModel != null) {
			try {
				Class<?> clazz = _venueRemoteModel.getClass();

				Method method = clazz.getMethod("setLatitude", String.class);

				method.invoke(_venueRemoteModel, latitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVenueRemoteModel() {
		return _venueRemoteModel;
	}

	public void setVenueRemoteModel(BaseModel<?> venueRemoteModel) {
		_venueRemoteModel = venueRemoteModel;
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

		Class<?> remoteModelClass = _venueRemoteModel.getClass();

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

		Object returnValue = method.invoke(_venueRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VenueLocalServiceUtil.addVenue(this);
		}
		else {
			VenueLocalServiceUtil.updateVenue(this);
		}
	}

	@Override
	public Venue toEscapedModel() {
		return (Venue)ProxyUtil.newProxyInstance(Venue.class.getClassLoader(),
			new Class[] { Venue.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VenueClp clone = new VenueClp();

		clone.setVenueId(getVenueId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setVenueName(getVenueName());
		clone.setVenueDescription(getVenueDescription());
		clone.setVenueZipCode(getVenueZipCode());
		clone.setAddrLine1(getAddrLine1());
		clone.setAddrLine2(getAddrLine2());
		clone.setVenueCity(getVenueCity());
		clone.setVenueStateId(getVenueStateId());
		clone.setVenueStateName(getVenueStateName());
		clone.setVenueCountryId(getVenueCountryId());
		clone.setVenueCountryName(getVenueCountryName());
		clone.setVenueMetroArea(getVenueMetroArea());
		clone.setLongitude(getLongitude());
		clone.setLatitude(getLatitude());

		return clone;
	}

	@Override
	public int compareTo(Venue venue) {
		int value = 0;

		value = getVenueName().compareTo(venue.getVenueName());

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

		if (!(obj instanceof VenueClp)) {
			return false;
		}

		VenueClp venue = (VenueClp)obj;

		long primaryKey = venue.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{venueId=");
		sb.append(getVenueId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", venueName=");
		sb.append(getVenueName());
		sb.append(", venueDescription=");
		sb.append(getVenueDescription());
		sb.append(", venueZipCode=");
		sb.append(getVenueZipCode());
		sb.append(", addrLine1=");
		sb.append(getAddrLine1());
		sb.append(", addrLine2=");
		sb.append(getAddrLine2());
		sb.append(", venueCity=");
		sb.append(getVenueCity());
		sb.append(", venueStateId=");
		sb.append(getVenueStateId());
		sb.append(", venueStateName=");
		sb.append(getVenueStateName());
		sb.append(", venueCountryId=");
		sb.append(getVenueCountryId());
		sb.append(", venueCountryName=");
		sb.append(getVenueCountryName());
		sb.append(", venueMetroArea=");
		sb.append(getVenueMetroArea());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.Venue");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>venueId</column-name><column-value><![CDATA[");
		sb.append(getVenueId());
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
			"<column><column-name>venueName</column-name><column-value><![CDATA[");
		sb.append(getVenueName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDescription</column-name><column-value><![CDATA[");
		sb.append(getVenueDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueZipCode</column-name><column-value><![CDATA[");
		sb.append(getVenueZipCode());
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
			"<column><column-name>venueCity</column-name><column-value><![CDATA[");
		sb.append(getVenueCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueStateId</column-name><column-value><![CDATA[");
		sb.append(getVenueStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueStateName</column-name><column-value><![CDATA[");
		sb.append(getVenueStateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueCountryId</column-name><column-value><![CDATA[");
		sb.append(getVenueCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueCountryName</column-name><column-value><![CDATA[");
		sb.append(getVenueCountryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueMetroArea</column-name><column-value><![CDATA[");
		sb.append(getVenueMetroArea());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longitude</column-name><column-value><![CDATA[");
		sb.append(getLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitude</column-name><column-value><![CDATA[");
		sb.append(getLatitude());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _venueId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _venueName;
	private String _venueDescription;
	private String _venueZipCode;
	private String _addrLine1;
	private String _addrLine2;
	private String _venueCity;
	private long _venueStateId;
	private String _venueStateName;
	private long _venueCountryId;
	private String _venueCountryName;
	private String _venueMetroArea;
	private String _longitude;
	private String _latitude;
	private BaseModel<?> _venueRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}