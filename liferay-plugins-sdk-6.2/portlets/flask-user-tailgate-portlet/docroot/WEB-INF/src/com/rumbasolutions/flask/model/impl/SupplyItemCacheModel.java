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

import com.rumbasolutions.flask.model.SupplyItem;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SupplyItem in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SupplyItem
 * @generated
 */
public class SupplyItemCacheModel implements CacheModel<SupplyItem>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{supplyItemId=");
		sb.append(supplyItemId);
		sb.append(", supplyItemName=");
		sb.append(supplyItemName);
		sb.append(", supplyListId=");
		sb.append(supplyListId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SupplyItem toEntityModel() {
		SupplyItemImpl supplyItemImpl = new SupplyItemImpl();

		supplyItemImpl.setSupplyItemId(supplyItemId);

		if (supplyItemName == null) {
			supplyItemImpl.setSupplyItemName(StringPool.BLANK);
		}
		else {
			supplyItemImpl.setSupplyItemName(supplyItemName);
		}

		supplyItemImpl.setSupplyListId(supplyListId);

		if (createdDate == Long.MIN_VALUE) {
			supplyItemImpl.setCreatedDate(null);
		}
		else {
			supplyItemImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			supplyItemImpl.setModifiedDate(null);
		}
		else {
			supplyItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		supplyItemImpl.resetOriginalValues();

		return supplyItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		supplyItemId = objectInput.readLong();
		supplyItemName = objectInput.readUTF();
		supplyListId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(supplyItemId);

		if (supplyItemName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(supplyItemName);
		}

		objectOutput.writeLong(supplyListId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long supplyItemId;
	public String supplyItemName;
	public long supplyListId;
	public long createdDate;
	public long modifiedDate;
}