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

package com.liferay.contacts.service.persistence;

import com.liferay.contacts.model.FlaskUserDeviceRegistration;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the flask user device registration service. This utility wraps {@link FlaskUserDeviceRegistrationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskUserDeviceRegistrationPersistence
 * @see FlaskUserDeviceRegistrationPersistenceImpl
 * @generated
 */
public class FlaskUserDeviceRegistrationUtil {
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
	public static void clearCache(
		FlaskUserDeviceRegistration flaskUserDeviceRegistration) {
		getPersistence().clearCache(flaskUserDeviceRegistration);
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
	public static List<FlaskUserDeviceRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FlaskUserDeviceRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FlaskUserDeviceRegistration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FlaskUserDeviceRegistration update(
		FlaskUserDeviceRegistration flaskUserDeviceRegistration)
		throws SystemException {
		return getPersistence().update(flaskUserDeviceRegistration);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FlaskUserDeviceRegistration update(
		FlaskUserDeviceRegistration flaskUserDeviceRegistration,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(flaskUserDeviceRegistration, serviceContext);
	}

	/**
	* Returns all the flask user device registrations where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the flask user device registrations where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of flask user device registrations
	* @param end the upper bound of the range of flask user device registrations (not inclusive)
	* @return the range of matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the flask user device registrations where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of flask user device registrations
	* @param end the upper bound of the range of flask user device registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first flask user device registration in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first flask user device registration in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last flask user device registration in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last flask user device registration in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the flask user device registrations before and after the current flask user device registration in the ordered set where userId = &#63;.
	*
	* @param userDeviceRegistrationId the primary key of the current flask user device registration
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a flask user device registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration[] findByUserId_PrevAndNext(
		long userDeviceRegistrationId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_PrevAndNext(userDeviceRegistrationId, userId,
			orderByComparator);
	}

	/**
	* Removes all the flask user device registrations where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of flask user device registrations where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the flask user device registrations where userEmail = &#63;.
	*
	* @param userEmail the user email
	* @return the matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByuserEmail(
		java.lang.String userEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserEmail(userEmail);
	}

	/**
	* Returns a range of all the flask user device registrations where userEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userEmail the user email
	* @param start the lower bound of the range of flask user device registrations
	* @param end the upper bound of the range of flask user device registrations (not inclusive)
	* @return the range of matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByuserEmail(
		java.lang.String userEmail, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserEmail(userEmail, start, end);
	}

	/**
	* Returns an ordered range of all the flask user device registrations where userEmail = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userEmail the user email
	* @param start the lower bound of the range of flask user device registrations
	* @param end the upper bound of the range of flask user device registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByuserEmail(
		java.lang.String userEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserEmail(userEmail, start, end, orderByComparator);
	}

	/**
	* Returns the first flask user device registration in the ordered set where userEmail = &#63;.
	*
	* @param userEmail the user email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration findByuserEmail_First(
		java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserEmail_First(userEmail, orderByComparator);
	}

	/**
	* Returns the first flask user device registration in the ordered set where userEmail = &#63;.
	*
	* @param userEmail the user email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration fetchByuserEmail_First(
		java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByuserEmail_First(userEmail, orderByComparator);
	}

	/**
	* Returns the last flask user device registration in the ordered set where userEmail = &#63;.
	*
	* @param userEmail the user email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration findByuserEmail_Last(
		java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserEmail_Last(userEmail, orderByComparator);
	}

	/**
	* Returns the last flask user device registration in the ordered set where userEmail = &#63;.
	*
	* @param userEmail the user email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration fetchByuserEmail_Last(
		java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByuserEmail_Last(userEmail, orderByComparator);
	}

	/**
	* Returns the flask user device registrations before and after the current flask user device registration in the ordered set where userEmail = &#63;.
	*
	* @param userDeviceRegistrationId the primary key of the current flask user device registration
	* @param userEmail the user email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a flask user device registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration[] findByuserEmail_PrevAndNext(
		long userDeviceRegistrationId, java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserEmail_PrevAndNext(userDeviceRegistrationId,
			userEmail, orderByComparator);
	}

	/**
	* Removes all the flask user device registrations where userEmail = &#63; from the database.
	*
	* @param userEmail the user email
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByuserEmail(java.lang.String userEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByuserEmail(userEmail);
	}

	/**
	* Returns the number of flask user device registrations where userEmail = &#63;.
	*
	* @param userEmail the user email
	* @return the number of matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuserEmail(java.lang.String userEmail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByuserEmail(userEmail);
	}

	/**
	* Returns all the flask user device registrations where deviceToken = &#63;.
	*
	* @param deviceToken the device token
	* @return the matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findBydeviceToken(
		java.lang.String deviceToken)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBydeviceToken(deviceToken);
	}

	/**
	* Returns a range of all the flask user device registrations where deviceToken = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param deviceToken the device token
	* @param start the lower bound of the range of flask user device registrations
	* @param end the upper bound of the range of flask user device registrations (not inclusive)
	* @return the range of matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findBydeviceToken(
		java.lang.String deviceToken, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBydeviceToken(deviceToken, start, end);
	}

	/**
	* Returns an ordered range of all the flask user device registrations where deviceToken = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param deviceToken the device token
	* @param start the lower bound of the range of flask user device registrations
	* @param end the upper bound of the range of flask user device registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findBydeviceToken(
		java.lang.String deviceToken, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydeviceToken(deviceToken, start, end, orderByComparator);
	}

	/**
	* Returns the first flask user device registration in the ordered set where deviceToken = &#63;.
	*
	* @param deviceToken the device token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration findBydeviceToken_First(
		java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydeviceToken_First(deviceToken, orderByComparator);
	}

	/**
	* Returns the first flask user device registration in the ordered set where deviceToken = &#63;.
	*
	* @param deviceToken the device token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration fetchBydeviceToken_First(
		java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBydeviceToken_First(deviceToken, orderByComparator);
	}

	/**
	* Returns the last flask user device registration in the ordered set where deviceToken = &#63;.
	*
	* @param deviceToken the device token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration findBydeviceToken_Last(
		java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydeviceToken_Last(deviceToken, orderByComparator);
	}

	/**
	* Returns the last flask user device registration in the ordered set where deviceToken = &#63;.
	*
	* @param deviceToken the device token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration fetchBydeviceToken_Last(
		java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBydeviceToken_Last(deviceToken, orderByComparator);
	}

	/**
	* Returns the flask user device registrations before and after the current flask user device registration in the ordered set where deviceToken = &#63;.
	*
	* @param userDeviceRegistrationId the primary key of the current flask user device registration
	* @param deviceToken the device token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a flask user device registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration[] findBydeviceToken_PrevAndNext(
		long userDeviceRegistrationId, java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBydeviceToken_PrevAndNext(userDeviceRegistrationId,
			deviceToken, orderByComparator);
	}

	/**
	* Removes all the flask user device registrations where deviceToken = &#63; from the database.
	*
	* @param deviceToken the device token
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBydeviceToken(java.lang.String deviceToken)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBydeviceToken(deviceToken);
	}

	/**
	* Returns the number of flask user device registrations where deviceToken = &#63;.
	*
	* @param deviceToken the device token
	* @return the number of matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countBydeviceToken(java.lang.String deviceToken)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBydeviceToken(deviceToken);
	}

	/**
	* Returns all the flask user device registrations where userId = &#63; and deviceToken = &#63;.
	*
	* @param userId the user ID
	* @param deviceToken the device token
	* @return the matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByUserIdDeviceToken(
		long userId, java.lang.String deviceToken)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdDeviceToken(userId, deviceToken);
	}

	/**
	* Returns a range of all the flask user device registrations where userId = &#63; and deviceToken = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param deviceToken the device token
	* @param start the lower bound of the range of flask user device registrations
	* @param end the upper bound of the range of flask user device registrations (not inclusive)
	* @return the range of matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByUserIdDeviceToken(
		long userId, java.lang.String deviceToken, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdDeviceToken(userId, deviceToken, start, end);
	}

	/**
	* Returns an ordered range of all the flask user device registrations where userId = &#63; and deviceToken = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param deviceToken the device token
	* @param start the lower bound of the range of flask user device registrations
	* @param end the upper bound of the range of flask user device registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByUserIdDeviceToken(
		long userId, java.lang.String deviceToken, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdDeviceToken(userId, deviceToken, start, end,
			orderByComparator);
	}

	/**
	* Returns the first flask user device registration in the ordered set where userId = &#63; and deviceToken = &#63;.
	*
	* @param userId the user ID
	* @param deviceToken the device token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration findByUserIdDeviceToken_First(
		long userId, java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdDeviceToken_First(userId, deviceToken,
			orderByComparator);
	}

	/**
	* Returns the first flask user device registration in the ordered set where userId = &#63; and deviceToken = &#63;.
	*
	* @param userId the user ID
	* @param deviceToken the device token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration fetchByUserIdDeviceToken_First(
		long userId, java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdDeviceToken_First(userId, deviceToken,
			orderByComparator);
	}

	/**
	* Returns the last flask user device registration in the ordered set where userId = &#63; and deviceToken = &#63;.
	*
	* @param userId the user ID
	* @param deviceToken the device token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration findByUserIdDeviceToken_Last(
		long userId, java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdDeviceToken_Last(userId, deviceToken,
			orderByComparator);
	}

	/**
	* Returns the last flask user device registration in the ordered set where userId = &#63; and deviceToken = &#63;.
	*
	* @param userId the user ID
	* @param deviceToken the device token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration fetchByUserIdDeviceToken_Last(
		long userId, java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdDeviceToken_Last(userId, deviceToken,
			orderByComparator);
	}

	/**
	* Returns the flask user device registrations before and after the current flask user device registration in the ordered set where userId = &#63; and deviceToken = &#63;.
	*
	* @param userDeviceRegistrationId the primary key of the current flask user device registration
	* @param userId the user ID
	* @param deviceToken the device token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a flask user device registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration[] findByUserIdDeviceToken_PrevAndNext(
		long userDeviceRegistrationId, long userId,
		java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdDeviceToken_PrevAndNext(userDeviceRegistrationId,
			userId, deviceToken, orderByComparator);
	}

	/**
	* Removes all the flask user device registrations where userId = &#63; and deviceToken = &#63; from the database.
	*
	* @param userId the user ID
	* @param deviceToken the device token
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdDeviceToken(long userId,
		java.lang.String deviceToken)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserIdDeviceToken(userId, deviceToken);
	}

	/**
	* Returns the number of flask user device registrations where userId = &#63; and deviceToken = &#63;.
	*
	* @param userId the user ID
	* @param deviceToken the device token
	* @return the number of matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdDeviceToken(long userId,
		java.lang.String deviceToken)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdDeviceToken(userId, deviceToken);
	}

	/**
	* Caches the flask user device registration in the entity cache if it is enabled.
	*
	* @param flaskUserDeviceRegistration the flask user device registration
	*/
	public static void cacheResult(
		com.liferay.contacts.model.FlaskUserDeviceRegistration flaskUserDeviceRegistration) {
		getPersistence().cacheResult(flaskUserDeviceRegistration);
	}

	/**
	* Caches the flask user device registrations in the entity cache if it is enabled.
	*
	* @param flaskUserDeviceRegistrations the flask user device registrations
	*/
	public static void cacheResult(
		java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> flaskUserDeviceRegistrations) {
		getPersistence().cacheResult(flaskUserDeviceRegistrations);
	}

	/**
	* Creates a new flask user device registration with the primary key. Does not add the flask user device registration to the database.
	*
	* @param userDeviceRegistrationId the primary key for the new flask user device registration
	* @return the new flask user device registration
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration create(
		long userDeviceRegistrationId) {
		return getPersistence().create(userDeviceRegistrationId);
	}

	/**
	* Removes the flask user device registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userDeviceRegistrationId the primary key of the flask user device registration
	* @return the flask user device registration that was removed
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a flask user device registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration remove(
		long userDeviceRegistrationId)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(userDeviceRegistrationId);
	}

	public static com.liferay.contacts.model.FlaskUserDeviceRegistration updateImpl(
		com.liferay.contacts.model.FlaskUserDeviceRegistration flaskUserDeviceRegistration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(flaskUserDeviceRegistration);
	}

	/**
	* Returns the flask user device registration with the primary key or throws a {@link com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException} if it could not be found.
	*
	* @param userDeviceRegistrationId the primary key of the flask user device registration
	* @return the flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a flask user device registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration findByPrimaryKey(
		long userDeviceRegistrationId)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(userDeviceRegistrationId);
	}

	/**
	* Returns the flask user device registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userDeviceRegistrationId the primary key of the flask user device registration
	* @return the flask user device registration, or <code>null</code> if a flask user device registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.contacts.model.FlaskUserDeviceRegistration fetchByPrimaryKey(
		long userDeviceRegistrationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userDeviceRegistrationId);
	}

	/**
	* Returns all the flask user device registrations.
	*
	* @return the flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the flask user device registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask user device registrations
	* @param end the upper bound of the range of flask user device registrations (not inclusive)
	* @return the range of flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the flask user device registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskUserDeviceRegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask user device registrations
	* @param end the upper bound of the range of flask user device registrations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the flask user device registrations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of flask user device registrations.
	*
	* @return the number of flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FlaskUserDeviceRegistrationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FlaskUserDeviceRegistrationPersistence)PortletBeanLocatorUtil.locate(com.liferay.contacts.service.ClpSerializer.getServletContextName(),
					FlaskUserDeviceRegistrationPersistence.class.getName());

			ReferenceRegistry.registerReference(FlaskUserDeviceRegistrationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		FlaskUserDeviceRegistrationPersistence persistence) {
	}

	private static FlaskUserDeviceRegistrationPersistence _persistence;
}