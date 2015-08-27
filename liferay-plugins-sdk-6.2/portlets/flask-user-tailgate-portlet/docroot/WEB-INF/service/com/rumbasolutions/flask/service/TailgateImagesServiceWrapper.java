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
 * Provides a wrapper for {@link TailgateImagesService}.
 *
 * @author rajeshj
 * @see TailgateImagesService
 * @generated
 */
public class TailgateImagesServiceWrapper implements TailgateImagesService,
	ServiceWrapper<TailgateImagesService> {
	public TailgateImagesServiceWrapper(
		TailgateImagesService tailgateImagesService) {
		_tailgateImagesService = tailgateImagesService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tailgateImagesService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tailgateImagesService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tailgateImagesService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateImages addTailgateImage(
		long tailgateId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID,
		long imageGroupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _tailgateImagesService.addTailgateImage(tailgateId, imageTitle,
			imageDesc, imageUUID, imageGroupId, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateImages updateTailgateImage(
		long tailgateImageId, java.lang.String imageTitle,
		java.lang.String imageDesc,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _tailgateImagesService.updateTailgateImage(tailgateImageId,
			imageTitle, imageDesc, serviceContext);
	}

	@Override
	public void deleteTailgateImageByTailgateImageId(long tailgateImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tailgateImagesService.deleteTailgateImageByTailgateImageId(tailgateImageId,
			serviceContext);
	}

	@Override
	public void deleteTailgateImageByTailgateId(long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tailgateImagesService.deleteTailgateImageByTailgateId(tailgateId,
			serviceContext);
	}

	@Override
	public void deleteTailgateImageByUUID(java.lang.String imageUUID,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tailgateImagesService.deleteTailgateImageByUUID(imageUUID,
			serviceContext);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateImages> getTailgateImages(
		long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _tailgateImagesService.getTailgateImages(tailgateId,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TailgateImagesService getWrappedTailgateImagesService() {
		return _tailgateImagesService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTailgateImagesService(
		TailgateImagesService tailgateImagesService) {
		_tailgateImagesService = tailgateImagesService;
	}

	@Override
	public TailgateImagesService getWrappedService() {
		return _tailgateImagesService;
	}

	@Override
	public void setWrappedService(TailgateImagesService tailgateImagesService) {
		_tailgateImagesService = tailgateImagesService;
	}

	private TailgateImagesService _tailgateImagesService;
}