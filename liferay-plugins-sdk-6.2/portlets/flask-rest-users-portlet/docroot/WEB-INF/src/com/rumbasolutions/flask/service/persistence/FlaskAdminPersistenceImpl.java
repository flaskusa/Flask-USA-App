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

import com.rumbasolutions.flask.NoSuchFlaskAdminException;
import com.rumbasolutions.flask.model.FlaskAdmin;
import com.rumbasolutions.flask.model.impl.FlaskAdminImpl;
import com.rumbasolutions.flask.model.impl.FlaskAdminModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the flask admin service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see FlaskAdminPersistence
 * @see FlaskAdminUtil
 * @generated
 */
public class FlaskAdminPersistenceImpl extends BasePersistenceImpl<FlaskAdmin>
	implements FlaskAdminPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FlaskAdminUtil} to access the flask admin persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FlaskAdminImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FlaskAdminModelImpl.ENTITY_CACHE_ENABLED,
			FlaskAdminModelImpl.FINDER_CACHE_ENABLED, FlaskAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FlaskAdminModelImpl.ENTITY_CACHE_ENABLED,
			FlaskAdminModelImpl.FINDER_CACHE_ENABLED, FlaskAdminImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FlaskAdminModelImpl.ENTITY_CACHE_ENABLED,
			FlaskAdminModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FlaskAdminPersistenceImpl() {
		setModelClass(FlaskAdmin.class);
	}

	/**
	 * Caches the flask admin in the entity cache if it is enabled.
	 *
	 * @param flaskAdmin the flask admin
	 */
	@Override
	public void cacheResult(FlaskAdmin flaskAdmin) {
		EntityCacheUtil.putResult(FlaskAdminModelImpl.ENTITY_CACHE_ENABLED,
			FlaskAdminImpl.class, flaskAdmin.getPrimaryKey(), flaskAdmin);

		flaskAdmin.resetOriginalValues();
	}

	/**
	 * Caches the flask admins in the entity cache if it is enabled.
	 *
	 * @param flaskAdmins the flask admins
	 */
	@Override
	public void cacheResult(List<FlaskAdmin> flaskAdmins) {
		for (FlaskAdmin flaskAdmin : flaskAdmins) {
			if (EntityCacheUtil.getResult(
						FlaskAdminModelImpl.ENTITY_CACHE_ENABLED,
						FlaskAdminImpl.class, flaskAdmin.getPrimaryKey()) == null) {
				cacheResult(flaskAdmin);
			}
			else {
				flaskAdmin.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all flask admins.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FlaskAdminImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FlaskAdminImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the flask admin.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FlaskAdmin flaskAdmin) {
		EntityCacheUtil.removeResult(FlaskAdminModelImpl.ENTITY_CACHE_ENABLED,
			FlaskAdminImpl.class, flaskAdmin.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FlaskAdmin> flaskAdmins) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FlaskAdmin flaskAdmin : flaskAdmins) {
			EntityCacheUtil.removeResult(FlaskAdminModelImpl.ENTITY_CACHE_ENABLED,
				FlaskAdminImpl.class, flaskAdmin.getPrimaryKey());
		}
	}

	/**
	 * Creates a new flask admin with the primary key. Does not add the flask admin to the database.
	 *
	 * @param userId the primary key for the new flask admin
	 * @return the new flask admin
	 */
	@Override
	public FlaskAdmin create(long userId) {
		FlaskAdmin flaskAdmin = new FlaskAdminImpl();

		flaskAdmin.setNew(true);
		flaskAdmin.setPrimaryKey(userId);

		return flaskAdmin;
	}

	/**
	 * Removes the flask admin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the flask admin
	 * @return the flask admin that was removed
	 * @throws com.rumbasolutions.flask.NoSuchFlaskAdminException if a flask admin with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskAdmin remove(long userId)
		throws NoSuchFlaskAdminException, SystemException {
		return remove((Serializable)userId);
	}

	/**
	 * Removes the flask admin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the flask admin
	 * @return the flask admin that was removed
	 * @throws com.rumbasolutions.flask.NoSuchFlaskAdminException if a flask admin with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskAdmin remove(Serializable primaryKey)
		throws NoSuchFlaskAdminException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FlaskAdmin flaskAdmin = (FlaskAdmin)session.get(FlaskAdminImpl.class,
					primaryKey);

			if (flaskAdmin == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFlaskAdminException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(flaskAdmin);
		}
		catch (NoSuchFlaskAdminException nsee) {
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
	protected FlaskAdmin removeImpl(FlaskAdmin flaskAdmin)
		throws SystemException {
		flaskAdmin = toUnwrappedModel(flaskAdmin);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(flaskAdmin)) {
				flaskAdmin = (FlaskAdmin)session.get(FlaskAdminImpl.class,
						flaskAdmin.getPrimaryKeyObj());
			}

			if (flaskAdmin != null) {
				session.delete(flaskAdmin);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (flaskAdmin != null) {
			clearCache(flaskAdmin);
		}

		return flaskAdmin;
	}

	@Override
	public FlaskAdmin updateImpl(
		com.rumbasolutions.flask.model.FlaskAdmin flaskAdmin)
		throws SystemException {
		flaskAdmin = toUnwrappedModel(flaskAdmin);

		boolean isNew = flaskAdmin.isNew();

		Session session = null;

		try {
			session = openSession();

			if (flaskAdmin.isNew()) {
				session.save(flaskAdmin);

				flaskAdmin.setNew(false);
			}
			else {
				session.merge(flaskAdmin);
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

		EntityCacheUtil.putResult(FlaskAdminModelImpl.ENTITY_CACHE_ENABLED,
			FlaskAdminImpl.class, flaskAdmin.getPrimaryKey(), flaskAdmin);

		return flaskAdmin;
	}

	protected FlaskAdmin toUnwrappedModel(FlaskAdmin flaskAdmin) {
		if (flaskAdmin instanceof FlaskAdminImpl) {
			return flaskAdmin;
		}

		FlaskAdminImpl flaskAdminImpl = new FlaskAdminImpl();

		flaskAdminImpl.setNew(flaskAdmin.isNew());
		flaskAdminImpl.setPrimaryKey(flaskAdmin.getPrimaryKey());

		flaskAdminImpl.setUserId(flaskAdmin.getUserId());
		flaskAdminImpl.setRoleId(flaskAdmin.getRoleId());
		flaskAdminImpl.setFirstName(flaskAdmin.getFirstName());
		flaskAdminImpl.setMiddleName(flaskAdmin.getMiddleName());
		flaskAdminImpl.setLastName(flaskAdmin.getLastName());
		flaskAdminImpl.setScreenName(flaskAdmin.getScreenName());
		flaskAdminImpl.setEmail(flaskAdmin.getEmail());
		flaskAdminImpl.setDOB(flaskAdmin.getDOB());
		flaskAdminImpl.setIsMale(flaskAdmin.getIsMale());
		flaskAdminImpl.setStreetName(flaskAdmin.getStreetName());
		flaskAdminImpl.setAptNo(flaskAdmin.getAptNo());
		flaskAdminImpl.setAreaCode(flaskAdmin.getAreaCode());
		flaskAdminImpl.setCity(flaskAdmin.getCity());
		flaskAdminImpl.setStateId(flaskAdmin.getStateId());
		flaskAdminImpl.setStateName(flaskAdmin.getStateName());
		flaskAdminImpl.setCountryId(flaskAdmin.getCountryId());
		flaskAdminImpl.setCountryName(flaskAdmin.getCountryName());
		flaskAdminImpl.setMobileNumber(flaskAdmin.getMobileNumber());
		flaskAdminImpl.setPortraitURL(flaskAdmin.getPortraitURL());
		flaskAdminImpl.setUserInterests(flaskAdmin.getUserInterests());

		return flaskAdminImpl;
	}

	/**
	 * Returns the flask admin with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask admin
	 * @return the flask admin
	 * @throws com.rumbasolutions.flask.NoSuchFlaskAdminException if a flask admin with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskAdmin findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFlaskAdminException, SystemException {
		FlaskAdmin flaskAdmin = fetchByPrimaryKey(primaryKey);

		if (flaskAdmin == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFlaskAdminException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return flaskAdmin;
	}

	/**
	 * Returns the flask admin with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchFlaskAdminException} if it could not be found.
	 *
	 * @param userId the primary key of the flask admin
	 * @return the flask admin
	 * @throws com.rumbasolutions.flask.NoSuchFlaskAdminException if a flask admin with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskAdmin findByPrimaryKey(long userId)
		throws NoSuchFlaskAdminException, SystemException {
		return findByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns the flask admin with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask admin
	 * @return the flask admin, or <code>null</code> if a flask admin with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskAdmin fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FlaskAdmin flaskAdmin = (FlaskAdmin)EntityCacheUtil.getResult(FlaskAdminModelImpl.ENTITY_CACHE_ENABLED,
				FlaskAdminImpl.class, primaryKey);

		if (flaskAdmin == _nullFlaskAdmin) {
			return null;
		}

		if (flaskAdmin == null) {
			Session session = null;

			try {
				session = openSession();

				flaskAdmin = (FlaskAdmin)session.get(FlaskAdminImpl.class,
						primaryKey);

				if (flaskAdmin != null) {
					cacheResult(flaskAdmin);
				}
				else {
					EntityCacheUtil.putResult(FlaskAdminModelImpl.ENTITY_CACHE_ENABLED,
						FlaskAdminImpl.class, primaryKey, _nullFlaskAdmin);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FlaskAdminModelImpl.ENTITY_CACHE_ENABLED,
					FlaskAdminImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return flaskAdmin;
	}

	/**
	 * Returns the flask admin with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the flask admin
	 * @return the flask admin, or <code>null</code> if a flask admin with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskAdmin fetchByPrimaryKey(long userId) throws SystemException {
		return fetchByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns all the flask admins.
	 *
	 * @return the flask admins
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskAdmin> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flask admins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskAdminModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask admins
	 * @param end the upper bound of the range of flask admins (not inclusive)
	 * @return the range of flask admins
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskAdmin> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask admins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskAdminModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask admins
	 * @param end the upper bound of the range of flask admins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of flask admins
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskAdmin> findAll(int start, int end,
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

		List<FlaskAdmin> list = (List<FlaskAdmin>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FLASKADMIN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FLASKADMIN;

				if (pagination) {
					sql = sql.concat(FlaskAdminModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FlaskAdmin>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskAdmin>(list);
				}
				else {
					list = (List<FlaskAdmin>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the flask admins from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FlaskAdmin flaskAdmin : findAll()) {
			remove(flaskAdmin);
		}
	}

	/**
	 * Returns the number of flask admins.
	 *
	 * @return the number of flask admins
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

				Query q = session.createQuery(_SQL_COUNT_FLASKADMIN);

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
	 * Initializes the flask admin persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.FlaskAdmin")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FlaskAdmin>> listenersList = new ArrayList<ModelListener<FlaskAdmin>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FlaskAdmin>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FlaskAdminImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FLASKADMIN = "SELECT flaskAdmin FROM FlaskAdmin flaskAdmin";
	private static final String _SQL_COUNT_FLASKADMIN = "SELECT COUNT(flaskAdmin) FROM FlaskAdmin flaskAdmin";
	private static final String _ORDER_BY_ENTITY_ALIAS = "flaskAdmin.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FlaskAdmin exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FlaskAdminPersistenceImpl.class);
	private static FlaskAdmin _nullFlaskAdmin = new FlaskAdminImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FlaskAdmin> toCacheModel() {
				return _nullFlaskAdminCacheModel;
			}
		};

	private static CacheModel<FlaskAdmin> _nullFlaskAdminCacheModel = new CacheModel<FlaskAdmin>() {
			@Override
			public FlaskAdmin toEntityModel() {
				return _nullFlaskAdmin;
			}
		};
}