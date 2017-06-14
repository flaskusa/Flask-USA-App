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

import com.rumbasolutions.flask.NoSuchVenueDeviceImageException;
import com.rumbasolutions.flask.model.VenueDeviceImage;
import com.rumbasolutions.flask.model.impl.VenueDeviceImageImpl;
import com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the venue device image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueDeviceImagePersistence
 * @see VenueDeviceImageUtil
 * @generated
 */
public class VenueDeviceImagePersistenceImpl extends BasePersistenceImpl<VenueDeviceImage>
	implements VenueDeviceImagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VenueDeviceImageUtil} to access the venue device image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VenueDeviceImageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED,
			VenueDeviceImageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED,
			VenueDeviceImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VENUEID = new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED,
			VenueDeviceImageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVenueId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEID =
		new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED,
			VenueDeviceImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVenueId",
			new String[] { Long.class.getName() },
			VenueDeviceImageModelImpl.VENUEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VENUEID = new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVenueId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the venue device images where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @return the matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findByVenueId(long venueId)
		throws SystemException {
		return findByVenueId(venueId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the venue device images where venueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueId the venue ID
	 * @param start the lower bound of the range of venue device images
	 * @param end the upper bound of the range of venue device images (not inclusive)
	 * @return the range of matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findByVenueId(long venueId, int start, int end)
		throws SystemException {
		return findByVenueId(venueId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the venue device images where venueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueId the venue ID
	 * @param start the lower bound of the range of venue device images
	 * @param end the upper bound of the range of venue device images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findByVenueId(long venueId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<VenueDeviceImage> list = (List<VenueDeviceImage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VenueDeviceImage venueDeviceImage : list) {
				if ((venueId != venueDeviceImage.getVenueId())) {
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

			query.append(_SQL_SELECT_VENUEDEVICEIMAGE_WHERE);

			query.append(_FINDER_COLUMN_VENUEID_VENUEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VenueDeviceImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(venueId);

				if (!pagination) {
					list = (List<VenueDeviceImage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VenueDeviceImage>(list);
				}
				else {
					list = (List<VenueDeviceImage>)QueryUtil.list(q,
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
	 * Returns the first venue device image in the ordered set where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue device image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage findByVenueId_First(long venueId,
		OrderByComparator orderByComparator)
		throws NoSuchVenueDeviceImageException, SystemException {
		VenueDeviceImage venueDeviceImage = fetchByVenueId_First(venueId,
				orderByComparator);

		if (venueDeviceImage != null) {
			return venueDeviceImage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueId=");
		msg.append(venueId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueDeviceImageException(msg.toString());
	}

	/**
	 * Returns the first venue device image in the ordered set where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue device image, or <code>null</code> if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage fetchByVenueId_First(long venueId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VenueDeviceImage> list = findByVenueId(venueId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last venue device image in the ordered set where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue device image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage findByVenueId_Last(long venueId,
		OrderByComparator orderByComparator)
		throws NoSuchVenueDeviceImageException, SystemException {
		VenueDeviceImage venueDeviceImage = fetchByVenueId_Last(venueId,
				orderByComparator);

		if (venueDeviceImage != null) {
			return venueDeviceImage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueId=");
		msg.append(venueId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueDeviceImageException(msg.toString());
	}

	/**
	 * Returns the last venue device image in the ordered set where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue device image, or <code>null</code> if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage fetchByVenueId_Last(long venueId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVenueId(venueId);

		if (count == 0) {
			return null;
		}

		List<VenueDeviceImage> list = findByVenueId(venueId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the venue device images before and after the current venue device image in the ordered set where venueId = &#63;.
	 *
	 * @param venueDeviceImageId the primary key of the current venue device image
	 * @param venueId the venue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next venue device image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage[] findByVenueId_PrevAndNext(
		long venueDeviceImageId, long venueId,
		OrderByComparator orderByComparator)
		throws NoSuchVenueDeviceImageException, SystemException {
		VenueDeviceImage venueDeviceImage = findByPrimaryKey(venueDeviceImageId);

		Session session = null;

		try {
			session = openSession();

			VenueDeviceImage[] array = new VenueDeviceImageImpl[3];

			array[0] = getByVenueId_PrevAndNext(session, venueDeviceImage,
					venueId, orderByComparator, true);

			array[1] = venueDeviceImage;

			array[2] = getByVenueId_PrevAndNext(session, venueDeviceImage,
					venueId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VenueDeviceImage getByVenueId_PrevAndNext(Session session,
		VenueDeviceImage venueDeviceImage, long venueId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENUEDEVICEIMAGE_WHERE);

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
			query.append(VenueDeviceImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(venueId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(venueDeviceImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VenueDeviceImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the venue device images where venueId = &#63; from the database.
	 *
	 * @param venueId the venue ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVenueId(long venueId) throws SystemException {
		for (VenueDeviceImage venueDeviceImage : findByVenueId(venueId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(venueDeviceImage);
		}
	}

	/**
	 * Returns the number of venue device images where venueId = &#63;.
	 *
	 * @param venueId the venue ID
	 * @return the number of matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVenueId(long venueId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VENUEID;

		Object[] finderArgs = new Object[] { venueId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VENUEDEVICEIMAGE_WHERE);

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

	private static final String _FINDER_COLUMN_VENUEID_VENUEID_2 = "venueDeviceImage.venueId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEVICETYPE =
		new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED,
			VenueDeviceImageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDeviceType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICETYPE =
		new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED,
			VenueDeviceImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDeviceType",
			new String[] { String.class.getName() },
			VenueDeviceImageModelImpl.DEVICETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEVICETYPE = new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDeviceType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the venue device images where deviceType = &#63;.
	 *
	 * @param deviceType the device type
	 * @return the matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findByDeviceType(String deviceType)
		throws SystemException {
		return findByDeviceType(deviceType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the venue device images where deviceType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deviceType the device type
	 * @param start the lower bound of the range of venue device images
	 * @param end the upper bound of the range of venue device images (not inclusive)
	 * @return the range of matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findByDeviceType(String deviceType,
		int start, int end) throws SystemException {
		return findByDeviceType(deviceType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the venue device images where deviceType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deviceType the device type
	 * @param start the lower bound of the range of venue device images
	 * @param end the upper bound of the range of venue device images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findByDeviceType(String deviceType,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICETYPE;
			finderArgs = new Object[] { deviceType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEVICETYPE;
			finderArgs = new Object[] { deviceType, start, end, orderByComparator };
		}

		List<VenueDeviceImage> list = (List<VenueDeviceImage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VenueDeviceImage venueDeviceImage : list) {
				if (!Validator.equals(deviceType,
							venueDeviceImage.getDeviceType())) {
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

			query.append(_SQL_SELECT_VENUEDEVICEIMAGE_WHERE);

			boolean bindDeviceType = false;

			if (deviceType == null) {
				query.append(_FINDER_COLUMN_DEVICETYPE_DEVICETYPE_1);
			}
			else if (deviceType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEVICETYPE_DEVICETYPE_3);
			}
			else {
				bindDeviceType = true;

				query.append(_FINDER_COLUMN_DEVICETYPE_DEVICETYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VenueDeviceImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDeviceType) {
					qPos.add(deviceType);
				}

				if (!pagination) {
					list = (List<VenueDeviceImage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VenueDeviceImage>(list);
				}
				else {
					list = (List<VenueDeviceImage>)QueryUtil.list(q,
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
	 * Returns the first venue device image in the ordered set where deviceType = &#63;.
	 *
	 * @param deviceType the device type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue device image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage findByDeviceType_First(String deviceType,
		OrderByComparator orderByComparator)
		throws NoSuchVenueDeviceImageException, SystemException {
		VenueDeviceImage venueDeviceImage = fetchByDeviceType_First(deviceType,
				orderByComparator);

		if (venueDeviceImage != null) {
			return venueDeviceImage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deviceType=");
		msg.append(deviceType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueDeviceImageException(msg.toString());
	}

	/**
	 * Returns the first venue device image in the ordered set where deviceType = &#63;.
	 *
	 * @param deviceType the device type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue device image, or <code>null</code> if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage fetchByDeviceType_First(String deviceType,
		OrderByComparator orderByComparator) throws SystemException {
		List<VenueDeviceImage> list = findByDeviceType(deviceType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last venue device image in the ordered set where deviceType = &#63;.
	 *
	 * @param deviceType the device type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue device image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage findByDeviceType_Last(String deviceType,
		OrderByComparator orderByComparator)
		throws NoSuchVenueDeviceImageException, SystemException {
		VenueDeviceImage venueDeviceImage = fetchByDeviceType_Last(deviceType,
				orderByComparator);

		if (venueDeviceImage != null) {
			return venueDeviceImage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deviceType=");
		msg.append(deviceType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueDeviceImageException(msg.toString());
	}

	/**
	 * Returns the last venue device image in the ordered set where deviceType = &#63;.
	 *
	 * @param deviceType the device type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue device image, or <code>null</code> if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage fetchByDeviceType_Last(String deviceType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDeviceType(deviceType);

		if (count == 0) {
			return null;
		}

		List<VenueDeviceImage> list = findByDeviceType(deviceType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the venue device images before and after the current venue device image in the ordered set where deviceType = &#63;.
	 *
	 * @param venueDeviceImageId the primary key of the current venue device image
	 * @param deviceType the device type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next venue device image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage[] findByDeviceType_PrevAndNext(
		long venueDeviceImageId, String deviceType,
		OrderByComparator orderByComparator)
		throws NoSuchVenueDeviceImageException, SystemException {
		VenueDeviceImage venueDeviceImage = findByPrimaryKey(venueDeviceImageId);

		Session session = null;

		try {
			session = openSession();

			VenueDeviceImage[] array = new VenueDeviceImageImpl[3];

			array[0] = getByDeviceType_PrevAndNext(session, venueDeviceImage,
					deviceType, orderByComparator, true);

			array[1] = venueDeviceImage;

			array[2] = getByDeviceType_PrevAndNext(session, venueDeviceImage,
					deviceType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VenueDeviceImage getByDeviceType_PrevAndNext(Session session,
		VenueDeviceImage venueDeviceImage, String deviceType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENUEDEVICEIMAGE_WHERE);

		boolean bindDeviceType = false;

		if (deviceType == null) {
			query.append(_FINDER_COLUMN_DEVICETYPE_DEVICETYPE_1);
		}
		else if (deviceType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DEVICETYPE_DEVICETYPE_3);
		}
		else {
			bindDeviceType = true;

			query.append(_FINDER_COLUMN_DEVICETYPE_DEVICETYPE_2);
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
			query.append(VenueDeviceImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDeviceType) {
			qPos.add(deviceType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(venueDeviceImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VenueDeviceImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the venue device images where deviceType = &#63; from the database.
	 *
	 * @param deviceType the device type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDeviceType(String deviceType) throws SystemException {
		for (VenueDeviceImage venueDeviceImage : findByDeviceType(deviceType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(venueDeviceImage);
		}
	}

	/**
	 * Returns the number of venue device images where deviceType = &#63;.
	 *
	 * @param deviceType the device type
	 * @return the number of matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDeviceType(String deviceType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEVICETYPE;

		Object[] finderArgs = new Object[] { deviceType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VENUEDEVICEIMAGE_WHERE);

			boolean bindDeviceType = false;

			if (deviceType == null) {
				query.append(_FINDER_COLUMN_DEVICETYPE_DEVICETYPE_1);
			}
			else if (deviceType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEVICETYPE_DEVICETYPE_3);
			}
			else {
				bindDeviceType = true;

				query.append(_FINDER_COLUMN_DEVICETYPE_DEVICETYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDeviceType) {
					qPos.add(deviceType);
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

	private static final String _FINDER_COLUMN_DEVICETYPE_DEVICETYPE_1 = "venueDeviceImage.deviceType IS NULL";
	private static final String _FINDER_COLUMN_DEVICETYPE_DEVICETYPE_2 = "venueDeviceImage.deviceType = ?";
	private static final String _FINDER_COLUMN_DEVICETYPE_DEVICETYPE_3 = "(venueDeviceImage.deviceType IS NULL OR venueDeviceImage.deviceType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VENUEDEVICE =
		new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED,
			VenueDeviceImageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVenueDevice",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDEVICE =
		new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED,
			VenueDeviceImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVenueDevice",
			new String[] { Long.class.getName(), String.class.getName() },
			VenueDeviceImageModelImpl.VENUEID_COLUMN_BITMASK |
			VenueDeviceImageModelImpl.DEVICETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VENUEDEVICE = new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVenueDevice",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the venue device images where venueId = &#63; and deviceType = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param deviceType the device type
	 * @return the matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findByVenueDevice(long venueId,
		String deviceType) throws SystemException {
		return findByVenueDevice(venueId, deviceType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the venue device images where venueId = &#63; and deviceType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueId the venue ID
	 * @param deviceType the device type
	 * @param start the lower bound of the range of venue device images
	 * @param end the upper bound of the range of venue device images (not inclusive)
	 * @return the range of matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findByVenueDevice(long venueId,
		String deviceType, int start, int end) throws SystemException {
		return findByVenueDevice(venueId, deviceType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the venue device images where venueId = &#63; and deviceType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueId the venue ID
	 * @param deviceType the device type
	 * @param start the lower bound of the range of venue device images
	 * @param end the upper bound of the range of venue device images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findByVenueDevice(long venueId,
		String deviceType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDEVICE;
			finderArgs = new Object[] { venueId, deviceType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VENUEDEVICE;
			finderArgs = new Object[] {
					venueId, deviceType,
					
					start, end, orderByComparator
				};
		}

		List<VenueDeviceImage> list = (List<VenueDeviceImage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VenueDeviceImage venueDeviceImage : list) {
				if ((venueId != venueDeviceImage.getVenueId()) ||
						!Validator.equals(deviceType,
							venueDeviceImage.getDeviceType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VENUEDEVICEIMAGE_WHERE);

			query.append(_FINDER_COLUMN_VENUEDEVICE_VENUEID_2);

			boolean bindDeviceType = false;

			if (deviceType == null) {
				query.append(_FINDER_COLUMN_VENUEDEVICE_DEVICETYPE_1);
			}
			else if (deviceType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_VENUEDEVICE_DEVICETYPE_3);
			}
			else {
				bindDeviceType = true;

				query.append(_FINDER_COLUMN_VENUEDEVICE_DEVICETYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VenueDeviceImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(venueId);

				if (bindDeviceType) {
					qPos.add(deviceType);
				}

				if (!pagination) {
					list = (List<VenueDeviceImage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VenueDeviceImage>(list);
				}
				else {
					list = (List<VenueDeviceImage>)QueryUtil.list(q,
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
	 * Returns the first venue device image in the ordered set where venueId = &#63; and deviceType = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param deviceType the device type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue device image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage findByVenueDevice_First(long venueId,
		String deviceType, OrderByComparator orderByComparator)
		throws NoSuchVenueDeviceImageException, SystemException {
		VenueDeviceImage venueDeviceImage = fetchByVenueDevice_First(venueId,
				deviceType, orderByComparator);

		if (venueDeviceImage != null) {
			return venueDeviceImage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueId=");
		msg.append(venueId);

		msg.append(", deviceType=");
		msg.append(deviceType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueDeviceImageException(msg.toString());
	}

	/**
	 * Returns the first venue device image in the ordered set where venueId = &#63; and deviceType = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param deviceType the device type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue device image, or <code>null</code> if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage fetchByVenueDevice_First(long venueId,
		String deviceType, OrderByComparator orderByComparator)
		throws SystemException {
		List<VenueDeviceImage> list = findByVenueDevice(venueId, deviceType, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last venue device image in the ordered set where venueId = &#63; and deviceType = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param deviceType the device type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue device image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage findByVenueDevice_Last(long venueId,
		String deviceType, OrderByComparator orderByComparator)
		throws NoSuchVenueDeviceImageException, SystemException {
		VenueDeviceImage venueDeviceImage = fetchByVenueDevice_Last(venueId,
				deviceType, orderByComparator);

		if (venueDeviceImage != null) {
			return venueDeviceImage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueId=");
		msg.append(venueId);

		msg.append(", deviceType=");
		msg.append(deviceType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueDeviceImageException(msg.toString());
	}

	/**
	 * Returns the last venue device image in the ordered set where venueId = &#63; and deviceType = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param deviceType the device type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue device image, or <code>null</code> if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage fetchByVenueDevice_Last(long venueId,
		String deviceType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByVenueDevice(venueId, deviceType);

		if (count == 0) {
			return null;
		}

		List<VenueDeviceImage> list = findByVenueDevice(venueId, deviceType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the venue device images before and after the current venue device image in the ordered set where venueId = &#63; and deviceType = &#63;.
	 *
	 * @param venueDeviceImageId the primary key of the current venue device image
	 * @param venueId the venue ID
	 * @param deviceType the device type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next venue device image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage[] findByVenueDevice_PrevAndNext(
		long venueDeviceImageId, long venueId, String deviceType,
		OrderByComparator orderByComparator)
		throws NoSuchVenueDeviceImageException, SystemException {
		VenueDeviceImage venueDeviceImage = findByPrimaryKey(venueDeviceImageId);

		Session session = null;

		try {
			session = openSession();

			VenueDeviceImage[] array = new VenueDeviceImageImpl[3];

			array[0] = getByVenueDevice_PrevAndNext(session, venueDeviceImage,
					venueId, deviceType, orderByComparator, true);

			array[1] = venueDeviceImage;

			array[2] = getByVenueDevice_PrevAndNext(session, venueDeviceImage,
					venueId, deviceType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VenueDeviceImage getByVenueDevice_PrevAndNext(Session session,
		VenueDeviceImage venueDeviceImage, long venueId, String deviceType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENUEDEVICEIMAGE_WHERE);

		query.append(_FINDER_COLUMN_VENUEDEVICE_VENUEID_2);

		boolean bindDeviceType = false;

		if (deviceType == null) {
			query.append(_FINDER_COLUMN_VENUEDEVICE_DEVICETYPE_1);
		}
		else if (deviceType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_VENUEDEVICE_DEVICETYPE_3);
		}
		else {
			bindDeviceType = true;

			query.append(_FINDER_COLUMN_VENUEDEVICE_DEVICETYPE_2);
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
			query.append(VenueDeviceImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(venueId);

		if (bindDeviceType) {
			qPos.add(deviceType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(venueDeviceImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VenueDeviceImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the venue device images where venueId = &#63; and deviceType = &#63; from the database.
	 *
	 * @param venueId the venue ID
	 * @param deviceType the device type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVenueDevice(long venueId, String deviceType)
		throws SystemException {
		for (VenueDeviceImage venueDeviceImage : findByVenueDevice(venueId,
				deviceType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(venueDeviceImage);
		}
	}

	/**
	 * Returns the number of venue device images where venueId = &#63; and deviceType = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param deviceType the device type
	 * @return the number of matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVenueDevice(long venueId, String deviceType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VENUEDEVICE;

		Object[] finderArgs = new Object[] { venueId, deviceType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VENUEDEVICEIMAGE_WHERE);

			query.append(_FINDER_COLUMN_VENUEDEVICE_VENUEID_2);

			boolean bindDeviceType = false;

			if (deviceType == null) {
				query.append(_FINDER_COLUMN_VENUEDEVICE_DEVICETYPE_1);
			}
			else if (deviceType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_VENUEDEVICE_DEVICETYPE_3);
			}
			else {
				bindDeviceType = true;

				query.append(_FINDER_COLUMN_VENUEDEVICE_DEVICETYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(venueId);

				if (bindDeviceType) {
					qPos.add(deviceType);
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

	private static final String _FINDER_COLUMN_VENUEDEVICE_VENUEID_2 = "venueDeviceImage.venueId = ? AND ";
	private static final String _FINDER_COLUMN_VENUEDEVICE_DEVICETYPE_1 = "venueDeviceImage.deviceType IS NULL";
	private static final String _FINDER_COLUMN_VENUEDEVICE_DEVICETYPE_2 = "venueDeviceImage.deviceType = ?";
	private static final String _FINDER_COLUMN_VENUEDEVICE_DEVICETYPE_3 = "(venueDeviceImage.deviceType IS NULL OR venueDeviceImage.deviceType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VENUEDETAILIMAGEID =
		new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED,
			VenueDeviceImageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVenueDetailImageId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDETAILIMAGEID =
		new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED,
			VenueDeviceImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVenueDetailImageId", new String[] { Long.class.getName() },
			VenueDeviceImageModelImpl.VENUEDETAILIMAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VENUEDETAILIMAGEID = new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVenueDetailImageId", new String[] { Long.class.getName() });

	/**
	 * Returns all the venue device images where venueDetailImageId = &#63;.
	 *
	 * @param venueDetailImageId the venue detail image ID
	 * @return the matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findByVenueDetailImageId(
		long venueDetailImageId) throws SystemException {
		return findByVenueDetailImageId(venueDetailImageId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the venue device images where venueDetailImageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueDetailImageId the venue detail image ID
	 * @param start the lower bound of the range of venue device images
	 * @param end the upper bound of the range of venue device images (not inclusive)
	 * @return the range of matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findByVenueDetailImageId(
		long venueDetailImageId, int start, int end) throws SystemException {
		return findByVenueDetailImageId(venueDetailImageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the venue device images where venueDetailImageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueDetailImageId the venue detail image ID
	 * @param start the lower bound of the range of venue device images
	 * @param end the upper bound of the range of venue device images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findByVenueDetailImageId(
		long venueDetailImageId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDETAILIMAGEID;
			finderArgs = new Object[] { venueDetailImageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VENUEDETAILIMAGEID;
			finderArgs = new Object[] {
					venueDetailImageId,
					
					start, end, orderByComparator
				};
		}

		List<VenueDeviceImage> list = (List<VenueDeviceImage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VenueDeviceImage venueDeviceImage : list) {
				if ((venueDetailImageId != venueDeviceImage.getVenueDetailImageId())) {
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

			query.append(_SQL_SELECT_VENUEDEVICEIMAGE_WHERE);

			query.append(_FINDER_COLUMN_VENUEDETAILIMAGEID_VENUEDETAILIMAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VenueDeviceImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(venueDetailImageId);

				if (!pagination) {
					list = (List<VenueDeviceImage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VenueDeviceImage>(list);
				}
				else {
					list = (List<VenueDeviceImage>)QueryUtil.list(q,
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
	 * Returns the first venue device image in the ordered set where venueDetailImageId = &#63;.
	 *
	 * @param venueDetailImageId the venue detail image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue device image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage findByVenueDetailImageId_First(
		long venueDetailImageId, OrderByComparator orderByComparator)
		throws NoSuchVenueDeviceImageException, SystemException {
		VenueDeviceImage venueDeviceImage = fetchByVenueDetailImageId_First(venueDetailImageId,
				orderByComparator);

		if (venueDeviceImage != null) {
			return venueDeviceImage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueDetailImageId=");
		msg.append(venueDetailImageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueDeviceImageException(msg.toString());
	}

	/**
	 * Returns the first venue device image in the ordered set where venueDetailImageId = &#63;.
	 *
	 * @param venueDetailImageId the venue detail image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue device image, or <code>null</code> if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage fetchByVenueDetailImageId_First(
		long venueDetailImageId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VenueDeviceImage> list = findByVenueDetailImageId(venueDetailImageId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last venue device image in the ordered set where venueDetailImageId = &#63;.
	 *
	 * @param venueDetailImageId the venue detail image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue device image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage findByVenueDetailImageId_Last(
		long venueDetailImageId, OrderByComparator orderByComparator)
		throws NoSuchVenueDeviceImageException, SystemException {
		VenueDeviceImage venueDeviceImage = fetchByVenueDetailImageId_Last(venueDetailImageId,
				orderByComparator);

		if (venueDeviceImage != null) {
			return venueDeviceImage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueDetailImageId=");
		msg.append(venueDetailImageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueDeviceImageException(msg.toString());
	}

	/**
	 * Returns the last venue device image in the ordered set where venueDetailImageId = &#63;.
	 *
	 * @param venueDetailImageId the venue detail image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue device image, or <code>null</code> if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage fetchByVenueDetailImageId_Last(
		long venueDetailImageId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByVenueDetailImageId(venueDetailImageId);

		if (count == 0) {
			return null;
		}

		List<VenueDeviceImage> list = findByVenueDetailImageId(venueDetailImageId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the venue device images before and after the current venue device image in the ordered set where venueDetailImageId = &#63;.
	 *
	 * @param venueDeviceImageId the primary key of the current venue device image
	 * @param venueDetailImageId the venue detail image ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next venue device image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage[] findByVenueDetailImageId_PrevAndNext(
		long venueDeviceImageId, long venueDetailImageId,
		OrderByComparator orderByComparator)
		throws NoSuchVenueDeviceImageException, SystemException {
		VenueDeviceImage venueDeviceImage = findByPrimaryKey(venueDeviceImageId);

		Session session = null;

		try {
			session = openSession();

			VenueDeviceImage[] array = new VenueDeviceImageImpl[3];

			array[0] = getByVenueDetailImageId_PrevAndNext(session,
					venueDeviceImage, venueDetailImageId, orderByComparator,
					true);

			array[1] = venueDeviceImage;

			array[2] = getByVenueDetailImageId_PrevAndNext(session,
					venueDeviceImage, venueDetailImageId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VenueDeviceImage getByVenueDetailImageId_PrevAndNext(
		Session session, VenueDeviceImage venueDeviceImage,
		long venueDetailImageId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENUEDEVICEIMAGE_WHERE);

		query.append(_FINDER_COLUMN_VENUEDETAILIMAGEID_VENUEDETAILIMAGEID_2);

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
			query.append(VenueDeviceImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(venueDetailImageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(venueDeviceImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VenueDeviceImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the venue device images where venueDetailImageId = &#63; from the database.
	 *
	 * @param venueDetailImageId the venue detail image ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVenueDetailImageId(long venueDetailImageId)
		throws SystemException {
		for (VenueDeviceImage venueDeviceImage : findByVenueDetailImageId(
				venueDetailImageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(venueDeviceImage);
		}
	}

	/**
	 * Returns the number of venue device images where venueDetailImageId = &#63;.
	 *
	 * @param venueDetailImageId the venue detail image ID
	 * @return the number of matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVenueDetailImageId(long venueDetailImageId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VENUEDETAILIMAGEID;

		Object[] finderArgs = new Object[] { venueDetailImageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VENUEDEVICEIMAGE_WHERE);

			query.append(_FINDER_COLUMN_VENUEDETAILIMAGEID_VENUEDETAILIMAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(venueDetailImageId);

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

	private static final String _FINDER_COLUMN_VENUEDETAILIMAGEID_VENUEDETAILIMAGEID_2 =
		"venueDeviceImage.venueDetailImageId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VENUERATIO =
		new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED,
			VenueDeviceImageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVenueRatio",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUERATIO =
		new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED,
			VenueDeviceImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVenueRatio",
			new String[] { Long.class.getName(), String.class.getName() },
			VenueDeviceImageModelImpl.VENUEID_COLUMN_BITMASK |
			VenueDeviceImageModelImpl.ASPECTRATIO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VENUERATIO = new FinderPath(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVenueRatio",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the venue device images where venueId = &#63; and aspectRatio = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param aspectRatio the aspect ratio
	 * @return the matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findByVenueRatio(long venueId,
		String aspectRatio) throws SystemException {
		return findByVenueRatio(venueId, aspectRatio, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the venue device images where venueId = &#63; and aspectRatio = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueId the venue ID
	 * @param aspectRatio the aspect ratio
	 * @param start the lower bound of the range of venue device images
	 * @param end the upper bound of the range of venue device images (not inclusive)
	 * @return the range of matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findByVenueRatio(long venueId,
		String aspectRatio, int start, int end) throws SystemException {
		return findByVenueRatio(venueId, aspectRatio, start, end, null);
	}

	/**
	 * Returns an ordered range of all the venue device images where venueId = &#63; and aspectRatio = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueId the venue ID
	 * @param aspectRatio the aspect ratio
	 * @param start the lower bound of the range of venue device images
	 * @param end the upper bound of the range of venue device images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findByVenueRatio(long venueId,
		String aspectRatio, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUERATIO;
			finderArgs = new Object[] { venueId, aspectRatio };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VENUERATIO;
			finderArgs = new Object[] {
					venueId, aspectRatio,
					
					start, end, orderByComparator
				};
		}

		List<VenueDeviceImage> list = (List<VenueDeviceImage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VenueDeviceImage venueDeviceImage : list) {
				if ((venueId != venueDeviceImage.getVenueId()) ||
						!Validator.equals(aspectRatio,
							venueDeviceImage.getAspectRatio())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VENUEDEVICEIMAGE_WHERE);

			query.append(_FINDER_COLUMN_VENUERATIO_VENUEID_2);

			boolean bindAspectRatio = false;

			if (aspectRatio == null) {
				query.append(_FINDER_COLUMN_VENUERATIO_ASPECTRATIO_1);
			}
			else if (aspectRatio.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_VENUERATIO_ASPECTRATIO_3);
			}
			else {
				bindAspectRatio = true;

				query.append(_FINDER_COLUMN_VENUERATIO_ASPECTRATIO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VenueDeviceImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(venueId);

				if (bindAspectRatio) {
					qPos.add(aspectRatio);
				}

				if (!pagination) {
					list = (List<VenueDeviceImage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VenueDeviceImage>(list);
				}
				else {
					list = (List<VenueDeviceImage>)QueryUtil.list(q,
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
	 * Returns the first venue device image in the ordered set where venueId = &#63; and aspectRatio = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param aspectRatio the aspect ratio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue device image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage findByVenueRatio_First(long venueId,
		String aspectRatio, OrderByComparator orderByComparator)
		throws NoSuchVenueDeviceImageException, SystemException {
		VenueDeviceImage venueDeviceImage = fetchByVenueRatio_First(venueId,
				aspectRatio, orderByComparator);

		if (venueDeviceImage != null) {
			return venueDeviceImage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueId=");
		msg.append(venueId);

		msg.append(", aspectRatio=");
		msg.append(aspectRatio);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueDeviceImageException(msg.toString());
	}

	/**
	 * Returns the first venue device image in the ordered set where venueId = &#63; and aspectRatio = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param aspectRatio the aspect ratio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue device image, or <code>null</code> if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage fetchByVenueRatio_First(long venueId,
		String aspectRatio, OrderByComparator orderByComparator)
		throws SystemException {
		List<VenueDeviceImage> list = findByVenueRatio(venueId, aspectRatio, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last venue device image in the ordered set where venueId = &#63; and aspectRatio = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param aspectRatio the aspect ratio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue device image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage findByVenueRatio_Last(long venueId,
		String aspectRatio, OrderByComparator orderByComparator)
		throws NoSuchVenueDeviceImageException, SystemException {
		VenueDeviceImage venueDeviceImage = fetchByVenueRatio_Last(venueId,
				aspectRatio, orderByComparator);

		if (venueDeviceImage != null) {
			return venueDeviceImage;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueId=");
		msg.append(venueId);

		msg.append(", aspectRatio=");
		msg.append(aspectRatio);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueDeviceImageException(msg.toString());
	}

	/**
	 * Returns the last venue device image in the ordered set where venueId = &#63; and aspectRatio = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param aspectRatio the aspect ratio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue device image, or <code>null</code> if a matching venue device image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage fetchByVenueRatio_Last(long venueId,
		String aspectRatio, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByVenueRatio(venueId, aspectRatio);

		if (count == 0) {
			return null;
		}

		List<VenueDeviceImage> list = findByVenueRatio(venueId, aspectRatio,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the venue device images before and after the current venue device image in the ordered set where venueId = &#63; and aspectRatio = &#63;.
	 *
	 * @param venueDeviceImageId the primary key of the current venue device image
	 * @param venueId the venue ID
	 * @param aspectRatio the aspect ratio
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next venue device image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage[] findByVenueRatio_PrevAndNext(
		long venueDeviceImageId, long venueId, String aspectRatio,
		OrderByComparator orderByComparator)
		throws NoSuchVenueDeviceImageException, SystemException {
		VenueDeviceImage venueDeviceImage = findByPrimaryKey(venueDeviceImageId);

		Session session = null;

		try {
			session = openSession();

			VenueDeviceImage[] array = new VenueDeviceImageImpl[3];

			array[0] = getByVenueRatio_PrevAndNext(session, venueDeviceImage,
					venueId, aspectRatio, orderByComparator, true);

			array[1] = venueDeviceImage;

			array[2] = getByVenueRatio_PrevAndNext(session, venueDeviceImage,
					venueId, aspectRatio, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VenueDeviceImage getByVenueRatio_PrevAndNext(Session session,
		VenueDeviceImage venueDeviceImage, long venueId, String aspectRatio,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENUEDEVICEIMAGE_WHERE);

		query.append(_FINDER_COLUMN_VENUERATIO_VENUEID_2);

		boolean bindAspectRatio = false;

		if (aspectRatio == null) {
			query.append(_FINDER_COLUMN_VENUERATIO_ASPECTRATIO_1);
		}
		else if (aspectRatio.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_VENUERATIO_ASPECTRATIO_3);
		}
		else {
			bindAspectRatio = true;

			query.append(_FINDER_COLUMN_VENUERATIO_ASPECTRATIO_2);
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
			query.append(VenueDeviceImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(venueId);

		if (bindAspectRatio) {
			qPos.add(aspectRatio);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(venueDeviceImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VenueDeviceImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the venue device images where venueId = &#63; and aspectRatio = &#63; from the database.
	 *
	 * @param venueId the venue ID
	 * @param aspectRatio the aspect ratio
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVenueRatio(long venueId, String aspectRatio)
		throws SystemException {
		for (VenueDeviceImage venueDeviceImage : findByVenueRatio(venueId,
				aspectRatio, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(venueDeviceImage);
		}
	}

	/**
	 * Returns the number of venue device images where venueId = &#63; and aspectRatio = &#63;.
	 *
	 * @param venueId the venue ID
	 * @param aspectRatio the aspect ratio
	 * @return the number of matching venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVenueRatio(long venueId, String aspectRatio)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VENUERATIO;

		Object[] finderArgs = new Object[] { venueId, aspectRatio };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VENUEDEVICEIMAGE_WHERE);

			query.append(_FINDER_COLUMN_VENUERATIO_VENUEID_2);

			boolean bindAspectRatio = false;

			if (aspectRatio == null) {
				query.append(_FINDER_COLUMN_VENUERATIO_ASPECTRATIO_1);
			}
			else if (aspectRatio.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_VENUERATIO_ASPECTRATIO_3);
			}
			else {
				bindAspectRatio = true;

				query.append(_FINDER_COLUMN_VENUERATIO_ASPECTRATIO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(venueId);

				if (bindAspectRatio) {
					qPos.add(aspectRatio);
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

	private static final String _FINDER_COLUMN_VENUERATIO_VENUEID_2 = "venueDeviceImage.venueId = ? AND ";
	private static final String _FINDER_COLUMN_VENUERATIO_ASPECTRATIO_1 = "venueDeviceImage.aspectRatio IS NULL";
	private static final String _FINDER_COLUMN_VENUERATIO_ASPECTRATIO_2 = "venueDeviceImage.aspectRatio = ?";
	private static final String _FINDER_COLUMN_VENUERATIO_ASPECTRATIO_3 = "(venueDeviceImage.aspectRatio IS NULL OR venueDeviceImage.aspectRatio = '')";

	public VenueDeviceImagePersistenceImpl() {
		setModelClass(VenueDeviceImage.class);
	}

	/**
	 * Caches the venue device image in the entity cache if it is enabled.
	 *
	 * @param venueDeviceImage the venue device image
	 */
	@Override
	public void cacheResult(VenueDeviceImage venueDeviceImage) {
		EntityCacheUtil.putResult(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageImpl.class, venueDeviceImage.getPrimaryKey(),
			venueDeviceImage);

		venueDeviceImage.resetOriginalValues();
	}

	/**
	 * Caches the venue device images in the entity cache if it is enabled.
	 *
	 * @param venueDeviceImages the venue device images
	 */
	@Override
	public void cacheResult(List<VenueDeviceImage> venueDeviceImages) {
		for (VenueDeviceImage venueDeviceImage : venueDeviceImages) {
			if (EntityCacheUtil.getResult(
						VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
						VenueDeviceImageImpl.class,
						venueDeviceImage.getPrimaryKey()) == null) {
				cacheResult(venueDeviceImage);
			}
			else {
				venueDeviceImage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all venue device images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VenueDeviceImageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VenueDeviceImageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the venue device image.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VenueDeviceImage venueDeviceImage) {
		EntityCacheUtil.removeResult(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageImpl.class, venueDeviceImage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VenueDeviceImage> venueDeviceImages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VenueDeviceImage venueDeviceImage : venueDeviceImages) {
			EntityCacheUtil.removeResult(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
				VenueDeviceImageImpl.class, venueDeviceImage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new venue device image with the primary key. Does not add the venue device image to the database.
	 *
	 * @param venueDeviceImageId the primary key for the new venue device image
	 * @return the new venue device image
	 */
	@Override
	public VenueDeviceImage create(long venueDeviceImageId) {
		VenueDeviceImage venueDeviceImage = new VenueDeviceImageImpl();

		venueDeviceImage.setNew(true);
		venueDeviceImage.setPrimaryKey(venueDeviceImageId);

		return venueDeviceImage;
	}

	/**
	 * Removes the venue device image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param venueDeviceImageId the primary key of the venue device image
	 * @return the venue device image that was removed
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage remove(long venueDeviceImageId)
		throws NoSuchVenueDeviceImageException, SystemException {
		return remove((Serializable)venueDeviceImageId);
	}

	/**
	 * Removes the venue device image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the venue device image
	 * @return the venue device image that was removed
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage remove(Serializable primaryKey)
		throws NoSuchVenueDeviceImageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VenueDeviceImage venueDeviceImage = (VenueDeviceImage)session.get(VenueDeviceImageImpl.class,
					primaryKey);

			if (venueDeviceImage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVenueDeviceImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(venueDeviceImage);
		}
		catch (NoSuchVenueDeviceImageException nsee) {
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
	protected VenueDeviceImage removeImpl(VenueDeviceImage venueDeviceImage)
		throws SystemException {
		venueDeviceImage = toUnwrappedModel(venueDeviceImage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(venueDeviceImage)) {
				venueDeviceImage = (VenueDeviceImage)session.get(VenueDeviceImageImpl.class,
						venueDeviceImage.getPrimaryKeyObj());
			}

			if (venueDeviceImage != null) {
				session.delete(venueDeviceImage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (venueDeviceImage != null) {
			clearCache(venueDeviceImage);
		}

		return venueDeviceImage;
	}

	@Override
	public VenueDeviceImage updateImpl(
		com.rumbasolutions.flask.model.VenueDeviceImage venueDeviceImage)
		throws SystemException {
		venueDeviceImage = toUnwrappedModel(venueDeviceImage);

		boolean isNew = venueDeviceImage.isNew();

		VenueDeviceImageModelImpl venueDeviceImageModelImpl = (VenueDeviceImageModelImpl)venueDeviceImage;

		Session session = null;

		try {
			session = openSession();

			if (venueDeviceImage.isNew()) {
				session.save(venueDeviceImage);

				venueDeviceImage.setNew(false);
			}
			else {
				session.merge(venueDeviceImage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VenueDeviceImageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((venueDeviceImageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						venueDeviceImageModelImpl.getOriginalVenueId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEID,
					args);

				args = new Object[] { venueDeviceImageModelImpl.getVenueId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEID,
					args);
			}

			if ((venueDeviceImageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						venueDeviceImageModelImpl.getOriginalDeviceType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEVICETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICETYPE,
					args);

				args = new Object[] { venueDeviceImageModelImpl.getDeviceType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEVICETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICETYPE,
					args);
			}

			if ((venueDeviceImageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDEVICE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						venueDeviceImageModelImpl.getOriginalVenueId(),
						venueDeviceImageModelImpl.getOriginalDeviceType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEDEVICE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDEVICE,
					args);

				args = new Object[] {
						venueDeviceImageModelImpl.getVenueId(),
						venueDeviceImageModelImpl.getDeviceType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEDEVICE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDEVICE,
					args);
			}

			if ((venueDeviceImageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDETAILIMAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						venueDeviceImageModelImpl.getOriginalVenueDetailImageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEDETAILIMAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDETAILIMAGEID,
					args);

				args = new Object[] {
						venueDeviceImageModelImpl.getVenueDetailImageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEDETAILIMAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEDETAILIMAGEID,
					args);
			}

			if ((venueDeviceImageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUERATIO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						venueDeviceImageModelImpl.getOriginalVenueId(),
						venueDeviceImageModelImpl.getOriginalAspectRatio()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUERATIO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUERATIO,
					args);

				args = new Object[] {
						venueDeviceImageModelImpl.getVenueId(),
						venueDeviceImageModelImpl.getAspectRatio()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUERATIO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUERATIO,
					args);
			}
		}

		EntityCacheUtil.putResult(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
			VenueDeviceImageImpl.class, venueDeviceImage.getPrimaryKey(),
			venueDeviceImage);

		return venueDeviceImage;
	}

	protected VenueDeviceImage toUnwrappedModel(
		VenueDeviceImage venueDeviceImage) {
		if (venueDeviceImage instanceof VenueDeviceImageImpl) {
			return venueDeviceImage;
		}

		VenueDeviceImageImpl venueDeviceImageImpl = new VenueDeviceImageImpl();

		venueDeviceImageImpl.setNew(venueDeviceImage.isNew());
		venueDeviceImageImpl.setPrimaryKey(venueDeviceImage.getPrimaryKey());

		venueDeviceImageImpl.setVenueDeviceImageId(venueDeviceImage.getVenueDeviceImageId());
		venueDeviceImageImpl.setVenueDetailImageId(venueDeviceImage.getVenueDetailImageId());
		venueDeviceImageImpl.setVenueId(venueDeviceImage.getVenueId());
		venueDeviceImageImpl.setDeviceType(venueDeviceImage.getDeviceType());
		venueDeviceImageImpl.setVenueDeviceImageUUID(venueDeviceImage.getVenueDeviceImageUUID());
		venueDeviceImageImpl.setAspectRatio(venueDeviceImage.getAspectRatio());

		return venueDeviceImageImpl;
	}

	/**
	 * Returns the venue device image with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the venue device image
	 * @return the venue device image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVenueDeviceImageException, SystemException {
		VenueDeviceImage venueDeviceImage = fetchByPrimaryKey(primaryKey);

		if (venueDeviceImage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVenueDeviceImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return venueDeviceImage;
	}

	/**
	 * Returns the venue device image with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueDeviceImageException} if it could not be found.
	 *
	 * @param venueDeviceImageId the primary key of the venue device image
	 * @return the venue device image
	 * @throws com.rumbasolutions.flask.NoSuchVenueDeviceImageException if a venue device image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage findByPrimaryKey(long venueDeviceImageId)
		throws NoSuchVenueDeviceImageException, SystemException {
		return findByPrimaryKey((Serializable)venueDeviceImageId);
	}

	/**
	 * Returns the venue device image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the venue device image
	 * @return the venue device image, or <code>null</code> if a venue device image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VenueDeviceImage venueDeviceImage = (VenueDeviceImage)EntityCacheUtil.getResult(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
				VenueDeviceImageImpl.class, primaryKey);

		if (venueDeviceImage == _nullVenueDeviceImage) {
			return null;
		}

		if (venueDeviceImage == null) {
			Session session = null;

			try {
				session = openSession();

				venueDeviceImage = (VenueDeviceImage)session.get(VenueDeviceImageImpl.class,
						primaryKey);

				if (venueDeviceImage != null) {
					cacheResult(venueDeviceImage);
				}
				else {
					EntityCacheUtil.putResult(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
						VenueDeviceImageImpl.class, primaryKey,
						_nullVenueDeviceImage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VenueDeviceImageModelImpl.ENTITY_CACHE_ENABLED,
					VenueDeviceImageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return venueDeviceImage;
	}

	/**
	 * Returns the venue device image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param venueDeviceImageId the primary key of the venue device image
	 * @return the venue device image, or <code>null</code> if a venue device image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VenueDeviceImage fetchByPrimaryKey(long venueDeviceImageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)venueDeviceImageId);
	}

	/**
	 * Returns all the venue device images.
	 *
	 * @return the venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the venue device images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of venue device images
	 * @param end the upper bound of the range of venue device images (not inclusive)
	 * @return the range of venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the venue device images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDeviceImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of venue device images
	 * @param end the upper bound of the range of venue device images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of venue device images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VenueDeviceImage> findAll(int start, int end,
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

		List<VenueDeviceImage> list = (List<VenueDeviceImage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VENUEDEVICEIMAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VENUEDEVICEIMAGE;

				if (pagination) {
					sql = sql.concat(VenueDeviceImageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VenueDeviceImage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VenueDeviceImage>(list);
				}
				else {
					list = (List<VenueDeviceImage>)QueryUtil.list(q,
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
	 * Removes all the venue device images from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VenueDeviceImage venueDeviceImage : findAll()) {
			remove(venueDeviceImage);
		}
	}

	/**
	 * Returns the number of venue device images.
	 *
	 * @return the number of venue device images
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

				Query q = session.createQuery(_SQL_COUNT_VENUEDEVICEIMAGE);

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
	 * Initializes the venue device image persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.VenueDeviceImage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VenueDeviceImage>> listenersList = new ArrayList<ModelListener<VenueDeviceImage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VenueDeviceImage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VenueDeviceImageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VENUEDEVICEIMAGE = "SELECT venueDeviceImage FROM VenueDeviceImage venueDeviceImage";
	private static final String _SQL_SELECT_VENUEDEVICEIMAGE_WHERE = "SELECT venueDeviceImage FROM VenueDeviceImage venueDeviceImage WHERE ";
	private static final String _SQL_COUNT_VENUEDEVICEIMAGE = "SELECT COUNT(venueDeviceImage) FROM VenueDeviceImage venueDeviceImage";
	private static final String _SQL_COUNT_VENUEDEVICEIMAGE_WHERE = "SELECT COUNT(venueDeviceImage) FROM VenueDeviceImage venueDeviceImage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "venueDeviceImage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VenueDeviceImage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VenueDeviceImage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VenueDeviceImagePersistenceImpl.class);
	private static VenueDeviceImage _nullVenueDeviceImage = new VenueDeviceImageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VenueDeviceImage> toCacheModel() {
				return _nullVenueDeviceImageCacheModel;
			}
		};

	private static CacheModel<VenueDeviceImage> _nullVenueDeviceImageCacheModel = new CacheModel<VenueDeviceImage>() {
			@Override
			public VenueDeviceImage toEntityModel() {
				return _nullVenueDeviceImage;
			}
		};
}