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
 * Provides a wrapper for {@link EventDetailImageLocalService}.
 *
 * @author Ashutosh Rai
 * @see EventDetailImageLocalService
 * @generated
 */
public class EventDetailImageLocalServiceWrapper
	implements EventDetailImageLocalService,
		ServiceWrapper<EventDetailImageLocalService> {
	public EventDetailImageLocalServiceWrapper(
		EventDetailImageLocalService eventDetailImageLocalService) {
		_eventDetailImageLocalService = eventDetailImageLocalService;
	}

	/**
	* Adds the event detail image to the database. Also notifies the appropriate model listeners.
	*
	* @param eventDetailImage the event detail image
	* @return the event detail image that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.EventDetailImage addEventDetailImage(
		com.rumbasolutions.flask.model.EventDetailImage eventDetailImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventDetailImageLocalService.addEventDetailImage(eventDetailImage);
	}

	/**
	* Creates a new event detail image with the primary key. Does not add the event detail image to the database.
	*
	* @param eventDetailImageId the primary key for the new event detail image
	* @return the new event detail image
	*/
	@Override
	public com.rumbasolutions.flask.model.EventDetailImage createEventDetailImage(
		long eventDetailImageId) {
		return _eventDetailImageLocalService.createEventDetailImage(eventDetailImageId);
	}

	/**
	* Deletes the event detail image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventDetailImageId the primary key of the event detail image
	* @return the event detail image that was removed
	* @throws PortalException if a event detail image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.EventDetailImage deleteEventDetailImage(
		long eventDetailImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventDetailImageLocalService.deleteEventDetailImage(eventDetailImageId);
	}

	/**
	* Deletes the event detail image from the database. Also notifies the appropriate model listeners.
	*
	* @param eventDetailImage the event detail image
	* @return the event detail image that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.EventDetailImage deleteEventDetailImage(
		com.rumbasolutions.flask.model.EventDetailImage eventDetailImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventDetailImageLocalService.deleteEventDetailImage(eventDetailImage);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eventDetailImageLocalService.dynamicQuery();
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
		return _eventDetailImageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _eventDetailImageLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _eventDetailImageLocalService.dynamicQuery(dynamicQuery, start,
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
		return _eventDetailImageLocalService.dynamicQueryCount(dynamicQuery);
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
		return _eventDetailImageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rumbasolutions.flask.model.EventDetailImage fetchEventDetailImage(
		long eventDetailImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventDetailImageLocalService.fetchEventDetailImage(eventDetailImageId);
	}

	/**
	* Returns the event detail image with the primary key.
	*
	* @param eventDetailImageId the primary key of the event detail image
	* @return the event detail image
	* @throws PortalException if a event detail image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.EventDetailImage getEventDetailImage(
		long eventDetailImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventDetailImageLocalService.getEventDetailImage(eventDetailImageId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eventDetailImageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the event detail images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event detail images
	* @param end the upper bound of the range of event detail images (not inclusive)
	* @return the range of event detail images
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rumbasolutions.flask.model.EventDetailImage> getEventDetailImages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventDetailImageLocalService.getEventDetailImages(start, end);
	}

	/**
	* Returns the number of event detail images.
	*
	* @return the number of event detail images
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEventDetailImagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventDetailImageLocalService.getEventDetailImagesCount();
	}

	/**
	* Updates the event detail image in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventDetailImage the event detail image
	* @return the event detail image that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.EventDetailImage updateEventDetailImage(
		com.rumbasolutions.flask.model.EventDetailImage eventDetailImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eventDetailImageLocalService.updateEventDetailImage(eventDetailImage);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _eventDetailImageLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eventDetailImageLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eventDetailImageLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EventDetailImageLocalService getWrappedEventDetailImageLocalService() {
		return _eventDetailImageLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEventDetailImageLocalService(
		EventDetailImageLocalService eventDetailImageLocalService) {
		_eventDetailImageLocalService = eventDetailImageLocalService;
	}

	@Override
	public EventDetailImageLocalService getWrappedService() {
		return _eventDetailImageLocalService;
	}

	@Override
	public void setWrappedService(
		EventDetailImageLocalService eventDetailImageLocalService) {
		_eventDetailImageLocalService = eventDetailImageLocalService;
	}

	private EventDetailImageLocalService _eventDetailImageLocalService;
}