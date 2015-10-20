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

import com.rumbasolutions.flask.NoSuchFlaskGroupUsersException;
import com.rumbasolutions.flask.model.FlaskGroupUsers;
import com.rumbasolutions.flask.model.impl.FlaskGroupUsersImpl;
import com.rumbasolutions.flask.model.impl.FlaskGroupUsersModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the flask group users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupUsersPersistence
 * @see FlaskGroupUsersUtil
 * @generated
 */
public class FlaskGroupUsersPersistenceImpl extends BasePersistenceImpl<FlaskGroupUsers>
	implements FlaskGroupUsersPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FlaskGroupUsersUtil} to access the flask group users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FlaskGroupUsersImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FlaskGroupUsersModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupUsersModelImpl.FINDER_CACHE_ENABLED,
			FlaskGroupUsersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FlaskGroupUsersModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupUsersModelImpl.FINDER_CACHE_ENABLED,
			FlaskGroupUsersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FlaskGroupUsersModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERGROUPS =
		new FinderPath(FlaskGroupUsersModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupUsersModelImpl.FINDER_CACHE_ENABLED,
			FlaskGroupUsersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserGroups",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERGROUPS =
		new FinderPath(FlaskGroupUsersModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupUsersModelImpl.FINDER_CACHE_ENABLED,
			FlaskGroupUsersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserGroups",
			new String[] { Long.class.getName() },
			FlaskGroupUsersModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERGROUPS = new FinderPath(FlaskGroupUsersModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserGroups",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the flask group userses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching flask group userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupUsers> findByUserGroups(long groupId)
		throws SystemException {
		return findByUserGroups(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the flask group userses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of flask group userses
	 * @param end the upper bound of the range of flask group userses (not inclusive)
	 * @return the range of matching flask group userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupUsers> findByUserGroups(long groupId, int start,
		int end) throws SystemException {
		return findByUserGroups(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask group userses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of flask group userses
	 * @param end the upper bound of the range of flask group userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flask group userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupUsers> findByUserGroups(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERGROUPS;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERGROUPS;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<FlaskGroupUsers> list = (List<FlaskGroupUsers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FlaskGroupUsers flaskGroupUsers : list) {
				if ((groupId != flaskGroupUsers.getGroupId())) {
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

			query.append(_SQL_SELECT_FLASKGROUPUSERS_WHERE);

			query.append(_FINDER_COLUMN_USERGROUPS_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlaskGroupUsersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<FlaskGroupUsers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskGroupUsers>(list);
				}
				else {
					list = (List<FlaskGroupUsers>)QueryUtil.list(q,
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
	 * Returns the first flask group users in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask group users
	 * @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a matching flask group users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupUsers findByUserGroups_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskGroupUsersException, SystemException {
		FlaskGroupUsers flaskGroupUsers = fetchByUserGroups_First(groupId,
				orderByComparator);

		if (flaskGroupUsers != null) {
			return flaskGroupUsers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskGroupUsersException(msg.toString());
	}

	/**
	 * Returns the first flask group users in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask group users, or <code>null</code> if a matching flask group users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupUsers fetchByUserGroups_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FlaskGroupUsers> list = findByUserGroups(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flask group users in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask group users
	 * @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a matching flask group users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupUsers findByUserGroups_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskGroupUsersException, SystemException {
		FlaskGroupUsers flaskGroupUsers = fetchByUserGroups_Last(groupId,
				orderByComparator);

		if (flaskGroupUsers != null) {
			return flaskGroupUsers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskGroupUsersException(msg.toString());
	}

	/**
	 * Returns the last flask group users in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask group users, or <code>null</code> if a matching flask group users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupUsers fetchByUserGroups_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserGroups(groupId);

		if (count == 0) {
			return null;
		}

		List<FlaskGroupUsers> list = findByUserGroups(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flask group userses before and after the current flask group users in the ordered set where groupId = &#63;.
	 *
	 * @param groupUserId the primary key of the current flask group users
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flask group users
	 * @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a flask group users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupUsers[] findByUserGroups_PrevAndNext(long groupUserId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchFlaskGroupUsersException, SystemException {
		FlaskGroupUsers flaskGroupUsers = findByPrimaryKey(groupUserId);

		Session session = null;

		try {
			session = openSession();

			FlaskGroupUsers[] array = new FlaskGroupUsersImpl[3];

			array[0] = getByUserGroups_PrevAndNext(session, flaskGroupUsers,
					groupId, orderByComparator, true);

			array[1] = flaskGroupUsers;

			array[2] = getByUserGroups_PrevAndNext(session, flaskGroupUsers,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FlaskGroupUsers getByUserGroups_PrevAndNext(Session session,
		FlaskGroupUsers flaskGroupUsers, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLASKGROUPUSERS_WHERE);

		query.append(_FINDER_COLUMN_USERGROUPS_GROUPID_2);

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
			query.append(FlaskGroupUsersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flaskGroupUsers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FlaskGroupUsers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flask group userses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserGroups(long groupId) throws SystemException {
		for (FlaskGroupUsers flaskGroupUsers : findByUserGroups(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(flaskGroupUsers);
		}
	}

	/**
	 * Returns the number of flask group userses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching flask group userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserGroups(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERGROUPS;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FLASKGROUPUSERS_WHERE);

			query.append(_FINDER_COLUMN_USERGROUPS_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_USERGROUPS_GROUPID_2 = "flaskGroupUsers.groupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERIDGROUPID = new FinderPath(FlaskGroupUsersModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupUsersModelImpl.FINDER_CACHE_ENABLED,
			FlaskGroupUsersImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			FlaskGroupUsersModelImpl.USERID_COLUMN_BITMASK |
			FlaskGroupUsersModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDGROUPID = new FinderPath(FlaskGroupUsersModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the flask group users where userId = &#63; and groupId = &#63; or throws a {@link com.rumbasolutions.flask.NoSuchFlaskGroupUsersException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching flask group users
	 * @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a matching flask group users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupUsers findByUserIdGroupId(long userId, long groupId)
		throws NoSuchFlaskGroupUsersException, SystemException {
		FlaskGroupUsers flaskGroupUsers = fetchByUserIdGroupId(userId, groupId);

		if (flaskGroupUsers == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFlaskGroupUsersException(msg.toString());
		}

		return flaskGroupUsers;
	}

	/**
	 * Returns the flask group users where userId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching flask group users, or <code>null</code> if a matching flask group users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupUsers fetchByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		return fetchByUserIdGroupId(userId, groupId, true);
	}

	/**
	 * Returns the flask group users where userId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching flask group users, or <code>null</code> if a matching flask group users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupUsers fetchByUserIdGroupId(long userId, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERIDGROUPID,
					finderArgs, this);
		}

		if (result instanceof FlaskGroupUsers) {
			FlaskGroupUsers flaskGroupUsers = (FlaskGroupUsers)result;

			if ((userId != flaskGroupUsers.getUserId()) ||
					(groupId != flaskGroupUsers.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_FLASKGROUPUSERS_WHERE);

			query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				List<FlaskGroupUsers> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDGROUPID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"FlaskGroupUsersPersistenceImpl.fetchByUserIdGroupId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					FlaskGroupUsers flaskGroupUsers = list.get(0);

					result = flaskGroupUsers;

					cacheResult(flaskGroupUsers);

					if ((flaskGroupUsers.getUserId() != userId) ||
							(flaskGroupUsers.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDGROUPID,
							finderArgs, flaskGroupUsers);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDGROUPID,
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
			return (FlaskGroupUsers)result;
		}
	}

	/**
	 * Removes the flask group users where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the flask group users that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupUsers removeByUserIdGroupId(long userId, long groupId)
		throws NoSuchFlaskGroupUsersException, SystemException {
		FlaskGroupUsers flaskGroupUsers = findByUserIdGroupId(userId, groupId);

		return remove(flaskGroupUsers);
	}

	/**
	 * Returns the number of flask group userses where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching flask group userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDGROUPID;

		Object[] finderArgs = new Object[] { userId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FLASKGROUPUSERS_WHERE);

			query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_USERIDGROUPID_USERID_2 = "flaskGroupUsers.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDGROUPID_GROUPID_2 = "flaskGroupUsers.groupId = ?";

	public FlaskGroupUsersPersistenceImpl() {
		setModelClass(FlaskGroupUsers.class);
	}

	/**
	 * Caches the flask group users in the entity cache if it is enabled.
	 *
	 * @param flaskGroupUsers the flask group users
	 */
	@Override
	public void cacheResult(FlaskGroupUsers flaskGroupUsers) {
		EntityCacheUtil.putResult(FlaskGroupUsersModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupUsersImpl.class, flaskGroupUsers.getPrimaryKey(),
			flaskGroupUsers);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDGROUPID,
			new Object[] {
				flaskGroupUsers.getUserId(), flaskGroupUsers.getGroupId()
			}, flaskGroupUsers);

		flaskGroupUsers.resetOriginalValues();
	}

	/**
	 * Caches the flask group userses in the entity cache if it is enabled.
	 *
	 * @param flaskGroupUserses the flask group userses
	 */
	@Override
	public void cacheResult(List<FlaskGroupUsers> flaskGroupUserses) {
		for (FlaskGroupUsers flaskGroupUsers : flaskGroupUserses) {
			if (EntityCacheUtil.getResult(
						FlaskGroupUsersModelImpl.ENTITY_CACHE_ENABLED,
						FlaskGroupUsersImpl.class,
						flaskGroupUsers.getPrimaryKey()) == null) {
				cacheResult(flaskGroupUsers);
			}
			else {
				flaskGroupUsers.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all flask group userses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FlaskGroupUsersImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FlaskGroupUsersImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the flask group users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FlaskGroupUsers flaskGroupUsers) {
		EntityCacheUtil.removeResult(FlaskGroupUsersModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupUsersImpl.class, flaskGroupUsers.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(flaskGroupUsers);
	}

	@Override
	public void clearCache(List<FlaskGroupUsers> flaskGroupUserses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FlaskGroupUsers flaskGroupUsers : flaskGroupUserses) {
			EntityCacheUtil.removeResult(FlaskGroupUsersModelImpl.ENTITY_CACHE_ENABLED,
				FlaskGroupUsersImpl.class, flaskGroupUsers.getPrimaryKey());

			clearUniqueFindersCache(flaskGroupUsers);
		}
	}

	protected void cacheUniqueFindersCache(FlaskGroupUsers flaskGroupUsers) {
		if (flaskGroupUsers.isNew()) {
			Object[] args = new Object[] {
					flaskGroupUsers.getUserId(), flaskGroupUsers.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDGROUPID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDGROUPID, args,
				flaskGroupUsers);
		}
		else {
			FlaskGroupUsersModelImpl flaskGroupUsersModelImpl = (FlaskGroupUsersModelImpl)flaskGroupUsers;

			if ((flaskGroupUsersModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERIDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flaskGroupUsers.getUserId(),
						flaskGroupUsers.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDGROUPID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERIDGROUPID,
					args, flaskGroupUsers);
			}
		}
	}

	protected void clearUniqueFindersCache(FlaskGroupUsers flaskGroupUsers) {
		FlaskGroupUsersModelImpl flaskGroupUsersModelImpl = (FlaskGroupUsersModelImpl)flaskGroupUsers;

		Object[] args = new Object[] {
				flaskGroupUsers.getUserId(), flaskGroupUsers.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDGROUPID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDGROUPID, args);

		if ((flaskGroupUsersModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USERIDGROUPID.getColumnBitmask()) != 0) {
			args = new Object[] {
					flaskGroupUsersModelImpl.getOriginalUserId(),
					flaskGroupUsersModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDGROUPID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERIDGROUPID,
				args);
		}
	}

	/**
	 * Creates a new flask group users with the primary key. Does not add the flask group users to the database.
	 *
	 * @param groupUserId the primary key for the new flask group users
	 * @return the new flask group users
	 */
	@Override
	public FlaskGroupUsers create(long groupUserId) {
		FlaskGroupUsers flaskGroupUsers = new FlaskGroupUsersImpl();

		flaskGroupUsers.setNew(true);
		flaskGroupUsers.setPrimaryKey(groupUserId);

		return flaskGroupUsers;
	}

	/**
	 * Removes the flask group users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserId the primary key of the flask group users
	 * @return the flask group users that was removed
	 * @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a flask group users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupUsers remove(long groupUserId)
		throws NoSuchFlaskGroupUsersException, SystemException {
		return remove((Serializable)groupUserId);
	}

	/**
	 * Removes the flask group users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the flask group users
	 * @return the flask group users that was removed
	 * @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a flask group users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupUsers remove(Serializable primaryKey)
		throws NoSuchFlaskGroupUsersException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FlaskGroupUsers flaskGroupUsers = (FlaskGroupUsers)session.get(FlaskGroupUsersImpl.class,
					primaryKey);

			if (flaskGroupUsers == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFlaskGroupUsersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(flaskGroupUsers);
		}
		catch (NoSuchFlaskGroupUsersException nsee) {
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
	protected FlaskGroupUsers removeImpl(FlaskGroupUsers flaskGroupUsers)
		throws SystemException {
		flaskGroupUsers = toUnwrappedModel(flaskGroupUsers);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(flaskGroupUsers)) {
				flaskGroupUsers = (FlaskGroupUsers)session.get(FlaskGroupUsersImpl.class,
						flaskGroupUsers.getPrimaryKeyObj());
			}

			if (flaskGroupUsers != null) {
				session.delete(flaskGroupUsers);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (flaskGroupUsers != null) {
			clearCache(flaskGroupUsers);
		}

		return flaskGroupUsers;
	}

	@Override
	public FlaskGroupUsers updateImpl(
		com.rumbasolutions.flask.model.FlaskGroupUsers flaskGroupUsers)
		throws SystemException {
		flaskGroupUsers = toUnwrappedModel(flaskGroupUsers);

		boolean isNew = flaskGroupUsers.isNew();

		FlaskGroupUsersModelImpl flaskGroupUsersModelImpl = (FlaskGroupUsersModelImpl)flaskGroupUsers;

		Session session = null;

		try {
			session = openSession();

			if (flaskGroupUsers.isNew()) {
				session.save(flaskGroupUsers);

				flaskGroupUsers.setNew(false);
			}
			else {
				session.merge(flaskGroupUsers);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FlaskGroupUsersModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((flaskGroupUsersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERGROUPS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flaskGroupUsersModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERGROUPS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERGROUPS,
					args);

				args = new Object[] { flaskGroupUsersModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERGROUPS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERGROUPS,
					args);
			}
		}

		EntityCacheUtil.putResult(FlaskGroupUsersModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupUsersImpl.class, flaskGroupUsers.getPrimaryKey(),
			flaskGroupUsers);

		clearUniqueFindersCache(flaskGroupUsers);
		cacheUniqueFindersCache(flaskGroupUsers);

		return flaskGroupUsers;
	}

	protected FlaskGroupUsers toUnwrappedModel(FlaskGroupUsers flaskGroupUsers) {
		if (flaskGroupUsers instanceof FlaskGroupUsersImpl) {
			return flaskGroupUsers;
		}

		FlaskGroupUsersImpl flaskGroupUsersImpl = new FlaskGroupUsersImpl();

		flaskGroupUsersImpl.setNew(flaskGroupUsers.isNew());
		flaskGroupUsersImpl.setPrimaryKey(flaskGroupUsers.getPrimaryKey());

		flaskGroupUsersImpl.setGroupUserId(flaskGroupUsers.getGroupUserId());
		flaskGroupUsersImpl.setGroupId(flaskGroupUsers.getGroupId());
		flaskGroupUsersImpl.setUserId(flaskGroupUsers.getUserId());
		flaskGroupUsersImpl.setUserName(flaskGroupUsers.getUserName());
		flaskGroupUsersImpl.setIsAdmin(flaskGroupUsers.getIsAdmin());
		flaskGroupUsersImpl.setEmailAddress(flaskGroupUsers.getEmailAddress());

		return flaskGroupUsersImpl;
	}

	/**
	 * Returns the flask group users with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask group users
	 * @return the flask group users
	 * @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a flask group users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupUsers findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFlaskGroupUsersException, SystemException {
		FlaskGroupUsers flaskGroupUsers = fetchByPrimaryKey(primaryKey);

		if (flaskGroupUsers == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFlaskGroupUsersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return flaskGroupUsers;
	}

	/**
	 * Returns the flask group users with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchFlaskGroupUsersException} if it could not be found.
	 *
	 * @param groupUserId the primary key of the flask group users
	 * @return the flask group users
	 * @throws com.rumbasolutions.flask.NoSuchFlaskGroupUsersException if a flask group users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupUsers findByPrimaryKey(long groupUserId)
		throws NoSuchFlaskGroupUsersException, SystemException {
		return findByPrimaryKey((Serializable)groupUserId);
	}

	/**
	 * Returns the flask group users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask group users
	 * @return the flask group users, or <code>null</code> if a flask group users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupUsers fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FlaskGroupUsers flaskGroupUsers = (FlaskGroupUsers)EntityCacheUtil.getResult(FlaskGroupUsersModelImpl.ENTITY_CACHE_ENABLED,
				FlaskGroupUsersImpl.class, primaryKey);

		if (flaskGroupUsers == _nullFlaskGroupUsers) {
			return null;
		}

		if (flaskGroupUsers == null) {
			Session session = null;

			try {
				session = openSession();

				flaskGroupUsers = (FlaskGroupUsers)session.get(FlaskGroupUsersImpl.class,
						primaryKey);

				if (flaskGroupUsers != null) {
					cacheResult(flaskGroupUsers);
				}
				else {
					EntityCacheUtil.putResult(FlaskGroupUsersModelImpl.ENTITY_CACHE_ENABLED,
						FlaskGroupUsersImpl.class, primaryKey,
						_nullFlaskGroupUsers);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FlaskGroupUsersModelImpl.ENTITY_CACHE_ENABLED,
					FlaskGroupUsersImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return flaskGroupUsers;
	}

	/**
	 * Returns the flask group users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserId the primary key of the flask group users
	 * @return the flask group users, or <code>null</code> if a flask group users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupUsers fetchByPrimaryKey(long groupUserId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)groupUserId);
	}

	/**
	 * Returns all the flask group userses.
	 *
	 * @return the flask group userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupUsers> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flask group userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask group userses
	 * @param end the upper bound of the range of flask group userses (not inclusive)
	 * @return the range of flask group userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupUsers> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask group userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask group userses
	 * @param end the upper bound of the range of flask group userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of flask group userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupUsers> findAll(int start, int end,
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

		List<FlaskGroupUsers> list = (List<FlaskGroupUsers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FLASKGROUPUSERS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FLASKGROUPUSERS;

				if (pagination) {
					sql = sql.concat(FlaskGroupUsersModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FlaskGroupUsers>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskGroupUsers>(list);
				}
				else {
					list = (List<FlaskGroupUsers>)QueryUtil.list(q,
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
	 * Removes all the flask group userses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FlaskGroupUsers flaskGroupUsers : findAll()) {
			remove(flaskGroupUsers);
		}
	}

	/**
	 * Returns the number of flask group userses.
	 *
	 * @return the number of flask group userses
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

				Query q = session.createQuery(_SQL_COUNT_FLASKGROUPUSERS);

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
	 * Initializes the flask group users persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.FlaskGroupUsers")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FlaskGroupUsers>> listenersList = new ArrayList<ModelListener<FlaskGroupUsers>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FlaskGroupUsers>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FlaskGroupUsersImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FLASKGROUPUSERS = "SELECT flaskGroupUsers FROM FlaskGroupUsers flaskGroupUsers";
	private static final String _SQL_SELECT_FLASKGROUPUSERS_WHERE = "SELECT flaskGroupUsers FROM FlaskGroupUsers flaskGroupUsers WHERE ";
	private static final String _SQL_COUNT_FLASKGROUPUSERS = "SELECT COUNT(flaskGroupUsers) FROM FlaskGroupUsers flaskGroupUsers";
	private static final String _SQL_COUNT_FLASKGROUPUSERS_WHERE = "SELECT COUNT(flaskGroupUsers) FROM FlaskGroupUsers flaskGroupUsers WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "flaskGroupUsers.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FlaskGroupUsers exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FlaskGroupUsers exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FlaskGroupUsersPersistenceImpl.class);
	private static FlaskGroupUsers _nullFlaskGroupUsers = new FlaskGroupUsersImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FlaskGroupUsers> toCacheModel() {
				return _nullFlaskGroupUsersCacheModel;
			}
		};

	private static CacheModel<FlaskGroupUsers> _nullFlaskGroupUsersCacheModel = new CacheModel<FlaskGroupUsers>() {
			@Override
			public FlaskGroupUsers toEntityModel() {
				return _nullFlaskGroupUsers;
			}
		};
}