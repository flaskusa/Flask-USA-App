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

import com.rumbasolutions.flask.NoSuchFlaskGroupException;
import com.rumbasolutions.flask.model.FlaskGroup;
import com.rumbasolutions.flask.model.impl.FlaskGroupImpl;
import com.rumbasolutions.flask.model.impl.FlaskGroupModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the flask group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupPersistence
 * @see FlaskGroupUtil
 * @generated
 */
public class FlaskGroupPersistenceImpl extends BasePersistenceImpl<FlaskGroup>
	implements FlaskGroupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FlaskGroupUtil} to access the flask group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FlaskGroupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FlaskGroupModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupModelImpl.FINDER_CACHE_ENABLED, FlaskGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FlaskGroupModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupModelImpl.FINDER_CACHE_ENABLED, FlaskGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FlaskGroupModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FlaskGroupPersistenceImpl() {
		setModelClass(FlaskGroup.class);
	}

	/**
	 * Caches the flask group in the entity cache if it is enabled.
	 *
	 * @param flaskGroup the flask group
	 */
	@Override
	public void cacheResult(FlaskGroup flaskGroup) {
		EntityCacheUtil.putResult(FlaskGroupModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupImpl.class, flaskGroup.getPrimaryKey(), flaskGroup);

		flaskGroup.resetOriginalValues();
	}

	/**
	 * Caches the flask groups in the entity cache if it is enabled.
	 *
	 * @param flaskGroups the flask groups
	 */
	@Override
	public void cacheResult(List<FlaskGroup> flaskGroups) {
		for (FlaskGroup flaskGroup : flaskGroups) {
			if (EntityCacheUtil.getResult(
						FlaskGroupModelImpl.ENTITY_CACHE_ENABLED,
						FlaskGroupImpl.class, flaskGroup.getPrimaryKey()) == null) {
				cacheResult(flaskGroup);
			}
			else {
				flaskGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all flask groups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FlaskGroupImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FlaskGroupImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the flask group.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FlaskGroup flaskGroup) {
		EntityCacheUtil.removeResult(FlaskGroupModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupImpl.class, flaskGroup.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FlaskGroup> flaskGroups) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FlaskGroup flaskGroup : flaskGroups) {
			EntityCacheUtil.removeResult(FlaskGroupModelImpl.ENTITY_CACHE_ENABLED,
				FlaskGroupImpl.class, flaskGroup.getPrimaryKey());
		}
	}

	/**
	 * Creates a new flask group with the primary key. Does not add the flask group to the database.
	 *
	 * @param groupId the primary key for the new flask group
	 * @return the new flask group
	 */
	@Override
	public FlaskGroup create(long groupId) {
		FlaskGroup flaskGroup = new FlaskGroupImpl();

		flaskGroup.setNew(true);
		flaskGroup.setPrimaryKey(groupId);

		return flaskGroup;
	}

	/**
	 * Removes the flask group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupId the primary key of the flask group
	 * @return the flask group that was removed
	 * @throws com.rumbasolutions.flask.NoSuchFlaskGroupException if a flask group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroup remove(long groupId)
		throws NoSuchFlaskGroupException, SystemException {
		return remove((Serializable)groupId);
	}

	/**
	 * Removes the flask group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the flask group
	 * @return the flask group that was removed
	 * @throws com.rumbasolutions.flask.NoSuchFlaskGroupException if a flask group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroup remove(Serializable primaryKey)
		throws NoSuchFlaskGroupException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FlaskGroup flaskGroup = (FlaskGroup)session.get(FlaskGroupImpl.class,
					primaryKey);

			if (flaskGroup == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFlaskGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(flaskGroup);
		}
		catch (NoSuchFlaskGroupException nsee) {
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
	protected FlaskGroup removeImpl(FlaskGroup flaskGroup)
		throws SystemException {
		flaskGroup = toUnwrappedModel(flaskGroup);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(flaskGroup)) {
				flaskGroup = (FlaskGroup)session.get(FlaskGroupImpl.class,
						flaskGroup.getPrimaryKeyObj());
			}

			if (flaskGroup != null) {
				session.delete(flaskGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (flaskGroup != null) {
			clearCache(flaskGroup);
		}

		return flaskGroup;
	}

	@Override
	public FlaskGroup updateImpl(
		com.rumbasolutions.flask.model.FlaskGroup flaskGroup)
		throws SystemException {
		flaskGroup = toUnwrappedModel(flaskGroup);

		boolean isNew = flaskGroup.isNew();

		Session session = null;

		try {
			session = openSession();

			if (flaskGroup.isNew()) {
				session.save(flaskGroup);

				flaskGroup.setNew(false);
			}
			else {
				session.merge(flaskGroup);
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

		EntityCacheUtil.putResult(FlaskGroupModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupImpl.class, flaskGroup.getPrimaryKey(), flaskGroup);

		return flaskGroup;
	}

	protected FlaskGroup toUnwrappedModel(FlaskGroup flaskGroup) {
		if (flaskGroup instanceof FlaskGroupImpl) {
			return flaskGroup;
		}

		FlaskGroupImpl flaskGroupImpl = new FlaskGroupImpl();

		flaskGroupImpl.setNew(flaskGroup.isNew());
		flaskGroupImpl.setPrimaryKey(flaskGroup.getPrimaryKey());

		flaskGroupImpl.setGroupId(flaskGroup.getGroupId());
		flaskGroupImpl.setGroupName(flaskGroup.getGroupName());
		flaskGroupImpl.setGroupDescription(flaskGroup.getGroupDescription());
		flaskGroupImpl.setCreatedDate(flaskGroup.getCreatedDate());
		flaskGroupImpl.setCreatedBy(flaskGroup.getCreatedBy());
		flaskGroupImpl.setIsActive(flaskGroup.getIsActive());
		flaskGroupImpl.setIsDelete(flaskGroup.getIsDelete());

		return flaskGroupImpl;
	}

	/**
	 * Returns the flask group with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask group
	 * @return the flask group
	 * @throws com.rumbasolutions.flask.NoSuchFlaskGroupException if a flask group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFlaskGroupException, SystemException {
		FlaskGroup flaskGroup = fetchByPrimaryKey(primaryKey);

		if (flaskGroup == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFlaskGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return flaskGroup;
	}

	/**
	 * Returns the flask group with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchFlaskGroupException} if it could not be found.
	 *
	 * @param groupId the primary key of the flask group
	 * @return the flask group
	 * @throws com.rumbasolutions.flask.NoSuchFlaskGroupException if a flask group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroup findByPrimaryKey(long groupId)
		throws NoSuchFlaskGroupException, SystemException {
		return findByPrimaryKey((Serializable)groupId);
	}

	/**
	 * Returns the flask group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask group
	 * @return the flask group, or <code>null</code> if a flask group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroup fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FlaskGroup flaskGroup = (FlaskGroup)EntityCacheUtil.getResult(FlaskGroupModelImpl.ENTITY_CACHE_ENABLED,
				FlaskGroupImpl.class, primaryKey);

		if (flaskGroup == _nullFlaskGroup) {
			return null;
		}

		if (flaskGroup == null) {
			Session session = null;

			try {
				session = openSession();

				flaskGroup = (FlaskGroup)session.get(FlaskGroupImpl.class,
						primaryKey);

				if (flaskGroup != null) {
					cacheResult(flaskGroup);
				}
				else {
					EntityCacheUtil.putResult(FlaskGroupModelImpl.ENTITY_CACHE_ENABLED,
						FlaskGroupImpl.class, primaryKey, _nullFlaskGroup);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FlaskGroupModelImpl.ENTITY_CACHE_ENABLED,
					FlaskGroupImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return flaskGroup;
	}

	/**
	 * Returns the flask group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupId the primary key of the flask group
	 * @return the flask group, or <code>null</code> if a flask group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroup fetchByPrimaryKey(long groupId) throws SystemException {
		return fetchByPrimaryKey((Serializable)groupId);
	}

	/**
	 * Returns all the flask groups.
	 *
	 * @return the flask groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroup> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flask groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask groups
	 * @param end the upper bound of the range of flask groups (not inclusive)
	 * @return the range of flask groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroup> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask groups
	 * @param end the upper bound of the range of flask groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of flask groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroup> findAll(int start, int end,
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

		List<FlaskGroup> list = (List<FlaskGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FLASKGROUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FLASKGROUP;

				if (pagination) {
					sql = sql.concat(FlaskGroupModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FlaskGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskGroup>(list);
				}
				else {
					list = (List<FlaskGroup>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the flask groups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FlaskGroup flaskGroup : findAll()) {
			remove(flaskGroup);
		}
	}

	/**
	 * Returns the number of flask groups.
	 *
	 * @return the number of flask groups
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

				Query q = session.createQuery(_SQL_COUNT_FLASKGROUP);

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
	 * Initializes the flask group persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.FlaskGroup")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FlaskGroup>> listenersList = new ArrayList<ModelListener<FlaskGroup>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FlaskGroup>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FlaskGroupImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FLASKGROUP = "SELECT flaskGroup FROM FlaskGroup flaskGroup";
	private static final String _SQL_COUNT_FLASKGROUP = "SELECT COUNT(flaskGroup) FROM FlaskGroup flaskGroup";
	private static final String _ORDER_BY_ENTITY_ALIAS = "flaskGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FlaskGroup exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FlaskGroupPersistenceImpl.class);
	private static FlaskGroup _nullFlaskGroup = new FlaskGroupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FlaskGroup> toCacheModel() {
				return _nullFlaskGroupCacheModel;
			}
		};

	private static CacheModel<FlaskGroup> _nullFlaskGroupCacheModel = new CacheModel<FlaskGroup>() {
			@Override
			public FlaskGroup toEntityModel() {
				return _nullFlaskGroup;
			}
		};
}