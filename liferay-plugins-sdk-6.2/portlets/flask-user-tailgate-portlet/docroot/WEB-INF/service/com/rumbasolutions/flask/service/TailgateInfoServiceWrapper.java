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
 * Provides a wrapper for {@link TailgateInfoService}.
 *
 * @author rajeshj
 * @see TailgateInfoService
 * @generated
 */
public class TailgateInfoServiceWrapper implements TailgateInfoService,
	ServiceWrapper<TailgateInfoService> {
	public TailgateInfoServiceWrapper(TailgateInfoService tailgateInfoService) {
		_tailgateInfoService = tailgateInfoService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tailgateInfoService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tailgateInfoService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tailgateInfoService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateInfo addTailgateInfo(
		java.lang.String tailgateName, java.lang.String tailgateDescription,
		long eventId, java.lang.String eventName, java.util.Date tailgateDate,
		java.util.Date startTime, java.util.Date endTime,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _tailgateInfoService.addTailgateInfo(tailgateName,
			tailgateDescription, eventId, eventName, tailgateDate, startTime,
			endTime, serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateInfo> getAllTailgate() {
		return _tailgateInfoService.getAllTailgate();
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateInfo> getAllMyTailgate(
		long userId) {
		return _tailgateInfoService.getAllMyTailgate(userId);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateInfo getTailgate(
		int tailgateId) {
		return _tailgateInfoService.getTailgate(tailgateId);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateInfo updateTailgateInfo(
		long tailgateId, java.lang.String tailgateName,
		java.lang.String tailgateDescription, long eventId,
		java.lang.String eventName, java.util.Date tailgateDate,
		java.util.Date startTime, java.util.Date endTime,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _tailgateInfoService.updateTailgateInfo(tailgateId,
			tailgateName, tailgateDescription, eventId, eventName,
			tailgateDate, startTime, endTime, serviceContext);
	}

	@Override
	public void deleteTailgateInfo(long tailgateId) {
		_tailgateInfoService.deleteTailgateInfo(tailgateId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TailgateInfoService getWrappedTailgateInfoService() {
		return _tailgateInfoService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTailgateInfoService(
		TailgateInfoService tailgateInfoService) {
		_tailgateInfoService = tailgateInfoService;
	}

	@Override
	public TailgateInfoService getWrappedService() {
		return _tailgateInfoService;
	}

	@Override
	public void setWrappedService(TailgateInfoService tailgateInfoService) {
		_tailgateInfoService = tailgateInfoService;
	}

	private TailgateInfoService _tailgateInfoService;
}