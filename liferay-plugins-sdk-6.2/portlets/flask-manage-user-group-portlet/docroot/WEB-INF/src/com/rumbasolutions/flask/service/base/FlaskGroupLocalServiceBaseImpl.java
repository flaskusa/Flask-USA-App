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

import com.rumbasolutions.flask.model.FlaskGroup;
import com.rumbasolutions.flask.service.FlaskGroupLocalService;
import com.rumbasolutions.flask.service.persistence.FlaskGroupFinder;
import com.rumbasolutions.flask.service.persistence.FlaskGroupPersistence;
import com.rumbasolutions.flask.service.persistence.FlaskGroupUsersFinder;
import com.rumbasolutions.flask.service.persistence.FlaskGroupUsersPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the flask group local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rumbasolutions.flask.service.impl.FlaskGroupLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.impl.FlaskGroupLocalServiceImpl
 * @see com.rumbasolutions.flask.service.FlaskGroupLocalServiceUtil
 * @generated
 */
public abstract class FlaskGroupLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements FlaskGroupLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rumbasolutions.flask.service.FlaskGroupLocalServiceUtil} to access the flask group local service.
	 */

	/**
	 * Adds the flask group to the database. Also notifies the appropriate model listeners.
	 *
	 * @param flaskGroup the flask group
	 * @return the flask group that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public FlaskGroup addFlaskGroup(FlaskGroup flaskGroup)
		throws SystemException {
		flaskGroup.setNew(true);

		return flaskGroupPersistence.update(flaskGroup);
	}

	/**
	 * Creates a new flask group with the primary key. Does not add the flask group to the database.
	 *
	 * @param groupId the primary key for the new flask group
	 * @return the new flask group
	 */
	@Override
	public FlaskGroup createFlaskGroup(long groupId) {
		return flaskGroupPersistence.create(groupId);
	}

	/**
	 * Deletes the flask group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupId the primary key of the flask group
	 * @return the flask group that was removed
	 * @throws PortalException if a flask group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public FlaskGroup deleteFlaskGroup(long groupId)
		throws PortalException, SystemException {
		return flaskGroupPersistence.remove(groupId);
	}

	/**
	 * Deletes the flask group from the database. Also notifies the appropriate model listeners.
	 *
	 * @param flaskGroup the flask group
	 * @return the flask group that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public FlaskGroup deleteFlaskGroup(FlaskGroup flaskGroup)
		throws SystemException {
		return flaskGroupPersistence.remove(flaskGroup);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(FlaskGroup.class,
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
		return flaskGroupPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return flaskGroupPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return flaskGroupPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return flaskGroupPersistence.countWithDynamicQuery(dynamicQuery);
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
		return flaskGroupPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public FlaskGroup fetchFlaskGroup(long groupId) throws SystemException {
		return flaskGroupPersistence.fetchByPrimaryKey(groupId);
	}

	/**
	 * Returns the flask group with the primary key.
	 *
	 * @param groupId the primary key of the flask group
	 * @return the flask group
	 * @throws PortalException if a flask group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskGroup getFlaskGroup(long groupId)
		throws PortalException, SystemException {
		return flaskGroupPersistence.findByPrimaryKey(groupId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return flaskGroupPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the flask groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.FlaskGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask groups
	 * @param end the upper bound of the range of flask groups (not inclusive)
	 * @return the range of flask groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskGroup> getFlaskGroups(int start, int end)
		throws SystemException {
		return flaskGroupPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of flask groups.
	 *
	 * @return the number of flask groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getFlaskGroupsCount() throws SystemException {
		return flaskGroupPersistence.countAll();
	}

	/**
	 * Updates the flask group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param flaskGroup the flask group
	 * @return the flask group that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public FlaskGroup updateFlaskGroup(FlaskGroup flaskGroup)
		throws SystemException {
		return flaskGroupPersistence.update(flaskGroup);
	}

	/**
	 * Returns the flask group local service.
	 *
	 * @return the flask group local service
	 */
	public com.rumbasolutions.flask.service.FlaskGroupLocalService getFlaskGroupLocalService() {
		return flaskGroupLocalService;
	}

	/**
	 * Sets the flask group local service.
	 *
	 * @param flaskGroupLocalService the flask group local service
	 */
	public void setFlaskGroupLocalService(
		com.rumbasolutions.flask.service.FlaskGroupLocalService flaskGroupLocalService) {
		this.flaskGroupLocalService = flaskGroupLocalService;
	}

	/**
	 * Returns the flask group remote service.
	 *
	 * @return the flask group remote service
	 */
	public com.rumbasolutions.flask.service.FlaskGroupService getFlaskGroupService() {
		return flaskGroupService;
	}

	/**
	 * Sets the flask group remote service.
	 *
	 * @param flaskGroupService the flask group remote service
	 */
	public void setFlaskGroupService(
		com.rumbasolutions.flask.service.FlaskGroupService flaskGroupService) {
		this.flaskGroupService = flaskGroupService;
	}

	/**
	 * Returns the flask group persistence.
	 *
	 * @return the flask group persistence
	 */
	public FlaskGroupPersistence getFlaskGroupPersistence() {
		return flaskGroupPersistence;
	}

	/**
	 * Sets the flask group persistence.
	 *
	 * @param flaskGroupPersistence the flask group persistence
	 */
	public void setFlaskGroupPersistence(
		FlaskGroupPersistence flaskGroupPersistence) {
		this.flaskGroupPersistence = flaskGroupPersistence;
	}

	/**
	 * Returns the flask group finder.
	 *
	 * @return the flask group finder
	 */
	public FlaskGroupFinder getFlaskGroupFinder() {
		return flaskGroupFinder;
	}

	/**
	 * Sets the flask group finder.
	 *
	 * @param flaskGroupFinder the flask group finder
	 */
	public void setFlaskGroupFinder(FlaskGroupFinder flaskGroupFinder) {
		this.flaskGroupFinder = flaskGroupFinder;
	}

	/**
	 * Returns the flask group users local service.
	 *
	 * @return the flask group users local service
	 */
	public com.rumbasolutions.flask.service.FlaskGroupUsersLocalService getFlaskGroupUsersLocalService() {
		return flaskGroupUsersLocalService;
	}

	/**
	 * Sets the flask group users local service.
	 *
	 * @param flaskGroupUsersLocalService the flask group users local service
	 */
	public void setFlaskGroupUsersLocalService(
		com.rumbasolutions.flask.service.FlaskGroupUsersLocalService flaskGroupUsersLocalService) {
		this.flaskGroupUsersLocalService = flaskGroupUsersLocalService;
	}

	/**
	 * Returns the flask group users remote service.
	 *
	 * @return the flask group users remote service
	 */
	public com.rumbasolutions.flask.service.FlaskGroupUsersService getFlaskGroupUsersService() {
		return flaskGroupUsersService;
	}

	/**
	 * Sets the flask group users remote service.
	 *
	 * @param flaskGroupUsersService the flask group users remote service
	 */
	public void setFlaskGroupUsersService(
		com.rumbasolutions.flask.service.FlaskGroupUsersService flaskGroupUsersService) {
		this.flaskGroupUsersService = flaskGroupUsersService;
	}

	/**
	 * Returns the flask group users persistence.
	 *
	 * @return the flask group users persistence
	 */
	public FlaskGroupUsersPersistence getFlaskGroupUsersPersistence() {
		return flaskGroupUsersPersistence;
	}

	/**
	 * Sets the flask group users persistence.
	 *
	 * @param flaskGroupUsersPersistence the flask group users persistence
	 */
	public void setFlaskGroupUsersPersistence(
		FlaskGroupUsersPersistence flaskGroupUsersPersistence) {
		this.flaskGroupUsersPersistence = flaskGroupUsersPersistence;
	}

	/**
	 * Returns the flask group users finder.
	 *
	 * @return the flask group users finder
	 */
	public FlaskGroupUsersFinder getFlaskGroupUsersFinder() {
		return flaskGroupUsersFinder;
	}

	/**
	 * Sets the flask group users finder.
	 *
	 * @param flaskGroupUsersFinder the flask group users finder
	 */
	public void setFlaskGroupUsersFinder(
		FlaskGroupUsersFinder flaskGroupUsersFinder) {
		this.flaskGroupUsersFinder = flaskGroupUsersFinder;
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

		PersistedModelLocalServiceRegistryUtil.register("com.rumbasolutions.flask.model.FlaskGroup",
			flaskGroupLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.rumbasolutions.flask.model.FlaskGroup");
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
		return FlaskGroup.class;
	}

	protected String getModelClassName() {
		return FlaskGroup.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = flaskGroupPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rumbasolutions.flask.service.FlaskGroupLocalService.class)
	protected com.rumbasolutions.flask.service.FlaskGroupLocalService flaskGroupLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.FlaskGroupService.class)
	protected com.rumbasolutions.flask.service.FlaskGroupService flaskGroupService;
	@BeanReference(type = FlaskGroupPersistence.class)
	protected FlaskGroupPersistence flaskGroupPersistence;
	@BeanReference(type = FlaskGroupFinder.class)
	protected FlaskGroupFinder flaskGroupFinder;
	@BeanReference(type = com.rumbasolutions.flask.service.FlaskGroupUsersLocalService.class)
	protected com.rumbasolutions.flask.service.FlaskGroupUsersLocalService flaskGroupUsersLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.FlaskGroupUsersService.class)
	protected com.rumbasolutions.flask.service.FlaskGroupUsersService flaskGroupUsersService;
	@BeanReference(type = FlaskGroupUsersPersistence.class)
	protected FlaskGroupUsersPersistence flaskGroupUsersPersistence;
	@BeanReference(type = FlaskGroupUsersFinder.class)
	protected FlaskGroupUsersFinder flaskGroupUsersFinder;
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
	private FlaskGroupLocalServiceClpInvoker _clpInvoker = new FlaskGroupLocalServiceClpInvoker();
}