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
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.rumbasolutions.flask.model.VenueSubDetail;
import com.rumbasolutions.flask.model.VenueSubDetailModel;
import com.rumbasolutions.flask.model.VenueSubDetailSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the VenueSubDetail service. Represents a row in the &quot;flaskevents_VenueSubDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.rumbasolutions.flask.model.VenueSubDetailModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VenueSubDetailImpl}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueSubDetailImpl
 * @see com.rumbasolutions.flask.model.VenueSubDetail
 * @see com.rumbasolutions.flask.model.VenueSubDetailModel
 * @generated
 */
@JSON(strict = true)
public class VenueSubDetailModelImpl extends BaseModelImpl<VenueSubDetail>
	implements VenueSubDetailModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a venue sub detail model instance should use the {@link com.rumbasolutions.flask.model.VenueSubDetail} interface instead.
	 */
	public static final String TABLE_NAME = "flaskevents_VenueSubDetail";
	public static final Object[][] TABLE_COLUMNS = {
			{ "venueSubDetailId", Types.BIGINT },
			{ "venueDetailId", Types.BIGINT },
			{ "venueSubDetailTitle", Types.VARCHAR },
			{ "venueSubDetailDesc", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table flaskevents_VenueSubDetail (venueSubDetailId LONG not null primary key,venueDetailId LONG,venueSubDetailTitle VARCHAR(75) null,venueSubDetailDesc VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table flaskevents_VenueSubDetail";
	public static final String ORDER_BY_JPQL = " ORDER BY venueSubDetail.venueSubDetailId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY flaskevents_VenueSubDetail.venueSubDetailId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.rumbasolutions.flask.model.VenueSubDetail"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.rumbasolutions.flask.model.VenueSubDetail"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.rumbasolutions.flask.model.VenueSubDetail"),
			true);
	public static long VENUEDETAILID_COLUMN_BITMASK = 1L;
	public static long VENUESUBDETAILID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static VenueSubDetail toModel(VenueSubDetailSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		VenueSubDetail model = new VenueSubDetailImpl();

		model.setVenueSubDetailId(soapModel.getVenueSubDetailId());
		model.setVenueDetailId(soapModel.getVenueDetailId());
		model.setVenueSubDetailTitle(soapModel.getVenueSubDetailTitle());
		model.setVenueSubDetailDesc(soapModel.getVenueSubDetailDesc());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<VenueSubDetail> toModels(VenueSubDetailSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<VenueSubDetail> models = new ArrayList<VenueSubDetail>(soapModels.length);

		for (VenueSubDetailSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.rumbasolutions.flask.model.VenueSubDetail"));

	public VenueSubDetailModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _venueSubDetailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVenueSubDetailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _venueSubDetailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return VenueSubDetail.class;
	}

	@Override
	public String getModelClassName() {
		return VenueSubDetail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("venueSubDetailId", getVenueSubDetailId());
		attributes.put("venueDetailId", getVenueDetailId());
		attributes.put("venueSubDetailTitle", getVenueSubDetailTitle());
		attributes.put("venueSubDetailDesc", getVenueSubDetailDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long venueSubDetailId = (Long)attributes.get("venueSubDetailId");

		if (venueSubDetailId != null) {
			setVenueSubDetailId(venueSubDetailId);
		}

		Long venueDetailId = (Long)attributes.get("venueDetailId");

		if (venueDetailId != null) {
			setVenueDetailId(venueDetailId);
		}

		String venueSubDetailTitle = (String)attributes.get(
				"venueSubDetailTitle");

		if (venueSubDetailTitle != null) {
			setVenueSubDetailTitle(venueSubDetailTitle);
		}

		String venueSubDetailDesc = (String)attributes.get("venueSubDetailDesc");

		if (venueSubDetailDesc != null) {
			setVenueSubDetailDesc(venueSubDetailDesc);
		}
	}

	@JSON
	@Override
	public long getVenueSubDetailId() {
		return _venueSubDetailId;
	}

	@Override
	public void setVenueSubDetailId(long venueSubDetailId) {
		_venueSubDetailId = venueSubDetailId;
	}

	@JSON
	@Override
	public long getVenueDetailId() {
		return _venueDetailId;
	}

	@Override
	public void setVenueDetailId(long venueDetailId) {
		_columnBitmask |= VENUEDETAILID_COLUMN_BITMASK;

		if (!_setOriginalVenueDetailId) {
			_setOriginalVenueDetailId = true;

			_originalVenueDetailId = _venueDetailId;
		}

		_venueDetailId = venueDetailId;
	}

	public long getOriginalVenueDetailId() {
		return _originalVenueDetailId;
	}

	@JSON
	@Override
	public String getVenueSubDetailTitle() {
		if (_venueSubDetailTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _venueSubDetailTitle;
		}
	}

	@Override
	public void setVenueSubDetailTitle(String venueSubDetailTitle) {
		_venueSubDetailTitle = venueSubDetailTitle;
	}

	@JSON
	@Override
	public String getVenueSubDetailDesc() {
		if (_venueSubDetailDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _venueSubDetailDesc;
		}
	}

	@Override
	public void setVenueSubDetailDesc(String venueSubDetailDesc) {
		_venueSubDetailDesc = venueSubDetailDesc;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			VenueSubDetail.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public VenueSubDetail toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (VenueSubDetail)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VenueSubDetailImpl venueSubDetailImpl = new VenueSubDetailImpl();

		venueSubDetailImpl.setVenueSubDetailId(getVenueSubDetailId());
		venueSubDetailImpl.setVenueDetailId(getVenueDetailId());
		venueSubDetailImpl.setVenueSubDetailTitle(getVenueSubDetailTitle());
		venueSubDetailImpl.setVenueSubDetailDesc(getVenueSubDetailDesc());

		venueSubDetailImpl.resetOriginalValues();

		return venueSubDetailImpl;
	}

	@Override
	public int compareTo(VenueSubDetail venueSubDetail) {
		long primaryKey = venueSubDetail.getPrimaryKey();

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

		if (!(obj instanceof VenueSubDetail)) {
			return false;
		}

		VenueSubDetail venueSubDetail = (VenueSubDetail)obj;

		long primaryKey = venueSubDetail.getPrimaryKey();

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
		VenueSubDetailModelImpl venueSubDetailModelImpl = this;

		venueSubDetailModelImpl._originalVenueDetailId = venueSubDetailModelImpl._venueDetailId;

		venueSubDetailModelImpl._setOriginalVenueDetailId = false;

		venueSubDetailModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VenueSubDetail> toCacheModel() {
		VenueSubDetailCacheModel venueSubDetailCacheModel = new VenueSubDetailCacheModel();

		venueSubDetailCacheModel.venueSubDetailId = getVenueSubDetailId();

		venueSubDetailCacheModel.venueDetailId = getVenueDetailId();

		venueSubDetailCacheModel.venueSubDetailTitle = getVenueSubDetailTitle();

		String venueSubDetailTitle = venueSubDetailCacheModel.venueSubDetailTitle;

		if ((venueSubDetailTitle != null) &&
				(venueSubDetailTitle.length() == 0)) {
			venueSubDetailCacheModel.venueSubDetailTitle = null;
		}

		venueSubDetailCacheModel.venueSubDetailDesc = getVenueSubDetailDesc();

		String venueSubDetailDesc = venueSubDetailCacheModel.venueSubDetailDesc;

		if ((venueSubDetailDesc != null) && (venueSubDetailDesc.length() == 0)) {
			venueSubDetailCacheModel.venueSubDetailDesc = null;
		}

		return venueSubDetailCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{venueSubDetailId=");
		sb.append(getVenueSubDetailId());
		sb.append(", venueDetailId=");
		sb.append(getVenueDetailId());
		sb.append(", venueSubDetailTitle=");
		sb.append(getVenueSubDetailTitle());
		sb.append(", venueSubDetailDesc=");
		sb.append(getVenueSubDetailDesc());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.rumbasolutions.flask.model.VenueSubDetail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>venueSubDetailId</column-name><column-value><![CDATA[");
		sb.append(getVenueSubDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueDetailId</column-name><column-value><![CDATA[");
		sb.append(getVenueDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueSubDetailTitle</column-name><column-value><![CDATA[");
		sb.append(getVenueSubDetailTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>venueSubDetailDesc</column-name><column-value><![CDATA[");
		sb.append(getVenueSubDetailDesc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = VenueSubDetail.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			VenueSubDetail.class
		};
	private long _venueSubDetailId;
	private long _venueDetailId;
	private long _originalVenueDetailId;
	private boolean _setOriginalVenueDetailId;
	private String _venueSubDetailTitle;
	private String _venueSubDetailDesc;
	private long _columnBitmask;
	private VenueSubDetail _escapedModel;
}