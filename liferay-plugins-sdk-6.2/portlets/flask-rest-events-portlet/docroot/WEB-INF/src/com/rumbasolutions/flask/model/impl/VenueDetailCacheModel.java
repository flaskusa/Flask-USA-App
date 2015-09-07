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

import com.rumbasolutions.flask.model.VenueDetail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VenueDetail in entity cache.
 *
 * @author Ashutosh Rai
 * @see VenueDetail
 * @generated
 */
public class VenueDetailCacheModel implements CacheModel<VenueDetail>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(55);

		sb.append("{venueDetailId=");
		sb.append(venueDetailId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", venueId=");
		sb.append(venueId);
		sb.append(", infoTypeId=");
		sb.append(infoTypeId);
		sb.append(", infoTypeName=");
		sb.append(infoTypeName);
		sb.append(", infoTypeCategoryId=");
		sb.append(infoTypeCategoryId);
		sb.append(", infoTypeCategoryName=");
		sb.append(infoTypeCategoryName);
		sb.append(", infoTitle=");
		sb.append(infoTitle);
		sb.append(", infoDesc=");
		sb.append(infoDesc);
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
		sb.append(", stateName=");
		sb.append(stateName);
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", countryName=");
		sb.append(countryName);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", website=");
		sb.append(website);
		sb.append(", cost=");
		sb.append(cost);
		sb.append(", hoursOfOperation=");
		sb.append(hoursOfOperation);
		sb.append(", showDescription=");
		sb.append(showDescription);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VenueDetail toEntityModel() {
		VenueDetailImpl venueDetailImpl = new VenueDetailImpl();

		venueDetailImpl.setVenueDetailId(venueDetailId);
		venueDetailImpl.setCompanyId(companyId);
		venueDetailImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			venueDetailImpl.setCreatedDate(null);
		}
		else {
			venueDetailImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			venueDetailImpl.setModifiedDate(null);
		}
		else {
			venueDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		venueDetailImpl.setVenueId(venueId);
		venueDetailImpl.setInfoTypeId(infoTypeId);

		if (infoTypeName == null) {
			venueDetailImpl.setInfoTypeName(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setInfoTypeName(infoTypeName);
		}

		venueDetailImpl.setInfoTypeCategoryId(infoTypeCategoryId);

		if (infoTypeCategoryName == null) {
			venueDetailImpl.setInfoTypeCategoryName(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setInfoTypeCategoryName(infoTypeCategoryName);
		}

		if (infoTitle == null) {
			venueDetailImpl.setInfoTitle(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setInfoTitle(infoTitle);
		}

		if (infoDesc == null) {
			venueDetailImpl.setInfoDesc(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setInfoDesc(infoDesc);
		}

		if (addrLine1 == null) {
			venueDetailImpl.setAddrLine1(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setAddrLine1(addrLine1);
		}

		if (addrLine2 == null) {
			venueDetailImpl.setAddrLine2(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setAddrLine2(addrLine2);
		}

		if (city == null) {
			venueDetailImpl.setCity(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setCity(city);
		}

		if (zipCode == null) {
			venueDetailImpl.setZipCode(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setZipCode(zipCode);
		}

		venueDetailImpl.setStateId(stateId);

		if (stateName == null) {
			venueDetailImpl.setStateName(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setStateName(stateName);
		}

		venueDetailImpl.setCountryId(countryId);

		if (countryName == null) {
			venueDetailImpl.setCountryName(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setCountryName(countryName);
		}

		if (latitude == null) {
			venueDetailImpl.setLatitude(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setLatitude(latitude);
		}

		if (longitude == null) {
			venueDetailImpl.setLongitude(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setLongitude(longitude);
		}

		if (phone == null) {
			venueDetailImpl.setPhone(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setPhone(phone);
		}

		if (website == null) {
			venueDetailImpl.setWebsite(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setWebsite(website);
		}

		venueDetailImpl.setCost(cost);

		if (hoursOfOperation == null) {
			venueDetailImpl.setHoursOfOperation(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setHoursOfOperation(hoursOfOperation);
		}

		venueDetailImpl.setShowDescription(showDescription);

		venueDetailImpl.resetOriginalValues();

		return venueDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		venueDetailId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		venueId = objectInput.readLong();
		infoTypeId = objectInput.readLong();
		infoTypeName = objectInput.readUTF();
		infoTypeCategoryId = objectInput.readLong();
		infoTypeCategoryName = objectInput.readUTF();
		infoTitle = objectInput.readUTF();
		infoDesc = objectInput.readUTF();
		addrLine1 = objectInput.readUTF();
		addrLine2 = objectInput.readUTF();
		city = objectInput.readUTF();
		zipCode = objectInput.readUTF();
		stateId = objectInput.readLong();
		stateName = objectInput.readUTF();
		countryId = objectInput.readLong();
		countryName = objectInput.readUTF();
		latitude = objectInput.readUTF();
		longitude = objectInput.readUTF();
		phone = objectInput.readUTF();
		website = objectInput.readUTF();
		cost = objectInput.readDouble();
		hoursOfOperation = objectInput.readUTF();
		showDescription = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(venueDetailId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(venueId);
		objectOutput.writeLong(infoTypeId);

		if (infoTypeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(infoTypeName);
		}

		objectOutput.writeLong(infoTypeCategoryId);

		if (infoTypeCategoryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(infoTypeCategoryName);
		}

		if (infoTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(infoTitle);
		}

		if (infoDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(infoDesc);
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

		if (stateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stateName);
		}

		objectOutput.writeLong(countryId);

		if (countryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryName);
		}

		if (latitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(latitude);
		}

		if (longitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(longitude);
		}

		if (phone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (website == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(website);
		}

		objectOutput.writeDouble(cost);

		if (hoursOfOperation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hoursOfOperation);
		}

		objectOutput.writeBoolean(showDescription);
	}

	public long venueDetailId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public long venueId;
	public long infoTypeId;
	public String infoTypeName;
	public long infoTypeCategoryId;
	public String infoTypeCategoryName;
	public String infoTitle;
	public String infoDesc;
	public String addrLine1;
	public String addrLine2;
	public String city;
	public String zipCode;
	public long stateId;
	public String stateName;
	public long countryId;
	public String countryName;
	public String latitude;
	public String longitude;
	public String phone;
	public String website;
	public double cost;
	public String hoursOfOperation;
	public boolean showDescription;
}