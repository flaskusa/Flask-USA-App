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

import com.rumbasolutions.flask.model.EventDetailImage;
import com.rumbasolutions.flask.model.EventDetailImageModel;
import com.rumbasolutions.flask.model.EventDetailImageSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the EventDetailImage service. Represents a row in the &quot;flaskevents_EventDetailImage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rumbasolutions.flask.model.EventDetailImageModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EventDetailImageImpl}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventDetailImageImpl
 * @see com.rumbasolutions.flask.model.EventDetailImage
 * @see com.rumbasolutions.flask.model.EventDetailImageModel
 * @generated
 */
@JSON(strict = true)
public class EventDetailImageModelImpl extends BaseModelImpl<EventDetailImage>
	implements EventDetailImageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a event detail image model instance should use the {@link com.rumbasolutions.flask.model.EventDetailImage} interface instead.
	 */
	public static final String TABLE_NAME = "flaskevents_EventDetailImage";
	public static final Object[][] TABLE_COLUMNS = {
			{ "eventDetailImageId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createdDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "eventDetailId", Types.BIGINT },
			{ "imageTitle", Types.VARCHAR },
			{ "imageDesc", Types.VARCHAR },
			{ "imageUUID", Types.VARCHAR },
			{ "imageGroupId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table flaskevents_EventDetailImage (eventDetailImageId LONG not null primary key,companyId LONG,userId LONG,createdDate DATE null,modifiedDate DATE null,eventDetailId LONG,imageTitle VARCHAR(75) null,imageDesc VARCHAR(75) null,imageUUID VARCHAR(75) null,imageGroupId LONG)";
	public static final String TABLE_SQL_DROP = "drop table flaskevents_EventDetailImage";
	public static final String ORDER_BY_JPQL = " ORDER BY eventDetailImage.eventDetailImageId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY flaskevents_EventDetailImage.eventDetailImageId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rumbasolutions.flask.model.EventDetailImage"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rumbasolutions.flask.model.EventDetailImage"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rumbasolutions.flask.model.EventDetailImage"),
			true);
	public static long EVENTDETAILID_COLUMN_BITMASK = 1L;
	public static long EVENTDETAILIMAGEID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static EventDetailImage toModel(EventDetailImageSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		EventDetailImage model = new EventDetailImageImpl();

		model.setEventDetailImageId(soapModel.getEventDetailImageId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setEventDetailId(soapModel.getEventDetailId());
		model.setImageTitle(soapModel.getImageTitle());
		model.setImageDesc(soapModel.getImageDesc());
		model.setImageUUID(soapModel.getImageUUID());
		model.setImageGroupId(soapModel.getImageGroupId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<EventDetailImage> toModels(
		EventDetailImageSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<EventDetailImage> models = new ArrayList<EventDetailImage>(soapModels.length);

		for (EventDetailImageSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rumbasolutions.flask.model.EventDetailImage"));

	public EventDetailImageModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _eventDetailImageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventDetailImageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventDetailImageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EventDetailImage.class;
	}

	@Override
	public String getModelClassName() {
		return EventDetailImage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("eventDetailImageId", getEventDetailImageId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventDetailId", getEventDetailId());
		attributes.put("imageTitle", getImageTitle());
		attributes.put("imageDesc", getImageDesc());
		attributes.put("imageUUID", getImageUUID());
		attributes.put("imageGroupId", getImageGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long eventDetailImageId = (Long)attributes.get("eventDetailImageId");

		if (eventDetailImageId != null) {
			setEventDetailImageId(eventDetailImageId);
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

		Long eventDetailId = (Long)attributes.get("eventDetailId");

		if (eventDetailId != null) {
			setEventDetailId(eventDetailId);
		}

		String imageTitle = (String)attributes.get("imageTitle");

		if (imageTitle != null) {
			setImageTitle(imageTitle);
		}

		String imageDesc = (String)attributes.get("imageDesc");

		if (imageDesc != null) {
			setImageDesc(imageDesc);
		}

		String imageUUID = (String)attributes.get("imageUUID");

		if (imageUUID != null) {
			setImageUUID(imageUUID);
		}

		Long imageGroupId = (Long)attributes.get("imageGroupId");

		if (imageGroupId != null) {
			setImageGroupId(imageGroupId);
		}
	}

	@JSON
	@Override
	public long getEventDetailImageId() {
		return _eventDetailImageId;
	}

	@Override
	public void setEventDetailImageId(long eventDetailImageId) {
		_eventDetailImageId = eventDetailImageId;
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
	public long getEventDetailId() {
		return _eventDetailId;
	}

	@Override
	public void setEventDetailId(long eventDetailId) {
		_columnBitmask |= EVENTDETAILID_COLUMN_BITMASK;

		if (!_setOriginalEventDetailId) {
			_setOriginalEventDetailId = true;

			_originalEventDetailId = _eventDetailId;
		}

		_eventDetailId = eventDetailId;
	}

	public long getOriginalEventDetailId() {
		return _originalEventDetailId;
	}

	@JSON
	@Override
	public String getImageTitle() {
		if (_imageTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageTitle;
		}
	}

	@Override
	public void setImageTitle(String imageTitle) {
		_imageTitle = imageTitle;
	}

	@JSON
	@Override
	public String getImageDesc() {
		if (_imageDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageDesc;
		}
	}

	@Override
	public void setImageDesc(String imageDesc) {
		_imageDesc = imageDesc;
	}

	@JSON
	@Override
	public String getImageUUID() {
		if (_imageUUID == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageUUID;
		}
	}

	@Override
	public void setImageUUID(String imageUUID) {
		_imageUUID = imageUUID;
	}

	@JSON
	@Override
	public long getImageGroupId() {
		return _imageGroupId;
	}

	@Override
	public void setImageGroupId(long imageGroupId) {
		_imageGroupId = imageGroupId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			EventDetailImage.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EventDetailImage toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (EventDetailImage)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EventDetailImageImpl eventDetailImageImpl = new EventDetailImageImpl();

		eventDetailImageImpl.setEventDetailImageId(getEventDetailImageId());
		eventDetailImageImpl.setCompanyId(getCompanyId());
		eventDetailImageImpl.setUserId(getUserId());
		eventDetailImageImpl.setCreatedDate(getCreatedDate());
		eventDetailImageImpl.setModifiedDate(getModifiedDate());
		eventDetailImageImpl.setEventDetailId(getEventDetailId());
		eventDetailImageImpl.setImageTitle(getImageTitle());
		eventDetailImageImpl.setImageDesc(getImageDesc());
		eventDetailImageImpl.setImageUUID(getImageUUID());
		eventDetailImageImpl.setImageGroupId(getImageGroupId());

		eventDetailImageImpl.resetOriginalValues();

		return eventDetailImageImpl;
	}

	@Override
	public int compareTo(EventDetailImage eventDetailImage) {
		long primaryKey = eventDetailImage.getPrimaryKey();

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

		if (!(obj instanceof EventDetailImage)) {
			return false;
		}

		EventDetailImage eventDetailImage = (EventDetailImage)obj;

		long primaryKey = eventDetailImage.getPrimaryKey();

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
		EventDetailImageModelImpl eventDetailImageModelImpl = this;

		eventDetailImageModelImpl._originalEventDetailId = eventDetailImageModelImpl._eventDetailId;

		eventDetailImageModelImpl._setOriginalEventDetailId = false;

		eventDetailImageModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<EventDetailImage> toCacheModel() {
		EventDetailImageCacheModel eventDetailImageCacheModel = new EventDetailImageCacheModel();

		eventDetailImageCacheModel.eventDetailImageId = getEventDetailImageId();

		eventDetailImageCacheModel.companyId = getCompanyId();

		eventDetailImageCacheModel.userId = getUserId();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			eventDetailImageCacheModel.createdDate = createdDate.getTime();
		}
		else {
			eventDetailImageCacheModel.createdDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			eventDetailImageCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			eventDetailImageCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		eventDetailImageCacheModel.eventDetailId = getEventDetailId();

		eventDetailImageCacheModel.imageTitle = getImageTitle();

		String imageTitle = eventDetailImageCacheModel.imageTitle;

		if ((imageTitle != null) && (imageTitle.length() == 0)) {
			eventDetailImageCacheModel.imageTitle = null;
		}

		eventDetailImageCacheModel.imageDesc = getImageDesc();

		String imageDesc = eventDetailImageCacheModel.imageDesc;

		if ((imageDesc != null) && (imageDesc.length() == 0)) {
			eventDetailImageCacheModel.imageDesc = null;
		}

		eventDetailImageCacheModel.imageUUID = getImageUUID();

		String imageUUID = eventDetailImageCacheModel.imageUUID;

		if ((imageUUID != null) && (imageUUID.length() == 0)) {
			eventDetailImageCacheModel.imageUUID = null;
		}

		eventDetailImageCacheModel.imageGroupId = getImageGroupId();

		return eventDetailImageCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{eventDetailImageId=");
		sb.append(getEventDetailImageId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", eventDetailId=");
		sb.append(getEventDetailId());
		sb.append(", imageTitle=");
		sb.append(getImageTitle());
		sb.append(", imageDesc=");
		sb.append(getImageDesc());
		sb.append(", imageUUID=");
		sb.append(getImageUUID());
		sb.append(", imageGroupId=");
		sb.append(getImageGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.EventDetailImage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>eventDetailImageId</column-name><column-value><![CDATA[");
		sb.append(getEventDetailImageId());
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
			"<column><column-name>eventDetailId</column-name><column-value><![CDATA[");
		sb.append(getEventDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageTitle</column-name><column-value><![CDATA[");
		sb.append(getImageTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageDesc</column-name><column-value><![CDATA[");
		sb.append(getImageDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageUUID</column-name><column-value><![CDATA[");
		sb.append(getImageUUID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageGroupId</column-name><column-value><![CDATA[");
		sb.append(getImageGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = EventDetailImage.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			EventDetailImage.class
		};
	private long _eventDetailImageId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createdDate;
	private Date _modifiedDate;
	private long _eventDetailId;
	private long _originalEventDetailId;
	private boolean _setOriginalEventDetailId;
	private String _imageTitle;
	private String _imageDesc;
	private String _imageUUID;
	private long _imageGroupId;
	private long _columnBitmask;
	private EventDetailImage _escapedModel;
}