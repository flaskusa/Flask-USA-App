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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.model.CampaignEvent;
import com.rumbasolutions.flask.model.impl.CampaignEventImpl;
import com.rumbasolutions.flask.service.CampaignEventLocalServiceUtil;
import com.rumbasolutions.flask.service.base.CampaignEventServiceBaseImpl;

/**
 * The implementation of the campaign event remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.CampaignEventService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.base.CampaignEventServiceBaseImpl
 * @see com.rumbasolutions.flask.service.CampaignEventServiceUtil
 */
public class CampaignEventServiceImpl extends CampaignEventServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.CampaignEventServiceUtil} to access the campaign event remote service.
	 */
	
	private static Log LOGGER = LogFactoryUtil.getLog(CampaignEventServiceImpl.class);
	
	@Override
	public List<CampaignEvent> getCampaignEvents(long campaignId, ServiceContext serviceContext){
		List<CampaignEvent> campaignEventList = new ArrayList<CampaignEvent>();
		try {
			DynamicQuery campaignEventQuery = DynamicQueryFactoryUtil.forClass(CampaignEventImpl.class);
			campaignEventQuery.add(PropertyFactoryUtil.forName("campaignId").eq(new Long(campaignId)));
			campaignEventList = CampaignEventLocalServiceUtil.dynamicQuery(campaignEventQuery);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error in get Event Cache :" + e.getMessage());
			e.printStackTrace();
		}
		return campaignEventList;
	}
}