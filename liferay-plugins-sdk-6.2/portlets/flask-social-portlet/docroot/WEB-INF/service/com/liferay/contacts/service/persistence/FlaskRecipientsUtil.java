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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the flask recipients service. This utility wraps {@link FlaskRecipientsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskRecipientsPersistence
 * @see FlaskRecipientsPersistenceImpl
 * @generated
 */
public class FlaskRecipientsUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(FlaskRecipients flaskRecipients) {
		getPersistence().clearCache(flaskRecipients);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FlaskRecipients> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FlaskRecipients> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FlaskRecipients> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FlaskRecipients update(FlaskRecipients flaskRecipients)
		throws SystemException {
		return getPersistence().update(flaskRecipients);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FlaskRecipients update(FlaskRecipients flaskRecipients,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(flaskRecipients, serviceContext);
	}

	/**
	* Returns all the flask recipientses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskRecipients> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

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
	public static java.util.List<com.liferay.contacts.model.FlaskRecipients> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

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
	public static java.util.List<com.liferay.contacts.model.FlaskRecipients> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first flask recipients in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskRecipients findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first flask recipients in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskRecipients fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last flask recipients in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskRecipients findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last flask recipients in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskRecipients fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

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
	public static com.liferay.contacts.model.FlaskRecipients[] findByUserId_PrevAndNext(
		long recipientId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_PrevAndNext(recipientId, userId,
			orderByComparator);
	}

	/**
	* Removes all the flask recipientses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of flask recipientses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the flask recipientses where messageId = &#63;.
	*
	* @param messageId the message ID
	* @return the matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskRecipients> findBymessageId(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymessageId(messageId);
	}

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
	public static java.util.List<com.liferay.contacts.model.FlaskRecipients> findBymessageId(
		long messageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymessageId(messageId, start, end);
	}

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
	public static java.util.List<com.liferay.contacts.model.FlaskRecipients> findBymessageId(
		long messageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymessageId(messageId, start, end, orderByComparator);
	}

	/**
	* Returns the first flask recipients in the ordered set where messageId = &#63;.
	*
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskRecipients findBymessageId_First(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymessageId_First(messageId, orderByComparator);
	}

	/**
	* Returns the first flask recipients in the ordered set where messageId = &#63;.
	*
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskRecipients fetchBymessageId_First(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymessageId_First(messageId, orderByComparator);
	}

	/**
	* Returns the last flask recipients in the ordered set where messageId = &#63;.
	*
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskRecipients findBymessageId_Last(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymessageId_Last(messageId, orderByComparator);
	}

	/**
	* Returns the last flask recipients in the ordered set where messageId = &#63;.
	*
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskRecipients fetchBymessageId_Last(
		long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBymessageId_Last(messageId, orderByComparator);
	}

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
	public static com.liferay.contacts.model.FlaskRecipients[] findBymessageId_PrevAndNext(
		long recipientId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymessageId_PrevAndNext(recipientId, messageId,
			orderByComparator);
	}

	/**
	* Removes all the flask recipientses where messageId = &#63; from the database.
	*
	* @param messageId the message ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBymessageId(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBymessageId(messageId);
	}

	/**
	* Returns the number of flask recipientses where messageId = &#63;.
	*
	* @param messageId the message ID
	* @return the number of matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBymessageId(long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBymessageId(messageId);
	}

	/**
	* Returns all the flask recipientses where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @return the matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskRecipients> findByreadFlag(
		long userId, boolean read)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByreadFlag(userId, read);
	}

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
	public static java.util.List<com.liferay.contacts.model.FlaskRecipients> findByreadFlag(
		long userId, boolean read, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByreadFlag(userId, read, start, end);
	}

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
	public static java.util.List<com.liferay.contacts.model.FlaskRecipients> findByreadFlag(
		long userId, boolean read, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByreadFlag(userId, read, start, end, orderByComparator);
	}

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
	public static com.liferay.contacts.model.FlaskRecipients findByreadFlag_First(
		long userId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByreadFlag_First(userId, read, orderByComparator);
	}

	/**
	* Returns the first flask recipients in the ordered set where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskRecipients fetchByreadFlag_First(
		long userId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByreadFlag_First(userId, read, orderByComparator);
	}

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
	public static com.liferay.contacts.model.FlaskRecipients findByreadFlag_Last(
		long userId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByreadFlag_Last(userId, read, orderByComparator);
	}

	/**
	* Returns the last flask recipients in the ordered set where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskRecipients fetchByreadFlag_Last(
		long userId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByreadFlag_Last(userId, read, orderByComparator);
	}

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
	public static com.liferay.contacts.model.FlaskRecipients[] findByreadFlag_PrevAndNext(
		long recipientId, long userId, boolean read,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByreadFlag_PrevAndNext(recipientId, userId, read,
			orderByComparator);
	}

	/**
	* Removes all the flask recipientses where userId = &#63; and read = &#63; from the database.
	*
	* @param userId the user ID
	* @param read the read
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByreadFlag(long userId, boolean read)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByreadFlag(userId, read);
	}

	/**
	* Returns the number of flask recipientses where userId = &#63; and read = &#63;.
	*
	* @param userId the user ID
	* @param read the read
	* @return the number of matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByreadFlag(long userId, boolean read)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByreadFlag(userId, read);
	}

	/**
	* Returns all the flask recipientses where userId = &#63; and messageId = &#63;.
	*
	* @param userId the user ID
	* @param messageId the message ID
	* @return the matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskRecipients> findByreadOrNot(
		long userId, long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByreadOrNot(userId, messageId);
	}

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
	public static java.util.List<com.liferay.contacts.model.FlaskRecipients> findByreadOrNot(
		long userId, long messageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByreadOrNot(userId, messageId, start, end);
	}

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
	public static java.util.List<com.liferay.contacts.model.FlaskRecipients> findByreadOrNot(
		long userId, long messageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByreadOrNot(userId, messageId, start, end,
			orderByComparator);
	}

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
	public static com.liferay.contacts.model.FlaskRecipients findByreadOrNot_First(
		long userId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByreadOrNot_First(userId, messageId, orderByComparator);
	}

	/**
	* Returns the first flask recipients in the ordered set where userId = &#63; and messageId = &#63;.
	*
	* @param userId the user ID
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskRecipients fetchByreadOrNot_First(
		long userId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByreadOrNot_First(userId, messageId, orderByComparator);
	}

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
	public static com.liferay.contacts.model.FlaskRecipients findByreadOrNot_Last(
		long userId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByreadOrNot_Last(userId, messageId, orderByComparator);
	}

	/**
	* Returns the last flask recipients in the ordered set where userId = &#63; and messageId = &#63;.
	*
	* @param userId the user ID
	* @param messageId the message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskRecipients fetchByreadOrNot_Last(
		long userId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByreadOrNot_Last(userId, messageId, orderByComparator);
	}

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
	public static com.liferay.contacts.model.FlaskRecipients[] findByreadOrNot_PrevAndNext(
		long recipientId, long userId, long messageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByreadOrNot_PrevAndNext(recipientId, userId, messageId,
			orderByComparator);
	}

	/**
	* Removes all the flask recipientses where userId = &#63; and messageId = &#63; from the database.
	*
	* @param userId the user ID
	* @param messageId the message ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByreadOrNot(long userId, long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByreadOrNot(userId, messageId);
	}

	/**
	* Returns the number of flask recipientses where userId = &#63; and messageId = &#63;.
	*
	* @param userId the user ID
	* @param messageId the message ID
	* @return the number of matching flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByreadOrNot(long userId, long messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByreadOrNot(userId, messageId);
	}

	/**
	* Caches the flask recipients in the entity cache if it is enabled.
	*
	* @param flaskRecipients the flask recipients
	*/
	public static void cacheResult(
		com.liferay.contacts.model.FlaskRecipients flaskRecipients) {
		getPersistence().cacheResult(flaskRecipients);
	}

	/**
	* Caches the flask recipientses in the entity cache if it is enabled.
	*
	* @param flaskRecipientses the flask recipientses
	*/
	public static void cacheResult(
		java.util.List<com.liferay.contacts.model.FlaskRecipients> flaskRecipientses) {
		getPersistence().cacheResult(flaskRecipientses);
	}

	/**
	* Creates a new flask recipients with the primary key. Does not add the flask recipients to the database.
	*
	* @param recipientId the primary key for the new flask recipients
	* @return the new flask recipients
	*/
	public static com.liferay.contacts.model.FlaskRecipients create(
		long recipientId) {
		return getPersistence().create(recipientId);
	}

	/**
	* Removes the flask recipients with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param recipientId the primary key of the flask recipients
	* @return the flask recipients that was removed
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a flask recipients with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskRecipients remove(
		long recipientId)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(recipientId);
	}

	public static com.liferay.contacts.model.FlaskRecipients updateImpl(
		com.liferay.contacts.model.FlaskRecipients flaskRecipients)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(flaskRecipients);
	}

	/**
	* Returns the flask recipients with the primary key or throws a {@link com.liferay.contacts.NoSuchFlaskRecipientsException} if it could not be found.
	*
	* @param recipientId the primary key of the flask recipients
	* @return the flask recipients
	* @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a flask recipients with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskRecipients findByPrimaryKey(
		long recipientId)
		throws com.liferay.contacts.NoSuchFlaskRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(recipientId);
	}

	/**
	* Returns the flask recipients with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param recipientId the primary key of the flask recipients
	* @return the flask recipients, or <code>null</code> if a flask recipients with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskRecipients fetchByPrimaryKey(
		long recipientId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(recipientId);
	}

	/**
	* Returns all the flask recipientses.
	*
	* @return the flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskRecipients> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.contacts.model.FlaskRecipients> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.contacts.model.FlaskRecipients> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the flask recipientses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of flask recipientses.
	*
	* @return the number of flask recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FlaskRecipientsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FlaskRecipientsPersistence)PortletBeanLocatorUtil.locate(com.liferay.contacts.service.ClpSerializer.getServletContextName(),
					FlaskRecipientsPersistence.class.getName());

			ReferenceRegistry.registerReference(FlaskRecipientsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FlaskRecipientsPersistence persistence) {
	}

	private static FlaskRecipientsPersistence _persistence;
}