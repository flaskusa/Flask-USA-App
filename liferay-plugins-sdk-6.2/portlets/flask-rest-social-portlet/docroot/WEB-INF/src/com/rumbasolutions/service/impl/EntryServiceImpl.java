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

package com.rumbasolutions.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.User;
import com.rumbasolutions.model.Entry;
import com.rumbasolutions.service.base.EntryServiceBaseImpl;
import com.rumbasolutions.util.ContactsUtil;

/**
 * The implementation of the entry remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.service.EntryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Admin
 * @see com.rumbasolutions.service.base.EntryServiceBaseImpl
 * @see com.rumbasolutions.service.EntryServiceUtil
 */
public class EntryServiceImpl extends EntryServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.service.EntryServiceUtil} to access the entry remote service.
	 */

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

}