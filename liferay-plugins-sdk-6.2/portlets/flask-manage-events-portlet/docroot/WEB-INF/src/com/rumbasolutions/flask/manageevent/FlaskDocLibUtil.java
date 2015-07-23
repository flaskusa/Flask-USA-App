package com.rumbasolutions.flask.manageevent;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.ResourceAction;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ResourceActionLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.bookmarks.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
//import com.rumbasolutions.flask.service.impl.EventServiceImpl;

public class FlaskDocLibUtil {
	public static final String _eventRootFolder = "Event";
	public static final String _venueRootFolder = "Venue";	
	
	public static String APP_NAME = "guest";
	public static Role _guestRole =null;
	
	public static long _repositoryId = 0; 
	//group id is used as repository id
	public static long getFlaskRepositoryId() throws PortalException, SystemException{
		if(_repositoryId==0){
			long companyId = PortalUtil.getDefaultCompanyId();
			Group group = GroupLocalServiceUtil.getGroup(companyId, APP_NAME);
			_repositoryId = group.getGroupId();
		}
		return _repositoryId;	
	}
	
	public static Role getGuestRole(){
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
	
	public static Folder createEventRootFolder(ServiceContext serviceContext) throws PortalException, SystemException{
		long repositoryId = getFlaskRepositoryId();
		long userId = serviceContext.getUserId();
		Folder folder = getOrCreateFolder(_eventRootFolder, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, repositoryId, userId, serviceContext);
		return folder;
	}
	
	public static Folder createVenueRootFolder(ServiceContext serviceContext) throws PortalException, SystemException{
		long repositoryId = getFlaskRepositoryId();
		long userId = serviceContext.getUserId();
		Folder folder = getOrCreateFolder(_venueRootFolder, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, repositoryId, userId, serviceContext);
		return folder;
	}
	
	
	public static Folder createEventFolder(long eventId,ServiceContext serviceContext) throws PortalException, SystemException{
		Folder folder = createEventRootFolder(serviceContext);
		String eventFolderName = folder.getName()+"-"+eventId;
		Folder eventFolder = getOrCreateFolder(eventFolderName, folder.getFolderId(), folder.getRepositoryId(), folder.getUserId(), serviceContext);
		return eventFolder;
	}
	
	public static Folder createVenueFolder(long venueId,ServiceContext serviceContext) throws PortalException, SystemException{
		Folder folder = createVenueRootFolder(serviceContext);
		String venueFolderName = folder.getName()+"-"+venueId;
		Folder venueFolder = getOrCreateFolder(venueFolderName, folder.getFolderId(), folder.getRepositoryId(), folder.getUserId(), serviceContext);
		return venueFolder;
	}
	
	
	public static Folder createEventContentTypeFolder(long eventId, long infoTypeId, long infoTypeCategoryId,long venueDetailId, ServiceContext serviceContext) throws PortalException, SystemException{
		long repositoryId = getFlaskRepositoryId();
		long userId = serviceContext.getUserId();
		Folder folder = getOrCreateFolder(_eventRootFolder, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, repositoryId, userId, serviceContext);
		String eventFolderName = folder.getName()+"-"+eventId;
		Folder eventFolder = getOrCreateFolder(eventFolderName, folder.getFolderId(), folder.getRepositoryId(), userId, serviceContext);
		Folder infoTypeFolder = getOrCreateFolder(String.valueOf(infoTypeId), eventFolder.getFolderId(), eventFolder.getRepositoryId(),userId, serviceContext);
		Folder infoTypeContentFolder = getOrCreateFolder(String.valueOf(infoTypeCategoryId), infoTypeFolder.getFolderId(), infoTypeFolder.getRepositoryId(),userId, serviceContext);
		Folder eventDetailFolder = getOrCreateFolder(String.valueOf(venueDetailId), infoTypeContentFolder.getFolderId(), infoTypeContentFolder.getRepositoryId(),userId, serviceContext);
		return eventDetailFolder;
	}
	
	public static Folder createVenueContentTypeFolder(long venueId, long infoTypeId, long infoTypeCategoryId,long venueDetailId, ServiceContext serviceContext) throws PortalException, SystemException{
		long repositoryId = getFlaskRepositoryId();
		long userId = serviceContext.getUserId();
		Folder folder = getOrCreateFolder(_venueRootFolder, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, repositoryId, userId, serviceContext);
		String venueFolderName = folder.getName()+"-"+venueId;
		Folder venueFolder = getOrCreateFolder(venueFolderName, folder.getFolderId(), folder.getRepositoryId(), userId, serviceContext);
		Folder infoTypeFolder = getOrCreateFolder(String.valueOf(infoTypeId), venueFolder.getFolderId(), venueFolder.getRepositoryId(),userId, serviceContext);
		Folder infoTypeContentFolder = getOrCreateFolder(String.valueOf(infoTypeCategoryId), infoTypeFolder.getFolderId(), infoTypeFolder.getRepositoryId(),userId, serviceContext);
		Folder venueDetailFolder = getOrCreateFolder(String.valueOf(venueDetailId), infoTypeContentFolder.getFolderId(), infoTypeContentFolder.getRepositoryId(),userId, serviceContext);
		return venueDetailFolder;
	}	
	
	public static Folder getEventRootFolder(ServiceContext serviceContext) throws PortalException, SystemException{
		Folder folder=null;
		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		long repositoryId = getFlaskRepositoryId();
		try {
		  folder = DLAppLocalServiceUtil.getFolder( repositoryId, parentFolderId, _eventRootFolder);
		} catch (final NoSuchFolderException e) {
		  folder = DLAppLocalServiceUtil.addFolder(serviceContext.getUserId(),repositoryId, parentFolderId, _eventRootFolder,
				  _eventRootFolder, serviceContext);
		}
		return folder;
	}

	public static Folder getVenueRootFolder(ServiceContext serviceContext) throws PortalException, SystemException{
		Folder folder=null;
		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		long repositoryId = getFlaskRepositoryId();
		try {
		  folder = DLAppLocalServiceUtil.getFolder( repositoryId, parentFolderId, _venueRootFolder);
		} catch (final NoSuchFolderException e) {
		  folder = DLAppLocalServiceUtil.addFolder(serviceContext.getUserId(),repositoryId, parentFolderId, _venueRootFolder,
				  _venueRootFolder, serviceContext);
		}
		return folder;
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
 * 	
 * @param folder
 * @param sourcefileName
 * @param title
 * @param desc
 * @param file
 * @param mimeType
 * @param serviceContext
 * @return
 * @throws PortalException
 * @throws SystemException
 */
	public static FileEntry addFileEntry(Folder folder, String sourcefileName,
										 String title, String desc, File file,  
										 String mimeType,  ServiceContext serviceContext) 
														 throws PortalException, SystemException{
		FileEntry fileEntry=null;	
		try{	
			fileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), folder.getRepositoryId(), 
												folder.getFolderId(), sourcefileName, mimeType, 
												title, desc, 
												"", file, 
												serviceContext);
			setGuestViewPermission(fileEntry);
			}catch(Exception ex){
			
			}
		return fileEntry;
	}
	
	public static void setGuestViewPermission( FileEntry fileEntry) throws PortalException, SystemException{
		ResourcePermission resourcePermission = null;
		Role guestRole = getGuestRole();
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
	public static void setGuestViewFolderPermission( Folder dlFolder) throws PortalException, SystemException{
		ResourcePermission resourcePermission = null;
		Role guestRole = getGuestRole();
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
	
	public static String updateEventLogoPath(String FilePath){
		String filePath="";
		try {
			//EventServiceImpl t = new EventServiceImpl();
			//t.updateEvent(eventId, eventName, description, eventDate, startTime, endTime, eventTypeId, venueId, eventImagePath, serviceContext);
			return filePath; 
		}
		catch (Exception e) {
			//e.printStackTrace();
		}
		return filePath;
	}
	
}
