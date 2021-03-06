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
 * The base model interface for the TailgateUsers service. Represents a row in the &quot;flasktailgate_TailgateUsers&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rumbasolutions.flask.model.impl.TailgateUsersModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rumbasolutions.flask.model.impl.TailgateUsersImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TailgateUsers
 * @see com.rumbasolutions.flask.model.impl.TailgateUsersImpl
 * @see com.rumbasolutions.flask.model.impl.TailgateUsersModelImpl
 * @generated
 */
public interface TailgateUsersModel extends BaseModel<TailgateUsers> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a tailgate users model instance should use the {@link TailgateUsers} interface instead.
	 */

	/**
	 * Returns the primary key of this tailgate users.
	 *
	 * @return the primary key of this tailgate users
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this tailgate users.
	 *
	 * @param primaryKey the primary key of this tailgate users
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the tailgate user ID of this tailgate users.
	 *
	 * @return the tailgate user ID of this tailgate users
	 */
	public long getTailgateUserId();

	/**
	 * Sets the tailgate user ID of this tailgate users.
	 *
	 * @param tailgateUserId the tailgate user ID of this tailgate users
	 */
	public void setTailgateUserId(long tailgateUserId);

	/**
	 * Returns the tailgate user uuid of this tailgate users.
	 *
	 * @return the tailgate user uuid of this tailgate users
	 * @throws SystemException if a system exception occurred
	 */
	public String getTailgateUserUuid() throws SystemException;

	/**
	 * Sets the tailgate user uuid of this tailgate users.
	 *
	 * @param tailgateUserUuid the tailgate user uuid of this tailgate users
	 */
	public void setTailgateUserUuid(String tailgateUserUuid);

	/**
	 * Returns the tailgate ID of this tailgate users.
	 *
	 * @return the tailgate ID of this tailgate users
	 */
	public long getTailgateId();

	/**
	 * Sets the tailgate ID of this tailgate users.
	 *
	 * @param tailgateId the tailgate ID of this tailgate users
	 */
	public void setTailgateId(long tailgateId);

	/**
	 * Returns the user ID of this tailgate users.
	 *
	 * @return the user ID of this tailgate users
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this tailgate users.
	 *
	 * @param userId the user ID of this tailgate users
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this tailgate users.
	 *
	 * @return the user uuid of this tailgate users
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this tailgate users.
	 *
	 * @param userUuid the user uuid of this tailgate users
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this tailgate users.
	 *
	 * @return the user name of this tailgate users
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this tailgate users.
	 *
	 * @param userName the user name of this tailgate users
	 */
	public void setUserName(String userName);

	/**
	 * Returns the is admin of this tailgate users.
	 *
	 * @return the is admin of this tailgate users
	 */
	public int getIsAdmin();

	/**
	 * Sets the is admin of this tailgate users.
	 *
	 * @param isAdmin the is admin of this tailgate users
	 */
	public void setIsAdmin(int isAdmin);

	/**
	 * Returns the group ID of this tailgate users.
	 *
	 * @return the group ID of this tailgate users
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this tailgate users.
	 *
	 * @param groupId the group ID of this tailgate users
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the email address of this tailgate users.
	 *
	 * @return the email address of this tailgate users
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this tailgate users.
	 *
	 * @param emailAddress the email address of this tailgate users
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the is paid of this tailgate users.
	 *
	 * @return the is paid of this tailgate users
	 */
	public boolean getIsPaid();

	/**
	 * Returns <code>true</code> if this tailgate users is is paid.
	 *
	 * @return <code>true</code> if this tailgate users is is paid; <code>false</code> otherwise
	 */
	public boolean isIsPaid();

	/**
	 * Sets whether this tailgate users is is paid.
	 *
	 * @param isPaid the is paid of this tailgate users
	 */
	public void setIsPaid(boolean isPaid);

	/**
	 * Returns the payment mode of this tailgate users.
	 *
	 * @return the payment mode of this tailgate users
	 */
	@AutoEscape
	public String getPaymentMode();

	/**
	 * Sets the payment mode of this tailgate users.
	 *
	 * @param paymentMode the payment mode of this tailgate users
	 */
	public void setPaymentMode(String paymentMode);

	/**
	 * Returns the description of this tailgate users.
	 *
	 * @return the description of this tailgate users
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this tailgate users.
	 *
	 * @param description the description of this tailgate users
	 */
	public void setDescription(String description);

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
		com.rumbasolutions.flask.model.TailgateUsers tailgateUsers);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.rumbasolutions.flask.model.TailgateUsers> toCacheModel();

	@Override
	public com.rumbasolutions.flask.model.TailgateUsers toEscapedModel();

	@Override
	public com.rumbasolutions.flask.model.TailgateUsers toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}