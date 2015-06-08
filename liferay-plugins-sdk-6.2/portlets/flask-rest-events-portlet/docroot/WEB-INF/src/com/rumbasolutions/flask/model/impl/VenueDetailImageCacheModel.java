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
		StringBundler sb = new StringBundler(17);

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
		sb.append(", venueDetailImageTitle=");
		sb.append(venueDetailImageTitle);
		sb.append(", venueDetailImageDesc=");
		sb.append(venueDetailImageDesc);

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

		if (venueDetailImageTitle == null) {
			venueDetailImageImpl.setVenueDetailImageTitle(StringPool.BLANK);
		}
		else {
			venueDetailImageImpl.setVenueDetailImageTitle(venueDetailImageTitle);
		}

		if (venueDetailImageDesc == null) {
			venueDetailImageImpl.setVenueDetailImageDesc(StringPool.BLANK);
		}
		else {
			venueDetailImageImpl.setVenueDetailImageDesc(venueDetailImageDesc);
		}

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
		venueDetailImageTitle = objectInput.readUTF();
		venueDetailImageDesc = objectInput.readUTF();
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

		if (venueDetailImageTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueDetailImageTitle);
		}

		if (venueDetailImageDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueDetailImageDesc);
		}
	}

	public long venueDetailImageId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public long venueDetailId;
	public String venueDetailImageTitle;
	public String venueDetailImageDesc;
}