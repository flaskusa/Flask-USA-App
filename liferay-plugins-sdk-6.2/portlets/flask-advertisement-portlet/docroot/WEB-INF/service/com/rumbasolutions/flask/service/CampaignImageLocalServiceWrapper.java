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

package com.rumbasolutions.flask.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CampaignImageLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CampaignImageLocalService
 * @generated
 */
public class CampaignImageLocalServiceWrapper
	implements CampaignImageLocalService,
		ServiceWrapper<CampaignImageLocalService> {
	public CampaignImageLocalServiceWrapper(
		CampaignImageLocalService campaignImageLocalService) {
		_campaignImageLocalService = campaignImageLocalService;
	}

	/**
	* Adds the campaign image to the database. Also notifies the appropriate model listeners.
	*
	* @param campaignImage the campaign image
	* @return the campaign image that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.CampaignImage addCampaignImage(
		com.rumbasolutions.flask.model.CampaignImage campaignImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignImageLocalService.addCampaignImage(campaignImage);
	}

	/**
	* Creates a new campaign image with the primary key. Does not add the campaign image to the database.
	*
	* @param campaignImageId the primary key for the new campaign image
	* @return the new campaign image
	*/
	@Override
	public com.rumbasolutions.flask.model.CampaignImage createCampaignImage(
		long campaignImageId) {
		return _campaignImageLocalService.createCampaignImage(campaignImageId);
	}

	/**
	* Deletes the campaign image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignImageId the primary key of the campaign image
	* @return the campaign image that was removed
	* @throws PortalException if a campaign image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.CampaignImage deleteCampaignImage(
		long campaignImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignImageLocalService.deleteCampaignImage(campaignImageId);
	}

	/**
	* Deletes the campaign image from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignImage the campaign image
	* @return the campaign image that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.CampaignImage deleteCampaignImage(
		com.rumbasolutions.flask.model.CampaignImage campaignImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignImageLocalService.deleteCampaignImage(campaignImage);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _campaignImageLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignImageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignImageLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignImageLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignImageLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignImageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rumbasolutions.flask.model.CampaignImage fetchCampaignImage(
		long campaignImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignImageLocalService.fetchCampaignImage(campaignImageId);
	}

	/**
	* Returns the campaign image with the primary key.
	*
	* @param campaignImageId the primary key of the campaign image
	* @return the campaign image
	* @throws PortalException if a campaign image with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.CampaignImage getCampaignImage(
		long campaignImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignImageLocalService.getCampaignImage(campaignImageId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _campaignImageLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.rumbasolutions.flask.model.CampaignImage> getCampaignImages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignImageLocalService.getCampaignImages(start, end);
	}

	/**
	* Returns the number of campaign images.
	*
	* @return the number of campaign images
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCampaignImagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignImageLocalService.getCampaignImagesCount();
	}

	/**
	* Updates the campaign image in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campaignImage the campaign image
	* @return the campaign image that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rumbasolutions.flask.model.CampaignImage updateCampaignImage(
		com.rumbasolutions.flask.model.CampaignImage campaignImage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _campaignImageLocalService.updateCampaignImage(campaignImage);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _campaignImageLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_campaignImageLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _campaignImageLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CampaignImageLocalService getWrappedCampaignImageLocalService() {
		return _campaignImageLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCampaignImageLocalService(
		CampaignImageLocalService campaignImageLocalService) {
		_campaignImageLocalService = campaignImageLocalService;
	}

	@Override
	public CampaignImageLocalService getWrappedService() {
		return _campaignImageLocalService;
	}

	@Override
	public void setWrappedService(
		CampaignImageLocalService campaignImageLocalService) {
		_campaignImageLocalService = campaignImageLocalService;
	}

	private CampaignImageLocalService _campaignImageLocalService;
}