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
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.model.CampaignEvent;
import com.rumbasolutions.flask.model.impl.CampaignEventImpl;
import com.rumbasolutions.flask.service.CampaignEventLocalServiceUtil;
import com.rumbasolutions.flask.service.base.CampaignEventServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.AdCampaignFinderUtil;

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
			LOGGER.error("Error in get Campaign's Events :" + e.getMessage());
			e.printStackTrace();
		}
		return campaignEventList;
	}
	
	@Override
	public List<CampaignEvent> getEventCampaigns(long eventId, ServiceContext serviceContext){
		List<CampaignEvent> campaignEventList = new ArrayList<CampaignEvent>();
		try {
			DynamicQuery campaignEventQuery = DynamicQueryFactoryUtil.forClass(CampaignEventImpl.class);
			campaignEventQuery.add(PropertyFactoryUtil.forName("eventId").eq(new Long(eventId)));
			campaignEventList = CampaignEventLocalServiceUtil.dynamicQuery(campaignEventQuery);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			LOGGER.error("Error in get Event's Campaigns :" + e.getMessage());
			e.printStackTrace();
		}
		return campaignEventList;
	}
	
	@Override
	public JSONObject getEventCampaignImages(String eventIdList, ServiceContext serviceContext){
		JSONObject imageJson = JSONFactoryUtil.createJSONObject();
		JSONArray campaignJsonArray = JSONFactoryUtil.createJSONArray();
		List campaignList = new ArrayList();
		JSONArray tempArray = null;
		String serilizeString = null;
		try{
			eventIdList = FlaskUtil.sanitizeIdList(eventIdList);
			campaignList = AdCampaignFinderUtil.getCampaignsForEvents(eventIdList);
			for (Object obj : campaignList) {
				serilizeString = JSONFactoryUtil.serialize(obj);
				tempArray = JSONFactoryUtil.createJSONArray(serilizeString);
				
				JSONObject campJSONObj = JSONFactoryUtil.createJSONObject();
				campJSONObj.put("campaignId", tempArray.getLong(0));
				campJSONObj.put("campaignName", tempArray.getString(1));
				campJSONObj.put("eventName", tempArray.getString(2));
				campJSONObj.put("fullScreenTitle", tempArray.getString(3));
				campJSONObj.put("fullScreenDesc", tempArray.getString(4));
				campJSONObj.put("fullScreenGroupId", tempArray.getLong(5));
				campJSONObj.put("fullScreenUUID", tempArray.getString(6));
				campJSONObj.put("frequencyPerHour", tempArray.getLong(7));
				
				campJSONObj.put("imageTitle", tempArray.getString(8));
				campJSONObj.put("imageDesc", tempArray.getString(9));
				campJSONObj.put("imageGroupId", tempArray.getLong(10));
				campJSONObj.put("imageUUID", tempArray.getString(11));
				campaignJsonArray.put(campJSONObj);
			}
		} catch(Exception e) {
			LOGGER.error("Exception in getAdCampains :" + e.getMessage());
			e.printStackTrace();
		}
		imageJson.put("Images", campaignJsonArray);
		return imageJson;
	}
}