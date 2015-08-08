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

import com.rumbasolutions.flask.service.AdCampaignLocalServiceUtil;
import com.rumbasolutions.flask.service.AdCampaignServiceUtil;
import com.rumbasolutions.flask.service.AdCustomerLocalServiceUtil;
import com.rumbasolutions.flask.service.AdCustomerServiceUtil;
import com.rumbasolutions.flask.service.CampaignEventLocalServiceUtil;
import com.rumbasolutions.flask.service.CampaignEventServiceUtil;
import com.rumbasolutions.flask.service.CampaignImageLocalServiceUtil;
import com.rumbasolutions.flask.service.CampaignImageServiceUtil;
import com.rumbasolutions.flask.service.ClpSerializer;

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
			AdCampaignLocalServiceUtil.clearService();

			AdCampaignServiceUtil.clearService();
			AdCustomerLocalServiceUtil.clearService();

			AdCustomerServiceUtil.clearService();
			CampaignEventLocalServiceUtil.clearService();

			CampaignEventServiceUtil.clearService();
			CampaignImageLocalServiceUtil.clearService();

			CampaignImageServiceUtil.clearService();
		}
	}
}