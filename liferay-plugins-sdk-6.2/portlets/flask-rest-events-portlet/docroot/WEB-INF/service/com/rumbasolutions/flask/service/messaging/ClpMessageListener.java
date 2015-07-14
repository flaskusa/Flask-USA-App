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

package com.rumbasolutions.flask.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.rumbasolutions.flask.service.ClpSerializer;
import com.rumbasolutions.flask.service.EventDetailImageLocalServiceUtil;
import com.rumbasolutions.flask.service.EventDetailImageServiceUtil;
import com.rumbasolutions.flask.service.EventDetailLocalServiceUtil;
import com.rumbasolutions.flask.service.EventDetailServiceUtil;
import com.rumbasolutions.flask.service.EventLocalServiceUtil;
import com.rumbasolutions.flask.service.EventServiceUtil;
import com.rumbasolutions.flask.service.EventTypeLocalServiceUtil;
import com.rumbasolutions.flask.service.EventTypeServiceUtil;
import com.rumbasolutions.flask.service.InfoTypeCategoryLocalServiceUtil;
import com.rumbasolutions.flask.service.InfoTypeCategoryServiceUtil;
import com.rumbasolutions.flask.service.InfoTypeLocalServiceUtil;
import com.rumbasolutions.flask.service.InfoTypeServiceUtil;
import com.rumbasolutions.flask.service.VenueDetailImageLocalServiceUtil;
import com.rumbasolutions.flask.service.VenueDetailImageServiceUtil;
import com.rumbasolutions.flask.service.VenueDetailLocalServiceUtil;
import com.rumbasolutions.flask.service.VenueDetailServiceUtil;
import com.rumbasolutions.flask.service.VenueImageLocalServiceUtil;
import com.rumbasolutions.flask.service.VenueImageServiceUtil;
import com.rumbasolutions.flask.service.VenueLocalServiceUtil;
import com.rumbasolutions.flask.service.VenueServiceUtil;

/**
 * @author Ashutosh Rai
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			EventLocalServiceUtil.clearService();

			EventServiceUtil.clearService();
			EventDetailLocalServiceUtil.clearService();

			EventDetailServiceUtil.clearService();
			EventDetailImageLocalServiceUtil.clearService();

			EventDetailImageServiceUtil.clearService();
			EventTypeLocalServiceUtil.clearService();

			EventTypeServiceUtil.clearService();
			InfoTypeLocalServiceUtil.clearService();

			InfoTypeServiceUtil.clearService();
			InfoTypeCategoryLocalServiceUtil.clearService();

			InfoTypeCategoryServiceUtil.clearService();
			VenueLocalServiceUtil.clearService();

			VenueServiceUtil.clearService();
			VenueDetailLocalServiceUtil.clearService();

			VenueDetailServiceUtil.clearService();
			VenueDetailImageLocalServiceUtil.clearService();

			VenueDetailImageServiceUtil.clearService();
			VenueImageLocalServiceUtil.clearService();

			VenueImageServiceUtil.clearService();
		}
	}
}