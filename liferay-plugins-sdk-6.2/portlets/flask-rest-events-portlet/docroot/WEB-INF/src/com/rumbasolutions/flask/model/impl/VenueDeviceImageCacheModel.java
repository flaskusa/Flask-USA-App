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

import com.rumbasolutions.flask.model.VenueDeviceImage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing VenueDeviceImage in entity cache.
 *
 * @author Ashutosh Rai
 * @see VenueDeviceImage
 * @generated
 */
public class VenueDeviceImageCacheModel implements CacheModel<VenueDeviceImage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{venueDeviceImageId=");
		sb.append(venueDeviceImageId);
		sb.append(", venueDetailImageId=");
		sb.append(venueDetailImageId);
		sb.append(", venueId=");
		sb.append(venueId);
		sb.append(", deviceType=");
		sb.append(deviceType);
		sb.append(", venueDeviceImageUUID=");
		sb.append(venueDeviceImageUUID);
		sb.append(", aspectRatio=");
		sb.append(aspectRatio);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VenueDeviceImage toEntityModel() {
		VenueDeviceImageImpl venueDeviceImageImpl = new VenueDeviceImageImpl();

		venueDeviceImageImpl.setVenueDeviceImageId(venueDeviceImageId);
		venueDeviceImageImpl.setVenueDetailImageId(venueDetailImageId);
		venueDeviceImageImpl.setVenueId(venueId);

		if (deviceType == null) {
			venueDeviceImageImpl.setDeviceType(StringPool.BLANK);
		}
		else {
			venueDeviceImageImpl.setDeviceType(deviceType);
		}

		if (venueDeviceImageUUID == null) {
			venueDeviceImageImpl.setVenueDeviceImageUUID(StringPool.BLANK);
		}
		else {
			venueDeviceImageImpl.setVenueDeviceImageUUID(venueDeviceImageUUID);
		}

		if (aspectRatio == null) {
			venueDeviceImageImpl.setAspectRatio(StringPool.BLANK);
		}
		else {
			venueDeviceImageImpl.setAspectRatio(aspectRatio);
		}

		venueDeviceImageImpl.resetOriginalValues();

		return venueDeviceImageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		venueDeviceImageId = objectInput.readLong();
		venueDetailImageId = objectInput.readLong();
		venueId = objectInput.readLong();
		deviceType = objectInput.readUTF();
		venueDeviceImageUUID = objectInput.readUTF();
		aspectRatio = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(venueDeviceImageId);
		objectOutput.writeLong(venueDetailImageId);
		objectOutput.writeLong(venueId);

		if (deviceType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(deviceType);
		}

		if (venueDeviceImageUUID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueDeviceImageUUID);
		}

		if (aspectRatio == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(aspectRatio);
		}
	}

	public long venueDeviceImageId;
	public long venueDetailImageId;
	public long venueId;
	public String deviceType;
	public String venueDeviceImageUUID;
	public String aspectRatio;
}