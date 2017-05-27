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

package com.liferay.contacts.model.impl;

import com.liferay.contacts.model.NotificationAuditLog;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing NotificationAuditLog in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see NotificationAuditLog
 * @generated
 */
public class NotificationAuditLogCacheModel implements CacheModel<NotificationAuditLog>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{notificationAuditLogId=");
		sb.append(notificationAuditLogId);
		sb.append(", senderEmail=");
		sb.append(senderEmail);
		sb.append(", receiverEmail=");
		sb.append(receiverEmail);
		sb.append(", messageReason=");
		sb.append(messageReason);
		sb.append(", message=");
		sb.append(message);
		sb.append(", notificationTime=");
		sb.append(notificationTime);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NotificationAuditLog toEntityModel() {
		NotificationAuditLogImpl notificationAuditLogImpl = new NotificationAuditLogImpl();

		notificationAuditLogImpl.setNotificationAuditLogId(notificationAuditLogId);

		if (senderEmail == null) {
			notificationAuditLogImpl.setSenderEmail(StringPool.BLANK);
		}
		else {
			notificationAuditLogImpl.setSenderEmail(senderEmail);
		}

		if (receiverEmail == null) {
			notificationAuditLogImpl.setReceiverEmail(StringPool.BLANK);
		}
		else {
			notificationAuditLogImpl.setReceiverEmail(receiverEmail);
		}

		if (messageReason == null) {
			notificationAuditLogImpl.setMessageReason(StringPool.BLANK);
		}
		else {
			notificationAuditLogImpl.setMessageReason(messageReason);
		}

		if (message == null) {
			notificationAuditLogImpl.setMessage(StringPool.BLANK);
		}
		else {
			notificationAuditLogImpl.setMessage(message);
		}

		if (notificationTime == Long.MIN_VALUE) {
			notificationAuditLogImpl.setNotificationTime(null);
		}
		else {
			notificationAuditLogImpl.setNotificationTime(new Date(
					notificationTime));
		}

		notificationAuditLogImpl.resetOriginalValues();

		return notificationAuditLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		notificationAuditLogId = objectInput.readLong();
		senderEmail = objectInput.readUTF();
		receiverEmail = objectInput.readUTF();
		messageReason = objectInput.readUTF();
		message = objectInput.readUTF();
		notificationTime = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(notificationAuditLogId);

		if (senderEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(senderEmail);
		}

		if (receiverEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(receiverEmail);
		}

		if (messageReason == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(messageReason);
		}

		if (message == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(message);
		}

		objectOutput.writeLong(notificationTime);
	}

	public long notificationAuditLogId;
	public String senderEmail;
	public String receiverEmail;
	public String messageReason;
	public String message;
	public long notificationTime;
}