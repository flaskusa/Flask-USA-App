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
import com.rumbasolutions.flask.model.EventSubDetail;
import com.rumbasolutions.flask.model.VenueSubDetail;
import com.rumbasolutions.flask.service.EventSubDetailLocalServiceUtil;
import com.rumbasolutions.flask.service.EventSubDetailServiceUtil;
import com.rumbasolutions.flask.service.base.EventSubDetailServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.EventSubDetailUtil;
import com.rumbasolutions.flask.service.persistence.VenueSubDetailUtil;

/**
 * The implementation of the event sub detail remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.EventSubDetailService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.base.EventSubDetailServiceBaseImpl
 * @see com.rumbasolutions.flask.service.EventSubDetailServiceUtil
 */
public class EventSubDetailServiceImpl extends EventSubDetailServiceBaseImpl {
	
	private static Log LOGGER = LogFactoryUtil.getLog(EventSubDetailServiceImpl.class);
	
	@Override
	public EventSubDetail addEventSubDetail(long eventDetailId, String eventSubDetailTitle, String eventSubDetailDesc){
		EventSubDetail eventSubDetail = null;
		try {
			eventSubDetail = EventSubDetailLocalServiceUtil.createEventSubDetail(CounterLocalServiceUtil.increment(EventSubDetailServiceImpl.class.getName()));
			eventSubDetail.setEventDetailId(eventDetailId);
			eventSubDetail.setEventSubDetailTitle(eventSubDetailTitle);
			eventSubDetail.setEventSubDetailDesc(eventSubDetailDesc);
			eventSubDetail = EventSubDetailLocalServiceUtil.addEventSubDetail(eventSubDetail);
		} catch (Exception e) {
			LOGGER.error("Exception in addEventSubDetail: "+e.getMessage());
		}
		return eventSubDetail;
	}
	
	@Override
	public List<EventSubDetail> addEventSubDetailsByJsonArray(long eventDetailId, String subDetailJson){
		List<EventSubDetail> eventSubDetails = new ArrayList<EventSubDetail>();
		try {
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(subDetailJson);
			for(int i=0; i<jsonArray.length(); i++){
				JSONObject jsonObj = jsonArray.getJSONObject(i);
				eventSubDetails.add(EventSubDetailServiceUtil.addEventSubDetail(eventDetailId, jsonObj.getString("title"), jsonObj.getString("desc")));
			}
		} catch (Exception e) {
			LOGGER.error("Exception in addEventSubDetailsByJsonArray: "+e.getMessage());
		}
		return eventSubDetails;
	}
	
	@Override
	public EventSubDetail updateEventSubDetail(long eventSubDetailId, long eventDetailId, String eventSubDetailTitle, String eventSubDetailDesc){
		EventSubDetail eventSubDetail = null;
		try {
			eventSubDetail = EventSubDetailLocalServiceUtil.getEventSubDetail(eventSubDetailId);
			eventSubDetail.setEventDetailId(eventDetailId);
			eventSubDetail.setEventSubDetailTitle(eventSubDetailTitle);
			eventSubDetail.setEventSubDetailDesc(eventSubDetailDesc);
			eventSubDetail = EventSubDetailLocalServiceUtil.updateEventSubDetail(eventSubDetail);
		} catch (Exception e) {
			LOGGER.error("Exception in updateEventSubDetail: "+e.getMessage());
		}
		return eventSubDetail;
	}
	
	@Override
	public EventSubDetail getEventSubDetailById(long eventSubDetailId){
		EventSubDetail eventSubDetail = null;
		try {
			eventSubDetail = EventSubDetailLocalServiceUtil.getEventSubDetail(eventSubDetailId);
		} catch (Exception e) {
			LOGGER.error("Exception in getEventSubDetailById: "+e.getMessage());
		}
		return eventSubDetail;
	}
	
	@Override
	public List<EventSubDetail> getEventSubDetailByEventDetailId(long eventDetailId){
		List<EventSubDetail> eventSubDetail = null;
		try {
			eventSubDetail = EventSubDetailUtil.findByEventDetailId(eventDetailId);
		} catch (Exception e){
			LOGGER.error("Exception in getEventSubDetailByEventDetailId: "+e.getMessage());
		}
		return eventSubDetail;
	}
	
	@Override
	public List<EventSubDetail> getAllEventSubDetails(){
		List<EventSubDetail> eventSubDetails = null;
		try {
			eventSubDetails = EventSubDetailLocalServiceUtil.getEventSubDetails(0, EventSubDetailLocalServiceUtil.getEventSubDetailsCount());
		} catch (Exception e) {
			LOGGER.error("Exception in getAllEventSubDetails: "+e.getMessage());
		}
		return eventSubDetails;
	}
	
	@Override
	public void deleteEventSubDetailById(long eventSubDetailId){
		try {
			EventSubDetailLocalServiceUtil.deleteEventSubDetail(eventSubDetailId);
		} catch (Exception e) {
			LOGGER.error("Exception in deleteEventSubDetailById: "+e.getMessage());
		}
	}
}