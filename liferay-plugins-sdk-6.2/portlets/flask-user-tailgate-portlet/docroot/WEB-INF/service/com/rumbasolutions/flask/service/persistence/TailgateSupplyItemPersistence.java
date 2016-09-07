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

import com.rumbasolutions.flask.model.TailgateSupplyItem;

/**
 * The persistence interface for the tailgate supply item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TailgateSupplyItemPersistenceImpl
 * @see TailgateSupplyItemUtil
 * @generated
 */
public interface TailgateSupplyItemPersistence extends BasePersistence<TailgateSupplyItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TailgateSupplyItemUtil} to access the tailgate supply item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tailgate supply items where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @return the matching tailgate supply items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> findBytailgateId(
		long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tailgate supply items where tailgateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateSupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tailgateId the tailgate ID
	* @param start the lower bound of the range of tailgate supply items
	* @param end the upper bound of the range of tailgate supply items (not inclusive)
	* @return the range of matching tailgate supply items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> findBytailgateId(
		long tailgateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tailgate supply items where tailgateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateSupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tailgateId the tailgate ID
	* @param start the lower bound of the range of tailgate supply items
	* @param end the upper bound of the range of tailgate supply items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tailgate supply items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> findBytailgateId(
		long tailgateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tailgate supply item in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate supply item
	* @throws com.rumbasolutions.flask.NoSuchTailgateSupplyItemException if a matching tailgate supply item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateSupplyItem findBytailgateId_First(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateSupplyItemException;

	/**
	* Returns the first tailgate supply item in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate supply item, or <code>null</code> if a matching tailgate supply item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateSupplyItem fetchBytailgateId_First(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tailgate supply item in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate supply item
	* @throws com.rumbasolutions.flask.NoSuchTailgateSupplyItemException if a matching tailgate supply item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateSupplyItem findBytailgateId_Last(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateSupplyItemException;

	/**
	* Returns the last tailgate supply item in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate supply item, or <code>null</code> if a matching tailgate supply item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateSupplyItem fetchBytailgateId_Last(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tailgate supply items before and after the current tailgate supply item in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateSupplyItemId the primary key of the current tailgate supply item
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tailgate supply item
	* @throws com.rumbasolutions.flask.NoSuchTailgateSupplyItemException if a tailgate supply item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateSupplyItem[] findBytailgateId_PrevAndNext(
		long tailgateSupplyItemId, long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateSupplyItemException;

	/**
	* Removes all the tailgate supply items where tailgateId = &#63; from the database.
	*
	* @param tailgateId the tailgate ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBytailgateId(long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tailgate supply items where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @return the number of matching tailgate supply items
	* @throws SystemException if a system exception occurred
	*/
	public int countBytailgateId(long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the tailgate supply item in the entity cache if it is enabled.
	*
	* @param tailgateSupplyItem the tailgate supply item
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.TailgateSupplyItem tailgateSupplyItem);

	/**
	* Caches the tailgate supply items in the entity cache if it is enabled.
	*
	* @param tailgateSupplyItems the tailgate supply items
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> tailgateSupplyItems);

	/**
	* Creates a new tailgate supply item with the primary key. Does not add the tailgate supply item to the database.
	*
	* @param tailgateSupplyItemId the primary key for the new tailgate supply item
	* @return the new tailgate supply item
	*/
	public com.rumbasolutions.flask.model.TailgateSupplyItem create(
		long tailgateSupplyItemId);

	/**
	* Removes the tailgate supply item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateSupplyItemId the primary key of the tailgate supply item
	* @return the tailgate supply item that was removed
	* @throws com.rumbasolutions.flask.NoSuchTailgateSupplyItemException if a tailgate supply item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateSupplyItem remove(
		long tailgateSupplyItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateSupplyItemException;

	public com.rumbasolutions.flask.model.TailgateSupplyItem updateImpl(
		com.rumbasolutions.flask.model.TailgateSupplyItem tailgateSupplyItem)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tailgate supply item with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchTailgateSupplyItemException} if it could not be found.
	*
	* @param tailgateSupplyItemId the primary key of the tailgate supply item
	* @return the tailgate supply item
	* @throws com.rumbasolutions.flask.NoSuchTailgateSupplyItemException if a tailgate supply item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateSupplyItem findByPrimaryKey(
		long tailgateSupplyItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateSupplyItemException;

	/**
	* Returns the tailgate supply item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tailgateSupplyItemId the primary key of the tailgate supply item
	* @return the tailgate supply item, or <code>null</code> if a tailgate supply item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateSupplyItem fetchByPrimaryKey(
		long tailgateSupplyItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tailgate supply items.
	*
	* @return the tailgate supply items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tailgate supply items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateSupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tailgate supply items
	* @param end the upper bound of the range of tailgate supply items (not inclusive)
	* @return the range of tailgate supply items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tailgate supply items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateSupplyItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tailgate supply items
	* @param end the upper bound of the range of tailgate supply items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tailgate supply items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tailgate supply items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tailgate supply items.
	*
	* @return the number of tailgate supply items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}