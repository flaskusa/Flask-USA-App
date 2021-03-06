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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.model.EventType;
import com.rumbasolutions.flask.service.base.EventTypeServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.EventTypeUtil;

/**
 * The implementation of the event type remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.EventTypeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.base.EventTypeServiceBaseImpl
 * @see com.rumbasolutions.flask.service.EventTypeServiceUtil
 */
public class EventTypeServiceImpl extends EventTypeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.EventTypeServiceUtil} to access the event type remote service.
	 */
	
	private static Log LOGGER = LogFactoryUtil.getLog(EventTypeServiceImpl.class);
	
	@Override
	public List<EventType> getEventTypes(ServiceContext  serviceContext){
		List<EventType> eventTypes= new ArrayList<EventType>();
		try {
			eventTypes  = EventTypeUtil.findAll();
		}
		catch (SystemException e) {
			LOGGER.error("Exception in getEventTypes. " + e.getMessage());
		}
		return eventTypes;
	}
	
	@Override
	public EventType getEventType(long eventTypeId, ServiceContext  serviceContext){
		EventType eventType= null;
		try {
			eventType  = EventTypeUtil.fetchByPrimaryKey(eventTypeId);
		}
		catch (SystemException e) {
			LOGGER.error("Exception in getEventType. " + e.getMessage());
		}
		return eventType;
	}
	
}