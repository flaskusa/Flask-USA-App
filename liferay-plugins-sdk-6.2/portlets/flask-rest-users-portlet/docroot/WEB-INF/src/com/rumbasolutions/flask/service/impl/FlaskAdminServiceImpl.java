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

import com.liferay.portal.model.User;

import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.rumbasolutions.flask.model.FlaskAdmin;
import com.rumbasolutions.flask.service.base.FlaskAdminServiceBaseImpl;

/**
 * The implementation of the flask admin remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.FlaskAdminService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.base.FlaskAdminServiceBaseImpl
 * @see com.rumbasolutions.flask.service.FlaskAdminServiceUtil
 */
public class FlaskAdminServiceImpl extends FlaskAdminServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.FlaskAdminServiceUtil} to access the flask admin remote service.
	 */
	

	

	
	public List<FlaskAdmin> getFlaskAdmins(){
		List<FlaskAdmin> adminList = new ArrayList<FlaskAdmin>();

		try{
			Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), ModelUtil.FLASK_ADMIN);
			int adminUsersCnt = UserLocalServiceUtil.getRoleUsersCount(role.getRoleId());
			List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId(), 0, adminUsersCnt);
			for(User user : users){
				adminList.add(ModelUtil.getFlaskAdmin(user));
			}
		}catch(Exception ex){
			
		}
	
		return adminList;
	}
	
	public List<FlaskAdmin> getFlaskContentManagers(){
		List<FlaskAdmin> cmList = new ArrayList<FlaskAdmin>();
		try{
			Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), ModelUtil.FLASK_CONTENT_ADMIN);
			int adminUsersCnt = UserLocalServiceUtil.getRoleUsersCount(role.getRoleId());
			List<User> users= UserLocalServiceUtil.getRoleUsers(role.getRoleId(), 0, adminUsersCnt);
			for(User user : users){
				cmList.add(ModelUtil.getFlaskAdmin(user));
			}
		}catch(Exception ex){
			
		}
		return cmList;
	}

}