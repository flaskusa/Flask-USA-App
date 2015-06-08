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

package com.rumbasolutions.flask.model;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the eventImage column in Event.
 *
 * @author Ashutosh Rai
 * @see Event
 * @generated
 */
public class EventEventImageBlobModel {
	public EventEventImageBlobModel() {
	}

	public EventEventImageBlobModel(long eventId) {
		_eventId = eventId;
	}

	public EventEventImageBlobModel(long eventId, Blob eventImageBlob) {
		_eventId = eventId;
		_eventImageBlob = eventImageBlob;
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public Blob getEventImageBlob() {
		return _eventImageBlob;
	}

	public void setEventImageBlob(Blob eventImageBlob) {
		_eventImageBlob = eventImageBlob;
	}

	private long _eventId;
	private Blob _eventImageBlob;
}