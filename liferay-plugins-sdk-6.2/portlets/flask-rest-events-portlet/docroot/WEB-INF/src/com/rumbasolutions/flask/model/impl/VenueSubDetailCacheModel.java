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

import com.rumbasolutions.flask.model.VenueSubDetail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing VenueSubDetail in entity cache.
 *
 * @author Ashutosh Rai
 * @see VenueSubDetail
 * @generated
 */
public class VenueSubDetailCacheModel implements CacheModel<VenueSubDetail>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{venueSubDetailId=");
		sb.append(venueSubDetailId);
		sb.append(", venueDetailId=");
		sb.append(venueDetailId);
		sb.append(", venueSubDetailTitle=");
		sb.append(venueSubDetailTitle);
		sb.append(", venueSubDetailDesc=");
		sb.append(venueSubDetailDesc);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VenueSubDetail toEntityModel() {
		VenueSubDetailImpl venueSubDetailImpl = new VenueSubDetailImpl();

		venueSubDetailImpl.setVenueSubDetailId(venueSubDetailId);
		venueSubDetailImpl.setVenueDetailId(venueDetailId);

		if (venueSubDetailTitle == null) {
			venueSubDetailImpl.setVenueSubDetailTitle(StringPool.BLANK);
		}
		else {
			venueSubDetailImpl.setVenueSubDetailTitle(venueSubDetailTitle);
		}

		if (venueSubDetailDesc == null) {
			venueSubDetailImpl.setVenueSubDetailDesc(StringPool.BLANK);
		}
		else {
			venueSubDetailImpl.setVenueSubDetailDesc(venueSubDetailDesc);
		}

		venueSubDetailImpl.resetOriginalValues();

		return venueSubDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		venueSubDetailId = objectInput.readLong();
		venueDetailId = objectInput.readLong();
		venueSubDetailTitle = objectInput.readUTF();
		venueSubDetailDesc = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(venueSubDetailId);
		objectOutput.writeLong(venueDetailId);

		if (venueSubDetailTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueSubDetailTitle);
		}

		if (venueSubDetailDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(venueSubDetailDesc);
		}
	}

	public long venueSubDetailId;
	public long venueDetailId;
	public String venueSubDetailTitle;
	public String venueSubDetailDesc;
}