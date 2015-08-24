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

import com.rumbasolutions.flask.model.InvitationInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing InvitationInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see InvitationInfo
 * @generated
 */
public class InvitationInfoCacheModel implements CacheModel<InvitationInfo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{inviationId=");
		sb.append(inviationId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", email=");
		sb.append(email);
		sb.append(", description=");
		sb.append(description);
		sb.append(", invitedDate=");
		sb.append(invitedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public InvitationInfo toEntityModel() {
		InvitationInfoImpl invitationInfoImpl = new InvitationInfoImpl();

		invitationInfoImpl.setInviationId(inviationId);

		if (name == null) {
			invitationInfoImpl.setName(StringPool.BLANK);
		}
		else {
			invitationInfoImpl.setName(name);
		}

		if (email == null) {
			invitationInfoImpl.setEmail(StringPool.BLANK);
		}
		else {
			invitationInfoImpl.setEmail(email);
		}

		if (description == null) {
			invitationInfoImpl.setDescription(StringPool.BLANK);
		}
		else {
			invitationInfoImpl.setDescription(description);
		}

		if (invitedDate == null) {
			invitationInfoImpl.setInvitedDate(StringPool.BLANK);
		}
		else {
			invitationInfoImpl.setInvitedDate(invitedDate);
		}

		invitationInfoImpl.resetOriginalValues();

		return invitationInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		inviationId = objectInput.readLong();
		name = objectInput.readUTF();
		email = objectInput.readUTF();
		description = objectInput.readUTF();
		invitedDate = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(inviationId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (invitedDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(invitedDate);
		}
	}

	public long inviationId;
	public String name;
	public String email;
	public String description;
	public String invitedDate;
}