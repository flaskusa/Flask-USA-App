package com.rumbasolutions.flask.service.impl;

import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.rumbasolutions.flask.model.FlaskAdmin;
import com.rumbasolutions.flask.model.FlaskRole;
import com.rumbasolutions.flask.model.impl.FlaskAdminImpl;
import com.rumbasolutions.flask.model.impl.FlaskRoleImpl;

public class ModelUtil {

	public static final String FLASK_ADMIN =  "Flask Admin";
	public static final String LIFERAY_ADMIN=  "Administrator";
	public static final String FLASK_CONTENT_ADMIN=  "Flask Content Manager";
	public static final String FLASK_USER=  "User";
	
	public enum FlaskRoleEnum{
		FLASK_ADMIN   ("Flask Admin"),
		FLASK_CONTENT_ADMIN ("Flask Content Manager"),
		FLASK_USER  ("User");
		
		private final String roleName;
		FlaskRoleEnum(String roleName){
			this.roleName = roleName;
		}
		public String getRoleName(){
			return roleName;
		}
		
	}
	public static FlaskAdmin getFlaskAdmin(User user){

		FlaskAdmin admin = new FlaskAdminImpl(); 
		admin.setUserId(user.getUserId()); 
		admin.setFirstName(user.getFirstName()); 
		admin.setLastName(user.getLastName());
		admin.setMiddleName(user.getMiddleName());
		admin.setEmail(user.getEmailAddress());
		return admin;
	}
	public static FlaskRole getFlaskRole(Role role){

		FlaskRole fRole = new FlaskRoleImpl(); 
		fRole.setRoleId(role.getRoleId()); 
		fRole.setRoleName(role.getName());
		fRole.setRoleDesc(role.getDescription());
		return fRole;
	}
	
	public static  ServiceContext getServiceContext(){
		
		return ServiceContextThreadLocal.getServiceContext();
	}
	
	
}