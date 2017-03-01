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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.rumbasolutions.flask.model.TailgateInfo;
import com.rumbasolutions.flask.model.TailgateMarker;
import com.rumbasolutions.flask.model.TailgateUsers;
import com.rumbasolutions.flask.model.impl.TailgateInfoImpl;
import com.rumbasolutions.flask.model.impl.TailgateUsersImpl;
import com.rumbasolutions.flask.service.TailgateInfoLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateMarkerLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateMarkerServiceUtil;
import com.rumbasolutions.flask.service.TailgateMessageBoardServiceUtil;
import com.rumbasolutions.flask.service.TailgateSupplyItemServiceUtil;
import com.rumbasolutions.flask.service.TailgateUsersLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateUsersServiceUtil;
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
public class TailgateInfoServiceImpl extends TailgateInfoServiceBaseImpl{
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
	String adminRoles[] = {FlaskTailgateUtil.FlaskRoleEnum.FLASK_ADMIN.getRoleName(), FlaskTailgateUtil.FlaskRoleEnum.LIFERAY_ADMIN.getRoleName(),
			FlaskTailgateUtil.FlaskRoleEnum.FLASK_CONTENT_ADMIN.getRoleName() };
	private static Log LOGGER = LogFactoryUtil.getLog(TailgateInfoServiceImpl.class);
	
	public TailgateInfo addTailgateInfo(String tailgateName, String tailgateDescription,long eventId, String eventName,
			Date tailgateDate,long startTime, long endTime, String venmoAccountId, double amountToPay, long logoId,
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
			userTailgate.setLogoId(logoId);
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
	
	@Override
	@AccessControlled(guestAccessEnabled =true)
	public FileEntry getTailgateLogo(long tailgateId){
		FileEntry fileEntry=null;	
		try{	
			TailgateInfo tailgateInfo = TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId);
			if(tailgateInfo.getLogoId()>0)
				fileEntry = DLAppLocalServiceUtil.getFileEntry(tailgateInfo.getLogoId());
		}catch(Exception e){
			LOGGER.error("Exception in get Tailgate Logo: " + e.getMessage());
		}
		return fileEntry;
	}
	
