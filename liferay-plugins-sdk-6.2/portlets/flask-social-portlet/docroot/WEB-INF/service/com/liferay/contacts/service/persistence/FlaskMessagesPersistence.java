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

import com.liferay.contacts.model.FlaskMessages;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the flask messages service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlaskMessagesPersistenceImpl
 * @see FlaskMessagesUtil
 * @generated
 */
public interface FlaskMessagesPersistence extends BasePersistence<FlaskMessages> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FlaskMessagesUtil} to access the flask messages persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the flask messages in the entity cache if it is enabled.
	*
	* @param flaskMessages the flask messages
	*/
	public void cacheResult(
		com.liferay.contacts.model.FlaskMessages flaskMessages);

	/**
	* Caches the flask messageses in the entity cache if it is enabled.
	*
	* @param flaskMessageses the flask messageses
	*/
	public void cacheResult(
		java.util.List<com.liferay.contacts.model.FlaskMessages> flaskMessageses);

	/**
	* Creates a new flask messages with the primary key. Does not add the flask messages to the database.
	*
	* @param messageId the primary key for the new flask messages
	* @return the new flask messages
	*/
	public com.liferay.contacts.model.FlaskMessages create(long messageId);

	/**
	* Removes the flask messages with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the flask messages
	* @return the flask messages that was removed
	* @throws com.liferay.contacts.NoSuchFlaskMessagesException if a flask messages with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskMessages remove(long messageId)
		throws com.liferay.contacts.NoSuchFlaskMessagesException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.contacts.model.FlaskMessages updateImpl(
		com.liferay.contacts.model.FlaskMessages flaskMessages)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask messages with the primary key or throws a {@link com.liferay.contacts.NoSuchFlaskMessagesException} if it could not be found.
	*
	* @param messageId the primary key of the flask messages
	* @return the flask messages
	* @throws com.liferay.contacts.NoSuchFlaskMessagesException if a flask messages with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskMessages findByPrimaryKey(
		long messageId)
		throws com.liferay.contacts.NoSuchFlaskMessagesException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the flask messages with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param messageId the primary key of the flask messages
	* @return the flask messages, or <code>null</code> if a flask messages with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.contacts.model.FlaskMessages fetchByPrimaryKey(
		long messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the flask messageses.
	*
	* @return the flask messageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskMessages> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the flask messageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskMessagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask messageses
	* @param end the upper bound of the range of flask messageses (not inclusive)
	* @return the range of flask messageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskMessages> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the flask messageses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskMessagesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of flask messageses
	* @param end the upper bound of the range of flask messageses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of flask messageses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.contacts.model.FlaskMessages> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the flask messageses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of flask messageses.
	*
	* @return the number of flask messageses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}