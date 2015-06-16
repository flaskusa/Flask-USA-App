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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.model.Event;
import com.rumbasolutions.flask.service.EventLocalServiceUtil;
import com.rumbasolutions.flask.service.base.EventServiceBaseImpl;
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
			EventLocalServiceUtil.addEvent(event);

			
		}catch(Exception ex){
			LOGGER.error("Exception in addEvent: " + ex.getMessage());
		}
		return event;
	}
	
}