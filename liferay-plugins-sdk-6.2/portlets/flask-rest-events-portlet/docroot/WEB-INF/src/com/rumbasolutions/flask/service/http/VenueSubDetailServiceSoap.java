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

import com.rumbasolutions.flask.service.VenueSubDetailServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.rumbasolutions.flask.service.VenueSubDetailServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.rumbasolutions.flask.model.VenueSubDetailSoap}.
 * If the method in the service utility returns a
 * {@link com.rumbasolutions.flask.model.VenueSubDetail}, that is translated to a
 * {@link com.rumbasolutions.flask.model.VenueSubDetailSoap}. Methods that SOAP cannot
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
 * @see VenueSubDetailServiceHttp
 * @see com.rumbasolutions.flask.model.VenueSubDetailSoap
 * @see com.rumbasolutions.flask.service.VenueSubDetailServiceUtil
 * @generated
 */
public class VenueSubDetailServiceSoap {
	public static com.rumbasolutions.flask.model.VenueSubDetailSoap addVenueSubDetail(
		long venueDetailId, java.lang.String venueSubDetailTitle,
		java.lang.String venueSubDetailDesc) throws RemoteException {
		try {
			com.rumbasolutions.flask.model.VenueSubDetail returnValue = VenueSubDetailServiceUtil.addVenueSubDetail(venueDetailId,
					venueSubDetailTitle, venueSubDetailDesc);

			return com.rumbasolutions.flask.model.VenueSubDetailSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueSubDetailSoap[] addVenueSubDetailsByJsonArray(
		long venueDetailId, java.lang.String subDetailJson)
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> returnValue =
				VenueSubDetailServiceUtil.addVenueSubDetailsByJsonArray(venueDetailId,
					subDetailJson);

			return com.rumbasolutions.flask.model.VenueSubDetailSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueSubDetailSoap updateVenueSubDetail(
		long venueSubDetailId, long venueDetailId,
		java.lang.String venueSubDetailTitle,
		java.lang.String venueSubDetailDesc) throws RemoteException {
		try {
			com.rumbasolutions.flask.model.VenueSubDetail returnValue = VenueSubDetailServiceUtil.updateVenueSubDetail(venueSubDetailId,
					venueDetailId, venueSubDetailTitle, venueSubDetailDesc);

			return com.rumbasolutions.flask.model.VenueSubDetailSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueSubDetailSoap getVenueSubDetailById(
		long venueSubDetailId) throws RemoteException {
		try {
			com.rumbasolutions.flask.model.VenueSubDetail returnValue = VenueSubDetailServiceUtil.getVenueSubDetailById(venueSubDetailId);

			return com.rumbasolutions.flask.model.VenueSubDetailSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueSubDetailSoap[] getVenueSubDetailByVenueDetailId(
		long venueDetailId) throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> returnValue =
				VenueSubDetailServiceUtil.getVenueSubDetailByVenueDetailId(venueDetailId);

			return com.rumbasolutions.flask.model.VenueSubDetailSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.VenueSubDetailSoap[] getAllVenueSubDetails()
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.VenueSubDetail> returnValue =
				VenueSubDetailServiceUtil.getAllVenueSubDetails();

			return com.rumbasolutions.flask.model.VenueSubDetailSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deletevenueSubDetailById(long venueSubDetailId)
		throws RemoteException {
		try {
			VenueSubDetailServiceUtil.deletevenueSubDetailById(venueSubDetailId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VenueSubDetailServiceSoap.class);
}