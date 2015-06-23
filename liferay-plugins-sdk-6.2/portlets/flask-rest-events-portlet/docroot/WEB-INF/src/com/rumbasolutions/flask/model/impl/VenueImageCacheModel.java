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

import com.rumbasolutions.flask.model.VenueImage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VenueImage in entity cache.
 *
 * @author Ashutosh Rai
 * @see VenueImage
 * @generated
 */
public class VenueImageCacheModel implements CacheModel<VenueImage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{venueImageId=");
		sb.append(venueImageId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", venueImagePath=");
		sb.append(venueImagePath);
		sb.append(", venueId=");
		sb.append(venueId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VenueImage toEntityModel() {
		VenueImageImpl venueImageImpl = new VenueImageImpl();

		venueImageImpl.setVenueImageId(venueImageId);
		venueImageImpl.setCompanyId(companyId);
		venueImageImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			venueImageImpl.setCreatedDate(null);
		}
		else {
			venueImageImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			venueImageImpl.setModifiedDate(null);
		}
		else {
			venueImageImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			venueImageImpl.setTitle(StringPool.BLANK);
		}
		else {
			venueImageImpl.setTitle(title);
		}

		if (venueImagePath == null) {
			venueImageImpl.setVenueImagePath(StringPool.BLANK);
		}
		else {
			venueImageImpl.setVenueImagePath(venueImagePath);
		}

		venueImageImpl.setVenueId(venueId);

		venueImageImpl.resetOriginalValues();

		return venueImageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		venueImageId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		venueImagePath = objectInput.readUTF();
		venueId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(venueImageId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (venueImagePath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueImagePath);
		}

		objectOutput.writeLong(venueId);
	}

	public long venueImageId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public String title;
	public String venueImagePath;
	public long venueId;
}