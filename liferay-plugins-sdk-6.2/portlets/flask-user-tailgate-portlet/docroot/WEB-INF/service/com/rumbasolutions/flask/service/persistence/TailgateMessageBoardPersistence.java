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

import com.liferay.portal.service.persistence.BasePersistence;

import com.rumbasolutions.flask.model.TailgateMessageBoard;

/**
 * The persistence interface for the tailgate message board service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TailgateMessageBoardPersistenceImpl
 * @see TailgateMessageBoardUtil
 * @generated
 */
public interface TailgateMessageBoardPersistence extends BasePersistence<TailgateMessageBoard> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TailgateMessageBoardUtil} to access the tailgate message board persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tailgate message boards where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @return the matching tailgate message boards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> findBytailgateId(
		long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> findBytailgateId(
		long tailgateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> findBytailgateId(
		long tailgateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tailgate message board in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate message board
	* @throws com.rumbasolutions.flask.NoSuchTailgateMessageBoardException if a matching tailgate message board could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateMessageBoard findBytailgateId_First(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMessageBoardException;

	/**
	* Returns the first tailgate message board in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate message board, or <code>null</code> if a matching tailgate message board could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateMessageBoard fetchBytailgateId_First(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tailgate message board in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate message board
	* @throws com.rumbasolutions.flask.NoSuchTailgateMessageBoardException if a matching tailgate message board could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateMessageBoard findBytailgateId_Last(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMessageBoardException;

	/**
	* Returns the last tailgate message board in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate message board, or <code>null</code> if a matching tailgate message board could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateMessageBoard fetchBytailgateId_Last(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rumbasolutions.flask.model.TailgateMessageBoard[] findBytailgateId_PrevAndNext(
		long tailgateMessageId, long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMessageBoardException;

	/**
	* Removes all the tailgate message boards where tailgateId = &#63; from the database.
	*
	* @param tailgateId the tailgate ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBytailgateId(long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tailgate message boards where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @return the number of matching tailgate message boards
	* @throws SystemException if a system exception occurred
	*/
	public int countBytailgateId(long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the tailgate message board in the entity cache if it is enabled.
	*
	* @param tailgateMessageBoard the tailgate message board
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.TailgateMessageBoard tailgateMessageBoard);

	/**
	* Caches the tailgate message boards in the entity cache if it is enabled.
	*
	* @param tailgateMessageBoards the tailgate message boards
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> tailgateMessageBoards);

	/**
	* Creates a new tailgate message board with the primary key. Does not add the tailgate message board to the database.
	*
	* @param tailgateMessageId the primary key for the new tailgate message board
	* @return the new tailgate message board
	*/
	public com.rumbasolutions.flask.model.TailgateMessageBoard create(
		long tailgateMessageId);

	/**
	* Removes the tailgate message board with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateMessageId the primary key of the tailgate message board
	* @return the tailgate message board that was removed
	* @throws com.rumbasolutions.flask.NoSuchTailgateMessageBoardException if a tailgate message board with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateMessageBoard remove(
		long tailgateMessageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMessageBoardException;

	public com.rumbasolutions.flask.model.TailgateMessageBoard updateImpl(
		com.rumbasolutions.flask.model.TailgateMessageBoard tailgateMessageBoard)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tailgate message board with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchTailgateMessageBoardException} if it could not be found.
	*
	* @param tailgateMessageId the primary key of the tailgate message board
	* @return the tailgate message board
	* @throws com.rumbasolutions.flask.NoSuchTailgateMessageBoardException if a tailgate message board with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateMessageBoard findByPrimaryKey(
		long tailgateMessageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateMessageBoardException;

	/**
	* Returns the tailgate message board with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tailgateMessageId the primary key of the tailgate message board
	* @return the tailgate message board, or <code>null</code> if a tailgate message board with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateMessageBoard fetchByPrimaryKey(
		long tailgateMessageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tailgate message boards.
	*
	* @return the tailgate message boards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.TailgateMessageBoard> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tailgate message boards from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tailgate message boards.
	*
	* @return the number of tailgate message boards
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}