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
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.rumbasolutions.flask.managetailgate.FlaskDocLibUtil;
import com.rumbasolutions.flask.model.TailgateImages;
import com.rumbasolutions.flask.service.TailgateImagesLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateImagesServiceUtil;
import com.rumbasolutions.flask.service.TailgateInfoLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateInfoServiceUtil;
import com.rumbasolutions.flask.service.base.TailgateImagesServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.TailgateImagesUtil;

/**
 * The implementation of the tailgate images remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.TailgateImagesService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author rajeshj, Kiran
 * @see com.rumbasolutions.flask.service.base.TailgateImagesServiceBaseImpl
 * @see com.rumbasolutions.flask.service.TailgateImagesServiceUtil
 */
public class TailgateImagesServiceImpl extends TailgateImagesServiceBaseImpl {
	
	String adminRoles[] = {FlaskTailgateUtil.FlaskRoleEnum.FLASK_ADMIN.getRoleName(), FlaskTailgateUtil.FlaskRoleEnum.LIFERAY_ADMIN.getRoleName(),
			FlaskTailgateUtil.FlaskRoleEnum.FLASK_CONTENT_ADMIN.getRoleName() };
	private static Log LOGGER = LogFactoryUtil.getLog(TailgateImagesServiceImpl.class);
	
	@Override
	public TailgateImages addTailgateImage(long tailgateId, String imageTitle,
									String imageDesc, String imageUUID, long imageGroupId,
									ServiceContext  serviceContext){
		TailgateImages tailgateImage =null;
		try{
			tailgateImage = TailgateImagesLocalServiceUtil.createTailgateImages(CounterLocalServiceUtil.increment());
			tailgateImage.setTailgateId(tailgateId);
			tailgateImage.setImageTitle(imageTitle);
			tailgateImage.setImageDesc(imageDesc);
			tailgateImage.setImageUUID(imageUUID);
			tailgateImage.setImageGroupId(imageGroupId);
			
			Date now = new Date();
			tailgateImage.setUserId(serviceContext.getGuestOrUserId());
		    tailgateImage.setCreatedDate(serviceContext.getCreateDate(now));
		    tailgateImage.setModifiedDate(serviceContext.getModifiedDate(now));
		    TailgateImagesLocalServiceUtil.addTailgateImages(tailgateImage);
			
		}catch(Exception ex){
			LOGGER.error(ex);
		}    
		return tailgateImage;
	}
	
	@Override
	public TailgateImages updateTailgateImage(long tailgateImageId,
									String imageTitle,
									String imageDesc,
									ServiceContext  serviceContext){
		TailgateImages tailgateImage=null;
		try{
			tailgateImage = TailgateImagesLocalServiceUtil.getTailgateImages(tailgateImageId);
			tailgateImage.setImageTitle(imageTitle);
			tailgateImage.setImageDesc(imageDesc);
			tailgateImage.setImageUUID(tailgateImage.getImageUUID());
			tailgateImage.setImageGroupId(tailgateImage.getImageGroupId());
			
			Date now = new Date();
			tailgateImage.setUserId(serviceContext.getGuestOrUserId());
			tailgateImage.setModifiedDate(serviceContext.getModifiedDate(now));

		    
			TailgateImagesLocalServiceUtil.updateTailgateImages(tailgateImage);
			
		}catch(Exception ex){
			LOGGER.error(ex);
		}    
		return tailgateImage;
	}
	
	@Override
	public void deleteTailgateImageByTailgateImageId(long tailgateImageId,
									ServiceContext  serviceContext){
		try{
			TailgateImagesLocalServiceUtil.deleteTailgateImages(tailgateImageId);
			
		}catch(Exception ex){
			LOGGER.error(ex);
		}    
	}
	
	@Override
	public void deleteTailgateImageByTailgateId(long tailgateId,
									ServiceContext  serviceContext){
		try{
			List<TailgateImages> images = TailgateImagesUtil.findBytailgateId(tailgateId);
			for(TailgateImages tailgate: images){
				TailgateImagesUtil.removeBytailgateId(tailgate.getTailgateId());
			}

		}catch(Exception ex){
			LOGGER.error(ex);
		}    
	}
	
	@Override
	public void deleteTailgateImageByUUID(String imageUUID,
									ServiceContext  serviceContext){
		try{
			List<TailgateImages> images = TailgateImagesUtil.findByimageUUID(imageUUID);
			for(TailgateImages tailgate: images){
				TailgateImagesUtil.removeBytailgateId(tailgate.getTailgateId());
			}

		}catch(Exception ex){
			LOGGER.error(ex);
		}    
	}
	
	@Override
	public List<TailgateImages> getTailgateImages(long tailgateId, ServiceContext  serviceContext){
		List<TailgateImages> tailgateImages = null;
		try{
			tailgateImages = TailgateImagesUtil.findBytailgateId(tailgateId);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return tailgateImages;
	}
	
	@Override
	public FileEntry uploadTailgateImage(File file, long tailgateId, ServiceContext serviceContext){
		FileEntry fileEntry = null;
		try {
			if(FlaskTailgateUtil.isTailgateAdmin(tailgateId, serviceContext)){
				Path source = Paths.get(file.getName());
				String mimeType = Files.probeContentType(source);
				long repositoryId = FlaskDocLibUtil.getFlaskRepositoryId();
				long userId = serviceContext.getUserId();
				String name = tailgateId +"_"+ file.getName();
				Folder folder = FlaskDocLibUtil.getOrCreateFolder(FlaskDocLibUtil._tailgateRootFolder, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, repositoryId, userId, serviceContext);
				String eventFolderName = folder.getName()+"-"+tailgateId;
				Folder tailgateFolder = FlaskDocLibUtil.getOrCreateFolder(eventFolderName, folder.getFolderId(), folder.getRepositoryId(), folder.getUserId(), serviceContext);
				fileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), tailgateFolder.getRepositoryId(), tailgateFolder.getFolderId(), name, mimeType, name, name, "", file, serviceContext);
				TailgateImagesServiceUtil.addTailgateImage(tailgateId, name, name, fileEntry.getUuid(), fileEntry.getGroupId(), serviceContext);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileEntry;
	}
	
	@Override
	public FileEntry uploadTailgateLogo(File file, long tailgateId, ServiceContext serviceContext){
		FileEntry fileEntry = null;
		try {
			boolean admin = false;
			try{
				if(tailgateId>0){
					admin = TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId).getUserId()==serviceContext.getUserId();
				}else{
					admin = FlaskTailgateUtil.isUserAdmin(serviceContext.getUserId(), adminRoles);
				}
			}finally{
				if(admin){
					Path source = Paths.get(file.getName());
					String mimeType = Files.probeContentType(source);
					long repositoryId = FlaskDocLibUtil.getFlaskRepositoryId();
					long userId = serviceContext.getUserId();
					String name = CounterLocalServiceUtil.increment() +"_"+ file.getName();
					Folder folder = FlaskDocLibUtil.getOrCreateFolder(FlaskDocLibUtil._tailgateRootFolder, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, repositoryId, userId, serviceContext);
					Folder logoFolder = FlaskDocLibUtil.getOrCreateFolder(FlaskDocLibUtil._tailgateLogosFolder, folder.getFolderId(), folder.getRepositoryId(), folder.getUserId(), serviceContext);
					fileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), logoFolder.getRepositoryId(), logoFolder.getFolderId(), name, mimeType, name, name, "", file, serviceContext);
					if(tailgateId>0){
						TailgateInfoServiceUtil.updateTailgateLogo(tailgateId, fileEntry.getFileEntryId(), serviceContext);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileEntry;
	}
}