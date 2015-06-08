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
		StringBundler sb = new StringBundler(45);

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
		sb.append(", infoTypeCategoryId=");
		sb.append(infoTypeCategoryId);
		sb.append(", venueDetailInfoName=");
		sb.append(venueDetailInfoName);
		sb.append(", venueDetailInfoDesc=");
		sb.append(venueDetailInfoDesc);
		sb.append(", venueDetailInfoComment=");
		sb.append(venueDetailInfoComment);
		sb.append(", venueDetailAddressLine1=");
		sb.append(venueDetailAddressLine1);
		sb.append(", venueDetailAddressLine2=");
		sb.append(venueDetailAddressLine2);
		sb.append(", venueDetailCity=");
		sb.append(venueDetailCity);
		sb.append(", venueDetailState=");
		sb.append(venueDetailState);
		sb.append(", venueDetailCountry=");
		sb.append(venueDetailCountry);
		sb.append(", venueDetailLatitude=");
		sb.append(venueDetailLatitude);
		sb.append(", venueDetailLongitude=");
		sb.append(venueDetailLongitude);
		sb.append(", venueDetailPhone=");
		sb.append(venueDetailPhone);
		sb.append(", venueDetailWebsite=");
		sb.append(venueDetailWebsite);
		sb.append(", venueDetailCost=");
		sb.append(venueDetailCost);
		sb.append(", venueDetailhoursOfOperation=");
		sb.append(venueDetailhoursOfOperation);
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
		venueDetailImpl.setInfoTypeCategoryId(infoTypeCategoryId);

		if (venueDetailInfoName == null) {
			venueDetailImpl.setVenueDetailInfoName(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setVenueDetailInfoName(venueDetailInfoName);
		}

		if (venueDetailInfoDesc == null) {
			venueDetailImpl.setVenueDetailInfoDesc(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setVenueDetailInfoDesc(venueDetailInfoDesc);
		}

		if (venueDetailInfoComment == null) {
			venueDetailImpl.setVenueDetailInfoComment(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setVenueDetailInfoComment(venueDetailInfoComment);
		}

		if (venueDetailAddressLine1 == null) {
			venueDetailImpl.setVenueDetailAddressLine1(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setVenueDetailAddressLine1(venueDetailAddressLine1);
		}

		if (venueDetailAddressLine2 == null) {
			venueDetailImpl.setVenueDetailAddressLine2(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setVenueDetailAddressLine2(venueDetailAddressLine2);
		}

		if (venueDetailCity == null) {
			venueDetailImpl.setVenueDetailCity(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setVenueDetailCity(venueDetailCity);
		}

		if (venueDetailState == null) {
			venueDetailImpl.setVenueDetailState(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setVenueDetailState(venueDetailState);
		}

		if (venueDetailCountry == null) {
			venueDetailImpl.setVenueDetailCountry(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setVenueDetailCountry(venueDetailCountry);
		}

		if (venueDetailLatitude == null) {
			venueDetailImpl.setVenueDetailLatitude(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setVenueDetailLatitude(venueDetailLatitude);
		}

		if (venueDetailLongitude == null) {
			venueDetailImpl.setVenueDetailLongitude(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setVenueDetailLongitude(venueDetailLongitude);
		}

		if (venueDetailPhone == null) {
			venueDetailImpl.setVenueDetailPhone(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setVenueDetailPhone(venueDetailPhone);
		}

		if (venueDetailWebsite == null) {
			venueDetailImpl.setVenueDetailWebsite(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setVenueDetailWebsite(venueDetailWebsite);
		}

		venueDetailImpl.setVenueDetailCost(venueDetailCost);

		if (venueDetailhoursOfOperation == null) {
			venueDetailImpl.setVenueDetailhoursOfOperation(StringPool.BLANK);
		}
		else {
			venueDetailImpl.setVenueDetailhoursOfOperation(venueDetailhoursOfOperation);
		}

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
		infoTypeCategoryId = objectInput.readLong();
		venueDetailInfoName = objectInput.readUTF();
		venueDetailInfoDesc = objectInput.readUTF();
		venueDetailInfoComment = objectInput.readUTF();
		venueDetailAddressLine1 = objectInput.readUTF();
		venueDetailAddressLine2 = objectInput.readUTF();
		venueDetailCity = objectInput.readUTF();
		venueDetailState = objectInput.readUTF();
		venueDetailCountry = objectInput.readUTF();
		venueDetailLatitude = objectInput.readUTF();
		venueDetailLongitude = objectInput.readUTF();
		venueDetailPhone = objectInput.readUTF();
		venueDetailWebsite = objectInput.readUTF();
		venueDetailCost = objectInput.readDouble();
		venueDetailhoursOfOperation = objectInput.readUTF();
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
		objectOutput.writeLong(infoTypeCategoryId);

		if (venueDetailInfoName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueDetailInfoName);
		}

		if (venueDetailInfoDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueDetailInfoDesc);
		}

		if (venueDetailInfoComment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueDetailInfoComment);
		}

		if (venueDetailAddressLine1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueDetailAddressLine1);
		}

		if (venueDetailAddressLine2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueDetailAddressLine2);
		}

		if (venueDetailCity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueDetailCity);
		}

		if (venueDetailState == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueDetailState);
		}

		if (venueDetailCountry == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueDetailCountry);
		}

		if (venueDetailLatitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueDetailLatitude);
		}

		if (venueDetailLongitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueDetailLongitude);
		}

		if (venueDetailPhone == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueDetailPhone);
		}

		if (venueDetailWebsite == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueDetailWebsite);
		}

		objectOutput.writeDouble(venueDetailCost);

		if (venueDetailhoursOfOperation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueDetailhoursOfOperation);
		}
	}

	public long venueDetailId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public long venueId;
	public long infoTypeId;
	public long infoTypeCategoryId;
	public String venueDetailInfoName;
	public String venueDetailInfoDesc;
	public String venueDetailInfoComment;
	public String venueDetailAddressLine1;
	public String venueDetailAddressLine2;
	public String venueDetailCity;
	public String venueDetailState;
	public String venueDetailCountry;
	public String venueDetailLatitude;
	public String venueDetailLongitude;
	public String venueDetailPhone;
	public String venueDetailWebsite;
	public double venueDetailCost;
	public String venueDetailhoursOfOperation;
}