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

import com.rumbasolutions.flask.model.VenueImage;

import java.util.List;

/**
 * The persistence utility for the venue image service. This utility wraps {@link VenueImagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueImagePersistence
 * @see VenueImagePersistenceImpl
 * @generated
 */
public class VenueImageUtil {
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
	public static void clearCache(VenueImage venueImage) {
		getPersistence().clearCache(venueImage);
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
	public static List<VenueImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VenueImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VenueImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VenueImage update(VenueImage venueImage)
		throws SystemException {
		return getPersistence().update(venueImage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VenueImage update(VenueImage venueImage,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(venueImage, serviceContext);
	}

	/**
	* Returns all the venue images where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @return the matching venue images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueImage> findByvenueId(
		long venueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByvenueId(venueId);
	}

	/**
	* Returns a range of all the venue images where venueId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueId the venue ID
	* @param start the lower bound of the range of venue images
	* @param end the upper bound of the range of venue images (not inclusive)
	* @return the range of matching venue images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueImage> findByvenueId(
		long venueId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByvenueId(venueId, start, end);
	}

	/**
	* Returns an ordered range of all the venue images where venueId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueId the venue ID
	* @param start the lower bound of the range of venue images
	* @param end the upper bound of the range of venue images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching venue images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueImage> findByvenueId(
		long venueId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByvenueId(venueId, start, end, orderByComparator);
	}

	/**
	* Returns the first venue image in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue image
	* @throws com.rumbasolutions.flask.NoSuchVenueImageException if a matching venue image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueImage findByvenueId_First(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueImageException {
		return getPersistence().findByvenueId_First(venueId, orderByComparator);
	}

	/**
	* Returns the first venue image in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue image, or <code>null</code> if a matching venue image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueImage fetchByvenueId_First(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByvenueId_First(venueId, orderByComparator);
	}

	/**
	* Returns the last venue image in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue image
	* @throws com.rumbasolutions.flask.NoSuchVenueImageException if a matching venue image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueImage findByvenueId_Last(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueImageException {
		return getPersistence().findByvenueId_Last(venueId, orderByComparator);
	}

	/**
	* Returns the last venue image in the ordered set where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue image, or <code>null</code> if a matching venue image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueImage fetchByvenueId_Last(
		long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByvenueId_Last(venueId, orderByComparator);
	}

	/**
	* Returns the venue images before and after the current venue image in the ordered set where venueId = &#63;.
	*
	* @param venueImageId the primary key of the current venue image
	* @param venueId the venue ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue image
	* @throws com.rumbasolutions.flask.NoSuchVenueImageException if a venue image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueImage[] findByvenueId_PrevAndNext(
		long venueImageId, long venueId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueImageException {
		return getPersistence()
				   .findByvenueId_PrevAndNext(venueImageId, venueId,
			orderByComparator);
	}

	/**
	* Removes all the venue images where venueId = &#63; from the database.
	*
	* @param venueId the venue ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByvenueId(long venueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByvenueId(venueId);
	}

	/**
	* Returns the number of venue images where venueId = &#63;.
	*
	* @param venueId the venue ID
	* @return the number of matching venue images
	* @throws SystemException if a system exception occurred
	*/
	public static int countByvenueId(long venueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByvenueId(venueId);
	}

	/**
	* Caches the venue image in the entity cache if it is enabled.
	*
	* @param venueImage the venue image
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.VenueImage venueImage) {
		getPersistence().cacheResult(venueImage);
	}

	/**
	* Caches the venue images in the entity cache if it is enabled.
	*
	* @param venueImages the venue images
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.VenueImage> venueImages) {
		getPersistence().cacheResult(venueImages);
	}

	/**
	* Creates a new venue image with the primary key. Does not add the venue image to the database.
	*
	* @param venueImageId the primary key for the new venue image
	* @return the new venue image
	*/
	public static com.rumbasolutions.flask.model.VenueImage create(
		long venueImageId) {
		return getPersistence().create(venueImageId);
	}

	/**
	* Removes the venue image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueImageId the primary key of the venue image
	* @return the venue image that was removed
	* @throws com.rumbasolutions.flask.NoSuchVenueImageException if a venue image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueImage remove(
		long venueImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueImageException {
		return getPersistence().remove(venueImageId);
	}

	public static com.rumbasolutions.flask.model.VenueImage updateImpl(
		com.rumbasolutions.flask.model.VenueImage venueImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(venueImage);
	}

	/**
	* Returns the venue image with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueImageException} if it could not be found.
	*
	* @param venueImageId the primary key of the venue image
	* @return the venue image
	* @throws com.rumbasolutions.flask.NoSuchVenueImageException if a venue image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueImage findByPrimaryKey(
		long venueImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueImageException {
		return getPersistence().findByPrimaryKey(venueImageId);
	}

	/**
	* Returns the venue image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param venueImageId the primary key of the venue image
	* @return the venue image, or <code>null</code> if a venue image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueImage fetchByPrimaryKey(
		long venueImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(venueImageId);
	}

	/**
	* Returns all the venue images.
	*
	* @return the venue images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueImage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the venue images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue images
	* @param end the upper bound of the range of venue images (not inclusive)
	* @return the range of venue images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueImage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the venue images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue images
	* @param end the upper bound of the range of venue images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of venue images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the venue images from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of venue images.
	*
	* @return the number of venue images
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VenueImagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VenueImagePersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					VenueImagePersistence.class.getName());

			ReferenceRegistry.registerReference(VenueImageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VenueImagePersistence persistence) {
	}

	private static VenueImagePersistence _persistence;
}