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

import com.rumbasolutions.flask.model.AdCampaign;

/**
 * The persistence interface for the ad campaign service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdCampaignPersistenceImpl
 * @see AdCampaignUtil
 * @generated
 */
public interface AdCampaignPersistence extends BasePersistence<AdCampaign> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdCampaignUtil} to access the ad campaign persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the ad campaigns where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @return the matching ad campaigns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.AdCampaign> findBycustomerId(
		long customerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ad campaigns where customerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param customerId the customer ID
	* @param start the lower bound of the range of ad campaigns
	* @param end the upper bound of the range of ad campaigns (not inclusive)
	* @return the range of matching ad campaigns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.AdCampaign> findBycustomerId(
		long customerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad campaigns where customerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param customerId the customer ID
	* @param start the lower bound of the range of ad campaigns
	* @param end the upper bound of the range of ad campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ad campaigns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.AdCampaign> findBycustomerId(
		long customerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ad campaign in the ordered set where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad campaign
	* @throws com.rumbasolutions.flask.NoSuchAdCampaignException if a matching ad campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.AdCampaign findBycustomerId_First(
		long customerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchAdCampaignException;

	/**
	* Returns the first ad campaign in the ordered set where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad campaign, or <code>null</code> if a matching ad campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.AdCampaign fetchBycustomerId_First(
		long customerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ad campaign in the ordered set where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad campaign
	* @throws com.rumbasolutions.flask.NoSuchAdCampaignException if a matching ad campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.AdCampaign findBycustomerId_Last(
		long customerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchAdCampaignException;

	/**
	* Returns the last ad campaign in the ordered set where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad campaign, or <code>null</code> if a matching ad campaign could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.AdCampaign fetchBycustomerId_Last(
		long customerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad campaigns before and after the current ad campaign in the ordered set where customerId = &#63;.
	*
	* @param campaignId the primary key of the current ad campaign
	* @param customerId the customer ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ad campaign
	* @throws com.rumbasolutions.flask.NoSuchAdCampaignException if a ad campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.AdCampaign[] findBycustomerId_PrevAndNext(
		long campaignId, long customerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchAdCampaignException;

	/**
	* Removes all the ad campaigns where customerId = &#63; from the database.
	*
	* @param customerId the customer ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBycustomerId(long customerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad campaigns where customerId = &#63;.
	*
	* @param customerId the customer ID
	* @return the number of matching ad campaigns
	* @throws SystemException if a system exception occurred
	*/
	public int countBycustomerId(long customerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the ad campaign in the entity cache if it is enabled.
	*
	* @param adCampaign the ad campaign
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.AdCampaign adCampaign);

	/**
	* Caches the ad campaigns in the entity cache if it is enabled.
	*
	* @param adCampaigns the ad campaigns
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.AdCampaign> adCampaigns);

	/**
	* Creates a new ad campaign with the primary key. Does not add the ad campaign to the database.
	*
	* @param campaignId the primary key for the new ad campaign
	* @return the new ad campaign
	*/
	public com.rumbasolutions.flask.model.AdCampaign create(long campaignId);

	/**
	* Removes the ad campaign with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignId the primary key of the ad campaign
	* @return the ad campaign that was removed
	* @throws com.rumbasolutions.flask.NoSuchAdCampaignException if a ad campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.AdCampaign remove(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchAdCampaignException;

	public com.rumbasolutions.flask.model.AdCampaign updateImpl(
		com.rumbasolutions.flask.model.AdCampaign adCampaign)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ad campaign with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchAdCampaignException} if it could not be found.
	*
	* @param campaignId the primary key of the ad campaign
	* @return the ad campaign
	* @throws com.rumbasolutions.flask.NoSuchAdCampaignException if a ad campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.AdCampaign findByPrimaryKey(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchAdCampaignException;

	/**
	* Returns the ad campaign with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignId the primary key of the ad campaign
	* @return the ad campaign, or <code>null</code> if a ad campaign with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.AdCampaign fetchByPrimaryKey(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ad campaigns.
	*
	* @return the ad campaigns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.AdCampaign> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ad campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ad campaigns
	* @param end the upper bound of the range of ad campaigns (not inclusive)
	* @return the range of ad campaigns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.AdCampaign> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ad campaigns.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCampaignModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ad campaigns
	* @param end the upper bound of the range of ad campaigns (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ad campaigns
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.AdCampaign> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ad campaigns from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ad campaigns.
	*
	* @return the number of ad campaigns
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}