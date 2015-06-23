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

package com.fl.uploadfile.service.persistence;

import com.fl.uploadfile.model.UploadFile;
import com.fl.uploadfile.service.UploadFileLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Rumba Solutions
 * @generated
 */
public abstract class UploadFileActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public UploadFileActionableDynamicQuery() throws SystemException {
		setBaseLocalService(UploadFileLocalServiceUtil.getService());
		setClass(UploadFile.class);

		setClassLoader(com.fl.uploadfile.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("fileUploadId");
	}
}