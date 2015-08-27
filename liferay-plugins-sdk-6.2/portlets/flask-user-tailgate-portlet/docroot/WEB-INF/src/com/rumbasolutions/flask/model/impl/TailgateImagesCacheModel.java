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

import com.rumbasolutions.flask.model.TailgateImages;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TailgateImages in entity cache.
 *
 * @author rajeshj
 * @see TailgateImages
 * @generated
 */
public class TailgateImagesCacheModel implements CacheModel<TailgateImages>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{tailgateImageId=");
		sb.append(tailgateImageId);
		sb.append(", tailgateId=");
		sb.append(tailgateId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", imageTitle=");
		sb.append(imageTitle);
		sb.append(", imageDesc=");
		sb.append(imageDesc);
		sb.append(", imageUUID=");
		sb.append(imageUUID);
		sb.append(", imageGroupId=");
		sb.append(imageGroupId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TailgateImages toEntityModel() {
		TailgateImagesImpl tailgateImagesImpl = new TailgateImagesImpl();

		tailgateImagesImpl.setTailgateImageId(tailgateImageId);
		tailgateImagesImpl.setTailgateId(tailgateId);
		tailgateImagesImpl.setUserId(userId);

		if (imageTitle == null) {
			tailgateImagesImpl.setImageTitle(StringPool.BLANK);
		}
		else {
			tailgateImagesImpl.setImageTitle(imageTitle);
		}

		if (imageDesc == null) {
			tailgateImagesImpl.setImageDesc(StringPool.BLANK);
		}
		else {
			tailgateImagesImpl.setImageDesc(imageDesc);
		}

		if (imageUUID == null) {
			tailgateImagesImpl.setImageUUID(StringPool.BLANK);
		}
		else {
			tailgateImagesImpl.setImageUUID(imageUUID);
		}

		tailgateImagesImpl.setImageGroupId(imageGroupId);

		if (createdDate == Long.MIN_VALUE) {
			tailgateImagesImpl.setCreatedDate(null);
		}
		else {
			tailgateImagesImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tailgateImagesImpl.setModifiedDate(null);
		}
		else {
			tailgateImagesImpl.setModifiedDate(new Date(modifiedDate));
		}

		tailgateImagesImpl.resetOriginalValues();

		return tailgateImagesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tailgateImageId = objectInput.readLong();
		tailgateId = objectInput.readLong();
		userId = objectInput.readLong();
		imageTitle = objectInput.readUTF();
		imageDesc = objectInput.readUTF();
		imageUUID = objectInput.readUTF();
		imageGroupId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tailgateImageId);
		objectOutput.writeLong(tailgateId);
		objectOutput.writeLong(userId);

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
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long tailgateImageId;
	public long tailgateId;
	public long userId;
	public String imageTitle;
	public String imageDesc;
	public String imageUUID;
	public long imageGroupId;
	public long createdDate;
	public long modifiedDate;
}