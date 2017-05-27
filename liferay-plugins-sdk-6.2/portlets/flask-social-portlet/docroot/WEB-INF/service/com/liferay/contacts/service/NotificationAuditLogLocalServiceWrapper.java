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
 * Provides a wrapper for {@link NotificationAuditLogLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NotificationAuditLogLocalService
 * @generated
 */
public class NotificationAuditLogLocalServiceWrapper
	implements NotificationAuditLogLocalService,
		ServiceWrapper<NotificationAuditLogLocalService> {
	public NotificationAuditLogLocalServiceWrapper(
		NotificationAuditLogLocalService notificationAuditLogLocalService) {
		_notificationAuditLogLocalService = notificationAuditLogLocalService;
	}

	/**
	* Adds the notification audit log to the database. Also notifies the appropriate model listeners.
	*
	* @param notificationAuditLog the notification audit log
	* @return the notification audit log that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.NotificationAuditLog addNotificationAuditLog(
		com.liferay.contacts.model.NotificationAuditLog notificationAuditLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationAuditLogLocalService.addNotificationAuditLog(notificationAuditLog);
	}

	/**
	* Creates a new notification audit log with the primary key. Does not add the notification audit log to the database.
	*
	* @param notificationAuditLogId the primary key for the new notification audit log
	* @return the new notification audit log
	*/
	@Override
	public com.liferay.contacts.model.NotificationAuditLog createNotificationAuditLog(
		long notificationAuditLogId) {
		return _notificationAuditLogLocalService.createNotificationAuditLog(notificationAuditLogId);
	}

	/**
	* Deletes the notification audit log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationAuditLogId the primary key of the notification audit log
	* @return the notification audit log that was removed
	* @throws PortalException if a notification audit log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.NotificationAuditLog deleteNotificationAuditLog(
		long notificationAuditLogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _notificationAuditLogLocalService.deleteNotificationAuditLog(notificationAuditLogId);
	}

	/**
	* Deletes the notification audit log from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationAuditLog the notification audit log
	* @return the notification audit log that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.NotificationAuditLog deleteNotificationAuditLog(
		com.liferay.contacts.model.NotificationAuditLog notificationAuditLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationAuditLogLocalService.deleteNotificationAuditLog(notificationAuditLog);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _notificationAuditLogLocalService.dynamicQuery();
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
		return _notificationAuditLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.NotificationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _notificationAuditLogLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.NotificationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _notificationAuditLogLocalService.dynamicQuery(dynamicQuery,
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
		return _notificationAuditLogLocalService.dynamicQueryCount(dynamicQuery);
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
		return _notificationAuditLogLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.contacts.model.NotificationAuditLog fetchNotificationAuditLog(
		long notificationAuditLogId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationAuditLogLocalService.fetchNotificationAuditLog(notificationAuditLogId);
	}

	/**
	* Returns the notification audit log with the primary key.
	*
	* @param notificationAuditLogId the primary key of the notification audit log
	* @return the notification audit log
	* @throws PortalException if a notification audit log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.NotificationAuditLog getNotificationAuditLog(
		long notificationAuditLogId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _notificationAuditLogLocalService.getNotificationAuditLog(notificationAuditLogId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _notificationAuditLogLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the notification audit logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.NotificationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notification audit logs
	* @param end the upper bound of the range of notification audit logs (not inclusive)
	* @return the range of notification audit logs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> getNotificationAuditLogs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationAuditLogLocalService.getNotificationAuditLogs(start,
			end);
	}

	/**
	* Returns the number of notification audit logs.
	*
	* @return the number of notification audit logs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getNotificationAuditLogsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationAuditLogLocalService.getNotificationAuditLogsCount();
	}

	/**
	* Updates the notification audit log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param notificationAuditLog the notification audit log
	* @return the notification audit log that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.contacts.model.NotificationAuditLog updateNotificationAuditLog(
		com.liferay.contacts.model.NotificationAuditLog notificationAuditLog)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationAuditLogLocalService.updateNotificationAuditLog(notificationAuditLog);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _notificationAuditLogLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_notificationAuditLogLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _notificationAuditLogLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public NotificationAuditLogLocalService getWrappedNotificationAuditLogLocalService() {
		return _notificationAuditLogLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedNotificationAuditLogLocalService(
		NotificationAuditLogLocalService notificationAuditLogLocalService) {
		_notificationAuditLogLocalService = notificationAuditLogLocalService;
	}

	@Override
	public NotificationAuditLogLocalService getWrappedService() {
		return _notificationAuditLogLocalService;
	}

	@Override
	public void setWrappedService(
		NotificationAuditLogLocalService notificationAuditLogLocalService) {
		_notificationAuditLogLocalService = notificationAuditLogLocalService;
	}

	private NotificationAuditLogLocalService _notificationAuditLogLocalService;
}