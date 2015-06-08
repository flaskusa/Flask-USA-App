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
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the InfoType service. Represents a row in the &quot;flaskevents_InfoType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rumbasolutions.flask.model.impl.InfoTypeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rumbasolutions.flask.model.impl.InfoTypeImpl}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see InfoType
 * @see com.rumbasolutions.flask.model.impl.InfoTypeImpl
 * @see com.rumbasolutions.flask.model.impl.InfoTypeModelImpl
 * @generated
 */
public interface InfoTypeModel extends BaseModel<InfoType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a info type model instance should use the {@link InfoType} interface instead.
	 */

	/**
	 * Returns the primary key of this info type.
	 *
	 * @return the primary key of this info type
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this info type.
	 *
	 * @param primaryKey the primary key of this info type
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the info type ID of this info type.
	 *
	 * @return the info type ID of this info type
	 */
	public long getInfoTypeId();

	/**
	 * Sets the info type ID of this info type.
	 *
	 * @param infoTypeId the info type ID of this info type
	 */
	public void setInfoTypeId(long infoTypeId);

	/**
	 * Returns the info type name of this info type.
	 *
	 * @return the info type name of this info type
	 */
	@AutoEscape
	public String getInfoTypeName();

	/**
	 * Sets the info type name of this info type.
	 *
	 * @param infoTypeName the info type name of this info type
	 */
	public void setInfoTypeName(String infoTypeName);

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
	public int compareTo(com.rumbasolutions.flask.model.InfoType infoType);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.rumbasolutions.flask.model.InfoType> toCacheModel();

	@Override
	public com.rumbasolutions.flask.model.InfoType toEscapedModel();

	@Override
	public com.rumbasolutions.flask.model.InfoType toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}