package com.rumbasolutions.flask.managevenue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.bookmarks.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;


public class FlaskDocLibUtil {

	public static final String _venueRootFolder = "Venue";
	public static final String _eventRootFolder = "Event";
	
	public static String APP_NAME = "guest";
	
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
	
	public static String getVenueFolderName(long venueId){
		return String.format("%s-%s",_venueRootFolder, String.valueOf(venueId));
	}
	
	public static String getEventFolderName(long eventId){
		return String.format("%s-%s-%s",_eventRootFolder, String.valueOf(eventId));
	}
	
	public static Folder createEventRootFolder(ServiceContext serviceContext) throws PortalException, SystemException{

		long repositoryId = getFlaskRepositoryId();
		long userId = serviceContext.getUserId();
		Folder folder = getOrCreateFolder(_eventRootFolder, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, repositoryId, userId, serviceContext);
		return folder;
	}
	
	public static  Folder createVenueRootFolder(ServiceContext serviceContext) throws PortalException, SystemException{
		
		long repositoryId = getFlaskRepositoryId();
		long userId = serviceContext.getUserId();
		Folder folder = getOrCreateFolder(_venueRootFolder, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, repositoryId, userId, serviceContext);
		return folder;
	}
	
	public static Folder createVenueFolder(long venueId, ServiceContext serviceContext) throws PortalException, SystemException{
		
		long repositoryId = getFlaskRepositoryId();
		long userId = serviceContext.getUserId();
		Folder folder = getOrCreateFolder(_venueRootFolder, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, repositoryId, userId, serviceContext);
		
		String venueFolderName = getVenueFolderName(venueId);
		Folder venueFolder = getOrCreateFolder(venueFolderName, folder.getFolderId(), folder.getRepositoryId(), userId, serviceContext);
		 
		
		return venueFolder;
	}
	
	public static Folder getVenueRootFolder(ServiceContext serviceContext) throws PortalException, SystemException{
		Folder folder=null;
		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		long repositoryId = getFlaskRepositoryId();
		try {
		  folder = DLAppLocalServiceUtil.getFolder( repositoryId, parentFolderId, _venueRootFolder);
		} catch (final NoSuchFolderException e) {
		  folder = DLAppLocalServiceUtil.addFolder(serviceContext.getUserId(),
	            repositoryId, parentFolderId, _venueRootFolder,
	            _venueRootFolder, serviceContext);
		}
		return folder;
	}
	
	public static Folder getEventRootFolder(ServiceContext serviceContext) throws PortalException, SystemException{
		Folder folder=null;
		long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		long repositoryId = getFlaskRepositoryId();
		try {
		  folder = DLAppLocalServiceUtil.getFolder( repositoryId, parentFolderId, _venueRootFolder);
		} catch (final NoSuchFolderException e) {
		  folder = DLAppLocalServiceUtil.addFolder(serviceContext.getUserId(),
	            repositoryId, parentFolderId, _eventRootFolder,
	            _eventRootFolder, serviceContext);
		}
		return folder;

	}
	
	public static Folder getEventFolderByEventId(){
		Folder folder = null;
		return folder;
	}
	
	public static Folder getVenueFolderByVenueId(){
		Folder folder=null;
		
		return folder;
	}


	
	public static Folder getOrCreateFolder(String folderName, long parentFolderId, long repositoryId, long userId, ServiceContext serviceContext) throws PortalException, SystemException{
		  
		Folder folder= null;
		 
		if(parentFolderId == 0){
			  parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			  
		  }
		  try {
			  folder = DLAppLocalServiceUtil.getFolder(
		            repositoryId, parentFolderId, folderName);
		  } catch (Exception e) {
			  folder = DLAppLocalServiceUtil.addFolder(userId,
		            repositoryId, parentFolderId, folderName,
		            folderName, serviceContext);
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
			}catch(Exception ex){
			
			}
		return fileEntry;
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
