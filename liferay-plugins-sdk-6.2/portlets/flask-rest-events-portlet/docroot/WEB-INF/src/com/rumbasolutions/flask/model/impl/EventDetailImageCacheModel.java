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

import com.rumbasolutions.flask.model.EventDetailImage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EventDetailImage in entity cache.
 *
 * @author Ashutosh Rai
 * @see EventDetailImage
 * @generated
 */
public class EventDetailImageCacheModel implements CacheModel<EventDetailImage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{eventDetailImageId=");
		sb.append(eventDetailImageId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", eventDetailId=");
		sb.append(eventDetailId);
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
	public EventDetailImage toEntityModel() {
		EventDetailImageImpl eventDetailImageImpl = new EventDetailImageImpl();

		eventDetailImageImpl.setEventDetailImageId(eventDetailImageId);
		eventDetailImageImpl.setCompanyId(companyId);
		eventDetailImageImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			eventDetailImageImpl.setCreatedDate(null);
		}
		else {
			eventDetailImageImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eventDetailImageImpl.setModifiedDate(null);
		}
		else {
			eventDetailImageImpl.setModifiedDate(new Date(modifiedDate));
		}

		eventDetailImageImpl.setEventDetailId(eventDetailId);

		if (imageTitle == null) {
			eventDetailImageImpl.setImageTitle(StringPool.BLANK);
		}
		else {
			eventDetailImageImpl.setImageTitle(imageTitle);
		}

		if (imageDesc == null) {
			eventDetailImageImpl.setImageDesc(StringPool.BLANK);
		}
		else {
			eventDetailImageImpl.setImageDesc(imageDesc);
		}

		if (imageUUID == null) {
			eventDetailImageImpl.setImageUUID(StringPool.BLANK);
		}
		else {
			eventDetailImageImpl.setImageUUID(imageUUID);
		}

		eventDetailImageImpl.setImageGroupId(imageGroupId);

		eventDetailImageImpl.resetOriginalValues();

		return eventDetailImageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eventDetailImageId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		eventDetailId = objectInput.readLong();
		imageTitle = objectInput.readUTF();
		imageDesc = objectInput.readUTF();
		imageUUID = objectInput.readUTF();
		imageGroupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eventDetailImageId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(eventDetailId);

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

	public long eventDetailImageId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public long eventDetailId;
	public String imageTitle;
	public String imageDesc;
	public String imageUUID;
	public long imageGroupId;
}