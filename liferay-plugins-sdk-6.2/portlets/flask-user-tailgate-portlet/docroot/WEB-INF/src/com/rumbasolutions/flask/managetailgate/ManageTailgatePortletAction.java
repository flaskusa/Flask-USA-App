package com.rumbasolutions.flask.managetailgate;

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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.rumbasolutions.flask.service.TailgateImagesServiceUtil;
//import com.rumbasolutions.flask.service.TailgateInfoLocalServiceUtil;

public class ManageTailgatePortletAction extends MVCPortlet {
	
	
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
	
	private static Log LOGGER = LogFactoryUtil.getLog(ManageTailgatePortletAction.class);
	
	private final String TAILGATE_ID_QSTR = "_tailgateId";
	private long _tailgateId = 0;
	
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
			_tailgateId = getEventId(formItems);
			createUploadFolder(uploadPath);
			
			for(FileItem item: formItems){
				if (!item.isFormField()) {
					String fileName = _tailgateId +"_" + new File(item.getName()).getName();
					String fileTitle = fileName;
					String fileDesc = fileName; // Change is later for description 
					String filePath = uploadPath + File.separator + fileName;
					File storeFile = new File(filePath);
					// saves the file on disk
					item.write(storeFile);
					String mimeType = FlaskDocLibUtil.getMimeType(filePath);
					FileEntry fileEntry = FlaskDocLibUtil.addFileEntry(_eventFolder, fileName, fileTitle, fileDesc, storeFile, mimeType, _serviceContext);
					TailgateImagesServiceUtil.addTailgateImage(_tailgateId, fileTitle, fileDesc, fileEntry.getUuid(), fileEntry.getGroupId(), _serviceContext);
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
			_eventFolder = FlaskDocLibUtil.createTailgateFolder(_tailgateId,_serviceContext);
		}
		catch (Exception e) {
			LOGGER.error("Error in creating tailgate folder in Document Media Library", e);
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
	
	private long getEventId(List<FileItem> formItems){
		long eventId = 0;
		for (FileItem item : formItems){
			if(item.getFieldName().contentEquals(TAILGATE_ID_QSTR)){
				eventId = Long.parseLong(item.getString());
				break;
			}
		}
		return eventId;
	}
}
