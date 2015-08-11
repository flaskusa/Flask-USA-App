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

package com.rumbasolutions.flask.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.rumbasolutions.flask.service.AdCampaignLocalServiceUtil;
import com.rumbasolutions.flask.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class AdCampaignClp extends BaseModelImpl<AdCampaign>
	implements AdCampaign {
	public AdCampaignClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AdCampaign.class;
	}

	@Override
	public String getModelClassName() {
		return AdCampaign.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _campaignId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCampaignId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _campaignId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campaignId", getCampaignId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("campaignName", getCampaignName());
		attributes.put("customerId", getCustomerId());
		attributes.put("displayGeneral", getDisplayGeneral());
		attributes.put("displayPreEvent", getDisplayPreEvent());
		attributes.put("displayDuringEvent", getDisplayDuringEvent());
		attributes.put("displayPostEvent", getDisplayPostEvent());
		attributes.put("frequencyPerHour", getFrequencyPerHour());
		attributes.put("eventTypeId", getEventTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long campaignId = (Long)attributes.get("campaignId");

		if (campaignId != null) {
			setCampaignId(campaignId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String campaignName = (String)attributes.get("campaignName");

		if (campaignName != null) {
			setCampaignName(campaignName);
		}

		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		Boolean displayGeneral = (Boolean)attributes.get("displayGeneral");

		if (displayGeneral != null) {
			setDisplayGeneral(displayGeneral);
		}

		Boolean displayPreEvent = (Boolean)attributes.get("displayPreEvent");

		if (displayPreEvent != null) {
			setDisplayPreEvent(displayPreEvent);
		}

		Boolean displayDuringEvent = (Boolean)attributes.get(
				"displayDuringEvent");

		if (displayDuringEvent != null) {
			setDisplayDuringEvent(displayDuringEvent);
		}

		Boolean displayPostEvent = (Boolean)attributes.get("displayPostEvent");

		if (displayPostEvent != null) {
			setDisplayPostEvent(displayPostEvent);
		}

		Long frequencyPerHour = (Long)attributes.get("frequencyPerHour");

		if (frequencyPerHour != null) {
			setFrequencyPerHour(frequencyPerHour);
		}

		Long eventTypeId = (Long)attributes.get("eventTypeId");

		if (eventTypeId != null) {
			setEventTypeId(eventTypeId);
		}
	}

	@Override
	public long getCampaignId() {
		return _campaignId;
	}

	@Override
	public void setCampaignId(long campaignId) {
		_campaignId = campaignId;

		if (_adCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _adCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setCampaignId", long.class);

				method.invoke(_adCampaignRemoteModel, campaignId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_adCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _adCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_adCampaignRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_adCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _adCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_adCampaignRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_adCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _adCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_adCampaignRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCampaignName() {
		return _campaignName;
	}

	@Override
	public void setCampaignName(String campaignName) {
		_campaignName = campaignName;

		if (_adCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _adCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setCampaignName", String.class);

				method.invoke(_adCampaignRemoteModel, campaignName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCustomerId() {
		return _customerId;
	}

	@Override
	public void setCustomerId(long customerId) {
		_customerId = customerId;

		if (_adCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _adCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomerId", long.class);

				method.invoke(_adCampaignRemoteModel, customerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDisplayGeneral() {
		return _displayGeneral;
	}

	@Override
	public boolean isDisplayGeneral() {
		return _displayGeneral;
	}

	@Override
	public void setDisplayGeneral(boolean displayGeneral) {
		_displayGeneral = displayGeneral;

		if (_adCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _adCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayGeneral",
						boolean.class);

				method.invoke(_adCampaignRemoteModel, displayGeneral);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDisplayPreEvent() {
		return _displayPreEvent;
	}

	@Override
	public boolean isDisplayPreEvent() {
		return _displayPreEvent;
	}

	@Override
	public void setDisplayPreEvent(boolean displayPreEvent) {
		_displayPreEvent = displayPreEvent;

		if (_adCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _adCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayPreEvent",
						boolean.class);

				method.invoke(_adCampaignRemoteModel, displayPreEvent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDisplayDuringEvent() {
		return _displayDuringEvent;
	}

	@Override
	public boolean isDisplayDuringEvent() {
		return _displayDuringEvent;
	}

	@Override
	public void setDisplayDuringEvent(boolean displayDuringEvent) {
		_displayDuringEvent = displayDuringEvent;

		if (_adCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _adCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayDuringEvent",
						boolean.class);

				method.invoke(_adCampaignRemoteModel, displayDuringEvent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDisplayPostEvent() {
		return _displayPostEvent;
	}

	@Override
	public boolean isDisplayPostEvent() {
		return _displayPostEvent;
	}

	@Override
	public void setDisplayPostEvent(boolean displayPostEvent) {
		_displayPostEvent = displayPostEvent;

		if (_adCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _adCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayPostEvent",
						boolean.class);

				method.invoke(_adCampaignRemoteModel, displayPostEvent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFrequencyPerHour() {
		return _frequencyPerHour;
	}

	@Override
	public void setFrequencyPerHour(long frequencyPerHour) {
		_frequencyPerHour = frequencyPerHour;

		if (_adCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _adCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setFrequencyPerHour",
						long.class);

				method.invoke(_adCampaignRemoteModel, frequencyPerHour);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEventTypeId() {
		return _eventTypeId;
	}

	@Override
	public void setEventTypeId(long eventTypeId) {
		_eventTypeId = eventTypeId;

		if (_adCampaignRemoteModel != null) {
			try {
				Class<?> clazz = _adCampaignRemoteModel.getClass();

				Method method = clazz.getMethod("setEventTypeId", long.class);

				method.invoke(_adCampaignRemoteModel, eventTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAdCampaignRemoteModel() {
		return _adCampaignRemoteModel;
	}

	public void setAdCampaignRemoteModel(BaseModel<?> adCampaignRemoteModel) {
		_adCampaignRemoteModel = adCampaignRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _adCampaignRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_adCampaignRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AdCampaignLocalServiceUtil.addAdCampaign(this);
		}
		else {
			AdCampaignLocalServiceUtil.updateAdCampaign(this);
		}
	}

	@Override
	public AdCampaign toEscapedModel() {
		return (AdCampaign)ProxyUtil.newProxyInstance(AdCampaign.class.getClassLoader(),
			new Class[] { AdCampaign.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AdCampaignClp clone = new AdCampaignClp();

		clone.setCampaignId(getCampaignId());
		clone.setUserId(getUserId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCampaignName(getCampaignName());
		clone.setCustomerId(getCustomerId());
		clone.setDisplayGeneral(getDisplayGeneral());
		clone.setDisplayPreEvent(getDisplayPreEvent());
		clone.setDisplayDuringEvent(getDisplayDuringEvent());
		clone.setDisplayPostEvent(getDisplayPostEvent());
		clone.setFrequencyPerHour(getFrequencyPerHour());
		clone.setEventTypeId(getEventTypeId());

		return clone;
	}

	@Override
	public int compareTo(AdCampaign adCampaign) {
		int value = 0;

		value = getCampaignName().compareTo(adCampaign.getCampaignName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdCampaignClp)) {
			return false;
		}

		AdCampaignClp adCampaign = (AdCampaignClp)obj;

		long primaryKey = adCampaign.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{campaignId=");
		sb.append(getCampaignId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", campaignName=");
		sb.append(getCampaignName());
		sb.append(", customerId=");
		sb.append(getCustomerId());
		sb.append(", displayGeneral=");
		sb.append(getDisplayGeneral());
		sb.append(", displayPreEvent=");
		sb.append(getDisplayPreEvent());
		sb.append(", displayDuringEvent=");
		sb.append(getDisplayDuringEvent());
		sb.append(", displayPostEvent=");
		sb.append(getDisplayPostEvent());
		sb.append(", frequencyPerHour=");
		sb.append(getFrequencyPerHour());
		sb.append(", eventTypeId=");
		sb.append(getEventTypeId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.AdCampaign");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>campaignId</column-name><column-value><![CDATA[");
		sb.append(getCampaignId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>campaignName</column-name><column-value><![CDATA[");
		sb.append(getCampaignName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customerId</column-name><column-value><![CDATA[");
		sb.append(getCustomerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayGeneral</column-name><column-value><![CDATA[");
		sb.append(getDisplayGeneral());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayPreEvent</column-name><column-value><![CDATA[");
		sb.append(getDisplayPreEvent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayDuringEvent</column-name><column-value><![CDATA[");
		sb.append(getDisplayDuringEvent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayPostEvent</column-name><column-value><![CDATA[");
		sb.append(getDisplayPostEvent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>frequencyPerHour</column-name><column-value><![CDATA[");
		sb.append(getFrequencyPerHour());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventTypeId</column-name><column-value><![CDATA[");
		sb.append(getEventTypeId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _campaignId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _campaignName;
	private long _customerId;
	private boolean _displayGeneral;
	private boolean _displayPreEvent;
	private boolean _displayDuringEvent;
	private boolean _displayPostEvent;
	private long _frequencyPerHour;
	private long _eventTypeId;
	private BaseModel<?> _adCampaignRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}