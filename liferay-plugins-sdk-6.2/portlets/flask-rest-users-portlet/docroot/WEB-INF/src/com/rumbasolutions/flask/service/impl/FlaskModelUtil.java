package com.rumbasolutions.flask.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.ListType;
import com.liferay.portal.model.ListTypeConstants;
import com.liferay.portal.model.Phone;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.ResourceAction;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.PhoneLocalServiceUtil;
import com.liferay.portal.service.ResourceActionLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.service.persistence.ListTypeUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.persistence.ExpandoValueUtil;
import com.rumbasolutions.flask.model.FlaskAdmin;
import com.rumbasolutions.flask.model.FlaskRole;
import com.rumbasolutions.flask.model.impl.FlaskAdminImpl;
import com.rumbasolutions.flask.model.impl.FlaskRoleImpl;

public class FlaskModelUtil {

	public static final String FLASK_ADMIN =  "Flask Admin";
	public static final String LIFERAY_ADMIN=  "Administrator";
	public static final String FLASK_CONTENT_ADMIN=  "Flask Content Manager";
	public static final String FLASK_USER=  "User";
	public static final String All_USERS=  "all";
	public static final int MAX_USER_LIMIT=  1000;
	public static final String[] COUNTRY_LIST=  {"united-states","canada"};
	
	public static Role _guestRole =null;
	public static final String USA_COUNTRY_NAME= "United States";
	public static final String MOBILE_PHONE_TYPE= "mobile";
	public static final String PERSONAL_ADDR_TYPE = "personal";
	public static final String EXPANDO_COL_USER_INTERESTS = "userinterests";
	
	public static final String SEPERATOR=",";
	
	private static ArrayList<FlaskRole> flaskRoles = new ArrayList<FlaskRole>();
	private static String defaultRoleIdList="";  //Flask admin/ Flask Content Managers
	
	
	private static Log LOGGER = LogFactoryUtil.getLog(FlaskModelUtil.class);
	
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
	
	public static long repositoryId = 0;
	public static long getFlaskRepositoryId() throws PortalException, SystemException{
		if(repositoryId==0){
			long companyId = PortalUtil.getDefaultCompanyId();
			Group group = GroupLocalServiceUtil.getGroup(companyId, "guest");
			repositoryId = group.getGroupId();
		}
		return repositoryId;	
	}
	
	public static Folder getOrCreateFolder(String eventFolderName, long parentFolderId, long repositoryId, long userId, ServiceContext serviceContext) throws PortalException, SystemException{
		Folder folder= null;
		if(parentFolderId == 0){
			  parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		  }
		  try {
			  folder = DLAppLocalServiceUtil.getFolder(
		            repositoryId, parentFolderId, eventFolderName);
		  } catch (Exception e) {
			  folder = DLAppLocalServiceUtil.addFolder(userId,
		            repositoryId, parentFolderId, eventFolderName,
		            eventFolderName, serviceContext);
			  setGuestViewFolderPermission(folder);
		    }
		return folder;
	}

	
	/**
	 * Get flask user specific information from liferay User 
	 * getFlaskAdmin
	 * @param user
	 * @param serviceContext
	 * @return
	 */
	public static FlaskAdmin getFlaskUser(User user, boolean bSetRole, ServiceContext serviceContext) {
		
		FlaskAdmin admin = new FlaskAdminImpl(); 
		
		try {
			admin.setUserId(user.getUserId()); 
			admin.setFirstName(user.getFirstName()); 
			admin.setLastName(user.getLastName());
			admin.setMiddleName(user.getMiddleName());
			admin.setEmail(user.getEmailAddress());
			admin.setScreenName(user.getScreenName());
			admin.setDOB(user.getBirthday());
			if(bSetRole){
				FlaskRole role = getFlaskUser(user);
				admin.setRoleId(role.getRoleId());
				admin.setRoleName(role.getRoleName());
			}
			Contact userContact = user.getContact();
			String phoneNo = getPhoneNumber(user);
			admin.setMobileNumber(phoneNo);
			setAddress(user, admin, userContact);
			admin.setPortraitURL(String.valueOf(user.getPortraitId()));
			admin.setUserInterests(getUserInterest(user));
			admin.setIsMale(user.isMale());
		} catch (Exception e) {
			LOGGER.error("Exception in getFlaskAdmin " + e.getMessage());
			e.printStackTrace();
		} 
		return admin;
	}

	private static String getUserInterest(User user) {
		String interest="";
		Object[] cols={"valueId"};
		
		
		long classNameId = ClassNameLocalServiceUtil.getClassNameId(User.class.getName());
		ExpandoValue val;
		try {
			val = ExpandoValueUtil.fetchByC_C_Last(classNameId,
							user.getUserId(), null );
			if(val != null){
				interest = val.getData();
			}
		}
		catch (SystemException e) {
			LOGGER.error("Exception in getUserInterest " + e.getMessage());
		}
		
		return interest;
	}

