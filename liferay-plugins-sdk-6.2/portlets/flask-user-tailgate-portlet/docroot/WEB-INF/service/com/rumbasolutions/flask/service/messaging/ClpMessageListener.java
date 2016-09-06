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
import com.rumbasolutions.flask.service.SupplyItemLocalServiceUtil;
import com.rumbasolutions.flask.service.SupplyItemServiceUtil;
import com.rumbasolutions.flask.service.SupplyListLocalServiceUtil;
import com.rumbasolutions.flask.service.SupplyListServiceUtil;
import com.rumbasolutions.flask.service.TailgateImagesLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateImagesServiceUtil;
import com.rumbasolutions.flask.service.TailgateInfoLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateInfoServiceUtil;
import com.rumbasolutions.flask.service.TailgateMarkerLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateMarkerServiceUtil;
import com.rumbasolutions.flask.service.TailgateSupplyItemLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateSupplyItemServiceUtil;
import com.rumbasolutions.flask.service.TailgateUsersLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateUsersServiceUtil;

/**
 * @author Brian Wing Shun Chan
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
			SupplyItemLocalServiceUtil.clearService();

			SupplyItemServiceUtil.clearService();
			SupplyListLocalServiceUtil.clearService();

			SupplyListServiceUtil.clearService();
			TailgateImagesLocalServiceUtil.clearService();

			TailgateImagesServiceUtil.clearService();
			TailgateInfoLocalServiceUtil.clearService();

			TailgateInfoServiceUtil.clearService();
			TailgateMarkerLocalServiceUtil.clearService();

			TailgateMarkerServiceUtil.clearService();
			TailgateSupplyItemLocalServiceUtil.clearService();

			TailgateSupplyItemServiceUtil.clearService();
			TailgateUsersLocalServiceUtil.clearService();

			TailgateUsersServiceUtil.clearService();
		}
	}
}