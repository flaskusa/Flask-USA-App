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

package com.liferay.contacts.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for FlaskGroupMessages. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FlaskGroupMessagesServiceUtil
 * @see com.liferay.contacts.service.base.FlaskGroupMessagesServiceBaseImpl
 * @see com.liferay.contacts.service.impl.FlaskGroupMessagesServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface FlaskGroupMessagesService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FlaskGroupMessagesServiceUtil} to access the flask group messages remote service. Add custom service methods to {@link com.liferay.contacts.service.impl.FlaskGroupMessagesServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public com.liferay.contacts.model.FlaskGroupMessages sendFlaskGroupMessage(
		long groupId, java.lang.String message, boolean sendEmail,
		com.liferay.portal.service.ServiceContext serviceContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getAllMyFlaskGroupMessages(
		long groupId, com.liferay.portal.service.ServiceContext serviceContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.contacts.model.FlaskGroupMessages> getGroupMessages(
		long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMyFlaskGroupMessagesCount(long groupId,
		com.liferay.portal.service.ServiceContext serviceContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMyUnreadFlaskGroupMessagesCount(long groupId,
		com.liferay.portal.service.ServiceContext serviceContext);

	public boolean deleteMyGroupChatMessages(
		java.util.List<java.lang.Long> groupMessageIds,
		com.liferay.portal.service.ServiceContext serviceContext);

	public void deleteGroupMessage(long groupMessageId,
		com.liferay.portal.service.ServiceContext serviceContext);

	public void deleteGroupMessagesByDateRange(java.util.Date startDate,
		java.util.Date endDate,
		com.liferay.portal.service.ServiceContext serviceContext);

	public boolean addGrpMsginfoInAll();
}