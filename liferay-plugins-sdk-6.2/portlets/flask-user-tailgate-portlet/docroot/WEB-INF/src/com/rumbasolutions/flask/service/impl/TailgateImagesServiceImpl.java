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

import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.model.TailgateImages;
import com.rumbasolutions.flask.service.TailgateImagesLocalServiceUtil;
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
	public List<TailgateImages> getTailgateImages(long tailgateId, ServiceContext  serviceContext){
		List<TailgateImages> tailgateImages = null;
		try{
			tailgateImages = TailgateImagesUtil.findBytailgateId(tailgateId);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return tailgateImages;
	}
}