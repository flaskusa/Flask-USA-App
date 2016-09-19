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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.model.SupplyItem;
import com.rumbasolutions.flask.service.SupplyItemLocalServiceUtil;
import com.rumbasolutions.flask.service.SupplyListLocalServiceUtil;
import com.rumbasolutions.flask.service.base.SupplyItemServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.SupplyItemUtil;

/**
 * The implementation of the supply item remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.SupplyItemService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Kiran
 * @see com.rumbasolutions.flask.service.base.SupplyItemServiceBaseImpl
 * @see com.rumbasolutions.flask.service.SupplyItemServiceUtil
 */
public class SupplyItemServiceImpl extends SupplyItemServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.SupplyItemServiceUtil} to access the supply item remote service.
	 */
	String adminRoles[] = {FlaskTailgateUtil.FlaskRoleEnum.FLASK_ADMIN.getRoleName(), FlaskTailgateUtil.FlaskRoleEnum.LIFERAY_ADMIN.getRoleName(),
			FlaskTailgateUtil.FlaskRoleEnum.FLASK_CONTENT_ADMIN.getRoleName() };
	private static Log LOGGER = LogFactoryUtil.getLog(SupplyItemServiceImpl.class);
	
	@Override
	public SupplyItem addSupplyItem(String supplyItemName, long supplyListId, ServiceContext serviceContext){
		SupplyItem supplyItem = null;
		try {
			if(FlaskTailgateUtil.isUserAdmin(serviceContext.getUserId(), adminRoles) || SupplyListLocalServiceUtil.getSupplyList(supplyListId).getUserId()==serviceContext.getUserId()){
				Date now = new Date();
				supplyItem = SupplyItemLocalServiceUtil.createSupplyItem(CounterLocalServiceUtil.increment());
				supplyItem.setSupplyItemName(supplyItemName);
				supplyItem.setSupplyListId(supplyListId);
				supplyItem.setCreatedDate(serviceContext.getCreateDate(now));
				supplyItem.setModifiedDate(serviceContext.getModifiedDate(now));
				supplyItem = SupplyItemLocalServiceUtil.addSupplyItem(supplyItem);
			}else{
				throw new Exception("You do not have required permissions");
			}
		} catch (Exception e) {
			LOGGER.error("Exception in Add Supply Item :" + e.getMessage());
			e.printStackTrace();
		}
		return supplyItem;
	}
	
	@Override
	public List<SupplyItem> addSupplyItems(String[] supplyItemNames, long supplyListId, ServiceContext serviceContext){
		List<SupplyItem> supplyItems = new ArrayList<SupplyItem>();
		try {
			if(FlaskTailgateUtil.isUserAdmin(serviceContext.getUserId(), adminRoles) || SupplyListLocalServiceUtil.getSupplyList(supplyListId).getUserId()==serviceContext.getUserId()){
				Date now = new Date();
				for(int i=0; i<supplyItemNames.length; i++){
					SupplyItem supplyItem = SupplyItemLocalServiceUtil.createSupplyItem(CounterLocalServiceUtil.increment());
					supplyItem.setSupplyItemName(supplyItemNames[i]);
					supplyItem.setSupplyListId(supplyListId);
					supplyItem.setCreatedDate(serviceContext.getCreateDate(now));
					supplyItem.setModifiedDate(serviceContext.getModifiedDate(now));
					supplyItem = SupplyItemLocalServiceUtil.addSupplyItem(supplyItem);
					supplyItems.add(supplyItem);
				}
			}else{
				throw new Exception("You do not have required permissions");
			}
		} catch (Exception e) {
			LOGGER.error("Exception in Add Supply Items :" + e.getMessage());
			e.printStackTrace();
		}
		return supplyItems;
	}
	
	@Override
	public SupplyItem updateSupplyItem(long supplyItemId, String supplyItemName, long supplyListId, ServiceContext serviceContext){
		SupplyItem supplyItem = null;
		try {
			if(FlaskTailgateUtil.isUserAdmin(serviceContext.getUserId(), adminRoles) || SupplyListLocalServiceUtil.getSupplyList(supplyListId).getUserId()==serviceContext.getUserId()){
				Date now = new Date();
				supplyItem = SupplyItemLocalServiceUtil.getSupplyItem(supplyItemId);
				supplyItem.setSupplyItemName(supplyItemName);
				supplyItem.setSupplyListId(supplyListId);
				supplyItem.setModifiedDate(serviceContext.getModifiedDate(now));
				supplyItem = SupplyItemLocalServiceUtil.updateSupplyItem(supplyItem);
			}else{
				throw new Exception("You do not have permission to update this Supply Item");
			}
			
		} catch (Exception e) {
			LOGGER.error("Exception in Update Supply Item :" + e.getMessage());
			e.printStackTrace();
		}
		return supplyItem;
	}
	
	@Override
	public SupplyItem getSupplyItem(long supplyItemId){
		SupplyItem supplyItem = null;
		try {
			supplyItem = SupplyItemLocalServiceUtil.getSupplyItem(supplyItemId);
		} catch (Exception e) {
			LOGGER.error("Exception in get Supply Item :" + e.getMessage());
			e.printStackTrace();
		}
		return supplyItem;
	}
	
	@Override
	public List<SupplyItem> getAllSupplyItems(ServiceContext serviceContext){
		List<SupplyItem> supplyItems = null;
		try {
			supplyItems = SupplyItemLocalServiceUtil.getSupplyItems(0, SupplyItemLocalServiceUtil.getSupplyItemsCount());
		} catch (Exception e) {
			LOGGER.error("Exception in get all Supply Items :" + e.getMessage());
			e.printStackTrace();
		}
		return supplyItems;
	}

	@Override
	public List<SupplyItem> getItemsByListId(long supplyListId){
		List<SupplyItem> supplyItems = null;
		try {
			supplyItems = SupplyItemUtil.findBysupplyListId(supplyListId);
		} catch (Exception e) {
			LOGGER.error("Exception in get Supply Items By Supply List ID :" + e.getMessage());
			e.printStackTrace();
		}
		return supplyItems;
	}

	@Override
	public void deleteSupplyItem(long supplyItemId, ServiceContext serviceContext){
		try {
			SupplyItem supplyItem = SupplyItemLocalServiceUtil.getSupplyItem(supplyItemId);
			if(FlaskTailgateUtil.isUserAdmin(serviceContext.getUserId(), adminRoles) || 
					SupplyListLocalServiceUtil.getSupplyList(supplyItem.getSupplyListId()).getUserId()==serviceContext.getUserId()){
				SupplyItemLocalServiceUtil.deleteSupplyItem(supplyItem);
			}else{
				throw new Exception("You do not have permission to update this Supply List");
			}
		} catch (Exception e) {
			LOGGER.error("Exception in delete Supply Item :" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteItemsByListId(long supplyListId, ServiceContext serviceContext){
		try {
			if(FlaskTailgateUtil.isUserAdmin(serviceContext.getUserId(), adminRoles) || SupplyListLocalServiceUtil.getSupplyList(supplyListId).getUserId()==serviceContext.getUserId()){
				List<SupplyItem> supplyItems = SupplyItemUtil.findBysupplyListId(supplyListId);
				for(SupplyItem supplyItem: supplyItems){
					SupplyItemLocalServiceUtil.deleteSupplyItem(supplyItem);
				}
			}else{
				throw new Exception("You do not have required permissions");
			}
		} catch (Exception e) {
			LOGGER.error("Exception in delete Items By List ID :" + e.getMessage());
			e.printStackTrace();
		}
	}
}