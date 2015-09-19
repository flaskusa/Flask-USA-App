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

import com.rumbasolutions.flask.model.TailgateInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TailgateInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TailgateInfo
 * @generated
 */
public class TailgateInfoCacheModel implements CacheModel<TailgateInfo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{tailgateId=");
		sb.append(tailgateId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", tailgateName=");
		sb.append(tailgateName);
		sb.append(", tailgateDescription=");
		sb.append(tailgateDescription);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", eventName=");
		sb.append(eventName);
		sb.append(", tailgateDate=");
		sb.append(tailgateDate);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append(", isDelete=");
		sb.append(isDelete);
		sb.append(", venmoAccountId=");
		sb.append(venmoAccountId);
		sb.append(", amountToPay=");
		sb.append(amountToPay);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TailgateInfo toEntityModel() {
		TailgateInfoImpl tailgateInfoImpl = new TailgateInfoImpl();

		tailgateInfoImpl.setTailgateId(tailgateId);
		tailgateInfoImpl.setCompanyId(companyId);
		tailgateInfoImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			tailgateInfoImpl.setCreatedDate(null);
		}
		else {
			tailgateInfoImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tailgateInfoImpl.setModifiedDate(null);
		}
		else {
			tailgateInfoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (tailgateName == null) {
			tailgateInfoImpl.setTailgateName(StringPool.BLANK);
		}
		else {
			tailgateInfoImpl.setTailgateName(tailgateName);
		}

		if (tailgateDescription == null) {
			tailgateInfoImpl.setTailgateDescription(StringPool.BLANK);
		}
		else {
			tailgateInfoImpl.setTailgateDescription(tailgateDescription);
		}

		tailgateInfoImpl.setEventId(eventId);

		if (eventName == null) {
			tailgateInfoImpl.setEventName(StringPool.BLANK);
		}
		else {
			tailgateInfoImpl.setEventName(eventName);
		}

		if (tailgateDate == Long.MIN_VALUE) {
			tailgateInfoImpl.setTailgateDate(null);
		}
		else {
			tailgateInfoImpl.setTailgateDate(new Date(tailgateDate));
		}

		tailgateInfoImpl.setStartTime(startTime);
		tailgateInfoImpl.setEndTime(endTime);
		tailgateInfoImpl.setIsActive(isActive);
		tailgateInfoImpl.setIsDelete(isDelete);

		if (venmoAccountId == null) {
			tailgateInfoImpl.setVenmoAccountId(StringPool.BLANK);
		}
		else {
			tailgateInfoImpl.setVenmoAccountId(venmoAccountId);
		}

		tailgateInfoImpl.setAmountToPay(amountToPay);

		tailgateInfoImpl.resetOriginalValues();

		return tailgateInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tailgateId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		tailgateName = objectInput.readUTF();
		tailgateDescription = objectInput.readUTF();
		eventId = objectInput.readLong();
		eventName = objectInput.readUTF();
		tailgateDate = objectInput.readLong();
		startTime = objectInput.readLong();
		endTime = objectInput.readLong();
		isActive = objectInput.readInt();
		isDelete = objectInput.readInt();
		venmoAccountId = objectInput.readUTF();
		amountToPay = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tailgateId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		if (tailgateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tailgateName);
		}

		if (tailgateDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tailgateDescription);
		}

		objectOutput.writeLong(eventId);

		if (eventName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventName);
		}

		objectOutput.writeLong(tailgateDate);
		objectOutput.writeLong(startTime);
		objectOutput.writeLong(endTime);
		objectOutput.writeInt(isActive);
		objectOutput.writeInt(isDelete);

		if (venmoAccountId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venmoAccountId);
		}

		objectOutput.writeDouble(amountToPay);
	}

	public long tailgateId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public String tailgateName;
	public String tailgateDescription;
	public long eventId;
	public String eventName;
	public long tailgateDate;
	public long startTime;
	public long endTime;
	public int isActive;
	public int isDelete;
	public String venmoAccountId;
	public double amountToPay;
}