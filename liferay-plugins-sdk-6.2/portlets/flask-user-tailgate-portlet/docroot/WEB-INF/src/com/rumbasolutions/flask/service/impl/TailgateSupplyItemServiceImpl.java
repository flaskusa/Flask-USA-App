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
import com.liferay.portal.util.PortalUtil;
import com.rumbasolutions.flask.model.TailgateSupplyItem;
import com.rumbasolutions.flask.service.TailgateInfoLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateSupplyItemLocalServiceUtil;
import com.rumbasolutions.flask.service.base.TailgateSupplyItemServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.TailgateSupplyItemUtil;

/**
 * The implementation of the tailgate supply item remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.TailgateSupplyItemService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Kiran
 * @see com.rumbasolutions.flask.service.base.TailgateSupplyItemServiceBaseImpl
 * @see com.rumbasolutions.flask.service.TailgateSupplyItemServiceUtil
 */
public class TailgateSupplyItemServiceImpl
	extends TailgateSupplyItemServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.TailgateSupplyItemServiceUtil} to access the tailgate supply item remote service.
	 */
	private static Log LOGGER = LogFactoryUtil.getLog(TailgateSupplyItemServiceImpl.class);
	
	@Override
	public TailgateSupplyItem addTailgateSupplyItem(String supplyListItemName, long tailgateId, long itemAssignedUserId, ServiceContext serviceContext){
		TailgateSupplyItem tailgateSupplyItem = null;
		try {
			if(serviceContext.getUserId() == TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId).getUserId()){
				Date now = new Date();
				tailgateSupplyItem = TailgateSupplyItemLocalServiceUtil.createTailgateSupplyItem(CounterLocalServiceUtil.increment());
				tailgateSupplyItem.setSupplyListItemName(supplyListItemName);
				tailgateSupplyItem.setTailgateId(tailgateId);
				tailgateSupplyItem.setItemAssignedUserId(itemAssignedUserId);
				tailgateSupplyItem.setCompanyId(PortalUtil.getDefaultCompanyId());
				tailgateSupplyItem.setUserId(serviceContext.getUserId());
				tailgateSupplyItem.setCreatedDate(serviceContext.getCreateDate(now));
				tailgateSupplyItem.setModifiedDate(serviceContext.getModifiedDate(now));
				tailgateSupplyItem = TailgateSupplyItemLocalServiceUtil.addTailgateSupplyItem(tailgateSupplyItem);
			}else{
				throw new Exception("You do not have permission to add Supply Item to this Tailgate");
			}
		} catch (Exception e) {
			LOGGER.error("Exception in Add Tailgate Supply Item :" + e.getMessage());
			e.printStackTrace();
		}
		return tailgateSupplyItem;
	}
	
	@Override
	public TailgateSupplyItem updateTailgateSupplyItem(long tailgateSupplyItemId, String supplyListItemName, long tailgateId, long itemAssignedUserId, ServiceContext serviceContext){
		TailgateSupplyItem tailgateSupplyItem = null;
		try {
			if(serviceContext.getUserId() == TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId).getUserId()){
				Date now = new Date();
				tailgateSupplyItem = TailgateSupplyItemLocalServiceUtil.getTailgateSupplyItem(tailgateSupplyItemId);
				tailgateSupplyItem.setSupplyListItemName(supplyListItemName);
				tailgateSupplyItem.setTailgateId(tailgateId);
				tailgateSupplyItem.setItemAssignedUserId(itemAssignedUserId);
				tailgateSupplyItem.setCompanyId(PortalUtil.getDefaultCompanyId());
				tailgateSupplyItem.setModifiedDate(serviceContext.getModifiedDate(now));
				tailgateSupplyItem = TailgateSupplyItemLocalServiceUtil.updateTailgateSupplyItem(tailgateSupplyItem);
			}else{
				throw new Exception("You do not have permission to add Supply Item to this Tailgate");
			}
		} catch (Exception e) {
			LOGGER.error("Exception in Update Tailgate Supply Item :" + e.getMessage());
			e.printStackTrace();
		}
		return tailgateSupplyItem;
	}
	
	@Override
	public TailgateSupplyItem getTailgateSupplyItem(long tailgateSupplyItemId, ServiceContext serviceContext){
		TailgateSupplyItem tailgateSupplyItem = null;
		try {
			tailgateSupplyItem = TailgateSupplyItemLocalServiceUtil.getTailgateSupplyItem(tailgateSupplyItemId);
		} catch (Exception e) {
			LOGGER.error("Exception in get Tailgate Supply Item :" + e.getMessage());
			e.printStackTrace();
		}
		return tailgateSupplyItem;
	}
	
	@Override
	public List<TailgateSupplyItem> getItemsByTailgateId(long tailgateId, ServiceContext serviceContext){
		List<TailgateSupplyItem> tailgateSupplyItems = null;
		try {
			tailgateSupplyItems = TailgateSupplyItemUtil.findBytailgateId(tailgateId);
		} catch (Exception e) {
			LOGGER.error("Exception in get Items by Tailgate ID :" + e.getMessage());
			e.printStackTrace();
		}
		return tailgateSupplyItems;
	}
	
	@Override
	public List<TailgateSupplyItem> getMyTailgateSupplyItems(ServiceContext serviceContext){
		List<TailgateSupplyItem> tailgateSupplyItems = null;
		try {
			tailgateSupplyItems = TailgateSupplyItemUtil.findByuserId(serviceContext.getUserId());
		} catch (Exception e) {
			LOGGER.error("Exception in get my Tailgate Supply Items:" + e.getMessage());
			e.printStackTrace();
		}
		return tailgateSupplyItems;
	}
	
	@Override
	public List<TailgateSupplyItem> getAllTailgateSupplyItems(ServiceContext serviceContext){
		List<TailgateSupplyItem> tailgateSupplyItems = null;
		try {
			tailgateSupplyItems = TailgateSupplyItemLocalServiceUtil.getTailgateSupplyItems(0, TailgateSupplyItemLocalServiceUtil.getTailgateSupplyItemsCount());
		} catch (Exception e) {
			LOGGER.error("Exception in get all Tailgate Supply Items :" + e.getMessage());
			e.printStackTrace();
		}
		return tailgateSupplyItems;
	}
	
	@Override
	public void deleteTailgateSupplyItem(long tailgateSupplyItemId, ServiceContext serviceContext){
		try {
			TailgateSupplyItem tailgateSupplyItem = TailgateSupplyItemLocalServiceUtil.getTailgateSupplyItem(tailgateSupplyItemId);
			if(serviceContext.getUserId() == tailgateSupplyItem.getUserId()){
				TailgateSupplyItemLocalServiceUtil.deleteTailgateSupplyItem(tailgateSupplyItem);
			}
			else{
				throw new Exception("You do not have permission to delete this Supply Item");
			}
		} catch (Exception e) {
			LOGGER.error("Exception in delete Tailgate Supply Item :" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteItemsByTailgateId(long tailgateId, ServiceContext serviceContext){
		try {
			if(serviceContext.getUserId() == TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId).getUserId()){
				List<TailgateSupplyItem> tailgateSupplyItems = TailgateSupplyItemUtil.findBytailgateId(tailgateId);
				for(TailgateSupplyItem item: tailgateSupplyItems){
					TailgateSupplyItemLocalServiceUtil.deleteTailgateSupplyItem(item);
				}
			}else{
				throw new Exception("You do not have permission to delete Supply Items");
			}
		} catch (Exception e) {
			LOGGER.error("Exception in delete Items By Tailgate ID :" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteMyItems(ServiceContext serviceContext){
		try {
			List<TailgateSupplyItem> tailgateSupplyItems = TailgateSupplyItemUtil.findByuserId(serviceContext.getUserId());
			for(TailgateSupplyItem item: tailgateSupplyItems){
				TailgateSupplyItemLocalServiceUtil.deleteTailgateSupplyItem(item);
			}
		} catch (Exception e) {
			LOGGER.error("Exception in delete my Items :" + e.getMessage());
			e.printStackTrace();
		}
	}
}