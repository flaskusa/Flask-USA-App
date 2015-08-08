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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.rumbasolutions.flask.service.http.AdCustomerServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.http.AdCustomerServiceSoap
 * @generated
 */
public class AdCustomerSoap implements Serializable {
	public static AdCustomerSoap toSoapModel(AdCustomer model) {
		AdCustomerSoap soapModel = new AdCustomerSoap();

		soapModel.setCustomerId(model.getCustomerId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCustomerName(model.getCustomerName());
		soapModel.setBusinessType(model.getBusinessType());
		soapModel.setAddrLine1(model.getAddrLine1());
		soapModel.setAddrLine2(model.getAddrLine2());
		soapModel.setCity(model.getCity());
		soapModel.setZipCode(model.getZipCode());
		soapModel.setStateId(model.getStateId());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setEmail(model.getEmail());
		soapModel.setWebsiteURL(model.getWebsiteURL());
		soapModel.setBusinessPhoneNumber(model.getBusinessPhoneNumber());
		soapModel.setContactPersonName(model.getContactPersonName());
		soapModel.setContactPersonNumber(model.getContactPersonNumber());

		return soapModel;
	}

	public static AdCustomerSoap[] toSoapModels(AdCustomer[] models) {
		AdCustomerSoap[] soapModels = new AdCustomerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdCustomerSoap[][] toSoapModels(AdCustomer[][] models) {
		AdCustomerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdCustomerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdCustomerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdCustomerSoap[] toSoapModels(List<AdCustomer> models) {
		List<AdCustomerSoap> soapModels = new ArrayList<AdCustomerSoap>(models.size());

		for (AdCustomer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdCustomerSoap[soapModels.size()]);
	}

	public AdCustomerSoap() {
	}

	public long getPrimaryKey() {
		return _customerId;
	}

	public void setPrimaryKey(long pk) {
		setCustomerId(pk);
	}

	public long getCustomerId() {
		return _customerId;
	}

	public void setCustomerId(long customerId) {
		_customerId = customerId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getCustomerName() {
		return _customerName;
	}

	public void setCustomerName(String customerName) {
		_customerName = customerName;
	}

	public String getBusinessType() {
		return _businessType;
	}

	public void setBusinessType(String businessType) {
		_businessType = businessType;
	}

	public String getAddrLine1() {
		return _addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		_addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return _addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		_addrLine2 = addrLine2;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getZipCode() {
		return _zipCode;
	}

	public void setZipCode(String zipCode) {
		_zipCode = zipCode;
	}

	public long getStateId() {
		return _stateId;
	}

	public void setStateId(long stateId) {
		_stateId = stateId;
	}

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getWebsiteURL() {
		return _websiteURL;
	}

	public void setWebsiteURL(String websiteURL) {
		_websiteURL = websiteURL;
	}

	public String getBusinessPhoneNumber() {
		return _businessPhoneNumber;
	}

	public void setBusinessPhoneNumber(String businessPhoneNumber) {
		_businessPhoneNumber = businessPhoneNumber;
	}

	public String getContactPersonName() {
		return _contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		_contactPersonName = contactPersonName;
	}

	public String getContactPersonNumber() {
		return _contactPersonNumber;
	}

	public void setContactPersonNumber(String contactPersonNumber) {
		_contactPersonNumber = contactPersonNumber;
	}

	private long _customerId;
	private long _userId;
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
}