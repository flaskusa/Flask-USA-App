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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.rumbasolutions.flask.model.VenueSubDetail;
import com.rumbasolutions.flask.service.VenueSubDetailLocalServiceUtil;
import com.rumbasolutions.flask.service.VenueSubDetailServiceUtil;
import com.rumbasolutions.flask.service.base.VenueSubDetailServiceBaseImpl;

/**
 * The implementation of the venue sub detail remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.VenueSubDetailService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.base.VenueSubDetailServiceBaseImpl
 * @see com.rumbasolutions.flask.service.VenueSubDetailServiceUtil
 */
public class VenueSubDetailServiceImpl extends VenueSubDetailServiceBaseImpl {

	private static Log LOGGER = LogFactoryUtil.getLog(VenueSubDetailServiceImpl.class);
	
	@Override
	public VenueSubDetail addVenueSubDetail(long venueDetailId, String venueSubDetailTitle, String venueSubDetailDesc){
		VenueSubDetail venueSubDetail = null;
		try {
			venueSubDetail = VenueSubDetailLocalServiceUtil.createVenueSubDetail(CounterLocalServiceUtil.increment(VenueSubDetailServiceImpl.class.getName()));
			venueSubDetail.setVenueDetailId(venueDetailId);
			venueSubDetail.setVenueSubDetailTitle(venueSubDetailTitle);
			venueSubDetail.setVenueSubDetailDesc(venueSubDetailDesc);
			venueSubDetail = VenueSubDetailLocalServiceUtil.addVenueSubDetail(venueSubDetail);
		} catch (Exception e) {
			LOGGER.error("Exception in addVenueSubDetail: "+e.getMessage());
		}
		return venueSubDetail;
	}
	
	@Override
	public List<VenueSubDetail> addVenueSubDetailsByJsonArray(long venueDetailId, String subDetailJson){
		List<VenueSubDetail> venueSubDetails = new ArrayList<VenueSubDetail>();
		try {
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(subDetailJson);
			for(int i=0; i<jsonArray.length(); i++){
				JSONObject jsonObj = jsonArray.getJSONObject(i);
				venueSubDetails.add(VenueSubDetailServiceUtil.addVenueSubDetail(venueDetailId, jsonObj.getString("title"), jsonObj.getString("desc")));
			}
		} catch (Exception e) {
			LOGGER.error("Exception in addVenueSubDetailsByJsonArray: "+e.getMessage());
		}
		return venueSubDetails;
	}
	
	@Override
	public VenueSubDetail updateVenueSubDetail(long venueSubDetailId, long venueDetailId, String venueSubDetailTitle, String venueSubDetailDesc){
		VenueSubDetail venueSubDetail = null;
		try {
			venueSubDetail = VenueSubDetailLocalServiceUtil.getVenueSubDetail(venueSubDetailId);
			venueSubDetail.setVenueDetailId(venueDetailId);
			venueSubDetail.setVenueSubDetailTitle(venueSubDetailTitle);
			venueSubDetail.setVenueSubDetailDesc(venueSubDetailDesc);
			venueSubDetail = VenueSubDetailLocalServiceUtil.updateVenueSubDetail(venueSubDetail);
		} catch (Exception e) {
			LOGGER.error("Exception in updateVenueSubDetail: "+e.getMessage());
		}
		return venueSubDetail;
	}
	
	@Override
	public VenueSubDetail getVenueSubDetailById(long venueSubDetailId){
		VenueSubDetail venueSubDetail = null;
		try {
			venueSubDetail = VenueSubDetailLocalServiceUtil.getVenueSubDetail(venueSubDetailId);
		} catch (Exception e) {
			LOGGER.error("Exception in getVenueSubDetailById: "+e.getMessage());
		}
		return venueSubDetail;
	}
	
	@Override
	public List<VenueSubDetail> getAllVenueSubDetails(){
		List<VenueSubDetail> venueSubDetails = null;
		try {
			venueSubDetails = VenueSubDetailLocalServiceUtil.getVenueSubDetails(0, VenueSubDetailLocalServiceUtil.getVenueSubDetailsCount());
		} catch (Exception e) {
			LOGGER.error("Exception in getAllvenueSubDetails: "+e.getMessage());
		}
		return venueSubDetails;
	}
	
	@Override
	public void deletevenueSubDetailById(long venueSubDetailId){
		try {
			VenueSubDetailLocalServiceUtil.deleteVenueSubDetail(venueSubDetailId);
		} catch (Exception e) {
			LOGGER.error("Exception in deletevenueSubDetailById: "+e.getMessage());
		}
	}
}