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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the FlaskGroupUsers service. Represents a row in the &quot;flaskgroup_FlaskGroupUsers&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rumbasolutions.flask.model.impl.FlaskGroupUsersModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rumbasolutions.flask.model.impl.FlaskGroupUsersImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupUsers
 * @see com.rumbasolutions.flask.model.impl.FlaskGroupUsersImpl
 * @see com.rumbasolutions.flask.model.impl.FlaskGroupUsersModelImpl
 * @generated
 */
public interface FlaskGroupUsersModel extends BaseModel<FlaskGroupUsers> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a flask group users model instance should use the {@link FlaskGroupUsers} interface instead.
	 */

	/**
	 * Returns the primary key of this flask group users.
	 *
	 * @return the primary key of this flask group users
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this flask group users.
	 *
	 * @param primaryKey the primary key of this flask group users
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the group user ID of this flask group users.
	 *
	 * @return the group user ID of this flask group users
	 */
	public long getGroupUserId();

	/**
	 * Sets the group user ID of this flask group users.
	 *
	 * @param groupUserId the group user ID of this flask group users
	 */
	public void setGroupUserId(long groupUserId);

	/**
	 * Returns the group user uuid of this flask group users.
	 *
	 * @return the group user uuid of this flask group users
	 * @throws SystemException if a system exception occurred
	 */
	public String getGroupUserUuid() throws SystemException;

	/**
	 * Sets the group user uuid of this flask group users.
	 *
	 * @param groupUserUuid the group user uuid of this flask group users
	 */
	public void setGroupUserUuid(String groupUserUuid);

	/**
	 * Returns the group ID of this flask group users.
	 *
	 * @return the group ID of this flask group users
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this flask group users.
	 *
	 * @param groupId the group ID of this flask group users
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this flask group users.
	 *
	 * @return the user ID of this flask group users
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this flask group users.
	 *
	 * @param userId the user ID of this flask group users
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this flask group users.
	 *
	 * @return the user uuid of this flask group users
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this flask group users.
	 *
	 * @param userUuid the user uuid of this flask group users
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this flask group users.
	 *
	 * @return the user name of this flask group users
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this flask group users.
	 *
	 * @param userName the user name of this flask group users
	 */
	public void setUserName(String userName);

	/**
	 * Returns the is admin of this flask group users.
	 *
	 * @return the is admin of this flask group users
	 */
	public int getIsAdmin();

	/**
	 * Sets the is admin of this flask group users.
	 *
	 * @param isAdmin the is admin of this flask group users
	 */
	public void setIsAdmin(int isAdmin);

	/**
	 * Returns the email address of this flask group users.
	 *
	 * @return the email address of this flask group users
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this flask group users.
	 *
	 * @param emailAddress the email address of this flask group users
	 */
	public void setEmailAddress(String emailAddress);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.rumbasolutions.flask.model.FlaskGroupUsers flaskGroupUsers);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.rumbasolutions.flask.model.FlaskGroupUsers> toCacheModel();

	@Override
	public com.rumbasolutions.flask.model.FlaskGroupUsers toEscapedModel();

	@Override
	public com.rumbasolutions.flask.model.FlaskGroupUsers toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}