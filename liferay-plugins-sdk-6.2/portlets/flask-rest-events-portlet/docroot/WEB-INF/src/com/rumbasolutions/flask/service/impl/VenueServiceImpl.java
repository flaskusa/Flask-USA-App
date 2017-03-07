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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.rumbasolutions.flask.manageevent.FlaskDocLibUtil;
import com.rumbasolutions.flask.model.Venue;
import com.rumbasolutions.flask.model.VenueDetail;
import com.rumbasolutions.flask.model.VenueDetailImage;
import com.rumbasolutions.flask.model.VenueDeviceImage;
import com.rumbasolutions.flask.model.VenueImage;
import com.rumbasolutions.flask.service.InfoTypeCategoryServiceUtil;
import com.rumbasolutions.flask.service.InfoTypeServiceUtil;
import com.rumbasolutions.flask.service.VenueDetailImageLocalServiceUtil;
import com.rumbasolutions.flask.service.VenueDetailLocalServiceUtil;
import com.rumbasolutions.flask.service.VenueDeviceImageLocalServiceUtil;
import com.rumbasolutions.flask.service.VenueImageLocalServiceUtil;
import com.rumbasolutions.flask.service.VenueLocalServiceUtil;
import com.rumbasolutions.flask.service.VenueServiceUtil;
import com.rumbasolutions.flask.service.VenueSubDetailServiceUtil;
import com.rumbasolutions.flask.service.base.VenueServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.VenueDetailImageUtil;
import com.rumbasolutions.flask.service.persistence.VenueDetailUtil;
import com.rumbasolutions.flask.service.persistence.VenueDeviceImageUtil;
import com.rumbasolutions.flask.service.persistence.VenueImageUtil;
import com.rumbasolutions.flask.service.persistence.VenueSubDetailUtil;
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
	public static final String _venueRootFolder = "Venue";
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
	
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public Venue getVenue(long venueId, ServiceContext  serviceContext){
		Venue venue= null;
		try {
			venue =  VenueUtil.fetchByPrimaryKey(venueId);
			venue = FlaskUtil.setVenueStringValues(venue);
		} catch (SystemException e) {
			LOGGER.error("Error in get venue:" + e.getMessage());
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
	public VenueImage addVenueImage(long venueId, String title, String venueImageUUID, long groupId, ServiceContext  serviceContext){
		VenueImage venueImage = null;
		try{
			venueImage = VenueImageLocalServiceUtil.createVenueImage(CounterLocalServiceUtil.increment());
			venueImage.setVenueId(venueId);	
			venueImage.setTitle(title);
			venueImage.setVenueImageUUId(venueImageUUID);
			venueImage.setVenueImageGroupId(groupId);
			
			Date now = new Date();
			venueImage.setCompanyId(serviceContext.getCompanyId());
		    venueImage.setUserId(serviceContext.getGuestOrUserId());
		    venueImage.setCreatedDate(serviceContext.getCreateDate(now));
		    venueImage.setModifiedDate(serviceContext.getModifiedDate(now));
		    
		    venueImage = VenueImageLocalServiceUtil.addVenueImage(venueImage);
			
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return venueImage;
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
		String infoTitle, String infoShortDesc, String infoDesc, String addrLine1, String addrLine2, String zipCode,
		String city, long stateId, long countryId, String latitude, 
		String longitude, String phone, String mobileAppName, String website, 
		Double cost, String hoursOfOperation, String venueSubDetails, ServiceContext  serviceContext){
		VenueDetail venueDetail=null;
		try{
			
			venueDetail= VenueDetailLocalServiceUtil.createVenueDetail(CounterLocalServiceUtil.increment());
			venueDetail.setVenueId(venueId);
			venueDetail.setInfoTypeId(infoTypeId);
			venueDetail.setInfoTypeName(InfoTypeServiceUtil.getInfoType(infoTypeId, serviceContext).getInfoTypeName());
			venueDetail.setInfoTypeCategoryId(infoTypeCategoryId);
			venueDetail.setInfoTypeCategoryName(InfoTypeCategoryServiceUtil.getInfoTypeCategory(infoTypeCategoryId, serviceContext).getInfoTypeCategoryName());
			venueDetail.setInfoTitle(infoTitle);
			venueDetail.setInfoShortDesc(infoShortDesc);
			venueDetail.setInfoDesc(infoDesc);
			venueDetail.setAddrLine1(addrLine1);
			venueDetail.setAddrLine2(addrLine2);
			venueDetail.setZipCode(zipCode);
			venueDetail.setCity(city);
			venueDetail.setStateId(stateId);
			venueDetail.setCountryId(countryId);
			venueDetail.setLatitude(latitude);
			venueDetail.setLongitude(longitude);
			venueDetail.setPhone(phone);
			venueDetail.setMobileAppName(mobileAppName);
			venueDetail.setWebsite(website);
			venueDetail.setCost(cost);
			venueDetail.setHoursOfOperation(hoursOfOperation);
			
			Date now = new Date();
			venueDetail.setCompanyId(serviceContext.getCompanyId());
		    venueDetail.setUserId(serviceContext.getGuestOrUserId());
		    venueDetail.setCreatedDate(serviceContext.getCreateDate(now));
		    venueDetail.setModifiedDate(serviceContext.getModifiedDate(now));
			venueDetail = VenueDetailLocalServiceUtil.addVenueDetail(venueDetail);
			VenueSubDetailServiceUtil.addVenueSubDetailsByJsonArray(venueDetail.getVenueDetailId(), venueSubDetails);
		}catch(Exception ex){
			LOGGER.error("Exception in addVenueDetail: " + ex.getMessage());
		}
		return venueDetail;
	}
	
	@Override
	public VenueDetail updateVenueDetail(long venueDetailId , long infoTypeId, long infoTypeCategoryId, 
		String infoTitle, String infoShortDesc, String infoDesc, String addrLine1, String addrLine2, String zipCode,
		String city, long stateId, long countryId, 
		String latitude, String longitude, String phone, 
		String mobileAppName, String website, Double cost, String hoursOfOperation, String venueSubDetails,
		ServiceContext  serviceContext){
		VenueDetail venueDetail=null;
		try{
			venueDetail= VenueDetailLocalServiceUtil.getVenueDetail(venueDetailId);
			venueDetail.setInfoTypeId(infoTypeId);
			venueDetail.setInfoTypeName(InfoTypeServiceUtil.getInfoType(infoTypeId, serviceContext).getInfoTypeName());
			venueDetail.setInfoTypeCategoryId(infoTypeCategoryId);
			venueDetail.setInfoTypeCategoryName(InfoTypeCategoryServiceUtil.getInfoTypeCategory(infoTypeCategoryId, serviceContext).getInfoTypeCategoryName());
			venueDetail.setInfoTitle(infoTitle);
			venueDetail.setInfoShortDesc(infoShortDesc);
			venueDetail.setInfoDesc(infoDesc);
			venueDetail.setAddrLine1(addrLine1);
			venueDetail.setAddrLine2(addrLine2);
			venueDetail.setZipCode(zipCode);
			venueDetail.setCity(city);
			venueDetail.setStateId(stateId);
			venueDetail.setCountryId(countryId);
			venueDetail.setLatitude(latitude);
			venueDetail.setLongitude(longitude);
			venueDetail.setPhone(phone);
			venueDetail.setMobileAppName(mobileAppName);
			venueDetail.setWebsite(website);
			venueDetail.setCost(cost);
			venueDetail.setHoursOfOperation(hoursOfOperation);
			
			Date now = new Date();
			venueDetail.setUserId(serviceContext.getGuestOrUserId());
		    venueDetail.setModifiedDate(serviceContext.getModifiedDate(now));
			venueDetail = VenueDetailLocalServiceUtil.updateVenueDetail(venueDetail);
			try{
				VenueSubDetailUtil.removeByVenueDetailId(venueDetailId);
			}finally{
				VenueSubDetailServiceUtil.addVenueSubDetailsByJsonArray(venueDetailId, venueSubDetails);
			}
			
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
			VenueSubDetailUtil.removeByVenueDetailId(venueDetailId);
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
									String imageDesc, String imageUUID, long groupId,
									ServiceContext  serviceContext){
		VenueDetailImage venueDetailImage =null;
		try{
			venueDetailImage =VenueDetailImageLocalServiceUtil.createVenueDetailImage(CounterLocalServiceUtil.increment());
			venueDetailImage.setVenueDetailId(venueDetailId);
			venueDetailImage.setImageTitle(imageTitle);
			venueDetailImage.setImageDesc(imageDesc);
			venueDetailImage.setImageUUID(imageUUID);
			venueDetailImage.setImageGroupId(groupId);
			
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
									String imageDesc, String imageUUID, long groupId,
									ServiceContext  serviceContext){
		VenueDetailImage venueDetailImage =null;
		try{
			venueDetailImage =VenueDetailImageLocalServiceUtil.getVenueDetailImage(venueDetailImageId);
			venueDetailImage.setImageTitle(imageTitle);
			venueDetailImage.setImageDesc(imageDesc);
			venueDetailImage.setImageUUID(imageUUID);
			venueDetailImage.setImageGroupId(groupId);
			
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
	
	@AccessControlled(guestAccessEnabled = true)
	@Override
	public JSONObject getVenueDetailsWithImages(long venueId, ServiceContext  serviceContext){
		return VenueLocalServiceUtil.getVenueDetailsWithImages(venueId);
	}
	
	@AccessControlled(guestAccessEnabled = true)
	@Override
	public JSONObject copyVenueDetailsWithImages(long sourceVenueId, long destinationVenueId, long infoTypeCategoryId, ServiceContext serviceContext){
		List<VenueDetail> sourceVenueDetails = null;
		List<VenueDetail> destinationVenueDetails = null;
		JSONObject destinationObject = null;
		try {
			destinationVenueDetails = VenueDetailUtil.findByVenueId(destinationVenueId);
			sourceVenueDetails = VenueDetailUtil.findByVenueId(sourceVenueId);
			if(destinationVenueDetails.isEmpty()){
				for(VenueDetail srcDetail: sourceVenueDetails){
					long srcDetailId = srcDetail.getVenueDetailId();
					VenueDetail tempDetail = srcDetail;
					if(tempDetail.getInfoTypeCategoryId()==infoTypeCategoryId){
						tempDetail.setVenueId(destinationVenueId);
						tempDetail.setVenueDetailId(CounterLocalServiceUtil.increment());
						VenueDetail destVenueDetail = VenueDetailLocalServiceUtil.addVenueDetail(tempDetail);
						addFileEntry(destinationVenueId, srcDetailId, destVenueDetail, serviceContext);
					}
				}
			}else{
				for(VenueDetail srcDetail: sourceVenueDetails){
					long srcDetailId = srcDetail.getVenueDetailId();
					VenueDetail tempDetail = srcDetail;
					if(tempDetail.getInfoTypeCategoryId()==infoTypeCategoryId){
						boolean updated = false;
						for(VenueDetail destDetail: destinationVenueDetails){
							if(tempDetail.getInfoTitle().equals(destDetail.getInfoTitle()) && tempDetail.getInfoTypeCategoryId()==destDetail.getInfoTypeCategoryId()){
								tempDetail.setVenueId(destinationVenueId);
								tempDetail.setVenueDetailId(destDetail.getVenueDetailId());
								VenueDetail destVenueDetail = VenueDetailLocalServiceUtil.updateVenueDetail(tempDetail);
								addFileEntry(destinationVenueId, srcDetailId, destVenueDetail, serviceContext);
								updated = true;
							}
						}
						if(!updated){
							tempDetail.setVenueId(destinationVenueId);
							tempDetail.setVenueDetailId(CounterLocalServiceUtil.increment());
							VenueDetail destVenueDetail = VenueDetailLocalServiceUtil.addVenueDetail(tempDetail);
							addFileEntry(destinationVenueId, srcDetailId, destVenueDetail, serviceContext);
						}
					}
				}	
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}finally{
			destinationObject = VenueServiceUtil.getVenueDetailsWithImages(destinationVenueId, serviceContext);
		}
		return destinationObject;
	}
	
	public void addFileEntry(long destinationVenueId, long srcVenueDetailId, VenueDetail destVenueDetail, ServiceContext serviceContext){
		FileEntry fileEntry = null;
		try {
			Folder venueDetailFolder = null;
			try {
				venueDetailFolder = FlaskDocLibUtil.createVenueContentTypeFolder(destinationVenueId, destVenueDetail.getVenueDetailId(), serviceContext);
			} catch (Exception e) {
				venueDetailFolder = FlaskDocLibUtil.createVenueContentTypeFolder(destinationVenueId, destVenueDetail.getVenueDetailId(), serviceContext);
			}finally{
				List<VenueDetailImage> srcDetailImages = VenueDetailImageUtil.findByVenueDetailId(srcVenueDetailId);
				for(VenueDetailImage srcDetailImg: srcDetailImages){
					FileEntry tempFile = DLAppLocalServiceUtil.getFileEntryByUuidAndGroupId(srcDetailImg.getImageUUID(), srcDetailImg.getImageGroupId());
					File file = DLFileEntryLocalServiceUtil.getFile(serviceContext.getUserId(), tempFile.getFileEntryId(), tempFile.getVersion(), false);
					fileEntry = FlaskDocLibUtil.addFileEntry(venueDetailFolder,
							srcDetailImg.getImageTitle(),
							srcDetailImg.getImageTitle(),
							srcDetailImg.getImageDesc(),
							file, tempFile.getMimeType(), serviceContext);
					if(fileEntry!=null)
						addVenueDetailImage(destVenueDetail.getVenueDetailId(),fileEntry.getTitle(),fileEntry.getDescription(),fileEntry.getUuid(),fileEntry.getGroupId(), serviceContext);
				}
			}
		} catch (Exception e) {
			LOGGER.error(e);
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
	
	@Override
	public VenueDeviceImage addVenueDeviceImage(long venueDetailImageId, long venueId, String deviceType, String venueDeviceImageUUID, String aspectRatio){
		VenueDeviceImage venueDeviceImage = null;
		try{
			venueDeviceImage = VenueDeviceImageLocalServiceUtil.createVenueDeviceImage(CounterLocalServiceUtil.increment());
			venueDeviceImage.setVenueDetailImageId(venueDetailImageId);
			venueDeviceImage.setVenueId(venueId);	
			venueDeviceImage.setDeviceType(deviceType);
			venueDeviceImage.setVenueDeviceImageUUID(venueDeviceImageUUID);
			venueDeviceImage.setAspectRatio(aspectRatio);
			venueDeviceImage =VenueDeviceImageLocalServiceUtil.addVenueDeviceImage(venueDeviceImage);
		}catch(Exception ex){
			LOGGER.error("Error in addVenueDeviceImage:" +ex);
		}
		return venueDeviceImage;
	}
	
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public List<VenueDeviceImage> getVenueDeviceImagesByVenueId(long venueId){
			List<VenueDeviceImage>  venueDeviceImages = new ArrayList<VenueDeviceImage>();
			try {
				venueDeviceImages =  VenueDeviceImageUtil.findByVenueId(venueId);
			}
			catch (SystemException e) {
				LOGGER.error("Error in getVenueDeviceImagesByVenueId:" + e );
			}
			return venueDeviceImages;
	}
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public List<VenueDeviceImage> getVenueDeviceImagesByDeviceType(String deviceType){
			List<VenueDeviceImage>  venueDeviceImages = new ArrayList<VenueDeviceImage>();
			try {
				venueDeviceImages =  VenueDeviceImageUtil.findByDeviceType(deviceType);
			}
			catch (SystemException e) {
				LOGGER.error("Error in getVenueDeviceImagesByDeviceType:" + e );
			}
			return venueDeviceImages;
	}
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public List<VenueImage> getVenueImagesByVenueIdAndDeviceType(long venueId, String deviceType, ServiceContext serviceContext){
		List<VenueImage> venueImages = new ArrayList<VenueImage>();
		try {
			List<VenueDeviceImage>  venueDeviceImages =  VenueDeviceImageUtil.findByVenueDevice(venueId, deviceType);
			for(VenueDeviceImage img: venueDeviceImages){
				venueImages.add(VenueServiceUtil.getVenueImage(img.getVenueDetailImageId(), serviceContext));
			}
		}
		catch (SystemException e) {
			LOGGER.error("Error in getVenueDeviceImagesByVenueDevice:" + e.getMessage());
		}
		return venueImages;
	}
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public VenueDeviceImage getVenueDeviceImage(long venueDeviceImageId){
		VenueDeviceImage  venueDeviceImage = null;
			try {
				venueDeviceImage = VenueDeviceImageUtil.findByPrimaryKey(venueDeviceImageId);
			}
			catch (Exception e) {
				LOGGER.error("Error in getVenueDeviceImage:" + e );
			}
			return venueDeviceImage;
	}
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public List<VenueDeviceImage> getAllVenueDeviceImages(){
		List<VenueDeviceImage>  venueDeviceImages = new ArrayList<VenueDeviceImage>();
			try {
				venueDeviceImages = VenueDeviceImageUtil.findAll();
			}
			catch (Exception e) {
				LOGGER.error("Error in getVenueDeviceImage:" + e );
			}
			return venueDeviceImages;
	}
	
	@Override
	public VenueDeviceImage updateVenueDeviceImage(long venueImageDeviceId, long venueDetailImageId, long venueId, String deviceType, String venueDeviceImageUUID, String aspectRatio){
		VenueDeviceImage venueDeviceImage = null;
		try{
			venueDeviceImage = VenueDeviceImageLocalServiceUtil.getVenueDeviceImage(venueImageDeviceId);
			venueDeviceImage.setVenueDetailImageId(venueDetailImageId);
			venueDeviceImage.setVenueId(venueId);	
			venueDeviceImage.setDeviceType(deviceType);
			venueDeviceImage.setVenueDeviceImageUUID(venueDeviceImageUUID);
			venueDeviceImage.setAspectRatio(aspectRatio);
			venueDeviceImage =VenueDeviceImageLocalServiceUtil.updateVenueDeviceImage(venueDeviceImage);
		}catch(Exception ex){
			LOGGER.error("Error in updateVenueDeviceImage:" +ex);
		}
		return venueDeviceImage;
	}
	@Override
	public void deleteVenueDeviceImage(long venueDeviceImageId){
		try{
			VenueDeviceImageLocalServiceUtil.deleteVenueDeviceImage(venueDeviceImageId);
		}catch(Exception ex){
			LOGGER.error("Error in deleteVenueDeviceImage:" +ex);
		}
	}
	@Override
	@AccessControlled(guestAccessEnabled =true)
	public VenueImage uploadDeviceImage(File file, long venueId, String deviceType, String aspectRatio, ServiceContext serviceContext){
		VenueImage venueImage = null;
		try {
			Path source = Paths.get(file.getName());
			String mimeType = Files.probeContentType(source);
			long repositoryId = FlaskUtil.getFlaskRepositoryId();
			long userId = serviceContext.getUserId();
			String name = venueId +"_"+ file.getName();
			Folder folder = FlaskUtil.getOrCreateFolder(_venueRootFolder, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, repositoryId, userId, serviceContext);
			String venueFolderName = folder.getName()+"-"+venueId;
			Folder venueFolder = FlaskUtil.getOrCreateFolder(venueFolderName, folder.getFolderId(), folder.getRepositoryId(), userId, serviceContext);
			FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), venueFolder.getRepositoryId(), venueFolder.getFolderId(), name, mimeType, name, name, "", file, serviceContext);
			FlaskUtil.setGuestViewPermission(fileEntry);
			venueImage = VenueServiceUtil.addVenueImage(venueId, name, fileEntry.getUuid(), fileEntry.getGroupId(), serviceContext);
			VenueServiceUtil.addVenueDeviceImage(venueImage.getVenueImageId(), venueId, deviceType, venueImage.getVenueImageUUId(), aspectRatio);
		} catch (Exception e) {
			LOGGER.error("Exception in uploadDetailImage: "+e);
		}
		return venueImage;
	}
}