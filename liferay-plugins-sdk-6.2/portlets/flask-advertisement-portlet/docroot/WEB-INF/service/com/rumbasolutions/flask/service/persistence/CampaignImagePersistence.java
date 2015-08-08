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

import com.rumbasolutions.flask.model.CampaignImage;

/**
 * The persistence interface for the campaign image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignImagePersistenceImpl
 * @see CampaignImageUtil
 * @generated
 */
public interface CampaignImagePersistence extends BasePersistence<CampaignImage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CampaignImageUtil} to access the campaign image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the campaign image where imageUUID = &#63; or throws a {@link com.rumbasolutions.flask.NoSuchCampaignImageException} if it could not be found.
	*
	* @param imageUUID the image u u i d
	* @return the matching campaign image
	* @throws com.rumbasolutions.flask.NoSuchCampaignImageException if a matching campaign image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.CampaignImage findByimageUUID(
		java.lang.String imageUUID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignImageException;

	/**
	* Returns the campaign image where imageUUID = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param imageUUID the image u u i d
	* @return the matching campaign image, or <code>null</code> if a matching campaign image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.CampaignImage fetchByimageUUID(
		java.lang.String imageUUID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign image where imageUUID = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param imageUUID the image u u i d
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching campaign image, or <code>null</code> if a matching campaign image could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.CampaignImage fetchByimageUUID(
		java.lang.String imageUUID, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the campaign image where imageUUID = &#63; from the database.
	*
	* @param imageUUID the image u u i d
	* @return the campaign image that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.CampaignImage removeByimageUUID(
		java.lang.String imageUUID)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignImageException;

	/**
	* Returns the number of campaign images where imageUUID = &#63;.
	*
	* @param imageUUID the image u u i d
	* @return the number of matching campaign images
	* @throws SystemException if a system exception occurred
	*/
	public int countByimageUUID(java.lang.String imageUUID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the campaign image in the entity cache if it is enabled.
	*
	* @param campaignImage the campaign image
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.CampaignImage campaignImage);

	/**
	* Caches the campaign images in the entity cache if it is enabled.
	*
	* @param campaignImages the campaign images
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.CampaignImage> campaignImages);

	/**
	* Creates a new campaign image with the primary key. Does not add the campaign image to the database.
	*
	* @param campaignImageId the primary key for the new campaign image
	* @return the new campaign image
	*/
	public com.rumbasolutions.flask.model.CampaignImage create(
		long campaignImageId);

	/**
	* Removes the campaign image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignImageId the primary key of the campaign image
	* @return the campaign image that was removed
	* @throws com.rumbasolutions.flask.NoSuchCampaignImageException if a campaign image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.CampaignImage remove(
		long campaignImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignImageException;

	public com.rumbasolutions.flask.model.CampaignImage updateImpl(
		com.rumbasolutions.flask.model.CampaignImage campaignImage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the campaign image with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchCampaignImageException} if it could not be found.
	*
	* @param campaignImageId the primary key of the campaign image
	* @return the campaign image
	* @throws com.rumbasolutions.flask.NoSuchCampaignImageException if a campaign image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.CampaignImage findByPrimaryKey(
		long campaignImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignImageException;

	/**
	* Returns the campaign image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignImageId the primary key of the campaign image
	* @return the campaign image, or <code>null</code> if a campaign image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.CampaignImage fetchByPrimaryKey(
		long campaignImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the campaign images.
	*
	* @return the campaign images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.CampaignImage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the campaign images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign images
	* @param end the upper bound of the range of campaign images (not inclusive)
	* @return the range of campaign images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.CampaignImage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the campaign images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign images
	* @param end the upper bound of the range of campaign images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of campaign images
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.CampaignImage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the campaign images from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of campaign images.
	*
	* @return the number of campaign images
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}