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

import com.rumbasolutions.flask.NoSuchAdCustomerException;
import com.rumbasolutions.flask.model.AdCustomer;
import com.rumbasolutions.flask.model.impl.AdCustomerImpl;
import com.rumbasolutions.flask.model.impl.AdCustomerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ad customer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdCustomerPersistence
 * @see AdCustomerUtil
 * @generated
 */
public class AdCustomerPersistenceImpl extends BasePersistenceImpl<AdCustomer>
	implements AdCustomerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AdCustomerUtil} to access the ad customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdCustomerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AdCustomerModelImpl.ENTITY_CACHE_ENABLED,
			AdCustomerModelImpl.FINDER_CACHE_ENABLED, AdCustomerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AdCustomerModelImpl.ENTITY_CACHE_ENABLED,
			AdCustomerModelImpl.FINDER_CACHE_ENABLED, AdCustomerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AdCustomerModelImpl.ENTITY_CACHE_ENABLED,
			AdCustomerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CUSTOMERNAME =
		new FinderPath(AdCustomerModelImpl.ENTITY_CACHE_ENABLED,
			AdCustomerModelImpl.FINDER_CACHE_ENABLED, AdCustomerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycustomerName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERNAME =
		new FinderPath(AdCustomerModelImpl.ENTITY_CACHE_ENABLED,
			AdCustomerModelImpl.FINDER_CACHE_ENABLED, AdCustomerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycustomerName",
			new String[] { String.class.getName() },
			AdCustomerModelImpl.CUSTOMERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CUSTOMERNAME = new FinderPath(AdCustomerModelImpl.ENTITY_CACHE_ENABLED,
			AdCustomerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycustomerName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the ad customers where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @return the matching ad customers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCustomer> findBycustomerName(String customerName)
		throws SystemException {
		return findBycustomerName(customerName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad customers where customerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param customerName the customer name
	 * @param start the lower bound of the range of ad customers
	 * @param end the upper bound of the range of ad customers (not inclusive)
	 * @return the range of matching ad customers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCustomer> findBycustomerName(String customerName, int start,
		int end) throws SystemException {
		return findBycustomerName(customerName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad customers where customerName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param customerName the customer name
	 * @param start the lower bound of the range of ad customers
	 * @param end the upper bound of the range of ad customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ad customers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCustomer> findBycustomerName(String customerName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERNAME;
			finderArgs = new Object[] { customerName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CUSTOMERNAME;
			finderArgs = new Object[] {
					customerName,
					
					start, end, orderByComparator
				};
		}

		List<AdCustomer> list = (List<AdCustomer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdCustomer adCustomer : list) {
				if (!Validator.equals(customerName, adCustomer.getCustomerName())) {
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

			query.append(_SQL_SELECT_ADCUSTOMER_WHERE);

			boolean bindCustomerName = false;

			if (customerName == null) {
				query.append(_FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_1);
			}
			else if (customerName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_3);
			}
			else {
				bindCustomerName = true;

				query.append(_FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdCustomerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCustomerName) {
					qPos.add(customerName);
				}

				if (!pagination) {
					list = (List<AdCustomer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdCustomer>(list);
				}
				else {
					list = (List<AdCustomer>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ad customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad customer
	 * @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a matching ad customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCustomer findBycustomerName_First(String customerName,
		OrderByComparator orderByComparator)
		throws NoSuchAdCustomerException, SystemException {
		AdCustomer adCustomer = fetchBycustomerName_First(customerName,
				orderByComparator);

		if (adCustomer != null) {
			return adCustomer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("customerName=");
		msg.append(customerName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdCustomerException(msg.toString());
	}

	/**
	 * Returns the first ad customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad customer, or <code>null</code> if a matching ad customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCustomer fetchBycustomerName_First(String customerName,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdCustomer> list = findBycustomerName(customerName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ad customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad customer
	 * @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a matching ad customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCustomer findBycustomerName_Last(String customerName,
		OrderByComparator orderByComparator)
		throws NoSuchAdCustomerException, SystemException {
		AdCustomer adCustomer = fetchBycustomerName_Last(customerName,
				orderByComparator);

		if (adCustomer != null) {
			return adCustomer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("customerName=");
		msg.append(customerName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdCustomerException(msg.toString());
	}

	/**
	 * Returns the last ad customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad customer, or <code>null</code> if a matching ad customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCustomer fetchBycustomerName_Last(String customerName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBycustomerName(customerName);

		if (count == 0) {
			return null;
		}

		List<AdCustomer> list = findBycustomerName(customerName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ad customers before and after the current ad customer in the ordered set where customerName = &#63;.
	 *
	 * @param customerId the primary key of the current ad customer
	 * @param customerName the customer name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ad customer
	 * @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a ad customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCustomer[] findBycustomerName_PrevAndNext(long customerId,
		String customerName, OrderByComparator orderByComparator)
		throws NoSuchAdCustomerException, SystemException {
		AdCustomer adCustomer = findByPrimaryKey(customerId);

		Session session = null;

		try {
			session = openSession();

			AdCustomer[] array = new AdCustomerImpl[3];

			array[0] = getBycustomerName_PrevAndNext(session, adCustomer,
					customerName, orderByComparator, true);

			array[1] = adCustomer;

			array[2] = getBycustomerName_PrevAndNext(session, adCustomer,
					customerName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdCustomer getBycustomerName_PrevAndNext(Session session,
		AdCustomer adCustomer, String customerName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADCUSTOMER_WHERE);

		boolean bindCustomerName = false;

		if (customerName == null) {
			query.append(_FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_1);
		}
		else if (customerName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_3);
		}
		else {
			bindCustomerName = true;

			query.append(_FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_2);
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
			query.append(AdCustomerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCustomerName) {
			qPos.add(customerName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adCustomer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdCustomer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ad customers where customerName = &#63; from the database.
	 *
	 * @param customerName the customer name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycustomerName(String customerName)
		throws SystemException {
		for (AdCustomer adCustomer : findBycustomerName(customerName,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(adCustomer);
		}
	}

	/**
	 * Returns the number of ad customers where customerName = &#63;.
	 *
	 * @param customerName the customer name
	 * @return the number of matching ad customers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycustomerName(String customerName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CUSTOMERNAME;

		Object[] finderArgs = new Object[] { customerName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADCUSTOMER_WHERE);

			boolean bindCustomerName = false;

			if (customerName == null) {
				query.append(_FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_1);
			}
			else if (customerName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_3);
			}
			else {
				bindCustomerName = true;

				query.append(_FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCustomerName) {
					qPos.add(customerName);
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

	private static final String _FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_1 = "adCustomer.customerName IS NULL";
	private static final String _FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_2 = "adCustomer.customerName = ?";
	private static final String _FINDER_COLUMN_CUSTOMERNAME_CUSTOMERNAME_3 = "(adCustomer.customerName IS NULL OR adCustomer.customerName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTPERSONNAME =
		new FinderPath(AdCustomerModelImpl.ENTITY_CACHE_ENABLED,
			AdCustomerModelImpl.FINDER_CACHE_ENABLED, AdCustomerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycontactPersonName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTPERSONNAME =
		new FinderPath(AdCustomerModelImpl.ENTITY_CACHE_ENABLED,
			AdCustomerModelImpl.FINDER_CACHE_ENABLED, AdCustomerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBycontactPersonName", new String[] { String.class.getName() },
			AdCustomerModelImpl.CONTACTPERSONNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTPERSONNAME = new FinderPath(AdCustomerModelImpl.ENTITY_CACHE_ENABLED,
			AdCustomerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycontactPersonName", new String[] { String.class.getName() });

	/**
	 * Returns all the ad customers where contactPersonName = &#63;.
	 *
	 * @param contactPersonName the contact person name
	 * @return the matching ad customers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCustomer> findBycontactPersonName(String contactPersonName)
		throws SystemException {
		return findBycontactPersonName(contactPersonName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad customers where contactPersonName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactPersonName the contact person name
	 * @param start the lower bound of the range of ad customers
	 * @param end the upper bound of the range of ad customers (not inclusive)
	 * @return the range of matching ad customers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCustomer> findBycontactPersonName(String contactPersonName,
		int start, int end) throws SystemException {
		return findBycontactPersonName(contactPersonName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad customers where contactPersonName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contactPersonName the contact person name
	 * @param start the lower bound of the range of ad customers
	 * @param end the upper bound of the range of ad customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ad customers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCustomer> findBycontactPersonName(String contactPersonName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTPERSONNAME;
			finderArgs = new Object[] { contactPersonName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTPERSONNAME;
			finderArgs = new Object[] {
					contactPersonName,
					
					start, end, orderByComparator
				};
		}

		List<AdCustomer> list = (List<AdCustomer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdCustomer adCustomer : list) {
				if (!Validator.equals(contactPersonName,
							adCustomer.getContactPersonName())) {
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

			query.append(_SQL_SELECT_ADCUSTOMER_WHERE);

			boolean bindContactPersonName = false;

			if (contactPersonName == null) {
				query.append(_FINDER_COLUMN_CONTACTPERSONNAME_CONTACTPERSONNAME_1);
			}
			else if (contactPersonName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTACTPERSONNAME_CONTACTPERSONNAME_3);
			}
			else {
				bindContactPersonName = true;

				query.append(_FINDER_COLUMN_CONTACTPERSONNAME_CONTACTPERSONNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdCustomerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindContactPersonName) {
					qPos.add(contactPersonName);
				}

				if (!pagination) {
					list = (List<AdCustomer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdCustomer>(list);
				}
				else {
					list = (List<AdCustomer>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ad customer in the ordered set where contactPersonName = &#63;.
	 *
	 * @param contactPersonName the contact person name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad customer
	 * @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a matching ad customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCustomer findBycontactPersonName_First(String contactPersonName,
		OrderByComparator orderByComparator)
		throws NoSuchAdCustomerException, SystemException {
		AdCustomer adCustomer = fetchBycontactPersonName_First(contactPersonName,
				orderByComparator);

		if (adCustomer != null) {
			return adCustomer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactPersonName=");
		msg.append(contactPersonName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdCustomerException(msg.toString());
	}

	/**
	 * Returns the first ad customer in the ordered set where contactPersonName = &#63;.
	 *
	 * @param contactPersonName the contact person name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ad customer, or <code>null</code> if a matching ad customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCustomer fetchBycontactPersonName_First(String contactPersonName,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdCustomer> list = findBycontactPersonName(contactPersonName, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ad customer in the ordered set where contactPersonName = &#63;.
	 *
	 * @param contactPersonName the contact person name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad customer
	 * @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a matching ad customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCustomer findBycontactPersonName_Last(String contactPersonName,
		OrderByComparator orderByComparator)
		throws NoSuchAdCustomerException, SystemException {
		AdCustomer adCustomer = fetchBycontactPersonName_Last(contactPersonName,
				orderByComparator);

		if (adCustomer != null) {
			return adCustomer;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contactPersonName=");
		msg.append(contactPersonName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdCustomerException(msg.toString());
	}

	/**
	 * Returns the last ad customer in the ordered set where contactPersonName = &#63;.
	 *
	 * @param contactPersonName the contact person name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ad customer, or <code>null</code> if a matching ad customer could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCustomer fetchBycontactPersonName_Last(String contactPersonName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBycontactPersonName(contactPersonName);

		if (count == 0) {
			return null;
		}

		List<AdCustomer> list = findBycontactPersonName(contactPersonName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ad customers before and after the current ad customer in the ordered set where contactPersonName = &#63;.
	 *
	 * @param customerId the primary key of the current ad customer
	 * @param contactPersonName the contact person name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ad customer
	 * @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a ad customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCustomer[] findBycontactPersonName_PrevAndNext(long customerId,
		String contactPersonName, OrderByComparator orderByComparator)
		throws NoSuchAdCustomerException, SystemException {
		AdCustomer adCustomer = findByPrimaryKey(customerId);

		Session session = null;

		try {
			session = openSession();

			AdCustomer[] array = new AdCustomerImpl[3];

			array[0] = getBycontactPersonName_PrevAndNext(session, adCustomer,
					contactPersonName, orderByComparator, true);

			array[1] = adCustomer;

			array[2] = getBycontactPersonName_PrevAndNext(session, adCustomer,
					contactPersonName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdCustomer getBycontactPersonName_PrevAndNext(Session session,
		AdCustomer adCustomer, String contactPersonName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADCUSTOMER_WHERE);

		boolean bindContactPersonName = false;

		if (contactPersonName == null) {
			query.append(_FINDER_COLUMN_CONTACTPERSONNAME_CONTACTPERSONNAME_1);
		}
		else if (contactPersonName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CONTACTPERSONNAME_CONTACTPERSONNAME_3);
		}
		else {
			bindContactPersonName = true;

			query.append(_FINDER_COLUMN_CONTACTPERSONNAME_CONTACTPERSONNAME_2);
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
			query.append(AdCustomerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindContactPersonName) {
			qPos.add(contactPersonName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adCustomer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdCustomer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ad customers where contactPersonName = &#63; from the database.
	 *
	 * @param contactPersonName the contact person name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycontactPersonName(String contactPersonName)
		throws SystemException {
		for (AdCustomer adCustomer : findBycontactPersonName(
				contactPersonName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(adCustomer);
		}
	}

	/**
	 * Returns the number of ad customers where contactPersonName = &#63;.
	 *
	 * @param contactPersonName the contact person name
	 * @return the number of matching ad customers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycontactPersonName(String contactPersonName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACTPERSONNAME;

		Object[] finderArgs = new Object[] { contactPersonName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADCUSTOMER_WHERE);

			boolean bindContactPersonName = false;

			if (contactPersonName == null) {
				query.append(_FINDER_COLUMN_CONTACTPERSONNAME_CONTACTPERSONNAME_1);
			}
			else if (contactPersonName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTACTPERSONNAME_CONTACTPERSONNAME_3);
			}
			else {
				bindContactPersonName = true;

				query.append(_FINDER_COLUMN_CONTACTPERSONNAME_CONTACTPERSONNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindContactPersonName) {
					qPos.add(contactPersonName);
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

	private static final String _FINDER_COLUMN_CONTACTPERSONNAME_CONTACTPERSONNAME_1 =
		"adCustomer.contactPersonName IS NULL";
	private static final String _FINDER_COLUMN_CONTACTPERSONNAME_CONTACTPERSONNAME_2 =
		"adCustomer.contactPersonName = ?";
	private static final String _FINDER_COLUMN_CONTACTPERSONNAME_CONTACTPERSONNAME_3 =
		"(adCustomer.contactPersonName IS NULL OR adCustomer.contactPersonName = '')";

	public AdCustomerPersistenceImpl() {
		setModelClass(AdCustomer.class);
	}

	/**
	 * Caches the ad customer in the entity cache if it is enabled.
	 *
	 * @param adCustomer the ad customer
	 */
	@Override
	public void cacheResult(AdCustomer adCustomer) {
		EntityCacheUtil.putResult(AdCustomerModelImpl.ENTITY_CACHE_ENABLED,
			AdCustomerImpl.class, adCustomer.getPrimaryKey(), adCustomer);

		adCustomer.resetOriginalValues();
	}

	/**
	 * Caches the ad customers in the entity cache if it is enabled.
	 *
	 * @param adCustomers the ad customers
	 */
	@Override
	public void cacheResult(List<AdCustomer> adCustomers) {
		for (AdCustomer adCustomer : adCustomers) {
			if (EntityCacheUtil.getResult(
						AdCustomerModelImpl.ENTITY_CACHE_ENABLED,
						AdCustomerImpl.class, adCustomer.getPrimaryKey()) == null) {
				cacheResult(adCustomer);
			}
			else {
				adCustomer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ad customers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AdCustomerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AdCustomerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ad customer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdCustomer adCustomer) {
		EntityCacheUtil.removeResult(AdCustomerModelImpl.ENTITY_CACHE_ENABLED,
			AdCustomerImpl.class, adCustomer.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AdCustomer> adCustomers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AdCustomer adCustomer : adCustomers) {
			EntityCacheUtil.removeResult(AdCustomerModelImpl.ENTITY_CACHE_ENABLED,
				AdCustomerImpl.class, adCustomer.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ad customer with the primary key. Does not add the ad customer to the database.
	 *
	 * @param customerId the primary key for the new ad customer
	 * @return the new ad customer
	 */
	@Override
	public AdCustomer create(long customerId) {
		AdCustomer adCustomer = new AdCustomerImpl();

		adCustomer.setNew(true);
		adCustomer.setPrimaryKey(customerId);

		return adCustomer;
	}

	/**
	 * Removes the ad customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customerId the primary key of the ad customer
	 * @return the ad customer that was removed
	 * @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a ad customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCustomer remove(long customerId)
		throws NoSuchAdCustomerException, SystemException {
		return remove((Serializable)customerId);
	}

	/**
	 * Removes the ad customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ad customer
	 * @return the ad customer that was removed
	 * @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a ad customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCustomer remove(Serializable primaryKey)
		throws NoSuchAdCustomerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AdCustomer adCustomer = (AdCustomer)session.get(AdCustomerImpl.class,
					primaryKey);

			if (adCustomer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdCustomerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(adCustomer);
		}
		catch (NoSuchAdCustomerException nsee) {
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
	protected AdCustomer removeImpl(AdCustomer adCustomer)
		throws SystemException {
		adCustomer = toUnwrappedModel(adCustomer);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(adCustomer)) {
				adCustomer = (AdCustomer)session.get(AdCustomerImpl.class,
						adCustomer.getPrimaryKeyObj());
			}

			if (adCustomer != null) {
				session.delete(adCustomer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (adCustomer != null) {
			clearCache(adCustomer);
		}

		return adCustomer;
	}

	@Override
	public AdCustomer updateImpl(
		com.rumbasolutions.flask.model.AdCustomer adCustomer)
		throws SystemException {
		adCustomer = toUnwrappedModel(adCustomer);

		boolean isNew = adCustomer.isNew();

		AdCustomerModelImpl adCustomerModelImpl = (AdCustomerModelImpl)adCustomer;

		Session session = null;

		try {
			session = openSession();

			if (adCustomer.isNew()) {
				session.save(adCustomer);

				adCustomer.setNew(false);
			}
			else {
				session.merge(adCustomer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AdCustomerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((adCustomerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adCustomerModelImpl.getOriginalCustomerName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CUSTOMERNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERNAME,
					args);

				args = new Object[] { adCustomerModelImpl.getCustomerName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CUSTOMERNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CUSTOMERNAME,
					args);
			}

			if ((adCustomerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTPERSONNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adCustomerModelImpl.getOriginalContactPersonName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTPERSONNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTPERSONNAME,
					args);

				args = new Object[] { adCustomerModelImpl.getContactPersonName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTPERSONNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTPERSONNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(AdCustomerModelImpl.ENTITY_CACHE_ENABLED,
			AdCustomerImpl.class, adCustomer.getPrimaryKey(), adCustomer);

		return adCustomer;
	}

	protected AdCustomer toUnwrappedModel(AdCustomer adCustomer) {
		if (adCustomer instanceof AdCustomerImpl) {
			return adCustomer;
		}

		AdCustomerImpl adCustomerImpl = new AdCustomerImpl();

		adCustomerImpl.setNew(adCustomer.isNew());
		adCustomerImpl.setPrimaryKey(adCustomer.getPrimaryKey());

		adCustomerImpl.setCustomerId(adCustomer.getCustomerId());
		adCustomerImpl.setUserId(adCustomer.getUserId());
		adCustomerImpl.setCreatedDate(adCustomer.getCreatedDate());
		adCustomerImpl.setModifiedDate(adCustomer.getModifiedDate());
		adCustomerImpl.setCustomerName(adCustomer.getCustomerName());
		adCustomerImpl.setBusinessType(adCustomer.getBusinessType());
		adCustomerImpl.setAddrLine1(adCustomer.getAddrLine1());
		adCustomerImpl.setAddrLine2(adCustomer.getAddrLine2());
		adCustomerImpl.setCity(adCustomer.getCity());
		adCustomerImpl.setZipCode(adCustomer.getZipCode());
		adCustomerImpl.setStateId(adCustomer.getStateId());
		adCustomerImpl.setCountryId(adCustomer.getCountryId());
		adCustomerImpl.setEmail(adCustomer.getEmail());
		adCustomerImpl.setWebsiteURL(adCustomer.getWebsiteURL());
		adCustomerImpl.setBusinessPhoneNumber(adCustomer.getBusinessPhoneNumber());
		adCustomerImpl.setContactPersonName(adCustomer.getContactPersonName());
		adCustomerImpl.setContactPersonNumber(adCustomer.getContactPersonNumber());

		return adCustomerImpl;
	}

	/**
	 * Returns the ad customer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ad customer
	 * @return the ad customer
	 * @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a ad customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCustomer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAdCustomerException, SystemException {
		AdCustomer adCustomer = fetchByPrimaryKey(primaryKey);

		if (adCustomer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAdCustomerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return adCustomer;
	}

	/**
	 * Returns the ad customer with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchAdCustomerException} if it could not be found.
	 *
	 * @param customerId the primary key of the ad customer
	 * @return the ad customer
	 * @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a ad customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCustomer findByPrimaryKey(long customerId)
		throws NoSuchAdCustomerException, SystemException {
		return findByPrimaryKey((Serializable)customerId);
	}

	/**
	 * Returns the ad customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ad customer
	 * @return the ad customer, or <code>null</code> if a ad customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCustomer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AdCustomer adCustomer = (AdCustomer)EntityCacheUtil.getResult(AdCustomerModelImpl.ENTITY_CACHE_ENABLED,
				AdCustomerImpl.class, primaryKey);

		if (adCustomer == _nullAdCustomer) {
			return null;
		}

		if (adCustomer == null) {
			Session session = null;

			try {
				session = openSession();

				adCustomer = (AdCustomer)session.get(AdCustomerImpl.class,
						primaryKey);

				if (adCustomer != null) {
					cacheResult(adCustomer);
				}
				else {
					EntityCacheUtil.putResult(AdCustomerModelImpl.ENTITY_CACHE_ENABLED,
						AdCustomerImpl.class, primaryKey, _nullAdCustomer);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AdCustomerModelImpl.ENTITY_CACHE_ENABLED,
					AdCustomerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return adCustomer;
	}

	/**
	 * Returns the ad customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customerId the primary key of the ad customer
	 * @return the ad customer, or <code>null</code> if a ad customer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdCustomer fetchByPrimaryKey(long customerId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)customerId);
	}

	/**
	 * Returns all the ad customers.
	 *
	 * @return the ad customers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCustomer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ad customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ad customers
	 * @param end the upper bound of the range of ad customers (not inclusive)
	 * @return the range of ad customers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCustomer> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ad customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ad customers
	 * @param end the upper bound of the range of ad customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ad customers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdCustomer> findAll(int start, int end,
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

		List<AdCustomer> list = (List<AdCustomer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADCUSTOMER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADCUSTOMER;

				if (pagination) {
					sql = sql.concat(AdCustomerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AdCustomer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdCustomer>(list);
				}
				else {
					list = (List<AdCustomer>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ad customers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AdCustomer adCustomer : findAll()) {
			remove(adCustomer);
		}
	}

	/**
	 * Returns the number of ad customers.
	 *
	 * @return the number of ad customers
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

				Query q = session.createQuery(_SQL_COUNT_ADCUSTOMER);

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
	 * Initializes the ad customer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.AdCustomer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AdCustomer>> listenersList = new ArrayList<ModelListener<AdCustomer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AdCustomer>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AdCustomerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADCUSTOMER = "SELECT adCustomer FROM AdCustomer adCustomer";
	private static final String _SQL_SELECT_ADCUSTOMER_WHERE = "SELECT adCustomer FROM AdCustomer adCustomer WHERE ";
	private static final String _SQL_COUNT_ADCUSTOMER = "SELECT COUNT(adCustomer) FROM AdCustomer adCustomer";
	private static final String _SQL_COUNT_ADCUSTOMER_WHERE = "SELECT COUNT(adCustomer) FROM AdCustomer adCustomer WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "adCustomer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdCustomer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AdCustomer exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AdCustomerPersistenceImpl.class);
	private static AdCustomer _nullAdCustomer = new AdCustomerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AdCustomer> toCacheModel() {
				return _nullAdCustomerCacheModel;
			}
		};

	private static CacheModel<AdCustomer> _nullAdCustomerCacheModel = new CacheModel<AdCustomer>() {
			@Override
			public AdCustomer toEntityModel() {
				return _nullAdCustomer;
			}
		};
}