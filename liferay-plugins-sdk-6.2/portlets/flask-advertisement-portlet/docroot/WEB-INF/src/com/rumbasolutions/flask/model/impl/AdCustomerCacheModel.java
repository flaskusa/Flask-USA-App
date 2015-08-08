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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rumbasolutions.flask.model.AdCustomer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AdCustomer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AdCustomer
 * @generated
 */
public class AdCustomerCacheModel implements CacheModel<AdCustomer>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{customerId=");
		sb.append(customerId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", customerName=");
		sb.append(customerName);
		sb.append(", businessType=");
		sb.append(businessType);
		sb.append(", addrLine1=");
		sb.append(addrLine1);
		sb.append(", addrLine2=");
		sb.append(addrLine2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", email=");
		sb.append(email);
		sb.append(", websiteURL=");
		sb.append(websiteURL);
		sb.append(", businessPhoneNumber=");
		sb.append(businessPhoneNumber);
		sb.append(", contactPersonName=");
		sb.append(contactPersonName);
		sb.append(", contactPersonNumber=");
		sb.append(contactPersonNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AdCustomer toEntityModel() {
		AdCustomerImpl adCustomerImpl = new AdCustomerImpl();

		adCustomerImpl.setCustomerId(customerId);
		adCustomerImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			adCustomerImpl.setCreatedDate(null);
		}
		else {
			adCustomerImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			adCustomerImpl.setModifiedDate(null);
		}
		else {
			adCustomerImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (customerName == null) {
			adCustomerImpl.setCustomerName(StringPool.BLANK);
		}
		else {
			adCustomerImpl.setCustomerName(customerName);
		}

		if (businessType == null) {
			adCustomerImpl.setBusinessType(StringPool.BLANK);
		}
		else {
			adCustomerImpl.setBusinessType(businessType);
		}

		if (addrLine1 == null) {
			adCustomerImpl.setAddrLine1(StringPool.BLANK);
		}
		else {
			adCustomerImpl.setAddrLine1(addrLine1);
		}

		if (addrLine2 == null) {
			adCustomerImpl.setAddrLine2(StringPool.BLANK);
		}
		else {
			adCustomerImpl.setAddrLine2(addrLine2);
		}

		if (city == null) {
			adCustomerImpl.setCity(StringPool.BLANK);
		}
		else {
			adCustomerImpl.setCity(city);
		}

		if (zipCode == null) {
			adCustomerImpl.setZipCode(StringPool.BLANK);
		}
		else {
			adCustomerImpl.setZipCode(zipCode);
		}

		adCustomerImpl.setStateId(stateId);
		adCustomerImpl.setCountryId(countryId);

		if (email == null) {
			adCustomerImpl.setEmail(StringPool.BLANK);
		}
		else {
			adCustomerImpl.setEmail(email);
		}

		if (websiteURL == null) {
			adCustomerImpl.setWebsiteURL(StringPool.BLANK);
		}
		else {
			adCustomerImpl.setWebsiteURL(websiteURL);
		}

		if (businessPhoneNumber == null) {
			adCustomerImpl.setBusinessPhoneNumber(StringPool.BLANK);
		}
		else {
			adCustomerImpl.setBusinessPhoneNumber(businessPhoneNumber);
		}

		if (contactPersonName == null) {
			adCustomerImpl.setContactPersonName(StringPool.BLANK);
		}
		else {
			adCustomerImpl.setContactPersonName(contactPersonName);
		}

		if (contactPersonNumber == null) {
			adCustomerImpl.setContactPersonNumber(StringPool.BLANK);
		}
		else {
			adCustomerImpl.setContactPersonNumber(contactPersonNumber);
		}

		adCustomerImpl.resetOriginalValues();

		return adCustomerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		customerId = objectInput.readLong();
		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		customerName = objectInput.readUTF();
		businessType = objectInput.readUTF();
		addrLine1 = objectInput.readUTF();
		addrLine2 = objectInput.readUTF();
		city = objectInput.readUTF();
		zipCode = objectInput.readUTF();
		stateId = objectInput.readLong();
		countryId = objectInput.readLong();
		email = objectInput.readUTF();
		websiteURL = objectInput.readUTF();
		businessPhoneNumber = objectInput.readUTF();
		contactPersonName = objectInput.readUTF();
		contactPersonNumber = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(customerId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		if (customerName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customerName);
		}

		if (businessType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(businessType);
		}

		if (addrLine1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(addrLine1);
		}

		if (addrLine2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(addrLine2);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (zipCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zipCode);
		}

		objectOutput.writeLong(stateId);
		objectOutput.writeLong(countryId);

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (websiteURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(websiteURL);
		}

		if (businessPhoneNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(businessPhoneNumber);
		}

		if (contactPersonName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactPersonName);
		}

		if (contactPersonNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactPersonNumber);
		}
	}

	public long customerId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public String customerName;
	public String businessType;
	public String addrLine1;
	public String addrLine2;
	public String city;
	public String zipCode;
	public long stateId;
	public long countryId;
	public String email;
	public String websiteURL;
	public String businessPhoneNumber;
	public String contactPersonName;
	public String contactPersonNumber;
}