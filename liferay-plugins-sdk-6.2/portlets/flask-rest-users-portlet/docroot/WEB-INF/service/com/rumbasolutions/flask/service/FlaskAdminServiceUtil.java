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
 * Provides the remote service utility for FlaskAdmin. This utility wraps
 * {@link com.rumbasolutions.flask.service.impl.FlaskAdminServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Ashutosh Rai
 * @see FlaskAdminService
 * @see com.rumbasolutions.flask.service.base.FlaskAdminServiceBaseImpl
 * @see com.rumbasolutions.flask.service.impl.FlaskAdminServiceImpl
 * @generated
 */
public class FlaskAdminServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.rumbasolutions.flask.service.impl.FlaskAdminServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> getFlaskAdmins(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getFlaskAdmins(serviceContext);
	}

	public static java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> getFlaskRegularUsers(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getFlaskRegularUsers(serviceContext);
	}

	public static com.rumbasolutions.flask.model.FlaskAdmin addFlaskAdmin(
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.lang.String DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city, long stateId,
		long countryId, java.lang.String mobileNumber,
		java.lang.String userInterests, long roleId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addFlaskAdmin(firstName, middleName, lastName, email,
			screenName, password1, password2, DOB, isMale, streetName, aptNo,
			areaCode, city, stateId, countryId, mobileNumber, userInterests,
			roleId, serviceContext);
	}

	public static com.rumbasolutions.flask.model.FlaskAdmin signUp(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String email, java.lang.String screenName,
		java.lang.String password1, java.lang.String password2,
		java.lang.String DOB, boolean isMale, java.lang.String areaCode,
		java.lang.String mobileNumber,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .signUp(firstName, lastName, email, screenName, password1,
			password2, DOB, isMale, areaCode, mobileNumber, serviceContext);
	}

	public static com.rumbasolutions.flask.model.FlaskAdmin updateFlaskAdmin(
		long userId, java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.lang.String DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city, long stateId,
		long countryId, java.lang.String mobileNumber,
		java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateFlaskAdmin(userId, firstName, middleName, lastName,
			email, screenName, password1, password2, DOB, isMale, streetName,
			aptNo, areaCode, city, stateId, countryId, mobileNumber,
			userInterests, serviceContext);
	}

	public static void deleteFlaskAdmins(long userId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFlaskAdmins(userId, serviceContext);
	}

	/**
	* Returns valid user id if user found else 0. -1 when there is unknown system exception
	*/
	public static long getUserIdForScreenName(java.lang.String screenName,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getUserIdForScreenName(screenName, serviceContext);
	}

	/**
	* Returns valid user id if user found else 0. -1 when there is unknown system exception
	*/
	public static long getUserIdForEmail(java.lang.String emailAddress,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getUserIdForEmail(emailAddress, serviceContext);
	}

	/**
	* Returns valid user id if user found else 0. -1 when there is unknown system exception
	*/
	public static com.rumbasolutions.flask.model.FlaskAdmin getUserById(
		long userId, com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getUserById(userId, serviceContext);
	}

	public static com.rumbasolutions.flask.model.FlaskAdmin addFlaskUser(
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.lang.String DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city, long stateId,
		long countryId, java.lang.String mobileNumber,
		java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addFlaskUser(firstName, middleName, lastName, email,
			screenName, password1, password2, DOB, isMale, streetName, aptNo,
			areaCode, city, stateId, countryId, mobileNumber, userInterests,
			serviceContext);
	}

	public static com.rumbasolutions.flask.model.FlaskAdmin updateFlaskUser(
		long userId, java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.lang.String DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city, long stateId,
		long countryId, java.lang.String mobileNumber,
		java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateFlaskUser(userId, firstName, middleName, lastName,
			email, screenName, password1, password2, DOB, isMale, streetName,
			aptNo, areaCode, city, stateId, countryId, mobileNumber,
			userInterests, serviceContext);
	}

	public static com.rumbasolutions.flask.model.FlaskAdmin updateLoggedInUser(
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.lang.String DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city, long stateId,
		long countryId, java.lang.String mobileNumber,
		java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateLoggedInUser(firstName, middleName, lastName, email,
			screenName, password1, password2, DOB, isMale, streetName, aptNo,
			areaCode, city, stateId, countryId, mobileNumber, userInterests,
			serviceContext);
	}

	public static com.liferay.portal.model.Country getCountryByName(
		java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountryByName(name, serviceContext);
	}

	public static java.util.List<com.liferay.portal.model.Country> getCountries(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountries(serviceContext);
	}

	public static java.util.List<com.liferay.portal.model.Region> getRegion(
		long countryId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRegion(countryId, serviceContext);
	}

	public static java.util.List<com.liferay.portal.model.Region> getUSARegions(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUSARegions(serviceContext);
	}

	public static com.liferay.portal.kernel.repository.model.FileEntry addMyFileEntry(
		long userId, long repositoryId, long folderId,
		java.lang.String sourceFileName, java.lang.String mimeType,
		java.lang.String title, java.lang.String description,
		java.lang.String changeLog, byte[] bytes,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addMyFileEntry(userId, repositoryId, folderId,
			sourceFileName, mimeType, title, description, changeLog, bytes,
			serviceContext);
	}

	public static com.liferay.portal.kernel.repository.model.FileEntry getMyFileEntry(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMyFileEntry(userId);
	}

	public static void deleteMyFileEntry(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteMyFileEntry(userId);
	}

	public static void updateUserForFileEntry(long userId, long fileEntryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateUserForFileEntry(userId, fileEntryId, serviceContext);
	}

	public static int getUserForEmail(java.lang.String emailAddress,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getUserForEmail(emailAddress, serviceContext);
	}

	public static int getUserForScreenName(java.lang.String screenName,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getUserForScreenName(screenName, serviceContext);
	}

	public static com.liferay.portal.kernel.repository.model.FileEntry uploadUserProfile(
		java.io.File file,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().uploadUserProfile(file, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static FlaskAdminService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FlaskAdminService.class.getName());

			if (invokableService instanceof FlaskAdminService) {
				_service = (FlaskAdminService)invokableService;
			}
			else {
				_service = new FlaskAdminServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(FlaskAdminServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FlaskAdminService service) {
	}

	private static FlaskAdminService _service;
}