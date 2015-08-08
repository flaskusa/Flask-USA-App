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

import com.rumbasolutions.flask.NoSuchCampaignImagesException;
import com.rumbasolutions.flask.model.CampaignImages;
import com.rumbasolutions.flask.model.impl.CampaignImagesImpl;
import com.rumbasolutions.flask.model.impl.CampaignImagesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the campaign images service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignImagesPersistence
 * @see CampaignImagesUtil
 * @generated
 */
public class CampaignImagesPersistenceImpl extends BasePersistenceImpl<CampaignImages>
	implements CampaignImagesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CampaignImagesUtil} to access the campaign images persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CampaignImagesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CampaignImagesModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImagesModelImpl.FINDER_CACHE_ENABLED,
			CampaignImagesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CampaignImagesModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImagesModelImpl.FINDER_CACHE_ENABLED,
			CampaignImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CampaignImagesModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_IMAGEUUID = new FinderPath(CampaignImagesModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImagesModelImpl.FINDER_CACHE_ENABLED,
			CampaignImagesImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByimageUUID", new String[] { String.class.getName() },
			CampaignImagesModelImpl.IMAGEUUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IMAGEUUID = new FinderPath(CampaignImagesModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByimageUUID",
			new String[] { String.class.getName() });

	/**
	 * Returns the campaign images where imageUUID = &#63; or throws a {@link com.rumbasolutions.flask.NoSuchCampaignImagesException} if it could not be found.
	 *
	 * @param imageUUID the image u u i d
	 * @return the matching campaign images
	 * @throws com.rumbasolutions.flask.NoSuchCampaignImagesException if a matching campaign images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImages findByimageUUID(String imageUUID)
		throws NoSuchCampaignImagesException, SystemException {
		CampaignImages campaignImages = fetchByimageUUID(imageUUID);

		if (campaignImages == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("imageUUID=");
			msg.append(imageUUID);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCampaignImagesException(msg.toString());
		}

		return campaignImages;
	}

	/**
	 * Returns the campaign images where imageUUID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param imageUUID the image u u i d
	 * @return the matching campaign images, or <code>null</code> if a matching campaign images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImages fetchByimageUUID(String imageUUID)
		throws SystemException {
		return fetchByimageUUID(imageUUID, true);
	}

	/**
	 * Returns the campaign images where imageUUID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param imageUUID the image u u i d
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching campaign images, or <code>null</code> if a matching campaign images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImages fetchByimageUUID(String imageUUID,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { imageUUID };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_IMAGEUUID,
					finderArgs, this);
		}

		if (result instanceof CampaignImages) {
			CampaignImages campaignImages = (CampaignImages)result;

			if (!Validator.equals(imageUUID, campaignImages.getImageUUID())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CAMPAIGNIMAGES_WHERE);

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

				List<CampaignImages> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IMAGEUUID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CampaignImagesPersistenceImpl.fetchByimageUUID(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CampaignImages campaignImages = list.get(0);

					result = campaignImages;

					cacheResult(campaignImages);

					if ((campaignImages.getImageUUID() == null) ||
							!campaignImages.getImageUUID().equals(imageUUID)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IMAGEUUID,
							finderArgs, campaignImages);
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
			return (CampaignImages)result;
		}
	}

	/**
	 * Removes the campaign images where imageUUID = &#63; from the database.
	 *
	 * @param imageUUID the image u u i d
	 * @return the campaign images that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImages removeByimageUUID(String imageUUID)
		throws NoSuchCampaignImagesException, SystemException {
		CampaignImages campaignImages = findByimageUUID(imageUUID);

		return remove(campaignImages);
	}

	/**
	 * Returns the number of campaign imageses where imageUUID = &#63;.
	 *
	 * @param imageUUID the image u u i d
	 * @return the number of matching campaign imageses
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

			query.append(_SQL_COUNT_CAMPAIGNIMAGES_WHERE);

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

	private static final String _FINDER_COLUMN_IMAGEUUID_IMAGEUUID_1 = "campaignImages.imageUUID IS NULL";
	private static final String _FINDER_COLUMN_IMAGEUUID_IMAGEUUID_2 = "campaignImages.imageUUID = ?";
	private static final String _FINDER_COLUMN_IMAGEUUID_IMAGEUUID_3 = "(campaignImages.imageUUID IS NULL OR campaignImages.imageUUID = '')";

	public CampaignImagesPersistenceImpl() {
		setModelClass(CampaignImages.class);
	}

	/**
	 * Caches the campaign images in the entity cache if it is enabled.
	 *
	 * @param campaignImages the campaign images
	 */
	@Override
	public void cacheResult(CampaignImages campaignImages) {
		EntityCacheUtil.putResult(CampaignImagesModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImagesImpl.class, campaignImages.getPrimaryKey(),
			campaignImages);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IMAGEUUID,
			new Object[] { campaignImages.getImageUUID() }, campaignImages);

		campaignImages.resetOriginalValues();
	}

	/**
	 * Caches the campaign imageses in the entity cache if it is enabled.
	 *
	 * @param campaignImageses the campaign imageses
	 */
	@Override
	public void cacheResult(List<CampaignImages> campaignImageses) {
		for (CampaignImages campaignImages : campaignImageses) {
			if (EntityCacheUtil.getResult(
						CampaignImagesModelImpl.ENTITY_CACHE_ENABLED,
						CampaignImagesImpl.class, campaignImages.getPrimaryKey()) == null) {
				cacheResult(campaignImages);
			}
			else {
				campaignImages.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all campaign imageses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CampaignImagesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CampaignImagesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the campaign images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CampaignImages campaignImages) {
		EntityCacheUtil.removeResult(CampaignImagesModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImagesImpl.class, campaignImages.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(campaignImages);
	}

	@Override
	public void clearCache(List<CampaignImages> campaignImageses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CampaignImages campaignImages : campaignImageses) {
			EntityCacheUtil.removeResult(CampaignImagesModelImpl.ENTITY_CACHE_ENABLED,
				CampaignImagesImpl.class, campaignImages.getPrimaryKey());

			clearUniqueFindersCache(campaignImages);
		}
	}

	protected void cacheUniqueFindersCache(CampaignImages campaignImages) {
		if (campaignImages.isNew()) {
			Object[] args = new Object[] { campaignImages.getImageUUID() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IMAGEUUID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IMAGEUUID, args,
				campaignImages);
		}
		else {
			CampaignImagesModelImpl campaignImagesModelImpl = (CampaignImagesModelImpl)campaignImages;

			if ((campaignImagesModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_IMAGEUUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { campaignImages.getImageUUID() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IMAGEUUID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IMAGEUUID, args,
					campaignImages);
			}
		}
	}

	protected void clearUniqueFindersCache(CampaignImages campaignImages) {
		CampaignImagesModelImpl campaignImagesModelImpl = (CampaignImagesModelImpl)campaignImages;

		Object[] args = new Object[] { campaignImages.getImageUUID() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMAGEUUID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IMAGEUUID, args);

		if ((campaignImagesModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_IMAGEUUID.getColumnBitmask()) != 0) {
			args = new Object[] { campaignImagesModelImpl.getOriginalImageUUID() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMAGEUUID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IMAGEUUID, args);
		}
	}

	/**
	 * Creates a new campaign images with the primary key. Does not add the campaign images to the database.
	 *
	 * @param campaignImageId the primary key for the new campaign images
	 * @return the new campaign images
	 */
	@Override
	public CampaignImages create(long campaignImageId) {
		CampaignImages campaignImages = new CampaignImagesImpl();

		campaignImages.setNew(true);
		campaignImages.setPrimaryKey(campaignImageId);

		return campaignImages;
	}

	/**
	 * Removes the campaign images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campaignImageId the primary key of the campaign images
	 * @return the campaign images that was removed
	 * @throws com.rumbasolutions.flask.NoSuchCampaignImagesException if a campaign images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImages remove(long campaignImageId)
		throws NoSuchCampaignImagesException, SystemException {
		return remove((Serializable)campaignImageId);
	}

	/**
	 * Removes the campaign images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the campaign images
	 * @return the campaign images that was removed
	 * @throws com.rumbasolutions.flask.NoSuchCampaignImagesException if a campaign images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImages remove(Serializable primaryKey)
		throws NoSuchCampaignImagesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CampaignImages campaignImages = (CampaignImages)session.get(CampaignImagesImpl.class,
					primaryKey);

			if (campaignImages == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCampaignImagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(campaignImages);
		}
		catch (NoSuchCampaignImagesException nsee) {
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
	protected CampaignImages removeImpl(CampaignImages campaignImages)
		throws SystemException {
		campaignImages = toUnwrappedModel(campaignImages);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(campaignImages)) {
				campaignImages = (CampaignImages)session.get(CampaignImagesImpl.class,
						campaignImages.getPrimaryKeyObj());
			}

			if (campaignImages != null) {
				session.delete(campaignImages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (campaignImages != null) {
			clearCache(campaignImages);
		}

		return campaignImages;
	}

	@Override
	public CampaignImages updateImpl(
		com.rumbasolutions.flask.model.CampaignImages campaignImages)
		throws SystemException {
		campaignImages = toUnwrappedModel(campaignImages);

		boolean isNew = campaignImages.isNew();

		Session session = null;

		try {
			session = openSession();

			if (campaignImages.isNew()) {
				session.save(campaignImages);

				campaignImages.setNew(false);
			}
			else {
				session.merge(campaignImages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CampaignImagesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(CampaignImagesModelImpl.ENTITY_CACHE_ENABLED,
			CampaignImagesImpl.class, campaignImages.getPrimaryKey(),
			campaignImages);

		clearUniqueFindersCache(campaignImages);
		cacheUniqueFindersCache(campaignImages);

		return campaignImages;
	}

	protected CampaignImages toUnwrappedModel(CampaignImages campaignImages) {
		if (campaignImages instanceof CampaignImagesImpl) {
			return campaignImages;
		}

		CampaignImagesImpl campaignImagesImpl = new CampaignImagesImpl();

		campaignImagesImpl.setNew(campaignImages.isNew());
		campaignImagesImpl.setPrimaryKey(campaignImages.getPrimaryKey());

		campaignImagesImpl.setCampaignImageId(campaignImages.getCampaignImageId());
		campaignImagesImpl.setUserId(campaignImages.getUserId());
		campaignImagesImpl.setCreatedDate(campaignImages.getCreatedDate());
		campaignImagesImpl.setModifiedDate(campaignImages.getModifiedDate());
		campaignImagesImpl.setImageTitle(campaignImages.getImageTitle());
		campaignImagesImpl.setImageDesc(campaignImages.getImageDesc());
		campaignImagesImpl.setImageUUID(campaignImages.getImageUUID());
		campaignImagesImpl.setImageGroupId(campaignImages.getImageGroupId());

		return campaignImagesImpl;
	}

	/**
	 * Returns the campaign images with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign images
	 * @return the campaign images
	 * @throws com.rumbasolutions.flask.NoSuchCampaignImagesException if a campaign images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImages findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCampaignImagesException, SystemException {
		CampaignImages campaignImages = fetchByPrimaryKey(primaryKey);

		if (campaignImages == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCampaignImagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return campaignImages;
	}

	/**
	 * Returns the campaign images with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchCampaignImagesException} if it could not be found.
	 *
	 * @param campaignImageId the primary key of the campaign images
	 * @return the campaign images
	 * @throws com.rumbasolutions.flask.NoSuchCampaignImagesException if a campaign images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImages findByPrimaryKey(long campaignImageId)
		throws NoSuchCampaignImagesException, SystemException {
		return findByPrimaryKey((Serializable)campaignImageId);
	}

	/**
	 * Returns the campaign images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign images
	 * @return the campaign images, or <code>null</code> if a campaign images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImages fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CampaignImages campaignImages = (CampaignImages)EntityCacheUtil.getResult(CampaignImagesModelImpl.ENTITY_CACHE_ENABLED,
				CampaignImagesImpl.class, primaryKey);

		if (campaignImages == _nullCampaignImages) {
			return null;
		}

		if (campaignImages == null) {
			Session session = null;

			try {
				session = openSession();

				campaignImages = (CampaignImages)session.get(CampaignImagesImpl.class,
						primaryKey);

				if (campaignImages != null) {
					cacheResult(campaignImages);
				}
				else {
					EntityCacheUtil.putResult(CampaignImagesModelImpl.ENTITY_CACHE_ENABLED,
						CampaignImagesImpl.class, primaryKey,
						_nullCampaignImages);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CampaignImagesModelImpl.ENTITY_CACHE_ENABLED,
					CampaignImagesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return campaignImages;
	}

	/**
	 * Returns the campaign images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param campaignImageId the primary key of the campaign images
	 * @return the campaign images, or <code>null</code> if a campaign images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CampaignImages fetchByPrimaryKey(long campaignImageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)campaignImageId);
	}

	/**
	 * Returns all the campaign imageses.
	 *
	 * @return the campaign imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignImages> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign imageses
	 * @param end the upper bound of the range of campaign imageses (not inclusive)
	 * @return the range of campaign imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignImages> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign imageses
	 * @param end the upper bound of the range of campaign imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of campaign imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CampaignImages> findAll(int start, int end,
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

		List<CampaignImages> list = (List<CampaignImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CAMPAIGNIMAGES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAMPAIGNIMAGES;

				if (pagination) {
					sql = sql.concat(CampaignImagesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CampaignImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CampaignImages>(list);
				}
				else {
					list = (List<CampaignImages>)QueryUtil.list(q,
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
	 * Removes all the campaign imageses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CampaignImages campaignImages : findAll()) {
			remove(campaignImages);
		}
	}

	/**
	 * Returns the number of campaign imageses.
	 *
	 * @return the number of campaign imageses
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

				Query q = session.createQuery(_SQL_COUNT_CAMPAIGNIMAGES);

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
	 * Initializes the campaign images persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.CampaignImages")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CampaignImages>> listenersList = new ArrayList<ModelListener<CampaignImages>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CampaignImages>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CampaignImagesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CAMPAIGNIMAGES = "SELECT campaignImages FROM CampaignImages campaignImages";
	private static final String _SQL_SELECT_CAMPAIGNIMAGES_WHERE = "SELECT campaignImages FROM CampaignImages campaignImages WHERE ";
	private static final String _SQL_COUNT_CAMPAIGNIMAGES = "SELECT COUNT(campaignImages) FROM CampaignImages campaignImages";
	private static final String _SQL_COUNT_CAMPAIGNIMAGES_WHERE = "SELECT COUNT(campaignImages) FROM CampaignImages campaignImages WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "campaignImages.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CampaignImages exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CampaignImages exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CampaignImagesPersistenceImpl.class);
	private static CampaignImages _nullCampaignImages = new CampaignImagesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CampaignImages> toCacheModel() {
				return _nullCampaignImagesCacheModel;
			}
		};

	private static CacheModel<CampaignImages> _nullCampaignImagesCacheModel = new CacheModel<CampaignImages>() {
			@Override
			public CampaignImages toEntityModel() {
				return _nullCampaignImages;
			}
		};
}