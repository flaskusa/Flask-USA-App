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

import com.rumbasolutions.flask.model.CampaignImages;

import java.util.List;

/**
 * The persistence utility for the campaign images service. This utility wraps {@link CampaignImagesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignImagesPersistence
 * @see CampaignImagesPersistenceImpl
 * @generated
 */
public class CampaignImagesUtil {
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
	public static void clearCache(CampaignImages campaignImages) {
		getPersistence().clearCache(campaignImages);
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
	public static List<CampaignImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CampaignImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CampaignImages> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CampaignImages update(CampaignImages campaignImages)
		throws SystemException {
		return getPersistence().update(campaignImages);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CampaignImages update(CampaignImages campaignImages,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(campaignImages, serviceContext);
	}

	/**
	* Returns the campaign images where imageUUID = &#63; or throws a {@link com.rumbasolutions.flask.NoSuchCampaignImagesException} if it could not be found.
	*
	* @param imageUUID the image u u i d
	* @return the matching campaign images
	* @throws com.rumbasolutions.flask.NoSuchCampaignImagesException if a matching campaign images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignImages findByimageUUID(
		java.lang.String imageUUID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignImagesException {
		return getPersistence().findByimageUUID(imageUUID);
	}

	/**
	* Returns the campaign images where imageUUID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param imageUUID the image u u i d
	* @return the matching campaign images, or <code>null</code> if a matching campaign images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignImages fetchByimageUUID(
		java.lang.String imageUUID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByimageUUID(imageUUID);
	}

	/**
	* Returns the campaign images where imageUUID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param imageUUID the image u u i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching campaign images, or <code>null</code> if a matching campaign images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignImages fetchByimageUUID(
		java.lang.String imageUUID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByimageUUID(imageUUID, retrieveFromCache);
	}

	/**
	* Removes the campaign images where imageUUID = &#63; from the database.
	*
	* @param imageUUID the image u u i d
	* @return the campaign images that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignImages removeByimageUUID(
		java.lang.String imageUUID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignImagesException {
		return getPersistence().removeByimageUUID(imageUUID);
	}

	/**
	* Returns the number of campaign imageses where imageUUID = &#63;.
	*
	* @param imageUUID the image u u i d
	* @return the number of matching campaign imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByimageUUID(java.lang.String imageUUID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByimageUUID(imageUUID);
	}

	/**
	* Caches the campaign images in the entity cache if it is enabled.
	*
	* @param campaignImages the campaign images
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.CampaignImages campaignImages) {
		getPersistence().cacheResult(campaignImages);
	}

	/**
	* Caches the campaign imageses in the entity cache if it is enabled.
	*
	* @param campaignImageses the campaign imageses
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.CampaignImages> campaignImageses) {
		getPersistence().cacheResult(campaignImageses);
	}

	/**
	* Creates a new campaign images with the primary key. Does not add the campaign images to the database.
	*
	* @param campaignImageId the primary key for the new campaign images
	* @return the new campaign images
	*/
	public static com.rumbasolutions.flask.model.CampaignImages create(
		long campaignImageId) {
		return getPersistence().create(campaignImageId);
	}

	/**
	* Removes the campaign images with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignImageId the primary key of the campaign images
	* @return the campaign images that was removed
	* @throws com.rumbasolutions.flask.NoSuchCampaignImagesException if a campaign images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignImages remove(
		long campaignImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignImagesException {
		return getPersistence().remove(campaignImageId);
	}

	public static com.rumbasolutions.flask.model.CampaignImages updateImpl(
		com.rumbasolutions.flask.model.CampaignImages campaignImages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(campaignImages);
	}

	/**
	* Returns the campaign images with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchCampaignImagesException} if it could not be found.
	*
	* @param campaignImageId the primary key of the campaign images
	* @return the campaign images
	* @throws com.rumbasolutions.flask.NoSuchCampaignImagesException if a campaign images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignImages findByPrimaryKey(
		long campaignImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignImagesException {
		return getPersistence().findByPrimaryKey(campaignImageId);
	}

	/**
	* Returns the campaign images with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignImageId the primary key of the campaign images
	* @return the campaign images, or <code>null</code> if a campaign images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignImages fetchByPrimaryKey(
		long campaignImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(campaignImageId);
	}

	/**
	* Returns all the campaign imageses.
	*
	* @return the campaign imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.CampaignImages> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the campaign imageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign imageses
	* @param end the upper bound of the range of campaign imageses (not inclusive)
	* @return the range of campaign imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.CampaignImages> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the campaign imageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign imageses
	* @param end the upper bound of the range of campaign imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of campaign imageses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.CampaignImages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the campaign imageses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of campaign imageses.
	*
	* @return the number of campaign imageses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CampaignImagesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CampaignImagesPersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					CampaignImagesPersistence.class.getName());

			ReferenceRegistry.registerReference(CampaignImagesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CampaignImagesPersistence persistence) {
	}

	private static CampaignImagesPersistence _persistence;
}