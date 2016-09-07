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

import com.rumbasolutions.flask.NoSuchTailgateSupplyItemException;
import com.rumbasolutions.flask.model.TailgateSupplyItem;
import com.rumbasolutions.flask.model.impl.TailgateSupplyItemImpl;
import com.rumbasolutions.flask.model.impl.TailgateSupplyItemModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tailgate supply item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TailgateSupplyItemPersistence
 * @see TailgateSupplyItemUtil
 * @generated
 */
public class TailgateSupplyItemPersistenceImpl extends BasePersistenceImpl<TailgateSupplyItem>
	implements TailgateSupplyItemPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TailgateSupplyItemUtil} to access the tailgate supply item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TailgateSupplyItemImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TailgateSupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			TailgateSupplyItemModelImpl.FINDER_CACHE_ENABLED,
			TailgateSupplyItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TailgateSupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			TailgateSupplyItemModelImpl.FINDER_CACHE_ENABLED,
			TailgateSupplyItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TailgateSupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			TailgateSupplyItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAILGATEID =
		new FinderPath(TailgateSupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			TailgateSupplyItemModelImpl.FINDER_CACHE_ENABLED,
			TailgateSupplyItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytailgateId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID =
		new FinderPath(TailgateSupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			TailgateSupplyItemModelImpl.FINDER_CACHE_ENABLED,
			TailgateSupplyItemImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytailgateId",
			new String[] { Long.class.getName() },
			TailgateSupplyItemModelImpl.TAILGATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAILGATEID = new FinderPath(TailgateSupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			TailgateSupplyItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytailgateId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tailgate supply items where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @return the matching tailgate supply items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateSupplyItem> findBytailgateId(long tailgateId)
		throws SystemException {
		return findBytailgateId(tailgateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tailgate supply items where tailgateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateSupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tailgateId the tailgate ID
	 * @param start the lower bound of the range of tailgate supply items
	 * @param end the upper bound of the range of tailgate supply items (not inclusive)
	 * @return the range of matching tailgate supply items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateSupplyItem> findBytailgateId(long tailgateId,
		int start, int end) throws SystemException {
		return findBytailgateId(tailgateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tailgate supply items where tailgateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateSupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tailgateId the tailgate ID
	 * @param start the lower bound of the range of tailgate supply items
	 * @param end the upper bound of the range of tailgate supply items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tailgate supply items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateSupplyItem> findBytailgateId(long tailgateId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID;
			finderArgs = new Object[] { tailgateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAILGATEID;
			finderArgs = new Object[] { tailgateId, start, end, orderByComparator };
		}

		List<TailgateSupplyItem> list = (List<TailgateSupplyItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TailgateSupplyItem tailgateSupplyItem : list) {
				if ((tailgateId != tailgateSupplyItem.getTailgateId())) {
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

			query.append(_SQL_SELECT_TAILGATESUPPLYITEM_WHERE);

			query.append(_FINDER_COLUMN_TAILGATEID_TAILGATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TailgateSupplyItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tailgateId);

				if (!pagination) {
					list = (List<TailgateSupplyItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TailgateSupplyItem>(list);
				}
				else {
					list = (List<TailgateSupplyItem>)QueryUtil.list(q,
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
	 * Returns the first tailgate supply item in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tailgate supply item
	 * @throws com.rumbasolutions.flask.NoSuchTailgateSupplyItemException if a matching tailgate supply item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateSupplyItem findBytailgateId_First(long tailgateId,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateSupplyItemException, SystemException {
		TailgateSupplyItem tailgateSupplyItem = fetchBytailgateId_First(tailgateId,
				orderByComparator);

		if (tailgateSupplyItem != null) {
			return tailgateSupplyItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tailgateId=");
		msg.append(tailgateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTailgateSupplyItemException(msg.toString());
	}

	/**
	 * Returns the first tailgate supply item in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tailgate supply item, or <code>null</code> if a matching tailgate supply item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateSupplyItem fetchBytailgateId_First(long tailgateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TailgateSupplyItem> list = findBytailgateId(tailgateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tailgate supply item in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tailgate supply item
	 * @throws com.rumbasolutions.flask.NoSuchTailgateSupplyItemException if a matching tailgate supply item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateSupplyItem findBytailgateId_Last(long tailgateId,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateSupplyItemException, SystemException {
		TailgateSupplyItem tailgateSupplyItem = fetchBytailgateId_Last(tailgateId,
				orderByComparator);

		if (tailgateSupplyItem != null) {
			return tailgateSupplyItem;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tailgateId=");
		msg.append(tailgateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTailgateSupplyItemException(msg.toString());
	}

	/**
	 * Returns the last tailgate supply item in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tailgate supply item, or <code>null</code> if a matching tailgate supply item could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateSupplyItem fetchBytailgateId_Last(long tailgateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBytailgateId(tailgateId);

		if (count == 0) {
			return null;
		}

		List<TailgateSupplyItem> list = findBytailgateId(tailgateId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tailgate supply items before and after the current tailgate supply item in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateSupplyItemId the primary key of the current tailgate supply item
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tailgate supply item
	 * @throws com.rumbasolutions.flask.NoSuchTailgateSupplyItemException if a tailgate supply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateSupplyItem[] findBytailgateId_PrevAndNext(
		long tailgateSupplyItemId, long tailgateId,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateSupplyItemException, SystemException {
		TailgateSupplyItem tailgateSupplyItem = findByPrimaryKey(tailgateSupplyItemId);

		Session session = null;

		try {
			session = openSession();

			TailgateSupplyItem[] array = new TailgateSupplyItemImpl[3];

			array[0] = getBytailgateId_PrevAndNext(session, tailgateSupplyItem,
					tailgateId, orderByComparator, true);

			array[1] = tailgateSupplyItem;

			array[2] = getBytailgateId_PrevAndNext(session, tailgateSupplyItem,
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

	protected TailgateSupplyItem getBytailgateId_PrevAndNext(Session session,
		TailgateSupplyItem tailgateSupplyItem, long tailgateId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAILGATESUPPLYITEM_WHERE);

		query.append(_FINDER_COLUMN_TAILGATEID_TAILGATEID_2);

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
			query.append(TailgateSupplyItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(tailgateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tailgateSupplyItem);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TailgateSupplyItem> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tailgate supply items where tailgateId = &#63; from the database.
	 *
	 * @param tailgateId the tailgate ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBytailgateId(long tailgateId) throws SystemException {
		for (TailgateSupplyItem tailgateSupplyItem : findBytailgateId(
				tailgateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tailgateSupplyItem);
		}
	}

	/**
	 * Returns the number of tailgate supply items where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @return the number of matching tailgate supply items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBytailgateId(long tailgateId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAILGATEID;

		Object[] finderArgs = new Object[] { tailgateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAILGATESUPPLYITEM_WHERE);

			query.append(_FINDER_COLUMN_TAILGATEID_TAILGATEID_2);

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

	private static final String _FINDER_COLUMN_TAILGATEID_TAILGATEID_2 = "tailgateSupplyItem.tailgateId = ?";

	public TailgateSupplyItemPersistenceImpl() {
		setModelClass(TailgateSupplyItem.class);
	}

	/**
	 * Caches the tailgate supply item in the entity cache if it is enabled.
	 *
	 * @param tailgateSupplyItem the tailgate supply item
	 */
	@Override
	public void cacheResult(TailgateSupplyItem tailgateSupplyItem) {
		EntityCacheUtil.putResult(TailgateSupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			TailgateSupplyItemImpl.class, tailgateSupplyItem.getPrimaryKey(),
			tailgateSupplyItem);

		tailgateSupplyItem.resetOriginalValues();
	}

	/**
	 * Caches the tailgate supply items in the entity cache if it is enabled.
	 *
	 * @param tailgateSupplyItems the tailgate supply items
	 */
	@Override
	public void cacheResult(List<TailgateSupplyItem> tailgateSupplyItems) {
		for (TailgateSupplyItem tailgateSupplyItem : tailgateSupplyItems) {
			if (EntityCacheUtil.getResult(
						TailgateSupplyItemModelImpl.ENTITY_CACHE_ENABLED,
						TailgateSupplyItemImpl.class,
						tailgateSupplyItem.getPrimaryKey()) == null) {
				cacheResult(tailgateSupplyItem);
			}
			else {
				tailgateSupplyItem.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tailgate supply items.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TailgateSupplyItemImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TailgateSupplyItemImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tailgate supply item.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TailgateSupplyItem tailgateSupplyItem) {
		EntityCacheUtil.removeResult(TailgateSupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			TailgateSupplyItemImpl.class, tailgateSupplyItem.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TailgateSupplyItem> tailgateSupplyItems) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TailgateSupplyItem tailgateSupplyItem : tailgateSupplyItems) {
			EntityCacheUtil.removeResult(TailgateSupplyItemModelImpl.ENTITY_CACHE_ENABLED,
				TailgateSupplyItemImpl.class, tailgateSupplyItem.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tailgate supply item with the primary key. Does not add the tailgate supply item to the database.
	 *
	 * @param tailgateSupplyItemId the primary key for the new tailgate supply item
	 * @return the new tailgate supply item
	 */
	@Override
	public TailgateSupplyItem create(long tailgateSupplyItemId) {
		TailgateSupplyItem tailgateSupplyItem = new TailgateSupplyItemImpl();

		tailgateSupplyItem.setNew(true);
		tailgateSupplyItem.setPrimaryKey(tailgateSupplyItemId);

		return tailgateSupplyItem;
	}

	/**
	 * Removes the tailgate supply item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tailgateSupplyItemId the primary key of the tailgate supply item
	 * @return the tailgate supply item that was removed
	 * @throws com.rumbasolutions.flask.NoSuchTailgateSupplyItemException if a tailgate supply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateSupplyItem remove(long tailgateSupplyItemId)
		throws NoSuchTailgateSupplyItemException, SystemException {
		return remove((Serializable)tailgateSupplyItemId);
	}

	/**
	 * Removes the tailgate supply item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tailgate supply item
	 * @return the tailgate supply item that was removed
	 * @throws com.rumbasolutions.flask.NoSuchTailgateSupplyItemException if a tailgate supply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateSupplyItem remove(Serializable primaryKey)
		throws NoSuchTailgateSupplyItemException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TailgateSupplyItem tailgateSupplyItem = (TailgateSupplyItem)session.get(TailgateSupplyItemImpl.class,
					primaryKey);

			if (tailgateSupplyItem == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTailgateSupplyItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tailgateSupplyItem);
		}
		catch (NoSuchTailgateSupplyItemException nsee) {
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
	protected TailgateSupplyItem removeImpl(
		TailgateSupplyItem tailgateSupplyItem) throws SystemException {
		tailgateSupplyItem = toUnwrappedModel(tailgateSupplyItem);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tailgateSupplyItem)) {
				tailgateSupplyItem = (TailgateSupplyItem)session.get(TailgateSupplyItemImpl.class,
						tailgateSupplyItem.getPrimaryKeyObj());
			}

			if (tailgateSupplyItem != null) {
				session.delete(tailgateSupplyItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tailgateSupplyItem != null) {
			clearCache(tailgateSupplyItem);
		}

		return tailgateSupplyItem;
	}

	@Override
	public TailgateSupplyItem updateImpl(
		com.rumbasolutions.flask.model.TailgateSupplyItem tailgateSupplyItem)
		throws SystemException {
		tailgateSupplyItem = toUnwrappedModel(tailgateSupplyItem);

		boolean isNew = tailgateSupplyItem.isNew();

		TailgateSupplyItemModelImpl tailgateSupplyItemModelImpl = (TailgateSupplyItemModelImpl)tailgateSupplyItem;

		Session session = null;

		try {
			session = openSession();

			if (tailgateSupplyItem.isNew()) {
				session.save(tailgateSupplyItem);

				tailgateSupplyItem.setNew(false);
			}
			else {
				session.merge(tailgateSupplyItem);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TailgateSupplyItemModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tailgateSupplyItemModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tailgateSupplyItemModelImpl.getOriginalTailgateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAILGATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID,
					args);

				args = new Object[] { tailgateSupplyItemModelImpl.getTailgateId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAILGATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID,
					args);
			}
		}

		EntityCacheUtil.putResult(TailgateSupplyItemModelImpl.ENTITY_CACHE_ENABLED,
			TailgateSupplyItemImpl.class, tailgateSupplyItem.getPrimaryKey(),
			tailgateSupplyItem);

		return tailgateSupplyItem;
	}

	protected TailgateSupplyItem toUnwrappedModel(
		TailgateSupplyItem tailgateSupplyItem) {
		if (tailgateSupplyItem instanceof TailgateSupplyItemImpl) {
			return tailgateSupplyItem;
		}

		TailgateSupplyItemImpl tailgateSupplyItemImpl = new TailgateSupplyItemImpl();

		tailgateSupplyItemImpl.setNew(tailgateSupplyItem.isNew());
		tailgateSupplyItemImpl.setPrimaryKey(tailgateSupplyItem.getPrimaryKey());

		tailgateSupplyItemImpl.setTailgateSupplyItemId(tailgateSupplyItem.getTailgateSupplyItemId());
		tailgateSupplyItemImpl.setSupplyListItemName(tailgateSupplyItem.getSupplyListItemName());
		tailgateSupplyItemImpl.setTailgateId(tailgateSupplyItem.getTailgateId());
		tailgateSupplyItemImpl.setItemAssignedUserId(tailgateSupplyItem.getItemAssignedUserId());
		tailgateSupplyItemImpl.setCompanyId(tailgateSupplyItem.getCompanyId());
		tailgateSupplyItemImpl.setUserId(tailgateSupplyItem.getUserId());
		tailgateSupplyItemImpl.setCreatedDate(tailgateSupplyItem.getCreatedDate());
		tailgateSupplyItemImpl.setModifiedDate(tailgateSupplyItem.getModifiedDate());

		return tailgateSupplyItemImpl;
	}

	/**
	 * Returns the tailgate supply item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tailgate supply item
	 * @return the tailgate supply item
	 * @throws com.rumbasolutions.flask.NoSuchTailgateSupplyItemException if a tailgate supply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateSupplyItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTailgateSupplyItemException, SystemException {
		TailgateSupplyItem tailgateSupplyItem = fetchByPrimaryKey(primaryKey);

		if (tailgateSupplyItem == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTailgateSupplyItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tailgateSupplyItem;
	}

	/**
	 * Returns the tailgate supply item with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchTailgateSupplyItemException} if it could not be found.
	 *
	 * @param tailgateSupplyItemId the primary key of the tailgate supply item
	 * @return the tailgate supply item
	 * @throws com.rumbasolutions.flask.NoSuchTailgateSupplyItemException if a tailgate supply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateSupplyItem findByPrimaryKey(long tailgateSupplyItemId)
		throws NoSuchTailgateSupplyItemException, SystemException {
		return findByPrimaryKey((Serializable)tailgateSupplyItemId);
	}

	/**
	 * Returns the tailgate supply item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tailgate supply item
	 * @return the tailgate supply item, or <code>null</code> if a tailgate supply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateSupplyItem fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TailgateSupplyItem tailgateSupplyItem = (TailgateSupplyItem)EntityCacheUtil.getResult(TailgateSupplyItemModelImpl.ENTITY_CACHE_ENABLED,
				TailgateSupplyItemImpl.class, primaryKey);

		if (tailgateSupplyItem == _nullTailgateSupplyItem) {
			return null;
		}

		if (tailgateSupplyItem == null) {
			Session session = null;

			try {
				session = openSession();

				tailgateSupplyItem = (TailgateSupplyItem)session.get(TailgateSupplyItemImpl.class,
						primaryKey);

				if (tailgateSupplyItem != null) {
					cacheResult(tailgateSupplyItem);
				}
				else {
					EntityCacheUtil.putResult(TailgateSupplyItemModelImpl.ENTITY_CACHE_ENABLED,
						TailgateSupplyItemImpl.class, primaryKey,
						_nullTailgateSupplyItem);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TailgateSupplyItemModelImpl.ENTITY_CACHE_ENABLED,
					TailgateSupplyItemImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tailgateSupplyItem;
	}

	/**
	 * Returns the tailgate supply item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tailgateSupplyItemId the primary key of the tailgate supply item
	 * @return the tailgate supply item, or <code>null</code> if a tailgate supply item with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateSupplyItem fetchByPrimaryKey(long tailgateSupplyItemId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)tailgateSupplyItemId);
	}

	/**
	 * Returns all the tailgate supply items.
	 *
	 * @return the tailgate supply items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateSupplyItem> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tailgate supply items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateSupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tailgate supply items
	 * @param end the upper bound of the range of tailgate supply items (not inclusive)
	 * @return the range of tailgate supply items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateSupplyItem> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tailgate supply items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateSupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tailgate supply items
	 * @param end the upper bound of the range of tailgate supply items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tailgate supply items
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateSupplyItem> findAll(int start, int end,
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

		List<TailgateSupplyItem> list = (List<TailgateSupplyItem>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAILGATESUPPLYITEM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAILGATESUPPLYITEM;

				if (pagination) {
					sql = sql.concat(TailgateSupplyItemModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TailgateSupplyItem>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TailgateSupplyItem>(list);
				}
				else {
					list = (List<TailgateSupplyItem>)QueryUtil.list(q,
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
	 * Removes all the tailgate supply items from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TailgateSupplyItem tailgateSupplyItem : findAll()) {
			remove(tailgateSupplyItem);
		}
	}

	/**
	 * Returns the number of tailgate supply items.
	 *
	 * @return the number of tailgate supply items
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

				Query q = session.createQuery(_SQL_COUNT_TAILGATESUPPLYITEM);

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
	 * Initializes the tailgate supply item persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.TailgateSupplyItem")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TailgateSupplyItem>> listenersList = new ArrayList<ModelListener<TailgateSupplyItem>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TailgateSupplyItem>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TailgateSupplyItemImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TAILGATESUPPLYITEM = "SELECT tailgateSupplyItem FROM TailgateSupplyItem tailgateSupplyItem";
	private static final String _SQL_SELECT_TAILGATESUPPLYITEM_WHERE = "SELECT tailgateSupplyItem FROM TailgateSupplyItem tailgateSupplyItem WHERE ";
	private static final String _SQL_COUNT_TAILGATESUPPLYITEM = "SELECT COUNT(tailgateSupplyItem) FROM TailgateSupplyItem tailgateSupplyItem";
	private static final String _SQL_COUNT_TAILGATESUPPLYITEM_WHERE = "SELECT COUNT(tailgateSupplyItem) FROM TailgateSupplyItem tailgateSupplyItem WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tailgateSupplyItem.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TailgateSupplyItem exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TailgateSupplyItem exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TailgateSupplyItemPersistenceImpl.class);
	private static TailgateSupplyItem _nullTailgateSupplyItem = new TailgateSupplyItemImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TailgateSupplyItem> toCacheModel() {
				return _nullTailgateSupplyItemCacheModel;
			}
		};

	private static CacheModel<TailgateSupplyItem> _nullTailgateSupplyItemCacheModel =
		new CacheModel<TailgateSupplyItem>() {
			@Override
			public TailgateSupplyItem toEntityModel() {
				return _nullTailgateSupplyItem;
			}
		};
}