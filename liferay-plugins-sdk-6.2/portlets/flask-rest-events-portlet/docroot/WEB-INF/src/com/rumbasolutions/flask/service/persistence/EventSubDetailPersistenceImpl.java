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

import com.rumbasolutions.flask.NoSuchEventSubDetailException;
import com.rumbasolutions.flask.model.EventSubDetail;
import com.rumbasolutions.flask.model.impl.EventSubDetailImpl;
import com.rumbasolutions.flask.model.impl.EventSubDetailModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the event sub detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventSubDetailPersistence
 * @see EventSubDetailUtil
 * @generated
 */
public class EventSubDetailPersistenceImpl extends BasePersistenceImpl<EventSubDetail>
	implements EventSubDetailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EventSubDetailUtil} to access the event sub detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EventSubDetailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventSubDetailModelImpl.FINDER_CACHE_ENABLED,
			EventSubDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventSubDetailModelImpl.FINDER_CACHE_ENABLED,
			EventSubDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventSubDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTDETAILID =
		new FinderPath(EventSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventSubDetailModelImpl.FINDER_CACHE_ENABLED,
			EventSubDetailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEventDetailId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTDETAILID =
		new FinderPath(EventSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventSubDetailModelImpl.FINDER_CACHE_ENABLED,
			EventSubDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventDetailId",
			new String[] { Long.class.getName() },
			EventSubDetailModelImpl.EVENTDETAILID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTDETAILID = new FinderPath(EventSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventSubDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventDetailId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the event sub details where eventDetailId = &#63;.
	 *
	 * @param eventDetailId the event detail ID
	 * @return the matching event sub details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventSubDetail> findByEventDetailId(long eventDetailId)
		throws SystemException {
		return findByEventDetailId(eventDetailId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event sub details where eventDetailId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventDetailId the event detail ID
	 * @param start the lower bound of the range of event sub details
	 * @param end the upper bound of the range of event sub details (not inclusive)
	 * @return the range of matching event sub details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventSubDetail> findByEventDetailId(long eventDetailId,
		int start, int end) throws SystemException {
		return findByEventDetailId(eventDetailId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the event sub details where eventDetailId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventDetailId the event detail ID
	 * @param start the lower bound of the range of event sub details
	 * @param end the upper bound of the range of event sub details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event sub details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventSubDetail> findByEventDetailId(long eventDetailId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTDETAILID;
			finderArgs = new Object[] { eventDetailId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTDETAILID;
			finderArgs = new Object[] {
					eventDetailId,
					
					start, end, orderByComparator
				};
		}

		List<EventSubDetail> list = (List<EventSubDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventSubDetail eventSubDetail : list) {
				if ((eventDetailId != eventSubDetail.getEventDetailId())) {
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

			query.append(_SQL_SELECT_EVENTSUBDETAIL_WHERE);

			query.append(_FINDER_COLUMN_EVENTDETAILID_EVENTDETAILID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventSubDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventDetailId);

				if (!pagination) {
					list = (List<EventSubDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventSubDetail>(list);
				}
				else {
					list = (List<EventSubDetail>)QueryUtil.list(q,
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
	 * Returns the first event sub detail in the ordered set where eventDetailId = &#63;.
	 *
	 * @param eventDetailId the event detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event sub detail
	 * @throws com.rumbasolutions.flask.NoSuchEventSubDetailException if a matching event sub detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventSubDetail findByEventDetailId_First(long eventDetailId,
		OrderByComparator orderByComparator)
		throws NoSuchEventSubDetailException, SystemException {
		EventSubDetail eventSubDetail = fetchByEventDetailId_First(eventDetailId,
				orderByComparator);

		if (eventSubDetail != null) {
			return eventSubDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventDetailId=");
		msg.append(eventDetailId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventSubDetailException(msg.toString());
	}

	/**
	 * Returns the first event sub detail in the ordered set where eventDetailId = &#63;.
	 *
	 * @param eventDetailId the event detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event sub detail, or <code>null</code> if a matching event sub detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventSubDetail fetchByEventDetailId_First(long eventDetailId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventSubDetail> list = findByEventDetailId(eventDetailId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event sub detail in the ordered set where eventDetailId = &#63;.
	 *
	 * @param eventDetailId the event detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event sub detail
	 * @throws com.rumbasolutions.flask.NoSuchEventSubDetailException if a matching event sub detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventSubDetail findByEventDetailId_Last(long eventDetailId,
		OrderByComparator orderByComparator)
		throws NoSuchEventSubDetailException, SystemException {
		EventSubDetail eventSubDetail = fetchByEventDetailId_Last(eventDetailId,
				orderByComparator);

		if (eventSubDetail != null) {
			return eventSubDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventDetailId=");
		msg.append(eventDetailId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventSubDetailException(msg.toString());
	}

	/**
	 * Returns the last event sub detail in the ordered set where eventDetailId = &#63;.
	 *
	 * @param eventDetailId the event detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event sub detail, or <code>null</code> if a matching event sub detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventSubDetail fetchByEventDetailId_Last(long eventDetailId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEventDetailId(eventDetailId);

		if (count == 0) {
			return null;
		}

		List<EventSubDetail> list = findByEventDetailId(eventDetailId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event sub details before and after the current event sub detail in the ordered set where eventDetailId = &#63;.
	 *
	 * @param eventSubDetailId the primary key of the current event sub detail
	 * @param eventDetailId the event detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event sub detail
	 * @throws com.rumbasolutions.flask.NoSuchEventSubDetailException if a event sub detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventSubDetail[] findByEventDetailId_PrevAndNext(
		long eventSubDetailId, long eventDetailId,
		OrderByComparator orderByComparator)
		throws NoSuchEventSubDetailException, SystemException {
		EventSubDetail eventSubDetail = findByPrimaryKey(eventSubDetailId);

		Session session = null;

		try {
			session = openSession();

			EventSubDetail[] array = new EventSubDetailImpl[3];

			array[0] = getByEventDetailId_PrevAndNext(session, eventSubDetail,
					eventDetailId, orderByComparator, true);

			array[1] = eventSubDetail;

			array[2] = getByEventDetailId_PrevAndNext(session, eventSubDetail,
					eventDetailId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventSubDetail getByEventDetailId_PrevAndNext(Session session,
		EventSubDetail eventSubDetail, long eventDetailId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTSUBDETAIL_WHERE);

		query.append(_FINDER_COLUMN_EVENTDETAILID_EVENTDETAILID_2);

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
			query.append(EventSubDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(eventDetailId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventSubDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventSubDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the event sub details where eventDetailId = &#63; from the database.
	 *
	 * @param eventDetailId the event detail ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEventDetailId(long eventDetailId)
		throws SystemException {
		for (EventSubDetail eventSubDetail : findByEventDetailId(
				eventDetailId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventSubDetail);
		}
	}

	/**
	 * Returns the number of event sub details where eventDetailId = &#63;.
	 *
	 * @param eventDetailId the event detail ID
	 * @return the number of matching event sub details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEventDetailId(long eventDetailId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTDETAILID;

		Object[] finderArgs = new Object[] { eventDetailId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EVENTSUBDETAIL_WHERE);

			query.append(_FINDER_COLUMN_EVENTDETAILID_EVENTDETAILID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventDetailId);

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

	private static final String _FINDER_COLUMN_EVENTDETAILID_EVENTDETAILID_2 = "eventSubDetail.eventDetailId = ?";

	public EventSubDetailPersistenceImpl() {
		setModelClass(EventSubDetail.class);
	}

	/**
	 * Caches the event sub detail in the entity cache if it is enabled.
	 *
	 * @param eventSubDetail the event sub detail
	 */
	@Override
	public void cacheResult(EventSubDetail eventSubDetail) {
		EntityCacheUtil.putResult(EventSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventSubDetailImpl.class, eventSubDetail.getPrimaryKey(),
			eventSubDetail);

		eventSubDetail.resetOriginalValues();
	}

	/**
	 * Caches the event sub details in the entity cache if it is enabled.
	 *
	 * @param eventSubDetails the event sub details
	 */
	@Override
	public void cacheResult(List<EventSubDetail> eventSubDetails) {
		for (EventSubDetail eventSubDetail : eventSubDetails) {
			if (EntityCacheUtil.getResult(
						EventSubDetailModelImpl.ENTITY_CACHE_ENABLED,
						EventSubDetailImpl.class, eventSubDetail.getPrimaryKey()) == null) {
				cacheResult(eventSubDetail);
			}
			else {
				eventSubDetail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all event sub details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EventSubDetailImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EventSubDetailImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the event sub detail.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EventSubDetail eventSubDetail) {
		EntityCacheUtil.removeResult(EventSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventSubDetailImpl.class, eventSubDetail.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EventSubDetail> eventSubDetails) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EventSubDetail eventSubDetail : eventSubDetails) {
			EntityCacheUtil.removeResult(EventSubDetailModelImpl.ENTITY_CACHE_ENABLED,
				EventSubDetailImpl.class, eventSubDetail.getPrimaryKey());
		}
	}

	/**
	 * Creates a new event sub detail with the primary key. Does not add the event sub detail to the database.
	 *
	 * @param eventSubDetailId the primary key for the new event sub detail
	 * @return the new event sub detail
	 */
	@Override
	public EventSubDetail create(long eventSubDetailId) {
		EventSubDetail eventSubDetail = new EventSubDetailImpl();

		eventSubDetail.setNew(true);
		eventSubDetail.setPrimaryKey(eventSubDetailId);

		return eventSubDetail;
	}

	/**
	 * Removes the event sub detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventSubDetailId the primary key of the event sub detail
	 * @return the event sub detail that was removed
	 * @throws com.rumbasolutions.flask.NoSuchEventSubDetailException if a event sub detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventSubDetail remove(long eventSubDetailId)
		throws NoSuchEventSubDetailException, SystemException {
		return remove((Serializable)eventSubDetailId);
	}

	/**
	 * Removes the event sub detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the event sub detail
	 * @return the event sub detail that was removed
	 * @throws com.rumbasolutions.flask.NoSuchEventSubDetailException if a event sub detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventSubDetail remove(Serializable primaryKey)
		throws NoSuchEventSubDetailException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EventSubDetail eventSubDetail = (EventSubDetail)session.get(EventSubDetailImpl.class,
					primaryKey);

			if (eventSubDetail == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventSubDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eventSubDetail);
		}
		catch (NoSuchEventSubDetailException nsee) {
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
	protected EventSubDetail removeImpl(EventSubDetail eventSubDetail)
		throws SystemException {
		eventSubDetail = toUnwrappedModel(eventSubDetail);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eventSubDetail)) {
				eventSubDetail = (EventSubDetail)session.get(EventSubDetailImpl.class,
						eventSubDetail.getPrimaryKeyObj());
			}

			if (eventSubDetail != null) {
				session.delete(eventSubDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eventSubDetail != null) {
			clearCache(eventSubDetail);
		}

		return eventSubDetail;
	}

	@Override
	public EventSubDetail updateImpl(
		com.rumbasolutions.flask.model.EventSubDetail eventSubDetail)
		throws SystemException {
		eventSubDetail = toUnwrappedModel(eventSubDetail);

		boolean isNew = eventSubDetail.isNew();

		EventSubDetailModelImpl eventSubDetailModelImpl = (EventSubDetailModelImpl)eventSubDetail;

		Session session = null;

		try {
			session = openSession();

			if (eventSubDetail.isNew()) {
				session.save(eventSubDetail);

				eventSubDetail.setNew(false);
			}
			else {
				session.merge(eventSubDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EventSubDetailModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eventSubDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTDETAILID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventSubDetailModelImpl.getOriginalEventDetailId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTDETAILID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTDETAILID,
					args);

				args = new Object[] { eventSubDetailModelImpl.getEventDetailId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTDETAILID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTDETAILID,
					args);
			}
		}

		EntityCacheUtil.putResult(EventSubDetailModelImpl.ENTITY_CACHE_ENABLED,
			EventSubDetailImpl.class, eventSubDetail.getPrimaryKey(),
			eventSubDetail);

		return eventSubDetail;
	}

	protected EventSubDetail toUnwrappedModel(EventSubDetail eventSubDetail) {
		if (eventSubDetail instanceof EventSubDetailImpl) {
			return eventSubDetail;
		}

		EventSubDetailImpl eventSubDetailImpl = new EventSubDetailImpl();

		eventSubDetailImpl.setNew(eventSubDetail.isNew());
		eventSubDetailImpl.setPrimaryKey(eventSubDetail.getPrimaryKey());

		eventSubDetailImpl.setEventSubDetailId(eventSubDetail.getEventSubDetailId());
		eventSubDetailImpl.setEventDetailId(eventSubDetail.getEventDetailId());
		eventSubDetailImpl.setEventSubDetailTitle(eventSubDetail.getEventSubDetailTitle());
		eventSubDetailImpl.setEventSubDetailDesc(eventSubDetail.getEventSubDetailDesc());

		return eventSubDetailImpl;
	}

	/**
	 * Returns the event sub detail with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the event sub detail
	 * @return the event sub detail
	 * @throws com.rumbasolutions.flask.NoSuchEventSubDetailException if a event sub detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventSubDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventSubDetailException, SystemException {
		EventSubDetail eventSubDetail = fetchByPrimaryKey(primaryKey);

		if (eventSubDetail == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventSubDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eventSubDetail;
	}

	/**
	 * Returns the event sub detail with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchEventSubDetailException} if it could not be found.
	 *
	 * @param eventSubDetailId the primary key of the event sub detail
	 * @return the event sub detail
	 * @throws com.rumbasolutions.flask.NoSuchEventSubDetailException if a event sub detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventSubDetail findByPrimaryKey(long eventSubDetailId)
		throws NoSuchEventSubDetailException, SystemException {
		return findByPrimaryKey((Serializable)eventSubDetailId);
	}

	/**
	 * Returns the event sub detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the event sub detail
	 * @return the event sub detail, or <code>null</code> if a event sub detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventSubDetail fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EventSubDetail eventSubDetail = (EventSubDetail)EntityCacheUtil.getResult(EventSubDetailModelImpl.ENTITY_CACHE_ENABLED,
				EventSubDetailImpl.class, primaryKey);

		if (eventSubDetail == _nullEventSubDetail) {
			return null;
		}

		if (eventSubDetail == null) {
			Session session = null;

			try {
				session = openSession();

				eventSubDetail = (EventSubDetail)session.get(EventSubDetailImpl.class,
						primaryKey);

				if (eventSubDetail != null) {
					cacheResult(eventSubDetail);
				}
				else {
					EntityCacheUtil.putResult(EventSubDetailModelImpl.ENTITY_CACHE_ENABLED,
						EventSubDetailImpl.class, primaryKey,
						_nullEventSubDetail);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EventSubDetailModelImpl.ENTITY_CACHE_ENABLED,
					EventSubDetailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eventSubDetail;
	}

	/**
	 * Returns the event sub detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventSubDetailId the primary key of the event sub detail
	 * @return the event sub detail, or <code>null</code> if a event sub detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventSubDetail fetchByPrimaryKey(long eventSubDetailId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)eventSubDetailId);
	}

	/**
	 * Returns all the event sub details.
	 *
	 * @return the event sub details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventSubDetail> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event sub details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event sub details
	 * @param end the upper bound of the range of event sub details (not inclusive)
	 * @return the range of event sub details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventSubDetail> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the event sub details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventSubDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event sub details
	 * @param end the upper bound of the range of event sub details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event sub details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventSubDetail> findAll(int start, int end,
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

		List<EventSubDetail> list = (List<EventSubDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EVENTSUBDETAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTSUBDETAIL;

				if (pagination) {
					sql = sql.concat(EventSubDetailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EventSubDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventSubDetail>(list);
				}
				else {
					list = (List<EventSubDetail>)QueryUtil.list(q,
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
	 * Removes all the event sub details from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EventSubDetail eventSubDetail : findAll()) {
			remove(eventSubDetail);
		}
	}

	/**
	 * Returns the number of event sub details.
	 *
	 * @return the number of event sub details
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

				Query q = session.createQuery(_SQL_COUNT_EVENTSUBDETAIL);

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
	 * Initializes the event sub detail persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.EventSubDetail")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EventSubDetail>> listenersList = new ArrayList<ModelListener<EventSubDetail>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EventSubDetail>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EventSubDetailImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EVENTSUBDETAIL = "SELECT eventSubDetail FROM EventSubDetail eventSubDetail";
	private static final String _SQL_SELECT_EVENTSUBDETAIL_WHERE = "SELECT eventSubDetail FROM EventSubDetail eventSubDetail WHERE ";
	private static final String _SQL_COUNT_EVENTSUBDETAIL = "SELECT COUNT(eventSubDetail) FROM EventSubDetail eventSubDetail";
	private static final String _SQL_COUNT_EVENTSUBDETAIL_WHERE = "SELECT COUNT(eventSubDetail) FROM EventSubDetail eventSubDetail WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eventSubDetail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EventSubDetail exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EventSubDetail exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EventSubDetailPersistenceImpl.class);
	private static EventSubDetail _nullEventSubDetail = new EventSubDetailImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EventSubDetail> toCacheModel() {
				return _nullEventSubDetailCacheModel;
			}
		};

	private static CacheModel<EventSubDetail> _nullEventSubDetailCacheModel = new CacheModel<EventSubDetail>() {
			@Override
			public EventSubDetail toEntityModel() {
				return _nullEventSubDetail;
			}
		};
}