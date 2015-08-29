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

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.rumbasolutions.flask.model.TailgateUsers;
import com.rumbasolutions.flask.model.impl.TailgateUsersImpl;
import com.rumbasolutions.flask.service.TailgateUsersLocalServiceUtil;
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

	@Override
	public List<TailgateUsers> getTailgateMembers(long tailgateId){
		List<TailgateUsers> tailgateMembers = null;
//		tailgateMarker = TailgateMarkerFinderUtil.getTailgateMarker(tailgateId);
		try {
			DynamicQuery tailgateQuery = DynamicQueryFactoryUtil.forClass(TailgateUsersImpl.class);
			tailgateQuery.add(PropertyFactoryUtil.forName("tailgateId").eq(new Long(tailgateId)));
			tailgateMembers = TailgateUsersLocalServiceUtil.dynamicQuery(tailgateQuery);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("Exception in get all Tailgate Users :" + e.getMessage());
		}
		return tailgateMembers;
	}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("Exception in get All Tailgate Group :" + e.getMessage());
		}
		return tailgateGroups;
	}
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("Exception in get All Tailgate Group :" + e.getMessage());
		}
		return isUserExist;
	}
	
	@Override
	public TailgateUsers addTailgateUser(long tailgateId, long userId, String userName, String emailAddress, int isAdmin, int groupId){
		TailgateUsers tailgateUsers = null;
		try{
			if(!checkTailgateUserExist(tailgateId, userId)){
				tailgateUsers = TailgateUsersLocalServiceUtil.createTailgateUsers(CounterLocalServiceUtil.increment());
				tailgateUsers.setTailgateId(tailgateId);
				tailgateUsers.setIsAdmin(isAdmin);
				tailgateUsers.setUserId(userId);
				tailgateUsers.setUserName(userName);
				tailgateUsers.setEmailAddress(emailAddress);
				tailgateUsers.setGroupId(groupId);
				
				tailgateUsers = TailgateUsersLocalServiceUtil.addTailgateUsers(tailgateUsers);
				String text = "You are invited to be participants of custom group.";
			}
//			NotificationUtil notificition = new NotificationUtil();
//			notificition.sendNotifications(userId, text);
			
		}catch(SystemException e){
			LOGGER.error("Exception in Add Tailgate User :" + e.getMessage());
			e.printStackTrace();
		}
		return tailgateUsers;
	}
	
	@Override
	public TailgateUsers updateTailgateUser(long tailgateUserId,long tailgateId, long userId, String userName, int isAdmin, int groupId){
		TailgateUsers tailgateUser = null;
		try{
			tailgateUser = TailgateUsersLocalServiceUtil.getTailgateUsers(tailgateUserId);
			tailgateUser.setTailgateId(tailgateId);
			tailgateUser.setIsAdmin(isAdmin);
			tailgateUser.setUserId(userId);
			tailgateUser.setUserName(userName);
			tailgateUser.setGroupId(groupId);
			
			tailgateUser = TailgateUsersLocalServiceUtil.updateTailgateUsers(tailgateUser);
		}catch(SystemException e){
			LOGGER.error("Exception in Update Tailgate User :" + e.getMessage());
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tailgateUser;
	}
	
	@Override
	public void deleteTailgateUser(long tailgateId,long userId){
		try {
			TailgateUsersFinderUtil.deleteTailgateUser(tailgateId, userId);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}