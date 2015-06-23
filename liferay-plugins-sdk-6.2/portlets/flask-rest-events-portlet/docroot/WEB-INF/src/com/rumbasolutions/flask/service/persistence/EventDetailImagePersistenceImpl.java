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

import com.rumbasolutions.flask.NoSuchEventDetailImageException;
import com.rumbasolutions.flask.model.EventDetailImage;
import com.rumbasolutions.flask.model.impl.EventDetailImageImpl;
import com.rumbasolutions.flask.model.impl.EventDetailImageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the event detail image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventDetailImagePersistence
 * @see EventDetailImageUtil
 * @generated
 */
public class EventDetailImagePersistenceImpl extends BasePersistenceImpl<EventDetailImage>
	implements EventDetailImagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EventDetailImageUtil} to access the event detail image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EventDetailImageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailImageModelImpl.FINDER_CACHE_ENABLED,
			EventDetailImageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailImageModelImpl.FINDER_CACHE_ENABLED,
			EventDetailImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTDETAILID =
		new FinderPath(EventDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailImageModelImpl.FINDER_CACHE_ENABLED,
			EventDetailImageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEventDetailId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTDETAILID =
		new FinderPath(EventDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailImageModelImpl.FINDER_CACHE_ENABLED,
			EventDetailImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventDetailId",
			new String[] { Long.class.getName() },
			EventDetailImageModelImpl.EVENTDETAILID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTDETAILID = new FinderPath(EventDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventDetailId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the event detail images where eventDetailId = &#63;.
	 *
	 * @param eventDetailId the event detail ID
	 * @return the matching event detail images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetailImage> findByEventDetailId(long eventDetailId)
		throws SystemException {
		return findByEventDetailId(eventDetailId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event detail images where eventDetailId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventDetailId the event detail ID
	 * @param start the lower bound of the range of event detail images
	 * @param end the upper bound of the range of event detail images (not inclusive)
	 * @return the range of matching event detail images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetailImage> findByEventDetailId(long eventDetailId,
		int start, int end) throws SystemException {
		return findByEventDetailId(eventDetailId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the event detail images where eventDetailId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventDetailId the event detail ID
	 * @param start the lower bound of the range of event detail images
	 * @param end the upper bound of the range of event detail images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event detail images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetailImage> findByEventDetailId(long eventDetailId,
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

		List<EventDetailImage> list = (List<EventDetailImage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EventDetailImage eventDetailImage : list) {
				if ((eventDetailId != eventDetailImage.getEventDetailId())) {
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

			query.append(_SQL_SELECT_EVENTDETAILIMAGE_WHERE);

			query.append(_FINDER_COLUMN_EVENTDETAILID_EVENTDETAILID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventDetailImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventDetailId);

				if (!pagination) {
					list = (List<EventDetailImage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventDetailImage>(list);
				}
				else {
					list = (List<EventDetailImage>)QueryUtil.list(q,
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
	 * Returns the first event detail image in the ordered set where eventDetailId = &#63;.
	 *
	 * @param eventDetailId the event detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event detail image
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailImageException if a matching event detail image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetailImage findByEventDetailId_First(long eventDetailId,
		OrderByComparator orderByComparator)
		throws NoSuchEventDetailImageException, SystemException {
		EventDetailImage eventDetailImage = fetchByEventDetailId_First(eventDetailId,
				orderByComparator);

		if (eventDetailImage != null) {
			return eventDetailImage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventDetailId=");
		msg.append(eventDetailId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventDetailImageException(msg.toString());
	}

	/**
	 * Returns the first event detail image in the ordered set where eventDetailId = &#63;.
	 *
	 * @param eventDetailId the event detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event detail image, or <code>null</code> if a matching event detail image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetailImage fetchByEventDetailId_First(long eventDetailId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EventDetailImage> list = findByEventDetailId(eventDetailId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event detail image in the ordered set where eventDetailId = &#63;.
	 *
	 * @param eventDetailId the event detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event detail image
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailImageException if a matching event detail image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetailImage findByEventDetailId_Last(long eventDetailId,
		OrderByComparator orderByComparator)
		throws NoSuchEventDetailImageException, SystemException {
		EventDetailImage eventDetailImage = fetchByEventDetailId_Last(eventDetailId,
				orderByComparator);

		if (eventDetailImage != null) {
			return eventDetailImage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventDetailId=");
		msg.append(eventDetailId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventDetailImageException(msg.toString());
	}

	/**
	 * Returns the last event detail image in the ordered set where eventDetailId = &#63;.
	 *
	 * @param eventDetailId the event detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event detail image, or <code>null</code> if a matching event detail image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetailImage fetchByEventDetailId_Last(long eventDetailId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEventDetailId(eventDetailId);

		if (count == 0) {
			return null;
		}

		List<EventDetailImage> list = findByEventDetailId(eventDetailId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event detail images before and after the current event detail image in the ordered set where eventDetailId = &#63;.
	 *
	 * @param eventDetailImageId the primary key of the current event detail image
	 * @param eventDetailId the event detail ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event detail image
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailImageException if a event detail image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetailImage[] findByEventDetailId_PrevAndNext(
		long eventDetailImageId, long eventDetailId,
		OrderByComparator orderByComparator)
		throws NoSuchEventDetailImageException, SystemException {
		EventDetailImage eventDetailImage = findByPrimaryKey(eventDetailImageId);

		Session session = null;

		try {
			session = openSession();

			EventDetailImage[] array = new EventDetailImageImpl[3];

			array[0] = getByEventDetailId_PrevAndNext(session,
					eventDetailImage, eventDetailId, orderByComparator, true);

			array[1] = eventDetailImage;

			array[2] = getByEventDetailId_PrevAndNext(session,
					eventDetailImage, eventDetailId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventDetailImage getByEventDetailId_PrevAndNext(Session session,
		EventDetailImage eventDetailImage, long eventDetailId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTDETAILIMAGE_WHERE);

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
			query.append(EventDetailImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(eventDetailId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eventDetailImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EventDetailImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the event detail images where eventDetailId = &#63; from the database.
	 *
	 * @param eventDetailId the event detail ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEventDetailId(long eventDetailId)
		throws SystemException {
		for (EventDetailImage eventDetailImage : findByEventDetailId(
				eventDetailId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eventDetailImage);
		}
	}

	/**
	 * Returns the number of event detail images where eventDetailId = &#63;.
	 *
	 * @param eventDetailId the event detail ID
	 * @return the number of matching event detail images
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

			query.append(_SQL_COUNT_EVENTDETAILIMAGE_WHERE);

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

	private static final String _FINDER_COLUMN_EVENTDETAILID_EVENTDETAILID_2 = "eventDetailImage.eventDetailId = ?";

	public EventDetailImagePersistenceImpl() {
		setModelClass(EventDetailImage.class);
	}

	/**
	 * Caches the event detail image in the entity cache if it is enabled.
	 *
	 * @param eventDetailImage the event detail image
	 */
	@Override
	public void cacheResult(EventDetailImage eventDetailImage) {
		EntityCacheUtil.putResult(EventDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailImageImpl.class, eventDetailImage.getPrimaryKey(),
			eventDetailImage);

		eventDetailImage.resetOriginalValues();
	}

	/**
	 * Caches the event detail images in the entity cache if it is enabled.
	 *
	 * @param eventDetailImages the event detail images
	 */
	@Override
	public void cacheResult(List<EventDetailImage> eventDetailImages) {
		for (EventDetailImage eventDetailImage : eventDetailImages) {
			if (EntityCacheUtil.getResult(
						EventDetailImageModelImpl.ENTITY_CACHE_ENABLED,
						EventDetailImageImpl.class,
						eventDetailImage.getPrimaryKey()) == null) {
				cacheResult(eventDetailImage);
			}
			else {
				eventDetailImage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all event detail images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EventDetailImageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EventDetailImageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the event detail image.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EventDetailImage eventDetailImage) {
		EntityCacheUtil.removeResult(EventDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailImageImpl.class, eventDetailImage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EventDetailImage> eventDetailImages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EventDetailImage eventDetailImage : eventDetailImages) {
			EntityCacheUtil.removeResult(EventDetailImageModelImpl.ENTITY_CACHE_ENABLED,
				EventDetailImageImpl.class, eventDetailImage.getPrimaryKey());
		}
	}

	/**
	 * Creates a new event detail image with the primary key. Does not add the event detail image to the database.
	 *
	 * @param eventDetailImageId the primary key for the new event detail image
	 * @return the new event detail image
	 */
	@Override
	public EventDetailImage create(long eventDetailImageId) {
		EventDetailImage eventDetailImage = new EventDetailImageImpl();

		eventDetailImage.setNew(true);
		eventDetailImage.setPrimaryKey(eventDetailImageId);

		return eventDetailImage;
	}

	/**
	 * Removes the event detail image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventDetailImageId the primary key of the event detail image
	 * @return the event detail image that was removed
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailImageException if a event detail image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetailImage remove(long eventDetailImageId)
		throws NoSuchEventDetailImageException, SystemException {
		return remove((Serializable)eventDetailImageId);
	}

	/**
	 * Removes the event detail image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the event detail image
	 * @return the event detail image that was removed
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailImageException if a event detail image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetailImage remove(Serializable primaryKey)
		throws NoSuchEventDetailImageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EventDetailImage eventDetailImage = (EventDetailImage)session.get(EventDetailImageImpl.class,
					primaryKey);

			if (eventDetailImage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventDetailImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eventDetailImage);
		}
		catch (NoSuchEventDetailImageException nsee) {
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
	protected EventDetailImage removeImpl(EventDetailImage eventDetailImage)
		throws SystemException {
		eventDetailImage = toUnwrappedModel(eventDetailImage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eventDetailImage)) {
				eventDetailImage = (EventDetailImage)session.get(EventDetailImageImpl.class,
						eventDetailImage.getPrimaryKeyObj());
			}

			if (eventDetailImage != null) {
				session.delete(eventDetailImage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eventDetailImage != null) {
			clearCache(eventDetailImage);
		}

		return eventDetailImage;
	}

	@Override
	public EventDetailImage updateImpl(
		com.rumbasolutions.flask.model.EventDetailImage eventDetailImage)
		throws SystemException {
		eventDetailImage = toUnwrappedModel(eventDetailImage);

		boolean isNew = eventDetailImage.isNew();

		EventDetailImageModelImpl eventDetailImageModelImpl = (EventDetailImageModelImpl)eventDetailImage;

		Session session = null;

		try {
			session = openSession();

			if (eventDetailImage.isNew()) {
				session.save(eventDetailImage);

				eventDetailImage.setNew(false);
			}
			else {
				session.merge(eventDetailImage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EventDetailImageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eventDetailImageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTDETAILID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventDetailImageModelImpl.getOriginalEventDetailId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTDETAILID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTDETAILID,
					args);

				args = new Object[] { eventDetailImageModelImpl.getEventDetailId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTDETAILID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTDETAILID,
					args);
			}
		}

		EntityCacheUtil.putResult(EventDetailImageModelImpl.ENTITY_CACHE_ENABLED,
			EventDetailImageImpl.class, eventDetailImage.getPrimaryKey(),
			eventDetailImage);

		return eventDetailImage;
	}

	protected EventDetailImage toUnwrappedModel(
		EventDetailImage eventDetailImage) {
		if (eventDetailImage instanceof EventDetailImageImpl) {
			return eventDetailImage;
		}

		EventDetailImageImpl eventDetailImageImpl = new EventDetailImageImpl();

		eventDetailImageImpl.setNew(eventDetailImage.isNew());
		eventDetailImageImpl.setPrimaryKey(eventDetailImage.getPrimaryKey());

		eventDetailImageImpl.setEventDetailImageId(eventDetailImage.getEventDetailImageId());
		eventDetailImageImpl.setCompanyId(eventDetailImage.getCompanyId());
		eventDetailImageImpl.setUserId(eventDetailImage.getUserId());
		eventDetailImageImpl.setCreatedDate(eventDetailImage.getCreatedDate());
		eventDetailImageImpl.setModifiedDate(eventDetailImage.getModifiedDate());
		eventDetailImageImpl.setEventDetailId(eventDetailImage.getEventDetailId());
		eventDetailImageImpl.setImageTitle(eventDetailImage.getImageTitle());
		eventDetailImageImpl.setImageDesc(eventDetailImage.getImageDesc());
		eventDetailImageImpl.setImagePath(eventDetailImage.getImagePath());

		return eventDetailImageImpl;
	}

	/**
	 * Returns the event detail image with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the event detail image
	 * @return the event detail image
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailImageException if a event detail image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetailImage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventDetailImageException, SystemException {
		EventDetailImage eventDetailImage = fetchByPrimaryKey(primaryKey);

		if (eventDetailImage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventDetailImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eventDetailImage;
	}

	/**
	 * Returns the event detail image with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchEventDetailImageException} if it could not be found.
	 *
	 * @param eventDetailImageId the primary key of the event detail image
	 * @return the event detail image
	 * @throws com.rumbasolutions.flask.NoSuchEventDetailImageException if a event detail image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetailImage findByPrimaryKey(long eventDetailImageId)
		throws NoSuchEventDetailImageException, SystemException {
		return findByPrimaryKey((Serializable)eventDetailImageId);
	}

	/**
	 * Returns the event detail image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the event detail image
	 * @return the event detail image, or <code>null</code> if a event detail image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetailImage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EventDetailImage eventDetailImage = (EventDetailImage)EntityCacheUtil.getResult(EventDetailImageModelImpl.ENTITY_CACHE_ENABLED,
				EventDetailImageImpl.class, primaryKey);

		if (eventDetailImage == _nullEventDetailImage) {
			return null;
		}

		if (eventDetailImage == null) {
			Session session = null;

			try {
				session = openSession();

				eventDetailImage = (EventDetailImage)session.get(EventDetailImageImpl.class,
						primaryKey);

				if (eventDetailImage != null) {
					cacheResult(eventDetailImage);
				}
				else {
					EntityCacheUtil.putResult(EventDetailImageModelImpl.ENTITY_CACHE_ENABLED,
						EventDetailImageImpl.class, primaryKey,
						_nullEventDetailImage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EventDetailImageModelImpl.ENTITY_CACHE_ENABLED,
					EventDetailImageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eventDetailImage;
	}

	/**
	 * Returns the event detail image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventDetailImageId the primary key of the event detail image
	 * @return the event detail image, or <code>null</code> if a event detail image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetailImage fetchByPrimaryKey(long eventDetailImageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)eventDetailImageId);
	}

	/**
	 * Returns all the event detail images.
	 *
	 * @return the event detail images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetailImage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event detail images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event detail images
	 * @param end the upper bound of the range of event detail images (not inclusive)
	 * @return the range of event detail images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetailImage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the event detail images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event detail images
	 * @param end the upper bound of the range of event detail images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event detail images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetailImage> findAll(int start, int end,
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

		List<EventDetailImage> list = (List<EventDetailImage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EVENTDETAILIMAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTDETAILIMAGE;

				if (pagination) {
					sql = sql.concat(EventDetailImageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EventDetailImage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventDetailImage>(list);
				}
				else {
					list = (List<EventDetailImage>)QueryUtil.list(q,
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
	 * Removes all the event detail images from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EventDetailImage eventDetailImage : findAll()) {
			remove(eventDetailImage);
		}
	}

	/**
	 * Returns the number of event detail images.
	 *
	 * @return the number of event detail images
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

				Query q = session.createQuery(_SQL_COUNT_EVENTDETAILIMAGE);

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
	 * Initializes the event detail image persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.EventDetailImage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EventDetailImage>> listenersList = new ArrayList<ModelListener<EventDetailImage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EventDetailImage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EventDetailImageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EVENTDETAILIMAGE = "SELECT eventDetailImage FROM EventDetailImage eventDetailImage";
	private static final String _SQL_SELECT_EVENTDETAILIMAGE_WHERE = "SELECT eventDetailImage FROM EventDetailImage eventDetailImage WHERE ";
	private static final String _SQL_COUNT_EVENTDETAILIMAGE = "SELECT COUNT(eventDetailImage) FROM EventDetailImage eventDetailImage";
	private static final String _SQL_COUNT_EVENTDETAILIMAGE_WHERE = "SELECT COUNT(eventDetailImage) FROM EventDetailImage eventDetailImage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eventDetailImage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EventDetailImage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EventDetailImage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EventDetailImagePersistenceImpl.class);
	private static EventDetailImage _nullEventDetailImage = new EventDetailImageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EventDetailImage> toCacheModel() {
				return _nullEventDetailImageCacheModel;
			}
		};

	private static CacheModel<EventDetailImage> _nullEventDetailImageCacheModel = new CacheModel<EventDetailImage>() {
			@Override
			public EventDetailImage toEntityModel() {
				return _nullEventDetailImage;
			}
		};
}