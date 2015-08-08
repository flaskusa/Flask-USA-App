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

import com.rumbasolutions.flask.service.AdCustomerLocalServiceUtil;
import com.rumbasolutions.flask.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class AdCustomerClp extends BaseModelImpl<AdCustomer>
	implements AdCustomer {
	public AdCustomerClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AdCustomer.class;
	}

	@Override
	public String getModelClassName() {
		return AdCustomer.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _customerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCustomerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _customerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("customerId", getCustomerId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("customerName", getCustomerName());
		attributes.put("businessType", getBusinessType());
		attributes.put("addrLine1", getAddrLine1());
		attributes.put("addrLine2", getAddrLine2());
		attributes.put("city", getCity());
		attributes.put("zipCode", getZipCode());
		attributes.put("stateId", getStateId());
		attributes.put("countryId", getCountryId());
		attributes.put("email", getEmail());
		attributes.put("websiteURL", getWebsiteURL());
		attributes.put("businessPhoneNumber", getBusinessPhoneNumber());
		attributes.put("contactPersonName", getContactPersonName());
		attributes.put("contactPersonNumber", getContactPersonNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
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

		String customerName = (String)attributes.get("customerName");

		if (customerName != null) {
			setCustomerName(customerName);
		}

		String businessType = (String)attributes.get("businessType");

		if (businessType != null) {
			setBusinessType(businessType);
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

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String websiteURL = (String)attributes.get("websiteURL");

		if (websiteURL != null) {
			setWebsiteURL(websiteURL);
		}

		String businessPhoneNumber = (String)attributes.get(
				"businessPhoneNumber");

		if (businessPhoneNumber != null) {
			setBusinessPhoneNumber(businessPhoneNumber);
		}

		String contactPersonName = (String)attributes.get("contactPersonName");

		if (contactPersonName != null) {
			setContactPersonName(contactPersonName);
		}

		String contactPersonNumber = (String)attributes.get(
				"contactPersonNumber");

		if (contactPersonNumber != null) {
			setContactPersonNumber(contactPersonNumber);
		}
	}

	@Override
	public long getCustomerId() {
		return _customerId;
	}

	@Override
	public void setCustomerId(long customerId) {
		_customerId = customerId;

		if (_adCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _adCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerId", long.class);

				method.invoke(_adCustomerRemoteModel, customerId);
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

		if (_adCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _adCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_adCustomerRemoteModel, userId);
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

		if (_adCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _adCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_adCustomerRemoteModel, createdDate);
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

		if (_adCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _adCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_adCustomerRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomerName() {
		return _customerName;
	}

	@Override
	public void setCustomerName(String customerName) {
		_customerName = customerName;

		if (_adCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _adCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerName", String.class);

				method.invoke(_adCustomerRemoteModel, customerName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBusinessType() {
		return _businessType;
	}

	@Override
	public void setBusinessType(String businessType) {
		_businessType = businessType;

		if (_adCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _adCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessType", String.class);

				method.invoke(_adCustomerRemoteModel, businessType);
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

		if (_adCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _adCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setAddrLine1", String.class);

				method.invoke(_adCustomerRemoteModel, addrLine1);
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

		if (_adCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _adCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setAddrLine2", String.class);

				method.invoke(_adCustomerRemoteModel, addrLine2);
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

		if (_adCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _adCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_adCustomerRemoteModel, city);
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

		if (_adCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _adCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setZipCode", String.class);

				method.invoke(_adCustomerRemoteModel, zipCode);
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

		if (_adCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _adCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setStateId", long.class);

				method.invoke(_adCustomerRemoteModel, stateId);
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

		if (_adCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _adCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryId", long.class);

				method.invoke(_adCustomerRemoteModel, countryId);
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

		if (_adCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _adCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_adCustomerRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWebsiteURL() {
		return _websiteURL;
	}

	@Override
	public void setWebsiteURL(String websiteURL) {
		_websiteURL = websiteURL;

		if (_adCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _adCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setWebsiteURL", String.class);

				method.invoke(_adCustomerRemoteModel, websiteURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBusinessPhoneNumber() {
		return _businessPhoneNumber;
	}

	@Override
	public void setBusinessPhoneNumber(String businessPhoneNumber) {
		_businessPhoneNumber = businessPhoneNumber;

		if (_adCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _adCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessPhoneNumber",
						String.class);

				method.invoke(_adCustomerRemoteModel, businessPhoneNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactPersonName() {
		return _contactPersonName;
	}

	@Override
	public void setContactPersonName(String contactPersonName) {
		_contactPersonName = contactPersonName;

		if (_adCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _adCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setContactPersonName",
						String.class);

				method.invoke(_adCustomerRemoteModel, contactPersonName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactPersonNumber() {
		return _contactPersonNumber;
	}

	@Override
	public void setContactPersonNumber(String contactPersonNumber) {
		_contactPersonNumber = contactPersonNumber;

		if (_adCustomerRemoteModel != null) {
			try {
				Class<?> clazz = _adCustomerRemoteModel.getClass();

				Method method = clazz.getMethod("setContactPersonNumber",
						String.class);

				method.invoke(_adCustomerRemoteModel, contactPersonNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAdCustomerRemoteModel() {
		return _adCustomerRemoteModel;
	}

	public void setAdCustomerRemoteModel(BaseModel<?> adCustomerRemoteModel) {
		_adCustomerRemoteModel = adCustomerRemoteModel;
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

		Class<?> remoteModelClass = _adCustomerRemoteModel.getClass();

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

		Object returnValue = method.invoke(_adCustomerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AdCustomerLocalServiceUtil.addAdCustomer(this);
		}
		else {
			AdCustomerLocalServiceUtil.updateAdCustomer(this);
		}
	}

	@Override
	public AdCustomer toEscapedModel() {
		return (AdCustomer)ProxyUtil.newProxyInstance(AdCustomer.class.getClassLoader(),
			new Class[] { AdCustomer.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AdCustomerClp clone = new AdCustomerClp();

		clone.setCustomerId(getCustomerId());
		clone.setUserId(getUserId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCustomerName(getCustomerName());
		clone.setBusinessType(getBusinessType());
		clone.setAddrLine1(getAddrLine1());
		clone.setAddrLine2(getAddrLine2());
		clone.setCity(getCity());
		clone.setZipCode(getZipCode());
		clone.setStateId(getStateId());
		clone.setCountryId(getCountryId());
		clone.setEmail(getEmail());
		clone.setWebsiteURL(getWebsiteURL());
		clone.setBusinessPhoneNumber(getBusinessPhoneNumber());
		clone.setContactPersonName(getContactPersonName());
		clone.setContactPersonNumber(getContactPersonNumber());

		return clone;
	}

	@Override
	public int compareTo(AdCustomer adCustomer) {
		long primaryKey = adCustomer.getPrimaryKey();

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

		if (!(obj instanceof AdCustomerClp)) {
			return false;
		}

		AdCustomerClp adCustomer = (AdCustomerClp)obj;

		long primaryKey = adCustomer.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{customerId=");
		sb.append(getCustomerId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", customerName=");
		sb.append(getCustomerName());
		sb.append(", businessType=");
		sb.append(getBusinessType());
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
		sb.append(", countryId=");
		sb.append(getCountryId());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", websiteURL=");
		sb.append(getWebsiteURL());
		sb.append(", businessPhoneNumber=");
		sb.append(getBusinessPhoneNumber());
		sb.append(", contactPersonName=");
		sb.append(getContactPersonName());
		sb.append(", contactPersonNumber=");
		sb.append(getContactPersonNumber());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.AdCustomer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>customerId</column-name><column-value><![CDATA[");
		sb.append(getCustomerId());
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
			"<column><column-name>customerName</column-name><column-value><![CDATA[");
		sb.append(getCustomerName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>businessType</column-name><column-value><![CDATA[");
		sb.append(getBusinessType());
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
			"<column><column-name>countryId</column-name><column-value><![CDATA[");
		sb.append(getCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>websiteURL</column-name><column-value><![CDATA[");
		sb.append(getWebsiteURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>businessPhoneNumber</column-name><column-value><![CDATA[");
		sb.append(getBusinessPhoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactPersonName</column-name><column-value><![CDATA[");
		sb.append(getContactPersonName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactPersonNumber</column-name><column-value><![CDATA[");
		sb.append(getContactPersonNumber());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _customerId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _customerName;
	private String _businessType;
	private String _addrLine1;
	private String _addrLine2;
	private String _city;
	private String _zipCode;
	private long _stateId;
	private long _countryId;
	private String _email;
	private String _websiteURL;
	private String _businessPhoneNumber;
	private String _contactPersonName;
	private String _contactPersonNumber;
	private BaseModel<?> _adCustomerRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}