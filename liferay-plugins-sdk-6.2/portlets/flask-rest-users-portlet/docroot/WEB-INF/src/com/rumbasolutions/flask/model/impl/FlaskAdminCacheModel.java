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
		StringBundler sb = new StringBundler(17);

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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FlaskAdmin toEntityModel() {
		FlaskAdminImpl flaskAdminImpl = new FlaskAdminImpl();

		flaskAdminImpl.setUserId(userId);
		flaskAdminImpl.setRoleId(roleId);

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

		flaskAdminImpl.resetOriginalValues();

		return flaskAdminImpl;
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
	}

	public long userId;
	public long roleId;
	public String firstName;
	public String middleName;
	public String lastName;
	public String screenName;
	public String email;
	public long DOB;
}