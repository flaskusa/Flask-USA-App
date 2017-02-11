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
 * Provides a wrapper for {@link VenueSubDetailLocalService}.
 *
 * @author Ashutosh Rai
 * @see VenueSubDetailLocalService
 * @generated
 */
public class VenueSubDetailLocalServiceWrapper
	implements VenueSubDetailLocalService,
		ServiceWrapper<VenueSubDetailLocalService> {
	public VenueSubDetailLocalServiceWrapper(
		VenueSubDetailLocalService venueSubDetailLocalService) {
		_venueSubDetailLocalService = venueSubDetailLocalService;
	}

	/**
	* Adds the venue sub detail to the database. Also notifies the appropriate model listeners.
	*
	* @param venueSubDetail the venue sub detail
	* @return the venue sub detail that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueSubDetail addVenueSubDetail(
		com.rumbasolutions.flask.model.VenueSubDetail venueSubDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueSubDetailLocalService.addVenueSubDetail(venueSubDetail);
	}

	/**
	* Creates a new venue sub detail with the primary key. Does not add the venue sub detail to the database.
	*
	* @param venueSubDetailId the primary key for the new venue sub detail
	* @return the new venue sub detail
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueSubDetail createVenueSubDetail(
		long venueSubDetailId) {
		return _venueSubDetailLocalService.createVenueSubDetail(venueSubDetailId);
	}

	/**
	* Deletes the venue sub detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueSubDetailId the primary key of the venue sub detail
	* @return the venue sub detail that was removed
	* @throws PortalException if a venue sub detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueSubDetail deleteVenueSubDetail(
		long venueSubDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _venueSubDetailLocalService.deleteVenueSubDetail(venueSubDetailId);
	}

	/**
	* Deletes the venue sub detail from the database. Also notifies the appropriate model listeners.
	*
	* @param venueSubDetail the venue sub detail
	* @return the venue sub detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueSubDetail deleteVenueSubDetail(
		com.rumbasolutions.flask.model.VenueSubDetail venueSubDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueSubDetailLocalService.deleteVenueSubDetail(venueSubDetail);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _venueSubDetailLocalService.dynamicQuery();
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
		return _venueSubDetailLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _venueSubDetailLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _venueSubDetailLocalService.dynamicQuery(dynamicQuery, start,
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
		return _venueSubDetailLocalService.dynamicQueryCount(dynamicQuery);
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
		return _venueSubDetailLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rumbasolutions.flask.model.VenueSubDetail fetchVenueSubDetail(
		long venueSubDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueSubDetailLocalService.fetchVenueSubDetail(venueSubDetailId);
	}

	/**
	* Returns the venue sub detail with the primary key.
	*
	* @param venueSubDetailId the primary key of the venue sub detail
	* @return the venue sub detail
	* @throws PortalException if a venue sub detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueSubDetail getVenueSubDetail(
		long venueSubDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _venueSubDetailLocalService.getVenueSubDetail(venueSubDetailId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _venueSubDetailLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the venue sub details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue sub details
	* @param end the upper bound of the range of venue sub details (not inclusive)
	* @return the range of venue sub details
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> getVenueSubDetails(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueSubDetailLocalService.getVenueSubDetails(start, end);
	}

	/**
	* Returns the number of venue sub details.
	*
	* @return the number of venue sub details
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVenueSubDetailsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueSubDetailLocalService.getVenueSubDetailsCount();
	}

	/**
	* Updates the venue sub detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param venueSubDetail the venue sub detail
	* @return the venue sub detail that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.VenueSubDetail updateVenueSubDetail(
		com.rumbasolutions.flask.model.VenueSubDetail venueSubDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _venueSubDetailLocalService.updateVenueSubDetail(venueSubDetail);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _venueSubDetailLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_venueSubDetailLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _venueSubDetailLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VenueSubDetailLocalService getWrappedVenueSubDetailLocalService() {
		return _venueSubDetailLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVenueSubDetailLocalService(
		VenueSubDetailLocalService venueSubDetailLocalService) {
		_venueSubDetailLocalService = venueSubDetailLocalService;
	}

	@Override
	public VenueSubDetailLocalService getWrappedService() {
		return _venueSubDetailLocalService;
	}

	@Override
	public void setWrappedService(
		VenueSubDetailLocalService venueSubDetailLocalService) {
		_venueSubDetailLocalService = venueSubDetailLocalService;
	}

	private VenueSubDetailLocalService _venueSubDetailLocalService;
}