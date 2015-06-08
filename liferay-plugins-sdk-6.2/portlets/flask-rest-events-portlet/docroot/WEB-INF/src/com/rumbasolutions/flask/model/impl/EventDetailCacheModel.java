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
		StringBundler sb = new StringBundler(47);

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
		sb.append(", infoTypeCategoryId=");
		sb.append(infoTypeCategoryId);
		sb.append(", eventDetailInfoName=");
		sb.append(eventDetailInfoName);
		sb.append(", eventDetailInfoDesc=");
		sb.append(eventDetailInfoDesc);
		sb.append(", eventDetailInfoComment=");
		sb.append(eventDetailInfoComment);
		sb.append(", eventDetailAddressLine1=");
		sb.append(eventDetailAddressLine1);
		sb.append(", eventDetailAddressLine2=");
		sb.append(eventDetailAddressLine2);
		sb.append(", eventDetailInfocity=");
		sb.append(eventDetailInfocity);
		sb.append(", eventDetailZip=");
		sb.append(eventDetailZip);
		sb.append(", eventDetailState=");
		sb.append(eventDetailState);
		sb.append(", eventDetailCountry=");
		sb.append(eventDetailCountry);
		sb.append(", eventDetailLatitude=");
		sb.append(eventDetailLatitude);
		sb.append(", eventDetailLongitude=");
		sb.append(eventDetailLongitude);
		sb.append(", eventDetailPhone=");
		sb.append(eventDetailPhone);
		sb.append(", eventDetailWebsite=");
		sb.append(eventDetailWebsite);
		sb.append(", eventDetailCost=");
		sb.append(eventDetailCost);
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
		eventDetailImpl.setInfoTypeCategoryId(infoTypeCategoryId);

		if (eventDetailInfoName == null) {
			eventDetailImpl.setEventDetailInfoName(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setEventDetailInfoName(eventDetailInfoName);
		}

		if (eventDetailInfoDesc == null) {
			eventDetailImpl.setEventDetailInfoDesc(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setEventDetailInfoDesc(eventDetailInfoDesc);
		}

		if (eventDetailInfoComment == null) {
			eventDetailImpl.setEventDetailInfoComment(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setEventDetailInfoComment(eventDetailInfoComment);
		}

		if (eventDetailAddressLine1 == null) {
			eventDetailImpl.setEventDetailAddressLine1(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setEventDetailAddressLine1(eventDetailAddressLine1);
		}

		if (eventDetailAddressLine2 == null) {
			eventDetailImpl.setEventDetailAddressLine2(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setEventDetailAddressLine2(eventDetailAddressLine2);
		}

		if (eventDetailInfocity == null) {
			eventDetailImpl.setEventDetailInfocity(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setEventDetailInfocity(eventDetailInfocity);
		}

		if (eventDetailZip == null) {
			eventDetailImpl.setEventDetailZip(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setEventDetailZip(eventDetailZip);
		}

		if (eventDetailState == null) {
			eventDetailImpl.setEventDetailState(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setEventDetailState(eventDetailState);
		}

		if (eventDetailCountry == null) {
			eventDetailImpl.setEventDetailCountry(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setEventDetailCountry(eventDetailCountry);
		}

		if (eventDetailLatitude == null) {
			eventDetailImpl.setEventDetailLatitude(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setEventDetailLatitude(eventDetailLatitude);
		}

		if (eventDetailLongitude == null) {
			eventDetailImpl.setEventDetailLongitude(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setEventDetailLongitude(eventDetailLongitude);
		}

		if (eventDetailPhone == null) {
			eventDetailImpl.setEventDetailPhone(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setEventDetailPhone(eventDetailPhone);
		}

		if (eventDetailWebsite == null) {
			eventDetailImpl.setEventDetailWebsite(StringPool.BLANK);
		}
		else {
			eventDetailImpl.setEventDetailWebsite(eventDetailWebsite);
		}

		eventDetailImpl.setEventDetailCost(eventDetailCost);

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
		infoTypeCategoryId = objectInput.readLong();
		eventDetailInfoName = objectInput.readUTF();
		eventDetailInfoDesc = objectInput.readUTF();
		eventDetailInfoComment = objectInput.readUTF();
		eventDetailAddressLine1 = objectInput.readUTF();
		eventDetailAddressLine2 = objectInput.readUTF();
		eventDetailInfocity = objectInput.readUTF();
		eventDetailZip = objectInput.readUTF();
		eventDetailState = objectInput.readUTF();
		eventDetailCountry = objectInput.readUTF();
		eventDetailLatitude = objectInput.readUTF();
		eventDetailLongitude = objectInput.readUTF();
		eventDetailPhone = objectInput.readUTF();
		eventDetailWebsite = objectInput.readUTF();
		eventDetailCost = objectInput.readDouble();
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
		objectOutput.writeLong(infoTypeCategoryId);

		if (eventDetailInfoName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventDetailInfoName);
		}

		if (eventDetailInfoDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventDetailInfoDesc);
		}

		if (eventDetailInfoComment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventDetailInfoComment);
		}

		if (eventDetailAddressLine1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventDetailAddressLine1);
		}

		if (eventDetailAddressLine2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventDetailAddressLine2);
		}

		if (eventDetailInfocity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventDetailInfocity);
		}

		if (eventDetailZip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventDetailZip);
		}

		if (eventDetailState == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventDetailState);
		}

		if (eventDetailCountry == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventDetailCountry);
		}

		if (eventDetailLatitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventDetailLatitude);
		}

		if (eventDetailLongitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventDetailLongitude);
		}

		if (eventDetailPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventDetailPhone);
		}

		if (eventDetailWebsite == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventDetailWebsite);
		}

		objectOutput.writeDouble(eventDetailCost);

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
	public long infoTypeCategoryId;
	public String eventDetailInfoName;
	public String eventDetailInfoDesc;
	public String eventDetailInfoComment;
	public String eventDetailAddressLine1;
	public String eventDetailAddressLine2;
	public String eventDetailInfocity;
	public String eventDetailZip;
	public String eventDetailState;
	public String eventDetailCountry;
	public String eventDetailLatitude;
	public String eventDetailLongitude;
	public String eventDetailPhone;
	public String eventDetailWebsite;
	public double eventDetailCost;
	public String hoursOfOperation;
}