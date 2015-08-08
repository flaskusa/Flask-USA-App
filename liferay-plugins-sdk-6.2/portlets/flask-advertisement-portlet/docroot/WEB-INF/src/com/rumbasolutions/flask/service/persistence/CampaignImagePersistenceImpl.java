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
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rumbasolutions.flask.NoSuchCampaignImageException;
import com.rumbasolutions.flask.model.CampaignImage;
import com.rumbasolutions.flask.model.impl.CampaignImageImpl;
import com.rumbasolutions.flask.model.impl.CampaignImageModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the campaign image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignImagePersistence
 * @see CampaignImageUtil
 * @generated
 */
public class CampaignImagePersistenceImpl extends BasePersistenceImpl<CampaignImage>
	implements CampaignImagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CampaignImageUtil} to access the campaign image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CampaignImageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CampaignImageModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImageModelImpl.FINDER_CACHE_ENABLED,
			CampaignImageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CampaignImageModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImageModelImpl.FINDER_CACHE_ENABLED,
			CampaignImageImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CampaignImageModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_IMAGEUUID = new FinderPath(CampaignImageModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImageModelImpl.FINDER_CACHE_ENABLED,
			CampaignImageImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByimageUUID", new String[] { String.class.getName() },
			CampaignImageModelImpl.IMAGEUUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IMAGEUUID = new FinderPath(CampaignImageModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByimageUUID",
			new String[] { String.class.getName() });

	/**
	 * Returns the campaign image where imageUUID = &#63; or throws a {@link com.rumbasolutions.flask.NoSuchCampaignImageException} if it could not be found.
	 *
	 * @param imageUUID the image u u i d
	 * @return the matching campaign image
	 * @throws com.rumbasolutions.flask.NoSuchCampaignImageException if a matching campaign image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImage findByimageUUID(String imageUUID)
		throws NoSuchCampaignImageException, SystemException {
		CampaignImage campaignImage = fetchByimageUUID(imageUUID);

		if (campaignImage == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("imageUUID=");
			msg.append(imageUUID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCampaignImageException(msg.toString());
		}

		return campaignImage;
	}

	/**
	 * Returns the campaign image where imageUUID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param imageUUID the image u u i d
	 * @return the matching campaign image, or <code>null</code> if a matching campaign image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImage fetchByimageUUID(String imageUUID)
		throws SystemException {
		return fetchByimageUUID(imageUUID, true);
	}

	/**
	 * Returns the campaign image where imageUUID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param imageUUID the image u u i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching campaign image, or <code>null</code> if a matching campaign image could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImage fetchByimageUUID(String imageUUID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { imageUUID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_IMAGEUUID,
					finderArgs, this);
		}

		if (result instanceof CampaignImage) {
			CampaignImage campaignImage = (CampaignImage)result;

			if (!Validator.equals(imageUUID, campaignImage.getImageUUID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CAMPAIGNIMAGE_WHERE);

			boolean bindImageUUID = false;

			if (imageUUID == null) {
				query.append(_FINDER_COLUMN_IMAGEUUID_IMAGEUUID_1);
			}
			else if (imageUUID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IMAGEUUID_IMAGEUUID_3);
			}
			else {
				bindImageUUID = true;

				query.append(_FINDER_COLUMN_IMAGEUUID_IMAGEUUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindImageUUID) {
					qPos.add(imageUUID);
				}

				List<CampaignImage> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IMAGEUUID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CampaignImagePersistenceImpl.fetchByimageUUID(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CampaignImage campaignImage = list.get(0);

					result = campaignImage;

					cacheResult(campaignImage);

					if ((campaignImage.getImageUUID() == null) ||
							!campaignImage.getImageUUID().equals(imageUUID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IMAGEUUID,
							finderArgs, campaignImage);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IMAGEUUID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CampaignImage)result;
		}
	}

	/**
	 * Removes the campaign image where imageUUID = &#63; from the database.
	 *
	 * @param imageUUID the image u u i d
	 * @return the campaign image that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImage removeByimageUUID(String imageUUID)
		throws NoSuchCampaignImageException, SystemException {
		CampaignImage campaignImage = findByimageUUID(imageUUID);

		return remove(campaignImage);
	}

	/**
	 * Returns the number of campaign images where imageUUID = &#63;.
	 *
	 * @param imageUUID the image u u i d
	 * @return the number of matching campaign images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByimageUUID(String imageUUID) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IMAGEUUID;

		Object[] finderArgs = new Object[] { imageUUID };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAMPAIGNIMAGE_WHERE);

			boolean bindImageUUID = false;

			if (imageUUID == null) {
				query.append(_FINDER_COLUMN_IMAGEUUID_IMAGEUUID_1);
			}
			else if (imageUUID.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IMAGEUUID_IMAGEUUID_3);
			}
			else {
				bindImageUUID = true;

				query.append(_FINDER_COLUMN_IMAGEUUID_IMAGEUUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindImageUUID) {
					qPos.add(imageUUID);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_IMAGEUUID_IMAGEUUID_1 = "campaignImage.imageUUID IS NULL";
	private static final String _FINDER_COLUMN_IMAGEUUID_IMAGEUUID_2 = "campaignImage.imageUUID = ?";
	private static final String _FINDER_COLUMN_IMAGEUUID_IMAGEUUID_3 = "(campaignImage.imageUUID IS NULL OR campaignImage.imageUUID = '')";

	public CampaignImagePersistenceImpl() {
		setModelClass(CampaignImage.class);
	}

	/**
	 * Caches the campaign image in the entity cache if it is enabled.
	 *
	 * @param campaignImage the campaign image
	 */
	@Override
	public void cacheResult(CampaignImage campaignImage) {
		EntityCacheUtil.putResult(CampaignImageModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImageImpl.class, campaignImage.getPrimaryKey(),
			campaignImage);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IMAGEUUID,
			new Object[] { campaignImage.getImageUUID() }, campaignImage);

		campaignImage.resetOriginalValues();
	}

	/**
	 * Caches the campaign images in the entity cache if it is enabled.
	 *
	 * @param campaignImages the campaign images
	 */
	@Override
	public void cacheResult(List<CampaignImage> campaignImages) {
		for (CampaignImage campaignImage : campaignImages) {
			if (EntityCacheUtil.getResult(
						CampaignImageModelImpl.ENTITY_CACHE_ENABLED,
						CampaignImageImpl.class, campaignImage.getPrimaryKey()) == null) {
				cacheResult(campaignImage);
			}
			else {
				campaignImage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all campaign images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CampaignImageImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CampaignImageImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the campaign image.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CampaignImage campaignImage) {
		EntityCacheUtil.removeResult(CampaignImageModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImageImpl.class, campaignImage.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(campaignImage);
	}

	@Override
	public void clearCache(List<CampaignImage> campaignImages) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CampaignImage campaignImage : campaignImages) {
			EntityCacheUtil.removeResult(CampaignImageModelImpl.ENTITY_CACHE_ENABLED,
				CampaignImageImpl.class, campaignImage.getPrimaryKey());

			clearUniqueFindersCache(campaignImage);
		}
	}

	protected void cacheUniqueFindersCache(CampaignImage campaignImage) {
		if (campaignImage.isNew()) {
			Object[] args = new Object[] { campaignImage.getImageUUID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IMAGEUUID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IMAGEUUID, args,
				campaignImage);
		}
		else {
			CampaignImageModelImpl campaignImageModelImpl = (CampaignImageModelImpl)campaignImage;

			if ((campaignImageModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_IMAGEUUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { campaignImage.getImageUUID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IMAGEUUID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IMAGEUUID, args,
					campaignImage);
			}
		}
	}

	protected void clearUniqueFindersCache(CampaignImage campaignImage) {
		CampaignImageModelImpl campaignImageModelImpl = (CampaignImageModelImpl)campaignImage;

		Object[] args = new Object[] { campaignImage.getImageUUID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMAGEUUID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IMAGEUUID, args);

		if ((campaignImageModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_IMAGEUUID.getColumnBitmask()) != 0) {
			args = new Object[] { campaignImageModelImpl.getOriginalImageUUID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMAGEUUID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IMAGEUUID, args);
		}
	}

	/**
	 * Creates a new campaign image with the primary key. Does not add the campaign image to the database.
	 *
	 * @param campaignImageId the primary key for the new campaign image
	 * @return the new campaign image
	 */
	@Override
	public CampaignImage create(long campaignImageId) {
		CampaignImage campaignImage = new CampaignImageImpl();

		campaignImage.setNew(true);
		campaignImage.setPrimaryKey(campaignImageId);

		return campaignImage;
	}

	/**
	 * Removes the campaign image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campaignImageId the primary key of the campaign image
	 * @return the campaign image that was removed
	 * @throws com.rumbasolutions.flask.NoSuchCampaignImageException if a campaign image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImage remove(long campaignImageId)
		throws NoSuchCampaignImageException, SystemException {
		return remove((Serializable)campaignImageId);
	}

	/**
	 * Removes the campaign image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the campaign image
	 * @return the campaign image that was removed
	 * @throws com.rumbasolutions.flask.NoSuchCampaignImageException if a campaign image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImage remove(Serializable primaryKey)
		throws NoSuchCampaignImageException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CampaignImage campaignImage = (CampaignImage)session.get(CampaignImageImpl.class,
					primaryKey);

			if (campaignImage == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCampaignImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(campaignImage);
		}
		catch (NoSuchCampaignImageException nsee) {
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
	protected CampaignImage removeImpl(CampaignImage campaignImage)
		throws SystemException {
		campaignImage = toUnwrappedModel(campaignImage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(campaignImage)) {
				campaignImage = (CampaignImage)session.get(CampaignImageImpl.class,
						campaignImage.getPrimaryKeyObj());
			}

			if (campaignImage != null) {
				session.delete(campaignImage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (campaignImage != null) {
			clearCache(campaignImage);
		}

		return campaignImage;
	}

	@Override
	public CampaignImage updateImpl(
		com.rumbasolutions.flask.model.CampaignImage campaignImage)
		throws SystemException {
		campaignImage = toUnwrappedModel(campaignImage);

		boolean isNew = campaignImage.isNew();

		Session session = null;

		try {
			session = openSession();

			if (campaignImage.isNew()) {
				session.save(campaignImage);

				campaignImage.setNew(false);
			}
			else {
				session.merge(campaignImage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CampaignImageModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(CampaignImageModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImageImpl.class, campaignImage.getPrimaryKey(),
			campaignImage);

		clearUniqueFindersCache(campaignImage);
		cacheUniqueFindersCache(campaignImage);

		return campaignImage;
	}

	protected CampaignImage toUnwrappedModel(CampaignImage campaignImage) {
		if (campaignImage instanceof CampaignImageImpl) {
			return campaignImage;
		}

		CampaignImageImpl campaignImageImpl = new CampaignImageImpl();

		campaignImageImpl.setNew(campaignImage.isNew());
		campaignImageImpl.setPrimaryKey(campaignImage.getPrimaryKey());

		campaignImageImpl.setCampaignImageId(campaignImage.getCampaignImageId());
		campaignImageImpl.setUserId(campaignImage.getUserId());
		campaignImageImpl.setCreatedDate(campaignImage.getCreatedDate());
		campaignImageImpl.setModifiedDate(campaignImage.getModifiedDate());
		campaignImageImpl.setImageTitle(campaignImage.getImageTitle());
		campaignImageImpl.setImageDesc(campaignImage.getImageDesc());
		campaignImageImpl.setImageUUID(campaignImage.getImageUUID());
		campaignImageImpl.setImageGroupId(campaignImage.getImageGroupId());

		return campaignImageImpl;
	}

	/**
	 * Returns the campaign image with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign image
	 * @return the campaign image
	 * @throws com.rumbasolutions.flask.NoSuchCampaignImageException if a campaign image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCampaignImageException, SystemException {
		CampaignImage campaignImage = fetchByPrimaryKey(primaryKey);

		if (campaignImage == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCampaignImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return campaignImage;
	}

	/**
	 * Returns the campaign image with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchCampaignImageException} if it could not be found.
	 *
	 * @param campaignImageId the primary key of the campaign image
	 * @return the campaign image
	 * @throws com.rumbasolutions.flask.NoSuchCampaignImageException if a campaign image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImage findByPrimaryKey(long campaignImageId)
		throws NoSuchCampaignImageException, SystemException {
		return findByPrimaryKey((Serializable)campaignImageId);
	}

	/**
	 * Returns the campaign image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign image
	 * @return the campaign image, or <code>null</code> if a campaign image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImage fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CampaignImage campaignImage = (CampaignImage)EntityCacheUtil.getResult(CampaignImageModelImpl.ENTITY_CACHE_ENABLED,
				CampaignImageImpl.class, primaryKey);

		if (campaignImage == _nullCampaignImage) {
			return null;
		}

		if (campaignImage == null) {
			Session session = null;

			try {
				session = openSession();

				campaignImage = (CampaignImage)session.get(CampaignImageImpl.class,
						primaryKey);

				if (campaignImage != null) {
					cacheResult(campaignImage);
				}
				else {
					EntityCacheUtil.putResult(CampaignImageModelImpl.ENTITY_CACHE_ENABLED,
						CampaignImageImpl.class, primaryKey, _nullCampaignImage);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CampaignImageModelImpl.ENTITY_CACHE_ENABLED,
					CampaignImageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return campaignImage;
	}

	/**
	 * Returns the campaign image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param campaignImageId the primary key of the campaign image
	 * @return the campaign image, or <code>null</code> if a campaign image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImage fetchByPrimaryKey(long campaignImageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)campaignImageId);
	}

	/**
	 * Returns all the campaign images.
	 *
	 * @return the campaign images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignImage> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign images
	 * @param end the upper bound of the range of campaign images (not inclusive)
	 * @return the range of campaign images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignImage> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign images
	 * @param end the upper bound of the range of campaign images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of campaign images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignImage> findAll(int start, int end,
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

		List<CampaignImage> list = (List<CampaignImage>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CAMPAIGNIMAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAMPAIGNIMAGE;

				if (pagination) {
					sql = sql.concat(CampaignImageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CampaignImage>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CampaignImage>(list);
				}
				else {
					list = (List<CampaignImage>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the campaign images from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CampaignImage campaignImage : findAll()) {
			remove(campaignImage);
		}
	}

	/**
	 * Returns the number of campaign images.
	 *
	 * @return the number of campaign images
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

				Query q = session.createQuery(_SQL_COUNT_CAMPAIGNIMAGE);

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
	 * Initializes the campaign image persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.CampaignImage")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CampaignImage>> listenersList = new ArrayList<ModelListener<CampaignImage>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CampaignImage>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CampaignImageImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CAMPAIGNIMAGE = "SELECT campaignImage FROM CampaignImage campaignImage";
	private static final String _SQL_SELECT_CAMPAIGNIMAGE_WHERE = "SELECT campaignImage FROM CampaignImage campaignImage WHERE ";
	private static final String _SQL_COUNT_CAMPAIGNIMAGE = "SELECT COUNT(campaignImage) FROM CampaignImage campaignImage";
	private static final String _SQL_COUNT_CAMPAIGNIMAGE_WHERE = "SELECT COUNT(campaignImage) FROM CampaignImage campaignImage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "campaignImage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CampaignImage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CampaignImage exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CampaignImagePersistenceImpl.class);
	private static CampaignImage _nullCampaignImage = new CampaignImageImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CampaignImage> toCacheModel() {
				return _nullCampaignImageCacheModel;
			}
		};

	private static CacheModel<CampaignImage> _nullCampaignImageCacheModel = new CacheModel<CampaignImage>() {
			@Override
			public CampaignImage toEntityModel() {
				return _nullCampaignImage;
			}
		};
}