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
 * The Blob model class for lazy loading the venueImage column in VenueImage.
 *
 * @author Ashutosh Rai
 * @see VenueImage
 * @generated
 */
public class VenueImageVenueImageBlobModel {
	public VenueImageVenueImageBlobModel() {
	}

	public VenueImageVenueImageBlobModel(long venueImageId) {
		_venueImageId = venueImageId;
	}

	public VenueImageVenueImageBlobModel(long venueImageId, Blob venueImageBlob) {
		_venueImageId = venueImageId;
		_venueImageBlob = venueImageBlob;
	}

	public long getVenueImageId() {
		return _venueImageId;
	}

	public void setVenueImageId(long venueImageId) {
		_venueImageId = venueImageId;
	}

	public Blob getVenueImageBlob() {
		return _venueImageBlob;
	}

	public void setVenueImageBlob(Blob venueImageBlob) {
		_venueImageBlob = venueImageBlob;
	}

	private long _venueImageId;
	private Blob _venueImageBlob;
}