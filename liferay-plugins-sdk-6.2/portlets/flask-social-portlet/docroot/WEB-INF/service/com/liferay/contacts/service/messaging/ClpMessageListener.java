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

package com.liferay.contacts.service.messaging;

import com.liferay.contacts.service.ClpSerializer;
import com.liferay.contacts.service.DeviceAwsEndpointLocalServiceUtil;
import com.liferay.contacts.service.DeviceAwsEndpointServiceUtil;
import com.liferay.contacts.service.EntryLocalServiceUtil;
import com.liferay.contacts.service.EntryServiceUtil;
import com.liferay.contacts.service.FlaskMessagesLocalServiceUtil;
import com.liferay.contacts.service.FlaskMessagesServiceUtil;
import com.liferay.contacts.service.FlaskRecipientsLocalServiceUtil;
import com.liferay.contacts.service.FlaskRecipientsServiceUtil;
import com.liferay.contacts.service.FlaskUserDeviceRegistrationLocalServiceUtil;
import com.liferay.contacts.service.FlaskUserDeviceRegistrationServiceUtil;
import com.liferay.contacts.service.NotificationAuditLogLocalServiceUtil;
import com.liferay.contacts.service.NotificationAuditLogServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

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
			DeviceAwsEndpointLocalServiceUtil.clearService();

			DeviceAwsEndpointServiceUtil.clearService();
			EntryLocalServiceUtil.clearService();

			EntryServiceUtil.clearService();
			FlaskMessagesLocalServiceUtil.clearService();

			FlaskMessagesServiceUtil.clearService();
			FlaskRecipientsLocalServiceUtil.clearService();

			FlaskRecipientsServiceUtil.clearService();
			FlaskUserDeviceRegistrationLocalServiceUtil.clearService();

			FlaskUserDeviceRegistrationServiceUtil.clearService();
			NotificationAuditLogLocalServiceUtil.clearService();

			NotificationAuditLogServiceUtil.clearService();
		}
	}
}