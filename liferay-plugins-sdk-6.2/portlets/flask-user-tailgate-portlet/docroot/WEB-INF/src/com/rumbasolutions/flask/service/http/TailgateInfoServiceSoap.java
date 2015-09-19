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

import com.rumbasolutions.flask.service.TailgateInfoServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.rumbasolutions.flask.service.TailgateInfoServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.rumbasolutions.flask.model.TailgateInfoSoap}.
 * If the method in the service utility returns a
 * {@link com.rumbasolutions.flask.model.TailgateInfo}, that is translated to a
 * {@link com.rumbasolutions.flask.model.TailgateInfoSoap}. Methods that SOAP cannot
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
 * @see TailgateInfoServiceHttp
 * @see com.rumbasolutions.flask.model.TailgateInfoSoap
 * @see com.rumbasolutions.flask.service.TailgateInfoServiceUtil
 * @generated
 */
public class TailgateInfoServiceSoap {
	public static com.rumbasolutions.flask.model.TailgateInfoSoap addTailgateInfo(
		java.lang.String tailgateName, java.lang.String tailgateDescription,
		long eventId, java.lang.String eventName, java.util.Date tailgateDate,
		long startTime, long endTime, java.lang.String venmoAccountId,
		long amountToPay,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.TailgateInfo returnValue = TailgateInfoServiceUtil.addTailgateInfo(tailgateName,
					tailgateDescription, eventId, eventName, tailgateDate,
					startTime, endTime, venmoAccountId, amountToPay,
					serviceContext);

			return com.rumbasolutions.flask.model.TailgateInfoSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.TailgateInfoSoap[] getAllTailgate()
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.TailgateInfo> returnValue =
				TailgateInfoServiceUtil.getAllTailgate();

			return com.rumbasolutions.flask.model.TailgateInfoSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.TailgateInfoSoap[] getAllMyTailgate(
		long userId) throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.TailgateInfo> returnValue =
				TailgateInfoServiceUtil.getAllMyTailgate(userId);

			return com.rumbasolutions.flask.model.TailgateInfoSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.TailgateInfoSoap[] getAllTailgeteByUserId(
		long userId) throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.TailgateInfo> returnValue =
				TailgateInfoServiceUtil.getAllTailgeteByUserId(userId);

			return com.rumbasolutions.flask.model.TailgateInfoSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.TailgateInfoSoap getTailgate(
		int tailgateId) throws RemoteException {
		try {
			com.rumbasolutions.flask.model.TailgateInfo returnValue = TailgateInfoServiceUtil.getTailgate(tailgateId);

			return com.rumbasolutions.flask.model.TailgateInfoSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.TailgateInfoSoap updateTailgateInfo(
		long tailgateId, java.lang.String tailgateName,
		java.lang.String tailgateDescription, long eventId,
		java.lang.String eventName, java.util.Date tailgateDate,
		long startTime, long endTime, java.lang.String venmoAccountId,
		long amountToPay,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.TailgateInfo returnValue = TailgateInfoServiceUtil.updateTailgateInfo(tailgateId,
					tailgateName, tailgateDescription, eventId, eventName,
					tailgateDate, startTime, endTime, venmoAccountId,
					amountToPay, serviceContext);

			return com.rumbasolutions.flask.model.TailgateInfoSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteTailgateInfo(long tailgateId)
		throws RemoteException {
		try {
			TailgateInfoServiceUtil.deleteTailgateInfo(tailgateId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TailgateInfoServiceSoap.class);
}