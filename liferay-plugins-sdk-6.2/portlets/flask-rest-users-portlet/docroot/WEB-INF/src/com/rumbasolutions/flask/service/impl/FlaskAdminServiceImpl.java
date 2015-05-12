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
import java.util.Locale;

import com.liferay.portal.ReservedUserIdException;
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
	
	
/*
 * 
 * This method gets list of all users with Flask admin role
 * @see com.rumbasolutions.flask.service.FlaskAdminService#getFlaskAdmins()
 */
	private static Log LOGGER = LogFactoryUtil.getLog(FlaskAdminServiceImpl.class);
			
	@Override
	public List<FlaskAdmin> getFlaskAdmins(){
		List<FlaskAdmin> adminList=null;
		try{
			adminList = getFlaskAdmins(ModelUtil.FLASK_ADMIN);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return adminList;
	}
	
	/*
	 * This method gets list of all users with the content manager role 
	 * 
	 * 
	 */
	
	@Override
	public List<FlaskAdmin> getFlaskContentManagers(){
		List<FlaskAdmin> adminList=null;
		try{
			adminList = getFlaskAdmins(ModelUtil.FLASK_CONTENT_ADMIN);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return adminList;
	}

	/**
	 * @param cmList
	 * @throws PortalException
	 * @throws SystemException
	 */
	private List<FlaskAdmin> getFlaskAdmins(String adminType)
			throws PortalException, SystemException {
		
		List<FlaskAdmin> adminList= new ArrayList<FlaskAdmin>();
		Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), adminType );
		int adminUsersCnt = UserLocalServiceUtil.getRoleUsersCount(role.getRoleId());
		List<User> users= UserLocalServiceUtil.getRoleUsers(role.getRoleId(), 0, adminUsersCnt);
		for(User user : users){
			adminList.add(ModelUtil.getFlaskAdmin(user));
		}
		return adminList;
	}
	
	/*
	 * This method adds flask admins
	 * 
	 * 
	 */
	
	@Override
	public  FlaskAdmin addFlaskAdmin(String firstName, String middleName, String lastName, 
			String email, String screenName,String password1, String password2,  
			ServiceContext serviceContext) throws SystemException, PortalException
	{
		FlaskAdmin adminUser=null;
		Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), ModelUtil.FlaskRoleEnum.FLASK_ADMIN.getRoleName());
		User user = addUser(role.getRoleId(), serviceContext.getUserId(), firstName, middleName, lastName, screenName, email, password1,  password2 );
		if(user != null)
			adminUser = ModelUtil.getFlaskAdmin(user);
		return adminUser;
	}
	
	
	@Override
	public  FlaskAdmin updateFlaskAdmin(long userId, String firstName, String middleName, String lastName, 
			String email, String screenName,String password1, String password2,  
			ServiceContext serviceContext) throws SystemException, PortalException
	{
		FlaskAdmin adminUser=null;
		Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), ModelUtil.FlaskRoleEnum.FLASK_ADMIN.getRoleName());
		User user = updateUser(userId, role.getRoleId(), serviceContext.getUserId(), firstName, middleName, lastName, screenName, email, password1,  password2 );
		if(user != null)
			adminUser = ModelUtil.getFlaskAdmin(user);
		return adminUser;
	}
	
	
	/*
	 * This adds user with the content manager role 
	 * 
	 * 
	 */
	
	@Override
	public  FlaskAdmin addFlaskContentManager(String firstName, String middleName, String lastName, 
			String email, String screenName,String password1, String password2,  
			ServiceContext serviceContext) throws SystemException, PortalException
	{
		FlaskAdmin adminUser=null;
		Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), ModelUtil.FlaskRoleEnum.FLASK_CONTENT_ADMIN.getRoleName());
		User user = addUser(role.getRoleId(), serviceContext.getUserId(), firstName, middleName, lastName, screenName, email, password1,  password2 );
		if(user != null)
			adminUser = ModelUtil.getFlaskAdmin(user);
		return adminUser;
	}
	
