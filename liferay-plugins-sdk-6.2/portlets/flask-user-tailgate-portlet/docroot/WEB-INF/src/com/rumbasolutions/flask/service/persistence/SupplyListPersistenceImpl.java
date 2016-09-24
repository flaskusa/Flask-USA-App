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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rumbasolutions.flask.NoSuchSupplyListException;
import com.rumbasolutions.flask.model.SupplyList;
import com.rumbasolutions.flask.model.impl.SupplyListImpl;
import com.rumbasolutions.flask.model.impl.SupplyListModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the supply list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplyListPersistence
 * @see SupplyListUtil
 * @generated
 */
public class SupplyListPersistenceImpl extends BasePersistenceImpl<SupplyList>
	implements SupplyListPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SupplyListUtil} to access the supply list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SupplyListImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
			SupplyListModelImpl.FINDER_CACHE_ENABLED, SupplyListImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
			SupplyListModelImpl.FINDER_CACHE_ENABLED, SupplyListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
			SupplyListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
			SupplyListModelImpl.FINDER_CACHE_ENABLED, SupplyListImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
			SupplyListModelImpl.FINDER_CACHE_ENABLED, SupplyListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] { Long.class.getName() },
			SupplyListModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
			SupplyListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the supply lists where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching supply lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyList> findByuserId(long userId) throws SystemException {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the supply lists where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of supply lists
	 * @param end the upper bound of the range of supply lists (not inclusive)
	 * @return the range of matching supply lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyList> findByuserId(long userId, int start, int end)
		throws SystemException {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the supply lists where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of supply lists
	 * @param end the upper bound of the range of supply lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching supply lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyList> findByuserId(long userId, int start, int end,
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

		List<SupplyList> list = (List<SupplyList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SupplyList supplyList : list) {
				if ((userId != supplyList.getUserId())) {
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

			query.append(_SQL_SELECT_SUPPLYLIST_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SupplyListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SupplyList>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SupplyList>(list);
				}
				else {
					list = (List<SupplyList>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first supply list in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching supply list
	 * @throws com.rumbasolutions.flask.NoSuchSupplyListException if a matching supply list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList findByuserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSupplyListException, SystemException {
		SupplyList supplyList = fetchByuserId_First(userId, orderByComparator);

		if (supplyList != null) {
			return supplyList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSupplyListException(msg.toString());
	}

	/**
	 * Returns the first supply list in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching supply list, or <code>null</code> if a matching supply list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList fetchByuserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SupplyList> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last supply list in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching supply list
	 * @throws com.rumbasolutions.flask.NoSuchSupplyListException if a matching supply list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList findByuserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSupplyListException, SystemException {
		SupplyList supplyList = fetchByuserId_Last(userId, orderByComparator);

		if (supplyList != null) {
			return supplyList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSupplyListException(msg.toString());
	}

	/**
	 * Returns the last supply list in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching supply list, or <code>null</code> if a matching supply list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList fetchByuserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<SupplyList> list = findByuserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the supply lists before and after the current supply list in the ordered set where userId = &#63;.
	 *
	 * @param supplyListId the primary key of the current supply list
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next supply list
	 * @throws com.rumbasolutions.flask.NoSuchSupplyListException if a supply list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList[] findByuserId_PrevAndNext(long supplyListId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchSupplyListException, SystemException {
		SupplyList supplyList = findByPrimaryKey(supplyListId);

		Session session = null;

		try {
			session = openSession();

			SupplyList[] array = new SupplyListImpl[3];

			array[0] = getByuserId_PrevAndNext(session, supplyList, userId,
					orderByComparator, true);

			array[1] = supplyList;

			array[2] = getByuserId_PrevAndNext(session, supplyList, userId,
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

	protected SupplyList getByuserId_PrevAndNext(Session session,
		SupplyList supplyList, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUPPLYLIST_WHERE);

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
			query.append(SupplyListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(supplyList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SupplyList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the supply lists where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserId(long userId) throws SystemException {
		for (SupplyList supplyList : findByuserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(supplyList);
		}
	}

	/**
	 * Returns the number of supply lists where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching supply lists
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

			query.append(_SQL_COUNT_SUPPLYLIST_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "supplyList.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISSYSTEM = new FinderPath(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
			SupplyListModelImpl.FINDER_CACHE_ENABLED, SupplyListImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByisSystem",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSYSTEM =
		new FinderPath(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
			SupplyListModelImpl.FINDER_CACHE_ENABLED, SupplyListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByisSystem",
			new String[] { Boolean.class.getName() },
			SupplyListModelImpl.ISSYSTEM_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISSYSTEM = new FinderPath(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
			SupplyListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByisSystem",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the supply lists where isSystem = &#63;.
	 *
	 * @param isSystem the is system
	 * @return the matching supply lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyList> findByisSystem(boolean isSystem)
		throws SystemException {
		return findByisSystem(isSystem, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the supply lists where isSystem = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isSystem the is system
	 * @param start the lower bound of the range of supply lists
	 * @param end the upper bound of the range of supply lists (not inclusive)
	 * @return the range of matching supply lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyList> findByisSystem(boolean isSystem, int start, int end)
		throws SystemException {
		return findByisSystem(isSystem, start, end, null);
	}

	/**
	 * Returns an ordered range of all the supply lists where isSystem = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isSystem the is system
	 * @param start the lower bound of the range of supply lists
	 * @param end the upper bound of the range of supply lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching supply lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyList> findByisSystem(boolean isSystem, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSYSTEM;
			finderArgs = new Object[] { isSystem };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISSYSTEM;
			finderArgs = new Object[] { isSystem, start, end, orderByComparator };
		}

		List<SupplyList> list = (List<SupplyList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SupplyList supplyList : list) {
				if ((isSystem != supplyList.getIsSystem())) {
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

			query.append(_SQL_SELECT_SUPPLYLIST_WHERE);

			query.append(_FINDER_COLUMN_ISSYSTEM_ISSYSTEM_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SupplyListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isSystem);

				if (!pagination) {
					list = (List<SupplyList>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SupplyList>(list);
				}
				else {
					list = (List<SupplyList>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first supply list in the ordered set where isSystem = &#63;.
	 *
	 * @param isSystem the is system
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching supply list
	 * @throws com.rumbasolutions.flask.NoSuchSupplyListException if a matching supply list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList findByisSystem_First(boolean isSystem,
		OrderByComparator orderByComparator)
		throws NoSuchSupplyListException, SystemException {
		SupplyList supplyList = fetchByisSystem_First(isSystem,
				orderByComparator);

		if (supplyList != null) {
			return supplyList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isSystem=");
		msg.append(isSystem);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSupplyListException(msg.toString());
	}

	/**
	 * Returns the first supply list in the ordered set where isSystem = &#63;.
	 *
	 * @param isSystem the is system
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching supply list, or <code>null</code> if a matching supply list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList fetchByisSystem_First(boolean isSystem,
		OrderByComparator orderByComparator) throws SystemException {
		List<SupplyList> list = findByisSystem(isSystem, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last supply list in the ordered set where isSystem = &#63;.
	 *
	 * @param isSystem the is system
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching supply list
	 * @throws com.rumbasolutions.flask.NoSuchSupplyListException if a matching supply list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList findByisSystem_Last(boolean isSystem,
		OrderByComparator orderByComparator)
		throws NoSuchSupplyListException, SystemException {
		SupplyList supplyList = fetchByisSystem_Last(isSystem, orderByComparator);

		if (supplyList != null) {
			return supplyList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isSystem=");
		msg.append(isSystem);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSupplyListException(msg.toString());
	}

	/**
	 * Returns the last supply list in the ordered set where isSystem = &#63;.
	 *
	 * @param isSystem the is system
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching supply list, or <code>null</code> if a matching supply list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList fetchByisSystem_Last(boolean isSystem,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByisSystem(isSystem);

		if (count == 0) {
			return null;
		}

		List<SupplyList> list = findByisSystem(isSystem, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the supply lists before and after the current supply list in the ordered set where isSystem = &#63;.
	 *
	 * @param supplyListId the primary key of the current supply list
	 * @param isSystem the is system
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next supply list
	 * @throws com.rumbasolutions.flask.NoSuchSupplyListException if a supply list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList[] findByisSystem_PrevAndNext(long supplyListId,
		boolean isSystem, OrderByComparator orderByComparator)
		throws NoSuchSupplyListException, SystemException {
		SupplyList supplyList = findByPrimaryKey(supplyListId);

		Session session = null;

		try {
			session = openSession();

			SupplyList[] array = new SupplyListImpl[3];

			array[0] = getByisSystem_PrevAndNext(session, supplyList, isSystem,
					orderByComparator, true);

			array[1] = supplyList;

			array[2] = getByisSystem_PrevAndNext(session, supplyList, isSystem,
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

	protected SupplyList getByisSystem_PrevAndNext(Session session,
		SupplyList supplyList, boolean isSystem,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUPPLYLIST_WHERE);

		query.append(_FINDER_COLUMN_ISSYSTEM_ISSYSTEM_2);

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
			query.append(SupplyListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isSystem);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(supplyList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SupplyList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the supply lists where isSystem = &#63; from the database.
	 *
	 * @param isSystem the is system
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByisSystem(boolean isSystem) throws SystemException {
		for (SupplyList supplyList : findByisSystem(isSystem,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(supplyList);
		}
	}

	/**
	 * Returns the number of supply lists where isSystem = &#63;.
	 *
	 * @param isSystem the is system
	 * @return the number of matching supply lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByisSystem(boolean isSystem) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISSYSTEM;

		Object[] finderArgs = new Object[] { isSystem };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUPPLYLIST_WHERE);

			query.append(_FINDER_COLUMN_ISSYSTEM_ISSYSTEM_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isSystem);

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

	private static final String _FINDER_COLUMN_ISSYSTEM_ISSYSTEM_2 = "supplyList.isSystem = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SUPPLYLISTNAME =
		new FinderPath(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
			SupplyListModelImpl.FINDER_CACHE_ENABLED, SupplyListImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysupplyListName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPPLYLISTNAME =
		new FinderPath(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
			SupplyListModelImpl.FINDER_CACHE_ENABLED, SupplyListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysupplyListName",
			new String[] { String.class.getName() },
			SupplyListModelImpl.SUPPLYLISTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SUPPLYLISTNAME = new FinderPath(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
			SupplyListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysupplyListName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the supply lists where supplyListName = &#63;.
	 *
	 * @param supplyListName the supply list name
	 * @return the matching supply lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyList> findBysupplyListName(String supplyListName)
		throws SystemException {
		return findBysupplyListName(supplyListName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the supply lists where supplyListName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supplyListName the supply list name
	 * @param start the lower bound of the range of supply lists
	 * @param end the upper bound of the range of supply lists (not inclusive)
	 * @return the range of matching supply lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyList> findBysupplyListName(String supplyListName,
		int start, int end) throws SystemException {
		return findBysupplyListName(supplyListName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the supply lists where supplyListName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supplyListName the supply list name
	 * @param start the lower bound of the range of supply lists
	 * @param end the upper bound of the range of supply lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching supply lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyList> findBysupplyListName(String supplyListName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPPLYLISTNAME;
			finderArgs = new Object[] { supplyListName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SUPPLYLISTNAME;
			finderArgs = new Object[] {
					supplyListName,
					
					start, end, orderByComparator
				};
		}

		List<SupplyList> list = (List<SupplyList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SupplyList supplyList : list) {
				if (!Validator.equals(supplyListName,
							supplyList.getSupplyListName())) {
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

			query.append(_SQL_SELECT_SUPPLYLIST_WHERE);

			boolean bindSupplyListName = false;

			if (supplyListName == null) {
				query.append(_FINDER_COLUMN_SUPPLYLISTNAME_SUPPLYLISTNAME_1);
			}
			else if (supplyListName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SUPPLYLISTNAME_SUPPLYLISTNAME_3);
			}
			else {
				bindSupplyListName = true;

				query.append(_FINDER_COLUMN_SUPPLYLISTNAME_SUPPLYLISTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SupplyListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSupplyListName) {
					qPos.add(supplyListName);
				}

				if (!pagination) {
					list = (List<SupplyList>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SupplyList>(list);
				}
				else {
					list = (List<SupplyList>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first supply list in the ordered set where supplyListName = &#63;.
	 *
	 * @param supplyListName the supply list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching supply list
	 * @throws com.rumbasolutions.flask.NoSuchSupplyListException if a matching supply list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList findBysupplyListName_First(String supplyListName,
		OrderByComparator orderByComparator)
		throws NoSuchSupplyListException, SystemException {
		SupplyList supplyList = fetchBysupplyListName_First(supplyListName,
				orderByComparator);

		if (supplyList != null) {
			return supplyList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("supplyListName=");
		msg.append(supplyListName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSupplyListException(msg.toString());
	}

	/**
	 * Returns the first supply list in the ordered set where supplyListName = &#63;.
	 *
	 * @param supplyListName the supply list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching supply list, or <code>null</code> if a matching supply list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList fetchBysupplyListName_First(String supplyListName,
		OrderByComparator orderByComparator) throws SystemException {
		List<SupplyList> list = findBysupplyListName(supplyListName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last supply list in the ordered set where supplyListName = &#63;.
	 *
	 * @param supplyListName the supply list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching supply list
	 * @throws com.rumbasolutions.flask.NoSuchSupplyListException if a matching supply list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList findBysupplyListName_Last(String supplyListName,
		OrderByComparator orderByComparator)
		throws NoSuchSupplyListException, SystemException {
		SupplyList supplyList = fetchBysupplyListName_Last(supplyListName,
				orderByComparator);

		if (supplyList != null) {
			return supplyList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("supplyListName=");
		msg.append(supplyListName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSupplyListException(msg.toString());
	}

	/**
	 * Returns the last supply list in the ordered set where supplyListName = &#63;.
	 *
	 * @param supplyListName the supply list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching supply list, or <code>null</code> if a matching supply list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList fetchBysupplyListName_Last(String supplyListName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBysupplyListName(supplyListName);

		if (count == 0) {
			return null;
		}

		List<SupplyList> list = findBysupplyListName(supplyListName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the supply lists before and after the current supply list in the ordered set where supplyListName = &#63;.
	 *
	 * @param supplyListId the primary key of the current supply list
	 * @param supplyListName the supply list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next supply list
	 * @throws com.rumbasolutions.flask.NoSuchSupplyListException if a supply list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList[] findBysupplyListName_PrevAndNext(long supplyListId,
		String supplyListName, OrderByComparator orderByComparator)
		throws NoSuchSupplyListException, SystemException {
		SupplyList supplyList = findByPrimaryKey(supplyListId);

		Session session = null;

		try {
			session = openSession();

			SupplyList[] array = new SupplyListImpl[3];

			array[0] = getBysupplyListName_PrevAndNext(session, supplyList,
					supplyListName, orderByComparator, true);

			array[1] = supplyList;

			array[2] = getBysupplyListName_PrevAndNext(session, supplyList,
					supplyListName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SupplyList getBysupplyListName_PrevAndNext(Session session,
		SupplyList supplyList, String supplyListName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUPPLYLIST_WHERE);

		boolean bindSupplyListName = false;

		if (supplyListName == null) {
			query.append(_FINDER_COLUMN_SUPPLYLISTNAME_SUPPLYLISTNAME_1);
		}
		else if (supplyListName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SUPPLYLISTNAME_SUPPLYLISTNAME_3);
		}
		else {
			bindSupplyListName = true;

			query.append(_FINDER_COLUMN_SUPPLYLISTNAME_SUPPLYLISTNAME_2);
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
			query.append(SupplyListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindSupplyListName) {
			qPos.add(supplyListName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(supplyList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SupplyList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the supply lists where supplyListName = &#63; from the database.
	 *
	 * @param supplyListName the supply list name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBysupplyListName(String supplyListName)
		throws SystemException {
		for (SupplyList supplyList : findBysupplyListName(supplyListName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(supplyList);
		}
	}

	/**
	 * Returns the number of supply lists where supplyListName = &#63;.
	 *
	 * @param supplyListName the supply list name
	 * @return the number of matching supply lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBysupplyListName(String supplyListName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SUPPLYLISTNAME;

		Object[] finderArgs = new Object[] { supplyListName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUPPLYLIST_WHERE);

			boolean bindSupplyListName = false;

			if (supplyListName == null) {
				query.append(_FINDER_COLUMN_SUPPLYLISTNAME_SUPPLYLISTNAME_1);
			}
			else if (supplyListName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SUPPLYLISTNAME_SUPPLYLISTNAME_3);
			}
			else {
				bindSupplyListName = true;

				query.append(_FINDER_COLUMN_SUPPLYLISTNAME_SUPPLYLISTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSupplyListName) {
					qPos.add(supplyListName);
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

	private static final String _FINDER_COLUMN_SUPPLYLISTNAME_SUPPLYLISTNAME_1 = "supplyList.supplyListName IS NULL";
	private static final String _FINDER_COLUMN_SUPPLYLISTNAME_SUPPLYLISTNAME_2 = "supplyList.supplyListName = ?";
	private static final String _FINDER_COLUMN_SUPPLYLISTNAME_SUPPLYLISTNAME_3 = "(supplyList.supplyListName IS NULL OR supplyList.supplyListName = '')";

	public SupplyListPersistenceImpl() {
		setModelClass(SupplyList.class);
	}

	/**
	 * Caches the supply list in the entity cache if it is enabled.
	 *
	 * @param supplyList the supply list
	 */
	@Override
	public void cacheResult(SupplyList supplyList) {
		EntityCacheUtil.putResult(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
			SupplyListImpl.class, supplyList.getPrimaryKey(), supplyList);

		supplyList.resetOriginalValues();
	}

	/**
	 * Caches the supply lists in the entity cache if it is enabled.
	 *
	 * @param supplyLists the supply lists
	 */
	@Override
	public void cacheResult(List<SupplyList> supplyLists) {
		for (SupplyList supplyList : supplyLists) {
			if (EntityCacheUtil.getResult(
						SupplyListModelImpl.ENTITY_CACHE_ENABLED,
						SupplyListImpl.class, supplyList.getPrimaryKey()) == null) {
				cacheResult(supplyList);
			}
			else {
				supplyList.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all supply lists.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SupplyListImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SupplyListImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the supply list.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SupplyList supplyList) {
		EntityCacheUtil.removeResult(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
			SupplyListImpl.class, supplyList.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SupplyList> supplyLists) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SupplyList supplyList : supplyLists) {
			EntityCacheUtil.removeResult(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
				SupplyListImpl.class, supplyList.getPrimaryKey());
		}
	}

	/**
	 * Creates a new supply list with the primary key. Does not add the supply list to the database.
	 *
	 * @param supplyListId the primary key for the new supply list
	 * @return the new supply list
	 */
	@Override
	public SupplyList create(long supplyListId) {
		SupplyList supplyList = new SupplyListImpl();

		supplyList.setNew(true);
		supplyList.setPrimaryKey(supplyListId);

		return supplyList;
	}

	/**
	 * Removes the supply list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supplyListId the primary key of the supply list
	 * @return the supply list that was removed
	 * @throws com.rumbasolutions.flask.NoSuchSupplyListException if a supply list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList remove(long supplyListId)
		throws NoSuchSupplyListException, SystemException {
		return remove((Serializable)supplyListId);
	}

	/**
	 * Removes the supply list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the supply list
	 * @return the supply list that was removed
	 * @throws com.rumbasolutions.flask.NoSuchSupplyListException if a supply list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList remove(Serializable primaryKey)
		throws NoSuchSupplyListException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SupplyList supplyList = (SupplyList)session.get(SupplyListImpl.class,
					primaryKey);

			if (supplyList == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSupplyListException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(supplyList);
		}
		catch (NoSuchSupplyListException nsee) {
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
	protected SupplyList removeImpl(SupplyList supplyList)
		throws SystemException {
		supplyList = toUnwrappedModel(supplyList);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(supplyList)) {
				supplyList = (SupplyList)session.get(SupplyListImpl.class,
						supplyList.getPrimaryKeyObj());
			}

			if (supplyList != null) {
				session.delete(supplyList);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (supplyList != null) {
			clearCache(supplyList);
		}

		return supplyList;
	}

	@Override
	public SupplyList updateImpl(
		com.rumbasolutions.flask.model.SupplyList supplyList)
		throws SystemException {
		supplyList = toUnwrappedModel(supplyList);

		boolean isNew = supplyList.isNew();

		SupplyListModelImpl supplyListModelImpl = (SupplyListModelImpl)supplyList;

		Session session = null;

		try {
			session = openSession();

			if (supplyList.isNew()) {
				session.save(supplyList);

				supplyList.setNew(false);
			}
			else {
				session.merge(supplyList);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SupplyListModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((supplyListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						supplyListModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { supplyListModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((supplyListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSYSTEM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						supplyListModelImpl.getOriginalIsSystem()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISSYSTEM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSYSTEM,
					args);

				args = new Object[] { supplyListModelImpl.getIsSystem() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISSYSTEM, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSYSTEM,
					args);
			}

			if ((supplyListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPPLYLISTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						supplyListModelImpl.getOriginalSupplyListName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUPPLYLISTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPPLYLISTNAME,
					args);

				args = new Object[] { supplyListModelImpl.getSupplyListName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUPPLYLISTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPPLYLISTNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
			SupplyListImpl.class, supplyList.getPrimaryKey(), supplyList);

		return supplyList;
	}

	protected SupplyList toUnwrappedModel(SupplyList supplyList) {
		if (supplyList instanceof SupplyListImpl) {
			return supplyList;
		}

		SupplyListImpl supplyListImpl = new SupplyListImpl();

		supplyListImpl.setNew(supplyList.isNew());
		supplyListImpl.setPrimaryKey(supplyList.getPrimaryKey());

		supplyListImpl.setSupplyListId(supplyList.getSupplyListId());
		supplyListImpl.setSupplyListName(supplyList.getSupplyListName());
		supplyListImpl.setIsSystem(supplyList.isIsSystem());
		supplyListImpl.setCompanyId(supplyList.getCompanyId());
		supplyListImpl.setUserId(supplyList.getUserId());
		supplyListImpl.setCreatedDate(supplyList.getCreatedDate());
		supplyListImpl.setModifiedDate(supplyList.getModifiedDate());

		return supplyListImpl;
	}

	/**
	 * Returns the supply list with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the supply list
	 * @return the supply list
	 * @throws com.rumbasolutions.flask.NoSuchSupplyListException if a supply list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSupplyListException, SystemException {
		SupplyList supplyList = fetchByPrimaryKey(primaryKey);

		if (supplyList == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSupplyListException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return supplyList;
	}

	/**
	 * Returns the supply list with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchSupplyListException} if it could not be found.
	 *
	 * @param supplyListId the primary key of the supply list
	 * @return the supply list
	 * @throws com.rumbasolutions.flask.NoSuchSupplyListException if a supply list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList findByPrimaryKey(long supplyListId)
		throws NoSuchSupplyListException, SystemException {
		return findByPrimaryKey((Serializable)supplyListId);
	}

	/**
	 * Returns the supply list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the supply list
	 * @return the supply list, or <code>null</code> if a supply list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SupplyList supplyList = (SupplyList)EntityCacheUtil.getResult(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
				SupplyListImpl.class, primaryKey);

		if (supplyList == _nullSupplyList) {
			return null;
		}

		if (supplyList == null) {
			Session session = null;

			try {
				session = openSession();

				supplyList = (SupplyList)session.get(SupplyListImpl.class,
						primaryKey);

				if (supplyList != null) {
					cacheResult(supplyList);
				}
				else {
					EntityCacheUtil.putResult(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
						SupplyListImpl.class, primaryKey, _nullSupplyList);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SupplyListModelImpl.ENTITY_CACHE_ENABLED,
					SupplyListImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return supplyList;
	}

	/**
	 * Returns the supply list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param supplyListId the primary key of the supply list
	 * @return the supply list, or <code>null</code> if a supply list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyList fetchByPrimaryKey(long supplyListId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)supplyListId);
	}

	/**
	 * Returns all the supply lists.
	 *
	 * @return the supply lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyList> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the supply lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of supply lists
	 * @param end the upper bound of the range of supply lists (not inclusive)
	 * @return the range of supply lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyList> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the supply lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of supply lists
	 * @param end the upper bound of the range of supply lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of supply lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyList> findAll(int start, int end,
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

		List<SupplyList> list = (List<SupplyList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUPPLYLIST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUPPLYLIST;

				if (pagination) {
					sql = sql.concat(SupplyListModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SupplyList>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SupplyList>(list);
				}
				else {
					list = (List<SupplyList>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the supply lists from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SupplyList supplyList : findAll()) {
			remove(supplyList);
		}
	}

	/**
	 * Returns the number of supply lists.
	 *
	 * @return the number of supply lists
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

				Query q = session.createQuery(_SQL_COUNT_SUPPLYLIST);

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
	 * Initializes the supply list persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.SupplyList")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SupplyList>> listenersList = new ArrayList<ModelListener<SupplyList>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SupplyList>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SupplyListImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SUPPLYLIST = "SELECT supplyList FROM SupplyList supplyList";
	private static final String _SQL_SELECT_SUPPLYLIST_WHERE = "SELECT supplyList FROM SupplyList supplyList WHERE ";
	private static final String _SQL_COUNT_SUPPLYLIST = "SELECT COUNT(supplyList) FROM SupplyList supplyList";
	private static final String _SQL_COUNT_SUPPLYLIST_WHERE = "SELECT COUNT(supplyList) FROM SupplyList supplyList WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "supplyList.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SupplyList exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SupplyList exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SupplyListPersistenceImpl.class);
	private static SupplyList _nullSupplyList = new SupplyListImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SupplyList> toCacheModel() {
				return _nullSupplyListCacheModel;
			}
		};

	private static CacheModel<SupplyList> _nullSupplyListCacheModel = new CacheModel<SupplyList>() {
			@Override
			public SupplyList toEntityModel() {
				return _nullSupplyList;
			}
		};
}