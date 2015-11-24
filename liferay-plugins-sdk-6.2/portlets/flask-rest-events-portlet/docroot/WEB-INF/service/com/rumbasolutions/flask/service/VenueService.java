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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for Venue. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Ashutosh Rai
 * @see VenueServiceUtil
 * @see com.rumbasolutions.flask.service.base.VenueServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.VenueServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface VenueService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VenueServiceUtil} to access the venue remote service. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.VenueServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.rumbasolutions.flask.model.Venue> getAllVenues(
		com.liferay.portal.service.ServiceContext serviceContext);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.rumbasolutions.flask.model.Venue getVenue(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext);

	public com.rumbasolutions.flask.model.Venue addVenue(
		java.lang.String venueName, java.lang.String venueDescription,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String venueZipCode, java.lang.String venueCity,
		java.lang.String venueMetroArea, long venueStateId,
		long venueCountryId, java.lang.String longitude,
		java.lang.String latitude,
		com.liferay.portal.service.ServiceContext serviceContext);

	public com.rumbasolutions.flask.model.Venue updateVenue(long venueId,
		java.lang.String venueName, java.lang.String venueDescription,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String venueZipCode, java.lang.String venueCity,
		java.lang.String venueMetroArea, long venueStateId,
		long venueCountryId, java.lang.String longitude,
		java.lang.String latitude,
		com.liferay.portal.service.ServiceContext serviceContext);

	public void deleteVenue(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext);

	/**
	* @param venueList comms seperated venueId list
	* @param serviceContext
	* @return
	*/
	public void deleteVenues(java.lang.String venueList,
		com.liferay.portal.service.ServiceContext serviceContext);

	public void addVenueImage(long venueId, java.lang.String title,
		java.lang.String venueImageUUID, long groupId,
		com.liferay.portal.service.ServiceContext serviceContext);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.rumbasolutions.flask.model.VenueImage> getVenueImages(
		long venueId, com.liferay.portal.service.ServiceContext serviceContext);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.rumbasolutions.flask.model.VenueImage getVenueImage(
		long venueImageId,
		com.liferay.portal.service.ServiceContext serviceContext);

	public void updateVenueImage(long venueImageId, java.lang.String title,
		java.lang.String venueImageUUID,
		com.liferay.portal.service.ServiceContext serviceContext);

	public void deleteVenueImage(long venueImageId,
		com.liferay.portal.service.ServiceContext serviceContext);

	public void deleteAllVenueImages(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext);

	public com.rumbasolutions.flask.model.VenueDetail addVenueDetail(
		long venueId, long infoTypeId, long infoTypeCategoryId,
		java.lang.String infoTitle, java.lang.String infoDesc,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String zipCode, java.lang.String city, long stateId,
		long countryId, java.lang.String latitude, java.lang.String longitude,
		java.lang.String phone, java.lang.String website,
		java.lang.Double cost, java.lang.String hoursOfOperation,
		com.liferay.portal.service.ServiceContext serviceContext);

	public com.rumbasolutions.flask.model.VenueDetail updateVenueDetail(
		long venueDetailId, long infoTypeId, long infoTypeCategoryId,
		java.lang.String infoTitle, java.lang.String infoDesc,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String zipCode, java.lang.String city, long stateId,
		long countryId, java.lang.String latitude, java.lang.String longitude,
		java.lang.String phone, java.lang.String website,
		java.lang.Double cost, java.lang.String hoursOfOperation,
		com.liferay.portal.service.ServiceContext serviceContext);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.rumbasolutions.flask.model.VenueDetail getVenueDetail(
		long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.rumbasolutions.flask.model.VenueDetail> getVenueDetails(
		long venueId, com.liferay.portal.service.ServiceContext serviceContext);

	public void deleteVenueDetail(long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext);

	public void deleteAllVenueDetails(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext);

	public com.rumbasolutions.flask.model.VenueDetailImage addVenueDetailImage(
		long venueDetailId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID, long groupId,
		com.liferay.portal.service.ServiceContext serviceContext);

	public com.rumbasolutions.flask.model.VenueDetailImage updateVenueDetailImage(
		long venueDetailImageId, long venueDetailId,
		java.lang.String imageTitle, java.lang.String imageDesc,
		java.lang.String imageUUID, long groupId,
		com.liferay.portal.service.ServiceContext serviceContext);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.rumbasolutions.flask.model.VenueDetailImage getVenueDetailImage(
		long venueDetailImageId,
		com.liferay.portal.service.ServiceContext serviceContext);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> getVenueDetailImages(
		long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext);

	public void deleteVenueDetailImage(long venueDetailImageId,
		com.liferay.portal.service.ServiceContext serviceContext);

	public void deleteAllVenueDetailImages(long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONObject getVenueDetailsWithImages(
		long venueId, com.liferay.portal.service.ServiceContext serviceContext);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public com.liferay.portal.kernel.json.JSONObject copyVenueDetailsWithImages(
		long sourceVenueId, long destinationVenueId, long infoTypeCategoryId,
		com.liferay.portal.service.ServiceContext serviceContext);

	public void addFileEntry(long destinationVenueId, long srcVenueDetailId,
		com.rumbasolutions.flask.model.VenueDetail destVenueDetail,
		com.liferay.portal.service.ServiceContext serviceContext);
}