/**
 * Update content managers
 */
	@Override
	public  FlaskAdmin updateFlaskContentManager(long userId, String firstName, String middleName, String lastName, 
			String email, String screenName,String password1, String password2,  
			ServiceContext serviceContext) throws SystemException, PortalException
	{
		FlaskAdmin adminUser=null;
		Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), ModelUtil.FlaskRoleEnum.FLASK_CONTENT_ADMIN.getRoleName());
		User user = updateUser(userId, role.getRoleId(), serviceContext.getUserId(), firstName, middleName, lastName, screenName, email, password1,  password2 );
		if(user != null)
			adminUser = ModelUtil.getFlaskAdmin(user);
		return adminUser;
	}
	
	/**
	 * 
	 */
	@Override
	public  void deleteFlaskAdmins(long userId, ServiceContext serviceContext) throws SystemException, PortalException
	{
		FlaskAdmin adminUser=null;
		if(serviceContext.getUserId() == userId){
			throw new ReservedUserIdException("User cannot delete self");
		}
		User user = UserLocalServiceUtil.getUser(userId);
		List<Role> roles = user.getRoles();
		for(Role role :roles){
			if(role.getName().contentEquals(ModelUtil.LIFERAY_ADMIN)){
				throw new ReservedUserIdException("Administrators cannot be deleted");
			}
		}
		UserLocalServiceUtil.deleteUser(userId);
	}
	
	
	
	
	private User addUser(long roldId, long loggedInUser, String firstName, String middleName, 
			String lastName, String screenName, String email, String password1, String password2 ) throws PortalException, SystemException
	{
		User user=null;
	
			 long[] emptyLong = {};
			 long[] roleIds ={roldId};
			 user = UserLocalServiceUtil.addUser(
					 	loggedInUser /*long creatorUserId*/,
					 	PortalUtil.getDefaultCompanyId() /*long companyId*/,
					 	false /*boolean autoPassword*/,
					 	password1 /*String password1*/,
					 	password2 /*String password2*/,
				 		false /*boolean autoScreenName*/,
				 		screenName /* String screenName*/,
				 		email 	/*String emailAddress*/,
				 		0, 		//long facebookId,
				 		"", 	//String openId
				 		new Locale("en-us") /*Locale locale*/,
				 		firstName /*String firstName*/,
				 		middleName /*String middleName*/,
				 		lastName /*String lastName*/,
				 		0/*int prefixId*/,
				 		0 /*int suffixId*/,
				 		true /*boolean male*/,
				 		1 /*int birthdayMonth*/,
				 		1 /*int birthdayDay*/,
				 		1970 /*int birthdayYear*/,
				 		null /*String jobTitle*/,
				 		emptyLong, /*groupIds*/
				 		emptyLong, /*long[] organizationIds*/
				 		roleIds, /*long[] roleIds*/
				 		emptyLong, /*long[] userGroupId*/
				 		true, /*boolean sendEmail*/
				 		null);
	
			return user;
	}
	
	private User updateUser(long userId, long roleId, long loggedInUser, String firstName, String middleName, 
			String lastName, String screenName, String email, String password1, String password2 ) throws PortalException, SystemException
	{
			 User user=null;
			 long[] roleIds ={roleId};
			 user = UserLocalServiceUtil.getUser(userId);
			 
			 user.setFirstName(firstName);
			 user.setMiddleName(middleName);
			 user.setLastName(lastName);
			 user.setScreenName(screenName);
			 user.setEmailAddress(email);
			 user.setPassword(password1);
			 user = UserLocalServiceUtil.updateUser(user) ;
			 
			 RoleLocalServiceUtil.deleteUserRoles(userId, user.getRoleIds());
			 RoleLocalServiceUtil.addUserRoles(userId, roleIds);
			 
			 return user;
	}
	
}