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

import com.rumbasolutions.flask.model.TailgateSupplyItem;

import java.util.List;

/**
 * The persistence utility for the tailgate supply item service. This utility wraps {@link TailgateSupplyItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TailgateSupplyItemPersistence
 * @see TailgateSupplyItemPersistenceImpl
 * @generated
 */
public class TailgateSupplyItemUtil {
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
	public static void clearCache(TailgateSupplyItem tailgateSupplyItem) {
		getPersistence().clearCache(tailgateSupplyItem);
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
	public static List<TailgateSupplyItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TailgateSupplyItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TailgateSupplyItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TailgateSupplyItem update(
		TailgateSupplyItem tailgateSupplyItem) throws SystemException {
		return getPersistence().update(tailgateSupplyItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TailgateSupplyItem update(
		TailgateSupplyItem tailgateSupplyItem, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(tailgateSupplyItem, serviceContext);
	}

	/**
	* Returns all the tailgate supply items where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @return the matching tailgate supply items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> findBytailgateId(
		long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytailgateId(tailgateId);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> findBytailgateId(
		long tailgateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytailgateId(tailgateId, start, end);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> findBytailgateId(
		long tailgateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBytailgateId(tailgateId, start, end, orderByComparator);
	}

	/**
	* Returns the first tailgate supply item in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate supply item
	* @throws com.rumbasolutions.flask.NoSuchTailgateSupplyItemException if a matching tailgate supply item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateSupplyItem findBytailgateId_First(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateSupplyItemException {
		return getPersistence()
				   .findBytailgateId_First(tailgateId, orderByComparator);
	}

	/**
	* Returns the first tailgate supply item in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate supply item, or <code>null</code> if a matching tailgate supply item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateSupplyItem fetchBytailgateId_First(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBytailgateId_First(tailgateId, orderByComparator);
	}

	/**
	* Returns the last tailgate supply item in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate supply item
	* @throws com.rumbasolutions.flask.NoSuchTailgateSupplyItemException if a matching tailgate supply item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateSupplyItem findBytailgateId_Last(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateSupplyItemException {
		return getPersistence()
				   .findBytailgateId_Last(tailgateId, orderByComparator);
	}

	/**
	* Returns the last tailgate supply item in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate supply item, or <code>null</code> if a matching tailgate supply item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateSupplyItem fetchBytailgateId_Last(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBytailgateId_Last(tailgateId, orderByComparator);
	}

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
	public static com.rumbasolutions.flask.model.TailgateSupplyItem[] findBytailgateId_PrevAndNext(
		long tailgateSupplyItemId, long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateSupplyItemException {
		return getPersistence()
				   .findBytailgateId_PrevAndNext(tailgateSupplyItemId,
			tailgateId, orderByComparator);
	}

	/**
	* Removes all the tailgate supply items where tailgateId = &#63; from the database.
	*
	* @param tailgateId the tailgate ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBytailgateId(long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBytailgateId(tailgateId);
	}

	/**
	* Returns the number of tailgate supply items where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @return the number of matching tailgate supply items
	* @throws SystemException if a system exception occurred
	*/
	public static int countBytailgateId(long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBytailgateId(tailgateId);
	}

	/**
	* Caches the tailgate supply item in the entity cache if it is enabled.
	*
	* @param tailgateSupplyItem the tailgate supply item
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.TailgateSupplyItem tailgateSupplyItem) {
		getPersistence().cacheResult(tailgateSupplyItem);
	}

	/**
	* Caches the tailgate supply items in the entity cache if it is enabled.
	*
	* @param tailgateSupplyItems the tailgate supply items
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> tailgateSupplyItems) {
		getPersistence().cacheResult(tailgateSupplyItems);
	}

	/**
	* Creates a new tailgate supply item with the primary key. Does not add the tailgate supply item to the database.
	*
	* @param tailgateSupplyItemId the primary key for the new tailgate supply item
	* @return the new tailgate supply item
	*/
	public static com.rumbasolutions.flask.model.TailgateSupplyItem create(
		long tailgateSupplyItemId) {
		return getPersistence().create(tailgateSupplyItemId);
	}

	/**
	* Removes the tailgate supply item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateSupplyItemId the primary key of the tailgate supply item
	* @return the tailgate supply item that was removed
	* @throws com.rumbasolutions.flask.NoSuchTailgateSupplyItemException if a tailgate supply item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateSupplyItem remove(
		long tailgateSupplyItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateSupplyItemException {
		return getPersistence().remove(tailgateSupplyItemId);
	}

	public static com.rumbasolutions.flask.model.TailgateSupplyItem updateImpl(
		com.rumbasolutions.flask.model.TailgateSupplyItem tailgateSupplyItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tailgateSupplyItem);
	}

	/**
	* Returns the tailgate supply item with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchTailgateSupplyItemException} if it could not be found.
	*
	* @param tailgateSupplyItemId the primary key of the tailgate supply item
	* @return the tailgate supply item
	* @throws com.rumbasolutions.flask.NoSuchTailgateSupplyItemException if a tailgate supply item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateSupplyItem findByPrimaryKey(
		long tailgateSupplyItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateSupplyItemException {
		return getPersistence().findByPrimaryKey(tailgateSupplyItemId);
	}

	/**
	* Returns the tailgate supply item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tailgateSupplyItemId the primary key of the tailgate supply item
	* @return the tailgate supply item, or <code>null</code> if a tailgate supply item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateSupplyItem fetchByPrimaryKey(
		long tailgateSupplyItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tailgateSupplyItemId);
	}

	/**
	* Returns all the tailgate supply items.
	*
	* @return the tailgate supply items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.TailgateSupplyItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tailgate supply items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tailgate supply items.
	*
	* @return the number of tailgate supply items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TailgateSupplyItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TailgateSupplyItemPersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					TailgateSupplyItemPersistence.class.getName());

			ReferenceRegistry.registerReference(TailgateSupplyItemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TailgateSupplyItemPersistence persistence) {
	}

	private static TailgateSupplyItemPersistence _persistence;
}