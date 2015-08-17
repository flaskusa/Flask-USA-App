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
import com.rumbasolutions.flask.service.TailgateInfoLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateInfoServiceUtil;
import com.rumbasolutions.flask.service.TailgateMarkerLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateMarkerServiceUtil;
import com.rumbasolutions.flask.service.TailgateUsersLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateUsersServiceUtil;

/**
 * @author rajeshj
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
			TailgateInfoLocalServiceUtil.clearService();

			TailgateInfoServiceUtil.clearService();
			TailgateMarkerLocalServiceUtil.clearService();

			TailgateMarkerServiceUtil.clearService();
			TailgateUsersLocalServiceUtil.clearService();

			TailgateUsersServiceUtil.clearService();
		}
	}
}