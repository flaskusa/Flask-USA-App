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

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.model.Group;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.rumbasolutions.flask.model.Event;
import com.rumbasolutions.flask.model.EventDetail;
import com.rumbasolutions.flask.model.EventDetailImage;
import com.rumbasolutions.flask.model.UserEvent;
import com.rumbasolutions.flask.service.EventDetailImageLocalServiceUtil;
import com.rumbasolutions.flask.service.EventDetailLocalServiceUtil;
import com.rumbasolutions.flask.service.EventLocalServiceUtil;
import com.rumbasolutions.flask.service.EventServiceUtil;
import com.rumbasolutions.flask.service.EventSubDetailServiceUtil;
import com.rumbasolutions.flask.service.InfoTypeCategoryServiceUtil;
import com.rumbasolutions.flask.service.InfoTypeServiceUtil;
import com.rumbasolutions.flask.service.UserEventLocalServiceUtil;
import com.rumbasolutions.flask.service.VenueLocalServiceUtil;
import com.rumbasolutions.flask.service.base.EventServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.EventDetailImageUtil;
import com.rumbasolutions.flask.service.persistence.EventDetailUtil;
import com.rumbasolutions.flask.service.persistence.EventFinderUtil;
import com.rumbasolutions.flask.service.persistence.EventSubDetailUtil;
import com.rumbasolutions.flask.service.persistence.EventUtil;
import com.rumbasolutions.flask.service.persistence.UserEventUtil;

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
	public static final String _eventRootFolder = "Event";
	private static Log LOGGER = LogFactoryUtil.getLog(EventServiceImpl.class);
	
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public JSONObject getAllEvents(ServiceContext  serviceContext){
		JSONObject eventListJsonObj =  JSONFactoryUtil.createJSONObject();

		List<Event> events= new ArrayList<Event>();
		List<Long> myEventList = new ArrayList<Long>();
		try {
			events =  EventUtil.findAll();
			if(serviceContext.isSignedIn()){
				myEventList = getUserEventIds(serviceContext);
			}
			JSONArray eventArr=  FlaskUtil.setStringNamesForEvents(events, myEventList);
			eventListJsonObj.put("Events", eventArr);
		}
		catch (Exception e) {
			LOGGER.error("Exception in getAllEvents. " + e.getMessage());
			e.printStackTrace();
		}
		return eventListJsonObj;
	}
	
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public JSONObject getSimpleFilteredEvents(String eventTypeIds, String startDate, String endDate, String searchString, String latitude, String longitude, ServiceContext  serviceContext){
		JSONObject eventListJsonObj =  JSONFactoryUtil.createJSONObject();

		List<Event> events= new ArrayList<Event>();
		List<Long> myEventList = new ArrayList<Long>();
		try {
			Double dLat =  FlaskUtil.parseLatitude(latitude);
			Double dLong = FlaskUtil.parseLatitude(longitude);
			Map<String, Double>  geoRange = null;
			if(dLat != null && dLong != null){
				geoRange = FlaskUtil.getLatitudeAndLongitudeRange(dLat, dLong, FlaskUtil.DEFAULT_RANGE);
			}
			events =  EventFinderUtil.getSimpleFilteredEvents(eventTypeIds, startDate, endDate, searchString, geoRange);
			if(serviceContext.isSignedIn()){
				myEventList = getUserEventIds(serviceContext);
			}
			JSONArray eventArr=  FlaskUtil.setStringNamesForEvents(events, myEventList);
			eventListJsonObj.put("Events", eventArr);
		}
		catch (Exception e) {
			LOGGER.error("Exception in getAllEvents. " + e.getMessage());
			e.printStackTrace();
		}
		return eventListJsonObj;
	}
	
	@Override
	public JSONObject getUserSelectedEvents(ServiceContext  serviceContext){
		JSONObject eventListJsonObj =  JSONFactoryUtil.createJSONObject();

		List<Event> events= new ArrayList<Event>();
		List<Long> myEventList = new ArrayList<Long>();
		try {
			if(serviceContext.isSignedIn()){
				myEventList = getUserEventIds(serviceContext);
//TODO this logic should be changed to use dynamic query
				for(Long eventId : myEventList){
					try {
						Event event = EventUtil.findByPrimaryKey(eventId);
						events.add(event);
					} catch (Exception e) {
					}
				}
				if(serviceContext.isSignedIn()){
					myEventList = getUserEventIds(serviceContext);
				}
				JSONArray eventArr=  FlaskUtil.setStringNamesForEvents(events, myEventList);
				eventListJsonObj.put("Events", eventArr);
			}
		}
		catch (Exception e) {
			LOGGER.error("Exception in getUserEvents. " + e.getMessage());
		}
		return eventListJsonObj;
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
						Date eventDate, long startTime, long endTime,
						long eventTypeId, long venueId, String eventImageUUID, long eventImageGroupId,
								ServiceContext  serviceContext){
		Event event=null;
		try{
			
			event = EventLocalServiceUtil.createEvent(CounterLocalServiceUtil.increment());
			event.setEventName(eventName);
			event.setDescription(description);
			event.setEventDate(eventDate);
			event.setStartTime(startTime);
			event.setEndTime(endTime);
			event.setEventTypeId(eventTypeId);
			event.setVenueId(venueId);
			event.setEventImageUUID(eventImageUUID);
			event.setEventImageGroupId(eventImageGroupId);

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
						Date eventDate, long startTime, long endTime,
						long eventTypeId, long venueId, String eventImageUUID, long eventImageGroupId,
								ServiceContext  serviceContext){
		Event event=null;
		try{
			event = EventLocalServiceUtil.getEvent(eventId);
			event.setEventName(eventName);
			event.setDescription(description);
			event.setEventDate(eventDate);
			event.setStartTime(startTime);
			event.setEndTime(endTime);
			
			Date now = new Date();
		    event.setUserId(serviceContext.getGuestOrUserId());
		    event.setModifiedDate(serviceContext.getModifiedDate(now));

		    event.setEventTypeId(eventTypeId);
			event.setVenueId(venueId);
			event.setEventImageUUID(eventImageUUID);
			event.setEventImageGroupId(eventImageGroupId);
			
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
		String infoTitle, String infoShortDesc, String infoDesc, String addrLine1, String addrLine2, String zipCode,
		String city, long stateId, long countryId, String latitude, String longitude, 
		String phone, String mobileAppName, String website, Double cost, 
		String hoursOfOperation, boolean showDescription, String eventSubDetails,
		ServiceContext  serviceContext){
		EventDetail eventDetail=null;
		try{
			eventDetail= EventDetailLocalServiceUtil.createEventDetail(CounterLocalServiceUtil.increment());
			eventDetail.setEventId(eventId);
			eventDetail.setInfoTypeId(infoTypeId);
			eventDetail.setInfoTypeName(InfoTypeServiceUtil.getInfoType(infoTypeId, serviceContext).getInfoTypeName());
			eventDetail.setInfoTypeCategoryId(infoTypeCategoryId);
			eventDetail.setInfoTypeCategoryName(InfoTypeCategoryServiceUtil.getInfoTypeCategory(infoTypeCategoryId, serviceContext).getInfoTypeCategoryName());
			eventDetail.setInfoTitle(infoTitle);
			eventDetail.setInfoShortDesc(infoShortDesc);
			eventDetail.setInfoDesc(infoDesc);
			eventDetail.setAddrLine1(addrLine1);
			eventDetail.setAddrLine2(addrLine2);
			eventDetail.setZipCode(zipCode);
			eventDetail.setCity(city);
			eventDetail.setStateId(stateId);
			eventDetail.setCountryId(countryId);
			eventDetail.setLatitude(latitude);
			eventDetail.setLongitude(longitude);
			eventDetail.setPhone(phone);
			eventDetail.setMobileAppName(mobileAppName);
			eventDetail.setWebsite(website);
			eventDetail.setCost(cost);
			eventDetail.setHoursOfOperation(hoursOfOperation);
			eventDetail.setShowDescription(showDescription);
			
			Date now = new Date();
			eventDetail.setCompanyId(serviceContext.getCompanyId());
		    eventDetail.setUserId(serviceContext.getGuestOrUserId());
		    eventDetail.setCreatedDate(serviceContext.getCreateDate(now));
		    eventDetail.setModifiedDate(serviceContext.getModifiedDate(now));
			eventDetail = EventDetailLocalServiceUtil.addEventDetail(eventDetail);
			EventSubDetailServiceUtil.addEventSubDetailsByJsonArray(eventDetail.getEventDetailId(), eventSubDetails);
		}catch(Exception ex){
			LOGGER.error("Exception in addEventDetail: " + ex.getMessage());
		}
		return eventDetail;
	}
	
	@Override
	public EventDetail updateEventDetail(long eventDetailId , long infoTypeId, long infoTypeCategoryId, 
		String infoTitle, String infoShortDesc, String infoDesc, String addrLine1, String addrLine2, String zipCode,
		String city, long stateId, long countryId, String latitude, String longitude, String phone, 
		String mobileAppName, String website, Double cost, String hoursOfOperation, boolean showDescription, String eventSubDetails,
		ServiceContext  serviceContext){
		EventDetail eventDetail=null;
		try{
			eventDetail= EventDetailLocalServiceUtil.getEventDetail(eventDetailId);
			eventDetail.setInfoTypeId(infoTypeId);
			eventDetail.setInfoTypeName(InfoTypeServiceUtil.getInfoType(infoTypeId, serviceContext).getInfoTypeName());
			eventDetail.setInfoTypeCategoryId(infoTypeCategoryId);
			eventDetail.setInfoTypeCategoryName(InfoTypeCategoryServiceUtil.getInfoTypeCategory(infoTypeCategoryId, serviceContext).getInfoTypeCategoryName());
			eventDetail.setInfoTitle(infoTitle);
			eventDetail.setInfoShortDesc(infoShortDesc);
			eventDetail.setInfoDesc(infoDesc);
			eventDetail.setAddrLine1(addrLine1);
			eventDetail.setAddrLine2(addrLine2);
			eventDetail.setZipCode(zipCode);
			eventDetail.setCity(city);
			eventDetail.setStateId(stateId);
			eventDetail.setCountryId(countryId);
			eventDetail.setLatitude(latitude);
			eventDetail.setLongitude(longitude);
			eventDetail.setPhone(phone);
			eventDetail.setMobileAppName(mobileAppName);
			eventDetail.setWebsite(website);
			eventDetail.setCost(cost);
			eventDetail.setHoursOfOperation(hoursOfOperation);
			eventDetail.setShowDescription(showDescription);
			
			Date now = new Date();
		    eventDetail.setUserId(serviceContext.getGuestOrUserId());
		    eventDetail.setModifiedDate(serviceContext.getModifiedDate(now));
			eventDetail = EventDetailLocalServiceUtil.updateEventDetail(eventDetail);
			try{
				EventSubDetailUtil.removeByEventDetailId(eventDetailId);
			}finally{
				EventSubDetailServiceUtil.addEventSubDetailsByJsonArray(eventDetailId, eventSubDetails);
			}
							
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
			eventJsonObj.put("Details", eventDetailArr);
			eventDetails = EventDetailUtil.findByEventId(eventId);
			eventDetails = FlaskUtil.setNamesForEventDetail(eventDetails);
			
			for (EventDetail eventDetail : eventDetails) {
				JSONObject eventDetailJsonObj =  JSONFactoryUtil.createJSONObject();
				eventDetailJsonObj.put("Detail", JSONFactoryUtil.looseSerialize(eventDetail));
				eventDetailArr.put(eventDetailJsonObj);
				detailImgList = getEventDetailImages(eventDetail.getEventDetailId(), serviceContext);
				JSONArray eventDetailImageArr =  JSONFactoryUtil.createJSONArray();
				eventDetailJsonObj.put("DetailImages", eventDetailImageArr);
				for (EventDetailImage detailImage : detailImgList) {
					JSONObject eventDetailImageObj =  JSONFactoryUtil.createJSONObject();
					eventDetailImageObj.put("DetailImage", JSONFactoryUtil.looseSerialize(detailImage));
					eventDetailImageArr.put(eventDetailImageObj);
				}
			}
		}catch(Exception ex){
			LOGGER.error("Exception in getEventDetailsWithImages. Exception: " +  ex.getMessage());
			return null;
		}
		return eventJsonObj;
	}
	
	@AccessControlled(guestAccessEnabled = true)
	@Override
	public JSONObject getEventVenueDetailsWithImages(long eventId, ServiceContext  serviceContext){
		JSONObject eventObj = getEventDetailsWithImages(eventId, serviceContext);
		JSONObject event=null;
		try {
			event = JSONFactoryUtil.createJSONObject(eventObj.getString("Event"));
		} catch (JSONException e) {
			LOGGER.error("Exception in getEventVenueDetailsWithImages. Exception: " +  e.getMessage());
		}
		long venueId = event.getLong("venueId");
		JSONObject venueJsonObj = VenueLocalServiceUtil.getVenueDetailsWithImages(venueId);
		eventObj = FlaskUtil.mergeEventVenueJSON(eventObj, venueJsonObj);
		return eventObj;
	}

	@Override
	public void deleteEventDetail(long eventDetailId, ServiceContext  serviceContext){
		try{
			EventDetailLocalServiceUtil.deleteEventDetail(eventDetailId);
			EventSubDetailUtil.removeByEventDetailId(eventDetailId);
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
									String imageDesc, String imageUUID, long groupId,
									ServiceContext  serviceContext){
		EventDetailImage eventDetailImage =null;
		try{
			eventDetailImage =EventDetailImageLocalServiceUtil.createEventDetailImage(CounterLocalServiceUtil.increment());
			eventDetailImage.setEventDetailId(eventDetailId);
			eventDetailImage.setImageTitle(imageTitle);
			eventDetailImage.setImageDesc(imageDesc);
			eventDetailImage.setImageUUID(imageUUID);
			eventDetailImage.setImageGroupId(groupId);
			
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
									String imageDesc, String imageUUID, long groupId,
									ServiceContext  serviceContext){
		EventDetailImage eventDetailImage =null;
		try{
			eventDetailImage =EventDetailImageLocalServiceUtil.getEventDetailImage(eventDetailImageId);
			eventDetailImage.setImageTitle(imageTitle);
			eventDetailImage.setImageDesc(imageDesc);
			eventDetailImage.setImageUUID(imageUUID);
			eventDetailImage.setImageGroupId(groupId);
			
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
	
	@Override
	public void addUserEvent(long eventId, ServiceContext  serviceContext){
		try{
			// check if already exist
			UserEvent userEvent = UserEventUtil.fetchByuserEvent(serviceContext.getUserId(), eventId);
			if(userEvent == null){
				userEvent = UserEventLocalServiceUtil.createUserEvent(CounterLocalServiceUtil.increment());
				userEvent.setEventId(eventId);
				userEvent.setUserId(serviceContext.getUserId());
				Date now = new Date();
				userEvent.setCreatedDate(now);
				UserEventLocalServiceUtil.addUserEvent(userEvent);
			}
		}catch(Exception ex){
			LOGGER.error("Exception in addUserEvent: " + ex.getMessage());
		}
	}
	
	@Override
	public void removeUserEvent(long eventId, ServiceContext  serviceContext){
		try{
			// check if already exist
			UserEventUtil.removeByuserEvent(serviceContext.getUserId(), eventId);
			
		}catch(Exception ex){
			LOGGER.error("Exception in removeUserEvent: " + ex.getMessage());
		}
	}

	
	@Override
	public List<Long> getUserEventIds(ServiceContext  serviceContext){
		List<Long> userEvents = new ArrayList<Long>();
		try{
			List<UserEvent> userEventList = UserEventUtil.findByuserId(serviceContext.getUserId());
			for(UserEvent ue: userEventList){
				userEvents.add(ue.getEventId());
			}
		}catch(Exception ex){
			LOGGER.error("Exception in getUserEventIds: " + ex.getMessage());
		}
		return userEvents;
	}
	
	@Override
	public List<Long> setGuestViewPermission(ServiceContext  serviceContext){
		List<Long> userEvents = new ArrayList<Long>();
		try{
			List<Event> eventList = EventUtil.findAll();
			DLFileEntry fileEntry;
			for (Event event: eventList){
				long groupId = event.getEventImageGroupId();
				String uuId = event.getEventImageUUID();
				try{
					fileEntry = DLFileEntryLocalServiceUtil.getFileEntryByUuidAndGroupId(uuId, groupId);
				}catch(Exception ex){
					LOGGER.error("Exception in calling getFileEntryByUuidAndGroupId: " + ex.getMessage());
					continue;
				}
				FlaskUtil.setGuestViewPermission(fileEntry);
				DLFolder dlFolder =fileEntry.getFolder(); 
				setFolderPermissionRecursive(dlFolder);
			}		
		}catch(Exception ex){
			LOGGER.error("Exception in getUserEventIds: " + ex.getMessage());
		}
		return userEvents;
	}
	
	private void setFolderPermissionRecursive(DLFolder dlFolder) {
		if(dlFolder == null){
			return;
		}
		try {
			FlaskUtil.setGuestViewFolderPermission(dlFolder);
		} catch (Exception ex) {
			LOGGER.error("Exception in setFolderPermissionRecursive:setGuestViewFolderPermission " + ex.getMessage());
		} 
		
		try {
			DLFolder parentFolder = dlFolder.getParentFolder();
			setFolderPermissionRecursive(parentFolder);
		} catch (Exception ex) {
			LOGGER.error("Exception in setFolderPermissionRecursive:getParentFolder " + ex.getMessage());
			return;
		} 
	}

	@Override
	public List<FileEntry> getEventLogos(ServiceContext serviceContext){
		List<FileEntry> eventLogos = null;
		try {
			long companyId = PortalUtil.getDefaultCompanyId();
			Group group = GroupLocalServiceUtil.getGroup(companyId, "guest");
			Folder folder = DLAppLocalServiceUtil.getFolder(group.getGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "Event");
			Folder eventLogosFolder = DLAppLocalServiceUtil.getFolder(folder.getRepositoryId(), folder.getFolderId(), "Logos");
			eventLogos = DLAppServiceUtil.getFileEntries(eventLogosFolder.getRepositoryId(), eventLogosFolder.getFolderId());
		} catch (Exception e) {
			LOGGER.error("Exception in getEventLogos " + e.getMessage());
		}
		return eventLogos;
	}
	@Override
	public EventDetailImage uploadDetailImage(File file, long eventId, long eventDetailId,  ServiceContext serviceContext){
		EventDetailImage detailImage = null;
		try {
			Path source = Paths.get(file.getName());
			String mimeType = Files.probeContentType(source);
			long repositoryId = FlaskUtil.getFlaskRepositoryId();
			System.out.println("repository Is is"+repositoryId);
			long userId = serviceContext.getUserId();
			System.out.println("USer Id"+userId);
			String name = eventDetailId +"_"+ file.getName();
			Folder folder = FlaskUtil.getOrCreateFolder(_eventRootFolder, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, repositoryId, userId, serviceContext);
			String eventFolderName = folder.getName()+"-"+eventId;
			System.out.println("Event folder NAme"+eventFolderName);
			Folder eventFolder = FlaskUtil.getOrCreateFolder(eventFolderName, folder.getFolderId(), folder.getRepositoryId(), userId, serviceContext);
			System.out.println("event folder");
			FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), eventFolder.getRepositoryId(), eventFolder.getFolderId(), name, mimeType, name, name, "", file, serviceContext);
			System.out.println("FileEntry"+fileEntry.getFileEntryId());
			
			FlaskUtil.setGuestViewPermission(fileEntry);
			detailImage = EventServiceUtil.addEventDetailImage(eventDetailId, name, name, fileEntry.getUuid(), fileEntry.getGroupId(), serviceContext);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return detailImage;
	}
}