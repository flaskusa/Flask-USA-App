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

package com.liferay.contacts.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.contacts.model.DeviceAwsEndpoint;
import com.liferay.contacts.model.FlaskUserDeviceRegistration;
import com.liferay.contacts.service.DeviceAwsEndpointLocalServiceUtil;
import com.liferay.contacts.service.FlaskUserDeviceRegistrationLocalServiceUtil;
import com.liferay.contacts.service.FlaskUserDeviceRegistrationServiceUtil;
import com.liferay.contacts.service.base.FlaskUserDeviceRegistrationServiceBaseImpl;
import com.liferay.contacts.service.persistence.DeviceAwsEndpointUtil;
import com.liferay.contacts.service.persistence.FlaskUserDeviceRegistrationUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the flask user device registration remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contacts.service.FlaskUserDeviceRegistrationService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contacts.service.base.FlaskUserDeviceRegistrationServiceBaseImpl
 * @see com.liferay.contacts.service.FlaskUserDeviceRegistrationServiceUtil
 */
public class FlaskUserDeviceRegistrationServiceImpl
	extends FlaskUserDeviceRegistrationServiceBaseImpl {

     private static Log LOGGER = LogFactoryUtil.getLog(FlaskUserDeviceRegistrationServiceImpl.class);
	
     @Override
     public FlaskUserDeviceRegistration addUserDevice(long userId, String userEmail, String devicePlatform, 
    		 String deviceDetails, String deviceToken, Date registrationTime, Boolean active, 
    		 Date lastNotificationTime, String lastNotificationMsg, ServiceContext  serviceContext){
 		FlaskUserDeviceRegistration flaskUserDeviceRegistration = null;
 		try{
 			List<FlaskUserDeviceRegistration> flaskUser = FlaskUserDeviceRegistrationServiceUtil.getUserDevicesByUserId(userId);
 			if(flaskUser.isEmpty()){
	 			flaskUserDeviceRegistration = FlaskUserDeviceRegistrationLocalServiceUtil.createFlaskUserDeviceRegistration(CounterLocalServiceUtil.increment());
	 			flaskUserDeviceRegistration.setUserId(userId);
	 			flaskUserDeviceRegistration.setUserEmail(userEmail);
	 			flaskUserDeviceRegistration.setDevicePlatform(devicePlatform);
	 			flaskUserDeviceRegistration.setDeviceDetails(deviceDetails);
	 			flaskUserDeviceRegistration.setDeviceToken(deviceToken);
	 			flaskUserDeviceRegistration.setRegistrationTime(registrationTime);
	 			flaskUserDeviceRegistration.setActive(active);
	 			flaskUserDeviceRegistration.setLastNotificationTime(lastNotificationTime);
	 			flaskUserDeviceRegistration.setLastNotificationMsg(lastNotificationMsg);
	 			flaskUserDeviceRegistration = FlaskUserDeviceRegistrationLocalServiceUtil.addFlaskUserDeviceRegistration(flaskUserDeviceRegistration);
 			}else{
 				flaskUserDeviceRegistration = FlaskUserDeviceRegistrationServiceUtil.updateUserDevices(flaskUser.get(0).getUserDeviceRegistrationId(), userId, 
 						userEmail, devicePlatform, deviceDetails, deviceToken, registrationTime, active, lastNotificationTime, lastNotificationMsg, serviceContext);
 			}
 		}catch(Exception e){
 			LOGGER.error("Exception in Registraing User Device: " + e.getMessage());
 		}
 		System.out.println(flaskUserDeviceRegistration);
 		return flaskUserDeviceRegistration;
 	}
     
     @Override
     public List<FlaskUserDeviceRegistration> getAllUserDevices(){
    	 List<FlaskUserDeviceRegistration> flaskUserDeviceRegistrationList = null;
    	 try{
    		 flaskUserDeviceRegistrationList = FlaskUserDeviceRegistrationUtil.findAll();
    	 }catch(Exception e){
    		 LOGGER.error("Exception in Get All Registred User Device: " + e.getMessage());
    	 }
    	 return flaskUserDeviceRegistrationList;
     }
     
     @Override
     public FlaskUserDeviceRegistration getUserDevice(long userDeviceRegistrationId){
    	 FlaskUserDeviceRegistration flaskUserDeviceRegistration =null;
    	 try{
    		 flaskUserDeviceRegistration = FlaskUserDeviceRegistrationLocalServiceUtil.getFlaskUserDeviceRegistration(userDeviceRegistrationId);
    	 }catch(Exception e){
    		 LOGGER.error("Exception in Get Registred User Device: " + e.getMessage());
    	 }
    	 return flaskUserDeviceRegistration;
     }
     
     @Override
     public List<FlaskUserDeviceRegistration> getUserDevicesByUserId(long userId){
    	 List<FlaskUserDeviceRegistration> flaskUserDeviceRegistration =null;
    	 try{
    		 flaskUserDeviceRegistration = FlaskUserDeviceRegistrationUtil.findByUserId(userId);
    	 }catch(Exception e){
    		 LOGGER.error("Exception in Get Registred User Device By userId: " + e.getMessage());
    	 }
    	 return flaskUserDeviceRegistration;
     }
     
     @Override
     public List<FlaskUserDeviceRegistration> getUserDevicesByUserEmail(String userEmail){
    	 List<FlaskUserDeviceRegistration> flaskUserDeviceRegistration =null;
    	 try{
    		 flaskUserDeviceRegistration = FlaskUserDeviceRegistrationUtil.findByuserEmail(userEmail);
    	 }catch(Exception e){
    		 LOGGER.error("Exception in Get Registred User Device By userEmail: " + e.getMessage());
    	 }
    	 return flaskUserDeviceRegistration;
     }
     
     @Override
     public List<FlaskUserDeviceRegistration> getUserDevicesByDeviceToken(String deviceToken){
    	 List<FlaskUserDeviceRegistration> flaskUserDeviceRegistration =null;
    	 try{
    		 flaskUserDeviceRegistration = FlaskUserDeviceRegistrationUtil.findBydeviceToken(deviceToken);
    	 }catch(Exception e){
    		 LOGGER.error("Exception in Get Registred User Device By deviceToken: " + e.getMessage());
    	 }
    	 return flaskUserDeviceRegistration;
     }
     
     @Override
     public FlaskUserDeviceRegistration updateUserDevices(long userDeviceRegistrationId, long userId, String userEmail, 
    		 String devicePlatform, String deviceDetails, String deviceToken, Date registrationTime, Boolean active, 
    		 Date lastNotificationTime, String lastNotificationMsg, ServiceContext  serviceContext){
 		FlaskUserDeviceRegistration flaskUserDeviceRegistration = null;
 		try{
 			flaskUserDeviceRegistration = FlaskUserDeviceRegistrationLocalServiceUtil.getFlaskUserDeviceRegistration(userDeviceRegistrationId);
 			flaskUserDeviceRegistration.setUserId(userId);
 			flaskUserDeviceRegistration.setUserEmail(userEmail);
 			flaskUserDeviceRegistration.setDevicePlatform(devicePlatform);
 			flaskUserDeviceRegistration.setDeviceDetails(deviceDetails);
 			flaskUserDeviceRegistration.setDeviceToken(deviceToken);
 			flaskUserDeviceRegistration.setRegistrationTime(registrationTime);
 			flaskUserDeviceRegistration.setActive(active);
 			flaskUserDeviceRegistration.setLastNotificationTime(lastNotificationTime);
 			flaskUserDeviceRegistration.setLastNotificationMsg(lastNotificationMsg);
 			flaskUserDeviceRegistration = FlaskUserDeviceRegistrationLocalServiceUtil.updateFlaskUserDeviceRegistration(flaskUserDeviceRegistration);
 		}catch(Exception e){
 			LOGGER.error("Exception in Update Registr User Device: " + e.getMessage());
 		}
 		return flaskUserDeviceRegistration;
 	}
     
     @Override
     public void deleteUserDevice(long userDeviceRegistrationId){
    	 try {
			FlaskUserDeviceRegistrationLocalServiceUtil.deleteFlaskUserDeviceRegistration(userDeviceRegistrationId);
			List<DeviceAwsEndpoint> deviceAwsEndpoints = DeviceAwsEndpointUtil.findByendpointsByRegistrationId(userDeviceRegistrationId);
				DeviceAwsEndpointLocalServiceUtil.deleteDeviceAwsEndpoint(deviceAwsEndpoints.get(0));
		}catch (Exception e) {
			LOGGER.error("Exception in Delete Registr User Device: " + e.getMessage());
		}
     }
}