package com.rumbasolutions.flask.manageevent;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.portlet.PortletFileUpload;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rumbasolutions.flask.service.EventServiceUtil;

public class ManageEventPortletAction extends MVCPortlet {
	
	
	/**
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	private static final String UPLOAD_DIRECTORY = "upload";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 10; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 10; // 10MB
	private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	
	private static Log LOGGER = LogFactoryUtil.getLog(ManageEventPortletAction.class);
	
	private final String EVENT_ID_QSTR = "_eventId";
	private final String EVENT_LOGO_CAPTION = "_eventLogoCaption";
	private final String EVENT_DETAIL_ID_QSTR= "_eventDetailId";
	private final String EVENT_ISLOGO_QSTR= "_isLogo";
	private long _eventId = 0;
	private String _eventLogoCaption = "";
	
	private long _eventDetailId = 0;
	private String _isLogo = "N";
	private ServiceContext _serviceContext;
	Folder _eventFolder=null;
	
	public void addImages(ActionRequest actionRequest, ActionResponse actionResponse)throws IOException, PortletException {
		
		if (!PortletFileUpload.isMultipartContent( actionRequest)) {
			return;
		}
	
		_serviceContext = getServicContext(actionRequest);
		// configures some settings
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		PortletFileUpload upload = new PortletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(REQUEST_SIZE);
		
		// constructs the directory path to store upload file
		String uploadPath = getPortletContext().getRealPath("")
			+ File.separator + UPLOAD_DIRECTORY;
		
		try {
			// parses the request's content to extract file data
			List<FileItem> formItems = upload.parseRequest(actionRequest);
			
			_eventId = getEventId(formItems);
			_eventLogoCaption = getEventLogoCaption(formItems);
			_eventDetailId = getEventDetailId(formItems);
			_isLogo = getIsLogo(formItems);
			createUploadFolder(uploadPath);
			
			for(FileItem item: formItems){
				if (!item.isFormField()) {
					String fileName = _eventDetailId +"_" + new File(item.getName()).getName();
					String fileTitle = fileName;
					String fileDesc = fileName; // Change is later for description 
					boolean IsLogo =  _isLogo.equals("Y");
					if(IsLogo){
						fileName = new File(item.getName()).getName();
						fileTitle = _eventLogoCaption;
						fileDesc = fileTitle; 
					}
					String filePath = uploadPath + File.separator + fileName;
					File storeFile = new File(filePath);
					// saves the file on disk
					item.write(storeFile);
					String mimeType = FlaskDocLibUtil.getMimeType(filePath);
					FileEntry fileEntry = FlaskDocLibUtil.addFileEntry(_eventFolder, fileName, fileTitle, fileDesc, storeFile, mimeType, _serviceContext);
					if(IsLogo)
						FlaskDocLibUtil.updateEventLogoPath(_eventId, fileEntry.getUuid(), fileEntry.getGroupId(), _serviceContext);
					else
						EventServiceUtil.addEventDetailImage(_eventDetailId, fileTitle, fileDesc, fileEntry.getUuid(), fileEntry.getGroupId(), _serviceContext);
					
				}else{
					
				}
			}
			actionRequest.setAttribute("message", "Upload has been done successfully!");
		} catch (Exception ex) {
			actionRequest.setAttribute("message", "There was an error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private void createUploadFolder(String uploadPath)  {

		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		try {
			boolean IsLogo =  _isLogo.equals("Y");
			if(IsLogo)
				_eventFolder = FlaskDocLibUtil.createEventFolder(_eventId,_serviceContext);
			else
				_eventFolder = FlaskDocLibUtil.createEventContentTypeFolder(_eventId,_eventDetailId, _serviceContext);
		}
		catch (Exception e) {
			LOGGER.error("Error in creating venue folder in Document Media Library", e);
		}
	}

	private ServiceContext getServicContext(ActionRequest actionRequest){
		
		ServiceContext serviceContext=null;
		try {
			serviceContext = ServiceContextFactory.getInstance(actionRequest);
		}
		catch (PortalException e) {
			LOGGER.error(e);	
		}
		catch (SystemException e) {
			LOGGER.error(e);
		}
		return serviceContext;
	}

	/*private long getInfoTypeId(List<FileItem> formItems){
		long infoTypeId = 0;
		for (FileItem item : formItems){
			if(item.getFieldName().contentEquals(INFO_TYPE_ID_QSTR)){
				infoTypeId =  Long.parseLong(item.getString());
				break;
			}
		}
		return infoTypeId;
	}
	
	private long getInfoTypeContentId(List<FileItem> formItems){
		long infoTypeContId = 0;
		 
		for (FileItem item : formItems){
			if(item.getFieldName().contentEquals(INFO_TYPE_CON_ID_QSTR)){
				infoTypeContId =  Long.parseLong(item.getString());
				break;
			}
		}
		return infoTypeContId;
	}*/
	
	
	private long getEventId(List<FileItem> formItems){
		long eventId = 0;
		for (FileItem item : formItems){
			if(item.getFieldName().contentEquals(EVENT_ID_QSTR)){
				eventId = Long.parseLong(item.getString());
				break;
			}
		}
		return eventId;
	}
	
	private String getEventLogoCaption(List<FileItem> formItems){
		String eventLogoCaption = "";
		for (FileItem item : formItems){
			System.out.println("item.getFieldName(): "+item.getFieldName());
			if(item.getFieldName().contentEquals(EVENT_LOGO_CAPTION)){
				eventLogoCaption = item.getString();
				System.out.println("EVENT_LOGO_CAPTION: "+eventLogoCaption);
				break;
			}
		}
		return eventLogoCaption;
	}

	private long getEventDetailId(List<FileItem> formItems){
		long infoTypeContId = 0;
		 
		for (FileItem item : formItems){
			if(item.getFieldName().contentEquals(EVENT_DETAIL_ID_QSTR)){
				infoTypeContId =  Long.parseLong(item.getString());
				break;
			}
		}
		return infoTypeContId;
	}

	private String getIsLogo(List<FileItem> formItems){
		String isLogo = "N";
		 
		for (FileItem item : formItems){
			if(item.getFieldName().contentEquals(EVENT_ISLOGO_QSTR)){
				isLogo = item.getString();
				break;
			}
		}
		return isLogo;
	}	
}
