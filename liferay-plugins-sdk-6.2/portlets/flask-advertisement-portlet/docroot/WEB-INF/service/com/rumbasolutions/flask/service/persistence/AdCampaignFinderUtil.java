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
public class AdCampaignFinderUtil {
	public static java.util.List getAdCampaginList() {
		return getFinder().getAdCampaginList();
	}

	public static java.util.List getAdCampaginListwithAddress() {
		return getFinder().getAdCampaginListwithAddress();
	}

	public static java.util.List getCampaignDetailsForEvents(
		java.lang.String eventList) {
		return getFinder().getCampaignDetailsForEvents(eventList);
	}

	public static AdCampaignFinder getFinder() {
		if (_finder == null) {
			_finder = (AdCampaignFinder)PortletBeanLocatorUtil.locate(com.rumbasolutions.flask.service.ClpSerializer.getServletContextName(),
					AdCampaignFinder.class.getName());

			ReferenceRegistry.registerReference(AdCampaignFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(AdCampaignFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(AdCampaignFinderUtil.class,
			"_finder");
	}

	private static AdCampaignFinder _finder;
}