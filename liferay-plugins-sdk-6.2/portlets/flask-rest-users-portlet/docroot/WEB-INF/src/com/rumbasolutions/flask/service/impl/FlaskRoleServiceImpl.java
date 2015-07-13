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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.rumbasolutions.flask.model.FlaskRole;
import com.rumbasolutions.flask.service.base.FlaskRoleServiceBaseImpl;

/**
 * The implementation of the flask role remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.FlaskRoleService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.base.FlaskRoleServiceBaseImpl
 * @see com.rumbasolutions.flask.service.FlaskRoleServiceUtil
 */
public class FlaskRoleServiceImpl extends FlaskRoleServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.FlaskRoleServiceUtil} to access the flask role remote service.
	 */
	
	private static Log LOGGER = LogFactoryUtil.getLog(FlaskRoleServiceImpl.class);


	@Override
	public List<FlaskRole> getFlaskRoles(){
		return FlaskModelUtil.getFlaskRoles();
	}
	
	@Override
	public void setFlaskRole( long userId, long roleId, ServiceContext  serviceContext) {
	
		try {
			User user = UserLocalServiceUtil.getUser(userId);
			Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), FlaskModelUtil.LIFERAY_ADMIN);
			long[] roleIds = user.getRoleIds();
			//make sure user is not Liferay administrator
			for(long id : roleIds){
				if(id == role.getRoleId()){
					LOGGER.error("Attempt to delete Administrator user, with id:" +  String.valueOf(userId));
					throw new PortalException();
				}
			}
			RoleLocalServiceUtil.deleteUserRoles(userId, roleIds);
			UserLocalServiceUtil.addRoleUser(roleId, userId);
		}
		catch (PortalException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		catch (SystemException e) {
			LOGGER.error(e.getMessage());
			e.printStackTrace();
		}
		
	}
}