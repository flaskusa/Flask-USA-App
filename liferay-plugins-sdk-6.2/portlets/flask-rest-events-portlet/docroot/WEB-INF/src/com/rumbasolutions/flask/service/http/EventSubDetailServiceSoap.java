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

import com.rumbasolutions.flask.service.EventSubDetailServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.rumbasolutions.flask.service.EventSubDetailServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.rumbasolutions.flask.model.EventSubDetailSoap}.
 * If the method in the service utility returns a
 * {@link com.rumbasolutions.flask.model.EventSubDetail}, that is translated to a
 * {@link com.rumbasolutions.flask.model.EventSubDetailSoap}. Methods that SOAP cannot
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
 * @see EventSubDetailServiceHttp
 * @see com.rumbasolutions.flask.model.EventSubDetailSoap
 * @see com.rumbasolutions.flask.service.EventSubDetailServiceUtil
 * @generated
 */
public class EventSubDetailServiceSoap {
	public static com.rumbasolutions.flask.model.EventSubDetailSoap addEventSubDetail(
		long eventDetailId, java.lang.String eventSubDetailTitle,
		java.lang.String eventSubDetailDesc) throws RemoteException {
		try {
			com.rumbasolutions.flask.model.EventSubDetail returnValue = EventSubDetailServiceUtil.addEventSubDetail(eventDetailId,
					eventSubDetailTitle, eventSubDetailDesc);

			return com.rumbasolutions.flask.model.EventSubDetailSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.EventSubDetailSoap[] addEventSubDetailsByJsonArray(
		long eventDetailId, java.lang.String subDetailJson)
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.EventSubDetail> returnValue =
				EventSubDetailServiceUtil.addEventSubDetailsByJsonArray(eventDetailId,
					subDetailJson);

			return com.rumbasolutions.flask.model.EventSubDetailSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.EventSubDetailSoap updateEventSubDetail(
		long eventSubDetailId, long eventDetailId,
		java.lang.String eventSubDetailTitle,
		java.lang.String eventSubDetailDesc) throws RemoteException {
		try {
			com.rumbasolutions.flask.model.EventSubDetail returnValue = EventSubDetailServiceUtil.updateEventSubDetail(eventSubDetailId,
					eventDetailId, eventSubDetailTitle, eventSubDetailDesc);

			return com.rumbasolutions.flask.model.EventSubDetailSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.EventSubDetailSoap getEventSubDetailById(
		long eventSubDetailId) throws RemoteException {
		try {
			com.rumbasolutions.flask.model.EventSubDetail returnValue = EventSubDetailServiceUtil.getEventSubDetailById(eventSubDetailId);

			return com.rumbasolutions.flask.model.EventSubDetailSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.EventSubDetailSoap[] getEventSubDetailByEventDetailId(
		long eventDetailId) throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.EventSubDetail> returnValue =
				EventSubDetailServiceUtil.getEventSubDetailByEventDetailId(eventDetailId);

			return com.rumbasolutions.flask.model.EventSubDetailSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.EventSubDetailSoap[] getAllEventSubDetails()
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.EventSubDetail> returnValue =
				EventSubDetailServiceUtil.getAllEventSubDetails();

			return com.rumbasolutions.flask.model.EventSubDetailSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteEventSubDetailById(long eventSubDetailId)
		throws RemoteException {
		try {
			EventSubDetailServiceUtil.deleteEventSubDetailById(eventSubDetailId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EventSubDetailServiceSoap.class);
}