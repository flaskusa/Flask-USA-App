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

package com.liferay.contacts.service.persistence;

import com.liferay.contacts.NoSuchDeviceAwsEndpointException;
import com.liferay.contacts.model.DeviceAwsEndpoint;
import com.liferay.contacts.model.impl.DeviceAwsEndpointImpl;
import com.liferay.contacts.model.impl.DeviceAwsEndpointModelImpl;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the device aws endpoint service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DeviceAwsEndpointPersistence
 * @see DeviceAwsEndpointUtil
 * @generated
 */
public class DeviceAwsEndpointPersistenceImpl extends BasePersistenceImpl<DeviceAwsEndpoint>
	implements DeviceAwsEndpointPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DeviceAwsEndpointUtil} to access the device aws endpoint persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DeviceAwsEndpointImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DeviceAwsEndpointModelImpl.ENTITY_CACHE_ENABLED,
			DeviceAwsEndpointModelImpl.FINDER_CACHE_ENABLED,
			DeviceAwsEndpointImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DeviceAwsEndpointModelImpl.ENTITY_CACHE_ENABLED,
			DeviceAwsEndpointModelImpl.FINDER_CACHE_ENABLED,
			DeviceAwsEndpointImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DeviceAwsEndpointModelImpl.ENTITY_CACHE_ENABLED,
			DeviceAwsEndpointModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ENDPOINTSBYREGISTRATIONID =
		new FinderPath(DeviceAwsEndpointModelImpl.ENTITY_CACHE_ENABLED,
			DeviceAwsEndpointModelImpl.FINDER_CACHE_ENABLED,
			DeviceAwsEndpointImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByendpointsByRegistrationId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENDPOINTSBYREGISTRATIONID =
		new FinderPath(DeviceAwsEndpointModelImpl.ENTITY_CACHE_ENABLED,
			DeviceAwsEndpointModelImpl.FINDER_CACHE_ENABLED,
			DeviceAwsEndpointImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByendpointsByRegistrationId",
			new String[] { Long.class.getName() },
			DeviceAwsEndpointModelImpl.USERDEVICEREGISTRATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ENDPOINTSBYREGISTRATIONID =
		new FinderPath(DeviceAwsEndpointModelImpl.ENTITY_CACHE_ENABLED,
			DeviceAwsEndpointModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByendpointsByRegistrationId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the device aws endpoints where userDeviceRegistrationId = &#63;.
	 *
	 * @param userDeviceRegistrationId the user device registration ID
	 * @return the matching device aws endpoints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeviceAwsEndpoint> findByendpointsByRegistrationId(
		long userDeviceRegistrationId) throws SystemException {
		return findByendpointsByRegistrationId(userDeviceRegistrationId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the device aws endpoints where userDeviceRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.DeviceAwsEndpointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userDeviceRegistrationId the user device registration ID
	 * @param start the lower bound of the range of device aws endpoints
	 * @param end the upper bound of the range of device aws endpoints (not inclusive)
	 * @return the range of matching device aws endpoints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeviceAwsEndpoint> findByendpointsByRegistrationId(
		long userDeviceRegistrationId, int start, int end)
		throws SystemException {
		return findByendpointsByRegistrationId(userDeviceRegistrationId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the device aws endpoints where userDeviceRegistrationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.DeviceAwsEndpointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userDeviceRegistrationId the user device registration ID
	 * @param start the lower bound of the range of device aws endpoints
	 * @param end the upper bound of the range of device aws endpoints (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching device aws endpoints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeviceAwsEndpoint> findByendpointsByRegistrationId(
		long userDeviceRegistrationId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENDPOINTSBYREGISTRATIONID;
			finderArgs = new Object[] { userDeviceRegistrationId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ENDPOINTSBYREGISTRATIONID;
			finderArgs = new Object[] {
					userDeviceRegistrationId,
					
					start, end, orderByComparator
				};
		}

		List<DeviceAwsEndpoint> list = (List<DeviceAwsEndpoint>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DeviceAwsEndpoint deviceAwsEndpoint : list) {
				if ((userDeviceRegistrationId != deviceAwsEndpoint.getUserDeviceRegistrationId())) {
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

			query.append(_SQL_SELECT_DEVICEAWSENDPOINT_WHERE);

			query.append(_FINDER_COLUMN_ENDPOINTSBYREGISTRATIONID_USERDEVICEREGISTRATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DeviceAwsEndpointModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userDeviceRegistrationId);

				if (!pagination) {
					list = (List<DeviceAwsEndpoint>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DeviceAwsEndpoint>(list);
				}
				else {
					list = (List<DeviceAwsEndpoint>)QueryUtil.list(q,
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
	 * Returns the first device aws endpoint in the ordered set where userDeviceRegistrationId = &#63;.
	 *
	 * @param userDeviceRegistrationId the user device registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device aws endpoint
	 * @throws com.liferay.contacts.NoSuchDeviceAwsEndpointException if a matching device aws endpoint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeviceAwsEndpoint findByendpointsByRegistrationId_First(
		long userDeviceRegistrationId, OrderByComparator orderByComparator)
		throws NoSuchDeviceAwsEndpointException, SystemException {
		DeviceAwsEndpoint deviceAwsEndpoint = fetchByendpointsByRegistrationId_First(userDeviceRegistrationId,
				orderByComparator);

		if (deviceAwsEndpoint != null) {
			return deviceAwsEndpoint;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userDeviceRegistrationId=");
		msg.append(userDeviceRegistrationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeviceAwsEndpointException(msg.toString());
	}

	/**
	 * Returns the first device aws endpoint in the ordered set where userDeviceRegistrationId = &#63;.
	 *
	 * @param userDeviceRegistrationId the user device registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching device aws endpoint, or <code>null</code> if a matching device aws endpoint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeviceAwsEndpoint fetchByendpointsByRegistrationId_First(
		long userDeviceRegistrationId, OrderByComparator orderByComparator)
		throws SystemException {
		List<DeviceAwsEndpoint> list = findByendpointsByRegistrationId(userDeviceRegistrationId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last device aws endpoint in the ordered set where userDeviceRegistrationId = &#63;.
	 *
	 * @param userDeviceRegistrationId the user device registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device aws endpoint
	 * @throws com.liferay.contacts.NoSuchDeviceAwsEndpointException if a matching device aws endpoint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeviceAwsEndpoint findByendpointsByRegistrationId_Last(
		long userDeviceRegistrationId, OrderByComparator orderByComparator)
		throws NoSuchDeviceAwsEndpointException, SystemException {
		DeviceAwsEndpoint deviceAwsEndpoint = fetchByendpointsByRegistrationId_Last(userDeviceRegistrationId,
				orderByComparator);

		if (deviceAwsEndpoint != null) {
			return deviceAwsEndpoint;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userDeviceRegistrationId=");
		msg.append(userDeviceRegistrationId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeviceAwsEndpointException(msg.toString());
	}

	/**
	 * Returns the last device aws endpoint in the ordered set where userDeviceRegistrationId = &#63;.
	 *
	 * @param userDeviceRegistrationId the user device registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching device aws endpoint, or <code>null</code> if a matching device aws endpoint could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeviceAwsEndpoint fetchByendpointsByRegistrationId_Last(
		long userDeviceRegistrationId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByendpointsByRegistrationId(userDeviceRegistrationId);

		if (count == 0) {
			return null;
		}

		List<DeviceAwsEndpoint> list = findByendpointsByRegistrationId(userDeviceRegistrationId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the device aws endpoints before and after the current device aws endpoint in the ordered set where userDeviceRegistrationId = &#63;.
	 *
	 * @param deviceEndPointId the primary key of the current device aws endpoint
	 * @param userDeviceRegistrationId the user device registration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next device aws endpoint
	 * @throws com.liferay.contacts.NoSuchDeviceAwsEndpointException if a device aws endpoint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeviceAwsEndpoint[] findByendpointsByRegistrationId_PrevAndNext(
		long deviceEndPointId, long userDeviceRegistrationId,
		OrderByComparator orderByComparator)
		throws NoSuchDeviceAwsEndpointException, SystemException {
		DeviceAwsEndpoint deviceAwsEndpoint = findByPrimaryKey(deviceEndPointId);

		Session session = null;

		try {
			session = openSession();

			DeviceAwsEndpoint[] array = new DeviceAwsEndpointImpl[3];

			array[0] = getByendpointsByRegistrationId_PrevAndNext(session,
					deviceAwsEndpoint, userDeviceRegistrationId,
					orderByComparator, true);

			array[1] = deviceAwsEndpoint;

			array[2] = getByendpointsByRegistrationId_PrevAndNext(session,
					deviceAwsEndpoint, userDeviceRegistrationId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DeviceAwsEndpoint getByendpointsByRegistrationId_PrevAndNext(
		Session session, DeviceAwsEndpoint deviceAwsEndpoint,
		long userDeviceRegistrationId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEVICEAWSENDPOINT_WHERE);

		query.append(_FINDER_COLUMN_ENDPOINTSBYREGISTRATIONID_USERDEVICEREGISTRATIONID_2);

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
			query.append(DeviceAwsEndpointModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userDeviceRegistrationId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(deviceAwsEndpoint);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DeviceAwsEndpoint> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the device aws endpoints where userDeviceRegistrationId = &#63; from the database.
	 *
	 * @param userDeviceRegistrationId the user device registration ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByendpointsByRegistrationId(long userDeviceRegistrationId)
		throws SystemException {
		for (DeviceAwsEndpoint deviceAwsEndpoint : findByendpointsByRegistrationId(
				userDeviceRegistrationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(deviceAwsEndpoint);
		}
	}

	/**
	 * Returns the number of device aws endpoints where userDeviceRegistrationId = &#63;.
	 *
	 * @param userDeviceRegistrationId the user device registration ID
	 * @return the number of matching device aws endpoints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByendpointsByRegistrationId(long userDeviceRegistrationId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ENDPOINTSBYREGISTRATIONID;

		Object[] finderArgs = new Object[] { userDeviceRegistrationId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DEVICEAWSENDPOINT_WHERE);

			query.append(_FINDER_COLUMN_ENDPOINTSBYREGISTRATIONID_USERDEVICEREGISTRATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userDeviceRegistrationId);

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

	private static final String _FINDER_COLUMN_ENDPOINTSBYREGISTRATIONID_USERDEVICEREGISTRATIONID_2 =
		"deviceAwsEndpoint.userDeviceRegistrationId = ?";

	public DeviceAwsEndpointPersistenceImpl() {
		setModelClass(DeviceAwsEndpoint.class);
	}

	/**
	 * Caches the device aws endpoint in the entity cache if it is enabled.
	 *
	 * @param deviceAwsEndpoint the device aws endpoint
	 */
	@Override
	public void cacheResult(DeviceAwsEndpoint deviceAwsEndpoint) {
		EntityCacheUtil.putResult(DeviceAwsEndpointModelImpl.ENTITY_CACHE_ENABLED,
			DeviceAwsEndpointImpl.class, deviceAwsEndpoint.getPrimaryKey(),
			deviceAwsEndpoint);

		deviceAwsEndpoint.resetOriginalValues();
	}

	/**
	 * Caches the device aws endpoints in the entity cache if it is enabled.
	 *
	 * @param deviceAwsEndpoints the device aws endpoints
	 */
	@Override
	public void cacheResult(List<DeviceAwsEndpoint> deviceAwsEndpoints) {
		for (DeviceAwsEndpoint deviceAwsEndpoint : deviceAwsEndpoints) {
			if (EntityCacheUtil.getResult(
						DeviceAwsEndpointModelImpl.ENTITY_CACHE_ENABLED,
						DeviceAwsEndpointImpl.class,
						deviceAwsEndpoint.getPrimaryKey()) == null) {
				cacheResult(deviceAwsEndpoint);
			}
			else {
				deviceAwsEndpoint.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all device aws endpoints.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DeviceAwsEndpointImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DeviceAwsEndpointImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the device aws endpoint.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DeviceAwsEndpoint deviceAwsEndpoint) {
		EntityCacheUtil.removeResult(DeviceAwsEndpointModelImpl.ENTITY_CACHE_ENABLED,
			DeviceAwsEndpointImpl.class, deviceAwsEndpoint.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DeviceAwsEndpoint> deviceAwsEndpoints) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DeviceAwsEndpoint deviceAwsEndpoint : deviceAwsEndpoints) {
			EntityCacheUtil.removeResult(DeviceAwsEndpointModelImpl.ENTITY_CACHE_ENABLED,
				DeviceAwsEndpointImpl.class, deviceAwsEndpoint.getPrimaryKey());
		}
	}

	/**
	 * Creates a new device aws endpoint with the primary key. Does not add the device aws endpoint to the database.
	 *
	 * @param deviceEndPointId the primary key for the new device aws endpoint
	 * @return the new device aws endpoint
	 */
	@Override
	public DeviceAwsEndpoint create(long deviceEndPointId) {
		DeviceAwsEndpoint deviceAwsEndpoint = new DeviceAwsEndpointImpl();

		deviceAwsEndpoint.setNew(true);
		deviceAwsEndpoint.setPrimaryKey(deviceEndPointId);

		return deviceAwsEndpoint;
	}

	/**
	 * Removes the device aws endpoint with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deviceEndPointId the primary key of the device aws endpoint
	 * @return the device aws endpoint that was removed
	 * @throws com.liferay.contacts.NoSuchDeviceAwsEndpointException if a device aws endpoint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeviceAwsEndpoint remove(long deviceEndPointId)
		throws NoSuchDeviceAwsEndpointException, SystemException {
		return remove((Serializable)deviceEndPointId);
	}

	/**
	 * Removes the device aws endpoint with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the device aws endpoint
	 * @return the device aws endpoint that was removed
	 * @throws com.liferay.contacts.NoSuchDeviceAwsEndpointException if a device aws endpoint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeviceAwsEndpoint remove(Serializable primaryKey)
		throws NoSuchDeviceAwsEndpointException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DeviceAwsEndpoint deviceAwsEndpoint = (DeviceAwsEndpoint)session.get(DeviceAwsEndpointImpl.class,
					primaryKey);

			if (deviceAwsEndpoint == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDeviceAwsEndpointException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(deviceAwsEndpoint);
		}
		catch (NoSuchDeviceAwsEndpointException nsee) {
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
	protected DeviceAwsEndpoint removeImpl(DeviceAwsEndpoint deviceAwsEndpoint)
		throws SystemException {
		deviceAwsEndpoint = toUnwrappedModel(deviceAwsEndpoint);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(deviceAwsEndpoint)) {
				deviceAwsEndpoint = (DeviceAwsEndpoint)session.get(DeviceAwsEndpointImpl.class,
						deviceAwsEndpoint.getPrimaryKeyObj());
			}

			if (deviceAwsEndpoint != null) {
				session.delete(deviceAwsEndpoint);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (deviceAwsEndpoint != null) {
			clearCache(deviceAwsEndpoint);
		}

		return deviceAwsEndpoint;
	}

	@Override
	public DeviceAwsEndpoint updateImpl(
		com.liferay.contacts.model.DeviceAwsEndpoint deviceAwsEndpoint)
		throws SystemException {
		deviceAwsEndpoint = toUnwrappedModel(deviceAwsEndpoint);

		boolean isNew = deviceAwsEndpoint.isNew();

		DeviceAwsEndpointModelImpl deviceAwsEndpointModelImpl = (DeviceAwsEndpointModelImpl)deviceAwsEndpoint;

		Session session = null;

		try {
			session = openSession();

			if (deviceAwsEndpoint.isNew()) {
				session.save(deviceAwsEndpoint);

				deviceAwsEndpoint.setNew(false);
			}
			else {
				session.merge(deviceAwsEndpoint);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DeviceAwsEndpointModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((deviceAwsEndpointModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENDPOINTSBYREGISTRATIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						deviceAwsEndpointModelImpl.getOriginalUserDeviceRegistrationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENDPOINTSBYREGISTRATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENDPOINTSBYREGISTRATIONID,
					args);

				args = new Object[] {
						deviceAwsEndpointModelImpl.getUserDeviceRegistrationId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ENDPOINTSBYREGISTRATIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ENDPOINTSBYREGISTRATIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(DeviceAwsEndpointModelImpl.ENTITY_CACHE_ENABLED,
			DeviceAwsEndpointImpl.class, deviceAwsEndpoint.getPrimaryKey(),
			deviceAwsEndpoint);

		return deviceAwsEndpoint;
	}

	protected DeviceAwsEndpoint toUnwrappedModel(
		DeviceAwsEndpoint deviceAwsEndpoint) {
		if (deviceAwsEndpoint instanceof DeviceAwsEndpointImpl) {
			return deviceAwsEndpoint;
		}

		DeviceAwsEndpointImpl deviceAwsEndpointImpl = new DeviceAwsEndpointImpl();

		deviceAwsEndpointImpl.setNew(deviceAwsEndpoint.isNew());
		deviceAwsEndpointImpl.setPrimaryKey(deviceAwsEndpoint.getPrimaryKey());

		deviceAwsEndpointImpl.setDeviceEndPointId(deviceAwsEndpoint.getDeviceEndPointId());
		deviceAwsEndpointImpl.setAwsEndpoint(deviceAwsEndpoint.getAwsEndpoint());
		deviceAwsEndpointImpl.setUserDeviceRegistrationId(deviceAwsEndpoint.getUserDeviceRegistrationId());

		return deviceAwsEndpointImpl;
	}

	/**
	 * Returns the device aws endpoint with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the device aws endpoint
	 * @return the device aws endpoint
	 * @throws com.liferay.contacts.NoSuchDeviceAwsEndpointException if a device aws endpoint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeviceAwsEndpoint findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDeviceAwsEndpointException, SystemException {
		DeviceAwsEndpoint deviceAwsEndpoint = fetchByPrimaryKey(primaryKey);

		if (deviceAwsEndpoint == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDeviceAwsEndpointException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return deviceAwsEndpoint;
	}

	/**
	 * Returns the device aws endpoint with the primary key or throws a {@link com.liferay.contacts.NoSuchDeviceAwsEndpointException} if it could not be found.
	 *
	 * @param deviceEndPointId the primary key of the device aws endpoint
	 * @return the device aws endpoint
	 * @throws com.liferay.contacts.NoSuchDeviceAwsEndpointException if a device aws endpoint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeviceAwsEndpoint findByPrimaryKey(long deviceEndPointId)
		throws NoSuchDeviceAwsEndpointException, SystemException {
		return findByPrimaryKey((Serializable)deviceEndPointId);
	}

	/**
	 * Returns the device aws endpoint with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the device aws endpoint
	 * @return the device aws endpoint, or <code>null</code> if a device aws endpoint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeviceAwsEndpoint fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DeviceAwsEndpoint deviceAwsEndpoint = (DeviceAwsEndpoint)EntityCacheUtil.getResult(DeviceAwsEndpointModelImpl.ENTITY_CACHE_ENABLED,
				DeviceAwsEndpointImpl.class, primaryKey);

		if (deviceAwsEndpoint == _nullDeviceAwsEndpoint) {
			return null;
		}

		if (deviceAwsEndpoint == null) {
			Session session = null;

			try {
				session = openSession();

				deviceAwsEndpoint = (DeviceAwsEndpoint)session.get(DeviceAwsEndpointImpl.class,
						primaryKey);

				if (deviceAwsEndpoint != null) {
					cacheResult(deviceAwsEndpoint);
				}
				else {
					EntityCacheUtil.putResult(DeviceAwsEndpointModelImpl.ENTITY_CACHE_ENABLED,
						DeviceAwsEndpointImpl.class, primaryKey,
						_nullDeviceAwsEndpoint);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DeviceAwsEndpointModelImpl.ENTITY_CACHE_ENABLED,
					DeviceAwsEndpointImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return deviceAwsEndpoint;
	}

	/**
	 * Returns the device aws endpoint with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deviceEndPointId the primary key of the device aws endpoint
	 * @return the device aws endpoint, or <code>null</code> if a device aws endpoint with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeviceAwsEndpoint fetchByPrimaryKey(long deviceEndPointId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)deviceEndPointId);
	}

	/**
	 * Returns all the device aws endpoints.
	 *
	 * @return the device aws endpoints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeviceAwsEndpoint> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the device aws endpoints.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.DeviceAwsEndpointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of device aws endpoints
	 * @param end the upper bound of the range of device aws endpoints (not inclusive)
	 * @return the range of device aws endpoints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeviceAwsEndpoint> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the device aws endpoints.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.DeviceAwsEndpointModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of device aws endpoints
	 * @param end the upper bound of the range of device aws endpoints (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of device aws endpoints
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeviceAwsEndpoint> findAll(int start, int end,
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

		List<DeviceAwsEndpoint> list = (List<DeviceAwsEndpoint>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DEVICEAWSENDPOINT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEVICEAWSENDPOINT;

				if (pagination) {
					sql = sql.concat(DeviceAwsEndpointModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DeviceAwsEndpoint>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DeviceAwsEndpoint>(list);
				}
				else {
					list = (List<DeviceAwsEndpoint>)QueryUtil.list(q,
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
	 * Removes all the device aws endpoints from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DeviceAwsEndpoint deviceAwsEndpoint : findAll()) {
			remove(deviceAwsEndpoint);
		}
	}

	/**
	 * Returns the number of device aws endpoints.
	 *
	 * @return the number of device aws endpoints
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

				Query q = session.createQuery(_SQL_COUNT_DEVICEAWSENDPOINT);

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
	 * Initializes the device aws endpoint persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.contacts.model.DeviceAwsEndpoint")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DeviceAwsEndpoint>> listenersList = new ArrayList<ModelListener<DeviceAwsEndpoint>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DeviceAwsEndpoint>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DeviceAwsEndpointImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DEVICEAWSENDPOINT = "SELECT deviceAwsEndpoint FROM DeviceAwsEndpoint deviceAwsEndpoint";
	private static final String _SQL_SELECT_DEVICEAWSENDPOINT_WHERE = "SELECT deviceAwsEndpoint FROM DeviceAwsEndpoint deviceAwsEndpoint WHERE ";
	private static final String _SQL_COUNT_DEVICEAWSENDPOINT = "SELECT COUNT(deviceAwsEndpoint) FROM DeviceAwsEndpoint deviceAwsEndpoint";
	private static final String _SQL_COUNT_DEVICEAWSENDPOINT_WHERE = "SELECT COUNT(deviceAwsEndpoint) FROM DeviceAwsEndpoint deviceAwsEndpoint WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "deviceAwsEndpoint.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DeviceAwsEndpoint exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DeviceAwsEndpoint exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DeviceAwsEndpointPersistenceImpl.class);
	private static DeviceAwsEndpoint _nullDeviceAwsEndpoint = new DeviceAwsEndpointImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DeviceAwsEndpoint> toCacheModel() {
				return _nullDeviceAwsEndpointCacheModel;
			}
		};

	private static CacheModel<DeviceAwsEndpoint> _nullDeviceAwsEndpointCacheModel =
		new CacheModel<DeviceAwsEndpoint>() {
			@Override
			public DeviceAwsEndpoint toEntityModel() {
				return _nullDeviceAwsEndpoint;
			}
		};
}