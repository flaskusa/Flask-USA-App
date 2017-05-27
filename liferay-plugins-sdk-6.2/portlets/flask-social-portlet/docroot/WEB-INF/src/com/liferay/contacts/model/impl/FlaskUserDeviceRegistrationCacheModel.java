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

package com.liferay.contacts.model.impl;

import com.liferay.contacts.model.FlaskUserDeviceRegistration;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FlaskUserDeviceRegistration in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskUserDeviceRegistration
 * @generated
 */
public class FlaskUserDeviceRegistrationCacheModel implements CacheModel<FlaskUserDeviceRegistration>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{userDeviceRegistrationId=");
		sb.append(userDeviceRegistrationId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userEmail=");
		sb.append(userEmail);
		sb.append(", devicePlatform=");
		sb.append(devicePlatform);
		sb.append(", deviceDetails=");
		sb.append(deviceDetails);
		sb.append(", deviceToken=");
		sb.append(deviceToken);
		sb.append(", registrationTime=");
		sb.append(registrationTime);
		sb.append(", active=");
		sb.append(active);
		sb.append(", lastNotificationTime=");
		sb.append(lastNotificationTime);
		sb.append(", lastNotificationMsg=");
		sb.append(lastNotificationMsg);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FlaskUserDeviceRegistration toEntityModel() {
		FlaskUserDeviceRegistrationImpl flaskUserDeviceRegistrationImpl = new FlaskUserDeviceRegistrationImpl();

		flaskUserDeviceRegistrationImpl.setUserDeviceRegistrationId(userDeviceRegistrationId);
		flaskUserDeviceRegistrationImpl.setUserId(userId);

		if (userEmail == null) {
			flaskUserDeviceRegistrationImpl.setUserEmail(StringPool.BLANK);
		}
		else {
			flaskUserDeviceRegistrationImpl.setUserEmail(userEmail);
		}

		if (devicePlatform == null) {
			flaskUserDeviceRegistrationImpl.setDevicePlatform(StringPool.BLANK);
		}
		else {
			flaskUserDeviceRegistrationImpl.setDevicePlatform(devicePlatform);
		}

		if (deviceDetails == null) {
			flaskUserDeviceRegistrationImpl.setDeviceDetails(StringPool.BLANK);
		}
		else {
			flaskUserDeviceRegistrationImpl.setDeviceDetails(deviceDetails);
		}

		if (deviceToken == null) {
			flaskUserDeviceRegistrationImpl.setDeviceToken(StringPool.BLANK);
		}
		else {
			flaskUserDeviceRegistrationImpl.setDeviceToken(deviceToken);
		}

		if (registrationTime == Long.MIN_VALUE) {
			flaskUserDeviceRegistrationImpl.setRegistrationTime(null);
		}
		else {
			flaskUserDeviceRegistrationImpl.setRegistrationTime(new Date(
					registrationTime));
		}

		flaskUserDeviceRegistrationImpl.setActive(active);

		if (lastNotificationTime == Long.MIN_VALUE) {
			flaskUserDeviceRegistrationImpl.setLastNotificationTime(null);
		}
		else {
			flaskUserDeviceRegistrationImpl.setLastNotificationTime(new Date(
					lastNotificationTime));
		}

		if (lastNotificationMsg == null) {
			flaskUserDeviceRegistrationImpl.setLastNotificationMsg(StringPool.BLANK);
		}
		else {
			flaskUserDeviceRegistrationImpl.setLastNotificationMsg(lastNotificationMsg);
		}

		flaskUserDeviceRegistrationImpl.resetOriginalValues();

		return flaskUserDeviceRegistrationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userDeviceRegistrationId = objectInput.readLong();
		userId = objectInput.readLong();
		userEmail = objectInput.readUTF();
		devicePlatform = objectInput.readUTF();
		deviceDetails = objectInput.readUTF();
		deviceToken = objectInput.readUTF();
		registrationTime = objectInput.readLong();
		active = objectInput.readBoolean();
		lastNotificationTime = objectInput.readLong();
		lastNotificationMsg = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userDeviceRegistrationId);
		objectOutput.writeLong(userId);

		if (userEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userEmail);
		}

		if (devicePlatform == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(devicePlatform);
		}

		if (deviceDetails == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(deviceDetails);
		}

		if (deviceToken == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(deviceToken);
		}

		objectOutput.writeLong(registrationTime);
		objectOutput.writeBoolean(active);
		objectOutput.writeLong(lastNotificationTime);

		if (lastNotificationMsg == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastNotificationMsg);
		}
	}

	public long userDeviceRegistrationId;
	public long userId;
	public String userEmail;
	public String devicePlatform;
	public String deviceDetails;
	public String deviceToken;
	public long registrationTime;
	public boolean active;
	public long lastNotificationTime;
	public String lastNotificationMsg;
}