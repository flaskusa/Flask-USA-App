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

import com.rumbasolutions.flask.service.SupplyItemServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.rumbasolutions.flask.service.SupplyItemServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.rumbasolutions.flask.model.SupplyItemSoap}.
 * If the method in the service utility returns a
 * {@link com.rumbasolutions.flask.model.SupplyItem}, that is translated to a
 * {@link com.rumbasolutions.flask.model.SupplyItemSoap}. Methods that SOAP cannot
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
 * @see SupplyItemServiceHttp
 * @see com.rumbasolutions.flask.model.SupplyItemSoap
 * @see com.rumbasolutions.flask.service.SupplyItemServiceUtil
 * @generated
 */
public class SupplyItemServiceSoap {
	public static com.rumbasolutions.flask.model.SupplyItemSoap addSupplyItem(
		java.lang.String supplyItemName, long supplyListId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.SupplyItem returnValue = SupplyItemServiceUtil.addSupplyItem(supplyItemName,
					supplyListId, serviceContext);

			return com.rumbasolutions.flask.model.SupplyItemSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.SupplyItemSoap[] addSupplyItems(
		java.lang.String[] supplyItemNames, long supplyListId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.SupplyItem> returnValue =
				SupplyItemServiceUtil.addSupplyItems(supplyItemNames,
					supplyListId, serviceContext);

			return com.rumbasolutions.flask.model.SupplyItemSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.SupplyItemSoap updateSupplyItem(
		long supplyItemId, java.lang.String supplyItemName, long supplyListId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.SupplyItem returnValue = SupplyItemServiceUtil.updateSupplyItem(supplyItemId,
					supplyItemName, supplyListId, serviceContext);

			return com.rumbasolutions.flask.model.SupplyItemSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.SupplyItemSoap getSupplyItem(
		long supplyItemId) throws RemoteException {
		try {
			com.rumbasolutions.flask.model.SupplyItem returnValue = SupplyItemServiceUtil.getSupplyItem(supplyItemId);

			return com.rumbasolutions.flask.model.SupplyItemSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.SupplyItemSoap[] getAllSupplyItems(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.SupplyItem> returnValue =
				SupplyItemServiceUtil.getAllSupplyItems(serviceContext);

			return com.rumbasolutions.flask.model.SupplyItemSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.SupplyItemSoap[] getItemsByListId(
		long supplyListId) throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.SupplyItem> returnValue =
				SupplyItemServiceUtil.getItemsByListId(supplyListId);

			return com.rumbasolutions.flask.model.SupplyItemSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteSupplyItem(long supplyItemId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			SupplyItemServiceUtil.deleteSupplyItem(supplyItemId, serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteItemsByListId(long supplyListId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			SupplyItemServiceUtil.deleteItemsByListId(supplyListId,
				serviceContext);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SupplyItemServiceSoap.class);
}