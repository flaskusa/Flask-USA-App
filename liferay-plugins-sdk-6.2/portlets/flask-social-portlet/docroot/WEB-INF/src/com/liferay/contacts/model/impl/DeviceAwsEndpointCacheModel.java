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

import com.liferay.contacts.model.DeviceAwsEndpoint;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing DeviceAwsEndpoint in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see DeviceAwsEndpoint
 * @generated
 */
public class DeviceAwsEndpointCacheModel implements CacheModel<DeviceAwsEndpoint>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{deviceEndPointId=");
		sb.append(deviceEndPointId);
		sb.append(", awsEndpoint=");
		sb.append(awsEndpoint);
		sb.append(", userDeviceRegistrationId=");
		sb.append(userDeviceRegistrationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DeviceAwsEndpoint toEntityModel() {
		DeviceAwsEndpointImpl deviceAwsEndpointImpl = new DeviceAwsEndpointImpl();

		deviceAwsEndpointImpl.setDeviceEndPointId(deviceEndPointId);

		if (awsEndpoint == null) {
			deviceAwsEndpointImpl.setAwsEndpoint(StringPool.BLANK);
		}
		else {
			deviceAwsEndpointImpl.setAwsEndpoint(awsEndpoint);
		}

		deviceAwsEndpointImpl.setUserDeviceRegistrationId(userDeviceRegistrationId);

		deviceAwsEndpointImpl.resetOriginalValues();

		return deviceAwsEndpointImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		deviceEndPointId = objectInput.readLong();
		awsEndpoint = objectInput.readUTF();
		userDeviceRegistrationId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(deviceEndPointId);

		if (awsEndpoint == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(awsEndpoint);
		}

		objectOutput.writeLong(userDeviceRegistrationId);
	}

	public long deviceEndPointId;
	public String awsEndpoint;
	public long userDeviceRegistrationId;
}