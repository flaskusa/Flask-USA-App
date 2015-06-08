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

import com.rumbasolutions.flask.model.EventType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EventType in entity cache.
 *
 * @author Ashutosh Rai
 * @see EventType
 * @generated
 */
public class EventTypeCacheModel implements CacheModel<EventType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{eventTypeId=");
		sb.append(eventTypeId);
		sb.append(", eventTypeKey=");
		sb.append(eventTypeKey);
		sb.append(", eventTypeName=");
		sb.append(eventTypeName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EventType toEntityModel() {
		EventTypeImpl eventTypeImpl = new EventTypeImpl();

		eventTypeImpl.setEventTypeId(eventTypeId);

		if (eventTypeKey == null) {
			eventTypeImpl.setEventTypeKey(StringPool.BLANK);
		}
		else {
			eventTypeImpl.setEventTypeKey(eventTypeKey);
		}

		if (eventTypeName == null) {
			eventTypeImpl.setEventTypeName(StringPool.BLANK);
		}
		else {
			eventTypeImpl.setEventTypeName(eventTypeName);
		}

		eventTypeImpl.resetOriginalValues();

		return eventTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eventTypeId = objectInput.readLong();
		eventTypeKey = objectInput.readUTF();
		eventTypeName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eventTypeId);

		if (eventTypeKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventTypeKey);
		}

		if (eventTypeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventTypeName);
		}
	}

	public long eventTypeId;
	public String eventTypeKey;
	public String eventTypeName;
}