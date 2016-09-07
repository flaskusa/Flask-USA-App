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

import com.rumbasolutions.flask.model.SupplyList;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SupplyList in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SupplyList
 * @generated
 */
public class SupplyListCacheModel implements CacheModel<SupplyList>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{supplyListId=");
		sb.append(supplyListId);
		sb.append(", supplyListName=");
		sb.append(supplyListName);
		sb.append(", isSystem=");
		sb.append(isSystem);
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
	public SupplyList toEntityModel() {
		SupplyListImpl supplyListImpl = new SupplyListImpl();

		supplyListImpl.setSupplyListId(supplyListId);

		if (supplyListName == null) {
			supplyListImpl.setSupplyListName(StringPool.BLANK);
		}
		else {
			supplyListImpl.setSupplyListName(supplyListName);
		}

		supplyListImpl.setIsSystem(isSystem);
		supplyListImpl.setCompanyId(companyId);
		supplyListImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			supplyListImpl.setCreatedDate(null);
		}
		else {
			supplyListImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			supplyListImpl.setModifiedDate(null);
		}
		else {
			supplyListImpl.setModifiedDate(new Date(modifiedDate));
		}

		supplyListImpl.resetOriginalValues();

		return supplyListImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		supplyListId = objectInput.readLong();
		supplyListName = objectInput.readUTF();
		isSystem = objectInput.readBoolean();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(supplyListId);

		if (supplyListName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(supplyListName);
		}

		objectOutput.writeBoolean(isSystem);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long supplyListId;
	public String supplyListName;
	public boolean isSystem;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
}