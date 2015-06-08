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

import com.rumbasolutions.flask.NoSuchVenueDetailException;
import com.rumbasolutions.flask.model.VenueDetail;
import com.rumbasolutions.flask.model.impl.VenueDetailImpl;
import com.rumbasolutions.flask.model.impl.VenueDetailModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the venue detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueDetailPersistence
 * @see VenueDetailUtil
 * @generated
 */
public class VenueDetailPersistenceImpl extends BasePersistenceImpl<VenueDetail>
	implements VenueDetailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VenueDetailUtil} to access the venue detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VenueDetailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VenueDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailModelImpl.FINDER_CACHE_ENABLED, VenueDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VenueDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailModelImpl.FINDER_CACHE_ENABLED, VenueDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VenueDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VENUEID = new FinderPath(VenueDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailModelImpl.FINDER_CACHE_ENABLED, VenueDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByvenueId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEID =
		new FinderPath(VenueDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailModelImpl.FINDER_CACHE_ENABLED, VenueDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByvenueId",
			new String[] { Long.class.getName() },
			VenueDetailModelImpl.VENUEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VENUEID = new FinderPath(VenueDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByvenueId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the venue details where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @return the matching venue details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDetail> findByvenueId(long venueId)
		throws SystemException {
		return findByvenueId(venueId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the venue details where venueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueId the venue ID
	 * @param start the lower bound of the range of venue details
	 * @param end the upper bound of the range of venue details (not inclusive)
	 * @return the range of matching venue details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDetail> findByvenueId(long venueId, int start, int end)
		throws SystemException {
		return findByvenueId(venueId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the venue details where venueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueId the venue ID
	 * @param start the lower bound of the range of venue details
	 * @param end the upper bound of the range of venue details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching venue details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDetail> findByvenueId(long venueId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEID;
			finderArgs = new Object[] { venueId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VENUEID;
			finderArgs = new Object[] { venueId, start, end, orderByComparator };
		}

		List<VenueDetail> list = (List<VenueDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VenueDetail venueDetail : list) {
				if ((venueId != venueDetail.getVenueId())) {
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

			query.append(_SQL_SELECT_VENUEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_VENUEID_VENUEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VenueDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(venueId);

				if (!pagination) {
					list = (List<VenueDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VenueDetail>(list);
				}
				else {
					list = (List<VenueDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first venue detail in the ordered set where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue detail
	 * @throws com.rumbasolutions.flask.NoSuchVenueDetailException if a matching venue detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetail findByvenueId_First(long venueId,
		OrderByComparator orderByComparator)
		throws NoSuchVenueDetailException, SystemException {
		VenueDetail venueDetail = fetchByvenueId_First(venueId,
				orderByComparator);

		if (venueDetail != null) {
			return venueDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueId=");
		msg.append(venueId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueDetailException(msg.toString());
	}

	/**
	 * Returns the first venue detail in the ordered set where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue detail, or <code>null</code> if a matching venue detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetail fetchByvenueId_First(long venueId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VenueDetail> list = findByvenueId(venueId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last venue detail in the ordered set where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue detail
	 * @throws com.rumbasolutions.flask.NoSuchVenueDetailException if a matching venue detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetail findByvenueId_Last(long venueId,
		OrderByComparator orderByComparator)
		throws NoSuchVenueDetailException, SystemException {
		VenueDetail venueDetail = fetchByvenueId_Last(venueId, orderByComparator);

		if (venueDetail != null) {
			return venueDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueId=");
		msg.append(venueId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueDetailException(msg.toString());
	}

	/**
	 * Returns the last venue detail in the ordered set where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue detail, or <code>null</code> if a matching venue detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetail fetchByvenueId_Last(long venueId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByvenueId(venueId);

		if (count == 0) {
			return null;
		}

		List<VenueDetail> list = findByvenueId(venueId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the venue details before and after the current venue detail in the ordered set where venueId = &#63;.
	 *
	 * @param venueDetailId the primary key of the current venue detail
	 * @param venueId the venue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next venue detail
	 * @throws com.rumbasolutions.flask.NoSuchVenueDetailException if a venue detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetail[] findByvenueId_PrevAndNext(long venueDetailId,
		long venueId, OrderByComparator orderByComparator)
		throws NoSuchVenueDetailException, SystemException {
		VenueDetail venueDetail = findByPrimaryKey(venueDetailId);

		Session session = null;

		try {
			session = openSession();

			VenueDetail[] array = new VenueDetailImpl[3];

			array[0] = getByvenueId_PrevAndNext(session, venueDetail, venueId,
					orderByComparator, true);

			array[1] = venueDetail;

			array[2] = getByvenueId_PrevAndNext(session, venueDetail, venueId,
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

	protected VenueDetail getByvenueId_PrevAndNext(Session session,
		VenueDetail venueDetail, long venueId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENUEDETAIL_WHERE);

		query.append(_FINDER_COLUMN_VENUEID_VENUEID_2);

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
			query.append(VenueDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(venueId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(venueDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VenueDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the venue details where venueId = &#63; from the database.
	 *
	 * @param venueId the venue ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByvenueId(long venueId) throws SystemException {
		for (VenueDetail venueDetail : findByvenueId(venueId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(venueDetail);
		}
	}

	/**
	 * Returns the number of venue details where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @return the number of matching venue details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByvenueId(long venueId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VENUEID;

		Object[] finderArgs = new Object[] { venueId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VENUEDETAIL_WHERE);

			query.append(_FINDER_COLUMN_VENUEID_VENUEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(venueId);

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

	private static final String _FINDER_COLUMN_VENUEID_VENUEID_2 = "venueDetail.venueId = ?";

	public VenueDetailPersistenceImpl() {
		setModelClass(VenueDetail.class);
	}

	/**
	 * Caches the venue detail in the entity cache if it is enabled.
	 *
	 * @param venueDetail the venue detail
	 */
	@Override
	public void cacheResult(VenueDetail venueDetail) {
		EntityCacheUtil.putResult(VenueDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailImpl.class, venueDetail.getPrimaryKey(), venueDetail);

		venueDetail.resetOriginalValues();
	}

	/**
	 * Caches the venue details in the entity cache if it is enabled.
	 *
	 * @param venueDetails the venue details
	 */
	@Override
	public void cacheResult(List<VenueDetail> venueDetails) {
		for (VenueDetail venueDetail : venueDetails) {
			if (EntityCacheUtil.getResult(
						VenueDetailModelImpl.ENTITY_CACHE_ENABLED,
						VenueDetailImpl.class, venueDetail.getPrimaryKey()) == null) {
				cacheResult(venueDetail);
			}
			else {
				venueDetail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all venue details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VenueDetailImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VenueDetailImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the venue detail.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VenueDetail venueDetail) {
		EntityCacheUtil.removeResult(VenueDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailImpl.class, venueDetail.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VenueDetail> venueDetails) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VenueDetail venueDetail : venueDetails) {
			EntityCacheUtil.removeResult(VenueDetailModelImpl.ENTITY_CACHE_ENABLED,
				VenueDetailImpl.class, venueDetail.getPrimaryKey());
		}
	}

	/**
	 * Creates a new venue detail with the primary key. Does not add the venue detail to the database.
	 *
	 * @param venueDetailId the primary key for the new venue detail
	 * @return the new venue detail
	 */
	@Override
	public VenueDetail create(long venueDetailId) {
		VenueDetail venueDetail = new VenueDetailImpl();

		venueDetail.setNew(true);
		venueDetail.setPrimaryKey(venueDetailId);

		return venueDetail;
	}

	/**
	 * Removes the venue detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param venueDetailId the primary key of the venue detail
	 * @return the venue detail that was removed
	 * @throws com.rumbasolutions.flask.NoSuchVenueDetailException if a venue detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetail remove(long venueDetailId)
		throws NoSuchVenueDetailException, SystemException {
		return remove((Serializable)venueDetailId);
	}

	/**
	 * Removes the venue detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the venue detail
	 * @return the venue detail that was removed
	 * @throws com.rumbasolutions.flask.NoSuchVenueDetailException if a venue detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetail remove(Serializable primaryKey)
		throws NoSuchVenueDetailException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VenueDetail venueDetail = (VenueDetail)session.get(VenueDetailImpl.class,
					primaryKey);

			if (venueDetail == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVenueDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(venueDetail);
		}
		catch (NoSuchVenueDetailException nsee) {
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
	protected VenueDetail removeImpl(VenueDetail venueDetail)
		throws SystemException {
		venueDetail = toUnwrappedModel(venueDetail);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(venueDetail)) {
				venueDetail = (VenueDetail)session.get(VenueDetailImpl.class,
						venueDetail.getPrimaryKeyObj());
			}

			if (venueDetail != null) {
				session.delete(venueDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (venueDetail != null) {
			clearCache(venueDetail);
		}

		return venueDetail;
	}

	@Override
	public VenueDetail updateImpl(
		com.rumbasolutions.flask.model.VenueDetail venueDetail)
		throws SystemException {
		venueDetail = toUnwrappedModel(venueDetail);

		boolean isNew = venueDetail.isNew();

		VenueDetailModelImpl venueDetailModelImpl = (VenueDetailModelImpl)venueDetail;

		Session session = null;

		try {
			session = openSession();

			if (venueDetail.isNew()) {
				session.save(venueDetail);

				venueDetail.setNew(false);
			}
			else {
				session.merge(venueDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VenueDetailModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((venueDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						venueDetailModelImpl.getOriginalVenueId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEID,
					args);

				args = new Object[] { venueDetailModelImpl.getVenueId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEID,
					args);
			}
		}

		EntityCacheUtil.putResult(VenueDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailImpl.class, venueDetail.getPrimaryKey(), venueDetail);

		return venueDetail;
	}

	protected VenueDetail toUnwrappedModel(VenueDetail venueDetail) {
		if (venueDetail instanceof VenueDetailImpl) {
			return venueDetail;
		}

		VenueDetailImpl venueDetailImpl = new VenueDetailImpl();

		venueDetailImpl.setNew(venueDetail.isNew());
		venueDetailImpl.setPrimaryKey(venueDetail.getPrimaryKey());

		venueDetailImpl.setVenueDetailId(venueDetail.getVenueDetailId());
		venueDetailImpl.setCompanyId(venueDetail.getCompanyId());
		venueDetailImpl.setUserId(venueDetail.getUserId());
		venueDetailImpl.setCreatedDate(venueDetail.getCreatedDate());
		venueDetailImpl.setModifiedDate(venueDetail.getModifiedDate());
		venueDetailImpl.setVenueId(venueDetail.getVenueId());
		venueDetailImpl.setInfoTypeId(venueDetail.getInfoTypeId());
		venueDetailImpl.setInfoTypeCategoryId(venueDetail.getInfoTypeCategoryId());
		venueDetailImpl.setVenueDetailInfoName(venueDetail.getVenueDetailInfoName());
		venueDetailImpl.setVenueDetailInfoDesc(venueDetail.getVenueDetailInfoDesc());
		venueDetailImpl.setVenueDetailInfoComment(venueDetail.getVenueDetailInfoComment());
		venueDetailImpl.setVenueDetailAddressLine1(venueDetail.getVenueDetailAddressLine1());
		venueDetailImpl.setVenueDetailAddressLine2(venueDetail.getVenueDetailAddressLine2());
		venueDetailImpl.setVenueDetailCity(venueDetail.getVenueDetailCity());
		venueDetailImpl.setVenueDetailState(venueDetail.getVenueDetailState());
		venueDetailImpl.setVenueDetailCountry(venueDetail.getVenueDetailCountry());
		venueDetailImpl.setVenueDetailLatitude(venueDetail.getVenueDetailLatitude());
		venueDetailImpl.setVenueDetailLongitude(venueDetail.getVenueDetailLongitude());
		venueDetailImpl.setVenueDetailPhone(venueDetail.getVenueDetailPhone());
		venueDetailImpl.setVenueDetailWebsite(venueDetail.getVenueDetailWebsite());
		venueDetailImpl.setVenueDetailCost(venueDetail.getVenueDetailCost());
		venueDetailImpl.setVenueDetailhoursOfOperation(venueDetail.getVenueDetailhoursOfOperation());

		return venueDetailImpl;
	}

	/**
	 * Returns the venue detail with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the venue detail
	 * @return the venue detail
	 * @throws com.rumbasolutions.flask.NoSuchVenueDetailException if a venue detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVenueDetailException, SystemException {
		VenueDetail venueDetail = fetchByPrimaryKey(primaryKey);

		if (venueDetail == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVenueDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return venueDetail;
	}

	/**
	 * Returns the venue detail with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueDetailException} if it could not be found.
	 *
	 * @param venueDetailId the primary key of the venue detail
	 * @return the venue detail
	 * @throws com.rumbasolutions.flask.NoSuchVenueDetailException if a venue detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetail findByPrimaryKey(long venueDetailId)
		throws NoSuchVenueDetailException, SystemException {
		return findByPrimaryKey((Serializable)venueDetailId);
	}

	/**
	 * Returns the venue detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the venue detail
	 * @return the venue detail, or <code>null</code> if a venue detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetail fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VenueDetail venueDetail = (VenueDetail)EntityCacheUtil.getResult(VenueDetailModelImpl.ENTITY_CACHE_ENABLED,
				VenueDetailImpl.class, primaryKey);

		if (venueDetail == _nullVenueDetail) {
			return null;
		}

		if (venueDetail == null) {
			Session session = null;

			try {
				session = openSession();

				venueDetail = (VenueDetail)session.get(VenueDetailImpl.class,
						primaryKey);

				if (venueDetail != null) {
					cacheResult(venueDetail);
				}
				else {
					EntityCacheUtil.putResult(VenueDetailModelImpl.ENTITY_CACHE_ENABLED,
						VenueDetailImpl.class, primaryKey, _nullVenueDetail);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VenueDetailModelImpl.ENTITY_CACHE_ENABLED,
					VenueDetailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return venueDetail;
	}

	/**
	 * Returns the venue detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param venueDetailId the primary key of the venue detail
	 * @return the venue detail, or <code>null</code> if a venue detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetail fetchByPrimaryKey(long venueDetailId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)venueDetailId);
	}

	/**
	 * Returns all the venue details.
	 *
	 * @return the venue details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDetail> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the venue details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of venue details
	 * @param end the upper bound of the range of venue details (not inclusive)
	 * @return the range of venue details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDetail> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the venue details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of venue details
	 * @param end the upper bound of the range of venue details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of venue details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDetail> findAll(int start, int end,
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

		List<VenueDetail> list = (List<VenueDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VENUEDETAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VENUEDETAIL;

				if (pagination) {
					sql = sql.concat(VenueDetailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VenueDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VenueDetail>(list);
				}
				else {
					list = (List<VenueDetail>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the venue details from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VenueDetail venueDetail : findAll()) {
			remove(venueDetail);
		}
	}

	/**
	 * Returns the number of venue details.
	 *
	 * @return the number of venue details
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

				Query q = session.createQuery(_SQL_COUNT_VENUEDETAIL);

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
	 * Initializes the venue detail persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.VenueDetail")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VenueDetail>> listenersList = new ArrayList<ModelListener<VenueDetail>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VenueDetail>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VenueDetailImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VENUEDETAIL = "SELECT venueDetail FROM VenueDetail venueDetail";
	private static final String _SQL_SELECT_VENUEDETAIL_WHERE = "SELECT venueDetail FROM VenueDetail venueDetail WHERE ";
	private static final String _SQL_COUNT_VENUEDETAIL = "SELECT COUNT(venueDetail) FROM VenueDetail venueDetail";
	private static final String _SQL_COUNT_VENUEDETAIL_WHERE = "SELECT COUNT(venueDetail) FROM VenueDetail venueDetail WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "venueDetail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VenueDetail exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VenueDetail exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VenueDetailPersistenceImpl.class);
	private static VenueDetail _nullVenueDetail = new VenueDetailImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VenueDetail> toCacheModel() {
				return _nullVenueDetailCacheModel;
			}
		};

	private static CacheModel<VenueDetail> _nullVenueDetailCacheModel = new CacheModel<VenueDetail>() {
			@Override
			public VenueDetail toEntityModel() {
				return _nullVenueDetail;
			}
		};
}