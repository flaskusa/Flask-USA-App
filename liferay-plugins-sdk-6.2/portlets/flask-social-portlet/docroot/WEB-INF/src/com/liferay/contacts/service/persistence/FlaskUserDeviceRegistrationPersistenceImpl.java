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

import com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException;
import com.liferay.contacts.model.FlaskUserDeviceRegistration;
import com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationImpl;
import com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the flask user device registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskUserDeviceRegistrationPersistence
 * @see FlaskUserDeviceRegistrationUtil
 * @generated
 */
public class FlaskUserDeviceRegistrationPersistenceImpl
	extends BasePersistenceImpl<FlaskUserDeviceRegistration>
	implements FlaskUserDeviceRegistrationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FlaskUserDeviceRegistrationUtil} to access the flask user device registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FlaskUserDeviceRegistrationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FlaskUserDeviceRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FlaskUserDeviceRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FlaskUserDeviceRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FlaskUserDeviceRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			FlaskUserDeviceRegistrationModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserId", new String[] { Long.class.getName() });

	/**
	 * Returns all the flask user device registrations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUserDeviceRegistration> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flask user device registrations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of flask user device registrations
	 * @param end the upper bound of the range of flask user device registrations (not inclusive)
	 * @return the range of matching flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUserDeviceRegistration> findByUserId(long userId,
		int start, int end) throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask user device registrations where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of flask user device registrations
	 * @param end the upper bound of the range of flask user device registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUserDeviceRegistration> findByUserId(long userId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<FlaskUserDeviceRegistration> list = (List<FlaskUserDeviceRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FlaskUserDeviceRegistration flaskUserDeviceRegistration : list) {
				if ((userId != flaskUserDeviceRegistration.getUserId())) {
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

			query.append(_SQL_SELECT_FLASKUSERDEVICEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlaskUserDeviceRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<FlaskUserDeviceRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskUserDeviceRegistration>(list);
				}
				else {
					list = (List<FlaskUserDeviceRegistration>)QueryUtil.list(q,
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
	 * Returns the first flask user device registration in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask user device registration
	 * @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskUserDeviceRegistrationException, SystemException {
		FlaskUserDeviceRegistration flaskUserDeviceRegistration = fetchByUserId_First(userId,
				orderByComparator);

		if (flaskUserDeviceRegistration != null) {
			return flaskUserDeviceRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskUserDeviceRegistrationException(msg.toString());
	}

	/**
	 * Returns the first flask user device registration in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FlaskUserDeviceRegistration> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flask user device registration in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask user device registration
	 * @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskUserDeviceRegistrationException, SystemException {
		FlaskUserDeviceRegistration flaskUserDeviceRegistration = fetchByUserId_Last(userId,
				orderByComparator);

		if (flaskUserDeviceRegistration != null) {
			return flaskUserDeviceRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskUserDeviceRegistrationException(msg.toString());
	}

	/**
	 * Returns the last flask user device registration in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<FlaskUserDeviceRegistration> list = findByUserId(userId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flask user device registrations before and after the current flask user device registration in the ordered set where userId = &#63;.
	 *
	 * @param userDeviceRegistrationId the primary key of the current flask user device registration
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flask user device registration
	 * @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a flask user device registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration[] findByUserId_PrevAndNext(
		long userDeviceRegistrationId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskUserDeviceRegistrationException, SystemException {
		FlaskUserDeviceRegistration flaskUserDeviceRegistration = findByPrimaryKey(userDeviceRegistrationId);

		Session session = null;

		try {
			session = openSession();

			FlaskUserDeviceRegistration[] array = new FlaskUserDeviceRegistrationImpl[3];

			array[0] = getByUserId_PrevAndNext(session,
					flaskUserDeviceRegistration, userId, orderByComparator, true);

			array[1] = flaskUserDeviceRegistration;

			array[2] = getByUserId_PrevAndNext(session,
					flaskUserDeviceRegistration, userId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FlaskUserDeviceRegistration getByUserId_PrevAndNext(
		Session session,
		FlaskUserDeviceRegistration flaskUserDeviceRegistration, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLASKUSERDEVICEREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(FlaskUserDeviceRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flaskUserDeviceRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FlaskUserDeviceRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flask user device registrations where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (FlaskUserDeviceRegistration flaskUserDeviceRegistration : findByUserId(
				userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(flaskUserDeviceRegistration);
		}
	}

	/**
	 * Returns the number of flask user device registrations where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FLASKUSERDEVICEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "flaskUserDeviceRegistration.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USEREMAIL =
		new FinderPath(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FlaskUserDeviceRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserEmail",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USEREMAIL =
		new FinderPath(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FlaskUserDeviceRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserEmail",
			new String[] { String.class.getName() },
			FlaskUserDeviceRegistrationModelImpl.USEREMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USEREMAIL = new FinderPath(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByuserEmail", new String[] { String.class.getName() });

	/**
	 * Returns all the flask user device registrations where userEmail = &#63;.
	 *
	 * @param userEmail the user email
	 * @return the matching flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUserDeviceRegistration> findByuserEmail(String userEmail)
		throws SystemException {
		return findByuserEmail(userEmail, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the flask user device registrations where userEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userEmail the user email
	 * @param start the lower bound of the range of flask user device registrations
	 * @param end the upper bound of the range of flask user device registrations (not inclusive)
	 * @return the range of matching flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUserDeviceRegistration> findByuserEmail(String userEmail,
		int start, int end) throws SystemException {
		return findByuserEmail(userEmail, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask user device registrations where userEmail = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userEmail the user email
	 * @param start the lower bound of the range of flask user device registrations
	 * @param end the upper bound of the range of flask user device registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUserDeviceRegistration> findByuserEmail(String userEmail,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USEREMAIL;
			finderArgs = new Object[] { userEmail };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USEREMAIL;
			finderArgs = new Object[] { userEmail, start, end, orderByComparator };
		}

		List<FlaskUserDeviceRegistration> list = (List<FlaskUserDeviceRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FlaskUserDeviceRegistration flaskUserDeviceRegistration : list) {
				if (!Validator.equals(userEmail,
							flaskUserDeviceRegistration.getUserEmail())) {
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

			query.append(_SQL_SELECT_FLASKUSERDEVICEREGISTRATION_WHERE);

			boolean bindUserEmail = false;

			if (userEmail == null) {
				query.append(_FINDER_COLUMN_USEREMAIL_USEREMAIL_1);
			}
			else if (userEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USEREMAIL_USEREMAIL_3);
			}
			else {
				bindUserEmail = true;

				query.append(_FINDER_COLUMN_USEREMAIL_USEREMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlaskUserDeviceRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserEmail) {
					qPos.add(userEmail);
				}

				if (!pagination) {
					list = (List<FlaskUserDeviceRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskUserDeviceRegistration>(list);
				}
				else {
					list = (List<FlaskUserDeviceRegistration>)QueryUtil.list(q,
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
	 * Returns the first flask user device registration in the ordered set where userEmail = &#63;.
	 *
	 * @param userEmail the user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask user device registration
	 * @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration findByuserEmail_First(String userEmail,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskUserDeviceRegistrationException, SystemException {
		FlaskUserDeviceRegistration flaskUserDeviceRegistration = fetchByuserEmail_First(userEmail,
				orderByComparator);

		if (flaskUserDeviceRegistration != null) {
			return flaskUserDeviceRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userEmail=");
		msg.append(userEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskUserDeviceRegistrationException(msg.toString());
	}

	/**
	 * Returns the first flask user device registration in the ordered set where userEmail = &#63;.
	 *
	 * @param userEmail the user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration fetchByuserEmail_First(
		String userEmail, OrderByComparator orderByComparator)
		throws SystemException {
		List<FlaskUserDeviceRegistration> list = findByuserEmail(userEmail, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flask user device registration in the ordered set where userEmail = &#63;.
	 *
	 * @param userEmail the user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask user device registration
	 * @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration findByuserEmail_Last(String userEmail,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskUserDeviceRegistrationException, SystemException {
		FlaskUserDeviceRegistration flaskUserDeviceRegistration = fetchByuserEmail_Last(userEmail,
				orderByComparator);

		if (flaskUserDeviceRegistration != null) {
			return flaskUserDeviceRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userEmail=");
		msg.append(userEmail);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskUserDeviceRegistrationException(msg.toString());
	}

	/**
	 * Returns the last flask user device registration in the ordered set where userEmail = &#63;.
	 *
	 * @param userEmail the user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration fetchByuserEmail_Last(String userEmail,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserEmail(userEmail);

		if (count == 0) {
			return null;
		}

		List<FlaskUserDeviceRegistration> list = findByuserEmail(userEmail,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flask user device registrations before and after the current flask user device registration in the ordered set where userEmail = &#63;.
	 *
	 * @param userDeviceRegistrationId the primary key of the current flask user device registration
	 * @param userEmail the user email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flask user device registration
	 * @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a flask user device registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration[] findByuserEmail_PrevAndNext(
		long userDeviceRegistrationId, String userEmail,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskUserDeviceRegistrationException, SystemException {
		FlaskUserDeviceRegistration flaskUserDeviceRegistration = findByPrimaryKey(userDeviceRegistrationId);

		Session session = null;

		try {
			session = openSession();

			FlaskUserDeviceRegistration[] array = new FlaskUserDeviceRegistrationImpl[3];

			array[0] = getByuserEmail_PrevAndNext(session,
					flaskUserDeviceRegistration, userEmail, orderByComparator,
					true);

			array[1] = flaskUserDeviceRegistration;

			array[2] = getByuserEmail_PrevAndNext(session,
					flaskUserDeviceRegistration, userEmail, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FlaskUserDeviceRegistration getByuserEmail_PrevAndNext(
		Session session,
		FlaskUserDeviceRegistration flaskUserDeviceRegistration,
		String userEmail, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLASKUSERDEVICEREGISTRATION_WHERE);

		boolean bindUserEmail = false;

		if (userEmail == null) {
			query.append(_FINDER_COLUMN_USEREMAIL_USEREMAIL_1);
		}
		else if (userEmail.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USEREMAIL_USEREMAIL_3);
		}
		else {
			bindUserEmail = true;

			query.append(_FINDER_COLUMN_USEREMAIL_USEREMAIL_2);
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
			query.append(FlaskUserDeviceRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUserEmail) {
			qPos.add(userEmail);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flaskUserDeviceRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FlaskUserDeviceRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flask user device registrations where userEmail = &#63; from the database.
	 *
	 * @param userEmail the user email
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserEmail(String userEmail) throws SystemException {
		for (FlaskUserDeviceRegistration flaskUserDeviceRegistration : findByuserEmail(
				userEmail, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(flaskUserDeviceRegistration);
		}
	}

	/**
	 * Returns the number of flask user device registrations where userEmail = &#63;.
	 *
	 * @param userEmail the user email
	 * @return the number of matching flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserEmail(String userEmail) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USEREMAIL;

		Object[] finderArgs = new Object[] { userEmail };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FLASKUSERDEVICEREGISTRATION_WHERE);

			boolean bindUserEmail = false;

			if (userEmail == null) {
				query.append(_FINDER_COLUMN_USEREMAIL_USEREMAIL_1);
			}
			else if (userEmail.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USEREMAIL_USEREMAIL_3);
			}
			else {
				bindUserEmail = true;

				query.append(_FINDER_COLUMN_USEREMAIL_USEREMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUserEmail) {
					qPos.add(userEmail);
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

	private static final String _FINDER_COLUMN_USEREMAIL_USEREMAIL_1 = "flaskUserDeviceRegistration.userEmail IS NULL";
	private static final String _FINDER_COLUMN_USEREMAIL_USEREMAIL_2 = "flaskUserDeviceRegistration.userEmail = ?";
	private static final String _FINDER_COLUMN_USEREMAIL_USEREMAIL_3 = "(flaskUserDeviceRegistration.userEmail IS NULL OR flaskUserDeviceRegistration.userEmail = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEVICETOKEN =
		new FinderPath(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FlaskUserDeviceRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydeviceToken",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICETOKEN =
		new FinderPath(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FlaskUserDeviceRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydeviceToken",
			new String[] { String.class.getName() },
			FlaskUserDeviceRegistrationModelImpl.DEVICETOKEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEVICETOKEN = new FinderPath(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBydeviceToken", new String[] { String.class.getName() });

	/**
	 * Returns all the flask user device registrations where deviceToken = &#63;.
	 *
	 * @param deviceToken the device token
	 * @return the matching flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUserDeviceRegistration> findBydeviceToken(
		String deviceToken) throws SystemException {
		return findBydeviceToken(deviceToken, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flask user device registrations where deviceToken = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deviceToken the device token
	 * @param start the lower bound of the range of flask user device registrations
	 * @param end the upper bound of the range of flask user device registrations (not inclusive)
	 * @return the range of matching flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUserDeviceRegistration> findBydeviceToken(
		String deviceToken, int start, int end) throws SystemException {
		return findBydeviceToken(deviceToken, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask user device registrations where deviceToken = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param deviceToken the device token
	 * @param start the lower bound of the range of flask user device registrations
	 * @param end the upper bound of the range of flask user device registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUserDeviceRegistration> findBydeviceToken(
		String deviceToken, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICETOKEN;
			finderArgs = new Object[] { deviceToken };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEVICETOKEN;
			finderArgs = new Object[] { deviceToken, start, end, orderByComparator };
		}

		List<FlaskUserDeviceRegistration> list = (List<FlaskUserDeviceRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FlaskUserDeviceRegistration flaskUserDeviceRegistration : list) {
				if (!Validator.equals(deviceToken,
							flaskUserDeviceRegistration.getDeviceToken())) {
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

			query.append(_SQL_SELECT_FLASKUSERDEVICEREGISTRATION_WHERE);

			boolean bindDeviceToken = false;

			if (deviceToken == null) {
				query.append(_FINDER_COLUMN_DEVICETOKEN_DEVICETOKEN_1);
			}
			else if (deviceToken.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEVICETOKEN_DEVICETOKEN_3);
			}
			else {
				bindDeviceToken = true;

				query.append(_FINDER_COLUMN_DEVICETOKEN_DEVICETOKEN_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlaskUserDeviceRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDeviceToken) {
					qPos.add(deviceToken);
				}

				if (!pagination) {
					list = (List<FlaskUserDeviceRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskUserDeviceRegistration>(list);
				}
				else {
					list = (List<FlaskUserDeviceRegistration>)QueryUtil.list(q,
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
	 * Returns the first flask user device registration in the ordered set where deviceToken = &#63;.
	 *
	 * @param deviceToken the device token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask user device registration
	 * @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration findBydeviceToken_First(
		String deviceToken, OrderByComparator orderByComparator)
		throws NoSuchFlaskUserDeviceRegistrationException, SystemException {
		FlaskUserDeviceRegistration flaskUserDeviceRegistration = fetchBydeviceToken_First(deviceToken,
				orderByComparator);

		if (flaskUserDeviceRegistration != null) {
			return flaskUserDeviceRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deviceToken=");
		msg.append(deviceToken);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskUserDeviceRegistrationException(msg.toString());
	}

	/**
	 * Returns the first flask user device registration in the ordered set where deviceToken = &#63;.
	 *
	 * @param deviceToken the device token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration fetchBydeviceToken_First(
		String deviceToken, OrderByComparator orderByComparator)
		throws SystemException {
		List<FlaskUserDeviceRegistration> list = findBydeviceToken(deviceToken,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flask user device registration in the ordered set where deviceToken = &#63;.
	 *
	 * @param deviceToken the device token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask user device registration
	 * @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration findBydeviceToken_Last(
		String deviceToken, OrderByComparator orderByComparator)
		throws NoSuchFlaskUserDeviceRegistrationException, SystemException {
		FlaskUserDeviceRegistration flaskUserDeviceRegistration = fetchBydeviceToken_Last(deviceToken,
				orderByComparator);

		if (flaskUserDeviceRegistration != null) {
			return flaskUserDeviceRegistration;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("deviceToken=");
		msg.append(deviceToken);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskUserDeviceRegistrationException(msg.toString());
	}

	/**
	 * Returns the last flask user device registration in the ordered set where deviceToken = &#63;.
	 *
	 * @param deviceToken the device token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration fetchBydeviceToken_Last(
		String deviceToken, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBydeviceToken(deviceToken);

		if (count == 0) {
			return null;
		}

		List<FlaskUserDeviceRegistration> list = findBydeviceToken(deviceToken,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flask user device registrations before and after the current flask user device registration in the ordered set where deviceToken = &#63;.
	 *
	 * @param userDeviceRegistrationId the primary key of the current flask user device registration
	 * @param deviceToken the device token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flask user device registration
	 * @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a flask user device registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration[] findBydeviceToken_PrevAndNext(
		long userDeviceRegistrationId, String deviceToken,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskUserDeviceRegistrationException, SystemException {
		FlaskUserDeviceRegistration flaskUserDeviceRegistration = findByPrimaryKey(userDeviceRegistrationId);

		Session session = null;

		try {
			session = openSession();

			FlaskUserDeviceRegistration[] array = new FlaskUserDeviceRegistrationImpl[3];

			array[0] = getBydeviceToken_PrevAndNext(session,
					flaskUserDeviceRegistration, deviceToken,
					orderByComparator, true);

			array[1] = flaskUserDeviceRegistration;

			array[2] = getBydeviceToken_PrevAndNext(session,
					flaskUserDeviceRegistration, deviceToken,
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

	protected FlaskUserDeviceRegistration getBydeviceToken_PrevAndNext(
		Session session,
		FlaskUserDeviceRegistration flaskUserDeviceRegistration,
		String deviceToken, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLASKUSERDEVICEREGISTRATION_WHERE);

		boolean bindDeviceToken = false;

		if (deviceToken == null) {
			query.append(_FINDER_COLUMN_DEVICETOKEN_DEVICETOKEN_1);
		}
		else if (deviceToken.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DEVICETOKEN_DEVICETOKEN_3);
		}
		else {
			bindDeviceToken = true;

			query.append(_FINDER_COLUMN_DEVICETOKEN_DEVICETOKEN_2);
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
			query.append(FlaskUserDeviceRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDeviceToken) {
			qPos.add(deviceToken);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flaskUserDeviceRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FlaskUserDeviceRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flask user device registrations where deviceToken = &#63; from the database.
	 *
	 * @param deviceToken the device token
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBydeviceToken(String deviceToken)
		throws SystemException {
		for (FlaskUserDeviceRegistration flaskUserDeviceRegistration : findBydeviceToken(
				deviceToken, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(flaskUserDeviceRegistration);
		}
	}

	/**
	 * Returns the number of flask user device registrations where deviceToken = &#63;.
	 *
	 * @param deviceToken the device token
	 * @return the number of matching flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBydeviceToken(String deviceToken) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEVICETOKEN;

		Object[] finderArgs = new Object[] { deviceToken };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FLASKUSERDEVICEREGISTRATION_WHERE);

			boolean bindDeviceToken = false;

			if (deviceToken == null) {
				query.append(_FINDER_COLUMN_DEVICETOKEN_DEVICETOKEN_1);
			}
			else if (deviceToken.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEVICETOKEN_DEVICETOKEN_3);
			}
			else {
				bindDeviceToken = true;

				query.append(_FINDER_COLUMN_DEVICETOKEN_DEVICETOKEN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDeviceToken) {
					qPos.add(deviceToken);
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

	private static final String _FINDER_COLUMN_DEVICETOKEN_DEVICETOKEN_1 = "flaskUserDeviceRegistration.deviceToken IS NULL";
	private static final String _FINDER_COLUMN_DEVICETOKEN_DEVICETOKEN_2 = "flaskUserDeviceRegistration.deviceToken = ?";
	private static final String _FINDER_COLUMN_DEVICETOKEN_DEVICETOKEN_3 = "(flaskUserDeviceRegistration.deviceToken IS NULL OR flaskUserDeviceRegistration.deviceToken = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDDEVICETOKEN =
		new FinderPath(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FlaskUserDeviceRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdDeviceToken",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDDEVICETOKEN =
		new FinderPath(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationModelImpl.FINDER_CACHE_ENABLED,
			FlaskUserDeviceRegistrationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdDeviceToken",
			new String[] { Long.class.getName(), String.class.getName() },
			FlaskUserDeviceRegistrationModelImpl.USERID_COLUMN_BITMASK |
			FlaskUserDeviceRegistrationModelImpl.DEVICETOKEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDDEVICETOKEN = new FinderPath(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdDeviceToken",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the flask user device registrations where userId = &#63; and deviceToken = &#63;.
	 *
	 * @param userId the user ID
	 * @param deviceToken the device token
	 * @return the matching flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUserDeviceRegistration> findByUserIdDeviceToken(
		long userId, String deviceToken) throws SystemException {
		return findByUserIdDeviceToken(userId, deviceToken, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flask user device registrations where userId = &#63; and deviceToken = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param deviceToken the device token
	 * @param start the lower bound of the range of flask user device registrations
	 * @param end the upper bound of the range of flask user device registrations (not inclusive)
	 * @return the range of matching flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUserDeviceRegistration> findByUserIdDeviceToken(
		long userId, String deviceToken, int start, int end)
		throws SystemException {
		return findByUserIdDeviceToken(userId, deviceToken, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask user device registrations where userId = &#63; and deviceToken = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param deviceToken the device token
	 * @param start the lower bound of the range of flask user device registrations
	 * @param end the upper bound of the range of flask user device registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUserDeviceRegistration> findByUserIdDeviceToken(
		long userId, String deviceToken, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDDEVICETOKEN;
			finderArgs = new Object[] { userId, deviceToken };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDDEVICETOKEN;
			finderArgs = new Object[] {
					userId, deviceToken,
					
					start, end, orderByComparator
				};
		}

		List<FlaskUserDeviceRegistration> list = (List<FlaskUserDeviceRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FlaskUserDeviceRegistration flaskUserDeviceRegistration : list) {
				if ((userId != flaskUserDeviceRegistration.getUserId()) ||
						!Validator.equals(deviceToken,
							flaskUserDeviceRegistration.getDeviceToken())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_FLASKUSERDEVICEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USERIDDEVICETOKEN_USERID_2);

			boolean bindDeviceToken = false;

			if (deviceToken == null) {
				query.append(_FINDER_COLUMN_USERIDDEVICETOKEN_DEVICETOKEN_1);
			}
			else if (deviceToken.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDDEVICETOKEN_DEVICETOKEN_3);
			}
			else {
				bindDeviceToken = true;

				query.append(_FINDER_COLUMN_USERIDDEVICETOKEN_DEVICETOKEN_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlaskUserDeviceRegistrationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindDeviceToken) {
					qPos.add(deviceToken);
				}

				if (!pagination) {
					list = (List<FlaskUserDeviceRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskUserDeviceRegistration>(list);
				}
				else {
					list = (List<FlaskUserDeviceRegistration>)QueryUtil.list(q,
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
	 * Returns the first flask user device registration in the ordered set where userId = &#63; and deviceToken = &#63;.
	 *
	 * @param userId the user ID
	 * @param deviceToken the device token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask user device registration
	 * @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration findByUserIdDeviceToken_First(
		long userId, String deviceToken, OrderByComparator orderByComparator)
		throws NoSuchFlaskUserDeviceRegistrationException, SystemException {
		FlaskUserDeviceRegistration flaskUserDeviceRegistration = fetchByUserIdDeviceToken_First(userId,
				deviceToken, orderByComparator);

		if (flaskUserDeviceRegistration != null) {
			return flaskUserDeviceRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", deviceToken=");
		msg.append(deviceToken);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskUserDeviceRegistrationException(msg.toString());
	}

	/**
	 * Returns the first flask user device registration in the ordered set where userId = &#63; and deviceToken = &#63;.
	 *
	 * @param userId the user ID
	 * @param deviceToken the device token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration fetchByUserIdDeviceToken_First(
		long userId, String deviceToken, OrderByComparator orderByComparator)
		throws SystemException {
		List<FlaskUserDeviceRegistration> list = findByUserIdDeviceToken(userId,
				deviceToken, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flask user device registration in the ordered set where userId = &#63; and deviceToken = &#63;.
	 *
	 * @param userId the user ID
	 * @param deviceToken the device token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask user device registration
	 * @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration findByUserIdDeviceToken_Last(
		long userId, String deviceToken, OrderByComparator orderByComparator)
		throws NoSuchFlaskUserDeviceRegistrationException, SystemException {
		FlaskUserDeviceRegistration flaskUserDeviceRegistration = fetchByUserIdDeviceToken_Last(userId,
				deviceToken, orderByComparator);

		if (flaskUserDeviceRegistration != null) {
			return flaskUserDeviceRegistration;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", deviceToken=");
		msg.append(deviceToken);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskUserDeviceRegistrationException(msg.toString());
	}

	/**
	 * Returns the last flask user device registration in the ordered set where userId = &#63; and deviceToken = &#63;.
	 *
	 * @param userId the user ID
	 * @param deviceToken the device token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration fetchByUserIdDeviceToken_Last(
		long userId, String deviceToken, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIdDeviceToken(userId, deviceToken);

		if (count == 0) {
			return null;
		}

		List<FlaskUserDeviceRegistration> list = findByUserIdDeviceToken(userId,
				deviceToken, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flask user device registrations before and after the current flask user device registration in the ordered set where userId = &#63; and deviceToken = &#63;.
	 *
	 * @param userDeviceRegistrationId the primary key of the current flask user device registration
	 * @param userId the user ID
	 * @param deviceToken the device token
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flask user device registration
	 * @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a flask user device registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration[] findByUserIdDeviceToken_PrevAndNext(
		long userDeviceRegistrationId, long userId, String deviceToken,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskUserDeviceRegistrationException, SystemException {
		FlaskUserDeviceRegistration flaskUserDeviceRegistration = findByPrimaryKey(userDeviceRegistrationId);

		Session session = null;

		try {
			session = openSession();

			FlaskUserDeviceRegistration[] array = new FlaskUserDeviceRegistrationImpl[3];

			array[0] = getByUserIdDeviceToken_PrevAndNext(session,
					flaskUserDeviceRegistration, userId, deviceToken,
					orderByComparator, true);

			array[1] = flaskUserDeviceRegistration;

			array[2] = getByUserIdDeviceToken_PrevAndNext(session,
					flaskUserDeviceRegistration, userId, deviceToken,
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

	protected FlaskUserDeviceRegistration getByUserIdDeviceToken_PrevAndNext(
		Session session,
		FlaskUserDeviceRegistration flaskUserDeviceRegistration, long userId,
		String deviceToken, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLASKUSERDEVICEREGISTRATION_WHERE);

		query.append(_FINDER_COLUMN_USERIDDEVICETOKEN_USERID_2);

		boolean bindDeviceToken = false;

		if (deviceToken == null) {
			query.append(_FINDER_COLUMN_USERIDDEVICETOKEN_DEVICETOKEN_1);
		}
		else if (deviceToken.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_USERIDDEVICETOKEN_DEVICETOKEN_3);
		}
		else {
			bindDeviceToken = true;

			query.append(_FINDER_COLUMN_USERIDDEVICETOKEN_DEVICETOKEN_2);
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
			query.append(FlaskUserDeviceRegistrationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (bindDeviceToken) {
			qPos.add(deviceToken);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flaskUserDeviceRegistration);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FlaskUserDeviceRegistration> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flask user device registrations where userId = &#63; and deviceToken = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param deviceToken the device token
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdDeviceToken(long userId, String deviceToken)
		throws SystemException {
		for (FlaskUserDeviceRegistration flaskUserDeviceRegistration : findByUserIdDeviceToken(
				userId, deviceToken, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(flaskUserDeviceRegistration);
		}
	}

	/**
	 * Returns the number of flask user device registrations where userId = &#63; and deviceToken = &#63;.
	 *
	 * @param userId the user ID
	 * @param deviceToken the device token
	 * @return the number of matching flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdDeviceToken(long userId, String deviceToken)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDDEVICETOKEN;

		Object[] finderArgs = new Object[] { userId, deviceToken };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FLASKUSERDEVICEREGISTRATION_WHERE);

			query.append(_FINDER_COLUMN_USERIDDEVICETOKEN_USERID_2);

			boolean bindDeviceToken = false;

			if (deviceToken == null) {
				query.append(_FINDER_COLUMN_USERIDDEVICETOKEN_DEVICETOKEN_1);
			}
			else if (deviceToken.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USERIDDEVICETOKEN_DEVICETOKEN_3);
			}
			else {
				bindDeviceToken = true;

				query.append(_FINDER_COLUMN_USERIDDEVICETOKEN_DEVICETOKEN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (bindDeviceToken) {
					qPos.add(deviceToken);
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

	private static final String _FINDER_COLUMN_USERIDDEVICETOKEN_USERID_2 = "flaskUserDeviceRegistration.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDDEVICETOKEN_DEVICETOKEN_1 = "flaskUserDeviceRegistration.deviceToken IS NULL";
	private static final String _FINDER_COLUMN_USERIDDEVICETOKEN_DEVICETOKEN_2 = "flaskUserDeviceRegistration.deviceToken = ?";
	private static final String _FINDER_COLUMN_USERIDDEVICETOKEN_DEVICETOKEN_3 = "(flaskUserDeviceRegistration.deviceToken IS NULL OR flaskUserDeviceRegistration.deviceToken = '')";

	public FlaskUserDeviceRegistrationPersistenceImpl() {
		setModelClass(FlaskUserDeviceRegistration.class);
	}

	/**
	 * Caches the flask user device registration in the entity cache if it is enabled.
	 *
	 * @param flaskUserDeviceRegistration the flask user device registration
	 */
	@Override
	public void cacheResult(
		FlaskUserDeviceRegistration flaskUserDeviceRegistration) {
		EntityCacheUtil.putResult(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationImpl.class,
			flaskUserDeviceRegistration.getPrimaryKey(),
			flaskUserDeviceRegistration);

		flaskUserDeviceRegistration.resetOriginalValues();
	}

	/**
	 * Caches the flask user device registrations in the entity cache if it is enabled.
	 *
	 * @param flaskUserDeviceRegistrations the flask user device registrations
	 */
	@Override
	public void cacheResult(
		List<FlaskUserDeviceRegistration> flaskUserDeviceRegistrations) {
		for (FlaskUserDeviceRegistration flaskUserDeviceRegistration : flaskUserDeviceRegistrations) {
			if (EntityCacheUtil.getResult(
						FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						FlaskUserDeviceRegistrationImpl.class,
						flaskUserDeviceRegistration.getPrimaryKey()) == null) {
				cacheResult(flaskUserDeviceRegistration);
			}
			else {
				flaskUserDeviceRegistration.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all flask user device registrations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FlaskUserDeviceRegistrationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FlaskUserDeviceRegistrationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the flask user device registration.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		FlaskUserDeviceRegistration flaskUserDeviceRegistration) {
		EntityCacheUtil.removeResult(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationImpl.class,
			flaskUserDeviceRegistration.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<FlaskUserDeviceRegistration> flaskUserDeviceRegistrations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FlaskUserDeviceRegistration flaskUserDeviceRegistration : flaskUserDeviceRegistrations) {
			EntityCacheUtil.removeResult(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				FlaskUserDeviceRegistrationImpl.class,
				flaskUserDeviceRegistration.getPrimaryKey());
		}
	}

	/**
	 * Creates a new flask user device registration with the primary key. Does not add the flask user device registration to the database.
	 *
	 * @param userDeviceRegistrationId the primary key for the new flask user device registration
	 * @return the new flask user device registration
	 */
	@Override
	public FlaskUserDeviceRegistration create(long userDeviceRegistrationId) {
		FlaskUserDeviceRegistration flaskUserDeviceRegistration = new FlaskUserDeviceRegistrationImpl();

		flaskUserDeviceRegistration.setNew(true);
		flaskUserDeviceRegistration.setPrimaryKey(userDeviceRegistrationId);

		return flaskUserDeviceRegistration;
	}

	/**
	 * Removes the flask user device registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userDeviceRegistrationId the primary key of the flask user device registration
	 * @return the flask user device registration that was removed
	 * @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a flask user device registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration remove(long userDeviceRegistrationId)
		throws NoSuchFlaskUserDeviceRegistrationException, SystemException {
		return remove((Serializable)userDeviceRegistrationId);
	}

	/**
	 * Removes the flask user device registration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the flask user device registration
	 * @return the flask user device registration that was removed
	 * @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a flask user device registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration remove(Serializable primaryKey)
		throws NoSuchFlaskUserDeviceRegistrationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FlaskUserDeviceRegistration flaskUserDeviceRegistration = (FlaskUserDeviceRegistration)session.get(FlaskUserDeviceRegistrationImpl.class,
					primaryKey);

			if (flaskUserDeviceRegistration == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFlaskUserDeviceRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(flaskUserDeviceRegistration);
		}
		catch (NoSuchFlaskUserDeviceRegistrationException nsee) {
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
	protected FlaskUserDeviceRegistration removeImpl(
		FlaskUserDeviceRegistration flaskUserDeviceRegistration)
		throws SystemException {
		flaskUserDeviceRegistration = toUnwrappedModel(flaskUserDeviceRegistration);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(flaskUserDeviceRegistration)) {
				flaskUserDeviceRegistration = (FlaskUserDeviceRegistration)session.get(FlaskUserDeviceRegistrationImpl.class,
						flaskUserDeviceRegistration.getPrimaryKeyObj());
			}

			if (flaskUserDeviceRegistration != null) {
				session.delete(flaskUserDeviceRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (flaskUserDeviceRegistration != null) {
			clearCache(flaskUserDeviceRegistration);
		}

		return flaskUserDeviceRegistration;
	}

	@Override
	public FlaskUserDeviceRegistration updateImpl(
		com.liferay.contacts.model.FlaskUserDeviceRegistration flaskUserDeviceRegistration)
		throws SystemException {
		flaskUserDeviceRegistration = toUnwrappedModel(flaskUserDeviceRegistration);

		boolean isNew = flaskUserDeviceRegistration.isNew();

		FlaskUserDeviceRegistrationModelImpl flaskUserDeviceRegistrationModelImpl =
			(FlaskUserDeviceRegistrationModelImpl)flaskUserDeviceRegistration;

		Session session = null;

		try {
			session = openSession();

			if (flaskUserDeviceRegistration.isNew()) {
				session.save(flaskUserDeviceRegistration);

				flaskUserDeviceRegistration.setNew(false);
			}
			else {
				session.merge(flaskUserDeviceRegistration);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!FlaskUserDeviceRegistrationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((flaskUserDeviceRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flaskUserDeviceRegistrationModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						flaskUserDeviceRegistrationModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((flaskUserDeviceRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USEREMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flaskUserDeviceRegistrationModelImpl.getOriginalUserEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USEREMAIL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USEREMAIL,
					args);

				args = new Object[] {
						flaskUserDeviceRegistrationModelImpl.getUserEmail()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USEREMAIL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USEREMAIL,
					args);
			}

			if ((flaskUserDeviceRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICETOKEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flaskUserDeviceRegistrationModelImpl.getOriginalDeviceToken()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEVICETOKEN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICETOKEN,
					args);

				args = new Object[] {
						flaskUserDeviceRegistrationModelImpl.getDeviceToken()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEVICETOKEN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVICETOKEN,
					args);
			}

			if ((flaskUserDeviceRegistrationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDDEVICETOKEN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flaskUserDeviceRegistrationModelImpl.getOriginalUserId(),
						flaskUserDeviceRegistrationModelImpl.getOriginalDeviceToken()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDDEVICETOKEN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDDEVICETOKEN,
					args);

				args = new Object[] {
						flaskUserDeviceRegistrationModelImpl.getUserId(),
						flaskUserDeviceRegistrationModelImpl.getDeviceToken()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDDEVICETOKEN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDDEVICETOKEN,
					args);
			}
		}

		EntityCacheUtil.putResult(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
			FlaskUserDeviceRegistrationImpl.class,
			flaskUserDeviceRegistration.getPrimaryKey(),
			flaskUserDeviceRegistration);

		return flaskUserDeviceRegistration;
	}

	protected FlaskUserDeviceRegistration toUnwrappedModel(
		FlaskUserDeviceRegistration flaskUserDeviceRegistration) {
		if (flaskUserDeviceRegistration instanceof FlaskUserDeviceRegistrationImpl) {
			return flaskUserDeviceRegistration;
		}

		FlaskUserDeviceRegistrationImpl flaskUserDeviceRegistrationImpl = new FlaskUserDeviceRegistrationImpl();

		flaskUserDeviceRegistrationImpl.setNew(flaskUserDeviceRegistration.isNew());
		flaskUserDeviceRegistrationImpl.setPrimaryKey(flaskUserDeviceRegistration.getPrimaryKey());

		flaskUserDeviceRegistrationImpl.setUserDeviceRegistrationId(flaskUserDeviceRegistration.getUserDeviceRegistrationId());
		flaskUserDeviceRegistrationImpl.setUserId(flaskUserDeviceRegistration.getUserId());
		flaskUserDeviceRegistrationImpl.setUserEmail(flaskUserDeviceRegistration.getUserEmail());
		flaskUserDeviceRegistrationImpl.setDevicePlatform(flaskUserDeviceRegistration.getDevicePlatform());
		flaskUserDeviceRegistrationImpl.setDeviceDetails(flaskUserDeviceRegistration.getDeviceDetails());
		flaskUserDeviceRegistrationImpl.setDeviceToken(flaskUserDeviceRegistration.getDeviceToken());
		flaskUserDeviceRegistrationImpl.setRegistrationTime(flaskUserDeviceRegistration.getRegistrationTime());
		flaskUserDeviceRegistrationImpl.setActive(flaskUserDeviceRegistration.isActive());
		flaskUserDeviceRegistrationImpl.setLastNotificationTime(flaskUserDeviceRegistration.getLastNotificationTime());
		flaskUserDeviceRegistrationImpl.setLastNotificationMsg(flaskUserDeviceRegistration.getLastNotificationMsg());

		return flaskUserDeviceRegistrationImpl;
	}

	/**
	 * Returns the flask user device registration with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask user device registration
	 * @return the flask user device registration
	 * @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a flask user device registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFlaskUserDeviceRegistrationException, SystemException {
		FlaskUserDeviceRegistration flaskUserDeviceRegistration = fetchByPrimaryKey(primaryKey);

		if (flaskUserDeviceRegistration == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFlaskUserDeviceRegistrationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return flaskUserDeviceRegistration;
	}

	/**
	 * Returns the flask user device registration with the primary key or throws a {@link com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException} if it could not be found.
	 *
	 * @param userDeviceRegistrationId the primary key of the flask user device registration
	 * @return the flask user device registration
	 * @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a flask user device registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration findByPrimaryKey(
		long userDeviceRegistrationId)
		throws NoSuchFlaskUserDeviceRegistrationException, SystemException {
		return findByPrimaryKey((Serializable)userDeviceRegistrationId);
	}

	/**
	 * Returns the flask user device registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask user device registration
	 * @return the flask user device registration, or <code>null</code> if a flask user device registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		FlaskUserDeviceRegistration flaskUserDeviceRegistration = (FlaskUserDeviceRegistration)EntityCacheUtil.getResult(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
				FlaskUserDeviceRegistrationImpl.class, primaryKey);

		if (flaskUserDeviceRegistration == _nullFlaskUserDeviceRegistration) {
			return null;
		}

		if (flaskUserDeviceRegistration == null) {
			Session session = null;

			try {
				session = openSession();

				flaskUserDeviceRegistration = (FlaskUserDeviceRegistration)session.get(FlaskUserDeviceRegistrationImpl.class,
						primaryKey);

				if (flaskUserDeviceRegistration != null) {
					cacheResult(flaskUserDeviceRegistration);
				}
				else {
					EntityCacheUtil.putResult(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
						FlaskUserDeviceRegistrationImpl.class, primaryKey,
						_nullFlaskUserDeviceRegistration);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FlaskUserDeviceRegistrationModelImpl.ENTITY_CACHE_ENABLED,
					FlaskUserDeviceRegistrationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return flaskUserDeviceRegistration;
	}

	/**
	 * Returns the flask user device registration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userDeviceRegistrationId the primary key of the flask user device registration
	 * @return the flask user device registration, or <code>null</code> if a flask user device registration with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskUserDeviceRegistration fetchByPrimaryKey(
		long userDeviceRegistrationId) throws SystemException {
		return fetchByPrimaryKey((Serializable)userDeviceRegistrationId);
	}

	/**
	 * Returns all the flask user device registrations.
	 *
	 * @return the flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUserDeviceRegistration> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flask user device registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask user device registrations
	 * @param end the upper bound of the range of flask user device registrations (not inclusive)
	 * @return the range of flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUserDeviceRegistration> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask user device registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask user device registrations
	 * @param end the upper bound of the range of flask user device registrations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of flask user device registrations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskUserDeviceRegistration> findAll(int start, int end,
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

		List<FlaskUserDeviceRegistration> list = (List<FlaskUserDeviceRegistration>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FLASKUSERDEVICEREGISTRATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FLASKUSERDEVICEREGISTRATION;

				if (pagination) {
					sql = sql.concat(FlaskUserDeviceRegistrationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FlaskUserDeviceRegistration>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskUserDeviceRegistration>(list);
				}
				else {
					list = (List<FlaskUserDeviceRegistration>)QueryUtil.list(q,
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
	 * Removes all the flask user device registrations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FlaskUserDeviceRegistration flaskUserDeviceRegistration : findAll()) {
			remove(flaskUserDeviceRegistration);
		}
	}

	/**
	 * Returns the number of flask user device registrations.
	 *
	 * @return the number of flask user device registrations
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

				Query q = session.createQuery(_SQL_COUNT_FLASKUSERDEVICEREGISTRATION);

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
	 * Initializes the flask user device registration persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.contacts.model.FlaskUserDeviceRegistration")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FlaskUserDeviceRegistration>> listenersList = new ArrayList<ModelListener<FlaskUserDeviceRegistration>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FlaskUserDeviceRegistration>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FlaskUserDeviceRegistrationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FLASKUSERDEVICEREGISTRATION = "SELECT flaskUserDeviceRegistration FROM FlaskUserDeviceRegistration flaskUserDeviceRegistration";
	private static final String _SQL_SELECT_FLASKUSERDEVICEREGISTRATION_WHERE = "SELECT flaskUserDeviceRegistration FROM FlaskUserDeviceRegistration flaskUserDeviceRegistration WHERE ";
	private static final String _SQL_COUNT_FLASKUSERDEVICEREGISTRATION = "SELECT COUNT(flaskUserDeviceRegistration) FROM FlaskUserDeviceRegistration flaskUserDeviceRegistration";
	private static final String _SQL_COUNT_FLASKUSERDEVICEREGISTRATION_WHERE = "SELECT COUNT(flaskUserDeviceRegistration) FROM FlaskUserDeviceRegistration flaskUserDeviceRegistration WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "flaskUserDeviceRegistration.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FlaskUserDeviceRegistration exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FlaskUserDeviceRegistration exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FlaskUserDeviceRegistrationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"active"
			});
	private static FlaskUserDeviceRegistration _nullFlaskUserDeviceRegistration = new FlaskUserDeviceRegistrationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FlaskUserDeviceRegistration> toCacheModel() {
				return _nullFlaskUserDeviceRegistrationCacheModel;
			}
		};

	private static CacheModel<FlaskUserDeviceRegistration> _nullFlaskUserDeviceRegistrationCacheModel =
		new CacheModel<FlaskUserDeviceRegistration>() {
			@Override
			public FlaskUserDeviceRegistration toEntityModel() {
				return _nullFlaskUserDeviceRegistration;
			}
		};
}