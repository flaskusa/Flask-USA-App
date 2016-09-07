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

import com.rumbasolutions.flask.NoSuchSupplyItemException;
import com.rumbasolutions.flask.model.SupplyItem;
import com.rumbasolutions.flask.model.impl.SupplyItemImpl;
import com.rumbasolutions.flask.model.impl.SupplyItemModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the supply item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupplyItemPersistence
 * @see SupplyItemUtil
 * @generated
 */
public class SupplyItemPersistenceImpl extends BasePersistenceImpl<SupplyItem>
	implements SupplyItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SupplyItemUtil} to access the supply item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SupplyItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			SupplyItemModelImpl.FINDER_CACHE_ENABLED, SupplyItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			SupplyItemModelImpl.FINDER_CACHE_ENABLED, SupplyItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			SupplyItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SUPPLYLISTID =
		new FinderPath(SupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			SupplyItemModelImpl.FINDER_CACHE_ENABLED, SupplyItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysupplyListId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPPLYLISTID =
		new FinderPath(SupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			SupplyItemModelImpl.FINDER_CACHE_ENABLED, SupplyItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysupplyListId",
			new String[] { Long.class.getName() },
			SupplyItemModelImpl.SUPPLYLISTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SUPPLYLISTID = new FinderPath(SupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			SupplyItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysupplyListId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the supply items where supplyListId = &#63;.
	 *
	 * @param supplyListId the supply list ID
	 * @return the matching supply items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyItem> findBysupplyListId(long supplyListId)
		throws SystemException {
		return findBysupplyListId(supplyListId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the supply items where supplyListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supplyListId the supply list ID
	 * @param start the lower bound of the range of supply items
	 * @param end the upper bound of the range of supply items (not inclusive)
	 * @return the range of matching supply items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyItem> findBysupplyListId(long supplyListId, int start,
		int end) throws SystemException {
		return findBysupplyListId(supplyListId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the supply items where supplyListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supplyListId the supply list ID
	 * @param start the lower bound of the range of supply items
	 * @param end the upper bound of the range of supply items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching supply items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyItem> findBysupplyListId(long supplyListId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPPLYLISTID;
			finderArgs = new Object[] { supplyListId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SUPPLYLISTID;
			finderArgs = new Object[] {
					supplyListId,
					
					start, end, orderByComparator
				};
		}

		List<SupplyItem> list = (List<SupplyItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SupplyItem supplyItem : list) {
				if ((supplyListId != supplyItem.getSupplyListId())) {
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

			query.append(_SQL_SELECT_SUPPLYITEM_WHERE);

			query.append(_FINDER_COLUMN_SUPPLYLISTID_SUPPLYLISTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SupplyItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(supplyListId);

				if (!pagination) {
					list = (List<SupplyItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SupplyItem>(list);
				}
				else {
					list = (List<SupplyItem>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first supply item in the ordered set where supplyListId = &#63;.
	 *
	 * @param supplyListId the supply list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching supply item
	 * @throws com.rumbasolutions.flask.NoSuchSupplyItemException if a matching supply item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyItem findBysupplyListId_First(long supplyListId,
		OrderByComparator orderByComparator)
		throws NoSuchSupplyItemException, SystemException {
		SupplyItem supplyItem = fetchBysupplyListId_First(supplyListId,
				orderByComparator);

		if (supplyItem != null) {
			return supplyItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("supplyListId=");
		msg.append(supplyListId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSupplyItemException(msg.toString());
	}

	/**
	 * Returns the first supply item in the ordered set where supplyListId = &#63;.
	 *
	 * @param supplyListId the supply list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching supply item, or <code>null</code> if a matching supply item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyItem fetchBysupplyListId_First(long supplyListId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SupplyItem> list = findBysupplyListId(supplyListId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last supply item in the ordered set where supplyListId = &#63;.
	 *
	 * @param supplyListId the supply list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching supply item
	 * @throws com.rumbasolutions.flask.NoSuchSupplyItemException if a matching supply item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyItem findBysupplyListId_Last(long supplyListId,
		OrderByComparator orderByComparator)
		throws NoSuchSupplyItemException, SystemException {
		SupplyItem supplyItem = fetchBysupplyListId_Last(supplyListId,
				orderByComparator);

		if (supplyItem != null) {
			return supplyItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("supplyListId=");
		msg.append(supplyListId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSupplyItemException(msg.toString());
	}

	/**
	 * Returns the last supply item in the ordered set where supplyListId = &#63;.
	 *
	 * @param supplyListId the supply list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching supply item, or <code>null</code> if a matching supply item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyItem fetchBysupplyListId_Last(long supplyListId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBysupplyListId(supplyListId);

		if (count == 0) {
			return null;
		}

		List<SupplyItem> list = findBysupplyListId(supplyListId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the supply items before and after the current supply item in the ordered set where supplyListId = &#63;.
	 *
	 * @param supplyItemId the primary key of the current supply item
	 * @param supplyListId the supply list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next supply item
	 * @throws com.rumbasolutions.flask.NoSuchSupplyItemException if a supply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyItem[] findBysupplyListId_PrevAndNext(long supplyItemId,
		long supplyListId, OrderByComparator orderByComparator)
		throws NoSuchSupplyItemException, SystemException {
		SupplyItem supplyItem = findByPrimaryKey(supplyItemId);

		Session session = null;

		try {
			session = openSession();

			SupplyItem[] array = new SupplyItemImpl[3];

			array[0] = getBysupplyListId_PrevAndNext(session, supplyItem,
					supplyListId, orderByComparator, true);

			array[1] = supplyItem;

			array[2] = getBysupplyListId_PrevAndNext(session, supplyItem,
					supplyListId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SupplyItem getBysupplyListId_PrevAndNext(Session session,
		SupplyItem supplyItem, long supplyListId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUPPLYITEM_WHERE);

		query.append(_FINDER_COLUMN_SUPPLYLISTID_SUPPLYLISTID_2);

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
			query.append(SupplyItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(supplyListId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(supplyItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SupplyItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the supply items where supplyListId = &#63; from the database.
	 *
	 * @param supplyListId the supply list ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBysupplyListId(long supplyListId)
		throws SystemException {
		for (SupplyItem supplyItem : findBysupplyListId(supplyListId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(supplyItem);
		}
	}

	/**
	 * Returns the number of supply items where supplyListId = &#63;.
	 *
	 * @param supplyListId the supply list ID
	 * @return the number of matching supply items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBysupplyListId(long supplyListId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SUPPLYLISTID;

		Object[] finderArgs = new Object[] { supplyListId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUPPLYITEM_WHERE);

			query.append(_FINDER_COLUMN_SUPPLYLISTID_SUPPLYLISTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(supplyListId);

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

	private static final String _FINDER_COLUMN_SUPPLYLISTID_SUPPLYLISTID_2 = "supplyItem.supplyListId = ?";

	public SupplyItemPersistenceImpl() {
		setModelClass(SupplyItem.class);
	}

	/**
	 * Caches the supply item in the entity cache if it is enabled.
	 *
	 * @param supplyItem the supply item
	 */
	@Override
	public void cacheResult(SupplyItem supplyItem) {
		EntityCacheUtil.putResult(SupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			SupplyItemImpl.class, supplyItem.getPrimaryKey(), supplyItem);

		supplyItem.resetOriginalValues();
	}

	/**
	 * Caches the supply items in the entity cache if it is enabled.
	 *
	 * @param supplyItems the supply items
	 */
	@Override
	public void cacheResult(List<SupplyItem> supplyItems) {
		for (SupplyItem supplyItem : supplyItems) {
			if (EntityCacheUtil.getResult(
						SupplyItemModelImpl.ENTITY_CACHE_ENABLED,
						SupplyItemImpl.class, supplyItem.getPrimaryKey()) == null) {
				cacheResult(supplyItem);
			}
			else {
				supplyItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all supply items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SupplyItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SupplyItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the supply item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SupplyItem supplyItem) {
		EntityCacheUtil.removeResult(SupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			SupplyItemImpl.class, supplyItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SupplyItem> supplyItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SupplyItem supplyItem : supplyItems) {
			EntityCacheUtil.removeResult(SupplyItemModelImpl.ENTITY_CACHE_ENABLED,
				SupplyItemImpl.class, supplyItem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new supply item with the primary key. Does not add the supply item to the database.
	 *
	 * @param supplyItemId the primary key for the new supply item
	 * @return the new supply item
	 */
	@Override
	public SupplyItem create(long supplyItemId) {
		SupplyItem supplyItem = new SupplyItemImpl();

		supplyItem.setNew(true);
		supplyItem.setPrimaryKey(supplyItemId);

		return supplyItem;
	}

	/**
	 * Removes the supply item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supplyItemId the primary key of the supply item
	 * @return the supply item that was removed
	 * @throws com.rumbasolutions.flask.NoSuchSupplyItemException if a supply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyItem remove(long supplyItemId)
		throws NoSuchSupplyItemException, SystemException {
		return remove((Serializable)supplyItemId);
	}

	/**
	 * Removes the supply item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the supply item
	 * @return the supply item that was removed
	 * @throws com.rumbasolutions.flask.NoSuchSupplyItemException if a supply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyItem remove(Serializable primaryKey)
		throws NoSuchSupplyItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SupplyItem supplyItem = (SupplyItem)session.get(SupplyItemImpl.class,
					primaryKey);

			if (supplyItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSupplyItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(supplyItem);
		}
		catch (NoSuchSupplyItemException nsee) {
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
	protected SupplyItem removeImpl(SupplyItem supplyItem)
		throws SystemException {
		supplyItem = toUnwrappedModel(supplyItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(supplyItem)) {
				supplyItem = (SupplyItem)session.get(SupplyItemImpl.class,
						supplyItem.getPrimaryKeyObj());
			}

			if (supplyItem != null) {
				session.delete(supplyItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (supplyItem != null) {
			clearCache(supplyItem);
		}

		return supplyItem;
	}

	@Override
	public SupplyItem updateImpl(
		com.rumbasolutions.flask.model.SupplyItem supplyItem)
		throws SystemException {
		supplyItem = toUnwrappedModel(supplyItem);

		boolean isNew = supplyItem.isNew();

		SupplyItemModelImpl supplyItemModelImpl = (SupplyItemModelImpl)supplyItem;

		Session session = null;

		try {
			session = openSession();

			if (supplyItem.isNew()) {
				session.save(supplyItem);

				supplyItem.setNew(false);
			}
			else {
				session.merge(supplyItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SupplyItemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((supplyItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPPLYLISTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						supplyItemModelImpl.getOriginalSupplyListId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUPPLYLISTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPPLYLISTID,
					args);

				args = new Object[] { supplyItemModelImpl.getSupplyListId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUPPLYLISTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUPPLYLISTID,
					args);
			}
		}

		EntityCacheUtil.putResult(SupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			SupplyItemImpl.class, supplyItem.getPrimaryKey(), supplyItem);

		return supplyItem;
	}

	protected SupplyItem toUnwrappedModel(SupplyItem supplyItem) {
		if (supplyItem instanceof SupplyItemImpl) {
			return supplyItem;
		}

		SupplyItemImpl supplyItemImpl = new SupplyItemImpl();

		supplyItemImpl.setNew(supplyItem.isNew());
		supplyItemImpl.setPrimaryKey(supplyItem.getPrimaryKey());

		supplyItemImpl.setSupplyItemId(supplyItem.getSupplyItemId());
		supplyItemImpl.setSupplyItemName(supplyItem.getSupplyItemName());
		supplyItemImpl.setSupplyListId(supplyItem.getSupplyListId());
		supplyItemImpl.setCreatedDate(supplyItem.getCreatedDate());
		supplyItemImpl.setModifiedDate(supplyItem.getModifiedDate());

		return supplyItemImpl;
	}

	/**
	 * Returns the supply item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the supply item
	 * @return the supply item
	 * @throws com.rumbasolutions.flask.NoSuchSupplyItemException if a supply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSupplyItemException, SystemException {
		SupplyItem supplyItem = fetchByPrimaryKey(primaryKey);

		if (supplyItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSupplyItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return supplyItem;
	}

	/**
	 * Returns the supply item with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchSupplyItemException} if it could not be found.
	 *
	 * @param supplyItemId the primary key of the supply item
	 * @return the supply item
	 * @throws com.rumbasolutions.flask.NoSuchSupplyItemException if a supply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyItem findByPrimaryKey(long supplyItemId)
		throws NoSuchSupplyItemException, SystemException {
		return findByPrimaryKey((Serializable)supplyItemId);
	}

	/**
	 * Returns the supply item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the supply item
	 * @return the supply item, or <code>null</code> if a supply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SupplyItem supplyItem = (SupplyItem)EntityCacheUtil.getResult(SupplyItemModelImpl.ENTITY_CACHE_ENABLED,
				SupplyItemImpl.class, primaryKey);

		if (supplyItem == _nullSupplyItem) {
			return null;
		}

		if (supplyItem == null) {
			Session session = null;

			try {
				session = openSession();

				supplyItem = (SupplyItem)session.get(SupplyItemImpl.class,
						primaryKey);

				if (supplyItem != null) {
					cacheResult(supplyItem);
				}
				else {
					EntityCacheUtil.putResult(SupplyItemModelImpl.ENTITY_CACHE_ENABLED,
						SupplyItemImpl.class, primaryKey, _nullSupplyItem);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SupplyItemModelImpl.ENTITY_CACHE_ENABLED,
					SupplyItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return supplyItem;
	}

	/**
	 * Returns the supply item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param supplyItemId the primary key of the supply item
	 * @return the supply item, or <code>null</code> if a supply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SupplyItem fetchByPrimaryKey(long supplyItemId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)supplyItemId);
	}

	/**
	 * Returns all the supply items.
	 *
	 * @return the supply items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the supply items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of supply items
	 * @param end the upper bound of the range of supply items (not inclusive)
	 * @return the range of supply items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyItem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the supply items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.SupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of supply items
	 * @param end the upper bound of the range of supply items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of supply items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SupplyItem> findAll(int start, int end,
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

		List<SupplyItem> list = (List<SupplyItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUPPLYITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUPPLYITEM;

				if (pagination) {
					sql = sql.concat(SupplyItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SupplyItem>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SupplyItem>(list);
				}
				else {
					list = (List<SupplyItem>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the supply items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SupplyItem supplyItem : findAll()) {
			remove(supplyItem);
		}
	}

	/**
	 * Returns the number of supply items.
	 *
	 * @return the number of supply items
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

				Query q = session.createQuery(_SQL_COUNT_SUPPLYITEM);

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
	 * Initializes the supply item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.SupplyItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SupplyItem>> listenersList = new ArrayList<ModelListener<SupplyItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SupplyItem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SupplyItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SUPPLYITEM = "SELECT supplyItem FROM SupplyItem supplyItem";
	private static final String _SQL_SELECT_SUPPLYITEM_WHERE = "SELECT supplyItem FROM SupplyItem supplyItem WHERE ";
	private static final String _SQL_COUNT_SUPPLYITEM = "SELECT COUNT(supplyItem) FROM SupplyItem supplyItem";
	private static final String _SQL_COUNT_SUPPLYITEM_WHERE = "SELECT COUNT(supplyItem) FROM SupplyItem supplyItem WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "supplyItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SupplyItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SupplyItem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SupplyItemPersistenceImpl.class);
	private static SupplyItem _nullSupplyItem = new SupplyItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SupplyItem> toCacheModel() {
				return _nullSupplyItemCacheModel;
			}
		};

	private static CacheModel<SupplyItem> _nullSupplyItemCacheModel = new CacheModel<SupplyItem>() {
			@Override
			public SupplyItem toEntityModel() {
				return _nullSupplyItem;
			}
		};
}