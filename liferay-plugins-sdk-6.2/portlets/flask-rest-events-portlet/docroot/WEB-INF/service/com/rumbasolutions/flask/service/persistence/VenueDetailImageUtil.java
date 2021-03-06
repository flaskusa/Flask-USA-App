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

import com.rumbasolutions.flask.model.VenueDetailImage;

import java.util.List;

/**
 * The persistence utility for the venue detail image service. This utility wraps {@link VenueDetailImagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see VenueDetailImagePersistence
 * @see VenueDetailImagePersistenceImpl
 * @generated
 */
public class VenueDetailImageUtil {
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
	public static void clearCache(VenueDetailImage venueDetailImage) {
		getPersistence().clearCache(venueDetailImage);
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
	public static List<VenueDetailImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VenueDetailImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VenueDetailImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static VenueDetailImage update(VenueDetailImage venueDetailImage)
		throws SystemException {
		return getPersistence().update(venueDetailImage);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static VenueDetailImage update(VenueDetailImage venueDetailImage,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(venueDetailImage, serviceContext);
	}

	/**
	* Returns all the venue detail images where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @return the matching venue detail images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> findByVenueDetailId(
		long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVenueDetailId(venueDetailId);
	}

	/**
	* Returns a range of all the venue detail images where venueDetailId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueDetailId the venue detail ID
	* @param start the lower bound of the range of venue detail images
	* @param end the upper bound of the range of venue detail images (not inclusive)
	* @return the range of matching venue detail images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> findByVenueDetailId(
		long venueDetailId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVenueDetailId(venueDetailId, start, end);
	}

	/**
	* Returns an ordered range of all the venue detail images where venueDetailId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param venueDetailId the venue detail ID
	* @param start the lower bound of the range of venue detail images
	* @param end the upper bound of the range of venue detail images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching venue detail images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> findByVenueDetailId(
		long venueDetailId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVenueDetailId(venueDetailId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first venue detail image in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue detail image
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailImageException if a matching venue detail image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDetailImage findByVenueDetailId_First(
		long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailImageException {
		return getPersistence()
				   .findByVenueDetailId_First(venueDetailId, orderByComparator);
	}

	/**
	* Returns the first venue detail image in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching venue detail image, or <code>null</code> if a matching venue detail image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDetailImage fetchByVenueDetailId_First(
		long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVenueDetailId_First(venueDetailId, orderByComparator);
	}

	/**
	* Returns the last venue detail image in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue detail image
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailImageException if a matching venue detail image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDetailImage findByVenueDetailId_Last(
		long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailImageException {
		return getPersistence()
				   .findByVenueDetailId_Last(venueDetailId, orderByComparator);
	}

	/**
	* Returns the last venue detail image in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching venue detail image, or <code>null</code> if a matching venue detail image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDetailImage fetchByVenueDetailId_Last(
		long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVenueDetailId_Last(venueDetailId, orderByComparator);
	}

	/**
	* Returns the venue detail images before and after the current venue detail image in the ordered set where venueDetailId = &#63;.
	*
	* @param venueDetailImageId the primary key of the current venue detail image
	* @param venueDetailId the venue detail ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next venue detail image
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailImageException if a venue detail image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDetailImage[] findByVenueDetailId_PrevAndNext(
		long venueDetailImageId, long venueDetailId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailImageException {
		return getPersistence()
				   .findByVenueDetailId_PrevAndNext(venueDetailImageId,
			venueDetailId, orderByComparator);
	}

	/**
	* Removes all the venue detail images where venueDetailId = &#63; from the database.
	*
	* @param venueDetailId the venue detail ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVenueDetailId(long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVenueDetailId(venueDetailId);
	}

	/**
	* Returns the number of venue detail images where venueDetailId = &#63;.
	*
	* @param venueDetailId the venue detail ID
	* @return the number of matching venue detail images
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVenueDetailId(long venueDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVenueDetailId(venueDetailId);
	}

	/**
	* Caches the venue detail image in the entity cache if it is enabled.
	*
	* @param venueDetailImage the venue detail image
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.VenueDetailImage venueDetailImage) {
		getPersistence().cacheResult(venueDetailImage);
	}

	/**
	* Caches the venue detail images in the entity cache if it is enabled.
	*
	* @param venueDetailImages the venue detail images
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> venueDetailImages) {
		getPersistence().cacheResult(venueDetailImages);
	}

	/**
	* Creates a new venue detail image with the primary key. Does not add the venue detail image to the database.
	*
	* @param venueDetailImageId the primary key for the new venue detail image
	* @return the new venue detail image
	*/
	public static com.rumbasolutions.flask.model.VenueDetailImage create(
		long venueDetailImageId) {
		return getPersistence().create(venueDetailImageId);
	}

	/**
	* Removes the venue detail image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param venueDetailImageId the primary key of the venue detail image
	* @return the venue detail image that was removed
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailImageException if a venue detail image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDetailImage remove(
		long venueDetailImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailImageException {
		return getPersistence().remove(venueDetailImageId);
	}

	public static com.rumbasolutions.flask.model.VenueDetailImage updateImpl(
		com.rumbasolutions.flask.model.VenueDetailImage venueDetailImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(venueDetailImage);
	}

	/**
	* Returns the venue detail image with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchVenueDetailImageException} if it could not be found.
	*
	* @param venueDetailImageId the primary key of the venue detail image
	* @return the venue detail image
	* @throws com.rumbasolutions.flask.NoSuchVenueDetailImageException if a venue detail image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDetailImage findByPrimaryKey(
		long venueDetailImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchVenueDetailImageException {
		return getPersistence().findByPrimaryKey(venueDetailImageId);
	}

	/**
	* Returns the venue detail image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param venueDetailImageId the primary key of the venue detail image
	* @return the venue detail image, or <code>null</code> if a venue detail image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.VenueDetailImage fetchByPrimaryKey(
		long venueDetailImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(venueDetailImageId);
	}

	/**
	* Returns all the venue detail images.
	*
	* @return the venue detail images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the venue detail images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue detail images
	* @param end the upper bound of the range of venue detail images (not inclusive)
	* @return the range of venue detail images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the venue detail images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.VenueDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of venue detail images
	* @param end the upper bound of the range of venue detail images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of venue detail images
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the venue detail images from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of venue detail images.
	*
	* @return the number of venue detail images
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VenueDetailImagePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VenueDetailImagePersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					VenueDetailImagePersistence.class.getName());

			ReferenceRegistry.registerReference(VenueDetailImageUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(VenueDetailImagePersistence persistence) {
	}

	private static VenueDetailImagePersistence _persistence;
}