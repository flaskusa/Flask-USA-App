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

package com.fl.uploadfile.service.persistence;

import com.fl.uploadfile.NoSuchUploadFileException;
import com.fl.uploadfile.model.UploadFile;
import com.fl.uploadfile.model.impl.UploadFileImpl;
import com.fl.uploadfile.model.impl.UploadFileModelImpl;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the upload file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rumba Solutions
 * @see UploadFilePersistence
 * @see UploadFileUtil
 * @generated
 */
public class UploadFilePersistenceImpl extends BasePersistenceImpl<UploadFile>
	implements UploadFilePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UploadFileUtil} to access the upload file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UploadFileImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UploadFileModelImpl.ENTITY_CACHE_ENABLED,
			UploadFileModelImpl.FINDER_CACHE_ENABLED, UploadFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UploadFileModelImpl.ENTITY_CACHE_ENABLED,
			UploadFileModelImpl.FINDER_CACHE_ENABLED, UploadFileImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UploadFileModelImpl.ENTITY_CACHE_ENABLED,
			UploadFileModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public UploadFilePersistenceImpl() {
		setModelClass(UploadFile.class);
	}

	/**
	 * Caches the upload file in the entity cache if it is enabled.
	 *
	 * @param uploadFile the upload file
	 */
	@Override
	public void cacheResult(UploadFile uploadFile) {
		EntityCacheUtil.putResult(UploadFileModelImpl.ENTITY_CACHE_ENABLED,
			UploadFileImpl.class, uploadFile.getPrimaryKey(), uploadFile);

		uploadFile.resetOriginalValues();
	}

	/**
	 * Caches the upload files in the entity cache if it is enabled.
	 *
	 * @param uploadFiles the upload files
	 */
	@Override
	public void cacheResult(List<UploadFile> uploadFiles) {
		for (UploadFile uploadFile : uploadFiles) {
			if (EntityCacheUtil.getResult(
						UploadFileModelImpl.ENTITY_CACHE_ENABLED,
						UploadFileImpl.class, uploadFile.getPrimaryKey()) == null) {
				cacheResult(uploadFile);
			}
			else {
				uploadFile.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all upload files.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UploadFileImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UploadFileImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the upload file.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UploadFile uploadFile) {
		EntityCacheUtil.removeResult(UploadFileModelImpl.ENTITY_CACHE_ENABLED,
			UploadFileImpl.class, uploadFile.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UploadFile> uploadFiles) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UploadFile uploadFile : uploadFiles) {
			EntityCacheUtil.removeResult(UploadFileModelImpl.ENTITY_CACHE_ENABLED,
				UploadFileImpl.class, uploadFile.getPrimaryKey());
		}
	}

	/**
	 * Creates a new upload file with the primary key. Does not add the upload file to the database.
	 *
	 * @param fileUploadId the primary key for the new upload file
	 * @return the new upload file
	 */
	@Override
	public UploadFile create(long fileUploadId) {
		UploadFile uploadFile = new UploadFileImpl();

		uploadFile.setNew(true);
		uploadFile.setPrimaryKey(fileUploadId);

		return uploadFile;
	}

	/**
	 * Removes the upload file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileUploadId the primary key of the upload file
	 * @return the upload file that was removed
	 * @throws com.fl.uploadfile.NoSuchUploadFileException if a upload file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UploadFile remove(long fileUploadId)
		throws NoSuchUploadFileException, SystemException {
		return remove((Serializable)fileUploadId);
	}

	/**
	 * Removes the upload file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the upload file
	 * @return the upload file that was removed
	 * @throws com.fl.uploadfile.NoSuchUploadFileException if a upload file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UploadFile remove(Serializable primaryKey)
		throws NoSuchUploadFileException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UploadFile uploadFile = (UploadFile)session.get(UploadFileImpl.class,
					primaryKey);

			if (uploadFile == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUploadFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(uploadFile);
		}
		catch (NoSuchUploadFileException nsee) {
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
	protected UploadFile removeImpl(UploadFile uploadFile)
		throws SystemException {
		uploadFile = toUnwrappedModel(uploadFile);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(uploadFile)) {
				uploadFile = (UploadFile)session.get(UploadFileImpl.class,
						uploadFile.getPrimaryKeyObj());
			}

			if (uploadFile != null) {
				session.delete(uploadFile);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (uploadFile != null) {
			clearCache(uploadFile);
		}

		return uploadFile;
	}

	@Override
	public UploadFile updateImpl(com.fl.uploadfile.model.UploadFile uploadFile)
		throws SystemException {
		uploadFile = toUnwrappedModel(uploadFile);

		boolean isNew = uploadFile.isNew();

		Session session = null;

		try {
			session = openSession();

			if (uploadFile.isNew()) {
				session.save(uploadFile);

				uploadFile.setNew(false);
			}
			else {
				session.merge(uploadFile);
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

		EntityCacheUtil.putResult(UploadFileModelImpl.ENTITY_CACHE_ENABLED,
			UploadFileImpl.class, uploadFile.getPrimaryKey(), uploadFile);

		return uploadFile;
	}

	protected UploadFile toUnwrappedModel(UploadFile uploadFile) {
		if (uploadFile instanceof UploadFileImpl) {
			return uploadFile;
		}

		UploadFileImpl uploadFileImpl = new UploadFileImpl();

		uploadFileImpl.setNew(uploadFile.isNew());
		uploadFileImpl.setPrimaryKey(uploadFile.getPrimaryKey());

		uploadFileImpl.setFileUploadId(uploadFile.getFileUploadId());
		uploadFileImpl.setFileEntryId(uploadFile.getFileEntryId());
		uploadFileImpl.setTitle(uploadFile.getTitle());
		uploadFileImpl.setDescription(uploadFile.getDescription());
		uploadFileImpl.setSize(uploadFile.getSize());

		return uploadFileImpl;
	}

	/**
	 * Returns the upload file with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the upload file
	 * @return the upload file
	 * @throws com.fl.uploadfile.NoSuchUploadFileException if a upload file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UploadFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUploadFileException, SystemException {
		UploadFile uploadFile = fetchByPrimaryKey(primaryKey);

		if (uploadFile == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUploadFileException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return uploadFile;
	}

	/**
	 * Returns the upload file with the primary key or throws a {@link com.fl.uploadfile.NoSuchUploadFileException} if it could not be found.
	 *
	 * @param fileUploadId the primary key of the upload file
	 * @return the upload file
	 * @throws com.fl.uploadfile.NoSuchUploadFileException if a upload file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UploadFile findByPrimaryKey(long fileUploadId)
		throws NoSuchUploadFileException, SystemException {
		return findByPrimaryKey((Serializable)fileUploadId);
	}

	/**
	 * Returns the upload file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the upload file
	 * @return the upload file, or <code>null</code> if a upload file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UploadFile fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UploadFile uploadFile = (UploadFile)EntityCacheUtil.getResult(UploadFileModelImpl.ENTITY_CACHE_ENABLED,
				UploadFileImpl.class, primaryKey);

		if (uploadFile == _nullUploadFile) {
			return null;
		}

		if (uploadFile == null) {
			Session session = null;

			try {
				session = openSession();

				uploadFile = (UploadFile)session.get(UploadFileImpl.class,
						primaryKey);

				if (uploadFile != null) {
					cacheResult(uploadFile);
				}
				else {
					EntityCacheUtil.putResult(UploadFileModelImpl.ENTITY_CACHE_ENABLED,
						UploadFileImpl.class, primaryKey, _nullUploadFile);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UploadFileModelImpl.ENTITY_CACHE_ENABLED,
					UploadFileImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return uploadFile;
	}

	/**
	 * Returns the upload file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileUploadId the primary key of the upload file
	 * @return the upload file, or <code>null</code> if a upload file with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UploadFile fetchByPrimaryKey(long fileUploadId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)fileUploadId);
	}

	/**
	 * Returns all the upload files.
	 *
	 * @return the upload files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UploadFile> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the upload files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fl.uploadfile.model.impl.UploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of upload files
	 * @param end the upper bound of the range of upload files (not inclusive)
	 * @return the range of upload files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UploadFile> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the upload files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fl.uploadfile.model.impl.UploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of upload files
	 * @param end the upper bound of the range of upload files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of upload files
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UploadFile> findAll(int start, int end,
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

		List<UploadFile> list = (List<UploadFile>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UPLOADFILE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UPLOADFILE;

				if (pagination) {
					sql = sql.concat(UploadFileModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UploadFile>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UploadFile>(list);
				}
				else {
					list = (List<UploadFile>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the upload files from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UploadFile uploadFile : findAll()) {
			remove(uploadFile);
		}
	}

	/**
	 * Returns the number of upload files.
	 *
	 * @return the number of upload files
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

				Query q = session.createQuery(_SQL_COUNT_UPLOADFILE);

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
	 * Initializes the upload file persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.fl.uploadfile.model.UploadFile")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UploadFile>> listenersList = new ArrayList<ModelListener<UploadFile>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UploadFile>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UploadFileImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_UPLOADFILE = "SELECT uploadFile FROM UploadFile uploadFile";
	private static final String _SQL_COUNT_UPLOADFILE = "SELECT COUNT(uploadFile) FROM UploadFile uploadFile";
	private static final String _ORDER_BY_ENTITY_ALIAS = "uploadFile.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UploadFile exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UploadFilePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"size"
			});
	private static UploadFile _nullUploadFile = new UploadFileImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UploadFile> toCacheModel() {
				return _nullUploadFileCacheModel;
			}
		};

	private static CacheModel<UploadFile> _nullUploadFileCacheModel = new CacheModel<UploadFile>() {
			@Override
			public UploadFile toEntityModel() {
				return _nullUploadFile;
			}
		};
}