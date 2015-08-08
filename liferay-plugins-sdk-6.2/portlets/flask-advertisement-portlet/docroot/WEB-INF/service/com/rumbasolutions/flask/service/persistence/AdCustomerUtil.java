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

package com.rumbasolutions.flask.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rumbasolutions.flask.model.AdCustomer;

import java.util.List;

/**
 * The persistence utility for the ad customer service. This utility wraps {@link AdCustomerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdCustomerPersistence
 * @see AdCustomerPersistenceImpl
 * @generated
 */
public class AdCustomerUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(AdCustomer adCustomer) {
		getPersistence().clearCache(adCustomer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AdCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AdCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AdCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AdCustomer update(AdCustomer adCustomer)
		throws SystemException {
		return getPersistence().update(adCustomer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AdCustomer update(AdCustomer adCustomer,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(adCustomer, serviceContext);
	}

	/**
	* Returns all the ad customers where customerName = &#63;.
	*
	* @param customerName the customer name
	* @return the matching ad customers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.AdCustomer> findBycustomerName(
		java.lang.String customerName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycustomerName(customerName);
	}

	/**
	* Returns a range of all the ad customers where customerName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param customerName the customer name
	* @param start the lower bound of the range of ad customers
	* @param end the upper bound of the range of ad customers (not inclusive)
	* @return the range of matching ad customers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.AdCustomer> findBycustomerName(
		java.lang.String customerName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycustomerName(customerName, start, end);
	}

	/**
	* Returns an ordered range of all the ad customers where customerName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param customerName the customer name
	* @param start the lower bound of the range of ad customers
	* @param end the upper bound of the range of ad customers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ad customers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.AdCustomer> findBycustomerName(
		java.lang.String customerName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycustomerName(customerName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first ad customer in the ordered set where customerName = &#63;.
	*
	* @param customerName the customer name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad customer
	* @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a matching ad customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.AdCustomer findBycustomerName_First(
		java.lang.String customerName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchAdCustomerException {
		return getPersistence()
				   .findBycustomerName_First(customerName, orderByComparator);
	}

	/**
	* Returns the first ad customer in the ordered set where customerName = &#63;.
	*
	* @param customerName the customer name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad customer, or <code>null</code> if a matching ad customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.AdCustomer fetchBycustomerName_First(
		java.lang.String customerName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycustomerName_First(customerName, orderByComparator);
	}

	/**
	* Returns the last ad customer in the ordered set where customerName = &#63;.
	*
	* @param customerName the customer name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad customer
	* @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a matching ad customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.AdCustomer findBycustomerName_Last(
		java.lang.String customerName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchAdCustomerException {
		return getPersistence()
				   .findBycustomerName_Last(customerName, orderByComparator);
	}

	/**
	* Returns the last ad customer in the ordered set where customerName = &#63;.
	*
	* @param customerName the customer name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad customer, or <code>null</code> if a matching ad customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.AdCustomer fetchBycustomerName_Last(
		java.lang.String customerName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycustomerName_Last(customerName, orderByComparator);
	}

	/**
	* Returns the ad customers before and after the current ad customer in the ordered set where customerName = &#63;.
	*
	* @param customerId the primary key of the current ad customer
	* @param customerName the customer name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ad customer
	* @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a ad customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.AdCustomer[] findBycustomerName_PrevAndNext(
		long customerId, java.lang.String customerName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchAdCustomerException {
		return getPersistence()
				   .findBycustomerName_PrevAndNext(customerId, customerName,
			orderByComparator);
	}

	/**
	* Removes all the ad customers where customerName = &#63; from the database.
	*
	* @param customerName the customer name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycustomerName(java.lang.String customerName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycustomerName(customerName);
	}

	/**
	* Returns the number of ad customers where customerName = &#63;.
	*
	* @param customerName the customer name
	* @return the number of matching ad customers
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycustomerName(java.lang.String customerName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycustomerName(customerName);
	}

	/**
	* Returns all the ad customers where contactPersonName = &#63;.
	*
	* @param contactPersonName the contact person name
	* @return the matching ad customers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.AdCustomer> findBycontactPersonName(
		java.lang.String contactPersonName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycontactPersonName(contactPersonName);
	}

	/**
	* Returns a range of all the ad customers where contactPersonName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contactPersonName the contact person name
	* @param start the lower bound of the range of ad customers
	* @param end the upper bound of the range of ad customers (not inclusive)
	* @return the range of matching ad customers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.AdCustomer> findBycontactPersonName(
		java.lang.String contactPersonName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycontactPersonName(contactPersonName, start, end);
	}

	/**
	* Returns an ordered range of all the ad customers where contactPersonName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contactPersonName the contact person name
	* @param start the lower bound of the range of ad customers
	* @param end the upper bound of the range of ad customers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ad customers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.AdCustomer> findBycontactPersonName(
		java.lang.String contactPersonName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycontactPersonName(contactPersonName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first ad customer in the ordered set where contactPersonName = &#63;.
	*
	* @param contactPersonName the contact person name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad customer
	* @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a matching ad customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.AdCustomer findBycontactPersonName_First(
		java.lang.String contactPersonName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchAdCustomerException {
		return getPersistence()
				   .findBycontactPersonName_First(contactPersonName,
			orderByComparator);
	}

	/**
	* Returns the first ad customer in the ordered set where contactPersonName = &#63;.
	*
	* @param contactPersonName the contact person name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ad customer, or <code>null</code> if a matching ad customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.AdCustomer fetchBycontactPersonName_First(
		java.lang.String contactPersonName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycontactPersonName_First(contactPersonName,
			orderByComparator);
	}

	/**
	* Returns the last ad customer in the ordered set where contactPersonName = &#63;.
	*
	* @param contactPersonName the contact person name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad customer
	* @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a matching ad customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.AdCustomer findBycontactPersonName_Last(
		java.lang.String contactPersonName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchAdCustomerException {
		return getPersistence()
				   .findBycontactPersonName_Last(contactPersonName,
			orderByComparator);
	}

	/**
	* Returns the last ad customer in the ordered set where contactPersonName = &#63;.
	*
	* @param contactPersonName the contact person name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ad customer, or <code>null</code> if a matching ad customer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.AdCustomer fetchBycontactPersonName_Last(
		java.lang.String contactPersonName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycontactPersonName_Last(contactPersonName,
			orderByComparator);
	}

	/**
	* Returns the ad customers before and after the current ad customer in the ordered set where contactPersonName = &#63;.
	*
	* @param customerId the primary key of the current ad customer
	* @param contactPersonName the contact person name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ad customer
	* @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a ad customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.AdCustomer[] findBycontactPersonName_PrevAndNext(
		long customerId, java.lang.String contactPersonName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchAdCustomerException {
		return getPersistence()
				   .findBycontactPersonName_PrevAndNext(customerId,
			contactPersonName, orderByComparator);
	}

	/**
	* Removes all the ad customers where contactPersonName = &#63; from the database.
	*
	* @param contactPersonName the contact person name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycontactPersonName(
		java.lang.String contactPersonName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycontactPersonName(contactPersonName);
	}

	/**
	* Returns the number of ad customers where contactPersonName = &#63;.
	*
	* @param contactPersonName the contact person name
	* @return the number of matching ad customers
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycontactPersonName(
		java.lang.String contactPersonName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycontactPersonName(contactPersonName);
	}

	/**
	* Caches the ad customer in the entity cache if it is enabled.
	*
	* @param adCustomer the ad customer
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.AdCustomer adCustomer) {
		getPersistence().cacheResult(adCustomer);
	}

	/**
	* Caches the ad customers in the entity cache if it is enabled.
	*
	* @param adCustomers the ad customers
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.AdCustomer> adCustomers) {
		getPersistence().cacheResult(adCustomers);
	}

	/**
	* Creates a new ad customer with the primary key. Does not add the ad customer to the database.
	*
	* @param customerId the primary key for the new ad customer
	* @return the new ad customer
	*/
	public static com.rumbasolutions.flask.model.AdCustomer create(
		long customerId) {
		return getPersistence().create(customerId);
	}

	/**
	* Removes the ad customer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param customerId the primary key of the ad customer
	* @return the ad customer that was removed
	* @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a ad customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.AdCustomer remove(
		long customerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchAdCustomerException {
		return getPersistence().remove(customerId);
	}

	public static com.rumbasolutions.flask.model.AdCustomer updateImpl(
		com.rumbasolutions.flask.model.AdCustomer adCustomer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(adCustomer);
	}

	/**
	* Returns the ad customer with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchAdCustomerException} if it could not be found.
	*
	* @param customerId the primary key of the ad customer
	* @return the ad customer
	* @throws com.rumbasolutions.flask.NoSuchAdCustomerException if a ad customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.AdCustomer findByPrimaryKey(
		long customerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchAdCustomerException {
		return getPersistence().findByPrimaryKey(customerId);
	}

	/**
	* Returns the ad customer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param customerId the primary key of the ad customer
	* @return the ad customer, or <code>null</code> if a ad customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.AdCustomer fetchByPrimaryKey(
		long customerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(customerId);
	}

	/**
	* Returns all the ad customers.
	*
	* @return the ad customers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.AdCustomer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ad customers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ad customers
	* @param end the upper bound of the range of ad customers (not inclusive)
	* @return the range of ad customers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.AdCustomer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ad customers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.AdCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ad customers
	* @param end the upper bound of the range of ad customers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ad customers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.AdCustomer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ad customers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ad customers.
	*
	* @return the number of ad customers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AdCustomerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AdCustomerPersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					AdCustomerPersistence.class.getName());

			ReferenceRegistry.registerReference(AdCustomerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AdCustomerPersistence persistence) {
	}

	private static AdCustomerPersistence _persistence;
}