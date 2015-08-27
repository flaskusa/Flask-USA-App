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

import com.liferay.portal.kernel.exception.SystemException;

import com.rumbasolutions.flask.model.TailgateImages;
import com.rumbasolutions.flask.service.TailgateImagesLocalServiceUtil;

/**
 * The extended model base implementation for the TailgateImages service. Represents a row in the &quot;flasktailgate_TailgateImages&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TailgateImagesImpl}.
 * </p>
 *
 * @author rajeshj
 * @see TailgateImagesImpl
 * @see com.rumbasolutions.flask.model.TailgateImages
 * @generated
 */
public abstract class TailgateImagesBaseImpl extends TailgateImagesModelImpl
	implements TailgateImages {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tailgate images model instance should use the {@link TailgateImages} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TailgateImagesLocalServiceUtil.addTailgateImages(this);
		}
		else {
			TailgateImagesLocalServiceUtil.updateTailgateImages(this);
		}
	}
}