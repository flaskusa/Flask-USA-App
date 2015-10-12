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
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.liferay.portal.security.ac.AccessControlled;
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
	private static int  IMAGE_DURATION = 4; // 4 seconds 
	private static int MAX_IMAGES_PER_HOUR =  60*60/IMAGE_DURATION;  /* 4 second each image mean 15 per minute*/
	
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
	
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public JSONObject getEventCampaignImages(String eventIdList, ServiceContext serviceContext){
		JSONObject imageJson = JSONFactoryUtil.createJSONObject();
		JSONArray uniqueImageArray = JSONFactoryUtil.createJSONArray();
		JSONArray imageUUIDForDisplay= JSONFactoryUtil.createJSONArray();
		
		List campaignList = new ArrayList();
		JSONArray tempArray = null;
		String serilizeString = null;
		HashMap<Integer, Integer> campaignFrequencyMap = new HashMap<Integer, Integer>();
		
		HashMap<Integer, JSONArray> campaignImageMap = new HashMap<Integer, JSONArray>();
		HashMap<Integer, Integer> campaignLastUsedImage = new HashMap<Integer, Integer>();

		
		HashMap<Integer, JSONObject> imageMap = new HashMap<Integer, JSONObject>();
		
		try{
			eventIdList = FlaskUtil.sanitizeIdList(eventIdList);
			campaignList = AdCampaignFinderUtil.getCampaignDetailsForEvents(eventIdList);
			for (Object obj : campaignList) {
				serilizeString = JSONFactoryUtil.serialize(obj);
				tempArray = JSONFactoryUtil.createJSONArray(serilizeString);
				
				Integer campaignId = tempArray.getInt(0);
				Integer frequencyPerHour = tempArray.getInt(6);
				
				JSONArray arr = campaignImageMap.get(campaignId);
				JSONObject imgJson = getImageJson(tempArray);
				uniqueImageArray.put(imgJson);
				if(arr == null){
					arr = JSONFactoryUtil.createJSONArray();
					arr.put(imgJson);
				}else{
					arr.put(imgJson);
				}
				campaignImageMap.put(campaignId, arr);
					
				campaignFrequencyMap.put(campaignId, frequencyPerHour);
				
			}
			campaignFrequencyMap = setCampaignWeight(campaignFrequencyMap);			
			LinkedHashMap<Integer, Integer> sortedByFrequencyMap = (LinkedHashMap<Integer, Integer>) FlaskUtil.sortByValue(campaignFrequencyMap);
			boolean processedAll = false;
			int maxLoopIndex = 0;
			String imageUUID ="";
			JSONObject img;
			int keysWithZeroValue = 0;
			while (processedAll == false){
				for(Integer key: sortedByFrequencyMap.keySet()){
					maxLoopIndex++;
					Integer weightedFrequency = sortedByFrequencyMap.get(key);
					if(weightedFrequency == 0){   //It has used all of the weighted frequency
						
						if(maxLoopIndex >= MAX_IMAGES_PER_HOUR ){ //all processed
							processedAll = true;
							break;
						}
						continue;						
					}else{
						weightedFrequency  -= 1;
					}
					sortedByFrequencyMap.put(key, weightedFrequency);
					
					JSONArray imgArrayForCampaign = campaignImageMap.get(key);
					int imageIndex = 0;
					int maxIndex = imgArrayForCampaign.length() - 1;
					if(imgArrayForCampaign.length() > 1){
						Integer lastUsedIndex = campaignLastUsedImage.get(key);
						if(lastUsedIndex == null){
							campaignLastUsedImage.put(key, 0);
						}					
						if( lastUsedIndex < maxIndex){  //Use next image if available else used first image
							imageIndex = lastUsedIndex + 1;
						}
					}
					img = imgArrayForCampaign.getJSONObject(imageIndex);
					imageUUID = img.getString("imageUUID");
					imageUUIDForDisplay.put(imageUUID);
					
				}

			}

		} catch(Exception e) {
			LOGGER.error("Exception in getEventCampaignImages :" + e.getMessage());
			e.printStackTrace();
		}
		imageJson.put("Images", uniqueImageArray);
		imageJson.put("DisplayOrder", imageUUIDForDisplay);
		return imageJson;
	}

	private HashMap<Integer, Integer> setCampaignWeight(HashMap<Integer, Integer> campaignMap){
		HashMap<Integer, Integer> weightedMap = new HashMap<Integer, Integer>(campaignMap.size());
		int total = getSumOfFrequency(campaignMap);
		float weight = 1;
		if(total !=0){
			weight = (float)MAX_IMAGES_PER_HOUR/ total;
		}
		for(Integer key: campaignMap.keySet()){
			Integer frequencyPerHour = campaignMap.get(key);
			frequencyPerHour = (int) (frequencyPerHour * weight);
			weightedMap.put(key, frequencyPerHour);
		}
		return weightedMap;
	}

	private int getSumOfFrequency(HashMap<Integer, Integer> campaignMap) {
		int total = 0;
		for (int impr: campaignMap.values()){
			total +=  impr;
		}
		return total;
	}
	
	private JSONObject getImageJson(JSONArray tempArray) {
		JSONObject campJSONObj = JSONFactoryUtil.createJSONObject();
		campJSONObj.put("campaignId", tempArray.getLong(0));
		campJSONObj.put("campaignName", tempArray.getString(1));
		campJSONObj.put("fullScreenTitle", tempArray.getString(2));
		campJSONObj.put("fullScreenDesc", tempArray.getString(3));
		campJSONObj.put("fullScreenGroupId", tempArray.getLong(4));
		campJSONObj.put("fullScreenUUID", tempArray.getString(5));
		campJSONObj.put("frequencyPerHour", tempArray.getLong(6));
		
		campJSONObj.put("imageTitle", tempArray.getString(7));
		campJSONObj.put("imageDesc", tempArray.getString(8));
		campJSONObj.put("imageGroupId", tempArray.getLong(9));
		campJSONObj.put("imageUUID", tempArray.getString(10));
		
		campJSONObj.put("customerName", tempArray.getString(11));
		campJSONObj.put("addrLine1", tempArray.getString(12));
		campJSONObj.put("addrLine2", tempArray.getString(13));
		campJSONObj.put("city", tempArray.getString(14));
		campJSONObj.put("State", tempArray.getString(15));
		campJSONObj.put("zipCode", tempArray.getString(16));
		campJSONObj.put("email", tempArray.getString(17));
		campJSONObj.put("url", tempArray.getString(18));
		campJSONObj.put("phone", tempArray.getString(19));
		return campJSONObj;
	}
}