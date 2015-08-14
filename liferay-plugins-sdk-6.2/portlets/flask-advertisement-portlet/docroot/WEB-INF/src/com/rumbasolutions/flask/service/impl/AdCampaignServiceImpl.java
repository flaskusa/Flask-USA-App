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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.model.AdCampaign;
import com.rumbasolutions.flask.model.CampaignEvent;
import com.rumbasolutions.flask.service.AdCampaignLocalServiceUtil;
import com.rumbasolutions.flask.service.AdCustomerServiceUtil;
import com.rumbasolutions.flask.service.CampaignEventLocalServiceUtil;
import com.rumbasolutions.flask.service.base.AdCampaignServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.AdCampaignFinderUtil;
import com.rumbasolutions.flask.service.persistence.AdCampaignUtil;
import com.rumbasolutions.flask.service.persistence.CampaignEventUtil;

/**
 * The implementation of the ad campaign remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.AdCampaignService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @see com.rumbasolutions.flask.service.base.AdCampaignServiceBaseImpl
 * @see com.rumbasolutions.flask.service.AdCampaignServiceUtil
 */
public class AdCampaignServiceImpl extends AdCampaignServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.AdCampaignServiceUtil} to access the ad campaign remote service.
	 */
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link flask.manage.advertisement.service.AdCampaignServiceUtil} to access the ad campaign remote service.
	 */
	private static Log LOGGER = LogFactoryUtil.getLog(AdCampaignServiceImpl.class);
	
	@Override
	public JSONArray getAllCampaign() {
		JSONArray campaignJsonArray = JSONFactoryUtil.createJSONArray();
		List<AdCampaign> campaignList = new ArrayList<AdCampaign>();
		try{
			campaignList = AdCampaignUtil.findAll();
			for (int i=0; i<campaignList.size(); i++) {
				AdCampaign campaign = campaignList.get(i);
				String customerName = AdCustomerServiceUtil.getCustomer(campaign.getCustomerId()).getCustomerName();
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put("campaignId", campaign.getCampaignId());
				obj.put("campaignName", campaign.getCampaignName());
				obj.put("customerId", campaign.getCustomerId());
				obj.put("customerName", customerName);
				obj.put("eventTypeId", campaign.getEventTypeId());
				//obj.put("eventTypeName", campaign.getE);
				//obj.put("adDisplayTime", campaignFieldArr.getString(6));
				obj.put("frequencyPerHour", campaign.getFrequencyPerHour());
				campaignJsonArray.put(obj);
			}
			
		} catch(SystemException e) {
			LOGGER.error("Exception in getAdCampains :" + e.getMessage());
			e.printStackTrace();
		}
		
		return campaignJsonArray;
	}
	/*
	 * Utility method
	 */
	private JSONArray createCustomModelCampaignList(List list){
		JSONArray campaignJsonArray = JSONFactoryUtil.createJSONArray();
		String serilizeString ="";
		JSONArray campaignFieldArr=null;
		
		try{
		for (Object ob : list) {
			
			serilizeString = JSONFactoryUtil.serialize(ob);
			campaignFieldArr = JSONFactoryUtil.createJSONArray(serilizeString);
			
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			obj.put("campaignId", campaignFieldArr.getString(0));
			obj.put("campaignName", campaignFieldArr.getString(1));
			obj.put("customerId", campaignFieldArr.getString(2));
			obj.put("customerName", campaignFieldArr.getString(3));
			obj.put("eventTypeId", campaignFieldArr.getString(4));
			obj.put("eventTypeName", campaignFieldArr.getString(5));
			obj.put("adDisplayTime", campaignFieldArr.getString(6));
			obj.put("frequencyPerHour", campaignFieldArr.getString(7));
			campaignJsonArray.put(obj);
			
		}
		}catch(JSONException e){
			LOGGER.error("Exception in createCustomModelList for searchEvent "
					+ e.getMessage());
		}
		return campaignJsonArray;
	}

	@Override
	public AdCampaign getCampaign(long campaignId) {
		AdCampaign campaign = null;
		try {
			campaign = AdCampaignUtil.fetchByPrimaryKey(campaignId);
		} catch (SystemException e) {
			LOGGER.error("Exception in getAdcampaign :" + e.getMessage());
			e.printStackTrace();
		}
		return campaign;
	}
	@Override
	public AdCampaign addCampaign(String campaignName, long customerId,
			  boolean displayGeneral, boolean displayPreEvent, boolean displayDuringEvent,
			  boolean displayPostEvent, long frequencyPerHour, String events, ServiceContext serviceContext) {
		AdCampaign adCampaign = null;
		try {
			adCampaign = AdCampaignLocalServiceUtil
					.createAdCampaign(CounterLocalServiceUtil.increment());
			Date date = new Date();
			adCampaign.setCampaignName(campaignName);
			adCampaign.setCustomerId(customerId);
			adCampaign.setDisplayGeneral(displayGeneral);
			adCampaign.setDisplayPreEvent(displayPreEvent);
			adCampaign.setDisplayDuringEvent(displayDuringEvent);
			adCampaign.setDisplayPostEvent(displayPostEvent);
			adCampaign.setFrequencyPerHour(frequencyPerHour);
			adCampaign.setCreatedDate(date);
			adCampaign.setModifiedDate(date);
			adCampaign.setUserId(serviceContext.getUserId());
			adCampaign = AdCampaignLocalServiceUtil.addAdCampaign(adCampaign);
			addEvents(events, serviceContext, adCampaign, date);
		} catch (SystemException e) {
			LOGGER.error(" Exception in Add Campaign :" + e.getMessage());
			e.printStackTrace();
		}
		return adCampaign;
	}

	private void addEvents(String events, ServiceContext serviceContext,
			AdCampaign adCampaign, Date date) throws SystemException {
		if(events.length() > 0){
			String[] eventArr = events.split(",");
			for(int i = 0; i < eventArr.length; i++){
				String event=eventArr[i].trim();
				if(event.length() == 0) continue;
				long eventId  = Long.parseLong(event);
				CampaignEvent ev = CampaignEventLocalServiceUtil.createCampaignEvent(CounterLocalServiceUtil.increment());
				ev.setCampaignId(adCampaign.getCampaignId());
				ev.setEventId(eventId);
				ev.setCreatedDate(date);
				ev.setModifiedDate(date);
				ev.setUserId(serviceContext.getUserId());
				CampaignEventLocalServiceUtil.addCampaignEvent(ev);
			}
		}
	}

	@Override
	public AdCampaign updateCampaign(long campaignId,String campaignName, long customerId,
			  boolean displayGeneral, boolean displayPreEvent, boolean displayDuringEvent,
			  boolean displayPostEvent, long frequencyPerHour, String events, ServiceContext serviceContext) {
		AdCampaign adCampaign = null;
		try {
			adCampaign = AdCampaignLocalServiceUtil.getAdCampaign(campaignId);
			Date date = new Date();
			adCampaign.setCampaignName(campaignName);
			adCampaign.setCustomerId(customerId);
			adCampaign.setDisplayGeneral(displayGeneral);
			adCampaign.setDisplayPreEvent(displayPreEvent);
			adCampaign.setDisplayDuringEvent(displayDuringEvent);
			adCampaign.setDisplayPostEvent(displayPostEvent);
			adCampaign.setFrequencyPerHour(frequencyPerHour);
			adCampaign.setModifiedDate(date);
			adCampaign.setUserId(serviceContext.getUserId());
			adCampaign = AdCampaignLocalServiceUtil.updateAdCampaign(adCampaign);
			
	
			addEvents(events, serviceContext, adCampaign, date);

		} catch (PortalException e) {
			LOGGER.error(" Exception in Update Campaign :" + e.getMessage());
			e.printStackTrace();
		} catch (SystemException e) {
			LOGGER.error(" Exception in Update Campaign :" + e.getMessage());
			e.printStackTrace();
		}
		return adCampaign;
	}

	@Override
	public void deleteCampaign(long campaignId) {
		try {
			AdCampaignLocalServiceUtil.deleteAdCampaign(campaignId);
		} catch (PortalException e) {
			LOGGER.error("Exception in Delete Campaign : " + e.getMessage());
			e.printStackTrace();
		} catch (SystemException e) {
			LOGGER.error("Exception in Delete Campaign : " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCampaigns(String campaignList) {

		String[] campaignArray = campaignList.split(",");
		for (String campaignId : campaignArray) {
			try {
				AdCampaignLocalServiceUtil.deleteAdCampaign(Long.parseLong(campaignId));
			} catch (PortalException e) {
				LOGGER.error("Error in deleting Campaign:" + campaignId);
			} catch (SystemException e) {
				LOGGER.error("Error in deleting Campaign:" + campaignId);
			}
		}
	}
	
	
}