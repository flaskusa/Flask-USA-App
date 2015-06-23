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
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.liferay.portal.ReservedUserIdException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.CountryUtil;
import com.liferay.portal.service.persistence.RegionUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoColumnConstants;
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
	public List<FlaskAdmin> getFlaskAdmins(ServiceContext  serviceContext){
		List<FlaskAdmin> adminList=null;
		try{
			adminList = getFlaskUsers(FlaskModelUtil.FLASK_ADMIN, serviceContext);
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
	public List<FlaskAdmin> getFlaskContentManagers(ServiceContext serviceContext){
		List<FlaskAdmin> adminList=null;
		try{
			adminList = getFlaskUsers(FlaskModelUtil.FLASK_CONTENT_ADMIN, serviceContext);
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return adminList;
	}
	
	
	/*
	 * This method gets list of all users with the content manager role 
	 *  
	 *  Get list of users based on filter
	 *  Possible filter values "All" , "Users", "Flask Admin", "Flask Content Manager"
	 */
	
	@Override
	public List<FlaskAdmin> getAllUsers(String userType,ServiceContext serviceContext){
		List<FlaskAdmin> adminList=new ArrayList<FlaskAdmin>(100);;
		try{
			if(userType.toLowerCase().contentEquals(FlaskModelUtil.All_USERS)){
				adminList.addAll(getFlaskUsers(FlaskModelUtil.FLASK_ADMIN, serviceContext));
				adminList.addAll(getFlaskUsers(FlaskModelUtil.FLASK_CONTENT_ADMIN, serviceContext));
				adminList.addAll(getFlaskUsers(FlaskModelUtil.FLASK_USER, serviceContext));
			}
		}catch(Exception ex){
			LOGGER.error(ex);
		}
		return adminList;
	}
	
	

	/**
	 * @param User List
	 * @throws PortalException
	 * @throws SystemException
	 */
	private List<FlaskAdmin> getFlaskUsers(String adminType,ServiceContext serviceContext)
			throws PortalException, SystemException {
		
		List<FlaskAdmin> adminList= new ArrayList<FlaskAdmin>();
		Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), adminType );
		int adminUsersCnt = UserLocalServiceUtil.getRoleUsersCount(role.getRoleId());
		adminUsersCnt = adminUsersCnt < FlaskModelUtil.MAX_USER_LIMIT ? adminUsersCnt : FlaskModelUtil.MAX_USER_LIMIT;
		List<User> users= UserLocalServiceUtil.getRoleUsers(role.getRoleId(), 0, adminUsersCnt);
		for(User user : users){
			adminList.add(FlaskModelUtil.getFlaskUser(user, serviceContext));
		}
		return adminList;
	}
	
	/*
	 * This method adds flask admins
	 * 
	 * 
	 */
	
	@Override
	public	FlaskAdmin addFlaskAdmin(String firstName, String middleName, String lastName, 
					String email, String screenName,String password1, String password2,  
					String DOB, boolean isMale,
					String streetName, String aptNo,
					String areaCode, String city,
					long stateId, long countryId,
					String mobileNumber, String userInterests, 
					ServiceContext serviceContext) throws SystemException, PortalException
	{
		FlaskAdmin adminUser=null;
		Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), FlaskModelUtil.FlaskRoleEnum.FLASK_ADMIN.getRoleName());
		User user = addUser(role.getRoleId(), serviceContext.getUserId(), firstName, middleName, lastName, 
				screenName, email, password1,  password2,
				DOB, isMale,
				streetName, aptNo,
				areaCode, city,
				stateId, countryId,
				mobileNumber, userInterests, serviceContext);
		if(user != null) {
			adminUser = FlaskModelUtil.getFlaskUser(user, serviceContext);
		}
		return adminUser;
	}
	
	
	@Override
	public  FlaskAdmin updateFlaskAdmin(long userId, String firstName, String middleName, String lastName, 
			String email, String screenName,String password1, String password2,  
			String DOB, boolean isMale,
			String streetName, String aptNo,
			String areaCode, String city,
			long stateId, long countryId,
			String mobileNumber, String userInterests,
			ServiceContext serviceContext) throws SystemException, PortalException
	{
		FlaskAdmin adminUser=null;
		Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), FlaskModelUtil.FlaskRoleEnum.FLASK_ADMIN.getRoleName());
		User user = updateUser(userId, role.getRoleId(), serviceContext.getUserId(),
				firstName, middleName, lastName, 
				screenName, email, password1,  password2,
				DOB, isMale,
				streetName, aptNo,
				areaCode, city,
				stateId, countryId,
				mobileNumber, userInterests, serviceContext);
		if(user != null) {
			adminUser = FlaskModelUtil.getFlaskUser(user, serviceContext);
		}
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
			String DOB, boolean isMale,
			String streetName, String aptNo,
			String areaCode, String city,
			long stateId, long countryId,
			String mobileNumber, String userInterests, 
			ServiceContext serviceContext) throws SystemException, PortalException
	{
		
			
		FlaskAdmin adminUser=null;
		Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), FlaskModelUtil.FlaskRoleEnum.FLASK_CONTENT_ADMIN.getRoleName());
		User user = addUser(role.getRoleId(), serviceContext.getUserId(), firstName, middleName, lastName, 
				screenName, email, password1,  password2,
				DOB, isMale,
				streetName, aptNo,
				areaCode, city,
				stateId, countryId,
				mobileNumber, userInterests, serviceContext);
		if(user != null) {
			adminUser = FlaskModelUtil.getFlaskUser(user, serviceContext);
		}
		return adminUser;
	}
	
	
	
	
