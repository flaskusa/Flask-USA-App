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
import com.rumbasolutions.flask.model.TailgateMessageBoard;
import com.rumbasolutions.flask.service.TailgateInfoLocalServiceUtil;
import com.rumbasolutions.flask.service.TailgateMessageBoardLocalServiceUtil;
import com.rumbasolutions.flask.service.base.TailgateMessageBoardServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.TailgateMessageBoardUtil;

/**
 * The implementation of the tailgate message board remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.TailgateMessageBoardService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Kiran
 * @see com.rumbasolutions.flask.service.base.TailgateMessageBoardServiceBaseImpl
 * @see com.rumbasolutions.flask.service.TailgateMessageBoardServiceUtil
 */
public class TailgateMessageBoardServiceImpl
	extends TailgateMessageBoardServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.TailgateMessageBoardServiceUtil} to access the tailgate message board remote service.
	 */
	private static Log LOGGER = LogFactoryUtil.getLog(SupplyListServiceImpl.class);
	
	@Override
	public TailgateMessageBoard addMessageBoard(String messageText, long tailgateId, ServiceContext serviceContext){
		TailgateMessageBoard tailgateMessageBoard = null;
		try {
			if(serviceContext.getUserId() == TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId).getUserId()){
				Date now = new Date();
				tailgateMessageBoard = TailgateMessageBoardLocalServiceUtil.createTailgateMessageBoard(CounterLocalServiceUtil.increment());
				tailgateMessageBoard.setMessageText(messageText);
				tailgateMessageBoard.setTailgateId(tailgateId);
				tailgateMessageBoard.setCompanyId(PortalUtil.getDefaultCompanyId());
				tailgateMessageBoard.setUserId(serviceContext.getUserId());
				tailgateMessageBoard.setCreatedDate(serviceContext.getCreateDate(now));
				tailgateMessageBoard.setModifiedDate(serviceContext.getModifiedDate(now));
				tailgateMessageBoard = TailgateMessageBoardLocalServiceUtil.addTailgateMessageBoard(tailgateMessageBoard);
			}else{
				throw new Exception("You do not have required permissions");
			}
		} catch (Exception e) {
			LOGGER.error("Exception in Add Message Board:" + e.getMessage());
			e.printStackTrace();
		}
		return tailgateMessageBoard;
	}
	
	@Override
	public TailgateMessageBoard updateMessageBoard(long tailgateMessageId, String messageText, long tailgateId, ServiceContext serviceContext){
		TailgateMessageBoard tailgateMessageBoard = null;
		try {
			if(serviceContext.getUserId() == TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId).getUserId()){
				Date now = new Date();
				tailgateMessageBoard = TailgateMessageBoardLocalServiceUtil.getTailgateMessageBoard(tailgateMessageId);
				tailgateMessageBoard.setMessageText(messageText);
				tailgateMessageBoard.setTailgateId(tailgateId);
				tailgateMessageBoard.setCompanyId(PortalUtil.getDefaultCompanyId());
				tailgateMessageBoard.setModifiedDate(serviceContext.getModifiedDate(now));
				tailgateMessageBoard = TailgateMessageBoardLocalServiceUtil.updateTailgateMessageBoard(tailgateMessageBoard);
			}else{
				throw new Exception("You do not have required permissions");
			}
		} catch (Exception e) {
			LOGGER.error("Exception in Update Message Board :" + e.getMessage());
			e.printStackTrace();
		}
		return tailgateMessageBoard;
	}
	
	@Override
	public TailgateMessageBoard getTailgMessageBoard(long tailgateMessageId, ServiceContext serviceContext){
		TailgateMessageBoard tailgateMessageBoard = null;
		try {
			tailgateMessageBoard = TailgateMessageBoardLocalServiceUtil.getTailgateMessageBoard(tailgateMessageId);
		} catch (Exception e) {
			LOGGER.error("Exception in get Message Board:" + e.getMessage());
			e.printStackTrace();
		}
		return tailgateMessageBoard;
	}
	
	@Override
	public List<TailgateMessageBoard> getAllTailgateMessageBoards(ServiceContext serviceContext){
		List<TailgateMessageBoard> tailgateMessageBoards = null;
		try {
			tailgateMessageBoards = TailgateMessageBoardLocalServiceUtil.getTailgateMessageBoards(0, TailgateMessageBoardLocalServiceUtil.getTailgateMessageBoardsCount());
		} catch (Exception e) {
			LOGGER.error("Exception in get all Message Boards:" + e.getMessage());
			e.printStackTrace();
		}
		return tailgateMessageBoards;
	}
	
	@Override
	public List<TailgateMessageBoard> getMessageBoardsByTailgateId(long tailgateId, ServiceContext serviceContext){
		List<TailgateMessageBoard> tailgateMessageBoards = null;
		try {
			tailgateMessageBoards = TailgateMessageBoardUtil.findBytailgateId(tailgateId);
		} catch (Exception e) {
			LOGGER.error("Exception in get Message Boards by Tailgate ID:" + e.getMessage());
			e.printStackTrace();
		}
		return tailgateMessageBoards;
	}
	
	@Override
	public void deleteMessageBoard(long tailgateMessageId, ServiceContext serviceContext){
		try {
			TailgateMessageBoard tailgateMessageBoard = TailgateMessageBoardLocalServiceUtil.getTailgateMessageBoard(tailgateMessageId);
			if(tailgateMessageBoard.getUserId()==serviceContext.getUserId()){
				TailgateMessageBoardLocalServiceUtil.deleteTailgateMessageBoard(tailgateMessageBoard);
			}else{
				throw new Exception("You do not have required permissions");
			}
		} catch (Exception e) {
			LOGGER.error("Exception in delete Message Board:" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteMyMessageBoards(ServiceContext serviceContext){
		try {
			List<TailgateMessageBoard> tailgateMessageBoards = TailgateMessageBoardUtil.findByuserId(serviceContext.getUserId());
			for(TailgateMessageBoard board: tailgateMessageBoards){
				TailgateMessageBoardLocalServiceUtil.deleteTailgateMessageBoard(board);
			}
		} catch (Exception e) {
			LOGGER.error("Exception in delete My Message Board:" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteBoardsByTailgateId(long tailgateId, ServiceContext serviceContext){
		try {
			if(TailgateInfoLocalServiceUtil.getTailgateInfo(tailgateId).getUserId()==serviceContext.getUserId()){
				List<TailgateMessageBoard> tailgateMessageBoards = TailgateMessageBoardUtil.findBytailgateId(tailgateId);
				for(TailgateMessageBoard board: tailgateMessageBoards){
					TailgateMessageBoardLocalServiceUtil.deleteTailgateMessageBoard(board);
				}
			}else{
				throw new Exception("You do not have permission to delete this Message Board");
			}
		} catch (Exception e) {
			LOGGER.error("Exception in delete Board by tailgate ID:" + e.getMessage());
			e.printStackTrace();
		}
	}
}