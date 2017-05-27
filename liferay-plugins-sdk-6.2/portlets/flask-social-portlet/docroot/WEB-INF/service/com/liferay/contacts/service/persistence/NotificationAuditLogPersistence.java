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

package com.liferay.contacts.service.persistence;

import com.liferay.contacts.model.NotificationAuditLog;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the notification audit log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationAuditLogPersistenceImpl
 * @see NotificationAuditLogUtil
 * @generated
 */
public interface NotificationAuditLogPersistence extends BasePersistence<NotificationAuditLog> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NotificationAuditLogUtil} to access the notification audit log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the notification audit logs where senderEmail = &#63;.
	*
	* @param senderEmail the sender email
	* @return the matching notification audit logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> findBynotificationBySenderEmail(
		java.lang.String senderEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the notification audit logs where senderEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.NotificationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param senderEmail the sender email
	* @param start the lower bound of the range of notification audit logs
	* @param end the upper bound of the range of notification audit logs (not inclusive)
	* @return the range of matching notification audit logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> findBynotificationBySenderEmail(
		java.lang.String senderEmail, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the notification audit logs where senderEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.NotificationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param senderEmail the sender email
	* @param start the lower bound of the range of notification audit logs
	* @param end the upper bound of the range of notification audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notification audit logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> findBynotificationBySenderEmail(
		java.lang.String senderEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first notification audit log in the ordered set where senderEmail = &#63;.
	*
	* @param senderEmail the sender email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification audit log
	* @throws com.liferay.contacts.NoSuchNotificationAuditLogException if a matching notification audit log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.NotificationAuditLog findBynotificationBySenderEmail_First(
		java.lang.String senderEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchNotificationAuditLogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first notification audit log in the ordered set where senderEmail = &#63;.
	*
	* @param senderEmail the sender email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification audit log, or <code>null</code> if a matching notification audit log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.NotificationAuditLog fetchBynotificationBySenderEmail_First(
		java.lang.String senderEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last notification audit log in the ordered set where senderEmail = &#63;.
	*
	* @param senderEmail the sender email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification audit log
	* @throws com.liferay.contacts.NoSuchNotificationAuditLogException if a matching notification audit log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.NotificationAuditLog findBynotificationBySenderEmail_Last(
		java.lang.String senderEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchNotificationAuditLogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last notification audit log in the ordered set where senderEmail = &#63;.
	*
	* @param senderEmail the sender email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification audit log, or <code>null</code> if a matching notification audit log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.NotificationAuditLog fetchBynotificationBySenderEmail_Last(
		java.lang.String senderEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notification audit logs before and after the current notification audit log in the ordered set where senderEmail = &#63;.
	*
	* @param notificationAuditLogId the primary key of the current notification audit log
	* @param senderEmail the sender email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notification audit log
	* @throws com.liferay.contacts.NoSuchNotificationAuditLogException if a notification audit log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.NotificationAuditLog[] findBynotificationBySenderEmail_PrevAndNext(
		long notificationAuditLogId, java.lang.String senderEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchNotificationAuditLogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the notification audit logs where senderEmail = &#63; from the database.
	*
	* @param senderEmail the sender email
	* @throws SystemException if a system exception occurred
	*/
	public void removeBynotificationBySenderEmail(java.lang.String senderEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of notification audit logs where senderEmail = &#63;.
	*
	* @param senderEmail the sender email
	* @return the number of matching notification audit logs
	* @throws SystemException if a system exception occurred
	*/
	public int countBynotificationBySenderEmail(java.lang.String senderEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the notification audit logs where receiverEmail = &#63;.
	*
	* @param receiverEmail the receiver email
	* @return the matching notification audit logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> findBynotificationReceiverEmail(
		java.lang.String receiverEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the notification audit logs where receiverEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.NotificationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverEmail the receiver email
	* @param start the lower bound of the range of notification audit logs
	* @param end the upper bound of the range of notification audit logs (not inclusive)
	* @return the range of matching notification audit logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> findBynotificationReceiverEmail(
		java.lang.String receiverEmail, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the notification audit logs where receiverEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.NotificationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param receiverEmail the receiver email
	* @param start the lower bound of the range of notification audit logs
	* @param end the upper bound of the range of notification audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notification audit logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> findBynotificationReceiverEmail(
		java.lang.String receiverEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first notification audit log in the ordered set where receiverEmail = &#63;.
	*
	* @param receiverEmail the receiver email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification audit log
	* @throws com.liferay.contacts.NoSuchNotificationAuditLogException if a matching notification audit log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.NotificationAuditLog findBynotificationReceiverEmail_First(
		java.lang.String receiverEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchNotificationAuditLogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first notification audit log in the ordered set where receiverEmail = &#63;.
	*
	* @param receiverEmail the receiver email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification audit log, or <code>null</code> if a matching notification audit log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.NotificationAuditLog fetchBynotificationReceiverEmail_First(
		java.lang.String receiverEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last notification audit log in the ordered set where receiverEmail = &#63;.
	*
	* @param receiverEmail the receiver email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification audit log
	* @throws com.liferay.contacts.NoSuchNotificationAuditLogException if a matching notification audit log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.NotificationAuditLog findBynotificationReceiverEmail_Last(
		java.lang.String receiverEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchNotificationAuditLogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last notification audit log in the ordered set where receiverEmail = &#63;.
	*
	* @param receiverEmail the receiver email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification audit log, or <code>null</code> if a matching notification audit log could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.NotificationAuditLog fetchBynotificationReceiverEmail_Last(
		java.lang.String receiverEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notification audit logs before and after the current notification audit log in the ordered set where receiverEmail = &#63;.
	*
	* @param notificationAuditLogId the primary key of the current notification audit log
	* @param receiverEmail the receiver email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notification audit log
	* @throws com.liferay.contacts.NoSuchNotificationAuditLogException if a notification audit log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.NotificationAuditLog[] findBynotificationReceiverEmail_PrevAndNext(
		long notificationAuditLogId, java.lang.String receiverEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchNotificationAuditLogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the notification audit logs where receiverEmail = &#63; from the database.
	*
	* @param receiverEmail the receiver email
	* @throws SystemException if a system exception occurred
	*/
	public void removeBynotificationReceiverEmail(
		java.lang.String receiverEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of notification audit logs where receiverEmail = &#63;.
	*
	* @param receiverEmail the receiver email
	* @return the number of matching notification audit logs
	* @throws SystemException if a system exception occurred
	*/
	public int countBynotificationReceiverEmail(java.lang.String receiverEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the notification audit log in the entity cache if it is enabled.
	*
	* @param notificationAuditLog the notification audit log
	*/
	public void cacheResult(
		com.liferay.contacts.model.NotificationAuditLog notificationAuditLog);

	/**
	* Caches the notification audit logs in the entity cache if it is enabled.
	*
	* @param notificationAuditLogs the notification audit logs
	*/
	public void cacheResult(
		java.util.List<com.liferay.contacts.model.NotificationAuditLog> notificationAuditLogs);

	/**
	* Creates a new notification audit log with the primary key. Does not add the notification audit log to the database.
	*
	* @param notificationAuditLogId the primary key for the new notification audit log
	* @return the new notification audit log
	*/
	public com.liferay.contacts.model.NotificationAuditLog create(
		long notificationAuditLogId);

	/**
	* Removes the notification audit log with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationAuditLogId the primary key of the notification audit log
	* @return the notification audit log that was removed
	* @throws com.liferay.contacts.NoSuchNotificationAuditLogException if a notification audit log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.NotificationAuditLog remove(
		long notificationAuditLogId)
		throws com.liferay.contacts.NoSuchNotificationAuditLogException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.contacts.model.NotificationAuditLog updateImpl(
		com.liferay.contacts.model.NotificationAuditLog notificationAuditLog)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notification audit log with the primary key or throws a {@link com.liferay.contacts.NoSuchNotificationAuditLogException} if it could not be found.
	*
	* @param notificationAuditLogId the primary key of the notification audit log
	* @return the notification audit log
	* @throws com.liferay.contacts.NoSuchNotificationAuditLogException if a notification audit log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.NotificationAuditLog findByPrimaryKey(
		long notificationAuditLogId)
		throws com.liferay.contacts.NoSuchNotificationAuditLogException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the notification audit log with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notificationAuditLogId the primary key of the notification audit log
	* @return the notification audit log, or <code>null</code> if a notification audit log with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.NotificationAuditLog fetchByPrimaryKey(
		long notificationAuditLogId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the notification audit logs.
	*
	* @return the notification audit logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the notification audit logs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.NotificationAuditLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of notification audit logs
	* @param end the upper bound of the range of notification audit logs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of notification audit logs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.NotificationAuditLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the notification audit logs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of notification audit logs.
	*
	* @return the number of notification audit logs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}