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

package com.rumbasolutions.flask.service.persistence;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rumbasolutions.flask.NoSuchUserEventException;
import com.rumbasolutions.flask.model.UserEvent;
import com.rumbasolutions.flask.model.impl.UserEventImpl;
import com.rumbasolutions.flask.model.impl.UserEventModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the user event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see UserEventPersistence
 * @see UserEventUtil
 * @generated
 */
public class UserEventPersistenceImpl extends BasePersistenceImpl<UserEvent>
	implements UserEventPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserEventUtil} to access the user event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserEventImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserEventModelImpl.ENTITY_CACHE_ENABLED,
			UserEventModelImpl.FINDER_CACHE_ENABLED, UserEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserEventModelImpl.ENTITY_CACHE_ENABLED,
			UserEventModelImpl.FINDER_CACHE_ENABLED, UserEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserEventModelImpl.ENTITY_CACHE_ENABLED,
			UserEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(UserEventModelImpl.ENTITY_CACHE_ENABLED,
			UserEventModelImpl.FINDER_CACHE_ENABLED, UserEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(UserEventModelImpl.ENTITY_CACHE_ENABLED,
			UserEventModelImpl.FINDER_CACHE_ENABLED, UserEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] { Long.class.getName() },
			UserEventModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserEventModelImpl.ENTITY_CACHE_ENABLED,
			UserEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the user events where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserEvent> findByuserId(long userId) throws SystemException {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user events where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.UserEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user events
	 * @param end the upper bound of the range of user events (not inclusive)
	 * @return the range of matching user events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserEvent> findByuserId(long userId, int start, int end)
		throws SystemException {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user events where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.UserEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user events
	 * @param end the upper bound of the range of user events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserEvent> findByuserId(long userId, int start, int end,
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

		List<UserEvent> list = (List<UserEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserEvent userEvent : list) {
				if ((userId != userEvent.getUserId())) {
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

			query.append(_SQL_SELECT_USEREVENT_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<UserEvent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserEvent>(list);
				}
				else {
					list = (List<UserEvent>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first user event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user event
	 * @throws com.rumbasolutions.flask.NoSuchUserEventException if a matching user event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEvent findByuserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserEventException, SystemException {
		UserEvent userEvent = fetchByuserId_First(userId, orderByComparator);

		if (userEvent != null) {
			return userEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserEventException(msg.toString());
	}

	/**
	 * Returns the first user event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user event, or <code>null</code> if a matching user event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEvent fetchByuserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserEvent> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user event
	 * @throws com.rumbasolutions.flask.NoSuchUserEventException if a matching user event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEvent findByuserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserEventException, SystemException {
		UserEvent userEvent = fetchByuserId_Last(userId, orderByComparator);

		if (userEvent != null) {
			return userEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserEventException(msg.toString());
	}

	/**
	 * Returns the last user event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user event, or <code>null</code> if a matching user event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEvent fetchByuserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<UserEvent> list = findByuserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user events before and after the current user event in the ordered set where userId = &#63;.
	 *
	 * @param userEventId the primary key of the current user event
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user event
	 * @throws com.rumbasolutions.flask.NoSuchUserEventException if a user event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEvent[] findByuserId_PrevAndNext(long userEventId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchUserEventException, SystemException {
		UserEvent userEvent = findByPrimaryKey(userEventId);

		Session session = null;

		try {
			session = openSession();

			UserEvent[] array = new UserEventImpl[3];

			array[0] = getByuserId_PrevAndNext(session, userEvent, userId,
					orderByComparator, true);

			array[1] = userEvent;

			array[2] = getByuserId_PrevAndNext(session, userEvent, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserEvent getByuserId_PrevAndNext(Session session,
		UserEvent userEvent, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USEREVENT_WHERE);

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
			query.append(UserEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user events where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserId(long userId) throws SystemException {
		for (UserEvent userEvent : findByuserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userEvent);
		}
	}

	/**
	 * Returns the number of user events where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USEREVENT_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "userEvent.userId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USEREVENT = new FinderPath(UserEventModelImpl.ENTITY_CACHE_ENABLED,
			UserEventModelImpl.FINDER_CACHE_ENABLED, UserEventImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByuserEvent",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserEventModelImpl.USERID_COLUMN_BITMASK |
			UserEventModelImpl.EVENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USEREVENT = new FinderPath(UserEventModelImpl.ENTITY_CACHE_ENABLED,
			UserEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserEvent",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the user event where userId = &#63; and eventId = &#63; or throws a {@link com.rumbasolutions.flask.NoSuchUserEventException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param eventId the event ID
	 * @return the matching user event
	 * @throws com.rumbasolutions.flask.NoSuchUserEventException if a matching user event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEvent findByuserEvent(long userId, long eventId)
		throws NoSuchUserEventException, SystemException {
		UserEvent userEvent = fetchByuserEvent(userId, eventId);

		if (userEvent == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", eventId=");
			msg.append(eventId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserEventException(msg.toString());
		}

		return userEvent;
	}

	/**
	 * Returns the user event where userId = &#63; and eventId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param eventId the event ID
	 * @return the matching user event, or <code>null</code> if a matching user event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEvent fetchByuserEvent(long userId, long eventId)
		throws SystemException {
		return fetchByuserEvent(userId, eventId, true);
	}

	/**
	 * Returns the user event where userId = &#63; and eventId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param eventId the event ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user event, or <code>null</code> if a matching user event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEvent fetchByuserEvent(long userId, long eventId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, eventId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USEREVENT,
					finderArgs, this);
		}

		if (result instanceof UserEvent) {
			UserEvent userEvent = (UserEvent)result;

			if ((userId != userEvent.getUserId()) ||
					(eventId != userEvent.getEventId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_USEREVENT_WHERE);

			query.append(_FINDER_COLUMN_USEREVENT_USERID_2);

			query.append(_FINDER_COLUMN_USEREVENT_EVENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(eventId);

				List<UserEvent> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USEREVENT,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UserEventPersistenceImpl.fetchByuserEvent(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UserEvent userEvent = list.get(0);

					result = userEvent;

					cacheResult(userEvent);

					if ((userEvent.getUserId() != userId) ||
							(userEvent.getEventId() != eventId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USEREVENT,
							finderArgs, userEvent);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USEREVENT,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (UserEvent)result;
		}
	}

	/**
	 * Removes the user event where userId = &#63; and eventId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param eventId the event ID
	 * @return the user event that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEvent removeByuserEvent(long userId, long eventId)
		throws NoSuchUserEventException, SystemException {
		UserEvent userEvent = findByuserEvent(userId, eventId);

		return remove(userEvent);
	}

	/**
	 * Returns the number of user events where userId = &#63; and eventId = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventId the event ID
	 * @return the number of matching user events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserEvent(long userId, long eventId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USEREVENT;

		Object[] finderArgs = new Object[] { userId, eventId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USEREVENT_WHERE);

			query.append(_FINDER_COLUMN_USEREVENT_USERID_2);

			query.append(_FINDER_COLUMN_USEREVENT_EVENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(eventId);

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

	private static final String _FINDER_COLUMN_USEREVENT_USERID_2 = "userEvent.userId = ? AND ";
	private static final String _FINDER_COLUMN_USEREVENT_EVENTID_2 = "userEvent.eventId = ?";

	public UserEventPersistenceImpl() {
		setModelClass(UserEvent.class);
	}

	/**
	 * Caches the user event in the entity cache if it is enabled.
	 *
	 * @param userEvent the user event
	 */
	@Override
	public void cacheResult(UserEvent userEvent) {
		EntityCacheUtil.putResult(UserEventModelImpl.ENTITY_CACHE_ENABLED,
			UserEventImpl.class, userEvent.getPrimaryKey(), userEvent);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USEREVENT,
			new Object[] { userEvent.getUserId(), userEvent.getEventId() },
			userEvent);

		userEvent.resetOriginalValues();
	}

	/**
	 * Caches the user events in the entity cache if it is enabled.
	 *
	 * @param userEvents the user events
	 */
	@Override
	public void cacheResult(List<UserEvent> userEvents) {
		for (UserEvent userEvent : userEvents) {
			if (EntityCacheUtil.getResult(
						UserEventModelImpl.ENTITY_CACHE_ENABLED,
						UserEventImpl.class, userEvent.getPrimaryKey()) == null) {
				cacheResult(userEvent);
			}
			else {
				userEvent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user events.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserEventImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserEventImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user event.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserEvent userEvent) {
		EntityCacheUtil.removeResult(UserEventModelImpl.ENTITY_CACHE_ENABLED,
			UserEventImpl.class, userEvent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(userEvent);
	}

	@Override
	public void clearCache(List<UserEvent> userEvents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserEvent userEvent : userEvents) {
			EntityCacheUtil.removeResult(UserEventModelImpl.ENTITY_CACHE_ENABLED,
				UserEventImpl.class, userEvent.getPrimaryKey());

			clearUniqueFindersCache(userEvent);
		}
	}

	protected void cacheUniqueFindersCache(UserEvent userEvent) {
		if (userEvent.isNew()) {
			Object[] args = new Object[] {
					userEvent.getUserId(), userEvent.getEventId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USEREVENT, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USEREVENT, args,
				userEvent);
		}
		else {
			UserEventModelImpl userEventModelImpl = (UserEventModelImpl)userEvent;

			if ((userEventModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USEREVENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userEvent.getUserId(), userEvent.getEventId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USEREVENT, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USEREVENT, args,
					userEvent);
			}
		}
	}

	protected void clearUniqueFindersCache(UserEvent userEvent) {
		UserEventModelImpl userEventModelImpl = (UserEventModelImpl)userEvent;

		Object[] args = new Object[] {
				userEvent.getUserId(), userEvent.getEventId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USEREVENT, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USEREVENT, args);

		if ((userEventModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USEREVENT.getColumnBitmask()) != 0) {
			args = new Object[] {
					userEventModelImpl.getOriginalUserId(),
					userEventModelImpl.getOriginalEventId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USEREVENT, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USEREVENT, args);
		}
	}

	/**
	 * Creates a new user event with the primary key. Does not add the user event to the database.
	 *
	 * @param userEventId the primary key for the new user event
	 * @return the new user event
	 */
	@Override
	public UserEvent create(long userEventId) {
		UserEvent userEvent = new UserEventImpl();

		userEvent.setNew(true);
		userEvent.setPrimaryKey(userEventId);

		return userEvent;
	}

	/**
	 * Removes the user event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userEventId the primary key of the user event
	 * @return the user event that was removed
	 * @throws com.rumbasolutions.flask.NoSuchUserEventException if a user event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEvent remove(long userEventId)
		throws NoSuchUserEventException, SystemException {
		return remove((Serializable)userEventId);
	}

	/**
	 * Removes the user event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user event
	 * @return the user event that was removed
	 * @throws com.rumbasolutions.flask.NoSuchUserEventException if a user event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEvent remove(Serializable primaryKey)
		throws NoSuchUserEventException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserEvent userEvent = (UserEvent)session.get(UserEventImpl.class,
					primaryKey);

			if (userEvent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userEvent);
		}
		catch (NoSuchUserEventException nsee) {
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
	protected UserEvent removeImpl(UserEvent userEvent)
		throws SystemException {
		userEvent = toUnwrappedModel(userEvent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userEvent)) {
				userEvent = (UserEvent)session.get(UserEventImpl.class,
						userEvent.getPrimaryKeyObj());
			}

			if (userEvent != null) {
				session.delete(userEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userEvent != null) {
			clearCache(userEvent);
		}

		return userEvent;
	}

	@Override
	public UserEvent updateImpl(
		com.rumbasolutions.flask.model.UserEvent userEvent)
		throws SystemException {
		userEvent = toUnwrappedModel(userEvent);

		boolean isNew = userEvent.isNew();

		UserEventModelImpl userEventModelImpl = (UserEventModelImpl)userEvent;

		Session session = null;

		try {
			session = openSession();

			if (userEvent.isNew()) {
				session.save(userEvent);

				userEvent.setNew(false);
			}
			else {
				session.merge(userEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserEventModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userEventModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { userEventModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(UserEventModelImpl.ENTITY_CACHE_ENABLED,
			UserEventImpl.class, userEvent.getPrimaryKey(), userEvent);

		clearUniqueFindersCache(userEvent);
		cacheUniqueFindersCache(userEvent);

		return userEvent;
	}

	protected UserEvent toUnwrappedModel(UserEvent userEvent) {
		if (userEvent instanceof UserEventImpl) {
			return userEvent;
		}

		UserEventImpl userEventImpl = new UserEventImpl();

		userEventImpl.setNew(userEvent.isNew());
		userEventImpl.setPrimaryKey(userEvent.getPrimaryKey());

		userEventImpl.setUserEventId(userEvent.getUserEventId());
		userEventImpl.setUserId(userEvent.getUserId());
		userEventImpl.setEventId(userEvent.getEventId());
		userEventImpl.setCreatedDate(userEvent.getCreatedDate());

		return userEventImpl;
	}

	/**
	 * Returns the user event with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user event
	 * @return the user event
	 * @throws com.rumbasolutions.flask.NoSuchUserEventException if a user event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserEventException, SystemException {
		UserEvent userEvent = fetchByPrimaryKey(primaryKey);

		if (userEvent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userEvent;
	}

	/**
	 * Returns the user event with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchUserEventException} if it could not be found.
	 *
	 * @param userEventId the primary key of the user event
	 * @return the user event
	 * @throws com.rumbasolutions.flask.NoSuchUserEventException if a user event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEvent findByPrimaryKey(long userEventId)
		throws NoSuchUserEventException, SystemException {
		return findByPrimaryKey((Serializable)userEventId);
	}

	/**
	 * Returns the user event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user event
	 * @return the user event, or <code>null</code> if a user event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEvent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserEvent userEvent = (UserEvent)EntityCacheUtil.getResult(UserEventModelImpl.ENTITY_CACHE_ENABLED,
				UserEventImpl.class, primaryKey);

		if (userEvent == _nullUserEvent) {
			return null;
		}

		if (userEvent == null) {
			Session session = null;

			try {
				session = openSession();

				userEvent = (UserEvent)session.get(UserEventImpl.class,
						primaryKey);

				if (userEvent != null) {
					cacheResult(userEvent);
				}
				else {
					EntityCacheUtil.putResult(UserEventModelImpl.ENTITY_CACHE_ENABLED,
						UserEventImpl.class, primaryKey, _nullUserEvent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserEventModelImpl.ENTITY_CACHE_ENABLED,
					UserEventImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userEvent;
	}

	/**
	 * Returns the user event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userEventId the primary key of the user event
	 * @return the user event, or <code>null</code> if a user event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEvent fetchByPrimaryKey(long userEventId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)userEventId);
	}

	/**
	 * Returns all the user events.
	 *
	 * @return the user events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserEvent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.UserEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user events
	 * @param end the upper bound of the range of user events (not inclusive)
	 * @return the range of user events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserEvent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.UserEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user events
	 * @param end the upper bound of the range of user events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserEvent> findAll(int start, int end,
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

		List<UserEvent> list = (List<UserEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USEREVENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USEREVENT;

				if (pagination) {
					sql = sql.concat(UserEventModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserEvent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserEvent>(list);
				}
				else {
					list = (List<UserEvent>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the user events from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserEvent userEvent : findAll()) {
			remove(userEvent);
		}
	}

	/**
	 * Returns the number of user events.
	 *
	 * @return the number of user events
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

				Query q = session.createQuery(_SQL_COUNT_USEREVENT);

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
	 * Initializes the user event persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.UserEvent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserEvent>> listenersList = new ArrayList<ModelListener<UserEvent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserEvent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserEventImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USEREVENT = "SELECT userEvent FROM UserEvent userEvent";
	private static final String _SQL_SELECT_USEREVENT_WHERE = "SELECT userEvent FROM UserEvent userEvent WHERE ";
	private static final String _SQL_COUNT_USEREVENT = "SELECT COUNT(userEvent) FROM UserEvent userEvent";
	private static final String _SQL_COUNT_USEREVENT_WHERE = "SELECT COUNT(userEvent) FROM UserEvent userEvent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userEvent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserEvent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserEvent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserEventPersistenceImpl.class);
	private static UserEvent _nullUserEvent = new UserEventImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserEvent> toCacheModel() {
				return _nullUserEventCacheModel;
			}
		};

	private static CacheModel<UserEvent> _nullUserEventCacheModel = new CacheModel<UserEvent>() {
			@Override
			public UserEvent toEntityModel() {
				return _nullUserEvent;
			}
		};
}