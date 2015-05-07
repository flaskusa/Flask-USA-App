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

import com.liferay.portal.service.persistence.BasePersistence;

import com.rumbasolutions.flask.model.FlaskUser;

/**
 * The persistence interface for the flask user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see FlaskUserPersistenceImpl
 * @see FlaskUserUtil
 * @generated
 */
public interface FlaskUserPersistence extends BasePersistence<FlaskUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FlaskUserUtil} to access the flask user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the flask user in the entity cache if it is enabled.
	*
	* @param flaskUser the flask user
	*/
	public void cacheResult(com.rumbasolutions.flask.model.FlaskUser flaskUser);

	/**
	* Caches the flask users in the entity cache if it is enabled.
	*
	* @param flaskUsers the flask users
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.FlaskUser> flaskUsers);

	/**
	* Creates a new flask user with the primary key. Does not add the flask user to the database.
	*
	* @param userId the primary key for the new flask user
	* @return the new flask user
	*/
	public com.rumbasolutions.flask.model.FlaskUser create(long userId);

	/**
	* Removes the flask user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the flask user
	* @return the flask user that was removed
	* @throws com.rumbasolutions.flask.NoSuchFlaskUserException if a flask user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskUser remove(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskUserException;

	public com.rumbasolutions.flask.model.FlaskUser updateImpl(
		com.rumbasolutions.flask.model.FlaskUser flaskUser)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask user with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchFlaskUserException} if it could not be found.
	*
	* @param userId the primary key of the flask user
	* @return the flask user
	* @throws com.rumbasolutions.flask.NoSuchFlaskUserException if a flask user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskUser findByPrimaryKey(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskUserException;

	/**
	* Returns the flask user with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the flask user
	* @return the flask user, or <code>null</code> if a flask user with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskUser fetchByPrimaryKey(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flask users.
	*
	* @return the flask users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskUser> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flask users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask users
	* @param end the upper bound of the range of flask users (not inclusive)
	* @return the range of flask users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskUser> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flask users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask users
	* @param end the upper bound of the range of flask users (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of flask users
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flask users from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask users.
	*
	* @return the number of flask users
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}