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

import com.rumbasolutions.flask.NoSuchTailgateImagesException;
import com.rumbasolutions.flask.model.TailgateImages;
import com.rumbasolutions.flask.model.impl.TailgateImagesImpl;
import com.rumbasolutions.flask.model.impl.TailgateImagesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tailgate images service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TailgateImagesPersistence
 * @see TailgateImagesUtil
 * @generated
 */
public class TailgateImagesPersistenceImpl extends BasePersistenceImpl<TailgateImages>
	implements TailgateImagesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TailgateImagesUtil} to access the tailgate images persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TailgateImagesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TailgateImagesModelImpl.ENTITY_CACHE_ENABLED,
			TailgateImagesModelImpl.FINDER_CACHE_ENABLED,
			TailgateImagesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TailgateImagesModelImpl.ENTITY_CACHE_ENABLED,
			TailgateImagesModelImpl.FINDER_CACHE_ENABLED,
			TailgateImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TailgateImagesModelImpl.ENTITY_CACHE_ENABLED,
			TailgateImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAILGATEID =
		new FinderPath(TailgateImagesModelImpl.ENTITY_CACHE_ENABLED,
			TailgateImagesModelImpl.FINDER_CACHE_ENABLED,
			TailgateImagesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBytailgateId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID =
		new FinderPath(TailgateImagesModelImpl.ENTITY_CACHE_ENABLED,
			TailgateImagesModelImpl.FINDER_CACHE_ENABLED,
			TailgateImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytailgateId",
			new String[] { Long.class.getName() },
			TailgateImagesModelImpl.TAILGATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAILGATEID = new FinderPath(TailgateImagesModelImpl.ENTITY_CACHE_ENABLED,
			TailgateImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytailgateId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tailgate imageses where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @return the matching tailgate imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateImages> findBytailgateId(long tailgateId)
		throws SystemException {
		return findBytailgateId(tailgateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tailgate imageses where tailgateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tailgateId the tailgate ID
	 * @param start the lower bound of the range of tailgate imageses
	 * @param end the upper bound of the range of tailgate imageses (not inclusive)
	 * @return the range of matching tailgate imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateImages> findBytailgateId(long tailgateId, int start,
		int end) throws SystemException {
		return findBytailgateId(tailgateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tailgate imageses where tailgateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tailgateId the tailgate ID
	 * @param start the lower bound of the range of tailgate imageses
	 * @param end the upper bound of the range of tailgate imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tailgate imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateImages> findBytailgateId(long tailgateId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID;
			finderArgs = new Object[] { tailgateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAILGATEID;
			finderArgs = new Object[] { tailgateId, start, end, orderByComparator };
		}

		List<TailgateImages> list = (List<TailgateImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TailgateImages tailgateImages : list) {
				if ((tailgateId != tailgateImages.getTailgateId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TAILGATEIMAGES_WHERE);

			query.append(_FINDER_COLUMN_TAILGATEID_TAILGATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TailgateImagesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tailgateId);

				if (!pagination) {
					list = (List<TailgateImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TailgateImages>(list);
				}
				else {
					list = (List<TailgateImages>)QueryUtil.list(q,
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
	 * Returns the first tailgate images in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tailgate images
	 * @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a matching tailgate images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateImages findBytailgateId_First(long tailgateId,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateImagesException, SystemException {
		TailgateImages tailgateImages = fetchBytailgateId_First(tailgateId,
				orderByComparator);

		if (tailgateImages != null) {
			return tailgateImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tailgateId=");
		msg.append(tailgateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTailgateImagesException(msg.toString());
	}

	/**
	 * Returns the first tailgate images in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tailgate images, or <code>null</code> if a matching tailgate images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateImages fetchBytailgateId_First(long tailgateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TailgateImages> list = findBytailgateId(tailgateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tailgate images in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tailgate images
	 * @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a matching tailgate images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateImages findBytailgateId_Last(long tailgateId,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateImagesException, SystemException {
		TailgateImages tailgateImages = fetchBytailgateId_Last(tailgateId,
				orderByComparator);

		if (tailgateImages != null) {
			return tailgateImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tailgateId=");
		msg.append(tailgateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTailgateImagesException(msg.toString());
	}

	/**
	 * Returns the last tailgate images in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tailgate images, or <code>null</code> if a matching tailgate images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateImages fetchBytailgateId_Last(long tailgateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBytailgateId(tailgateId);

		if (count == 0) {
			return null;
		}

		List<TailgateImages> list = findBytailgateId(tailgateId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tailgate imageses before and after the current tailgate images in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateImageId the primary key of the current tailgate images
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tailgate images
	 * @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a tailgate images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateImages[] findBytailgateId_PrevAndNext(long tailgateImageId,
		long tailgateId, OrderByComparator orderByComparator)
		throws NoSuchTailgateImagesException, SystemException {
		TailgateImages tailgateImages = findByPrimaryKey(tailgateImageId);

		Session session = null;

		try {
			session = openSession();

			TailgateImages[] array = new TailgateImagesImpl[3];

			array[0] = getBytailgateId_PrevAndNext(session, tailgateImages,
					tailgateId, orderByComparator, true);

			array[1] = tailgateImages;

			array[2] = getBytailgateId_PrevAndNext(session, tailgateImages,
					tailgateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TailgateImages getBytailgateId_PrevAndNext(Session session,
		TailgateImages tailgateImages, long tailgateId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAILGATEIMAGES_WHERE);

		query.append(_FINDER_COLUMN_TAILGATEID_TAILGATEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TailgateImagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(tailgateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tailgateImages);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TailgateImages> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tailgate imageses where tailgateId = &#63; from the database.
	 *
	 * @param tailgateId the tailgate ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBytailgateId(long tailgateId) throws SystemException {
		for (TailgateImages tailgateImages : findBytailgateId(tailgateId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tailgateImages);
		}
	}

	/**
	 * Returns the number of tailgate imageses where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @return the number of matching tailgate imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBytailgateId(long tailgateId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAILGATEID;

		Object[] finderArgs = new Object[] { tailgateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAILGATEIMAGES_WHERE);

			query.append(_FINDER_COLUMN_TAILGATEID_TAILGATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tailgateId);

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

	private static final String _FINDER_COLUMN_TAILGATEID_TAILGATEID_2 = "tailgateImages.tailgateId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_IMAGEUUID =
		new FinderPath(TailgateImagesModelImpl.ENTITY_CACHE_ENABLED,
			TailgateImagesModelImpl.FINDER_CACHE_ENABLED,
			TailgateImagesImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByimageUUID",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEUUID =
		new FinderPath(TailgateImagesModelImpl.ENTITY_CACHE_ENABLED,
			TailgateImagesModelImpl.FINDER_CACHE_ENABLED,
			TailgateImagesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByimageUUID",
			new String[] { String.class.getName() },
			TailgateImagesModelImpl.IMAGEUUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IMAGEUUID = new FinderPath(TailgateImagesModelImpl.ENTITY_CACHE_ENABLED,
			TailgateImagesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByimageUUID",
			new String[] { String.class.getName() });

	/**
	 * Returns all the tailgate imageses where imageUUID = &#63;.
	 *
	 * @param imageUUID the image u u i d
	 * @return the matching tailgate imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateImages> findByimageUUID(String imageUUID)
		throws SystemException {
		return findByimageUUID(imageUUID, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the tailgate imageses where imageUUID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param imageUUID the image u u i d
	 * @param start the lower bound of the range of tailgate imageses
	 * @param end the upper bound of the range of tailgate imageses (not inclusive)
	 * @return the range of matching tailgate imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateImages> findByimageUUID(String imageUUID, int start,
		int end) throws SystemException {
		return findByimageUUID(imageUUID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tailgate imageses where imageUUID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param imageUUID the image u u i d
	 * @param start the lower bound of the range of tailgate imageses
	 * @param end the upper bound of the range of tailgate imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tailgate imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateImages> findByimageUUID(String imageUUID, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEUUID;
			finderArgs = new Object[] { imageUUID };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_IMAGEUUID;
			finderArgs = new Object[] { imageUUID, start, end, orderByComparator };
		}

		List<TailgateImages> list = (List<TailgateImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TailgateImages tailgateImages : list) {
				if (!Validator.equals(imageUUID, tailgateImages.getImageUUID())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TAILGATEIMAGES_WHERE);

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

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TailgateImagesModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<TailgateImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TailgateImages>(list);
				}
				else {
					list = (List<TailgateImages>)QueryUtil.list(q,
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
	 * Returns the first tailgate images in the ordered set where imageUUID = &#63;.
	 *
	 * @param imageUUID the image u u i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tailgate images
	 * @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a matching tailgate images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateImages findByimageUUID_First(String imageUUID,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateImagesException, SystemException {
		TailgateImages tailgateImages = fetchByimageUUID_First(imageUUID,
				orderByComparator);

		if (tailgateImages != null) {
			return tailgateImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("imageUUID=");
		msg.append(imageUUID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTailgateImagesException(msg.toString());
	}

	/**
	 * Returns the first tailgate images in the ordered set where imageUUID = &#63;.
	 *
	 * @param imageUUID the image u u i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tailgate images, or <code>null</code> if a matching tailgate images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateImages fetchByimageUUID_First(String imageUUID,
		OrderByComparator orderByComparator) throws SystemException {
		List<TailgateImages> list = findByimageUUID(imageUUID, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tailgate images in the ordered set where imageUUID = &#63;.
	 *
	 * @param imageUUID the image u u i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tailgate images
	 * @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a matching tailgate images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateImages findByimageUUID_Last(String imageUUID,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateImagesException, SystemException {
		TailgateImages tailgateImages = fetchByimageUUID_Last(imageUUID,
				orderByComparator);

		if (tailgateImages != null) {
			return tailgateImages;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("imageUUID=");
		msg.append(imageUUID);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTailgateImagesException(msg.toString());
	}

	/**
	 * Returns the last tailgate images in the ordered set where imageUUID = &#63;.
	 *
	 * @param imageUUID the image u u i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tailgate images, or <code>null</code> if a matching tailgate images could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateImages fetchByimageUUID_Last(String imageUUID,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByimageUUID(imageUUID);

		if (count == 0) {
			return null;
		}

		List<TailgateImages> list = findByimageUUID(imageUUID, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tailgate imageses before and after the current tailgate images in the ordered set where imageUUID = &#63;.
	 *
	 * @param tailgateImageId the primary key of the current tailgate images
	 * @param imageUUID the image u u i d
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tailgate images
	 * @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a tailgate images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateImages[] findByimageUUID_PrevAndNext(long tailgateImageId,
		String imageUUID, OrderByComparator orderByComparator)
		throws NoSuchTailgateImagesException, SystemException {
		TailgateImages tailgateImages = findByPrimaryKey(tailgateImageId);

		Session session = null;

		try {
			session = openSession();

			TailgateImages[] array = new TailgateImagesImpl[3];

			array[0] = getByimageUUID_PrevAndNext(session, tailgateImages,
					imageUUID, orderByComparator, true);

			array[1] = tailgateImages;

			array[2] = getByimageUUID_PrevAndNext(session, tailgateImages,
					imageUUID, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TailgateImages getByimageUUID_PrevAndNext(Session session,
		TailgateImages tailgateImages, String imageUUID,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAILGATEIMAGES_WHERE);

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

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(TailgateImagesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindImageUUID) {
			qPos.add(imageUUID);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tailgateImages);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TailgateImages> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tailgate imageses where imageUUID = &#63; from the database.
	 *
	 * @param imageUUID the image u u i d
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByimageUUID(String imageUUID) throws SystemException {
		for (TailgateImages tailgateImages : findByimageUUID(imageUUID,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tailgateImages);
		}
	}

	/**
	 * Returns the number of tailgate imageses where imageUUID = &#63;.
	 *
	 * @param imageUUID the image u u i d
	 * @return the number of matching tailgate imageses
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

			query.append(_SQL_COUNT_TAILGATEIMAGES_WHERE);

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

	private static final String _FINDER_COLUMN_IMAGEUUID_IMAGEUUID_1 = "tailgateImages.imageUUID IS NULL";
	private static final String _FINDER_COLUMN_IMAGEUUID_IMAGEUUID_2 = "tailgateImages.imageUUID = ?";
	private static final String _FINDER_COLUMN_IMAGEUUID_IMAGEUUID_3 = "(tailgateImages.imageUUID IS NULL OR tailgateImages.imageUUID = '')";

	public TailgateImagesPersistenceImpl() {
		setModelClass(TailgateImages.class);
	}

	/**
	 * Caches the tailgate images in the entity cache if it is enabled.
	 *
	 * @param tailgateImages the tailgate images
	 */
	@Override
	public void cacheResult(TailgateImages tailgateImages) {
		EntityCacheUtil.putResult(TailgateImagesModelImpl.ENTITY_CACHE_ENABLED,
			TailgateImagesImpl.class, tailgateImages.getPrimaryKey(),
			tailgateImages);

		tailgateImages.resetOriginalValues();
	}

	/**
	 * Caches the tailgate imageses in the entity cache if it is enabled.
	 *
	 * @param tailgateImageses the tailgate imageses
	 */
	@Override
	public void cacheResult(List<TailgateImages> tailgateImageses) {
		for (TailgateImages tailgateImages : tailgateImageses) {
			if (EntityCacheUtil.getResult(
						TailgateImagesModelImpl.ENTITY_CACHE_ENABLED,
						TailgateImagesImpl.class, tailgateImages.getPrimaryKey()) == null) {
				cacheResult(tailgateImages);
			}
			else {
				tailgateImages.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tailgate imageses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TailgateImagesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TailgateImagesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tailgate images.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TailgateImages tailgateImages) {
		EntityCacheUtil.removeResult(TailgateImagesModelImpl.ENTITY_CACHE_ENABLED,
			TailgateImagesImpl.class, tailgateImages.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TailgateImages> tailgateImageses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TailgateImages tailgateImages : tailgateImageses) {
			EntityCacheUtil.removeResult(TailgateImagesModelImpl.ENTITY_CACHE_ENABLED,
				TailgateImagesImpl.class, tailgateImages.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tailgate images with the primary key. Does not add the tailgate images to the database.
	 *
	 * @param tailgateImageId the primary key for the new tailgate images
	 * @return the new tailgate images
	 */
	@Override
	public TailgateImages create(long tailgateImageId) {
		TailgateImages tailgateImages = new TailgateImagesImpl();

		tailgateImages.setNew(true);
		tailgateImages.setPrimaryKey(tailgateImageId);

		return tailgateImages;
	}

	/**
	 * Removes the tailgate images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tailgateImageId the primary key of the tailgate images
	 * @return the tailgate images that was removed
	 * @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a tailgate images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateImages remove(long tailgateImageId)
		throws NoSuchTailgateImagesException, SystemException {
		return remove((Serializable)tailgateImageId);
	}

	/**
	 * Removes the tailgate images with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tailgate images
	 * @return the tailgate images that was removed
	 * @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a tailgate images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateImages remove(Serializable primaryKey)
		throws NoSuchTailgateImagesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TailgateImages tailgateImages = (TailgateImages)session.get(TailgateImagesImpl.class,
					primaryKey);

			if (tailgateImages == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTailgateImagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tailgateImages);
		}
		catch (NoSuchTailgateImagesException nsee) {
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
	protected TailgateImages removeImpl(TailgateImages tailgateImages)
		throws SystemException {
		tailgateImages = toUnwrappedModel(tailgateImages);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tailgateImages)) {
				tailgateImages = (TailgateImages)session.get(TailgateImagesImpl.class,
						tailgateImages.getPrimaryKeyObj());
			}

			if (tailgateImages != null) {
				session.delete(tailgateImages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tailgateImages != null) {
			clearCache(tailgateImages);
		}

		return tailgateImages;
	}

	@Override
	public TailgateImages updateImpl(
		com.rumbasolutions.flask.model.TailgateImages tailgateImages)
		throws SystemException {
		tailgateImages = toUnwrappedModel(tailgateImages);

		boolean isNew = tailgateImages.isNew();

		TailgateImagesModelImpl tailgateImagesModelImpl = (TailgateImagesModelImpl)tailgateImages;

		Session session = null;

		try {
			session = openSession();

			if (tailgateImages.isNew()) {
				session.save(tailgateImages);

				tailgateImages.setNew(false);
			}
			else {
				session.merge(tailgateImages);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TailgateImagesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tailgateImagesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tailgateImagesModelImpl.getOriginalTailgateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAILGATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID,
					args);

				args = new Object[] { tailgateImagesModelImpl.getTailgateId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAILGATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID,
					args);
			}

			if ((tailgateImagesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEUUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tailgateImagesModelImpl.getOriginalImageUUID()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMAGEUUID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEUUID,
					args);

				args = new Object[] { tailgateImagesModelImpl.getImageUUID() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IMAGEUUID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_IMAGEUUID,
					args);
			}
		}

		EntityCacheUtil.putResult(TailgateImagesModelImpl.ENTITY_CACHE_ENABLED,
			TailgateImagesImpl.class, tailgateImages.getPrimaryKey(),
			tailgateImages);

		return tailgateImages;
	}

	protected TailgateImages toUnwrappedModel(TailgateImages tailgateImages) {
		if (tailgateImages instanceof TailgateImagesImpl) {
			return tailgateImages;
		}

		TailgateImagesImpl tailgateImagesImpl = new TailgateImagesImpl();

		tailgateImagesImpl.setNew(tailgateImages.isNew());
		tailgateImagesImpl.setPrimaryKey(tailgateImages.getPrimaryKey());

		tailgateImagesImpl.setTailgateImageId(tailgateImages.getTailgateImageId());
		tailgateImagesImpl.setTailgateId(tailgateImages.getTailgateId());
		tailgateImagesImpl.setUserId(tailgateImages.getUserId());
		tailgateImagesImpl.setImageTitle(tailgateImages.getImageTitle());
		tailgateImagesImpl.setImageDesc(tailgateImages.getImageDesc());
		tailgateImagesImpl.setImageUUID(tailgateImages.getImageUUID());
		tailgateImagesImpl.setImageGroupId(tailgateImages.getImageGroupId());
		tailgateImagesImpl.setCreatedDate(tailgateImages.getCreatedDate());
		tailgateImagesImpl.setModifiedDate(tailgateImages.getModifiedDate());

		return tailgateImagesImpl;
	}

	/**
	 * Returns the tailgate images with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tailgate images
	 * @return the tailgate images
	 * @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a tailgate images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateImages findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTailgateImagesException, SystemException {
		TailgateImages tailgateImages = fetchByPrimaryKey(primaryKey);

		if (tailgateImages == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTailgateImagesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tailgateImages;
	}

	/**
	 * Returns the tailgate images with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchTailgateImagesException} if it could not be found.
	 *
	 * @param tailgateImageId the primary key of the tailgate images
	 * @return the tailgate images
	 * @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a tailgate images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateImages findByPrimaryKey(long tailgateImageId)
		throws NoSuchTailgateImagesException, SystemException {
		return findByPrimaryKey((Serializable)tailgateImageId);
	}

	/**
	 * Returns the tailgate images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tailgate images
	 * @return the tailgate images, or <code>null</code> if a tailgate images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateImages fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TailgateImages tailgateImages = (TailgateImages)EntityCacheUtil.getResult(TailgateImagesModelImpl.ENTITY_CACHE_ENABLED,
				TailgateImagesImpl.class, primaryKey);

		if (tailgateImages == _nullTailgateImages) {
			return null;
		}

		if (tailgateImages == null) {
			Session session = null;

			try {
				session = openSession();

				tailgateImages = (TailgateImages)session.get(TailgateImagesImpl.class,
						primaryKey);

				if (tailgateImages != null) {
					cacheResult(tailgateImages);
				}
				else {
					EntityCacheUtil.putResult(TailgateImagesModelImpl.ENTITY_CACHE_ENABLED,
						TailgateImagesImpl.class, primaryKey,
						_nullTailgateImages);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TailgateImagesModelImpl.ENTITY_CACHE_ENABLED,
					TailgateImagesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tailgateImages;
	}

	/**
	 * Returns the tailgate images with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tailgateImageId the primary key of the tailgate images
	 * @return the tailgate images, or <code>null</code> if a tailgate images with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateImages fetchByPrimaryKey(long tailgateImageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)tailgateImageId);
	}

	/**
	 * Returns all the tailgate imageses.
	 *
	 * @return the tailgate imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateImages> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tailgate imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tailgate imageses
	 * @param end the upper bound of the range of tailgate imageses (not inclusive)
	 * @return the range of tailgate imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateImages> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tailgate imageses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tailgate imageses
	 * @param end the upper bound of the range of tailgate imageses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tailgate imageses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateImages> findAll(int start, int end,
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

		List<TailgateImages> list = (List<TailgateImages>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAILGATEIMAGES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAILGATEIMAGES;

				if (pagination) {
					sql = sql.concat(TailgateImagesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TailgateImages>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TailgateImages>(list);
				}
				else {
					list = (List<TailgateImages>)QueryUtil.list(q,
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
	 * Removes all the tailgate imageses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TailgateImages tailgateImages : findAll()) {
			remove(tailgateImages);
		}
	}

	/**
	 * Returns the number of tailgate imageses.
	 *
	 * @return the number of tailgate imageses
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

				Query q = session.createQuery(_SQL_COUNT_TAILGATEIMAGES);

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
	 * Initializes the tailgate images persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.TailgateImages")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TailgateImages>> listenersList = new ArrayList<ModelListener<TailgateImages>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TailgateImages>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TailgateImagesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TAILGATEIMAGES = "SELECT tailgateImages FROM TailgateImages tailgateImages";
	private static final String _SQL_SELECT_TAILGATEIMAGES_WHERE = "SELECT tailgateImages FROM TailgateImages tailgateImages WHERE ";
	private static final String _SQL_COUNT_TAILGATEIMAGES = "SELECT COUNT(tailgateImages) FROM TailgateImages tailgateImages";
	private static final String _SQL_COUNT_TAILGATEIMAGES_WHERE = "SELECT COUNT(tailgateImages) FROM TailgateImages tailgateImages WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tailgateImages.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TailgateImages exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TailgateImages exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TailgateImagesPersistenceImpl.class);
	private static TailgateImages _nullTailgateImages = new TailgateImagesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TailgateImages> toCacheModel() {
				return _nullTailgateImagesCacheModel;
			}
		};

	private static CacheModel<TailgateImages> _nullTailgateImagesCacheModel = new CacheModel<TailgateImages>() {
			@Override
			public TailgateImages toEntityModel() {
				return _nullTailgateImages;
			}
		};
}