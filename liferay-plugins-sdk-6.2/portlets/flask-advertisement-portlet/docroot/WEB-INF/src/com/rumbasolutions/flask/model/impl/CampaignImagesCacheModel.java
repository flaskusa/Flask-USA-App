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

import com.rumbasolutions.flask.model.CampaignImages;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CampaignImages in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignImages
 * @generated
 */
public class CampaignImagesCacheModel implements CacheModel<CampaignImages>,
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
	public CampaignImages toEntityModel() {
		CampaignImagesImpl campaignImagesImpl = new CampaignImagesImpl();

		campaignImagesImpl.setCampaignImageId(campaignImageId);
		campaignImagesImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			campaignImagesImpl.setCreatedDate(null);
		}
		else {
			campaignImagesImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			campaignImagesImpl.setModifiedDate(null);
		}
		else {
			campaignImagesImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (imageTitle == null) {
			campaignImagesImpl.setImageTitle(StringPool.BLANK);
		}
		else {
			campaignImagesImpl.setImageTitle(imageTitle);
		}

		if (imageDesc == null) {
			campaignImagesImpl.setImageDesc(StringPool.BLANK);
		}
		else {
			campaignImagesImpl.setImageDesc(imageDesc);
		}

		if (imageUUID == null) {
			campaignImagesImpl.setImageUUID(StringPool.BLANK);
		}
		else {
			campaignImagesImpl.setImageUUID(imageUUID);
		}

		campaignImagesImpl.setImageGroupId(imageGroupId);

		campaignImagesImpl.resetOriginalValues();

		return campaignImagesImpl;
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