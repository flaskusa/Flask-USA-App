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
		StringBundler sb = new StringBundler(17);

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
		sb.append(", eventDetailImagetitle=");
		sb.append(eventDetailImagetitle);
		sb.append(", eventDetailImageDesc=");
		sb.append(eventDetailImageDesc);

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

		if (eventDetailImagetitle == null) {
			eventDetailImageImpl.setEventDetailImagetitle(StringPool.BLANK);
		}
		else {
			eventDetailImageImpl.setEventDetailImagetitle(eventDetailImagetitle);
		}

		if (eventDetailImageDesc == null) {
			eventDetailImageImpl.setEventDetailImageDesc(StringPool.BLANK);
		}
		else {
			eventDetailImageImpl.setEventDetailImageDesc(eventDetailImageDesc);
		}

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
		eventDetailImagetitle = objectInput.readUTF();
		eventDetailImageDesc = objectInput.readUTF();
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

		if (eventDetailImagetitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventDetailImagetitle);
		}

		if (eventDetailImageDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventDetailImageDesc);
		}
	}

	public long eventDetailImageId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public long eventDetailId;
	public String eventDetailImagetitle;
	public String eventDetailImageDesc;
}