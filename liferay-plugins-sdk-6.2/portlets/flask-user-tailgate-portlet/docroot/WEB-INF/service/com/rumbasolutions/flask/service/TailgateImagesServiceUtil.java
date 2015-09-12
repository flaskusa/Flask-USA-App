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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for TailgateImages. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.TailgateImagesServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TailgateImagesService
 * @see com.rumbasolutions.flask.service.base.TailgateImagesServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.TailgateImagesServiceImpl
 * @generated
 */
public class TailgateImagesServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.TailgateImagesServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.rumbasolutions.flask.model.TailgateImages addTailgateImage(
		long tailgateId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID,
		long imageGroupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addTailgateImage(tailgateId, imageTitle, imageDesc,
			imageUUID, imageGroupId, serviceContext);
	}

	public static com.rumbasolutions.flask.model.TailgateImages updateTailgateImage(
		long tailgateImageId, java.lang.String imageTitle,
		java.lang.String imageDesc,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateTailgateImage(tailgateImageId, imageTitle, imageDesc,
			serviceContext);
	}

	public static void deleteTailgateImageByTailgateImageId(
		long tailgateImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService()
			.deleteTailgateImageByTailgateImageId(tailgateImageId,
			serviceContext);
	}

	public static void deleteTailgateImageByTailgateId(long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteTailgateImageByTailgateId(tailgateId, serviceContext);
	}

	public static void deleteTailgateImageByUUID(java.lang.String imageUUID,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteTailgateImageByUUID(imageUUID, serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.TailgateImages> getTailgateImages(
		long tailgateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getTailgateImages(tailgateId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static TailgateImagesService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TailgateImagesService.class.getName());

			if (invokableService instanceof TailgateImagesService) {
				_service = (TailgateImagesService)invokableService;
			}
			else {
				_service = new TailgateImagesServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(TailgateImagesServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TailgateImagesService service) {
	}

	private static TailgateImagesService _service;
}