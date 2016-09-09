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

package com.rumbasolutions.flask.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TailgateMessageBoardService}.
 *
 * @author Brian Wing Shun Chan
 * @see TailgateMessageBoardService
 * @generated
 */
public class TailgateMessageBoardServiceWrapper
	implements TailgateMessageBoardService,
		ServiceWrapper<TailgateMessageBoardService> {
	public TailgateMessageBoardServiceWrapper(
		TailgateMessageBoardService tailgateMessageBoardService) {
		_tailgateMessageBoardService = tailgateMessageBoardService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tailgateMessageBoardService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tailgateMessageBoardService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tailgateMessageBoardService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateMessageBoard addMessageBoard(
		java.lang.String messageText, long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _tailgateMessageBoardService.addMessageBoard(messageText,
			tailgateId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateMessageBoard updateMessageBoard(
		long tailgateMessageId, java.lang.String messageText, long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _tailgateMessageBoardService.updateMessageBoard(tailgateMessageId,
			messageText, tailgateId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateMessageBoard getTailgMessageBoard(
		long tailgateMessageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _tailgateMessageBoardService.getTailgMessageBoard(tailgateMessageId,
			serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> getAllTailgateMessageBoards(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _tailgateMessageBoardService.getAllTailgateMessageBoards(serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> getMessageBoardsByTailgateId(
		long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _tailgateMessageBoardService.getMessageBoardsByTailgateId(tailgateId,
			serviceContext);
	}

	@Override
	public void deleteMessageBoard(long tailgateMessageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tailgateMessageBoardService.deleteMessageBoard(tailgateMessageId,
			serviceContext);
	}

	@Override
	public void deleteMyMessageBoards(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tailgateMessageBoardService.deleteMyMessageBoards(serviceContext);
	}

	@Override
	public void deleteBoardsByTailgateId(long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tailgateMessageBoardService.deleteBoardsByTailgateId(tailgateId,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TailgateMessageBoardService getWrappedTailgateMessageBoardService() {
		return _tailgateMessageBoardService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTailgateMessageBoardService(
		TailgateMessageBoardService tailgateMessageBoardService) {
		_tailgateMessageBoardService = tailgateMessageBoardService;
	}

	@Override
	public TailgateMessageBoardService getWrappedService() {
		return _tailgateMessageBoardService;
	}

	@Override
	public void setWrappedService(
		TailgateMessageBoardService tailgateMessageBoardService) {
		_tailgateMessageBoardService = tailgateMessageBoardService;
	}

	private TailgateMessageBoardService _tailgateMessageBoardService;
}