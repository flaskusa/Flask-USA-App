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

package com.rumbasolutions.flask.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.model.InfoTypeCategory;
import com.rumbasolutions.flask.service.base.InfoTypeCategoryServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.InfoTypeCategoryUtil;

/**
 * The implementation of the info type category remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.InfoTypeCategoryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.base.InfoTypeCategoryServiceBaseImpl
 * @see com.rumbasolutions.flask.service.InfoTypeCategoryServiceUtil
 */
public class InfoTypeCategoryServiceImpl extends InfoTypeCategoryServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.InfoTypeCategoryServiceUtil} to access the info type category remote service.
	 */
	
	private static Log LOGGER = LogFactoryUtil.getLog(InfoTypeCategoryServiceImpl.class);
	
	@Override
	public List<InfoTypeCategory> getInfoTypeCategories(ServiceContext  serviceContext){
		List<InfoTypeCategory> infoTypeCategorys= new ArrayList<InfoTypeCategory>();
		try {
			infoTypeCategorys  = InfoTypeCategoryUtil.findAll();
		}
		catch (SystemException e) {
			LOGGER.error("Exception in getInfoTypeCategorys. " + e.getMessage());
		}
		return infoTypeCategorys;
	}
	
	@Override
	public InfoTypeCategory getInfoTypeCategory(long InfoTypeCategoryId, ServiceContext  serviceContext){
		InfoTypeCategory infoTypeCategory= null;
		try {
			infoTypeCategory  = InfoTypeCategoryUtil.fetchByPrimaryKey(InfoTypeCategoryId);
		}
		catch (SystemException e) {
			LOGGER.error("Exception in getInfoTypeCategory. " + e.getMessage());
		}
		return infoTypeCategory;
	}
}