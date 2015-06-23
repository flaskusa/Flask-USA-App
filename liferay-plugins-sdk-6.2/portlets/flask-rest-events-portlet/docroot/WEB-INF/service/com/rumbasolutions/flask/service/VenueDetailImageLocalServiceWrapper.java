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
 * Provides a wrapper for {@link VenueDetailImageLocalService}.
 *
 * @author Ashutosh Rai
 * @see VenueDetailImageLocalService
 * @generated
 */
public class VenueDetailImageLocalServiceWrapper
	implements VenueDetailImageLocalService,
		ServiceWrapper<VenueDetailImageLocalService> {
	public VenueDetailImageLocalServiceWrapper(
		VenueDetailImageLocalService venueDetailImageLocalService) {
		_venueDetailImageLocalService = venueDetailImageLocalService;
	}

	/**
	* Adds the venue detail image to the database. Also notifies the appropriate model listeners.
	*
	* @param venueDetailImage the venue detail image
	* @return the venue detail image that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueDetailImage addVenueDetailImage(
		com.rumbasolutions.flask.model.VenueDetailImage venueDetailImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDetailImageLocalService.addVenueDetailImage(venueDetailImage);
	}

	/**
	* Creates a new venue detail image with the primary key. Does not add the venue detail image to the database.
	*
	* @param venueDetailImageId the primary key for the new venue detail image
	* @return the new venue detail image
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueDetailImage createVenueDetailImage(
		long venueDetailImageId) {
		return _venueDetailImageLocalService.createVenueDetailImage(venueDetailImageId);
	}

	/**
	* Deletes the venue detail image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueDetailImageId the primary key of the venue detail image
	* @return the venue detail image that was removed
	* @throws PortalException if a venue detail image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueDetailImage deleteVenueDetailImage(
		long venueDetailImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _venueDetailImageLocalService.deleteVenueDetailImage(venueDetailImageId);
	}

	/**
	* Deletes the venue detail image from the database. Also notifies the appropriate model listeners.
	*
	* @param venueDetailImage the venue detail image
	* @return the venue detail image that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueDetailImage deleteVenueDetailImage(
		com.rumbasolutions.flask.model.VenueDetailImage venueDetailImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDetailImageLocalService.deleteVenueDetailImage(venueDetailImage);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _venueDetailImageLocalService.dynamicQuery();
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
		return _venueDetailImageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _venueDetailImageLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _venueDetailImageLocalService.dynamicQuery(dynamicQuery, start,
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
		return _venueDetailImageLocalService.dynamicQueryCount(dynamicQuery);
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
		return _venueDetailImageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueDetailImage fetchVenueDetailImage(
		long venueDetailImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDetailImageLocalService.fetchVenueDetailImage(venueDetailImageId);
	}

	/**
	* Returns the venue detail image with the primary key.
	*
	* @param venueDetailImageId the primary key of the venue detail image
	* @return the venue detail image
	* @throws PortalException if a venue detail image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueDetailImage getVenueDetailImage(
		long venueDetailImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _venueDetailImageLocalService.getVenueDetailImage(venueDetailImageId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _venueDetailImageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the venue detail images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue detail images
	* @param end the upper bound of the range of venue detail images (not inclusive)
	* @return the range of venue detail images
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> getVenueDetailImages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDetailImageLocalService.getVenueDetailImages(start, end);
	}

	/**
	* Returns the number of venue detail images.
	*
	* @return the number of venue detail images
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVenueDetailImagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDetailImageLocalService.getVenueDetailImagesCount();
	}

	/**
	* Updates the venue detail image in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param venueDetailImage the venue detail image
	* @return the venue detail image that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueDetailImage updateVenueDetailImage(
		com.rumbasolutions.flask.model.VenueDetailImage venueDetailImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueDetailImageLocalService.updateVenueDetailImage(venueDetailImage);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _venueDetailImageLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_venueDetailImageLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _venueDetailImageLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VenueDetailImageLocalService getWrappedVenueDetailImageLocalService() {
		return _venueDetailImageLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVenueDetailImageLocalService(
		VenueDetailImageLocalService venueDetailImageLocalService) {
		_venueDetailImageLocalService = venueDetailImageLocalService;
	}

	@Override
	public VenueDetailImageLocalService getWrappedService() {
		return _venueDetailImageLocalService;
	}

	@Override
	public void setWrappedService(
		VenueDetailImageLocalService venueDetailImageLocalService) {
		_venueDetailImageLocalService = venueDetailImageLocalService;
	}

	private VenueDetailImageLocalService _venueDetailImageLocalService;
}