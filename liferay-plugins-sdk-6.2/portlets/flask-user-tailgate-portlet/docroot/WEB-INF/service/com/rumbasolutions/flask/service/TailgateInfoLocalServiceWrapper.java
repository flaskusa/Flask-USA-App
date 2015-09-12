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
 * Provides a wrapper for {@link TailgateInfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TailgateInfoLocalService
 * @generated
 */
public class TailgateInfoLocalServiceWrapper implements TailgateInfoLocalService,
	ServiceWrapper<TailgateInfoLocalService> {
	public TailgateInfoLocalServiceWrapper(
		TailgateInfoLocalService tailgateInfoLocalService) {
		_tailgateInfoLocalService = tailgateInfoLocalService;
	}

	/**
	* Adds the tailgate info to the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateInfo the tailgate info
	* @return the tailgate info that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateInfo addTailgateInfo(
		com.rumbasolutions.flask.model.TailgateInfo tailgateInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateInfoLocalService.addTailgateInfo(tailgateInfo);
	}

	/**
	* Creates a new tailgate info with the primary key. Does not add the tailgate info to the database.
	*
	* @param tailgateId the primary key for the new tailgate info
	* @return the new tailgate info
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateInfo createTailgateInfo(
		long tailgateId) {
		return _tailgateInfoLocalService.createTailgateInfo(tailgateId);
	}

	/**
	* Deletes the tailgate info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateId the primary key of the tailgate info
	* @return the tailgate info that was removed
	* @throws PortalException if a tailgate info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateInfo deleteTailgateInfo(
		long tailgateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tailgateInfoLocalService.deleteTailgateInfo(tailgateId);
	}

	/**
	* Deletes the tailgate info from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateInfo the tailgate info
	* @return the tailgate info that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateInfo deleteTailgateInfo(
		com.rumbasolutions.flask.model.TailgateInfo tailgateInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateInfoLocalService.deleteTailgateInfo(tailgateInfo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tailgateInfoLocalService.dynamicQuery();
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
		return _tailgateInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tailgateInfoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _tailgateInfoLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _tailgateInfoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _tailgateInfoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rumbasolutions.flask.model.TailgateInfo fetchTailgateInfo(
		long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateInfoLocalService.fetchTailgateInfo(tailgateId);
	}

	/**
	* Returns the tailgate info with the primary key.
	*
	* @param tailgateId the primary key of the tailgate info
	* @return the tailgate info
	* @throws PortalException if a tailgate info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateInfo getTailgateInfo(
		long tailgateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tailgateInfoLocalService.getTailgateInfo(tailgateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tailgateInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tailgate infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tailgate infos
	* @param end the upper bound of the range of tailgate infos (not inclusive)
	* @return the range of tailgate infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rumbasolutions.flask.model.TailgateInfo> getTailgateInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateInfoLocalService.getTailgateInfos(start, end);
	}

	/**
	* Returns the number of tailgate infos.
	*
	* @return the number of tailgate infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTailgateInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateInfoLocalService.getTailgateInfosCount();
	}

	/**
	* Updates the tailgate info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tailgateInfo the tailgate info
	* @return the tailgate info that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.TailgateInfo updateTailgateInfo(
		com.rumbasolutions.flask.model.TailgateInfo tailgateInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tailgateInfoLocalService.updateTailgateInfo(tailgateInfo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _tailgateInfoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tailgateInfoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tailgateInfoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TailgateInfoLocalService getWrappedTailgateInfoLocalService() {
		return _tailgateInfoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTailgateInfoLocalService(
		TailgateInfoLocalService tailgateInfoLocalService) {
		_tailgateInfoLocalService = tailgateInfoLocalService;
	}

	@Override
	public TailgateInfoLocalService getWrappedService() {
		return _tailgateInfoLocalService;
	}

	@Override
	public void setWrappedService(
		TailgateInfoLocalService tailgateInfoLocalService) {
		_tailgateInfoLocalService = tailgateInfoLocalService;
	}

	private TailgateInfoLocalService _tailgateInfoLocalService;
}