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

import com.rumbasolutions.flask.NoSuchInvitationInfoException;
import com.rumbasolutions.flask.model.InvitationInfo;
import com.rumbasolutions.flask.model.impl.InvitationInfoImpl;
import com.rumbasolutions.flask.model.impl.InvitationInfoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the invitation info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvitationInfoPersistence
 * @see InvitationInfoUtil
 * @generated
 */
public class InvitationInfoPersistenceImpl extends BasePersistenceImpl<InvitationInfo>
	implements InvitationInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InvitationInfoUtil} to access the invitation info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InvitationInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InvitationInfoModelImpl.ENTITY_CACHE_ENABLED,
			InvitationInfoModelImpl.FINDER_CACHE_ENABLED,
			InvitationInfoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InvitationInfoModelImpl.ENTITY_CACHE_ENABLED,
			InvitationInfoModelImpl.FINDER_CACHE_ENABLED,
			InvitationInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InvitationInfoModelImpl.ENTITY_CACHE_ENABLED,
			InvitationInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public InvitationInfoPersistenceImpl() {
		setModelClass(InvitationInfo.class);
	}

	/**
	 * Caches the invitation info in the entity cache if it is enabled.
	 *
	 * @param invitationInfo the invitation info
	 */
	@Override
	public void cacheResult(InvitationInfo invitationInfo) {
		EntityCacheUtil.putResult(InvitationInfoModelImpl.ENTITY_CACHE_ENABLED,
			InvitationInfoImpl.class, invitationInfo.getPrimaryKey(),
			invitationInfo);

		invitationInfo.resetOriginalValues();
	}

	/**
	 * Caches the invitation infos in the entity cache if it is enabled.
	 *
	 * @param invitationInfos the invitation infos
	 */
	@Override
	public void cacheResult(List<InvitationInfo> invitationInfos) {
		for (InvitationInfo invitationInfo : invitationInfos) {
			if (EntityCacheUtil.getResult(
						InvitationInfoModelImpl.ENTITY_CACHE_ENABLED,
						InvitationInfoImpl.class, invitationInfo.getPrimaryKey()) == null) {
				cacheResult(invitationInfo);
			}
			else {
				invitationInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all invitation infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InvitationInfoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InvitationInfoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the invitation info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InvitationInfo invitationInfo) {
		EntityCacheUtil.removeResult(InvitationInfoModelImpl.ENTITY_CACHE_ENABLED,
			InvitationInfoImpl.class, invitationInfo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<InvitationInfo> invitationInfos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (InvitationInfo invitationInfo : invitationInfos) {
			EntityCacheUtil.removeResult(InvitationInfoModelImpl.ENTITY_CACHE_ENABLED,
				InvitationInfoImpl.class, invitationInfo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new invitation info with the primary key. Does not add the invitation info to the database.
	 *
	 * @param inviationId the primary key for the new invitation info
	 * @return the new invitation info
	 */
	@Override
	public InvitationInfo create(long inviationId) {
		InvitationInfo invitationInfo = new InvitationInfoImpl();

		invitationInfo.setNew(true);
		invitationInfo.setPrimaryKey(inviationId);

		return invitationInfo;
	}

	/**
	 * Removes the invitation info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param inviationId the primary key of the invitation info
	 * @return the invitation info that was removed
	 * @throws com.rumbasolutions.flask.NoSuchInvitationInfoException if a invitation info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationInfo remove(long inviationId)
		throws NoSuchInvitationInfoException, SystemException {
		return remove((Serializable)inviationId);
	}

	/**
	 * Removes the invitation info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the invitation info
	 * @return the invitation info that was removed
	 * @throws com.rumbasolutions.flask.NoSuchInvitationInfoException if a invitation info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationInfo remove(Serializable primaryKey)
		throws NoSuchInvitationInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			InvitationInfo invitationInfo = (InvitationInfo)session.get(InvitationInfoImpl.class,
					primaryKey);

			if (invitationInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInvitationInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(invitationInfo);
		}
		catch (NoSuchInvitationInfoException nsee) {
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
	protected InvitationInfo removeImpl(InvitationInfo invitationInfo)
		throws SystemException {
		invitationInfo = toUnwrappedModel(invitationInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(invitationInfo)) {
				invitationInfo = (InvitationInfo)session.get(InvitationInfoImpl.class,
						invitationInfo.getPrimaryKeyObj());
			}

			if (invitationInfo != null) {
				session.delete(invitationInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (invitationInfo != null) {
			clearCache(invitationInfo);
		}

		return invitationInfo;
	}

	@Override
	public InvitationInfo updateImpl(
		com.rumbasolutions.flask.model.InvitationInfo invitationInfo)
		throws SystemException {
		invitationInfo = toUnwrappedModel(invitationInfo);

		boolean isNew = invitationInfo.isNew();

		Session session = null;

		try {
			session = openSession();

			if (invitationInfo.isNew()) {
				session.save(invitationInfo);

				invitationInfo.setNew(false);
			}
			else {
				session.merge(invitationInfo);
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

		EntityCacheUtil.putResult(InvitationInfoModelImpl.ENTITY_CACHE_ENABLED,
			InvitationInfoImpl.class, invitationInfo.getPrimaryKey(),
			invitationInfo);

		return invitationInfo;
	}

	protected InvitationInfo toUnwrappedModel(InvitationInfo invitationInfo) {
		if (invitationInfo instanceof InvitationInfoImpl) {
			return invitationInfo;
		}

		InvitationInfoImpl invitationInfoImpl = new InvitationInfoImpl();

		invitationInfoImpl.setNew(invitationInfo.isNew());
		invitationInfoImpl.setPrimaryKey(invitationInfo.getPrimaryKey());

		invitationInfoImpl.setInviationId(invitationInfo.getInviationId());
		invitationInfoImpl.setName(invitationInfo.getName());
		invitationInfoImpl.setEmail(invitationInfo.getEmail());
		invitationInfoImpl.setDescription(invitationInfo.getDescription());
		invitationInfoImpl.setInvitedDate(invitationInfo.getInvitedDate());

		return invitationInfoImpl;
	}

	/**
	 * Returns the invitation info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the invitation info
	 * @return the invitation info
	 * @throws com.rumbasolutions.flask.NoSuchInvitationInfoException if a invitation info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInvitationInfoException, SystemException {
		InvitationInfo invitationInfo = fetchByPrimaryKey(primaryKey);

		if (invitationInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInvitationInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return invitationInfo;
	}

	/**
	 * Returns the invitation info with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchInvitationInfoException} if it could not be found.
	 *
	 * @param inviationId the primary key of the invitation info
	 * @return the invitation info
	 * @throws com.rumbasolutions.flask.NoSuchInvitationInfoException if a invitation info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationInfo findByPrimaryKey(long inviationId)
		throws NoSuchInvitationInfoException, SystemException {
		return findByPrimaryKey((Serializable)inviationId);
	}

	/**
	 * Returns the invitation info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the invitation info
	 * @return the invitation info, or <code>null</code> if a invitation info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		InvitationInfo invitationInfo = (InvitationInfo)EntityCacheUtil.getResult(InvitationInfoModelImpl.ENTITY_CACHE_ENABLED,
				InvitationInfoImpl.class, primaryKey);

		if (invitationInfo == _nullInvitationInfo) {
			return null;
		}

		if (invitationInfo == null) {
			Session session = null;

			try {
				session = openSession();

				invitationInfo = (InvitationInfo)session.get(InvitationInfoImpl.class,
						primaryKey);

				if (invitationInfo != null) {
					cacheResult(invitationInfo);
				}
				else {
					EntityCacheUtil.putResult(InvitationInfoModelImpl.ENTITY_CACHE_ENABLED,
						InvitationInfoImpl.class, primaryKey,
						_nullInvitationInfo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(InvitationInfoModelImpl.ENTITY_CACHE_ENABLED,
					InvitationInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return invitationInfo;
	}

	/**
	 * Returns the invitation info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param inviationId the primary key of the invitation info
	 * @return the invitation info, or <code>null</code> if a invitation info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InvitationInfo fetchByPrimaryKey(long inviationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)inviationId);
	}

	/**
	 * Returns all the invitation infos.
	 *
	 * @return the invitation infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InvitationInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invitation infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InvitationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of invitation infos
	 * @param end the upper bound of the range of invitation infos (not inclusive)
	 * @return the range of invitation infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InvitationInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the invitation infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InvitationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of invitation infos
	 * @param end the upper bound of the range of invitation infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of invitation infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InvitationInfo> findAll(int start, int end,
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

		List<InvitationInfo> list = (List<InvitationInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INVITATIONINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INVITATIONINFO;

				if (pagination) {
					sql = sql.concat(InvitationInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<InvitationInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<InvitationInfo>(list);
				}
				else {
					list = (List<InvitationInfo>)QueryUtil.list(q,
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
	 * Removes all the invitation infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (InvitationInfo invitationInfo : findAll()) {
			remove(invitationInfo);
		}
	}

	/**
	 * Returns the number of invitation infos.
	 *
	 * @return the number of invitation infos
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

				Query q = session.createQuery(_SQL_COUNT_INVITATIONINFO);

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
	 * Initializes the invitation info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.InvitationInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<InvitationInfo>> listenersList = new ArrayList<ModelListener<InvitationInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<InvitationInfo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(InvitationInfoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_INVITATIONINFO = "SELECT invitationInfo FROM InvitationInfo invitationInfo";
	private static final String _SQL_COUNT_INVITATIONINFO = "SELECT COUNT(invitationInfo) FROM InvitationInfo invitationInfo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "invitationInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No InvitationInfo exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InvitationInfoPersistenceImpl.class);
	private static InvitationInfo _nullInvitationInfo = new InvitationInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<InvitationInfo> toCacheModel() {
				return _nullInvitationInfoCacheModel;
			}
		};

	private static CacheModel<InvitationInfo> _nullInvitationInfoCacheModel = new CacheModel<InvitationInfo>() {
			@Override
			public InvitationInfo toEntityModel() {
				return _nullInvitationInfo;
			}
		};
}