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

import com.rumbasolutions.flask.NoSuchVenueDetailImageException;
import com.rumbasolutions.flask.model.VenueDetailImage;
import com.rumbasolutions.flask.model.impl.VenueDetailImageImpl;
import com.rumbasolutions.flask.model.impl.VenueDetailImageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the venue detail image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueDetailImagePersistence
 * @see VenueDetailImageUtil
 * @generated
 */
public class VenueDetailImagePersistenceImpl extends BasePersistenceImpl<VenueDetailImage>
	implements VenueDetailImagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VenueDetailImageUtil} to access the venue detail image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VenueDetailImageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VenueDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailImageModelImpl.FINDER_CACHE_ENABLED,
			VenueDetailImageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VenueDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailImageModelImpl.FINDER_CACHE_ENABLED,
			VenueDetailImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VenueDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VENUEDETAILID =
		new FinderPath(VenueDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailImageModelImpl.FINDER_CACHE_ENABLED,
			VenueDetailImageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVenueDetailId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDETAILID =
		new FinderPath(VenueDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailImageModelImpl.FINDER_CACHE_ENABLED,
			VenueDetailImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVenueDetailId",
			new String[] { Long.class.getName() },
			VenueDetailImageModelImpl.VENUEDETAILID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VENUEDETAILID = new FinderPath(VenueDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVenueDetailId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the venue detail images where venueDetailId = &#63;.
	 *
	 * @param venueDetailId the venue detail ID
	 * @return the matching venue detail images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDetailImage> findByVenueDetailId(long venueDetailId)
		throws SystemException {
		return findByVenueDetailId(venueDetailId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the venue detail images where venueDetailId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueDetailId the venue detail ID
	 * @param start the lower bound of the range of venue detail images
	 * @param end the upper bound of the range of venue detail images (not inclusive)
	 * @return the range of matching venue detail images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDetailImage> findByVenueDetailId(long venueDetailId,
		int start, int end) throws SystemException {
		return findByVenueDetailId(venueDetailId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the venue detail images where venueDetailId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueDetailId the venue detail ID
	 * @param start the lower bound of the range of venue detail images
	 * @param end the upper bound of the range of venue detail images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching venue detail images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDetailImage> findByVenueDetailId(long venueDetailId,
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

		List<VenueDetailImage> list = (List<VenueDetailImage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VenueDetailImage venueDetailImage : list) {
				if ((venueDetailId != venueDetailImage.getVenueDetailId())) {
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

			query.append(_SQL_SELECT_VENUEDETAILIMAGE_WHERE);

			query.append(_FINDER_COLUMN_VENUEDETAILID_VENUEDETAILID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VenueDetailImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(venueDetailId);

				if (!pagination) {
					list = (List<VenueDetailImage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VenueDetailImage>(list);
				}
				else {
					list = (List<VenueDetailImage>)QueryUtil.list(q,
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
	 * Returns the first venue detail image in the ordered set where venueDetailId = &#63;.
	 *
	 * @param venueDetailId the venue detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue detail image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDetailImageException if a matching venue detail image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetailImage findByVenueDetailId_First(long venueDetailId,
		OrderByComparator orderByComparator)
		throws NoSuchVenueDetailImageException, SystemException {
		VenueDetailImage venueDetailImage = fetchByVenueDetailId_First(venueDetailId,
				orderByComparator);

		if (venueDetailImage != null) {
			return venueDetailImage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueDetailId=");
		msg.append(venueDetailId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueDetailImageException(msg.toString());
	}

	/**
	 * Returns the first venue detail image in the ordered set where venueDetailId = &#63;.
	 *
	 * @param venueDetailId the venue detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue detail image, or <code>null</code> if a matching venue detail image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetailImage fetchByVenueDetailId_First(long venueDetailId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VenueDetailImage> list = findByVenueDetailId(venueDetailId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last venue detail image in the ordered set where venueDetailId = &#63;.
	 *
	 * @param venueDetailId the venue detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue detail image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDetailImageException if a matching venue detail image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetailImage findByVenueDetailId_Last(long venueDetailId,
		OrderByComparator orderByComparator)
		throws NoSuchVenueDetailImageException, SystemException {
		VenueDetailImage venueDetailImage = fetchByVenueDetailId_Last(venueDetailId,
				orderByComparator);

		if (venueDetailImage != null) {
			return venueDetailImage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueDetailId=");
		msg.append(venueDetailId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueDetailImageException(msg.toString());
	}

	/**
	 * Returns the last venue detail image in the ordered set where venueDetailId = &#63;.
	 *
	 * @param venueDetailId the venue detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue detail image, or <code>null</code> if a matching venue detail image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetailImage fetchByVenueDetailId_Last(long venueDetailId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVenueDetailId(venueDetailId);

		if (count == 0) {
			return null;
		}

		List<VenueDetailImage> list = findByVenueDetailId(venueDetailId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the venue detail images before and after the current venue detail image in the ordered set where venueDetailId = &#63;.
	 *
	 * @param venueDetailImageId the primary key of the current venue detail image
	 * @param venueDetailId the venue detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next venue detail image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDetailImageException if a venue detail image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetailImage[] findByVenueDetailId_PrevAndNext(
		long venueDetailImageId, long venueDetailId,
		OrderByComparator orderByComparator)
		throws NoSuchVenueDetailImageException, SystemException {
		VenueDetailImage venueDetailImage = findByPrimaryKey(venueDetailImageId);

		Session session = null;

		try {
			session = openSession();

			VenueDetailImage[] array = new VenueDetailImageImpl[3];

			array[0] = getByVenueDetailId_PrevAndNext(session,
					venueDetailImage, venueDetailId, orderByComparator, true);

			array[1] = venueDetailImage;

			array[2] = getByVenueDetailId_PrevAndNext(session,
					venueDetailImage, venueDetailId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VenueDetailImage getByVenueDetailId_PrevAndNext(Session session,
		VenueDetailImage venueDetailImage, long venueDetailId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENUEDETAILIMAGE_WHERE);

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
			query.append(VenueDetailImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(venueDetailId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(venueDetailImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VenueDetailImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the venue detail images where venueDetailId = &#63; from the database.
	 *
	 * @param venueDetailId the venue detail ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVenueDetailId(long venueDetailId)
		throws SystemException {
		for (VenueDetailImage venueDetailImage : findByVenueDetailId(
				venueDetailId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(venueDetailImage);
		}
	}

	/**
	 * Returns the number of venue detail images where venueDetailId = &#63;.
	 *
	 * @param venueDetailId the venue detail ID
	 * @return the number of matching venue detail images
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

			query.append(_SQL_COUNT_VENUEDETAILIMAGE_WHERE);

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

	private static final String _FINDER_COLUMN_VENUEDETAILID_VENUEDETAILID_2 = "venueDetailImage.venueDetailId = ?";

	public VenueDetailImagePersistenceImpl() {
		setModelClass(VenueDetailImage.class);
	}

	/**
	 * Caches the venue detail image in the entity cache if it is enabled.
	 *
	 * @param venueDetailImage the venue detail image
	 */
	@Override
	public void cacheResult(VenueDetailImage venueDetailImage) {
		EntityCacheUtil.putResult(VenueDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailImageImpl.class, venueDetailImage.getPrimaryKey(),
			venueDetailImage);

		venueDetailImage.resetOriginalValues();
	}

	/**
	 * Caches the venue detail images in the entity cache if it is enabled.
	 *
	 * @param venueDetailImages the venue detail images
	 */
	@Override
	public void cacheResult(List<VenueDetailImage> venueDetailImages) {
		for (VenueDetailImage venueDetailImage : venueDetailImages) {
			if (EntityCacheUtil.getResult(
						VenueDetailImageModelImpl.ENTITY_CACHE_ENABLED,
						VenueDetailImageImpl.class,
						venueDetailImage.getPrimaryKey()) == null) {
				cacheResult(venueDetailImage);
			}
			else {
				venueDetailImage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all venue detail images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VenueDetailImageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VenueDetailImageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the venue detail image.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VenueDetailImage venueDetailImage) {
		EntityCacheUtil.removeResult(VenueDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailImageImpl.class, venueDetailImage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VenueDetailImage> venueDetailImages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VenueDetailImage venueDetailImage : venueDetailImages) {
			EntityCacheUtil.removeResult(VenueDetailImageModelImpl.ENTITY_CACHE_ENABLED,
				VenueDetailImageImpl.class, venueDetailImage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new venue detail image with the primary key. Does not add the venue detail image to the database.
	 *
	 * @param venueDetailImageId the primary key for the new venue detail image
	 * @return the new venue detail image
	 */
	@Override
	public VenueDetailImage create(long venueDetailImageId) {
		VenueDetailImage venueDetailImage = new VenueDetailImageImpl();

		venueDetailImage.setNew(true);
		venueDetailImage.setPrimaryKey(venueDetailImageId);

		return venueDetailImage;
	}

	/**
	 * Removes the venue detail image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param venueDetailImageId the primary key of the venue detail image
	 * @return the venue detail image that was removed
	 * @throws com.rumbasolutions.flask.NoSuchVenueDetailImageException if a venue detail image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetailImage remove(long venueDetailImageId)
		throws NoSuchVenueDetailImageException, SystemException {
		return remove((Serializable)venueDetailImageId);
	}

	/**
	 * Removes the venue detail image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the venue detail image
	 * @return the venue detail image that was removed
	 * @throws com.rumbasolutions.flask.NoSuchVenueDetailImageException if a venue detail image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetailImage remove(Serializable primaryKey)
		throws NoSuchVenueDetailImageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VenueDetailImage venueDetailImage = (VenueDetailImage)session.get(VenueDetailImageImpl.class,
					primaryKey);

			if (venueDetailImage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVenueDetailImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(venueDetailImage);
		}
		catch (NoSuchVenueDetailImageException nsee) {
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
	protected VenueDetailImage removeImpl(VenueDetailImage venueDetailImage)
		throws SystemException {
		venueDetailImage = toUnwrappedModel(venueDetailImage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(venueDetailImage)) {
				venueDetailImage = (VenueDetailImage)session.get(VenueDetailImageImpl.class,
						venueDetailImage.getPrimaryKeyObj());
			}

			if (venueDetailImage != null) {
				session.delete(venueDetailImage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (venueDetailImage != null) {
			clearCache(venueDetailImage);
		}

		return venueDetailImage;
	}

	@Override
	public VenueDetailImage updateImpl(
		com.rumbasolutions.flask.model.VenueDetailImage venueDetailImage)
		throws SystemException {
		venueDetailImage = toUnwrappedModel(venueDetailImage);

		boolean isNew = venueDetailImage.isNew();

		VenueDetailImageModelImpl venueDetailImageModelImpl = (VenueDetailImageModelImpl)venueDetailImage;

		Session session = null;

		try {
			session = openSession();

			if (venueDetailImage.isNew()) {
				session.save(venueDetailImage);

				venueDetailImage.setNew(false);
			}
			else {
				session.merge(venueDetailImage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VenueDetailImageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((venueDetailImageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDETAILID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						venueDetailImageModelImpl.getOriginalVenueDetailId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEDETAILID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDETAILID,
					args);

				args = new Object[] { venueDetailImageModelImpl.getVenueDetailId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEDETAILID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDETAILID,
					args);
			}
		}

		EntityCacheUtil.putResult(VenueDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDetailImageImpl.class, venueDetailImage.getPrimaryKey(),
			venueDetailImage);

		return venueDetailImage;
	}

	protected VenueDetailImage toUnwrappedModel(
		VenueDetailImage venueDetailImage) {
		if (venueDetailImage instanceof VenueDetailImageImpl) {
			return venueDetailImage;
		}

		VenueDetailImageImpl venueDetailImageImpl = new VenueDetailImageImpl();

		venueDetailImageImpl.setNew(venueDetailImage.isNew());
		venueDetailImageImpl.setPrimaryKey(venueDetailImage.getPrimaryKey());

		venueDetailImageImpl.setVenueDetailImageId(venueDetailImage.getVenueDetailImageId());
		venueDetailImageImpl.setCompanyId(venueDetailImage.getCompanyId());
		venueDetailImageImpl.setUserId(venueDetailImage.getUserId());
		venueDetailImageImpl.setCreatedDate(venueDetailImage.getCreatedDate());
		venueDetailImageImpl.setModifiedDate(venueDetailImage.getModifiedDate());
		venueDetailImageImpl.setVenueDetailId(venueDetailImage.getVenueDetailId());
		venueDetailImageImpl.setImageTitle(venueDetailImage.getImageTitle());
		venueDetailImageImpl.setImageDesc(venueDetailImage.getImageDesc());
		venueDetailImageImpl.setImageUUID(venueDetailImage.getImageUUID());
		venueDetailImageImpl.setImageGroupId(venueDetailImage.getImageGroupId());

		return venueDetailImageImpl;
	}

	/**
	 * Returns the venue detail image with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the venue detail image
	 * @return the venue detail image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDetailImageException if a venue detail image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetailImage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVenueDetailImageException, SystemException {
		VenueDetailImage venueDetailImage = fetchByPrimaryKey(primaryKey);

		if (venueDetailImage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVenueDetailImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return venueDetailImage;
	}

	/**
	 * Returns the venue detail image with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueDetailImageException} if it could not be found.
	 *
	 * @param venueDetailImageId the primary key of the venue detail image
	 * @return the venue detail image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDetailImageException if a venue detail image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetailImage findByPrimaryKey(long venueDetailImageId)
		throws NoSuchVenueDetailImageException, SystemException {
		return findByPrimaryKey((Serializable)venueDetailImageId);
	}

	/**
	 * Returns the venue detail image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the venue detail image
	 * @return the venue detail image, or <code>null</code> if a venue detail image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetailImage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VenueDetailImage venueDetailImage = (VenueDetailImage)EntityCacheUtil.getResult(VenueDetailImageModelImpl.ENTITY_CACHE_ENABLED,
				VenueDetailImageImpl.class, primaryKey);

		if (venueDetailImage == _nullVenueDetailImage) {
			return null;
		}

		if (venueDetailImage == null) {
			Session session = null;

			try {
				session = openSession();

				venueDetailImage = (VenueDetailImage)session.get(VenueDetailImageImpl.class,
						primaryKey);

				if (venueDetailImage != null) {
					cacheResult(venueDetailImage);
				}
				else {
					EntityCacheUtil.putResult(VenueDetailImageModelImpl.ENTITY_CACHE_ENABLED,
						VenueDetailImageImpl.class, primaryKey,
						_nullVenueDetailImage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VenueDetailImageModelImpl.ENTITY_CACHE_ENABLED,
					VenueDetailImageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return venueDetailImage;
	}

	/**
	 * Returns the venue detail image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param venueDetailImageId the primary key of the venue detail image
	 * @return the venue detail image, or <code>null</code> if a venue detail image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDetailImage fetchByPrimaryKey(long venueDetailImageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)venueDetailImageId);
	}

	/**
	 * Returns all the venue detail images.
	 *
	 * @return the venue detail images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDetailImage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the venue detail images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of venue detail images
	 * @param end the upper bound of the range of venue detail images (not inclusive)
	 * @return the range of venue detail images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDetailImage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the venue detail images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of venue detail images
	 * @param end the upper bound of the range of venue detail images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of venue detail images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDetailImage> findAll(int start, int end,
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

		List<VenueDetailImage> list = (List<VenueDetailImage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VENUEDETAILIMAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VENUEDETAILIMAGE;

				if (pagination) {
					sql = sql.concat(VenueDetailImageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VenueDetailImage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VenueDetailImage>(list);
				}
				else {
					list = (List<VenueDetailImage>)QueryUtil.list(q,
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
	 * Removes all the venue detail images from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VenueDetailImage venueDetailImage : findAll()) {
			remove(venueDetailImage);
		}
	}

	/**
	 * Returns the number of venue detail images.
	 *
	 * @return the number of venue detail images
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

				Query q = session.createQuery(_SQL_COUNT_VENUEDETAILIMAGE);

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
	 * Initializes the venue detail image persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.VenueDetailImage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VenueDetailImage>> listenersList = new ArrayList<ModelListener<VenueDetailImage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VenueDetailImage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VenueDetailImageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VENUEDETAILIMAGE = "SELECT venueDetailImage FROM VenueDetailImage venueDetailImage";
	private static final String _SQL_SELECT_VENUEDETAILIMAGE_WHERE = "SELECT venueDetailImage FROM VenueDetailImage venueDetailImage WHERE ";
	private static final String _SQL_COUNT_VENUEDETAILIMAGE = "SELECT COUNT(venueDetailImage) FROM VenueDetailImage venueDetailImage";
	private static final String _SQL_COUNT_VENUEDETAILIMAGE_WHERE = "SELECT COUNT(venueDetailImage) FROM VenueDetailImage venueDetailImage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "venueDetailImage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VenueDetailImage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VenueDetailImage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VenueDetailImagePersistenceImpl.class);
	private static VenueDetailImage _nullVenueDetailImage = new VenueDetailImageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VenueDetailImage> toCacheModel() {
				return _nullVenueDetailImageCacheModel;
			}
		};

	private static CacheModel<VenueDetailImage> _nullVenueDetailImageCacheModel = new CacheModel<VenueDetailImage>() {
			@Override
			public VenueDetailImage toEntityModel() {
				return _nullVenueDetailImage;
			}
		};
}