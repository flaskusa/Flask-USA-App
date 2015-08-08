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
public class FlaskGroupFinderUtil {
	public static java.util.List<com.rumbasolutions.flask.model.FlaskGroup> getGroupList(
		long userId, int isAdmin) {
		return getFinder().getGroupList(userId, isAdmin);
	}

	public static java.util.List getAllMyGroups(long userId) {
		return getFinder().getAllMyGroups(userId);
	}

	public static int deleteGroup(long groupId) {
		return getFinder().deleteGroup(groupId);
	}

	public static int deleteGroups(java.lang.String groupIds) {
		return getFinder().deleteGroups(groupIds);
	}

	public static int deActivateGroup(long groupId) {
		return getFinder().deActivateGroup(groupId);
	}

	public static FlaskGroupFinder getFinder() {
		if (_finder == null) {
			_finder = (FlaskGroupFinder)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					FlaskGroupFinder.class.getName());

			ReferenceRegistry.registerReference(FlaskGroupFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(FlaskGroupFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(FlaskGroupFinderUtil.class,
			"_finder");
	}

	private static FlaskGroupFinder _finder;
}