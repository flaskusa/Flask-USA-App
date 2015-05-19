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

import com.rumbasolutions.flask.model.FlaskUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FlaskUser in entity cache.
 *
 * @author Ashutosh Rai
 * @see FlaskUser
 * @generated
 */
public class FlaskUserCacheModel implements CacheModel<FlaskUser>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", middleName=");
		sb.append(middleName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", screenName=");
		sb.append(screenName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", DOB=");
		sb.append(DOB);
		sb.append(", isMale=");
		sb.append(isMale);
		sb.append(", streetName=");
		sb.append(streetName);
		sb.append(", aptNo=");
		sb.append(aptNo);
		sb.append(", areaCode=");
		sb.append(areaCode);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", country=");
		sb.append(country);
		sb.append(", mobileNumber=");
		sb.append(mobileNumber);
		sb.append(", portraitURL=");
		sb.append(portraitURL);
		sb.append(", userInterests=");
		sb.append(userInterests);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FlaskUser toEntityModel() {
		FlaskUserImpl flaskUserImpl = new FlaskUserImpl();

		flaskUserImpl.setUserId(userId);
		flaskUserImpl.setRoleId(roleId);

		if (firstName == null) {
			flaskUserImpl.setFirstName(StringPool.BLANK);
		}
		else {
			flaskUserImpl.setFirstName(firstName);
		}

		if (middleName == null) {
			flaskUserImpl.setMiddleName(StringPool.BLANK);
		}
		else {
			flaskUserImpl.setMiddleName(middleName);
		}

		if (lastName == null) {
			flaskUserImpl.setLastName(StringPool.BLANK);
		}
		else {
			flaskUserImpl.setLastName(lastName);
		}

		if (screenName == null) {
			flaskUserImpl.setScreenName(StringPool.BLANK);
		}
		else {
			flaskUserImpl.setScreenName(screenName);
		}

		if (email == null) {
			flaskUserImpl.setEmail(StringPool.BLANK);
		}
		else {
			flaskUserImpl.setEmail(email);
		}

		if (DOB == Long.MIN_VALUE) {
			flaskUserImpl.setDOB(null);
		}
		else {
			flaskUserImpl.setDOB(new Date(DOB));
		}

		flaskUserImpl.setIsMale(isMale);

		if (streetName == null) {
			flaskUserImpl.setStreetName(StringPool.BLANK);
		}
		else {
			flaskUserImpl.setStreetName(streetName);
		}

		if (aptNo == null) {
			flaskUserImpl.setAptNo(StringPool.BLANK);
		}
		else {
			flaskUserImpl.setAptNo(aptNo);
		}

		if (areaCode == null) {
			flaskUserImpl.setAreaCode(StringPool.BLANK);
		}
		else {
			flaskUserImpl.setAreaCode(areaCode);
		}

		if (city == null) {
			flaskUserImpl.setCity(StringPool.BLANK);
		}
		else {
			flaskUserImpl.setCity(city);
		}

		if (state == null) {
			flaskUserImpl.setState(StringPool.BLANK);
		}
		else {
			flaskUserImpl.setState(state);
		}

		if (country == null) {
			flaskUserImpl.setCountry(StringPool.BLANK);
		}
		else {
			flaskUserImpl.setCountry(country);
		}

		if (mobileNumber == null) {
			flaskUserImpl.setMobileNumber(StringPool.BLANK);
		}
		else {
			flaskUserImpl.setMobileNumber(mobileNumber);
		}

		if (portraitURL == null) {
			flaskUserImpl.setPortraitURL(StringPool.BLANK);
		}
		else {
			flaskUserImpl.setPortraitURL(portraitURL);
		}

		if (userInterests == null) {
			flaskUserImpl.setUserInterests(StringPool.BLANK);
		}
		else {
			flaskUserImpl.setUserInterests(userInterests);
		}

		flaskUserImpl.resetOriginalValues();

		return flaskUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		roleId = objectInput.readLong();
		firstName = objectInput.readUTF();
		middleName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		screenName = objectInput.readUTF();
		email = objectInput.readUTF();
		DOB = objectInput.readLong();
		isMale = objectInput.readBoolean();
		streetName = objectInput.readUTF();
		aptNo = objectInput.readUTF();
		areaCode = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		country = objectInput.readUTF();
		mobileNumber = objectInput.readUTF();
		portraitURL = objectInput.readUTF();
		userInterests = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);
		objectOutput.writeLong(roleId);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (middleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(middleName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (screenName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(screenName);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(DOB);
		objectOutput.writeBoolean(isMale);

		if (streetName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(streetName);
		}

		if (aptNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(aptNo);
		}

		if (areaCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(areaCode);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (mobileNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mobileNumber);
		}

		if (portraitURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portraitURL);
		}

		if (userInterests == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userInterests);
		}
	}

	public long userId;
	public long roleId;
	public String firstName;
	public String middleName;
	public String lastName;
	public String screenName;
	public String email;
	public long DOB;
	public Boolean isMale;
	public String streetName;
	public String aptNo;
	public String areaCode;
	public String city;
	public String state;
	public String country;
	public String mobileNumber;
	public String portraitURL;
	public String userInterests;
}