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

import java.util.List;

import com.liferay.contacts.service.FlaskMessagesServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.rumbasolutions.flask.model.TailgateInfo;
import com.rumbasolutions.flask.model.TailgateSupplyItem;
import com.rumbasolutions.flask.model.TailgateUsers;
import com.rumbasolutions.flask.model.impl.TailgateUsersImpl;
import com.rumbasolutions.flask.service.TailgateInfoLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateSupplyItemServiceUtil;
import com.rumbasolutions.flask.service.TailgateUsersLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateUsersServiceUtil;
import com.rumbasolutions.flask.service.base.TailgateUsersServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.TailgateUsersFinderUtil;

/**
 * The implementation of the tailgate users remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.TailgateUsersService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author rajeshj
 * @see com.rumbasolutions.flask.service.base.TailgateUsersServiceBaseImpl
 * @see com.rumbasolutions.flask.service.TailgateUsersServiceUtil
 */
public class TailgateUsersServiceImpl extends TailgateUsersServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.TailgateUsersServiceUtil} to access the tailgate users remote service.
	 */
	private static Log LOGGER = LogFactoryUtil.getLog(TailgateUsersServiceImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<TailgateUsers> getTailgateMembers(long tailgateId){
		List<TailgateUsers> tailgateMembers = null;
//		tailgateMarker = TailgateMarkerFinderUtil.getTailgateMarker(tailgateId);
		try {
			DynamicQuery tailgateQuery = DynamicQueryFactoryUtil.forClass(TailgateUsersImpl.class);
			tailgateQuery.add(PropertyFactoryUtil.forName("tailgateId").eq(new Long(tailgateId)));
			tailgateMembers = TailgateUsersLocalServiceUtil.dynamicQuery(tailgateQuery);
		} catch (SystemException e) {
			e.printStackTrace();
			LOGGER.error("Exception in get all Tailgate Users :" + e.getMessage());
		}
		return tailgateMembers;
	}
	
	@Override
	public boolean isTailgateAdmin(long tailgateId, ServiceContext serviceContext){
		boolean tailgateAdmin = false;
		try {
			if(serviceContext.getUserId() == TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId).getUserId()){
				tailgateAdmin = true;
			}
			for(TailgateUsers user:TailgateUsersServiceUtil.getTailgateMembers(tailgateId)){
				if(user.getUserId()== serviceContext.getUserId() && user.getIsAdmin()==1){
					tailgateAdmin = true;
				}
			}
		} catch (Exception e) {
			LOGGER.error("Exception in is Tailgate Admin :" + e.getMessage());
		}
		return tailgateAdmin;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TailgateUsers> getTailgateGroups(long tailgateId, long groupId){
		List<TailgateUsers> tailgateGroups = null;
//		tailgateMarker = TailgateMarkerFinderUtil.getTailgateMarker(tailgateId);
		try {
			DynamicQuery tailgateQuery = DynamicQueryFactoryUtil.forClass(TailgateUsersImpl.class);
			tailgateQuery.add(PropertyFactoryUtil.forName("tailgateId").eq(new Long(tailgateId)));
			tailgateQuery.add(PropertyFactoryUtil.forName("groupId").eq(new Long(groupId)));
			tailgateGroups = TailgateUsersLocalServiceUtil.dynamicQuery(tailgateQuery);
		} catch (SystemException e) {
			e.printStackTrace();
			LOGGER.error("Exception in get All Tailgate Group :" + e.getMessage());
		}
		return tailgateGroups;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkTailgateUserExist(long tailgateId, long userId){
		boolean isUserExist = false;
		List<TailgateUsers> tailgateGroups = null;
//		tailgateMarker = TailgateMarkerFinderUtil.getTailgateMarker(tailgateId);
		try {
			DynamicQuery tailgateQuery = DynamicQueryFactoryUtil.forClass(TailgateUsersImpl.class);
			tailgateQuery.add(PropertyFactoryUtil.forName("tailgateId").eq(new Long(tailgateId)));
			tailgateQuery.add(PropertyFactoryUtil.forName("userId").eq(new Long(userId)));
			tailgateGroups = TailgateUsersLocalServiceUtil.dynamicQuery(tailgateQuery);
			if(tailgateGroups.size() > 0)
				isUserExist = true;
		} catch (SystemException e) {
			e.printStackTrace();
			LOGGER.error("Exception in get All Tailgate Group :" + e.getMessage());
		}
		return isUserExist;
	}
	
	@Override
	public TailgateUsers addTailgateUser(long tailgateId, long userId, String userName, String emailAddress, int isAdmin, boolean isPaid, String paymentMode, int groupId){
		TailgateUsers tailgateUsers = null;
		try{
			if(!checkTailgateUserExist(tailgateId, userId)){
				tailgateUsers = TailgateUsersLocalServiceUtil.createTailgateUsers(CounterLocalServiceUtil.increment());
				tailgateUsers.setTailgateId(tailgateId);
				tailgateUsers.setIsAdmin(isAdmin);
				tailgateUsers.setUserId(userId);
				tailgateUsers.setUserName(userName);
				tailgateUsers.setEmailAddress(emailAddress);
				tailgateUsers.setIsPaid(isPaid);
				tailgateUsers.setPaymentMode(paymentMode);
				tailgateUsers.setGroupId(groupId);
				TailgateInfo tailgate = TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId);
				tailgateUsers = TailgateUsersLocalServiceUtil.addTailgateUsers(tailgateUsers);
				FlaskMessagesServiceUtil.sendPush(userId, "Flask Tailgate Invitation", 
						"You are invited to a tailgate party, " + tailgate.getTailgateName() + " by " + UserLocalServiceUtil.getUser(tailgate.getUserId()).getFullName(),
						"Tailgate_invitation", tailgate.getModelAttributes(), userId);
			}
		}catch(Exception e){
			LOGGER.error("Exception in Add Tailgate User :" + e.getMessage());
			e.printStackTrace();
		}
		return tailgateUsers;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TailgateUsers updateTailgateUser(long userId, long tailgateId, boolean isPaid, String paymentMode, String description){
		List<TailgateUsers> tailgateUsers = null;
		TailgateUsers tailgateUser = null;
		try{
			DynamicQuery tailgateQuery = DynamicQueryFactoryUtil.forClass(TailgateUsersImpl.class);
			tailgateQuery.add(PropertyFactoryUtil.forName("userId").eq(new Long(userId)));
			tailgateQuery.add(PropertyFactoryUtil.forName("tailgateId").eq(new Long(tailgateId)));
			tailgateUsers = TailgateUsersLocalServiceUtil.dynamicQuery(tailgateQuery);
			for(TailgateUsers tUser: tailgateUsers){
				tUser.setIsPaid(isPaid);
				tUser.setPaymentMode(paymentMode);
				tUser.setDescription(description);
				tailgateUser = TailgateUsersLocalServiceUtil.updateTailgateUsers(tUser);
			}
			
		}catch(Exception e){
			LOGGER.error("Exception in Update Tailgate User :" + e.getMessage());
			e.printStackTrace();
		}
		return tailgateUser;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int updateTailgateUserRole(long userId, long tailgateId){
		List<TailgateUsers> tailgateUsers = null;
		TailgateUsers tailgateUser = null;
		try{
			DynamicQuery tailgateQuery = DynamicQueryFactoryUtil.forClass(TailgateUsersImpl.class);
			tailgateQuery.add(PropertyFactoryUtil.forName("userId").eq(new Long(userId)));
			tailgateQuery.add(PropertyFactoryUtil.forName("tailgateId").eq(new Long(tailgateId)));
			tailgateUsers = TailgateUsersLocalServiceUtil.dynamicQuery(tailgateQuery);
			for(TailgateUsers tUser: tailgateUsers){
				if(tUser.getIsAdmin() == 0){
					tUser.setIsAdmin(1);
				}else{
					tUser.setIsAdmin(0);
				}
				tailgateUser = TailgateUsersLocalServiceUtil.updateTailgateUsers(tUser);
			}
			
			
		}catch(Exception e){
			LOGGER.error("Exception in Update Tailgate User Role:" + e.getMessage());
			e.printStackTrace();
		}
		return tailgateUser.getIsAdmin();
	}
	
	@Override
	public void deleteTailgateUser(long tailgateId, long userId, ServiceContext serviceContext){
		try {
			TailgateUsersFinderUtil.deleteTailgateUser(tailgateId, userId);
			List<TailgateSupplyItem> tailgateSupplyItems= TailgateSupplyItemServiceUtil.getItemsByTailgateId(tailgateId, serviceContext);
			for(TailgateSupplyItem item: tailgateSupplyItems){
				if(userId == item.getItemAssignedUserId()){
					TailgateSupplyItemServiceUtil.updateTailgateSupplyItem(item.getTailgateSupplyItemId(), "", item.getTailgateId(), 0, serviceContext);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Exception in delete Tailgate User Role:" + e.getMessage());
		}
	}
}