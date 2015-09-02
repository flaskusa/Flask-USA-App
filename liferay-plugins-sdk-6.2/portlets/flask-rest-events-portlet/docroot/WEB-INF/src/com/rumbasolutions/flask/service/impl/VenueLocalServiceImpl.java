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

import java.util.List;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.model.Venue;
import com.rumbasolutions.flask.model.VenueDetail;
import com.rumbasolutions.flask.model.VenueDetailImage;
import com.rumbasolutions.flask.model.VenueImage;
import com.rumbasolutions.flask.service.base.VenueLocalServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.VenueDetailImageUtil;
import com.rumbasolutions.flask.service.persistence.VenueDetailUtil;
import com.rumbasolutions.flask.service.persistence.VenueImageUtil;

/**
 * The implementation of the venue local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.VenueLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.base.VenueLocalServiceBaseImpl
 * @see com.rumbasolutions.flask.service.VenueLocalServiceUtil
 */
public class VenueLocalServiceImpl extends VenueLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.VenueLocalServiceUtil} to access the venue local service.
	 */
	private static Log LOGGER = LogFactoryUtil.getLog(VenueLocalServiceImpl.class);
	
	public JSONObject getVenueDetailsWithImages(long venueId){
		List<VenueImage> venueImgList = null;
		List<VenueDetail> venueDetails = null;
		List<VenueDetailImage> detailImgList = null;
		JSONObject venueJsonObj =  JSONFactoryUtil.createJSONObject();
		try{
			Venue venue = getVenue(venueId);
			venue = FlaskUtil.setVenueStringValues(venue);
			venueJsonObj.put("VenueInfo", JSONFactoryUtil.looseSerialize(venue));
			venueImgList = VenueImageUtil.findByvenueId(venueId);
			//Add venue image information
			JSONArray venueImageArr =  JSONFactoryUtil.createJSONArray();
			venueJsonObj.put("VenueImages", venueImageArr);
			for (VenueImage venueImage : venueImgList) {
				JSONObject venueImageObj =  JSONFactoryUtil.createJSONObject();
				venueImageObj.put("VenueImage", JSONFactoryUtil.looseSerialize(venueImage));
				venueImageArr.put(venueImageObj);
			}
			//Add venue detail information
			JSONArray venueDetailArr =  JSONFactoryUtil.createJSONArray();
			venueJsonObj.put("VenueDetails", venueDetailArr);
			venueDetails = VenueDetailUtil.findByVenueId(venueId);
			for (VenueDetail venueDetail : venueDetails) {
				JSONObject venueDetailJsonObj =  JSONFactoryUtil.createJSONObject();
				venueDetail = FlaskUtil.setNamesForVenueDetail(venueDetail);
				venueDetailJsonObj.put("VenueDetail", JSONFactoryUtil.looseSerialize(venueDetail));
				venueDetailArr.put(venueDetailJsonObj);
				detailImgList = VenueDetailImageUtil.findByVenueDetailId(venueDetail.getVenueDetailId());
				JSONArray venueDetailImageArr =  JSONFactoryUtil.createJSONArray();
				venueDetailJsonObj.put("VenueDetailImages", venueDetailImageArr);
				for (VenueDetailImage detailImage : detailImgList) {
					JSONObject venueDetailImageObj =  JSONFactoryUtil.createJSONObject();
					venueDetailImageObj.put("VenueDetailImage", JSONFactoryUtil.looseSerialize(detailImage));
					venueDetailImageArr.put(venueDetailImageObj);
				}
			}			
		}catch(Exception ex){
			
			LOGGER.error("Exception in getting venue information " + ex.getMessage());
		}
		

		return venueJsonObj;
	}

}