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

package com.rumbasolutions.flask.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.rumbasolutions.flask.model.FlaskAdmin;
import com.rumbasolutions.flask.service.base.FlaskUserServiceBaseImpl;

/**
 * The implementation of the flask user remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.FlaskUserService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.base.FlaskUserServiceBaseImpl
 * @see com.rumbasolutions.flask.service.FlaskUserServiceUtil
 */
public class FlaskUserServiceImpl extends FlaskUserServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.FlaskUserServiceUtil} to access the flask user remote service.
	 */
	
	@Override
	public List<FlaskAdmin> getFlaskUsers(ServiceContext serviceContext){
		List<FlaskAdmin> userList = new ArrayList<FlaskAdmin>();
		try{
			Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), FlaskModelUtil.FLASK_USER);
			int flaskUsers = UserLocalServiceUtil.getRoleUsersCount(role.getRoleId());
			
			//AR TODO implement paging/filtering
			//TODO return first 100 users
			flaskUsers = flaskUsers < 100 ? flaskUsers : 100;
			List<User> users= UserLocalServiceUtil.getRoleUsers(role.getRoleId(), 0, flaskUsers);
			for(User user : users){
				userList.add(FlaskModelUtil.getFlaskAdmin(user, serviceContext));
			}
		}catch(Exception ex){
			
		}
		return userList;
	}

}