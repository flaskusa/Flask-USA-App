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

import com.liferay.contacts.model.FlaskMessages;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FlaskMessages in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskMessages
 * @generated
 */
public class FlaskMessagesCacheModel implements CacheModel<FlaskMessages>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{messageId=");
		sb.append(messageId);
		sb.append(", senderEmail=");
		sb.append(senderEmail);
		sb.append(", senderUserId=");
		sb.append(senderUserId);
		sb.append(", senderName=");
		sb.append(senderName);
		sb.append(", recipients=");
		sb.append(recipients);
		sb.append(", message=");
		sb.append(message);
		sb.append(", sendEmail=");
		sb.append(sendEmail);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FlaskMessages toEntityModel() {
		FlaskMessagesImpl flaskMessagesImpl = new FlaskMessagesImpl();

		flaskMessagesImpl.setMessageId(messageId);

		if (senderEmail == null) {
			flaskMessagesImpl.setSenderEmail(StringPool.BLANK);
		}
		else {
			flaskMessagesImpl.setSenderEmail(senderEmail);
		}

		flaskMessagesImpl.setSenderUserId(senderUserId);

		if (senderName == null) {
			flaskMessagesImpl.setSenderName(StringPool.BLANK);
		}
		else {
			flaskMessagesImpl.setSenderName(senderName);
		}

		if (recipients == null) {
			flaskMessagesImpl.setRecipients(StringPool.BLANK);
		}
		else {
			flaskMessagesImpl.setRecipients(recipients);
		}

		if (message == null) {
			flaskMessagesImpl.setMessage(StringPool.BLANK);
		}
		else {
			flaskMessagesImpl.setMessage(message);
		}

		flaskMessagesImpl.setSendEmail(sendEmail);

		flaskMessagesImpl.resetOriginalValues();

		return flaskMessagesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		messageId = objectInput.readLong();
		senderEmail = objectInput.readUTF();
		senderUserId = objectInput.readLong();
		senderName = objectInput.readUTF();
		recipients = objectInput.readUTF();
		message = objectInput.readUTF();
		sendEmail = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(messageId);

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

		if (recipients == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(recipients);
		}

		if (message == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(message);
		}

		objectOutput.writeBoolean(sendEmail);
	}

	public long messageId;
	public String senderEmail;
	public long senderUserId;
	public String senderName;
	public String recipients;
	public String message;
	public boolean sendEmail;
}