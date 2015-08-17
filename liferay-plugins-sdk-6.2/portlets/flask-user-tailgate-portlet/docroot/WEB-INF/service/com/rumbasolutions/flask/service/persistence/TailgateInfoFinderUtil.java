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
 * @author rajeshj
 */
public class TailgateInfoFinderUtil {
	public static java.util.List getAllMyTailgate(long userId) {
		return getFinder().getAllMyTailgate(userId);
	}

	public static int deleteTailgate(long tailgateId) {
		return getFinder().deleteTailgate(tailgateId);
	}

	public static int deleteTailgates(java.lang.String tailgateIds) {
		return getFinder().deleteTailgates(tailgateIds);
	}

	public static TailgateInfoFinder getFinder() {
		if (_finder == null) {
			_finder = (TailgateInfoFinder)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					TailgateInfoFinder.class.getName());

			ReferenceRegistry.registerReference(TailgateInfoFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TailgateInfoFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TailgateInfoFinderUtil.class,
			"_finder");
	}

	private static TailgateInfoFinder _finder;
}