/**
 * Update content managers
 */
	@Override
	public  FlaskAdmin updateFlaskContentManager(long userId, String firstName, String middleName, String lastName, 
			String email, String screenName,String password1, String password2,
			String DOB, boolean isMale,
			String streetName, String aptNo,
			String areaCode, String city,
			long state, long country,
			String mobileNumber, String userInterests,
			ServiceContext serviceContext) throws SystemException, PortalException
	{
		FlaskAdmin adminUser=null;
		Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), FlaskModelUtil.FlaskRoleEnum.FLASK_CONTENT_ADMIN.getRoleName());
		User user = updateUser(userId, role.getRoleId(), serviceContext.getUserId(), firstName,
						middleName, lastName, screenName, email, password1,  password2, 
						DOB, isMale,
						streetName, aptNo,
						areaCode, city,
						state, country,
						mobileNumber, userInterests, serviceContext);
		if(user != null) {
			adminUser = FlaskModelUtil.getFlaskUser(user, serviceContext);
		}
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
			if(role.getName().contentEquals(FlaskModelUtil.LIFERAY_ADMIN)){
				throw new ReservedUserIdException("Administrators cannot be deleted");
			}
		}
		UserLocalServiceUtil.deleteUser(userId);
	}
	
	
	/**
	 *  Returns valid user id if user found else 0. -1 when there is unknown system exception
	 */
	@Override
	public  long getUserIdForScreenName(String screenName, ServiceContext serviceContext) 
	{
		
		long userId = 0;
		User  user=null;;
		try{
			user = UserLocalServiceUtil.getUserByScreenName(PortalUtil.getDefaultCompanyId(), screenName);
			userId = user.getUserId();
		}catch(PortalException  ex){
			//no user with screen name.. hence unique
			
		}catch(SystemException ex){
			LOGGER.error("Exception in getUserIdForEmail " + ex.getMessage());
			userId = -1;
		}
		return userId;
	}
	
	/**
	 *  Returns valid user id if user found else 0. -1 when there is unknown system exception
	 */
	@Override
	public  long getUserIdForEmail(String  emailAddress, ServiceContext serviceContext)
	{
		long userId = 0;
		User  user;
		try{
			user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), emailAddress);
			userId = user.getUserId();
		}catch(PortalException  ex){
			return 0;
		}catch(SystemException ex){
			LOGGER.error("Exception in getUserIdForEmail " + ex.getMessage());
			userId = -1;
		}
		return userId;
	}
	
	/**
	 *  Returns valid user id if user found else 0. -1 when there is unknown system exception
	 */
	@Override
	public  FlaskAdmin getUserById(long userId, ServiceContext serviceContext)
	{
		FlaskAdmin flaskUser=null;
		try{
			User  user = UserLocalServiceUtil.getUser(userId);
			flaskUser =FlaskModelUtil.getFlaskUser(user, serviceContext);
		}catch(PortalException  ex){
			LOGGER.error("Exception in getUserIdById" + ex.getMessage());
		}catch(SystemException ex){
			LOGGER.error("Exception in getUserIdById" + ex.getMessage());
		}
		return flaskUser;
	}
	
	private User addUser(long roldId, long loggedInUser, String firstName, String middleName, 
			String lastName, String screenName, String email,
			String password1, String password2,
			String DOB, boolean isMale,
			String streetName, String aptNo,
			String areaCode, String city,
			long stateId, long countryId,
			String mobileNumber, String userInterests, ServiceContext serviceContext) throws PortalException, SystemException {
		
			User user=null;
			Calendar cal = FlaskModelUtil.parseDate(DOB);
	
			
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
				 		isMale /*boolean male*/,
				 		cal.get(Calendar.MONTH) /*int birthdayMonth*/,
				 		cal.get(Calendar.DAY_OF_MONTH) /*int birthdayDay*/,
				 		cal.get(Calendar.YEAR) /*int birthdayYear*/,
				 		null /*String jobTitle*/,
				 		emptyLong, /*groupIds*/
				 		emptyLong, /*long[] organizationIds*/
				 		roleIds, /*long[] roleIds*/
				 		emptyLong, /*long[] userGroupId*/
				 		true, /*boolean sendEmail*/
				 		null);
			 
			 addUserInterest(userInterests, user);
			 
		addAddress(streetName, aptNo, areaCode, city, stateId, countryId,
					serviceContext, user);
			 
			 if(!mobileNumber.isEmpty()){
				 addMobile(mobileNumber, user, serviceContext);
			 }
			 return user;
	}



	private void addUserInterest(String userInterests, User user)
			throws PortalException {
		
		if(userInterests.isEmpty()) {
			return;
		}
		
		//JSONArray json = JSONFactoryUtil.createJSONArray(userInterests); //this should validate JSON else throw JSON exception
		
		if (!user.getExpandoBridge().hasAttribute(FlaskModelUtil.EXPANDO_COL_USER_INTERESTS)){
			 user.getExpandoBridge().addAttribute(FlaskModelUtil.EXPANDO_COL_USER_INTERESTS, ExpandoColumnConstants.STRING);
		}
		user.getExpandoBridge().setAttribute(FlaskModelUtil.EXPANDO_COL_USER_INTERESTS, userInterests, false);
	}

	private void addMobile(String mobileNumber, User user, ServiceContext serviceContext){
		if(mobileNumber == null || mobileNumber.isEmpty()){
			LOGGER.warn("Empty mobile number");
			return;
		}
		int mobileTypeId = FlaskModelUtil.getMobilePhoneTypeId();
		try {
			Phone phone = PhoneLocalServiceUtil.addPhone( user.getUserId()/*long userId*/,
					 Contact.class.getName()/*String className*/,
					 user.getContact().getClassPK()/*long classPK*/,
			         mobileNumber,
			         ""/*String extension*/,
			         mobileTypeId/*int typeId*/,
			         true,
			         serviceContext);
			if(phone == null){
				LOGGER.error("Error in adding phone");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		
	}

	private void addAddress(String streetName, String aptNo, String areaCode,
							String city, long stateId, long countryId,
							ServiceContext serviceContext,User user){
		
		 int addressTypeId = FlaskModelUtil.getPersonalAddressId();
		 try {
			Address address = AddressLocalServiceUtil.addAddress( user.getUserId()/*long userId*/,
			         Contact.class.getName()/*String className*/,
			         user.getContact().getClassPK()/*long classPK*/,
			         aptNo/*String street1*/,
			         streetName /*String street2*/,
			         "" /*String street1*/,
			         city /*String City*/,
			         areaCode /*String zipCode*/,
			         stateId /*  long regionId*/,
 					 countryId/* long countryId */,
			         addressTypeId,
			         false	/*boolean mailing*/,
			         true	/*boolean primary*/,
			         serviceContext);
			if(address == null){
				LOGGER.error("Error in adding address");
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	/**
	 * THis function sets address fields to passed Address Object and saves the address
	 * @param streetName
	 * @param aptNo
	 * @param areaCode
	 * @param city
	 * @param stateId
	 * @param countryId
	 * @param addr
	 * @throws SystemException
	 */
	
	private void setAddress(
		String streetName, String aptNo, String areaCode, String city, long stateId, long countryId, Address addr)
		throws SystemException {

		addr.setStreet1(aptNo);
		addr.setStreet2(streetName);
		addr.setCity(city);
		addr.setRegionId(stateId);
		addr.setCountryId(countryId);
		addr.setZip(areaCode);
		AddressLocalServiceUtil.updateAddress(addr);
	}
	/**
	 * 
	 * @param userId
	 * @param roleId
	 * @param loggedInUser
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param screenName
	 * @param email
	 * @param password1
	 * @param password2
	 * @param DOB
	 * @param isMale
	 * @param streetName
	 * @param aptNo
	 * @param areaCode
	 * @param city
	 * @param stateId
	 * @param countryId
	 * @param mobileNumber
	 * @param userInterests
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	private User updateUser(long userId, long roleId, long loggedInUser, String firstName, String middleName, 
			String lastName, String screenName, String email, String password1, String password2,
			String DOB, boolean isMale,
			String streetName, String aptNo,
			String areaCode, String city,
			long stateId, long countryId,
			String mobileNumber, String userInterests, 
			ServiceContext serviceContext) throws PortalException, SystemException {
		
		long[] roleIds = {roleId};
		User user =	UserLocalServiceUtil.getUser(userId);
		Calendar cal = FlaskModelUtil.parseDate(DOB);
		user = UserLocalServiceUtil.updateUser( userId /*long userId*/,
				password1/*String oldPassword*/,
				password1 /*String newPassword1*/,
				password1/*String newPassword2*/,
                false/*boolean passwordReset*/,
                user.getReminderQueryQuestion() /*String reminderQueryQuestion*/,
                user.getReminderQueryAnswer() /*String reminderQueryAnswer*/,
                screenName/*String screenName*/,
                email/*String emailAddress*/,
                user.getFacebookId()/*long facebookId*/,
                user.getOpenId()/*String openId*/,
                user.getLanguageId() /*String languageId*/,
                user.getTimeZoneId()/*String timeZoneId*/,
                user.getGreeting()/*String greeting*/,
                user.getComments()/*String comments*/,
                firstName/*String firstName*/,
                middleName/*String middleName*/,
                lastName/*String lastName*/,
                0/*int prefixId*/,
                0/*int suffixId*/,
                isMale/*boolean male*/,
            	cal.get(Calendar.MONTH) /*int birthdayMonth*/,
		 		cal.get(Calendar.DAY_OF_MONTH) /*int birthdayDay*/,
		 		cal.get(Calendar.YEAR) /*int birthdayYear*/,
		 		""/*String smsSn*/,
		 		""/*String aimSn*/,
                "" /*String facebookSn*/,
                "" /*String icqSn*/,
                "" /*String jabberSn*/,
                "" /*String msnSn*/,
                "" /*String mySpaceSn*/,
                ""/*String skypeSn*/,
                "" /*String twitterSn*/,
                "" /*String ymSn*/,
                user.getJobTitle() /*String jobTitle*/,
                user.getGroupIds(),
                user.getOrganizationIds()/*long[] organizationIds*/,
                roleIds/*long[] roleIds*/,
                null/*List<UserGroupRole> userGroupRoles*/,
                user.getGroupIds(),
                serviceContext);
		
			if(user.getAddresses().size() > 0){
				Address addr = user.getAddresses().get(0);
				setAddress(streetName, aptNo, areaCode, city, stateId, countryId, addr);
			}else{
				addAddress(streetName, aptNo, areaCode, city, stateId, countryId,
					serviceContext, user);
			}
			if(user.getPhones().size() > 0 ){
				Phone phone = PhoneLocalServiceUtil.getPhones(PortalUtil.getDefaultCompanyId(), Contact.class.getName(), user.getContactId()).get(0);
				phone.setNumber(mobileNumber);
				PhoneLocalServiceUtil.updatePhone(phone);
			}else{
				addMobile(mobileNumber, user, serviceContext);
			}	
			return user;
	}	
	
	/*
	 * This method adds flask admins
	 * 
	 * 
	 */
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public	FlaskAdmin addFlaskUser(String firstName, String middleName, String lastName, 
					String email, String screenName,String password1, String password2,  
					String DOB, boolean isMale,
					String streetName, String aptNo,
					String areaCode, String city,
					long stateId, long countryId,
					String mobileNumber, String userInterests, 
					ServiceContext serviceContext) throws SystemException, PortalException
	{
		FlaskAdmin adminUser=null;
		Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), FlaskModelUtil.FlaskRoleEnum.FLASK_USER.getRoleName());
		User user = addUser(role.getRoleId(), serviceContext.getUserId(), firstName, middleName, lastName, 
				screenName, email, password1,  password2,
				DOB, isMale,
				streetName, aptNo,
				areaCode, city,
				stateId, countryId,
				mobileNumber, userInterests, serviceContext);
		if(user != null) {
			adminUser = FlaskModelUtil.getFlaskUser(user, serviceContext);
		}
		return adminUser;
	}
	
	@Override
	public  FlaskAdmin updateLoggedInUser(String firstName, String middleName, String lastName, 
			String email, String screenName,String password1, String password2,  
			String DOB, boolean isMale,
			String streetName, String aptNo,
			String areaCode, String city,
			long stateId, long countryId,
			String mobileNumber, String userInterests,
			ServiceContext serviceContext) throws SystemException, PortalException
	{
		FlaskAdmin adminUser=null;
		Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), FlaskModelUtil.FlaskRoleEnum.FLASK_ADMIN.getRoleName());
		User user = updateUser(serviceContext.getGuestOrUserId(), role.getRoleId(), serviceContext.getUserId(),
				firstName, middleName, lastName, 
				screenName, email, password1,  password2,
				DOB, isMale,
				streetName, aptNo,
				areaCode, city,
				stateId, countryId,
				mobileNumber, userInterests, serviceContext);
		if(user != null) {
			adminUser = FlaskModelUtil.getFlaskUser(user, serviceContext);
		}
		return adminUser;
	}
	
	/*
	 * This method get details of country 
	 * 
	 * 
	 */
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public	Country getCountryByName( String name, ServiceContext serviceContext) throws SystemException, PortalException
	{ 
		return  CountryUtil.fetchByName(name);
	
	}
	/*
	 * This get list of supported countries
	 * 
	 * 
	 */
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public	List<Country> getCountries(ServiceContext serviceContext) throws SystemException, PortalException
	{ 	
		List<Country> countryList = new ArrayList<Country>();
		for (String name : FlaskModelUtil.COUNTRY_LIST){
			try{
				countryList.add(CountryUtil.fetchByName(name));
			}catch(Exception ex){
				
			}
		}
		return  countryList;
	}
	
	/*
	 * This method is accesible by guest users and returns all regions for specified country id
	 * 
	 * 
	 */
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public	List<Region> getRegion(long countryId, ServiceContext serviceContext) throws SystemException, PortalException
	{ 
		
		return RegionUtil.findByCountryId(countryId);
	}
	
	/*
	 * This method is accesible by guest users and returns all regions for specified country id
	 * 
	 * 
	 */
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public	List<Region> getUSARegions(ServiceContext serviceContext) throws SystemException, PortalException
	{ 
		Country country = CountryUtil.fetchByName("united-states");
		return RegionUtil.findByCountryId(country.getCountryId());
	}
	
}