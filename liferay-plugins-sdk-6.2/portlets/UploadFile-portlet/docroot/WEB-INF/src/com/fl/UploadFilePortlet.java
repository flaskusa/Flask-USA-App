package com.fl;
import java.io.IOException;
import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.fl.uploadfile.service.UploadFileLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class UploadFilePortlet
 */
public class UploadFilePortlet extends MVCPortlet {


	private static Log _log = LogFactoryUtil.getLog(UploadFilePortlet.class);

	public void UploadDocument(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		try {
			_log.info("In UploadDocument process action");
			
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			String sourceFileName = uploadRequest.getFileName("fileUpload");//uploaded filename		
			String title = uploadRequest.getParameter("title");
			String description = uploadRequest.getParameter("description");

			long repositoryId = ParamUtil.getLong(uploadRequest, "repositoryId");
			long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID; //get home directory folderId
			String changeLog = "changeLog";
			InputStream inputStream = null;
			long fileSize = uploadRequest.getSize("fileUpload");
			String contentType = uploadRequest.getContentType("fileUpload");

			inputStream = uploadRequest.getFileAsStream("fileUpload");

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					DLFileEntry.class.getName(), actionRequest);


			FileEntry fileEntry = DLAppServiceUtil.addFileEntry(
					repositoryId, folderId, sourceFileName, contentType, title,
					description, changeLog, inputStream, fileSize, serviceContext); //call document library addFileEntry method to add file in home directory


			long fileEntryId = fileEntry.getFileEntryId();
			actionRequest.setAttribute("fileEntry", fileEntry);

			UploadFileLocalServiceUtil.addFile(fileEntryId, title, description, fileSize); //call custom portlet addFile method to add file details in table

		}catch (com.liferay.portal.kernel.exception.PortalException e) {

			e.printStackTrace();
		}
		catch (SystemException e) {
			_log.equals("In UploadDocument():"+e.getMessage());
		}

	}
}
