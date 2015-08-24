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

import com.rumbasolutions.flask.model.InvitationInfo;

import java.util.List;

/**
 * The persistence utility for the invitation info service. This utility wraps {@link InvitationInfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvitationInfoPersistence
 * @see InvitationInfoPersistenceImpl
 * @generated
 */
public class InvitationInfoUtil {
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
	public static void clearCache(InvitationInfo invitationInfo) {
		getPersistence().clearCache(invitationInfo);
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
	public static List<InvitationInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<InvitationInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<InvitationInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static InvitationInfo update(InvitationInfo invitationInfo)
		throws SystemException {
		return getPersistence().update(invitationInfo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static InvitationInfo update(InvitationInfo invitationInfo,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(invitationInfo, serviceContext);
	}

	/**
	* Caches the invitation info in the entity cache if it is enabled.
	*
	* @param invitationInfo the invitation info
	*/
	public static void cacheResult(
		com.rumbasolutions.flask.model.InvitationInfo invitationInfo) {
		getPersistence().cacheResult(invitationInfo);
	}

	/**
	* Caches the invitation infos in the entity cache if it is enabled.
	*
	* @param invitationInfos the invitation infos
	*/
	public static void cacheResult(
		java.util.List<com.rumbasolutions.flask.model.InvitationInfo> invitationInfos) {
		getPersistence().cacheResult(invitationInfos);
	}

	/**
	* Creates a new invitation info with the primary key. Does not add the invitation info to the database.
	*
	* @param inviationId the primary key for the new invitation info
	* @return the new invitation info
	*/
	public static com.rumbasolutions.flask.model.InvitationInfo create(
		long inviationId) {
		return getPersistence().create(inviationId);
	}

	/**
	* Removes the invitation info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inviationId the primary key of the invitation info
	* @return the invitation info that was removed
	* @throws com.rumbasolutions.flask.NoSuchInvitationInfoException if a invitation info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.InvitationInfo remove(
		long inviationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchInvitationInfoException {
		return getPersistence().remove(inviationId);
	}

	public static com.rumbasolutions.flask.model.InvitationInfo updateImpl(
		com.rumbasolutions.flask.model.InvitationInfo invitationInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(invitationInfo);
	}

	/**
	* Returns the invitation info with the primary key or throws a {@link com.rumbasolutions.flask.NoSuchInvitationInfoException} if it could not be found.
	*
	* @param inviationId the primary key of the invitation info
	* @return the invitation info
	* @throws com.rumbasolutions.flask.NoSuchInvitationInfoException if a invitation info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.InvitationInfo findByPrimaryKey(
		long inviationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rumbasolutions.flask.NoSuchInvitationInfoException {
		return getPersistence().findByPrimaryKey(inviationId);
	}

	/**
	* Returns the invitation info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param inviationId the primary key of the invitation info
	* @return the invitation info, or <code>null</code> if a invitation info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rumbasolutions.flask.model.InvitationInfo fetchByPrimaryKey(
		long inviationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(inviationId);
	}

	/**
	* Returns all the invitation infos.
	*
	* @return the invitation infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rumbasolutions.flask.model.InvitationInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.InvitationInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.rumbasolutions.flask.model.InvitationInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the invitation infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of invitation infos.
	*
	* @return the number of invitation infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static InvitationInfoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (InvitationInfoPersistence)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					InvitationInfoPersistence.class.getName());

			ReferenceRegistry.registerReference(InvitationInfoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(InvitationInfoPersistence persistence) {
	}

	private static InvitationInfoPersistence _persistence;
}