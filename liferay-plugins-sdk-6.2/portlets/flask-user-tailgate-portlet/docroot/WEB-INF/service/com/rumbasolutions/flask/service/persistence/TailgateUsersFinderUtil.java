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
public class TailgateUsersFinderUtil {
	public static java.util.List<com.rumbasolutions.flask.model.TailgateUsers> getTailgateUsersByTailgateId(
		long tailgateId) {
		return getFinder().getTailgateUsersByTailgateId(tailgateId);
	}

	public static int deleteTailgateUser(long tailgateId, long userId) {
		return getFinder().deleteTailgateUser(tailgateId, userId);
	}

	public static int deleteTailgateUsers(long tailgateId,
		java.lang.String userIds) {
		return getFinder().deleteTailgateUsers(tailgateId, userIds);
	}

	public static TailgateUsersFinder getFinder() {
		if (_finder == null) {
			_finder = (TailgateUsersFinder)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					TailgateUsersFinder.class.getName());

			ReferenceRegistry.registerReference(TailgateUsersFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TailgateUsersFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TailgateUsersFinderUtil.class,
			"_finder");
	}

	private static TailgateUsersFinder _finder;
}