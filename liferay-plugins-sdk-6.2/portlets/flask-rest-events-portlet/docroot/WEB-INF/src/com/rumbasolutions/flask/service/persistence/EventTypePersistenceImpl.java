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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rumbasolutions.flask.NoSuchEventTypeException;
import com.rumbasolutions.flask.model.EventType;
import com.rumbasolutions.flask.model.impl.EventTypeImpl;
import com.rumbasolutions.flask.model.impl.EventTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the event type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventTypePersistence
 * @see EventTypeUtil
 * @generated
 */
public class EventTypePersistenceImpl extends BasePersistenceImpl<EventType>
	implements EventTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EventTypeUtil} to access the event type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EventTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventTypeModelImpl.ENTITY_CACHE_ENABLED,
			EventTypeModelImpl.FINDER_CACHE_ENABLED, EventTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventTypeModelImpl.ENTITY_CACHE_ENABLED,
			EventTypeModelImpl.FINDER_CACHE_ENABLED, EventTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventTypeModelImpl.ENTITY_CACHE_ENABLED,
			EventTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EventTypePersistenceImpl() {
		setModelClass(EventType.class);
	}

	/**
	 * Caches the event type in the entity cache if it is enabled.
	 *
	 * @param eventType the event type
	 */
	@Override
	public void cacheResult(EventType eventType) {
		EntityCacheUtil.putResult(EventTypeModelImpl.ENTITY_CACHE_ENABLED,
			EventTypeImpl.class, eventType.getPrimaryKey(), eventType);

		eventType.resetOriginalValues();
	}

	/**
	 * Caches the event types in the entity cache if it is enabled.
	 *
	 * @param eventTypes the event types
	 */
	@Override
	public void cacheResult(List<EventType> eventTypes) {
		for (EventType eventType : eventTypes) {
			if (EntityCacheUtil.getResult(
						EventTypeModelImpl.ENTITY_CACHE_ENABLED,
						EventTypeImpl.class, eventType.getPrimaryKey()) == null) {
				cacheResult(eventType);
			}
			else {
				eventType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all event types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EventTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EventTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the event type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EventType eventType) {
		EntityCacheUtil.removeResult(EventTypeModelImpl.ENTITY_CACHE_ENABLED,
			EventTypeImpl.class, eventType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EventType> eventTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EventType eventType : eventTypes) {
			EntityCacheUtil.removeResult(EventTypeModelImpl.ENTITY_CACHE_ENABLED,
				EventTypeImpl.class, eventType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new event type with the primary key. Does not add the event type to the database.
	 *
	 * @param eventTypeId the primary key for the new event type
	 * @return the new event type
	 */
	@Override
	public EventType create(long eventTypeId) {
		EventType eventType = new EventTypeImpl();

		eventType.setNew(true);
		eventType.setPrimaryKey(eventTypeId);

		return eventType;
	}

	/**
	 * Removes the event type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventTypeId the primary key of the event type
	 * @return the event type that was removed
	 * @throws com.rumbasolutions.flask.NoSuchEventTypeException if a event type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventType remove(long eventTypeId)
		throws NoSuchEventTypeException, SystemException {
		return remove((Serializable)eventTypeId);
	}

	/**
	 * Removes the event type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the event type
	 * @return the event type that was removed
	 * @throws com.rumbasolutions.flask.NoSuchEventTypeException if a event type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventType remove(Serializable primaryKey)
		throws NoSuchEventTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EventType eventType = (EventType)session.get(EventTypeImpl.class,
					primaryKey);

			if (eventType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eventType);
		}
		catch (NoSuchEventTypeException nsee) {
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
	protected EventType removeImpl(EventType eventType)
		throws SystemException {
		eventType = toUnwrappedModel(eventType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eventType)) {
				eventType = (EventType)session.get(EventTypeImpl.class,
						eventType.getPrimaryKeyObj());
			}

			if (eventType != null) {
				session.delete(eventType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eventType != null) {
			clearCache(eventType);
		}

		return eventType;
	}

	@Override
	public EventType updateImpl(
		com.rumbasolutions.flask.model.EventType eventType)
		throws SystemException {
		eventType = toUnwrappedModel(eventType);

		boolean isNew = eventType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (eventType.isNew()) {
				session.save(eventType);

				eventType.setNew(false);
			}
			else {
				session.merge(eventType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(EventTypeModelImpl.ENTITY_CACHE_ENABLED,
			EventTypeImpl.class, eventType.getPrimaryKey(), eventType);

		return eventType;
	}

	protected EventType toUnwrappedModel(EventType eventType) {
		if (eventType instanceof EventTypeImpl) {
			return eventType;
		}

		EventTypeImpl eventTypeImpl = new EventTypeImpl();

		eventTypeImpl.setNew(eventType.isNew());
		eventTypeImpl.setPrimaryKey(eventType.getPrimaryKey());

		eventTypeImpl.setEventTypeId(eventType.getEventTypeId());
		eventTypeImpl.setEventTypeKey(eventType.getEventTypeKey());
		eventTypeImpl.setEventTypeName(eventType.getEventTypeName());

		return eventTypeImpl;
	}

	/**
	 * Returns the event type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the event type
	 * @return the event type
	 * @throws com.rumbasolutions.flask.NoSuchEventTypeException if a event type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventTypeException, SystemException {
		EventType eventType = fetchByPrimaryKey(primaryKey);

		if (eventType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eventType;
	}

	/**
	 * Returns the event type with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchEventTypeException} if it could not be found.
	 *
	 * @param eventTypeId the primary key of the event type
	 * @return the event type
	 * @throws com.rumbasolutions.flask.NoSuchEventTypeException if a event type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventType findByPrimaryKey(long eventTypeId)
		throws NoSuchEventTypeException, SystemException {
		return findByPrimaryKey((Serializable)eventTypeId);
	}

	/**
	 * Returns the event type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the event type
	 * @return the event type, or <code>null</code> if a event type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EventType eventType = (EventType)EntityCacheUtil.getResult(EventTypeModelImpl.ENTITY_CACHE_ENABLED,
				EventTypeImpl.class, primaryKey);

		if (eventType == _nullEventType) {
			return null;
		}

		if (eventType == null) {
			Session session = null;

			try {
				session = openSession();

				eventType = (EventType)session.get(EventTypeImpl.class,
						primaryKey);

				if (eventType != null) {
					cacheResult(eventType);
				}
				else {
					EntityCacheUtil.putResult(EventTypeModelImpl.ENTITY_CACHE_ENABLED,
						EventTypeImpl.class, primaryKey, _nullEventType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EventTypeModelImpl.ENTITY_CACHE_ENABLED,
					EventTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eventType;
	}

	/**
	 * Returns the event type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventTypeId the primary key of the event type
	 * @return the event type, or <code>null</code> if a event type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventType fetchByPrimaryKey(long eventTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)eventTypeId);
	}

	/**
	 * Returns all the event types.
	 *
	 * @return the event types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event types
	 * @param end the upper bound of the range of event types (not inclusive)
	 * @return the range of event types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the event types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event types
	 * @param end the upper bound of the range of event types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventType> findAll(int start, int end,
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

		List<EventType> list = (List<EventType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EVENTTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTTYPE;

				if (pagination) {
					sql = sql.concat(EventTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EventType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EventType>(list);
				}
				else {
					list = (List<EventType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the event types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EventType eventType : findAll()) {
			remove(eventType);
		}
	}

	/**
	 * Returns the number of event types.
	 *
	 * @return the number of event types
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

				Query q = session.createQuery(_SQL_COUNT_EVENTTYPE);

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
	 * Initializes the event type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.EventType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EventType>> listenersList = new ArrayList<ModelListener<EventType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EventType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EventTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EVENTTYPE = "SELECT eventType FROM EventType eventType";
	private static final String _SQL_COUNT_EVENTTYPE = "SELECT COUNT(eventType) FROM EventType eventType";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eventType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EventType exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EventTypePersistenceImpl.class);
	private static EventType _nullEventType = new EventTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EventType> toCacheModel() {
				return _nullEventTypeCacheModel;
			}
		};

	private static CacheModel<EventType> _nullEventTypeCacheModel = new CacheModel<EventType>() {
			@Override
			public EventType toEntityModel() {
				return _nullEventType;
			}
		};
}