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

import com.rumbasolutions.flask.NoSuchVenueSubDetailException;
import com.rumbasolutions.flask.model.VenueSubDetail;
import com.rumbasolutions.flask.model.impl.VenueSubDetailImpl;
import com.rumbasolutions.flask.model.impl.VenueSubDetailModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the venue sub detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueSubDetailPersistence
 * @see VenueSubDetailUtil
 * @generated
 */
public class VenueSubDetailPersistenceImpl extends BasePersistenceImpl<VenueSubDetail>
	implements VenueSubDetailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VenueSubDetailUtil} to access the venue sub detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VenueSubDetailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VenueSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueSubDetailModelImpl.FINDER_CACHE_ENABLED,
			VenueSubDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VenueSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueSubDetailModelImpl.FINDER_CACHE_ENABLED,
			VenueSubDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VenueSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueSubDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VENUEDETAILID =
		new FinderPath(VenueSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueSubDetailModelImpl.FINDER_CACHE_ENABLED,
			VenueSubDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVenueDetailId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDETAILID =
		new FinderPath(VenueSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueSubDetailModelImpl.FINDER_CACHE_ENABLED,
			VenueSubDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVenueDetailId",
			new String[] { Long.class.getName() },
			VenueSubDetailModelImpl.VENUEDETAILID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VENUEDETAILID = new FinderPath(VenueSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueSubDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVenueDetailId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the venue sub details where venueDetailId = &#63;.
	 *
	 * @param venueDetailId the venue detail ID
	 * @return the matching venue sub details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueSubDetail> findByVenueDetailId(long venueDetailId)
		throws SystemException {
		return findByVenueDetailId(venueDetailId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the venue sub details where venueDetailId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueDetailId the venue detail ID
	 * @param start the lower bound of the range of venue sub details
	 * @param end the upper bound of the range of venue sub details (not inclusive)
	 * @return the range of matching venue sub details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueSubDetail> findByVenueDetailId(long venueDetailId,
		int start, int end) throws SystemException {
		return findByVenueDetailId(venueDetailId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the venue sub details where venueDetailId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueDetailId the venue detail ID
	 * @param start the lower bound of the range of venue sub details
	 * @param end the upper bound of the range of venue sub details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching venue sub details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueSubDetail> findByVenueDetailId(long venueDetailId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDETAILID;
			finderArgs = new Object[] { venueDetailId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VENUEDETAILID;
			finderArgs = new Object[] {
					venueDetailId,
					
					start, end, orderByComparator
				};
		}

		List<VenueSubDetail> list = (List<VenueSubDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VenueSubDetail venueSubDetail : list) {
				if ((venueDetailId != venueSubDetail.getVenueDetailId())) {
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

			query.append(_SQL_SELECT_VENUESUBDETAIL_WHERE);

			query.append(_FINDER_COLUMN_VENUEDETAILID_VENUEDETAILID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VenueSubDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(venueDetailId);

				if (!pagination) {
					list = (List<VenueSubDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VenueSubDetail>(list);
				}
				else {
					list = (List<VenueSubDetail>)QueryUtil.list(q,
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
	 * Returns the first venue sub detail in the ordered set where venueDetailId = &#63;.
	 *
	 * @param venueDetailId the venue detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue sub detail
	 * @throws com.rumbasolutions.flask.NoSuchVenueSubDetailException if a matching venue sub detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueSubDetail findByVenueDetailId_First(long venueDetailId,
		OrderByComparator orderByComparator)
		throws NoSuchVenueSubDetailException, SystemException {
		VenueSubDetail venueSubDetail = fetchByVenueDetailId_First(venueDetailId,
				orderByComparator);

		if (venueSubDetail != null) {
			return venueSubDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueDetailId=");
		msg.append(venueDetailId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueSubDetailException(msg.toString());
	}

	/**
	 * Returns the first venue sub detail in the ordered set where venueDetailId = &#63;.
	 *
	 * @param venueDetailId the venue detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue sub detail, or <code>null</code> if a matching venue sub detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueSubDetail fetchByVenueDetailId_First(long venueDetailId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VenueSubDetail> list = findByVenueDetailId(venueDetailId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last venue sub detail in the ordered set where venueDetailId = &#63;.
	 *
	 * @param venueDetailId the venue detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue sub detail
	 * @throws com.rumbasolutions.flask.NoSuchVenueSubDetailException if a matching venue sub detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueSubDetail findByVenueDetailId_Last(long venueDetailId,
		OrderByComparator orderByComparator)
		throws NoSuchVenueSubDetailException, SystemException {
		VenueSubDetail venueSubDetail = fetchByVenueDetailId_Last(venueDetailId,
				orderByComparator);

		if (venueSubDetail != null) {
			return venueSubDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueDetailId=");
		msg.append(venueDetailId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueSubDetailException(msg.toString());
	}

	/**
	 * Returns the last venue sub detail in the ordered set where venueDetailId = &#63;.
	 *
	 * @param venueDetailId the venue detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue sub detail, or <code>null</code> if a matching venue sub detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueSubDetail fetchByVenueDetailId_Last(long venueDetailId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVenueDetailId(venueDetailId);

		if (count == 0) {
			return null;
		}

		List<VenueSubDetail> list = findByVenueDetailId(venueDetailId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the venue sub details before and after the current venue sub detail in the ordered set where venueDetailId = &#63;.
	 *
	 * @param venueSubDetailId the primary key of the current venue sub detail
	 * @param venueDetailId the venue detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next venue sub detail
	 * @throws com.rumbasolutions.flask.NoSuchVenueSubDetailException if a venue sub detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueSubDetail[] findByVenueDetailId_PrevAndNext(
		long venueSubDetailId, long venueDetailId,
		OrderByComparator orderByComparator)
		throws NoSuchVenueSubDetailException, SystemException {
		VenueSubDetail venueSubDetail = findByPrimaryKey(venueSubDetailId);

		Session session = null;

		try {
			session = openSession();

			VenueSubDetail[] array = new VenueSubDetailImpl[3];

			array[0] = getByVenueDetailId_PrevAndNext(session, venueSubDetail,
					venueDetailId, orderByComparator, true);

			array[1] = venueSubDetail;

			array[2] = getByVenueDetailId_PrevAndNext(session, venueSubDetail,
					venueDetailId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VenueSubDetail getByVenueDetailId_PrevAndNext(Session session,
		VenueSubDetail venueSubDetail, long venueDetailId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENUESUBDETAIL_WHERE);

		query.append(_FINDER_COLUMN_VENUEDETAILID_VENUEDETAILID_2);

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
			query.append(VenueSubDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(venueDetailId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(venueSubDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VenueSubDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the venue sub details where venueDetailId = &#63; from the database.
	 *
	 * @param venueDetailId the venue detail ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVenueDetailId(long venueDetailId)
		throws SystemException {
		for (VenueSubDetail venueSubDetail : findByVenueDetailId(
				venueDetailId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(venueSubDetail);
		}
	}

	/**
	 * Returns the number of venue sub details where venueDetailId = &#63;.
	 *
	 * @param venueDetailId the venue detail ID
	 * @return the number of matching venue sub details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVenueDetailId(long venueDetailId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VENUEDETAILID;

		Object[] finderArgs = new Object[] { venueDetailId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VENUESUBDETAIL_WHERE);

			query.append(_FINDER_COLUMN_VENUEDETAILID_VENUEDETAILID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(venueDetailId);

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

	private static final String _FINDER_COLUMN_VENUEDETAILID_VENUEDETAILID_2 = "venueSubDetail.venueDetailId = ?";

	public VenueSubDetailPersistenceImpl() {
		setModelClass(VenueSubDetail.class);
	}

	/**
	 * Caches the venue sub detail in the entity cache if it is enabled.
	 *
	 * @param venueSubDetail the venue sub detail
	 */
	@Override
	public void cacheResult(VenueSubDetail venueSubDetail) {
		EntityCacheUtil.putResult(VenueSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueSubDetailImpl.class, venueSubDetail.getPrimaryKey(),
			venueSubDetail);

		venueSubDetail.resetOriginalValues();
	}

	/**
	 * Caches the venue sub details in the entity cache if it is enabled.
	 *
	 * @param venueSubDetails the venue sub details
	 */
	@Override
	public void cacheResult(List<VenueSubDetail> venueSubDetails) {
		for (VenueSubDetail venueSubDetail : venueSubDetails) {
			if (EntityCacheUtil.getResult(
						VenueSubDetailModelImpl.ENTITY_CACHE_ENABLED,
						VenueSubDetailImpl.class, venueSubDetail.getPrimaryKey()) == null) {
				cacheResult(venueSubDetail);
			}
			else {
				venueSubDetail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all venue sub details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VenueSubDetailImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VenueSubDetailImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the venue sub detail.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VenueSubDetail venueSubDetail) {
		EntityCacheUtil.removeResult(VenueSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueSubDetailImpl.class, venueSubDetail.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VenueSubDetail> venueSubDetails) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VenueSubDetail venueSubDetail : venueSubDetails) {
			EntityCacheUtil.removeResult(VenueSubDetailModelImpl.ENTITY_CACHE_ENABLED,
				VenueSubDetailImpl.class, venueSubDetail.getPrimaryKey());
		}
	}

	/**
	 * Creates a new venue sub detail with the primary key. Does not add the venue sub detail to the database.
	 *
	 * @param venueSubDetailId the primary key for the new venue sub detail
	 * @return the new venue sub detail
	 */
	@Override
	public VenueSubDetail create(long venueSubDetailId) {
		VenueSubDetail venueSubDetail = new VenueSubDetailImpl();

		venueSubDetail.setNew(true);
		venueSubDetail.setPrimaryKey(venueSubDetailId);

		return venueSubDetail;
	}

	/**
	 * Removes the venue sub detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param venueSubDetailId the primary key of the venue sub detail
	 * @return the venue sub detail that was removed
	 * @throws com.rumbasolutions.flask.NoSuchVenueSubDetailException if a venue sub detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueSubDetail remove(long venueSubDetailId)
		throws NoSuchVenueSubDetailException, SystemException {
		return remove((Serializable)venueSubDetailId);
	}

	/**
	 * Removes the venue sub detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the venue sub detail
	 * @return the venue sub detail that was removed
	 * @throws com.rumbasolutions.flask.NoSuchVenueSubDetailException if a venue sub detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueSubDetail remove(Serializable primaryKey)
		throws NoSuchVenueSubDetailException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VenueSubDetail venueSubDetail = (VenueSubDetail)session.get(VenueSubDetailImpl.class,
					primaryKey);

			if (venueSubDetail == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVenueSubDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(venueSubDetail);
		}
		catch (NoSuchVenueSubDetailException nsee) {
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
	protected VenueSubDetail removeImpl(VenueSubDetail venueSubDetail)
		throws SystemException {
		venueSubDetail = toUnwrappedModel(venueSubDetail);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(venueSubDetail)) {
				venueSubDetail = (VenueSubDetail)session.get(VenueSubDetailImpl.class,
						venueSubDetail.getPrimaryKeyObj());
			}

			if (venueSubDetail != null) {
				session.delete(venueSubDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (venueSubDetail != null) {
			clearCache(venueSubDetail);
		}

		return venueSubDetail;
	}

	@Override
	public VenueSubDetail updateImpl(
		com.rumbasolutions.flask.model.VenueSubDetail venueSubDetail)
		throws SystemException {
		venueSubDetail = toUnwrappedModel(venueSubDetail);

		boolean isNew = venueSubDetail.isNew();

		VenueSubDetailModelImpl venueSubDetailModelImpl = (VenueSubDetailModelImpl)venueSubDetail;

		Session session = null;

		try {
			session = openSession();

			if (venueSubDetail.isNew()) {
				session.save(venueSubDetail);

				venueSubDetail.setNew(false);
			}
			else {
				session.merge(venueSubDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VenueSubDetailModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((venueSubDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDETAILID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						venueSubDetailModelImpl.getOriginalVenueDetailId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEDETAILID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDETAILID,
					args);

				args = new Object[] { venueSubDetailModelImpl.getVenueDetailId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEDETAILID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDETAILID,
					args);
			}
		}

		EntityCacheUtil.putResult(VenueSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			VenueSubDetailImpl.class, venueSubDetail.getPrimaryKey(),
			venueSubDetail);

		return venueSubDetail;
	}

	protected VenueSubDetail toUnwrappedModel(VenueSubDetail venueSubDetail) {
		if (venueSubDetail instanceof VenueSubDetailImpl) {
			return venueSubDetail;
		}

		VenueSubDetailImpl venueSubDetailImpl = new VenueSubDetailImpl();

		venueSubDetailImpl.setNew(venueSubDetail.isNew());
		venueSubDetailImpl.setPrimaryKey(venueSubDetail.getPrimaryKey());

		venueSubDetailImpl.setVenueSubDetailId(venueSubDetail.getVenueSubDetailId());
		venueSubDetailImpl.setVenueDetailId(venueSubDetail.getVenueDetailId());
		venueSubDetailImpl.setVenueSubDetailTitle(venueSubDetail.getVenueSubDetailTitle());
		venueSubDetailImpl.setVenueSubDetailDesc(venueSubDetail.getVenueSubDetailDesc());

		return venueSubDetailImpl;
	}

	/**
	 * Returns the venue sub detail with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the venue sub detail
	 * @return the venue sub detail
	 * @throws com.rumbasolutions.flask.NoSuchVenueSubDetailException if a venue sub detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueSubDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVenueSubDetailException, SystemException {
		VenueSubDetail venueSubDetail = fetchByPrimaryKey(primaryKey);

		if (venueSubDetail == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVenueSubDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return venueSubDetail;
	}

	/**
	 * Returns the venue sub detail with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueSubDetailException} if it could not be found.
	 *
	 * @param venueSubDetailId the primary key of the venue sub detail
	 * @return the venue sub detail
	 * @throws com.rumbasolutions.flask.NoSuchVenueSubDetailException if a venue sub detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueSubDetail findByPrimaryKey(long venueSubDetailId)
		throws NoSuchVenueSubDetailException, SystemException {
		return findByPrimaryKey((Serializable)venueSubDetailId);
	}

	/**
	 * Returns the venue sub detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the venue sub detail
	 * @return the venue sub detail, or <code>null</code> if a venue sub detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueSubDetail fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VenueSubDetail venueSubDetail = (VenueSubDetail)EntityCacheUtil.getResult(VenueSubDetailModelImpl.ENTITY_CACHE_ENABLED,
				VenueSubDetailImpl.class, primaryKey);

		if (venueSubDetail == _nullVenueSubDetail) {
			return null;
		}

		if (venueSubDetail == null) {
			Session session = null;

			try {
				session = openSession();

				venueSubDetail = (VenueSubDetail)session.get(VenueSubDetailImpl.class,
						primaryKey);

				if (venueSubDetail != null) {
					cacheResult(venueSubDetail);
				}
				else {
					EntityCacheUtil.putResult(VenueSubDetailModelImpl.ENTITY_CACHE_ENABLED,
						VenueSubDetailImpl.class, primaryKey,
						_nullVenueSubDetail);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VenueSubDetailModelImpl.ENTITY_CACHE_ENABLED,
					VenueSubDetailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return venueSubDetail;
	}

	/**
	 * Returns the venue sub detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param venueSubDetailId the primary key of the venue sub detail
	 * @return the venue sub detail, or <code>null</code> if a venue sub detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueSubDetail fetchByPrimaryKey(long venueSubDetailId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)venueSubDetailId);
	}

	/**
	 * Returns all the venue sub details.
	 *
	 * @return the venue sub details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueSubDetail> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the venue sub details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of venue sub details
	 * @param end the upper bound of the range of venue sub details (not inclusive)
	 * @return the range of venue sub details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueSubDetail> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the venue sub details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of venue sub details
	 * @param end the upper bound of the range of venue sub details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of venue sub details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueSubDetail> findAll(int start, int end,
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

		List<VenueSubDetail> list = (List<VenueSubDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VENUESUBDETAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VENUESUBDETAIL;

				if (pagination) {
					sql = sql.concat(VenueSubDetailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VenueSubDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VenueSubDetail>(list);
				}
				else {
					list = (List<VenueSubDetail>)QueryUtil.list(q,
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
	 * Removes all the venue sub details from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VenueSubDetail venueSubDetail : findAll()) {
			remove(venueSubDetail);
		}
	}

	/**
	 * Returns the number of venue sub details.
	 *
	 * @return the number of venue sub details
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

				Query q = session.createQuery(_SQL_COUNT_VENUESUBDETAIL);

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
	 * Initializes the venue sub detail persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.VenueSubDetail")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VenueSubDetail>> listenersList = new ArrayList<ModelListener<VenueSubDetail>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VenueSubDetail>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VenueSubDetailImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VENUESUBDETAIL = "SELECT venueSubDetail FROM VenueSubDetail venueSubDetail";
	private static final String _SQL_SELECT_VENUESUBDETAIL_WHERE = "SELECT venueSubDetail FROM VenueSubDetail venueSubDetail WHERE ";
	private static final String _SQL_COUNT_VENUESUBDETAIL = "SELECT COUNT(venueSubDetail) FROM VenueSubDetail venueSubDetail";
	private static final String _SQL_COUNT_VENUESUBDETAIL_WHERE = "SELECT COUNT(venueSubDetail) FROM VenueSubDetail venueSubDetail WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "venueSubDetail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VenueSubDetail exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VenueSubDetail exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VenueSubDetailPersistenceImpl.class);
	private static VenueSubDetail _nullVenueSubDetail = new VenueSubDetailImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VenueSubDetail> toCacheModel() {
				return _nullVenueSubDetailCacheModel;
			}
		};

	private static CacheModel<VenueSubDetail> _nullVenueSubDetailCacheModel = new CacheModel<VenueSubDetail>() {
			@Override
			public VenueSubDetail toEntityModel() {
				return _nullVenueSubDetail;
			}
		};
}