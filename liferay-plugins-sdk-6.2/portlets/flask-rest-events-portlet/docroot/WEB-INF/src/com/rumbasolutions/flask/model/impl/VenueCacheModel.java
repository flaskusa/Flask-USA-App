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

import com.rumbasolutions.flask.model.Venue;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Venue in entity cache.
 *
 * @author Ashutosh Rai
 * @see Venue
 * @generated
 */
public class VenueCacheModel implements CacheModel<Venue>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{venueId=");
		sb.append(venueId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", venueName=");
		sb.append(venueName);
		sb.append(", venueDescription=");
		sb.append(venueDescription);
		sb.append(", venueZipCode=");
		sb.append(venueZipCode);
		sb.append(", addrLine1=");
		sb.append(addrLine1);
		sb.append(", addrLine2=");
		sb.append(addrLine2);
		sb.append(", venueCity=");
		sb.append(venueCity);
		sb.append(", venueStateId=");
		sb.append(venueStateId);
		sb.append(", venueStateName=");
		sb.append(venueStateName);
		sb.append(", venueCountryId=");
		sb.append(venueCountryId);
		sb.append(", venueCountryName=");
		sb.append(venueCountryName);
		sb.append(", venueMetroArea=");
		sb.append(venueMetroArea);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Venue toEntityModel() {
		VenueImpl venueImpl = new VenueImpl();

		venueImpl.setVenueId(venueId);
		venueImpl.setCompanyId(companyId);
		venueImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			venueImpl.setCreatedDate(null);
		}
		else {
			venueImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			venueImpl.setModifiedDate(null);
		}
		else {
			venueImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (venueName == null) {
			venueImpl.setVenueName(StringPool.BLANK);
		}
		else {
			venueImpl.setVenueName(venueName);
		}

		if (venueDescription == null) {
			venueImpl.setVenueDescription(StringPool.BLANK);
		}
		else {
			venueImpl.setVenueDescription(venueDescription);
		}

		if (venueZipCode == null) {
			venueImpl.setVenueZipCode(StringPool.BLANK);
		}
		else {
			venueImpl.setVenueZipCode(venueZipCode);
		}

		if (addrLine1 == null) {
			venueImpl.setAddrLine1(StringPool.BLANK);
		}
		else {
			venueImpl.setAddrLine1(addrLine1);
		}

		if (addrLine2 == null) {
			venueImpl.setAddrLine2(StringPool.BLANK);
		}
		else {
			venueImpl.setAddrLine2(addrLine2);
		}

		if (venueCity == null) {
			venueImpl.setVenueCity(StringPool.BLANK);
		}
		else {
			venueImpl.setVenueCity(venueCity);
		}

		venueImpl.setVenueStateId(venueStateId);

		if (venueStateName == null) {
			venueImpl.setVenueStateName(StringPool.BLANK);
		}
		else {
			venueImpl.setVenueStateName(venueStateName);
		}

		venueImpl.setVenueCountryId(venueCountryId);

		if (venueCountryName == null) {
			venueImpl.setVenueCountryName(StringPool.BLANK);
		}
		else {
			venueImpl.setVenueCountryName(venueCountryName);
		}

		if (venueMetroArea == null) {
			venueImpl.setVenueMetroArea(StringPool.BLANK);
		}
		else {
			venueImpl.setVenueMetroArea(venueMetroArea);
		}

		if (longitude == null) {
			venueImpl.setLongitude(StringPool.BLANK);
		}
		else {
			venueImpl.setLongitude(longitude);
		}

		if (latitude == null) {
			venueImpl.setLatitude(StringPool.BLANK);
		}
		else {
			venueImpl.setLatitude(latitude);
		}

		venueImpl.resetOriginalValues();

		return venueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		venueId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		venueName = objectInput.readUTF();
		venueDescription = objectInput.readUTF();
		venueZipCode = objectInput.readUTF();
		addrLine1 = objectInput.readUTF();
		addrLine2 = objectInput.readUTF();
		venueCity = objectInput.readUTF();
		venueStateId = objectInput.readLong();
		venueStateName = objectInput.readUTF();
		venueCountryId = objectInput.readLong();
		venueCountryName = objectInput.readUTF();
		venueMetroArea = objectInput.readUTF();
		longitude = objectInput.readUTF();
		latitude = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(venueId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		if (venueName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueName);
		}

		if (venueDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueDescription);
		}

		if (venueZipCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueZipCode);
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

		if (venueCity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueCity);
		}

		objectOutput.writeLong(venueStateId);

		if (venueStateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueStateName);
		}

		objectOutput.writeLong(venueCountryId);

		if (venueCountryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueCountryName);
		}

		if (venueMetroArea == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueMetroArea);
		}

		if (longitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(longitude);
		}

		if (latitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(latitude);
		}
	}

	public long venueId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public String venueName;
	public String venueDescription;
	public String venueZipCode;
	public String addrLine1;
	public String addrLine2;
	public String venueCity;
	public long venueStateId;
	public String venueStateName;
	public long venueCountryId;
	public String venueCountryName;
	public String venueMetroArea;
	public String longitude;
	public String latitude;
}