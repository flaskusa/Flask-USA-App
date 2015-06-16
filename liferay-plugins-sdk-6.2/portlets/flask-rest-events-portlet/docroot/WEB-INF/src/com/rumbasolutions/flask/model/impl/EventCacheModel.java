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

import com.rumbasolutions.flask.model.Event;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Event in entity cache.
 *
 * @author Ashutosh Rai
 * @see Event
 * @generated
 */
public class EventCacheModel implements CacheModel<Event>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{eventId=");
		sb.append(eventId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", eventName=");
		sb.append(eventName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", eventDate=");
		sb.append(eventDate);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", eventTypeId=");
		sb.append(eventTypeId);
		sb.append(", eventTypeName=");
		sb.append(eventTypeName);
		sb.append(", eventImagePath=");
		sb.append(eventImagePath);
		sb.append(", venueId=");
		sb.append(venueId);
		sb.append(", venueName=");
		sb.append(venueName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Event toEntityModel() {
		EventImpl eventImpl = new EventImpl();

		eventImpl.setEventId(eventId);
		eventImpl.setCompanyId(companyId);
		eventImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			eventImpl.setCreatedDate(null);
		}
		else {
			eventImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eventImpl.setModifiedDate(null);
		}
		else {
			eventImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (eventName == null) {
			eventImpl.setEventName(StringPool.BLANK);
		}
		else {
			eventImpl.setEventName(eventName);
		}

		if (description == null) {
			eventImpl.setDescription(StringPool.BLANK);
		}
		else {
			eventImpl.setDescription(description);
		}

		if (eventDate == Long.MIN_VALUE) {
			eventImpl.setEventDate(null);
		}
		else {
			eventImpl.setEventDate(new Date(eventDate));
		}

		if (startTime == Long.MIN_VALUE) {
			eventImpl.setStartTime(null);
		}
		else {
			eventImpl.setStartTime(new Date(startTime));
		}

		if (endTime == Long.MIN_VALUE) {
			eventImpl.setEndTime(null);
		}
		else {
			eventImpl.setEndTime(new Date(endTime));
		}

		eventImpl.setEventTypeId(eventTypeId);

		if (eventTypeName == null) {
			eventImpl.setEventTypeName(StringPool.BLANK);
		}
		else {
			eventImpl.setEventTypeName(eventTypeName);
		}

		if (eventImagePath == null) {
			eventImpl.setEventImagePath(StringPool.BLANK);
		}
		else {
			eventImpl.setEventImagePath(eventImagePath);
		}

		eventImpl.setVenueId(venueId);
		eventImpl.setVenueName(venueName);

		eventImpl.resetOriginalValues();

		return eventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		eventId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		eventName = objectInput.readUTF();
		description = objectInput.readUTF();
		eventDate = objectInput.readLong();
		startTime = objectInput.readLong();
		endTime = objectInput.readLong();
		eventTypeId = objectInput.readLong();
		eventTypeName = objectInput.readUTF();
		eventImagePath = objectInput.readUTF();
		venueId = objectInput.readLong();
		venueName = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(eventId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		if (eventName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventName);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(eventDate);
		objectOutput.writeLong(startTime);
		objectOutput.writeLong(endTime);
		objectOutput.writeLong(eventTypeId);

		if (eventTypeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventTypeName);
		}

		if (eventImagePath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventImagePath);
		}

		objectOutput.writeLong(venueId);
		objectOutput.writeLong(venueName);
	}

	public long eventId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public String eventName;
	public String description;
	public long eventDate;
	public long startTime;
	public long endTime;
	public long eventTypeId;
	public String eventTypeName;
	public String eventImagePath;
	public long venueId;
	public long venueName;
}