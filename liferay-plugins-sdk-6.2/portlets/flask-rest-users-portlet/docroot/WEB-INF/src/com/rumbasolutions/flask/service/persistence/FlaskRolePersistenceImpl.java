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

import com.rumbasolutions.flask.NoSuchFlaskRoleException;
import com.rumbasolutions.flask.model.FlaskRole;
import com.rumbasolutions.flask.model.impl.FlaskRoleImpl;
import com.rumbasolutions.flask.model.impl.FlaskRoleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the flask role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see FlaskRolePersistence
 * @see FlaskRoleUtil
 * @generated
 */
public class FlaskRolePersistenceImpl extends BasePersistenceImpl<FlaskRole>
	implements FlaskRolePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FlaskRoleUtil} to access the flask role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FlaskRoleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FlaskRoleModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRoleModelImpl.FINDER_CACHE_ENABLED, FlaskRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FlaskRoleModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRoleModelImpl.FINDER_CACHE_ENABLED, FlaskRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FlaskRoleModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FlaskRolePersistenceImpl() {
		setModelClass(FlaskRole.class);
	}

	/**
	 * Caches the flask role in the entity cache if it is enabled.
	 *
	 * @param flaskRole the flask role
	 */
	@Override
	public void cacheResult(FlaskRole flaskRole) {
		EntityCacheUtil.putResult(FlaskRoleModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRoleImpl.class, flaskRole.getPrimaryKey(), flaskRole);

		flaskRole.resetOriginalValues();
	}

	/**
	 * Caches the flask roles in the entity cache if it is enabled.
	 *
	 * @param flaskRoles the flask roles
	 */
	@Override
	public void cacheResult(List<FlaskRole> flaskRoles) {
		for (FlaskRole flaskRole : flaskRoles) {
			if (EntityCacheUtil.getResult(
						FlaskRoleModelImpl.ENTITY_CACHE_ENABLED,
						FlaskRoleImpl.class, flaskRole.getPrimaryKey()) == null) {
				cacheResult(flaskRole);
			}
			else {
				flaskRole.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all flask roles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FlaskRoleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FlaskRoleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the flask role.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FlaskRole flaskRole) {
		EntityCacheUtil.removeResult(FlaskRoleModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRoleImpl.class, flaskRole.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FlaskRole> flaskRoles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FlaskRole flaskRole : flaskRoles) {
			EntityCacheUtil.removeResult(FlaskRoleModelImpl.ENTITY_CACHE_ENABLED,
				FlaskRoleImpl.class, flaskRole.getPrimaryKey());
		}
	}

	/**
	 * Creates a new flask role with the primary key. Does not add the flask role to the database.
	 *
	 * @param roleId the primary key for the new flask role
	 * @return the new flask role
	 */
	@Override
	public FlaskRole create(long roleId) {
		FlaskRole flaskRole = new FlaskRoleImpl();

		flaskRole.setNew(true);
		flaskRole.setPrimaryKey(roleId);

		return flaskRole;
	}

	/**
	 * Removes the flask role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roleId the primary key of the flask role
	 * @return the flask role that was removed
	 * @throws com.rumbasolutions.flask.NoSuchFlaskRoleException if a flask role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRole remove(long roleId)
		throws NoSuchFlaskRoleException, SystemException {
		return remove((Serializable)roleId);
	}

	/**
	 * Removes the flask role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the flask role
	 * @return the flask role that was removed
	 * @throws com.rumbasolutions.flask.NoSuchFlaskRoleException if a flask role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRole remove(Serializable primaryKey)
		throws NoSuchFlaskRoleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FlaskRole flaskRole = (FlaskRole)session.get(FlaskRoleImpl.class,
					primaryKey);

			if (flaskRole == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFlaskRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(flaskRole);
		}
		catch (NoSuchFlaskRoleException nsee) {
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
	protected FlaskRole removeImpl(FlaskRole flaskRole)
		throws SystemException {
		flaskRole = toUnwrappedModel(flaskRole);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(flaskRole)) {
				flaskRole = (FlaskRole)session.get(FlaskRoleImpl.class,
						flaskRole.getPrimaryKeyObj());
			}

			if (flaskRole != null) {
				session.delete(flaskRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (flaskRole != null) {
			clearCache(flaskRole);
		}

		return flaskRole;
	}

	@Override
	public FlaskRole updateImpl(
		com.rumbasolutions.flask.model.FlaskRole flaskRole)
		throws SystemException {
		flaskRole = toUnwrappedModel(flaskRole);

		boolean isNew = flaskRole.isNew();

		Session session = null;

		try {
			session = openSession();

			if (flaskRole.isNew()) {
				session.save(flaskRole);

				flaskRole.setNew(false);
			}
			else {
				session.merge(flaskRole);
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

		EntityCacheUtil.putResult(FlaskRoleModelImpl.ENTITY_CACHE_ENABLED,
			FlaskRoleImpl.class, flaskRole.getPrimaryKey(), flaskRole);

		return flaskRole;
	}

	protected FlaskRole toUnwrappedModel(FlaskRole flaskRole) {
		if (flaskRole instanceof FlaskRoleImpl) {
			return flaskRole;
		}

		FlaskRoleImpl flaskRoleImpl = new FlaskRoleImpl();

		flaskRoleImpl.setNew(flaskRole.isNew());
		flaskRoleImpl.setPrimaryKey(flaskRole.getPrimaryKey());

		flaskRoleImpl.setRoleId(flaskRole.getRoleId());
		flaskRoleImpl.setRoleName(flaskRole.getRoleName());
		flaskRoleImpl.setRoleDesc(flaskRole.getRoleDesc());

		return flaskRoleImpl;
	}

	/**
	 * Returns the flask role with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask role
	 * @return the flask role
	 * @throws com.rumbasolutions.flask.NoSuchFlaskRoleException if a flask role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFlaskRoleException, SystemException {
		FlaskRole flaskRole = fetchByPrimaryKey(primaryKey);

		if (flaskRole == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFlaskRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return flaskRole;
	}

	/**
	 * Returns the flask role with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchFlaskRoleException} if it could not be found.
	 *
	 * @param roleId the primary key of the flask role
	 * @return the flask role
	 * @throws com.rumbasolutions.flask.NoSuchFlaskRoleException if a flask role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRole findByPrimaryKey(long roleId)
		throws NoSuchFlaskRoleException, SystemException {
		return findByPrimaryKey((Serializable)roleId);
	}

	/**
	 * Returns the flask role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask role
	 * @return the flask role, or <code>null</code> if a flask role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRole fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FlaskRole flaskRole = (FlaskRole)EntityCacheUtil.getResult(FlaskRoleModelImpl.ENTITY_CACHE_ENABLED,
				FlaskRoleImpl.class, primaryKey);

		if (flaskRole == _nullFlaskRole) {
			return null;
		}

		if (flaskRole == null) {
			Session session = null;

			try {
				session = openSession();

				flaskRole = (FlaskRole)session.get(FlaskRoleImpl.class,
						primaryKey);

				if (flaskRole != null) {
					cacheResult(flaskRole);
				}
				else {
					EntityCacheUtil.putResult(FlaskRoleModelImpl.ENTITY_CACHE_ENABLED,
						FlaskRoleImpl.class, primaryKey, _nullFlaskRole);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FlaskRoleModelImpl.ENTITY_CACHE_ENABLED,
					FlaskRoleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return flaskRole;
	}

	/**
	 * Returns the flask role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roleId the primary key of the flask role
	 * @return the flask role, or <code>null</code> if a flask role with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRole fetchByPrimaryKey(long roleId) throws SystemException {
		return fetchByPrimaryKey((Serializable)roleId);
	}

	/**
	 * Returns all the flask roles.
	 *
	 * @return the flask roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskRole> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flask roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask roles
	 * @param end the upper bound of the range of flask roles (not inclusive)
	 * @return the range of flask roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskRole> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask roles
	 * @param end the upper bound of the range of flask roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of flask roles
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskRole> findAll(int start, int end,
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

		List<FlaskRole> list = (List<FlaskRole>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FLASKROLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FLASKROLE;

				if (pagination) {
					sql = sql.concat(FlaskRoleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FlaskRole>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskRole>(list);
				}
				else {
					list = (List<FlaskRole>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the flask roles from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FlaskRole flaskRole : findAll()) {
			remove(flaskRole);
		}
	}

	/**
	 * Returns the number of flask roles.
	 *
	 * @return the number of flask roles
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

				Query q = session.createQuery(_SQL_COUNT_FLASKROLE);

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
	 * Initializes the flask role persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.FlaskRole")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FlaskRole>> listenersList = new ArrayList<ModelListener<FlaskRole>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FlaskRole>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FlaskRoleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FLASKROLE = "SELECT flaskRole FROM FlaskRole flaskRole";
	private static final String _SQL_COUNT_FLASKROLE = "SELECT COUNT(flaskRole) FROM FlaskRole flaskRole";
	private static final String _ORDER_BY_ENTITY_ALIAS = "flaskRole.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FlaskRole exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FlaskRolePersistenceImpl.class);
	private static FlaskRole _nullFlaskRole = new FlaskRoleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FlaskRole> toCacheModel() {
				return _nullFlaskRoleCacheModel;
			}
		};

	private static CacheModel<FlaskRole> _nullFlaskRoleCacheModel = new CacheModel<FlaskRole>() {
			@Override
			public FlaskRole toEntityModel() {
				return _nullFlaskRole;
			}
		};
}