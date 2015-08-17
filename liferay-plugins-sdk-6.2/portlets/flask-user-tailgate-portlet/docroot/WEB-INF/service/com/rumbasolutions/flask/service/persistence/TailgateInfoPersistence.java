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

import com.rumbasolutions.flask.model.TailgateInfo;

/**
 * The persistence interface for the tailgate info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author rajeshj
 * @see TailgateInfoPersistenceImpl
 * @see TailgateInfoUtil
 * @generated
 */
public interface TailgateInfoPersistence extends BasePersistence<TailgateInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TailgateInfoUtil} to access the tailgate info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tailgate info in the entity cache if it is enabled.
	*
	* @param tailgateInfo the tailgate info
	*/
	public void cacheResult(
		com.rumbasolutions.flask.model.TailgateInfo tailgateInfo);

	/**
	* Caches the tailgate infos in the entity cache if it is enabled.
	*
	* @param tailgateInfos the tailgate infos
	*/
	public void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.TailgateInfo> tailgateInfos);

	/**
	* Creates a new tailgate info with the primary key. Does not add the tailgate info to the database.
	*
	* @param tailgateId the primary key for the new tailgate info
	* @return the new tailgate info
	*/
	public com.rumbasolutions.flask.model.TailgateInfo create(long tailgateId);

	/**
	* Removes the tailgate info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tailgateId the primary key of the tailgate info
	* @return the tailgate info that was removed
	* @throws com.rumbasolutions.flask.NoSuchTailgateInfoException if a tailgate info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateInfo remove(long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateInfoException;

	public com.rumbasolutions.flask.model.TailgateInfo updateImpl(
		com.rumbasolutions.flask.model.TailgateInfo tailgateInfo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tailgate info with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchTailgateInfoException} if it could not be found.
	*
	* @param tailgateId the primary key of the tailgate info
	* @return the tailgate info
	* @throws com.rumbasolutions.flask.NoSuchTailgateInfoException if a tailgate info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateInfo findByPrimaryKey(
		long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchTailgateInfoException;

	/**
	* Returns the tailgate info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param tailgateId the primary key of the tailgate info
	* @return the tailgate info, or <code>null</code> if a tailgate info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rumbasolutions.flask.model.TailgateInfo fetchByPrimaryKey(
		long tailgateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tailgate infos.
	*
	* @return the tailgate infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.TailgateInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tailgate infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tailgate infos
	* @param end the upper bound of the range of tailgate infos (not inclusive)
	* @return the range of tailgate infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.TailgateInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tailgate infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tailgate infos
	* @param end the upper bound of the range of tailgate infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tailgate infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rumbasolutions.flask.model.TailgateInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tailgate infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tailgate infos.
	*
	* @return the number of tailgate infos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}