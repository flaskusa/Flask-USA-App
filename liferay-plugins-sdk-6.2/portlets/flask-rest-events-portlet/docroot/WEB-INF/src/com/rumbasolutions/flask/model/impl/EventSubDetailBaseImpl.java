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

import com.rumbasolutions.flask.model.EventSubDetail;
import com.rumbasolutions.flask.service.EventSubDetailLocalServiceUtil;

/**
 * The extended model base implementation for the EventSubDetail service. Represents a row in the &quot;flaskevents_EventSubDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EventSubDetailImpl}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventSubDetailImpl
 * @see com.rumbasolutions.flask.model.EventSubDetail
 * @generated
 */
public abstract class EventSubDetailBaseImpl extends EventSubDetailModelImpl
	implements EventSubDetail {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a event sub detail model instance should use the {@link EventSubDetail} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EventSubDetailLocalServiceUtil.addEventSubDetail(this);
		}
		else {
			EventSubDetailLocalServiceUtil.updateEventSubDetail(this);
		}
	}
}