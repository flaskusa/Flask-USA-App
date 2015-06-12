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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the upload file service. This utility wraps {@link UploadFilePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Rumba Solutions
 * @see UploadFilePersistence
 * @see UploadFilePersistenceImpl
 * @generated
 */
public class UploadFileUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UploadFile uploadFile) {
		getPersistence().clearCache(uploadFile);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UploadFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UploadFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UploadFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UploadFile update(UploadFile uploadFile)
		throws SystemException {
		return getPersistence().update(uploadFile);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UploadFile update(UploadFile uploadFile,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(uploadFile, serviceContext);
	}

	/**
	* Caches the upload file in the entity cache if it is enabled.
	*
	* @param uploadFile the upload file
	*/
	public static void cacheResult(
		com.fl.uploadfile.model.UploadFile uploadFile) {
		getPersistence().cacheResult(uploadFile);
	}

	/**
	* Caches the upload files in the entity cache if it is enabled.
	*
	* @param uploadFiles the upload files
	*/
	public static void cacheResult(
		java.util.List<com.fl.uploadfile.model.UploadFile> uploadFiles) {
		getPersistence().cacheResult(uploadFiles);
	}

	/**
	* Creates a new upload file with the primary key. Does not add the upload file to the database.
	*
	* @param fileUploadId the primary key for the new upload file
	* @return the new upload file
	*/
	public static com.fl.uploadfile.model.UploadFile create(long fileUploadId) {
		return getPersistence().create(fileUploadId);
	}

	/**
	* Removes the upload file with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileUploadId the primary key of the upload file
	* @return the upload file that was removed
	* @throws com.fl.uploadfile.NoSuchUploadFileException if a upload file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fl.uploadfile.model.UploadFile remove(long fileUploadId)
		throws com.fl.uploadfile.NoSuchUploadFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(fileUploadId);
	}

	public static com.fl.uploadfile.model.UploadFile updateImpl(
		com.fl.uploadfile.model.UploadFile uploadFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(uploadFile);
	}

	/**
	* Returns the upload file with the primary key or throws a {@link com.fl.uploadfile.NoSuchUploadFileException} if it could not be found.
	*
	* @param fileUploadId the primary key of the upload file
	* @return the upload file
	* @throws com.fl.uploadfile.NoSuchUploadFileException if a upload file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fl.uploadfile.model.UploadFile findByPrimaryKey(
		long fileUploadId)
		throws com.fl.uploadfile.NoSuchUploadFileException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(fileUploadId);
	}

	/**
	* Returns the upload file with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fileUploadId the primary key of the upload file
	* @return the upload file, or <code>null</code> if a upload file with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.fl.uploadfile.model.UploadFile fetchByPrimaryKey(
		long fileUploadId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(fileUploadId);
	}

	/**
	* Returns all the upload files.
	*
	* @return the upload files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fl.uploadfile.model.UploadFile> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the upload files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fl.uploadfile.model.impl.UploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of upload files
	* @param end the upper bound of the range of upload files (not inclusive)
	* @return the range of upload files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fl.uploadfile.model.UploadFile> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the upload files.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.fl.uploadfile.model.impl.UploadFileModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of upload files
	* @param end the upper bound of the range of upload files (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of upload files
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.fl.uploadfile.model.UploadFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the upload files from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of upload files.
	*
	* @return the number of upload files
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UploadFilePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UploadFilePersistence)PortletBeanLocatorUtil.locate(com.fl.uploadfile.service.ClpSerializer.getServletContextName(),
					UploadFilePersistence.class.getName());

			ReferenceRegistry.registerReference(UploadFileUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UploadFilePersistence persistence) {
	}

	private static UploadFilePersistence _persistence;
}