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

import com.rumbasolutions.flask.model.CampaignImages;

/**
 * The persistence interface for the campaign images service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignImagesPersistenceImpl
 * @see CampaignImagesUtil
 * @generated
 */
public interface CampaignImagesPersistence extends BasePersistence<CampaignImages> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CampaignImagesUtil} to access the campaign images persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the campaign images where imageUUID = &#63; or throws a {@link com.rumbasolutions.flask.NoSuchCampaignImagesException} if it could not be found.
	*
	* @param imageUUID the image u u i d
	* @return the matching campaign images
	* @throws com.rumbasolutions.flask.NoSuchCampaignImagesException if a matching campaign images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.CampaignImages findByimageUUID(
		java.lang.String imageUUID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignImagesException;

	/**
	* Returns the campaign images where imageUUID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param imageUUID the image u u i d
	* @return the matching campaign images, or <code>null</code> if a matching campaign images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.CampaignImages fetchByimageUUID(
		java.lang.String imageUUID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign images where imageUUID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param imageUUID the image u u i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching campaign images, or <code>null</code> if a matching campaign images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.CampaignImages fetchByimageUUID(
		java.lang.String imageUUID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the campaign images where imageUUID = &#63; from the database.
	*
	* @param imageUUID the image u u i d
	* @return the campaign images that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.CampaignImages removeByimageUUID(
		java.lang.String imageUUID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignImagesException;

	/**
	* Returns the number of campaign imageses where imageUUID = &#63;.
	*
	* @param imageUUID the image u u i d
	* @return the number of matching campaign imageses
	* @throws SystemException if a system exception occurred
	*/
	public int countByimageUUID(java.lang.String imageUUID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the campaign images in the entity cache if it is enabled.
	*
	* @param campaignImages the campaign images
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.CampaignImages campaignImages);

	/**
	* Caches the campaign imageses in the entity cache if it is enabled.
	*
	* @param campaignImageses the campaign imageses
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.CampaignImages> campaignImageses);

	/**
	* Creates a new campaign images with the primary key. Does not add the campaign images to the database.
	*
	* @param campaignImageId the primary key for the new campaign images
	* @return the new campaign images
	*/
	public com.rumbasolutions.flask.model.CampaignImages create(
		long campaignImageId);

	/**
	* Removes the campaign images with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignImageId the primary key of the campaign images
	* @return the campaign images that was removed
	* @throws com.rumbasolutions.flask.NoSuchCampaignImagesException if a campaign images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.CampaignImages remove(
		long campaignImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignImagesException;

	public com.rumbasolutions.flask.model.CampaignImages updateImpl(
		com.rumbasolutions.flask.model.CampaignImages campaignImages)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign images with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchCampaignImagesException} if it could not be found.
	*
	* @param campaignImageId the primary key of the campaign images
	* @return the campaign images
	* @throws com.rumbasolutions.flask.NoSuchCampaignImagesException if a campaign images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.CampaignImages findByPrimaryKey(
		long campaignImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignImagesException;

	/**
	* Returns the campaign images with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignImageId the primary key of the campaign images
	* @return the campaign images, or <code>null</code> if a campaign images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.CampaignImages fetchByPrimaryKey(
		long campaignImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the campaign imageses.
	*
	* @return the campaign imageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.CampaignImages> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.CampaignImages> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.CampaignImages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the campaign imageses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of campaign imageses.
	*
	* @return the number of campaign imageses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}