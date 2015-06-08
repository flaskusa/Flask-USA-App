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
 * The Blob model class for lazy loading the venueDetailImageData column in VenueDetailImage.
 *
 * @author Ashutosh Rai
 * @see VenueDetailImage
 * @generated
 */
public class VenueDetailImageVenueDetailImageDataBlobModel {
	public VenueDetailImageVenueDetailImageDataBlobModel() {
	}

	public VenueDetailImageVenueDetailImageDataBlobModel(
		long venueDetailImageId) {
		_venueDetailImageId = venueDetailImageId;
	}

	public VenueDetailImageVenueDetailImageDataBlobModel(
		long venueDetailImageId, Blob venueDetailImageDataBlob) {
		_venueDetailImageId = venueDetailImageId;
		_venueDetailImageDataBlob = venueDetailImageDataBlob;
	}

	public long getVenueDetailImageId() {
		return _venueDetailImageId;
	}

	public void setVenueDetailImageId(long venueDetailImageId) {
		_venueDetailImageId = venueDetailImageId;
	}

	public Blob getVenueDetailImageDataBlob() {
		return _venueDetailImageDataBlob;
	}

	public void setVenueDetailImageDataBlob(Blob venueDetailImageDataBlob) {
		_venueDetailImageDataBlob = venueDetailImageDataBlob;
	}

	private long _venueDetailImageId;
	private Blob _venueDetailImageDataBlob;
}