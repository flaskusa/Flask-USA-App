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

package com.rumbasolutions.flask.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AdCustomer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdCustomer
 * @generated
 */
public class AdCustomerWrapper implements AdCustomer, ModelWrapper<AdCustomer> {
	public AdCustomerWrapper(AdCustomer adCustomer) {
		_adCustomer = adCustomer;
	}

	@Override
	public Class<?> getModelClass() {
		return AdCustomer.class;
	}

	@Override
	public String getModelClassName() {
		return AdCustomer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("customerId", getCustomerId());
		attributes.put("userId", getUserId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("customerName", getCustomerName());
		attributes.put("businessType", getBusinessType());
		attributes.put("addrLine1", getAddrLine1());
		attributes.put("addrLine2", getAddrLine2());
		attributes.put("city", getCity());
		attributes.put("zipCode", getZipCode());
		attributes.put("stateId", getStateId());
		attributes.put("countryId", getCountryId());
		attributes.put("email", getEmail());
		attributes.put("websiteURL", getWebsiteURL());
		attributes.put("businessPhoneNumber", getBusinessPhoneNumber());
		attributes.put("contactPersonName", getContactPersonName());
		attributes.put("contactPersonNumber", getContactPersonNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long customerId = (Long)attributes.get("customerId");

		if (customerId != null) {
			setCustomerId(customerId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String customerName = (String)attributes.get("customerName");

		if (customerName != null) {
			setCustomerName(customerName);
		}

		String businessType = (String)attributes.get("businessType");

		if (businessType != null) {
			setBusinessType(businessType);
		}

		String addrLine1 = (String)attributes.get("addrLine1");

		if (addrLine1 != null) {
			setAddrLine1(addrLine1);
		}

		String addrLine2 = (String)attributes.get("addrLine2");

		if (addrLine2 != null) {
			setAddrLine2(addrLine2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		Long stateId = (Long)attributes.get("stateId");

		if (stateId != null) {
			setStateId(stateId);
		}

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String websiteURL = (String)attributes.get("websiteURL");

		if (websiteURL != null) {
			setWebsiteURL(websiteURL);
		}

		String businessPhoneNumber = (String)attributes.get(
				"businessPhoneNumber");

		if (businessPhoneNumber != null) {
			setBusinessPhoneNumber(businessPhoneNumber);
		}

		String contactPersonName = (String)attributes.get("contactPersonName");

		if (contactPersonName != null) {
			setContactPersonName(contactPersonName);
		}

		String contactPersonNumber = (String)attributes.get(
				"contactPersonNumber");

		if (contactPersonNumber != null) {
			setContactPersonNumber(contactPersonNumber);
		}
	}

	/**
	* Returns the primary key of this ad customer.
	*
	* @return the primary key of this ad customer
	*/
	@Override
	public long getPrimaryKey() {
		return _adCustomer.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ad customer.
	*
	* @param primaryKey the primary key of this ad customer
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_adCustomer.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the customer ID of this ad customer.
	*
	* @return the customer ID of this ad customer
	*/
	@Override
	public long getCustomerId() {
		return _adCustomer.getCustomerId();
	}

	/**
	* Sets the customer ID of this ad customer.
	*
	* @param customerId the customer ID of this ad customer
	*/
	@Override
	public void setCustomerId(long customerId) {
		_adCustomer.setCustomerId(customerId);
	}

	/**
	* Returns the user ID of this ad customer.
	*
	* @return the user ID of this ad customer
	*/
	@Override
	public long getUserId() {
		return _adCustomer.getUserId();
	}

	/**
	* Sets the user ID of this ad customer.
	*
	* @param userId the user ID of this ad customer
	*/
	@Override
	public void setUserId(long userId) {
		_adCustomer.setUserId(userId);
	}

	/**
	* Returns the user uuid of this ad customer.
	*
	* @return the user uuid of this ad customer
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _adCustomer.getUserUuid();
	}

	/**
	* Sets the user uuid of this ad customer.
	*
	* @param userUuid the user uuid of this ad customer
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_adCustomer.setUserUuid(userUuid);
	}

	/**
	* Returns the created date of this ad customer.
	*
	* @return the created date of this ad customer
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _adCustomer.getCreatedDate();
	}

	/**
	* Sets the created date of this ad customer.
	*
	* @param createdDate the created date of this ad customer
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_adCustomer.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this ad customer.
	*
	* @return the modified date of this ad customer
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _adCustomer.getModifiedDate();
	}

	/**
	* Sets the modified date of this ad customer.
	*
	* @param modifiedDate the modified date of this ad customer
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_adCustomer.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the customer name of this ad customer.
	*
	* @return the customer name of this ad customer
	*/
	@Override
	public java.lang.String getCustomerName() {
		return _adCustomer.getCustomerName();
	}

	/**
	* Sets the customer name of this ad customer.
	*
	* @param customerName the customer name of this ad customer
	*/
	@Override
	public void setCustomerName(java.lang.String customerName) {
		_adCustomer.setCustomerName(customerName);
	}

	/**
	* Returns the business type of this ad customer.
	*
	* @return the business type of this ad customer
	*/
	@Override
	public java.lang.String getBusinessType() {
		return _adCustomer.getBusinessType();
	}

	/**
	* Sets the business type of this ad customer.
	*
	* @param businessType the business type of this ad customer
	*/
	@Override
	public void setBusinessType(java.lang.String businessType) {
		_adCustomer.setBusinessType(businessType);
	}

	/**
	* Returns the addr line1 of this ad customer.
	*
	* @return the addr line1 of this ad customer
	*/
	@Override
	public java.lang.String getAddrLine1() {
		return _adCustomer.getAddrLine1();
	}

	/**
	* Sets the addr line1 of this ad customer.
	*
	* @param addrLine1 the addr line1 of this ad customer
	*/
	@Override
	public void setAddrLine1(java.lang.String addrLine1) {
		_adCustomer.setAddrLine1(addrLine1);
	}

	/**
	* Returns the addr line2 of this ad customer.
	*
	* @return the addr line2 of this ad customer
	*/
	@Override
	public java.lang.String getAddrLine2() {
		return _adCustomer.getAddrLine2();
	}

	/**
	* Sets the addr line2 of this ad customer.
	*
	* @param addrLine2 the addr line2 of this ad customer
	*/
	@Override
	public void setAddrLine2(java.lang.String addrLine2) {
		_adCustomer.setAddrLine2(addrLine2);
	}

	/**
	* Returns the city of this ad customer.
	*
	* @return the city of this ad customer
	*/
	@Override
	public java.lang.String getCity() {
		return _adCustomer.getCity();
	}

	/**
	* Sets the city of this ad customer.
	*
	* @param city the city of this ad customer
	*/
	@Override
	public void setCity(java.lang.String city) {
		_adCustomer.setCity(city);
	}

	/**
	* Returns the zip code of this ad customer.
	*
	* @return the zip code of this ad customer
	*/
	@Override
	public java.lang.String getZipCode() {
		return _adCustomer.getZipCode();
	}

	/**
	* Sets the zip code of this ad customer.
	*
	* @param zipCode the zip code of this ad customer
	*/
	@Override
	public void setZipCode(java.lang.String zipCode) {
		_adCustomer.setZipCode(zipCode);
	}

	/**
	* Returns the state ID of this ad customer.
	*
	* @return the state ID of this ad customer
	*/
	@Override
	public long getStateId() {
		return _adCustomer.getStateId();
	}

	/**
	* Sets the state ID of this ad customer.
	*
	* @param stateId the state ID of this ad customer
	*/
	@Override
	public void setStateId(long stateId) {
		_adCustomer.setStateId(stateId);
	}

	/**
	* Returns the country ID of this ad customer.
	*
	* @return the country ID of this ad customer
	*/
	@Override
	public long getCountryId() {
		return _adCustomer.getCountryId();
	}

	/**
	* Sets the country ID of this ad customer.
	*
	* @param countryId the country ID of this ad customer
	*/
	@Override
	public void setCountryId(long countryId) {
		_adCustomer.setCountryId(countryId);
	}

	/**
	* Returns the email of this ad customer.
	*
	* @return the email of this ad customer
	*/
	@Override
	public java.lang.String getEmail() {
		return _adCustomer.getEmail();
	}

	/**
	* Sets the email of this ad customer.
	*
	* @param email the email of this ad customer
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_adCustomer.setEmail(email);
	}

	/**
	* Returns the website u r l of this ad customer.
	*
	* @return the website u r l of this ad customer
	*/
	@Override
	public java.lang.String getWebsiteURL() {
		return _adCustomer.getWebsiteURL();
	}

	/**
	* Sets the website u r l of this ad customer.
	*
	* @param websiteURL the website u r l of this ad customer
	*/
	@Override
	public void setWebsiteURL(java.lang.String websiteURL) {
		_adCustomer.setWebsiteURL(websiteURL);
	}

	/**
	* Returns the business phone number of this ad customer.
	*
	* @return the business phone number of this ad customer
	*/
	@Override
	public java.lang.String getBusinessPhoneNumber() {
		return _adCustomer.getBusinessPhoneNumber();
	}

	/**
	* Sets the business phone number of this ad customer.
	*
	* @param businessPhoneNumber the business phone number of this ad customer
	*/
	@Override
	public void setBusinessPhoneNumber(java.lang.String businessPhoneNumber) {
		_adCustomer.setBusinessPhoneNumber(businessPhoneNumber);
	}

	/**
	* Returns the contact person name of this ad customer.
	*
	* @return the contact person name of this ad customer
	*/
	@Override
	public java.lang.String getContactPersonName() {
		return _adCustomer.getContactPersonName();
	}

	/**
	* Sets the contact person name of this ad customer.
	*
	* @param contactPersonName the contact person name of this ad customer
	*/
	@Override
	public void setContactPersonName(java.lang.String contactPersonName) {
		_adCustomer.setContactPersonName(contactPersonName);
	}

	/**
	* Returns the contact person number of this ad customer.
	*
	* @return the contact person number of this ad customer
	*/
	@Override
	public java.lang.String getContactPersonNumber() {
		return _adCustomer.getContactPersonNumber();
	}

	/**
	* Sets the contact person number of this ad customer.
	*
	* @param contactPersonNumber the contact person number of this ad customer
	*/
	@Override
	public void setContactPersonNumber(java.lang.String contactPersonNumber) {
		_adCustomer.setContactPersonNumber(contactPersonNumber);
	}

	@Override
	public boolean isNew() {
		return _adCustomer.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_adCustomer.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _adCustomer.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_adCustomer.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _adCustomer.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _adCustomer.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_adCustomer.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _adCustomer.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_adCustomer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_adCustomer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_adCustomer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AdCustomerWrapper((AdCustomer)_adCustomer.clone());
	}

	@Override
	public int compareTo(com.rumbasolutions.flask.model.AdCustomer adCustomer) {
		return _adCustomer.compareTo(adCustomer);
	}

	@Override
	public int hashCode() {
		return _adCustomer.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rumbasolutions.flask.model.AdCustomer> toCacheModel() {
		return _adCustomer.toCacheModel();
	}

	@Override
	public com.rumbasolutions.flask.model.AdCustomer toEscapedModel() {
		return new AdCustomerWrapper(_adCustomer.toEscapedModel());
	}

	@Override
	public com.rumbasolutions.flask.model.AdCustomer toUnescapedModel() {
		return new AdCustomerWrapper(_adCustomer.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _adCustomer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _adCustomer.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_adCustomer.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdCustomerWrapper)) {
			return false;
		}

		AdCustomerWrapper adCustomerWrapper = (AdCustomerWrapper)obj;

		if (Validator.equals(_adCustomer, adCustomerWrapper._adCustomer)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AdCustomer getWrappedAdCustomer() {
		return _adCustomer;
	}

	@Override
	public AdCustomer getWrappedModel() {
		return _adCustomer;
	}

	@Override
	public void resetOriginalValues() {
		_adCustomer.resetOriginalValues();
	}

	private AdCustomer _adCustomer;
}