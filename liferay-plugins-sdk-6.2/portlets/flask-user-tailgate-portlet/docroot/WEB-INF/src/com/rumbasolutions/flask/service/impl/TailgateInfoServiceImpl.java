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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.rumbasolutions.flask.model.TailgateInfo;
import com.rumbasolutions.flask.model.TailgateUsers;
import com.rumbasolutions.flask.model.impl.TailgateInfoImpl;
import com.rumbasolutions.flask.model.impl.TailgateUsersImpl;
import com.rumbasolutions.flask.service.TailgateInfoLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateUsersLocalServiceUtil;
import com.rumbasolutions.flask.service.base.TailgateInfoServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.TailgateInfoFinderUtil;
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
	
	public TailgateInfo addTailgateInfo(String tailgateName, String tailgateDescription,long eventId, String eventName,
			Date tailgateDate,long startTime, long endTime, String venmoAccountId, long amountToPay,
			ServiceContext  serviceContext){
		
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
			userTailgate.setVenmoAccountId(venmoAccountId);
			
			userTailgate.setAmountToPay(amountToPay);
			Date now = new Date();
			userTailgate.setCompanyId(serviceContext.getCompanyId());
			userTailgate.setUserId(serviceContext.getUserId());
			userTailgate.setCreatedDate(serviceContext.getCreateDate(now));
			userTailgate.setModifiedDate(serviceContext.getModifiedDate(now));
			TailgateInfoLocalServiceUtil.addTailgateInfo(userTailgate);
			
			TailgateUsers tailgateUser = TailgateUsersLocalServiceUtil.createTailgateUsers(CounterLocalServiceUtil.increment());
			tailgateUser.setIsAdmin(1); //TRUE
			User user = UserLocalServiceUtil.getUser(serviceContext.getUserId());
			
			tailgateUser.setTailgateId(userTailgate.getTailgateId());
			tailgateUser.setUserId(user.getUserId());
			String userName = user.getFirstName() + " " + user.getLastName();
			tailgateUser.setUserName(userName);
			tailgateUser.setIsPaid(false);
			tailgateUser.setPaymentMode("None");
			tailgateUser.setGroupId(0);
			TailgateUsersLocalServiceUtil.addTailgateUsers(tailgateUser);
			
			
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
			tailgateList = TailgateInfoFinderUtil.getAllMyTailgate(userId);
			
		}catch(Exception ex){
			LOGGER.error("Exception in get All My Tailgate: " + ex.getMessage());
			tailgateList = new ArrayList<TailgateInfo>(100);
		}
		return tailgateList;
	}
	
	public List<TailgateInfo> getAllTailgeteByUserId(long userId){
		List<TailgateInfo> tailgateList = null;
		List<TailgateUsers> tailgateList1 = null;
		try{
			DynamicQuery tailgateQuery = DynamicQueryFactoryUtil.forClass(TailgateUsersImpl.class);
			tailgateQuery.add(PropertyFactoryUtil.forName("userId").eq(new Long(userId)));
			tailgateList1 = TailgateUsersLocalServiceUtil.dynamicQuery(tailgateQuery);
			
			for(TailgateUsers info: tailgateList1){
				tailgateList = new ArrayList<TailgateInfo>();
				tailgateList.add(TailgateInfoLocalServiceUtil.getTailgateInfo(info.getTailgateId()));
			}
			
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
	
	public TailgateInfo updateTailgateInfo(long tailgateId, String tailgateName, String tailgateDescription,long eventId, String eventName, 
				Date tailgateDate, long startTime, long endTime, String venmoAccountId, long amountToPay, ServiceContext  serviceContext){
		TailgateInfo userTailgate = null;
		try{
			userTailgate = TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId);
			//make sure user who created the tailgate is the one who can modify it.
			if(serviceContext.getUserId() == userTailgate.getUserId()){
				userTailgate.setTailgateName(tailgateName);
				userTailgate.setTailgateDescription(tailgateDescription);
				userTailgate.setEventId(eventId);
				userTailgate.setEventName(eventName);
				userTailgate.setTailgateDate(tailgateDate);
				userTailgate.setStartTime(startTime);
				userTailgate.setEndTime(endTime);
				userTailgate.setVenmoAccountId(venmoAccountId);
				userTailgate.setAmountToPay(amountToPay);
				Date now = new Date();
				userTailgate.setCompanyId(serviceContext.getCompanyId());
				userTailgate.setUserId(serviceContext.getGuestOrUserId());
				userTailgate.setModifiedDate(serviceContext.getModifiedDate(now));
				TailgateInfoLocalServiceUtil.updateTailgateInfo(userTailgate);
			}else{
				LOGGER.error("updateTailgateInfo user who is not tailgate owner is updating the tailgate info.");
			}
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