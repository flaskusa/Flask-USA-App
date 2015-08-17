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

import com.rumbasolutions.flask.model.TailgateMarker;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TailgateMarker in entity cache.
 *
 * @author rajeshj
 * @see TailgateMarker
 * @generated
 */
public class TailgateMarkerCacheModel implements CacheModel<TailgateMarker>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{tailgatemarkerid=");
		sb.append(tailgatemarkerid);
		sb.append(", tailgateid=");
		sb.append(tailgateid);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TailgateMarker toEntityModel() {
		TailgateMarkerImpl tailgateMarkerImpl = new TailgateMarkerImpl();

		tailgateMarkerImpl.setTailgatemarkerid(tailgatemarkerid);
		tailgateMarkerImpl.setTailgateid(tailgateid);

		if (latitude == null) {
			tailgateMarkerImpl.setLatitude(StringPool.BLANK);
		}
		else {
			tailgateMarkerImpl.setLatitude(latitude);
		}

		if (longitude == null) {
			tailgateMarkerImpl.setLongitude(StringPool.BLANK);
		}
		else {
			tailgateMarkerImpl.setLongitude(longitude);
		}

		if (name == null) {
			tailgateMarkerImpl.setName(StringPool.BLANK);
		}
		else {
			tailgateMarkerImpl.setName(name);
		}

		if (description == null) {
			tailgateMarkerImpl.setDescription(StringPool.BLANK);
		}
		else {
			tailgateMarkerImpl.setDescription(description);
		}

		tailgateMarkerImpl.resetOriginalValues();

		return tailgateMarkerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tailgatemarkerid = objectInput.readLong();
		tailgateid = objectInput.readLong();
		latitude = objectInput.readUTF();
		longitude = objectInput.readUTF();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tailgatemarkerid);
		objectOutput.writeLong(tailgateid);

		if (latitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(latitude);
		}

		if (longitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(longitude);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long tailgatemarkerid;
	public long tailgateid;
	public String latitude;
	public String longitude;
	public String name;
	public String description;
}