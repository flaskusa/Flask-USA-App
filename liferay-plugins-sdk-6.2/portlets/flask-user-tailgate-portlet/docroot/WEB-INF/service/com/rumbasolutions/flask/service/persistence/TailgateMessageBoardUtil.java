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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rumbasolutions.flask.model.TailgateMessageBoard;

import java.util.List;

/**
 * The persistence utility for the tailgate message board service. This utility wraps {@link TailgateMessageBoardPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TailgateMessageBoardPersistence
 * @see TailgateMessageBoardPersistenceImpl
 * @generated
 */
public class TailgateMessageBoardUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(TailgateMessageBoard tailgateMessageBoard) {
		getPersistence().clearCache(tailgateMessageBoard);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TailgateMessageBoard> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TailgateMessageBoard> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TailgateMessageBoard> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TailgateMessageBoard update(
		TailgateMessageBoard tailgateMessageBoard) throws SystemException {
		return getPersistence().update(tailgateMessageBoard);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TailgateMessageBoard update(
		TailgateMessageBoard tailgateMessageBoard, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(tailgateMessageBoard, serviceContext);
	}

	/**
	* Returns all the tailgate message boards where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @return the matching tailgate message boards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> findBytailgateId(
		long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytailgateId(tailgateId);
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
	public static java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> findBytailgateId(
		long tailgateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytailgateId(tailgateId, start, end);
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
	public static java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> findBytailgateId(
		long tailgateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBytailgateId(tailgateId, start, end, orderByComparator);
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
	public static com.rumbasolutions.flask.model.TailgateMessageBoard findBytailgateId_First(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMessageBoardException {
		return getPersistence()
				   .findBytailgateId_First(tailgateId, orderByComparator);
	}

	/**
	* Returns the first tailgate message board in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate message board, or <code>null</code> if a matching tailgate message board could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateMessageBoard fetchBytailgateId_First(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBytailgateId_First(tailgateId, orderByComparator);
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
	public static com.rumbasolutions.flask.model.TailgateMessageBoard findBytailgateId_Last(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMessageBoardException {
		return getPersistence()
				   .findBytailgateId_Last(tailgateId, orderByComparator);
	}

	/**
	* Returns the last tailgate message board in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate message board, or <code>null</code> if a matching tailgate message board could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateMessageBoard fetchBytailgateId_Last(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBytailgateId_Last(tailgateId, orderByComparator);
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
	public static com.rumbasolutions.flask.model.TailgateMessageBoard[] findBytailgateId_PrevAndNext(
		long tailgateMessageId, long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMessageBoardException {
		return getPersistence()
				   .findBytailgateId_PrevAndNext(tailgateMessageId, tailgateId,
			orderByComparator);
	}

	/**
	* Removes all the tailgate message boards where tailgateId = &#63; from the database.
	*
	* @param tailgateId the tailgate ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBytailgateId(long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBytailgateId(tailgateId);
	}

	/**
	* Returns the number of tailgate message boards where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @return the number of matching tailgate message boards
	* @throws SystemException if a system exception occurred
	*/
	public static int countBytailgateId(long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBytailgateId(tailgateId);
	}

	/**
	* Returns all the tailgate message boards where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching tailgate message boards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> findByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserId(userId);
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
	public static java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> findByuserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserId(userId, start, end);
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
	public static java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserId(userId, start, end, orderByComparator);
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
	public static com.rumbasolutions.flask.model.TailgateMessageBoard findByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMessageBoardException {
		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first tailgate message board in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate message board, or <code>null</code> if a matching tailgate message board could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateMessageBoard fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuserId_First(userId, orderByComparator);
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
	public static com.rumbasolutions.flask.model.TailgateMessageBoard findByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMessageBoardException {
		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last tailgate message board in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate message board, or <code>null</code> if a matching tailgate message board could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateMessageBoard fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
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
	public static com.rumbasolutions.flask.model.TailgateMessageBoard[] findByuserId_PrevAndNext(
		long tailgateMessageId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMessageBoardException {
		return getPersistence()
				   .findByuserId_PrevAndNext(tailgateMessageId, userId,
			orderByComparator);
	}

	/**
	* Removes all the tailgate message boards where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByuserId(userId);
	}

	/**
	* Returns the number of tailgate message boards where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching tailgate message boards
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByuserId(userId);
	}

	/**
	* Caches the tailgate message board in the entity cache if it is enabled.
	*
	* @param tailgateMessageBoard the tailgate message board
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.TailgateMessageBoard tailgateMessageBoard) {
		getPersistence().cacheResult(tailgateMessageBoard);
	}

	/**
	* Caches the tailgate message boards in the entity cache if it is enabled.
	*
	* @param tailgateMessageBoards the tailgate message boards
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> tailgateMessageBoards) {
		getPersistence().cacheResult(tailgateMessageBoards);
	}

	/**
	* Creates a new tailgate message board with the primary key. Does not add the tailgate message board to the database.
	*
	* @param tailgateMessageId the primary key for the new tailgate message board
	* @return the new tailgate message board
	*/
	public static com.rumbasolutions.flask.model.TailgateMessageBoard create(
		long tailgateMessageId) {
		return getPersistence().create(tailgateMessageId);
	}

	/**
	* Removes the tailgate message board with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateMessageId the primary key of the tailgate message board
	* @return the tailgate message board that was removed
	* @throws com.rumbasolutions.flask.NoSuchTailgateMessageBoardException if a tailgate message board with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateMessageBoard remove(
		long tailgateMessageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMessageBoardException {
		return getPersistence().remove(tailgateMessageId);
	}

	public static com.rumbasolutions.flask.model.TailgateMessageBoard updateImpl(
		com.rumbasolutions.flask.model.TailgateMessageBoard tailgateMessageBoard)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tailgateMessageBoard);
	}

	/**
	* Returns the tailgate message board with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchTailgateMessageBoardException} if it could not be found.
	*
	* @param tailgateMessageId the primary key of the tailgate message board
	* @return the tailgate message board
	* @throws com.rumbasolutions.flask.NoSuchTailgateMessageBoardException if a tailgate message board with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateMessageBoard findByPrimaryKey(
		long tailgateMessageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMessageBoardException {
		return getPersistence().findByPrimaryKey(tailgateMessageId);
	}

	/**
	* Returns the tailgate message board with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tailgateMessageId the primary key of the tailgate message board
	* @return the tailgate message board, or <code>null</code> if a tailgate message board with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateMessageBoard fetchByPrimaryKey(
		long tailgateMessageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tailgateMessageId);
	}

	/**
	* Returns all the tailgate message boards.
	*
	* @return the tailgate message boards
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tailgate message boards from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tailgate message boards.
	*
	* @return the number of tailgate message boards
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TailgateMessageBoardPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TailgateMessageBoardPersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					TailgateMessageBoardPersistence.class.getName());

			ReferenceRegistry.registerReference(TailgateMessageBoardUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TailgateMessageBoardPersistence persistence) {
	}

	private static TailgateMessageBoardPersistence _persistence;
}