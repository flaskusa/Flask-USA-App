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

import com.rumbasolutions.flask.model.InfoType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing InfoType in entity cache.
 *
 * @author Ashutosh Rai
 * @see InfoType
 * @generated
 */
public class InfoTypeCacheModel implements CacheModel<InfoType>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{infoTypeId=");
		sb.append(infoTypeId);
		sb.append(", infoTypeName=");
		sb.append(infoTypeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public InfoType toEntityModel() {
		InfoTypeImpl infoTypeImpl = new InfoTypeImpl();

		infoTypeImpl.setInfoTypeId(infoTypeId);

		if (infoTypeName == null) {
			infoTypeImpl.setInfoTypeName(StringPool.BLANK);
		}
		else {
			infoTypeImpl.setInfoTypeName(infoTypeName);
		}

		infoTypeImpl.resetOriginalValues();

		return infoTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		infoTypeId = objectInput.readLong();
		infoTypeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(infoTypeId);

		if (infoTypeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(infoTypeName);
		}
	}

	public long infoTypeId;
	public String infoTypeName;
}