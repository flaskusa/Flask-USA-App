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
 * The Blob model class for lazy loading the eventDetailImageData column in EventDetailImage.
 *
 * @author Ashutosh Rai
 * @see EventDetailImage
 * @generated
 */
public class EventDetailImageEventDetailImageDataBlobModel {
	public EventDetailImageEventDetailImageDataBlobModel() {
	}

	public EventDetailImageEventDetailImageDataBlobModel(
		long eventDetailImageId) {
		_eventDetailImageId = eventDetailImageId;
	}

	public EventDetailImageEventDetailImageDataBlobModel(
		long eventDetailImageId, Blob eventDetailImageDataBlob) {
		_eventDetailImageId = eventDetailImageId;
		_eventDetailImageDataBlob = eventDetailImageDataBlob;
	}

	public long getEventDetailImageId() {
		return _eventDetailImageId;
	}

	public void setEventDetailImageId(long eventDetailImageId) {
		_eventDetailImageId = eventDetailImageId;
	}

	public Blob getEventDetailImageDataBlob() {
		return _eventDetailImageDataBlob;
	}

	public void setEventDetailImageDataBlob(Blob eventDetailImageDataBlob) {
		_eventDetailImageDataBlob = eventDetailImageDataBlob;
	}

	private long _eventDetailImageId;
	private Blob _eventDetailImageDataBlob;
}