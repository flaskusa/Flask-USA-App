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

import com.rumbasolutions.flask.model.CampaignEvent;

import java.util.List;

/**
 * The persistence utility for the campaign event service. This utility wraps {@link CampaignEventPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampaignEventPersistence
 * @see CampaignEventPersistenceImpl
 * @generated
 */
public class CampaignEventUtil {
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
	public static void clearCache(CampaignEvent campaignEvent) {
		getPersistence().clearCache(campaignEvent);
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
	public static List<CampaignEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CampaignEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CampaignEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CampaignEvent update(CampaignEvent campaignEvent)
		throws SystemException {
		return getPersistence().update(campaignEvent);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CampaignEvent update(CampaignEvent campaignEvent,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(campaignEvent, serviceContext);
	}

	/**
	* Returns all the campaign events where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the matching campaign events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.CampaignEvent> findBycampaignId(
		long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycampaignId(campaignId);
	}

	/**
	* Returns a range of all the campaign events where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of campaign events
	* @param end the upper bound of the range of campaign events (not inclusive)
	* @return the range of matching campaign events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.CampaignEvent> findBycampaignId(
		long campaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycampaignId(campaignId, start, end);
	}

	/**
	* Returns an ordered range of all the campaign events where campaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param campaignId the campaign ID
	* @param start the lower bound of the range of campaign events
	* @param end the upper bound of the range of campaign events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaign events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.CampaignEvent> findBycampaignId(
		long campaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycampaignId(campaignId, start, end, orderByComparator);
	}

	/**
	* Returns the first campaign event in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign event
	* @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a matching campaign event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignEvent findBycampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignEventException {
		return getPersistence()
				   .findBycampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the first campaign event in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign event, or <code>null</code> if a matching campaign event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignEvent fetchBycampaignId_First(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycampaignId_First(campaignId, orderByComparator);
	}

	/**
	* Returns the last campaign event in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign event
	* @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a matching campaign event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignEvent findBycampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignEventException {
		return getPersistence()
				   .findBycampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the last campaign event in the ordered set where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign event, or <code>null</code> if a matching campaign event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignEvent fetchBycampaignId_Last(
		long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycampaignId_Last(campaignId, orderByComparator);
	}

	/**
	* Returns the campaign events before and after the current campaign event in the ordered set where campaignId = &#63;.
	*
	* @param campaignEventId the primary key of the current campaign event
	* @param campaignId the campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign event
	* @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a campaign event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignEvent[] findBycampaignId_PrevAndNext(
		long campaignEventId, long campaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignEventException {
		return getPersistence()
				   .findBycampaignId_PrevAndNext(campaignEventId, campaignId,
			orderByComparator);
	}

	/**
	* Removes all the campaign events where campaignId = &#63; from the database.
	*
	* @param campaignId the campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycampaignId(campaignId);
	}

	/**
	* Returns the number of campaign events where campaignId = &#63;.
	*
	* @param campaignId the campaign ID
	* @return the number of matching campaign events
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycampaignId(long campaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycampaignId(campaignId);
	}

	/**
	* Returns all the campaign events where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the matching campaign events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.CampaignEvent> findByeventId(
		long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByeventId(eventId);
	}

	/**
	* Returns a range of all the campaign events where eventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventId the event ID
	* @param start the lower bound of the range of campaign events
	* @param end the upper bound of the range of campaign events (not inclusive)
	* @return the range of matching campaign events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.CampaignEvent> findByeventId(
		long eventId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByeventId(eventId, start, end);
	}

	/**
	* Returns an ordered range of all the campaign events where eventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventId the event ID
	* @param start the lower bound of the range of campaign events
	* @param end the upper bound of the range of campaign events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campaign events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.CampaignEvent> findByeventId(
		long eventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByeventId(eventId, start, end, orderByComparator);
	}

	/**
	* Returns the first campaign event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign event
	* @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a matching campaign event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignEvent findByeventId_First(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignEventException {
		return getPersistence().findByeventId_First(eventId, orderByComparator);
	}

	/**
	* Returns the first campaign event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campaign event, or <code>null</code> if a matching campaign event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignEvent fetchByeventId_First(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByeventId_First(eventId, orderByComparator);
	}

	/**
	* Returns the last campaign event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign event
	* @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a matching campaign event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignEvent findByeventId_Last(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignEventException {
		return getPersistence().findByeventId_Last(eventId, orderByComparator);
	}

	/**
	* Returns the last campaign event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campaign event, or <code>null</code> if a matching campaign event could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignEvent fetchByeventId_Last(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByeventId_Last(eventId, orderByComparator);
	}

	/**
	* Returns the campaign events before and after the current campaign event in the ordered set where eventId = &#63;.
	*
	* @param campaignEventId the primary key of the current campaign event
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campaign event
	* @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a campaign event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignEvent[] findByeventId_PrevAndNext(
		long campaignEventId, long eventId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignEventException {
		return getPersistence()
				   .findByeventId_PrevAndNext(campaignEventId, eventId,
			orderByComparator);
	}

	/**
	* Removes all the campaign events where eventId = &#63; from the database.
	*
	* @param eventId the event ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByeventId(long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByeventId(eventId);
	}

	/**
	* Returns the number of campaign events where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the number of matching campaign events
	* @throws SystemException if a system exception occurred
	*/
	public static int countByeventId(long eventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByeventId(eventId);
	}

	/**
	* Caches the campaign event in the entity cache if it is enabled.
	*
	* @param campaignEvent the campaign event
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.CampaignEvent campaignEvent) {
		getPersistence().cacheResult(campaignEvent);
	}

	/**
	* Caches the campaign events in the entity cache if it is enabled.
	*
	* @param campaignEvents the campaign events
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.CampaignEvent> campaignEvents) {
		getPersistence().cacheResult(campaignEvents);
	}

	/**
	* Creates a new campaign event with the primary key. Does not add the campaign event to the database.
	*
	* @param campaignEventId the primary key for the new campaign event
	* @return the new campaign event
	*/
	public static com.rumbasolutions.flask.model.CampaignEvent create(
		long campaignEventId) {
		return getPersistence().create(campaignEventId);
	}

	/**
	* Removes the campaign event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campaignEventId the primary key of the campaign event
	* @return the campaign event that was removed
	* @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a campaign event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignEvent remove(
		long campaignEventId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignEventException {
		return getPersistence().remove(campaignEventId);
	}

	public static com.rumbasolutions.flask.model.CampaignEvent updateImpl(
		com.rumbasolutions.flask.model.CampaignEvent campaignEvent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(campaignEvent);
	}

	/**
	* Returns the campaign event with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchCampaignEventException} if it could not be found.
	*
	* @param campaignEventId the primary key of the campaign event
	* @return the campaign event
	* @throws com.rumbasolutions.flask.NoSuchCampaignEventException if a campaign event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignEvent findByPrimaryKey(
		long campaignEventId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchCampaignEventException {
		return getPersistence().findByPrimaryKey(campaignEventId);
	}

	/**
	* Returns the campaign event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campaignEventId the primary key of the campaign event
	* @return the campaign event, or <code>null</code> if a campaign event with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.CampaignEvent fetchByPrimaryKey(
		long campaignEventId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(campaignEventId);
	}

	/**
	* Returns all the campaign events.
	*
	* @return the campaign events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.CampaignEvent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the campaign events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign events
	* @param end the upper bound of the range of campaign events (not inclusive)
	* @return the range of campaign events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.CampaignEvent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the campaign events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.CampaignEventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campaign events
	* @param end the upper bound of the range of campaign events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of campaign events
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.CampaignEvent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the campaign events from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of campaign events.
	*
	* @return the number of campaign events
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CampaignEventPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CampaignEventPersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					CampaignEventPersistence.class.getName());

			ReferenceRegistry.registerReference(CampaignEventUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CampaignEventPersistence persistence) {
	}

	private static CampaignEventPersistence _persistence;
}