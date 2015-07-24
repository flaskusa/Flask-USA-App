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
import com.liferay.portal.kernel.util.DateUtil;
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

import com.rumbasolutions.flask.model.Event;
import com.rumbasolutions.flask.model.EventModel;
import com.rumbasolutions.flask.model.EventSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Event service. Represents a row in the &quot;flaskevents_Event&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rumbasolutions.flask.model.EventModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EventImpl}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventImpl
 * @see com.rumbasolutions.flask.model.Event
 * @see com.rumbasolutions.flask.model.EventModel
 * @generated
 */
@JSON(strict = true)
public class EventModelImpl extends BaseModelImpl<Event> implements EventModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a event model instance should use the {@link com.rumbasolutions.flask.model.Event} interface instead.
	 */
	public static final String TABLE_NAME = "flaskevents_Event";
	public static final Object[][] TABLE_COLUMNS = {
			{ "eventId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createdDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "eventName", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "eventDate", Types.TIMESTAMP },
			{ "startTime", Types.TIMESTAMP },
			{ "endTime", Types.TIMESTAMP },
			{ "eventTypeId", Types.BIGINT },
			{ "eventTypeName", Types.VARCHAR },
			{ "eventImageUUID", Types.VARCHAR },
			{ "eventImageGroupId", Types.BIGINT },
			{ "venueId", Types.BIGINT },
			{ "venueName", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table flaskevents_Event (eventId LONG not null primary key,companyId LONG,userId LONG,createdDate DATE null,modifiedDate DATE null,eventName VARCHAR(75) null,description VARCHAR(75) null,eventDate DATE null,startTime DATE null,endTime DATE null,eventTypeId LONG,eventTypeName VARCHAR(75) null,eventImageUUID VARCHAR(75) null,eventImageGroupId LONG,venueId LONG,venueName VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table flaskevents_Event";
	public static final String ORDER_BY_JPQL = " ORDER BY event.eventDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY flaskevents_Event.eventDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rumbasolutions.flask.model.Event"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rumbasolutions.flask.model.Event"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rumbasolutions.flask.model.Event"),
			true);
	public static long EVENTDATE_COLUMN_BITMASK = 1L;
	public static long VENUEID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Event toModel(EventSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Event model = new EventImpl();

		model.setEventId(soapModel.getEventId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setEventName(soapModel.getEventName());
		model.setDescription(soapModel.getDescription());
		model.setEventDate(soapModel.getEventDate());
		model.setStartTime(soapModel.getStartTime());
		model.setEndTime(soapModel.getEndTime());
		model.setEventTypeId(soapModel.getEventTypeId());
		model.setEventTypeName(soapModel.getEventTypeName());
		model.setEventImageUUID(soapModel.getEventImageUUID());
		model.setEventImageGroupId(soapModel.getEventImageGroupId());
		model.setVenueId(soapModel.getVenueId());
		model.setVenueName(soapModel.getVenueName());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Event> toModels(EventSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Event> models = new ArrayList<Event>(soapModels.length);

		for (EventSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rumbasolutions.flask.model.Event"));

	public EventModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _eventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Event.class;
	}

	@Override
	public String getModelClassName() {
		return Event.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventId", getEventId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventName", getEventName());
		attributes.put("description", getDescription());
		attributes.put("eventDate", getEventDate());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("eventTypeId", getEventTypeId());
		attributes.put("eventTypeName", getEventTypeName());
		attributes.put("eventImageUUID", getEventImageUUID());
		attributes.put("eventImageGroupId", getEventImageGroupId());
		attributes.put("venueId", getVenueId());
		attributes.put("venueName", getVenueName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
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

		String eventName = (String)attributes.get("eventName");

		if (eventName != null) {
			setEventName(eventName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date eventDate = (Date)attributes.get("eventDate");

		if (eventDate != null) {
			setEventDate(eventDate);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Long eventTypeId = (Long)attributes.get("eventTypeId");

		if (eventTypeId != null) {
			setEventTypeId(eventTypeId);
		}

		String eventTypeName = (String)attributes.get("eventTypeName");

		if (eventTypeName != null) {
			setEventTypeName(eventTypeName);
		}

		String eventImageUUID = (String)attributes.get("eventImageUUID");

		if (eventImageUUID != null) {
			setEventImageUUID(eventImageUUID);
		}

		Long eventImageGroupId = (Long)attributes.get("eventImageGroupId");

		if (eventImageGroupId != null) {
			setEventImageGroupId(eventImageGroupId);
		}

		Long venueId = (Long)attributes.get("venueId");

		if (venueId != null) {
			setVenueId(venueId);
		}

		String venueName = (String)attributes.get("venueName");

		if (venueName != null) {
			setVenueName(venueName);
		}
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
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public Date getEventDate() {
		return _eventDate;
	}

	@Override
	public void setEventDate(Date eventDate) {
		_columnBitmask = -1L;

		if (_originalEventDate == null) {
			_originalEventDate = _eventDate;
		}

		_eventDate = eventDate;
	}

	public Date getOriginalEventDate() {
		return _originalEventDate;
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
	public long getEventTypeId() {
		return _eventTypeId;
	}

	@Override
	public void setEventTypeId(long eventTypeId) {
		_eventTypeId = eventTypeId;
	}

	@JSON
	@Override
	public String getEventTypeName() {
		if (_eventTypeName == null) {
			return StringPool.BLANK;
		}
		else {
			return _eventTypeName;
		}
	}

	@Override
	public void setEventTypeName(String eventTypeName) {
		_eventTypeName = eventTypeName;
	}

	@JSON
	@Override
	public String getEventImageUUID() {
		if (_eventImageUUID == null) {
			return StringPool.BLANK;
		}
		else {
			return _eventImageUUID;
		}
	}

	@Override
	public void setEventImageUUID(String eventImageUUID) {
		_eventImageUUID = eventImageUUID;
	}

	@JSON
	@Override
	public long getEventImageGroupId() {
		return _eventImageGroupId;
	}

	@Override
	public void setEventImageGroupId(long eventImageGroupId) {
		_eventImageGroupId = eventImageGroupId;
	}

	@JSON
	@Override
	public long getVenueId() {
		return _venueId;
	}

	@Override
	public void setVenueId(long venueId) {
		_columnBitmask |= VENUEID_COLUMN_BITMASK;

		if (!_setOriginalVenueId) {
			_setOriginalVenueId = true;

			_originalVenueId = _venueId;
		}

		_venueId = venueId;
	}

	public long getOriginalVenueId() {
		return _originalVenueId;
	}

	@JSON
	@Override
	public String getVenueName() {
		if (_venueName == null) {
			return StringPool.BLANK;
		}
		else {
			return _venueName;
		}
	}

	@Override
	public void setVenueName(String venueName) {
		_venueName = venueName;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Event.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Event toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Event)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EventImpl eventImpl = new EventImpl();

		eventImpl.setEventId(getEventId());
		eventImpl.setCompanyId(getCompanyId());
		eventImpl.setUserId(getUserId());
		eventImpl.setCreatedDate(getCreatedDate());
		eventImpl.setModifiedDate(getModifiedDate());
		eventImpl.setEventName(getEventName());
		eventImpl.setDescription(getDescription());
		eventImpl.setEventDate(getEventDate());
		eventImpl.setStartTime(getStartTime());
		eventImpl.setEndTime(getEndTime());
		eventImpl.setEventTypeId(getEventTypeId());
		eventImpl.setEventTypeName(getEventTypeName());
		eventImpl.setEventImageUUID(getEventImageUUID());
		eventImpl.setEventImageGroupId(getEventImageGroupId());
		eventImpl.setVenueId(getVenueId());
		eventImpl.setVenueName(getVenueName());

		eventImpl.resetOriginalValues();

		return eventImpl;
	}

	@Override
	public int compareTo(Event event) {
		int value = 0;

		value = DateUtil.compareTo(getEventDate(), event.getEventDate());

		value = value * -1;

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

		if (!(obj instanceof Event)) {
			return false;
		}

		Event event = (Event)obj;

		long primaryKey = event.getPrimaryKey();

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
		EventModelImpl eventModelImpl = this;

		eventModelImpl._originalEventDate = eventModelImpl._eventDate;

		eventModelImpl._originalVenueId = eventModelImpl._venueId;

		eventModelImpl._setOriginalVenueId = false;

		eventModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Event> toCacheModel() {
		EventCacheModel eventCacheModel = new EventCacheModel();

		eventCacheModel.eventId = getEventId();

		eventCacheModel.companyId = getCompanyId();

		eventCacheModel.userId = getUserId();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			eventCacheModel.createdDate = createdDate.getTime();
		}
		else {
			eventCacheModel.createdDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			eventCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			eventCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		eventCacheModel.eventName = getEventName();

		String eventName = eventCacheModel.eventName;

		if ((eventName != null) && (eventName.length() == 0)) {
			eventCacheModel.eventName = null;
		}

		eventCacheModel.description = getDescription();

		String description = eventCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			eventCacheModel.description = null;
		}

		Date eventDate = getEventDate();

		if (eventDate != null) {
			eventCacheModel.eventDate = eventDate.getTime();
		}
		else {
			eventCacheModel.eventDate = Long.MIN_VALUE;
		}

		Date startTime = getStartTime();

		if (startTime != null) {
			eventCacheModel.startTime = startTime.getTime();
		}
		else {
			eventCacheModel.startTime = Long.MIN_VALUE;
		}

		Date endTime = getEndTime();

		if (endTime != null) {
			eventCacheModel.endTime = endTime.getTime();
		}
		else {
			eventCacheModel.endTime = Long.MIN_VALUE;
		}

		eventCacheModel.eventTypeId = getEventTypeId();

		eventCacheModel.eventTypeName = getEventTypeName();

		String eventTypeName = eventCacheModel.eventTypeName;

		if ((eventTypeName != null) && (eventTypeName.length() == 0)) {
			eventCacheModel.eventTypeName = null;
		}

		eventCacheModel.eventImageUUID = getEventImageUUID();

		String eventImageUUID = eventCacheModel.eventImageUUID;

		if ((eventImageUUID != null) && (eventImageUUID.length() == 0)) {
			eventCacheModel.eventImageUUID = null;
		}

		eventCacheModel.eventImageGroupId = getEventImageGroupId();

		eventCacheModel.venueId = getVenueId();

		eventCacheModel.venueName = getVenueName();

		String venueName = eventCacheModel.venueName;

		if ((venueName != null) && (venueName.length() == 0)) {
			eventCacheModel.venueName = null;
		}

		return eventCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{eventId=");
		sb.append(getEventId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", eventName=");
		sb.append(getEventName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", eventDate=");
		sb.append(getEventDate());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", eventTypeId=");
		sb.append(getEventTypeId());
		sb.append(", eventTypeName=");
		sb.append(getEventTypeName());
		sb.append(", eventImageUUID=");
		sb.append(getEventImageUUID());
		sb.append(", eventImageGroupId=");
		sb.append(getEventImageGroupId());
		sb.append(", venueId=");
		sb.append(getVenueId());
		sb.append(", venueName=");
		sb.append(getVenueName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.Event");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventId</column-name><column-value><![CDATA[");
		sb.append(getEventId());
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
			"<column><column-name>eventName</column-name><column-value><![CDATA[");
		sb.append(getEventName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventDate</column-name><column-value><![CDATA[");
		sb.append(getEventDate());
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
			"<column><column-name>eventTypeId</column-name><column-value><![CDATA[");
		sb.append(getEventTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventTypeName</column-name><column-value><![CDATA[");
		sb.append(getEventTypeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventImageUUID</column-name><column-value><![CDATA[");
		sb.append(getEventImageUUID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventImageGroupId</column-name><column-value><![CDATA[");
		sb.append(getEventImageGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueId</column-name><column-value><![CDATA[");
		sb.append(getVenueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueName</column-name><column-value><![CDATA[");
		sb.append(getVenueName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Event.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Event.class };
	private long _eventId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _eventName;
	private String _description;
	private Date _eventDate;
	private Date _originalEventDate;
	private Date _startTime;
	private Date _endTime;
	private long _eventTypeId;
	private String _eventTypeName;
	private String _eventImageUUID;
	private long _eventImageGroupId;
	private long _venueId;
	private long _originalVenueId;
	private boolean _setOriginalVenueId;
	private String _venueName;
	private long _columnBitmask;
	private Event _escapedModel;
}