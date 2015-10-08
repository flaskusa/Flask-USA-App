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

import com.liferay.contacts.model.FlaskMessages;
import com.liferay.contacts.model.FlaskMessagesModel;
import com.liferay.contacts.model.FlaskMessagesSoap;

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

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the FlaskMessages service. Represents a row in the &quot;Contacts_FlaskMessages&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.contacts.model.FlaskMessagesModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FlaskMessagesImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskMessagesImpl
 * @see com.liferay.contacts.model.FlaskMessages
 * @see com.liferay.contacts.model.FlaskMessagesModel
 * @generated
 */
@JSON(strict = true)
public class FlaskMessagesModelImpl extends BaseModelImpl<FlaskMessages>
	implements FlaskMessagesModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a flask messages model instance should use the {@link com.liferay.contacts.model.FlaskMessages} interface instead.
	 */
	public static final String TABLE_NAME = "Contacts_FlaskMessages";
	public static final Object[][] TABLE_COLUMNS = {
			{ "messageId", Types.BIGINT },
			{ "senderEmail", Types.VARCHAR },
			{ "senderUserId", Types.BIGINT },
			{ "senderName", Types.VARCHAR },
			{ "recipients", Types.VARCHAR },
			{ "message", Types.VARCHAR },
			{ "sendEmail", Types.BOOLEAN },
			{ "dateTime", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table Contacts_FlaskMessages (messageId LONG not null primary key,senderEmail VARCHAR(75) null,senderUserId LONG,senderName VARCHAR(75) null,recipients VARCHAR(75) null,message VARCHAR(75) null,sendEmail BOOLEAN,dateTime DATE null)";
	public static final String TABLE_SQL_DROP = "drop table Contacts_FlaskMessages";
	public static final String ORDER_BY_JPQL = " ORDER BY flaskMessages.messageId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Contacts_FlaskMessages.messageId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.contacts.model.FlaskMessages"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.contacts.model.FlaskMessages"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static FlaskMessages toModel(FlaskMessagesSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		FlaskMessages model = new FlaskMessagesImpl();

		model.setMessageId(soapModel.getMessageId());
		model.setSenderEmail(soapModel.getSenderEmail());
		model.setSenderUserId(soapModel.getSenderUserId());
		model.setSenderName(soapModel.getSenderName());
		model.setRecipients(soapModel.getRecipients());
		model.setMessage(soapModel.getMessage());
		model.setSendEmail(soapModel.getSendEmail());
		model.setDateTime(soapModel.getDateTime());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<FlaskMessages> toModels(FlaskMessagesSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<FlaskMessages> models = new ArrayList<FlaskMessages>(soapModels.length);

		for (FlaskMessagesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.contacts.model.FlaskMessages"));

	public FlaskMessagesModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _messageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMessageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _messageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskMessages.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskMessages.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("messageId", getMessageId());
		attributes.put("senderEmail", getSenderEmail());
		attributes.put("senderUserId", getSenderUserId());
		attributes.put("senderName", getSenderName());
		attributes.put("recipients", getRecipients());
		attributes.put("message", getMessage());
		attributes.put("sendEmail", getSendEmail());
		attributes.put("dateTime", getDateTime());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		String senderEmail = (String)attributes.get("senderEmail");

		if (senderEmail != null) {
			setSenderEmail(senderEmail);
		}

		Long senderUserId = (Long)attributes.get("senderUserId");

		if (senderUserId != null) {
			setSenderUserId(senderUserId);
		}

		String senderName = (String)attributes.get("senderName");

		if (senderName != null) {
			setSenderName(senderName);
		}

		String recipients = (String)attributes.get("recipients");

		if (recipients != null) {
			setRecipients(recipients);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Boolean sendEmail = (Boolean)attributes.get("sendEmail");

		if (sendEmail != null) {
			setSendEmail(sendEmail);
		}

		Date dateTime = (Date)attributes.get("dateTime");

		if (dateTime != null) {
			setDateTime(dateTime);
		}
	}

	@JSON
	@Override
	public long getMessageId() {
		return _messageId;
	}

	@Override
	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	@JSON
	@Override
	public String getSenderEmail() {
		if (_senderEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _senderEmail;
		}
	}

	@Override
	public void setSenderEmail(String senderEmail) {
		_senderEmail = senderEmail;
	}

	@JSON
	@Override
	public long getSenderUserId() {
		return _senderUserId;
	}

	@Override
	public void setSenderUserId(long senderUserId) {
		_senderUserId = senderUserId;
	}

	@Override
	public String getSenderUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getSenderUserId(), "uuid",
			_senderUserUuid);
	}

	@Override
	public void setSenderUserUuid(String senderUserUuid) {
		_senderUserUuid = senderUserUuid;
	}

	@JSON
	@Override
	public String getSenderName() {
		if (_senderName == null) {
			return StringPool.BLANK;
		}
		else {
			return _senderName;
		}
	}

	@Override
	public void setSenderName(String senderName) {
		_senderName = senderName;
	}

	@JSON
	@Override
	public String getRecipients() {
		if (_recipients == null) {
			return StringPool.BLANK;
		}
		else {
			return _recipients;
		}
	}

	@Override
	public void setRecipients(String recipients) {
		_recipients = recipients;
	}

	@JSON
	@Override
	public String getMessage() {
		if (_message == null) {
			return StringPool.BLANK;
		}
		else {
			return _message;
		}
	}

	@Override
	public void setMessage(String message) {
		_message = message;
	}

	@JSON
	@Override
	public boolean getSendEmail() {
		return _sendEmail;
	}

	@Override
	public boolean isSendEmail() {
		return _sendEmail;
	}

	@Override
	public void setSendEmail(boolean sendEmail) {
		_sendEmail = sendEmail;
	}

	@JSON
	@Override
	public Date getDateTime() {
		return _dateTime;
	}

	@Override
	public void setDateTime(Date dateTime) {
		_dateTime = dateTime;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			FlaskMessages.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FlaskMessages toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FlaskMessages)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FlaskMessagesImpl flaskMessagesImpl = new FlaskMessagesImpl();

		flaskMessagesImpl.setMessageId(getMessageId());
		flaskMessagesImpl.setSenderEmail(getSenderEmail());
		flaskMessagesImpl.setSenderUserId(getSenderUserId());
		flaskMessagesImpl.setSenderName(getSenderName());
		flaskMessagesImpl.setRecipients(getRecipients());
		flaskMessagesImpl.setMessage(getMessage());
		flaskMessagesImpl.setSendEmail(getSendEmail());
		flaskMessagesImpl.setDateTime(getDateTime());

		flaskMessagesImpl.resetOriginalValues();

		return flaskMessagesImpl;
	}

	@Override
	public int compareTo(FlaskMessages flaskMessages) {
		long primaryKey = flaskMessages.getPrimaryKey();

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

		if (!(obj instanceof FlaskMessages)) {
			return false;
		}

		FlaskMessages flaskMessages = (FlaskMessages)obj;

		long primaryKey = flaskMessages.getPrimaryKey();

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
	public CacheModel<FlaskMessages> toCacheModel() {
		FlaskMessagesCacheModel flaskMessagesCacheModel = new FlaskMessagesCacheModel();

		flaskMessagesCacheModel.messageId = getMessageId();

		flaskMessagesCacheModel.senderEmail = getSenderEmail();

		String senderEmail = flaskMessagesCacheModel.senderEmail;

		if ((senderEmail != null) && (senderEmail.length() == 0)) {
			flaskMessagesCacheModel.senderEmail = null;
		}

		flaskMessagesCacheModel.senderUserId = getSenderUserId();

		flaskMessagesCacheModel.senderName = getSenderName();

		String senderName = flaskMessagesCacheModel.senderName;

		if ((senderName != null) && (senderName.length() == 0)) {
			flaskMessagesCacheModel.senderName = null;
		}

		flaskMessagesCacheModel.recipients = getRecipients();

		String recipients = flaskMessagesCacheModel.recipients;

		if ((recipients != null) && (recipients.length() == 0)) {
			flaskMessagesCacheModel.recipients = null;
		}

		flaskMessagesCacheModel.message = getMessage();

		String message = flaskMessagesCacheModel.message;

		if ((message != null) && (message.length() == 0)) {
			flaskMessagesCacheModel.message = null;
		}

		flaskMessagesCacheModel.sendEmail = getSendEmail();

		Date dateTime = getDateTime();

		if (dateTime != null) {
			flaskMessagesCacheModel.dateTime = dateTime.getTime();
		}
		else {
			flaskMessagesCacheModel.dateTime = Long.MIN_VALUE;
		}

		return flaskMessagesCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{messageId=");
		sb.append(getMessageId());
		sb.append(", senderEmail=");
		sb.append(getSenderEmail());
		sb.append(", senderUserId=");
		sb.append(getSenderUserId());
		sb.append(", senderName=");
		sb.append(getSenderName());
		sb.append(", recipients=");
		sb.append(getRecipients());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", sendEmail=");
		sb.append(getSendEmail());
		sb.append(", dateTime=");
		sb.append(getDateTime());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.contacts.model.FlaskMessages");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>messageId</column-name><column-value><![CDATA[");
		sb.append(getMessageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderEmail</column-name><column-value><![CDATA[");
		sb.append(getSenderEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderUserId</column-name><column-value><![CDATA[");
		sb.append(getSenderUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderName</column-name><column-value><![CDATA[");
		sb.append(getSenderName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recipients</column-name><column-value><![CDATA[");
		sb.append(getRecipients());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sendEmail</column-name><column-value><![CDATA[");
		sb.append(getSendEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateTime</column-name><column-value><![CDATA[");
		sb.append(getDateTime());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = FlaskMessages.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			FlaskMessages.class
		};
	private long _messageId;
	private String _senderEmail;
	private long _senderUserId;
	private String _senderUserUuid;
	private String _senderName;
	private String _recipients;
	private String _message;
	private boolean _sendEmail;
	private Date _dateTime;
	private FlaskMessages _escapedModel;
}