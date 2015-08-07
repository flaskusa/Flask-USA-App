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
import com.liferay.portal.model.CacheModel;

import com.rumbasolutions.flask.model.UserEvent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserEvent in entity cache.
 *
 * @author Ashutosh Rai
 * @see UserEvent
 * @generated
 */
public class UserEventCacheModel implements CacheModel<UserEvent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{userEventId=");
		sb.append(userEventId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserEvent toEntityModel() {
		UserEventImpl userEventImpl = new UserEventImpl();

		userEventImpl.setUserEventId(userEventId);
		userEventImpl.setUserId(userId);
		userEventImpl.setEventId(eventId);

		if (createdDate == Long.MIN_VALUE) {
			userEventImpl.setCreatedDate(null);
		}
		else {
			userEventImpl.setCreatedDate(new Date(createdDate));
		}

		userEventImpl.resetOriginalValues();

		return userEventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userEventId = objectInput.readLong();
		userId = objectInput.readLong();
		eventId = objectInput.readLong();
		createdDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userEventId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(eventId);
		objectOutput.writeLong(createdDate);
	}

	public long userEventId;
	public long userId;
	public long eventId;
	public long createdDate;
}