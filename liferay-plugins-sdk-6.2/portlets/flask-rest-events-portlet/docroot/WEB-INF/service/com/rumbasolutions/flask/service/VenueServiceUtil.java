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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Venue. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.VenueServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Ashutosh Rai
 * @see VenueService
 * @see com.rumbasolutions.flask.service.base.VenueServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.VenueServiceImpl
 * @generated
 */
public class VenueServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.VenueServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.rumbasolutions.flask.model.Venue> getAllVenues(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getAllVenues(serviceContext);
	}

	public static com.rumbasolutions.flask.model.Venue getVenue(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getVenue(venueId, serviceContext);
	}

	public static com.rumbasolutions.flask.model.Venue addVenue(
		java.lang.String venueName, java.lang.String venueDescription,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String venueZipCode, java.lang.String venueCity,
		java.lang.String venueMetroArea, long venueStateId,
		long venueCountryId, java.lang.String longitude,
		java.lang.String latitude,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addVenue(venueName, venueDescription, addrLine1, addrLine2,
			venueZipCode, venueCity, venueMetroArea, venueStateId,
			venueCountryId, longitude, latitude, serviceContext);
	}

	public static com.rumbasolutions.flask.model.Venue updateVenue(
		long venueId, java.lang.String venueName,
		java.lang.String venueDescription, java.lang.String addrLine1,
		java.lang.String addrLine2, java.lang.String venueZipCode,
		java.lang.String venueCity, java.lang.String venueMetroArea,
		long venueStateId, long venueCountryId, java.lang.String longitude,
		java.lang.String latitude,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateVenue(venueId, venueName, venueDescription,
			addrLine1, addrLine2, venueZipCode, venueCity, venueMetroArea,
			venueStateId, venueCountryId, longitude, latitude, serviceContext);
	}

	public static void deleteVenue(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteVenue(venueId, serviceContext);
	}

	/**
	* @param venueList comms seperated venueId list
	* @param serviceContext
	* @return
	*/
	public static void deleteVenues(java.lang.String venueList,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteVenues(venueList, serviceContext);
	}

	public static com.rumbasolutions.flask.model.VenueImage addVenueImage(
		long venueId, java.lang.String title, java.lang.String venueImageUUID,
		long groupId, com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addVenueImage(venueId, title, venueImageUUID, groupId,
			serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.VenueImage> getVenueImages(
		long venueId, com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getVenueImages(venueId, serviceContext);
	}

	public static com.rumbasolutions.flask.model.VenueImage getVenueImage(
		long venueImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getVenueImage(venueImageId, serviceContext);
	}

	public static void updateVenueImage(long venueImageId,
		java.lang.String title, java.lang.String venueImageUUID,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService()
			.updateVenueImage(venueImageId, title, venueImageUUID,
			serviceContext);
	}

	public static void deleteVenueImage(long venueImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteVenueImage(venueImageId, serviceContext);
	}

	public static void deleteAllVenueImages(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteAllVenueImages(venueId, serviceContext);
	}

	public static com.rumbasolutions.flask.model.VenueDetail addVenueDetail(
		long venueId, long infoTypeId, long infoTypeCategoryId,
		java.lang.String infoTitle, java.lang.String infoShortDesc,
		java.lang.String infoDesc, java.lang.String addrLine1,
		java.lang.String addrLine2, java.lang.String zipCode,
		java.lang.String city, long stateId, long countryId,
		java.lang.String latitude, java.lang.String longitude,
		java.lang.String phone, java.lang.String mobileAppName,
		java.lang.String website, java.lang.Double cost,
		java.lang.String hoursOfOperation, java.lang.String venueSubDetails,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addVenueDetail(venueId, infoTypeId, infoTypeCategoryId,
			infoTitle, infoShortDesc, infoDesc, addrLine1, addrLine2, zipCode,
			city, stateId, countryId, latitude, longitude, phone,
			mobileAppName, website, cost, hoursOfOperation, venueSubDetails,
			serviceContext);
	}

	public static com.rumbasolutions.flask.model.VenueDetail updateVenueDetail(
		long venueDetailId, long infoTypeId, long infoTypeCategoryId,
		java.lang.String infoTitle, java.lang.String infoShortDesc,
		java.lang.String infoDesc, java.lang.String addrLine1,
		java.lang.String addrLine2, java.lang.String zipCode,
		java.lang.String city, long stateId, long countryId,
		java.lang.String latitude, java.lang.String longitude,
		java.lang.String phone, java.lang.String mobileAppName,
		java.lang.String website, java.lang.Double cost,
		java.lang.String hoursOfOperation, java.lang.String venueSubDetails,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateVenueDetail(venueDetailId, infoTypeId,
			infoTypeCategoryId, infoTitle, infoShortDesc, infoDesc, addrLine1,
			addrLine2, zipCode, city, stateId, countryId, latitude, longitude,
			phone, mobileAppName, website, cost, hoursOfOperation,
			venueSubDetails, serviceContext);
	}

	public static com.rumbasolutions.flask.model.VenueDetail getVenueDetail(
		long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getVenueDetail(venueDetailId, serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.VenueDetail> getVenueDetails(
		long venueId, com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getVenueDetails(venueId, serviceContext);
	}

	public static void deleteVenueDetail(long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteVenueDetail(venueDetailId, serviceContext);
	}

	public static void deleteAllVenueDetails(long venueId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteAllVenueDetails(venueId, serviceContext);
	}

	public static com.rumbasolutions.flask.model.VenueDetailImage addVenueDetailImage(
		long venueDetailId, java.lang.String imageTitle,
		java.lang.String imageDesc, java.lang.String imageUUID, long groupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addVenueDetailImage(venueDetailId, imageTitle, imageDesc,
			imageUUID, groupId, serviceContext);
	}

	public static com.rumbasolutions.flask.model.VenueDetailImage updateVenueDetailImage(
		long venueDetailImageId, long venueDetailId,
		java.lang.String imageTitle, java.lang.String imageDesc,
		java.lang.String imageUUID, long groupId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateVenueDetailImage(venueDetailImageId, venueDetailId,
			imageTitle, imageDesc, imageUUID, groupId, serviceContext);
	}

	public static com.rumbasolutions.flask.model.VenueDetailImage getVenueDetailImage(
		long venueDetailImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .getVenueDetailImage(venueDetailImageId, serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.VenueDetailImage> getVenueDetailImages(
		long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getVenueDetailImages(venueDetailId, serviceContext);
	}

	public static void deleteVenueDetailImage(long venueDetailImageId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteVenueDetailImage(venueDetailImageId, serviceContext);
	}

	public static void deleteAllVenueDetailImages(long venueDetailId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService().deleteAllVenueDetailImages(venueDetailId, serviceContext);
	}

	public static com.liferay.portal.kernel.json.JSONObject getVenueDetailsWithImages(
		long venueId, com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getVenueDetailsWithImages(venueId, serviceContext);
	}

	public static com.liferay.portal.kernel.json.JSONObject copyVenueDetailsWithImages(
		long sourceVenueId, long destinationVenueId, long infoTypeCategoryId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .copyVenueDetailsWithImages(sourceVenueId,
			destinationVenueId, infoTypeCategoryId, serviceContext);
	}

	public static void addFileEntry(long destinationVenueId,
		long srcVenueDetailId,
		com.rumbasolutions.flask.model.VenueDetail destVenueDetail,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService()
			.addFileEntry(destinationVenueId, srcVenueDetailId,
			destVenueDetail, serviceContext);
	}

	public static com.rumbasolutions.flask.model.VenueDeviceImage addVenueDeviceImage(
		long venueDetailImageId, long venueId, java.lang.String deviceType,
		java.lang.String venueDeviceImageUUID, java.lang.String aspectRatio) {
		return getService()
				   .addVenueDeviceImage(venueDetailImageId, venueId,
			deviceType, venueDeviceImageUUID, aspectRatio);
	}

	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> getVenueDeviceImagesByVenueId(
		long venueId) {
		return getService().getVenueDeviceImagesByVenueId(venueId);
	}

	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> getVenueDeviceImagesByDeviceType(
		java.lang.String deviceType) {
		return getService().getVenueDeviceImagesByDeviceType(deviceType);
	}

	public static java.util.List<com.rumbasolutions.flask.model.VenueImage> getVenueImagesByVenueIdAndDeviceType(
		long venueId, java.lang.String deviceType,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .getVenueImagesByVenueIdAndDeviceType(venueId, deviceType,
			serviceContext);
	}

	public static com.rumbasolutions.flask.model.VenueDeviceImage getVenueDeviceImage(
		long venueDeviceImageId) {
		return getService().getVenueDeviceImage(venueDeviceImageId);
	}

	public static java.util.List<com.rumbasolutions.flask.model.VenueDeviceImage> getAllVenueDeviceImages() {
		return getService().getAllVenueDeviceImages();
	}

	public static com.rumbasolutions.flask.model.VenueDeviceImage updateVenueDeviceImage(
		long venueImageDeviceId, long venueDetailImageId, long venueId,
		java.lang.String deviceType, java.lang.String venueDeviceImageUUID,
		java.lang.String aspectRatio) {
		return getService()
				   .updateVenueDeviceImage(venueImageDeviceId,
			venueDetailImageId, venueId, deviceType, venueDeviceImageUUID,
			aspectRatio);
	}

	public static void deleteVenueDeviceImage(long venueDeviceImageId) {
		getService().deleteVenueDeviceImage(venueDeviceImageId);
	}

	public static com.rumbasolutions.flask.model.VenueImage uploadDeviceImage(
		java.io.File file, long venueId, java.lang.String deviceType,
		java.lang.String aspectRatio,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .uploadDeviceImage(file, venueId, deviceType, aspectRatio,
			serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static VenueService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VenueService.class.getName());

			if (invokableService instanceof VenueService) {
				_service = (VenueService)invokableService;
			}
			else {
				_service = new VenueServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(VenueServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VenueService service) {
	}

	private static VenueService _service;
}