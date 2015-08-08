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

import com.rumbasolutions.flask.model.FlaskGroup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FlaskGroup in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroup
 * @generated
 */
public class FlaskGroupCacheModel implements CacheModel<FlaskGroup>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{groupId=");
		sb.append(groupId);
		sb.append(", groupName=");
		sb.append(groupName);
		sb.append(", groupDescription=");
		sb.append(groupDescription);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append(", isDelete=");
		sb.append(isDelete);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FlaskGroup toEntityModel() {
		FlaskGroupImpl flaskGroupImpl = new FlaskGroupImpl();

		flaskGroupImpl.setGroupId(groupId);

		if (groupName == null) {
			flaskGroupImpl.setGroupName(StringPool.BLANK);
		}
		else {
			flaskGroupImpl.setGroupName(groupName);
		}

		if (groupDescription == null) {
			flaskGroupImpl.setGroupDescription(StringPool.BLANK);
		}
		else {
			flaskGroupImpl.setGroupDescription(groupDescription);
		}

		if (createdDate == null) {
			flaskGroupImpl.setCreatedDate(StringPool.BLANK);
		}
		else {
			flaskGroupImpl.setCreatedDate(createdDate);
		}

		if (createdBy == null) {
			flaskGroupImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			flaskGroupImpl.setCreatedBy(createdBy);
		}

		flaskGroupImpl.setIsActive(isActive);
		flaskGroupImpl.setIsDelete(isDelete);

		flaskGroupImpl.resetOriginalValues();

		return flaskGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupId = objectInput.readLong();
		groupName = objectInput.readUTF();
		groupDescription = objectInput.readUTF();
		createdDate = objectInput.readUTF();
		createdBy = objectInput.readUTF();
		isActive = objectInput.readInt();
		isDelete = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(groupId);

		if (groupName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(groupName);
		}

		if (groupDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(groupDescription);
		}

		if (createdDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdDate);
		}

		if (createdBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		objectOutput.writeInt(isActive);
		objectOutput.writeInt(isDelete);
	}

	public long groupId;
	public String groupName;
	public String groupDescription;
	public String createdDate;
	public String createdBy;
	public int isActive;
	public int isDelete;
}