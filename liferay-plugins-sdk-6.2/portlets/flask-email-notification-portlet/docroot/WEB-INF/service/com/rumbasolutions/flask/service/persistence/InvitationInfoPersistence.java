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

import com.rumbasolutions.flask.model.InvitationInfo;

/**
 * The persistence interface for the invitation info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvitationInfoPersistenceImpl
 * @see InvitationInfoUtil
 * @generated
 */
public interface InvitationInfoPersistence extends BasePersistence<InvitationInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InvitationInfoUtil} to access the invitation info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the invitation info in the entity cache if it is enabled.
	*
	* @param invitationInfo the invitation info
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.InvitationInfo invitationInfo);

	/**
	* Caches the invitation infos in the entity cache if it is enabled.
	*
	* @param invitationInfos the invitation infos
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.InvitationInfo> invitationInfos);

	/**
	* Creates a new invitation info with the primary key. Does not add the invitation info to the database.
	*
	* @param inviationId the primary key for the new invitation info
	* @return the new invitation info
	*/
	public com.rumbasolutions.flask.model.InvitationInfo create(
		long inviationId);

	/**
	* Removes the invitation info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inviationId the primary key of the invitation info
	* @return the invitation info that was removed
	* @throws com.rumbasolutions.flask.NoSuchInvitationInfoException if a invitation info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.InvitationInfo remove(
		long inviationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchInvitationInfoException;

	public com.rumbasolutions.flask.model.InvitationInfo updateImpl(
		com.rumbasolutions.flask.model.InvitationInfo invitationInfo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the invitation info with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchInvitationInfoException} if it could not be found.
	*
	* @param inviationId the primary key of the invitation info
	* @return the invitation info
	* @throws com.rumbasolutions.flask.NoSuchInvitationInfoException if a invitation info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.InvitationInfo findByPrimaryKey(
		long inviationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchInvitationInfoException;

	/**
	* Returns the invitation info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param inviationId the primary key of the invitation info
	* @return the invitation info, or <code>null</code> if a invitation info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.InvitationInfo fetchByPrimaryKey(
		long inviationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the invitation infos.
	*
	* @return the invitation infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.InvitationInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the invitation infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InvitationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of invitation infos
	* @param end the upper bound of the range of invitation infos (not inclusive)
	* @return the range of invitation infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.InvitationInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the invitation infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.InvitationInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of invitation infos
	* @param end the upper bound of the range of invitation infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of invitation infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.InvitationInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the invitation infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of invitation infos.
	*
	* @return the number of invitation infos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}