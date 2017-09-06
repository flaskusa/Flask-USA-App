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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Entry. This utility wraps
 * {@link com.liferay.contacts.service.impl.EntryServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see EntryService
 * @see com.liferay.contacts.service.base.EntryServiceBaseImpl
 * @see com.liferay.contacts.service.impl.EntryServiceImpl
 * @generated
 */
public class EntryServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.contacts.service.impl.EntryServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.portal.kernel.json.JSONArray searchUsersAndContacts(
		long companyId, java.lang.String keywords, int start, int end,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .searchUsersAndContacts(companyId, keywords, start, end,
			serviceContext);
	}

	public static java.util.List<com.liferay.portlet.social.model.SocialRequest> getRequestsToConfirm(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRequestsToConfirm(serviceContext);
	}

	public static com.liferay.portlet.social.model.SocialRequest deleteRequest(
		long receiverUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws java.lang.Exception {
		return getService().deleteRequest(receiverUserId, serviceContext);
	}

	public static com.liferay.portal.kernel.json.JSONArray getRequestingUsers(
		long companyId, java.lang.String keywords,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getRequestingUsers(companyId, keywords, serviceContext);
	}

	public static void blockUser(long blockUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().blockUser(blockUserId, serviceContext);
	}

	public static void unblockUser(long unblockUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().unblockUser(unblockUserId, serviceContext);
	}

	public static int getUsersAndContactsCount(long companyId,
		java.lang.String keywords,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getUsersAndContactsCount(companyId, keywords, serviceContext);
	}

	public static com.liferay.portal.kernel.json.JSONArray searchMyFriends(
		long companyId, java.lang.String keywords,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().searchMyFriends(companyId, keywords, serviceContext);
	}

	public static com.liferay.portal.kernel.repository.model.FileEntry getMyFileEntry(
		long portraitId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getMyFileEntry(portraitId);
	}

	public static com.liferay.portal.model.User getUserById(long userId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getUserById(userId, serviceContext);
	}

	public static void addSocialRelation(long receiverUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws java.lang.Exception {
		getService().addSocialRelation(receiverUserId, serviceContext);
	}

	public static void requestSocialRelation(long receiverUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws java.lang.Exception {
		getService().requestSocialRelation(receiverUserId, serviceContext);
	}

	public static int getRequestsCount(
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRequestsCount(serviceContext);
	}

	public static void deleteSocialRelation(long receiverUserId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws java.lang.Exception {
		getService().deleteSocialRelation(receiverUserId, serviceContext);
	}

	public static java.util.Map<java.util.Date, com.liferay.portal.kernel.json.JSONObject> getAllMyMessages(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().getAllMyMessages(serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static EntryService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EntryService.class.getName());

			if (invokableService instanceof EntryService) {
				_service = (EntryService)invokableService;
			}
			else {
				_service = new EntryServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(EntryServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EntryService service) {
	}

	private static EntryService _service;
}