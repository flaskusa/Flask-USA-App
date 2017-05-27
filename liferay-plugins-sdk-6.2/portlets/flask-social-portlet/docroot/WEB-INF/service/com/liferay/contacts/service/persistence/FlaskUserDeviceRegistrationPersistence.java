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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the flask user device registration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskUserDeviceRegistrationPersistenceImpl
 * @see FlaskUserDeviceRegistrationUtil
 * @generated
 */
public interface FlaskUserDeviceRegistrationPersistence extends BasePersistence<FlaskUserDeviceRegistration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FlaskUserDeviceRegistrationUtil} to access the flask user device registration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the flask user device registrations where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask user device registration in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask user device registration in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask user device registration in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask user device registration in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.contacts.model.FlaskUserDeviceRegistration[] findByUserId_PrevAndNext(
		long userDeviceRegistrationId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flask user device registrations where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask user device registrations where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flask user device registrations where userEmail = &#63;.
	*
	* @param userEmail the user email
	* @return the matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByuserEmail(
		java.lang.String userEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByuserEmail(
		java.lang.String userEmail, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByuserEmail(
		java.lang.String userEmail, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask user device registration in the ordered set where userEmail = &#63;.
	*
	* @param userEmail the user email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration findByuserEmail_First(
		java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask user device registration in the ordered set where userEmail = &#63;.
	*
	* @param userEmail the user email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration fetchByuserEmail_First(
		java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask user device registration in the ordered set where userEmail = &#63;.
	*
	* @param userEmail the user email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration findByuserEmail_Last(
		java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask user device registration in the ordered set where userEmail = &#63;.
	*
	* @param userEmail the user email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration fetchByuserEmail_Last(
		java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.contacts.model.FlaskUserDeviceRegistration[] findByuserEmail_PrevAndNext(
		long userDeviceRegistrationId, java.lang.String userEmail,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flask user device registrations where userEmail = &#63; from the database.
	*
	* @param userEmail the user email
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserEmail(java.lang.String userEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask user device registrations where userEmail = &#63;.
	*
	* @param userEmail the user email
	* @return the number of matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserEmail(java.lang.String userEmail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flask user device registrations where deviceToken = &#63;.
	*
	* @param deviceToken the device token
	* @return the matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findBydeviceToken(
		java.lang.String deviceToken)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findBydeviceToken(
		java.lang.String deviceToken, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findBydeviceToken(
		java.lang.String deviceToken, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask user device registration in the ordered set where deviceToken = &#63;.
	*
	* @param deviceToken the device token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration findBydeviceToken_First(
		java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask user device registration in the ordered set where deviceToken = &#63;.
	*
	* @param deviceToken the device token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration fetchBydeviceToken_First(
		java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask user device registration in the ordered set where deviceToken = &#63;.
	*
	* @param deviceToken the device token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration findBydeviceToken_Last(
		java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask user device registration in the ordered set where deviceToken = &#63;.
	*
	* @param deviceToken the device token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration fetchBydeviceToken_Last(
		java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.contacts.model.FlaskUserDeviceRegistration[] findBydeviceToken_PrevAndNext(
		long userDeviceRegistrationId, java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flask user device registrations where deviceToken = &#63; from the database.
	*
	* @param deviceToken the device token
	* @throws SystemException if a system exception occurred
	*/
	public void removeBydeviceToken(java.lang.String deviceToken)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask user device registrations where deviceToken = &#63;.
	*
	* @param deviceToken the device token
	* @return the number of matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countBydeviceToken(java.lang.String deviceToken)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flask user device registrations where userId = &#63; and deviceToken = &#63;.
	*
	* @param userId the user ID
	* @param deviceToken the device token
	* @return the matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByUserIdDeviceToken(
		long userId, java.lang.String deviceToken)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByUserIdDeviceToken(
		long userId, java.lang.String deviceToken, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findByUserIdDeviceToken(
		long userId, java.lang.String deviceToken, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.contacts.model.FlaskUserDeviceRegistration findByUserIdDeviceToken_First(
		long userId, java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first flask user device registration in the ordered set where userId = &#63; and deviceToken = &#63;.
	*
	* @param userId the user ID
	* @param deviceToken the device token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration fetchByUserIdDeviceToken_First(
		long userId, java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.contacts.model.FlaskUserDeviceRegistration findByUserIdDeviceToken_Last(
		long userId, java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last flask user device registration in the ordered set where userId = &#63; and deviceToken = &#63;.
	*
	* @param userId the user ID
	* @param deviceToken the device token
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching flask user device registration, or <code>null</code> if a matching flask user device registration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration fetchByUserIdDeviceToken_Last(
		long userId, java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.contacts.model.FlaskUserDeviceRegistration[] findByUserIdDeviceToken_PrevAndNext(
		long userDeviceRegistrationId, long userId,
		java.lang.String deviceToken,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flask user device registrations where userId = &#63; and deviceToken = &#63; from the database.
	*
	* @param userId the user ID
	* @param deviceToken the device token
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdDeviceToken(long userId,
		java.lang.String deviceToken)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask user device registrations where userId = &#63; and deviceToken = &#63;.
	*
	* @param userId the user ID
	* @param deviceToken the device token
	* @return the number of matching flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdDeviceToken(long userId,
		java.lang.String deviceToken)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the flask user device registration in the entity cache if it is enabled.
	*
	* @param flaskUserDeviceRegistration the flask user device registration
	*/
	public void cacheResult(
		com.liferay.contacts.model.FlaskUserDeviceRegistration flaskUserDeviceRegistration);

	/**
	* Caches the flask user device registrations in the entity cache if it is enabled.
	*
	* @param flaskUserDeviceRegistrations the flask user device registrations
	*/
	public void cacheResult(
		java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> flaskUserDeviceRegistrations);

	/**
	* Creates a new flask user device registration with the primary key. Does not add the flask user device registration to the database.
	*
	* @param userDeviceRegistrationId the primary key for the new flask user device registration
	* @return the new flask user device registration
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration create(
		long userDeviceRegistrationId);

	/**
	* Removes the flask user device registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userDeviceRegistrationId the primary key of the flask user device registration
	* @return the flask user device registration that was removed
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a flask user device registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration remove(
		long userDeviceRegistrationId)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.contacts.model.FlaskUserDeviceRegistration updateImpl(
		com.liferay.contacts.model.FlaskUserDeviceRegistration flaskUserDeviceRegistration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask user device registration with the primary key or throws a {@link com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException} if it could not be found.
	*
	* @param userDeviceRegistrationId the primary key of the flask user device registration
	* @return the flask user device registration
	* @throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException if a flask user device registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration findByPrimaryKey(
		long userDeviceRegistrationId)
		throws com.liferay.contacts.NoSuchFlaskUserDeviceRegistrationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask user device registration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userDeviceRegistrationId the primary key of the flask user device registration
	* @return the flask user device registration, or <code>null</code> if a flask user device registration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskUserDeviceRegistration fetchByPrimaryKey(
		long userDeviceRegistrationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flask user device registrations.
	*
	* @return the flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.contacts.model.FlaskUserDeviceRegistration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flask user device registrations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask user device registrations.
	*
	* @return the number of flask user device registrations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}