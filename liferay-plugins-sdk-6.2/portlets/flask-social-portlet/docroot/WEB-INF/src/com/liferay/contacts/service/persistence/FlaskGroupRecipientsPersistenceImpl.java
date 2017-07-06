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

import com.liferay.contacts.NoSuchFlaskGroupRecipientsException;
import com.liferay.contacts.model.FlaskGroupRecipients;
import com.liferay.contacts.model.impl.FlaskGroupRecipientsImpl;
import com.liferay.contacts.model.impl.FlaskGroupRecipientsModelImpl;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the flask group recipients service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupRecipientsPersistence
 * @see FlaskGroupRecipientsUtil
 * @generated
 */
public class FlaskGroupRecipientsPersistenceImpl extends BasePersistenceImpl<FlaskGroupRecipients>
	implements FlaskGroupRecipientsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FlaskGroupRecipientsUtil} to access the flask group recipients persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FlaskGroupRecipientsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FlaskGroupRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskGroupRecipientsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FlaskGroupRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskGroupRecipientsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FlaskGroupRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupRecipientsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(FlaskGroupRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskGroupRecipientsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(FlaskGroupRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskGroupRecipientsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			FlaskGroupRecipientsModelImpl.GROUPID_COLUMN_BITMASK |
			FlaskGroupRecipientsModelImpl.RECEIVEDDATETIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(FlaskGroupRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupRecipientsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the flask group recipientses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching flask group recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupRecipients> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flask group recipientses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of flask group recipientses
	 * @param end the upper bound of the range of flask group recipientses (not inclusive)
	 * @return the range of matching flask group recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupRecipients> findByGroupId(long groupId, int start,
		int end) throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask group recipientses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of flask group recipientses
	 * @param end the upper bound of the range of flask group recipientses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flask group recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupRecipients> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<FlaskGroupRecipients> list = (List<FlaskGroupRecipients>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FlaskGroupRecipients flaskGroupRecipients : list) {
				if ((groupId != flaskGroupRecipients.getGroupId())) {
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

			query.append(_SQL_SELECT_FLASKGROUPRECIPIENTS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlaskGroupRecipientsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<FlaskGroupRecipients>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskGroupRecipients>(list);
				}
				else {
					list = (List<FlaskGroupRecipients>)QueryUtil.list(q,
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
	 * Returns the first flask group recipients in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask group recipients
	 * @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a matching flask group recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupRecipients findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskGroupRecipientsException, SystemException {
		FlaskGroupRecipients flaskGroupRecipients = fetchByGroupId_First(groupId,
				orderByComparator);

		if (flaskGroupRecipients != null) {
			return flaskGroupRecipients;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskGroupRecipientsException(msg.toString());
	}

	/**
	 * Returns the first flask group recipients in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask group recipients, or <code>null</code> if a matching flask group recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupRecipients fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FlaskGroupRecipients> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flask group recipients in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask group recipients
	 * @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a matching flask group recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupRecipients findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskGroupRecipientsException, SystemException {
		FlaskGroupRecipients flaskGroupRecipients = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (flaskGroupRecipients != null) {
			return flaskGroupRecipients;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskGroupRecipientsException(msg.toString());
	}

	/**
	 * Returns the last flask group recipients in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask group recipients, or <code>null</code> if a matching flask group recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupRecipients fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<FlaskGroupRecipients> list = findByGroupId(groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flask group recipientses before and after the current flask group recipients in the ordered set where groupId = &#63;.
	 *
	 * @param groupRecipientId the primary key of the current flask group recipients
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flask group recipients
	 * @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a flask group recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupRecipients[] findByGroupId_PrevAndNext(
		long groupRecipientId, long groupId, OrderByComparator orderByComparator)
		throws NoSuchFlaskGroupRecipientsException, SystemException {
		FlaskGroupRecipients flaskGroupRecipients = findByPrimaryKey(groupRecipientId);

		Session session = null;

		try {
			session = openSession();

			FlaskGroupRecipients[] array = new FlaskGroupRecipientsImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, flaskGroupRecipients,
					groupId, orderByComparator, true);

			array[1] = flaskGroupRecipients;

			array[2] = getByGroupId_PrevAndNext(session, flaskGroupRecipients,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FlaskGroupRecipients getByGroupId_PrevAndNext(Session session,
		FlaskGroupRecipients flaskGroupRecipients, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLASKGROUPRECIPIENTS_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(FlaskGroupRecipientsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flaskGroupRecipients);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FlaskGroupRecipients> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flask group recipientses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (FlaskGroupRecipients flaskGroupRecipients : findByGroupId(
				groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(flaskGroupRecipients);
		}
	}

	/**
	 * Returns the number of flask group recipientses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching flask group recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FLASKGROUPRECIPIENTS_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "flaskGroupRecipients.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MESSAGEID =
		new FinderPath(FlaskGroupRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskGroupRecipientsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMessageId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID =
		new FinderPath(FlaskGroupRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupRecipientsModelImpl.FINDER_CACHE_ENABLED,
			FlaskGroupRecipientsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMessageId",
			new String[] { Long.class.getName() },
			FlaskGroupRecipientsModelImpl.GROUPMESSAGEID_COLUMN_BITMASK |
			FlaskGroupRecipientsModelImpl.RECEIVEDDATETIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MESSAGEID = new FinderPath(FlaskGroupRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupRecipientsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMessageId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the flask group recipientses where groupMessageId = &#63;.
	 *
	 * @param groupMessageId the group message ID
	 * @return the matching flask group recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupRecipients> findByMessageId(long groupMessageId)
		throws SystemException {
		return findByMessageId(groupMessageId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flask group recipientses where groupMessageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupMessageId the group message ID
	 * @param start the lower bound of the range of flask group recipientses
	 * @param end the upper bound of the range of flask group recipientses (not inclusive)
	 * @return the range of matching flask group recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupRecipients> findByMessageId(long groupMessageId,
		int start, int end) throws SystemException {
		return findByMessageId(groupMessageId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask group recipientses where groupMessageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupMessageId the group message ID
	 * @param start the lower bound of the range of flask group recipientses
	 * @param end the upper bound of the range of flask group recipientses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flask group recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupRecipients> findByMessageId(long groupMessageId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID;
			finderArgs = new Object[] { groupMessageId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MESSAGEID;
			finderArgs = new Object[] {
					groupMessageId,
					
					start, end, orderByComparator
				};
		}

		List<FlaskGroupRecipients> list = (List<FlaskGroupRecipients>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FlaskGroupRecipients flaskGroupRecipients : list) {
				if ((groupMessageId != flaskGroupRecipients.getGroupMessageId())) {
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

			query.append(_SQL_SELECT_FLASKGROUPRECIPIENTS_WHERE);

			query.append(_FINDER_COLUMN_MESSAGEID_GROUPMESSAGEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlaskGroupRecipientsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupMessageId);

				if (!pagination) {
					list = (List<FlaskGroupRecipients>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskGroupRecipients>(list);
				}
				else {
					list = (List<FlaskGroupRecipients>)QueryUtil.list(q,
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
	 * Returns the first flask group recipients in the ordered set where groupMessageId = &#63;.
	 *
	 * @param groupMessageId the group message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask group recipients
	 * @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a matching flask group recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupRecipients findByMessageId_First(long groupMessageId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskGroupRecipientsException, SystemException {
		FlaskGroupRecipients flaskGroupRecipients = fetchByMessageId_First(groupMessageId,
				orderByComparator);

		if (flaskGroupRecipients != null) {
			return flaskGroupRecipients;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupMessageId=");
		msg.append(groupMessageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskGroupRecipientsException(msg.toString());
	}

	/**
	 * Returns the first flask group recipients in the ordered set where groupMessageId = &#63;.
	 *
	 * @param groupMessageId the group message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flask group recipients, or <code>null</code> if a matching flask group recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupRecipients fetchByMessageId_First(long groupMessageId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FlaskGroupRecipients> list = findByMessageId(groupMessageId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flask group recipients in the ordered set where groupMessageId = &#63;.
	 *
	 * @param groupMessageId the group message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask group recipients
	 * @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a matching flask group recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupRecipients findByMessageId_Last(long groupMessageId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskGroupRecipientsException, SystemException {
		FlaskGroupRecipients flaskGroupRecipients = fetchByMessageId_Last(groupMessageId,
				orderByComparator);

		if (flaskGroupRecipients != null) {
			return flaskGroupRecipients;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupMessageId=");
		msg.append(groupMessageId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlaskGroupRecipientsException(msg.toString());
	}

	/**
	 * Returns the last flask group recipients in the ordered set where groupMessageId = &#63;.
	 *
	 * @param groupMessageId the group message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flask group recipients, or <code>null</code> if a matching flask group recipients could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupRecipients fetchByMessageId_Last(long groupMessageId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMessageId(groupMessageId);

		if (count == 0) {
			return null;
		}

		List<FlaskGroupRecipients> list = findByMessageId(groupMessageId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flask group recipientses before and after the current flask group recipients in the ordered set where groupMessageId = &#63;.
	 *
	 * @param groupRecipientId the primary key of the current flask group recipients
	 * @param groupMessageId the group message ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flask group recipients
	 * @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a flask group recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupRecipients[] findByMessageId_PrevAndNext(
		long groupRecipientId, long groupMessageId,
		OrderByComparator orderByComparator)
		throws NoSuchFlaskGroupRecipientsException, SystemException {
		FlaskGroupRecipients flaskGroupRecipients = findByPrimaryKey(groupRecipientId);

		Session session = null;

		try {
			session = openSession();

			FlaskGroupRecipients[] array = new FlaskGroupRecipientsImpl[3];

			array[0] = getByMessageId_PrevAndNext(session,
					flaskGroupRecipients, groupMessageId, orderByComparator,
					true);

			array[1] = flaskGroupRecipients;

			array[2] = getByMessageId_PrevAndNext(session,
					flaskGroupRecipients, groupMessageId, orderByComparator,
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

	protected FlaskGroupRecipients getByMessageId_PrevAndNext(Session session,
		FlaskGroupRecipients flaskGroupRecipients, long groupMessageId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLASKGROUPRECIPIENTS_WHERE);

		query.append(_FINDER_COLUMN_MESSAGEID_GROUPMESSAGEID_2);

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
			query.append(FlaskGroupRecipientsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupMessageId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flaskGroupRecipients);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FlaskGroupRecipients> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flask group recipientses where groupMessageId = &#63; from the database.
	 *
	 * @param groupMessageId the group message ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMessageId(long groupMessageId)
		throws SystemException {
		for (FlaskGroupRecipients flaskGroupRecipients : findByMessageId(
				groupMessageId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(flaskGroupRecipients);
		}
	}

	/**
	 * Returns the number of flask group recipientses where groupMessageId = &#63;.
	 *
	 * @param groupMessageId the group message ID
	 * @return the number of matching flask group recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMessageId(long groupMessageId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MESSAGEID;

		Object[] finderArgs = new Object[] { groupMessageId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FLASKGROUPRECIPIENTS_WHERE);

			query.append(_FINDER_COLUMN_MESSAGEID_GROUPMESSAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupMessageId);

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

	private static final String _FINDER_COLUMN_MESSAGEID_GROUPMESSAGEID_2 = "flaskGroupRecipients.groupMessageId = ?";

	public FlaskGroupRecipientsPersistenceImpl() {
		setModelClass(FlaskGroupRecipients.class);
	}

	/**
	 * Caches the flask group recipients in the entity cache if it is enabled.
	 *
	 * @param flaskGroupRecipients the flask group recipients
	 */
	@Override
	public void cacheResult(FlaskGroupRecipients flaskGroupRecipients) {
		EntityCacheUtil.putResult(FlaskGroupRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupRecipientsImpl.class,
			flaskGroupRecipients.getPrimaryKey(), flaskGroupRecipients);

		flaskGroupRecipients.resetOriginalValues();
	}

	/**
	 * Caches the flask group recipientses in the entity cache if it is enabled.
	 *
	 * @param flaskGroupRecipientses the flask group recipientses
	 */
	@Override
	public void cacheResult(List<FlaskGroupRecipients> flaskGroupRecipientses) {
		for (FlaskGroupRecipients flaskGroupRecipients : flaskGroupRecipientses) {
			if (EntityCacheUtil.getResult(
						FlaskGroupRecipientsModelImpl.ENTITY_CACHE_ENABLED,
						FlaskGroupRecipientsImpl.class,
						flaskGroupRecipients.getPrimaryKey()) == null) {
				cacheResult(flaskGroupRecipients);
			}
			else {
				flaskGroupRecipients.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all flask group recipientses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FlaskGroupRecipientsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FlaskGroupRecipientsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the flask group recipients.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FlaskGroupRecipients flaskGroupRecipients) {
		EntityCacheUtil.removeResult(FlaskGroupRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupRecipientsImpl.class, flaskGroupRecipients.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FlaskGroupRecipients> flaskGroupRecipientses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FlaskGroupRecipients flaskGroupRecipients : flaskGroupRecipientses) {
			EntityCacheUtil.removeResult(FlaskGroupRecipientsModelImpl.ENTITY_CACHE_ENABLED,
				FlaskGroupRecipientsImpl.class,
				flaskGroupRecipients.getPrimaryKey());
		}
	}

	/**
	 * Creates a new flask group recipients with the primary key. Does not add the flask group recipients to the database.
	 *
	 * @param groupRecipientId the primary key for the new flask group recipients
	 * @return the new flask group recipients
	 */
	@Override
	public FlaskGroupRecipients create(long groupRecipientId) {
		FlaskGroupRecipients flaskGroupRecipients = new FlaskGroupRecipientsImpl();

		flaskGroupRecipients.setNew(true);
		flaskGroupRecipients.setPrimaryKey(groupRecipientId);

		return flaskGroupRecipients;
	}

	/**
	 * Removes the flask group recipients with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupRecipientId the primary key of the flask group recipients
	 * @return the flask group recipients that was removed
	 * @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a flask group recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupRecipients remove(long groupRecipientId)
		throws NoSuchFlaskGroupRecipientsException, SystemException {
		return remove((Serializable)groupRecipientId);
	}

	/**
	 * Removes the flask group recipients with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the flask group recipients
	 * @return the flask group recipients that was removed
	 * @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a flask group recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupRecipients remove(Serializable primaryKey)
		throws NoSuchFlaskGroupRecipientsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FlaskGroupRecipients flaskGroupRecipients = (FlaskGroupRecipients)session.get(FlaskGroupRecipientsImpl.class,
					primaryKey);

			if (flaskGroupRecipients == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFlaskGroupRecipientsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(flaskGroupRecipients);
		}
		catch (NoSuchFlaskGroupRecipientsException nsee) {
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
	protected FlaskGroupRecipients removeImpl(
		FlaskGroupRecipients flaskGroupRecipients) throws SystemException {
		flaskGroupRecipients = toUnwrappedModel(flaskGroupRecipients);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(flaskGroupRecipients)) {
				flaskGroupRecipients = (FlaskGroupRecipients)session.get(FlaskGroupRecipientsImpl.class,
						flaskGroupRecipients.getPrimaryKeyObj());
			}

			if (flaskGroupRecipients != null) {
				session.delete(flaskGroupRecipients);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (flaskGroupRecipients != null) {
			clearCache(flaskGroupRecipients);
		}

		return flaskGroupRecipients;
	}

	@Override
	public FlaskGroupRecipients updateImpl(
		com.liferay.contacts.model.FlaskGroupRecipients flaskGroupRecipients)
		throws SystemException {
		flaskGroupRecipients = toUnwrappedModel(flaskGroupRecipients);

		boolean isNew = flaskGroupRecipients.isNew();

		FlaskGroupRecipientsModelImpl flaskGroupRecipientsModelImpl = (FlaskGroupRecipientsModelImpl)flaskGroupRecipients;

		Session session = null;

		try {
			session = openSession();

			if (flaskGroupRecipients.isNew()) {
				session.save(flaskGroupRecipients);

				flaskGroupRecipients.setNew(false);
			}
			else {
				session.merge(flaskGroupRecipients);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FlaskGroupRecipientsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((flaskGroupRecipientsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flaskGroupRecipientsModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { flaskGroupRecipientsModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((flaskGroupRecipientsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flaskGroupRecipientsModelImpl.getOriginalGroupMessageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MESSAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID,
					args);

				args = new Object[] {
						flaskGroupRecipientsModelImpl.getGroupMessageId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MESSAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MESSAGEID,
					args);
			}
		}

		EntityCacheUtil.putResult(FlaskGroupRecipientsModelImpl.ENTITY_CACHE_ENABLED,
			FlaskGroupRecipientsImpl.class,
			flaskGroupRecipients.getPrimaryKey(), flaskGroupRecipients);

		return flaskGroupRecipients;
	}

	protected FlaskGroupRecipients toUnwrappedModel(
		FlaskGroupRecipients flaskGroupRecipients) {
		if (flaskGroupRecipients instanceof FlaskGroupRecipientsImpl) {
			return flaskGroupRecipients;
		}

		FlaskGroupRecipientsImpl flaskGroupRecipientsImpl = new FlaskGroupRecipientsImpl();

		flaskGroupRecipientsImpl.setNew(flaskGroupRecipients.isNew());
		flaskGroupRecipientsImpl.setPrimaryKey(flaskGroupRecipients.getPrimaryKey());

		flaskGroupRecipientsImpl.setGroupRecipientId(flaskGroupRecipients.getGroupRecipientId());
		flaskGroupRecipientsImpl.setGroupId(flaskGroupRecipients.getGroupId());
		flaskGroupRecipientsImpl.setRecipients(flaskGroupRecipients.getRecipients());
		flaskGroupRecipientsImpl.setGroupMessageId(flaskGroupRecipients.getGroupMessageId());
		flaskGroupRecipientsImpl.setRead(flaskGroupRecipients.getRead());
		flaskGroupRecipientsImpl.setReceivedDateTime(flaskGroupRecipients.getReceivedDateTime());
		flaskGroupRecipientsImpl.setSenderId(flaskGroupRecipients.getSenderId());
		flaskGroupRecipientsImpl.setMessageStatusInfo(flaskGroupRecipients.getMessageStatusInfo());

		return flaskGroupRecipientsImpl;
	}

	/**
	 * Returns the flask group recipients with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask group recipients
	 * @return the flask group recipients
	 * @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a flask group recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupRecipients findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFlaskGroupRecipientsException, SystemException {
		FlaskGroupRecipients flaskGroupRecipients = fetchByPrimaryKey(primaryKey);

		if (flaskGroupRecipients == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFlaskGroupRecipientsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return flaskGroupRecipients;
	}

	/**
	 * Returns the flask group recipients with the primary key or throws a {@link com.liferay.contacts.NoSuchFlaskGroupRecipientsException} if it could not be found.
	 *
	 * @param groupRecipientId the primary key of the flask group recipients
	 * @return the flask group recipients
	 * @throws com.liferay.contacts.NoSuchFlaskGroupRecipientsException if a flask group recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupRecipients findByPrimaryKey(long groupRecipientId)
		throws NoSuchFlaskGroupRecipientsException, SystemException {
		return findByPrimaryKey((Serializable)groupRecipientId);
	}

	/**
	 * Returns the flask group recipients with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the flask group recipients
	 * @return the flask group recipients, or <code>null</code> if a flask group recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupRecipients fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FlaskGroupRecipients flaskGroupRecipients = (FlaskGroupRecipients)EntityCacheUtil.getResult(FlaskGroupRecipientsModelImpl.ENTITY_CACHE_ENABLED,
				FlaskGroupRecipientsImpl.class, primaryKey);

		if (flaskGroupRecipients == _nullFlaskGroupRecipients) {
			return null;
		}

		if (flaskGroupRecipients == null) {
			Session session = null;

			try {
				session = openSession();

				flaskGroupRecipients = (FlaskGroupRecipients)session.get(FlaskGroupRecipientsImpl.class,
						primaryKey);

				if (flaskGroupRecipients != null) {
					cacheResult(flaskGroupRecipients);
				}
				else {
					EntityCacheUtil.putResult(FlaskGroupRecipientsModelImpl.ENTITY_CACHE_ENABLED,
						FlaskGroupRecipientsImpl.class, primaryKey,
						_nullFlaskGroupRecipients);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FlaskGroupRecipientsModelImpl.ENTITY_CACHE_ENABLED,
					FlaskGroupRecipientsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return flaskGroupRecipients;
	}

	/**
	 * Returns the flask group recipients with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupRecipientId the primary key of the flask group recipients
	 * @return the flask group recipients, or <code>null</code> if a flask group recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroupRecipients fetchByPrimaryKey(long groupRecipientId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)groupRecipientId);
	}

	/**
	 * Returns all the flask group recipientses.
	 *
	 * @return the flask group recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupRecipients> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flask group recipientses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask group recipientses
	 * @param end the upper bound of the range of flask group recipientses (not inclusive)
	 * @return the range of flask group recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupRecipients> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the flask group recipientses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskGroupRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask group recipientses
	 * @param end the upper bound of the range of flask group recipientses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of flask group recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroupRecipients> findAll(int start, int end,
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

		List<FlaskGroupRecipients> list = (List<FlaskGroupRecipients>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FLASKGROUPRECIPIENTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FLASKGROUPRECIPIENTS;

				if (pagination) {
					sql = sql.concat(FlaskGroupRecipientsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FlaskGroupRecipients>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlaskGroupRecipients>(list);
				}
				else {
					list = (List<FlaskGroupRecipients>)QueryUtil.list(q,
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
	 * Removes all the flask group recipientses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FlaskGroupRecipients flaskGroupRecipients : findAll()) {
			remove(flaskGroupRecipients);
		}
	}

	/**
	 * Returns the number of flask group recipientses.
	 *
	 * @return the number of flask group recipientses
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

				Query q = session.createQuery(_SQL_COUNT_FLASKGROUPRECIPIENTS);

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
	 * Initializes the flask group recipients persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.contacts.model.FlaskGroupRecipients")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FlaskGroupRecipients>> listenersList = new ArrayList<ModelListener<FlaskGroupRecipients>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FlaskGroupRecipients>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FlaskGroupRecipientsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FLASKGROUPRECIPIENTS = "SELECT flaskGroupRecipients FROM FlaskGroupRecipients flaskGroupRecipients";
	private static final String _SQL_SELECT_FLASKGROUPRECIPIENTS_WHERE = "SELECT flaskGroupRecipients FROM FlaskGroupRecipients flaskGroupRecipients WHERE ";
	private static final String _SQL_COUNT_FLASKGROUPRECIPIENTS = "SELECT COUNT(flaskGroupRecipients) FROM FlaskGroupRecipients flaskGroupRecipients";
	private static final String _SQL_COUNT_FLASKGROUPRECIPIENTS_WHERE = "SELECT COUNT(flaskGroupRecipients) FROM FlaskGroupRecipients flaskGroupRecipients WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "flaskGroupRecipients.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FlaskGroupRecipients exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FlaskGroupRecipients exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FlaskGroupRecipientsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"read"
			});
	private static FlaskGroupRecipients _nullFlaskGroupRecipients = new FlaskGroupRecipientsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FlaskGroupRecipients> toCacheModel() {
				return _nullFlaskGroupRecipientsCacheModel;
			}
		};

	private static CacheModel<FlaskGroupRecipients> _nullFlaskGroupRecipientsCacheModel =
		new CacheModel<FlaskGroupRecipients>() {
			@Override
			public FlaskGroupRecipients toEntityModel() {
				return _nullFlaskGroupRecipients;
			}
		};
}