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

package com.rumbasolutions.flask.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.rumbasolutions.flask.model.TailgateInfo;
import com.rumbasolutions.flask.service.TailgateInfoLocalService;
import com.rumbasolutions.flask.service.persistence.TailgateImagesPersistence;
import com.rumbasolutions.flask.service.persistence.TailgateInfoFinder;
import com.rumbasolutions.flask.service.persistence.TailgateInfoPersistence;
import com.rumbasolutions.flask.service.persistence.TailgateMarkerFinder;
import com.rumbasolutions.flask.service.persistence.TailgateMarkerPersistence;
import com.rumbasolutions.flask.service.persistence.TailgateUsersFinder;
import com.rumbasolutions.flask.service.persistence.TailgateUsersPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the tailgate info local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rumbasolutions.flask.service.impl.TailgateInfoLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.impl.TailgateInfoLocalServiceImpl
 * @see com.rumbasolutions.flask.service.TailgateInfoLocalServiceUtil
 * @generated
 */
public abstract class TailgateInfoLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements TailgateInfoLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rumbasolutions.flask.service.TailgateInfoLocalServiceUtil} to access the tailgate info local service.
	 */

	/**
	 * Adds the tailgate info to the database. Also notifies the appropriate model listeners.
	 *
	 * @param tailgateInfo the tailgate info
	 * @return the tailgate info that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TailgateInfo addTailgateInfo(TailgateInfo tailgateInfo)
		throws SystemException {
		tailgateInfo.setNew(true);

		return tailgateInfoPersistence.update(tailgateInfo);
	}

	/**
	 * Creates a new tailgate info with the primary key. Does not add the tailgate info to the database.
	 *
	 * @param tailgateId the primary key for the new tailgate info
	 * @return the new tailgate info
	 */
	@Override
	public TailgateInfo createTailgateInfo(long tailgateId) {
		return tailgateInfoPersistence.create(tailgateId);
	}

	/**
	 * Deletes the tailgate info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tailgateId the primary key of the tailgate info
	 * @return the tailgate info that was removed
	 * @throws PortalException if a tailgate info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TailgateInfo deleteTailgateInfo(long tailgateId)
		throws PortalException, SystemException {
		return tailgateInfoPersistence.remove(tailgateId);
	}

	/**
	 * Deletes the tailgate info from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tailgateInfo the tailgate info
	 * @return the tailgate info that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TailgateInfo deleteTailgateInfo(TailgateInfo tailgateInfo)
		throws SystemException {
		return tailgateInfoPersistence.remove(tailgateInfo);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(TailgateInfo.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return tailgateInfoPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return tailgateInfoPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return tailgateInfoPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return tailgateInfoPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return tailgateInfoPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public TailgateInfo fetchTailgateInfo(long tailgateId)
		throws SystemException {
		return tailgateInfoPersistence.fetchByPrimaryKey(tailgateId);
	}

	/**
	 * Returns the tailgate info with the primary key.
	 *
	 * @param tailgateId the primary key of the tailgate info
	 * @return the tailgate info
	 * @throws PortalException if a tailgate info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TailgateInfo getTailgateInfo(long tailgateId)
		throws PortalException, SystemException {
		return tailgateInfoPersistence.findByPrimaryKey(tailgateId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return tailgateInfoPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the tailgate infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.TailgateInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tailgate infos
	 * @param end the upper bound of the range of tailgate infos (not inclusive)
	 * @return the range of tailgate infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TailgateInfo> getTailgateInfos(int start, int end)
		throws SystemException {
		return tailgateInfoPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of tailgate infos.
	 *
	 * @return the number of tailgate infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getTailgateInfosCount() throws SystemException {
		return tailgateInfoPersistence.countAll();
	}

	/**
	 * Updates the tailgate info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param tailgateInfo the tailgate info
	 * @return the tailgate info that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TailgateInfo updateTailgateInfo(TailgateInfo tailgateInfo)
		throws SystemException {
		return tailgateInfoPersistence.update(tailgateInfo);
	}

	/**
	 * Returns the tailgate images local service.
	 *
	 * @return the tailgate images local service
	 */
	public com.rumbasolutions.flask.service.TailgateImagesLocalService getTailgateImagesLocalService() {
		return tailgateImagesLocalService;
	}

	/**
	 * Sets the tailgate images local service.
	 *
	 * @param tailgateImagesLocalService the tailgate images local service
	 */
	public void setTailgateImagesLocalService(
		com.rumbasolutions.flask.service.TailgateImagesLocalService tailgateImagesLocalService) {
		this.tailgateImagesLocalService = tailgateImagesLocalService;
	}

	/**
	 * Returns the tailgate images remote service.
	 *
	 * @return the tailgate images remote service
	 */
	public com.rumbasolutions.flask.service.TailgateImagesService getTailgateImagesService() {
		return tailgateImagesService;
	}

	/**
	 * Sets the tailgate images remote service.
	 *
	 * @param tailgateImagesService the tailgate images remote service
	 */
	public void setTailgateImagesService(
		com.rumbasolutions.flask.service.TailgateImagesService tailgateImagesService) {
		this.tailgateImagesService = tailgateImagesService;
	}

	/**
	 * Returns the tailgate images persistence.
	 *
	 * @return the tailgate images persistence
	 */
	public TailgateImagesPersistence getTailgateImagesPersistence() {
		return tailgateImagesPersistence;
	}

	/**
	 * Sets the tailgate images persistence.
	 *
	 * @param tailgateImagesPersistence the tailgate images persistence
	 */
	public void setTailgateImagesPersistence(
		TailgateImagesPersistence tailgateImagesPersistence) {
		this.tailgateImagesPersistence = tailgateImagesPersistence;
	}

	/**
	 * Returns the tailgate info local service.
	 *
	 * @return the tailgate info local service
	 */
	public com.rumbasolutions.flask.service.TailgateInfoLocalService getTailgateInfoLocalService() {
		return tailgateInfoLocalService;
	}

	/**
	 * Sets the tailgate info local service.
	 *
	 * @param tailgateInfoLocalService the tailgate info local service
	 */
	public void setTailgateInfoLocalService(
		com.rumbasolutions.flask.service.TailgateInfoLocalService tailgateInfoLocalService) {
		this.tailgateInfoLocalService = tailgateInfoLocalService;
	}

	/**
	 * Returns the tailgate info remote service.
	 *
	 * @return the tailgate info remote service
	 */
	public com.rumbasolutions.flask.service.TailgateInfoService getTailgateInfoService() {
		return tailgateInfoService;
	}

	/**
	 * Sets the tailgate info remote service.
	 *
	 * @param tailgateInfoService the tailgate info remote service
	 */
	public void setTailgateInfoService(
		com.rumbasolutions.flask.service.TailgateInfoService tailgateInfoService) {
		this.tailgateInfoService = tailgateInfoService;
	}

	/**
	 * Returns the tailgate info persistence.
	 *
	 * @return the tailgate info persistence
	 */
	public TailgateInfoPersistence getTailgateInfoPersistence() {
		return tailgateInfoPersistence;
	}

	/**
	 * Sets the tailgate info persistence.
	 *
	 * @param tailgateInfoPersistence the tailgate info persistence
	 */
	public void setTailgateInfoPersistence(
		TailgateInfoPersistence tailgateInfoPersistence) {
		this.tailgateInfoPersistence = tailgateInfoPersistence;
	}

	/**
	 * Returns the tailgate info finder.
	 *
	 * @return the tailgate info finder
	 */
	public TailgateInfoFinder getTailgateInfoFinder() {
		return tailgateInfoFinder;
	}

	/**
	 * Sets the tailgate info finder.
	 *
	 * @param tailgateInfoFinder the tailgate info finder
	 */
	public void setTailgateInfoFinder(TailgateInfoFinder tailgateInfoFinder) {
		this.tailgateInfoFinder = tailgateInfoFinder;
	}

	/**
	 * Returns the tailgate marker local service.
	 *
	 * @return the tailgate marker local service
	 */
	public com.rumbasolutions.flask.service.TailgateMarkerLocalService getTailgateMarkerLocalService() {
		return tailgateMarkerLocalService;
	}

	/**
	 * Sets the tailgate marker local service.
	 *
	 * @param tailgateMarkerLocalService the tailgate marker local service
	 */
	public void setTailgateMarkerLocalService(
		com.rumbasolutions.flask.service.TailgateMarkerLocalService tailgateMarkerLocalService) {
		this.tailgateMarkerLocalService = tailgateMarkerLocalService;
	}

	/**
	 * Returns the tailgate marker remote service.
	 *
	 * @return the tailgate marker remote service
	 */
	public com.rumbasolutions.flask.service.TailgateMarkerService getTailgateMarkerService() {
		return tailgateMarkerService;
	}

	/**
	 * Sets the tailgate marker remote service.
	 *
	 * @param tailgateMarkerService the tailgate marker remote service
	 */
	public void setTailgateMarkerService(
		com.rumbasolutions.flask.service.TailgateMarkerService tailgateMarkerService) {
		this.tailgateMarkerService = tailgateMarkerService;
	}

	/**
	 * Returns the tailgate marker persistence.
	 *
	 * @return the tailgate marker persistence
	 */
	public TailgateMarkerPersistence getTailgateMarkerPersistence() {
		return tailgateMarkerPersistence;
	}

	/**
	 * Sets the tailgate marker persistence.
	 *
	 * @param tailgateMarkerPersistence the tailgate marker persistence
	 */
	public void setTailgateMarkerPersistence(
		TailgateMarkerPersistence tailgateMarkerPersistence) {
		this.tailgateMarkerPersistence = tailgateMarkerPersistence;
	}

	/**
	 * Returns the tailgate marker finder.
	 *
	 * @return the tailgate marker finder
	 */
	public TailgateMarkerFinder getTailgateMarkerFinder() {
		return tailgateMarkerFinder;
	}

	/**
	 * Sets the tailgate marker finder.
	 *
	 * @param tailgateMarkerFinder the tailgate marker finder
	 */
	public void setTailgateMarkerFinder(
		TailgateMarkerFinder tailgateMarkerFinder) {
		this.tailgateMarkerFinder = tailgateMarkerFinder;
	}

	/**
	 * Returns the tailgate users local service.
	 *
	 * @return the tailgate users local service
	 */
	public com.rumbasolutions.flask.service.TailgateUsersLocalService getTailgateUsersLocalService() {
		return tailgateUsersLocalService;
	}

	/**
	 * Sets the tailgate users local service.
	 *
	 * @param tailgateUsersLocalService the tailgate users local service
	 */
	public void setTailgateUsersLocalService(
		com.rumbasolutions.flask.service.TailgateUsersLocalService tailgateUsersLocalService) {
		this.tailgateUsersLocalService = tailgateUsersLocalService;
	}

	/**
	 * Returns the tailgate users remote service.
	 *
	 * @return the tailgate users remote service
	 */
	public com.rumbasolutions.flask.service.TailgateUsersService getTailgateUsersService() {
		return tailgateUsersService;
	}

	/**
	 * Sets the tailgate users remote service.
	 *
	 * @param tailgateUsersService the tailgate users remote service
	 */
	public void setTailgateUsersService(
		com.rumbasolutions.flask.service.TailgateUsersService tailgateUsersService) {
		this.tailgateUsersService = tailgateUsersService;
	}

	/**
	 * Returns the tailgate users persistence.
	 *
	 * @return the tailgate users persistence
	 */
	public TailgateUsersPersistence getTailgateUsersPersistence() {
		return tailgateUsersPersistence;
	}

	/**
	 * Sets the tailgate users persistence.
	 *
	 * @param tailgateUsersPersistence the tailgate users persistence
	 */
	public void setTailgateUsersPersistence(
		TailgateUsersPersistence tailgateUsersPersistence) {
		this.tailgateUsersPersistence = tailgateUsersPersistence;
	}

	/**
	 * Returns the tailgate users finder.
	 *
	 * @return the tailgate users finder
	 */
	public TailgateUsersFinder getTailgateUsersFinder() {
		return tailgateUsersFinder;
	}

	/**
	 * Sets the tailgate users finder.
	 *
	 * @param tailgateUsersFinder the tailgate users finder
	 */
	public void setTailgateUsersFinder(TailgateUsersFinder tailgateUsersFinder) {
		this.tailgateUsersFinder = tailgateUsersFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.rumbasolutions.flask.model.TailgateInfo",
			tailgateInfoLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.rumbasolutions.flask.model.TailgateInfo");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return TailgateInfo.class;
	}

	protected String getModelClassName() {
		return TailgateInfo.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = tailgateInfoPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rumbasolutions.flask.service.TailgateImagesLocalService.class)
	protected com.rumbasolutions.flask.service.TailgateImagesLocalService tailgateImagesLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateImagesService.class)
	protected com.rumbasolutions.flask.service.TailgateImagesService tailgateImagesService;
	@BeanReference(type = TailgateImagesPersistence.class)
	protected TailgateImagesPersistence tailgateImagesPersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateInfoLocalService.class)
	protected com.rumbasolutions.flask.service.TailgateInfoLocalService tailgateInfoLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateInfoService.class)
	protected com.rumbasolutions.flask.service.TailgateInfoService tailgateInfoService;
	@BeanReference(type = TailgateInfoPersistence.class)
	protected TailgateInfoPersistence tailgateInfoPersistence;
	@BeanReference(type = TailgateInfoFinder.class)
	protected TailgateInfoFinder tailgateInfoFinder;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateMarkerLocalService.class)
	protected com.rumbasolutions.flask.service.TailgateMarkerLocalService tailgateMarkerLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateMarkerService.class)
	protected com.rumbasolutions.flask.service.TailgateMarkerService tailgateMarkerService;
	@BeanReference(type = TailgateMarkerPersistence.class)
	protected TailgateMarkerPersistence tailgateMarkerPersistence;
	@BeanReference(type = TailgateMarkerFinder.class)
	protected TailgateMarkerFinder tailgateMarkerFinder;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateUsersLocalService.class)
	protected com.rumbasolutions.flask.service.TailgateUsersLocalService tailgateUsersLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.TailgateUsersService.class)
	protected com.rumbasolutions.flask.service.TailgateUsersService tailgateUsersService;
	@BeanReference(type = TailgateUsersPersistence.class)
	protected TailgateUsersPersistence tailgateUsersPersistence;
	@BeanReference(type = TailgateUsersFinder.class)
	protected TailgateUsersFinder tailgateUsersFinder;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private TailgateInfoLocalServiceClpInvoker _clpInvoker = new TailgateInfoLocalServiceClpInvoker();
}