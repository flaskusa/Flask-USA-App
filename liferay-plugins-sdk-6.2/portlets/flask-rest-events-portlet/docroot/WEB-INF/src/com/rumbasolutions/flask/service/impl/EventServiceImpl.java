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
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.rumbasolutions.flask.model.Event;
import com.rumbasolutions.flask.model.EventDetail;
import com.rumbasolutions.flask.model.EventDetailImage;
import com.rumbasolutions.flask.service.EventDetailImageLocalServiceUtil;
import com.rumbasolutions.flask.service.EventDetailLocalServiceUtil;
import com.rumbasolutions.flask.service.EventLocalServiceUtil;
import com.rumbasolutions.flask.service.base.EventServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.EventDetailImageUtil;
import com.rumbasolutions.flask.service.persistence.EventDetailUtil;
import com.rumbasolutions.flask.service.persistence.EventUtil;

/**
 * The implementation of the event remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.EventService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.base.EventServiceBaseImpl
 * @see com.rumbasolutions.flask.service.EventServiceUtil
 */
public class EventServiceImpl extends EventServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.EventServiceUtil} to access the event remote service.
	 */
	
	private static Log LOGGER = LogFactoryUtil.getLog(EventServiceImpl.class);
	
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public List<Event> getAllEvents(ServiceContext  serviceContext){
		List<Event> events= new ArrayList<Event>();
		try {
			events =  EventUtil.findAll();
			events = FlaskUtil.setStringNamesForEvents(events);
		}
		catch (Exception e) {
			LOGGER.error("Exception in getAllEvents. " + e.getMessage());
			e.printStackTrace();
		}
		return events;
	}
	
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public Event getEvent(long eventId, ServiceContext  serviceContext){
		Event event= null;
		try {
			event =  EventUtil.fetchByPrimaryKey(eventId);
			event = FlaskUtil.setStringNamesForEvent(event);
		} catch (SystemException e) {
			LOGGER.error("Error in get event:" + e.getMessage());
		}
		
		return event;
	}
	

	
	@Override
	public Event addEvent(String eventName, String description, 
						String eventDate, Date startTime, Date endTime,
						long eventTypeId, long venueId, String eventImageUUID,
								ServiceContext  serviceContext){
		Event event=null;
		try{
			
			event = EventLocalServiceUtil.createEvent(CounterLocalServiceUtil.increment());
			event.setEventName(eventName);
			event.setDescription(description);
			event.setEventDate(FlaskUtil.parseDate(eventDate).getTime());
			event.setStartTime(startTime);
			event.setEndTime(endTime);
			event.setEventTypeId(eventTypeId);
			event.setVenueId(venueId);
			event.setEventImageUUID(eventImageUUID);
			event.setEventImageGroupId(FlaskUtil.getFlaskRepositoryId());

			Date now = new Date();
			event.setCompanyId(serviceContext.getCompanyId());
		    event.setUserId(serviceContext.getGuestOrUserId());
		    event.setCreatedDate(serviceContext.getCreateDate(now));
		    event.setModifiedDate(serviceContext.getModifiedDate(now));
		    
			EventLocalServiceUtil.addEvent(event);

			
		}catch(Exception ex){
			LOGGER.error("Exception in addEvent: " + ex.getMessage());
		}
		return event;
	}
	
	@Override
	public Event updateEvent(long eventId, String eventName, String description, 
						String eventDate, Date startTime, Date endTime,
						long eventTypeId, long venueId, String eventImageUUID,
								ServiceContext  serviceContext){
		Event event=null;
		try{
			event = EventLocalServiceUtil.getEvent(eventId);
			event.setEventName(eventName);
			event.setDescription(description);
			event.setEventDate(FlaskUtil.parseDate(eventDate).getTime());
			event.setStartTime(startTime);
			event.setEndTime(endTime);
			
			Date now = new Date();
		    event.setUserId(serviceContext.getGuestOrUserId());
		    event.setModifiedDate(serviceContext.getModifiedDate(now));

		    event.setEventTypeId(eventTypeId);
			event.setVenueId(venueId);
			event.setEventImageUUID(eventImageUUID);
			event.setEventImageGroupId(FlaskUtil.getFlaskRepositoryId());
			
			EventLocalServiceUtil.updateEvent(event);
		}catch(Exception ex){
			LOGGER.error("Exception in addEvent: " + ex.getMessage());
		}
		return event;
	}
	
	@Override
	public void deleteEvent(long eventId, ServiceContext  serviceContext){
		try{
			EventLocalServiceUtil.deleteEvent(eventId);
		}catch(Exception ex){
			LOGGER.error("Exception in deleteEvent: " + ex.getMessage());
		}
	}
	
	@Override
	public void deleteEvents(String eventIds, ServiceContext  serviceContext){
		try{
			String[] eventArr = eventIds.split(",");
			for (String eventId : eventArr){
				eventId = eventId.replace(",","").trim();
				EventLocalServiceUtil.deleteEvent(Long.parseLong(eventId));
			}
			
		}catch(Exception ex){
			LOGGER.error("Exception in deleteEvents: " + ex.getMessage());
		}
	}
	
	@Override
	public EventDetail addEventDetail(long eventId , long infoTypeId, long infoTypeCategoryId, 
		String infoTitle, String infoDesc, String addrLine1, String addrLine2, String zipCode,
		String city, long stateId, long countryId, String lattitude, String longitude, 
		String phone, String website, Double cost, 
		String hoursOfOperation,
		ServiceContext  serviceContext){
		EventDetail eventDetail=null;
		try{
			eventDetail= EventDetailLocalServiceUtil.createEventDetail(CounterLocalServiceUtil.increment());
			eventDetail.setEventId(eventId);
			eventDetail.setInfoTypeId(infoTypeId);
			eventDetail.setInfoTypeCategoryId(infoTypeCategoryId);
			eventDetail.setInfoTitle(infoTitle);
			eventDetail.setInfoDesc(infoDesc);
			eventDetail.setAddrLine1(addrLine1);
			eventDetail.setAddrLine2(addrLine2);
			eventDetail.setZipCode(zipCode);
			eventDetail.setCity(city);
			eventDetail.setStateId(stateId);
			eventDetail.setCountryId(countryId);
			eventDetail.setLatitude(lattitude);
			eventDetail.setLongitude(longitude);
			eventDetail.setPhone(phone);
			eventDetail.setWebsite(website);
			eventDetail.setCost(cost);
			eventDetail.setHoursOfOperation(hoursOfOperation);
			
			Date now = new Date();
			eventDetail.setCompanyId(serviceContext.getCompanyId());
		    eventDetail.setUserId(serviceContext.getGuestOrUserId());
		    eventDetail.setCreatedDate(serviceContext.getCreateDate(now));
		    eventDetail.setModifiedDate(serviceContext.getModifiedDate(now));

		    
			eventDetail = EventDetailLocalServiceUtil.addEventDetail(eventDetail);
		}catch(Exception ex){
			LOGGER.error("Exception in addEventDetail: " + ex.getMessage());
		}
		return eventDetail;
	}
	
	@Override
	public EventDetail updateEventDetail(long eventDetailId , long infoTypeId, long infoTypeCategoryId, 
		String infoTitle, String infoDesc, String addrLine1, String addrLine2, String zipCode,
		String city, long stateId, long countryId, String lattitude, String longitude, String phone, 
		String website, Double cost, String hoursOfOperation,
		ServiceContext  serviceContext){
		EventDetail eventDetail=null;
		try{
			eventDetail= EventDetailLocalServiceUtil.getEventDetail(eventDetailId);
			eventDetail.setInfoTypeId(infoTypeId);
			eventDetail.setInfoTypeCategoryId(infoTypeCategoryId);
			eventDetail.setInfoTitle(infoTitle);
			eventDetail.setInfoDesc(infoDesc);
			eventDetail.setAddrLine1(addrLine1);
			eventDetail.setAddrLine2(addrLine2);
			eventDetail.setZipCode(zipCode);
			eventDetail.setCity(city);
			eventDetail.setStateId(stateId);
			eventDetail.setCountryId(countryId);
			eventDetail.setLatitude(lattitude);
			eventDetail.setLongitude(longitude);
			eventDetail.setPhone(phone);
			eventDetail.setWebsite(website);
			eventDetail.setCost(cost);
			eventDetail.setHoursOfOperation(hoursOfOperation);
			
			Date now = new Date();
		    eventDetail.setUserId(serviceContext.getGuestOrUserId());
		    eventDetail.setModifiedDate(serviceContext.getModifiedDate(now));

		    
			eventDetail = EventDetailLocalServiceUtil.updateEventDetail(eventDetail);
							
		}catch(Exception ex){
			LOGGER.error("Exception in updateEventDetail: " + ex.getMessage());
		}
		return eventDetail;
	}
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public EventDetail getEventDetail(long eventDetailId, ServiceContext  serviceContext){
		EventDetail eventDetail = null;
		try{
			eventDetail = EventDetailUtil.fetchByPrimaryKey(eventDetailId);
			eventDetail = FlaskUtil.setNamesForEventDetail(eventDetail);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return eventDetail;
	}
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public List<EventDetail> getEventDetails(long eventId, ServiceContext  serviceContext){
		List<EventDetail> eventDetails = null;
		try{
			eventDetails = EventDetailUtil.findByEventId(eventId);
			eventDetails = FlaskUtil.setNamesForEventDetail(eventDetails);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return eventDetails;
	}
	
	@AccessControlled(guestAccessEnabled = true)
	@Override
	public JSONObject getEventDetailsWithImages(long eventId, ServiceContext  serviceContext){
		
		List<EventDetail> eventDetails = null;
		List<EventDetailImage> detailImgList = null;
		JSONObject eventJsonObj =  JSONFactoryUtil.createJSONObject();
		try{
			Event event  = getEvent(eventId, serviceContext);
			eventJsonObj.put("Event", JSONFactoryUtil.looseSerialize(event));
			JSONArray eventDetailArr =  JSONFactoryUtil.createJSONArray();
			eventJsonObj.put("EventDetails", eventDetailArr);
			eventDetails = EventDetailUtil.findByEventId(eventId);
			eventDetails = FlaskUtil.setNamesForEventDetail(eventDetails);
			
			for (EventDetail eventDetail : eventDetails) {
				JSONObject eventDetailJsonObj =  JSONFactoryUtil.createJSONObject();
				eventDetailJsonObj.put("EventDetail", JSONFactoryUtil.looseSerialize(eventDetail));
				eventDetailArr.put(eventDetailJsonObj);
				detailImgList = getEventDetailImages(eventDetail.getEventDetailId(), serviceContext);
				JSONArray eventDetailImageArr =  JSONFactoryUtil.createJSONArray();
				eventDetailJsonObj.put("EventDetailImages", eventDetailImageArr);
				for (EventDetailImage detailImage : detailImgList) {
					JSONObject eventDetailImageObj =  JSONFactoryUtil.createJSONObject();
					eventDetailImageObj.put("EventDetailImage", JSONFactoryUtil.looseSerialize(detailImage));
					eventDetailImageArr.put(eventDetailImageObj);
				}
				
				
			}
			
		}catch(Exception ex){
			LOGGER.error("Exception in getEventDetailsWithImages. Exception: " +  ex.getMessage());
			return null;
		}
		return eventJsonObj;
	}

	

	@Override
	public void deleteEventDetail(long eventDetailId, ServiceContext  serviceContext){
		try{
			EventDetailLocalServiceUtil.deleteEventDetail(eventDetailId);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		
	}
	
	@Override
	public void deleteAllEventDetails(long eventId, ServiceContext  serviceContext){
		try{
			List<EventDetail> eventDetails = EventDetailLocalServiceUtil.getEventDetails(0, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			for( EventDetail eventDetail: eventDetails){
				EventDetailLocalServiceUtil.deleteEventDetail(eventDetail);
			}
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		
	}
	
	@Override
	public EventDetailImage addEventDetailImage(long eventDetailId, String imageTitle,
									String imageDesc, String imageUUID,
									ServiceContext  serviceContext){
		EventDetailImage eventDetailImage =null;
		try{
			eventDetailImage =EventDetailImageLocalServiceUtil.createEventDetailImage(CounterLocalServiceUtil.increment());
			eventDetailImage.setEventDetailId(eventDetailId);
			eventDetailImage.setImageTitle(imageTitle);
			eventDetailImage.setImageDesc(imageDesc);
			eventDetailImage.setImageUUID(imageUUID);
			eventDetailImage.setImageGroupId(FlaskUtil.getFlaskRepositoryId());
			
			Date now = new Date();
			eventDetailImage.setCompanyId(serviceContext.getCompanyId());
		    eventDetailImage.setUserId(serviceContext.getGuestOrUserId());
		    eventDetailImage.setCreatedDate(serviceContext.getCreateDate(now));
		    eventDetailImage.setModifiedDate(serviceContext.getModifiedDate(now));
		    
			EventDetailImageLocalServiceUtil.addEventDetailImage(eventDetailImage);
			
		}catch(Exception ex){
			LOGGER.error(ex);
		}    
		return eventDetailImage;
	}
	
	@Override
	public EventDetailImage updateEventDetailImage(long eventDetailImageId,
									String imageTitle,
									String imageDesc, String imageUUID,
									ServiceContext  serviceContext){
		EventDetailImage eventDetailImage =null;
		try{
			eventDetailImage =EventDetailImageLocalServiceUtil.getEventDetailImage(eventDetailImageId);
			eventDetailImage.setImageTitle(imageTitle);
			eventDetailImage.setImageDesc(imageDesc);
			eventDetailImage.setImageUUID(imageUUID);
			eventDetailImage.setImageGroupId(FlaskUtil.getFlaskRepositoryId());
			
			Date now = new Date();
			eventDetailImage.setUserId(serviceContext.getGuestOrUserId());
		    eventDetailImage.setModifiedDate(serviceContext.getModifiedDate(now));

		    
			EventDetailImageLocalServiceUtil.updateEventDetailImage(eventDetailImage);
			
		}catch(Exception ex){
			LOGGER.error(ex);
		}    
		return eventDetailImage;
	}
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public EventDetailImage getEventDetailImage(long eventDetailImageId, ServiceContext  serviceContext){
		EventDetailImage EventDetailImage = null;
		try{
			EventDetailImage = EventDetailImageUtil.fetchByPrimaryKey(eventDetailImageId);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return EventDetailImage;
	}
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public List<EventDetailImage> getEventDetailImages(long eventDetailId, ServiceContext  serviceContext){
		List<EventDetailImage> eventDetailImages = null;
		try{
			eventDetailImages = EventDetailImageUtil.findByEventDetailId(eventDetailId);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return eventDetailImages;
	}
	
	@Override
	public void deleteEventDetailImage(long eventDetailImageId,
									ServiceContext  serviceContext){
		try{
			EventDetailImageLocalServiceUtil.deleteEventDetailImage(eventDetailImageId);
			
		}catch(Exception ex){
			LOGGER.error(ex);
		}    
	}
	
	
}