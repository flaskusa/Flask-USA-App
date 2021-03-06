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

package com.liferay.contacts.service;

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
 * Provides the remote service interface for FlaskUserDeviceRegistration. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskUserDeviceRegistrationServiceUtil
 * @see com.liferay.contacts.service.base.FlaskUserDeviceRegistrationServiceBaseImpl
 * @see com.liferay.contacts.service.impl.FlaskUserDeviceRegistrationServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface FlaskUserDeviceRegistrationService extends BaseService,
	InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FlaskUserDeviceRegistrationServiceUtil} to access the flask user device registration remote service. Add custom service methods to {@link com.liferay.contacts.service.impl.FlaskUserDeviceRegistrationServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

	public com.liferay.contacts.model.FlaskUserDeviceRegistration addUserDevice(
		long userId, java.lang.String userEmail,
		java.lang.String devicePlatform, java.lang.String deviceDetails,
		java.lang.String deviceToken, java.util.Date registrationTime,
		java.lang.Boolean active, java.util.Date lastNotificationTime,
		java.lang.String lastNotificationMsg,
		com.liferay.portal.service.ServiceContext serviceContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> getAllUserDevices();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.contacts.model.FlaskUserDeviceRegistration getUserDevice(
		long userDeviceRegistrationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> getUserDevicesByUserId(
		long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> getUserDevicesByUserEmail(
		java.lang.String userEmail);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> getUserDevicesByDeviceToken(
		java.lang.String deviceToken);

	public com.liferay.contacts.model.FlaskUserDeviceRegistration updateUserDevices(
		long userDeviceRegistrationId, long userId, java.lang.String userEmail,
		java.lang.String devicePlatform, java.lang.String deviceDetails,
		java.lang.String deviceToken, java.util.Date registrationTime,
		java.lang.Boolean active, java.util.Date lastNotificationTime,
		java.lang.String lastNotificationMsg,
		com.liferay.portal.service.ServiceContext serviceContext);

	public void deleteUserDevice(long userDeviceRegistrationId);

	public boolean deactivateUserForUserDevice(long userId,
		java.lang.String deviceToken);

	public boolean activateUserForUserDevice(long userDeviceRegistrationId);
}