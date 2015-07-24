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

import com.rumbasolutions.flask.model.VenueDetailImage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VenueDetailImage in entity cache.
 *
 * @author Ashutosh Rai
 * @see VenueDetailImage
 * @generated
 */
public class VenueDetailImageCacheModel implements CacheModel<VenueDetailImage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{venueDetailImageId=");
		sb.append(venueDetailImageId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", venueDetailId=");
		sb.append(venueDetailId);
		sb.append(", imageTitle=");
		sb.append(imageTitle);
		sb.append(", imageDesc=");
		sb.append(imageDesc);
		sb.append(", imageUUID=");
		sb.append(imageUUID);
		sb.append(", imageGroupId=");
		sb.append(imageGroupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VenueDetailImage toEntityModel() {
		VenueDetailImageImpl venueDetailImageImpl = new VenueDetailImageImpl();

		venueDetailImageImpl.setVenueDetailImageId(venueDetailImageId);
		venueDetailImageImpl.setCompanyId(companyId);
		venueDetailImageImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			venueDetailImageImpl.setCreatedDate(null);
		}
		else {
			venueDetailImageImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			venueDetailImageImpl.setModifiedDate(null);
		}
		else {
			venueDetailImageImpl.setModifiedDate(new Date(modifiedDate));
		}

		venueDetailImageImpl.setVenueDetailId(venueDetailId);

		if (imageTitle == null) {
			venueDetailImageImpl.setImageTitle(StringPool.BLANK);
		}
		else {
			venueDetailImageImpl.setImageTitle(imageTitle);
		}

		if (imageDesc == null) {
			venueDetailImageImpl.setImageDesc(StringPool.BLANK);
		}
		else {
			venueDetailImageImpl.setImageDesc(imageDesc);
		}

		if (imageUUID == null) {
			venueDetailImageImpl.setImageUUID(StringPool.BLANK);
		}
		else {
			venueDetailImageImpl.setImageUUID(imageUUID);
		}

		venueDetailImageImpl.setImageGroupId(imageGroupId);

		venueDetailImageImpl.resetOriginalValues();

		return venueDetailImageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		venueDetailImageId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		venueDetailId = objectInput.readLong();
		imageTitle = objectInput.readUTF();
		imageDesc = objectInput.readUTF();
		imageUUID = objectInput.readUTF();
		imageGroupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(venueDetailImageId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(venueDetailId);

		if (imageTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageTitle);
		}

		if (imageDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageDesc);
		}

		if (imageUUID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageUUID);
		}

		objectOutput.writeLong(imageGroupId);
	}

	public long venueDetailImageId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public long venueDetailId;
	public String imageTitle;
	public String imageDesc;
	public String imageUUID;
	public long imageGroupId;
}