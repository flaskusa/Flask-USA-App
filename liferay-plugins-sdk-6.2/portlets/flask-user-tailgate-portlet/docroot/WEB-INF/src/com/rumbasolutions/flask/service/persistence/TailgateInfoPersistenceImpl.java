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

import com.rumbasolutions.flask.NoSuchTailgateInfoException;
import com.rumbasolutions.flask.model.TailgateInfo;
import com.rumbasolutions.flask.model.impl.TailgateInfoImpl;
import com.rumbasolutions.flask.model.impl.TailgateInfoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tailgate info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rajeshj
 * @see TailgateInfoPersistence
 * @see TailgateInfoUtil
 * @generated
 */
public class TailgateInfoPersistenceImpl extends BasePersistenceImpl<TailgateInfo>
	implements TailgateInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TailgateInfoUtil} to access the tailgate info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TailgateInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TailgateInfoModelImpl.ENTITY_CACHE_ENABLED,
			TailgateInfoModelImpl.FINDER_CACHE_ENABLED, TailgateInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TailgateInfoModelImpl.ENTITY_CACHE_ENABLED,
			TailgateInfoModelImpl.FINDER_CACHE_ENABLED, TailgateInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TailgateInfoModelImpl.ENTITY_CACHE_ENABLED,
			TailgateInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public TailgateInfoPersistenceImpl() {
		setModelClass(TailgateInfo.class);
	}

	/**
	 * Caches the tailgate info in the entity cache if it is enabled.
	 *
	 * @param tailgateInfo the tailgate info
	 */
	@Override
	public void cacheResult(TailgateInfo tailgateInfo) {
		EntityCacheUtil.putResult(TailgateInfoModelImpl.ENTITY_CACHE_ENABLED,
			TailgateInfoImpl.class, tailgateInfo.getPrimaryKey(), tailgateInfo);

		tailgateInfo.resetOriginalValues();
	}

	/**
	 * Caches the tailgate infos in the entity cache if it is enabled.
	 *
	 * @param tailgateInfos the tailgate infos
	 */
	@Override
	public void cacheResult(List<TailgateInfo> tailgateInfos) {
		for (TailgateInfo tailgateInfo : tailgateInfos) {
			if (EntityCacheUtil.getResult(
						TailgateInfoModelImpl.ENTITY_CACHE_ENABLED,
						TailgateInfoImpl.class, tailgateInfo.getPrimaryKey()) == null) {
				cacheResult(tailgateInfo);
			}
			else {
				tailgateInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tailgate infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TailgateInfoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TailgateInfoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tailgate info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TailgateInfo tailgateInfo) {
		EntityCacheUtil.removeResult(TailgateInfoModelImpl.ENTITY_CACHE_ENABLED,
			TailgateInfoImpl.class, tailgateInfo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TailgateInfo> tailgateInfos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TailgateInfo tailgateInfo : tailgateInfos) {
			EntityCacheUtil.removeResult(TailgateInfoModelImpl.ENTITY_CACHE_ENABLED,
				TailgateInfoImpl.class, tailgateInfo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tailgate info with the primary key. Does not add the tailgate info to the database.
	 *
	 * @param tailgateId the primary key for the new tailgate info
	 * @return the new tailgate info
	 */
	@Override
	public TailgateInfo create(long tailgateId) {
		TailgateInfo tailgateInfo = new TailgateInfoImpl();

		tailgateInfo.setNew(true);
		tailgateInfo.setPrimaryKey(tailgateId);

		return tailgateInfo;
	}

	/**
	 * Removes the tailgate info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tailgateId the primary key of the tailgate info
	 * @return the tailgate info that was removed
	 * @throws com.rumbasolutions.flask.NoSuchTailgateInfoException if a tailgate info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateInfo remove(long tailgateId)
		throws NoSuchTailgateInfoException, SystemException {
		return remove((Serializable)tailgateId);
	}

	/**
	 * Removes the tailgate info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tailgate info
	 * @return the tailgate info that was removed
	 * @throws com.rumbasolutions.flask.NoSuchTailgateInfoException if a tailgate info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateInfo remove(Serializable primaryKey)
		throws NoSuchTailgateInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TailgateInfo tailgateInfo = (TailgateInfo)session.get(TailgateInfoImpl.class,
					primaryKey);

			if (tailgateInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTailgateInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tailgateInfo);
		}
		catch (NoSuchTailgateInfoException nsee) {
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
	protected TailgateInfo removeImpl(TailgateInfo tailgateInfo)
		throws SystemException {
		tailgateInfo = toUnwrappedModel(tailgateInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tailgateInfo)) {
				tailgateInfo = (TailgateInfo)session.get(TailgateInfoImpl.class,
						tailgateInfo.getPrimaryKeyObj());
			}

			if (tailgateInfo != null) {
				session.delete(tailgateInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tailgateInfo != null) {
			clearCache(tailgateInfo);
		}

		return tailgateInfo;
	}

	@Override
	public TailgateInfo updateImpl(
		com.rumbasolutions.flask.model.TailgateInfo tailgateInfo)
		throws SystemException {
		tailgateInfo = toUnwrappedModel(tailgateInfo);

		boolean isNew = tailgateInfo.isNew();

		Session session = null;

		try {
			session = openSession();

			if (tailgateInfo.isNew()) {
				session.save(tailgateInfo);

				tailgateInfo.setNew(false);
			}
			else {
				session.merge(tailgateInfo);
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

		EntityCacheUtil.putResult(TailgateInfoModelImpl.ENTITY_CACHE_ENABLED,
			TailgateInfoImpl.class, tailgateInfo.getPrimaryKey(), tailgateInfo);

		return tailgateInfo;
	}

	protected TailgateInfo toUnwrappedModel(TailgateInfo tailgateInfo) {
		if (tailgateInfo instanceof TailgateInfoImpl) {
			return tailgateInfo;
		}

		TailgateInfoImpl tailgateInfoImpl = new TailgateInfoImpl();

		tailgateInfoImpl.setNew(tailgateInfo.isNew());
		tailgateInfoImpl.setPrimaryKey(tailgateInfo.getPrimaryKey());

		tailgateInfoImpl.setTailgateId(tailgateInfo.getTailgateId());
		tailgateInfoImpl.setCompanyId(tailgateInfo.getCompanyId());
		tailgateInfoImpl.setUserId(tailgateInfo.getUserId());
		tailgateInfoImpl.setCreatedDate(tailgateInfo.getCreatedDate());
		tailgateInfoImpl.setModifiedDate(tailgateInfo.getModifiedDate());
		tailgateInfoImpl.setTailgateName(tailgateInfo.getTailgateName());
		tailgateInfoImpl.setTailgateDescription(tailgateInfo.getTailgateDescription());
		tailgateInfoImpl.setEventId(tailgateInfo.getEventId());
		tailgateInfoImpl.setEventName(tailgateInfo.getEventName());
		tailgateInfoImpl.setTailgateDate(tailgateInfo.getTailgateDate());
		tailgateInfoImpl.setStartTime(tailgateInfo.getStartTime());
		tailgateInfoImpl.setEndTime(tailgateInfo.getEndTime());
		tailgateInfoImpl.setIsActive(tailgateInfo.getIsActive());
		tailgateInfoImpl.setIsDelete(tailgateInfo.getIsDelete());
		tailgateInfoImpl.setAmountToPay(tailgateInfo.getAmountToPay());

		return tailgateInfoImpl;
	}

	/**
	 * Returns the tailgate info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tailgate info
	 * @return the tailgate info
	 * @throws com.rumbasolutions.flask.NoSuchTailgateInfoException if a tailgate info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTailgateInfoException, SystemException {
		TailgateInfo tailgateInfo = fetchByPrimaryKey(primaryKey);

		if (tailgateInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTailgateInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tailgateInfo;
	}

	/**
	 * Returns the tailgate info with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchTailgateInfoException} if it could not be found.
	 *
	 * @param tailgateId the primary key of the tailgate info
	 * @return the tailgate info
	 * @throws com.rumbasolutions.flask.NoSuchTailgateInfoException if a tailgate info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateInfo findByPrimaryKey(long tailgateId)
		throws NoSuchTailgateInfoException, SystemException {
		return findByPrimaryKey((Serializable)tailgateId);
	}

	/**
	 * Returns the tailgate info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tailgate info
	 * @return the tailgate info, or <code>null</code> if a tailgate info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TailgateInfo tailgateInfo = (TailgateInfo)EntityCacheUtil.getResult(TailgateInfoModelImpl.ENTITY_CACHE_ENABLED,
				TailgateInfoImpl.class, primaryKey);

		if (tailgateInfo == _nullTailgateInfo) {
			return null;
		}

		if (tailgateInfo == null) {
			Session session = null;

			try {
				session = openSession();

				tailgateInfo = (TailgateInfo)session.get(TailgateInfoImpl.class,
						primaryKey);

				if (tailgateInfo != null) {
					cacheResult(tailgateInfo);
				}
				else {
					EntityCacheUtil.putResult(TailgateInfoModelImpl.ENTITY_CACHE_ENABLED,
						TailgateInfoImpl.class, primaryKey, _nullTailgateInfo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TailgateInfoModelImpl.ENTITY_CACHE_ENABLED,
					TailgateInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tailgateInfo;
	}

	/**
	 * Returns the tailgate info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tailgateId the primary key of the tailgate info
	 * @return the tailgate info, or <code>null</code> if a tailgate info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateInfo fetchByPrimaryKey(long tailgateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)tailgateId);
	}

	/**
	 * Returns all the tailgate infos.
	 *
	 * @return the tailgate infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tailgate infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tailgate infos
	 * @param end the upper bound of the range of tailgate infos (not inclusive)
	 * @return the range of tailgate infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tailgate infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tailgate infos
	 * @param end the upper bound of the range of tailgate infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tailgate infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateInfo> findAll(int start, int end,
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

		List<TailgateInfo> list = (List<TailgateInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAILGATEINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAILGATEINFO;

				if (pagination) {
					sql = sql.concat(TailgateInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TailgateInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TailgateInfo>(list);
				}
				else {
					list = (List<TailgateInfo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the tailgate infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TailgateInfo tailgateInfo : findAll()) {
			remove(tailgateInfo);
		}
	}

	/**
	 * Returns the number of tailgate infos.
	 *
	 * @return the number of tailgate infos
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

				Query q = session.createQuery(_SQL_COUNT_TAILGATEINFO);

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
	 * Initializes the tailgate info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.TailgateInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TailgateInfo>> listenersList = new ArrayList<ModelListener<TailgateInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TailgateInfo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TailgateInfoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TAILGATEINFO = "SELECT tailgateInfo FROM TailgateInfo tailgateInfo";
	private static final String _SQL_COUNT_TAILGATEINFO = "SELECT COUNT(tailgateInfo) FROM TailgateInfo tailgateInfo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tailgateInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TailgateInfo exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TailgateInfoPersistenceImpl.class);
	private static TailgateInfo _nullTailgateInfo = new TailgateInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TailgateInfo> toCacheModel() {
				return _nullTailgateInfoCacheModel;
			}
		};

	private static CacheModel<TailgateInfo> _nullTailgateInfoCacheModel = new CacheModel<TailgateInfo>() {
			@Override
			public TailgateInfo toEntityModel() {
				return _nullTailgateInfo;
			}
		};
}