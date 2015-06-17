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

import com.rumbasolutions.flask.NoSuchEventDetailException;
import com.rumbasolutions.flask.model.EventDetail;
import com.rumbasolutions.flask.model.impl.EventDetailImpl;
import com.rumbasolutions.flask.model.impl.EventDetailModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the event detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventDetailPersistence
 * @see EventDetailUtil
 * @generated
 */
public class EventDetailPersistenceImpl extends BasePersistenceImpl<EventDetail>
	implements EventDetailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EventDetailUtil} to access the event detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EventDetailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailModelImpl.FINDER_CACHE_ENABLED, EventDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailModelImpl.FINDER_CACHE_ENABLED, EventDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTID = new FinderPath(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailModelImpl.FINDER_CACHE_ENABLED, EventDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID =
		new FinderPath(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailModelImpl.FINDER_CACHE_ENABLED, EventDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventId",
			new String[] { Long.class.getName() },
			EventDetailModelImpl.EVENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTID = new FinderPath(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the event details where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the matching event details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetail> findByEventId(long eventId)
		throws SystemException {
		return findByEventId(eventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event details where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event details
	 * @param end the upper bound of the range of event details (not inclusive)
	 * @return the range of matching event details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetail> findByEventId(long eventId, int start, int end)
		throws SystemException {
		return findByEventId(eventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the event details where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event details
	 * @param end the upper bound of the range of event details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetail> findByEventId(long eventId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID;
			finderArgs = new Object[] { eventId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTID;
			finderArgs = new Object[] { eventId, start, end, orderByComparator };
		}

		List<EventDetail> list = (List<EventDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventDetail eventDetail : list) {
				if ((eventId != eventDetail.getEventId())) {
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

			query.append(_SQL_SELECT_EVENTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventId);

				if (!pagination) {
					list = (List<EventDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventDetail>(list);
				}
				else {
					list = (List<EventDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first event detail in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event detail
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailException if a matching event detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail findByEventId_First(long eventId,
		OrderByComparator orderByComparator)
		throws NoSuchEventDetailException, SystemException {
		EventDetail eventDetail = fetchByEventId_First(eventId,
				orderByComparator);

		if (eventDetail != null) {
			return eventDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventId=");
		msg.append(eventId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventDetailException(msg.toString());
	}

	/**
	 * Returns the first event detail in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event detail, or <code>null</code> if a matching event detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail fetchByEventId_First(long eventId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventDetail> list = findByEventId(eventId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event detail in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event detail
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailException if a matching event detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail findByEventId_Last(long eventId,
		OrderByComparator orderByComparator)
		throws NoSuchEventDetailException, SystemException {
		EventDetail eventDetail = fetchByEventId_Last(eventId, orderByComparator);

		if (eventDetail != null) {
			return eventDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventId=");
		msg.append(eventId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventDetailException(msg.toString());
	}

	/**
	 * Returns the last event detail in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event detail, or <code>null</code> if a matching event detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail fetchByEventId_Last(long eventId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEventId(eventId);

		if (count == 0) {
			return null;
		}

		List<EventDetail> list = findByEventId(eventId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event details before and after the current event detail in the ordered set where eventId = &#63;.
	 *
	 * @param eventDetailId the primary key of the current event detail
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event detail
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailException if a event detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail[] findByEventId_PrevAndNext(long eventDetailId,
		long eventId, OrderByComparator orderByComparator)
		throws NoSuchEventDetailException, SystemException {
		EventDetail eventDetail = findByPrimaryKey(eventDetailId);

		Session session = null;

		try {
			session = openSession();

			EventDetail[] array = new EventDetailImpl[3];

			array[0] = getByEventId_PrevAndNext(session, eventDetail, eventId,
					orderByComparator, true);

			array[1] = eventDetail;

			array[2] = getByEventId_PrevAndNext(session, eventDetail, eventId,
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

	protected EventDetail getByEventId_PrevAndNext(Session session,
		EventDetail eventDetail, long eventId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTDETAIL_WHERE);

		query.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

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
			query.append(EventDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(eventId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the event details where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEventId(long eventId) throws SystemException {
		for (EventDetail eventDetail : findByEventId(eventId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventDetail);
		}
	}

	/**
	 * Returns the number of event details where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching event details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEventId(long eventId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTID;

		Object[] finderArgs = new Object[] { eventId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EVENTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventId);

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

	private static final String _FINDER_COLUMN_EVENTID_EVENTID_2 = "eventDetail.eventId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTINFOTYPE =
		new FinderPath(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailModelImpl.FINDER_CACHE_ENABLED, EventDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventInfoType",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTINFOTYPE =
		new FinderPath(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailModelImpl.FINDER_CACHE_ENABLED, EventDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventInfoType",
			new String[] { Long.class.getName() },
			EventDetailModelImpl.INFOTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTINFOTYPE = new FinderPath(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventInfoType",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the event details where infoTypeId = &#63;.
	 *
	 * @param infoTypeId the info type ID
	 * @return the matching event details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetail> findByEventInfoType(long infoTypeId)
		throws SystemException {
		return findByEventInfoType(infoTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event details where infoTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param infoTypeId the info type ID
	 * @param start the lower bound of the range of event details
	 * @param end the upper bound of the range of event details (not inclusive)
	 * @return the range of matching event details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetail> findByEventInfoType(long infoTypeId, int start,
		int end) throws SystemException {
		return findByEventInfoType(infoTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the event details where infoTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param infoTypeId the info type ID
	 * @param start the lower bound of the range of event details
	 * @param end the upper bound of the range of event details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetail> findByEventInfoType(long infoTypeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTINFOTYPE;
			finderArgs = new Object[] { infoTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTINFOTYPE;
			finderArgs = new Object[] { infoTypeId, start, end, orderByComparator };
		}

		List<EventDetail> list = (List<EventDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventDetail eventDetail : list) {
				if ((infoTypeId != eventDetail.getInfoTypeId())) {
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

			query.append(_SQL_SELECT_EVENTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_EVENTINFOTYPE_INFOTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(infoTypeId);

				if (!pagination) {
					list = (List<EventDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventDetail>(list);
				}
				else {
					list = (List<EventDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first event detail in the ordered set where infoTypeId = &#63;.
	 *
	 * @param infoTypeId the info type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event detail
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailException if a matching event detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail findByEventInfoType_First(long infoTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchEventDetailException, SystemException {
		EventDetail eventDetail = fetchByEventInfoType_First(infoTypeId,
				orderByComparator);

		if (eventDetail != null) {
			return eventDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("infoTypeId=");
		msg.append(infoTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventDetailException(msg.toString());
	}

	/**
	 * Returns the first event detail in the ordered set where infoTypeId = &#63;.
	 *
	 * @param infoTypeId the info type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event detail, or <code>null</code> if a matching event detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail fetchByEventInfoType_First(long infoTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventDetail> list = findByEventInfoType(infoTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event detail in the ordered set where infoTypeId = &#63;.
	 *
	 * @param infoTypeId the info type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event detail
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailException if a matching event detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail findByEventInfoType_Last(long infoTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchEventDetailException, SystemException {
		EventDetail eventDetail = fetchByEventInfoType_Last(infoTypeId,
				orderByComparator);

		if (eventDetail != null) {
			return eventDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("infoTypeId=");
		msg.append(infoTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventDetailException(msg.toString());
	}

	/**
	 * Returns the last event detail in the ordered set where infoTypeId = &#63;.
	 *
	 * @param infoTypeId the info type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event detail, or <code>null</code> if a matching event detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail fetchByEventInfoType_Last(long infoTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEventInfoType(infoTypeId);

		if (count == 0) {
			return null;
		}

		List<EventDetail> list = findByEventInfoType(infoTypeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event details before and after the current event detail in the ordered set where infoTypeId = &#63;.
	 *
	 * @param eventDetailId the primary key of the current event detail
	 * @param infoTypeId the info type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event detail
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailException if a event detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail[] findByEventInfoType_PrevAndNext(long eventDetailId,
		long infoTypeId, OrderByComparator orderByComparator)
		throws NoSuchEventDetailException, SystemException {
		EventDetail eventDetail = findByPrimaryKey(eventDetailId);

		Session session = null;

		try {
			session = openSession();

			EventDetail[] array = new EventDetailImpl[3];

			array[0] = getByEventInfoType_PrevAndNext(session, eventDetail,
					infoTypeId, orderByComparator, true);

			array[1] = eventDetail;

			array[2] = getByEventInfoType_PrevAndNext(session, eventDetail,
					infoTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventDetail getByEventInfoType_PrevAndNext(Session session,
		EventDetail eventDetail, long infoTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTDETAIL_WHERE);

		query.append(_FINDER_COLUMN_EVENTINFOTYPE_INFOTYPEID_2);

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
			query.append(EventDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(infoTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the event details where infoTypeId = &#63; from the database.
	 *
	 * @param infoTypeId the info type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEventInfoType(long infoTypeId)
		throws SystemException {
		for (EventDetail eventDetail : findByEventInfoType(infoTypeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventDetail);
		}
	}

	/**
	 * Returns the number of event details where infoTypeId = &#63;.
	 *
	 * @param infoTypeId the info type ID
	 * @return the number of matching event details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEventInfoType(long infoTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTINFOTYPE;

		Object[] finderArgs = new Object[] { infoTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EVENTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_EVENTINFOTYPE_INFOTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(infoTypeId);

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

	private static final String _FINDER_COLUMN_EVENTINFOTYPE_INFOTYPEID_2 = "eventDetail.infoTypeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTINFOTYPECATEGORY =
		new FinderPath(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailModelImpl.FINDER_CACHE_ENABLED, EventDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEventInfoTypeCategory",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTINFOTYPECATEGORY =
		new FinderPath(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailModelImpl.FINDER_CACHE_ENABLED, EventDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEventInfoTypeCategory",
			new String[] { Long.class.getName(), Long.class.getName() },
			EventDetailModelImpl.INFOTYPEID_COLUMN_BITMASK |
			EventDetailModelImpl.INFOTYPECATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTINFOTYPECATEGORY = new FinderPath(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEventInfoTypeCategory",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the event details where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	 *
	 * @param infoTypeId the info type ID
	 * @param infoTypeCategoryId the info type category ID
	 * @return the matching event details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetail> findByEventInfoTypeCategory(long infoTypeId,
		long infoTypeCategoryId) throws SystemException {
		return findByEventInfoTypeCategory(infoTypeId, infoTypeCategoryId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event details where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param infoTypeId the info type ID
	 * @param infoTypeCategoryId the info type category ID
	 * @param start the lower bound of the range of event details
	 * @param end the upper bound of the range of event details (not inclusive)
	 * @return the range of matching event details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetail> findByEventInfoTypeCategory(long infoTypeId,
		long infoTypeCategoryId, int start, int end) throws SystemException {
		return findByEventInfoTypeCategory(infoTypeId, infoTypeCategoryId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the event details where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param infoTypeId the info type ID
	 * @param infoTypeCategoryId the info type category ID
	 * @param start the lower bound of the range of event details
	 * @param end the upper bound of the range of event details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetail> findByEventInfoTypeCategory(long infoTypeId,
		long infoTypeCategoryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTINFOTYPECATEGORY;
			finderArgs = new Object[] { infoTypeId, infoTypeCategoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTINFOTYPECATEGORY;
			finderArgs = new Object[] {
					infoTypeId, infoTypeCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<EventDetail> list = (List<EventDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventDetail eventDetail : list) {
				if ((infoTypeId != eventDetail.getInfoTypeId()) ||
						(infoTypeCategoryId != eventDetail.getInfoTypeCategoryId())) {
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

			query.append(_SQL_SELECT_EVENTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_EVENTINFOTYPECATEGORY_INFOTYPEID_2);

			query.append(_FINDER_COLUMN_EVENTINFOTYPECATEGORY_INFOTYPECATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(infoTypeId);

				qPos.add(infoTypeCategoryId);

				if (!pagination) {
					list = (List<EventDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventDetail>(list);
				}
				else {
					list = (List<EventDetail>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first event detail in the ordered set where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	 *
	 * @param infoTypeId the info type ID
	 * @param infoTypeCategoryId the info type category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event detail
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailException if a matching event detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail findByEventInfoTypeCategory_First(long infoTypeId,
		long infoTypeCategoryId, OrderByComparator orderByComparator)
		throws NoSuchEventDetailException, SystemException {
		EventDetail eventDetail = fetchByEventInfoTypeCategory_First(infoTypeId,
				infoTypeCategoryId, orderByComparator);

		if (eventDetail != null) {
			return eventDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("infoTypeId=");
		msg.append(infoTypeId);

		msg.append(", infoTypeCategoryId=");
		msg.append(infoTypeCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventDetailException(msg.toString());
	}

	/**
	 * Returns the first event detail in the ordered set where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	 *
	 * @param infoTypeId the info type ID
	 * @param infoTypeCategoryId the info type category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event detail, or <code>null</code> if a matching event detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail fetchByEventInfoTypeCategory_First(long infoTypeId,
		long infoTypeCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<EventDetail> list = findByEventInfoTypeCategory(infoTypeId,
				infoTypeCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event detail in the ordered set where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	 *
	 * @param infoTypeId the info type ID
	 * @param infoTypeCategoryId the info type category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event detail
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailException if a matching event detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail findByEventInfoTypeCategory_Last(long infoTypeId,
		long infoTypeCategoryId, OrderByComparator orderByComparator)
		throws NoSuchEventDetailException, SystemException {
		EventDetail eventDetail = fetchByEventInfoTypeCategory_Last(infoTypeId,
				infoTypeCategoryId, orderByComparator);

		if (eventDetail != null) {
			return eventDetail;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("infoTypeId=");
		msg.append(infoTypeId);

		msg.append(", infoTypeCategoryId=");
		msg.append(infoTypeCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventDetailException(msg.toString());
	}

	/**
	 * Returns the last event detail in the ordered set where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	 *
	 * @param infoTypeId the info type ID
	 * @param infoTypeCategoryId the info type category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event detail, or <code>null</code> if a matching event detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail fetchByEventInfoTypeCategory_Last(long infoTypeId,
		long infoTypeCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByEventInfoTypeCategory(infoTypeId, infoTypeCategoryId);

		if (count == 0) {
			return null;
		}

		List<EventDetail> list = findByEventInfoTypeCategory(infoTypeId,
				infoTypeCategoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event details before and after the current event detail in the ordered set where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	 *
	 * @param eventDetailId the primary key of the current event detail
	 * @param infoTypeId the info type ID
	 * @param infoTypeCategoryId the info type category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event detail
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailException if a event detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail[] findByEventInfoTypeCategory_PrevAndNext(
		long eventDetailId, long infoTypeId, long infoTypeCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchEventDetailException, SystemException {
		EventDetail eventDetail = findByPrimaryKey(eventDetailId);

		Session session = null;

		try {
			session = openSession();

			EventDetail[] array = new EventDetailImpl[3];

			array[0] = getByEventInfoTypeCategory_PrevAndNext(session,
					eventDetail, infoTypeId, infoTypeCategoryId,
					orderByComparator, true);

			array[1] = eventDetail;

			array[2] = getByEventInfoTypeCategory_PrevAndNext(session,
					eventDetail, infoTypeId, infoTypeCategoryId,
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

	protected EventDetail getByEventInfoTypeCategory_PrevAndNext(
		Session session, EventDetail eventDetail, long infoTypeId,
		long infoTypeCategoryId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTDETAIL_WHERE);

		query.append(_FINDER_COLUMN_EVENTINFOTYPECATEGORY_INFOTYPEID_2);

		query.append(_FINDER_COLUMN_EVENTINFOTYPECATEGORY_INFOTYPECATEGORYID_2);

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
			query.append(EventDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(infoTypeId);

		qPos.add(infoTypeCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the event details where infoTypeId = &#63; and infoTypeCategoryId = &#63; from the database.
	 *
	 * @param infoTypeId the info type ID
	 * @param infoTypeCategoryId the info type category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEventInfoTypeCategory(long infoTypeId,
		long infoTypeCategoryId) throws SystemException {
		for (EventDetail eventDetail : findByEventInfoTypeCategory(infoTypeId,
				infoTypeCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventDetail);
		}
	}

	/**
	 * Returns the number of event details where infoTypeId = &#63; and infoTypeCategoryId = &#63;.
	 *
	 * @param infoTypeId the info type ID
	 * @param infoTypeCategoryId the info type category ID
	 * @return the number of matching event details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEventInfoTypeCategory(long infoTypeId,
		long infoTypeCategoryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTINFOTYPECATEGORY;

		Object[] finderArgs = new Object[] { infoTypeId, infoTypeCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVENTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_EVENTINFOTYPECATEGORY_INFOTYPEID_2);

			query.append(_FINDER_COLUMN_EVENTINFOTYPECATEGORY_INFOTYPECATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(infoTypeId);

				qPos.add(infoTypeCategoryId);

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

	private static final String _FINDER_COLUMN_EVENTINFOTYPECATEGORY_INFOTYPEID_2 =
		"eventDetail.infoTypeId = ? AND ";
	private static final String _FINDER_COLUMN_EVENTINFOTYPECATEGORY_INFOTYPECATEGORYID_2 =
		"eventDetail.infoTypeCategoryId = ?";

	public EventDetailPersistenceImpl() {
		setModelClass(EventDetail.class);
	}

	/**
	 * Caches the event detail in the entity cache if it is enabled.
	 *
	 * @param eventDetail the event detail
	 */
	@Override
	public void cacheResult(EventDetail eventDetail) {
		EntityCacheUtil.putResult(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailImpl.class, eventDetail.getPrimaryKey(), eventDetail);

		eventDetail.resetOriginalValues();
	}

	/**
	 * Caches the event details in the entity cache if it is enabled.
	 *
	 * @param eventDetails the event details
	 */
	@Override
	public void cacheResult(List<EventDetail> eventDetails) {
		for (EventDetail eventDetail : eventDetails) {
			if (EntityCacheUtil.getResult(
						EventDetailModelImpl.ENTITY_CACHE_ENABLED,
						EventDetailImpl.class, eventDetail.getPrimaryKey()) == null) {
				cacheResult(eventDetail);
			}
			else {
				eventDetail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all event details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EventDetailImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EventDetailImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the event detail.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EventDetail eventDetail) {
		EntityCacheUtil.removeResult(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailImpl.class, eventDetail.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EventDetail> eventDetails) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EventDetail eventDetail : eventDetails) {
			EntityCacheUtil.removeResult(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
				EventDetailImpl.class, eventDetail.getPrimaryKey());
		}
	}

	/**
	 * Creates a new event detail with the primary key. Does not add the event detail to the database.
	 *
	 * @param eventDetailId the primary key for the new event detail
	 * @return the new event detail
	 */
	@Override
	public EventDetail create(long eventDetailId) {
		EventDetail eventDetail = new EventDetailImpl();

		eventDetail.setNew(true);
		eventDetail.setPrimaryKey(eventDetailId);

		return eventDetail;
	}

	/**
	 * Removes the event detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventDetailId the primary key of the event detail
	 * @return the event detail that was removed
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailException if a event detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail remove(long eventDetailId)
		throws NoSuchEventDetailException, SystemException {
		return remove((Serializable)eventDetailId);
	}

	/**
	 * Removes the event detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the event detail
	 * @return the event detail that was removed
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailException if a event detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail remove(Serializable primaryKey)
		throws NoSuchEventDetailException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EventDetail eventDetail = (EventDetail)session.get(EventDetailImpl.class,
					primaryKey);

			if (eventDetail == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eventDetail);
		}
		catch (NoSuchEventDetailException nsee) {
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
	protected EventDetail removeImpl(EventDetail eventDetail)
		throws SystemException {
		eventDetail = toUnwrappedModel(eventDetail);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eventDetail)) {
				eventDetail = (EventDetail)session.get(EventDetailImpl.class,
						eventDetail.getPrimaryKeyObj());
			}

			if (eventDetail != null) {
				session.delete(eventDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eventDetail != null) {
			clearCache(eventDetail);
		}

		return eventDetail;
	}

	@Override
	public EventDetail updateImpl(
		com.rumbasolutions.flask.model.EventDetail eventDetail)
		throws SystemException {
		eventDetail = toUnwrappedModel(eventDetail);

		boolean isNew = eventDetail.isNew();

		EventDetailModelImpl eventDetailModelImpl = (EventDetailModelImpl)eventDetail;

		Session session = null;

		try {
			session = openSession();

			if (eventDetail.isNew()) {
				session.save(eventDetail);

				eventDetail.setNew(false);
			}
			else {
				session.merge(eventDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EventDetailModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eventDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventDetailModelImpl.getOriginalEventId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID,
					args);

				args = new Object[] { eventDetailModelImpl.getEventId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID,
					args);
			}

			if ((eventDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTINFOTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventDetailModelImpl.getOriginalInfoTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTINFOTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTINFOTYPE,
					args);

				args = new Object[] { eventDetailModelImpl.getInfoTypeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTINFOTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTINFOTYPE,
					args);
			}

			if ((eventDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTINFOTYPECATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventDetailModelImpl.getOriginalInfoTypeId(),
						eventDetailModelImpl.getOriginalInfoTypeCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTINFOTYPECATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTINFOTYPECATEGORY,
					args);

				args = new Object[] {
						eventDetailModelImpl.getInfoTypeId(),
						eventDetailModelImpl.getInfoTypeCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTINFOTYPECATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTINFOTYPECATEGORY,
					args);
			}
		}

		EntityCacheUtil.putResult(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailImpl.class, eventDetail.getPrimaryKey(), eventDetail);

		return eventDetail;
	}

	protected EventDetail toUnwrappedModel(EventDetail eventDetail) {
		if (eventDetail instanceof EventDetailImpl) {
			return eventDetail;
		}

		EventDetailImpl eventDetailImpl = new EventDetailImpl();

		eventDetailImpl.setNew(eventDetail.isNew());
		eventDetailImpl.setPrimaryKey(eventDetail.getPrimaryKey());

		eventDetailImpl.setEventDetailId(eventDetail.getEventDetailId());
		eventDetailImpl.setCompanyId(eventDetail.getCompanyId());
		eventDetailImpl.setUserId(eventDetail.getUserId());
		eventDetailImpl.setCreatedDate(eventDetail.getCreatedDate());
		eventDetailImpl.setModifiedDate(eventDetail.getModifiedDate());
		eventDetailImpl.setEventId(eventDetail.getEventId());
		eventDetailImpl.setInfoTypeId(eventDetail.getInfoTypeId());
		eventDetailImpl.setInfoTypeName(eventDetail.getInfoTypeName());
		eventDetailImpl.setInfoTypeCategoryId(eventDetail.getInfoTypeCategoryId());
		eventDetailImpl.setInfoTypeCategoryName(eventDetail.getInfoTypeCategoryName());
		eventDetailImpl.setInfoTitle(eventDetail.getInfoTitle());
		eventDetailImpl.setInfoDesc(eventDetail.getInfoDesc());
		eventDetailImpl.setAddrLine1(eventDetail.getAddrLine1());
		eventDetailImpl.setAddrLine2(eventDetail.getAddrLine2());
		eventDetailImpl.setCity(eventDetail.getCity());
		eventDetailImpl.setZipCode(eventDetail.getZipCode());
		eventDetailImpl.setStateId(eventDetail.getStateId());
		eventDetailImpl.setStateName(eventDetail.getStateName());
		eventDetailImpl.setCountryId(eventDetail.getCountryId());
		eventDetailImpl.setCountryName(eventDetail.getCountryName());
		eventDetailImpl.setLatitude(eventDetail.getLatitude());
		eventDetailImpl.setLongitude(eventDetail.getLongitude());
		eventDetailImpl.setPhone(eventDetail.getPhone());
		eventDetailImpl.setWebsite(eventDetail.getWebsite());
		eventDetailImpl.setCost(eventDetail.getCost());
		eventDetailImpl.setHoursOfOperation(eventDetail.getHoursOfOperation());

		return eventDetailImpl;
	}

	/**
	 * Returns the event detail with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the event detail
	 * @return the event detail
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailException if a event detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventDetailException, SystemException {
		EventDetail eventDetail = fetchByPrimaryKey(primaryKey);

		if (eventDetail == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eventDetail;
	}

	/**
	 * Returns the event detail with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchEventDetailException} if it could not be found.
	 *
	 * @param eventDetailId the primary key of the event detail
	 * @return the event detail
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailException if a event detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail findByPrimaryKey(long eventDetailId)
		throws NoSuchEventDetailException, SystemException {
		return findByPrimaryKey((Serializable)eventDetailId);
	}

	/**
	 * Returns the event detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the event detail
	 * @return the event detail, or <code>null</code> if a event detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EventDetail eventDetail = (EventDetail)EntityCacheUtil.getResult(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
				EventDetailImpl.class, primaryKey);

		if (eventDetail == _nullEventDetail) {
			return null;
		}

		if (eventDetail == null) {
			Session session = null;

			try {
				session = openSession();

				eventDetail = (EventDetail)session.get(EventDetailImpl.class,
						primaryKey);

				if (eventDetail != null) {
					cacheResult(eventDetail);
				}
				else {
					EntityCacheUtil.putResult(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
						EventDetailImpl.class, primaryKey, _nullEventDetail);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EventDetailModelImpl.ENTITY_CACHE_ENABLED,
					EventDetailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eventDetail;
	}

	/**
	 * Returns the event detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventDetailId the primary key of the event detail
	 * @return the event detail, or <code>null</code> if a event detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetail fetchByPrimaryKey(long eventDetailId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)eventDetailId);
	}

	/**
	 * Returns all the event details.
	 *
	 * @return the event details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetail> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event details
	 * @param end the upper bound of the range of event details (not inclusive)
	 * @return the range of event details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetail> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the event details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event details
	 * @param end the upper bound of the range of event details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetail> findAll(int start, int end,
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

		List<EventDetail> list = (List<EventDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EVENTDETAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTDETAIL;

				if (pagination) {
					sql = sql.concat(EventDetailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EventDetail>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventDetail>(list);
				}
				else {
					list = (List<EventDetail>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the event details from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EventDetail eventDetail : findAll()) {
			remove(eventDetail);
		}
	}

	/**
	 * Returns the number of event details.
	 *
	 * @return the number of event details
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

				Query q = session.createQuery(_SQL_COUNT_EVENTDETAIL);

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
	 * Initializes the event detail persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.EventDetail")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EventDetail>> listenersList = new ArrayList<ModelListener<EventDetail>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EventDetail>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EventDetailImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EVENTDETAIL = "SELECT eventDetail FROM EventDetail eventDetail";
	private static final String _SQL_SELECT_EVENTDETAIL_WHERE = "SELECT eventDetail FROM EventDetail eventDetail WHERE ";
	private static final String _SQL_COUNT_EVENTDETAIL = "SELECT COUNT(eventDetail) FROM EventDetail eventDetail";
	private static final String _SQL_COUNT_EVENTDETAIL_WHERE = "SELECT COUNT(eventDetail) FROM EventDetail eventDetail WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eventDetail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EventDetail exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EventDetail exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EventDetailPersistenceImpl.class);
	private static EventDetail _nullEventDetail = new EventDetailImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EventDetail> toCacheModel() {
				return _nullEventDetailCacheModel;
			}
		};

	private static CacheModel<EventDetail> _nullEventDetailCacheModel = new CacheModel<EventDetail>() {
			@Override
			public EventDetail toEntityModel() {
				return _nullEventDetail;
			}
		};
}