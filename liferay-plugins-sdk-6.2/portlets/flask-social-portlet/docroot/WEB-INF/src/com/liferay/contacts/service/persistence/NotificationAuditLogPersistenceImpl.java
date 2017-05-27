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

import com.liferay.contacts.NoSuchNotificationAuditLogException;
import com.liferay.contacts.model.NotificationAuditLog;
import com.liferay.contacts.model.impl.NotificationAuditLogImpl;
import com.liferay.contacts.model.impl.NotificationAuditLogModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the notification audit log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NotificationAuditLogPersistence
 * @see NotificationAuditLogUtil
 * @generated
 */
public class NotificationAuditLogPersistenceImpl extends BasePersistenceImpl<NotificationAuditLog>
	implements NotificationAuditLogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NotificationAuditLogUtil} to access the notification audit log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NotificationAuditLogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NotificationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			NotificationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			NotificationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NotificationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			NotificationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			NotificationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NotificationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			NotificationAuditLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTIFICATIONBYSENDEREMAIL =
		new FinderPath(NotificationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			NotificationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			NotificationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBynotificationBySenderEmail",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICATIONBYSENDEREMAIL =
		new FinderPath(NotificationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			NotificationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			NotificationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBynotificationBySenderEmail",
			new String[] { String.class.getName() },
			NotificationAuditLogModelImpl.SENDEREMAIL_COLUMN_BITMASK |
			NotificationAuditLogModelImpl.NOTIFICATIONTIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NOTIFICATIONBYSENDEREMAIL =
		new FinderPath(NotificationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			NotificationAuditLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBynotificationBySenderEmail",
			new String[] { String.class.getName() });

	/**
	 * Returns all the notification audit logs where senderEmail = &#63;.
	 *
	 * @param senderEmail the sender email
	 * @return the matching notification audit logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificationAuditLog> findBynotificationBySenderEmail(
		String senderEmail) throws SystemException {
		return findBynotificationBySenderEmail(senderEmail, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<NotificationAuditLog> findBynotificationBySenderEmail(
		String senderEmail, int start, int end) throws SystemException {
		return findBynotificationBySenderEmail(senderEmail, start, end, null);
	}

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
	@Override
	public List<NotificationAuditLog> findBynotificationBySenderEmail(
		String senderEmail, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICATIONBYSENDEREMAIL;
			finderArgs = new Object[] { senderEmail };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTIFICATIONBYSENDEREMAIL;
			finderArgs = new Object[] { senderEmail, start, end, orderByComparator };
		}

		List<NotificationAuditLog> list = (List<NotificationAuditLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (NotificationAuditLog notificationAuditLog : list) {
				if (!Validator.equals(senderEmail,
							notificationAuditLog.getSenderEmail())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_NOTIFICATIONAUDITLOG_WHERE);

			boolean bindSenderEmail = false;

			if (senderEmail == null) {
				query.append(_FINDER_COLUMN_NOTIFICATIONBYSENDEREMAIL_SENDEREMAIL_1);
			}
			else if (senderEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOTIFICATIONBYSENDEREMAIL_SENDEREMAIL_3);
			}
			else {
				bindSenderEmail = true;

				query.append(_FINDER_COLUMN_NOTIFICATIONBYSENDEREMAIL_SENDEREMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NotificationAuditLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSenderEmail) {
					qPos.add(senderEmail);
				}

				if (!pagination) {
					list = (List<NotificationAuditLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NotificationAuditLog>(list);
				}
				else {
					list = (List<NotificationAuditLog>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first notification audit log in the ordered set where senderEmail = &#63;.
	 *
	 * @param senderEmail the sender email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification audit log
	 * @throws com.liferay.contacts.NoSuchNotificationAuditLogException if a matching notification audit log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationAuditLog findBynotificationBySenderEmail_First(
		String senderEmail, OrderByComparator orderByComparator)
		throws NoSuchNotificationAuditLogException, SystemException {
		NotificationAuditLog notificationAuditLog = fetchBynotificationBySenderEmail_First(senderEmail,
				orderByComparator);

		if (notificationAuditLog != null) {
			return notificationAuditLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("senderEmail=");
		msg.append(senderEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotificationAuditLogException(msg.toString());
	}

	/**
	 * Returns the first notification audit log in the ordered set where senderEmail = &#63;.
	 *
	 * @param senderEmail the sender email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification audit log, or <code>null</code> if a matching notification audit log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationAuditLog fetchBynotificationBySenderEmail_First(
		String senderEmail, OrderByComparator orderByComparator)
		throws SystemException {
		List<NotificationAuditLog> list = findBynotificationBySenderEmail(senderEmail,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notification audit log in the ordered set where senderEmail = &#63;.
	 *
	 * @param senderEmail the sender email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification audit log
	 * @throws com.liferay.contacts.NoSuchNotificationAuditLogException if a matching notification audit log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationAuditLog findBynotificationBySenderEmail_Last(
		String senderEmail, OrderByComparator orderByComparator)
		throws NoSuchNotificationAuditLogException, SystemException {
		NotificationAuditLog notificationAuditLog = fetchBynotificationBySenderEmail_Last(senderEmail,
				orderByComparator);

		if (notificationAuditLog != null) {
			return notificationAuditLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("senderEmail=");
		msg.append(senderEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotificationAuditLogException(msg.toString());
	}

	/**
	 * Returns the last notification audit log in the ordered set where senderEmail = &#63;.
	 *
	 * @param senderEmail the sender email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification audit log, or <code>null</code> if a matching notification audit log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationAuditLog fetchBynotificationBySenderEmail_Last(
		String senderEmail, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBynotificationBySenderEmail(senderEmail);

		if (count == 0) {
			return null;
		}

		List<NotificationAuditLog> list = findBynotificationBySenderEmail(senderEmail,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public NotificationAuditLog[] findBynotificationBySenderEmail_PrevAndNext(
		long notificationAuditLogId, String senderEmail,
		OrderByComparator orderByComparator)
		throws NoSuchNotificationAuditLogException, SystemException {
		NotificationAuditLog notificationAuditLog = findByPrimaryKey(notificationAuditLogId);

		Session session = null;

		try {
			session = openSession();

			NotificationAuditLog[] array = new NotificationAuditLogImpl[3];

			array[0] = getBynotificationBySenderEmail_PrevAndNext(session,
					notificationAuditLog, senderEmail, orderByComparator, true);

			array[1] = notificationAuditLog;

			array[2] = getBynotificationBySenderEmail_PrevAndNext(session,
					notificationAuditLog, senderEmail, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected NotificationAuditLog getBynotificationBySenderEmail_PrevAndNext(
		Session session, NotificationAuditLog notificationAuditLog,
		String senderEmail, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NOTIFICATIONAUDITLOG_WHERE);

		boolean bindSenderEmail = false;

		if (senderEmail == null) {
			query.append(_FINDER_COLUMN_NOTIFICATIONBYSENDEREMAIL_SENDEREMAIL_1);
		}
		else if (senderEmail.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NOTIFICATIONBYSENDEREMAIL_SENDEREMAIL_3);
		}
		else {
			bindSenderEmail = true;

			query.append(_FINDER_COLUMN_NOTIFICATIONBYSENDEREMAIL_SENDEREMAIL_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(NotificationAuditLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindSenderEmail) {
			qPos.add(senderEmail);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(notificationAuditLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NotificationAuditLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notification audit logs where senderEmail = &#63; from the database.
	 *
	 * @param senderEmail the sender email
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBynotificationBySenderEmail(String senderEmail)
		throws SystemException {
		for (NotificationAuditLog notificationAuditLog : findBynotificationBySenderEmail(
				senderEmail, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(notificationAuditLog);
		}
	}

	/**
	 * Returns the number of notification audit logs where senderEmail = &#63;.
	 *
	 * @param senderEmail the sender email
	 * @return the number of matching notification audit logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBynotificationBySenderEmail(String senderEmail)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NOTIFICATIONBYSENDEREMAIL;

		Object[] finderArgs = new Object[] { senderEmail };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NOTIFICATIONAUDITLOG_WHERE);

			boolean bindSenderEmail = false;

			if (senderEmail == null) {
				query.append(_FINDER_COLUMN_NOTIFICATIONBYSENDEREMAIL_SENDEREMAIL_1);
			}
			else if (senderEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOTIFICATIONBYSENDEREMAIL_SENDEREMAIL_3);
			}
			else {
				bindSenderEmail = true;

				query.append(_FINDER_COLUMN_NOTIFICATIONBYSENDEREMAIL_SENDEREMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSenderEmail) {
					qPos.add(senderEmail);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NOTIFICATIONBYSENDEREMAIL_SENDEREMAIL_1 =
		"notificationAuditLog.senderEmail IS NULL";
	private static final String _FINDER_COLUMN_NOTIFICATIONBYSENDEREMAIL_SENDEREMAIL_2 =
		"notificationAuditLog.senderEmail = ?";
	private static final String _FINDER_COLUMN_NOTIFICATIONBYSENDEREMAIL_SENDEREMAIL_3 =
		"(notificationAuditLog.senderEmail IS NULL OR notificationAuditLog.senderEmail = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTIFICATIONRECEIVEREMAIL =
		new FinderPath(NotificationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			NotificationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			NotificationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBynotificationReceiverEmail",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICATIONRECEIVEREMAIL =
		new FinderPath(NotificationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			NotificationAuditLogModelImpl.FINDER_CACHE_ENABLED,
			NotificationAuditLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBynotificationReceiverEmail",
			new String[] { String.class.getName() },
			NotificationAuditLogModelImpl.RECEIVEREMAIL_COLUMN_BITMASK |
			NotificationAuditLogModelImpl.NOTIFICATIONTIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NOTIFICATIONRECEIVEREMAIL =
		new FinderPath(NotificationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			NotificationAuditLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBynotificationReceiverEmail",
			new String[] { String.class.getName() });

	/**
	 * Returns all the notification audit logs where receiverEmail = &#63;.
	 *
	 * @param receiverEmail the receiver email
	 * @return the matching notification audit logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificationAuditLog> findBynotificationReceiverEmail(
		String receiverEmail) throws SystemException {
		return findBynotificationReceiverEmail(receiverEmail,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<NotificationAuditLog> findBynotificationReceiverEmail(
		String receiverEmail, int start, int end) throws SystemException {
		return findBynotificationReceiverEmail(receiverEmail, start, end, null);
	}

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
	@Override
	public List<NotificationAuditLog> findBynotificationReceiverEmail(
		String receiverEmail, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICATIONRECEIVEREMAIL;
			finderArgs = new Object[] { receiverEmail };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTIFICATIONRECEIVEREMAIL;
			finderArgs = new Object[] {
					receiverEmail,
					
					start, end, orderByComparator
				};
		}

		List<NotificationAuditLog> list = (List<NotificationAuditLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (NotificationAuditLog notificationAuditLog : list) {
				if (!Validator.equals(receiverEmail,
							notificationAuditLog.getReceiverEmail())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_NOTIFICATIONAUDITLOG_WHERE);

			boolean bindReceiverEmail = false;

			if (receiverEmail == null) {
				query.append(_FINDER_COLUMN_NOTIFICATIONRECEIVEREMAIL_RECEIVEREMAIL_1);
			}
			else if (receiverEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOTIFICATIONRECEIVEREMAIL_RECEIVEREMAIL_3);
			}
			else {
				bindReceiverEmail = true;

				query.append(_FINDER_COLUMN_NOTIFICATIONRECEIVEREMAIL_RECEIVEREMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NotificationAuditLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReceiverEmail) {
					qPos.add(receiverEmail);
				}

				if (!pagination) {
					list = (List<NotificationAuditLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NotificationAuditLog>(list);
				}
				else {
					list = (List<NotificationAuditLog>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first notification audit log in the ordered set where receiverEmail = &#63;.
	 *
	 * @param receiverEmail the receiver email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification audit log
	 * @throws com.liferay.contacts.NoSuchNotificationAuditLogException if a matching notification audit log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationAuditLog findBynotificationReceiverEmail_First(
		String receiverEmail, OrderByComparator orderByComparator)
		throws NoSuchNotificationAuditLogException, SystemException {
		NotificationAuditLog notificationAuditLog = fetchBynotificationReceiverEmail_First(receiverEmail,
				orderByComparator);

		if (notificationAuditLog != null) {
			return notificationAuditLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverEmail=");
		msg.append(receiverEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotificationAuditLogException(msg.toString());
	}

	/**
	 * Returns the first notification audit log in the ordered set where receiverEmail = &#63;.
	 *
	 * @param receiverEmail the receiver email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification audit log, or <code>null</code> if a matching notification audit log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationAuditLog fetchBynotificationReceiverEmail_First(
		String receiverEmail, OrderByComparator orderByComparator)
		throws SystemException {
		List<NotificationAuditLog> list = findBynotificationReceiverEmail(receiverEmail,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notification audit log in the ordered set where receiverEmail = &#63;.
	 *
	 * @param receiverEmail the receiver email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification audit log
	 * @throws com.liferay.contacts.NoSuchNotificationAuditLogException if a matching notification audit log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationAuditLog findBynotificationReceiverEmail_Last(
		String receiverEmail, OrderByComparator orderByComparator)
		throws NoSuchNotificationAuditLogException, SystemException {
		NotificationAuditLog notificationAuditLog = fetchBynotificationReceiverEmail_Last(receiverEmail,
				orderByComparator);

		if (notificationAuditLog != null) {
			return notificationAuditLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("receiverEmail=");
		msg.append(receiverEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchNotificationAuditLogException(msg.toString());
	}

	/**
	 * Returns the last notification audit log in the ordered set where receiverEmail = &#63;.
	 *
	 * @param receiverEmail the receiver email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification audit log, or <code>null</code> if a matching notification audit log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationAuditLog fetchBynotificationReceiverEmail_Last(
		String receiverEmail, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBynotificationReceiverEmail(receiverEmail);

		if (count == 0) {
			return null;
		}

		List<NotificationAuditLog> list = findBynotificationReceiverEmail(receiverEmail,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public NotificationAuditLog[] findBynotificationReceiverEmail_PrevAndNext(
		long notificationAuditLogId, String receiverEmail,
		OrderByComparator orderByComparator)
		throws NoSuchNotificationAuditLogException, SystemException {
		NotificationAuditLog notificationAuditLog = findByPrimaryKey(notificationAuditLogId);

		Session session = null;

		try {
			session = openSession();

			NotificationAuditLog[] array = new NotificationAuditLogImpl[3];

			array[0] = getBynotificationReceiverEmail_PrevAndNext(session,
					notificationAuditLog, receiverEmail, orderByComparator, true);

			array[1] = notificationAuditLog;

			array[2] = getBynotificationReceiverEmail_PrevAndNext(session,
					notificationAuditLog, receiverEmail, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected NotificationAuditLog getBynotificationReceiverEmail_PrevAndNext(
		Session session, NotificationAuditLog notificationAuditLog,
		String receiverEmail, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NOTIFICATIONAUDITLOG_WHERE);

		boolean bindReceiverEmail = false;

		if (receiverEmail == null) {
			query.append(_FINDER_COLUMN_NOTIFICATIONRECEIVEREMAIL_RECEIVEREMAIL_1);
		}
		else if (receiverEmail.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NOTIFICATIONRECEIVEREMAIL_RECEIVEREMAIL_3);
		}
		else {
			bindReceiverEmail = true;

			query.append(_FINDER_COLUMN_NOTIFICATIONRECEIVEREMAIL_RECEIVEREMAIL_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(NotificationAuditLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindReceiverEmail) {
			qPos.add(receiverEmail);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(notificationAuditLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NotificationAuditLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notification audit logs where receiverEmail = &#63; from the database.
	 *
	 * @param receiverEmail the receiver email
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBynotificationReceiverEmail(String receiverEmail)
		throws SystemException {
		for (NotificationAuditLog notificationAuditLog : findBynotificationReceiverEmail(
				receiverEmail, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(notificationAuditLog);
		}
	}

	/**
	 * Returns the number of notification audit logs where receiverEmail = &#63;.
	 *
	 * @param receiverEmail the receiver email
	 * @return the number of matching notification audit logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBynotificationReceiverEmail(String receiverEmail)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NOTIFICATIONRECEIVEREMAIL;

		Object[] finderArgs = new Object[] { receiverEmail };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NOTIFICATIONAUDITLOG_WHERE);

			boolean bindReceiverEmail = false;

			if (receiverEmail == null) {
				query.append(_FINDER_COLUMN_NOTIFICATIONRECEIVEREMAIL_RECEIVEREMAIL_1);
			}
			else if (receiverEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NOTIFICATIONRECEIVEREMAIL_RECEIVEREMAIL_3);
			}
			else {
				bindReceiverEmail = true;

				query.append(_FINDER_COLUMN_NOTIFICATIONRECEIVEREMAIL_RECEIVEREMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReceiverEmail) {
					qPos.add(receiverEmail);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NOTIFICATIONRECEIVEREMAIL_RECEIVEREMAIL_1 =
		"notificationAuditLog.receiverEmail IS NULL";
	private static final String _FINDER_COLUMN_NOTIFICATIONRECEIVEREMAIL_RECEIVEREMAIL_2 =
		"notificationAuditLog.receiverEmail = ?";
	private static final String _FINDER_COLUMN_NOTIFICATIONRECEIVEREMAIL_RECEIVEREMAIL_3 =
		"(notificationAuditLog.receiverEmail IS NULL OR notificationAuditLog.receiverEmail = '')";

	public NotificationAuditLogPersistenceImpl() {
		setModelClass(NotificationAuditLog.class);
	}

	/**
	 * Caches the notification audit log in the entity cache if it is enabled.
	 *
	 * @param notificationAuditLog the notification audit log
	 */
	@Override
	public void cacheResult(NotificationAuditLog notificationAuditLog) {
		EntityCacheUtil.putResult(NotificationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			NotificationAuditLogImpl.class,
			notificationAuditLog.getPrimaryKey(), notificationAuditLog);

		notificationAuditLog.resetOriginalValues();
	}

	/**
	 * Caches the notification audit logs in the entity cache if it is enabled.
	 *
	 * @param notificationAuditLogs the notification audit logs
	 */
	@Override
	public void cacheResult(List<NotificationAuditLog> notificationAuditLogs) {
		for (NotificationAuditLog notificationAuditLog : notificationAuditLogs) {
			if (EntityCacheUtil.getResult(
						NotificationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
						NotificationAuditLogImpl.class,
						notificationAuditLog.getPrimaryKey()) == null) {
				cacheResult(notificationAuditLog);
			}
			else {
				notificationAuditLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all notification audit logs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NotificationAuditLogImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NotificationAuditLogImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the notification audit log.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NotificationAuditLog notificationAuditLog) {
		EntityCacheUtil.removeResult(NotificationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			NotificationAuditLogImpl.class, notificationAuditLog.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<NotificationAuditLog> notificationAuditLogs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NotificationAuditLog notificationAuditLog : notificationAuditLogs) {
			EntityCacheUtil.removeResult(NotificationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
				NotificationAuditLogImpl.class,
				notificationAuditLog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new notification audit log with the primary key. Does not add the notification audit log to the database.
	 *
	 * @param notificationAuditLogId the primary key for the new notification audit log
	 * @return the new notification audit log
	 */
	@Override
	public NotificationAuditLog create(long notificationAuditLogId) {
		NotificationAuditLog notificationAuditLog = new NotificationAuditLogImpl();

		notificationAuditLog.setNew(true);
		notificationAuditLog.setPrimaryKey(notificationAuditLogId);

		return notificationAuditLog;
	}

	/**
	 * Removes the notification audit log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notificationAuditLogId the primary key of the notification audit log
	 * @return the notification audit log that was removed
	 * @throws com.liferay.contacts.NoSuchNotificationAuditLogException if a notification audit log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationAuditLog remove(long notificationAuditLogId)
		throws NoSuchNotificationAuditLogException, SystemException {
		return remove((Serializable)notificationAuditLogId);
	}

	/**
	 * Removes the notification audit log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the notification audit log
	 * @return the notification audit log that was removed
	 * @throws com.liferay.contacts.NoSuchNotificationAuditLogException if a notification audit log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationAuditLog remove(Serializable primaryKey)
		throws NoSuchNotificationAuditLogException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NotificationAuditLog notificationAuditLog = (NotificationAuditLog)session.get(NotificationAuditLogImpl.class,
					primaryKey);

			if (notificationAuditLog == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNotificationAuditLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(notificationAuditLog);
		}
		catch (NoSuchNotificationAuditLogException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected NotificationAuditLog removeImpl(
		NotificationAuditLog notificationAuditLog) throws SystemException {
		notificationAuditLog = toUnwrappedModel(notificationAuditLog);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(notificationAuditLog)) {
				notificationAuditLog = (NotificationAuditLog)session.get(NotificationAuditLogImpl.class,
						notificationAuditLog.getPrimaryKeyObj());
			}

			if (notificationAuditLog != null) {
				session.delete(notificationAuditLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (notificationAuditLog != null) {
			clearCache(notificationAuditLog);
		}

		return notificationAuditLog;
	}

	@Override
	public NotificationAuditLog updateImpl(
		com.liferay.contacts.model.NotificationAuditLog notificationAuditLog)
		throws SystemException {
		notificationAuditLog = toUnwrappedModel(notificationAuditLog);

		boolean isNew = notificationAuditLog.isNew();

		NotificationAuditLogModelImpl notificationAuditLogModelImpl = (NotificationAuditLogModelImpl)notificationAuditLog;

		Session session = null;

		try {
			session = openSession();

			if (notificationAuditLog.isNew()) {
				session.save(notificationAuditLog);

				notificationAuditLog.setNew(false);
			}
			else {
				session.merge(notificationAuditLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NotificationAuditLogModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((notificationAuditLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICATIONBYSENDEREMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						notificationAuditLogModelImpl.getOriginalSenderEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTIFICATIONBYSENDEREMAIL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICATIONBYSENDEREMAIL,
					args);

				args = new Object[] {
						notificationAuditLogModelImpl.getSenderEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTIFICATIONBYSENDEREMAIL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICATIONBYSENDEREMAIL,
					args);
			}

			if ((notificationAuditLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICATIONRECEIVEREMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						notificationAuditLogModelImpl.getOriginalReceiverEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTIFICATIONRECEIVEREMAIL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICATIONRECEIVEREMAIL,
					args);

				args = new Object[] {
						notificationAuditLogModelImpl.getReceiverEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTIFICATIONRECEIVEREMAIL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTIFICATIONRECEIVEREMAIL,
					args);
			}
		}

		EntityCacheUtil.putResult(NotificationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
			NotificationAuditLogImpl.class,
			notificationAuditLog.getPrimaryKey(), notificationAuditLog);

		return notificationAuditLog;
	}

	protected NotificationAuditLog toUnwrappedModel(
		NotificationAuditLog notificationAuditLog) {
		if (notificationAuditLog instanceof NotificationAuditLogImpl) {
			return notificationAuditLog;
		}

		NotificationAuditLogImpl notificationAuditLogImpl = new NotificationAuditLogImpl();

		notificationAuditLogImpl.setNew(notificationAuditLog.isNew());
		notificationAuditLogImpl.setPrimaryKey(notificationAuditLog.getPrimaryKey());

		notificationAuditLogImpl.setNotificationAuditLogId(notificationAuditLog.getNotificationAuditLogId());
		notificationAuditLogImpl.setSenderEmail(notificationAuditLog.getSenderEmail());
		notificationAuditLogImpl.setReceiverEmail(notificationAuditLog.getReceiverEmail());
		notificationAuditLogImpl.setMessageReason(notificationAuditLog.getMessageReason());
		notificationAuditLogImpl.setMessage(notificationAuditLog.getMessage());
		notificationAuditLogImpl.setNotificationTime(notificationAuditLog.getNotificationTime());

		return notificationAuditLogImpl;
	}

	/**
	 * Returns the notification audit log with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the notification audit log
	 * @return the notification audit log
	 * @throws com.liferay.contacts.NoSuchNotificationAuditLogException if a notification audit log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationAuditLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNotificationAuditLogException, SystemException {
		NotificationAuditLog notificationAuditLog = fetchByPrimaryKey(primaryKey);

		if (notificationAuditLog == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNotificationAuditLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return notificationAuditLog;
	}

	/**
	 * Returns the notification audit log with the primary key or throws a {@link com.liferay.contacts.NoSuchNotificationAuditLogException} if it could not be found.
	 *
	 * @param notificationAuditLogId the primary key of the notification audit log
	 * @return the notification audit log
	 * @throws com.liferay.contacts.NoSuchNotificationAuditLogException if a notification audit log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationAuditLog findByPrimaryKey(long notificationAuditLogId)
		throws NoSuchNotificationAuditLogException, SystemException {
		return findByPrimaryKey((Serializable)notificationAuditLogId);
	}

	/**
	 * Returns the notification audit log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the notification audit log
	 * @return the notification audit log, or <code>null</code> if a notification audit log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationAuditLog fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		NotificationAuditLog notificationAuditLog = (NotificationAuditLog)EntityCacheUtil.getResult(NotificationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
				NotificationAuditLogImpl.class, primaryKey);

		if (notificationAuditLog == _nullNotificationAuditLog) {
			return null;
		}

		if (notificationAuditLog == null) {
			Session session = null;

			try {
				session = openSession();

				notificationAuditLog = (NotificationAuditLog)session.get(NotificationAuditLogImpl.class,
						primaryKey);

				if (notificationAuditLog != null) {
					cacheResult(notificationAuditLog);
				}
				else {
					EntityCacheUtil.putResult(NotificationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
						NotificationAuditLogImpl.class, primaryKey,
						_nullNotificationAuditLog);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(NotificationAuditLogModelImpl.ENTITY_CACHE_ENABLED,
					NotificationAuditLogImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return notificationAuditLog;
	}

	/**
	 * Returns the notification audit log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param notificationAuditLogId the primary key of the notification audit log
	 * @return the notification audit log, or <code>null</code> if a notification audit log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationAuditLog fetchByPrimaryKey(long notificationAuditLogId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)notificationAuditLogId);
	}

	/**
	 * Returns all the notification audit logs.
	 *
	 * @return the notification audit logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<NotificationAuditLog> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<NotificationAuditLog> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<NotificationAuditLog> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<NotificationAuditLog> list = (List<NotificationAuditLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NOTIFICATIONAUDITLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NOTIFICATIONAUDITLOG;

				if (pagination) {
					sql = sql.concat(NotificationAuditLogModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<NotificationAuditLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<NotificationAuditLog>(list);
				}
				else {
					list = (List<NotificationAuditLog>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the notification audit logs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (NotificationAuditLog notificationAuditLog : findAll()) {
			remove(notificationAuditLog);
		}
	}

	/**
	 * Returns the number of notification audit logs.
	 *
	 * @return the number of notification audit logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NOTIFICATIONAUDITLOG);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the notification audit log persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.contacts.model.NotificationAuditLog")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NotificationAuditLog>> listenersList = new ArrayList<ModelListener<NotificationAuditLog>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NotificationAuditLog>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(NotificationAuditLogImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_NOTIFICATIONAUDITLOG = "SELECT notificationAuditLog FROM NotificationAuditLog notificationAuditLog";
	private static final String _SQL_SELECT_NOTIFICATIONAUDITLOG_WHERE = "SELECT notificationAuditLog FROM NotificationAuditLog notificationAuditLog WHERE ";
	private static final String _SQL_COUNT_NOTIFICATIONAUDITLOG = "SELECT COUNT(notificationAuditLog) FROM NotificationAuditLog notificationAuditLog";
	private static final String _SQL_COUNT_NOTIFICATIONAUDITLOG_WHERE = "SELECT COUNT(notificationAuditLog) FROM NotificationAuditLog notificationAuditLog WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "notificationAuditLog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NotificationAuditLog exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No NotificationAuditLog exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NotificationAuditLogPersistenceImpl.class);
	private static NotificationAuditLog _nullNotificationAuditLog = new NotificationAuditLogImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<NotificationAuditLog> toCacheModel() {
				return _nullNotificationAuditLogCacheModel;
			}
		};

	private static CacheModel<NotificationAuditLog> _nullNotificationAuditLogCacheModel =
		new CacheModel<NotificationAuditLog>() {
			@Override
			public NotificationAuditLog toEntityModel() {
				return _nullNotificationAuditLog;
			}
		};
}