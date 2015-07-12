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

import com.rumbasolutions.flask.model.FlaskAdmin;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FlaskAdmin in entity cache.
 *
 * @author Ashutosh Rai
 * @see FlaskAdmin
 * @generated
 */
public class FlaskAdminCacheModel implements CacheModel<FlaskAdmin>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", roleName=");
		sb.append(roleName);
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
		sb.append(", stateId=");
		sb.append(stateId);
		sb.append(", stateName=");
		sb.append(stateName);
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", countryName=");
		sb.append(countryName);
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
	public FlaskAdmin toEntityModel() {
		FlaskAdminImpl flaskAdminImpl = new FlaskAdminImpl();

		flaskAdminImpl.setUserId(userId);
		flaskAdminImpl.setRoleId(roleId);

		if (roleName == null) {
			flaskAdminImpl.setRoleName(StringPool.BLANK);
		}
		else {
			flaskAdminImpl.setRoleName(roleName);
		}

		if (firstName == null) {
			flaskAdminImpl.setFirstName(StringPool.BLANK);
		}
		else {
			flaskAdminImpl.setFirstName(firstName);
		}

		if (middleName == null) {
			flaskAdminImpl.setMiddleName(StringPool.BLANK);
		}
		else {
			flaskAdminImpl.setMiddleName(middleName);
		}

		if (lastName == null) {
			flaskAdminImpl.setLastName(StringPool.BLANK);
		}
		else {
			flaskAdminImpl.setLastName(lastName);
		}

		if (screenName == null) {
			flaskAdminImpl.setScreenName(StringPool.BLANK);
		}
		else {
			flaskAdminImpl.setScreenName(screenName);
		}

		if (email == null) {
			flaskAdminImpl.setEmail(StringPool.BLANK);
		}
		else {
			flaskAdminImpl.setEmail(email);
		}

		if (DOB == Long.MIN_VALUE) {
			flaskAdminImpl.setDOB(null);
		}
		else {
			flaskAdminImpl.setDOB(new Date(DOB));
		}

		flaskAdminImpl.setIsMale(isMale);

		if (streetName == null) {
			flaskAdminImpl.setStreetName(StringPool.BLANK);
		}
		else {
			flaskAdminImpl.setStreetName(streetName);
		}

		if (aptNo == null) {
			flaskAdminImpl.setAptNo(StringPool.BLANK);
		}
		else {
			flaskAdminImpl.setAptNo(aptNo);
		}

		if (areaCode == null) {
			flaskAdminImpl.setAreaCode(StringPool.BLANK);
		}
		else {
			flaskAdminImpl.setAreaCode(areaCode);
		}

		if (city == null) {
			flaskAdminImpl.setCity(StringPool.BLANK);
		}
		else {
			flaskAdminImpl.setCity(city);
		}

		flaskAdminImpl.setStateId(stateId);

		if (stateName == null) {
			flaskAdminImpl.setStateName(StringPool.BLANK);
		}
		else {
			flaskAdminImpl.setStateName(stateName);
		}

		flaskAdminImpl.setCountryId(countryId);

		if (countryName == null) {
			flaskAdminImpl.setCountryName(StringPool.BLANK);
		}
		else {
			flaskAdminImpl.setCountryName(countryName);
		}

		if (mobileNumber == null) {
			flaskAdminImpl.setMobileNumber(StringPool.BLANK);
		}
		else {
			flaskAdminImpl.setMobileNumber(mobileNumber);
		}

		if (portraitURL == null) {
			flaskAdminImpl.setPortraitURL(StringPool.BLANK);
		}
		else {
			flaskAdminImpl.setPortraitURL(portraitURL);
		}

		if (userInterests == null) {
			flaskAdminImpl.setUserInterests(StringPool.BLANK);
		}
		else {
			flaskAdminImpl.setUserInterests(userInterests);
		}

		flaskAdminImpl.resetOriginalValues();

		return flaskAdminImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		roleId = objectInput.readLong();
		roleName = objectInput.readUTF();
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
		stateId = objectInput.readLong();
		stateName = objectInput.readUTF();
		countryId = objectInput.readLong();
		countryName = objectInput.readUTF();
		mobileNumber = objectInput.readUTF();
		portraitURL = objectInput.readUTF();
		userInterests = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);
		objectOutput.writeLong(roleId);

		if (roleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(roleName);
		}

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
	public String roleName;
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
	public long stateId;
	public String stateName;
	public long countryId;
	public String countryName;
	public String mobileNumber;
	public String portraitURL;
	public String userInterests;
}