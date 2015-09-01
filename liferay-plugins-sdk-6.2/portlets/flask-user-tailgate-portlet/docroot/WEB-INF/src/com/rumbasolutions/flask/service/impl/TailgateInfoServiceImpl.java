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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.model.TailgateInfo;
import com.rumbasolutions.flask.model.impl.TailgateInfoImpl;
import com.rumbasolutions.flask.service.TailgateInfoLocalServiceUtil;
import com.rumbasolutions.flask.service.base.TailgateInfoServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.TailgateInfoUtil;

/**
 * The implementation of the tailgate info remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.TailgateInfoService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author rajeshj
 * @see com.rumbasolutions.flask.service.base.TailgateInfoServiceBaseImpl
 * @see com.rumbasolutions.flask.service.TailgateInfoServiceUtil
 */
public class TailgateInfoServiceImpl extends TailgateInfoServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.TailgateInfoServiceUtil} to access the tailgate info remote service.
	 */
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.UserTailgateServiceUtil} to access the user tailgate remote service.
	 */
	private static Log LOGGER = LogFactoryUtil.getLog(TailgateInfoServiceImpl.class);
	
	public TailgateInfo addTailgateInfo(String tailgateName, String tailgateDescription,long eventId, String eventName,Date tailgateDate,Date startTime, Date endTime, ServiceContext  serviceContext){
		TailgateInfo userTailgate = null;
		try{
		userTailgate = TailgateInfoLocalServiceUtil.createTailgateInfo(CounterLocalServiceUtil.increment());
		userTailgate.setTailgateName(tailgateName);
		userTailgate.setTailgateDescription(tailgateDescription);
		userTailgate.setEventId(eventId);
		userTailgate.setEventName(eventName);
		userTailgate.setTailgateDate(tailgateDate);
		userTailgate.setStartTime(startTime);
		userTailgate.setEndTime(endTime);
		userTailgate.setIsActive(1);
		userTailgate.setIsDelete(0);
		Date now = new Date();
		userTailgate.setCompanyId(serviceContext.getCompanyId());
		userTailgate.setUserId(serviceContext.getGuestOrUserId());
		userTailgate.setCreatedDate(serviceContext.getCreateDate(now));
		userTailgate.setModifiedDate(serviceContext.getModifiedDate(now));
		TailgateInfoLocalServiceUtil.addTailgateInfo(userTailgate);
		
		}catch(Exception ex){
			LOGGER.error("Exception in saving Tailgate: " + ex.getMessage());
		}
		return userTailgate;
		
		}
	
	public List<TailgateInfo> getAllTailgate(){
		List<TailgateInfo> tailgateList = null;
		try{
			tailgateList = TailgateInfoUtil.findAll();
		}catch(Exception ex){
			LOGGER.error("Exception in get All Tailgates : " + ex.getMessage());
			tailgateList = new ArrayList<TailgateInfo>(100);
		}
		return tailgateList;
	}
	
	public List<TailgateInfo> getAllMyTailgate(long userId){
		List<TailgateInfo> tailgateList = null;
		try{
			DynamicQuery tailgateQuery = DynamicQueryFactoryUtil.forClass(TailgateInfoImpl.class);
			tailgateQuery.add(PropertyFactoryUtil.forName("userId").eq(new Long(userId)));
			tailgateList = TailgateInfoLocalServiceUtil.dynamicQuery(tailgateQuery);
			
		}catch(Exception ex){
			LOGGER.error("Exception in get All My Tailgate: " + ex.getMessage());
			tailgateList = new ArrayList<TailgateInfo>(100);
		}
		return tailgateList;
	}
	
	public TailgateInfo getTailgate(int tailgateId){
		TailgateInfo userTailgate = null;
		try{
			userTailgate = TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId);
		}catch(Exception ex){
			LOGGER.error("Exception in get Tailgate: " + ex.getMessage());
			userTailgate = new TailgateInfoImpl();
		}
		return userTailgate;
	}
	
	public TailgateInfo updateTailgateInfo(long tailgateId, String tailgateName, String tailgateDescription,long eventId, String eventName,Date tailgateDate,Date startTime, Date endTime, ServiceContext  serviceContext){
		TailgateInfo userTailgate = null;
		try{
		userTailgate = TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId);
		userTailgate.setTailgateName(tailgateName);
		userTailgate.setTailgateDescription(tailgateDescription);
		userTailgate.setEventId(eventId);
		userTailgate.setEventName(eventName);
		userTailgate.setTailgateDate(tailgateDate);
		userTailgate.setStartTime(startTime);
		userTailgate.setEndTime(endTime);
		Date now = new Date();
		userTailgate.setCompanyId(serviceContext.getCompanyId());
		userTailgate.setUserId(serviceContext.getGuestOrUserId());
		userTailgate.setModifiedDate(serviceContext.getModifiedDate(now));
		TailgateInfoLocalServiceUtil.updateTailgateInfo(userTailgate);
		
		}catch(Exception ex){
			LOGGER.error("Exception in updating Tailgate: " + ex.getMessage());
		}
		return userTailgate;
		
		}
	public void deleteTailgateInfo(long tailgateId){
		try{
		TailgateInfoLocalServiceUtil.deleteTailgateInfo(tailgateId);
		}catch(Exception ex){
			LOGGER.error("Exception in deleteiing Tailgate: " + ex.getMessage());
		}
	} 
}