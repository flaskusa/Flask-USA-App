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

import com.liferay.contacts.NoSuchFlaskRecipientsException;
import com.liferay.contacts.model.FlaskRecipients;
import com.liferay.contacts.model.impl.FlaskRecipientsImpl;
import com.liferay.contacts.model.impl.FlaskRecipientsModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the flask recipients service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskRecipientsPersistence
 * @see FlaskRecipientsUtil
 * @generated
 */
public class FlaskRecipientsPersistenceImpl extends BasePersistenceImpl<FlaskRecipients>
	implements FlaskRecipientsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FlaskRecipientsUtil} to access the flask recipients persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FlaskRecipientsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskRecipientsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskRecipientsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskRecipientsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskRecipientsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			FlaskRecipientsModelImpl.USERID_COLUMN_BITMASK |
			FlaskRecipientsModelImpl.RECEIVEDDATETIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the flask recipientses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching flask recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskRecipients> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<FlaskRecipients> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<FlaskRecipients> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<FlaskRecipients> list = (List<FlaskRecipients>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FlaskRecipients flaskRecipients : list) {
				if ((userId != flaskRecipients.getUserId())) {
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

			query.append(_SQL_SELECT_FLASKRECIPIENTS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlaskRecipientsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<FlaskRecipients>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskRecipients>(list);
				}
				else {
					list = (List<FlaskRecipients>)QueryUtil.list(q,
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
	 * Returns the first flask recipients in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask recipients
	 * @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskRecipientsException, SystemException {
		FlaskRecipients flaskRecipients = fetchByUserId_First(userId,
				orderByComparator);

		if (flaskRecipients != null) {
			return flaskRecipients;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskRecipientsException(msg.toString());
	}

	/**
	 * Returns the first flask recipients in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FlaskRecipients> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public FlaskRecipients findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskRecipientsException, SystemException {
		FlaskRecipients flaskRecipients = fetchByUserId_Last(userId,
				orderByComparator);

		if (flaskRecipients != null) {
			return flaskRecipients;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskRecipientsException(msg.toString());
	}

	/**
	 * Returns the last flask recipients in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<FlaskRecipients> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public FlaskRecipients[] findByUserId_PrevAndNext(long recipientId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchFlaskRecipientsException, SystemException {
		FlaskRecipients flaskRecipients = findByPrimaryKey(recipientId);

		Session session = null;

		try {
			session = openSession();

			FlaskRecipients[] array = new FlaskRecipientsImpl[3];

			array[0] = getByUserId_PrevAndNext(session, flaskRecipients,
					userId, orderByComparator, true);

			array[1] = flaskRecipients;

			array[2] = getByUserId_PrevAndNext(session, flaskRecipients,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FlaskRecipients getByUserId_PrevAndNext(Session session,
		FlaskRecipients flaskRecipients, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLASKRECIPIENTS_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(FlaskRecipientsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flaskRecipients);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FlaskRecipients> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flask recipientses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (FlaskRecipients flaskRecipients : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(flaskRecipients);
		}
	}

	/**
	 * Returns the number of flask recipientses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching flask recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FLASKRECIPIENTS_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "flaskRecipients.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MESSAGEID =
		new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskRecipientsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBymessageId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID =
		new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskRecipientsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymessageId",
			new String[] { Long.class.getName() },
			FlaskRecipientsModelImpl.MESSAGEID_COLUMN_BITMASK |
			FlaskRecipientsModelImpl.RECEIVEDDATETIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MESSAGEID = new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymessageId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the flask recipientses where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @return the matching flask recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskRecipients> findBymessageId(long messageId)
		throws SystemException {
		return findBymessageId(messageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<FlaskRecipients> findBymessageId(long messageId, int start,
		int end) throws SystemException {
		return findBymessageId(messageId, start, end, null);
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
	@Override
	public List<FlaskRecipients> findBymessageId(long messageId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID;
			finderArgs = new Object[] { messageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MESSAGEID;
			finderArgs = new Object[] { messageId, start, end, orderByComparator };
		}

		List<FlaskRecipients> list = (List<FlaskRecipients>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FlaskRecipients flaskRecipients : list) {
				if ((messageId != flaskRecipients.getMessageId())) {
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

			query.append(_SQL_SELECT_FLASKRECIPIENTS_WHERE);

			query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlaskRecipientsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(messageId);

				if (!pagination) {
					list = (List<FlaskRecipients>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskRecipients>(list);
				}
				else {
					list = (List<FlaskRecipients>)QueryUtil.list(q,
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
	 * Returns the first flask recipients in the ordered set where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask recipients
	 * @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients findBymessageId_First(long messageId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskRecipientsException, SystemException {
		FlaskRecipients flaskRecipients = fetchBymessageId_First(messageId,
				orderByComparator);

		if (flaskRecipients != null) {
			return flaskRecipients;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("messageId=");
		msg.append(messageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskRecipientsException(msg.toString());
	}

	/**
	 * Returns the first flask recipients in the ordered set where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients fetchBymessageId_First(long messageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FlaskRecipients> list = findBymessageId(messageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public FlaskRecipients findBymessageId_Last(long messageId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskRecipientsException, SystemException {
		FlaskRecipients flaskRecipients = fetchBymessageId_Last(messageId,
				orderByComparator);

		if (flaskRecipients != null) {
			return flaskRecipients;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("messageId=");
		msg.append(messageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskRecipientsException(msg.toString());
	}

	/**
	 * Returns the last flask recipients in the ordered set where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients fetchBymessageId_Last(long messageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBymessageId(messageId);

		if (count == 0) {
			return null;
		}

		List<FlaskRecipients> list = findBymessageId(messageId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public FlaskRecipients[] findBymessageId_PrevAndNext(long recipientId,
		long messageId, OrderByComparator orderByComparator)
		throws NoSuchFlaskRecipientsException, SystemException {
		FlaskRecipients flaskRecipients = findByPrimaryKey(recipientId);

		Session session = null;

		try {
			session = openSession();

			FlaskRecipients[] array = new FlaskRecipientsImpl[3];

			array[0] = getBymessageId_PrevAndNext(session, flaskRecipients,
					messageId, orderByComparator, true);

			array[1] = flaskRecipients;

			array[2] = getBymessageId_PrevAndNext(session, flaskRecipients,
					messageId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FlaskRecipients getBymessageId_PrevAndNext(Session session,
		FlaskRecipients flaskRecipients, long messageId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLASKRECIPIENTS_WHERE);

		query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_2);

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
			query.append(FlaskRecipientsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(messageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flaskRecipients);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FlaskRecipients> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flask recipientses where messageId = &#63; from the database.
	 *
	 * @param messageId the message ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBymessageId(long messageId) throws SystemException {
		for (FlaskRecipients flaskRecipients : findBymessageId(messageId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(flaskRecipients);
		}
	}

	/**
	 * Returns the number of flask recipientses where messageId = &#63;.
	 *
	 * @param messageId the message ID
	 * @return the number of matching flask recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBymessageId(long messageId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MESSAGEID;

		Object[] finderArgs = new Object[] { messageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FLASKRECIPIENTS_WHERE);

			query.append(_FINDER_COLUMN_MESSAGEID_MESSAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(messageId);

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

	private static final String _FINDER_COLUMN_MESSAGEID_MESSAGEID_2 = "flaskRecipients.messageId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_READFLAG = new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskRecipientsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByreadFlag",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_READFLAG =
		new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskRecipientsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByreadFlag",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			},
			FlaskRecipientsModelImpl.USERID_COLUMN_BITMASK |
			FlaskRecipientsModelImpl.READ_COLUMN_BITMASK |
			FlaskRecipientsModelImpl.SENDERID_COLUMN_BITMASK |
			FlaskRecipientsModelImpl.RECEIVEDDATETIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_READFLAG = new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByreadFlag",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the flask recipientses where userId = &#63; and read = &#63; and senderId = &#63;.
	 *
	 * @param userId the user ID
	 * @param read the read
	 * @param senderId the sender ID
	 * @return the matching flask recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskRecipients> findByreadFlag(long userId, boolean read,
		long senderId) throws SystemException {
		return findByreadFlag(userId, read, senderId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flask recipientses where userId = &#63; and read = &#63; and senderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param read the read
	 * @param senderId the sender ID
	 * @param start the lower bound of the range of flask recipientses
	 * @param end the upper bound of the range of flask recipientses (not inclusive)
	 * @return the range of matching flask recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskRecipients> findByreadFlag(long userId, boolean read,
		long senderId, int start, int end) throws SystemException {
		return findByreadFlag(userId, read, senderId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask recipientses where userId = &#63; and read = &#63; and senderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param read the read
	 * @param senderId the sender ID
	 * @param start the lower bound of the range of flask recipientses
	 * @param end the upper bound of the range of flask recipientses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flask recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskRecipients> findByreadFlag(long userId, boolean read,
		long senderId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_READFLAG;
			finderArgs = new Object[] { userId, read, senderId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_READFLAG;
			finderArgs = new Object[] {
					userId, read, senderId,
					
					start, end, orderByComparator
				};
		}

		List<FlaskRecipients> list = (List<FlaskRecipients>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FlaskRecipients flaskRecipients : list) {
				if ((userId != flaskRecipients.getUserId()) ||
						(read != flaskRecipients.getRead()) ||
						(senderId != flaskRecipients.getSenderId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_FLASKRECIPIENTS_WHERE);

			query.append(_FINDER_COLUMN_READFLAG_USERID_2);

			query.append(_FINDER_COLUMN_READFLAG_READ_2);

			query.append(_FINDER_COLUMN_READFLAG_SENDERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlaskRecipientsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(read);

				qPos.add(senderId);

				if (!pagination) {
					list = (List<FlaskRecipients>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskRecipients>(list);
				}
				else {
					list = (List<FlaskRecipients>)QueryUtil.list(q,
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
	 * Returns the first flask recipients in the ordered set where userId = &#63; and read = &#63; and senderId = &#63;.
	 *
	 * @param userId the user ID
	 * @param read the read
	 * @param senderId the sender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask recipients
	 * @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients findByreadFlag_First(long userId, boolean read,
		long senderId, OrderByComparator orderByComparator)
		throws NoSuchFlaskRecipientsException, SystemException {
		FlaskRecipients flaskRecipients = fetchByreadFlag_First(userId, read,
				senderId, orderByComparator);

		if (flaskRecipients != null) {
			return flaskRecipients;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", read=");
		msg.append(read);

		msg.append(", senderId=");
		msg.append(senderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskRecipientsException(msg.toString());
	}

	/**
	 * Returns the first flask recipients in the ordered set where userId = &#63; and read = &#63; and senderId = &#63;.
	 *
	 * @param userId the user ID
	 * @param read the read
	 * @param senderId the sender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients fetchByreadFlag_First(long userId, boolean read,
		long senderId, OrderByComparator orderByComparator)
		throws SystemException {
		List<FlaskRecipients> list = findByreadFlag(userId, read, senderId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flask recipients in the ordered set where userId = &#63; and read = &#63; and senderId = &#63;.
	 *
	 * @param userId the user ID
	 * @param read the read
	 * @param senderId the sender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask recipients
	 * @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients findByreadFlag_Last(long userId, boolean read,
		long senderId, OrderByComparator orderByComparator)
		throws NoSuchFlaskRecipientsException, SystemException {
		FlaskRecipients flaskRecipients = fetchByreadFlag_Last(userId, read,
				senderId, orderByComparator);

		if (flaskRecipients != null) {
			return flaskRecipients;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", read=");
		msg.append(read);

		msg.append(", senderId=");
		msg.append(senderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskRecipientsException(msg.toString());
	}

	/**
	 * Returns the last flask recipients in the ordered set where userId = &#63; and read = &#63; and senderId = &#63;.
	 *
	 * @param userId the user ID
	 * @param read the read
	 * @param senderId the sender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients fetchByreadFlag_Last(long userId, boolean read,
		long senderId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByreadFlag(userId, read, senderId);

		if (count == 0) {
			return null;
		}

		List<FlaskRecipients> list = findByreadFlag(userId, read, senderId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flask recipientses before and after the current flask recipients in the ordered set where userId = &#63; and read = &#63; and senderId = &#63;.
	 *
	 * @param recipientId the primary key of the current flask recipients
	 * @param userId the user ID
	 * @param read the read
	 * @param senderId the sender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flask recipients
	 * @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a flask recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients[] findByreadFlag_PrevAndNext(long recipientId,
		long userId, boolean read, long senderId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskRecipientsException, SystemException {
		FlaskRecipients flaskRecipients = findByPrimaryKey(recipientId);

		Session session = null;

		try {
			session = openSession();

			FlaskRecipients[] array = new FlaskRecipientsImpl[3];

			array[0] = getByreadFlag_PrevAndNext(session, flaskRecipients,
					userId, read, senderId, orderByComparator, true);

			array[1] = flaskRecipients;

			array[2] = getByreadFlag_PrevAndNext(session, flaskRecipients,
					userId, read, senderId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FlaskRecipients getByreadFlag_PrevAndNext(Session session,
		FlaskRecipients flaskRecipients, long userId, boolean read,
		long senderId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLASKRECIPIENTS_WHERE);

		query.append(_FINDER_COLUMN_READFLAG_USERID_2);

		query.append(_FINDER_COLUMN_READFLAG_READ_2);

		query.append(_FINDER_COLUMN_READFLAG_SENDERID_2);

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
			query.append(FlaskRecipientsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(read);

		qPos.add(senderId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flaskRecipients);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FlaskRecipients> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flask recipientses where userId = &#63; and read = &#63; and senderId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param read the read
	 * @param senderId the sender ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByreadFlag(long userId, boolean read, long senderId)
		throws SystemException {
		for (FlaskRecipients flaskRecipients : findByreadFlag(userId, read,
				senderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(flaskRecipients);
		}
	}

	/**
	 * Returns the number of flask recipientses where userId = &#63; and read = &#63; and senderId = &#63;.
	 *
	 * @param userId the user ID
	 * @param read the read
	 * @param senderId the sender ID
	 * @return the number of matching flask recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByreadFlag(long userId, boolean read, long senderId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_READFLAG;

		Object[] finderArgs = new Object[] { userId, read, senderId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_FLASKRECIPIENTS_WHERE);

			query.append(_FINDER_COLUMN_READFLAG_USERID_2);

			query.append(_FINDER_COLUMN_READFLAG_READ_2);

			query.append(_FINDER_COLUMN_READFLAG_SENDERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(read);

				qPos.add(senderId);

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

	private static final String _FINDER_COLUMN_READFLAG_USERID_2 = "flaskRecipients.userId = ? AND ";
	private static final String _FINDER_COLUMN_READFLAG_READ_2 = "flaskRecipients.read = ? AND ";
	private static final String _FINDER_COLUMN_READFLAG_SENDERID_2 = "flaskRecipients.senderId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_READORNOT =
		new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskRecipientsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByreadOrNot",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_READORNOT =
		new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskRecipientsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByreadOrNot",
			new String[] { Long.class.getName(), Long.class.getName() },
			FlaskRecipientsModelImpl.USERID_COLUMN_BITMASK |
			FlaskRecipientsModelImpl.MESSAGEID_COLUMN_BITMASK |
			FlaskRecipientsModelImpl.RECEIVEDDATETIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_READORNOT = new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByreadOrNot",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the flask recipientses where userId = &#63; and messageId = &#63;.
	 *
	 * @param userId the user ID
	 * @param messageId the message ID
	 * @return the matching flask recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskRecipients> findByreadOrNot(long userId, long messageId)
		throws SystemException {
		return findByreadOrNot(userId, messageId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<FlaskRecipients> findByreadOrNot(long userId, long messageId,
		int start, int end) throws SystemException {
		return findByreadOrNot(userId, messageId, start, end, null);
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
	@Override
	public List<FlaskRecipients> findByreadOrNot(long userId, long messageId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_READORNOT;
			finderArgs = new Object[] { userId, messageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_READORNOT;
			finderArgs = new Object[] {
					userId, messageId,
					
					start, end, orderByComparator
				};
		}

		List<FlaskRecipients> list = (List<FlaskRecipients>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FlaskRecipients flaskRecipients : list) {
				if ((userId != flaskRecipients.getUserId()) ||
						(messageId != flaskRecipients.getMessageId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_FLASKRECIPIENTS_WHERE);

			query.append(_FINDER_COLUMN_READORNOT_USERID_2);

			query.append(_FINDER_COLUMN_READORNOT_MESSAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlaskRecipientsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(messageId);

				if (!pagination) {
					list = (List<FlaskRecipients>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskRecipients>(list);
				}
				else {
					list = (List<FlaskRecipients>)QueryUtil.list(q,
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
	 * Returns the first flask recipients in the ordered set where userId = &#63; and messageId = &#63;.
	 *
	 * @param userId the user ID
	 * @param messageId the message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask recipients
	 * @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients findByreadOrNot_First(long userId, long messageId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskRecipientsException, SystemException {
		FlaskRecipients flaskRecipients = fetchByreadOrNot_First(userId,
				messageId, orderByComparator);

		if (flaskRecipients != null) {
			return flaskRecipients;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", messageId=");
		msg.append(messageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskRecipientsException(msg.toString());
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
	@Override
	public FlaskRecipients fetchByreadOrNot_First(long userId, long messageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FlaskRecipients> list = findByreadOrNot(userId, messageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public FlaskRecipients findByreadOrNot_Last(long userId, long messageId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskRecipientsException, SystemException {
		FlaskRecipients flaskRecipients = fetchByreadOrNot_Last(userId,
				messageId, orderByComparator);

		if (flaskRecipients != null) {
			return flaskRecipients;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", messageId=");
		msg.append(messageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskRecipientsException(msg.toString());
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
	@Override
	public FlaskRecipients fetchByreadOrNot_Last(long userId, long messageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByreadOrNot(userId, messageId);

		if (count == 0) {
			return null;
		}

		List<FlaskRecipients> list = findByreadOrNot(userId, messageId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public FlaskRecipients[] findByreadOrNot_PrevAndNext(long recipientId,
		long userId, long messageId, OrderByComparator orderByComparator)
		throws NoSuchFlaskRecipientsException, SystemException {
		FlaskRecipients flaskRecipients = findByPrimaryKey(recipientId);

		Session session = null;

		try {
			session = openSession();

			FlaskRecipients[] array = new FlaskRecipientsImpl[3];

			array[0] = getByreadOrNot_PrevAndNext(session, flaskRecipients,
					userId, messageId, orderByComparator, true);

			array[1] = flaskRecipients;

			array[2] = getByreadOrNot_PrevAndNext(session, flaskRecipients,
					userId, messageId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FlaskRecipients getByreadOrNot_PrevAndNext(Session session,
		FlaskRecipients flaskRecipients, long userId, long messageId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLASKRECIPIENTS_WHERE);

		query.append(_FINDER_COLUMN_READORNOT_USERID_2);

		query.append(_FINDER_COLUMN_READORNOT_MESSAGEID_2);

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
			query.append(FlaskRecipientsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(messageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flaskRecipients);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FlaskRecipients> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flask recipientses where userId = &#63; and messageId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param messageId the message ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByreadOrNot(long userId, long messageId)
		throws SystemException {
		for (FlaskRecipients flaskRecipients : findByreadOrNot(userId,
				messageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(flaskRecipients);
		}
	}

	/**
	 * Returns the number of flask recipientses where userId = &#63; and messageId = &#63;.
	 *
	 * @param userId the user ID
	 * @param messageId the message ID
	 * @return the number of matching flask recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByreadOrNot(long userId, long messageId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_READORNOT;

		Object[] finderArgs = new Object[] { userId, messageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FLASKRECIPIENTS_WHERE);

			query.append(_FINDER_COLUMN_READORNOT_USERID_2);

			query.append(_FINDER_COLUMN_READORNOT_MESSAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(messageId);

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

	private static final String _FINDER_COLUMN_READORNOT_USERID_2 = "flaskRecipients.userId = ? AND ";
	private static final String _FINDER_COLUMN_READORNOT_MESSAGEID_2 = "flaskRecipients.messageId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDSENDERID =
		new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskRecipientsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIdSenderId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDSENDERID =
		new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskRecipientsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdSenderId",
			new String[] { Long.class.getName(), Long.class.getName() },
			FlaskRecipientsModelImpl.USERID_COLUMN_BITMASK |
			FlaskRecipientsModelImpl.SENDERID_COLUMN_BITMASK |
			FlaskRecipientsModelImpl.RECEIVEDDATETIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDSENDERID = new FinderPath(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdSenderId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the flask recipientses where userId = &#63; and senderId = &#63;.
	 *
	 * @param userId the user ID
	 * @param senderId the sender ID
	 * @return the matching flask recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskRecipients> findByUserIdSenderId(long userId, long senderId)
		throws SystemException {
		return findByUserIdSenderId(userId, senderId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flask recipientses where userId = &#63; and senderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param senderId the sender ID
	 * @param start the lower bound of the range of flask recipientses
	 * @param end the upper bound of the range of flask recipientses (not inclusive)
	 * @return the range of matching flask recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskRecipients> findByUserIdSenderId(long userId,
		long senderId, int start, int end) throws SystemException {
		return findByUserIdSenderId(userId, senderId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask recipientses where userId = &#63; and senderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param senderId the sender ID
	 * @param start the lower bound of the range of flask recipientses
	 * @param end the upper bound of the range of flask recipientses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flask recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskRecipients> findByUserIdSenderId(long userId,
		long senderId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDSENDERID;
			finderArgs = new Object[] { userId, senderId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDSENDERID;
			finderArgs = new Object[] {
					userId, senderId,
					
					start, end, orderByComparator
				};
		}

		List<FlaskRecipients> list = (List<FlaskRecipients>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FlaskRecipients flaskRecipients : list) {
				if ((userId != flaskRecipients.getUserId()) ||
						(senderId != flaskRecipients.getSenderId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_FLASKRECIPIENTS_WHERE);

			query.append(_FINDER_COLUMN_USERIDSENDERID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDSENDERID_SENDERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlaskRecipientsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(senderId);

				if (!pagination) {
					list = (List<FlaskRecipients>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskRecipients>(list);
				}
				else {
					list = (List<FlaskRecipients>)QueryUtil.list(q,
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
	 * Returns the first flask recipients in the ordered set where userId = &#63; and senderId = &#63;.
	 *
	 * @param userId the user ID
	 * @param senderId the sender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask recipients
	 * @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients findByUserIdSenderId_First(long userId,
		long senderId, OrderByComparator orderByComparator)
		throws NoSuchFlaskRecipientsException, SystemException {
		FlaskRecipients flaskRecipients = fetchByUserIdSenderId_First(userId,
				senderId, orderByComparator);

		if (flaskRecipients != null) {
			return flaskRecipients;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", senderId=");
		msg.append(senderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskRecipientsException(msg.toString());
	}

	/**
	 * Returns the first flask recipients in the ordered set where userId = &#63; and senderId = &#63;.
	 *
	 * @param userId the user ID
	 * @param senderId the sender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients fetchByUserIdSenderId_First(long userId,
		long senderId, OrderByComparator orderByComparator)
		throws SystemException {
		List<FlaskRecipients> list = findByUserIdSenderId(userId, senderId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flask recipients in the ordered set where userId = &#63; and senderId = &#63;.
	 *
	 * @param userId the user ID
	 * @param senderId the sender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask recipients
	 * @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a matching flask recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients findByUserIdSenderId_Last(long userId,
		long senderId, OrderByComparator orderByComparator)
		throws NoSuchFlaskRecipientsException, SystemException {
		FlaskRecipients flaskRecipients = fetchByUserIdSenderId_Last(userId,
				senderId, orderByComparator);

		if (flaskRecipients != null) {
			return flaskRecipients;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", senderId=");
		msg.append(senderId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskRecipientsException(msg.toString());
	}

	/**
	 * Returns the last flask recipients in the ordered set where userId = &#63; and senderId = &#63;.
	 *
	 * @param userId the user ID
	 * @param senderId the sender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask recipients, or <code>null</code> if a matching flask recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients fetchByUserIdSenderId_Last(long userId,
		long senderId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIdSenderId(userId, senderId);

		if (count == 0) {
			return null;
		}

		List<FlaskRecipients> list = findByUserIdSenderId(userId, senderId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flask recipientses before and after the current flask recipients in the ordered set where userId = &#63; and senderId = &#63;.
	 *
	 * @param recipientId the primary key of the current flask recipients
	 * @param userId the user ID
	 * @param senderId the sender ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flask recipients
	 * @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a flask recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients[] findByUserIdSenderId_PrevAndNext(
		long recipientId, long userId, long senderId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskRecipientsException, SystemException {
		FlaskRecipients flaskRecipients = findByPrimaryKey(recipientId);

		Session session = null;

		try {
			session = openSession();

			FlaskRecipients[] array = new FlaskRecipientsImpl[3];

			array[0] = getByUserIdSenderId_PrevAndNext(session,
					flaskRecipients, userId, senderId, orderByComparator, true);

			array[1] = flaskRecipients;

			array[2] = getByUserIdSenderId_PrevAndNext(session,
					flaskRecipients, userId, senderId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FlaskRecipients getByUserIdSenderId_PrevAndNext(Session session,
		FlaskRecipients flaskRecipients, long userId, long senderId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLASKRECIPIENTS_WHERE);

		query.append(_FINDER_COLUMN_USERIDSENDERID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDSENDERID_SENDERID_2);

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
			query.append(FlaskRecipientsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(senderId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flaskRecipients);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FlaskRecipients> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flask recipientses where userId = &#63; and senderId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param senderId the sender ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdSenderId(long userId, long senderId)
		throws SystemException {
		for (FlaskRecipients flaskRecipients : findByUserIdSenderId(userId,
				senderId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(flaskRecipients);
		}
	}

	/**
	 * Returns the number of flask recipientses where userId = &#63; and senderId = &#63;.
	 *
	 * @param userId the user ID
	 * @param senderId the sender ID
	 * @return the number of matching flask recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdSenderId(long userId, long senderId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDSENDERID;

		Object[] finderArgs = new Object[] { userId, senderId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FLASKRECIPIENTS_WHERE);

			query.append(_FINDER_COLUMN_USERIDSENDERID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDSENDERID_SENDERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(senderId);

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

	private static final String _FINDER_COLUMN_USERIDSENDERID_USERID_2 = "flaskRecipients.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDSENDERID_SENDERID_2 = "flaskRecipients.senderId = ?";

	public FlaskRecipientsPersistenceImpl() {
		setModelClass(FlaskRecipients.class);
	}

	/**
	 * Caches the flask recipients in the entity cache if it is enabled.
	 *
	 * @param flaskRecipients the flask recipients
	 */
	@Override
	public void cacheResult(FlaskRecipients flaskRecipients) {
		EntityCacheUtil.putResult(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsImpl.class, flaskRecipients.getPrimaryKey(),
			flaskRecipients);

		flaskRecipients.resetOriginalValues();
	}

	/**
	 * Caches the flask recipientses in the entity cache if it is enabled.
	 *
	 * @param flaskRecipientses the flask recipientses
	 */
	@Override
	public void cacheResult(List<FlaskRecipients> flaskRecipientses) {
		for (FlaskRecipients flaskRecipients : flaskRecipientses) {
			if (EntityCacheUtil.getResult(
						FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
						FlaskRecipientsImpl.class,
						flaskRecipients.getPrimaryKey()) == null) {
				cacheResult(flaskRecipients);
			}
			else {
				flaskRecipients.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all flask recipientses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FlaskRecipientsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FlaskRecipientsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the flask recipients.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FlaskRecipients flaskRecipients) {
		EntityCacheUtil.removeResult(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsImpl.class, flaskRecipients.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FlaskRecipients> flaskRecipientses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FlaskRecipients flaskRecipients : flaskRecipientses) {
			EntityCacheUtil.removeResult(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
				FlaskRecipientsImpl.class, flaskRecipients.getPrimaryKey());
		}
	}

	/**
	 * Creates a new flask recipients with the primary key. Does not add the flask recipients to the database.
	 *
	 * @param recipientId the primary key for the new flask recipients
	 * @return the new flask recipients
	 */
	@Override
	public FlaskRecipients create(long recipientId) {
		FlaskRecipients flaskRecipients = new FlaskRecipientsImpl();

		flaskRecipients.setNew(true);
		flaskRecipients.setPrimaryKey(recipientId);

		return flaskRecipients;
	}

	/**
	 * Removes the flask recipients with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recipientId the primary key of the flask recipients
	 * @return the flask recipients that was removed
	 * @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a flask recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients remove(long recipientId)
		throws NoSuchFlaskRecipientsException, SystemException {
		return remove((Serializable)recipientId);
	}

	/**
	 * Removes the flask recipients with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the flask recipients
	 * @return the flask recipients that was removed
	 * @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a flask recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients remove(Serializable primaryKey)
		throws NoSuchFlaskRecipientsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FlaskRecipients flaskRecipients = (FlaskRecipients)session.get(FlaskRecipientsImpl.class,
					primaryKey);

			if (flaskRecipients == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFlaskRecipientsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(flaskRecipients);
		}
		catch (NoSuchFlaskRecipientsException nsee) {
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
	protected FlaskRecipients removeImpl(FlaskRecipients flaskRecipients)
		throws SystemException {
		flaskRecipients = toUnwrappedModel(flaskRecipients);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(flaskRecipients)) {
				flaskRecipients = (FlaskRecipients)session.get(FlaskRecipientsImpl.class,
						flaskRecipients.getPrimaryKeyObj());
			}

			if (flaskRecipients != null) {
				session.delete(flaskRecipients);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (flaskRecipients != null) {
			clearCache(flaskRecipients);
		}

		return flaskRecipients;
	}

	@Override
	public FlaskRecipients updateImpl(
		com.liferay.contacts.model.FlaskRecipients flaskRecipients)
		throws SystemException {
		flaskRecipients = toUnwrappedModel(flaskRecipients);

		boolean isNew = flaskRecipients.isNew();

		FlaskRecipientsModelImpl flaskRecipientsModelImpl = (FlaskRecipientsModelImpl)flaskRecipients;

		Session session = null;

		try {
			session = openSession();

			if (flaskRecipients.isNew()) {
				session.save(flaskRecipients);

				flaskRecipients.setNew(false);
			}
			else {
				session.merge(flaskRecipients);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FlaskRecipientsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((flaskRecipientsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flaskRecipientsModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { flaskRecipientsModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((flaskRecipientsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flaskRecipientsModelImpl.getOriginalMessageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MESSAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID,
					args);

				args = new Object[] { flaskRecipientsModelImpl.getMessageId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MESSAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID,
					args);
			}

			if ((flaskRecipientsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_READFLAG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flaskRecipientsModelImpl.getOriginalUserId(),
						flaskRecipientsModelImpl.getOriginalRead(),
						flaskRecipientsModelImpl.getOriginalSenderId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_READFLAG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_READFLAG,
					args);

				args = new Object[] {
						flaskRecipientsModelImpl.getUserId(),
						flaskRecipientsModelImpl.getRead(),
						flaskRecipientsModelImpl.getSenderId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_READFLAG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_READFLAG,
					args);
			}

			if ((flaskRecipientsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_READORNOT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flaskRecipientsModelImpl.getOriginalUserId(),
						flaskRecipientsModelImpl.getOriginalMessageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_READORNOT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_READORNOT,
					args);

				args = new Object[] {
						flaskRecipientsModelImpl.getUserId(),
						flaskRecipientsModelImpl.getMessageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_READORNOT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_READORNOT,
					args);
			}

			if ((flaskRecipientsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDSENDERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flaskRecipientsModelImpl.getOriginalUserId(),
						flaskRecipientsModelImpl.getOriginalSenderId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDSENDERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDSENDERID,
					args);

				args = new Object[] {
						flaskRecipientsModelImpl.getUserId(),
						flaskRecipientsModelImpl.getSenderId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDSENDERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDSENDERID,
					args);
			}
		}

		EntityCacheUtil.putResult(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRecipientsImpl.class, flaskRecipients.getPrimaryKey(),
			flaskRecipients);

		return flaskRecipients;
	}

	protected FlaskRecipients toUnwrappedModel(FlaskRecipients flaskRecipients) {
		if (flaskRecipients instanceof FlaskRecipientsImpl) {
			return flaskRecipients;
		}

		FlaskRecipientsImpl flaskRecipientsImpl = new FlaskRecipientsImpl();

		flaskRecipientsImpl.setNew(flaskRecipients.isNew());
		flaskRecipientsImpl.setPrimaryKey(flaskRecipients.getPrimaryKey());

		flaskRecipientsImpl.setRecipientId(flaskRecipients.getRecipientId());
		flaskRecipientsImpl.setUserId(flaskRecipients.getUserId());
		flaskRecipientsImpl.setEmail(flaskRecipients.getEmail());
		flaskRecipientsImpl.setMessageId(flaskRecipients.getMessageId());
		flaskRecipientsImpl.setRead(flaskRecipients.isRead());
		flaskRecipientsImpl.setReceivedDateTime(flaskRecipients.getReceivedDateTime());
		flaskRecipientsImpl.setSenderId(flaskRecipients.getSenderId());
		flaskRecipientsImpl.setDeletedBy(flaskRecipients.getDeletedBy());

		return flaskRecipientsImpl;
	}

	/**
	 * Returns the flask recipients with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask recipients
	 * @return the flask recipients
	 * @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a flask recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFlaskRecipientsException, SystemException {
		FlaskRecipients flaskRecipients = fetchByPrimaryKey(primaryKey);

		if (flaskRecipients == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFlaskRecipientsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return flaskRecipients;
	}

	/**
	 * Returns the flask recipients with the primary key or throws a {@link com.liferay.contacts.NoSuchFlaskRecipientsException} if it could not be found.
	 *
	 * @param recipientId the primary key of the flask recipients
	 * @return the flask recipients
	 * @throws com.liferay.contacts.NoSuchFlaskRecipientsException if a flask recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients findByPrimaryKey(long recipientId)
		throws NoSuchFlaskRecipientsException, SystemException {
		return findByPrimaryKey((Serializable)recipientId);
	}

	/**
	 * Returns the flask recipients with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask recipients
	 * @return the flask recipients, or <code>null</code> if a flask recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FlaskRecipients flaskRecipients = (FlaskRecipients)EntityCacheUtil.getResult(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
				FlaskRecipientsImpl.class, primaryKey);

		if (flaskRecipients == _nullFlaskRecipients) {
			return null;
		}

		if (flaskRecipients == null) {
			Session session = null;

			try {
				session = openSession();

				flaskRecipients = (FlaskRecipients)session.get(FlaskRecipientsImpl.class,
						primaryKey);

				if (flaskRecipients != null) {
					cacheResult(flaskRecipients);
				}
				else {
					EntityCacheUtil.putResult(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
						FlaskRecipientsImpl.class, primaryKey,
						_nullFlaskRecipients);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FlaskRecipientsModelImpl.ENTITY_CACHE_ENABLED,
					FlaskRecipientsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return flaskRecipients;
	}

	/**
	 * Returns the flask recipients with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param recipientId the primary key of the flask recipients
	 * @return the flask recipients, or <code>null</code> if a flask recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients fetchByPrimaryKey(long recipientId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)recipientId);
	}

	/**
	 * Returns all the flask recipientses.
	 *
	 * @return the flask recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskRecipients> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<FlaskRecipients> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<FlaskRecipients> findAll(int start, int end,
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

		List<FlaskRecipients> list = (List<FlaskRecipients>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FLASKRECIPIENTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FLASKRECIPIENTS;

				if (pagination) {
					sql = sql.concat(FlaskRecipientsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FlaskRecipients>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskRecipients>(list);
				}
				else {
					list = (List<FlaskRecipients>)QueryUtil.list(q,
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
	 * Removes all the flask recipientses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FlaskRecipients flaskRecipients : findAll()) {
			remove(flaskRecipients);
		}
	}

	/**
	 * Returns the number of flask recipientses.
	 *
	 * @return the number of flask recipientses
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

				Query q = session.createQuery(_SQL_COUNT_FLASKRECIPIENTS);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the flask recipients persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.contacts.model.FlaskRecipients")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FlaskRecipients>> listenersList = new ArrayList<ModelListener<FlaskRecipients>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FlaskRecipients>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FlaskRecipientsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FLASKRECIPIENTS = "SELECT flaskRecipients FROM FlaskRecipients flaskRecipients";
	private static final String _SQL_SELECT_FLASKRECIPIENTS_WHERE = "SELECT flaskRecipients FROM FlaskRecipients flaskRecipients WHERE ";
	private static final String _SQL_COUNT_FLASKRECIPIENTS = "SELECT COUNT(flaskRecipients) FROM FlaskRecipients flaskRecipients";
	private static final String _SQL_COUNT_FLASKRECIPIENTS_WHERE = "SELECT COUNT(flaskRecipients) FROM FlaskRecipients flaskRecipients WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "flaskRecipients.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FlaskRecipients exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FlaskRecipients exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FlaskRecipientsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"read"
			});
	private static FlaskRecipients _nullFlaskRecipients = new FlaskRecipientsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FlaskRecipients> toCacheModel() {
				return _nullFlaskRecipientsCacheModel;
			}
		};

	private static CacheModel<FlaskRecipients> _nullFlaskRecipientsCacheModel = new CacheModel<FlaskRecipients>() {
			@Override
			public FlaskRecipients toEntityModel() {
				return _nullFlaskRecipients;
			}
		};
}