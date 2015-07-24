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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.model.Venue;
import com.rumbasolutions.flask.model.VenueDetail;
import com.rumbasolutions.flask.model.VenueDetailImage;
import com.rumbasolutions.flask.model.VenueImage;
import com.rumbasolutions.flask.service.VenueDetailImageLocalServiceUtil;
import com.rumbasolutions.flask.service.VenueDetailLocalServiceUtil;
import com.rumbasolutions.flask.service.VenueImageLocalServiceUtil;
import com.rumbasolutions.flask.service.VenueLocalServiceUtil;
import com.rumbasolutions.flask.service.base.VenueServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.VenueDetailImageUtil;
import com.rumbasolutions.flask.service.persistence.VenueDetailUtil;
import com.rumbasolutions.flask.service.persistence.VenueImageUtil;
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
	
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public List<Venue> getAllVenues(ServiceContext  serviceContext){
		List<Venue> venue = new ArrayList<Venue>();
		try {
			venue = VenueUtil.findAll();
			venue = FlaskUtil.setVenueStringValues(venue);
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
								String venueMetroArea, long venueStateId, long venueCountryId, String longitude, String latitude, 
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
			venue.setLongitude(longitude);
			venue.setLatitude(latitude);
			Date now = new Date();
			venue.setCompanyId(serviceContext.getCompanyId());
		    venue.setUserId(serviceContext.getGuestOrUserId());
		    venue.setCreatedDate(serviceContext.getCreateDate(now));
		    venue.setModifiedDate(serviceContext.getModifiedDate(now));
		    venue = VenueLocalServiceUtil.addVenue(venue);
			
		}catch(Exception ex){
			LOGGER.error("Exception in addVenue: " + ex.getMessage());
		}
		return venue;
	}
	
	@Override
	public Venue updateVenue(long venueId, String venueName, String venueDescription, String addrLine1, 
								String addrLine2, String venueZipCode, String venueCity,
								String venueMetroArea, long venueStateId, long venueCountryId, String longitude, String latitude, 
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
			venue.setLongitude(longitude);
			venue.setLatitude(latitude);
			Date now = new Date();
			venue.setUserId(serviceContext.getGuestOrUserId());
		    venue.setModifiedDate(serviceContext.getModifiedDate(now));
		    
			venue = VenueLocalServiceUtil.updateVenue(venue);
			
		}catch(Exception ex){
			LOGGER.error("Exception in addVenue: " + ex.getMessage());
		}
		return venue;
	}
	
	@Override
	public void deleteVenue(long venueId, ServiceContext  serviceContext){
		
			try {
				deleteVenueCascade(venueId, serviceContext);
				VenueLocalServiceUtil.deleteVenue(venueId);
			}
			catch (Exception e) {
				LOGGER.error("Exception in deleteVenue: " + e.getMessage());
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
					if(venueId.length() > 0){
						VenueLocalServiceUtil.deleteVenue(Integer.valueOf(venueId));
					}
				}catch(Exception ex){
					LOGGER.error("Error in deleting venue:" + venueId );
				}
		}
	}

		
	@Override
	public void addVenueImage(long venueId, String title, String venueImageUUID ,ServiceContext  serviceContext){
		try{
			VenueImage venueImage = VenueImageLocalServiceUtil.createVenueImage(CounterLocalServiceUtil.increment());
			venueImage.setVenueId(venueId);	
			venueImage.setTitle(title);
			venueImage.setVenueImageUUId(venueImageUUID);
			
			Date now = new Date();
			venueImage.setCompanyId(serviceContext.getCompanyId());
		    venueImage.setUserId(serviceContext.getGuestOrUserId());
		    venueImage.setCreatedDate(serviceContext.getCreateDate(now));
		    venueImage.setModifiedDate(serviceContext.getModifiedDate(now));
		    
			VenueImageLocalServiceUtil.addVenueImage(venueImage);
			
		}catch(Exception ex){
			LOGGER.error(ex);
		}
	}
	
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public List<VenueImage> getVenueImages(long venueId,ServiceContext  serviceContext){
			
			List<VenueImage>  venueImages = new ArrayList<VenueImage>();
			try {
				venueImages =  VenueImageUtil.findByvenueId(venueId);
			}
			catch (SystemException e) {
				LOGGER.error("Error in getVenueImages:" + venueId );
			}
			return venueImages;
	}
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public VenueImage getVenueImage(long venueImageId,ServiceContext  serviceContext){
				
			VenueImage  venueImage = null;
			try {
				venueImage = VenueImageUtil.findByPrimaryKey(venueImageId);
			}
			catch (Exception e) {
				LOGGER.error("Error in getVenueImage:" + venueImageId );
			}
			return venueImage;
	}
	
	@Override
	public void updateVenueImage(long venueImageId, String title, String venueImageUUID ,ServiceContext  serviceContext){
		try{
			VenueImage venueImage = VenueImageLocalServiceUtil.getVenueImage(venueImageId);
			venueImage.setTitle(title);
			venueImage.setVenueImageUUId(venueImageUUID);
			
			Date now = new Date();
			venueImage.setUserId(serviceContext.getGuestOrUserId());
		    venueImage.setModifiedDate(serviceContext.getModifiedDate(now));
		    
			VenueImageLocalServiceUtil.updateVenueImage(venueImage);
			
		}catch(Exception ex){
			LOGGER.error(ex);
		}
	}
	
	
	@Override
	public void deleteVenueImage(long venueImageId ,ServiceContext  serviceContext){
		try{
			VenueImageLocalServiceUtil.deleteVenueImage(venueImageId);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
	}
	
	@Override
	public void deleteAllVenueImages(long venueId ,ServiceContext  serviceContext){
		try{
			List<VenueImage> venueImages = VenueImageLocalServiceUtil.getVenueImages(0, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			for( VenueImage venueImage: venueImages){
				 VenueImageLocalServiceUtil.deleteVenueImage(venueImage);
			}
		}catch(Exception ex){
			LOGGER.error(ex);
		}
	}
	
	@Override
	public VenueDetail addVenueDetail(long venueId , long infoTypeId, long infoTypeCategoryId, 
		String infoTitle, String infoDesc, String addrLine1, String addrLine2, String zipCode,
		String city, long stateId, long countryId, String lattitude, 
		String longitude, String phone, String website, 
		Double cost, String hoursOfOperation,
		ServiceContext  serviceContext){
		VenueDetail venueDetail=null;
		try{
			
			venueDetail= VenueDetailLocalServiceUtil.createVenueDetail(CounterLocalServiceUtil.increment());
			venueDetail.setVenueId(venueId);
			venueDetail.setInfoTypeId(infoTypeId);
			venueDetail.setInfoTypeCategoryId(infoTypeCategoryId);
			
			venueDetail.setInfoTitle(infoTitle);
			venueDetail.setInfoDesc(infoDesc);
			venueDetail.setAddrLine1(addrLine1);
			venueDetail.setAddrLine2(addrLine2);
			venueDetail.setZipCode(zipCode);
			venueDetail.setCity(city);
			venueDetail.setStateId(stateId);
			venueDetail.setCountryId(countryId);
			venueDetail.setLatitude(lattitude);
			venueDetail.setLongitude(longitude);
			venueDetail.setPhone(phone);
			venueDetail.setWebsite(website);
			venueDetail.setCost(cost);
			venueDetail.setHoursOfOperation(hoursOfOperation);
			
			Date now = new Date();
			venueDetail.setCompanyId(serviceContext.getCompanyId());
		    venueDetail.setUserId(serviceContext.getGuestOrUserId());
		    venueDetail.setCreatedDate(serviceContext.getCreateDate(now));
		    venueDetail.setModifiedDate(serviceContext.getModifiedDate(now));
		    
			venueDetail = VenueDetailLocalServiceUtil.addVenueDetail(venueDetail);
			
		}catch(Exception ex){
			LOGGER.error("Exception in addVenueDetail: " + ex.getMessage());
		}
		return venueDetail;
	}
	
	@Override
	public VenueDetail updateVenueDetail(long venueDetailId , long infoTypeId, long infoTypeCategoryId, 
		String infoTitle, String infoDesc, String addrLine1, String addrLine2, String zipCode,
		String city, long stateId, long countryId, 
		String lattitude, String longitude, String phone, String website, Double cost, String hoursOfOperation,
		ServiceContext  serviceContext){
		VenueDetail venueDetail=null;
		try{
			venueDetail= VenueDetailLocalServiceUtil.getVenueDetail(venueDetailId);
			venueDetail.setInfoTypeId(infoTypeId);
			venueDetail.setInfoTypeCategoryId(infoTypeCategoryId);
			venueDetail.setInfoTitle(infoTitle);
			venueDetail.setInfoDesc(infoDesc);
			venueDetail.setAddrLine1(addrLine1);
			venueDetail.setAddrLine2(addrLine2);
			venueDetail.setZipCode(zipCode);
			venueDetail.setCity(city);
			venueDetail.setStateId(stateId);
			venueDetail.setCountryId(countryId);
			venueDetail.setLatitude(lattitude);
			venueDetail.setLongitude(longitude);
			venueDetail.setPhone(phone);
			venueDetail.setWebsite(website);
			venueDetail.setCost(cost);
			venueDetail.setHoursOfOperation(hoursOfOperation);
			
			Date now = new Date();
			venueDetail.setUserId(serviceContext.getGuestOrUserId());
		    venueDetail.setModifiedDate(serviceContext.getModifiedDate(now));
		    
			venueDetail = VenueDetailLocalServiceUtil.updateVenueDetail(venueDetail);
							
		}catch(Exception ex){
			LOGGER.error("Exception in updateVenueDetail: " + ex.getMessage());
		}
		return venueDetail;
	}
	
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public VenueDetail getVenueDetail(long venueDetailId, ServiceContext  serviceContext){
		VenueDetail venueDetail = null;
		try{
			venueDetail = VenueDetailUtil.fetchByPrimaryKey(venueDetailId);
			venueDetail = FlaskUtil.setNamesForVenueDetail(venueDetail);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return venueDetail;
	}
	
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public List<VenueDetail> getVenueDetails(long venueId, ServiceContext  serviceContext){
		List<VenueDetail> venueDetails = null;
		try{
			venueDetails = VenueDetailUtil.findByVenueId(venueId);
			venueDetails = FlaskUtil.setNamesForVenueDetail(venueDetails);
			
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return venueDetails;
	}

	@Override
	public void deleteVenueDetail(long venueDetailId, ServiceContext  serviceContext){
		try{
			VenueDetailLocalServiceUtil.deleteVenueDetail(venueDetailId);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		
	}
	
	@Override
	public void deleteAllVenueDetails(long venueId, ServiceContext  serviceContext){
		try{
			List<VenueDetail> venueDetails = VenueDetailLocalServiceUtil.getVenueDetails(0, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			for( VenueDetail venueDetail: venueDetails){
				VenueDetailLocalServiceUtil.deleteVenueDetail(venueDetail);
			}
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		
	}
	
	@Override
	public VenueDetailImage addVenueDetailImage(long venueDetailId, String imageTitle,
									String imageDesc, String imageUUID,
									ServiceContext  serviceContext){
		VenueDetailImage venueDetailImage =null;
		try{
			venueDetailImage =VenueDetailImageLocalServiceUtil.createVenueDetailImage(CounterLocalServiceUtil.increment());
			venueDetailImage.setVenueDetailId(venueDetailId);
			venueDetailImage.setImageTitle(imageTitle);
			venueDetailImage.setImageDesc(imageDesc);
			venueDetailImage.setImageUUID(imageUUID);
			
			Date now = new Date();
			venueDetailImage.setCompanyId(serviceContext.getCompanyId());
		    venueDetailImage.setUserId(serviceContext.getGuestOrUserId());
		    venueDetailImage.setCreatedDate(serviceContext.getCreateDate(now));
		    venueDetailImage.setModifiedDate(serviceContext.getModifiedDate(now));
		    
			VenueDetailImageLocalServiceUtil.addVenueDetailImage(venueDetailImage);
			
		}catch(Exception ex){
			LOGGER.error(ex);
		}    
		return venueDetailImage;
	}
	
	@Override
	public VenueDetailImage updateVenueDetailImage(long venueDetailImageId,
									long venueDetailId, String imageTitle,
									String imageDesc, String imagePath,
									ServiceContext  serviceContext){
		VenueDetailImage venueDetailImage =null;
		try{
			venueDetailImage =VenueDetailImageLocalServiceUtil.getVenueDetailImage(venueDetailImageId);
			venueDetailImage.setImageTitle(imageTitle);
			venueDetailImage.setImageDesc(imageDesc);
			venueDetailImage.setImageUUID(imagePath);
			
			Date now = new Date();
			venueDetailImage.setUserId(serviceContext.getGuestOrUserId());
		    venueDetailImage.setModifiedDate(serviceContext.getModifiedDate(now));
		    
			VenueDetailImageLocalServiceUtil.updateVenueDetailImage(venueDetailImage);
			
		}catch(Exception ex){
			LOGGER.error(ex);
		}    
		return venueDetailImage;
	}
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public VenueDetailImage getVenueDetailImage(long venueDetailImageId, ServiceContext  serviceContext){
		VenueDetailImage venueDetailImage = null;
		try{
			venueDetailImage = VenueDetailImageUtil.fetchByPrimaryKey(venueDetailImageId);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return venueDetailImage;
	}
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public List<VenueDetailImage> getVenueDetailImages(long venueDetailId, ServiceContext  serviceContext){
		List<VenueDetailImage> venueDetailImages = null;
		try{
			venueDetailImages = VenueDetailImageUtil.findByVenueDetailId(venueDetailId);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return venueDetailImages;
	}
	
	@Override
	public void deleteVenueDetailImage(long venueDetailImageId,
									ServiceContext  serviceContext){
		try{
			VenueDetailImageLocalServiceUtil.deleteVenueDetailImage(venueDetailImageId);
			
		}catch(Exception ex){
			LOGGER.error(ex);
		}    
	}
	
	@Override
	public void deleteAllVenueDetailImages(long venueDetailId,
									ServiceContext  serviceContext){
		try{
			List<VenueDetailImage> venueDetailImages = VenueDetailImageLocalServiceUtil.getVenueDetailImages(0, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			for(VenueDetailImage venueDetailImage : venueDetailImages){
				VenueDetailImageLocalServiceUtil.deleteVenueDetailImage(venueDetailImage);
			}
			
		}catch(Exception ex){
			LOGGER.error(ex);
		}    
	}
	
	
	private void deleteVenueCascade(long venueId, ServiceContext serviceContext){
		try {
			
			List<VenueDetail> venueDetails = VenueDetailUtil.findByVenueId(venueId);
			
			for (VenueDetail vd: venueDetails){
				
				deleteDetailCascade(vd.getVenueDetailId(), serviceContext);
			}
			deleteAllVenueImages(venueId, serviceContext);
			VenueLocalServiceUtil.deleteVenue(venueId);
		}
		catch (Exception e) {
			LOGGER.error(e);
		}
	}
	
	private void deleteDetailCascade(long venueDetailId, ServiceContext serviceContext){
		try {
			deleteAllVenueDetailImages(venueDetailId, serviceContext);
			deleteVenueDetail(venueDetailId, serviceContext);
		}
		catch (Exception e) {
			LOGGER.error(e);
		}
	}
	
	
}