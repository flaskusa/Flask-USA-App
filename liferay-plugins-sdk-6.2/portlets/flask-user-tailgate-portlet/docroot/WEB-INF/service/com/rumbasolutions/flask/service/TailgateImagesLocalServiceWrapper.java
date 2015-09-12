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
 * Provides a wrapper for {@link TailgateImagesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TailgateImagesLocalService
 * @generated
 */
public class TailgateImagesLocalServiceWrapper
	implements TailgateImagesLocalService,
		ServiceWrapper<TailgateImagesLocalService> {
	public TailgateImagesLocalServiceWrapper(
		TailgateImagesLocalService tailgateImagesLocalService) {
		_tailgateImagesLocalService = tailgateImagesLocalService;
	}

	/**
	* Adds the tailgate images to the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateImages the tailgate images
	* @return the tailgate images that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateImages addTailgateImages(
		com.rumbasolutions.flask.model.TailgateImages tailgateImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateImagesLocalService.addTailgateImages(tailgateImages);
	}

	/**
	* Creates a new tailgate images with the primary key. Does not add the tailgate images to the database.
	*
	* @param tailgateImageId the primary key for the new tailgate images
	* @return the new tailgate images
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateImages createTailgateImages(
		long tailgateImageId) {
		return _tailgateImagesLocalService.createTailgateImages(tailgateImageId);
	}

	/**
	* Deletes the tailgate images with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateImageId the primary key of the tailgate images
	* @return the tailgate images that was removed
	* @throws PortalException if a tailgate images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateImages deleteTailgateImages(
		long tailgateImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tailgateImagesLocalService.deleteTailgateImages(tailgateImageId);
	}

	/**
	* Deletes the tailgate images from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateImages the tailgate images
	* @return the tailgate images that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateImages deleteTailgateImages(
		com.rumbasolutions.flask.model.TailgateImages tailgateImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateImagesLocalService.deleteTailgateImages(tailgateImages);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tailgateImagesLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateImagesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateImagesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateImagesLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateImagesLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateImagesLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateImages fetchTailgateImages(
		long tailgateImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateImagesLocalService.fetchTailgateImages(tailgateImageId);
	}

	/**
	* Returns the tailgate images with the primary key.
	*
	* @param tailgateImageId the primary key of the tailgate images
	* @return the tailgate images
	* @throws PortalException if a tailgate images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateImages getTailgateImages(
		long tailgateImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tailgateImagesLocalService.getTailgateImages(tailgateImageId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tailgateImagesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tailgate imageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tailgate imageses
	* @param end the upper bound of the range of tailgate imageses (not inclusive)
	* @return the range of tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateImages> getTailgateImageses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateImagesLocalService.getTailgateImageses(start, end);
	}

	/**
	* Returns the number of tailgate imageses.
	*
	* @return the number of tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTailgateImagesesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateImagesLocalService.getTailgateImagesesCount();
	}

	/**
	* Updates the tailgate images in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tailgateImages the tailgate images
	* @return the tailgate images that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateImages updateTailgateImages(
		com.rumbasolutions.flask.model.TailgateImages tailgateImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateImagesLocalService.updateTailgateImages(tailgateImages);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tailgateImagesLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tailgateImagesLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tailgateImagesLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TailgateImagesLocalService getWrappedTailgateImagesLocalService() {
		return _tailgateImagesLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTailgateImagesLocalService(
		TailgateImagesLocalService tailgateImagesLocalService) {
		_tailgateImagesLocalService = tailgateImagesLocalService;
	}

	@Override
	public TailgateImagesLocalService getWrappedService() {
		return _tailgateImagesLocalService;
	}

	@Override
	public void setWrappedService(
		TailgateImagesLocalService tailgateImagesLocalService) {
		_tailgateImagesLocalService = tailgateImagesLocalService;
	}

	private TailgateImagesLocalService _tailgateImagesLocalService;
}