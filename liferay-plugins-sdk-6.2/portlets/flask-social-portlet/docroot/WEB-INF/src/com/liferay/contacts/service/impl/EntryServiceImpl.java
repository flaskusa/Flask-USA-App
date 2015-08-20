/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */

package com.liferay.contacts.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.liferay.contacts.model.Entry;
import com.liferay.contacts.service.base.EntryServiceBaseImpl;
import com.liferay.contacts.util.ContactsUtil;
import com.liferay.contacts.util.PortletKeys;
import com.liferay.contacts.util.SocialRelationConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.notifications.NotificationEvent;
import com.liferay.portal.kernel.notifications.NotificationEventFactoryUtil;
import com.liferay.portal.kernel.notifications.UserNotificationManagerUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserNotificationDeliveryConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.social.NoSuchRelationException;
import com.liferay.portlet.social.model.SocialRequest;
import com.liferay.portlet.social.service.SocialRelationLocalServiceUtil;
import com.liferay.portlet.social.service.SocialRequestLocalServiceUtil;

/**
 * @author Bruno Farache
 */
public class EntryServiceImpl extends EntryServiceBaseImpl {

	public JSONArray searchUsersAndContacts(
			long companyId, String keywords, int start, int end)
		throws PortalException, SystemException {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		long userId = getUserId();

		List<BaseModel<?>> contacts = entryLocalService.searchUsersAndContacts(
			companyId, userId, keywords, start, end);

		for (BaseModel<?> contact : contacts) {
			JSONObject jsonObject = null;

			if (contact instanceof User) {
				jsonObject = ContactsUtil.getUserJSONObject(
					userId, (User)contact);
			}
			else {
				jsonObject = ContactsUtil.getEntryJSONObject((Entry)contact);
			}

			jsonArray.put(jsonObject);
		}

		return jsonArray;
	}

	public void addSocialRelation(long receiverUserId, int type, ServiceContext serviceContext)
		throws Exception {
			long socialRequestId;
			SocialRequest sRequest;
			List<SocialRequest> request = SocialRequestLocalServiceUtil.getUserRequests(serviceContext.getUserId(), 3, 0, 50);
			for(SocialRequest socialRequest: request ){
				if(socialRequest.getUserId() == serviceContext.getUserId()){
					socialRequestId = socialRequest.getRequestId();
					sRequest = SocialRequestLocalServiceUtil.getSocialRequest(socialRequestId);
					ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
					SocialRequestLocalServiceUtil.updateRequest(socialRequestId, 1, themeDisplay);
				}
			}
			SocialRelationLocalServiceUtil.addRelation(serviceContext.getUserId(), receiverUserId, type);
	}

	public void requestSocialRelation(long receiverUserId, int type, ServiceContext serviceContext)throws Exception {
			SocialRequest socialRequest = SocialRequestLocalServiceUtil.addRequest(serviceContext.getUserId(), 0, User.class.getName(),serviceContext.getUserId(), type, "", receiverUserId);
			sendNotificationEvent(socialRequest);
	}
	
	
	protected void sendNotificationEvent(SocialRequest socialRequest)
			throws Exception {

			if (UserNotificationManagerUtil.isDeliver(
					socialRequest.getReceiverUserId(), PortletKeys.CONTACTS_CENTER,
					0, SocialRelationConstants.SOCIAL_RELATION_REQUEST,
					UserNotificationDeliveryConstants.TYPE_WEBSITE)) {

				JSONObject notificationEventJSONObject =
					JSONFactoryUtil.createJSONObject();

				notificationEventJSONObject.put("actionRequired", true);
				notificationEventJSONObject.put(
					"classPK", socialRequest.getRequestId());
				notificationEventJSONObject.put(
					"userId", socialRequest.getUserId());

				NotificationEvent notificationEvent =
					NotificationEventFactoryUtil.createNotificationEvent(
						System.currentTimeMillis(), PortletKeys.CONTACTS_CENTER,
						notificationEventJSONObject);

				notificationEvent.setDeliveryRequired(0);

				UserNotificationEventLocalServiceUtil.addUserNotificationEvent(
					socialRequest.getReceiverUserId(), notificationEvent);
			}
		}
	public void deleteSocialRelation(ServiceContext serviceContext)
		throws Exception {
		HttpServletRequest request = serviceContext.getRequest();
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		long[] userIds = getUserIds(request);

		int type = ParamUtil.getInteger(request, "type");

		for (long userId : userIds) {
			if (userId == themeDisplay.getUserId()) {
				continue;
			}

			try {
				SocialRelationLocalServiceUtil.deleteRelation(
					themeDisplay.getUserId(), userId, type);
			}
			catch (NoSuchRelationException nsre) {
			}
		}
	}

	protected long[] getUserIds(HttpServletRequest request) {
		long[] userIds;

		long userId = ParamUtil.getLong(request, "userId", 0);

		if (userId > 0) {
			userIds = new long[] {userId};
		}
		else {
			userIds = StringUtil.split(
				ParamUtil.getString(request, "userIds"), 0L);
		}

		return userIds;
	}
}