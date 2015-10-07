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

import com.liferay.contacts.model.FlaskRecipients;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the flask recipients service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskRecipientsPersistenceImpl
 * @see FlaskRecipientsUtil
 * @generated
 */
public interface FlaskRecipientsPersistence extends BasePersistence<FlaskRecipients> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FlaskRecipientsUtil} to access the flask recipients persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the flask recipientses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskRecipients> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flask recipientses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of flask recipientses
	* @param end the upper bound of the range of flask recipientses (not inclusive)
	* @return the range of matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskRecipients> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flask recipientses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of flask recipientses
	* @param end the upper bound of the range of flask recipientses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskRecipients> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask recipients in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask recipients in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask recipients in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask recipients in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask recipientses before and after the current flask recipients in the ordered set where userId = &#63;.
	*
	* @param recipientId the primary key of the current flask recipients
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a flask recipients with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients[] findByUserId_PrevAndNext(
		long recipientId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flask recipientses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask recipientses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flask recipientses where messageId = &#63;.
	*
	* @param messageId the message ID
	* @return the matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskRecipients> findBymessageId(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flask recipientses where messageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param messageId the message ID
	* @param start the lower bound of the range of flask recipientses
	* @param end the upper bound of the range of flask recipientses (not inclusive)
	* @return the range of matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskRecipients> findBymessageId(
		long messageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flask recipientses where messageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param messageId the message ID
	* @param start the lower bound of the range of flask recipientses
	* @param end the upper bound of the range of flask recipientses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskRecipients> findBymessageId(
		long messageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask recipients in the ordered set where messageId = &#63;.
	*
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients findBymessageId_First(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask recipients in the ordered set where messageId = &#63;.
	*
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients fetchBymessageId_First(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask recipients in the ordered set where messageId = &#63;.
	*
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients findBymessageId_Last(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask recipients in the ordered set where messageId = &#63;.
	*
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients fetchBymessageId_Last(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask recipientses before and after the current flask recipients in the ordered set where messageId = &#63;.
	*
	* @param recipientId the primary key of the current flask recipients
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a flask recipients with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients[] findBymessageId_PrevAndNext(
		long recipientId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flask recipientses where messageId = &#63; from the database.
	*
	* @param messageId the message ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBymessageId(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask recipientses where messageId = &#63;.
	*
	* @param messageId the message ID
	* @return the number of matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public int countBymessageId(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flask recipientses where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @return the matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskRecipients> findByreadFlag(
		long userId, boolean read)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flask recipientses where userId = &#63; and read = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param read the read
	* @param start the lower bound of the range of flask recipientses
	* @param end the upper bound of the range of flask recipientses (not inclusive)
	* @return the range of matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskRecipients> findByreadFlag(
		long userId, boolean read, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flask recipientses where userId = &#63; and read = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param read the read
	* @param start the lower bound of the range of flask recipientses
	* @param end the upper bound of the range of flask recipientses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskRecipients> findByreadFlag(
		long userId, boolean read, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask recipients in the ordered set where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients findByreadFlag_First(
		long userId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask recipients in the ordered set where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients fetchByreadFlag_First(
		long userId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask recipients in the ordered set where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients findByreadFlag_Last(
		long userId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask recipients in the ordered set where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients fetchByreadFlag_Last(
		long userId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask recipientses before and after the current flask recipients in the ordered set where userId = &#63; and read = &#63;.
	*
	* @param recipientId the primary key of the current flask recipients
	* @param userId the user ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a flask recipients with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients[] findByreadFlag_PrevAndNext(
		long recipientId, long userId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flask recipientses where userId = &#63; and read = &#63; from the database.
	*
	* @param userId the user ID
	* @param read the read
	* @throws SystemException if a system exception occurred
	*/
	public void removeByreadFlag(long userId, boolean read)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask recipientses where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @return the number of matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public int countByreadFlag(long userId, boolean read)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flask recipientses where userId = &#63; and messageId = &#63;.
	*
	* @param userId the user ID
	* @param messageId the message ID
	* @return the matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskRecipients> findByreadOrNot(
		long userId, long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flask recipientses where userId = &#63; and messageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param messageId the message ID
	* @param start the lower bound of the range of flask recipientses
	* @param end the upper bound of the range of flask recipientses (not inclusive)
	* @return the range of matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskRecipients> findByreadOrNot(
		long userId, long messageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flask recipientses where userId = &#63; and messageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param messageId the message ID
	* @param start the lower bound of the range of flask recipientses
	* @param end the upper bound of the range of flask recipientses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskRecipients> findByreadOrNot(
		long userId, long messageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask recipients in the ordered set where userId = &#63; and messageId = &#63;.
	*
	* @param userId the user ID
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients findByreadOrNot_First(
		long userId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask recipients in the ordered set where userId = &#63; and messageId = &#63;.
	*
	* @param userId the user ID
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients fetchByreadOrNot_First(
		long userId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask recipients in the ordered set where userId = &#63; and messageId = &#63;.
	*
	* @param userId the user ID
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients findByreadOrNot_Last(
		long userId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask recipients in the ordered set where userId = &#63; and messageId = &#63;.
	*
	* @param userId the user ID
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients fetchByreadOrNot_Last(
		long userId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask recipientses before and after the current flask recipients in the ordered set where userId = &#63; and messageId = &#63;.
	*
	* @param recipientId the primary key of the current flask recipients
	* @param userId the user ID
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a flask recipients with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients[] findByreadOrNot_PrevAndNext(
		long recipientId, long userId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flask recipientses where userId = &#63; and messageId = &#63; from the database.
	*
	* @param userId the user ID
	* @param messageId the message ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByreadOrNot(long userId, long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask recipientses where userId = &#63; and messageId = &#63;.
	*
	* @param userId the user ID
	* @param messageId the message ID
	* @return the number of matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public int countByreadOrNot(long userId, long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the flask recipients in the entity cache if it is enabled.
	*
	* @param flaskRecipients the flask recipients
	*/
	public void cacheResult(
		com.liferay.contacts.model.FlaskRecipients flaskRecipients);

	/**
	* Caches the flask recipientses in the entity cache if it is enabled.
	*
	* @param flaskRecipientses the flask recipientses
	*/
	public void cacheResult(
		java.util.List<com.liferay.contacts.model.FlaskRecipients> flaskRecipientses);

	/**
	* Creates a new flask recipients with the primary key. Does not add the flask recipients to the database.
	*
	* @param recipientId the primary key for the new flask recipients
	* @return the new flask recipients
	*/
	public com.liferay.contacts.model.FlaskRecipients create(long recipientId);

	/**
	* Removes the flask recipients with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recipientId the primary key of the flask recipients
	* @return the flask recipients that was removed
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a flask recipients with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients remove(long recipientId)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.contacts.model.FlaskRecipients updateImpl(
		com.liferay.contacts.model.FlaskRecipients flaskRecipients)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask recipients with the primary key or throws a {@link com.liferay.contacts.NoSuchFlaskRecipientsException} if it could not be found.
	*
	* @param recipientId the primary key of the flask recipients
	* @return the flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a flask recipients with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients findByPrimaryKey(
		long recipientId)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask recipients with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recipientId the primary key of the flask recipients
	* @return the flask recipients, or <code>null</code> if a flask recipients with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskRecipients fetchByPrimaryKey(
		long recipientId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flask recipientses.
	*
	* @return the flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskRecipients> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flask recipientses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask recipientses
	* @param end the upper bound of the range of flask recipientses (not inclusive)
	* @return the range of flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskRecipients> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flask recipientses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask recipientses
	* @param end the upper bound of the range of flask recipientses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskRecipients> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flask recipientses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask recipientses.
	*
	* @return the number of flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}