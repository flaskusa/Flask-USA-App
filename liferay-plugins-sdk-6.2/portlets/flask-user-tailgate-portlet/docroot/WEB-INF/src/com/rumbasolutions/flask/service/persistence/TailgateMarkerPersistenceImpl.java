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

import com.rumbasolutions.flask.NoSuchTailgateMarkerException;
import com.rumbasolutions.flask.model.TailgateMarker;
import com.rumbasolutions.flask.model.impl.TailgateMarkerImpl;
import com.rumbasolutions.flask.model.impl.TailgateMarkerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tailgate marker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TailgateMarkerPersistence
 * @see TailgateMarkerUtil
 * @generated
 */
public class TailgateMarkerPersistenceImpl extends BasePersistenceImpl<TailgateMarker>
	implements TailgateMarkerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TailgateMarkerUtil} to access the tailgate marker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TailgateMarkerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TailgateMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMarkerModelImpl.FINDER_CACHE_ENABLED,
			TailgateMarkerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TailgateMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMarkerModelImpl.FINDER_CACHE_ENABLED,
			TailgateMarkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TailgateMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMarkerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAILGATEID =
		new FinderPath(TailgateMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMarkerModelImpl.FINDER_CACHE_ENABLED,
			TailgateMarkerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBytailgateid",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID =
		new FinderPath(TailgateMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMarkerModelImpl.FINDER_CACHE_ENABLED,
			TailgateMarkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytailgateid",
			new String[] { Long.class.getName() },
			TailgateMarkerModelImpl.TAILGATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAILGATEID = new FinderPath(TailgateMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMarkerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytailgateid",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tailgate markers where tailgateid = &#63;.
	 *
	 * @param tailgateid the tailgateid
	 * @return the matching tailgate markers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateMarker> findBytailgateid(long tailgateid)
		throws SystemException {
		return findBytailgateid(tailgateid, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tailgate markers where tailgateid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateMarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tailgateid the tailgateid
	 * @param start the lower bound of the range of tailgate markers
	 * @param end the upper bound of the range of tailgate markers (not inclusive)
	 * @return the range of matching tailgate markers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateMarker> findBytailgateid(long tailgateid, int start,
		int end) throws SystemException {
		return findBytailgateid(tailgateid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tailgate markers where tailgateid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateMarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tailgateid the tailgateid
	 * @param start the lower bound of the range of tailgate markers
	 * @param end the upper bound of the range of tailgate markers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tailgate markers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateMarker> findBytailgateid(long tailgateid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID;
			finderArgs = new Object[] { tailgateid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAILGATEID;
			finderArgs = new Object[] { tailgateid, start, end, orderByComparator };
		}

		List<TailgateMarker> list = (List<TailgateMarker>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TailgateMarker tailgateMarker : list) {
				if ((tailgateid != tailgateMarker.getTailgateid())) {
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

			query.append(_SQL_SELECT_TAILGATEMARKER_WHERE);

			query.append(_FINDER_COLUMN_TAILGATEID_TAILGATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TailgateMarkerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tailgateid);

				if (!pagination) {
					list = (List<TailgateMarker>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TailgateMarker>(list);
				}
				else {
					list = (List<TailgateMarker>)QueryUtil.list(q,
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
	 * Returns the first tailgate marker in the ordered set where tailgateid = &#63;.
	 *
	 * @param tailgateid the tailgateid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tailgate marker
	 * @throws com.rumbasolutions.flask.NoSuchTailgateMarkerException if a matching tailgate marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMarker findBytailgateid_First(long tailgateid,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateMarkerException, SystemException {
		TailgateMarker tailgateMarker = fetchBytailgateid_First(tailgateid,
				orderByComparator);

		if (tailgateMarker != null) {
			return tailgateMarker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tailgateid=");
		msg.append(tailgateid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTailgateMarkerException(msg.toString());
	}

	/**
	 * Returns the first tailgate marker in the ordered set where tailgateid = &#63;.
	 *
	 * @param tailgateid the tailgateid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tailgate marker, or <code>null</code> if a matching tailgate marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMarker fetchBytailgateid_First(long tailgateid,
		OrderByComparator orderByComparator) throws SystemException {
		List<TailgateMarker> list = findBytailgateid(tailgateid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tailgate marker in the ordered set where tailgateid = &#63;.
	 *
	 * @param tailgateid the tailgateid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tailgate marker
	 * @throws com.rumbasolutions.flask.NoSuchTailgateMarkerException if a matching tailgate marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMarker findBytailgateid_Last(long tailgateid,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateMarkerException, SystemException {
		TailgateMarker tailgateMarker = fetchBytailgateid_Last(tailgateid,
				orderByComparator);

		if (tailgateMarker != null) {
			return tailgateMarker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tailgateid=");
		msg.append(tailgateid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTailgateMarkerException(msg.toString());
	}

	/**
	 * Returns the last tailgate marker in the ordered set where tailgateid = &#63;.
	 *
	 * @param tailgateid the tailgateid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tailgate marker, or <code>null</code> if a matching tailgate marker could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMarker fetchBytailgateid_Last(long tailgateid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBytailgateid(tailgateid);

		if (count == 0) {
			return null;
		}

		List<TailgateMarker> list = findBytailgateid(tailgateid, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tailgate markers before and after the current tailgate marker in the ordered set where tailgateid = &#63;.
	 *
	 * @param tailgatemarkerid the primary key of the current tailgate marker
	 * @param tailgateid the tailgateid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tailgate marker
	 * @throws com.rumbasolutions.flask.NoSuchTailgateMarkerException if a tailgate marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMarker[] findBytailgateid_PrevAndNext(
		long tailgatemarkerid, long tailgateid,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateMarkerException, SystemException {
		TailgateMarker tailgateMarker = findByPrimaryKey(tailgatemarkerid);

		Session session = null;

		try {
			session = openSession();

			TailgateMarker[] array = new TailgateMarkerImpl[3];

			array[0] = getBytailgateid_PrevAndNext(session, tailgateMarker,
					tailgateid, orderByComparator, true);

			array[1] = tailgateMarker;

			array[2] = getBytailgateid_PrevAndNext(session, tailgateMarker,
					tailgateid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TailgateMarker getBytailgateid_PrevAndNext(Session session,
		TailgateMarker tailgateMarker, long tailgateid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAILGATEMARKER_WHERE);

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
			query.append(TailgateMarkerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(tailgateid);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tailgateMarker);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TailgateMarker> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tailgate markers where tailgateid = &#63; from the database.
	 *
	 * @param tailgateid the tailgateid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBytailgateid(long tailgateid) throws SystemException {
		for (TailgateMarker tailgateMarker : findBytailgateid(tailgateid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tailgateMarker);
		}
	}

	/**
	 * Returns the number of tailgate markers where tailgateid = &#63;.
	 *
	 * @param tailgateid the tailgateid
	 * @return the number of matching tailgate markers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBytailgateid(long tailgateid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAILGATEID;

		Object[] finderArgs = new Object[] { tailgateid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAILGATEMARKER_WHERE);

			query.append(_FINDER_COLUMN_TAILGATEID_TAILGATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tailgateid);

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

	private static final String _FINDER_COLUMN_TAILGATEID_TAILGATEID_2 = "tailgateMarker.tailgateid = ?";

	public TailgateMarkerPersistenceImpl() {
		setModelClass(TailgateMarker.class);
	}

	/**
	 * Caches the tailgate marker in the entity cache if it is enabled.
	 *
	 * @param tailgateMarker the tailgate marker
	 */
	@Override
	public void cacheResult(TailgateMarker tailgateMarker) {
		EntityCacheUtil.putResult(TailgateMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMarkerImpl.class, tailgateMarker.getPrimaryKey(),
			tailgateMarker);

		tailgateMarker.resetOriginalValues();
	}

	/**
	 * Caches the tailgate markers in the entity cache if it is enabled.
	 *
	 * @param tailgateMarkers the tailgate markers
	 */
	@Override
	public void cacheResult(List<TailgateMarker> tailgateMarkers) {
		for (TailgateMarker tailgateMarker : tailgateMarkers) {
			if (EntityCacheUtil.getResult(
						TailgateMarkerModelImpl.ENTITY_CACHE_ENABLED,
						TailgateMarkerImpl.class, tailgateMarker.getPrimaryKey()) == null) {
				cacheResult(tailgateMarker);
			}
			else {
				tailgateMarker.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tailgate markers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TailgateMarkerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TailgateMarkerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tailgate marker.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TailgateMarker tailgateMarker) {
		EntityCacheUtil.removeResult(TailgateMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMarkerImpl.class, tailgateMarker.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TailgateMarker> tailgateMarkers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TailgateMarker tailgateMarker : tailgateMarkers) {
			EntityCacheUtil.removeResult(TailgateMarkerModelImpl.ENTITY_CACHE_ENABLED,
				TailgateMarkerImpl.class, tailgateMarker.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tailgate marker with the primary key. Does not add the tailgate marker to the database.
	 *
	 * @param tailgatemarkerid the primary key for the new tailgate marker
	 * @return the new tailgate marker
	 */
	@Override
	public TailgateMarker create(long tailgatemarkerid) {
		TailgateMarker tailgateMarker = new TailgateMarkerImpl();

		tailgateMarker.setNew(true);
		tailgateMarker.setPrimaryKey(tailgatemarkerid);

		return tailgateMarker;
	}

	/**
	 * Removes the tailgate marker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tailgatemarkerid the primary key of the tailgate marker
	 * @return the tailgate marker that was removed
	 * @throws com.rumbasolutions.flask.NoSuchTailgateMarkerException if a tailgate marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMarker remove(long tailgatemarkerid)
		throws NoSuchTailgateMarkerException, SystemException {
		return remove((Serializable)tailgatemarkerid);
	}

	/**
	 * Removes the tailgate marker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tailgate marker
	 * @return the tailgate marker that was removed
	 * @throws com.rumbasolutions.flask.NoSuchTailgateMarkerException if a tailgate marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMarker remove(Serializable primaryKey)
		throws NoSuchTailgateMarkerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TailgateMarker tailgateMarker = (TailgateMarker)session.get(TailgateMarkerImpl.class,
					primaryKey);

			if (tailgateMarker == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTailgateMarkerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tailgateMarker);
		}
		catch (NoSuchTailgateMarkerException nsee) {
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
	protected TailgateMarker removeImpl(TailgateMarker tailgateMarker)
		throws SystemException {
		tailgateMarker = toUnwrappedModel(tailgateMarker);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tailgateMarker)) {
				tailgateMarker = (TailgateMarker)session.get(TailgateMarkerImpl.class,
						tailgateMarker.getPrimaryKeyObj());
			}

			if (tailgateMarker != null) {
				session.delete(tailgateMarker);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tailgateMarker != null) {
			clearCache(tailgateMarker);
		}

		return tailgateMarker;
	}

	@Override
	public TailgateMarker updateImpl(
		com.rumbasolutions.flask.model.TailgateMarker tailgateMarker)
		throws SystemException {
		tailgateMarker = toUnwrappedModel(tailgateMarker);

		boolean isNew = tailgateMarker.isNew();

		TailgateMarkerModelImpl tailgateMarkerModelImpl = (TailgateMarkerModelImpl)tailgateMarker;

		Session session = null;

		try {
			session = openSession();

			if (tailgateMarker.isNew()) {
				session.save(tailgateMarker);

				tailgateMarker.setNew(false);
			}
			else {
				session.merge(tailgateMarker);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TailgateMarkerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tailgateMarkerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tailgateMarkerModelImpl.getOriginalTailgateid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAILGATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID,
					args);

				args = new Object[] { tailgateMarkerModelImpl.getTailgateid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAILGATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID,
					args);
			}
		}

		EntityCacheUtil.putResult(TailgateMarkerModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMarkerImpl.class, tailgateMarker.getPrimaryKey(),
			tailgateMarker);

		return tailgateMarker;
	}

	protected TailgateMarker toUnwrappedModel(TailgateMarker tailgateMarker) {
		if (tailgateMarker instanceof TailgateMarkerImpl) {
			return tailgateMarker;
		}

		TailgateMarkerImpl tailgateMarkerImpl = new TailgateMarkerImpl();

		tailgateMarkerImpl.setNew(tailgateMarker.isNew());
		tailgateMarkerImpl.setPrimaryKey(tailgateMarker.getPrimaryKey());

		tailgateMarkerImpl.setTailgatemarkerid(tailgateMarker.getTailgatemarkerid());
		tailgateMarkerImpl.setTailgateid(tailgateMarker.getTailgateid());
		tailgateMarkerImpl.setLatitude(tailgateMarker.getLatitude());
		tailgateMarkerImpl.setLongitude(tailgateMarker.getLongitude());
		tailgateMarkerImpl.setName(tailgateMarker.getName());
		tailgateMarkerImpl.setDescription(tailgateMarker.getDescription());

		return tailgateMarkerImpl;
	}

	/**
	 * Returns the tailgate marker with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tailgate marker
	 * @return the tailgate marker
	 * @throws com.rumbasolutions.flask.NoSuchTailgateMarkerException if a tailgate marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMarker findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTailgateMarkerException, SystemException {
		TailgateMarker tailgateMarker = fetchByPrimaryKey(primaryKey);

		if (tailgateMarker == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTailgateMarkerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tailgateMarker;
	}

	/**
	 * Returns the tailgate marker with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchTailgateMarkerException} if it could not be found.
	 *
	 * @param tailgatemarkerid the primary key of the tailgate marker
	 * @return the tailgate marker
	 * @throws com.rumbasolutions.flask.NoSuchTailgateMarkerException if a tailgate marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMarker findByPrimaryKey(long tailgatemarkerid)
		throws NoSuchTailgateMarkerException, SystemException {
		return findByPrimaryKey((Serializable)tailgatemarkerid);
	}

	/**
	 * Returns the tailgate marker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tailgate marker
	 * @return the tailgate marker, or <code>null</code> if a tailgate marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMarker fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TailgateMarker tailgateMarker = (TailgateMarker)EntityCacheUtil.getResult(TailgateMarkerModelImpl.ENTITY_CACHE_ENABLED,
				TailgateMarkerImpl.class, primaryKey);

		if (tailgateMarker == _nullTailgateMarker) {
			return null;
		}

		if (tailgateMarker == null) {
			Session session = null;

			try {
				session = openSession();

				tailgateMarker = (TailgateMarker)session.get(TailgateMarkerImpl.class,
						primaryKey);

				if (tailgateMarker != null) {
					cacheResult(tailgateMarker);
				}
				else {
					EntityCacheUtil.putResult(TailgateMarkerModelImpl.ENTITY_CACHE_ENABLED,
						TailgateMarkerImpl.class, primaryKey,
						_nullTailgateMarker);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TailgateMarkerModelImpl.ENTITY_CACHE_ENABLED,
					TailgateMarkerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tailgateMarker;
	}

	/**
	 * Returns the tailgate marker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tailgatemarkerid the primary key of the tailgate marker
	 * @return the tailgate marker, or <code>null</code> if a tailgate marker with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMarker fetchByPrimaryKey(long tailgatemarkerid)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)tailgatemarkerid);
	}

	/**
	 * Returns all the tailgate markers.
	 *
	 * @return the tailgate markers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateMarker> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tailgate markers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateMarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tailgate markers
	 * @param end the upper bound of the range of tailgate markers (not inclusive)
	 * @return the range of tailgate markers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateMarker> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tailgate markers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateMarkerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tailgate markers
	 * @param end the upper bound of the range of tailgate markers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tailgate markers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateMarker> findAll(int start, int end,
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

		List<TailgateMarker> list = (List<TailgateMarker>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAILGATEMARKER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAILGATEMARKER;

				if (pagination) {
					sql = sql.concat(TailgateMarkerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TailgateMarker>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TailgateMarker>(list);
				}
				else {
					list = (List<TailgateMarker>)QueryUtil.list(q,
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
	 * Removes all the tailgate markers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TailgateMarker tailgateMarker : findAll()) {
			remove(tailgateMarker);
		}
	}

	/**
	 * Returns the number of tailgate markers.
	 *
	 * @return the number of tailgate markers
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

				Query q = session.createQuery(_SQL_COUNT_TAILGATEMARKER);

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
	 * Initializes the tailgate marker persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.TailgateMarker")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TailgateMarker>> listenersList = new ArrayList<ModelListener<TailgateMarker>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TailgateMarker>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TailgateMarkerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TAILGATEMARKER = "SELECT tailgateMarker FROM TailgateMarker tailgateMarker";
	private static final String _SQL_SELECT_TAILGATEMARKER_WHERE = "SELECT tailgateMarker FROM TailgateMarker tailgateMarker WHERE ";
	private static final String _SQL_COUNT_TAILGATEMARKER = "SELECT COUNT(tailgateMarker) FROM TailgateMarker tailgateMarker";
	private static final String _SQL_COUNT_TAILGATEMARKER_WHERE = "SELECT COUNT(tailgateMarker) FROM TailgateMarker tailgateMarker WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tailgateMarker.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TailgateMarker exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TailgateMarker exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TailgateMarkerPersistenceImpl.class);
	private static TailgateMarker _nullTailgateMarker = new TailgateMarkerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TailgateMarker> toCacheModel() {
				return _nullTailgateMarkerCacheModel;
			}
		};

	private static CacheModel<TailgateMarker> _nullTailgateMarkerCacheModel = new CacheModel<TailgateMarker>() {
			@Override
			public TailgateMarker toEntityModel() {
				return _nullTailgateMarker;
			}
		};
}