	private static FlaskRole getFlaskUser(User user)
		throws SystemException {
		long roleId=0;
		FlaskRole role = getFlaskRoleByName(FLASK_ADMIN);
		if( isRoleInList(user, role)){
			return role;
		}
		role = getFlaskRoleByName(FLASK_CONTENT_ADMIN);
		if( isRoleInList(user, role)){
			return role;
		}
		return getFlaskRoleByName(FLASK_USER);
	}

	private static boolean isRoleInList(User user,FlaskRole role) throws SystemException{
		for(long roleId : user.getRoleIds()){
			if (role.getRoleId() == roleId){
				return true;
			}
		}
		return false;
	}
	
	private static void setAddress(User user, FlaskAdmin admin, Contact userContact)
		throws SystemException {

		try {
			List<Address> addrList = AddressLocalServiceUtil.getAddresses(user.getCompanyId(),
					Contact.class.getName(),
					userContact.getContactId()) ;
			if( addrList.size() > 0){
				Address addr = addrList.get(0);
				
				admin.setAptNo(addr.getStreet1());
				admin.setStreetName(addr.getStreet2());
				admin.setCity(addr.getCity());
				admin.setAreaCode(addr.getZip());			
				
				Region region = addr.getRegion();
				if(region != null){
					admin.setStateId(region.getRegionId());
					admin.setStateName(region.getName());
				}
				Country  country = addr.getCountry();
				if(country != null){
					admin.setCountryId(country.getCountryId());
					admin.setCountryName(country.getNameCurrentValue());
				}

			}
		}
		catch (Exception e) {
			LOGGER.error("Exception in setAddress " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static String getPhoneNumber(User user){
		String phoneNo="";
		try {
			 List<Phone> phoneList = PhoneLocalServiceUtil.getPhones(user.getCompanyId(), Contact.class.getName(),
				     user.getContact().getContactId());
			if(phoneList.size() > 0){
				phoneNo = phoneList.get(0).getNumber();
			}
		} catch (Exception e) {
			LOGGER.error("getPhoneNumber:" + e.getMessage());
		}
		return phoneNo;
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
	
	public static int getPersonalAddressId(){
		int id=0;
		 try {
			List<ListType> addressTypes = ListTypeUtil.findByType(Contact.class.getName()+ ListTypeConstants.ADDRESS); 
				
			for(ListType lt : addressTypes){
				if(lt.getName().toLowerCase().contains(PERSONAL_ADDR_TYPE)){
					id  = lt.getListTypeId();
					break;
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error in getPersonalAddressId" + e.getMessage());
		}
		return id;	
	}
	
	public static int getMobilePhoneTypeId(){
		int id=0;
		 try {
			 
			List<ListType> phoneTypes = ListTypeUtil.findByType(Contact.class.getName()
			    	        + ListTypeConstants.PHONE);
	
			for(ListType lt : phoneTypes){
				if(lt.getName().toLowerCase().contains(MOBILE_PHONE_TYPE)){
					id  = lt.getListTypeId();
					break;
				}
			}
		} catch (Exception e) {
			LOGGER.error("Error in getMobilePhoneTypeId:" + e.getMessage());
		}
		return id;	
	}
	public static Calendar parseDate(String DOB){
		Calendar cal = Calendar.getInstance();
		Date dt =null;
		String[] validFormats = {"MM-dd-yyyy", "yyyy-MM-dd", "MM/dd/yyyy" };
		for(String format : validFormats ){
				SimpleDateFormat sf  =new SimpleDateFormat(format, Locale.US);
				try {
					dt= sf.parse(DOB);
					cal.setTime(dt);				
					return cal;
				}catch (Exception e) {
					
				}
		}	
		return cal;
	}
	public static List<FlaskRole> getFlaskRoles(){
		if(flaskRoles.size() > 0){
			return flaskRoles;
		}
			
		try{
			for (FlaskRoleEnum eRole : FlaskRoleEnum.values()){
				Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(),eRole.getRoleName());
				if(role != null){
					flaskRoles.add(FlaskModelUtil.getFlaskRole(role));
				}

			}
		}catch(Exception ex){
			LOGGER.error("Exception in getFlaskAdmin " + ex.getMessage());
		}
		return flaskRoles;		
	}
	
	public static List<Long> getFlaskRoleIdList(){
		List<Long> adminList = new ArrayList<Long>();
		for(FlaskRole fr: getFlaskRoles()){
			adminList.add(fr.getRoleId());
		}
		return adminList;
	}
	
	public static List<Long> getFlaskAdminRoleIds(){
		List<Long> adminList = new ArrayList<Long>();
		for(FlaskRole fr: getFlaskRoles()){
			if(!fr.getRoleName().contentEquals(FLASK_USER)){
				adminList.add(fr.getRoleId());
			}
		}
		return adminList;
	}
	

	public static FlaskRole getFlaskRoleByName(String roleName){
		
		List<FlaskRole> roleList = getFlaskRoles();
		for (FlaskRole role: roleList){
			if(role.getRoleName().contentEquals(roleName)){
				return role;
			}
		}
		return null;
	}
	
/****************************************upload logic************************/
	
	

	public static void setMyGuestViewPermission( FileEntry fileEntry) throws PortalException, SystemException{
		ResourcePermission resourcePermission = null;
		Role guestRole = getMyGuestRole();
		try
		   {
			
		    resourcePermission = ResourcePermissionLocalServiceUtil.getResourcePermission(fileEntry.getCompanyId(),
		    					DLFileEntry.class.getName(),
		    					ResourceConstants.SCOPE_INDIVIDUAL, 
		    					String.valueOf(fileEntry.getPrimaryKey()),
		    					guestRole.getRoleId());
		        
		    ResourceAction resourceAction = ResourceActionLocalServiceUtil.getResourceAction(DLFileEntry.class.getName(), ActionKeys.VIEW);
		  
		    if(Validator.isNotNull(resourcePermission) && !ResourcePermissionLocalServiceUtil.hasActionId(resourcePermission,resourceAction))
		    {
		      resourcePermission.setActionIds(resourcePermission.getActionIds() + resourceAction.getBitwiseValue());
		      ResourcePermissionLocalServiceUtil.updateResourcePermission(resourcePermission);
		    }
		   }catch(Exception ex){
			      resourcePermission = ResourcePermissionLocalServiceUtil.createResourcePermission(CounterLocalServiceUtil.increment());
			      resourcePermission.setCompanyId(fileEntry.getCompanyId());
			      resourcePermission.setName(DLFileEntry.class.getName());
			      resourcePermission.setScope(ResourceConstants.SCOPE_INDIVIDUAL);
			      resourcePermission.setPrimKey(String.valueOf(fileEntry.getPrimaryKey()));
			      resourcePermission.setRoleId(guestRole.getRoleId());
			    
			      ResourceAction resourceAction = ResourceActionLocalServiceUtil.getResourceAction(DLFileEntry.class.getName(), ActionKeys.VIEW);
			      resourcePermission.setActionIds(resourceAction.getBitwiseValue());// (ActionKeys.VIEW);
			      ResourcePermissionLocalServiceUtil.addResourcePermission(resourcePermission);
			   
		   }
	}
	
	public static Role getMyGuestRole(){
		try {
			if(_guestRole == null){
				_guestRole =RoleServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), RoleConstants.GUEST);
			}
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return _guestRole;
	}
	
	public static void setGuestViewFolderPermission( Folder dlFolder) throws PortalException, SystemException{
		ResourcePermission resourcePermission = null;
		Role guestRole = getMyGuestRole();
		try
		   {

		    resourcePermission = ResourcePermissionLocalServiceUtil.getResourcePermission(dlFolder.getCompanyId(),
		    					DLFolder.class.getName(),
		    					ResourceConstants.SCOPE_INDIVIDUAL, 
		    					String.valueOf(dlFolder.getPrimaryKey()),
		    					guestRole.getRoleId());
		        
		    ResourceAction resourceAction = ResourceActionLocalServiceUtil.getResourceAction(DLFolder.class.getName(), ActionKeys.VIEW);
		  
		    if(Validator.isNotNull(resourcePermission) && !ResourcePermissionLocalServiceUtil.hasActionId(resourcePermission,resourceAction))
		    {
		      resourcePermission.setActionIds(resourcePermission.getActionIds() + resourceAction.getBitwiseValue());
		      ResourcePermissionLocalServiceUtil.updateResourcePermission(resourcePermission);
		    }
		   }catch(Exception ex){
			      resourcePermission = ResourcePermissionLocalServiceUtil.createResourcePermission(CounterLocalServiceUtil.increment());
			      resourcePermission.setCompanyId(dlFolder.getCompanyId());
			      resourcePermission.setName(DLFolder.class.getName());
			      resourcePermission.setScope(ResourceConstants.SCOPE_INDIVIDUAL);
			      resourcePermission.setPrimKey(String.valueOf(dlFolder.getPrimaryKey()));
			      resourcePermission.setRoleId(guestRole.getRoleId());
			    
			      ResourceAction resourceAction = ResourceActionLocalServiceUtil.getResourceAction(DLFolder.class.getName(), ActionKeys.VIEW);
			      resourcePermission.setActionIds(resourceAction.getBitwiseValue());// (ActionKeys.VIEW);
			      ResourcePermissionLocalServiceUtil.addResourcePermission(resourcePermission);
			   
		   }
	}
	/**
	 * 
	 * @param fullFileName
	 * @return
	 */
	
	public static String getMimeType(String fullFileName){
		Path source = Paths.get(fullFileName);
		String mimeType="";
		try {
			mimeType = Files.probeContentType(source);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return mimeType;
	}
}