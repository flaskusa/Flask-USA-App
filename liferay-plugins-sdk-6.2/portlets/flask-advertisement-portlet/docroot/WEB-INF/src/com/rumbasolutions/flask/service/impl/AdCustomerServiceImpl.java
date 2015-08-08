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

package com.rumbasolutions.flask.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.model.AdCustomer;
import com.rumbasolutions.flask.service.AdCustomerLocalServiceUtil;
import com.rumbasolutions.flask.service.base.AdCustomerServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.AdCustomerUtil;

/**
 * The implementation of the ad customer remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.AdCustomerService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.base.AdCustomerServiceBaseImpl
 * @see com.rumbasolutions.flask.service.AdCustomerServiceUtil
 */
public class AdCustomerServiceImpl extends AdCustomerServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.AdCustomerServiceUtil} to access the ad customer remote service.
	 */
	
	private static Log LOGGER = LogFactoryUtil.getLog(AdCustomerServiceImpl.class);

	
	@Override
	public List<AdCustomer> getAllCustomer() {
		List<AdCustomer> customerList = new ArrayList<AdCustomer>();
		try {
			customerList = AdCustomerUtil.findAll();
		} catch (SystemException e) {
			LOGGER.error("Exception in getAdCustomers :" + e.getMessage());
			e.printStackTrace();
		}
		return customerList;
	}
	
	@Override
	public AdCustomer getCustomer(long customerId) {
		AdCustomer customer = null;
		try {
			customer = AdCustomerUtil.fetchByPrimaryKey(customerId);
		} catch (SystemException e) {
			LOGGER.error("Exception in getAdCustomers :" + e.getMessage());
			e.printStackTrace();
		}
		return customer;
	}
	

	@Override
	public AdCustomer addCustomer(String customerName, String businessType,
			String addrLine1, String addrLine2,
			String city, String zipCode, long stateId, long countryId,
			String businessPhoneNumber, String contactPersonName, String contactPersonNumber,
			String email, String websiteURL, ServiceContext serviceContext) {
		AdCustomer adCustomer = null;
		try {
			adCustomer = AdCustomerLocalServiceUtil
					.createAdCustomer(CounterLocalServiceUtil.increment());
			adCustomer.setCustomerName(customerName);
			adCustomer.setBusinessType(businessType);
			adCustomer.setAddrLine1(addrLine1);
			adCustomer.setAddrLine2(addrLine2);
			adCustomer.setCity(city);
			adCustomer.setZipCode(zipCode);
			adCustomer.setStateId(stateId);
			adCustomer.setCountryId(countryId);
			adCustomer.setBusinessPhoneNumber(businessPhoneNumber);
			adCustomer.setContactPersonName(contactPersonName);
			adCustomer.setContactPersonNumber(contactPersonNumber);
			adCustomer.setEmail(email);
			adCustomer.setWebsiteURL(websiteURL);

			Date dt = new Date();
			adCustomer.setCreatedDate(dt);
			adCustomer.setModifiedDate(dt);
			adCustomer.setUserId(serviceContext.getUserId());


			adCustomer = AdCustomerLocalServiceUtil.addAdCustomer(adCustomer);

		} catch (SystemException e) {
			LOGGER.error(" Exception in Add Customer :" + e.getMessage());
			e.printStackTrace();
		}
		return adCustomer;
	}

	@Override
	public AdCustomer updateCustomer(long customerId, String customerName, 
			String businessType, String addrLine1, String addrLine2,
			String city, String zipCode, long stateId, long countryId,
			String businessPhoneNumber, String contactPersonName, String contactPersonNumber,
			String email, String websiteURL, ServiceContext serviceContext) {
		AdCustomer adCustomer = null;
		try {
			adCustomer = AdCustomerLocalServiceUtil.getAdCustomer(customerId);
			adCustomer.setCustomerName(customerName);
			adCustomer.setBusinessType(businessType);
			adCustomer.setAddrLine1(addrLine1);
			adCustomer.setAddrLine2(addrLine2);
			adCustomer.setCity(city);
			adCustomer.setZipCode(zipCode);
			adCustomer.setStateId(stateId);
			adCustomer.setCountryId(countryId);
			adCustomer.setBusinessPhoneNumber(businessPhoneNumber);
			adCustomer.setContactPersonName(contactPersonName);
			adCustomer.setContactPersonNumber(contactPersonNumber);
			adCustomer.setEmail(email);
			adCustomer.setWebsiteURL(websiteURL);
			
			
			Date dt = new Date();
			adCustomer.setModifiedDate(dt);
			adCustomer.setUserId(serviceContext.getUserId());


			adCustomer = AdCustomerLocalServiceUtil
					.updateAdCustomer(adCustomer);

		} catch (PortalException e) {
			LOGGER.error(" Exception in Update Customer :" + e.getMessage());
			e.printStackTrace();
		} catch (SystemException e) {
			LOGGER.error(" Exception in Update Customer :" + e.getMessage());
			e.printStackTrace();
		}
		return adCustomer;
	}

	@Override
	public void deleteCustomer(long customerId) {
		try {
			AdCustomerLocalServiceUtil.deleteAdCustomer(customerId);
		} catch (PortalException e) {
			LOGGER.error("Exception in Delete Customer : " + e.getMessage());
			e.printStackTrace();
		} catch (SystemException e) {
			LOGGER.error("Exception in Delete Customer : " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomers(String customerList) {

		String[] customerArray = customerList.split(",");
		for (String customerId : customerArray) {
			try {
				AdCustomerLocalServiceUtil.deleteAdCustomer(Long.parseLong(customerId));
			} catch (PortalException e) {
				LOGGER.error("Error in deleting customer:" + customerId);
			} catch (SystemException e) {
				LOGGER.error("Error in deleting customer:" + customerId);
			}
		}
	}
}