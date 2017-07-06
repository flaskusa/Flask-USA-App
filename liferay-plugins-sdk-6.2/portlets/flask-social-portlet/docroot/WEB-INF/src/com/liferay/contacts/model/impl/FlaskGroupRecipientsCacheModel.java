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

import com.liferay.contacts.model.FlaskGroupRecipients;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FlaskGroupRecipients in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupRecipients
 * @generated
 */
public class FlaskGroupRecipientsCacheModel implements CacheModel<FlaskGroupRecipients>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{groupRecipientId=");
		sb.append(groupRecipientId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", recipients=");
		sb.append(recipients);
		sb.append(", groupMessageId=");
		sb.append(groupMessageId);
		sb.append(", read=");
		sb.append(read);
		sb.append(", receivedDateTime=");
		sb.append(receivedDateTime);
		sb.append(", senderId=");
		sb.append(senderId);
		sb.append(", messageStatusInfo=");
		sb.append(messageStatusInfo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FlaskGroupRecipients toEntityModel() {
		FlaskGroupRecipientsImpl flaskGroupRecipientsImpl = new FlaskGroupRecipientsImpl();

		flaskGroupRecipientsImpl.setGroupRecipientId(groupRecipientId);
		flaskGroupRecipientsImpl.setGroupId(groupId);

		if (recipients == null) {
			flaskGroupRecipientsImpl.setRecipients(StringPool.BLANK);
		}
		else {
			flaskGroupRecipientsImpl.setRecipients(recipients);
		}

		flaskGroupRecipientsImpl.setGroupMessageId(groupMessageId);

		if (read == null) {
			flaskGroupRecipientsImpl.setRead(StringPool.BLANK);
		}
		else {
			flaskGroupRecipientsImpl.setRead(read);
		}

		if (receivedDateTime == Long.MIN_VALUE) {
			flaskGroupRecipientsImpl.setReceivedDateTime(null);
		}
		else {
			flaskGroupRecipientsImpl.setReceivedDateTime(new Date(
					receivedDateTime));
		}

		flaskGroupRecipientsImpl.setSenderId(senderId);

		if (messageStatusInfo == null) {
			flaskGroupRecipientsImpl.setMessageStatusInfo(StringPool.BLANK);
		}
		else {
			flaskGroupRecipientsImpl.setMessageStatusInfo(messageStatusInfo);
		}

		flaskGroupRecipientsImpl.resetOriginalValues();

		return flaskGroupRecipientsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupRecipientId = objectInput.readLong();
		groupId = objectInput.readLong();
		recipients = objectInput.readUTF();
		groupMessageId = objectInput.readLong();
		read = objectInput.readUTF();
		receivedDateTime = objectInput.readLong();
		senderId = objectInput.readLong();
		messageStatusInfo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(groupRecipientId);
		objectOutput.writeLong(groupId);

		if (recipients == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(recipients);
		}

		objectOutput.writeLong(groupMessageId);

		if (read == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(read);
		}

		objectOutput.writeLong(receivedDateTime);
		objectOutput.writeLong(senderId);

		if (messageStatusInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(messageStatusInfo);
		}
	}

	public long groupRecipientId;
	public long groupId;
	public String recipients;
	public long groupMessageId;
	public String read;
	public long receivedDateTime;
	public long senderId;
	public String messageStatusInfo;
}