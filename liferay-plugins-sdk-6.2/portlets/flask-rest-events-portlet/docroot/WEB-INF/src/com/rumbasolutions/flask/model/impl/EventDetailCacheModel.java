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
		StringBundler sb = new StringBundler(49);

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
		sb.append(", infoName=");
		sb.append(infoName);
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
		sb.append(", countryId=");
		sb.append(countryId);
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
		eventDetailImpl.setInfoTypeCategoryName(infoTypeCategoryName);

		if (infoName == null) {
			eventDetailImpl.setInfoName(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setInfoName(infoName);
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
		eventDetailImpl.setCountryId(countryId);

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
		infoTypeCategoryName = objectInput.readLong();
		infoName = objectInput.readUTF();
		infoDesc = objectInput.readUTF();
		addrLine1 = objectInput.readUTF();
		addrLine2 = objectInput.readUTF();
		city = objectInput.readUTF();
		zipCode = objectInput.readUTF();
		stateId = objectInput.readLong();
		countryId = objectInput.readLong();
		latitude = objectInput.readUTF();
		longitude = objectInput.readUTF();
		phone = objectInput.readUTF();
		website = objectInput.readUTF();
		cost = objectInput.readDouble();
		hoursOfOperation = objectInput.readUTF();
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
		objectOutput.writeLong(infoTypeCategoryName);

		if (infoName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(infoName);
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
		objectOutput.writeLong(countryId);

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
	public long infoTypeCategoryName;
	public String infoName;
	public String infoDesc;
	public String addrLine1;
	public String addrLine2;
	public String city;
	public String zipCode;
	public long stateId;
	public long countryId;
	public String latitude;
	public String longitude;
	public String phone;
	public String website;
	public double cost;
	public String hoursOfOperation;
}