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
public class TailgateMarkerFinderUtil {
	public static com.rumbasolutions.flask.model.TailgateMarker getTailgateMarker(
		long tailgateId) {
		return getFinder().getTailgateMarker(tailgateId);
	}

	public static int deleteTailgateMarker(long tailgateId) {
		return getFinder().deleteTailgateMarker(tailgateId);
	}

	public static TailgateMarkerFinder getFinder() {
		if (_finder == null) {
			_finder = (TailgateMarkerFinder)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					TailgateMarkerFinder.class.getName());

			ReferenceRegistry.registerReference(TailgateMarkerFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TailgateMarkerFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TailgateMarkerFinderUtil.class,
			"_finder");
	}

	private static TailgateMarkerFinder _finder;
}