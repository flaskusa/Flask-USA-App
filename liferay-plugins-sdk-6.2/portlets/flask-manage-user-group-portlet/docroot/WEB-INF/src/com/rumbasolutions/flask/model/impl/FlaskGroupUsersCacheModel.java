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

import com.rumbasolutions.flask.model.FlaskGroupUsers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FlaskGroupUsers in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupUsers
 * @generated
 */
public class FlaskGroupUsersCacheModel implements CacheModel<FlaskGroupUsers>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{groupUserId=");
		sb.append(groupUserId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", isAdmin=");
		sb.append(isAdmin);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FlaskGroupUsers toEntityModel() {
		FlaskGroupUsersImpl flaskGroupUsersImpl = new FlaskGroupUsersImpl();

		flaskGroupUsersImpl.setGroupUserId(groupUserId);
		flaskGroupUsersImpl.setGroupId(groupId);
		flaskGroupUsersImpl.setUserId(userId);

		if (userName == null) {
			flaskGroupUsersImpl.setUserName(StringPool.BLANK);
		}
		else {
			flaskGroupUsersImpl.setUserName(userName);
		}

		flaskGroupUsersImpl.setIsAdmin(isAdmin);

		flaskGroupUsersImpl.resetOriginalValues();

		return flaskGroupUsersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupUserId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		isAdmin = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(groupUserId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeInt(isAdmin);
	}

	public long groupUserId;
	public long groupId;
	public long userId;
	public String userName;
	public int isAdmin;
}