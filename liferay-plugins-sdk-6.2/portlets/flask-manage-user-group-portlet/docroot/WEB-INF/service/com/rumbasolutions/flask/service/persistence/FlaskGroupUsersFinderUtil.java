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
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class FlaskGroupUsersFinderUtil {
	public static java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> getGroupUsersListByGroupId(
		long groupId) {
		return getFinder().getGroupUsersListByGroupId(groupId);
	}

	public static int addGroupOwner(long groupId, long userId) {
		return getFinder().addGroupOwner(groupId, userId);
	}

	public static int deleteGroupUser(long groupId, long userId) {
		return getFinder().deleteGroupUser(groupId, userId);
	}

	public static int deleteGroupUsers(long groupId, java.lang.String userIds) {
		return getFinder().deleteGroupUsers(groupId, userIds);
	}

	public static FlaskGroupUsersFinder getFinder() {
		if (_finder == null) {
			_finder = (FlaskGroupUsersFinder)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					FlaskGroupUsersFinder.class.getName());

			ReferenceRegistry.registerReference(FlaskGroupUsersFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(FlaskGroupUsersFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(FlaskGroupUsersFinderUtil.class,
			"_finder");
	}

	private static FlaskGroupUsersFinder _finder;
}