	@Override
	public FileEntry updateTailgateLogo(long tailgateId, long logoId, ServiceContext serviceContext){
		FileEntry fileEntry=null;	
		try{
			TailgateInfo tailgateInfo = TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId);
			if(serviceContext.getUserId() == tailgateInfo.getUserId()){
				if(logoId>0){
					tailgateInfo.setLogoId(logoId);
					TailgateInfoLocalServiceUtil.updateTailgateInfo(tailgateInfo);
				}
			}
		}catch(Exception e){
			LOGGER.error("Exception in update Tailgate Logo: " + e.getMessage());
		}
		return fileEntry;
	}
	
	@Override
	public void deleteTailgateLogo(long tailgateId, ServiceContext serviceContext){
		try{
			TailgateInfo tailgateInfo = TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId);
			if(serviceContext.getUserId() == tailgateInfo.getUserId()){
				if(tailgateInfo.getLogoId()>0){
					DLAppLocalServiceUtil.deleteFileEntry(tailgateInfo.getLogoId());
					tailgateInfo.setLogoId(0);
					TailgateInfoLocalServiceUtil.updateTailgateInfo(tailgateInfo);
				}
			}
		}catch(Exception e){
			LOGGER.error("Exception in delete Tailgate Logo: " + e.getMessage());
		}
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
	
	@SuppressWarnings({ "unchecked"})
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
	
	@SuppressWarnings("unchecked")
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
	
	public TailgateInfo copyTailgate(int tailgateId, ServiceContext  serviceContext){
		TailgateInfo userTailgate = null;
		TailgateInfo newUserTailgate = null;
		try{
			userTailgate = TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId);
			newUserTailgate = TailgateInfoLocalServiceUtil.createTailgateInfo(CounterLocalServiceUtil.increment());
			newUserTailgate.setTailgateName("Copy of "+ userTailgate.getTailgateName());
			newUserTailgate.setTailgateDescription(userTailgate.getTailgateDescription());
			newUserTailgate.setEventId(userTailgate.getEventId());
			newUserTailgate.setEventName(userTailgate.getEventName());
			newUserTailgate.setTailgateDate(userTailgate.getTailgateDate());
			newUserTailgate.setStartTime(userTailgate.getStartTime());
			newUserTailgate.setEndTime(userTailgate.getEndTime());
			newUserTailgate.setIsActive(1);
			newUserTailgate.setIsDelete(0);
			newUserTailgate.setVenmoAccountId(userTailgate.getVenmoAccountId());
			newUserTailgate.setAmountToPay(userTailgate.getAmountToPay());
			Date now = new Date();
			newUserTailgate.setCompanyId(serviceContext.getCompanyId());
			newUserTailgate.setUserId(serviceContext.getUserId());
			newUserTailgate.setCreatedDate(serviceContext.getCreateDate(now));
			newUserTailgate.setModifiedDate(serviceContext.getModifiedDate(now));
			newUserTailgate.setLogoId(userTailgate.getLogoId());
			TailgateInfoLocalServiceUtil.addTailgateInfo(newUserTailgate);
			
			TailgateUsers tailgateUser = TailgateUsersLocalServiceUtil.createTailgateUsers(CounterLocalServiceUtil.increment());
			tailgateUser.setIsAdmin(1); //TRUE
			User user = UserLocalServiceUtil.getUser(serviceContext.getUserId());
			tailgateUser.setTailgateId(newUserTailgate.getTailgateId());
			tailgateUser.setUserId(user.getUserId());
			String userName = user.getFirstName() + " " + user.getLastName();
			tailgateUser.setUserName(userName);
			tailgateUser.setEmailAddress(user.getEmailAddress());
			tailgateUser.setIsPaid(false);
			tailgateUser.setPaymentMode("None");
			tailgateUser.setGroupId(0);
			TailgateUsersLocalServiceUtil.addTailgateUsers(tailgateUser);
			
			List<TailgateUsers> allMembers = TailgateUsersServiceUtil.getTailgateMembers(tailgateId);
			for(TailgateUsers member: allMembers){
				if(member.getUserId()!= serviceContext.getUserId()){
					TailgateUsers newMember = TailgateUsersLocalServiceUtil.createTailgateUsers(CounterLocalServiceUtil.increment());
					newMember.setTailgateId(newUserTailgate.getTailgateId());
					newMember.setUserId(member.getUserId());
					newMember.setUserName(member.getUserName());
					newMember.setEmailAddress(member.getEmailAddress());
					newMember.setIsPaid(false);
					newMember.setPaymentMode("None");
					newMember.setGroupId(0);
					TailgateUsersLocalServiceUtil.addTailgateUsers(newMember);
				}
			}
			
			TailgateMarker telgateMarker = TailgateMarkerServiceUtil.getTailgateMarker(tailgateId);
			TailgateMarker newMarker = TailgateMarkerLocalServiceUtil.createTailgateMarker(CounterLocalServiceUtil.increment());
			newMarker.setLatitude(telgateMarker.getLatitude());
			newMarker.setLongitude(telgateMarker.getLongitude());
			newMarker.setName(telgateMarker.getName());
			newMarker.setDescription(telgateMarker.getDescription());
			newMarker.setTailgateid(newUserTailgate.getTailgateId());
			TailgateMarkerLocalServiceUtil.addTailgateMarker(newMarker);
			
		}catch(Exception ex){
			LOGGER.error("Exception in copy Tailgate: " + ex.getMessage());
		}
		return newUserTailgate;
	}
	
	public TailgateInfo updateTailgateInfo(long tailgateId, String tailgateName, String tailgateDescription,long eventId, String eventName, 
				Date tailgateDate, long startTime, long endTime, String venmoAccountId, double amountToPay, long logoId, ServiceContext  serviceContext){
		TailgateInfo userTailgate = null;
		try{
			boolean isAdmin = TailgateUsersServiceUtil.isTailgateAdmin(tailgateId, serviceContext);
			userTailgate = TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId);
			//make sure user who created the tailgate is the one who can modify it.
			if(isAdmin){
				userTailgate.setTailgateName(tailgateName);
				userTailgate.setTailgateDescription(tailgateDescription);
				userTailgate.setEventId(eventId);
				userTailgate.setEventName(eventName);
				userTailgate.setTailgateDate(tailgateDate);
				userTailgate.setStartTime(startTime);
				userTailgate.setEndTime(endTime);
				userTailgate.setVenmoAccountId(venmoAccountId);
				userTailgate.setAmountToPay(amountToPay);
				userTailgate.setLogoId(logoId);
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
	public void deleteTailgateInfo(long tailgateId, ServiceContext serviceContext){
		try{
			if(FlaskTailgateUtil.isUserAdmin(serviceContext.getUserId(), adminRoles) || TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId).getUserId()==serviceContext.getUserId()){
				TailgateInfoLocalServiceUtil.deleteTailgateInfo(tailgateId);
				TailgateSupplyItemServiceUtil.deleteItemsByTailgateId(tailgateId, serviceContext);
				TailgateMessageBoardServiceUtil.deleteBoardsByTailgateId(tailgateId, serviceContext);
			}
		}catch(Exception ex){
			LOGGER.error("Exception in deleteiing Tailgate: " + ex.getMessage());
		}
	}
}