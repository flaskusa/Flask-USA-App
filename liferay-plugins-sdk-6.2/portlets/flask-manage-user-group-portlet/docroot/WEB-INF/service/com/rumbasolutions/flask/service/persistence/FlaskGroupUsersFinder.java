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

/**
 * @author Brian Wing Shun Chan
 */
public interface FlaskGroupUsersFinder {
	public java.util.List<com.rumbasolutions.flask.model.FlaskGroupUsers> getGroupUsersListByGroupId(
		long groupId);

	public int addGroupOwner(long groupId, long userId);

	public int deleteGroupUser(long groupId, long userId);

	public int deleteGroupUsers(long groupId, java.lang.String userIds);
}