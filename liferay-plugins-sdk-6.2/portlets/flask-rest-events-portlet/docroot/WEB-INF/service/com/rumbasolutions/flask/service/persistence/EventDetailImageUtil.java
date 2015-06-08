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

import com.rumbasolutions.flask.model.EventDetailImage;

import java.util.List;

/**
 * The persistence utility for the event detail image service. This utility wraps {@link EventDetailImagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see EventDetailImagePersistence
 * @see EventDetailImagePersistenceImpl
 * @generated
 */
public class EventDetailImageUtil {
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
	public static void clearCache(EventDetailImage eventDetailImage) {
		getPersistence().clearCache(eventDetailImage);
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
	public static List<EventDetailImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EventDetailImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EventDetailImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EventDetailImage update(EventDetailImage eventDetailImage)
		throws SystemException {
		return getPersistence().update(eventDetailImage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EventDetailImage update(EventDetailImage eventDetailImage,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(eventDetailImage, serviceContext);
	}

	/**
	* Returns all the event detail images where eventDetailId = &#63;.
	*
	* @param eventDetailId the event detail ID
	* @return the matching event detail images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.EventDetailImage> findByeventDetailId(
		long eventDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByeventDetailId(eventDetailId);
	}

	/**
	* Returns a range of all the event detail images where eventDetailId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventDetailId the event detail ID
	* @param start the lower bound of the range of event detail images
	* @param end the upper bound of the range of event detail images (not inclusive)
	* @return the range of matching event detail images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.EventDetailImage> findByeventDetailId(
		long eventDetailId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByeventDetailId(eventDetailId, start, end);
	}

	/**
	* Returns an ordered range of all the event detail images where eventDetailId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventDetailId the event detail ID
	* @param start the lower bound of the range of event detail images
	* @param end the upper bound of the range of event detail images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event detail images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.EventDetailImage> findByeventDetailId(
		long eventDetailId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByeventDetailId(eventDetailId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first event detail image in the ordered set where eventDetailId = &#63;.
	*
	* @param eventDetailId the event detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event detail image
	* @throws com.rumbasolutions.flask.NoSuchEventDetailImageException if a matching event detail image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.EventDetailImage findByeventDetailId_First(
		long eventDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailImageException {
		return getPersistence()
				   .findByeventDetailId_First(eventDetailId, orderByComparator);
	}

	/**
	* Returns the first event detail image in the ordered set where eventDetailId = &#63;.
	*
	* @param eventDetailId the event detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event detail image, or <code>null</code> if a matching event detail image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.EventDetailImage fetchByeventDetailId_First(
		long eventDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByeventDetailId_First(eventDetailId, orderByComparator);
	}

	/**
	* Returns the last event detail image in the ordered set where eventDetailId = &#63;.
	*
	* @param eventDetailId the event detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event detail image
	* @throws com.rumbasolutions.flask.NoSuchEventDetailImageException if a matching event detail image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.EventDetailImage findByeventDetailId_Last(
		long eventDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailImageException {
		return getPersistence()
				   .findByeventDetailId_Last(eventDetailId, orderByComparator);
	}

	/**
	* Returns the last event detail image in the ordered set where eventDetailId = &#63;.
	*
	* @param eventDetailId the event detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event detail image, or <code>null</code> if a matching event detail image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.EventDetailImage fetchByeventDetailId_Last(
		long eventDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByeventDetailId_Last(eventDetailId, orderByComparator);
	}

	/**
	* Returns the event detail images before and after the current event detail image in the ordered set where eventDetailId = &#63;.
	*
	* @param eventDetailImageId the primary key of the current event detail image
	* @param eventDetailId the event detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event detail image
	* @throws com.rumbasolutions.flask.NoSuchEventDetailImageException if a event detail image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.EventDetailImage[] findByeventDetailId_PrevAndNext(
		long eventDetailImageId, long eventDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailImageException {
		return getPersistence()
				   .findByeventDetailId_PrevAndNext(eventDetailImageId,
			eventDetailId, orderByComparator);
	}

	/**
	* Removes all the event detail images where eventDetailId = &#63; from the database.
	*
	* @param eventDetailId the event detail ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByeventDetailId(long eventDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByeventDetailId(eventDetailId);
	}

	/**
	* Returns the number of event detail images where eventDetailId = &#63;.
	*
	* @param eventDetailId the event detail ID
	* @return the number of matching event detail images
	* @throws SystemException if a system exception occurred
	*/
	public static int countByeventDetailId(long eventDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByeventDetailId(eventDetailId);
	}

	/**
	* Caches the event detail image in the entity cache if it is enabled.
	*
	* @param eventDetailImage the event detail image
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.EventDetailImage eventDetailImage) {
		getPersistence().cacheResult(eventDetailImage);
	}

	/**
	* Caches the event detail images in the entity cache if it is enabled.
	*
	* @param eventDetailImages the event detail images
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.EventDetailImage> eventDetailImages) {
		getPersistence().cacheResult(eventDetailImages);
	}

	/**
	* Creates a new event detail image with the primary key. Does not add the event detail image to the database.
	*
	* @param eventDetailImageId the primary key for the new event detail image
	* @return the new event detail image
	*/
	public static com.rumbasolutions.flask.model.EventDetailImage create(
		long eventDetailImageId) {
		return getPersistence().create(eventDetailImageId);
	}

	/**
	* Removes the event detail image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventDetailImageId the primary key of the event detail image
	* @return the event detail image that was removed
	* @throws com.rumbasolutions.flask.NoSuchEventDetailImageException if a event detail image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.EventDetailImage remove(
		long eventDetailImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailImageException {
		return getPersistence().remove(eventDetailImageId);
	}

	public static com.rumbasolutions.flask.model.EventDetailImage updateImpl(
		com.rumbasolutions.flask.model.EventDetailImage eventDetailImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(eventDetailImage);
	}

	/**
	* Returns the event detail image with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchEventDetailImageException} if it could not be found.
	*
	* @param eventDetailImageId the primary key of the event detail image
	* @return the event detail image
	* @throws com.rumbasolutions.flask.NoSuchEventDetailImageException if a event detail image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.EventDetailImage findByPrimaryKey(
		long eventDetailImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchEventDetailImageException {
		return getPersistence().findByPrimaryKey(eventDetailImageId);
	}

	/**
	* Returns the event detail image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventDetailImageId the primary key of the event detail image
	* @return the event detail image, or <code>null</code> if a event detail image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.EventDetailImage fetchByPrimaryKey(
		long eventDetailImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eventDetailImageId);
	}

	/**
	* Returns all the event detail images.
	*
	* @return the event detail images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.EventDetailImage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the event detail images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event detail images
	* @param end the upper bound of the range of event detail images (not inclusive)
	* @return the range of event detail images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.EventDetailImage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the event detail images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event detail images
	* @param end the upper bound of the range of event detail images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of event detail images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.EventDetailImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the event detail images from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of event detail images.
	*
	* @return the number of event detail images
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EventDetailImagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EventDetailImagePersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					EventDetailImagePersistence.class.getName());

			ReferenceRegistry.registerReference(EventDetailImageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EventDetailImagePersistence persistence) {
	}

	private static EventDetailImagePersistence _persistence;
}