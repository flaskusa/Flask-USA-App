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

import com.rumbasolutions.flask.model.SupplyItem;
import com.rumbasolutions.flask.service.SupplyItemLocalServiceUtil;

/**
 * The extended model base implementation for the SupplyItem service. Represents a row in the &quot;flasktailgate_SupplyItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SupplyItemImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplyItemImpl
 * @see com.rumbasolutions.flask.model.SupplyItem
 * @generated
 */
public abstract class SupplyItemBaseImpl extends SupplyItemModelImpl
	implements SupplyItem {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a supply item model instance should use the {@link SupplyItem} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SupplyItemLocalServiceUtil.addSupplyItem(this);
		}
		else {
			SupplyItemLocalServiceUtil.updateSupplyItem(this);
		}
	}
}