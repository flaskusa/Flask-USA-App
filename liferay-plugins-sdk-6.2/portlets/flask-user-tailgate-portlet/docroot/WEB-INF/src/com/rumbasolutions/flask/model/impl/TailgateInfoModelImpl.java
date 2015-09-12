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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.rumbasolutions.flask.model.TailgateInfo;
import com.rumbasolutions.flask.model.TailgateInfoModel;
import com.rumbasolutions.flask.model.TailgateInfoSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the TailgateInfo service. Represents a row in the &quot;flasktailgate_TailgateInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rumbasolutions.flask.model.TailgateInfoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TailgateInfoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TailgateInfoImpl
 * @see com.rumbasolutions.flask.model.TailgateInfo
 * @see com.rumbasolutions.flask.model.TailgateInfoModel
 * @generated
 */
@JSON(strict = true)
public class TailgateInfoModelImpl extends BaseModelImpl<TailgateInfo>
	implements TailgateInfoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tailgate info model instance should use the {@link com.rumbasolutions.flask.model.TailgateInfo} interface instead.
	 */
	public static final String TABLE_NAME = "flasktailgate_TailgateInfo";
	public static final Object[][] TABLE_COLUMNS = {
			{ "tailgateId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createdDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "tailgateName", Types.VARCHAR },
			{ "tailgateDescription", Types.VARCHAR },
			{ "eventId", Types.BIGINT },
			{ "eventName", Types.VARCHAR },
			{ "tailgateDate", Types.TIMESTAMP },
			{ "startTime", Types.TIMESTAMP },
			{ "endTime", Types.TIMESTAMP },
			{ "isActive", Types.INTEGER },
			{ "isDelete", Types.INTEGER },
			{ "venmoAccountId", Types.VARCHAR },
			{ "amountToPay", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table flasktailgate_TailgateInfo (tailgateId LONG not null primary key,companyId LONG,userId LONG,createdDate DATE null,modifiedDate DATE null,tailgateName VARCHAR(75) null,tailgateDescription VARCHAR(75) null,eventId LONG,eventName VARCHAR(75) null,tailgateDate DATE null,startTime DATE null,endTime DATE null,isActive INTEGER,isDelete INTEGER,venmoAccountId VARCHAR(75) null,amountToPay DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table flasktailgate_TailgateInfo";
	public static final String ORDER_BY_JPQL = " ORDER BY tailgateInfo.tailgateId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY flasktailgate_TailgateInfo.tailgateId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rumbasolutions.flask.model.TailgateInfo"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rumbasolutions.flask.model.TailgateInfo"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TailgateInfo toModel(TailgateInfoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TailgateInfo model = new TailgateInfoImpl();

		model.setTailgateId(soapModel.getTailgateId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTailgateName(soapModel.getTailgateName());
		model.setTailgateDescription(soapModel.getTailgateDescription());
		model.setEventId(soapModel.getEventId());
		model.setEventName(soapModel.getEventName());
		model.setTailgateDate(soapModel.getTailgateDate());
		model.setStartTime(soapModel.getStartTime());
		model.setEndTime(soapModel.getEndTime());
		model.setIsActive(soapModel.getIsActive());
		model.setIsDelete(soapModel.getIsDelete());
		model.setVenmoAccountId(soapModel.getVenmoAccountId());
		model.setAmountToPay(soapModel.getAmountToPay());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TailgateInfo> toModels(TailgateInfoSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TailgateInfo> models = new ArrayList<TailgateInfo>(soapModels.length);

		for (TailgateInfoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rumbasolutions.flask.model.TailgateInfo"));

	public TailgateInfoModelImpl() {
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
	public Class<?> getModelClass() {
		return TailgateInfo.class;
	}

	@Override
	public String getModelClassName() {
		return TailgateInfo.class.getName();
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

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

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
	}

	@JSON
	@Override
	public long getTailgateId() {
		return _tailgateId;
	}

	@Override
	public void setTailgateId(long tailgateId) {
		_tailgateId = tailgateId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getTailgateName() {
		if (_tailgateName == null) {
			return StringPool.BLANK;
		}
		else {
			return _tailgateName;
		}
	}

	@Override
	public void setTailgateName(String tailgateName) {
		_tailgateName = tailgateName;
	}

	@JSON
	@Override
	public String getTailgateDescription() {
		if (_tailgateDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _tailgateDescription;
		}
	}

	@Override
	public void setTailgateDescription(String tailgateDescription) {
		_tailgateDescription = tailgateDescription;
	}

	@JSON
	@Override
	public long getEventId() {
		return _eventId;
	}

	@Override
	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	@JSON
	@Override
	public String getEventName() {
		if (_eventName == null) {
			return StringPool.BLANK;
		}
		else {
			return _eventName;
		}
	}

	@Override
	public void setEventName(String eventName) {
		_eventName = eventName;
	}

	@JSON
	@Override
	public Date getTailgateDate() {
		return _tailgateDate;
	}

	@Override
	public void setTailgateDate(Date tailgateDate) {
		_tailgateDate = tailgateDate;
	}

	@JSON
	@Override
	public Date getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	@JSON
	@Override
	public Date getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	@JSON
	@Override
	public int getIsActive() {
		return _isActive;
	}

	@Override
	public void setIsActive(int isActive) {
		_isActive = isActive;
	}

	@JSON
	@Override
	public int getIsDelete() {
		return _isDelete;
	}

	@Override
	public void setIsDelete(int isDelete) {
		_isDelete = isDelete;
	}

	@JSON
	@Override
	public String getVenmoAccountId() {
		if (_venmoAccountId == null) {
			return StringPool.BLANK;
		}
		else {
			return _venmoAccountId;
		}
	}

	@Override
	public void setVenmoAccountId(String venmoAccountId) {
		_venmoAccountId = venmoAccountId;
	}

	@JSON
	@Override
	public double getAmountToPay() {
		return _amountToPay;
	}

	@Override
	public void setAmountToPay(double amountToPay) {
		_amountToPay = amountToPay;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			TailgateInfo.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TailgateInfo toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TailgateInfo)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TailgateInfoImpl tailgateInfoImpl = new TailgateInfoImpl();

		tailgateInfoImpl.setTailgateId(getTailgateId());
		tailgateInfoImpl.setCompanyId(getCompanyId());
		tailgateInfoImpl.setUserId(getUserId());
		tailgateInfoImpl.setCreatedDate(getCreatedDate());
		tailgateInfoImpl.setModifiedDate(getModifiedDate());
		tailgateInfoImpl.setTailgateName(getTailgateName());
		tailgateInfoImpl.setTailgateDescription(getTailgateDescription());
		tailgateInfoImpl.setEventId(getEventId());
		tailgateInfoImpl.setEventName(getEventName());
		tailgateInfoImpl.setTailgateDate(getTailgateDate());
		tailgateInfoImpl.setStartTime(getStartTime());
		tailgateInfoImpl.setEndTime(getEndTime());
		tailgateInfoImpl.setIsActive(getIsActive());
		tailgateInfoImpl.setIsDelete(getIsDelete());
		tailgateInfoImpl.setVenmoAccountId(getVenmoAccountId());
		tailgateInfoImpl.setAmountToPay(getAmountToPay());

		tailgateInfoImpl.resetOriginalValues();

		return tailgateInfoImpl;
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

		if (!(obj instanceof TailgateInfo)) {
			return false;
		}

		TailgateInfo tailgateInfo = (TailgateInfo)obj;

		long primaryKey = tailgateInfo.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<TailgateInfo> toCacheModel() {
		TailgateInfoCacheModel tailgateInfoCacheModel = new TailgateInfoCacheModel();

		tailgateInfoCacheModel.tailgateId = getTailgateId();

		tailgateInfoCacheModel.companyId = getCompanyId();

		tailgateInfoCacheModel.userId = getUserId();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			tailgateInfoCacheModel.createdDate = createdDate.getTime();
		}
		else {
			tailgateInfoCacheModel.createdDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			tailgateInfoCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			tailgateInfoCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		tailgateInfoCacheModel.tailgateName = getTailgateName();

		String tailgateName = tailgateInfoCacheModel.tailgateName;

		if ((tailgateName != null) && (tailgateName.length() == 0)) {
			tailgateInfoCacheModel.tailgateName = null;
		}

		tailgateInfoCacheModel.tailgateDescription = getTailgateDescription();

		String tailgateDescription = tailgateInfoCacheModel.tailgateDescription;

		if ((tailgateDescription != null) &&
				(tailgateDescription.length() == 0)) {
			tailgateInfoCacheModel.tailgateDescription = null;
		}

		tailgateInfoCacheModel.eventId = getEventId();

		tailgateInfoCacheModel.eventName = getEventName();

		String eventName = tailgateInfoCacheModel.eventName;

		if ((eventName != null) && (eventName.length() == 0)) {
			tailgateInfoCacheModel.eventName = null;
		}

		Date tailgateDate = getTailgateDate();

		if (tailgateDate != null) {
			tailgateInfoCacheModel.tailgateDate = tailgateDate.getTime();
		}
		else {
			tailgateInfoCacheModel.tailgateDate = Long.MIN_VALUE;
		}

		Date startTime = getStartTime();

		if (startTime != null) {
			tailgateInfoCacheModel.startTime = startTime.getTime();
		}
		else {
			tailgateInfoCacheModel.startTime = Long.MIN_VALUE;
		}

		Date endTime = getEndTime();

		if (endTime != null) {
			tailgateInfoCacheModel.endTime = endTime.getTime();
		}
		else {
			tailgateInfoCacheModel.endTime = Long.MIN_VALUE;
		}

		tailgateInfoCacheModel.isActive = getIsActive();

		tailgateInfoCacheModel.isDelete = getIsDelete();

		tailgateInfoCacheModel.venmoAccountId = getVenmoAccountId();

		String venmoAccountId = tailgateInfoCacheModel.venmoAccountId;

		if ((venmoAccountId != null) && (venmoAccountId.length() == 0)) {
			tailgateInfoCacheModel.venmoAccountId = null;
		}

		tailgateInfoCacheModel.amountToPay = getAmountToPay();

		return tailgateInfoCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

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

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = TailgateInfo.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			TailgateInfo.class
		};
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
	private Date _startTime;
	private Date _endTime;
	private int _isActive;
	private int _isDelete;
	private String _venmoAccountId;
	private double _amountToPay;
	private TailgateInfo _escapedModel;
}