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

import com.rumbasolutions.flask.model.FlaskGroup;

/**
 * The persistence interface for the flask group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupPersistenceImpl
 * @see FlaskGroupUtil
 * @generated
 */
public interface FlaskGroupPersistence extends BasePersistence<FlaskGroup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FlaskGroupUtil} to access the flask group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the flask group in the entity cache if it is enabled.
	*
	* @param flaskGroup the flask group
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.FlaskGroup flaskGroup);

	/**
	* Caches the flask groups in the entity cache if it is enabled.
	*
	* @param flaskGroups the flask groups
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.FlaskGroup> flaskGroups);

	/**
	* Creates a new flask group with the primary key. Does not add the flask group to the database.
	*
	* @param groupId the primary key for the new flask group
	* @return the new flask group
	*/
	public com.rumbasolutions.flask.model.FlaskGroup create(long groupId);

	/**
	* Removes the flask group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupId the primary key of the flask group
	* @return the flask group that was removed
	* @throws com.rumbasolutions.flask.NoSuchFlaskGroupException if a flask group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroup remove(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskGroupException;

	public com.rumbasolutions.flask.model.FlaskGroup updateImpl(
		com.rumbasolutions.flask.model.FlaskGroup flaskGroup)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask group with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchFlaskGroupException} if it could not be found.
	*
	* @param groupId the primary key of the flask group
	* @return the flask group
	* @throws com.rumbasolutions.flask.NoSuchFlaskGroupException if a flask group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroup findByPrimaryKey(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchFlaskGroupException;

	/**
	* Returns the flask group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param groupId the primary key of the flask group
	* @return the flask group, or <code>null</code> if a flask group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.FlaskGroup fetchByPrimaryKey(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flask groups.
	*
	* @return the flask groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flask groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask groups
	* @param end the upper bound of the range of flask groups (not inclusive)
	* @return the range of flask groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flask groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask groups
	* @param end the upper bound of the range of flask groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of flask groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flask groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask groups.
	*
	* @return the number of flask groups
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}