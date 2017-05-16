package com.rumbasolutions.flask.managecampaign;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
import com.rumbasolutions.flask.model.AdCampaign;
import com.rumbasolutions.flask.service.AdCampaignLocalServiceUtil;
import com.rumbasolutions.flask.service.AdCampaignServiceUtil;

public class ManageCampaignPortletAction extends MVCPortlet {
	
	
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
	
	private static Log LOGGER = LogFactoryUtil.getLog(ManageCampaignPortletAction.class);
	
	private final String CAMPAIGN_ID_QSTR = "_campaignId";
	private final String CAMPAIGN_ID_FS_QSTR = "_campaignFullScreenId";
	
	private  boolean bIsFullScreen = false;
	
	private long _campaignId = 0;
	
	private ServiceContext _serviceContext;
	Folder _campaignFolder = null;
	Folder _campaignFullScreen = null;
	
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
			_campaignId = getCampaignId(formItems);
			createUploadFolder(uploadPath);
			
			for(FileItem item: formItems){
				if (!item.isFormField()) {
					String fileName = "_" + new File(item.getName()).getName();
					String fileTitle = fileName;
					String fileDesc = fileName; // Change is later for description 
					String filePath = uploadPath + File.separator + fileName;
					File storeFile = new File(filePath);
					// saves the file on disk
					item.write(storeFile);
					String mimeType = FlaskDocLibUtil.getMimeType(filePath);
					FileEntry fileEntry;
					if(!bIsFullScreen){
						fileEntry = FlaskDocLibUtil.addFileEntry(_campaignFolder, fileName, fileTitle, fileDesc, storeFile, mimeType, _serviceContext);
						AdCampaignServiceUtil.addCampaignImage(_campaignId,fileTitle, fileDesc, fileEntry.getUuid(), fileEntry.getGroupId(), _serviceContext);
					}else{
						fileEntry = FlaskDocLibUtil.addFileEntry(_campaignFullScreen, fileName, fileTitle, fileDesc, storeFile, mimeType, _serviceContext);
						AdCampaign adCampaign = AdCampaignServiceUtil.getCampaign(_campaignId);
						adCampaign.setImageTitle(fileTitle);
						adCampaign.setImageDesc(fileDesc);
						adCampaign.setImageGroupId(fileEntry.getGroupId());
						adCampaign.setImageUUID(fileEntry.getUuid());
						AdCampaignLocalServiceUtil.updateAdCampaign(adCampaign);
					}					
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
			_campaignFolder = FlaskDocLibUtil.createCampaignFolder(_campaignId, _serviceContext);
			_campaignFullScreen =	FlaskDocLibUtil.createCampaignFullScreenImageFolder(_campaignId, _serviceContext);
			
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
	
	private long getCampaignId(List<FileItem> formItems){
		long campaingId = 0;
		for (FileItem item : formItems){
			if(item.getFieldName().contentEquals(CAMPAIGN_ID_QSTR)){
				campaingId = Long.parseLong(item.getString());
				bIsFullScreen = false;
				break;
			}
			if(item.getFieldName().contentEquals(CAMPAIGN_ID_FS_QSTR)){
				campaingId = Long.parseLong(item.getString());
				bIsFullScreen = true;
				break;
			}
			
		}
		return campaingId;
	}
}
