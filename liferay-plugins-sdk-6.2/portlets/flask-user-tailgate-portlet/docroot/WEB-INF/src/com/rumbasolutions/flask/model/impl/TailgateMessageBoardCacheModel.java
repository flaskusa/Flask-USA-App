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

package com.rumbasolutions.flask.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rumbasolutions.flask.model.TailgateMessageBoard;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TailgateMessageBoard in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see TailgateMessageBoard
 * @generated
 */
public class TailgateMessageBoardCacheModel implements CacheModel<TailgateMessageBoard>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{tailgateMessageId=");
		sb.append(tailgateMessageId);
		sb.append(", messageText=");
		sb.append(messageText);
		sb.append(", tailgateId=");
		sb.append(tailgateId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TailgateMessageBoard toEntityModel() {
		TailgateMessageBoardImpl tailgateMessageBoardImpl = new TailgateMessageBoardImpl();

		tailgateMessageBoardImpl.setTailgateMessageId(tailgateMessageId);

		if (messageText == null) {
			tailgateMessageBoardImpl.setMessageText(StringPool.BLANK);
		}
		else {
			tailgateMessageBoardImpl.setMessageText(messageText);
		}

		tailgateMessageBoardImpl.setTailgateId(tailgateId);
		tailgateMessageBoardImpl.setCompanyId(companyId);
		tailgateMessageBoardImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			tailgateMessageBoardImpl.setCreatedDate(null);
		}
		else {
			tailgateMessageBoardImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tailgateMessageBoardImpl.setModifiedDate(null);
		}
		else {
			tailgateMessageBoardImpl.setModifiedDate(new Date(modifiedDate));
		}

		tailgateMessageBoardImpl.resetOriginalValues();

		return tailgateMessageBoardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tailgateMessageId = objectInput.readLong();
		messageText = objectInput.readUTF();
		tailgateId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(tailgateMessageId);

		if (messageText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(messageText);
		}

		objectOutput.writeLong(tailgateId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long tailgateMessageId;
	public String messageText;
	public long tailgateId;
	public long companyId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
}