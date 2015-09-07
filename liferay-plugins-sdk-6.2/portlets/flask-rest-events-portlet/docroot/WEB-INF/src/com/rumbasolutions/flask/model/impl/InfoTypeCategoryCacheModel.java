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

import com.rumbasolutions.flask.model.InfoTypeCategory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing InfoTypeCategory in entity cache.
 *
 * @author Ashutosh Rai
 * @see InfoTypeCategory
 * @generated
 */
public class InfoTypeCategoryCacheModel implements CacheModel<InfoTypeCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{infoTypeCategoryId=");
		sb.append(infoTypeCategoryId);
		sb.append(", infoTypeCategoryName=");
		sb.append(infoTypeCategoryName);
		sb.append(", displayTemplate=");
		sb.append(displayTemplate);
		sb.append(", infoTypeId=");
		sb.append(infoTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public InfoTypeCategory toEntityModel() {
		InfoTypeCategoryImpl infoTypeCategoryImpl = new InfoTypeCategoryImpl();

		infoTypeCategoryImpl.setInfoTypeCategoryId(infoTypeCategoryId);

		if (infoTypeCategoryName == null) {
			infoTypeCategoryImpl.setInfoTypeCategoryName(StringPool.BLANK);
		}
		else {
			infoTypeCategoryImpl.setInfoTypeCategoryName(infoTypeCategoryName);
		}

		if (displayTemplate == null) {
			infoTypeCategoryImpl.setDisplayTemplate(StringPool.BLANK);
		}
		else {
			infoTypeCategoryImpl.setDisplayTemplate(displayTemplate);
		}

		infoTypeCategoryImpl.setInfoTypeId(infoTypeId);

		infoTypeCategoryImpl.resetOriginalValues();

		return infoTypeCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		infoTypeCategoryId = objectInput.readLong();
		infoTypeCategoryName = objectInput.readUTF();
		displayTemplate = objectInput.readUTF();
		infoTypeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(infoTypeCategoryId);

		if (infoTypeCategoryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(infoTypeCategoryName);
		}

		if (displayTemplate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(displayTemplate);
		}

		objectOutput.writeLong(infoTypeId);
	}

	public long infoTypeCategoryId;
	public String infoTypeCategoryName;
	public String displayTemplate;
	public long infoTypeId;
}