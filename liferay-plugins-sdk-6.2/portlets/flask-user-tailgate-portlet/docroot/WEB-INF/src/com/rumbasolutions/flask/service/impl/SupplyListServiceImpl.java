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
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.rumbasolutions.flask.model.SupplyList;
import com.rumbasolutions.flask.service.SupplyItemServiceUtil;
import com.rumbasolutions.flask.service.SupplyListLocalServiceUtil;
import com.rumbasolutions.flask.service.base.SupplyListServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.SupplyItemUtil;
import com.rumbasolutions.flask.service.persistence.SupplyListUtil;

/**
 * The implementation of the supply list remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.SupplyListService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Kiran
 * @see com.rumbasolutions.flask.service.base.SupplyListServiceBaseImpl
 * @see com.rumbasolutions.flask.service.SupplyListServiceUtil
 */
public class SupplyListServiceImpl extends SupplyListServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.SupplyListServiceUtil} to access the supply list remote service.
	 */
	String adminRoles[] = {FlaskTailgateUtil.FlaskRoleEnum.FLASK_ADMIN.getRoleName(), FlaskTailgateUtil.FlaskRoleEnum.LIFERAY_ADMIN.getRoleName(),
			FlaskTailgateUtil.FlaskRoleEnum.FLASK_CONTENT_ADMIN.getRoleName() };
	private static Log LOGGER = LogFactoryUtil.getLog(SupplyListServiceImpl.class);
	
	@Override
	public SupplyList addSupplyList(String supplyListName, boolean isSystem, ServiceContext serviceContext){
		SupplyList supplyList = null;
		try {
				Date now = new Date();
				supplyList = SupplyListLocalServiceUtil.createSupplyList(CounterLocalServiceUtil.increment());
				supplyList.setSupplyListName(supplyListName);
				if(FlaskTailgateUtil.isUserAdmin(serviceContext.getUserId(), adminRoles))
					supplyList.setIsSystem(isSystem);
				else
					supplyList.setIsSystem(false);
				supplyList.setCompanyId(PortalUtil.getDefaultCompanyId());
				supplyList.setUserId(serviceContext.getUserId());
				supplyList.setCreatedDate(serviceContext.getCreateDate(now));
				supplyList.setModifiedDate(serviceContext.getModifiedDate(now));
				supplyList = SupplyListLocalServiceUtil.addSupplyList(supplyList);
		} catch (Exception e) {
			LOGGER.error("Exception in Add Supply List :" + e.getMessage());
			e.printStackTrace();
		}
		return supplyList;
	}
	
	@Override
	public SupplyList updateSupplyList(long supplyListId, String supplyListName, boolean isSystem, ServiceContext serviceContext){
		SupplyList supplyList = null;
		try {
			supplyList = SupplyListLocalServiceUtil.getSupplyList(supplyListId);
			if(serviceContext.getUserId()==supplyList.getUserId() || FlaskTailgateUtil.isUserAdmin(serviceContext.getUserId(), adminRoles)){
				Date now = new Date();
				supplyList.setSupplyListName(supplyListName);
				if(FlaskTailgateUtil.isUserAdmin(serviceContext.getUserId(), adminRoles))
					supplyList.setIsSystem(isSystem);
				else
					supplyList.setIsSystem(false);
				supplyList.setCompanyId(PortalUtil.getDefaultCompanyId());
				supplyList.setUserId(serviceContext.getUserId());
				supplyList.setModifiedDate(serviceContext.getModifiedDate(now));
				supplyList = SupplyListLocalServiceUtil.updateSupplyList(supplyList);
			}else{
				throw new Exception("You do not have permission to update this Supply List");
			}
		} catch (Exception e) {
			LOGGER.error("Exception in update Supply List :" + e.getMessage());
			e.printStackTrace();
		}
		return supplyList;
	}
	
	@Override
	public SupplyList getSupplyList(long supplyListId, ServiceContext serviceContext){
		SupplyList supplyList = null;
		try {
			supplyList = SupplyListLocalServiceUtil.getSupplyList(supplyListId);
		} catch (Exception e) {
			LOGGER.error("Exception in get Supply List :" + e.getMessage());
			e.printStackTrace();
		}
		return supplyList;
	}
	
	@Override
	public List<SupplyList> getAllSupplyLists(ServiceContext serviceContext){
		List<SupplyList> supplyLists = null;
		try {
			supplyLists = SupplyListLocalServiceUtil.getSupplyLists(0, SupplyListLocalServiceUtil.getSupplyListsCount());
		} catch (Exception e) {
			LOGGER.error("Exception in get All Supply Lists :" + e.getMessage());
			e.printStackTrace();
		}
		return supplyLists;
	}
	
	@Override
	public JSONArray getMySupplyLists(ServiceContext serviceContext){
		List<SupplyList> mySupplyLists = null;
		JSONArray array = JSONFactoryUtil.createJSONArray();
		try {
			mySupplyLists = SupplyListLocalServiceUtil.getSupplyLists(0, SupplyListLocalServiceUtil.getSupplyListsCount());
			for(SupplyList list: mySupplyLists){
				if(list.getUserId()==serviceContext.getUserId() || list.getIsSystem()){
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					obj.put("supplyListId", list.getSupplyListId());
					obj.put("supplyListName", list.getSupplyListName());
					obj.put("isSystem", list.getIsSystem());
					obj.put("companyId", list.getCompanyId());
					obj.put("userId", list.getUserId());
					obj.put("createdDate", list.getCreatedDate());
					obj.put("modifiedDate", list.getModifiedDate());
					obj.put("itemsCount", SupplyItemUtil.findBysupplyListId(list.getSupplyListId()).size());
					array.put(obj);
				}
			}
		} catch (Exception e) {
			LOGGER.error("Exception in get My Supply Lists :" + e.getMessage());
			e.printStackTrace();
		}
		return array;
	}
	
	@Override
	public void deleteSupplyList(long supplyListId, ServiceContext serviceContext){
		try {
			SupplyList supplyList = SupplyListLocalServiceUtil.getSupplyList(supplyListId);
			if(serviceContext.getUserId()==supplyList.getUserId() || FlaskTailgateUtil.isUserAdmin(serviceContext.getUserId(), adminRoles)){
				SupplyListLocalServiceUtil.deleteSupplyList(supplyList);
				SupplyItemServiceUtil.deleteItemsByListId(supplyListId, serviceContext);
			}else{
				throw new Exception("You do not have permission to update this Supply List");
			}
		} catch (Exception e) {
			LOGGER.error("Exception in delete Supply List :" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteMySupplyLists(ServiceContext serviceContext){
		try {
			List<SupplyList> supplyLists = SupplyListUtil.findByuserId(serviceContext.getUserId());
			for(SupplyList supplyList: supplyLists){
				SupplyListLocalServiceUtil.deleteSupplyList(supplyList);
				SupplyItemServiceUtil.deleteItemsByListId(supplyList.getSupplyListId(), serviceContext);
			}
		} catch (Exception e) {
			LOGGER.error("Exception in delete My Supply Lists :" + e.getMessage());
			e.printStackTrace();
		}
	}
}