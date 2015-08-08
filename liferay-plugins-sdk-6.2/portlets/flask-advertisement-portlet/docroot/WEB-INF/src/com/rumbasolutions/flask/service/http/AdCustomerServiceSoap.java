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

import com.rumbasolutions.flask.service.AdCustomerServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.rumbasolutions.flask.service.AdCustomerServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.rumbasolutions.flask.model.AdCustomerSoap}.
 * If the method in the service utility returns a
 * {@link com.rumbasolutions.flask.model.AdCustomer}, that is translated to a
 * {@link com.rumbasolutions.flask.model.AdCustomerSoap}. Methods that SOAP cannot
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
 * @see AdCustomerServiceHttp
 * @see com.rumbasolutions.flask.model.AdCustomerSoap
 * @see com.rumbasolutions.flask.service.AdCustomerServiceUtil
 * @generated
 */
public class AdCustomerServiceSoap {
	public static com.rumbasolutions.flask.model.AdCustomerSoap[] getAllCustomer()
		throws RemoteException {
		try {
			java.util.List<com.rumbasolutions.flask.model.AdCustomer> returnValue =
				AdCustomerServiceUtil.getAllCustomer();

			return com.rumbasolutions.flask.model.AdCustomerSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.AdCustomerSoap getCustomer(
		long customerId) throws RemoteException {
		try {
			com.rumbasolutions.flask.model.AdCustomer returnValue = AdCustomerServiceUtil.getCustomer(customerId);

			return com.rumbasolutions.flask.model.AdCustomerSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.AdCustomerSoap addCustomer(
		java.lang.String customerName, java.lang.String businessType,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String city, java.lang.String zipCode, long stateId,
		long countryId, java.lang.String businessPhoneNumber,
		java.lang.String contactPersonName,
		java.lang.String contactPersonNumber, java.lang.String email,
		java.lang.String websiteURL,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.AdCustomer returnValue = AdCustomerServiceUtil.addCustomer(customerName,
					businessType, addrLine1, addrLine2, city, zipCode, stateId,
					countryId, businessPhoneNumber, contactPersonName,
					contactPersonNumber, email, websiteURL, serviceContext);

			return com.rumbasolutions.flask.model.AdCustomerSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.rumbasolutions.flask.model.AdCustomerSoap updateCustomer(
		long customerId, java.lang.String customerName,
		java.lang.String businessType, java.lang.String addrLine1,
		java.lang.String addrLine2, java.lang.String city,
		java.lang.String zipCode, long stateId, long countryId,
		java.lang.String businessPhoneNumber,
		java.lang.String contactPersonName,
		java.lang.String contactPersonNumber, java.lang.String email,
		java.lang.String websiteURL,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.rumbasolutions.flask.model.AdCustomer returnValue = AdCustomerServiceUtil.updateCustomer(customerId,
					customerName, businessType, addrLine1, addrLine2, city,
					zipCode, stateId, countryId, businessPhoneNumber,
					contactPersonName, contactPersonNumber, email, websiteURL,
					serviceContext);

			return com.rumbasolutions.flask.model.AdCustomerSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteCustomer(long customerId)
		throws RemoteException {
		try {
			AdCustomerServiceUtil.deleteCustomer(customerId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteCustomers(java.lang.String customerList)
		throws RemoteException {
		try {
			AdCustomerServiceUtil.deleteCustomers(customerList);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AdCustomerServiceSoap.class);
}