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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EntryService}.
 *
 * @author Brian Wing Shun Chan
 * @see EntryService
 * @generated
 */
public class EntryServiceWrapper implements EntryService,
	ServiceWrapper<EntryService> {
	public EntryServiceWrapper(EntryService entryService) {
		_entryService = entryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _entryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_entryService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _entryService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray searchUsersAndContacts(
		long companyId, java.lang.String keywords, int start, int end,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _entryService.searchUsersAndContacts(companyId, keywords, start,
			end, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.portlet.social.model.SocialRequest> getRequestsToConfirm(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _entryService.getRequestsToConfirm(serviceContext);
	}

	@Override
	public com.liferay.portlet.social.model.SocialRequest deleteRequest(
		long receiverUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws java.lang.Exception {
		return _entryService.deleteRequest(receiverUserId, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getRequestingUsers(
		long companyId, java.lang.String keywords,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _entryService.getRequestingUsers(companyId, keywords,
			serviceContext);
	}

	@Override
	public void blockUser(long blockUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_entryService.blockUser(blockUserId, serviceContext);
	}

	@Override
	public void unblockUser(long unblockUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_entryService.unblockUser(unblockUserId, serviceContext);
	}

	@Override
	public int getUsersAndContactsCount(long companyId,
		java.lang.String keywords,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _entryService.getUsersAndContactsCount(companyId, keywords,
			serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray searchMyFriends(
		long companyId, java.lang.String keywords,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _entryService.searchMyFriends(companyId, keywords, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getMyFileEntry(
		long portraitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _entryService.getMyFileEntry(portraitId);
	}

	@Override
	public com.liferay.portal.model.User getUserById(long userId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _entryService.getUserById(userId, serviceContext);
	}

	@Override
	public void addSocialRelation(long receiverUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws java.lang.Exception {
		_entryService.addSocialRelation(receiverUserId, serviceContext);
	}

	@Override
	public void requestSocialRelation(long receiverUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws java.lang.Exception {
		_entryService.requestSocialRelation(receiverUserId, serviceContext);
	}

	@Override
	public int getRequestsCount(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _entryService.getRequestsCount(serviceContext);
	}

	@Override
	public void deleteSocialRelation(long receiverUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws java.lang.Exception {
		_entryService.deleteSocialRelation(receiverUserId, serviceContext);
	}

	@Override
	public java.util.Map<java.util.Date, com.liferay.portal.kernel.json.JSONObject> getAllMyMessages(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _entryService.getAllMyMessages(serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EntryService getWrappedEntryService() {
		return _entryService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEntryService(EntryService entryService) {
		_entryService = entryService;
	}

	@Override
	public EntryService getWrappedService() {
		return _entryService;
	}

	@Override
	public void setWrappedService(EntryService entryService) {
		_entryService = entryService;
	}

	private EntryService _entryService;
}