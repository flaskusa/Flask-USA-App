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

import java.util.List;

import com.liferay.portal.model.Role;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the tailgate users remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.TailgateUsersService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Kiran
 
 */
public class FlaskTailgateUtil {
	
	public static final String FLASK_ADMIN =  "Flask Admin";
	public static final String LIFERAY_ADMIN=  "Administrator";
	public static final String FLASK_CONTENT_ADMIN=  "Flask Content Manager";
	public static final String FLASK_USER=  "User";
	
	public enum FlaskRoleEnum{
		FLASK_ADMIN   ("Flask Admin"),
		FLASK_CONTENT_ADMIN ("Flask Content Manager"),
		FLASK_USER  ("User"),
		LIFERAY_ADMIN  ("Administrator");
		
		private final String roleName;
		FlaskRoleEnum(String roleName){
			this.roleName = roleName;
		}
		public String getRoleName(){
			return roleName;
		}
		
	}
	
	public static boolean isUserAdmin(long userId, String[] roles){
		boolean admin = false;
		try {
			List<Role> userRoles = UserLocalServiceUtil.getUser(userId).getRoles();
			for(int i=0; i<roles.length; i++){
				for(int j=0; j<userRoles.size(); j++){
					if(userRoles.get(j).getName().equals(roles[i])){
						admin = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
}