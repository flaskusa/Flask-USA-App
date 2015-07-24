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

import com.rumbasolutions.flask.NoSuchVenueImageException;
import com.rumbasolutions.flask.model.VenueImage;
import com.rumbasolutions.flask.model.impl.VenueImageImpl;
import com.rumbasolutions.flask.model.impl.VenueImageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the venue image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueImagePersistence
 * @see VenueImageUtil
 * @generated
 */
public class VenueImagePersistenceImpl extends BasePersistenceImpl<VenueImage>
	implements VenueImagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VenueImageUtil} to access the venue image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VenueImageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VenueImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueImageModelImpl.FINDER_CACHE_ENABLED, VenueImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VenueImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueImageModelImpl.FINDER_CACHE_ENABLED, VenueImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VenueImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VENUEID = new FinderPath(VenueImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueImageModelImpl.FINDER_CACHE_ENABLED, VenueImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByvenueId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEID =
		new FinderPath(VenueImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueImageModelImpl.FINDER_CACHE_ENABLED, VenueImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByvenueId",
			new String[] { Long.class.getName() },
			VenueImageModelImpl.VENUEID_COLUMN_BITMASK |
			VenueImageModelImpl.TITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VENUEID = new FinderPath(VenueImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByvenueId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the venue images where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @return the matching venue images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueImage> findByvenueId(long venueId)
		throws SystemException {
		return findByvenueId(venueId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the venue images where venueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueId the venue ID
	 * @param start the lower bound of the range of venue images
	 * @param end the upper bound of the range of venue images (not inclusive)
	 * @return the range of matching venue images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueImage> findByvenueId(long venueId, int start, int end)
		throws SystemException {
		return findByvenueId(venueId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the venue images where venueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueId the venue ID
	 * @param start the lower bound of the range of venue images
	 * @param end the upper bound of the range of venue images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching venue images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueImage> findByvenueId(long venueId, int start, int end,
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

		List<VenueImage> list = (List<VenueImage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VenueImage venueImage : list) {
				if ((venueId != venueImage.getVenueId())) {
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

			query.append(_SQL_SELECT_VENUEIMAGE_WHERE);

			query.append(_FINDER_COLUMN_VENUEID_VENUEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VenueImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(venueId);

				if (!pagination) {
					list = (List<VenueImage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VenueImage>(list);
				}
				else {
					list = (List<VenueImage>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first venue image in the ordered set where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue image
	 * @throws com.rumbasolutions.flask.NoSuchVenueImageException if a matching venue image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueImage findByvenueId_First(long venueId,
		OrderByComparator orderByComparator)
		throws NoSuchVenueImageException, SystemException {
		VenueImage venueImage = fetchByvenueId_First(venueId, orderByComparator);

		if (venueImage != null) {
			return venueImage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueId=");
		msg.append(venueId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueImageException(msg.toString());
	}

	/**
	 * Returns the first venue image in the ordered set where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue image, or <code>null</code> if a matching venue image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueImage fetchByvenueId_First(long venueId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VenueImage> list = findByvenueId(venueId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last venue image in the ordered set where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue image
	 * @throws com.rumbasolutions.flask.NoSuchVenueImageException if a matching venue image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueImage findByvenueId_Last(long venueId,
		OrderByComparator orderByComparator)
		throws NoSuchVenueImageException, SystemException {
		VenueImage venueImage = fetchByvenueId_Last(venueId, orderByComparator);

		if (venueImage != null) {
			return venueImage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueId=");
		msg.append(venueId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueImageException(msg.toString());
	}

	/**
	 * Returns the last venue image in the ordered set where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue image, or <code>null</code> if a matching venue image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueImage fetchByvenueId_Last(long venueId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByvenueId(venueId);

		if (count == 0) {
			return null;
		}

		List<VenueImage> list = findByvenueId(venueId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the venue images before and after the current venue image in the ordered set where venueId = &#63;.
	 *
	 * @param venueImageId the primary key of the current venue image
	 * @param venueId the venue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next venue image
	 * @throws com.rumbasolutions.flask.NoSuchVenueImageException if a venue image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueImage[] findByvenueId_PrevAndNext(long venueImageId,
		long venueId, OrderByComparator orderByComparator)
		throws NoSuchVenueImageException, SystemException {
		VenueImage venueImage = findByPrimaryKey(venueImageId);

		Session session = null;

		try {
			session = openSession();

			VenueImage[] array = new VenueImageImpl[3];

			array[0] = getByvenueId_PrevAndNext(session, venueImage, venueId,
					orderByComparator, true);

			array[1] = venueImage;

			array[2] = getByvenueId_PrevAndNext(session, venueImage, venueId,
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

	protected VenueImage getByvenueId_PrevAndNext(Session session,
		VenueImage venueImage, long venueId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENUEIMAGE_WHERE);

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
			query.append(VenueImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(venueId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(venueImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VenueImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the venue images where venueId = &#63; from the database.
	 *
	 * @param venueId the venue ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByvenueId(long venueId) throws SystemException {
		for (VenueImage venueImage : findByvenueId(venueId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(venueImage);
		}
	}

	/**
	 * Returns the number of venue images where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @return the number of matching venue images
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

			query.append(_SQL_COUNT_VENUEIMAGE_WHERE);

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

	private static final String _FINDER_COLUMN_VENUEID_VENUEID_2 = "venueImage.venueId = ?";

	public VenueImagePersistenceImpl() {
		setModelClass(VenueImage.class);
	}

	/**
	 * Caches the venue image in the entity cache if it is enabled.
	 *
	 * @param venueImage the venue image
	 */
	@Override
	public void cacheResult(VenueImage venueImage) {
		EntityCacheUtil.putResult(VenueImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueImageImpl.class, venueImage.getPrimaryKey(), venueImage);

		venueImage.resetOriginalValues();
	}

	/**
	 * Caches the venue images in the entity cache if it is enabled.
	 *
	 * @param venueImages the venue images
	 */
	@Override
	public void cacheResult(List<VenueImage> venueImages) {
		for (VenueImage venueImage : venueImages) {
			if (EntityCacheUtil.getResult(
						VenueImageModelImpl.ENTITY_CACHE_ENABLED,
						VenueImageImpl.class, venueImage.getPrimaryKey()) == null) {
				cacheResult(venueImage);
			}
			else {
				venueImage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all venue images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VenueImageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VenueImageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the venue image.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VenueImage venueImage) {
		EntityCacheUtil.removeResult(VenueImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueImageImpl.class, venueImage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VenueImage> venueImages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VenueImage venueImage : venueImages) {
			EntityCacheUtil.removeResult(VenueImageModelImpl.ENTITY_CACHE_ENABLED,
				VenueImageImpl.class, venueImage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new venue image with the primary key. Does not add the venue image to the database.
	 *
	 * @param venueImageId the primary key for the new venue image
	 * @return the new venue image
	 */
	@Override
	public VenueImage create(long venueImageId) {
		VenueImage venueImage = new VenueImageImpl();

		venueImage.setNew(true);
		venueImage.setPrimaryKey(venueImageId);

		return venueImage;
	}

	/**
	 * Removes the venue image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param venueImageId the primary key of the venue image
	 * @return the venue image that was removed
	 * @throws com.rumbasolutions.flask.NoSuchVenueImageException if a venue image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueImage remove(long venueImageId)
		throws NoSuchVenueImageException, SystemException {
		return remove((Serializable)venueImageId);
	}

	/**
	 * Removes the venue image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the venue image
	 * @return the venue image that was removed
	 * @throws com.rumbasolutions.flask.NoSuchVenueImageException if a venue image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueImage remove(Serializable primaryKey)
		throws NoSuchVenueImageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VenueImage venueImage = (VenueImage)session.get(VenueImageImpl.class,
					primaryKey);

			if (venueImage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVenueImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(venueImage);
		}
		catch (NoSuchVenueImageException nsee) {
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
	protected VenueImage removeImpl(VenueImage venueImage)
		throws SystemException {
		venueImage = toUnwrappedModel(venueImage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(venueImage)) {
				venueImage = (VenueImage)session.get(VenueImageImpl.class,
						venueImage.getPrimaryKeyObj());
			}

			if (venueImage != null) {
				session.delete(venueImage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (venueImage != null) {
			clearCache(venueImage);
		}

		return venueImage;
	}

	@Override
	public VenueImage updateImpl(
		com.rumbasolutions.flask.model.VenueImage venueImage)
		throws SystemException {
		venueImage = toUnwrappedModel(venueImage);

		boolean isNew = venueImage.isNew();

		VenueImageModelImpl venueImageModelImpl = (VenueImageModelImpl)venueImage;

		Session session = null;

		try {
			session = openSession();

			if (venueImage.isNew()) {
				session.save(venueImage);

				venueImage.setNew(false);
			}
			else {
				session.merge(venueImage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VenueImageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((venueImageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						venueImageModelImpl.getOriginalVenueId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEID,
					args);

				args = new Object[] { venueImageModelImpl.getVenueId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEID,
					args);
			}
		}

		EntityCacheUtil.putResult(VenueImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueImageImpl.class, venueImage.getPrimaryKey(), venueImage);

		return venueImage;
	}

	protected VenueImage toUnwrappedModel(VenueImage venueImage) {
		if (venueImage instanceof VenueImageImpl) {
			return venueImage;
		}

		VenueImageImpl venueImageImpl = new VenueImageImpl();

		venueImageImpl.setNew(venueImage.isNew());
		venueImageImpl.setPrimaryKey(venueImage.getPrimaryKey());

		venueImageImpl.setVenueImageId(venueImage.getVenueImageId());
		venueImageImpl.setCompanyId(venueImage.getCompanyId());
		venueImageImpl.setUserId(venueImage.getUserId());
		venueImageImpl.setCreatedDate(venueImage.getCreatedDate());
		venueImageImpl.setModifiedDate(venueImage.getModifiedDate());
		venueImageImpl.setTitle(venueImage.getTitle());
		venueImageImpl.setVenueImageUUId(venueImage.getVenueImageUUId());
		venueImageImpl.setVenueImageGroupId(venueImage.getVenueImageGroupId());
		venueImageImpl.setVenueId(venueImage.getVenueId());

		return venueImageImpl;
	}

	/**
	 * Returns the venue image with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the venue image
	 * @return the venue image
	 * @throws com.rumbasolutions.flask.NoSuchVenueImageException if a venue image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueImage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVenueImageException, SystemException {
		VenueImage venueImage = fetchByPrimaryKey(primaryKey);

		if (venueImage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVenueImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return venueImage;
	}

	/**
	 * Returns the venue image with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueImageException} if it could not be found.
	 *
	 * @param venueImageId the primary key of the venue image
	 * @return the venue image
	 * @throws com.rumbasolutions.flask.NoSuchVenueImageException if a venue image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueImage findByPrimaryKey(long venueImageId)
		throws NoSuchVenueImageException, SystemException {
		return findByPrimaryKey((Serializable)venueImageId);
	}

	/**
	 * Returns the venue image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the venue image
	 * @return the venue image, or <code>null</code> if a venue image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueImage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VenueImage venueImage = (VenueImage)EntityCacheUtil.getResult(VenueImageModelImpl.ENTITY_CACHE_ENABLED,
				VenueImageImpl.class, primaryKey);

		if (venueImage == _nullVenueImage) {
			return null;
		}

		if (venueImage == null) {
			Session session = null;

			try {
				session = openSession();

				venueImage = (VenueImage)session.get(VenueImageImpl.class,
						primaryKey);

				if (venueImage != null) {
					cacheResult(venueImage);
				}
				else {
					EntityCacheUtil.putResult(VenueImageModelImpl.ENTITY_CACHE_ENABLED,
						VenueImageImpl.class, primaryKey, _nullVenueImage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VenueImageModelImpl.ENTITY_CACHE_ENABLED,
					VenueImageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return venueImage;
	}

	/**
	 * Returns the venue image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param venueImageId the primary key of the venue image
	 * @return the venue image, or <code>null</code> if a venue image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueImage fetchByPrimaryKey(long venueImageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)venueImageId);
	}

	/**
	 * Returns all the venue images.
	 *
	 * @return the venue images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueImage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the venue images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of venue images
	 * @param end the upper bound of the range of venue images (not inclusive)
	 * @return the range of venue images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueImage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the venue images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of venue images
	 * @param end the upper bound of the range of venue images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of venue images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueImage> findAll(int start, int end,
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

		List<VenueImage> list = (List<VenueImage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VENUEIMAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VENUEIMAGE;

				if (pagination) {
					sql = sql.concat(VenueImageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VenueImage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VenueImage>(list);
				}
				else {
					list = (List<VenueImage>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the venue images from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VenueImage venueImage : findAll()) {
			remove(venueImage);
		}
	}

	/**
	 * Returns the number of venue images.
	 *
	 * @return the number of venue images
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

				Query q = session.createQuery(_SQL_COUNT_VENUEIMAGE);

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
	 * Initializes the venue image persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.VenueImage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VenueImage>> listenersList = new ArrayList<ModelListener<VenueImage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VenueImage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VenueImageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VENUEIMAGE = "SELECT venueImage FROM VenueImage venueImage";
	private static final String _SQL_SELECT_VENUEIMAGE_WHERE = "SELECT venueImage FROM VenueImage venueImage WHERE ";
	private static final String _SQL_COUNT_VENUEIMAGE = "SELECT COUNT(venueImage) FROM VenueImage venueImage";
	private static final String _SQL_COUNT_VENUEIMAGE_WHERE = "SELECT COUNT(venueImage) FROM VenueImage venueImage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "venueImage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VenueImage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VenueImage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VenueImagePersistenceImpl.class);
	private static VenueImage _nullVenueImage = new VenueImageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VenueImage> toCacheModel() {
				return _nullVenueImageCacheModel;
			}
		};

	private static CacheModel<VenueImage> _nullVenueImageCacheModel = new CacheModel<VenueImage>() {
			@Override
			public VenueImage toEntityModel() {
				return _nullVenueImage;
			}
		};
}