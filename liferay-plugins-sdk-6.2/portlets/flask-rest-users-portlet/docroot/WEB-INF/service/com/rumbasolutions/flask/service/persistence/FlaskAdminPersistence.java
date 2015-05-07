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

import com.rumbasolutions.flask.model.FlaskAdmin;

/**
 * The persistence interface for the flask admin service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ashutosh Rai
 * @see FlaskAdminPersistenceImpl
 * @see FlaskAdminUtil
 * @generated
 */
public interface FlaskAdminPersistence extends BasePersistence<FlaskAdmin> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FlaskAdminUtil} to access the flask admin persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the flask admin in the entity cache if it is enabled.
	*
	* @param flaskAdmin the flask admin
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.FlaskAdmin flaskAdmin);

	/**
	* Caches the flask admins in the entity cache if it is enabled.
	*
	* @param flaskAdmins the flask admins
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> flaskAdmins);

	/**
	* Creates a new flask admin with the primary key. Does not add the flask admin to the database.
	*
	* @param userId the primary key for the new flask admin
	* @return the new flask admin
	*/
	public com.rumbasolutions.flask.model.FlaskAdmin create(long userId);

	/**
	* Removes the flask admin with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the flask admin
	* @return the flask admin that was removed
	* @throws com.rumbasolutions.flask.NoSuchFlaskAdminException if a flask admin with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskAdmin remove(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskAdminException;

	public com.rumbasolutions.flask.model.FlaskAdmin updateImpl(
		com.rumbasolutions.flask.model.FlaskAdmin flaskAdmin)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask admin with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchFlaskAdminException} if it could not be found.
	*
	* @param userId the primary key of the flask admin
	* @return the flask admin
	* @throws com.rumbasolutions.flask.NoSuchFlaskAdminException if a flask admin with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskAdmin findByPrimaryKey(
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskAdminException;

	/**
	* Returns the flask admin with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the flask admin
	* @return the flask admin, or <code>null</code> if a flask admin with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskAdmin fetchByPrimaryKey(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flask admins.
	*
	* @return the flask admins
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flask admins.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskAdminModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask admins
	* @param end the upper bound of the range of flask admins (not inclusive)
	* @return the range of flask admins
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flask admins.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskAdminModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask admins
	* @param end the upper bound of the range of flask admins (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of flask admins
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskAdmin> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flask admins from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask admins.
	*
	* @return the number of flask admins
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}