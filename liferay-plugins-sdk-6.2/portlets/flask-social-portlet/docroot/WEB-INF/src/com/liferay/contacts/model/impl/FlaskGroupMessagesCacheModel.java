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

import com.liferay.contacts.model.FlaskGroupMessages;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FlaskGroupMessages in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupMessages
 * @generated
 */
public class FlaskGroupMessagesCacheModel implements CacheModel<FlaskGroupMessages>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{groupMessagesId=");
		sb.append(groupMessagesId);
		sb.append(", senderEmail=");
		sb.append(senderEmail);
		sb.append(", senderUserId=");
		sb.append(senderUserId);
		sb.append(", senderName=");
		sb.append(senderName);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", message=");
		sb.append(message);
		sb.append(", sendEmail=");
		sb.append(sendEmail);
		sb.append(", dateTime=");
		sb.append(dateTime);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FlaskGroupMessages toEntityModel() {
		FlaskGroupMessagesImpl flaskGroupMessagesImpl = new FlaskGroupMessagesImpl();

		flaskGroupMessagesImpl.setGroupMessagesId(groupMessagesId);

		if (senderEmail == null) {
			flaskGroupMessagesImpl.setSenderEmail(StringPool.BLANK);
		}
		else {
			flaskGroupMessagesImpl.setSenderEmail(senderEmail);
		}

		flaskGroupMessagesImpl.setSenderUserId(senderUserId);

		if (senderName == null) {
			flaskGroupMessagesImpl.setSenderName(StringPool.BLANK);
		}
		else {
			flaskGroupMessagesImpl.setSenderName(senderName);
		}

		flaskGroupMessagesImpl.setGroupId(groupId);

		if (message == null) {
			flaskGroupMessagesImpl.setMessage(StringPool.BLANK);
		}
		else {
			flaskGroupMessagesImpl.setMessage(message);
		}

		flaskGroupMessagesImpl.setSendEmail(sendEmail);

		if (dateTime == Long.MIN_VALUE) {
			flaskGroupMessagesImpl.setDateTime(null);
		}
		else {
			flaskGroupMessagesImpl.setDateTime(new Date(dateTime));
		}

		flaskGroupMessagesImpl.resetOriginalValues();

		return flaskGroupMessagesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupMessagesId = objectInput.readLong();
		senderEmail = objectInput.readUTF();
		senderUserId = objectInput.readLong();
		senderName = objectInput.readUTF();
		groupId = objectInput.readLong();
		message = objectInput.readUTF();
		sendEmail = objectInput.readBoolean();
		dateTime = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(groupMessagesId);

		if (senderEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(senderEmail);
		}

		objectOutput.writeLong(senderUserId);

		if (senderName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(senderName);
		}

		objectOutput.writeLong(groupId);

		if (message == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(message);
		}

		objectOutput.writeBoolean(sendEmail);
		objectOutput.writeLong(dateTime);
	}

	public long groupMessagesId;
	public String senderEmail;
	public long senderUserId;
	public String senderName;
	public long groupId;
	public String message;
	public boolean sendEmail;
	public long dateTime;
}