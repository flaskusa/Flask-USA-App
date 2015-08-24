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
 * Provides a wrapper for {@link InvitationInfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see InvitationInfoLocalService
 * @generated
 */
public class InvitationInfoLocalServiceWrapper
	implements InvitationInfoLocalService,
		ServiceWrapper<InvitationInfoLocalService> {
	public InvitationInfoLocalServiceWrapper(
		InvitationInfoLocalService invitationInfoLocalService) {
		_invitationInfoLocalService = invitationInfoLocalService;
	}

	/**
	* Adds the invitation info to the database. Also notifies the appropriate model listeners.
	*
	* @param invitationInfo the invitation info
	* @return the invitation info that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.InvitationInfo addInvitationInfo(
		com.rumbasolutions.flask.model.InvitationInfo invitationInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationInfoLocalService.addInvitationInfo(invitationInfo);
	}

	/**
	* Creates a new invitation info with the primary key. Does not add the invitation info to the database.
	*
	* @param inviationId the primary key for the new invitation info
	* @return the new invitation info
	*/
	@Override
	public com.rumbasolutions.flask.model.InvitationInfo createInvitationInfo(
		long inviationId) {
		return _invitationInfoLocalService.createInvitationInfo(inviationId);
	}

	/**
	* Deletes the invitation info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inviationId the primary key of the invitation info
	* @return the invitation info that was removed
	* @throws PortalException if a invitation info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.InvitationInfo deleteInvitationInfo(
		long inviationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _invitationInfoLocalService.deleteInvitationInfo(inviationId);
	}

	/**
	* Deletes the invitation info from the database. Also notifies the appropriate model listeners.
	*
	* @param invitationInfo the invitation info
	* @return the invitation info that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.InvitationInfo deleteInvitationInfo(
		com.rumbasolutions.flask.model.InvitationInfo invitationInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationInfoLocalService.deleteInvitationInfo(invitationInfo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _invitationInfoLocalService.dynamicQuery();
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
		return _invitationInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InvitationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _invitationInfoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InvitationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _invitationInfoLocalService.dynamicQuery(dynamicQuery, start,
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
		return _invitationInfoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _invitationInfoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rumbasolutions.flask.model.InvitationInfo fetchInvitationInfo(
		long inviationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationInfoLocalService.fetchInvitationInfo(inviationId);
	}

	/**
	* Returns the invitation info with the primary key.
	*
	* @param inviationId the primary key of the invitation info
	* @return the invitation info
	* @throws PortalException if a invitation info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.InvitationInfo getInvitationInfo(
		long inviationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _invitationInfoLocalService.getInvitationInfo(inviationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _invitationInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the invitation infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InvitationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of invitation infos
	* @param end the upper bound of the range of invitation infos (not inclusive)
	* @return the range of invitation infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.rumbasolutions.flask.model.InvitationInfo> getInvitationInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationInfoLocalService.getInvitationInfos(start, end);
	}

	/**
	* Returns the number of invitation infos.
	*
	* @return the number of invitation infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getInvitationInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationInfoLocalService.getInvitationInfosCount();
	}

	/**
	* Updates the invitation info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param invitationInfo the invitation info
	* @return the invitation info that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.InvitationInfo updateInvitationInfo(
		com.rumbasolutions.flask.model.InvitationInfo invitationInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _invitationInfoLocalService.updateInvitationInfo(invitationInfo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _invitationInfoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_invitationInfoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _invitationInfoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public InvitationInfoLocalService getWrappedInvitationInfoLocalService() {
		return _invitationInfoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedInvitationInfoLocalService(
		InvitationInfoLocalService invitationInfoLocalService) {
		_invitationInfoLocalService = invitationInfoLocalService;
	}

	@Override
	public InvitationInfoLocalService getWrappedService() {
		return _invitationInfoLocalService;
	}

	@Override
	public void setWrappedService(
		InvitationInfoLocalService invitationInfoLocalService) {
		_invitationInfoLocalService = invitationInfoLocalService;
	}

	private InvitationInfoLocalService _invitationInfoLocalService;
}