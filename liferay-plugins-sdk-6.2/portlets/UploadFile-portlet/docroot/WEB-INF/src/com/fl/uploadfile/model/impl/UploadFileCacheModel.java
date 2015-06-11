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

package com.fl.uploadfile.model.impl;

import com.fl.uploadfile.model.UploadFile;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UploadFile in entity cache.
 *
 * @author Manisha
 * @see UploadFile
 * @generated
 */
public class UploadFileCacheModel implements CacheModel<UploadFile>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{fileUploadId=");
		sb.append(fileUploadId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", size=");
		sb.append(size);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UploadFile toEntityModel() {
		UploadFileImpl uploadFileImpl = new UploadFileImpl();

		uploadFileImpl.setFileUploadId(fileUploadId);
		uploadFileImpl.setFileEntryId(fileEntryId);

		if (title == null) {
			uploadFileImpl.setTitle(StringPool.BLANK);
		}
		else {
			uploadFileImpl.setTitle(title);
		}

		if (description == null) {
			uploadFileImpl.setDescription(StringPool.BLANK);
		}
		else {
			uploadFileImpl.setDescription(description);
		}

		uploadFileImpl.setSize(size);

		uploadFileImpl.resetOriginalValues();

		return uploadFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fileUploadId = objectInput.readLong();
		fileEntryId = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		size = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(fileUploadId);
		objectOutput.writeLong(fileEntryId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(size);
	}

	public long fileUploadId;
	public long fileEntryId;
	public String title;
	public String description;
	public long size;
}