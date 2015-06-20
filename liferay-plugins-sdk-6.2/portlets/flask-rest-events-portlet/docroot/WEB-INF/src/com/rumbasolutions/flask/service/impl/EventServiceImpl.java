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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
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
	
	@Override
	public List<Event> getAllEvents(ServiceContext  serviceContext){
		List<Event> events= new ArrayList<Event>();
		try {
			events =  EventUtil.findAll();
		}
		catch (Exception e) {
			LOGGER.error("Exception in getAllEvents. " + e.getMessage());
			e.printStackTrace();
		}
		return events;
	}
	

	
	@Override
	public Event addEvent(String eventName, String description, 
						String eventDate, String startTime, String endTime,
						long eventTypeId, long venueId, String eventImagePath,
								ServiceContext  serviceContext){
		Event event=null;
		try{
			
			event = EventLocalServiceUtil.createEvent(CounterLocalServiceUtil.increment());
			event.setEventName(eventName);
			event.setDescription(description);
			event.setEventDate(FlaskUtil.parseDate(eventDate).getTime());
			event.setStartTime(FlaskUtil.parseTime(startTime).getTime());
			event.setEndTime(FlaskUtil.parseTime(endTime).getTime());
			event.setEventTypeId(eventTypeId);
			event.setVenueId(venueId);
			event.setEventImagePath(eventImagePath);

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
						String eventDate, String startTime, String endTime,
						long eventTypeId, long venueId, String eventImagePath,
								ServiceContext  serviceContext){
		Event event=null;
		try{
			event = EventLocalServiceUtil.getEvent(eventId);
			event.setEventName(eventName);
			event.setDescription(description);
			event.setEventDate(FlaskUtil.parseDate(eventDate).getTime());
			event.setStartTime(FlaskUtil.parseTime(startTime).getTime());
			event.setEndTime(FlaskUtil.parseTime(endTime).getTime());
			
			Date now = new Date();
		    event.setUserId(serviceContext.getGuestOrUserId());
		    event.setModifiedDate(serviceContext.getModifiedDate(now));

		    event.setEventTypeId(eventTypeId);
			event.setVenueId(venueId);
			event.setEventImagePath(eventImagePath);
			
			
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
	
	@Override
	public EventDetail getEventDetail(long eventDetailId, ServiceContext  serviceContext){
		EventDetail eventDetail = null;
		try{
			eventDetail = EventDetailUtil.fetchByPrimaryKey(eventDetailId);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return eventDetail;
	}
	
	@Override
	public List<EventDetail> getEventDetails(long eventId, ServiceContext  serviceContext){
		List<EventDetail> eventDetails = null;
		try{
			eventDetails = EventDetailUtil.findByEventId(eventId);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return eventDetails;
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
									String imageDesc, String imagePath,
									ServiceContext  serviceContext){
		EventDetailImage eventDetailImage =null;
		try{
			eventDetailImage =EventDetailImageLocalServiceUtil.createEventDetailImage(CounterLocalServiceUtil.increment());
			eventDetailImage.setEventDetailId(eventDetailId);
			eventDetailImage.setImageTitle(imageTitle);
			eventDetailImage.setImageDesc(imageDesc);
			eventDetailImage.setImagePath(imagePath);
			
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
									String imageDesc, String imagePath,
									ServiceContext  serviceContext){
		EventDetailImage eventDetailImage =null;
		try{
			eventDetailImage =EventDetailImageLocalServiceUtil.getEventDetailImage(eventDetailImageId);
			eventDetailImage.setImageTitle(imageTitle);
			eventDetailImage.setImageDesc(imageDesc);
			eventDetailImage.setImagePath(imagePath);
			
			Date now = new Date();
			eventDetailImage.setUserId(serviceContext.getGuestOrUserId());
		    eventDetailImage.setModifiedDate(serviceContext.getModifiedDate(now));

		    
			EventDetailImageLocalServiceUtil.updateEventDetailImage(eventDetailImage);
			
		}catch(Exception ex){
			LOGGER.error(ex);
		}    
		return eventDetailImage;
	}
	
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