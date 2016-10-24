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

package com.rumbasolutions.flask.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.rumbasolutions.flask.service.FlaskAdminServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.rumbasolutions.flask.service.FlaskAdminServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.rumbasolutions.flask.model.FlaskAdminSoap}.
 * If the method in the service utility returns a
 * {@link com.rumbasolutions.flask.model.FlaskAdmin}, that is translated to a
 * {@link com.rumbasolutions.flask.model.FlaskAdminSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Ashutosh Rai
 * @see FlaskAdminServiceHttp
 * @see com.rumbasolutions.flask.model.FlaskAdminSoap
 * @see com.rumbasolutions.flask.service.FlaskAdminServiceUtil
 * @generated
 */
public class FlaskAdminServiceSoap {
	public static com.rumbasolutions.flask.model.FlaskAdminSoap[] getFlaskAdmins(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> returnValue =
				FlaskAdminServiceUtil.getFlaskAdmins(serviceContext);

			return com.rumbasolutions.flask.model.FlaskAdminSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.FlaskAdminSoap[] getFlaskRegularUsers(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> returnValue =
				FlaskAdminServiceUtil.getFlaskRegularUsers(serviceContext);

			return com.rumbasolutions.flask.model.FlaskAdminSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.FlaskAdminSoap addFlaskAdmin(
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.lang.String DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city, long stateId,
		long countryId, java.lang.String mobileNumber,
		java.lang.String userInterests, long roleId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.FlaskAdmin returnValue = FlaskAdminServiceUtil.addFlaskAdmin(firstName,
					middleName, lastName, email, screenName, password1,
					password2, DOB, isMale, streetName, aptNo, areaCode, city,
					stateId, countryId, mobileNumber, userInterests, roleId,
					serviceContext);

			return com.rumbasolutions.flask.model.FlaskAdminSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.FlaskAdminSoap signUp(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String email, java.lang.String screenName,
		java.lang.String password1, java.lang.String password2,
		java.lang.String DOB, boolean isMale, java.lang.String areaCode,
		java.lang.String mobileNumber,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.FlaskAdmin returnValue = FlaskAdminServiceUtil.signUp(firstName,
					lastName, email, screenName, password1, password2, DOB,
					isMale, areaCode, mobileNumber, serviceContext);

			return com.rumbasolutions.flask.model.FlaskAdminSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.FlaskAdminSoap updateFlaskAdmin(
		long userId, java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.lang.String DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city, long stateId,
		long countryId, java.lang.String mobileNumber,
		java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.FlaskAdmin returnValue = FlaskAdminServiceUtil.updateFlaskAdmin(userId,
					firstName, middleName, lastName, email, screenName,
					password1, password2, DOB, isMale, streetName, aptNo,
					areaCode, city, stateId, countryId, mobileNumber,
					userInterests, serviceContext);

			return com.rumbasolutions.flask.model.FlaskAdminSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteFlaskAdmins(long userId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			FlaskAdminServiceUtil.deleteFlaskAdmins(userId, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* Returns valid user id if user found else 0. -1 when there is unknown system exception
	*/
	public static long getUserIdForScreenName(java.lang.String screenName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			long returnValue = FlaskAdminServiceUtil.getUserIdForScreenName(screenName,
					serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* Returns valid user id if user found else 0. -1 when there is unknown system exception
	*/
	public static long getUserIdForEmail(java.lang.String emailAddress,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			long returnValue = FlaskAdminServiceUtil.getUserIdForEmail(emailAddress,
					serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* Returns valid user id if user found else 0. -1 when there is unknown system exception
	*/
	public static com.rumbasolutions.flask.model.FlaskAdminSoap getUserById(
		long userId, com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.FlaskAdmin returnValue = FlaskAdminServiceUtil.getUserById(userId,
					serviceContext);

			return com.rumbasolutions.flask.model.FlaskAdminSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.FlaskAdminSoap addFlaskUser(
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.lang.String DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city, long stateId,
		long countryId, java.lang.String mobileNumber,
		java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.FlaskAdmin returnValue = FlaskAdminServiceUtil.addFlaskUser(firstName,
					middleName, lastName, email, screenName, password1,
					password2, DOB, isMale, streetName, aptNo, areaCode, city,
					stateId, countryId, mobileNumber, userInterests,
					serviceContext);

			return com.rumbasolutions.flask.model.FlaskAdminSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.FlaskAdminSoap updateFlaskUser(
		long userId, java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.lang.String DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city, long stateId,
		long countryId, java.lang.String mobileNumber,
		java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.FlaskAdmin returnValue = FlaskAdminServiceUtil.updateFlaskUser(userId,
					firstName, middleName, lastName, email, screenName,
					password1, password2, DOB, isMale, streetName, aptNo,
					areaCode, city, stateId, countryId, mobileNumber,
					userInterests, serviceContext);

			return com.rumbasolutions.flask.model.FlaskAdminSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.FlaskAdminSoap updateLoggedInUser(
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String email,
		java.lang.String screenName, java.lang.String password1,
		java.lang.String password2, java.lang.String DOB, boolean isMale,
		java.lang.String streetName, java.lang.String aptNo,
		java.lang.String areaCode, java.lang.String city, long stateId,
		long countryId, java.lang.String mobileNumber,
		java.lang.String userInterests,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.FlaskAdmin returnValue = FlaskAdminServiceUtil.updateLoggedInUser(firstName,
					middleName, lastName, email, screenName, password1,
					password2, DOB, isMale, streetName, aptNo, areaCode, city,
					stateId, countryId, mobileNumber, userInterests,
					serviceContext);

			return com.rumbasolutions.flask.model.FlaskAdminSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.Country getCountryByName(
		java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portal.model.Country returnValue = FlaskAdminServiceUtil.getCountryByName(name,
					serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.CountrySoap[] getCountries(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.liferay.portal.model.Country> returnValue = FlaskAdminServiceUtil.getCountries(serviceContext);

			return com.liferay.portal.model.CountrySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.RegionSoap[] getRegion(
		long countryId, com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.liferay.portal.model.Region> returnValue = FlaskAdminServiceUtil.getRegion(countryId,
					serviceContext);

			return com.liferay.portal.model.RegionSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.RegionSoap[] getUSARegions(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.liferay.portal.model.Region> returnValue = FlaskAdminServiceUtil.getUSARegions(serviceContext);

			return com.liferay.portal.model.RegionSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.kernel.repository.model.FileEntrySoap addMyFileEntry(
		long userId, long repositoryId, long folderId,
		java.lang.String sourceFileName, java.lang.String mimeType,
		java.lang.String title, java.lang.String description,
		java.lang.String changeLog, byte[] bytes,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.repository.model.FileEntry returnValue = FlaskAdminServiceUtil.addMyFileEntry(userId,
					repositoryId, folderId, sourceFileName, mimeType, title,
					description, changeLog, bytes, serviceContext);

			return com.liferay.portal.kernel.repository.model.FileEntrySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.kernel.repository.model.FileEntrySoap getMyFileEntry(
		long userId) throws RemoteException {
		try {
			com.liferay.portal.kernel.repository.model.FileEntry returnValue = FlaskAdminServiceUtil.getMyFileEntry(userId);

			return com.liferay.portal.kernel.repository.model.FileEntrySoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteMyFileEntry(long userId) throws RemoteException {
		try {
			FlaskAdminServiceUtil.deleteMyFileEntry(userId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void updateUserForFileEntry(long userId, long fileEntryId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			FlaskAdminServiceUtil.updateUserForFileEntry(userId, fileEntryId,
				serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getUserForEmail(java.lang.String emailAddress,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			int returnValue = FlaskAdminServiceUtil.getUserForEmail(emailAddress,
					serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getUserForScreenName(java.lang.String screenName,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			int returnValue = FlaskAdminServiceUtil.getUserForScreenName(screenName,
					serviceContext);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static long getCompanyId() throws RemoteException {
		try {
			long returnValue = FlaskAdminServiceUtil.getCompanyId();

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean isUserContentAdmin(long userId)
		throws RemoteException {
		try {
			boolean returnValue = FlaskAdminServiceUtil.isUserContentAdmin(userId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FlaskAdminServiceSoap.class);
}