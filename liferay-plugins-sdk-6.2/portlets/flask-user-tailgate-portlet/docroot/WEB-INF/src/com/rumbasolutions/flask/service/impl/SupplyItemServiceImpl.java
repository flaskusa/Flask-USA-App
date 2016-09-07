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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.model.SupplyItem;
import com.rumbasolutions.flask.service.SupplyItemLocalServiceUtil;
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
	public SupplyItem addSupplyItem(String supplyItemName, long supplyListId, Date createdDate, Date modifiedDate, ServiceContext serviceContext){
		SupplyItem supplyItem = null;
		try {
			Date now = new Date();
			supplyItem = SupplyItemLocalServiceUtil.createSupplyItem(CounterLocalServiceUtil.increment());
			supplyItem.setSupplyItemName(supplyItemName);
			supplyItem.setSupplyListId(supplyListId);
			supplyItem.setCreatedDate(serviceContext.getCreateDate(now));
			supplyItem.setModifiedDate(serviceContext.getModifiedDate(now));
			supplyItem = SupplyItemLocalServiceUtil.addSupplyItem(supplyItem);
		} catch (Exception e) {
			LOGGER.error("Exception in Add Supply Item :" + e.getMessage());
			e.printStackTrace();
		}
		return supplyItem;
	}
	
	@Override
	public SupplyItem updateSupplyItem(long supplyItemId, String supplyItemName, long supplyListId, Date createdDate, Date modifiedDate, ServiceContext serviceContext){
		SupplyItem supplyItem = null;
		try {
			if(FlaskTailgateUtil.isUserAdmin(serviceContext.getUserId(), adminRoles)){
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
	public List<SupplyItem> getAllSupplyItems(){
		List<SupplyItem> supplyItems = null;
		try {
			supplyItems = SupplyItemLocalServiceUtil.getSupplyItems(0, SupplyItemLocalServiceUtil.getSupplyItemsCount());
		} catch (Exception e) {
			LOGGER.error("Exception in get Supply Item :" + e.getMessage());
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
			if(FlaskTailgateUtil.isUserAdmin(serviceContext.getUserId(), adminRoles)){
				SupplyItem supplyItem = SupplyItemLocalServiceUtil.getSupplyItem(supplyItemId);
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
			if(FlaskTailgateUtil.isUserAdmin(serviceContext.getUserId(), adminRoles)){
				List<SupplyItem> supplyItems = SupplyItemUtil.findBysupplyListId(supplyListId);
				for(int i=0; i<supplyItems.size(); i++){
					SupplyItemLocalServiceUtil.deleteSupplyItem(supplyItems.get(i));
				}
			}
		} catch (Exception e) {
			LOGGER.error("Exception in delete Items By List ID :" + e.getMessage());
			e.printStackTrace();
		}
	}
}