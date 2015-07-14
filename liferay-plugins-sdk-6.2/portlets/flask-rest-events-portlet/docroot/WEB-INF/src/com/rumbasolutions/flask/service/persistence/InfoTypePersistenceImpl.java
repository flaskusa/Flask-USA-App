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

import com.rumbasolutions.flask.NoSuchInfoTypeException;
import com.rumbasolutions.flask.model.InfoType;
import com.rumbasolutions.flask.model.impl.InfoTypeImpl;
import com.rumbasolutions.flask.model.impl.InfoTypeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the info type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see InfoTypePersistence
 * @see InfoTypeUtil
 * @generated
 */
public class InfoTypePersistenceImpl extends BasePersistenceImpl<InfoType>
	implements InfoTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InfoTypeUtil} to access the info type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InfoTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InfoTypeModelImpl.ENTITY_CACHE_ENABLED,
			InfoTypeModelImpl.FINDER_CACHE_ENABLED, InfoTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InfoTypeModelImpl.ENTITY_CACHE_ENABLED,
			InfoTypeModelImpl.FINDER_CACHE_ENABLED, InfoTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InfoTypeModelImpl.ENTITY_CACHE_ENABLED,
			InfoTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public InfoTypePersistenceImpl() {
		setModelClass(InfoType.class);
	}

	/**
	 * Caches the info type in the entity cache if it is enabled.
	 *
	 * @param infoType the info type
	 */
	@Override
	public void cacheResult(InfoType infoType) {
		EntityCacheUtil.putResult(InfoTypeModelImpl.ENTITY_CACHE_ENABLED,
			InfoTypeImpl.class, infoType.getPrimaryKey(), infoType);

		infoType.resetOriginalValues();
	}

	/**
	 * Caches the info types in the entity cache if it is enabled.
	 *
	 * @param infoTypes the info types
	 */
	@Override
	public void cacheResult(List<InfoType> infoTypes) {
		for (InfoType infoType : infoTypes) {
			if (EntityCacheUtil.getResult(
						InfoTypeModelImpl.ENTITY_CACHE_ENABLED,
						InfoTypeImpl.class, infoType.getPrimaryKey()) == null) {
				cacheResult(infoType);
			}
			else {
				infoType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all info types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InfoTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InfoTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the info type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InfoType infoType) {
		EntityCacheUtil.removeResult(InfoTypeModelImpl.ENTITY_CACHE_ENABLED,
			InfoTypeImpl.class, infoType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<InfoType> infoTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (InfoType infoType : infoTypes) {
			EntityCacheUtil.removeResult(InfoTypeModelImpl.ENTITY_CACHE_ENABLED,
				InfoTypeImpl.class, infoType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new info type with the primary key. Does not add the info type to the database.
	 *
	 * @param infoTypeId the primary key for the new info type
	 * @return the new info type
	 */
	@Override
	public InfoType create(long infoTypeId) {
		InfoType infoType = new InfoTypeImpl();

		infoType.setNew(true);
		infoType.setPrimaryKey(infoTypeId);

		return infoType;
	}

	/**
	 * Removes the info type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param infoTypeId the primary key of the info type
	 * @return the info type that was removed
	 * @throws com.rumbasolutions.flask.NoSuchInfoTypeException if a info type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InfoType remove(long infoTypeId)
		throws NoSuchInfoTypeException, SystemException {
		return remove((Serializable)infoTypeId);
	}

	/**
	 * Removes the info type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the info type
	 * @return the info type that was removed
	 * @throws com.rumbasolutions.flask.NoSuchInfoTypeException if a info type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InfoType remove(Serializable primaryKey)
		throws NoSuchInfoTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			InfoType infoType = (InfoType)session.get(InfoTypeImpl.class,
					primaryKey);

			if (infoType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInfoTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(infoType);
		}
		catch (NoSuchInfoTypeException nsee) {
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
	protected InfoType removeImpl(InfoType infoType) throws SystemException {
		infoType = toUnwrappedModel(infoType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(infoType)) {
				infoType = (InfoType)session.get(InfoTypeImpl.class,
						infoType.getPrimaryKeyObj());
			}

			if (infoType != null) {
				session.delete(infoType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (infoType != null) {
			clearCache(infoType);
		}

		return infoType;
	}

	@Override
	public InfoType updateImpl(com.rumbasolutions.flask.model.InfoType infoType)
		throws SystemException {
		infoType = toUnwrappedModel(infoType);

		boolean isNew = infoType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (infoType.isNew()) {
				session.save(infoType);

				infoType.setNew(false);
			}
			else {
				session.merge(infoType);
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

		EntityCacheUtil.putResult(InfoTypeModelImpl.ENTITY_CACHE_ENABLED,
			InfoTypeImpl.class, infoType.getPrimaryKey(), infoType);

		return infoType;
	}

	protected InfoType toUnwrappedModel(InfoType infoType) {
		if (infoType instanceof InfoTypeImpl) {
			return infoType;
		}

		InfoTypeImpl infoTypeImpl = new InfoTypeImpl();

		infoTypeImpl.setNew(infoType.isNew());
		infoTypeImpl.setPrimaryKey(infoType.getPrimaryKey());

		infoTypeImpl.setInfoTypeId(infoType.getInfoTypeId());
		infoTypeImpl.setInfoTypeName(infoType.getInfoTypeName());

		return infoTypeImpl;
	}

	/**
	 * Returns the info type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the info type
	 * @return the info type
	 * @throws com.rumbasolutions.flask.NoSuchInfoTypeException if a info type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InfoType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInfoTypeException, SystemException {
		InfoType infoType = fetchByPrimaryKey(primaryKey);

		if (infoType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInfoTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return infoType;
	}

	/**
	 * Returns the info type with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchInfoTypeException} if it could not be found.
	 *
	 * @param infoTypeId the primary key of the info type
	 * @return the info type
	 * @throws com.rumbasolutions.flask.NoSuchInfoTypeException if a info type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InfoType findByPrimaryKey(long infoTypeId)
		throws NoSuchInfoTypeException, SystemException {
		return findByPrimaryKey((Serializable)infoTypeId);
	}

	/**
	 * Returns the info type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the info type
	 * @return the info type, or <code>null</code> if a info type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InfoType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		InfoType infoType = (InfoType)EntityCacheUtil.getResult(InfoTypeModelImpl.ENTITY_CACHE_ENABLED,
				InfoTypeImpl.class, primaryKey);

		if (infoType == _nullInfoType) {
			return null;
		}

		if (infoType == null) {
			Session session = null;

			try {
				session = openSession();

				infoType = (InfoType)session.get(InfoTypeImpl.class, primaryKey);

				if (infoType != null) {
					cacheResult(infoType);
				}
				else {
					EntityCacheUtil.putResult(InfoTypeModelImpl.ENTITY_CACHE_ENABLED,
						InfoTypeImpl.class, primaryKey, _nullInfoType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(InfoTypeModelImpl.ENTITY_CACHE_ENABLED,
					InfoTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return infoType;
	}

	/**
	 * Returns the info type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param infoTypeId the primary key of the info type
	 * @return the info type, or <code>null</code> if a info type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InfoType fetchByPrimaryKey(long infoTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)infoTypeId);
	}

	/**
	 * Returns all the info types.
	 *
	 * @return the info types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InfoType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the info types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InfoTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of info types
	 * @param end the upper bound of the range of info types (not inclusive)
	 * @return the range of info types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InfoType> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the info types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InfoTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of info types
	 * @param end the upper bound of the range of info types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of info types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InfoType> findAll(int start, int end,
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

		List<InfoType> list = (List<InfoType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INFOTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INFOTYPE;

				if (pagination) {
					sql = sql.concat(InfoTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<InfoType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<InfoType>(list);
				}
				else {
					list = (List<InfoType>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the info types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (InfoType infoType : findAll()) {
			remove(infoType);
		}
	}

	/**
	 * Returns the number of info types.
	 *
	 * @return the number of info types
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

				Query q = session.createQuery(_SQL_COUNT_INFOTYPE);

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
	 * Initializes the info type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.InfoType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<InfoType>> listenersList = new ArrayList<ModelListener<InfoType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<InfoType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(InfoTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_INFOTYPE = "SELECT infoType FROM InfoType infoType";
	private static final String _SQL_COUNT_INFOTYPE = "SELECT COUNT(infoType) FROM InfoType infoType";
	private static final String _ORDER_BY_ENTITY_ALIAS = "infoType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No InfoType exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InfoTypePersistenceImpl.class);
	private static InfoType _nullInfoType = new InfoTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<InfoType> toCacheModel() {
				return _nullInfoTypeCacheModel;
			}
		};

	private static CacheModel<InfoType> _nullInfoTypeCacheModel = new CacheModel<InfoType>() {
			@Override
			public InfoType toEntityModel() {
				return _nullInfoType;
			}
		};
}