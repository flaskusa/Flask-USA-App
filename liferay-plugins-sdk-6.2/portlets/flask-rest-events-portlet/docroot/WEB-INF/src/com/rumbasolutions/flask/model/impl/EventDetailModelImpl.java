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

import com.rumbasolutions.flask.model.EventDetail;
import com.rumbasolutions.flask.model.EventDetailModel;
import com.rumbasolutions.flask.model.EventDetailSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the EventDetail service. Represents a row in the &quot;flaskevents_EventDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rumbasolutions.flask.model.EventDetailModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EventDetailImpl}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventDetailImpl
 * @see com.rumbasolutions.flask.model.EventDetail
 * @see com.rumbasolutions.flask.model.EventDetailModel
 * @generated
 */
@JSON(strict = true)
public class EventDetailModelImpl extends BaseModelImpl<EventDetail>
	implements EventDetailModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a event detail model instance should use the {@link com.rumbasolutions.flask.model.EventDetail} interface instead.
	 */
	public static final String TABLE_NAME = "flaskevents_EventDetail";
	public static final Object[][] TABLE_COLUMNS = {
			{ "eventDetailId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createdDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "eventId", Types.BIGINT },
			{ "infoTypeId", Types.BIGINT },
			{ "infoTypeName", Types.VARCHAR },
			{ "infoTypeCategoryId", Types.BIGINT },
			{ "infoTypeCategoryName", Types.VARCHAR },
			{ "infoTitle", Types.VARCHAR },
			{ "infoShortDesc", Types.VARCHAR },
			{ "infoDesc", Types.VARCHAR },
			{ "addrLine1", Types.VARCHAR },
			{ "addrLine2", Types.VARCHAR },
			{ "city", Types.VARCHAR },
			{ "zipCode", Types.VARCHAR },
			{ "stateId", Types.BIGINT },
			{ "stateName", Types.VARCHAR },
			{ "countryId", Types.BIGINT },
			{ "countryName", Types.VARCHAR },
			{ "latitude", Types.VARCHAR },
			{ "longitude", Types.VARCHAR },
			{ "phone", Types.VARCHAR },
			{ "mobileAppName", Types.VARCHAR },
			{ "website", Types.VARCHAR },
			{ "cost", Types.DOUBLE },
			{ "hoursOfOperation", Types.VARCHAR },
			{ "showDescription", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table flaskevents_EventDetail (eventDetailId LONG not null primary key,companyId LONG,userId LONG,createdDate DATE null,modifiedDate DATE null,eventId LONG,infoTypeId LONG,infoTypeName VARCHAR(75) null,infoTypeCategoryId LONG,infoTypeCategoryName VARCHAR(75) null,infoTitle VARCHAR(100) null,infoShortDesc VARCHAR(100) null,infoDesc TEXT null,addrLine1 VARCHAR(100) null,addrLine2 VARCHAR(100) null,city VARCHAR(100) null,zipCode VARCHAR(20) null,stateId LONG,stateName VARCHAR(75) null,countryId LONG,countryName VARCHAR(75) null,latitude VARCHAR(20) null,longitude VARCHAR(20) null,phone VARCHAR(20) null,mobileAppName VARCHAR(75) null,website VARCHAR(255) null,cost DOUBLE,hoursOfOperation VARCHAR(255) null,showDescription BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table flaskevents_EventDetail";
	public static final String ORDER_BY_JPQL = " ORDER BY eventDetail.eventDetailId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY flaskevents_EventDetail.eventDetailId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rumbasolutions.flask.model.EventDetail"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rumbasolutions.flask.model.EventDetail"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rumbasolutions.flask.model.EventDetail"),
			true);
	public static long EVENTID_COLUMN_BITMASK = 1L;
	public static long INFOTYPECATEGORYID_COLUMN_BITMASK = 2L;
	public static long INFOTYPEID_COLUMN_BITMASK = 4L;
	public static long EVENTDETAILID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static EventDetail toModel(EventDetailSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		EventDetail model = new EventDetailImpl();

		model.setEventDetailId(soapModel.getEventDetailId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setEventId(soapModel.getEventId());
		model.setInfoTypeId(soapModel.getInfoTypeId());
		model.setInfoTypeName(soapModel.getInfoTypeName());
		model.setInfoTypeCategoryId(soapModel.getInfoTypeCategoryId());
		model.setInfoTypeCategoryName(soapModel.getInfoTypeCategoryName());
		model.setInfoTitle(soapModel.getInfoTitle());
		model.setInfoShortDesc(soapModel.getInfoShortDesc());
		model.setInfoDesc(soapModel.getInfoDesc());
		model.setAddrLine1(soapModel.getAddrLine1());
		model.setAddrLine2(soapModel.getAddrLine2());
		model.setCity(soapModel.getCity());
		model.setZipCode(soapModel.getZipCode());
		model.setStateId(soapModel.getStateId());
		model.setStateName(soapModel.getStateName());
		model.setCountryId(soapModel.getCountryId());
		model.setCountryName(soapModel.getCountryName());
		model.setLatitude(soapModel.getLatitude());
		model.setLongitude(soapModel.getLongitude());
		model.setPhone(soapModel.getPhone());
		model.setMobileAppName(soapModel.getMobileAppName());
		model.setWebsite(soapModel.getWebsite());
		model.setCost(soapModel.getCost());
		model.setHoursOfOperation(soapModel.getHoursOfOperation());
		model.setShowDescription(soapModel.getShowDescription());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<EventDetail> toModels(EventDetailSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<EventDetail> models = new ArrayList<EventDetail>(soapModels.length);

		for (EventDetailSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rumbasolutions.flask.model.EventDetail"));

	public EventDetailModelImpl() {
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
	public Class<?> getModelClass() {
		return EventDetail.class;
	}

	@Override
	public String getModelClassName() {
		return EventDetail.class.getName();
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
		attributes.put("infoTypeName", getInfoTypeName());
		attributes.put("infoTypeCategoryId", getInfoTypeCategoryId());
		attributes.put("infoTypeCategoryName", getInfoTypeCategoryName());
		attributes.put("infoTitle", getInfoTitle());
		attributes.put("infoShortDesc", getInfoShortDesc());
		attributes.put("infoDesc", getInfoDesc());
		attributes.put("addrLine1", getAddrLine1());
		attributes.put("addrLine2", getAddrLine2());
		attributes.put("city", getCity());
		attributes.put("zipCode", getZipCode());
		attributes.put("stateId", getStateId());
		attributes.put("stateName", getStateName());
		attributes.put("countryId", getCountryId());
		attributes.put("countryName", getCountryName());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("phone", getPhone());
		attributes.put("mobileAppName", getMobileAppName());
		attributes.put("website", getWebsite());
		attributes.put("cost", getCost());
		attributes.put("hoursOfOperation", getHoursOfOperation());
		attributes.put("showDescription", getShowDescription());

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

		String infoTypeName = (String)attributes.get("infoTypeName");

		if (infoTypeName != null) {
			setInfoTypeName(infoTypeName);
		}

		Long infoTypeCategoryId = (Long)attributes.get("infoTypeCategoryId");

		if (infoTypeCategoryId != null) {
			setInfoTypeCategoryId(infoTypeCategoryId);
		}

		String infoTypeCategoryName = (String)attributes.get(
				"infoTypeCategoryName");

		if (infoTypeCategoryName != null) {
			setInfoTypeCategoryName(infoTypeCategoryName);
		}

		String infoTitle = (String)attributes.get("infoTitle");

		if (infoTitle != null) {
			setInfoTitle(infoTitle);
		}

		String infoShortDesc = (String)attributes.get("infoShortDesc");

		if (infoShortDesc != null) {
			setInfoShortDesc(infoShortDesc);
		}

		String infoDesc = (String)attributes.get("infoDesc");

		if (infoDesc != null) {
			setInfoDesc(infoDesc);
		}

		String addrLine1 = (String)attributes.get("addrLine1");

		if (addrLine1 != null) {
			setAddrLine1(addrLine1);
		}

		String addrLine2 = (String)attributes.get("addrLine2");

		if (addrLine2 != null) {
			setAddrLine2(addrLine2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		String stateName = (String)attributes.get("stateName");

		if (stateName != null) {
			setStateName(stateName);
		}

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		String countryName = (String)attributes.get("countryName");

		if (countryName != null) {
			setCountryName(countryName);
		}

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String mobileAppName = (String)attributes.get("mobileAppName");

		if (mobileAppName != null) {
			setMobileAppName(mobileAppName);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}

		Double cost = (Double)attributes.get("cost");

		if (cost != null) {
			setCost(cost);
		}

		String hoursOfOperation = (String)attributes.get("hoursOfOperation");

		if (hoursOfOperation != null) {
			setHoursOfOperation(hoursOfOperation);
		}

		Boolean showDescription = (Boolean)attributes.get("showDescription");

		if (showDescription != null) {
			setShowDescription(showDescription);
		}
	}

	@JSON
	@Override
	public long getEventDetailId() {
		return _eventDetailId;
	}

	@Override
	public void setEventDetailId(long eventDetailId) {
		_eventDetailId = eventDetailId;
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
	public long getEventId() {
		return _eventId;
	}

	@Override
	public void setEventId(long eventId) {
		_columnBitmask |= EVENTID_COLUMN_BITMASK;

		if (!_setOriginalEventId) {
			_setOriginalEventId = true;

			_originalEventId = _eventId;
		}

		_eventId = eventId;
	}

	public long getOriginalEventId() {
		return _originalEventId;
	}

	@JSON
	@Override
	public long getInfoTypeId() {
		return _infoTypeId;
	}

	@Override
	public void setInfoTypeId(long infoTypeId) {
		_columnBitmask |= INFOTYPEID_COLUMN_BITMASK;

		if (!_setOriginalInfoTypeId) {
			_setOriginalInfoTypeId = true;

			_originalInfoTypeId = _infoTypeId;
		}

		_infoTypeId = infoTypeId;
	}

	public long getOriginalInfoTypeId() {
		return _originalInfoTypeId;
	}

	@JSON
	@Override
	public String getInfoTypeName() {
		if (_infoTypeName == null) {
			return StringPool.BLANK;
		}
		else {
			return _infoTypeName;
		}
	}

	@Override
	public void setInfoTypeName(String infoTypeName) {
		_infoTypeName = infoTypeName;
	}

	@JSON
	@Override
	public long getInfoTypeCategoryId() {
		return _infoTypeCategoryId;
	}

	@Override
	public void setInfoTypeCategoryId(long infoTypeCategoryId) {
		_columnBitmask |= INFOTYPECATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalInfoTypeCategoryId) {
			_setOriginalInfoTypeCategoryId = true;

			_originalInfoTypeCategoryId = _infoTypeCategoryId;
		}

		_infoTypeCategoryId = infoTypeCategoryId;
	}

	public long getOriginalInfoTypeCategoryId() {
		return _originalInfoTypeCategoryId;
	}

	@JSON
	@Override
	public String getInfoTypeCategoryName() {
		if (_infoTypeCategoryName == null) {
			return StringPool.BLANK;
		}
		else {
			return _infoTypeCategoryName;
		}
	}

	@Override
	public void setInfoTypeCategoryName(String infoTypeCategoryName) {
		_infoTypeCategoryName = infoTypeCategoryName;
	}

	@JSON
	@Override
	public String getInfoTitle() {
		if (_infoTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _infoTitle;
		}
	}

	@Override
	public void setInfoTitle(String infoTitle) {
		_infoTitle = infoTitle;
	}

	@JSON
	@Override
	public String getInfoShortDesc() {
		if (_infoShortDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _infoShortDesc;
		}
	}

	@Override
	public void setInfoShortDesc(String infoShortDesc) {
		_infoShortDesc = infoShortDesc;
	}

	@JSON
	@Override
	public String getInfoDesc() {
		if (_infoDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _infoDesc;
		}
	}

	@Override
	public void setInfoDesc(String infoDesc) {
		_infoDesc = infoDesc;
	}

	@JSON
	@Override
	public String getAddrLine1() {
		if (_addrLine1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _addrLine1;
		}
	}

	@Override
	public void setAddrLine1(String addrLine1) {
		_addrLine1 = addrLine1;
	}

	@JSON
	@Override
	public String getAddrLine2() {
		if (_addrLine2 == null) {
			return StringPool.BLANK;
		}
		else {
			return _addrLine2;
		}
	}

	@Override
	public void setAddrLine2(String addrLine2) {
		_addrLine2 = addrLine2;
	}

	@JSON
	@Override
	public String getCity() {
		if (_city == null) {
			return StringPool.BLANK;
		}
		else {
			return _city;
		}
	}

	@Override
	public void setCity(String city) {
		_city = city;
	}

	@JSON
	@Override
	public String getZipCode() {
		if (_zipCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _zipCode;
		}
	}

	@Override
	public void setZipCode(String zipCode) {
		_zipCode = zipCode;
	}

	@JSON
	@Override
	public long getStateId() {
		return _stateId;
	}

	@Override
	public void setStateId(long stateId) {
		_stateId = stateId;
	}

	@JSON
	@Override
	public String getStateName() {
		if (_stateName == null) {
			return StringPool.BLANK;
		}
		else {
			return _stateName;
		}
	}

	@Override
	public void setStateName(String stateName) {
		_stateName = stateName;
	}

	@JSON
	@Override
	public long getCountryId() {
		return _countryId;
	}

	@Override
	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	@JSON
	@Override
	public String getCountryName() {
		if (_countryName == null) {
			return StringPool.BLANK;
		}
		else {
			return _countryName;
		}
	}

	@Override
	public void setCountryName(String countryName) {
		_countryName = countryName;
	}

	@JSON
	@Override
	public String getLatitude() {
		if (_latitude == null) {
			return StringPool.BLANK;
		}
		else {
			return _latitude;
		}
	}

	@Override
	public void setLatitude(String latitude) {
		_latitude = latitude;
	}

	@JSON
	@Override
	public String getLongitude() {
		if (_longitude == null) {
			return StringPool.BLANK;
		}
		else {
			return _longitude;
		}
	}

	@Override
	public void setLongitude(String longitude) {
		_longitude = longitude;
	}

	@JSON
	@Override
	public String getPhone() {
		if (_phone == null) {
			return StringPool.BLANK;
		}
		else {
			return _phone;
		}
	}

	@Override
	public void setPhone(String phone) {
		_phone = phone;
	}

	@JSON
	@Override
	public String getMobileAppName() {
		if (_mobileAppName == null) {
			return StringPool.BLANK;
		}
		else {
			return _mobileAppName;
		}
	}

	@Override
	public void setMobileAppName(String mobileAppName) {
		_mobileAppName = mobileAppName;
	}

	@JSON
	@Override
	public String getWebsite() {
		if (_website == null) {
			return StringPool.BLANK;
		}
		else {
			return _website;
		}
	}

	@Override
	public void setWebsite(String website) {
		_website = website;
	}

	@JSON
	@Override
	public double getCost() {
		return _cost;
	}

	@Override
	public void setCost(double cost) {
		_cost = cost;
	}

	@JSON
	@Override
	public String getHoursOfOperation() {
		if (_hoursOfOperation == null) {
			return StringPool.BLANK;
		}
		else {
			return _hoursOfOperation;
		}
	}

	@Override
	public void setHoursOfOperation(String hoursOfOperation) {
		_hoursOfOperation = hoursOfOperation;
	}

	@JSON
	@Override
	public boolean getShowDescription() {
		return _showDescription;
	}

	@Override
	public boolean isShowDescription() {
		return _showDescription;
	}

	@Override
	public void setShowDescription(boolean showDescription) {
		_showDescription = showDescription;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			EventDetail.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EventDetail toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (EventDetail)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EventDetailImpl eventDetailImpl = new EventDetailImpl();

		eventDetailImpl.setEventDetailId(getEventDetailId());
		eventDetailImpl.setCompanyId(getCompanyId());
		eventDetailImpl.setUserId(getUserId());
		eventDetailImpl.setCreatedDate(getCreatedDate());
		eventDetailImpl.setModifiedDate(getModifiedDate());
		eventDetailImpl.setEventId(getEventId());
		eventDetailImpl.setInfoTypeId(getInfoTypeId());
		eventDetailImpl.setInfoTypeName(getInfoTypeName());
		eventDetailImpl.setInfoTypeCategoryId(getInfoTypeCategoryId());
		eventDetailImpl.setInfoTypeCategoryName(getInfoTypeCategoryName());
		eventDetailImpl.setInfoTitle(getInfoTitle());
		eventDetailImpl.setInfoShortDesc(getInfoShortDesc());
		eventDetailImpl.setInfoDesc(getInfoDesc());
		eventDetailImpl.setAddrLine1(getAddrLine1());
		eventDetailImpl.setAddrLine2(getAddrLine2());
		eventDetailImpl.setCity(getCity());
		eventDetailImpl.setZipCode(getZipCode());
		eventDetailImpl.setStateId(getStateId());
		eventDetailImpl.setStateName(getStateName());
		eventDetailImpl.setCountryId(getCountryId());
		eventDetailImpl.setCountryName(getCountryName());
		eventDetailImpl.setLatitude(getLatitude());
		eventDetailImpl.setLongitude(getLongitude());
		eventDetailImpl.setPhone(getPhone());
		eventDetailImpl.setMobileAppName(getMobileAppName());
		eventDetailImpl.setWebsite(getWebsite());
		eventDetailImpl.setCost(getCost());
		eventDetailImpl.setHoursOfOperation(getHoursOfOperation());
		eventDetailImpl.setShowDescription(getShowDescription());

		eventDetailImpl.resetOriginalValues();

		return eventDetailImpl;
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

		if (!(obj instanceof EventDetail)) {
			return false;
		}

		EventDetail eventDetail = (EventDetail)obj;

		long primaryKey = eventDetail.getPrimaryKey();

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
		EventDetailModelImpl eventDetailModelImpl = this;

		eventDetailModelImpl._originalEventId = eventDetailModelImpl._eventId;

		eventDetailModelImpl._setOriginalEventId = false;

		eventDetailModelImpl._originalInfoTypeId = eventDetailModelImpl._infoTypeId;

		eventDetailModelImpl._setOriginalInfoTypeId = false;

		eventDetailModelImpl._originalInfoTypeCategoryId = eventDetailModelImpl._infoTypeCategoryId;

		eventDetailModelImpl._setOriginalInfoTypeCategoryId = false;

		eventDetailModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<EventDetail> toCacheModel() {
		EventDetailCacheModel eventDetailCacheModel = new EventDetailCacheModel();

		eventDetailCacheModel.eventDetailId = getEventDetailId();

		eventDetailCacheModel.companyId = getCompanyId();

		eventDetailCacheModel.userId = getUserId();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			eventDetailCacheModel.createdDate = createdDate.getTime();
		}
		else {
			eventDetailCacheModel.createdDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			eventDetailCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			eventDetailCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		eventDetailCacheModel.eventId = getEventId();

		eventDetailCacheModel.infoTypeId = getInfoTypeId();

		eventDetailCacheModel.infoTypeName = getInfoTypeName();

		String infoTypeName = eventDetailCacheModel.infoTypeName;

		if ((infoTypeName != null) && (infoTypeName.length() == 0)) {
			eventDetailCacheModel.infoTypeName = null;
		}

		eventDetailCacheModel.infoTypeCategoryId = getInfoTypeCategoryId();

		eventDetailCacheModel.infoTypeCategoryName = getInfoTypeCategoryName();

		String infoTypeCategoryName = eventDetailCacheModel.infoTypeCategoryName;

		if ((infoTypeCategoryName != null) &&
				(infoTypeCategoryName.length() == 0)) {
			eventDetailCacheModel.infoTypeCategoryName = null;
		}

		eventDetailCacheModel.infoTitle = getInfoTitle();

		String infoTitle = eventDetailCacheModel.infoTitle;

		if ((infoTitle != null) && (infoTitle.length() == 0)) {
			eventDetailCacheModel.infoTitle = null;
		}

		eventDetailCacheModel.infoShortDesc = getInfoShortDesc();

		String infoShortDesc = eventDetailCacheModel.infoShortDesc;

		if ((infoShortDesc != null) && (infoShortDesc.length() == 0)) {
			eventDetailCacheModel.infoShortDesc = null;
		}

		eventDetailCacheModel.infoDesc = getInfoDesc();

		String infoDesc = eventDetailCacheModel.infoDesc;

		if ((infoDesc != null) && (infoDesc.length() == 0)) {
			eventDetailCacheModel.infoDesc = null;
		}

		eventDetailCacheModel.addrLine1 = getAddrLine1();

		String addrLine1 = eventDetailCacheModel.addrLine1;

		if ((addrLine1 != null) && (addrLine1.length() == 0)) {
			eventDetailCacheModel.addrLine1 = null;
		}

		eventDetailCacheModel.addrLine2 = getAddrLine2();

		String addrLine2 = eventDetailCacheModel.addrLine2;

		if ((addrLine2 != null) && (addrLine2.length() == 0)) {
			eventDetailCacheModel.addrLine2 = null;
		}

		eventDetailCacheModel.city = getCity();

		String city = eventDetailCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			eventDetailCacheModel.city = null;
		}

		eventDetailCacheModel.zipCode = getZipCode();

		String zipCode = eventDetailCacheModel.zipCode;

		if ((zipCode != null) && (zipCode.length() == 0)) {
			eventDetailCacheModel.zipCode = null;
		}

		eventDetailCacheModel.stateId = getStateId();

		eventDetailCacheModel.stateName = getStateName();

		String stateName = eventDetailCacheModel.stateName;

		if ((stateName != null) && (stateName.length() == 0)) {
			eventDetailCacheModel.stateName = null;
		}

		eventDetailCacheModel.countryId = getCountryId();

		eventDetailCacheModel.countryName = getCountryName();

		String countryName = eventDetailCacheModel.countryName;

		if ((countryName != null) && (countryName.length() == 0)) {
			eventDetailCacheModel.countryName = null;
		}

		eventDetailCacheModel.latitude = getLatitude();

		String latitude = eventDetailCacheModel.latitude;

		if ((latitude != null) && (latitude.length() == 0)) {
			eventDetailCacheModel.latitude = null;
		}

		eventDetailCacheModel.longitude = getLongitude();

		String longitude = eventDetailCacheModel.longitude;

		if ((longitude != null) && (longitude.length() == 0)) {
			eventDetailCacheModel.longitude = null;
		}

		eventDetailCacheModel.phone = getPhone();

		String phone = eventDetailCacheModel.phone;

		if ((phone != null) && (phone.length() == 0)) {
			eventDetailCacheModel.phone = null;
		}

		eventDetailCacheModel.mobileAppName = getMobileAppName();

		String mobileAppName = eventDetailCacheModel.mobileAppName;

		if ((mobileAppName != null) && (mobileAppName.length() == 0)) {
			eventDetailCacheModel.mobileAppName = null;
		}

		eventDetailCacheModel.website = getWebsite();

		String website = eventDetailCacheModel.website;

		if ((website != null) && (website.length() == 0)) {
			eventDetailCacheModel.website = null;
		}

		eventDetailCacheModel.cost = getCost();

		eventDetailCacheModel.hoursOfOperation = getHoursOfOperation();

		String hoursOfOperation = eventDetailCacheModel.hoursOfOperation;

		if ((hoursOfOperation != null) && (hoursOfOperation.length() == 0)) {
			eventDetailCacheModel.hoursOfOperation = null;
		}

		eventDetailCacheModel.showDescription = getShowDescription();

		return eventDetailCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(59);

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
		sb.append(", infoTypeName=");
		sb.append(getInfoTypeName());
		sb.append(", infoTypeCategoryId=");
		sb.append(getInfoTypeCategoryId());
		sb.append(", infoTypeCategoryName=");
		sb.append(getInfoTypeCategoryName());
		sb.append(", infoTitle=");
		sb.append(getInfoTitle());
		sb.append(", infoShortDesc=");
		sb.append(getInfoShortDesc());
		sb.append(", infoDesc=");
		sb.append(getInfoDesc());
		sb.append(", addrLine1=");
		sb.append(getAddrLine1());
		sb.append(", addrLine2=");
		sb.append(getAddrLine2());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", zipCode=");
		sb.append(getZipCode());
		sb.append(", stateId=");
		sb.append(getStateId());
		sb.append(", stateName=");
		sb.append(getStateName());
		sb.append(", countryId=");
		sb.append(getCountryId());
		sb.append(", countryName=");
		sb.append(getCountryName());
		sb.append(", latitude=");
		sb.append(getLatitude());
		sb.append(", longitude=");
		sb.append(getLongitude());
		sb.append(", phone=");
		sb.append(getPhone());
		sb.append(", mobileAppName=");
		sb.append(getMobileAppName());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", cost=");
		sb.append(getCost());
		sb.append(", hoursOfOperation=");
		sb.append(getHoursOfOperation());
		sb.append(", showDescription=");
		sb.append(getShowDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(91);

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
			"<column><column-name>infoTypeName</column-name><column-value><![CDATA[");
		sb.append(getInfoTypeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoTypeCategoryId</column-name><column-value><![CDATA[");
		sb.append(getInfoTypeCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoTypeCategoryName</column-name><column-value><![CDATA[");
		sb.append(getInfoTypeCategoryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoTitle</column-name><column-value><![CDATA[");
		sb.append(getInfoTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoShortDesc</column-name><column-value><![CDATA[");
		sb.append(getInfoShortDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoDesc</column-name><column-value><![CDATA[");
		sb.append(getInfoDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addrLine1</column-name><column-value><![CDATA[");
		sb.append(getAddrLine1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addrLine2</column-name><column-value><![CDATA[");
		sb.append(getAddrLine2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zipCode</column-name><column-value><![CDATA[");
		sb.append(getZipCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stateId</column-name><column-value><![CDATA[");
		sb.append(getStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stateName</column-name><column-value><![CDATA[");
		sb.append(getStateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryId</column-name><column-value><![CDATA[");
		sb.append(getCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryName</column-name><column-value><![CDATA[");
		sb.append(getCountryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latitude</column-name><column-value><![CDATA[");
		sb.append(getLatitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longitude</column-name><column-value><![CDATA[");
		sb.append(getLongitude());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phone</column-name><column-value><![CDATA[");
		sb.append(getPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobileAppName</column-name><column-value><![CDATA[");
		sb.append(getMobileAppName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cost</column-name><column-value><![CDATA[");
		sb.append(getCost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hoursOfOperation</column-name><column-value><![CDATA[");
		sb.append(getHoursOfOperation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>showDescription</column-name><column-value><![CDATA[");
		sb.append(getShowDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = EventDetail.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			EventDetail.class
		};
	private long _eventDetailId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _eventId;
	private long _originalEventId;
	private boolean _setOriginalEventId;
	private long _infoTypeId;
	private long _originalInfoTypeId;
	private boolean _setOriginalInfoTypeId;
	private String _infoTypeName;
	private long _infoTypeCategoryId;
	private long _originalInfoTypeCategoryId;
	private boolean _setOriginalInfoTypeCategoryId;
	private String _infoTypeCategoryName;
	private String _infoTitle;
	private String _infoShortDesc;
	private String _infoDesc;
	private String _addrLine1;
	private String _addrLine2;
	private String _city;
	private String _zipCode;
	private long _stateId;
	private String _stateName;
	private long _countryId;
	private String _countryName;
	private String _latitude;
	private String _longitude;
	private String _phone;
	private String _mobileAppName;
	private String _website;
	private double _cost;
	private String _hoursOfOperation;
	private boolean _showDescription;
	private long _columnBitmask;
	private EventDetail _escapedModel;
}