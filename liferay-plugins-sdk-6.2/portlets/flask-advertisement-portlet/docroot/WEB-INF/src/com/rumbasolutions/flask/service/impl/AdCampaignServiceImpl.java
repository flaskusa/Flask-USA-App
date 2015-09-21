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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.model.AdCampaign;
import com.rumbasolutions.flask.model.CampaignEvent;
import com.rumbasolutions.flask.model.CampaignImage;
import com.rumbasolutions.flask.service.AdCampaignLocalServiceUtil;
import com.rumbasolutions.flask.service.AdCustomerServiceUtil;
import com.rumbasolutions.flask.service.CampaignEventLocalServiceUtil;
import com.rumbasolutions.flask.service.CampaignImageLocalServiceUtil;
import com.rumbasolutions.flask.service.base.AdCampaignServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.AdCampaignFinderUtil;
import com.rumbasolutions.flask.service.persistence.AdCampaignUtil;
import com.rumbasolutions.flask.service.persistence.CampaignEventUtil;
import com.rumbasolutions.flask.service.persistence.CampaignImageUtil;

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
		List campaignList = new ArrayList();
		JSONArray tempArray = null;
		String serilizeString = null;
		try{
			campaignList = AdCampaignFinderUtil.getAdCampaginList();
			for (Object obj : campaignList) {
				serilizeString = JSONFactoryUtil.serialize(obj);
				tempArray = JSONFactoryUtil.createJSONArray(serilizeString);
				
				JSONObject campJSONObj = JSONFactoryUtil.createJSONObject();
				campJSONObj.put("campaignId", tempArray.getString(0));
				campJSONObj.put("campaignName", tempArray.getString(1));
				campJSONObj.put("customerId", tempArray.getString(2));
				campJSONObj.put("customerName", tempArray.getString(3));
				campJSONObj.put("displayGeneral", tempArray.getString(4));
				campJSONObj.put("displayPreEvent", tempArray.getString(5));
				campJSONObj.put("displayDuringEvent", tempArray.getString(6));
				campJSONObj.put("displayPostEvent", tempArray.getString(7));
				campJSONObj.put("eventTypeId", tempArray.getString(8));
				campJSONObj.put("frequencyPerHour", tempArray.getString(9));
				campJSONObj.put("adDisplayTime", tempArray.getString(10));
				campaignJsonArray.put(campJSONObj);
			}
		} catch(Exception e) {
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
			  boolean displayPostEvent, long frequencyPerHour, long eventTypeId, String events, ServiceContext serviceContext) {
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
			adCampaign.setEventTypeId(eventTypeId);
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
			CampaignEventUtil.removeBycampaignId(campaignId);
			CampaignImageUtil.removeBycampaignId(campaignId);
			
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
				if(!campaignId.isEmpty() ){
					deleteCampaign(Long.parseLong(campaignId));
				}
			} catch (Exception e) {
				LOGGER.error("Error in deleting Campaign:" + campaignId + " Exception:" + e.getMessage());
			}
		}
	}
	
	@Override
	public CampaignImage addCampaignImage(long campaignId, String imageTitle,
			String imageDesc, String imageUUID, long imageGroupId, ServiceContext  serviceContext){
		CampaignImage campaignImage = null;
		try{
			
			campaignImage = CampaignImageLocalServiceUtil.createCampaignImage(CounterLocalServiceUtil.increment());
			campaignImage.setCampaignId(campaignId);
			campaignImage.setImageTitle(imageTitle);
			campaignImage.setImageDesc(imageDesc);
			campaignImage.setImageUUID(imageUUID);
			campaignImage.setImageGroupId(imageGroupId);
			
			Date now = new Date();
			campaignImage.setUserId(serviceContext.getUserId());
			campaignImage.setCreatedDate(serviceContext.getCreateDate(now));
			campaignImage.setModifiedDate(serviceContext.getModifiedDate(now));
			
			CampaignImageLocalServiceUtil.addCampaignImage(campaignImage);
			
		} catch(Exception e){
			LOGGER.error(e);
		}
		return campaignImage;
	}
	
	@Override
	public CampaignImage updateCampaignImage(long campaignImageId, String imageTitle,
			String imageDesc, String imageUUID, long imageGroupId, ServiceContext  serviceContext){
		CampaignImage campaignImage = null;
		try{
			campaignImage = CampaignImageLocalServiceUtil.getCampaignImage(campaignImageId);
			campaignImage.setImageTitle(imageTitle);
			campaignImage.setImageDesc(imageDesc);
			campaignImage.setImageUUID(imageUUID);
			campaignImage.setImageGroupId(imageGroupId);
			
			Date now = new Date();
			campaignImage.setUserId(serviceContext.getUserId());
			campaignImage.setModifiedDate(serviceContext.getModifiedDate(now));
			
			CampaignImageLocalServiceUtil.updateCampaignImage(campaignImage);
		}catch(Exception e){
			LOGGER.error(e);
		}
		return campaignImage;
	}

	@Override
	public CampaignImage getCampaignImage(long campaignImageId, ServiceContext serviceContext){
		CampaignImage campaignImage = null;
		try{
			campaignImage = CampaignImageUtil.fetchByPrimaryKey(campaignImageId);
		}catch(Exception e){
			LOGGER.error(e);
		}
		return campaignImage;
	}
	
	@Override
	public List<CampaignImage> getCampaignImages(long campaignId, ServiceContext serviceContext){
		List<CampaignImage> campaignImages = null;
		try{
			campaignImages = CampaignImageUtil.findBycampaignId(campaignId);
		}catch(Exception e){
			LOGGER.error(e);
		}
		return campaignImages;
	}
	
	@Override
	public void deleteCampaignImage(long campaignImageId, ServiceContext serviceContext){
		try{
			CampaignImageLocalServiceUtil.deleteCampaignImage(campaignImageId);
		}catch(Exception e){
			LOGGER.error(e);
		}
	}

	@AccessControlled(guestAccessEnabled =true)
	@Override
	public JSONObject getCampaignWithImages(long campaignId, ServiceContext serviceContext){
		List<CampaignImage> campaignImageList = null;
		JSONObject campaignJsonObj = JSONFactoryUtil.createJSONObject();
		try{
			AdCampaign adCampaign = getCampaign(campaignId);
			campaignJsonObj.put("AdCampaign", JSONFactoryUtil.looseSerialize(adCampaign));
			campaignImageList = getCampaignImages(campaignId, serviceContext);
			JSONArray campaignImageArr = JSONFactoryUtil.createJSONArray();
			campaignJsonObj.put("campaignImages", campaignImageArr);
			for(CampaignImage campaignImage : campaignImageList){
				JSONObject campaignImageObj = JSONFactoryUtil.createJSONObject();
				campaignImageObj.put("campaignImage", JSONFactoryUtil.looseSerialize(campaignImage));
				campaignImageArr.put(campaignImageObj);
			}
		}catch(Exception e){
			LOGGER.error("Exception in getCampaignWithImages. Exception: " +  e.getMessage());
			return null;
		}
		return campaignJsonObj;
	}
	
}