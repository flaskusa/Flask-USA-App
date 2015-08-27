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

import com.rumbasolutions.flask.model.TailgateImages;

import java.util.List;

/**
 * The persistence utility for the tailgate images service. This utility wraps {@link TailgateImagesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rajeshj
 * @see TailgateImagesPersistence
 * @see TailgateImagesPersistenceImpl
 * @generated
 */
public class TailgateImagesUtil {
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
	public static void clearCache(TailgateImages tailgateImages) {
		getPersistence().clearCache(tailgateImages);
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
	public static List<TailgateImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TailgateImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TailgateImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TailgateImages update(TailgateImages tailgateImages)
		throws SystemException {
		return getPersistence().update(tailgateImages);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TailgateImages update(TailgateImages tailgateImages,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tailgateImages, serviceContext);
	}

	/**
	* Returns all the tailgate imageses where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @return the matching tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateImages> findBytailgateId(
		long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytailgateId(tailgateId);
	}

	/**
	* Returns a range of all the tailgate imageses where tailgateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tailgateId the tailgate ID
	* @param start the lower bound of the range of tailgate imageses
	* @param end the upper bound of the range of tailgate imageses (not inclusive)
	* @return the range of matching tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateImages> findBytailgateId(
		long tailgateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytailgateId(tailgateId, start, end);
	}

	/**
	* Returns an ordered range of all the tailgate imageses where tailgateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param tailgateId the tailgate ID
	* @param start the lower bound of the range of tailgate imageses
	* @param end the upper bound of the range of tailgate imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateImages> findBytailgateId(
		long tailgateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBytailgateId(tailgateId, start, end, orderByComparator);
	}

	/**
	* Returns the first tailgate images in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate images
	* @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a matching tailgate images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateImages findBytailgateId_First(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateImagesException {
		return getPersistence()
				   .findBytailgateId_First(tailgateId, orderByComparator);
	}

	/**
	* Returns the first tailgate images in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate images, or <code>null</code> if a matching tailgate images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateImages fetchBytailgateId_First(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBytailgateId_First(tailgateId, orderByComparator);
	}

	/**
	* Returns the last tailgate images in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate images
	* @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a matching tailgate images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateImages findBytailgateId_Last(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateImagesException {
		return getPersistence()
				   .findBytailgateId_Last(tailgateId, orderByComparator);
	}

	/**
	* Returns the last tailgate images in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate images, or <code>null</code> if a matching tailgate images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateImages fetchBytailgateId_Last(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBytailgateId_Last(tailgateId, orderByComparator);
	}

	/**
	* Returns the tailgate imageses before and after the current tailgate images in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateImageId the primary key of the current tailgate images
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tailgate images
	* @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a tailgate images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateImages[] findBytailgateId_PrevAndNext(
		long tailgateImageId, long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateImagesException {
		return getPersistence()
				   .findBytailgateId_PrevAndNext(tailgateImageId, tailgateId,
			orderByComparator);
	}

	/**
	* Removes all the tailgate imageses where tailgateId = &#63; from the database.
	*
	* @param tailgateId the tailgate ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBytailgateId(long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBytailgateId(tailgateId);
	}

	/**
	* Returns the number of tailgate imageses where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @return the number of matching tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBytailgateId(long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBytailgateId(tailgateId);
	}

	/**
	* Caches the tailgate images in the entity cache if it is enabled.
	*
	* @param tailgateImages the tailgate images
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.TailgateImages tailgateImages) {
		getPersistence().cacheResult(tailgateImages);
	}

	/**
	* Caches the tailgate imageses in the entity cache if it is enabled.
	*
	* @param tailgateImageses the tailgate imageses
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.TailgateImages> tailgateImageses) {
		getPersistence().cacheResult(tailgateImageses);
	}

	/**
	* Creates a new tailgate images with the primary key. Does not add the tailgate images to the database.
	*
	* @param tailgateImageId the primary key for the new tailgate images
	* @return the new tailgate images
	*/
	public static com.rumbasolutions.flask.model.TailgateImages create(
		long tailgateImageId) {
		return getPersistence().create(tailgateImageId);
	}

	/**
	* Removes the tailgate images with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateImageId the primary key of the tailgate images
	* @return the tailgate images that was removed
	* @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a tailgate images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateImages remove(
		long tailgateImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateImagesException {
		return getPersistence().remove(tailgateImageId);
	}

	public static com.rumbasolutions.flask.model.TailgateImages updateImpl(
		com.rumbasolutions.flask.model.TailgateImages tailgateImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tailgateImages);
	}

	/**
	* Returns the tailgate images with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchTailgateImagesException} if it could not be found.
	*
	* @param tailgateImageId the primary key of the tailgate images
	* @return the tailgate images
	* @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a tailgate images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateImages findByPrimaryKey(
		long tailgateImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateImagesException {
		return getPersistence().findByPrimaryKey(tailgateImageId);
	}

	/**
	* Returns the tailgate images with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tailgateImageId the primary key of the tailgate images
	* @return the tailgate images, or <code>null</code> if a tailgate images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.TailgateImages fetchByPrimaryKey(
		long tailgateImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(tailgateImageId);
	}

	/**
	* Returns all the tailgate imageses.
	*
	* @return the tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateImages> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the tailgate imageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tailgate imageses
	* @param end the upper bound of the range of tailgate imageses (not inclusive)
	* @return the range of tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateImages> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tailgate imageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tailgate imageses
	* @param end the upper bound of the range of tailgate imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.TailgateImages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tailgate imageses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tailgate imageses.
	*
	* @return the number of tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TailgateImagesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TailgateImagesPersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					TailgateImagesPersistence.class.getName());

			ReferenceRegistry.registerReference(TailgateImagesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TailgateImagesPersistence persistence) {
	}

	private static TailgateImagesPersistence _persistence;
}