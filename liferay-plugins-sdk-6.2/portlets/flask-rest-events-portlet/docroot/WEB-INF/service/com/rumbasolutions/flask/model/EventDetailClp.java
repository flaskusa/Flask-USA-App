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

import com.rumbasolutions.flask.service.ClpSerializer;
import com.rumbasolutions.flask.service.EventDetailLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ashutosh Rai
 */
public class EventDetailClp extends BaseModelImpl<EventDetail>
	implements EventDetail {
	public EventDetailClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EventDetail.class;
	}

	@Override
	public String getModelClassName() {
		return EventDetail.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _eventDetailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventDetailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventDetailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventDetailId", getEventDetailId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventId", getEventId());
		attributes.put("infoTypeId", getInfoTypeId());
		attributes.put("infoTypeCategoryId", getInfoTypeCategoryId());
		attributes.put("eventDetailInfoName", getEventDetailInfoName());
		attributes.put("eventDetailInfoDesc", getEventDetailInfoDesc());
		attributes.put("eventDetailInfoComment", getEventDetailInfoComment());
		attributes.put("eventDetailAddressLine1", getEventDetailAddressLine1());
		attributes.put("eventDetailAddressLine2", getEventDetailAddressLine2());
		attributes.put("eventDetailInfocity", getEventDetailInfocity());
		attributes.put("eventDetailZip", getEventDetailZip());
		attributes.put("eventDetailState", getEventDetailState());
		attributes.put("eventDetailCountry", getEventDetailCountry());
		attributes.put("eventDetailLatitude", getEventDetailLatitude());
		attributes.put("eventDetailLongitude", getEventDetailLongitude());
		attributes.put("eventDetailPhone", getEventDetailPhone());
		attributes.put("eventDetailWebsite", getEventDetailWebsite());
		attributes.put("eventDetailCost", getEventDetailCost());
		attributes.put("hoursOfOperation", getHoursOfOperation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventDetailId = (Long)attributes.get("eventDetailId");

		if (eventDetailId != null) {
			setEventDetailId(eventDetailId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Long infoTypeId = (Long)attributes.get("infoTypeId");

		if (infoTypeId != null) {
			setInfoTypeId(infoTypeId);
		}

		Long infoTypeCategoryId = (Long)attributes.get("infoTypeCategoryId");

		if (infoTypeCategoryId != null) {
			setInfoTypeCategoryId(infoTypeCategoryId);
		}

		String eventDetailInfoName = (String)attributes.get(
				"eventDetailInfoName");

		if (eventDetailInfoName != null) {
			setEventDetailInfoName(eventDetailInfoName);
		}

		String eventDetailInfoDesc = (String)attributes.get(
				"eventDetailInfoDesc");

		if (eventDetailInfoDesc != null) {
			setEventDetailInfoDesc(eventDetailInfoDesc);
		}

		String eventDetailInfoComment = (String)attributes.get(
				"eventDetailInfoComment");

		if (eventDetailInfoComment != null) {
			setEventDetailInfoComment(eventDetailInfoComment);
		}

		String eventDetailAddressLine1 = (String)attributes.get(
				"eventDetailAddressLine1");

		if (eventDetailAddressLine1 != null) {
			setEventDetailAddressLine1(eventDetailAddressLine1);
		}

		String eventDetailAddressLine2 = (String)attributes.get(
				"eventDetailAddressLine2");

		if (eventDetailAddressLine2 != null) {
			setEventDetailAddressLine2(eventDetailAddressLine2);
		}

		String eventDetailInfocity = (String)attributes.get(
				"eventDetailInfocity");

		if (eventDetailInfocity != null) {
			setEventDetailInfocity(eventDetailInfocity);
		}

		String eventDetailZip = (String)attributes.get("eventDetailZip");

		if (eventDetailZip != null) {
			setEventDetailZip(eventDetailZip);
		}

		String eventDetailState = (String)attributes.get("eventDetailState");

		if (eventDetailState != null) {
			setEventDetailState(eventDetailState);
		}

		String eventDetailCountry = (String)attributes.get("eventDetailCountry");

		if (eventDetailCountry != null) {
			setEventDetailCountry(eventDetailCountry);
		}

		String eventDetailLatitude = (String)attributes.get(
				"eventDetailLatitude");

		if (eventDetailLatitude != null) {
			setEventDetailLatitude(eventDetailLatitude);
		}

		String eventDetailLongitude = (String)attributes.get(
				"eventDetailLongitude");

		if (eventDetailLongitude != null) {
			setEventDetailLongitude(eventDetailLongitude);
		}

		String eventDetailPhone = (String)attributes.get("eventDetailPhone");

		if (eventDetailPhone != null) {
			setEventDetailPhone(eventDetailPhone);
		}

		String eventDetailWebsite = (String)attributes.get("eventDetailWebsite");

		if (eventDetailWebsite != null) {
			setEventDetailWebsite(eventDetailWebsite);
		}

		Double eventDetailCost = (Double)attributes.get("eventDetailCost");

		if (eventDetailCost != null) {
			setEventDetailCost(eventDetailCost);
		}

		String hoursOfOperation = (String)attributes.get("hoursOfOperation");

		if (hoursOfOperation != null) {
			setHoursOfOperation(hoursOfOperation);
		}
	}

	@Override
	public long getEventDetailId() {
		return _eventDetailId;
	}

	@Override
	public void setEventDetailId(long eventDetailId) {
		_eventDetailId = eventDetailId;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailId", long.class);

				method.invoke(_eventDetailRemoteModel, eventDetailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_eventDetailRemoteModel, companyId);
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

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_eventDetailRemoteModel, userId);
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

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_eventDetailRemoteModel, createdDate);
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

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_eventDetailRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEventId() {
		return _eventId;
	}

	@Override
	public void setEventId(long eventId) {
		_eventId = eventId;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventId", long.class);

				method.invoke(_eventDetailRemoteModel, eventId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInfoTypeId() {
		return _infoTypeId;
	}

	@Override
	public void setInfoTypeId(long infoTypeId) {
		_infoTypeId = infoTypeId;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setInfoTypeId", long.class);

				method.invoke(_eventDetailRemoteModel, infoTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInfoTypeCategoryId() {
		return _infoTypeCategoryId;
	}

	@Override
	public void setInfoTypeCategoryId(long infoTypeCategoryId) {
		_infoTypeCategoryId = infoTypeCategoryId;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setInfoTypeCategoryId",
						long.class);

				method.invoke(_eventDetailRemoteModel, infoTypeCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventDetailInfoName() {
		return _eventDetailInfoName;
	}

	@Override
	public void setEventDetailInfoName(String eventDetailInfoName) {
		_eventDetailInfoName = eventDetailInfoName;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailInfoName",
						String.class);

				method.invoke(_eventDetailRemoteModel, eventDetailInfoName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventDetailInfoDesc() {
		return _eventDetailInfoDesc;
	}

	@Override
	public void setEventDetailInfoDesc(String eventDetailInfoDesc) {
		_eventDetailInfoDesc = eventDetailInfoDesc;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailInfoDesc",
						String.class);

				method.invoke(_eventDetailRemoteModel, eventDetailInfoDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventDetailInfoComment() {
		return _eventDetailInfoComment;
	}

	@Override
	public void setEventDetailInfoComment(String eventDetailInfoComment) {
		_eventDetailInfoComment = eventDetailInfoComment;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailInfoComment",
						String.class);

				method.invoke(_eventDetailRemoteModel, eventDetailInfoComment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventDetailAddressLine1() {
		return _eventDetailAddressLine1;
	}

	@Override
	public void setEventDetailAddressLine1(String eventDetailAddressLine1) {
		_eventDetailAddressLine1 = eventDetailAddressLine1;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailAddressLine1",
						String.class);

				method.invoke(_eventDetailRemoteModel, eventDetailAddressLine1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventDetailAddressLine2() {
		return _eventDetailAddressLine2;
	}

	@Override
	public void setEventDetailAddressLine2(String eventDetailAddressLine2) {
		_eventDetailAddressLine2 = eventDetailAddressLine2;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailAddressLine2",
						String.class);

				method.invoke(_eventDetailRemoteModel, eventDetailAddressLine2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventDetailInfocity() {
		return _eventDetailInfocity;
	}

	@Override
	public void setEventDetailInfocity(String eventDetailInfocity) {
		_eventDetailInfocity = eventDetailInfocity;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailInfocity",
						String.class);

				method.invoke(_eventDetailRemoteModel, eventDetailInfocity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventDetailZip() {
		return _eventDetailZip;
	}

	@Override
	public void setEventDetailZip(String eventDetailZip) {
		_eventDetailZip = eventDetailZip;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailZip",
						String.class);

				method.invoke(_eventDetailRemoteModel, eventDetailZip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventDetailState() {
		return _eventDetailState;
	}

	@Override
	public void setEventDetailState(String eventDetailState) {
		_eventDetailState = eventDetailState;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailState",
						String.class);

				method.invoke(_eventDetailRemoteModel, eventDetailState);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventDetailCountry() {
		return _eventDetailCountry;
	}

	@Override
	public void setEventDetailCountry(String eventDetailCountry) {
		_eventDetailCountry = eventDetailCountry;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailCountry",
						String.class);

				method.invoke(_eventDetailRemoteModel, eventDetailCountry);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventDetailLatitude() {
		return _eventDetailLatitude;
	}

	@Override
	public void setEventDetailLatitude(String eventDetailLatitude) {
		_eventDetailLatitude = eventDetailLatitude;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailLatitude",
						String.class);

				method.invoke(_eventDetailRemoteModel, eventDetailLatitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventDetailLongitude() {
		return _eventDetailLongitude;
	}

	@Override
	public void setEventDetailLongitude(String eventDetailLongitude) {
		_eventDetailLongitude = eventDetailLongitude;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailLongitude",
						String.class);

				method.invoke(_eventDetailRemoteModel, eventDetailLongitude);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventDetailPhone() {
		return _eventDetailPhone;
	}

	@Override
	public void setEventDetailPhone(String eventDetailPhone) {
		_eventDetailPhone = eventDetailPhone;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailPhone",
						String.class);

				method.invoke(_eventDetailRemoteModel, eventDetailPhone);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventDetailWebsite() {
		return _eventDetailWebsite;
	}

	@Override
	public void setEventDetailWebsite(String eventDetailWebsite) {
		_eventDetailWebsite = eventDetailWebsite;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailWebsite",
						String.class);

				method.invoke(_eventDetailRemoteModel, eventDetailWebsite);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getEventDetailCost() {
		return _eventDetailCost;
	}

	@Override
	public void setEventDetailCost(double eventDetailCost) {
		_eventDetailCost = eventDetailCost;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEventDetailCost",
						double.class);

				method.invoke(_eventDetailRemoteModel, eventDetailCost);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHoursOfOperation() {
		return _hoursOfOperation;
	}

	@Override
	public void setHoursOfOperation(String hoursOfOperation) {
		_hoursOfOperation = hoursOfOperation;

		if (_eventDetailRemoteModel != null) {
			try {
				Class<?> clazz = _eventDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setHoursOfOperation",
						String.class);

				method.invoke(_eventDetailRemoteModel, hoursOfOperation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEventDetailRemoteModel() {
		return _eventDetailRemoteModel;
	}

	public void setEventDetailRemoteModel(BaseModel<?> eventDetailRemoteModel) {
		_eventDetailRemoteModel = eventDetailRemoteModel;
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

		Class<?> remoteModelClass = _eventDetailRemoteModel.getClass();

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

		Object returnValue = method.invoke(_eventDetailRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EventDetailLocalServiceUtil.addEventDetail(this);
		}
		else {
			EventDetailLocalServiceUtil.updateEventDetail(this);
		}
	}

	@Override
	public EventDetail toEscapedModel() {
		return (EventDetail)ProxyUtil.newProxyInstance(EventDetail.class.getClassLoader(),
			new Class[] { EventDetail.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EventDetailClp clone = new EventDetailClp();

		clone.setEventDetailId(getEventDetailId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEventId(getEventId());
		clone.setInfoTypeId(getInfoTypeId());
		clone.setInfoTypeCategoryId(getInfoTypeCategoryId());
		clone.setEventDetailInfoName(getEventDetailInfoName());
		clone.setEventDetailInfoDesc(getEventDetailInfoDesc());
		clone.setEventDetailInfoComment(getEventDetailInfoComment());
		clone.setEventDetailAddressLine1(getEventDetailAddressLine1());
		clone.setEventDetailAddressLine2(getEventDetailAddressLine2());
		clone.setEventDetailInfocity(getEventDetailInfocity());
		clone.setEventDetailZip(getEventDetailZip());
		clone.setEventDetailState(getEventDetailState());
		clone.setEventDetailCountry(getEventDetailCountry());
		clone.setEventDetailLatitude(getEventDetailLatitude());
		clone.setEventDetailLongitude(getEventDetailLongitude());
		clone.setEventDetailPhone(getEventDetailPhone());
		clone.setEventDetailWebsite(getEventDetailWebsite());
		clone.setEventDetailCost(getEventDetailCost());
		clone.setHoursOfOperation(getHoursOfOperation());

		return clone;
	}

	@Override
	public int compareTo(EventDetail eventDetail) {
		long primaryKey = eventDetail.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventDetailClp)) {
			return false;
		}

		EventDetailClp eventDetail = (EventDetailClp)obj;

		long primaryKey = eventDetail.getPrimaryKey();

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
		StringBundler sb = new StringBundler(47);

		sb.append("{eventDetailId=");
		sb.append(getEventDetailId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", eventId=");
		sb.append(getEventId());
		sb.append(", infoTypeId=");
		sb.append(getInfoTypeId());
		sb.append(", infoTypeCategoryId=");
		sb.append(getInfoTypeCategoryId());
		sb.append(", eventDetailInfoName=");
		sb.append(getEventDetailInfoName());
		sb.append(", eventDetailInfoDesc=");
		sb.append(getEventDetailInfoDesc());
		sb.append(", eventDetailInfoComment=");
		sb.append(getEventDetailInfoComment());
		sb.append(", eventDetailAddressLine1=");
		sb.append(getEventDetailAddressLine1());
		sb.append(", eventDetailAddressLine2=");
		sb.append(getEventDetailAddressLine2());
		sb.append(", eventDetailInfocity=");
		sb.append(getEventDetailInfocity());
		sb.append(", eventDetailZip=");
		sb.append(getEventDetailZip());
		sb.append(", eventDetailState=");
		sb.append(getEventDetailState());
		sb.append(", eventDetailCountry=");
		sb.append(getEventDetailCountry());
		sb.append(", eventDetailLatitude=");
		sb.append(getEventDetailLatitude());
		sb.append(", eventDetailLongitude=");
		sb.append(getEventDetailLongitude());
		sb.append(", eventDetailPhone=");
		sb.append(getEventDetailPhone());
		sb.append(", eventDetailWebsite=");
		sb.append(getEventDetailWebsite());
		sb.append(", eventDetailCost=");
		sb.append(getEventDetailCost());
		sb.append(", hoursOfOperation=");
		sb.append(getHoursOfOperation());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.EventDetail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventDetailId</column-name><column-value><![CDATA[");
		sb.append(getEventDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoTypeId</column-name><column-value><![CDATA[");
		sb.append(getInfoTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoTypeCategoryId</column-name><column-value><![CDATA[");
		sb.append(getInfoTypeCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailInfoName</column-name><column-value><![CDATA[");
		sb.append(getEventDetailInfoName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailInfoDesc</column-name><column-value><![CDATA[");
		sb.append(getEventDetailInfoDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailInfoComment</column-name><column-value><![CDATA[");
		sb.append(getEventDetailInfoComment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailAddressLine1</column-name><column-value><![CDATA[");
		sb.append(getEventDetailAddressLine1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailAddressLine2</column-name><column-value><![CDATA[");
		sb.append(getEventDetailAddressLine2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailInfocity</column-name><column-value><![CDATA[");
		sb.append(getEventDetailInfocity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailZip</column-name><column-value><![CDATA[");
		sb.append(getEventDetailZip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailState</column-name><column-value><![CDATA[");
		sb.append(getEventDetailState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailCountry</column-name><column-value><![CDATA[");
		sb.append(getEventDetailCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailLatitude</column-name><column-value><![CDATA[");
		sb.append(getEventDetailLatitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailLongitude</column-name><column-value><![CDATA[");
		sb.append(getEventDetailLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailPhone</column-name><column-value><![CDATA[");
		sb.append(getEventDetailPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailWebsite</column-name><column-value><![CDATA[");
		sb.append(getEventDetailWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDetailCost</column-name><column-value><![CDATA[");
		sb.append(getEventDetailCost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoursOfOperation</column-name><column-value><![CDATA[");
		sb.append(getHoursOfOperation());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _eventDetailId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _eventId;
	private long _infoTypeId;
	private long _infoTypeCategoryId;
	private String _eventDetailInfoName;
	private String _eventDetailInfoDesc;
	private String _eventDetailInfoComment;
	private String _eventDetailAddressLine1;
	private String _eventDetailAddressLine2;
	private String _eventDetailInfocity;
	private String _eventDetailZip;
	private String _eventDetailState;
	private String _eventDetailCountry;
	private String _eventDetailLatitude;
	private String _eventDetailLongitude;
	private String _eventDetailPhone;
	private String _eventDetailWebsite;
	private double _eventDetailCost;
	private String _hoursOfOperation;
	private BaseModel<?> _eventDetailRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}