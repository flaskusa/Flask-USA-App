/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.fl.uploadfile.service.impl;

import java.util.Date;
import java.util.List;

import com.fl.uploadfile.model.UploadFile;
import com.fl.uploadfile.service.base.UploadFileLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the upload file local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.fl.uploadfile.service.UploadFileLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Manisha
 * @see com.fl.uploadfile.service.base.UploadFileLocalServiceBaseImpl
 * @see com.fl.uploadfile.service.UploadFileLocalServiceUtil
 */
public class UploadFileLocalServiceImpl extends UploadFileLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.fl.uploadfile.service.UploadFileLocalServiceUtil} to access the upload file local service.
	 */
	
	private static Log _log = LogFactoryUtil.getLog(UploadFileLocalServiceImpl.class);
	public UploadFile addFile(long fileEntryId ,String title ,String description,long size) throws SystemException{

		_log.info("In addFile FileUploadLocalServiceImpl");
		UploadFile fileUpload = uploadFilePersistence.create(counterLocalService.increment());
		fileUpload.setFileEntryId(fileEntryId);
		fileUpload.setTitle(title);
		fileUpload.setDescription(description);
		fileUpload.setSize(size);
		return uploadFilePersistence.update(fileUpload, false);
	}
	
	
	public List<UploadFile> getAllFiles() throws SystemException{
		_log.info("In getAllFiles FileUploadLocalServiceImpl");
		return uploadFilePersistence.findAll();

	}
}