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

import com.rumbasolutions.flask.model.EventSubDetail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EventSubDetail in entity cache.
 *
 * @author Ashutosh Rai
 * @see EventSubDetail
 * @generated
 */
public class EventSubDetailCacheModel implements CacheModel<EventSubDetail>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{eventSubDetailId=");
		sb.append(eventSubDetailId);
		sb.append(", eventDetailId=");
		sb.append(eventDetailId);
		sb.append(", eventSubDetailTitle=");
		sb.append(eventSubDetailTitle);
		sb.append(", eventSubDetailDesc=");
		sb.append(eventSubDetailDesc);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EventSubDetail toEntityModel() {
		EventSubDetailImpl eventSubDetailImpl = new EventSubDetailImpl();

		eventSubDetailImpl.setEventSubDetailId(eventSubDetailId);
		eventSubDetailImpl.setEventDetailId(eventDetailId);

		if (eventSubDetailTitle == null) {
			eventSubDetailImpl.setEventSubDetailTitle(StringPool.BLANK);
		}
		else {
			eventSubDetailImpl.setEventSubDetailTitle(eventSubDetailTitle);
		}

		if (eventSubDetailDesc == null) {
			eventSubDetailImpl.setEventSubDetailDesc(StringPool.BLANK);
		}
		else {
			eventSubDetailImpl.setEventSubDetailDesc(eventSubDetailDesc);
		}

		eventSubDetailImpl.resetOriginalValues();

		return eventSubDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eventSubDetailId = objectInput.readLong();
		eventDetailId = objectInput.readLong();
		eventSubDetailTitle = objectInput.readUTF();
		eventSubDetailDesc = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eventSubDetailId);
		objectOutput.writeLong(eventDetailId);

		if (eventSubDetailTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventSubDetailTitle);
		}

		if (eventSubDetailDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventSubDetailDesc);
		}
	}

	public long eventSubDetailId;
	public long eventDetailId;
	public String eventSubDetailTitle;
	public String eventSubDetailDesc;
}