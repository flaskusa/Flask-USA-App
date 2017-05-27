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

import com.liferay.contacts.model.FlaskGroupRecipients;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the flask group recipients service. This utility wraps {@link FlaskGroupRecipientsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupRecipientsPersistence
 * @see FlaskGroupRecipientsPersistenceImpl
 * @generated
 */
public class FlaskGroupRecipientsUtil {
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
	public static void clearCache(FlaskGroupRecipients flaskGroupRecipients) {
		getPersistence().clearCache(flaskGroupRecipients);
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
	public static List<FlaskGroupRecipients> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FlaskGroupRecipients> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FlaskGroupRecipients> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FlaskGroupRecipients update(
		FlaskGroupRecipients flaskGroupRecipients) throws SystemException {
		return getPersistence().update(flaskGroupRecipients);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FlaskGroupRecipients update(
		FlaskGroupRecipients flaskGroupRecipients, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(flaskGroupRecipients, serviceContext);
	}

	/**
	* Returns all the flask group recipientses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching flask group recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskGroupRecipients> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the flask group recipientses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of flask group recipientses
	* @param end the upper bound of the range of flask group recipientses (not inclusive)
	* @return the range of matching flask group recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskGroupRecipients> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the flask group recipientses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of flask group recipientses
	* @param end the upper bound of the range of flask group recipientses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flask group recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskGroupRecipients> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first flask group recipients in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask group recipients
	* @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a matching flask group recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskGroupRecipients findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first flask group recipients in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask group recipients, or <code>null</code> if a matching flask group recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskGroupRecipients fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last flask group recipients in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask group recipients
	* @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a matching flask group recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskGroupRecipients findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last flask group recipients in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask group recipients, or <code>null</code> if a matching flask group recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskGroupRecipients fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the flask group recipientses before and after the current flask group recipients in the ordered set where groupId = &#63;.
	*
	* @param groupRecipientId the primary key of the current flask group recipients
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flask group recipients
	* @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a flask group recipients with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskGroupRecipients[] findByGroupId_PrevAndNext(
		long groupRecipientId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(groupRecipientId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the flask group recipientses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of flask group recipientses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching flask group recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the flask group recipientses where groupMessageId = &#63;.
	*
	* @param groupMessageId the group message ID
	* @return the matching flask group recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskGroupRecipients> findByMessageId(
		long groupMessageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMessageId(groupMessageId);
	}

	/**
	* Returns a range of all the flask group recipientses where groupMessageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupMessageId the group message ID
	* @param start the lower bound of the range of flask group recipientses
	* @param end the upper bound of the range of flask group recipientses (not inclusive)
	* @return the range of matching flask group recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskGroupRecipients> findByMessageId(
		long groupMessageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMessageId(groupMessageId, start, end);
	}

	/**
	* Returns an ordered range of all the flask group recipientses where groupMessageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupMessageId the group message ID
	* @param start the lower bound of the range of flask group recipientses
	* @param end the upper bound of the range of flask group recipientses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flask group recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskGroupRecipients> findByMessageId(
		long groupMessageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMessageId(groupMessageId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first flask group recipients in the ordered set where groupMessageId = &#63;.
	*
	* @param groupMessageId the group message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask group recipients
	* @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a matching flask group recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskGroupRecipients findByMessageId_First(
		long groupMessageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMessageId_First(groupMessageId, orderByComparator);
	}

	/**
	* Returns the first flask group recipients in the ordered set where groupMessageId = &#63;.
	*
	* @param groupMessageId the group message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask group recipients, or <code>null</code> if a matching flask group recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskGroupRecipients fetchByMessageId_First(
		long groupMessageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMessageId_First(groupMessageId, orderByComparator);
	}

	/**
	* Returns the last flask group recipients in the ordered set where groupMessageId = &#63;.
	*
	* @param groupMessageId the group message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask group recipients
	* @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a matching flask group recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskGroupRecipients findByMessageId_Last(
		long groupMessageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMessageId_Last(groupMessageId, orderByComparator);
	}

	/**
	* Returns the last flask group recipients in the ordered set where groupMessageId = &#63;.
	*
	* @param groupMessageId the group message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask group recipients, or <code>null</code> if a matching flask group recipients could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskGroupRecipients fetchByMessageId_Last(
		long groupMessageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMessageId_Last(groupMessageId, orderByComparator);
	}

	/**
	* Returns the flask group recipientses before and after the current flask group recipients in the ordered set where groupMessageId = &#63;.
	*
	* @param groupRecipientId the primary key of the current flask group recipients
	* @param groupMessageId the group message ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flask group recipients
	* @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a flask group recipients with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskGroupRecipients[] findByMessageId_PrevAndNext(
		long groupRecipientId, long groupMessageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMessageId_PrevAndNext(groupRecipientId,
			groupMessageId, orderByComparator);
	}

	/**
	* Removes all the flask group recipientses where groupMessageId = &#63; from the database.
	*
	* @param groupMessageId the group message ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMessageId(long groupMessageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMessageId(groupMessageId);
	}

	/**
	* Returns the number of flask group recipientses where groupMessageId = &#63;.
	*
	* @param groupMessageId the group message ID
	* @return the number of matching flask group recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMessageId(long groupMessageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMessageId(groupMessageId);
	}

	/**
	* Caches the flask group recipients in the entity cache if it is enabled.
	*
	* @param flaskGroupRecipients the flask group recipients
	*/
	public static void cacheResult(
		com.liferay.contacts.model.FlaskGroupRecipients flaskGroupRecipients) {
		getPersistence().cacheResult(flaskGroupRecipients);
	}

	/**
	* Caches the flask group recipientses in the entity cache if it is enabled.
	*
	* @param flaskGroupRecipientses the flask group recipientses
	*/
	public static void cacheResult(
		java.util.List<com.liferay.contacts.model.FlaskGroupRecipients> flaskGroupRecipientses) {
		getPersistence().cacheResult(flaskGroupRecipientses);
	}

	/**
	* Creates a new flask group recipients with the primary key. Does not add the flask group recipients to the database.
	*
	* @param groupRecipientId the primary key for the new flask group recipients
	* @return the new flask group recipients
	*/
	public static com.liferay.contacts.model.FlaskGroupRecipients create(
		long groupRecipientId) {
		return getPersistence().create(groupRecipientId);
	}

	/**
	* Removes the flask group recipients with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupRecipientId the primary key of the flask group recipients
	* @return the flask group recipients that was removed
	* @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a flask group recipients with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskGroupRecipients remove(
		long groupRecipientId)
		throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(groupRecipientId);
	}

	public static com.liferay.contacts.model.FlaskGroupRecipients updateImpl(
		com.liferay.contacts.model.FlaskGroupRecipients flaskGroupRecipients)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(flaskGroupRecipients);
	}

	/**
	* Returns the flask group recipients with the primary key or throws a {@link com.liferay.contacts.NoSuchFlaskGroupRecipientsException} if it could not be found.
	*
	* @param groupRecipientId the primary key of the flask group recipients
	* @return the flask group recipients
	* @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a flask group recipients with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskGroupRecipients findByPrimaryKey(
		long groupRecipientId)
		throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(groupRecipientId);
	}

	/**
	* Returns the flask group recipients with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param groupRecipientId the primary key of the flask group recipients
	* @return the flask group recipients, or <code>null</code> if a flask group recipients with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskGroupRecipients fetchByPrimaryKey(
		long groupRecipientId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(groupRecipientId);
	}

	/**
	* Returns all the flask group recipientses.
	*
	* @return the flask group recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskGroupRecipients> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.contacts.model.FlaskGroupRecipients> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the flask group recipientses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask group recipientses
	* @param end the upper bound of the range of flask group recipientses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of flask group recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskGroupRecipients> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the flask group recipientses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of flask group recipientses.
	*
	* @return the number of flask group recipientses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FlaskGroupRecipientsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FlaskGroupRecipientsPersistence)PortletBeanLocatorUtil.locate(com.liferay.contacts.service.ClpSerializer.getServletContextName(),
					FlaskGroupRecipientsPersistence.class.getName());

			ReferenceRegistry.registerReference(FlaskGroupRecipientsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FlaskGroupRecipientsPersistence persistence) {
	}

	private static FlaskGroupRecipientsPersistence _persistence;
}