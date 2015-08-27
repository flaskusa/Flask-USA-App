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

import com.rumbasolutions.flask.model.TailgateImages;

/**
 * The persistence interface for the tailgate images service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rajeshj
 * @see TailgateImagesPersistenceImpl
 * @see TailgateImagesUtil
 * @generated
 */
public interface TailgateImagesPersistence extends BasePersistence<TailgateImages> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TailgateImagesUtil} to access the tailgate images persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tailgate imageses where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @return the matching tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.TailgateImages> findBytailgateId(
		long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.TailgateImages> findBytailgateId(
		long tailgateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.TailgateImages> findBytailgateId(
		long tailgateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tailgate images in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate images
	* @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a matching tailgate images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateImages findBytailgateId_First(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateImagesException;

	/**
	* Returns the first tailgate images in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate images, or <code>null</code> if a matching tailgate images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateImages fetchBytailgateId_First(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tailgate images in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate images
	* @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a matching tailgate images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateImages findBytailgateId_Last(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateImagesException;

	/**
	* Returns the last tailgate images in the ordered set where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate images, or <code>null</code> if a matching tailgate images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateImages fetchBytailgateId_Last(
		long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.rumbasolutions.flask.model.TailgateImages[] findBytailgateId_PrevAndNext(
		long tailgateImageId, long tailgateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateImagesException;

	/**
	* Removes all the tailgate imageses where tailgateId = &#63; from the database.
	*
	* @param tailgateId the tailgate ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBytailgateId(long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tailgate imageses where tailgateId = &#63;.
	*
	* @param tailgateId the tailgate ID
	* @return the number of matching tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	public int countBytailgateId(long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tailgate imageses where imageUUID = &#63;.
	*
	* @param imageUUID the image u u i d
	* @return the matching tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.TailgateImages> findByimageUUID(
		java.lang.String imageUUID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tailgate imageses where imageUUID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param imageUUID the image u u i d
	* @param start the lower bound of the range of tailgate imageses
	* @param end the upper bound of the range of tailgate imageses (not inclusive)
	* @return the range of matching tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.TailgateImages> findByimageUUID(
		java.lang.String imageUUID, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tailgate imageses where imageUUID = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateImagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param imageUUID the image u u i d
	* @param start the lower bound of the range of tailgate imageses
	* @param end the upper bound of the range of tailgate imageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.TailgateImages> findByimageUUID(
		java.lang.String imageUUID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first tailgate images in the ordered set where imageUUID = &#63;.
	*
	* @param imageUUID the image u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate images
	* @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a matching tailgate images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateImages findByimageUUID_First(
		java.lang.String imageUUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateImagesException;

	/**
	* Returns the first tailgate images in the ordered set where imageUUID = &#63;.
	*
	* @param imageUUID the image u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching tailgate images, or <code>null</code> if a matching tailgate images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateImages fetchByimageUUID_First(
		java.lang.String imageUUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last tailgate images in the ordered set where imageUUID = &#63;.
	*
	* @param imageUUID the image u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate images
	* @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a matching tailgate images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateImages findByimageUUID_Last(
		java.lang.String imageUUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateImagesException;

	/**
	* Returns the last tailgate images in the ordered set where imageUUID = &#63;.
	*
	* @param imageUUID the image u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching tailgate images, or <code>null</code> if a matching tailgate images could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateImages fetchByimageUUID_Last(
		java.lang.String imageUUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tailgate imageses before and after the current tailgate images in the ordered set where imageUUID = &#63;.
	*
	* @param tailgateImageId the primary key of the current tailgate images
	* @param imageUUID the image u u i d
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next tailgate images
	* @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a tailgate images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateImages[] findByimageUUID_PrevAndNext(
		long tailgateImageId, java.lang.String imageUUID,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateImagesException;

	/**
	* Removes all the tailgate imageses where imageUUID = &#63; from the database.
	*
	* @param imageUUID the image u u i d
	* @throws SystemException if a system exception occurred
	*/
	public void removeByimageUUID(java.lang.String imageUUID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tailgate imageses where imageUUID = &#63;.
	*
	* @param imageUUID the image u u i d
	* @return the number of matching tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	public int countByimageUUID(java.lang.String imageUUID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the tailgate images in the entity cache if it is enabled.
	*
	* @param tailgateImages the tailgate images
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.TailgateImages tailgateImages);

	/**
	* Caches the tailgate imageses in the entity cache if it is enabled.
	*
	* @param tailgateImageses the tailgate imageses
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.TailgateImages> tailgateImageses);

	/**
	* Creates a new tailgate images with the primary key. Does not add the tailgate images to the database.
	*
	* @param tailgateImageId the primary key for the new tailgate images
	* @return the new tailgate images
	*/
	public com.rumbasolutions.flask.model.TailgateImages create(
		long tailgateImageId);

	/**
	* Removes the tailgate images with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateImageId the primary key of the tailgate images
	* @return the tailgate images that was removed
	* @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a tailgate images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateImages remove(
		long tailgateImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateImagesException;

	public com.rumbasolutions.flask.model.TailgateImages updateImpl(
		com.rumbasolutions.flask.model.TailgateImages tailgateImages)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tailgate images with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchTailgateImagesException} if it could not be found.
	*
	* @param tailgateImageId the primary key of the tailgate images
	* @return the tailgate images
	* @throws com.rumbasolutions.flask.NoSuchTailgateImagesException if a tailgate images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateImages findByPrimaryKey(
		long tailgateImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateImagesException;

	/**
	* Returns the tailgate images with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tailgateImageId the primary key of the tailgate images
	* @return the tailgate images, or <code>null</code> if a tailgate images with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateImages fetchByPrimaryKey(
		long tailgateImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tailgate imageses.
	*
	* @return the tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.TailgateImages> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.TailgateImages> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.rumbasolutions.flask.model.TailgateImages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tailgate imageses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tailgate imageses.
	*
	* @return the number of tailgate imageses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}