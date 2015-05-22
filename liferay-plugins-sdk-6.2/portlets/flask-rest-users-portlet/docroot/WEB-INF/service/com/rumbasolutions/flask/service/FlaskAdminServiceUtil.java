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

	public static java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> getFlaskContentManagers(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getFlaskContentManagers(serviceContext);
	}

	public static com.rumbasolutions.flask.model.FlaskAdmin addFlaskAdmin(
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.util.Date DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city,
		java.lang.String state, java.lang.String country,
		java.lang.String mobileNo, java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addFlaskAdmin(firstName, middleName, lastName, email,
			screenName, password1, password2, DOB, isMale, streetName, aptNo,
			areaCode, city, state, country, mobileNo, userInterests,
			serviceContext);
	}

	public static com.rumbasolutions.flask.model.FlaskAdmin updateFlaskAdmin(
		long userId, java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.util.Date DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city,
		java.lang.String state, java.lang.String country,
		java.lang.String mobileNo, java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateFlaskAdmin(userId, firstName, middleName, lastName,
			email, screenName, password1, password2, DOB, isMale, streetName,
			aptNo, areaCode, city, state, country, mobileNo, userInterests,
			serviceContext);
	}

	public static com.rumbasolutions.flask.model.FlaskAdmin addFlaskContentManager(
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.util.Date DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city,
		java.lang.String state, java.lang.String country,
		java.lang.String mobileNo, java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addFlaskContentManager(firstName, middleName, lastName,
			email, screenName, password1, password2, DOB, isMale, streetName,
			aptNo, areaCode, city, state, country, mobileNo, userInterests,
			serviceContext);
	}

	/**
	* Update content managers
	*/
	public static com.rumbasolutions.flask.model.FlaskAdmin updateFlaskContentManager(
		long userId, java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.util.Date DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city,
		java.lang.String state, java.lang.String country,
		java.lang.String mobileNo, java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateFlaskContentManager(userId, firstName, middleName,
			lastName, email, screenName, password1, password2, DOB, isMale,
			streetName, aptNo, areaCode, city, state, country, mobileNo,
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