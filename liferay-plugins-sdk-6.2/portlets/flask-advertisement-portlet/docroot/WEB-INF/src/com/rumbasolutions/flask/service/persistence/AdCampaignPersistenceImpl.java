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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rumbasolutions.flask.NoSuchAdCampaignException;
import com.rumbasolutions.flask.model.AdCampaign;
import com.rumbasolutions.flask.model.impl.AdCampaignImpl;
import com.rumbasolutions.flask.model.impl.AdCampaignModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ad campaign service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdCampaignPersistence
 * @see AdCampaignUtil
 * @generated
 */
public class AdCampaignPersistenceImpl extends BasePersistenceImpl<AdCampaign>
	implements AdCampaignPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AdCampaignUtil} to access the ad campaign persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdCampaignImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AdCampaignModelImpl.ENTITY_CACHE_ENABLED,
			AdCampaignModelImpl.FINDER_CACHE_ENABLED, AdCampaignImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AdCampaignModelImpl.ENTITY_CACHE_ENABLED,
			AdCampaignModelImpl.FINDER_CACHE_ENABLED, AdCampaignImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AdCampaignModelImpl.ENTITY_CACHE_ENABLED,
			AdCampaignModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CUSTOMERID =
		new FinderPath(AdCampaignModelImpl.ENTITY_CACHE_ENABLED,
			AdCampaignModelImpl.FINDER_CACHE_ENABLED, AdCampaignImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycustomerId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERID =
		new FinderPath(AdCampaignModelImpl.ENTITY_CACHE_ENABLED,
			AdCampaignModelImpl.FINDER_CACHE_ENABLED, AdCampaignImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycustomerId",
			new String[] { Long.class.getName() },
			AdCampaignModelImpl.CUSTOMERID_COLUMN_BITMASK |
			AdCampaignModelImpl.CAMPAIGNNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CUSTOMERID = new FinderPath(AdCampaignModelImpl.ENTITY_CACHE_ENABLED,
			AdCampaignModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycustomerId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the ad campaigns where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the matching ad campaigns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCampaign> findBycustomerId(long customerId)
		throws SystemException {
		return findBycustomerId(customerId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad campaigns where customerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param start the lower bound of the range of ad campaigns
	 * @param end the upper bound of the range of ad campaigns (not inclusive)
	 * @return the range of matching ad campaigns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCampaign> findBycustomerId(long customerId, int start, int end)
		throws SystemException {
		return findBycustomerId(customerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad campaigns where customerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param start the lower bound of the range of ad campaigns
	 * @param end the upper bound of the range of ad campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ad campaigns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCampaign> findBycustomerId(long customerId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERID;
			finderArgs = new Object[] { customerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CUSTOMERID;
			finderArgs = new Object[] { customerId, start, end, orderByComparator };
		}

		List<AdCampaign> list = (List<AdCampaign>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdCampaign adCampaign : list) {
				if ((customerId != adCampaign.getCustomerId())) {
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

			query.append(_SQL_SELECT_ADCAMPAIGN_WHERE);

			query.append(_FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdCampaignModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerId);

				if (!pagination) {
					list = (List<AdCampaign>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdCampaign>(list);
				}
				else {
					list = (List<AdCampaign>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ad campaign in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad campaign
	 * @throws com.rumbasolutions.flask.NoSuchAdCampaignException if a matching ad campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCampaign findBycustomerId_First(long customerId,
		OrderByComparator orderByComparator)
		throws NoSuchAdCampaignException, SystemException {
		AdCampaign adCampaign = fetchBycustomerId_First(customerId,
				orderByComparator);

		if (adCampaign != null) {
			return adCampaign;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("customerId=");
		msg.append(customerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdCampaignException(msg.toString());
	}

	/**
	 * Returns the first ad campaign in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad campaign, or <code>null</code> if a matching ad campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCampaign fetchBycustomerId_First(long customerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdCampaign> list = findBycustomerId(customerId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ad campaign in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad campaign
	 * @throws com.rumbasolutions.flask.NoSuchAdCampaignException if a matching ad campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCampaign findBycustomerId_Last(long customerId,
		OrderByComparator orderByComparator)
		throws NoSuchAdCampaignException, SystemException {
		AdCampaign adCampaign = fetchBycustomerId_Last(customerId,
				orderByComparator);

		if (adCampaign != null) {
			return adCampaign;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("customerId=");
		msg.append(customerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdCampaignException(msg.toString());
	}

	/**
	 * Returns the last ad campaign in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad campaign, or <code>null</code> if a matching ad campaign could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCampaign fetchBycustomerId_Last(long customerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBycustomerId(customerId);

		if (count == 0) {
			return null;
		}

		List<AdCampaign> list = findBycustomerId(customerId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ad campaigns before and after the current ad campaign in the ordered set where customerId = &#63;.
	 *
	 * @param campaignId the primary key of the current ad campaign
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ad campaign
	 * @throws com.rumbasolutions.flask.NoSuchAdCampaignException if a ad campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCampaign[] findBycustomerId_PrevAndNext(long campaignId,
		long customerId, OrderByComparator orderByComparator)
		throws NoSuchAdCampaignException, SystemException {
		AdCampaign adCampaign = findByPrimaryKey(campaignId);

		Session session = null;

		try {
			session = openSession();

			AdCampaign[] array = new AdCampaignImpl[3];

			array[0] = getBycustomerId_PrevAndNext(session, adCampaign,
					customerId, orderByComparator, true);

			array[1] = adCampaign;

			array[2] = getBycustomerId_PrevAndNext(session, adCampaign,
					customerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdCampaign getBycustomerId_PrevAndNext(Session session,
		AdCampaign adCampaign, long customerId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADCAMPAIGN_WHERE);

		query.append(_FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2);

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
			query.append(AdCampaignModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(customerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adCampaign);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdCampaign> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ad campaigns where customerId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycustomerId(long customerId) throws SystemException {
		for (AdCampaign adCampaign : findBycustomerId(customerId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(adCampaign);
		}
	}

	/**
	 * Returns the number of ad campaigns where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the number of matching ad campaigns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycustomerId(long customerId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CUSTOMERID;

		Object[] finderArgs = new Object[] { customerId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADCAMPAIGN_WHERE);

			query.append(_FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(customerId);

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

	private static final String _FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2 = "adCampaign.customerId = ?";

	public AdCampaignPersistenceImpl() {
		setModelClass(AdCampaign.class);
	}

	/**
	 * Caches the ad campaign in the entity cache if it is enabled.
	 *
	 * @param adCampaign the ad campaign
	 */
	@Override
	public void cacheResult(AdCampaign adCampaign) {
		EntityCacheUtil.putResult(AdCampaignModelImpl.ENTITY_CACHE_ENABLED,
			AdCampaignImpl.class, adCampaign.getPrimaryKey(), adCampaign);

		adCampaign.resetOriginalValues();
	}

	/**
	 * Caches the ad campaigns in the entity cache if it is enabled.
	 *
	 * @param adCampaigns the ad campaigns
	 */
	@Override
	public void cacheResult(List<AdCampaign> adCampaigns) {
		for (AdCampaign adCampaign : adCampaigns) {
			if (EntityCacheUtil.getResult(
						AdCampaignModelImpl.ENTITY_CACHE_ENABLED,
						AdCampaignImpl.class, adCampaign.getPrimaryKey()) == null) {
				cacheResult(adCampaign);
			}
			else {
				adCampaign.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ad campaigns.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AdCampaignImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AdCampaignImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ad campaign.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdCampaign adCampaign) {
		EntityCacheUtil.removeResult(AdCampaignModelImpl.ENTITY_CACHE_ENABLED,
			AdCampaignImpl.class, adCampaign.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AdCampaign> adCampaigns) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AdCampaign adCampaign : adCampaigns) {
			EntityCacheUtil.removeResult(AdCampaignModelImpl.ENTITY_CACHE_ENABLED,
				AdCampaignImpl.class, adCampaign.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ad campaign with the primary key. Does not add the ad campaign to the database.
	 *
	 * @param campaignId the primary key for the new ad campaign
	 * @return the new ad campaign
	 */
	@Override
	public AdCampaign create(long campaignId) {
		AdCampaign adCampaign = new AdCampaignImpl();

		adCampaign.setNew(true);
		adCampaign.setPrimaryKey(campaignId);

		return adCampaign;
	}

	/**
	 * Removes the ad campaign with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campaignId the primary key of the ad campaign
	 * @return the ad campaign that was removed
	 * @throws com.rumbasolutions.flask.NoSuchAdCampaignException if a ad campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCampaign remove(long campaignId)
		throws NoSuchAdCampaignException, SystemException {
		return remove((Serializable)campaignId);
	}

	/**
	 * Removes the ad campaign with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ad campaign
	 * @return the ad campaign that was removed
	 * @throws com.rumbasolutions.flask.NoSuchAdCampaignException if a ad campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCampaign remove(Serializable primaryKey)
		throws NoSuchAdCampaignException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AdCampaign adCampaign = (AdCampaign)session.get(AdCampaignImpl.class,
					primaryKey);

			if (adCampaign == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdCampaignException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(adCampaign);
		}
		catch (NoSuchAdCampaignException nsee) {
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
	protected AdCampaign removeImpl(AdCampaign adCampaign)
		throws SystemException {
		adCampaign = toUnwrappedModel(adCampaign);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(adCampaign)) {
				adCampaign = (AdCampaign)session.get(AdCampaignImpl.class,
						adCampaign.getPrimaryKeyObj());
			}

			if (adCampaign != null) {
				session.delete(adCampaign);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (adCampaign != null) {
			clearCache(adCampaign);
		}

		return adCampaign;
	}

	@Override
	public AdCampaign updateImpl(
		com.rumbasolutions.flask.model.AdCampaign adCampaign)
		throws SystemException {
		adCampaign = toUnwrappedModel(adCampaign);

		boolean isNew = adCampaign.isNew();

		AdCampaignModelImpl adCampaignModelImpl = (AdCampaignModelImpl)adCampaign;

		Session session = null;

		try {
			session = openSession();

			if (adCampaign.isNew()) {
				session.save(adCampaign);

				adCampaign.setNew(false);
			}
			else {
				session.merge(adCampaign);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AdCampaignModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((adCampaignModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adCampaignModelImpl.getOriginalCustomerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CUSTOMERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERID,
					args);

				args = new Object[] { adCampaignModelImpl.getCustomerId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CUSTOMERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERID,
					args);
			}
		}

		EntityCacheUtil.putResult(AdCampaignModelImpl.ENTITY_CACHE_ENABLED,
			AdCampaignImpl.class, adCampaign.getPrimaryKey(), adCampaign);

		return adCampaign;
	}

	protected AdCampaign toUnwrappedModel(AdCampaign adCampaign) {
		if (adCampaign instanceof AdCampaignImpl) {
			return adCampaign;
		}

		AdCampaignImpl adCampaignImpl = new AdCampaignImpl();

		adCampaignImpl.setNew(adCampaign.isNew());
		adCampaignImpl.setPrimaryKey(adCampaign.getPrimaryKey());

		adCampaignImpl.setCampaignId(adCampaign.getCampaignId());
		adCampaignImpl.setUserId(adCampaign.getUserId());
		adCampaignImpl.setCreatedDate(adCampaign.getCreatedDate());
		adCampaignImpl.setModifiedDate(adCampaign.getModifiedDate());
		adCampaignImpl.setCampaignName(adCampaign.getCampaignName());
		adCampaignImpl.setCustomerId(adCampaign.getCustomerId());
		adCampaignImpl.setDisplayGeneral(adCampaign.isDisplayGeneral());
		adCampaignImpl.setDisplayPreEvent(adCampaign.isDisplayPreEvent());
		adCampaignImpl.setDisplayDuringEvent(adCampaign.isDisplayDuringEvent());
		adCampaignImpl.setDisplayPostEvent(adCampaign.isDisplayPostEvent());
		adCampaignImpl.setFrequencyPerHour(adCampaign.getFrequencyPerHour());
		adCampaignImpl.setEventTypeId(adCampaign.getEventTypeId());
		adCampaignImpl.setImageTitle(adCampaign.getImageTitle());
		adCampaignImpl.setImageDesc(adCampaign.getImageDesc());
		adCampaignImpl.setImageUUID(adCampaign.getImageUUID());
		adCampaignImpl.setImageGroupId(adCampaign.getImageGroupId());
		adCampaignImpl.setShowAlways(adCampaign.isShowAlways());

		return adCampaignImpl;
	}

	/**
	 * Returns the ad campaign with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ad campaign
	 * @return the ad campaign
	 * @throws com.rumbasolutions.flask.NoSuchAdCampaignException if a ad campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCampaign findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAdCampaignException, SystemException {
		AdCampaign adCampaign = fetchByPrimaryKey(primaryKey);

		if (adCampaign == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAdCampaignException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return adCampaign;
	}

	/**
	 * Returns the ad campaign with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchAdCampaignException} if it could not be found.
	 *
	 * @param campaignId the primary key of the ad campaign
	 * @return the ad campaign
	 * @throws com.rumbasolutions.flask.NoSuchAdCampaignException if a ad campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCampaign findByPrimaryKey(long campaignId)
		throws NoSuchAdCampaignException, SystemException {
		return findByPrimaryKey((Serializable)campaignId);
	}

	/**
	 * Returns the ad campaign with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ad campaign
	 * @return the ad campaign, or <code>null</code> if a ad campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCampaign fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AdCampaign adCampaign = (AdCampaign)EntityCacheUtil.getResult(AdCampaignModelImpl.ENTITY_CACHE_ENABLED,
				AdCampaignImpl.class, primaryKey);

		if (adCampaign == _nullAdCampaign) {
			return null;
		}

		if (adCampaign == null) {
			Session session = null;

			try {
				session = openSession();

				adCampaign = (AdCampaign)session.get(AdCampaignImpl.class,
						primaryKey);

				if (adCampaign != null) {
					cacheResult(adCampaign);
				}
				else {
					EntityCacheUtil.putResult(AdCampaignModelImpl.ENTITY_CACHE_ENABLED,
						AdCampaignImpl.class, primaryKey, _nullAdCampaign);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AdCampaignModelImpl.ENTITY_CACHE_ENABLED,
					AdCampaignImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return adCampaign;
	}

	/**
	 * Returns the ad campaign with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param campaignId the primary key of the ad campaign
	 * @return the ad campaign, or <code>null</code> if a ad campaign with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCampaign fetchByPrimaryKey(long campaignId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)campaignId);
	}

	/**
	 * Returns all the ad campaigns.
	 *
	 * @return the ad campaigns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCampaign> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad campaigns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ad campaigns
	 * @param end the upper bound of the range of ad campaigns (not inclusive)
	 * @return the range of ad campaigns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCampaign> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad campaigns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ad campaigns
	 * @param end the upper bound of the range of ad campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ad campaigns
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCampaign> findAll(int start, int end,
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

		List<AdCampaign> list = (List<AdCampaign>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADCAMPAIGN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADCAMPAIGN;

				if (pagination) {
					sql = sql.concat(AdCampaignModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AdCampaign>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdCampaign>(list);
				}
				else {
					list = (List<AdCampaign>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ad campaigns from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AdCampaign adCampaign : findAll()) {
			remove(adCampaign);
		}
	}

	/**
	 * Returns the number of ad campaigns.
	 *
	 * @return the number of ad campaigns
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

				Query q = session.createQuery(_SQL_COUNT_ADCAMPAIGN);

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
	 * Initializes the ad campaign persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.AdCampaign")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AdCampaign>> listenersList = new ArrayList<ModelListener<AdCampaign>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AdCampaign>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AdCampaignImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADCAMPAIGN = "SELECT adCampaign FROM AdCampaign adCampaign";
	private static final String _SQL_SELECT_ADCAMPAIGN_WHERE = "SELECT adCampaign FROM AdCampaign adCampaign WHERE ";
	private static final String _SQL_COUNT_ADCAMPAIGN = "SELECT COUNT(adCampaign) FROM AdCampaign adCampaign";
	private static final String _SQL_COUNT_ADCAMPAIGN_WHERE = "SELECT COUNT(adCampaign) FROM AdCampaign adCampaign WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "adCampaign.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdCampaign exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AdCampaign exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AdCampaignPersistenceImpl.class);
	private static AdCampaign _nullAdCampaign = new AdCampaignImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AdCampaign> toCacheModel() {
				return _nullAdCampaignCacheModel;
			}
		};

	private static CacheModel<AdCampaign> _nullAdCampaignCacheModel = new CacheModel<AdCampaign>() {
			@Override
			public AdCampaign toEntityModel() {
				return _nullAdCampaign;
			}
		};
}