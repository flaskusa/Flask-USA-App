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

import com.liferay.contacts.model.FlaskRecipients;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FlaskRecipients in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskRecipients
 * @generated
 */
public class FlaskRecipientsCacheModel implements CacheModel<FlaskRecipients>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{recipientId=");
		sb.append(recipientId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", email=");
		sb.append(email);
		sb.append(", messageId=");
		sb.append(messageId);
		sb.append(", read=");
		sb.append(read);
		sb.append(", receivedDateTime=");
		sb.append(receivedDateTime);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FlaskRecipients toEntityModel() {
		FlaskRecipientsImpl flaskRecipientsImpl = new FlaskRecipientsImpl();

		flaskRecipientsImpl.setRecipientId(recipientId);
		flaskRecipientsImpl.setUserId(userId);

		if (email == null) {
			flaskRecipientsImpl.setEmail(StringPool.BLANK);
		}
		else {
			flaskRecipientsImpl.setEmail(email);
		}

		flaskRecipientsImpl.setMessageId(messageId);
		flaskRecipientsImpl.setRead(read);

		if (receivedDateTime == Long.MIN_VALUE) {
			flaskRecipientsImpl.setReceivedDateTime(null);
		}
		else {
			flaskRecipientsImpl.setReceivedDateTime(new Date(receivedDateTime));
		}

		flaskRecipientsImpl.resetOriginalValues();

		return flaskRecipientsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		recipientId = objectInput.readLong();
		userId = objectInput.readLong();
		email = objectInput.readUTF();
		messageId = objectInput.readLong();
		read = objectInput.readBoolean();
		receivedDateTime = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(recipientId);
		objectOutput.writeLong(userId);

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(messageId);
		objectOutput.writeBoolean(read);
		objectOutput.writeLong(receivedDateTime);
	}

	public long recipientId;
	public long userId;
	public String email;
	public long messageId;
	public boolean read;
	public long receivedDateTime;
}