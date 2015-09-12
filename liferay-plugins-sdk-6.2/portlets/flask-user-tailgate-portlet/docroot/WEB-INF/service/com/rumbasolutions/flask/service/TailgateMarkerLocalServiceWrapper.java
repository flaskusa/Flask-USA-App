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
 * Provides a wrapper for {@link TailgateMarkerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TailgateMarkerLocalService
 * @generated
 */
public class TailgateMarkerLocalServiceWrapper
	implements TailgateMarkerLocalService,
		ServiceWrapper<TailgateMarkerLocalService> {
	public TailgateMarkerLocalServiceWrapper(
		TailgateMarkerLocalService tailgateMarkerLocalService) {
		_tailgateMarkerLocalService = tailgateMarkerLocalService;
	}

	/**
	* Adds the tailgate marker to the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateMarker the tailgate marker
	* @return the tailgate marker that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateMarker addTailgateMarker(
		com.rumbasolutions.flask.model.TailgateMarker tailgateMarker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateMarkerLocalService.addTailgateMarker(tailgateMarker);
	}

	/**
	* Creates a new tailgate marker with the primary key. Does not add the tailgate marker to the database.
	*
	* @param tailgatemarkerid the primary key for the new tailgate marker
	* @return the new tailgate marker
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateMarker createTailgateMarker(
		long tailgatemarkerid) {
		return _tailgateMarkerLocalService.createTailgateMarker(tailgatemarkerid);
	}

	/**
	* Deletes the tailgate marker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgatemarkerid the primary key of the tailgate marker
	* @return the tailgate marker that was removed
	* @throws PortalException if a tailgate marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateMarker deleteTailgateMarker(
		long tailgatemarkerid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tailgateMarkerLocalService.deleteTailgateMarker(tailgatemarkerid);
	}

	/**
	* Deletes the tailgate marker from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateMarker the tailgate marker
	* @return the tailgate marker that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateMarker deleteTailgateMarker(
		com.rumbasolutions.flask.model.TailgateMarker tailgateMarker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateMarkerLocalService.deleteTailgateMarker(tailgateMarker);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tailgateMarkerLocalService.dynamicQuery();
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
		return _tailgateMarkerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateMarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tailgateMarkerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateMarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tailgateMarkerLocalService.dynamicQuery(dynamicQuery, start,
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
		return _tailgateMarkerLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tailgateMarkerLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateMarker fetchTailgateMarker(
		long tailgatemarkerid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateMarkerLocalService.fetchTailgateMarker(tailgatemarkerid);
	}

	/**
	* Returns the tailgate marker with the primary key.
	*
	* @param tailgatemarkerid the primary key of the tailgate marker
	* @return the tailgate marker
	* @throws PortalException if a tailgate marker with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateMarker getTailgateMarker(
		long tailgatemarkerid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tailgateMarkerLocalService.getTailgateMarker(tailgatemarkerid);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tailgateMarkerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tailgate markers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateMarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tailgate markers
	* @param end the upper bound of the range of tailgate markers (not inclusive)
	* @return the range of tailgate markers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateMarker> getTailgateMarkers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateMarkerLocalService.getTailgateMarkers(start, end);
	}

	/**
	* Returns the number of tailgate markers.
	*
	* @return the number of tailgate markers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTailgateMarkersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateMarkerLocalService.getTailgateMarkersCount();
	}

	/**
	* Updates the tailgate marker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tailgateMarker the tailgate marker
	* @return the tailgate marker that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateMarker updateTailgateMarker(
		com.rumbasolutions.flask.model.TailgateMarker tailgateMarker)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateMarkerLocalService.updateTailgateMarker(tailgateMarker);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tailgateMarkerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tailgateMarkerLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tailgateMarkerLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TailgateMarkerLocalService getWrappedTailgateMarkerLocalService() {
		return _tailgateMarkerLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTailgateMarkerLocalService(
		TailgateMarkerLocalService tailgateMarkerLocalService) {
		_tailgateMarkerLocalService = tailgateMarkerLocalService;
	}

	@Override
	public TailgateMarkerLocalService getWrappedService() {
		return _tailgateMarkerLocalService;
	}

	@Override
	public void setWrappedService(
		TailgateMarkerLocalService tailgateMarkerLocalService) {
		_tailgateMarkerLocalService = tailgateMarkerLocalService;
	}

	private TailgateMarkerLocalService _tailgateMarkerLocalService;
}