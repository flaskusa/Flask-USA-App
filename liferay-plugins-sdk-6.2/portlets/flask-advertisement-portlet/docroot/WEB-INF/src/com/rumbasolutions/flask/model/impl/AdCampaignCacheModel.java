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

import com.rumbasolutions.flask.model.AdCampaign;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AdCampaign in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AdCampaign
 * @generated
 */
public class AdCampaignCacheModel implements CacheModel<AdCampaign>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{campaignId=");
		sb.append(campaignId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", campaignName=");
		sb.append(campaignName);
		sb.append(", customerId=");
		sb.append(customerId);
		sb.append(", displayGeneral=");
		sb.append(displayGeneral);
		sb.append(", displayPreEvent=");
		sb.append(displayPreEvent);
		sb.append(", displayDuringEvent=");
		sb.append(displayDuringEvent);
		sb.append(", displayPostEvent=");
		sb.append(displayPostEvent);
		sb.append(", frequencyPerHour=");
		sb.append(frequencyPerHour);
		sb.append(", eventTypeId=");
		sb.append(eventTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AdCampaign toEntityModel() {
		AdCampaignImpl adCampaignImpl = new AdCampaignImpl();

		adCampaignImpl.setCampaignId(campaignId);
		adCampaignImpl.setUserId(userId);

		if (createdDate == Long.MIN_VALUE) {
			adCampaignImpl.setCreatedDate(null);
		}
		else {
			adCampaignImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			adCampaignImpl.setModifiedDate(null);
		}
		else {
			adCampaignImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (campaignName == null) {
			adCampaignImpl.setCampaignName(StringPool.BLANK);
		}
		else {
			adCampaignImpl.setCampaignName(campaignName);
		}

		adCampaignImpl.setCustomerId(customerId);
		adCampaignImpl.setDisplayGeneral(displayGeneral);
		adCampaignImpl.setDisplayPreEvent(displayPreEvent);
		adCampaignImpl.setDisplayDuringEvent(displayDuringEvent);
		adCampaignImpl.setDisplayPostEvent(displayPostEvent);
		adCampaignImpl.setFrequencyPerHour(frequencyPerHour);
		adCampaignImpl.setEventTypeId(eventTypeId);

		adCampaignImpl.resetOriginalValues();

		return adCampaignImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		campaignId = objectInput.readLong();
		userId = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		campaignName = objectInput.readUTF();
		customerId = objectInput.readLong();
		displayGeneral = objectInput.readBoolean();
		displayPreEvent = objectInput.readBoolean();
		displayDuringEvent = objectInput.readBoolean();
		displayPostEvent = objectInput.readBoolean();
		frequencyPerHour = objectInput.readLong();
		eventTypeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(campaignId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		if (campaignName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(campaignName);
		}

		objectOutput.writeLong(customerId);
		objectOutput.writeBoolean(displayGeneral);
		objectOutput.writeBoolean(displayPreEvent);
		objectOutput.writeBoolean(displayDuringEvent);
		objectOutput.writeBoolean(displayPostEvent);
		objectOutput.writeLong(frequencyPerHour);
		objectOutput.writeLong(eventTypeId);
	}

	public long campaignId;
	public long userId;
	public long createdDate;
	public long modifiedDate;
	public String campaignName;
	public long customerId;
	public boolean displayGeneral;
	public boolean displayPreEvent;
	public boolean displayDuringEvent;
	public boolean displayPostEvent;
	public long frequencyPerHour;
	public long eventTypeId;
}