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

import com.liferay.contacts.NoSuchFlaskGroupMessagesException;
import com.liferay.contacts.model.FlaskGroupMessages;
import com.liferay.contacts.model.impl.FlaskGroupMessagesImpl;
import com.liferay.contacts.model.impl.FlaskGroupMessagesModelImpl;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the flask group messages service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupMessagesPersistence
 * @see FlaskGroupMessagesUtil
 * @generated
 */
public class FlaskGroupMessagesPersistenceImpl extends BasePersistenceImpl<FlaskGroupMessages>
	implements FlaskGroupMessagesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FlaskGroupMessagesUtil} to access the flask group messages persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FlaskGroupMessagesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FlaskGroupMessagesModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupMessagesModelImpl.FINDER_CACHE_ENABLED,
			FlaskGroupMessagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FlaskGroupMessagesModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupMessagesModelImpl.FINDER_CACHE_ENABLED,
			FlaskGroupMessagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FlaskGroupMessagesModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupMessagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(FlaskGroupMessagesModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupMessagesModelImpl.FINDER_CACHE_ENABLED,
			FlaskGroupMessagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(FlaskGroupMessagesModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupMessagesModelImpl.FINDER_CACHE_ENABLED,
			FlaskGroupMessagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygroupId",
			new String[] { Long.class.getName() },
			FlaskGroupMessagesModelImpl.GROUPID_COLUMN_BITMASK |
			FlaskGroupMessagesModelImpl.DATETIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(FlaskGroupMessagesModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupMessagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the flask group messageses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching flask group messageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupMessages> findBygroupId(long groupId)
		throws SystemException {
		return findBygroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flask group messageses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupMessagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of flask group messageses
	 * @param end the upper bound of the range of flask group messageses (not inclusive)
	 * @return the range of matching flask group messageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupMessages> findBygroupId(long groupId, int start,
		int end) throws SystemException {
		return findBygroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask group messageses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupMessagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of flask group messageses
	 * @param end the upper bound of the range of flask group messageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flask group messageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupMessages> findBygroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<FlaskGroupMessages> list = (List<FlaskGroupMessages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FlaskGroupMessages flaskGroupMessages : list) {
				if ((groupId != flaskGroupMessages.getGroupId())) {
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

			query.append(_SQL_SELECT_FLASKGROUPMESSAGES_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlaskGroupMessagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<FlaskGroupMessages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskGroupMessages>(list);
				}
				else {
					list = (List<FlaskGroupMessages>)QueryUtil.list(q,
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
	 * Returns the first flask group messages in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask group messages
	 * @throws com.liferay.contacts.NoSuchFlaskGroupMessagesException if a matching flask group messages could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupMessages findBygroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskGroupMessagesException, SystemException {
		FlaskGroupMessages flaskGroupMessages = fetchBygroupId_First(groupId,
				orderByComparator);

		if (flaskGroupMessages != null) {
			return flaskGroupMessages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskGroupMessagesException(msg.toString());
	}

	/**
	 * Returns the first flask group messages in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask group messages, or <code>null</code> if a matching flask group messages could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupMessages fetchBygroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FlaskGroupMessages> list = findBygroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flask group messages in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask group messages
	 * @throws com.liferay.contacts.NoSuchFlaskGroupMessagesException if a matching flask group messages could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupMessages findBygroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskGroupMessagesException, SystemException {
		FlaskGroupMessages flaskGroupMessages = fetchBygroupId_Last(groupId,
				orderByComparator);

		if (flaskGroupMessages != null) {
			return flaskGroupMessages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskGroupMessagesException(msg.toString());
	}

	/**
	 * Returns the last flask group messages in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask group messages, or <code>null</code> if a matching flask group messages could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupMessages fetchBygroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBygroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<FlaskGroupMessages> list = findBygroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flask group messageses before and after the current flask group messages in the ordered set where groupId = &#63;.
	 *
	 * @param groupMessagesId the primary key of the current flask group messages
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flask group messages
	 * @throws com.liferay.contacts.NoSuchFlaskGroupMessagesException if a flask group messages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupMessages[] findBygroupId_PrevAndNext(
		long groupMessagesId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchFlaskGroupMessagesException, SystemException {
		FlaskGroupMessages flaskGroupMessages = findByPrimaryKey(groupMessagesId);

		Session session = null;

		try {
			session = openSession();

			FlaskGroupMessages[] array = new FlaskGroupMessagesImpl[3];

			array[0] = getBygroupId_PrevAndNext(session, flaskGroupMessages,
					groupId, orderByComparator, true);

			array[1] = flaskGroupMessages;

			array[2] = getBygroupId_PrevAndNext(session, flaskGroupMessages,
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

	protected FlaskGroupMessages getBygroupId_PrevAndNext(Session session,
		FlaskGroupMessages flaskGroupMessages, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLASKGROUPMESSAGES_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(FlaskGroupMessagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flaskGroupMessages);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FlaskGroupMessages> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flask group messageses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBygroupId(long groupId) throws SystemException {
		for (FlaskGroupMessages flaskGroupMessages : findBygroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(flaskGroupMessages);
		}
	}

	/**
	 * Returns the number of flask group messageses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching flask group messageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBygroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FLASKGROUPMESSAGES_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "flaskGroupMessages.groupId = ?";

	public FlaskGroupMessagesPersistenceImpl() {
		setModelClass(FlaskGroupMessages.class);
	}

	/**
	 * Caches the flask group messages in the entity cache if it is enabled.
	 *
	 * @param flaskGroupMessages the flask group messages
	 */
	@Override
	public void cacheResult(FlaskGroupMessages flaskGroupMessages) {
		EntityCacheUtil.putResult(FlaskGroupMessagesModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupMessagesImpl.class, flaskGroupMessages.getPrimaryKey(),
			flaskGroupMessages);

		flaskGroupMessages.resetOriginalValues();
	}

	/**
	 * Caches the flask group messageses in the entity cache if it is enabled.
	 *
	 * @param flaskGroupMessageses the flask group messageses
	 */
	@Override
	public void cacheResult(List<FlaskGroupMessages> flaskGroupMessageses) {
		for (FlaskGroupMessages flaskGroupMessages : flaskGroupMessageses) {
			if (EntityCacheUtil.getResult(
						FlaskGroupMessagesModelImpl.ENTITY_CACHE_ENABLED,
						FlaskGroupMessagesImpl.class,
						flaskGroupMessages.getPrimaryKey()) == null) {
				cacheResult(flaskGroupMessages);
			}
			else {
				flaskGroupMessages.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all flask group messageses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FlaskGroupMessagesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FlaskGroupMessagesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the flask group messages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FlaskGroupMessages flaskGroupMessages) {
		EntityCacheUtil.removeResult(FlaskGroupMessagesModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupMessagesImpl.class, flaskGroupMessages.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FlaskGroupMessages> flaskGroupMessageses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FlaskGroupMessages flaskGroupMessages : flaskGroupMessageses) {
			EntityCacheUtil.removeResult(FlaskGroupMessagesModelImpl.ENTITY_CACHE_ENABLED,
				FlaskGroupMessagesImpl.class, flaskGroupMessages.getPrimaryKey());
		}
	}

	/**
	 * Creates a new flask group messages with the primary key. Does not add the flask group messages to the database.
	 *
	 * @param groupMessagesId the primary key for the new flask group messages
	 * @return the new flask group messages
	 */
	@Override
	public FlaskGroupMessages create(long groupMessagesId) {
		FlaskGroupMessages flaskGroupMessages = new FlaskGroupMessagesImpl();

		flaskGroupMessages.setNew(true);
		flaskGroupMessages.setPrimaryKey(groupMessagesId);

		return flaskGroupMessages;
	}

	/**
	 * Removes the flask group messages with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupMessagesId the primary key of the flask group messages
	 * @return the flask group messages that was removed
	 * @throws com.liferay.contacts.NoSuchFlaskGroupMessagesException if a flask group messages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupMessages remove(long groupMessagesId)
		throws NoSuchFlaskGroupMessagesException, SystemException {
		return remove((Serializable)groupMessagesId);
	}

	/**
	 * Removes the flask group messages with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the flask group messages
	 * @return the flask group messages that was removed
	 * @throws com.liferay.contacts.NoSuchFlaskGroupMessagesException if a flask group messages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupMessages remove(Serializable primaryKey)
		throws NoSuchFlaskGroupMessagesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FlaskGroupMessages flaskGroupMessages = (FlaskGroupMessages)session.get(FlaskGroupMessagesImpl.class,
					primaryKey);

			if (flaskGroupMessages == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFlaskGroupMessagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(flaskGroupMessages);
		}
		catch (NoSuchFlaskGroupMessagesException nsee) {
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
	protected FlaskGroupMessages removeImpl(
		FlaskGroupMessages flaskGroupMessages) throws SystemException {
		flaskGroupMessages = toUnwrappedModel(flaskGroupMessages);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(flaskGroupMessages)) {
				flaskGroupMessages = (FlaskGroupMessages)session.get(FlaskGroupMessagesImpl.class,
						flaskGroupMessages.getPrimaryKeyObj());
			}

			if (flaskGroupMessages != null) {
				session.delete(flaskGroupMessages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (flaskGroupMessages != null) {
			clearCache(flaskGroupMessages);
		}

		return flaskGroupMessages;
	}

	@Override
	public FlaskGroupMessages updateImpl(
		com.liferay.contacts.model.FlaskGroupMessages flaskGroupMessages)
		throws SystemException {
		flaskGroupMessages = toUnwrappedModel(flaskGroupMessages);

		boolean isNew = flaskGroupMessages.isNew();

		FlaskGroupMessagesModelImpl flaskGroupMessagesModelImpl = (FlaskGroupMessagesModelImpl)flaskGroupMessages;

		Session session = null;

		try {
			session = openSession();

			if (flaskGroupMessages.isNew()) {
				session.save(flaskGroupMessages);

				flaskGroupMessages.setNew(false);
			}
			else {
				session.merge(flaskGroupMessages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FlaskGroupMessagesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((flaskGroupMessagesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flaskGroupMessagesModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { flaskGroupMessagesModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(FlaskGroupMessagesModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupMessagesImpl.class, flaskGroupMessages.getPrimaryKey(),
			flaskGroupMessages);

		return flaskGroupMessages;
	}

	protected FlaskGroupMessages toUnwrappedModel(
		FlaskGroupMessages flaskGroupMessages) {
		if (flaskGroupMessages instanceof FlaskGroupMessagesImpl) {
			return flaskGroupMessages;
		}

		FlaskGroupMessagesImpl flaskGroupMessagesImpl = new FlaskGroupMessagesImpl();

		flaskGroupMessagesImpl.setNew(flaskGroupMessages.isNew());
		flaskGroupMessagesImpl.setPrimaryKey(flaskGroupMessages.getPrimaryKey());

		flaskGroupMessagesImpl.setGroupMessagesId(flaskGroupMessages.getGroupMessagesId());
		flaskGroupMessagesImpl.setSenderEmail(flaskGroupMessages.getSenderEmail());
		flaskGroupMessagesImpl.setSenderUserId(flaskGroupMessages.getSenderUserId());
		flaskGroupMessagesImpl.setSenderName(flaskGroupMessages.getSenderName());
		flaskGroupMessagesImpl.setGroupId(flaskGroupMessages.getGroupId());
		flaskGroupMessagesImpl.setMessage(flaskGroupMessages.getMessage());
		flaskGroupMessagesImpl.setSendEmail(flaskGroupMessages.isSendEmail());
		flaskGroupMessagesImpl.setDateTime(flaskGroupMessages.getDateTime());

		return flaskGroupMessagesImpl;
	}

	/**
	 * Returns the flask group messages with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask group messages
	 * @return the flask group messages
	 * @throws com.liferay.contacts.NoSuchFlaskGroupMessagesException if a flask group messages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupMessages findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFlaskGroupMessagesException, SystemException {
		FlaskGroupMessages flaskGroupMessages = fetchByPrimaryKey(primaryKey);

		if (flaskGroupMessages == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFlaskGroupMessagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return flaskGroupMessages;
	}

	/**
	 * Returns the flask group messages with the primary key or throws a {@link com.liferay.contacts.NoSuchFlaskGroupMessagesException} if it could not be found.
	 *
	 * @param groupMessagesId the primary key of the flask group messages
	 * @return the flask group messages
	 * @throws com.liferay.contacts.NoSuchFlaskGroupMessagesException if a flask group messages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupMessages findByPrimaryKey(long groupMessagesId)
		throws NoSuchFlaskGroupMessagesException, SystemException {
		return findByPrimaryKey((Serializable)groupMessagesId);
	}

	/**
	 * Returns the flask group messages with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask group messages
	 * @return the flask group messages, or <code>null</code> if a flask group messages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupMessages fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FlaskGroupMessages flaskGroupMessages = (FlaskGroupMessages)EntityCacheUtil.getResult(FlaskGroupMessagesModelImpl.ENTITY_CACHE_ENABLED,
				FlaskGroupMessagesImpl.class, primaryKey);

		if (flaskGroupMessages == _nullFlaskGroupMessages) {
			return null;
		}

		if (flaskGroupMessages == null) {
			Session session = null;

			try {
				session = openSession();

				flaskGroupMessages = (FlaskGroupMessages)session.get(FlaskGroupMessagesImpl.class,
						primaryKey);

				if (flaskGroupMessages != null) {
					cacheResult(flaskGroupMessages);
				}
				else {
					EntityCacheUtil.putResult(FlaskGroupMessagesModelImpl.ENTITY_CACHE_ENABLED,
						FlaskGroupMessagesImpl.class, primaryKey,
						_nullFlaskGroupMessages);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FlaskGroupMessagesModelImpl.ENTITY_CACHE_ENABLED,
					FlaskGroupMessagesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return flaskGroupMessages;
	}

	/**
	 * Returns the flask group messages with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupMessagesId the primary key of the flask group messages
	 * @return the flask group messages, or <code>null</code> if a flask group messages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupMessages fetchByPrimaryKey(long groupMessagesId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)groupMessagesId);
	}

	/**
	 * Returns all the flask group messageses.
	 *
	 * @return the flask group messageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupMessages> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flask group messageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupMessagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask group messageses
	 * @param end the upper bound of the range of flask group messageses (not inclusive)
	 * @return the range of flask group messageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupMessages> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask group messageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupMessagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask group messageses
	 * @param end the upper bound of the range of flask group messageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of flask group messageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupMessages> findAll(int start, int end,
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

		List<FlaskGroupMessages> list = (List<FlaskGroupMessages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FLASKGROUPMESSAGES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FLASKGROUPMESSAGES;

				if (pagination) {
					sql = sql.concat(FlaskGroupMessagesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FlaskGroupMessages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskGroupMessages>(list);
				}
				else {
					list = (List<FlaskGroupMessages>)QueryUtil.list(q,
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
	 * Removes all the flask group messageses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FlaskGroupMessages flaskGroupMessages : findAll()) {
			remove(flaskGroupMessages);
		}
	}

	/**
	 * Returns the number of flask group messageses.
	 *
	 * @return the number of flask group messageses
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

				Query q = session.createQuery(_SQL_COUNT_FLASKGROUPMESSAGES);

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
	 * Initializes the flask group messages persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.contacts.model.FlaskGroupMessages")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FlaskGroupMessages>> listenersList = new ArrayList<ModelListener<FlaskGroupMessages>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FlaskGroupMessages>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FlaskGroupMessagesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FLASKGROUPMESSAGES = "SELECT flaskGroupMessages FROM FlaskGroupMessages flaskGroupMessages";
	private static final String _SQL_SELECT_FLASKGROUPMESSAGES_WHERE = "SELECT flaskGroupMessages FROM FlaskGroupMessages flaskGroupMessages WHERE ";
	private static final String _SQL_COUNT_FLASKGROUPMESSAGES = "SELECT COUNT(flaskGroupMessages) FROM FlaskGroupMessages flaskGroupMessages";
	private static final String _SQL_COUNT_FLASKGROUPMESSAGES_WHERE = "SELECT COUNT(flaskGroupMessages) FROM FlaskGroupMessages flaskGroupMessages WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "flaskGroupMessages.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FlaskGroupMessages exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FlaskGroupMessages exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FlaskGroupMessagesPersistenceImpl.class);
	private static FlaskGroupMessages _nullFlaskGroupMessages = new FlaskGroupMessagesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FlaskGroupMessages> toCacheModel() {
				return _nullFlaskGroupMessagesCacheModel;
			}
		};

	private static CacheModel<FlaskGroupMessages> _nullFlaskGroupMessagesCacheModel =
		new CacheModel<FlaskGroupMessages>() {
			@Override
			public FlaskGroupMessages toEntityModel() {
				return _nullFlaskGroupMessages;
			}
		};
}