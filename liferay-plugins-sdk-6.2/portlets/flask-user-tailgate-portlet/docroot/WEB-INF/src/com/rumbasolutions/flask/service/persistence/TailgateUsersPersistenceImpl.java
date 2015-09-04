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

import com.rumbasolutions.flask.NoSuchTailgateUsersException;
import com.rumbasolutions.flask.model.TailgateUsers;
import com.rumbasolutions.flask.model.impl.TailgateUsersImpl;
import com.rumbasolutions.flask.model.impl.TailgateUsersModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tailgate users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rajeshj
 * @see TailgateUsersPersistence
 * @see TailgateUsersUtil
 * @generated
 */
public class TailgateUsersPersistenceImpl extends BasePersistenceImpl<TailgateUsers>
	implements TailgateUsersPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TailgateUsersUtil} to access the tailgate users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TailgateUsersImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TailgateUsersModelImpl.ENTITY_CACHE_ENABLED,
			TailgateUsersModelImpl.FINDER_CACHE_ENABLED,
			TailgateUsersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TailgateUsersModelImpl.ENTITY_CACHE_ENABLED,
			TailgateUsersModelImpl.FINDER_CACHE_ENABLED,
			TailgateUsersImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TailgateUsersModelImpl.ENTITY_CACHE_ENABLED,
			TailgateUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAILGATEGROUPS =
		new FinderPath(TailgateUsersModelImpl.ENTITY_CACHE_ENABLED,
			TailgateUsersModelImpl.FINDER_CACHE_ENABLED,
			TailgateUsersImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBytailgateGroups",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEGROUPS =
		new FinderPath(TailgateUsersModelImpl.ENTITY_CACHE_ENABLED,
			TailgateUsersModelImpl.FINDER_CACHE_ENABLED,
			TailgateUsersImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBytailgateGroups", new String[] { Long.class.getName() },
			TailgateUsersModelImpl.TAILGATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAILGATEGROUPS = new FinderPath(TailgateUsersModelImpl.ENTITY_CACHE_ENABLED,
			TailgateUsersModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytailgateGroups",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tailgate userses where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @return the matching tailgate userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateUsers> findBytailgateGroups(long tailgateId)
		throws SystemException {
		return findBytailgateGroups(tailgateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tailgate userses where tailgateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tailgateId the tailgate ID
	 * @param start the lower bound of the range of tailgate userses
	 * @param end the upper bound of the range of tailgate userses (not inclusive)
	 * @return the range of matching tailgate userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateUsers> findBytailgateGroups(long tailgateId, int start,
		int end) throws SystemException {
		return findBytailgateGroups(tailgateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tailgate userses where tailgateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tailgateId the tailgate ID
	 * @param start the lower bound of the range of tailgate userses
	 * @param end the upper bound of the range of tailgate userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tailgate userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateUsers> findBytailgateGroups(long tailgateId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEGROUPS;
			finderArgs = new Object[] { tailgateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAILGATEGROUPS;
			finderArgs = new Object[] { tailgateId, start, end, orderByComparator };
		}

		List<TailgateUsers> list = (List<TailgateUsers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TailgateUsers tailgateUsers : list) {
				if ((tailgateId != tailgateUsers.getTailgateId())) {
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

			query.append(_SQL_SELECT_TAILGATEUSERS_WHERE);

			query.append(_FINDER_COLUMN_TAILGATEGROUPS_TAILGATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TailgateUsersModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tailgateId);

				if (!pagination) {
					list = (List<TailgateUsers>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TailgateUsers>(list);
				}
				else {
					list = (List<TailgateUsers>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first tailgate users in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tailgate users
	 * @throws com.rumbasolutions.flask.NoSuchTailgateUsersException if a matching tailgate users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateUsers findBytailgateGroups_First(long tailgateId,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateUsersException, SystemException {
		TailgateUsers tailgateUsers = fetchBytailgateGroups_First(tailgateId,
				orderByComparator);

		if (tailgateUsers != null) {
			return tailgateUsers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tailgateId=");
		msg.append(tailgateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTailgateUsersException(msg.toString());
	}

	/**
	 * Returns the first tailgate users in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tailgate users, or <code>null</code> if a matching tailgate users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateUsers fetchBytailgateGroups_First(long tailgateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TailgateUsers> list = findBytailgateGroups(tailgateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tailgate users in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tailgate users
	 * @throws com.rumbasolutions.flask.NoSuchTailgateUsersException if a matching tailgate users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateUsers findBytailgateGroups_Last(long tailgateId,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateUsersException, SystemException {
		TailgateUsers tailgateUsers = fetchBytailgateGroups_Last(tailgateId,
				orderByComparator);

		if (tailgateUsers != null) {
			return tailgateUsers;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tailgateId=");
		msg.append(tailgateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTailgateUsersException(msg.toString());
	}

	/**
	 * Returns the last tailgate users in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tailgate users, or <code>null</code> if a matching tailgate users could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateUsers fetchBytailgateGroups_Last(long tailgateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBytailgateGroups(tailgateId);

		if (count == 0) {
			return null;
		}

		List<TailgateUsers> list = findBytailgateGroups(tailgateId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tailgate userses before and after the current tailgate users in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateUserId the primary key of the current tailgate users
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tailgate users
	 * @throws com.rumbasolutions.flask.NoSuchTailgateUsersException if a tailgate users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateUsers[] findBytailgateGroups_PrevAndNext(
		long tailgateUserId, long tailgateId,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateUsersException, SystemException {
		TailgateUsers tailgateUsers = findByPrimaryKey(tailgateUserId);

		Session session = null;

		try {
			session = openSession();

			TailgateUsers[] array = new TailgateUsersImpl[3];

			array[0] = getBytailgateGroups_PrevAndNext(session, tailgateUsers,
					tailgateId, orderByComparator, true);

			array[1] = tailgateUsers;

			array[2] = getBytailgateGroups_PrevAndNext(session, tailgateUsers,
					tailgateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TailgateUsers getBytailgateGroups_PrevAndNext(Session session,
		TailgateUsers tailgateUsers, long tailgateId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAILGATEUSERS_WHERE);

		query.append(_FINDER_COLUMN_TAILGATEGROUPS_TAILGATEID_2);

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
			query.append(TailgateUsersModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(tailgateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tailgateUsers);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TailgateUsers> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tailgate userses where tailgateId = &#63; from the database.
	 *
	 * @param tailgateId the tailgate ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBytailgateGroups(long tailgateId)
		throws SystemException {
		for (TailgateUsers tailgateUsers : findBytailgateGroups(tailgateId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tailgateUsers);
		}
	}

	/**
	 * Returns the number of tailgate userses where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @return the number of matching tailgate userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBytailgateGroups(long tailgateId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAILGATEGROUPS;

		Object[] finderArgs = new Object[] { tailgateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAILGATEUSERS_WHERE);

			query.append(_FINDER_COLUMN_TAILGATEGROUPS_TAILGATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tailgateId);

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

	private static final String _FINDER_COLUMN_TAILGATEGROUPS_TAILGATEID_2 = "tailgateUsers.tailgateId = ?";

	public TailgateUsersPersistenceImpl() {
		setModelClass(TailgateUsers.class);
	}

	/**
	 * Caches the tailgate users in the entity cache if it is enabled.
	 *
	 * @param tailgateUsers the tailgate users
	 */
	@Override
	public void cacheResult(TailgateUsers tailgateUsers) {
		EntityCacheUtil.putResult(TailgateUsersModelImpl.ENTITY_CACHE_ENABLED,
			TailgateUsersImpl.class, tailgateUsers.getPrimaryKey(),
			tailgateUsers);

		tailgateUsers.resetOriginalValues();
	}

	/**
	 * Caches the tailgate userses in the entity cache if it is enabled.
	 *
	 * @param tailgateUserses the tailgate userses
	 */
	@Override
	public void cacheResult(List<TailgateUsers> tailgateUserses) {
		for (TailgateUsers tailgateUsers : tailgateUserses) {
			if (EntityCacheUtil.getResult(
						TailgateUsersModelImpl.ENTITY_CACHE_ENABLED,
						TailgateUsersImpl.class, tailgateUsers.getPrimaryKey()) == null) {
				cacheResult(tailgateUsers);
			}
			else {
				tailgateUsers.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tailgate userses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TailgateUsersImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TailgateUsersImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tailgate users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TailgateUsers tailgateUsers) {
		EntityCacheUtil.removeResult(TailgateUsersModelImpl.ENTITY_CACHE_ENABLED,
			TailgateUsersImpl.class, tailgateUsers.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TailgateUsers> tailgateUserses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TailgateUsers tailgateUsers : tailgateUserses) {
			EntityCacheUtil.removeResult(TailgateUsersModelImpl.ENTITY_CACHE_ENABLED,
				TailgateUsersImpl.class, tailgateUsers.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tailgate users with the primary key. Does not add the tailgate users to the database.
	 *
	 * @param tailgateUserId the primary key for the new tailgate users
	 * @return the new tailgate users
	 */
	@Override
	public TailgateUsers create(long tailgateUserId) {
		TailgateUsers tailgateUsers = new TailgateUsersImpl();

		tailgateUsers.setNew(true);
		tailgateUsers.setPrimaryKey(tailgateUserId);

		return tailgateUsers;
	}

	/**
	 * Removes the tailgate users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tailgateUserId the primary key of the tailgate users
	 * @return the tailgate users that was removed
	 * @throws com.rumbasolutions.flask.NoSuchTailgateUsersException if a tailgate users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateUsers remove(long tailgateUserId)
		throws NoSuchTailgateUsersException, SystemException {
		return remove((Serializable)tailgateUserId);
	}

	/**
	 * Removes the tailgate users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tailgate users
	 * @return the tailgate users that was removed
	 * @throws com.rumbasolutions.flask.NoSuchTailgateUsersException if a tailgate users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateUsers remove(Serializable primaryKey)
		throws NoSuchTailgateUsersException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TailgateUsers tailgateUsers = (TailgateUsers)session.get(TailgateUsersImpl.class,
					primaryKey);

			if (tailgateUsers == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTailgateUsersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tailgateUsers);
		}
		catch (NoSuchTailgateUsersException nsee) {
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
	protected TailgateUsers removeImpl(TailgateUsers tailgateUsers)
		throws SystemException {
		tailgateUsers = toUnwrappedModel(tailgateUsers);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tailgateUsers)) {
				tailgateUsers = (TailgateUsers)session.get(TailgateUsersImpl.class,
						tailgateUsers.getPrimaryKeyObj());
			}

			if (tailgateUsers != null) {
				session.delete(tailgateUsers);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tailgateUsers != null) {
			clearCache(tailgateUsers);
		}

		return tailgateUsers;
	}

	@Override
	public TailgateUsers updateImpl(
		com.rumbasolutions.flask.model.TailgateUsers tailgateUsers)
		throws SystemException {
		tailgateUsers = toUnwrappedModel(tailgateUsers);

		boolean isNew = tailgateUsers.isNew();

		TailgateUsersModelImpl tailgateUsersModelImpl = (TailgateUsersModelImpl)tailgateUsers;

		Session session = null;

		try {
			session = openSession();

			if (tailgateUsers.isNew()) {
				session.save(tailgateUsers);

				tailgateUsers.setNew(false);
			}
			else {
				session.merge(tailgateUsers);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TailgateUsersModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tailgateUsersModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEGROUPS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tailgateUsersModelImpl.getOriginalTailgateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAILGATEGROUPS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEGROUPS,
					args);

				args = new Object[] { tailgateUsersModelImpl.getTailgateId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAILGATEGROUPS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEGROUPS,
					args);
			}
		}

		EntityCacheUtil.putResult(TailgateUsersModelImpl.ENTITY_CACHE_ENABLED,
			TailgateUsersImpl.class, tailgateUsers.getPrimaryKey(),
			tailgateUsers);

		return tailgateUsers;
	}

	protected TailgateUsers toUnwrappedModel(TailgateUsers tailgateUsers) {
		if (tailgateUsers instanceof TailgateUsersImpl) {
			return tailgateUsers;
		}

		TailgateUsersImpl tailgateUsersImpl = new TailgateUsersImpl();

		tailgateUsersImpl.setNew(tailgateUsers.isNew());
		tailgateUsersImpl.setPrimaryKey(tailgateUsers.getPrimaryKey());

		tailgateUsersImpl.setTailgateUserId(tailgateUsers.getTailgateUserId());
		tailgateUsersImpl.setTailgateId(tailgateUsers.getTailgateId());
		tailgateUsersImpl.setUserId(tailgateUsers.getUserId());
		tailgateUsersImpl.setUserName(tailgateUsers.getUserName());
		tailgateUsersImpl.setIsAdmin(tailgateUsers.getIsAdmin());
		tailgateUsersImpl.setGroupId(tailgateUsers.getGroupId());
		tailgateUsersImpl.setEmailAddress(tailgateUsers.getEmailAddress());
		tailgateUsersImpl.setIsPaid(tailgateUsers.isIsPaid());
		tailgateUsersImpl.setPaymentMode(tailgateUsers.getPaymentMode());
		tailgateUsersImpl.setDescription(tailgateUsers.getDescription());

		return tailgateUsersImpl;
	}

	/**
	 * Returns the tailgate users with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tailgate users
	 * @return the tailgate users
	 * @throws com.rumbasolutions.flask.NoSuchTailgateUsersException if a tailgate users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateUsers findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTailgateUsersException, SystemException {
		TailgateUsers tailgateUsers = fetchByPrimaryKey(primaryKey);

		if (tailgateUsers == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTailgateUsersException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tailgateUsers;
	}

	/**
	 * Returns the tailgate users with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchTailgateUsersException} if it could not be found.
	 *
	 * @param tailgateUserId the primary key of the tailgate users
	 * @return the tailgate users
	 * @throws com.rumbasolutions.flask.NoSuchTailgateUsersException if a tailgate users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateUsers findByPrimaryKey(long tailgateUserId)
		throws NoSuchTailgateUsersException, SystemException {
		return findByPrimaryKey((Serializable)tailgateUserId);
	}

	/**
	 * Returns the tailgate users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tailgate users
	 * @return the tailgate users, or <code>null</code> if a tailgate users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateUsers fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TailgateUsers tailgateUsers = (TailgateUsers)EntityCacheUtil.getResult(TailgateUsersModelImpl.ENTITY_CACHE_ENABLED,
				TailgateUsersImpl.class, primaryKey);

		if (tailgateUsers == _nullTailgateUsers) {
			return null;
		}

		if (tailgateUsers == null) {
			Session session = null;

			try {
				session = openSession();

				tailgateUsers = (TailgateUsers)session.get(TailgateUsersImpl.class,
						primaryKey);

				if (tailgateUsers != null) {
					cacheResult(tailgateUsers);
				}
				else {
					EntityCacheUtil.putResult(TailgateUsersModelImpl.ENTITY_CACHE_ENABLED,
						TailgateUsersImpl.class, primaryKey, _nullTailgateUsers);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TailgateUsersModelImpl.ENTITY_CACHE_ENABLED,
					TailgateUsersImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tailgateUsers;
	}

	/**
	 * Returns the tailgate users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tailgateUserId the primary key of the tailgate users
	 * @return the tailgate users, or <code>null</code> if a tailgate users with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateUsers fetchByPrimaryKey(long tailgateUserId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)tailgateUserId);
	}

	/**
	 * Returns all the tailgate userses.
	 *
	 * @return the tailgate userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateUsers> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tailgate userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tailgate userses
	 * @param end the upper bound of the range of tailgate userses (not inclusive)
	 * @return the range of tailgate userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateUsers> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tailgate userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateUsersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tailgate userses
	 * @param end the upper bound of the range of tailgate userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tailgate userses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateUsers> findAll(int start, int end,
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

		List<TailgateUsers> list = (List<TailgateUsers>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAILGATEUSERS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAILGATEUSERS;

				if (pagination) {
					sql = sql.concat(TailgateUsersModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TailgateUsers>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TailgateUsers>(list);
				}
				else {
					list = (List<TailgateUsers>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the tailgate userses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TailgateUsers tailgateUsers : findAll()) {
			remove(tailgateUsers);
		}
	}

	/**
	 * Returns the number of tailgate userses.
	 *
	 * @return the number of tailgate userses
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

				Query q = session.createQuery(_SQL_COUNT_TAILGATEUSERS);

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
	 * Initializes the tailgate users persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.TailgateUsers")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TailgateUsers>> listenersList = new ArrayList<ModelListener<TailgateUsers>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TailgateUsers>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TailgateUsersImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TAILGATEUSERS = "SELECT tailgateUsers FROM TailgateUsers tailgateUsers";
	private static final String _SQL_SELECT_TAILGATEUSERS_WHERE = "SELECT tailgateUsers FROM TailgateUsers tailgateUsers WHERE ";
	private static final String _SQL_COUNT_TAILGATEUSERS = "SELECT COUNT(tailgateUsers) FROM TailgateUsers tailgateUsers";
	private static final String _SQL_COUNT_TAILGATEUSERS_WHERE = "SELECT COUNT(tailgateUsers) FROM TailgateUsers tailgateUsers WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tailgateUsers.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TailgateUsers exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TailgateUsers exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TailgateUsersPersistenceImpl.class);
	private static TailgateUsers _nullTailgateUsers = new TailgateUsersImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TailgateUsers> toCacheModel() {
				return _nullTailgateUsersCacheModel;
			}
		};

	private static CacheModel<TailgateUsers> _nullTailgateUsersCacheModel = new CacheModel<TailgateUsers>() {
			@Override
			public TailgateUsers toEntityModel() {
				return _nullTailgateUsers;
			}
		};
}