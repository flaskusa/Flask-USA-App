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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rumbasolutions.flask.NoSuchFlaskUserException;
import com.rumbasolutions.flask.model.FlaskUser;
import com.rumbasolutions.flask.model.impl.FlaskUserImpl;
import com.rumbasolutions.flask.model.impl.FlaskUserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the flask user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see FlaskUserPersistence
 * @see FlaskUserUtil
 * @generated
 */
public class FlaskUserPersistenceImpl extends BasePersistenceImpl<FlaskUser>
	implements FlaskUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FlaskUserUtil} to access the flask user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FlaskUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FlaskUserModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserModelImpl.FINDER_CACHE_ENABLED, FlaskUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FlaskUserModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserModelImpl.FINDER_CACHE_ENABLED, FlaskUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FlaskUserModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public FlaskUserPersistenceImpl() {
		setModelClass(FlaskUser.class);
	}

	/**
	 * Caches the flask user in the entity cache if it is enabled.
	 *
	 * @param flaskUser the flask user
	 */
	@Override
	public void cacheResult(FlaskUser flaskUser) {
		EntityCacheUtil.putResult(FlaskUserModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserImpl.class, flaskUser.getPrimaryKey(), flaskUser);

		flaskUser.resetOriginalValues();
	}

	/**
	 * Caches the flask users in the entity cache if it is enabled.
	 *
	 * @param flaskUsers the flask users
	 */
	@Override
	public void cacheResult(List<FlaskUser> flaskUsers) {
		for (FlaskUser flaskUser : flaskUsers) {
			if (EntityCacheUtil.getResult(
						FlaskUserModelImpl.ENTITY_CACHE_ENABLED,
						FlaskUserImpl.class, flaskUser.getPrimaryKey()) == null) {
				cacheResult(flaskUser);
			}
			else {
				flaskUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all flask users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FlaskUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FlaskUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the flask user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FlaskUser flaskUser) {
		EntityCacheUtil.removeResult(FlaskUserModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserImpl.class, flaskUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FlaskUser> flaskUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FlaskUser flaskUser : flaskUsers) {
			EntityCacheUtil.removeResult(FlaskUserModelImpl.ENTITY_CACHE_ENABLED,
				FlaskUserImpl.class, flaskUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new flask user with the primary key. Does not add the flask user to the database.
	 *
	 * @param userId the primary key for the new flask user
	 * @return the new flask user
	 */
	@Override
	public FlaskUser create(long userId) {
		FlaskUser flaskUser = new FlaskUserImpl();

		flaskUser.setNew(true);
		flaskUser.setPrimaryKey(userId);

		return flaskUser;
	}

	/**
	 * Removes the flask user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the flask user
	 * @return the flask user that was removed
	 * @throws com.rumbasolutions.flask.NoSuchFlaskUserException if a flask user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUser remove(long userId)
		throws NoSuchFlaskUserException, SystemException {
		return remove((Serializable)userId);
	}

	/**
	 * Removes the flask user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the flask user
	 * @return the flask user that was removed
	 * @throws com.rumbasolutions.flask.NoSuchFlaskUserException if a flask user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUser remove(Serializable primaryKey)
		throws NoSuchFlaskUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FlaskUser flaskUser = (FlaskUser)session.get(FlaskUserImpl.class,
					primaryKey);

			if (flaskUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFlaskUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(flaskUser);
		}
		catch (NoSuchFlaskUserException nsee) {
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
	protected FlaskUser removeImpl(FlaskUser flaskUser)
		throws SystemException {
		flaskUser = toUnwrappedModel(flaskUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(flaskUser)) {
				flaskUser = (FlaskUser)session.get(FlaskUserImpl.class,
						flaskUser.getPrimaryKeyObj());
			}

			if (flaskUser != null) {
				session.delete(flaskUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (flaskUser != null) {
			clearCache(flaskUser);
		}

		return flaskUser;
	}

	@Override
	public FlaskUser updateImpl(
		com.rumbasolutions.flask.model.FlaskUser flaskUser)
		throws SystemException {
		flaskUser = toUnwrappedModel(flaskUser);

		boolean isNew = flaskUser.isNew();

		Session session = null;

		try {
			session = openSession();

			if (flaskUser.isNew()) {
				session.save(flaskUser);

				flaskUser.setNew(false);
			}
			else {
				session.merge(flaskUser);
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

		EntityCacheUtil.putResult(FlaskUserModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserImpl.class, flaskUser.getPrimaryKey(), flaskUser);

		return flaskUser;
	}

	protected FlaskUser toUnwrappedModel(FlaskUser flaskUser) {
		if (flaskUser instanceof FlaskUserImpl) {
			return flaskUser;
		}

		FlaskUserImpl flaskUserImpl = new FlaskUserImpl();

		flaskUserImpl.setNew(flaskUser.isNew());
		flaskUserImpl.setPrimaryKey(flaskUser.getPrimaryKey());

		flaskUserImpl.setUserId(flaskUser.getUserId());
		flaskUserImpl.setRoleId(flaskUser.getRoleId());
		flaskUserImpl.setFirstName(flaskUser.getFirstName());
		flaskUserImpl.setMiddleName(flaskUser.getMiddleName());
		flaskUserImpl.setLastName(flaskUser.getLastName());
		flaskUserImpl.setScreenName(flaskUser.getScreenName());
		flaskUserImpl.setEmail(flaskUser.getEmail());
		flaskUserImpl.setDOB(flaskUser.getDOB());
		flaskUserImpl.setIsMale(flaskUser.getIsMale());
		flaskUserImpl.setStreetName(flaskUser.getStreetName());
		flaskUserImpl.setAptNo(flaskUser.getAptNo());
		flaskUserImpl.setAreaCode(flaskUser.getAreaCode());
		flaskUserImpl.setCity(flaskUser.getCity());
		flaskUserImpl.setState(flaskUser.getState());
		flaskUserImpl.setCountry(flaskUser.getCountry());
		flaskUserImpl.setMobileNumber(flaskUser.getMobileNumber());
		flaskUserImpl.setPortraitURL(flaskUser.getPortraitURL());
		flaskUserImpl.setUserInterests(flaskUser.getUserInterests());

		return flaskUserImpl;
	}

	/**
	 * Returns the flask user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask user
	 * @return the flask user
	 * @throws com.rumbasolutions.flask.NoSuchFlaskUserException if a flask user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFlaskUserException, SystemException {
		FlaskUser flaskUser = fetchByPrimaryKey(primaryKey);

		if (flaskUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFlaskUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return flaskUser;
	}

	/**
	 * Returns the flask user with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchFlaskUserException} if it could not be found.
	 *
	 * @param userId the primary key of the flask user
	 * @return the flask user
	 * @throws com.rumbasolutions.flask.NoSuchFlaskUserException if a flask user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUser findByPrimaryKey(long userId)
		throws NoSuchFlaskUserException, SystemException {
		return findByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns the flask user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask user
	 * @return the flask user, or <code>null</code> if a flask user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FlaskUser flaskUser = (FlaskUser)EntityCacheUtil.getResult(FlaskUserModelImpl.ENTITY_CACHE_ENABLED,
				FlaskUserImpl.class, primaryKey);

		if (flaskUser == _nullFlaskUser) {
			return null;
		}

		if (flaskUser == null) {
			Session session = null;

			try {
				session = openSession();

				flaskUser = (FlaskUser)session.get(FlaskUserImpl.class,
						primaryKey);

				if (flaskUser != null) {
					cacheResult(flaskUser);
				}
				else {
					EntityCacheUtil.putResult(FlaskUserModelImpl.ENTITY_CACHE_ENABLED,
						FlaskUserImpl.class, primaryKey, _nullFlaskUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FlaskUserModelImpl.ENTITY_CACHE_ENABLED,
					FlaskUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return flaskUser;
	}

	/**
	 * Returns the flask user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the flask user
	 * @return the flask user, or <code>null</code> if a flask user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUser fetchByPrimaryKey(long userId) throws SystemException {
		return fetchByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns all the flask users.
	 *
	 * @return the flask users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flask users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask users
	 * @param end the upper bound of the range of flask users (not inclusive)
	 * @return the range of flask users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask users
	 * @param end the upper bound of the range of flask users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of flask users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUser> findAll(int start, int end,
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

		List<FlaskUser> list = (List<FlaskUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FLASKUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FLASKUSER;

				if (pagination) {
					sql = sql.concat(FlaskUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FlaskUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskUser>(list);
				}
				else {
					list = (List<FlaskUser>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the flask users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FlaskUser flaskUser : findAll()) {
			remove(flaskUser);
		}
	}

	/**
	 * Returns the number of flask users.
	 *
	 * @return the number of flask users
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

				Query q = session.createQuery(_SQL_COUNT_FLASKUSER);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the flask user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.FlaskUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FlaskUser>> listenersList = new ArrayList<ModelListener<FlaskUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FlaskUser>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FlaskUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FLASKUSER = "SELECT flaskUser FROM FlaskUser flaskUser";
	private static final String _SQL_COUNT_FLASKUSER = "SELECT COUNT(flaskUser) FROM FlaskUser flaskUser";
	private static final String _ORDER_BY_ENTITY_ALIAS = "flaskUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FlaskUser exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FlaskUserPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"state"
			});
	private static FlaskUser _nullFlaskUser = new FlaskUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FlaskUser> toCacheModel() {
				return _nullFlaskUserCacheModel;
			}
		};

	private static CacheModel<FlaskUser> _nullFlaskUserCacheModel = new CacheModel<FlaskUser>() {
			@Override
			public FlaskUser toEntityModel() {
				return _nullFlaskUser;
			}
		};
}