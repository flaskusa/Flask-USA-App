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

import com.rumbasolutions.flask.service.FlaskGroupServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.rumbasolutions.flask.service.FlaskGroupServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.rumbasolutions.flask.model.FlaskGroupSoap}.
 * If the method in the service utility returns a
 * {@link com.rumbasolutions.flask.model.FlaskGroup}, that is translated to a
 * {@link com.rumbasolutions.flask.model.FlaskGroupSoap}. Methods that SOAP cannot
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
 * @author Brian Wing Shun Chan
 * @see FlaskGroupServiceHttp
 * @see com.rumbasolutions.flask.model.FlaskGroupSoap
 * @see com.rumbasolutions.flask.service.FlaskGroupServiceUtil
 * @generated
 */
public class FlaskGroupServiceSoap {
	public static com.rumbasolutions.flask.model.FlaskGroupSoap[] getAllGroups()
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.FlaskGroup> returnValue =
				FlaskGroupServiceUtil.getAllGroups();

			return com.rumbasolutions.flask.model.FlaskGroupSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getAllMyGroups(long userId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = FlaskGroupServiceUtil.getAllMyGroups(userId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.FlaskGroupSoap[] getGroups(
		long userId) throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.FlaskGroup> returnValue =
				FlaskGroupServiceUtil.getGroups(userId);

			return com.rumbasolutions.flask.model.FlaskGroupSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.FlaskGroupSoap[] getMyGroups(
		long userId) throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.FlaskGroup> returnValue =
				FlaskGroupServiceUtil.getMyGroups(userId);

			return com.rumbasolutions.flask.model.FlaskGroupSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.FlaskGroupSoap[] getParticipatingGroups(
		long userId) throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.FlaskGroup> returnValue =
				FlaskGroupServiceUtil.getParticipatingGroups(userId);

			return com.rumbasolutions.flask.model.FlaskGroupSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.FlaskGroupSoap getGroup(
		long groupId) throws RemoteException {
		try {
			com.rumbasolutions.flask.model.FlaskGroup returnValue = FlaskGroupServiceUtil.getGroup(groupId);

			return com.rumbasolutions.flask.model.FlaskGroupSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.FlaskGroupSoap addGroup(
		java.lang.String groupName, java.lang.String groupDescription,
		java.lang.String createdBy, java.lang.String createdDate, int isActive,
		int isDelete, com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.FlaskGroup returnValue = FlaskGroupServiceUtil.addGroup(groupName,
					groupDescription, createdBy, createdDate, isActive,
					isDelete, serviceContext);

			return com.rumbasolutions.flask.model.FlaskGroupSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.FlaskGroupSoap updateGroup(
		long groupId, java.lang.String groupName,
		java.lang.String groupDescription, java.lang.String createdDate,
		java.lang.String createdBy, int isActive, int isDelete)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.FlaskGroup returnValue = FlaskGroupServiceUtil.updateGroup(groupId,
					groupName, groupDescription, createdDate, createdBy,
					isActive, isDelete);

			return com.rumbasolutions.flask.model.FlaskGroupSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteGroup(long groupId) throws RemoteException {
		try {
			FlaskGroupServiceUtil.deleteGroup(groupId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteGroups(java.lang.String groupList,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			FlaskGroupServiceUtil.deleteGroups(groupList, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deactivateGroup(long groupId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			FlaskGroupServiceUtil.deactivateGroup(groupId, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(FlaskGroupServiceSoap.class);
}