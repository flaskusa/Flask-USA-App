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
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.model.FlaskGroup;
import com.rumbasolutions.flask.model.FlaskGroupUsers;
import com.rumbasolutions.flask.service.FlaskGroupLocalServiceUtil;
import com.rumbasolutions.flask.service.base.FlaskGroupServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.FlaskGroupFinderUtil;
import com.rumbasolutions.flask.service.persistence.FlaskGroupUsersUtil;
import com.rumbasolutions.flask.service.persistence.FlaskGroupUtil;

/**
 * The implementation of the flask group remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.FlaskGroupService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Tejas Patel
 * @see com.rumbasolutions.flask.service.base.FlaskGroupServiceBaseImpl
 * @see com.rumbasolutions.flask.service.FlaskGroupServiceUtil
 */
public class FlaskGroupServiceImpl extends FlaskGroupServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.FlaskGroupServiceUtil} to access the flask group remote service.
	 */
	private static Log LOGGER = LogFactoryUtil
			.getLog(FlaskGroupServiceImpl.class);

	@Override
	public List<FlaskGroup> getAllGroups() {
		List<FlaskGroup> groupList = new ArrayList<FlaskGroup>();
		try {
			groupList = FlaskGroupUtil.findAll();
		} catch (SystemException e) {
			LOGGER.error("Exception in getGroups :" + e.getMessage());
			e.printStackTrace();
		}
		return groupList;
	}
	
	@Override
	public List<FlaskGroup> getAllMyGroups(long userId){
		int isAdmin = 1;
		List<FlaskGroup> myGroupList = null;
		myGroupList = FlaskGroupFinderUtil.getAllMyGroups(userId);
		return myGroupList;
	}
	
	@Override
	public List<FlaskGroup> getMyGroups(long userId){
		int isAdmin = 1;
		List<FlaskGroup> myGroupList = null;
		myGroupList = FlaskGroupFinderUtil.getGroupList(userId, isAdmin);
		return myGroupList;
	}
	@Override
	public List<FlaskGroup> getParticipatingGroups(long userId){
		int isAdmin = 0;
		List<FlaskGroup> participatingGroupList = null;
		participatingGroupList = FlaskGroupFinderUtil.getGroupList(userId, isAdmin);
		return participatingGroupList;
	}
	
	@Override
	public FlaskGroup getGroup(long groupId) {
		FlaskGroup group = null;
		try {
			group = FlaskGroupUtil.fetchByPrimaryKey(groupId);
		} catch (SystemException e) {
			LOGGER.error("Exception in getGroups :" + e.getMessage());
			e.printStackTrace();
		}
		return group;
	}
	

	@Override
	public FlaskGroup addGroup(String groupName, String groupDescription,
			String createdBy, String createdDate, int isActive, int isDelete, ServiceContext serviceContext) {
		FlaskGroup group = null;
		try {
			group = FlaskGroupLocalServiceUtil.createFlaskGroup(CounterLocalServiceUtil.increment());
			group.setGroupName(groupName);
			group.setGroupDescription(groupDescription);
			group.setCreatedBy(createdBy);
			Date now = new Date();
			group.setCreatedDate(createdDate);
			group.setIsActive(isActive);
			group.setIsDelete(isDelete);
			
			group = FlaskGroupLocalServiceUtil.addFlaskGroup(group);
//			NotificationUtil notifyUtil = new NotificationUtil();
//			notifyUtil.sendNotifications(JSONFactoryUtil.createJSONObject());
		} catch (SystemException e) {
			LOGGER.error(" Exception in Add Group :" + e.getMessage());
			e.printStackTrace();
		}
		return group;
	}

	@Override
	public FlaskGroup updateGroup(long groupId, String groupName,
			String groupDescription, String createdDate, String createdBy, int isActive, int isDelete) {
		FlaskGroup group = null;
		try {
			group = FlaskGroupLocalServiceUtil.getFlaskGroup(groupId);
			group.setGroupName(groupName);
			group.setGroupDescription(groupDescription);
			group.setCreatedBy(createdBy);
			group.setCreatedDate(createdDate);
			group.setIsActive(isActive);
			group.setIsDelete(isDelete);
			
			group = FlaskGroupLocalServiceUtil.updateFlaskGroup(group);

		} catch (PortalException e) {
			LOGGER.error(" Exception in Update Group :" + e.getMessage());
			e.printStackTrace();
		} catch (SystemException e) {
			LOGGER.error(" Exception in Update Group :" + e.getMessage());
			e.printStackTrace();
		}
		return group;
	}

	@Override
	public void deleteGroup(long groupId) {
		try {
			FlaskGroupLocalServiceUtil.deleteFlaskGroup(groupId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void deleteGroups(String groupList, ServiceContext serviceContext) {
		try {
				FlaskGroupUsers user = null;
				List<String> grpId = Arrays.asList(groupList.split(","));
				for(String strGroupId: grpId){
					long groupId = Long.parseLong(strGroupId);
					user = FlaskGroupUsersUtil.fetchByUserIdGroupId(serviceContext.getUserId(), groupId);
					if(user.getIsAdmin()==1){
						FlaskGroupLocalServiceUtil.deleteFlaskGroup(groupId);
					}
				}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Override
	public void deactivateGroup(long groupId, ServiceContext serviceContext){
		int res = FlaskGroupFinderUtil.deActivateGroup(groupId);
	}
}