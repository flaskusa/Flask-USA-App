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

import com.rumbasolutions.flask.model.FlaskRole;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FlaskRole in entity cache.
 *
 * @author Ashutosh Rai
 * @see FlaskRole
 * @generated
 */
public class FlaskRoleCacheModel implements CacheModel<FlaskRole>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{roleId=");
		sb.append(roleId);
		sb.append(", roleName=");
		sb.append(roleName);
		sb.append(", roleDesc=");
		sb.append(roleDesc);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FlaskRole toEntityModel() {
		FlaskRoleImpl flaskRoleImpl = new FlaskRoleImpl();

		flaskRoleImpl.setRoleId(roleId);

		if (roleName == null) {
			flaskRoleImpl.setRoleName(StringPool.BLANK);
		}
		else {
			flaskRoleImpl.setRoleName(roleName);
		}

		if (roleDesc == null) {
			flaskRoleImpl.setRoleDesc(StringPool.BLANK);
		}
		else {
			flaskRoleImpl.setRoleDesc(roleDesc);
		}

		flaskRoleImpl.resetOriginalValues();

		return flaskRoleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		roleId = objectInput.readLong();
		roleName = objectInput.readUTF();
		roleDesc = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(roleId);

		if (roleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(roleName);
		}

		if (roleDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(roleDesc);
		}
	}

	public long roleId;
	public String roleName;
	public String roleDesc;
}