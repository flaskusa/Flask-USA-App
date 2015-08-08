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

import com.rumbasolutions.flask.NoSuchCampaignEventException;
import com.rumbasolutions.flask.model.CampaignEvent;
import com.rumbasolutions.flask.model.impl.CampaignEventImpl;
import com.rumbasolutions.flask.model.impl.CampaignEventModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the campaign event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignEventPersistence
 * @see CampaignEventUtil
 * @generated
 */
public class CampaignEventPersistenceImpl extends BasePersistenceImpl<CampaignEvent>
	implements CampaignEventPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CampaignEventUtil} to access the campaign event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CampaignEventImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CampaignEventModelImpl.ENTITY_CACHE_ENABLED,
			CampaignEventModelImpl.FINDER_CACHE_ENABLED,
			CampaignEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CampaignEventModelImpl.ENTITY_CACHE_ENABLED,
			CampaignEventModelImpl.FINDER_CACHE_ENABLED,
			CampaignEventImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CampaignEventModelImpl.ENTITY_CACHE_ENABLED,
			CampaignEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(CampaignEventModelImpl.ENTITY_CACHE_ENABLED,
			CampaignEventModelImpl.FINDER_CACHE_ENABLED,
			CampaignEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBycampaignId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID =
		new FinderPath(CampaignEventModelImpl.ENTITY_CACHE_ENABLED,
			CampaignEventModelImpl.FINDER_CACHE_ENABLED,
			CampaignEventImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBycampaignId", new String[] { Long.class.getName() },
			CampaignEventModelImpl.CAMPAIGNID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CAMPAIGNID = new FinderPath(CampaignEventModelImpl.ENTITY_CACHE_ENABLED,
			CampaignEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycampaignId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the campaign events where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the matching campaign events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignEvent> findBycampaignId(long campaignId)
		throws SystemException {
		return findBycampaignId(campaignId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign events where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @return the range of matching campaign events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignEvent> findBycampaignId(long campaignId, int start,
		int end) throws SystemException {
		return findBycampaignId(campaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign events where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignEvent> findBycampaignId(long campaignId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID;
			finderArgs = new Object[] { campaignId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CAMPAIGNID;
			finderArgs = new Object[] { campaignId, start, end, orderByComparator };
		}

		List<CampaignEvent> list = (List<CampaignEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CampaignEvent campaignEvent : list) {
				if ((campaignId != campaignEvent.getCampaignId())) {
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

			query.append(_SQL_SELECT_CAMPAIGNEVENT_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CampaignEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

				if (!pagination) {
					list = (List<CampaignEvent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CampaignEvent>(list);
				}
				else {
					list = (List<CampaignEvent>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first campaign event in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event
	 * @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a matching campaign event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignEvent findBycampaignId_First(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignEventException, SystemException {
		CampaignEvent campaignEvent = fetchBycampaignId_First(campaignId,
				orderByComparator);

		if (campaignEvent != null) {
			return campaignEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignEventException(msg.toString());
	}

	/**
	 * Returns the first campaign event in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event, or <code>null</code> if a matching campaign event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignEvent fetchBycampaignId_First(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CampaignEvent> list = findBycampaignId(campaignId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign event in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event
	 * @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a matching campaign event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignEvent findBycampaignId_Last(long campaignId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignEventException, SystemException {
		CampaignEvent campaignEvent = fetchBycampaignId_Last(campaignId,
				orderByComparator);

		if (campaignEvent != null) {
			return campaignEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("campaignId=");
		msg.append(campaignId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignEventException(msg.toString());
	}

	/**
	 * Returns the last campaign event in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event, or <code>null</code> if a matching campaign event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignEvent fetchBycampaignId_Last(long campaignId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBycampaignId(campaignId);

		if (count == 0) {
			return null;
		}

		List<CampaignEvent> list = findBycampaignId(campaignId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaign events before and after the current campaign event in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignEventId the primary key of the current campaign event
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign event
	 * @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a campaign event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignEvent[] findBycampaignId_PrevAndNext(long campaignEventId,
		long campaignId, OrderByComparator orderByComparator)
		throws NoSuchCampaignEventException, SystemException {
		CampaignEvent campaignEvent = findByPrimaryKey(campaignEventId);

		Session session = null;

		try {
			session = openSession();

			CampaignEvent[] array = new CampaignEventImpl[3];

			array[0] = getBycampaignId_PrevAndNext(session, campaignEvent,
					campaignId, orderByComparator, true);

			array[1] = campaignEvent;

			array[2] = getBycampaignId_PrevAndNext(session, campaignEvent,
					campaignId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CampaignEvent getBycampaignId_PrevAndNext(Session session,
		CampaignEvent campaignEvent, long campaignId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGNEVENT_WHERE);

		query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

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
			query.append(CampaignEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(campaignId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(campaignEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CampaignEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campaign events where campaignId = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycampaignId(long campaignId) throws SystemException {
		for (CampaignEvent campaignEvent : findBycampaignId(campaignId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(campaignEvent);
		}
	}

	/**
	 * Returns the number of campaign events where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the number of matching campaign events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycampaignId(long campaignId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CAMPAIGNID;

		Object[] finderArgs = new Object[] { campaignId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAMPAIGNEVENT_WHERE);

			query.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(campaignId);

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

	private static final String _FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2 = "campaignEvent.campaignId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTID = new FinderPath(CampaignEventModelImpl.ENTITY_CACHE_ENABLED,
			CampaignEventModelImpl.FINDER_CACHE_ENABLED,
			CampaignEventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByeventId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID =
		new FinderPath(CampaignEventModelImpl.ENTITY_CACHE_ENABLED,
			CampaignEventModelImpl.FINDER_CACHE_ENABLED,
			CampaignEventImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByeventId", new String[] { Long.class.getName() },
			CampaignEventModelImpl.EVENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTID = new FinderPath(CampaignEventModelImpl.ENTITY_CACHE_ENABLED,
			CampaignEventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByeventId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the campaign events where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the matching campaign events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignEvent> findByeventId(long eventId)
		throws SystemException {
		return findByeventId(eventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign events where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @return the range of matching campaign events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignEvent> findByeventId(long eventId, int start, int end)
		throws SystemException {
		return findByeventId(eventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign events where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignEvent> findByeventId(long eventId, int start, int end,
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

		List<CampaignEvent> list = (List<CampaignEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CampaignEvent campaignEvent : list) {
				if ((eventId != campaignEvent.getEventId())) {
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

			query.append(_SQL_SELECT_CAMPAIGNEVENT_WHERE);

			query.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CampaignEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventId);

				if (!pagination) {
					list = (List<CampaignEvent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CampaignEvent>(list);
				}
				else {
					list = (List<CampaignEvent>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first campaign event in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event
	 * @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a matching campaign event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignEvent findByeventId_First(long eventId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignEventException, SystemException {
		CampaignEvent campaignEvent = fetchByeventId_First(eventId,
				orderByComparator);

		if (campaignEvent != null) {
			return campaignEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventId=");
		msg.append(eventId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignEventException(msg.toString());
	}

	/**
	 * Returns the first campaign event in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event, or <code>null</code> if a matching campaign event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignEvent fetchByeventId_First(long eventId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CampaignEvent> list = findByeventId(eventId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign event in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event
	 * @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a matching campaign event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignEvent findByeventId_Last(long eventId,
		OrderByComparator orderByComparator)
		throws NoSuchCampaignEventException, SystemException {
		CampaignEvent campaignEvent = fetchByeventId_Last(eventId,
				orderByComparator);

		if (campaignEvent != null) {
			return campaignEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventId=");
		msg.append(eventId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCampaignEventException(msg.toString());
	}

	/**
	 * Returns the last campaign event in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event, or <code>null</code> if a matching campaign event could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignEvent fetchByeventId_Last(long eventId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByeventId(eventId);

		if (count == 0) {
			return null;
		}

		List<CampaignEvent> list = findByeventId(eventId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaign events before and after the current campaign event in the ordered set where eventId = &#63;.
	 *
	 * @param campaignEventId the primary key of the current campaign event
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign event
	 * @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a campaign event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignEvent[] findByeventId_PrevAndNext(long campaignEventId,
		long eventId, OrderByComparator orderByComparator)
		throws NoSuchCampaignEventException, SystemException {
		CampaignEvent campaignEvent = findByPrimaryKey(campaignEventId);

		Session session = null;

		try {
			session = openSession();

			CampaignEvent[] array = new CampaignEventImpl[3];

			array[0] = getByeventId_PrevAndNext(session, campaignEvent,
					eventId, orderByComparator, true);

			array[1] = campaignEvent;

			array[2] = getByeventId_PrevAndNext(session, campaignEvent,
					eventId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CampaignEvent getByeventId_PrevAndNext(Session session,
		CampaignEvent campaignEvent, long eventId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAMPAIGNEVENT_WHERE);

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
			query.append(CampaignEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(eventId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(campaignEvent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CampaignEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campaign events where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByeventId(long eventId) throws SystemException {
		for (CampaignEvent campaignEvent : findByeventId(eventId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(campaignEvent);
		}
	}

	/**
	 * Returns the number of campaign events where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching campaign events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByeventId(long eventId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTID;

		Object[] finderArgs = new Object[] { eventId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAMPAIGNEVENT_WHERE);

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

	private static final String _FINDER_COLUMN_EVENTID_EVENTID_2 = "campaignEvent.eventId = ?";

	public CampaignEventPersistenceImpl() {
		setModelClass(CampaignEvent.class);
	}

	/**
	 * Caches the campaign event in the entity cache if it is enabled.
	 *
	 * @param campaignEvent the campaign event
	 */
	@Override
	public void cacheResult(CampaignEvent campaignEvent) {
		EntityCacheUtil.putResult(CampaignEventModelImpl.ENTITY_CACHE_ENABLED,
			CampaignEventImpl.class, campaignEvent.getPrimaryKey(),
			campaignEvent);

		campaignEvent.resetOriginalValues();
	}

	/**
	 * Caches the campaign events in the entity cache if it is enabled.
	 *
	 * @param campaignEvents the campaign events
	 */
	@Override
	public void cacheResult(List<CampaignEvent> campaignEvents) {
		for (CampaignEvent campaignEvent : campaignEvents) {
			if (EntityCacheUtil.getResult(
						CampaignEventModelImpl.ENTITY_CACHE_ENABLED,
						CampaignEventImpl.class, campaignEvent.getPrimaryKey()) == null) {
				cacheResult(campaignEvent);
			}
			else {
				campaignEvent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all campaign events.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CampaignEventImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CampaignEventImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the campaign event.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CampaignEvent campaignEvent) {
		EntityCacheUtil.removeResult(CampaignEventModelImpl.ENTITY_CACHE_ENABLED,
			CampaignEventImpl.class, campaignEvent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CampaignEvent> campaignEvents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CampaignEvent campaignEvent : campaignEvents) {
			EntityCacheUtil.removeResult(CampaignEventModelImpl.ENTITY_CACHE_ENABLED,
				CampaignEventImpl.class, campaignEvent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new campaign event with the primary key. Does not add the campaign event to the database.
	 *
	 * @param campaignEventId the primary key for the new campaign event
	 * @return the new campaign event
	 */
	@Override
	public CampaignEvent create(long campaignEventId) {
		CampaignEvent campaignEvent = new CampaignEventImpl();

		campaignEvent.setNew(true);
		campaignEvent.setPrimaryKey(campaignEventId);

		return campaignEvent;
	}

	/**
	 * Removes the campaign event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campaignEventId the primary key of the campaign event
	 * @return the campaign event that was removed
	 * @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a campaign event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignEvent remove(long campaignEventId)
		throws NoSuchCampaignEventException, SystemException {
		return remove((Serializable)campaignEventId);
	}

	/**
	 * Removes the campaign event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the campaign event
	 * @return the campaign event that was removed
	 * @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a campaign event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignEvent remove(Serializable primaryKey)
		throws NoSuchCampaignEventException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CampaignEvent campaignEvent = (CampaignEvent)session.get(CampaignEventImpl.class,
					primaryKey);

			if (campaignEvent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCampaignEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(campaignEvent);
		}
		catch (NoSuchCampaignEventException nsee) {
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
	protected CampaignEvent removeImpl(CampaignEvent campaignEvent)
		throws SystemException {
		campaignEvent = toUnwrappedModel(campaignEvent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(campaignEvent)) {
				campaignEvent = (CampaignEvent)session.get(CampaignEventImpl.class,
						campaignEvent.getPrimaryKeyObj());
			}

			if (campaignEvent != null) {
				session.delete(campaignEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (campaignEvent != null) {
			clearCache(campaignEvent);
		}

		return campaignEvent;
	}

	@Override
	public CampaignEvent updateImpl(
		com.rumbasolutions.flask.model.CampaignEvent campaignEvent)
		throws SystemException {
		campaignEvent = toUnwrappedModel(campaignEvent);

		boolean isNew = campaignEvent.isNew();

		CampaignEventModelImpl campaignEventModelImpl = (CampaignEventModelImpl)campaignEvent;

		Session session = null;

		try {
			session = openSession();

			if (campaignEvent.isNew()) {
				session.save(campaignEvent);

				campaignEvent.setNew(false);
			}
			else {
				session.merge(campaignEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CampaignEventModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((campaignEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						campaignEventModelImpl.getOriginalCampaignId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);

				args = new Object[] { campaignEventModelImpl.getCampaignId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CAMPAIGNID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CAMPAIGNID,
					args);
			}

			if ((campaignEventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						campaignEventModelImpl.getOriginalEventId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID,
					args);

				args = new Object[] { campaignEventModelImpl.getEventId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID,
					args);
			}
		}

		EntityCacheUtil.putResult(CampaignEventModelImpl.ENTITY_CACHE_ENABLED,
			CampaignEventImpl.class, campaignEvent.getPrimaryKey(),
			campaignEvent);

		return campaignEvent;
	}

	protected CampaignEvent toUnwrappedModel(CampaignEvent campaignEvent) {
		if (campaignEvent instanceof CampaignEventImpl) {
			return campaignEvent;
		}

		CampaignEventImpl campaignEventImpl = new CampaignEventImpl();

		campaignEventImpl.setNew(campaignEvent.isNew());
		campaignEventImpl.setPrimaryKey(campaignEvent.getPrimaryKey());

		campaignEventImpl.setCampaignEventId(campaignEvent.getCampaignEventId());
		campaignEventImpl.setUserId(campaignEvent.getUserId());
		campaignEventImpl.setCreatedDate(campaignEvent.getCreatedDate());
		campaignEventImpl.setModifiedDate(campaignEvent.getModifiedDate());
		campaignEventImpl.setCampaignId(campaignEvent.getCampaignId());
		campaignEventImpl.setEventId(campaignEvent.getEventId());

		return campaignEventImpl;
	}

	/**
	 * Returns the campaign event with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign event
	 * @return the campaign event
	 * @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a campaign event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCampaignEventException, SystemException {
		CampaignEvent campaignEvent = fetchByPrimaryKey(primaryKey);

		if (campaignEvent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCampaignEventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return campaignEvent;
	}

	/**
	 * Returns the campaign event with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchCampaignEventException} if it could not be found.
	 *
	 * @param campaignEventId the primary key of the campaign event
	 * @return the campaign event
	 * @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a campaign event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignEvent findByPrimaryKey(long campaignEventId)
		throws NoSuchCampaignEventException, SystemException {
		return findByPrimaryKey((Serializable)campaignEventId);
	}

	/**
	 * Returns the campaign event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign event
	 * @return the campaign event, or <code>null</code> if a campaign event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignEvent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CampaignEvent campaignEvent = (CampaignEvent)EntityCacheUtil.getResult(CampaignEventModelImpl.ENTITY_CACHE_ENABLED,
				CampaignEventImpl.class, primaryKey);

		if (campaignEvent == _nullCampaignEvent) {
			return null;
		}

		if (campaignEvent == null) {
			Session session = null;

			try {
				session = openSession();

				campaignEvent = (CampaignEvent)session.get(CampaignEventImpl.class,
						primaryKey);

				if (campaignEvent != null) {
					cacheResult(campaignEvent);
				}
				else {
					EntityCacheUtil.putResult(CampaignEventModelImpl.ENTITY_CACHE_ENABLED,
						CampaignEventImpl.class, primaryKey, _nullCampaignEvent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CampaignEventModelImpl.ENTITY_CACHE_ENABLED,
					CampaignEventImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return campaignEvent;
	}

	/**
	 * Returns the campaign event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param campaignEventId the primary key of the campaign event
	 * @return the campaign event, or <code>null</code> if a campaign event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignEvent fetchByPrimaryKey(long campaignEventId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)campaignEventId);
	}

	/**
	 * Returns all the campaign events.
	 *
	 * @return the campaign events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignEvent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @return the range of campaign events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignEvent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of campaign events
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignEvent> findAll(int start, int end,
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

		List<CampaignEvent> list = (List<CampaignEvent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CAMPAIGNEVENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAMPAIGNEVENT;

				if (pagination) {
					sql = sql.concat(CampaignEventModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CampaignEvent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CampaignEvent>(list);
				}
				else {
					list = (List<CampaignEvent>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the campaign events from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CampaignEvent campaignEvent : findAll()) {
			remove(campaignEvent);
		}
	}

	/**
	 * Returns the number of campaign events.
	 *
	 * @return the number of campaign events
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

				Query q = session.createQuery(_SQL_COUNT_CAMPAIGNEVENT);

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
	 * Initializes the campaign event persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.CampaignEvent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CampaignEvent>> listenersList = new ArrayList<ModelListener<CampaignEvent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CampaignEvent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CampaignEventImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CAMPAIGNEVENT = "SELECT campaignEvent FROM CampaignEvent campaignEvent";
	private static final String _SQL_SELECT_CAMPAIGNEVENT_WHERE = "SELECT campaignEvent FROM CampaignEvent campaignEvent WHERE ";
	private static final String _SQL_COUNT_CAMPAIGNEVENT = "SELECT COUNT(campaignEvent) FROM CampaignEvent campaignEvent";
	private static final String _SQL_COUNT_CAMPAIGNEVENT_WHERE = "SELECT COUNT(campaignEvent) FROM CampaignEvent campaignEvent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "campaignEvent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CampaignEvent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CampaignEvent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CampaignEventPersistenceImpl.class);
	private static CampaignEvent _nullCampaignEvent = new CampaignEventImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CampaignEvent> toCacheModel() {
				return _nullCampaignEventCacheModel;
			}
		};

	private static CacheModel<CampaignEvent> _nullCampaignEventCacheModel = new CacheModel<CampaignEvent>() {
			@Override
			public CampaignEvent toEntityModel() {
				return _nullCampaignEvent;
			}
		};
}