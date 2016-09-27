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
import com.rumbasolutions.flask.service.TailgateInfoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class TailgateInfoClp extends BaseModelImpl<TailgateInfo>
	implements TailgateInfo {
	public TailgateInfoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TailgateInfo.class;
	}

	@Override
	public String getModelClassName() {
		return TailgateInfo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _tailgateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTailgateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tailgateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tailgateId", getTailgateId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("tailgateName", getTailgateName());
		attributes.put("tailgateDescription", getTailgateDescription());
		attributes.put("eventId", getEventId());
		attributes.put("eventName", getEventName());
		attributes.put("tailgateDate", getTailgateDate());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("isActive", getIsActive());
		attributes.put("isDelete", getIsDelete());
		attributes.put("venmoAccountId", getVenmoAccountId());
		attributes.put("amountToPay", getAmountToPay());
		attributes.put("logoId", getLogoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tailgateId = (Long)attributes.get("tailgateId");

		if (tailgateId != null) {
			setTailgateId(tailgateId);
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

		String tailgateName = (String)attributes.get("tailgateName");

		if (tailgateName != null) {
			setTailgateName(tailgateName);
		}

		String tailgateDescription = (String)attributes.get(
				"tailgateDescription");

		if (tailgateDescription != null) {
			setTailgateDescription(tailgateDescription);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		String eventName = (String)attributes.get("eventName");

		if (eventName != null) {
			setEventName(eventName);
		}

		Date tailgateDate = (Date)attributes.get("tailgateDate");

		if (tailgateDate != null) {
			setTailgateDate(tailgateDate);
		}

		Long startTime = (Long)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Long endTime = (Long)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Integer isActive = (Integer)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		Integer isDelete = (Integer)attributes.get("isDelete");

		if (isDelete != null) {
			setIsDelete(isDelete);
		}

		String venmoAccountId = (String)attributes.get("venmoAccountId");

		if (venmoAccountId != null) {
			setVenmoAccountId(venmoAccountId);
		}

		Double amountToPay = (Double)attributes.get("amountToPay");

		if (amountToPay != null) {
			setAmountToPay(amountToPay);
		}

		Long logoId = (Long)attributes.get("logoId");

		if (logoId != null) {
			setLogoId(logoId);
		}
	}

	@Override
	public long getTailgateId() {
		return _tailgateId;
	}

	@Override
	public void setTailgateId(long tailgateId) {
		_tailgateId = tailgateId;

		if (_tailgateInfoRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgateId", long.class);

				method.invoke(_tailgateInfoRemoteModel, tailgateId);
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

		if (_tailgateInfoRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_tailgateInfoRemoteModel, companyId);
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

		if (_tailgateInfoRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_tailgateInfoRemoteModel, userId);
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

		if (_tailgateInfoRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_tailgateInfoRemoteModel, createdDate);
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

		if (_tailgateInfoRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_tailgateInfoRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTailgateName() {
		return _tailgateName;
	}

	@Override
	public void setTailgateName(String tailgateName) {
		_tailgateName = tailgateName;

		if (_tailgateInfoRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgateName", String.class);

				method.invoke(_tailgateInfoRemoteModel, tailgateName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTailgateDescription() {
		return _tailgateDescription;
	}

	@Override
	public void setTailgateDescription(String tailgateDescription) {
		_tailgateDescription = tailgateDescription;

		if (_tailgateInfoRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgateDescription",
						String.class);

				method.invoke(_tailgateInfoRemoteModel, tailgateDescription);
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

		if (_tailgateInfoRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEventId", long.class);

				method.invoke(_tailgateInfoRemoteModel, eventId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEventName() {
		return _eventName;
	}

	@Override
	public void setEventName(String eventName) {
		_eventName = eventName;

		if (_tailgateInfoRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEventName", String.class);

				method.invoke(_tailgateInfoRemoteModel, eventName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getTailgateDate() {
		return _tailgateDate;
	}

	@Override
	public void setTailgateDate(Date tailgateDate) {
		_tailgateDate = tailgateDate;

		if (_tailgateInfoRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setTailgateDate", Date.class);

				method.invoke(_tailgateInfoRemoteModel, tailgateDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(long startTime) {
		_startTime = startTime;

		if (_tailgateInfoRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setStartTime", long.class);

				method.invoke(_tailgateInfoRemoteModel, startTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(long endTime) {
		_endTime = endTime;

		if (_tailgateInfoRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEndTime", long.class);

				method.invoke(_tailgateInfoRemoteModel, endTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIsActive() {
		return _isActive;
	}

	@Override
	public void setIsActive(int isActive) {
		_isActive = isActive;

		if (_tailgateInfoRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setIsActive", int.class);

				method.invoke(_tailgateInfoRemoteModel, isActive);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIsDelete() {
		return _isDelete;
	}

	@Override
	public void setIsDelete(int isDelete) {
		_isDelete = isDelete;

		if (_tailgateInfoRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setIsDelete", int.class);

				method.invoke(_tailgateInfoRemoteModel, isDelete);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVenmoAccountId() {
		return _venmoAccountId;
	}

	@Override
	public void setVenmoAccountId(String venmoAccountId) {
		_venmoAccountId = venmoAccountId;

		if (_tailgateInfoRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setVenmoAccountId",
						String.class);

				method.invoke(_tailgateInfoRemoteModel, venmoAccountId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAmountToPay() {
		return _amountToPay;
	}

	@Override
	public void setAmountToPay(double amountToPay) {
		_amountToPay = amountToPay;

		if (_tailgateInfoRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setAmountToPay", double.class);

				method.invoke(_tailgateInfoRemoteModel, amountToPay);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLogoId() {
		return _logoId;
	}

	@Override
	public void setLogoId(long logoId) {
		_logoId = logoId;

		if (_tailgateInfoRemoteModel != null) {
			try {
				Class<?> clazz = _tailgateInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setLogoId", long.class);

				method.invoke(_tailgateInfoRemoteModel, logoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTailgateInfoRemoteModel() {
		return _tailgateInfoRemoteModel;
	}

	public void setTailgateInfoRemoteModel(BaseModel<?> tailgateInfoRemoteModel) {
		_tailgateInfoRemoteModel = tailgateInfoRemoteModel;
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

		Class<?> remoteModelClass = _tailgateInfoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_tailgateInfoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TailgateInfoLocalServiceUtil.addTailgateInfo(this);
		}
		else {
			TailgateInfoLocalServiceUtil.updateTailgateInfo(this);
		}
	}

	@Override
	public TailgateInfo toEscapedModel() {
		return (TailgateInfo)ProxyUtil.newProxyInstance(TailgateInfo.class.getClassLoader(),
			new Class[] { TailgateInfo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TailgateInfoClp clone = new TailgateInfoClp();

		clone.setTailgateId(getTailgateId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTailgateName(getTailgateName());
		clone.setTailgateDescription(getTailgateDescription());
		clone.setEventId(getEventId());
		clone.setEventName(getEventName());
		clone.setTailgateDate(getTailgateDate());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setIsActive(getIsActive());
		clone.setIsDelete(getIsDelete());
		clone.setVenmoAccountId(getVenmoAccountId());
		clone.setAmountToPay(getAmountToPay());
		clone.setLogoId(getLogoId());

		return clone;
	}

	@Override
	public int compareTo(TailgateInfo tailgateInfo) {
		int value = 0;

		if (getTailgateId() < tailgateInfo.getTailgateId()) {
			value = -1;
		}
		else if (getTailgateId() > tailgateInfo.getTailgateId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof TailgateInfoClp)) {
			return false;
		}

		TailgateInfoClp tailgateInfo = (TailgateInfoClp)obj;

		long primaryKey = tailgateInfo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{tailgateId=");
		sb.append(getTailgateId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", tailgateName=");
		sb.append(getTailgateName());
		sb.append(", tailgateDescription=");
		sb.append(getTailgateDescription());
		sb.append(", eventId=");
		sb.append(getEventId());
		sb.append(", eventName=");
		sb.append(getEventName());
		sb.append(", tailgateDate=");
		sb.append(getTailgateDate());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", isActive=");
		sb.append(getIsActive());
		sb.append(", isDelete=");
		sb.append(getIsDelete());
		sb.append(", venmoAccountId=");
		sb.append(getVenmoAccountId());
		sb.append(", amountToPay=");
		sb.append(getAmountToPay());
		sb.append(", logoId=");
		sb.append(getLogoId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.TailgateInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>tailgateId</column-name><column-value><![CDATA[");
		sb.append(getTailgateId());
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
			"<column><column-name>tailgateName</column-name><column-value><![CDATA[");
		sb.append(getTailgateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tailgateDescription</column-name><column-value><![CDATA[");
		sb.append(getTailgateDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventName</column-name><column-value><![CDATA[");
		sb.append(getEventName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tailgateDate</column-name><column-value><![CDATA[");
		sb.append(getTailgateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isActive</column-name><column-value><![CDATA[");
		sb.append(getIsActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isDelete</column-name><column-value><![CDATA[");
		sb.append(getIsDelete());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venmoAccountId</column-name><column-value><![CDATA[");
		sb.append(getVenmoAccountId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amountToPay</column-name><column-value><![CDATA[");
		sb.append(getAmountToPay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logoId</column-name><column-value><![CDATA[");
		sb.append(getLogoId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _tailgateId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _tailgateName;
	private String _tailgateDescription;
	private long _eventId;
	private String _eventName;
	private Date _tailgateDate;
	private long _startTime;
	private long _endTime;
	private int _isActive;
	private int _isDelete;
	private String _venmoAccountId;
	private double _amountToPay;
	private long _logoId;
	private BaseModel<?> _tailgateInfoRemoteModel;
	private Class<?> _clpSerializerClass = com.rumbasolutions.flask.service.ClpSerializer.class;
}