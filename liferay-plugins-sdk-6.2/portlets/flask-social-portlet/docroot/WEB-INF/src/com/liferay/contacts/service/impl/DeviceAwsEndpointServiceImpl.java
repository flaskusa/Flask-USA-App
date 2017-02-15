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

import java.util.List;

import com.liferay.contacts.model.DeviceAwsEndpoint;
import com.liferay.contacts.service.DeviceAwsEndpointLocalServiceUtil;
import com.liferay.contacts.service.base.DeviceAwsEndpointServiceBaseImpl;
import com.liferay.contacts.service.persistence.DeviceAwsEndpointUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the device aws endpoint remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contacts.service.DeviceAwsEndpointService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contacts.service.base.DeviceAwsEndpointServiceBaseImpl
 * @see com.liferay.contacts.service.DeviceAwsEndpointServiceUtil
 */
public class DeviceAwsEndpointServiceImpl
	extends DeviceAwsEndpointServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.contacts.service.DeviceAwsEndpointServiceUtil} to access the device aws endpoint remote service.
	 */
	private static Log LOGGER = LogFactoryUtil.getLog(DeviceAwsEndpointServiceImpl.class);
	
	@Override
    public DeviceAwsEndpoint addDeviceAwsEndpoint(String awsEndpoint, long userDeviceRegistrationId){
    	DeviceAwsEndpoint deviceAwsEndpoint = null;
		try{
			deviceAwsEndpoint = DeviceAwsEndpointLocalServiceUtil.createDeviceAwsEndpoint(CounterLocalServiceUtil.increment());
			deviceAwsEndpoint.setAwsEndpoint(awsEndpoint);
			deviceAwsEndpoint.setUserDeviceRegistrationId(userDeviceRegistrationId);
			deviceAwsEndpoint = DeviceAwsEndpointLocalServiceUtil.addDeviceAwsEndpoint(deviceAwsEndpoint);
		}catch(Exception e){
			LOGGER.error("Exception in add Device Aws Endpoint: " + e.getMessage());
		}
		return deviceAwsEndpoint;
	}
    
	@Override
    public List<DeviceAwsEndpoint> getAllDeviceAwsEndpoint(){
    	List<DeviceAwsEndpoint> deviceAwsEndpoint = null;
    	try{
    		deviceAwsEndpoint = DeviceAwsEndpointUtil.findAll();
    	}catch(Exception e){
    		LOGGER.error("Exception in get all Device Aws Endpoint: " + e.getMessage());
    	}
    	return deviceAwsEndpoint;
    }
    
	@Override
    public DeviceAwsEndpoint getDeviceAwsEndpoint(long deviceEndPointId){
    	DeviceAwsEndpoint deviceAwsEndpoint = null;
    	try{
    		deviceAwsEndpoint = DeviceAwsEndpointLocalServiceUtil.getDeviceAwsEndpoint(deviceEndPointId);
    	}catch(Exception e){
    		LOGGER.error("Exception in get Device Aws Endpoint: " + e.getMessage());
    	}
    	return deviceAwsEndpoint;
    }
    
	@Override
    public List<DeviceAwsEndpoint> getAllDeviceAwsEndpointsByUserDeviceRegistrationId(long userDeviceRegistrationId){
    	List<DeviceAwsEndpoint> deviceAwsEndpoint = null;
    	try{
    		deviceAwsEndpoint = DeviceAwsEndpointUtil.findByendpointsByRegistrationId(userDeviceRegistrationId);
    	}catch(Exception e){
    		LOGGER.error("Exception in get all Device Aws Endpoint by userDeviceRegistrationId: " + e.getMessage());
    	}
    	return deviceAwsEndpoint;
    }
    
	@Override
    public DeviceAwsEndpoint updateDeviceAwsEndpoint(long deviceEndPointId, String awsEndpoint, long userDeviceRegistrationId){
    	DeviceAwsEndpoint deviceAwsEndpoint = null;
		try{
			deviceAwsEndpoint = DeviceAwsEndpointLocalServiceUtil.getDeviceAwsEndpoint(deviceEndPointId);
			deviceAwsEndpoint.setAwsEndpoint(awsEndpoint);
			deviceAwsEndpoint.setUserDeviceRegistrationId(userDeviceRegistrationId);
			deviceAwsEndpoint = DeviceAwsEndpointLocalServiceUtil.updateDeviceAwsEndpoint(deviceAwsEndpoint);
		}catch(Exception e){
			LOGGER.error("Exception in update Device Aws Endpoint: " + e.getMessage());
		}
		return deviceAwsEndpoint;
	}
    
	@Override
    public void deleteDeviceAwsEndpoint(long deviceEndPointId){
    	try{
    		DeviceAwsEndpointLocalServiceUtil.deleteDeviceAwsEndpoint(deviceEndPointId);
    	}catch(Exception e){
    		LOGGER.error("Exception in delete Device Aws Endpoint: " + e.getMessage());
    	}
    }
}