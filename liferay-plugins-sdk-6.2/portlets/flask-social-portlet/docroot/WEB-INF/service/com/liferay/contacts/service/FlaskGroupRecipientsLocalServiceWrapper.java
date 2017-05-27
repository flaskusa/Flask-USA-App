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

package com.liferay.contacts.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FlaskGroupRecipientsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupRecipientsLocalService
 * @generated
 */
public class FlaskGroupRecipientsLocalServiceWrapper
	implements FlaskGroupRecipientsLocalService,
		ServiceWrapper<FlaskGroupRecipientsLocalService> {
	public FlaskGroupRecipientsLocalServiceWrapper(
		FlaskGroupRecipientsLocalService flaskGroupRecipientsLocalService) {
		_flaskGroupRecipientsLocalService = flaskGroupRecipientsLocalService;
	}

	/**
	* Adds the flask group recipients to the database. Also notifies the appropriate model listeners.
	*
	* @param flaskGroupRecipients the flask group recipients
	* @return the flask group recipients that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.FlaskGroupRecipients addFlaskGroupRecipients(
		com.liferay.contacts.model.FlaskGroupRecipients flaskGroupRecipients)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupRecipientsLocalService.addFlaskGroupRecipients(flaskGroupRecipients);
	}

	/**
	* Creates a new flask group recipients with the primary key. Does not add the flask group recipients to the database.
	*
	* @param groupRecipientId the primary key for the new flask group recipients
	* @return the new flask group recipients
	*/
	@Override
	public com.liferay.contacts.model.FlaskGroupRecipients createFlaskGroupRecipients(
		long groupRecipientId) {
		return _flaskGroupRecipientsLocalService.createFlaskGroupRecipients(groupRecipientId);
	}

	/**
	* Deletes the flask group recipients with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupRecipientId the primary key of the flask group recipients
	* @return the flask group recipients that was removed
	* @throws PortalException if a flask group recipients with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.FlaskGroupRecipients deleteFlaskGroupRecipients(
		long groupRecipientId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupRecipientsLocalService.deleteFlaskGroupRecipients(groupRecipientId);
	}

	/**
	* Deletes the flask group recipients from the database. Also notifies the appropriate model listeners.
	*
	* @param flaskGroupRecipients the flask group recipients
	* @return the flask group recipients that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.FlaskGroupRecipients deleteFlaskGroupRecipients(
		com.liferay.contacts.model.FlaskGroupRecipients flaskGroupRecipients)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupRecipientsLocalService.deleteFlaskGroupRecipients(flaskGroupRecipients);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _flaskGroupRecipientsLocalService.dynamicQuery();
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
		return _flaskGroupRecipientsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _flaskGroupRecipientsLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _flaskGroupRecipientsLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _flaskGroupRecipientsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _flaskGroupRecipientsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.contacts.model.FlaskGroupRecipients fetchFlaskGroupRecipients(
		long groupRecipientId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupRecipientsLocalService.fetchFlaskGroupRecipients(groupRecipientId);
	}

	/**
	* Returns the flask group recipients with the primary key.
	*
	* @param groupRecipientId the primary key of the flask group recipients
	* @return the flask group recipients
	* @throws PortalException if a flask group recipients with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.FlaskGroupRecipients getFlaskGroupRecipients(
		long groupRecipientId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupRecipientsLocalService.getFlaskGroupRecipients(groupRecipientId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupRecipientsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the flask group recipientses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask group recipientses
	* @param end the upper bound of the range of flask group recipientses (not inclusive)
	* @return the range of flask group recipientses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.contacts.model.FlaskGroupRecipients> getFlaskGroupRecipientses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupRecipientsLocalService.getFlaskGroupRecipientses(start,
			end);
	}

	/**
	* Returns the number of flask group recipientses.
	*
	* @return the number of flask group recipientses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFlaskGroupRecipientsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupRecipientsLocalService.getFlaskGroupRecipientsesCount();
	}

	/**
	* Updates the flask group recipients in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param flaskGroupRecipients the flask group recipients
	* @return the flask group recipients that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.FlaskGroupRecipients updateFlaskGroupRecipients(
		com.liferay.contacts.model.FlaskGroupRecipients flaskGroupRecipients)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _flaskGroupRecipientsLocalService.updateFlaskGroupRecipients(flaskGroupRecipients);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _flaskGroupRecipientsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_flaskGroupRecipientsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _flaskGroupRecipientsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public FlaskGroupRecipientsLocalService getWrappedFlaskGroupRecipientsLocalService() {
		return _flaskGroupRecipientsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFlaskGroupRecipientsLocalService(
		FlaskGroupRecipientsLocalService flaskGroupRecipientsLocalService) {
		_flaskGroupRecipientsLocalService = flaskGroupRecipientsLocalService;
	}

	@Override
	public FlaskGroupRecipientsLocalService getWrappedService() {
		return _flaskGroupRecipientsLocalService;
	}

	@Override
	public void setWrappedService(
		FlaskGroupRecipientsLocalService flaskGroupRecipientsLocalService) {
		_flaskGroupRecipientsLocalService = flaskGroupRecipientsLocalService;
	}

	private FlaskGroupRecipientsLocalService _flaskGroupRecipientsLocalService;
}