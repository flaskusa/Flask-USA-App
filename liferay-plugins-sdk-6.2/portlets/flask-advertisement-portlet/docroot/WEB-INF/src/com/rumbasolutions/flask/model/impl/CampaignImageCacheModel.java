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

import com.rumbasolutions.flask.model.CampaignImage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CampaignImage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignImage
 * @generated
 */
public class CampaignImageCacheModel implements CacheModel<CampaignImage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{campaignImageId=");
		sb.append(campaignImageId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
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
	public CampaignImage toEntityModel() {
		CampaignImageImpl campaignImageImpl = new CampaignImageImpl();

		campaignImageImpl.setCampaignImageId(campaignImageId);
		campaignImageImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			campaignImageImpl.setCreatedDate(null);
		}
		else {
			campaignImageImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			campaignImageImpl.setModifiedDate(null);
		}
		else {
			campaignImageImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (imageTitle == null) {
			campaignImageImpl.setImageTitle(StringPool.BLANK);
		}
		else {
			campaignImageImpl.setImageTitle(imageTitle);
		}

		if (imageDesc == null) {
			campaignImageImpl.setImageDesc(StringPool.BLANK);
		}
		else {
			campaignImageImpl.setImageDesc(imageDesc);
		}

		if (imageUUID == null) {
			campaignImageImpl.setImageUUID(StringPool.BLANK);
		}
		else {
			campaignImageImpl.setImageUUID(imageUUID);
		}

		campaignImageImpl.setImageGroupId(imageGroupId);

		campaignImageImpl.resetOriginalValues();

		return campaignImageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		campaignImageId = objectInput.readLong();
		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		imageTitle = objectInput.readUTF();
		imageDesc = objectInput.readUTF();
		imageUUID = objectInput.readUTF();
		imageGroupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(campaignImageId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

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

	public long campaignImageId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public String imageTitle;
	public String imageDesc;
	public String imageUUID;
	public long imageGroupId;
}