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

import com.rumbasolutions.flask.model.FlaskGroupUsers;
import com.rumbasolutions.flask.model.FlaskGroupUsersModel;
import com.rumbasolutions.flask.model.FlaskGroupUsersSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the FlaskGroupUsers service. Represents a row in the &quot;flaskgroup_FlaskGroupUsers&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rumbasolutions.flask.model.FlaskGroupUsersModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FlaskGroupUsersImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupUsersImpl
 * @see com.rumbasolutions.flask.model.FlaskGroupUsers
 * @see com.rumbasolutions.flask.model.FlaskGroupUsersModel
 * @generated
 */
@JSON(strict = true)
public class FlaskGroupUsersModelImpl extends BaseModelImpl<FlaskGroupUsers>
	implements FlaskGroupUsersModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a flask group users model instance should use the {@link com.rumbasolutions.flask.model.FlaskGroupUsers} interface instead.
	 */
	public static final String TABLE_NAME = "flaskgroup_FlaskGroupUsers";
	public static final Object[][] TABLE_COLUMNS = {
			{ "groupUserId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "isAdmin", Types.INTEGER },
			{ "emailAddress", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table flaskgroup_FlaskGroupUsers (groupUserId LONG not null primary key,groupId LONG,userId LONG,userName VARCHAR(75) null,isAdmin INTEGER,emailAddress VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table flaskgroup_FlaskGroupUsers";
	public static final String ORDER_BY_JPQL = " ORDER BY flaskGroupUsers.groupUserId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY flaskgroup_FlaskGroupUsers.groupUserId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rumbasolutions.flask.model.FlaskGroupUsers"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rumbasolutions.flask.model.FlaskGroupUsers"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rumbasolutions.flask.model.FlaskGroupUsers"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long USERID_COLUMN_BITMASK = 2L;
	public static long GROUPUSERID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static FlaskGroupUsers toModel(FlaskGroupUsersSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		FlaskGroupUsers model = new FlaskGroupUsersImpl();

		model.setGroupUserId(soapModel.getGroupUserId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setIsAdmin(soapModel.getIsAdmin());
		model.setEmailAddress(soapModel.getEmailAddress());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<FlaskGroupUsers> toModels(
		FlaskGroupUsersSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<FlaskGroupUsers> models = new ArrayList<FlaskGroupUsers>(soapModels.length);

		for (FlaskGroupUsersSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rumbasolutions.flask.model.FlaskGroupUsers"));

	public FlaskGroupUsersModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _groupUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGroupUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _groupUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FlaskGroupUsers.class;
	}

	@Override
	public String getModelClassName() {
		return FlaskGroupUsers.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupUserId", getGroupUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("isAdmin", getIsAdmin());
		attributes.put("emailAddress", getEmailAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupUserId = (Long)attributes.get("groupUserId");

		if (groupUserId != null) {
			setGroupUserId(groupUserId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Integer isAdmin = (Integer)attributes.get("isAdmin");

		if (isAdmin != null) {
			setIsAdmin(isAdmin);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}
	}

	@JSON
	@Override
	public long getGroupUserId() {
		return _groupUserId;
	}

	@Override
	public void setGroupUserId(long groupUserId) {
		_groupUserId = groupUserId;
	}

	@Override
	public String getGroupUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getGroupUserId(), "uuid", _groupUserUuid);
	}

	@Override
	public void setGroupUserUuid(String groupUserUuid) {
		_groupUserUuid = groupUserUuid;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

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

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public int getIsAdmin() {
		return _isAdmin;
	}

	@Override
	public void setIsAdmin(int isAdmin) {
		_isAdmin = isAdmin;
	}

	@JSON
	@Override
	public String getEmailAddress() {
		if (_emailAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _emailAddress;
		}
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			FlaskGroupUsers.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FlaskGroupUsers toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (FlaskGroupUsers)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FlaskGroupUsersImpl flaskGroupUsersImpl = new FlaskGroupUsersImpl();

		flaskGroupUsersImpl.setGroupUserId(getGroupUserId());
		flaskGroupUsersImpl.setGroupId(getGroupId());
		flaskGroupUsersImpl.setUserId(getUserId());
		flaskGroupUsersImpl.setUserName(getUserName());
		flaskGroupUsersImpl.setIsAdmin(getIsAdmin());
		flaskGroupUsersImpl.setEmailAddress(getEmailAddress());

		flaskGroupUsersImpl.resetOriginalValues();

		return flaskGroupUsersImpl;
	}

	@Override
	public int compareTo(FlaskGroupUsers flaskGroupUsers) {
		long primaryKey = flaskGroupUsers.getPrimaryKey();

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

		if (!(obj instanceof FlaskGroupUsers)) {
			return false;
		}

		FlaskGroupUsers flaskGroupUsers = (FlaskGroupUsers)obj;

		long primaryKey = flaskGroupUsers.getPrimaryKey();

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
		FlaskGroupUsersModelImpl flaskGroupUsersModelImpl = this;

		flaskGroupUsersModelImpl._originalGroupId = flaskGroupUsersModelImpl._groupId;

		flaskGroupUsersModelImpl._setOriginalGroupId = false;

		flaskGroupUsersModelImpl._originalUserId = flaskGroupUsersModelImpl._userId;

		flaskGroupUsersModelImpl._setOriginalUserId = false;

		flaskGroupUsersModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<FlaskGroupUsers> toCacheModel() {
		FlaskGroupUsersCacheModel flaskGroupUsersCacheModel = new FlaskGroupUsersCacheModel();

		flaskGroupUsersCacheModel.groupUserId = getGroupUserId();

		flaskGroupUsersCacheModel.groupId = getGroupId();

		flaskGroupUsersCacheModel.userId = getUserId();

		flaskGroupUsersCacheModel.userName = getUserName();

		String userName = flaskGroupUsersCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			flaskGroupUsersCacheModel.userName = null;
		}

		flaskGroupUsersCacheModel.isAdmin = getIsAdmin();

		flaskGroupUsersCacheModel.emailAddress = getEmailAddress();

		String emailAddress = flaskGroupUsersCacheModel.emailAddress;

		if ((emailAddress != null) && (emailAddress.length() == 0)) {
			flaskGroupUsersCacheModel.emailAddress = null;
		}

		return flaskGroupUsersCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{groupUserId=");
		sb.append(getGroupUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", isAdmin=");
		sb.append(getIsAdmin());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.FlaskGroupUsers");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>groupUserId</column-name><column-value><![CDATA[");
		sb.append(getGroupUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isAdmin</column-name><column-value><![CDATA[");
		sb.append(getIsAdmin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = FlaskGroupUsers.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			FlaskGroupUsers.class
		};
	private long _groupUserId;
	private String _groupUserUuid;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private int _isAdmin;
	private String _emailAddress;
	private long _columnBitmask;
	private FlaskGroupUsers _escapedModel;
}