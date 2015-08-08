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
 * Provides a wrapper for {@link FlaskGroupLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupLocalService
 * @generated
 */
public class FlaskGroupLocalServiceWrapper implements FlaskGroupLocalService,
	ServiceWrapper<FlaskGroupLocalService> {
	public FlaskGroupLocalServiceWrapper(
		FlaskGroupLocalService flaskGroupLocalService) {
		_flaskGroupLocalService = flaskGroupLocalService;
	}

	/**
	* Adds the flask group to the database. Also notifies the appropriate model listeners.
	*
	* @param flaskGroup the flask group
	* @return the flask group that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.FlaskGroup addFlaskGroup(
		com.rumbasolutions.flask.model.FlaskGroup flaskGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupLocalService.addFlaskGroup(flaskGroup);
	}

	/**
	* Creates a new flask group with the primary key. Does not add the flask group to the database.
	*
	* @param groupId the primary key for the new flask group
	* @return the new flask group
	*/
	@Override
	public com.rumbasolutions.flask.model.FlaskGroup createFlaskGroup(
		long groupId) {
		return _flaskGroupLocalService.createFlaskGroup(groupId);
	}

	/**
	* Deletes the flask group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupId the primary key of the flask group
	* @return the flask group that was removed
	* @throws PortalException if a flask group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.FlaskGroup deleteFlaskGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupLocalService.deleteFlaskGroup(groupId);
	}

	/**
	* Deletes the flask group from the database. Also notifies the appropriate model listeners.
	*
	* @param flaskGroup the flask group
	* @return the flask group that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.FlaskGroup deleteFlaskGroup(
		com.rumbasolutions.flask.model.FlaskGroup flaskGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupLocalService.deleteFlaskGroup(flaskGroup);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _flaskGroupLocalService.dynamicQuery();
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
		return _flaskGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _flaskGroupLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _flaskGroupLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _flaskGroupLocalService.dynamicQueryCount(dynamicQuery);
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
		return _flaskGroupLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rumbasolutions.flask.model.FlaskGroup fetchFlaskGroup(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupLocalService.fetchFlaskGroup(groupId);
	}

	/**
	* Returns the flask group with the primary key.
	*
	* @param groupId the primary key of the flask group
	* @return the flask group
	* @throws PortalException if a flask group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.FlaskGroup getFlaskGroup(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupLocalService.getFlaskGroup(groupId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the flask groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask groups
	* @param end the upper bound of the range of flask groups (not inclusive)
	* @return the range of flask groups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroup> getFlaskGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupLocalService.getFlaskGroups(start, end);
	}

	/**
	* Returns the number of flask groups.
	*
	* @return the number of flask groups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFlaskGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupLocalService.getFlaskGroupsCount();
	}

	/**
	* Updates the flask group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param flaskGroup the flask group
	* @return the flask group that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.FlaskGroup updateFlaskGroup(
		com.rumbasolutions.flask.model.FlaskGroup flaskGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupLocalService.updateFlaskGroup(flaskGroup);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _flaskGroupLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_flaskGroupLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _flaskGroupLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FlaskGroupLocalService getWrappedFlaskGroupLocalService() {
		return _flaskGroupLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFlaskGroupLocalService(
		FlaskGroupLocalService flaskGroupLocalService) {
		_flaskGroupLocalService = flaskGroupLocalService;
	}

	@Override
	public FlaskGroupLocalService getWrappedService() {
		return _flaskGroupLocalService;
	}

	@Override
	public void setWrappedService(FlaskGroupLocalService flaskGroupLocalService) {
		_flaskGroupLocalService = flaskGroupLocalService;
	}

	private FlaskGroupLocalService _flaskGroupLocalService;
}