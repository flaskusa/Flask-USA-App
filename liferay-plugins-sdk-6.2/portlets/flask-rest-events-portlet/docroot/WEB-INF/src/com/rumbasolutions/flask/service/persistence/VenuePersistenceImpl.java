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

import com.rumbasolutions.flask.NoSuchVenueException;
import com.rumbasolutions.flask.model.Venue;
import com.rumbasolutions.flask.model.impl.VenueImpl;
import com.rumbasolutions.flask.model.impl.VenueModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the venue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenuePersistence
 * @see VenueUtil
 * @generated
 */
public class VenuePersistenceImpl extends BasePersistenceImpl<Venue>
	implements VenuePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VenueUtil} to access the venue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VenueImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VenueModelImpl.ENTITY_CACHE_ENABLED,
			VenueModelImpl.FINDER_CACHE_ENABLED, VenueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VenueModelImpl.ENTITY_CACHE_ENABLED,
			VenueModelImpl.FINDER_CACHE_ENABLED, VenueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VenueModelImpl.ENTITY_CACHE_ENABLED,
			VenueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VENUEMETROAREA =
		new FinderPath(VenueModelImpl.ENTITY_CACHE_ENABLED,
			VenueModelImpl.FINDER_CACHE_ENABLED, VenueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVenueMetroArea",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEMETROAREA =
		new FinderPath(VenueModelImpl.ENTITY_CACHE_ENABLED,
			VenueModelImpl.FINDER_CACHE_ENABLED, VenueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVenueMetroArea",
			new String[] { String.class.getName() },
			VenueModelImpl.VENUEMETROAREA_COLUMN_BITMASK |
			VenueModelImpl.VENUENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VENUEMETROAREA = new FinderPath(VenueModelImpl.ENTITY_CACHE_ENABLED,
			VenueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVenueMetroArea",
			new String[] { String.class.getName() });

	/**
	 * Returns all the venues where venueMetroArea = &#63;.
	 *
	 * @param venueMetroArea the venue metro area
	 * @return the matching venues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Venue> findByVenueMetroArea(String venueMetroArea)
		throws SystemException {
		return findByVenueMetroArea(venueMetroArea, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the venues where venueMetroArea = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueMetroArea the venue metro area
	 * @param start the lower bound of the range of venues
	 * @param end the upper bound of the range of venues (not inclusive)
	 * @return the range of matching venues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Venue> findByVenueMetroArea(String venueMetroArea, int start,
		int end) throws SystemException {
		return findByVenueMetroArea(venueMetroArea, start, end, null);
	}

	/**
	 * Returns an ordered range of all the venues where venueMetroArea = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueMetroArea the venue metro area
	 * @param start the lower bound of the range of venues
	 * @param end the upper bound of the range of venues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching venues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Venue> findByVenueMetroArea(String venueMetroArea, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEMETROAREA;
			finderArgs = new Object[] { venueMetroArea };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VENUEMETROAREA;
			finderArgs = new Object[] {
					venueMetroArea,
					
					start, end, orderByComparator
				};
		}

		List<Venue> list = (List<Venue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Venue venue : list) {
				if (!Validator.equals(venueMetroArea, venue.getVenueMetroArea())) {
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

			query.append(_SQL_SELECT_VENUE_WHERE);

			boolean bindVenueMetroArea = false;

			if (venueMetroArea == null) {
				query.append(_FINDER_COLUMN_VENUEMETROAREA_VENUEMETROAREA_1);
			}
			else if (venueMetroArea.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_VENUEMETROAREA_VENUEMETROAREA_3);
			}
			else {
				bindVenueMetroArea = true;

				query.append(_FINDER_COLUMN_VENUEMETROAREA_VENUEMETROAREA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VenueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindVenueMetroArea) {
					qPos.add(venueMetroArea);
				}

				if (!pagination) {
					list = (List<Venue>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Venue>(list);
				}
				else {
					list = (List<Venue>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first venue in the ordered set where venueMetroArea = &#63;.
	 *
	 * @param venueMetroArea the venue metro area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue
	 * @throws com.rumbasolutions.flask.NoSuchVenueException if a matching venue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Venue findByVenueMetroArea_First(String venueMetroArea,
		OrderByComparator orderByComparator)
		throws NoSuchVenueException, SystemException {
		Venue venue = fetchByVenueMetroArea_First(venueMetroArea,
				orderByComparator);

		if (venue != null) {
			return venue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueMetroArea=");
		msg.append(venueMetroArea);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueException(msg.toString());
	}

	/**
	 * Returns the first venue in the ordered set where venueMetroArea = &#63;.
	 *
	 * @param venueMetroArea the venue metro area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue, or <code>null</code> if a matching venue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Venue fetchByVenueMetroArea_First(String venueMetroArea,
		OrderByComparator orderByComparator) throws SystemException {
		List<Venue> list = findByVenueMetroArea(venueMetroArea, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last venue in the ordered set where venueMetroArea = &#63;.
	 *
	 * @param venueMetroArea the venue metro area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue
	 * @throws com.rumbasolutions.flask.NoSuchVenueException if a matching venue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Venue findByVenueMetroArea_Last(String venueMetroArea,
		OrderByComparator orderByComparator)
		throws NoSuchVenueException, SystemException {
		Venue venue = fetchByVenueMetroArea_Last(venueMetroArea,
				orderByComparator);

		if (venue != null) {
			return venue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueMetroArea=");
		msg.append(venueMetroArea);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueException(msg.toString());
	}

	/**
	 * Returns the last venue in the ordered set where venueMetroArea = &#63;.
	 *
	 * @param venueMetroArea the venue metro area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue, or <code>null</code> if a matching venue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Venue fetchByVenueMetroArea_Last(String venueMetroArea,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVenueMetroArea(venueMetroArea);

		if (count == 0) {
			return null;
		}

		List<Venue> list = findByVenueMetroArea(venueMetroArea, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the venues before and after the current venue in the ordered set where venueMetroArea = &#63;.
	 *
	 * @param venueId the primary key of the current venue
	 * @param venueMetroArea the venue metro area
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next venue
	 * @throws com.rumbasolutions.flask.NoSuchVenueException if a venue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Venue[] findByVenueMetroArea_PrevAndNext(long venueId,
		String venueMetroArea, OrderByComparator orderByComparator)
		throws NoSuchVenueException, SystemException {
		Venue venue = findByPrimaryKey(venueId);

		Session session = null;

		try {
			session = openSession();

			Venue[] array = new VenueImpl[3];

			array[0] = getByVenueMetroArea_PrevAndNext(session, venue,
					venueMetroArea, orderByComparator, true);

			array[1] = venue;

			array[2] = getByVenueMetroArea_PrevAndNext(session, venue,
					venueMetroArea, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Venue getByVenueMetroArea_PrevAndNext(Session session,
		Venue venue, String venueMetroArea,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENUE_WHERE);

		boolean bindVenueMetroArea = false;

		if (venueMetroArea == null) {
			query.append(_FINDER_COLUMN_VENUEMETROAREA_VENUEMETROAREA_1);
		}
		else if (venueMetroArea.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_VENUEMETROAREA_VENUEMETROAREA_3);
		}
		else {
			bindVenueMetroArea = true;

			query.append(_FINDER_COLUMN_VENUEMETROAREA_VENUEMETROAREA_2);
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
			query.append(VenueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindVenueMetroArea) {
			qPos.add(venueMetroArea);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(venue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Venue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the venues where venueMetroArea = &#63; from the database.
	 *
	 * @param venueMetroArea the venue metro area
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVenueMetroArea(String venueMetroArea)
		throws SystemException {
		for (Venue venue : findByVenueMetroArea(venueMetroArea,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(venue);
		}
	}

	/**
	 * Returns the number of venues where venueMetroArea = &#63;.
	 *
	 * @param venueMetroArea the venue metro area
	 * @return the number of matching venues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVenueMetroArea(String venueMetroArea)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VENUEMETROAREA;

		Object[] finderArgs = new Object[] { venueMetroArea };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VENUE_WHERE);

			boolean bindVenueMetroArea = false;

			if (venueMetroArea == null) {
				query.append(_FINDER_COLUMN_VENUEMETROAREA_VENUEMETROAREA_1);
			}
			else if (venueMetroArea.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_VENUEMETROAREA_VENUEMETROAREA_3);
			}
			else {
				bindVenueMetroArea = true;

				query.append(_FINDER_COLUMN_VENUEMETROAREA_VENUEMETROAREA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindVenueMetroArea) {
					qPos.add(venueMetroArea);
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

	private static final String _FINDER_COLUMN_VENUEMETROAREA_VENUEMETROAREA_1 = "venue.venueMetroArea IS NULL";
	private static final String _FINDER_COLUMN_VENUEMETROAREA_VENUEMETROAREA_2 = "venue.venueMetroArea = ?";
	private static final String _FINDER_COLUMN_VENUEMETROAREA_VENUEMETROAREA_3 = "(venue.venueMetroArea IS NULL OR venue.venueMetroArea = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VENUEZIPCODE =
		new FinderPath(VenueModelImpl.ENTITY_CACHE_ENABLED,
			VenueModelImpl.FINDER_CACHE_ENABLED, VenueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVenueZipCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEZIPCODE =
		new FinderPath(VenueModelImpl.ENTITY_CACHE_ENABLED,
			VenueModelImpl.FINDER_CACHE_ENABLED, VenueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVenueZipCode",
			new String[] { String.class.getName() },
			VenueModelImpl.VENUEZIPCODE_COLUMN_BITMASK |
			VenueModelImpl.VENUENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VENUEZIPCODE = new FinderPath(VenueModelImpl.ENTITY_CACHE_ENABLED,
			VenueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVenueZipCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the venues where venueZipCode = &#63;.
	 *
	 * @param venueZipCode the venue zip code
	 * @return the matching venues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Venue> findByVenueZipCode(String venueZipCode)
		throws SystemException {
		return findByVenueZipCode(venueZipCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the venues where venueZipCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueZipCode the venue zip code
	 * @param start the lower bound of the range of venues
	 * @param end the upper bound of the range of venues (not inclusive)
	 * @return the range of matching venues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Venue> findByVenueZipCode(String venueZipCode, int start,
		int end) throws SystemException {
		return findByVenueZipCode(venueZipCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the venues where venueZipCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param venueZipCode the venue zip code
	 * @param start the lower bound of the range of venues
	 * @param end the upper bound of the range of venues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching venues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Venue> findByVenueZipCode(String venueZipCode, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEZIPCODE;
			finderArgs = new Object[] { venueZipCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VENUEZIPCODE;
			finderArgs = new Object[] {
					venueZipCode,
					
					start, end, orderByComparator
				};
		}

		List<Venue> list = (List<Venue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Venue venue : list) {
				if (!Validator.equals(venueZipCode, venue.getVenueZipCode())) {
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

			query.append(_SQL_SELECT_VENUE_WHERE);

			boolean bindVenueZipCode = false;

			if (venueZipCode == null) {
				query.append(_FINDER_COLUMN_VENUEZIPCODE_VENUEZIPCODE_1);
			}
			else if (venueZipCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_VENUEZIPCODE_VENUEZIPCODE_3);
			}
			else {
				bindVenueZipCode = true;

				query.append(_FINDER_COLUMN_VENUEZIPCODE_VENUEZIPCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VenueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindVenueZipCode) {
					qPos.add(venueZipCode);
				}

				if (!pagination) {
					list = (List<Venue>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Venue>(list);
				}
				else {
					list = (List<Venue>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first venue in the ordered set where venueZipCode = &#63;.
	 *
	 * @param venueZipCode the venue zip code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue
	 * @throws com.rumbasolutions.flask.NoSuchVenueException if a matching venue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Venue findByVenueZipCode_First(String venueZipCode,
		OrderByComparator orderByComparator)
		throws NoSuchVenueException, SystemException {
		Venue venue = fetchByVenueZipCode_First(venueZipCode, orderByComparator);

		if (venue != null) {
			return venue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueZipCode=");
		msg.append(venueZipCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueException(msg.toString());
	}

	/**
	 * Returns the first venue in the ordered set where venueZipCode = &#63;.
	 *
	 * @param venueZipCode the venue zip code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching venue, or <code>null</code> if a matching venue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Venue fetchByVenueZipCode_First(String venueZipCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<Venue> list = findByVenueZipCode(venueZipCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last venue in the ordered set where venueZipCode = &#63;.
	 *
	 * @param venueZipCode the venue zip code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue
	 * @throws com.rumbasolutions.flask.NoSuchVenueException if a matching venue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Venue findByVenueZipCode_Last(String venueZipCode,
		OrderByComparator orderByComparator)
		throws NoSuchVenueException, SystemException {
		Venue venue = fetchByVenueZipCode_Last(venueZipCode, orderByComparator);

		if (venue != null) {
			return venue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("venueZipCode=");
		msg.append(venueZipCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVenueException(msg.toString());
	}

	/**
	 * Returns the last venue in the ordered set where venueZipCode = &#63;.
	 *
	 * @param venueZipCode the venue zip code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching venue, or <code>null</code> if a matching venue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Venue fetchByVenueZipCode_Last(String venueZipCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVenueZipCode(venueZipCode);

		if (count == 0) {
			return null;
		}

		List<Venue> list = findByVenueZipCode(venueZipCode, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the venues before and after the current venue in the ordered set where venueZipCode = &#63;.
	 *
	 * @param venueId the primary key of the current venue
	 * @param venueZipCode the venue zip code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next venue
	 * @throws com.rumbasolutions.flask.NoSuchVenueException if a venue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Venue[] findByVenueZipCode_PrevAndNext(long venueId,
		String venueZipCode, OrderByComparator orderByComparator)
		throws NoSuchVenueException, SystemException {
		Venue venue = findByPrimaryKey(venueId);

		Session session = null;

		try {
			session = openSession();

			Venue[] array = new VenueImpl[3];

			array[0] = getByVenueZipCode_PrevAndNext(session, venue,
					venueZipCode, orderByComparator, true);

			array[1] = venue;

			array[2] = getByVenueZipCode_PrevAndNext(session, venue,
					venueZipCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Venue getByVenueZipCode_PrevAndNext(Session session, Venue venue,
		String venueZipCode, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENUE_WHERE);

		boolean bindVenueZipCode = false;

		if (venueZipCode == null) {
			query.append(_FINDER_COLUMN_VENUEZIPCODE_VENUEZIPCODE_1);
		}
		else if (venueZipCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_VENUEZIPCODE_VENUEZIPCODE_3);
		}
		else {
			bindVenueZipCode = true;

			query.append(_FINDER_COLUMN_VENUEZIPCODE_VENUEZIPCODE_2);
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
			query.append(VenueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindVenueZipCode) {
			qPos.add(venueZipCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(venue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Venue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the venues where venueZipCode = &#63; from the database.
	 *
	 * @param venueZipCode the venue zip code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVenueZipCode(String venueZipCode)
		throws SystemException {
		for (Venue venue : findByVenueZipCode(venueZipCode, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(venue);
		}
	}

	/**
	 * Returns the number of venues where venueZipCode = &#63;.
	 *
	 * @param venueZipCode the venue zip code
	 * @return the number of matching venues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVenueZipCode(String venueZipCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VENUEZIPCODE;

		Object[] finderArgs = new Object[] { venueZipCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VENUE_WHERE);

			boolean bindVenueZipCode = false;

			if (venueZipCode == null) {
				query.append(_FINDER_COLUMN_VENUEZIPCODE_VENUEZIPCODE_1);
			}
			else if (venueZipCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_VENUEZIPCODE_VENUEZIPCODE_3);
			}
			else {
				bindVenueZipCode = true;

				query.append(_FINDER_COLUMN_VENUEZIPCODE_VENUEZIPCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindVenueZipCode) {
					qPos.add(venueZipCode);
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

	private static final String _FINDER_COLUMN_VENUEZIPCODE_VENUEZIPCODE_1 = "venue.venueZipCode IS NULL";
	private static final String _FINDER_COLUMN_VENUEZIPCODE_VENUEZIPCODE_2 = "venue.venueZipCode = ?";
	private static final String _FINDER_COLUMN_VENUEZIPCODE_VENUEZIPCODE_3 = "(venue.venueZipCode IS NULL OR venue.venueZipCode = '')";

	public VenuePersistenceImpl() {
		setModelClass(Venue.class);
	}

	/**
	 * Caches the venue in the entity cache if it is enabled.
	 *
	 * @param venue the venue
	 */
	@Override
	public void cacheResult(Venue venue) {
		EntityCacheUtil.putResult(VenueModelImpl.ENTITY_CACHE_ENABLED,
			VenueImpl.class, venue.getPrimaryKey(), venue);

		venue.resetOriginalValues();
	}

	/**
	 * Caches the venues in the entity cache if it is enabled.
	 *
	 * @param venues the venues
	 */
	@Override
	public void cacheResult(List<Venue> venues) {
		for (Venue venue : venues) {
			if (EntityCacheUtil.getResult(VenueModelImpl.ENTITY_CACHE_ENABLED,
						VenueImpl.class, venue.getPrimaryKey()) == null) {
				cacheResult(venue);
			}
			else {
				venue.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all venues.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VenueImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VenueImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the venue.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Venue venue) {
		EntityCacheUtil.removeResult(VenueModelImpl.ENTITY_CACHE_ENABLED,
			VenueImpl.class, venue.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Venue> venues) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Venue venue : venues) {
			EntityCacheUtil.removeResult(VenueModelImpl.ENTITY_CACHE_ENABLED,
				VenueImpl.class, venue.getPrimaryKey());
		}
	}

	/**
	 * Creates a new venue with the primary key. Does not add the venue to the database.
	 *
	 * @param venueId the primary key for the new venue
	 * @return the new venue
	 */
	@Override
	public Venue create(long venueId) {
		Venue venue = new VenueImpl();

		venue.setNew(true);
		venue.setPrimaryKey(venueId);

		return venue;
	}

	/**
	 * Removes the venue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param venueId the primary key of the venue
	 * @return the venue that was removed
	 * @throws com.rumbasolutions.flask.NoSuchVenueException if a venue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Venue remove(long venueId)
		throws NoSuchVenueException, SystemException {
		return remove((Serializable)venueId);
	}

	/**
	 * Removes the venue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the venue
	 * @return the venue that was removed
	 * @throws com.rumbasolutions.flask.NoSuchVenueException if a venue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Venue remove(Serializable primaryKey)
		throws NoSuchVenueException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Venue venue = (Venue)session.get(VenueImpl.class, primaryKey);

			if (venue == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVenueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(venue);
		}
		catch (NoSuchVenueException nsee) {
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
	protected Venue removeImpl(Venue venue) throws SystemException {
		venue = toUnwrappedModel(venue);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(venue)) {
				venue = (Venue)session.get(VenueImpl.class,
						venue.getPrimaryKeyObj());
			}

			if (venue != null) {
				session.delete(venue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (venue != null) {
			clearCache(venue);
		}

		return venue;
	}

	@Override
	public Venue updateImpl(com.rumbasolutions.flask.model.Venue venue)
		throws SystemException {
		venue = toUnwrappedModel(venue);

		boolean isNew = venue.isNew();

		VenueModelImpl venueModelImpl = (VenueModelImpl)venue;

		Session session = null;

		try {
			session = openSession();

			if (venue.isNew()) {
				session.save(venue);

				venue.setNew(false);
			}
			else {
				session.merge(venue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VenueModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((venueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEMETROAREA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						venueModelImpl.getOriginalVenueMetroArea()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEMETROAREA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEMETROAREA,
					args);

				args = new Object[] { venueModelImpl.getVenueMetroArea() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEMETROAREA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEMETROAREA,
					args);
			}

			if ((venueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEZIPCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						venueModelImpl.getOriginalVenueZipCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEZIPCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEZIPCODE,
					args);

				args = new Object[] { venueModelImpl.getVenueZipCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VENUEZIPCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VENUEZIPCODE,
					args);
			}
		}

		EntityCacheUtil.putResult(VenueModelImpl.ENTITY_CACHE_ENABLED,
			VenueImpl.class, venue.getPrimaryKey(), venue);

		return venue;
	}

	protected Venue toUnwrappedModel(Venue venue) {
		if (venue instanceof VenueImpl) {
			return venue;
		}

		VenueImpl venueImpl = new VenueImpl();

		venueImpl.setNew(venue.isNew());
		venueImpl.setPrimaryKey(venue.getPrimaryKey());

		venueImpl.setVenueId(venue.getVenueId());
		venueImpl.setCompanyId(venue.getCompanyId());
		venueImpl.setUserId(venue.getUserId());
		venueImpl.setCreatedDate(venue.getCreatedDate());
		venueImpl.setModifiedDate(venue.getModifiedDate());
		venueImpl.setVenueName(venue.getVenueName());
		venueImpl.setVenueDescription(venue.getVenueDescription());
		venueImpl.setVenueZipCode(venue.getVenueZipCode());
		venueImpl.setAddrLine1(venue.getAddrLine1());
		venueImpl.setAddrLine2(venue.getAddrLine2());
		venueImpl.setVenueCity(venue.getVenueCity());
		venueImpl.setVenueStateId(venue.getVenueStateId());
		venueImpl.setVenueStateName(venue.getVenueStateName());
		venueImpl.setVenueCountryId(venue.getVenueCountryId());
		venueImpl.setVenueCountryName(venue.getVenueCountryName());
		venueImpl.setVenueMetroArea(venue.getVenueMetroArea());
		venueImpl.setLongitude(venue.getLongitude());
		venueImpl.setLatitude(venue.getLatitude());

		return venueImpl;
	}

	/**
	 * Returns the venue with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the venue
	 * @return the venue
	 * @throws com.rumbasolutions.flask.NoSuchVenueException if a venue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Venue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVenueException, SystemException {
		Venue venue = fetchByPrimaryKey(primaryKey);

		if (venue == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVenueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return venue;
	}

	/**
	 * Returns the venue with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueException} if it could not be found.
	 *
	 * @param venueId the primary key of the venue
	 * @return the venue
	 * @throws com.rumbasolutions.flask.NoSuchVenueException if a venue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Venue findByPrimaryKey(long venueId)
		throws NoSuchVenueException, SystemException {
		return findByPrimaryKey((Serializable)venueId);
	}

	/**
	 * Returns the venue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the venue
	 * @return the venue, or <code>null</code> if a venue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Venue fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Venue venue = (Venue)EntityCacheUtil.getResult(VenueModelImpl.ENTITY_CACHE_ENABLED,
				VenueImpl.class, primaryKey);

		if (venue == _nullVenue) {
			return null;
		}

		if (venue == null) {
			Session session = null;

			try {
				session = openSession();

				venue = (Venue)session.get(VenueImpl.class, primaryKey);

				if (venue != null) {
					cacheResult(venue);
				}
				else {
					EntityCacheUtil.putResult(VenueModelImpl.ENTITY_CACHE_ENABLED,
						VenueImpl.class, primaryKey, _nullVenue);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VenueModelImpl.ENTITY_CACHE_ENABLED,
					VenueImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return venue;
	}

	/**
	 * Returns the venue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param venueId the primary key of the venue
	 * @return the venue, or <code>null</code> if a venue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Venue fetchByPrimaryKey(long venueId) throws SystemException {
		return fetchByPrimaryKey((Serializable)venueId);
	}

	/**
	 * Returns all the venues.
	 *
	 * @return the venues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Venue> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the venues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of venues
	 * @param end the upper bound of the range of venues (not inclusive)
	 * @return the range of venues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Venue> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the venues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of venues
	 * @param end the upper bound of the range of venues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of venues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Venue> findAll(int start, int end,
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

		List<Venue> list = (List<Venue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VENUE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VENUE;

				if (pagination) {
					sql = sql.concat(VenueModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Venue>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Venue>(list);
				}
				else {
					list = (List<Venue>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the venues from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Venue venue : findAll()) {
			remove(venue);
		}
	}

	/**
	 * Returns the number of venues.
	 *
	 * @return the number of venues
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

				Query q = session.createQuery(_SQL_COUNT_VENUE);

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
	 * Initializes the venue persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.Venue")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Venue>> listenersList = new ArrayList<ModelListener<Venue>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Venue>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VenueImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VENUE = "SELECT venue FROM Venue venue";
	private static final String _SQL_SELECT_VENUE_WHERE = "SELECT venue FROM Venue venue WHERE ";
	private static final String _SQL_COUNT_VENUE = "SELECT COUNT(venue) FROM Venue venue";
	private static final String _SQL_COUNT_VENUE_WHERE = "SELECT COUNT(venue) FROM Venue venue WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "venue.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Venue exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Venue exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VenuePersistenceImpl.class);
	private static Venue _nullVenue = new VenueImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Venue> toCacheModel() {
				return _nullVenueCacheModel;
			}
		};

	private static CacheModel<Venue> _nullVenueCacheModel = new CacheModel<Venue>() {
			@Override
			public Venue toEntityModel() {
				return _nullVenue;
			}
		};
}