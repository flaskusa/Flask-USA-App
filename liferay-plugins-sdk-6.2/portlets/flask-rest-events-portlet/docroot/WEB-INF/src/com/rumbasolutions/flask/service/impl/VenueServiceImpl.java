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

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.model.Venue;
import com.rumbasolutions.flask.model.VenueImage;
import com.rumbasolutions.flask.service.VenueImageLocalServiceUtil;
import com.rumbasolutions.flask.service.VenueLocalServiceUtil;
import com.rumbasolutions.flask.service.base.VenueServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.VenueUtil;

/**
 * The implementation of the venue remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.VenueService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.base.VenueServiceBaseImpl
 * @see com.rumbasolutions.flask.service.VenueServiceUtil
 */
public class VenueServiceImpl extends VenueServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.VenueServiceUtil} to access the venue remote service.
	 */
	
	private static Log LOGGER = LogFactoryUtil.getLog(VenueServiceImpl.class);
	
	@Override
	public List<Venue> getAllVenues(ServiceContext  serviceContext){
		List<Venue> venue = new ArrayList<Venue>();
		try {
			return  VenueUtil.findAll();
		}
		catch (SystemException e) {
			LOGGER.error("Exception in getAllVenues. " + e.getMessage());
			e.printStackTrace();
		}
		return venue;
	}
	
	
	
	@Override
	public Venue addVenue(String venueName, String venueDescription, String addrLine1, 
								String addrLine2, String venueZipCode, String venueCity,
								String venueMetroArea, long venueStateId, long venueCountryId, 
								ServiceContext  serviceContext){
		Venue venue=null;
		try{
			
			venue= VenueLocalServiceUtil.createVenue(CounterLocalServiceUtil.increment());

			venue.setVenueName(venueName);
			venue.setVenueDescription(venueDescription);
			venue.setAddrLine1(addrLine1);
			venue.setAddrLine2(addrLine2);
			venue.setVenueZipCode(venueZipCode);
			venue.setVenueCity(venueCity);
			venue.setVenueMetroArea(venueMetroArea);
			venue.setVenueStateId(venueStateId);
			venue.setVenueCountryId(venueCountryId);
			venue = VenueLocalServiceUtil.addVenue(venue);
			
		}catch(Exception ex){
			LOGGER.error("Exception in addVenue: " + ex.getMessage());
		}
		return venue;
	}
	
	@Override
	public Venue updateVenue(long venueId, String venueName, String venueDescription, String addrLine1, 
								String addrLine2, String venueZipCode, String venueCity,
								String venueMetroArea, long venueStateId, long venueCountryId, 
								ServiceContext  serviceContext){
		Venue venue=null;
		try{
			
			venue= VenueLocalServiceUtil.getVenue(venueId);

			venue.setVenueName(venueName);
			venue.setVenueDescription(venueDescription);
			venue.setAddrLine1(addrLine1);
			venue.setAddrLine2(addrLine2);
			venue.setVenueZipCode(venueZipCode);
			venue.setVenueCity(venueCity);
			venue.setVenueMetroArea(venueMetroArea);
			venue.setVenueStateId(venueStateId);
			venue.setVenueCountryId(venueCountryId);
			venue = VenueLocalServiceUtil.updateVenue(venue);
			
		}catch(Exception ex){
			LOGGER.error("Exception in addVenue: " + ex.getMessage());
		}
		return venue;
	}
	
	@Override
	public void deleteVenue(long venueId, ServiceContext  serviceContext){
		
			try {
				VenueLocalServiceUtil.deleteVenue(venueId);
			}
			catch (PortalException e) {
				
				LOGGER.error("Exception in addVenue: " + e.getMessage());
			}
			catch (SystemException e) {
				LOGGER.error("Exception in addVenue: " + e.getMessage());
			}
	}
	
	/**
	 * 
	 * @param venueList comms seperated venueId list
	 * @param serviceContext
	 * @return
	 */
	@Override
	public void deleteVenues(String venueList,
								ServiceContext  serviceContext){
	
		String[] venueArr = venueList.split(",");
		for (String venueId :venueArr){
				try{
					VenueLocalServiceUtil.deleteVenue(Integer.valueOf(venueId));
				}catch(Exception ex){
					LOGGER.error("Error in deleting venue:" + venueId );
				}
		}
	}

		
	@Override
	public void addVenueImage(long venueId, String title, Blob venueImageData ,ServiceContext  serviceContext){
		try{
			VenueImage venueImage = VenueImageLocalServiceUtil.createVenueImage(CounterLocalServiceUtil.increment());
			VenueImageLocalServiceUtil.addVenueImage(venueImage);
			venueImage.setTitle(title);
			venueImage.setVenueImage(venueImageData);
			VenueImageLocalServiceUtil.addVenueImage(venueImage);
			
		}catch(Exception ex){
			LOGGER.error(ex);
		}
	}

	
}