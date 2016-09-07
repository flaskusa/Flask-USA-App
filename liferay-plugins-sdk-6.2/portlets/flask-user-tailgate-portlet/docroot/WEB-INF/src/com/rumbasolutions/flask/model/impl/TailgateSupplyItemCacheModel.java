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

import com.rumbasolutions.flask.model.TailgateSupplyItem;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TailgateSupplyItem in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TailgateSupplyItem
 * @generated
 */
public class TailgateSupplyItemCacheModel implements CacheModel<TailgateSupplyItem>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{tailgateSupplyItemId=");
		sb.append(tailgateSupplyItemId);
		sb.append(", supplyListItemName=");
		sb.append(supplyListItemName);
		sb.append(", tailgateId=");
		sb.append(tailgateId);
		sb.append(", itemAssignedUserId=");
		sb.append(itemAssignedUserId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TailgateSupplyItem toEntityModel() {
		TailgateSupplyItemImpl tailgateSupplyItemImpl = new TailgateSupplyItemImpl();

		tailgateSupplyItemImpl.setTailgateSupplyItemId(tailgateSupplyItemId);

		if (supplyListItemName == null) {
			tailgateSupplyItemImpl.setSupplyListItemName(StringPool.BLANK);
		}
		else {
			tailgateSupplyItemImpl.setSupplyListItemName(supplyListItemName);
		}

		tailgateSupplyItemImpl.setTailgateId(tailgateId);
		tailgateSupplyItemImpl.setItemAssignedUserId(itemAssignedUserId);
		tailgateSupplyItemImpl.setCompanyId(companyId);
		tailgateSupplyItemImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			tailgateSupplyItemImpl.setCreatedDate(null);
		}
		else {
			tailgateSupplyItemImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tailgateSupplyItemImpl.setModifiedDate(null);
		}
		else {
			tailgateSupplyItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		tailgateSupplyItemImpl.resetOriginalValues();

		return tailgateSupplyItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tailgateSupplyItemId = objectInput.readLong();
		supplyListItemName = objectInput.readUTF();
		tailgateId = objectInput.readLong();
		itemAssignedUserId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tailgateSupplyItemId);

		if (supplyListItemName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(supplyListItemName);
		}

		objectOutput.writeLong(tailgateId);
		objectOutput.writeLong(itemAssignedUserId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long tailgateSupplyItemId;
	public String supplyListItemName;
	public long tailgateId;
	public long itemAssignedUserId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
}