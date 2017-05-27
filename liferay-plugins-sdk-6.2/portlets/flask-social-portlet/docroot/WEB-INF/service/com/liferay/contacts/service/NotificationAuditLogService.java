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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for NotificationAuditLog. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see NotificationAuditLogServiceUtil
 * @see com.liferay.contacts.service.base.NotificationAuditLogServiceBaseImpl
 * @see com.liferay.contacts.service.impl.NotificationAuditLogServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface NotificationAuditLogService extends BaseService,
	InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NotificationAuditLogServiceUtil} to access the notification audit log remote service. Add custom service methods to {@link com.liferay.contacts.service.impl.NotificationAuditLogServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public com.liferay.contacts.model.NotificationAuditLog addNotificationAuditLog(
		java.lang.String senderEmail, java.lang.String receiverEmail,
		java.lang.String messageReason, java.lang.String message,
		java.util.Date notificationTime);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> getAllNotificationAuditLog();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.contacts.model.NotificationAuditLog getNotificationAuditLog(
		long notificationAuditLogId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> getAllNotificationAuditLogBySenderEmail(
		java.lang.String senderEmail);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> getAllNotificationAuditLogByReceiverEmail(
		java.lang.String receiverEmail);

	public com.liferay.contacts.model.NotificationAuditLog updateNotificationAuditLog(
		long notificationAuditLogId, java.lang.String senderEmail,
		java.lang.String receiverEmail, java.lang.String messageReason,
		java.lang.String message, java.util.Date notificationTime);

	public void deleteNotificationAuditLog(long notificationAuditLogId);
}