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

import com.rumbasolutions.flask.NoSuchTailgateMessageBoardException;
import com.rumbasolutions.flask.model.TailgateMessageBoard;
import com.rumbasolutions.flask.model.impl.TailgateMessageBoardImpl;
import com.rumbasolutions.flask.model.impl.TailgateMessageBoardModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the tailgate message board service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TailgateMessageBoardPersistence
 * @see TailgateMessageBoardUtil
 * @generated
 */
public class TailgateMessageBoardPersistenceImpl extends BasePersistenceImpl<TailgateMessageBoard>
	implements TailgateMessageBoardPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TailgateMessageBoardUtil} to access the tailgate message board persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TailgateMessageBoardImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TailgateMessageBoardModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMessageBoardModelImpl.FINDER_CACHE_ENABLED,
			TailgateMessageBoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TailgateMessageBoardModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMessageBoardModelImpl.FINDER_CACHE_ENABLED,
			TailgateMessageBoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TailgateMessageBoardModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMessageBoardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAILGATEID =
		new FinderPath(TailgateMessageBoardModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMessageBoardModelImpl.FINDER_CACHE_ENABLED,
			TailgateMessageBoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytailgateId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID =
		new FinderPath(TailgateMessageBoardModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMessageBoardModelImpl.FINDER_CACHE_ENABLED,
			TailgateMessageBoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytailgateId",
			new String[] { Long.class.getName() },
			TailgateMessageBoardModelImpl.TAILGATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAILGATEID = new FinderPath(TailgateMessageBoardModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMessageBoardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytailgateId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tailgate message boards where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @return the matching tailgate message boards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateMessageBoard> findBytailgateId(long tailgateId)
		throws SystemException {
		return findBytailgateId(tailgateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tailgate message boards where tailgateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateMessageBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tailgateId the tailgate ID
	 * @param start the lower bound of the range of tailgate message boards
	 * @param end the upper bound of the range of tailgate message boards (not inclusive)
	 * @return the range of matching tailgate message boards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateMessageBoard> findBytailgateId(long tailgateId,
		int start, int end) throws SystemException {
		return findBytailgateId(tailgateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tailgate message boards where tailgateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateMessageBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param tailgateId the tailgate ID
	 * @param start the lower bound of the range of tailgate message boards
	 * @param end the upper bound of the range of tailgate message boards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tailgate message boards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateMessageBoard> findBytailgateId(long tailgateId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<TailgateMessageBoard> list = (List<TailgateMessageBoard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TailgateMessageBoard tailgateMessageBoard : list) {
				if ((tailgateId != tailgateMessageBoard.getTailgateId())) {
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

			query.append(_SQL_SELECT_TAILGATEMESSAGEBOARD_WHERE);

			query.append(_FINDER_COLUMN_TAILGATEID_TAILGATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TailgateMessageBoardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tailgateId);

				if (!pagination) {
					list = (List<TailgateMessageBoard>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TailgateMessageBoard>(list);
				}
				else {
					list = (List<TailgateMessageBoard>)QueryUtil.list(q,
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
	 * Returns the first tailgate message board in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tailgate message board
	 * @throws com.rumbasolutions.flask.NoSuchTailgateMessageBoardException if a matching tailgate message board could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMessageBoard findBytailgateId_First(long tailgateId,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateMessageBoardException, SystemException {
		TailgateMessageBoard tailgateMessageBoard = fetchBytailgateId_First(tailgateId,
				orderByComparator);

		if (tailgateMessageBoard != null) {
			return tailgateMessageBoard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tailgateId=");
		msg.append(tailgateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTailgateMessageBoardException(msg.toString());
	}

	/**
	 * Returns the first tailgate message board in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tailgate message board, or <code>null</code> if a matching tailgate message board could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMessageBoard fetchBytailgateId_First(long tailgateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TailgateMessageBoard> list = findBytailgateId(tailgateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tailgate message board in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tailgate message board
	 * @throws com.rumbasolutions.flask.NoSuchTailgateMessageBoardException if a matching tailgate message board could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMessageBoard findBytailgateId_Last(long tailgateId,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateMessageBoardException, SystemException {
		TailgateMessageBoard tailgateMessageBoard = fetchBytailgateId_Last(tailgateId,
				orderByComparator);

		if (tailgateMessageBoard != null) {
			return tailgateMessageBoard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tailgateId=");
		msg.append(tailgateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTailgateMessageBoardException(msg.toString());
	}

	/**
	 * Returns the last tailgate message board in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tailgate message board, or <code>null</code> if a matching tailgate message board could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMessageBoard fetchBytailgateId_Last(long tailgateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBytailgateId(tailgateId);

		if (count == 0) {
			return null;
		}

		List<TailgateMessageBoard> list = findBytailgateId(tailgateId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tailgate message boards before and after the current tailgate message board in the ordered set where tailgateId = &#63;.
	 *
	 * @param tailgateMessageId the primary key of the current tailgate message board
	 * @param tailgateId the tailgate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tailgate message board
	 * @throws com.rumbasolutions.flask.NoSuchTailgateMessageBoardException if a tailgate message board with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMessageBoard[] findBytailgateId_PrevAndNext(
		long tailgateMessageId, long tailgateId,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateMessageBoardException, SystemException {
		TailgateMessageBoard tailgateMessageBoard = findByPrimaryKey(tailgateMessageId);

		Session session = null;

		try {
			session = openSession();

			TailgateMessageBoard[] array = new TailgateMessageBoardImpl[3];

			array[0] = getBytailgateId_PrevAndNext(session,
					tailgateMessageBoard, tailgateId, orderByComparator, true);

			array[1] = tailgateMessageBoard;

			array[2] = getBytailgateId_PrevAndNext(session,
					tailgateMessageBoard, tailgateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TailgateMessageBoard getBytailgateId_PrevAndNext(
		Session session, TailgateMessageBoard tailgateMessageBoard,
		long tailgateId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAILGATEMESSAGEBOARD_WHERE);

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
			query.append(TailgateMessageBoardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(tailgateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tailgateMessageBoard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TailgateMessageBoard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tailgate message boards where tailgateId = &#63; from the database.
	 *
	 * @param tailgateId the tailgate ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBytailgateId(long tailgateId) throws SystemException {
		for (TailgateMessageBoard tailgateMessageBoard : findBytailgateId(
				tailgateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tailgateMessageBoard);
		}
	}

	/**
	 * Returns the number of tailgate message boards where tailgateId = &#63;.
	 *
	 * @param tailgateId the tailgate ID
	 * @return the number of matching tailgate message boards
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

			query.append(_SQL_COUNT_TAILGATEMESSAGEBOARD_WHERE);

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

	private static final String _FINDER_COLUMN_TAILGATEID_TAILGATEID_2 = "tailgateMessageBoard.tailgateId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(TailgateMessageBoardModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMessageBoardModelImpl.FINDER_CACHE_ENABLED,
			TailgateMessageBoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(TailgateMessageBoardModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMessageBoardModelImpl.FINDER_CACHE_ENABLED,
			TailgateMessageBoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] { Long.class.getName() },
			TailgateMessageBoardModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(TailgateMessageBoardModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMessageBoardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the tailgate message boards where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching tailgate message boards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateMessageBoard> findByuserId(long userId)
		throws SystemException {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tailgate message boards where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateMessageBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of tailgate message boards
	 * @param end the upper bound of the range of tailgate message boards (not inclusive)
	 * @return the range of matching tailgate message boards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateMessageBoard> findByuserId(long userId, int start,
		int end) throws SystemException {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tailgate message boards where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateMessageBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of tailgate message boards
	 * @param end the upper bound of the range of tailgate message boards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tailgate message boards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateMessageBoard> findByuserId(long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<TailgateMessageBoard> list = (List<TailgateMessageBoard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TailgateMessageBoard tailgateMessageBoard : list) {
				if ((userId != tailgateMessageBoard.getUserId())) {
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

			query.append(_SQL_SELECT_TAILGATEMESSAGEBOARD_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TailgateMessageBoardModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<TailgateMessageBoard>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TailgateMessageBoard>(list);
				}
				else {
					list = (List<TailgateMessageBoard>)QueryUtil.list(q,
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
	 * Returns the first tailgate message board in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tailgate message board
	 * @throws com.rumbasolutions.flask.NoSuchTailgateMessageBoardException if a matching tailgate message board could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMessageBoard findByuserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateMessageBoardException, SystemException {
		TailgateMessageBoard tailgateMessageBoard = fetchByuserId_First(userId,
				orderByComparator);

		if (tailgateMessageBoard != null) {
			return tailgateMessageBoard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTailgateMessageBoardException(msg.toString());
	}

	/**
	 * Returns the first tailgate message board in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tailgate message board, or <code>null</code> if a matching tailgate message board could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMessageBoard fetchByuserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TailgateMessageBoard> list = findByuserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tailgate message board in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tailgate message board
	 * @throws com.rumbasolutions.flask.NoSuchTailgateMessageBoardException if a matching tailgate message board could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMessageBoard findByuserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchTailgateMessageBoardException, SystemException {
		TailgateMessageBoard tailgateMessageBoard = fetchByuserId_Last(userId,
				orderByComparator);

		if (tailgateMessageBoard != null) {
			return tailgateMessageBoard;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTailgateMessageBoardException(msg.toString());
	}

	/**
	 * Returns the last tailgate message board in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tailgate message board, or <code>null</code> if a matching tailgate message board could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMessageBoard fetchByuserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<TailgateMessageBoard> list = findByuserId(userId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tailgate message boards before and after the current tailgate message board in the ordered set where userId = &#63;.
	 *
	 * @param tailgateMessageId the primary key of the current tailgate message board
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tailgate message board
	 * @throws com.rumbasolutions.flask.NoSuchTailgateMessageBoardException if a tailgate message board with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMessageBoard[] findByuserId_PrevAndNext(
		long tailgateMessageId, long userId, OrderByComparator orderByComparator)
		throws NoSuchTailgateMessageBoardException, SystemException {
		TailgateMessageBoard tailgateMessageBoard = findByPrimaryKey(tailgateMessageId);

		Session session = null;

		try {
			session = openSession();

			TailgateMessageBoard[] array = new TailgateMessageBoardImpl[3];

			array[0] = getByuserId_PrevAndNext(session, tailgateMessageBoard,
					userId, orderByComparator, true);

			array[1] = tailgateMessageBoard;

			array[2] = getByuserId_PrevAndNext(session, tailgateMessageBoard,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TailgateMessageBoard getByuserId_PrevAndNext(Session session,
		TailgateMessageBoard tailgateMessageBoard, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAILGATEMESSAGEBOARD_WHERE);

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
			query.append(TailgateMessageBoardModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(tailgateMessageBoard);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TailgateMessageBoard> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tailgate message boards where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuserId(long userId) throws SystemException {
		for (TailgateMessageBoard tailgateMessageBoard : findByuserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(tailgateMessageBoard);
		}
	}

	/**
	 * Returns the number of tailgate message boards where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching tailgate message boards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAILGATEMESSAGEBOARD_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "tailgateMessageBoard.userId = ?";

	public TailgateMessageBoardPersistenceImpl() {
		setModelClass(TailgateMessageBoard.class);
	}

	/**
	 * Caches the tailgate message board in the entity cache if it is enabled.
	 *
	 * @param tailgateMessageBoard the tailgate message board
	 */
	@Override
	public void cacheResult(TailgateMessageBoard tailgateMessageBoard) {
		EntityCacheUtil.putResult(TailgateMessageBoardModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMessageBoardImpl.class,
			tailgateMessageBoard.getPrimaryKey(), tailgateMessageBoard);

		tailgateMessageBoard.resetOriginalValues();
	}

	/**
	 * Caches the tailgate message boards in the entity cache if it is enabled.
	 *
	 * @param tailgateMessageBoards the tailgate message boards
	 */
	@Override
	public void cacheResult(List<TailgateMessageBoard> tailgateMessageBoards) {
		for (TailgateMessageBoard tailgateMessageBoard : tailgateMessageBoards) {
			if (EntityCacheUtil.getResult(
						TailgateMessageBoardModelImpl.ENTITY_CACHE_ENABLED,
						TailgateMessageBoardImpl.class,
						tailgateMessageBoard.getPrimaryKey()) == null) {
				cacheResult(tailgateMessageBoard);
			}
			else {
				tailgateMessageBoard.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tailgate message boards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TailgateMessageBoardImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TailgateMessageBoardImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tailgate message board.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TailgateMessageBoard tailgateMessageBoard) {
		EntityCacheUtil.removeResult(TailgateMessageBoardModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMessageBoardImpl.class, tailgateMessageBoard.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TailgateMessageBoard> tailgateMessageBoards) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TailgateMessageBoard tailgateMessageBoard : tailgateMessageBoards) {
			EntityCacheUtil.removeResult(TailgateMessageBoardModelImpl.ENTITY_CACHE_ENABLED,
				TailgateMessageBoardImpl.class,
				tailgateMessageBoard.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tailgate message board with the primary key. Does not add the tailgate message board to the database.
	 *
	 * @param tailgateMessageId the primary key for the new tailgate message board
	 * @return the new tailgate message board
	 */
	@Override
	public TailgateMessageBoard create(long tailgateMessageId) {
		TailgateMessageBoard tailgateMessageBoard = new TailgateMessageBoardImpl();

		tailgateMessageBoard.setNew(true);
		tailgateMessageBoard.setPrimaryKey(tailgateMessageId);

		return tailgateMessageBoard;
	}

	/**
	 * Removes the tailgate message board with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tailgateMessageId the primary key of the tailgate message board
	 * @return the tailgate message board that was removed
	 * @throws com.rumbasolutions.flask.NoSuchTailgateMessageBoardException if a tailgate message board with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMessageBoard remove(long tailgateMessageId)
		throws NoSuchTailgateMessageBoardException, SystemException {
		return remove((Serializable)tailgateMessageId);
	}

	/**
	 * Removes the tailgate message board with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tailgate message board
	 * @return the tailgate message board that was removed
	 * @throws com.rumbasolutions.flask.NoSuchTailgateMessageBoardException if a tailgate message board with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMessageBoard remove(Serializable primaryKey)
		throws NoSuchTailgateMessageBoardException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TailgateMessageBoard tailgateMessageBoard = (TailgateMessageBoard)session.get(TailgateMessageBoardImpl.class,
					primaryKey);

			if (tailgateMessageBoard == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTailgateMessageBoardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tailgateMessageBoard);
		}
		catch (NoSuchTailgateMessageBoardException nsee) {
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
	protected TailgateMessageBoard removeImpl(
		TailgateMessageBoard tailgateMessageBoard) throws SystemException {
		tailgateMessageBoard = toUnwrappedModel(tailgateMessageBoard);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tailgateMessageBoard)) {
				tailgateMessageBoard = (TailgateMessageBoard)session.get(TailgateMessageBoardImpl.class,
						tailgateMessageBoard.getPrimaryKeyObj());
			}

			if (tailgateMessageBoard != null) {
				session.delete(tailgateMessageBoard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tailgateMessageBoard != null) {
			clearCache(tailgateMessageBoard);
		}

		return tailgateMessageBoard;
	}

	@Override
	public TailgateMessageBoard updateImpl(
		com.rumbasolutions.flask.model.TailgateMessageBoard tailgateMessageBoard)
		throws SystemException {
		tailgateMessageBoard = toUnwrappedModel(tailgateMessageBoard);

		boolean isNew = tailgateMessageBoard.isNew();

		TailgateMessageBoardModelImpl tailgateMessageBoardModelImpl = (TailgateMessageBoardModelImpl)tailgateMessageBoard;

		Session session = null;

		try {
			session = openSession();

			if (tailgateMessageBoard.isNew()) {
				session.save(tailgateMessageBoard);

				tailgateMessageBoard.setNew(false);
			}
			else {
				session.merge(tailgateMessageBoard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TailgateMessageBoardModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((tailgateMessageBoardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tailgateMessageBoardModelImpl.getOriginalTailgateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAILGATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID,
					args);

				args = new Object[] {
						tailgateMessageBoardModelImpl.getTailgateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAILGATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAILGATEID,
					args);
			}

			if ((tailgateMessageBoardModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						tailgateMessageBoardModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { tailgateMessageBoardModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(TailgateMessageBoardModelImpl.ENTITY_CACHE_ENABLED,
			TailgateMessageBoardImpl.class,
			tailgateMessageBoard.getPrimaryKey(), tailgateMessageBoard);

		return tailgateMessageBoard;
	}

	protected TailgateMessageBoard toUnwrappedModel(
		TailgateMessageBoard tailgateMessageBoard) {
		if (tailgateMessageBoard instanceof TailgateMessageBoardImpl) {
			return tailgateMessageBoard;
		}

		TailgateMessageBoardImpl tailgateMessageBoardImpl = new TailgateMessageBoardImpl();

		tailgateMessageBoardImpl.setNew(tailgateMessageBoard.isNew());
		tailgateMessageBoardImpl.setPrimaryKey(tailgateMessageBoard.getPrimaryKey());

		tailgateMessageBoardImpl.setTailgateMessageId(tailgateMessageBoard.getTailgateMessageId());
		tailgateMessageBoardImpl.setMessageText(tailgateMessageBoard.getMessageText());
		tailgateMessageBoardImpl.setTailgateId(tailgateMessageBoard.getTailgateId());
		tailgateMessageBoardImpl.setCompanyId(tailgateMessageBoard.getCompanyId());
		tailgateMessageBoardImpl.setUserId(tailgateMessageBoard.getUserId());
		tailgateMessageBoardImpl.setCreatedDate(tailgateMessageBoard.getCreatedDate());
		tailgateMessageBoardImpl.setModifiedDate(tailgateMessageBoard.getModifiedDate());

		return tailgateMessageBoardImpl;
	}

	/**
	 * Returns the tailgate message board with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tailgate message board
	 * @return the tailgate message board
	 * @throws com.rumbasolutions.flask.NoSuchTailgateMessageBoardException if a tailgate message board with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMessageBoard findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTailgateMessageBoardException, SystemException {
		TailgateMessageBoard tailgateMessageBoard = fetchByPrimaryKey(primaryKey);

		if (tailgateMessageBoard == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTailgateMessageBoardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return tailgateMessageBoard;
	}

	/**
	 * Returns the tailgate message board with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchTailgateMessageBoardException} if it could not be found.
	 *
	 * @param tailgateMessageId the primary key of the tailgate message board
	 * @return the tailgate message board
	 * @throws com.rumbasolutions.flask.NoSuchTailgateMessageBoardException if a tailgate message board with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMessageBoard findByPrimaryKey(long tailgateMessageId)
		throws NoSuchTailgateMessageBoardException, SystemException {
		return findByPrimaryKey((Serializable)tailgateMessageId);
	}

	/**
	 * Returns the tailgate message board with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tailgate message board
	 * @return the tailgate message board, or <code>null</code> if a tailgate message board with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMessageBoard fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TailgateMessageBoard tailgateMessageBoard = (TailgateMessageBoard)EntityCacheUtil.getResult(TailgateMessageBoardModelImpl.ENTITY_CACHE_ENABLED,
				TailgateMessageBoardImpl.class, primaryKey);

		if (tailgateMessageBoard == _nullTailgateMessageBoard) {
			return null;
		}

		if (tailgateMessageBoard == null) {
			Session session = null;

			try {
				session = openSession();

				tailgateMessageBoard = (TailgateMessageBoard)session.get(TailgateMessageBoardImpl.class,
						primaryKey);

				if (tailgateMessageBoard != null) {
					cacheResult(tailgateMessageBoard);
				}
				else {
					EntityCacheUtil.putResult(TailgateMessageBoardModelImpl.ENTITY_CACHE_ENABLED,
						TailgateMessageBoardImpl.class, primaryKey,
						_nullTailgateMessageBoard);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TailgateMessageBoardModelImpl.ENTITY_CACHE_ENABLED,
					TailgateMessageBoardImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return tailgateMessageBoard;
	}

	/**
	 * Returns the tailgate message board with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tailgateMessageId the primary key of the tailgate message board
	 * @return the tailgate message board, or <code>null</code> if a tailgate message board with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateMessageBoard fetchByPrimaryKey(long tailgateMessageId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)tailgateMessageId);
	}

	/**
	 * Returns all the tailgate message boards.
	 *
	 * @return the tailgate message boards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateMessageBoard> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tailgate message boards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateMessageBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tailgate message boards
	 * @param end the upper bound of the range of tailgate message boards (not inclusive)
	 * @return the range of tailgate message boards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateMessageBoard> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tailgate message boards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateMessageBoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tailgate message boards
	 * @param end the upper bound of the range of tailgate message boards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tailgate message boards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateMessageBoard> findAll(int start, int end,
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

		List<TailgateMessageBoard> list = (List<TailgateMessageBoard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAILGATEMESSAGEBOARD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAILGATEMESSAGEBOARD;

				if (pagination) {
					sql = sql.concat(TailgateMessageBoardModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TailgateMessageBoard>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TailgateMessageBoard>(list);
				}
				else {
					list = (List<TailgateMessageBoard>)QueryUtil.list(q,
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
	 * Removes all the tailgate message boards from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TailgateMessageBoard tailgateMessageBoard : findAll()) {
			remove(tailgateMessageBoard);
		}
	}

	/**
	 * Returns the number of tailgate message boards.
	 *
	 * @return the number of tailgate message boards
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

				Query q = session.createQuery(_SQL_COUNT_TAILGATEMESSAGEBOARD);

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
	 * Initializes the tailgate message board persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rumbasolutions.flask.model.TailgateMessageBoard")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TailgateMessageBoard>> listenersList = new ArrayList<ModelListener<TailgateMessageBoard>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TailgateMessageBoard>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TailgateMessageBoardImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TAILGATEMESSAGEBOARD = "SELECT tailgateMessageBoard FROM TailgateMessageBoard tailgateMessageBoard";
	private static final String _SQL_SELECT_TAILGATEMESSAGEBOARD_WHERE = "SELECT tailgateMessageBoard FROM TailgateMessageBoard tailgateMessageBoard WHERE ";
	private static final String _SQL_COUNT_TAILGATEMESSAGEBOARD = "SELECT COUNT(tailgateMessageBoard) FROM TailgateMessageBoard tailgateMessageBoard";
	private static final String _SQL_COUNT_TAILGATEMESSAGEBOARD_WHERE = "SELECT COUNT(tailgateMessageBoard) FROM TailgateMessageBoard tailgateMessageBoard WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tailgateMessageBoard.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TailgateMessageBoard exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TailgateMessageBoard exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TailgateMessageBoardPersistenceImpl.class);
	private static TailgateMessageBoard _nullTailgateMessageBoard = new TailgateMessageBoardImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TailgateMessageBoard> toCacheModel() {
				return _nullTailgateMessageBoardCacheModel;
			}
		};

	private static CacheModel<TailgateMessageBoard> _nullTailgateMessageBoardCacheModel =
		new CacheModel<TailgateMessageBoard>() {
			@Override
			public TailgateMessageBoard toEntityModel() {
				return _nullTailgateMessageBoard;
			}
		};
}