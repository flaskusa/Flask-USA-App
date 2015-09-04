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

import com.rumbasolutions.flask.model.TailgateUsers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TailgateUsers in entity cache.
 *
 * @author rajeshj
 * @see TailgateUsers
 * @generated
 */
public class TailgateUsersCacheModel implements CacheModel<TailgateUsers>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{tailgateUserId=");
		sb.append(tailgateUserId);
		sb.append(", tailgateId=");
		sb.append(tailgateId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", isAdmin=");
		sb.append(isAdmin);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", isPaid=");
		sb.append(isPaid);
		sb.append(", paymentMode=");
		sb.append(paymentMode);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TailgateUsers toEntityModel() {
		TailgateUsersImpl tailgateUsersImpl = new TailgateUsersImpl();

		tailgateUsersImpl.setTailgateUserId(tailgateUserId);
		tailgateUsersImpl.setTailgateId(tailgateId);
		tailgateUsersImpl.setUserId(userId);

		if (userName == null) {
			tailgateUsersImpl.setUserName(StringPool.BLANK);
		}
		else {
			tailgateUsersImpl.setUserName(userName);
		}

		tailgateUsersImpl.setIsAdmin(isAdmin);
		tailgateUsersImpl.setGroupId(groupId);

		if (emailAddress == null) {
			tailgateUsersImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			tailgateUsersImpl.setEmailAddress(emailAddress);
		}

		tailgateUsersImpl.setIsPaid(isPaid);

		if (paymentMode == null) {
			tailgateUsersImpl.setPaymentMode(StringPool.BLANK);
		}
		else {
			tailgateUsersImpl.setPaymentMode(paymentMode);
		}

		if (description == null) {
			tailgateUsersImpl.setDescription(StringPool.BLANK);
		}
		else {
			tailgateUsersImpl.setDescription(description);
		}

		tailgateUsersImpl.resetOriginalValues();

		return tailgateUsersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tailgateUserId = objectInput.readLong();
		tailgateId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		isAdmin = objectInput.readInt();
		groupId = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		isPaid = objectInput.readBoolean();
		paymentMode = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tailgateUserId);
		objectOutput.writeLong(tailgateId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeInt(isAdmin);
		objectOutput.writeLong(groupId);

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		objectOutput.writeBoolean(isPaid);

		if (paymentMode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(paymentMode);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long tailgateUserId;
	public long tailgateId;
	public long userId;
	public String userName;
	public int isAdmin;
	public long groupId;
	public String emailAddress;
	public boolean isPaid;
	public String paymentMode;
	public String description;
}