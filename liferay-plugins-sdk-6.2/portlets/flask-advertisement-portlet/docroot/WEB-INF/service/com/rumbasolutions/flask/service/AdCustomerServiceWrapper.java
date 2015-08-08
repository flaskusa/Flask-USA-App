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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AdCustomerService}.
 *
 * @author Brian Wing Shun Chan
 * @see AdCustomerService
 * @generated
 */
public class AdCustomerServiceWrapper implements AdCustomerService,
	ServiceWrapper<AdCustomerService> {
	public AdCustomerServiceWrapper(AdCustomerService adCustomerService) {
		_adCustomerService = adCustomerService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _adCustomerService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_adCustomerService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _adCustomerService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.rumbasolutions.flask.model.AdCustomer> getAllCustomer() {
		return _adCustomerService.getAllCustomer();
	}

	@Override
	public com.rumbasolutions.flask.model.AdCustomer getCustomer(
		long customerId) {
		return _adCustomerService.getCustomer(customerId);
	}

	@Override
	public com.rumbasolutions.flask.model.AdCustomer addCustomer(
		java.lang.String customerName, java.lang.String businessType,
		java.lang.String addrLine1, java.lang.String addrLine2,
		java.lang.String city, java.lang.String zipCode, long stateId,
		long countryId, java.lang.String businessPhoneNumber,
		java.lang.String contactPersonName,
		java.lang.String contactPersonNumber, java.lang.String email,
		java.lang.String websiteURL,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _adCustomerService.addCustomer(customerName, businessType,
			addrLine1, addrLine2, city, zipCode, stateId, countryId,
			businessPhoneNumber, contactPersonName, contactPersonNumber, email,
			websiteURL, serviceContext);
	}

	@Override
	public com.rumbasolutions.flask.model.AdCustomer updateCustomer(
		long customerId, java.lang.String customerName,
		java.lang.String businessType, java.lang.String addrLine1,
		java.lang.String addrLine2, java.lang.String city,
		java.lang.String zipCode, long stateId, long countryId,
		java.lang.String businessPhoneNumber,
		java.lang.String contactPersonName,
		java.lang.String contactPersonNumber, java.lang.String email,
		java.lang.String websiteURL,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _adCustomerService.updateCustomer(customerId, customerName,
			businessType, addrLine1, addrLine2, city, zipCode, stateId,
			countryId, businessPhoneNumber, contactPersonName,
			contactPersonNumber, email, websiteURL, serviceContext);
	}

	@Override
	public void deleteCustomer(long customerId) {
		_adCustomerService.deleteCustomer(customerId);
	}

	@Override
	public void deleteCustomers(java.lang.String customerList) {
		_adCustomerService.deleteCustomers(customerList);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AdCustomerService getWrappedAdCustomerService() {
		return _adCustomerService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAdCustomerService(AdCustomerService adCustomerService) {
		_adCustomerService = adCustomerService;
	}

	@Override
	public AdCustomerService getWrappedService() {
		return _adCustomerService;
	}

	@Override
	public void setWrappedService(AdCustomerService adCustomerService) {
		_adCustomerService = adCustomerService;
	}

	private AdCustomerService _adCustomerService;
}