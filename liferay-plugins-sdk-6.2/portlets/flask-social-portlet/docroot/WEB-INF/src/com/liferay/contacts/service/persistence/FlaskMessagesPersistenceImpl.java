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

package com.liferay.contacts.service.persistence;

import com.liferay.contacts.NoSuchFlaskMessagesException;
import com.liferay.contacts.model.FlaskMessages;
import com.liferay.contacts.model.impl.FlaskMessagesImpl;
import com.liferay.contacts.model.impl.FlaskMessagesModelImpl;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the flask messages service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskMessagesPersistence
 * @see FlaskMessagesUtil
 * @generated
 */
public class FlaskMessagesPersistenceImpl extends BasePersistenceImpl<FlaskMessages>
	implements FlaskMessagesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FlaskMessagesUtil} to access the flask messages persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FlaskMessagesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FlaskMessagesModelImpl.ENTITY_CACHE_ENABLED,
			FlaskMessagesModelImpl.FINDER_CACHE_ENABLED,
			FlaskMessagesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FlaskMessagesModelImpl.ENTITY_CACHE_ENABLED,
			FlaskMessagesModelImpl.FINDER_CACHE_ENABLED,
			FlaskMessagesImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FlaskMessagesModelImpl.ENTITY_CACHE_ENABLED,
			FlaskMessagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FlaskMessagesPersistenceImpl() {
		setModelClass(FlaskMessages.class);
	}

	/**
	 * Caches the flask messages in the entity cache if it is enabled.
	 *
	 * @param flaskMessages the flask messages
	 */
	@Override
	public void cacheResult(FlaskMessages flaskMessages) {
		EntityCacheUtil.putResult(FlaskMessagesModelImpl.ENTITY_CACHE_ENABLED,
			FlaskMessagesImpl.class, flaskMessages.getPrimaryKey(),
			flaskMessages);

		flaskMessages.resetOriginalValues();
	}

	/**
	 * Caches the flask messageses in the entity cache if it is enabled.
	 *
	 * @param flaskMessageses the flask messageses
	 */
	@Override
	public void cacheResult(List<FlaskMessages> flaskMessageses) {
		for (FlaskMessages flaskMessages : flaskMessageses) {
			if (EntityCacheUtil.getResult(
						FlaskMessagesModelImpl.ENTITY_CACHE_ENABLED,
						FlaskMessagesImpl.class, flaskMessages.getPrimaryKey()) == null) {
				cacheResult(flaskMessages);
			}
			else {
				flaskMessages.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all flask messageses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FlaskMessagesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FlaskMessagesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the flask messages.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FlaskMessages flaskMessages) {
		EntityCacheUtil.removeResult(FlaskMessagesModelImpl.ENTITY_CACHE_ENABLED,
			FlaskMessagesImpl.class, flaskMessages.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FlaskMessages> flaskMessageses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FlaskMessages flaskMessages : flaskMessageses) {
			EntityCacheUtil.removeResult(FlaskMessagesModelImpl.ENTITY_CACHE_ENABLED,
				FlaskMessagesImpl.class, flaskMessages.getPrimaryKey());
		}
	}

	/**
	 * Creates a new flask messages with the primary key. Does not add the flask messages to the database.
	 *
	 * @param messageId the primary key for the new flask messages
	 * @return the new flask messages
	 */
	@Override
	public FlaskMessages create(long messageId) {
		FlaskMessages flaskMessages = new FlaskMessagesImpl();

		flaskMessages.setNew(true);
		flaskMessages.setPrimaryKey(messageId);

		return flaskMessages;
	}

	/**
	 * Removes the flask messages with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageId the primary key of the flask messages
	 * @return the flask messages that was removed
	 * @throws com.liferay.contacts.NoSuchFlaskMessagesException if a flask messages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskMessages remove(long messageId)
		throws NoSuchFlaskMessagesException, SystemException {
		return remove((Serializable)messageId);
	}

	/**
	 * Removes the flask messages with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the flask messages
	 * @return the flask messages that was removed
	 * @throws com.liferay.contacts.NoSuchFlaskMessagesException if a flask messages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskMessages remove(Serializable primaryKey)
		throws NoSuchFlaskMessagesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FlaskMessages flaskMessages = (FlaskMessages)session.get(FlaskMessagesImpl.class,
					primaryKey);

			if (flaskMessages == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFlaskMessagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(flaskMessages);
		}
		catch (NoSuchFlaskMessagesException nsee) {
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
	protected FlaskMessages removeImpl(FlaskMessages flaskMessages)
		throws SystemException {
		flaskMessages = toUnwrappedModel(flaskMessages);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(flaskMessages)) {
				flaskMessages = (FlaskMessages)session.get(FlaskMessagesImpl.class,
						flaskMessages.getPrimaryKeyObj());
			}

			if (flaskMessages != null) {
				session.delete(flaskMessages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (flaskMessages != null) {
			clearCache(flaskMessages);
		}

		return flaskMessages;
	}

	@Override
	public FlaskMessages updateImpl(
		com.liferay.contacts.model.FlaskMessages flaskMessages)
		throws SystemException {
		flaskMessages = toUnwrappedModel(flaskMessages);

		boolean isNew = flaskMessages.isNew();

		Session session = null;

		try {
			session = openSession();

			if (flaskMessages.isNew()) {
				session.save(flaskMessages);

				flaskMessages.setNew(false);
			}
			else {
				session.merge(flaskMessages);
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

		EntityCacheUtil.putResult(FlaskMessagesModelImpl.ENTITY_CACHE_ENABLED,
			FlaskMessagesImpl.class, flaskMessages.getPrimaryKey(),
			flaskMessages);

		return flaskMessages;
	}

	protected FlaskMessages toUnwrappedModel(FlaskMessages flaskMessages) {
		if (flaskMessages instanceof FlaskMessagesImpl) {
			return flaskMessages;
		}

		FlaskMessagesImpl flaskMessagesImpl = new FlaskMessagesImpl();

		flaskMessagesImpl.setNew(flaskMessages.isNew());
		flaskMessagesImpl.setPrimaryKey(flaskMessages.getPrimaryKey());

		flaskMessagesImpl.setMessageId(flaskMessages.getMessageId());
		flaskMessagesImpl.setSenderEmail(flaskMessages.getSenderEmail());
		flaskMessagesImpl.setSenderUserId(flaskMessages.getSenderUserId());
		flaskMessagesImpl.setSenderName(flaskMessages.getSenderName());
		flaskMessagesImpl.setRecipients(flaskMessages.getRecipients());
		flaskMessagesImpl.setMessage(flaskMessages.getMessage());
		flaskMessagesImpl.setSendEmail(flaskMessages.isSendEmail());
		flaskMessagesImpl.setDateTime(flaskMessages.getDateTime());

		return flaskMessagesImpl;
	}

	/**
	 * Returns the flask messages with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask messages
	 * @return the flask messages
	 * @throws com.liferay.contacts.NoSuchFlaskMessagesException if a flask messages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskMessages findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFlaskMessagesException, SystemException {
		FlaskMessages flaskMessages = fetchByPrimaryKey(primaryKey);

		if (flaskMessages == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFlaskMessagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return flaskMessages;
	}

	/**
	 * Returns the flask messages with the primary key or throws a {@link com.liferay.contacts.NoSuchFlaskMessagesException} if it could not be found.
	 *
	 * @param messageId the primary key of the flask messages
	 * @return the flask messages
	 * @throws com.liferay.contacts.NoSuchFlaskMessagesException if a flask messages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskMessages findByPrimaryKey(long messageId)
		throws NoSuchFlaskMessagesException, SystemException {
		return findByPrimaryKey((Serializable)messageId);
	}

	/**
	 * Returns the flask messages with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask messages
	 * @return the flask messages, or <code>null</code> if a flask messages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskMessages fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FlaskMessages flaskMessages = (FlaskMessages)EntityCacheUtil.getResult(FlaskMessagesModelImpl.ENTITY_CACHE_ENABLED,
				FlaskMessagesImpl.class, primaryKey);

		if (flaskMessages == _nullFlaskMessages) {
			return null;
		}

		if (flaskMessages == null) {
			Session session = null;

			try {
				session = openSession();

				flaskMessages = (FlaskMessages)session.get(FlaskMessagesImpl.class,
						primaryKey);

				if (flaskMessages != null) {
					cacheResult(flaskMessages);
				}
				else {
					EntityCacheUtil.putResult(FlaskMessagesModelImpl.ENTITY_CACHE_ENABLED,
						FlaskMessagesImpl.class, primaryKey, _nullFlaskMessages);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FlaskMessagesModelImpl.ENTITY_CACHE_ENABLED,
					FlaskMessagesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return flaskMessages;
	}

	/**
	 * Returns the flask messages with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageId the primary key of the flask messages
	 * @return the flask messages, or <code>null</code> if a flask messages with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskMessages fetchByPrimaryKey(long messageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)messageId);
	}

	/**
	 * Returns all the flask messageses.
	 *
	 * @return the flask messageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskMessages> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flask messageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskMessagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask messageses
	 * @param end the upper bound of the range of flask messageses (not inclusive)
	 * @return the range of flask messageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskMessages> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask messageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskMessagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask messageses
	 * @param end the upper bound of the range of flask messageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of flask messageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskMessages> findAll(int start, int end,
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

		List<FlaskMessages> list = (List<FlaskMessages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FLASKMESSAGES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FLASKMESSAGES;

				if (pagination) {
					sql = sql.concat(FlaskMessagesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FlaskMessages>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskMessages>(list);
				}
				else {
					list = (List<FlaskMessages>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the flask messageses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FlaskMessages flaskMessages : findAll()) {
			remove(flaskMessages);
		}
	}

	/**
	 * Returns the number of flask messageses.
	 *
	 * @return the number of flask messageses
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

				Query q = session.createQuery(_SQL_COUNT_FLASKMESSAGES);

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
	 * Initializes the flask messages persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.contacts.model.FlaskMessages")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FlaskMessages>> listenersList = new ArrayList<ModelListener<FlaskMessages>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FlaskMessages>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FlaskMessagesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FLASKMESSAGES = "SELECT flaskMessages FROM FlaskMessages flaskMessages";
	private static final String _SQL_COUNT_FLASKMESSAGES = "SELECT COUNT(flaskMessages) FROM FlaskMessages flaskMessages";
	private static final String _ORDER_BY_ENTITY_ALIAS = "flaskMessages.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FlaskMessages exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FlaskMessagesPersistenceImpl.class);
	private static FlaskMessages _nullFlaskMessages = new FlaskMessagesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FlaskMessages> toCacheModel() {
				return _nullFlaskMessagesCacheModel;
			}
		};

	private static CacheModel<FlaskMessages> _nullFlaskMessagesCacheModel = new CacheModel<FlaskMessages>() {
			@Override
			public FlaskMessages toEntityModel() {
				return _nullFlaskMessages;
			}
		};
}