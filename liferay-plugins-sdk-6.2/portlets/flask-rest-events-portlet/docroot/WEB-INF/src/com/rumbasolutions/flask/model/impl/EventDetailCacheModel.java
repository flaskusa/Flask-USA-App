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

import com.rumbasolutions.flask.model.EventDetail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EventDetail in entity cache.
 *
 * @author Ashutosh Rai
 * @see EventDetail
 * @generated
 */
public class EventDetailCacheModel implements CacheModel<EventDetail>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{eventDetailId=");
		sb.append(eventDetailId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", eventId=");
		sb.append(eventId);
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
		sb.append(", infoShortDesc=");
		sb.append(infoShortDesc);
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
		sb.append(", mobileAppName=");
		sb.append(mobileAppName);
		sb.append(", website=");
		sb.append(website);
		sb.append(", cost=");
		sb.append(cost);
		sb.append(", hoursOfOperation=");
		sb.append(hoursOfOperation);
		sb.append(", showDescription=");
		sb.append(showDescription);
		sb.append(", premiumDisplayEnabled=");
		sb.append(premiumDisplayEnabled);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EventDetail toEntityModel() {
		EventDetailImpl eventDetailImpl = new EventDetailImpl();

		eventDetailImpl.setEventDetailId(eventDetailId);
		eventDetailImpl.setCompanyId(companyId);
		eventDetailImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			eventDetailImpl.setCreatedDate(null);
		}
		else {
			eventDetailImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eventDetailImpl.setModifiedDate(null);
		}
		else {
			eventDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		eventDetailImpl.setEventId(eventId);
		eventDetailImpl.setInfoTypeId(infoTypeId);

		if (infoTypeName == null) {
			eventDetailImpl.setInfoTypeName(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setInfoTypeName(infoTypeName);
		}

		eventDetailImpl.setInfoTypeCategoryId(infoTypeCategoryId);

		if (infoTypeCategoryName == null) {
			eventDetailImpl.setInfoTypeCategoryName(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setInfoTypeCategoryName(infoTypeCategoryName);
		}

		if (infoTitle == null) {
			eventDetailImpl.setInfoTitle(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setInfoTitle(infoTitle);
		}

		if (infoShortDesc == null) {
			eventDetailImpl.setInfoShortDesc(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setInfoShortDesc(infoShortDesc);
		}

		if (infoDesc == null) {
			eventDetailImpl.setInfoDesc(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setInfoDesc(infoDesc);
		}

		if (addrLine1 == null) {
			eventDetailImpl.setAddrLine1(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setAddrLine1(addrLine1);
		}

		if (addrLine2 == null) {
			eventDetailImpl.setAddrLine2(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setAddrLine2(addrLine2);
		}

		if (city == null) {
			eventDetailImpl.setCity(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setCity(city);
		}

		if (zipCode == null) {
			eventDetailImpl.setZipCode(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setZipCode(zipCode);
		}

		eventDetailImpl.setStateId(stateId);

		if (stateName == null) {
			eventDetailImpl.setStateName(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setStateName(stateName);
		}

		eventDetailImpl.setCountryId(countryId);

		if (countryName == null) {
			eventDetailImpl.setCountryName(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setCountryName(countryName);
		}

		if (latitude == null) {
			eventDetailImpl.setLatitude(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setLatitude(latitude);
		}

		if (longitude == null) {
			eventDetailImpl.setLongitude(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setLongitude(longitude);
		}

		if (phone == null) {
			eventDetailImpl.setPhone(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setPhone(phone);
		}

		if (mobileAppName == null) {
			eventDetailImpl.setMobileAppName(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setMobileAppName(mobileAppName);
		}

		if (website == null) {
			eventDetailImpl.setWebsite(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setWebsite(website);
		}

		eventDetailImpl.setCost(cost);

		if (hoursOfOperation == null) {
			eventDetailImpl.setHoursOfOperation(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setHoursOfOperation(hoursOfOperation);
		}

		eventDetailImpl.setShowDescription(showDescription);
		eventDetailImpl.setPremiumDisplayEnabled(premiumDisplayEnabled);

		eventDetailImpl.resetOriginalValues();

		return eventDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eventDetailId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		eventId = objectInput.readLong();
		infoTypeId = objectInput.readLong();
		infoTypeName = objectInput.readUTF();
		infoTypeCategoryId = objectInput.readLong();
		infoTypeCategoryName = objectInput.readUTF();
		infoTitle = objectInput.readUTF();
		infoShortDesc = objectInput.readUTF();
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
		mobileAppName = objectInput.readUTF();
		website = objectInput.readUTF();
		cost = objectInput.readDouble();
		hoursOfOperation = objectInput.readUTF();
		showDescription = objectInput.readBoolean();
		premiumDisplayEnabled = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eventDetailId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(eventId);
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

		if (infoShortDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(infoShortDesc);
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

		if (mobileAppName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mobileAppName);
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
		objectOutput.writeBoolean(premiumDisplayEnabled);
	}

	public long eventDetailId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public long eventId;
	public long infoTypeId;
	public String infoTypeName;
	public long infoTypeCategoryId;
	public String infoTypeCategoryName;
	public String infoTitle;
	public String infoShortDesc;
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
	public String mobileAppName;
	public String website;
	public double cost;
	public String hoursOfOperation;
	public boolean showDescription;
	public boolean premiumDisplayEnabled;
}