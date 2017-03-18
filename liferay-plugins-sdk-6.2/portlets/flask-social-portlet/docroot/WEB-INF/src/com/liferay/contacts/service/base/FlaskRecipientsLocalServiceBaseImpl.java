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

package com.liferay.contacts.service.base;

import com.liferay.contacts.model.FlaskRecipients;
import com.liferay.contacts.service.FlaskRecipientsLocalService;
import com.liferay.contacts.service.persistence.DeviceAwsEndpointPersistence;
import com.liferay.contacts.service.persistence.EntryFinder;
import com.liferay.contacts.service.persistence.EntryPersistence;
import com.liferay.contacts.service.persistence.FlaskGroupMessagesPersistence;
import com.liferay.contacts.service.persistence.FlaskGroupRecipientsPersistence;
import com.liferay.contacts.service.persistence.FlaskMessagesPersistence;
import com.liferay.contacts.service.persistence.FlaskRecipientsPersistence;
import com.liferay.contacts.service.persistence.FlaskUserDeviceRegistrationPersistence;
import com.liferay.contacts.service.persistence.NotificationAuditLogPersistence;

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

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the flask recipients local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.contacts.service.impl.FlaskRecipientsLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.contacts.service.impl.FlaskRecipientsLocalServiceImpl
 * @see com.liferay.contacts.service.FlaskRecipientsLocalServiceUtil
 * @generated
 */
public abstract class FlaskRecipientsLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements FlaskRecipientsLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.contacts.service.FlaskRecipientsLocalServiceUtil} to access the flask recipients local service.
	 */

	/**
	 * Adds the flask recipients to the database. Also notifies the appropriate model listeners.
	 *
	 * @param flaskRecipients the flask recipients
	 * @return the flask recipients that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public FlaskRecipients addFlaskRecipients(FlaskRecipients flaskRecipients)
		throws SystemException {
		flaskRecipients.setNew(true);

		return flaskRecipientsPersistence.update(flaskRecipients);
	}

	/**
	 * Creates a new flask recipients with the primary key. Does not add the flask recipients to the database.
	 *
	 * @param recipientId the primary key for the new flask recipients
	 * @return the new flask recipients
	 */
	@Override
	public FlaskRecipients createFlaskRecipients(long recipientId) {
		return flaskRecipientsPersistence.create(recipientId);
	}

	/**
	 * Deletes the flask recipients with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param recipientId the primary key of the flask recipients
	 * @return the flask recipients that was removed
	 * @throws PortalException if a flask recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public FlaskRecipients deleteFlaskRecipients(long recipientId)
		throws PortalException, SystemException {
		return flaskRecipientsPersistence.remove(recipientId);
	}

	/**
	 * Deletes the flask recipients from the database. Also notifies the appropriate model listeners.
	 *
	 * @param flaskRecipients the flask recipients
	 * @return the flask recipients that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public FlaskRecipients deleteFlaskRecipients(
		FlaskRecipients flaskRecipients) throws SystemException {
		return flaskRecipientsPersistence.remove(flaskRecipients);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(FlaskRecipients.class,
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
		return flaskRecipientsPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return flaskRecipientsPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return flaskRecipientsPersistence.findWithDynamicQuery(dynamicQuery,
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
		return flaskRecipientsPersistence.countWithDynamicQuery(dynamicQuery);
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
		return flaskRecipientsPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public FlaskRecipients fetchFlaskRecipients(long recipientId)
		throws SystemException {
		return flaskRecipientsPersistence.fetchByPrimaryKey(recipientId);
	}

	/**
	 * Returns the flask recipients with the primary key.
	 *
	 * @param recipientId the primary key of the flask recipients
	 * @return the flask recipients
	 * @throws PortalException if a flask recipients with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlaskRecipients getFlaskRecipients(long recipientId)
		throws PortalException, SystemException {
		return flaskRecipientsPersistence.findByPrimaryKey(recipientId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return flaskRecipientsPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the flask recipientses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.contacts.model.impl.FlaskRecipientsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flask recipientses
	 * @param end the upper bound of the range of flask recipientses (not inclusive)
	 * @return the range of flask recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlaskRecipients> getFlaskRecipientses(int start, int end)
		throws SystemException {
		return flaskRecipientsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of flask recipientses.
	 *
	 * @return the number of flask recipientses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getFlaskRecipientsesCount() throws SystemException {
		return flaskRecipientsPersistence.countAll();
	}

	/**
	 * Updates the flask recipients in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param flaskRecipients the flask recipients
	 * @return the flask recipients that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public FlaskRecipients updateFlaskRecipients(
		FlaskRecipients flaskRecipients) throws SystemException {
		return flaskRecipientsPersistence.update(flaskRecipients);
	}

	/**
	 * Returns the device aws endpoint local service.
	 *
	 * @return the device aws endpoint local service
	 */
	public com.liferay.contacts.service.DeviceAwsEndpointLocalService getDeviceAwsEndpointLocalService() {
		return deviceAwsEndpointLocalService;
	}

	/**
	 * Sets the device aws endpoint local service.
	 *
	 * @param deviceAwsEndpointLocalService the device aws endpoint local service
	 */
	public void setDeviceAwsEndpointLocalService(
		com.liferay.contacts.service.DeviceAwsEndpointLocalService deviceAwsEndpointLocalService) {
		this.deviceAwsEndpointLocalService = deviceAwsEndpointLocalService;
	}

	/**
	 * Returns the device aws endpoint remote service.
	 *
	 * @return the device aws endpoint remote service
	 */
	public com.liferay.contacts.service.DeviceAwsEndpointService getDeviceAwsEndpointService() {
		return deviceAwsEndpointService;
	}

	/**
	 * Sets the device aws endpoint remote service.
	 *
	 * @param deviceAwsEndpointService the device aws endpoint remote service
	 */
	public void setDeviceAwsEndpointService(
		com.liferay.contacts.service.DeviceAwsEndpointService deviceAwsEndpointService) {
		this.deviceAwsEndpointService = deviceAwsEndpointService;
	}

	/**
	 * Returns the device aws endpoint persistence.
	 *
	 * @return the device aws endpoint persistence
	 */
	public DeviceAwsEndpointPersistence getDeviceAwsEndpointPersistence() {
		return deviceAwsEndpointPersistence;
	}

	/**
	 * Sets the device aws endpoint persistence.
	 *
	 * @param deviceAwsEndpointPersistence the device aws endpoint persistence
	 */
	public void setDeviceAwsEndpointPersistence(
		DeviceAwsEndpointPersistence deviceAwsEndpointPersistence) {
		this.deviceAwsEndpointPersistence = deviceAwsEndpointPersistence;
	}

	/**
	 * Returns the entry local service.
	 *
	 * @return the entry local service
	 */
	public com.liferay.contacts.service.EntryLocalService getEntryLocalService() {
		return entryLocalService;
	}

	/**
	 * Sets the entry local service.
	 *
	 * @param entryLocalService the entry local service
	 */
	public void setEntryLocalService(
		com.liferay.contacts.service.EntryLocalService entryLocalService) {
		this.entryLocalService = entryLocalService;
	}

	/**
	 * Returns the entry remote service.
	 *
	 * @return the entry remote service
	 */
	public com.liferay.contacts.service.EntryService getEntryService() {
		return entryService;
	}

	/**
	 * Sets the entry remote service.
	 *
	 * @param entryService the entry remote service
	 */
	public void setEntryService(
		com.liferay.contacts.service.EntryService entryService) {
		this.entryService = entryService;
	}

	/**
	 * Returns the entry persistence.
	 *
	 * @return the entry persistence
	 */
	public EntryPersistence getEntryPersistence() {
		return entryPersistence;
	}

	/**
	 * Sets the entry persistence.
	 *
	 * @param entryPersistence the entry persistence
	 */
	public void setEntryPersistence(EntryPersistence entryPersistence) {
		this.entryPersistence = entryPersistence;
	}

	/**
	 * Returns the entry finder.
	 *
	 * @return the entry finder
	 */
	public EntryFinder getEntryFinder() {
		return entryFinder;
	}

	/**
	 * Sets the entry finder.
	 *
	 * @param entryFinder the entry finder
	 */
	public void setEntryFinder(EntryFinder entryFinder) {
		this.entryFinder = entryFinder;
	}

	/**
	 * Returns the flask group messages local service.
	 *
	 * @return the flask group messages local service
	 */
	public com.liferay.contacts.service.FlaskGroupMessagesLocalService getFlaskGroupMessagesLocalService() {
		return flaskGroupMessagesLocalService;
	}

	/**
	 * Sets the flask group messages local service.
	 *
	 * @param flaskGroupMessagesLocalService the flask group messages local service
	 */
	public void setFlaskGroupMessagesLocalService(
		com.liferay.contacts.service.FlaskGroupMessagesLocalService flaskGroupMessagesLocalService) {
		this.flaskGroupMessagesLocalService = flaskGroupMessagesLocalService;
	}

	/**
	 * Returns the flask group messages remote service.
	 *
	 * @return the flask group messages remote service
	 */
	public com.liferay.contacts.service.FlaskGroupMessagesService getFlaskGroupMessagesService() {
		return flaskGroupMessagesService;
	}

	/**
	 * Sets the flask group messages remote service.
	 *
	 * @param flaskGroupMessagesService the flask group messages remote service
	 */
	public void setFlaskGroupMessagesService(
		com.liferay.contacts.service.FlaskGroupMessagesService flaskGroupMessagesService) {
		this.flaskGroupMessagesService = flaskGroupMessagesService;
	}

	/**
	 * Returns the flask group messages persistence.
	 *
	 * @return the flask group messages persistence
	 */
	public FlaskGroupMessagesPersistence getFlaskGroupMessagesPersistence() {
		return flaskGroupMessagesPersistence;
	}

	/**
	 * Sets the flask group messages persistence.
	 *
	 * @param flaskGroupMessagesPersistence the flask group messages persistence
	 */
	public void setFlaskGroupMessagesPersistence(
		FlaskGroupMessagesPersistence flaskGroupMessagesPersistence) {
		this.flaskGroupMessagesPersistence = flaskGroupMessagesPersistence;
	}

	/**
	 * Returns the flask group recipients local service.
	 *
	 * @return the flask group recipients local service
	 */
	public com.liferay.contacts.service.FlaskGroupRecipientsLocalService getFlaskGroupRecipientsLocalService() {
		return flaskGroupRecipientsLocalService;
	}

	/**
	 * Sets the flask group recipients local service.
	 *
	 * @param flaskGroupRecipientsLocalService the flask group recipients local service
	 */
	public void setFlaskGroupRecipientsLocalService(
		com.liferay.contacts.service.FlaskGroupRecipientsLocalService flaskGroupRecipientsLocalService) {
		this.flaskGroupRecipientsLocalService = flaskGroupRecipientsLocalService;
	}

	/**
	 * Returns the flask group recipients remote service.
	 *
	 * @return the flask group recipients remote service
	 */
	public com.liferay.contacts.service.FlaskGroupRecipientsService getFlaskGroupRecipientsService() {
		return flaskGroupRecipientsService;
	}

	/**
	 * Sets the flask group recipients remote service.
	 *
	 * @param flaskGroupRecipientsService the flask group recipients remote service
	 */
	public void setFlaskGroupRecipientsService(
		com.liferay.contacts.service.FlaskGroupRecipientsService flaskGroupRecipientsService) {
		this.flaskGroupRecipientsService = flaskGroupRecipientsService;
	}

	/**
	 * Returns the flask group recipients persistence.
	 *
	 * @return the flask group recipients persistence
	 */
	public FlaskGroupRecipientsPersistence getFlaskGroupRecipientsPersistence() {
		return flaskGroupRecipientsPersistence;
	}

	/**
	 * Sets the flask group recipients persistence.
	 *
	 * @param flaskGroupRecipientsPersistence the flask group recipients persistence
	 */
	public void setFlaskGroupRecipientsPersistence(
		FlaskGroupRecipientsPersistence flaskGroupRecipientsPersistence) {
		this.flaskGroupRecipientsPersistence = flaskGroupRecipientsPersistence;
	}

	/**
	 * Returns the flask messages local service.
	 *
	 * @return the flask messages local service
	 */
	public com.liferay.contacts.service.FlaskMessagesLocalService getFlaskMessagesLocalService() {
		return flaskMessagesLocalService;
	}

	/**
	 * Sets the flask messages local service.
	 *
	 * @param flaskMessagesLocalService the flask messages local service
	 */
	public void setFlaskMessagesLocalService(
		com.liferay.contacts.service.FlaskMessagesLocalService flaskMessagesLocalService) {
		this.flaskMessagesLocalService = flaskMessagesLocalService;
	}

	/**
	 * Returns the flask messages remote service.
	 *
	 * @return the flask messages remote service
	 */
	public com.liferay.contacts.service.FlaskMessagesService getFlaskMessagesService() {
		return flaskMessagesService;
	}

	/**
	 * Sets the flask messages remote service.
	 *
	 * @param flaskMessagesService the flask messages remote service
	 */
	public void setFlaskMessagesService(
		com.liferay.contacts.service.FlaskMessagesService flaskMessagesService) {
		this.flaskMessagesService = flaskMessagesService;
	}

	/**
	 * Returns the flask messages persistence.
	 *
	 * @return the flask messages persistence
	 */
	public FlaskMessagesPersistence getFlaskMessagesPersistence() {
		return flaskMessagesPersistence;
	}

	/**
	 * Sets the flask messages persistence.
	 *
	 * @param flaskMessagesPersistence the flask messages persistence
	 */
	public void setFlaskMessagesPersistence(
		FlaskMessagesPersistence flaskMessagesPersistence) {
		this.flaskMessagesPersistence = flaskMessagesPersistence;
	}

	/**
	 * Returns the flask recipients local service.
	 *
	 * @return the flask recipients local service
	 */
	public com.liferay.contacts.service.FlaskRecipientsLocalService getFlaskRecipientsLocalService() {
		return flaskRecipientsLocalService;
	}

	/**
	 * Sets the flask recipients local service.
	 *
	 * @param flaskRecipientsLocalService the flask recipients local service
	 */
	public void setFlaskRecipientsLocalService(
		com.liferay.contacts.service.FlaskRecipientsLocalService flaskRecipientsLocalService) {
		this.flaskRecipientsLocalService = flaskRecipientsLocalService;
	}

	/**
	 * Returns the flask recipients remote service.
	 *
	 * @return the flask recipients remote service
	 */
	public com.liferay.contacts.service.FlaskRecipientsService getFlaskRecipientsService() {
		return flaskRecipientsService;
	}

	/**
	 * Sets the flask recipients remote service.
	 *
	 * @param flaskRecipientsService the flask recipients remote service
	 */
	public void setFlaskRecipientsService(
		com.liferay.contacts.service.FlaskRecipientsService flaskRecipientsService) {
		this.flaskRecipientsService = flaskRecipientsService;
	}

	/**
	 * Returns the flask recipients persistence.
	 *
	 * @return the flask recipients persistence
	 */
	public FlaskRecipientsPersistence getFlaskRecipientsPersistence() {
		return flaskRecipientsPersistence;
	}

	/**
	 * Sets the flask recipients persistence.
	 *
	 * @param flaskRecipientsPersistence the flask recipients persistence
	 */
	public void setFlaskRecipientsPersistence(
		FlaskRecipientsPersistence flaskRecipientsPersistence) {
		this.flaskRecipientsPersistence = flaskRecipientsPersistence;
	}

	/**
	 * Returns the flask user device registration local service.
	 *
	 * @return the flask user device registration local service
	 */
	public com.liferay.contacts.service.FlaskUserDeviceRegistrationLocalService getFlaskUserDeviceRegistrationLocalService() {
		return flaskUserDeviceRegistrationLocalService;
	}

	/**
	 * Sets the flask user device registration local service.
	 *
	 * @param flaskUserDeviceRegistrationLocalService the flask user device registration local service
	 */
	public void setFlaskUserDeviceRegistrationLocalService(
		com.liferay.contacts.service.FlaskUserDeviceRegistrationLocalService flaskUserDeviceRegistrationLocalService) {
		this.flaskUserDeviceRegistrationLocalService = flaskUserDeviceRegistrationLocalService;
	}

	/**
	 * Returns the flask user device registration remote service.
	 *
	 * @return the flask user device registration remote service
	 */
	public com.liferay.contacts.service.FlaskUserDeviceRegistrationService getFlaskUserDeviceRegistrationService() {
		return flaskUserDeviceRegistrationService;
	}

	/**
	 * Sets the flask user device registration remote service.
	 *
	 * @param flaskUserDeviceRegistrationService the flask user device registration remote service
	 */
	public void setFlaskUserDeviceRegistrationService(
		com.liferay.contacts.service.FlaskUserDeviceRegistrationService flaskUserDeviceRegistrationService) {
		this.flaskUserDeviceRegistrationService = flaskUserDeviceRegistrationService;
	}

	/**
	 * Returns the flask user device registration persistence.
	 *
	 * @return the flask user device registration persistence
	 */
	public FlaskUserDeviceRegistrationPersistence getFlaskUserDeviceRegistrationPersistence() {
		return flaskUserDeviceRegistrationPersistence;
	}

	/**
	 * Sets the flask user device registration persistence.
	 *
	 * @param flaskUserDeviceRegistrationPersistence the flask user device registration persistence
	 */
	public void setFlaskUserDeviceRegistrationPersistence(
		FlaskUserDeviceRegistrationPersistence flaskUserDeviceRegistrationPersistence) {
		this.flaskUserDeviceRegistrationPersistence = flaskUserDeviceRegistrationPersistence;
	}

	/**
	 * Returns the notification audit log local service.
	 *
	 * @return the notification audit log local service
	 */
	public com.liferay.contacts.service.NotificationAuditLogLocalService getNotificationAuditLogLocalService() {
		return notificationAuditLogLocalService;
	}

	/**
	 * Sets the notification audit log local service.
	 *
	 * @param notificationAuditLogLocalService the notification audit log local service
	 */
	public void setNotificationAuditLogLocalService(
		com.liferay.contacts.service.NotificationAuditLogLocalService notificationAuditLogLocalService) {
		this.notificationAuditLogLocalService = notificationAuditLogLocalService;
	}

	/**
	 * Returns the notification audit log remote service.
	 *
	 * @return the notification audit log remote service
	 */
	public com.liferay.contacts.service.NotificationAuditLogService getNotificationAuditLogService() {
		return notificationAuditLogService;
	}

	/**
	 * Sets the notification audit log remote service.
	 *
	 * @param notificationAuditLogService the notification audit log remote service
	 */
	public void setNotificationAuditLogService(
		com.liferay.contacts.service.NotificationAuditLogService notificationAuditLogService) {
		this.notificationAuditLogService = notificationAuditLogService;
	}

	/**
	 * Returns the notification audit log persistence.
	 *
	 * @return the notification audit log persistence
	 */
	public NotificationAuditLogPersistence getNotificationAuditLogPersistence() {
		return notificationAuditLogPersistence;
	}

	/**
	 * Sets the notification audit log persistence.
	 *
	 * @param notificationAuditLogPersistence the notification audit log persistence
	 */
	public void setNotificationAuditLogPersistence(
		NotificationAuditLogPersistence notificationAuditLogPersistence) {
		this.notificationAuditLogPersistence = notificationAuditLogPersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.liferay.contacts.model.FlaskRecipients",
			flaskRecipientsLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.contacts.model.FlaskRecipients");
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
		return FlaskRecipients.class;
	}

	protected String getModelClassName() {
		return FlaskRecipients.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = flaskRecipientsPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.contacts.service.DeviceAwsEndpointLocalService.class)
	protected com.liferay.contacts.service.DeviceAwsEndpointLocalService deviceAwsEndpointLocalService;
	@BeanReference(type = com.liferay.contacts.service.DeviceAwsEndpointService.class)
	protected com.liferay.contacts.service.DeviceAwsEndpointService deviceAwsEndpointService;
	@BeanReference(type = DeviceAwsEndpointPersistence.class)
	protected DeviceAwsEndpointPersistence deviceAwsEndpointPersistence;
	@BeanReference(type = com.liferay.contacts.service.EntryLocalService.class)
	protected com.liferay.contacts.service.EntryLocalService entryLocalService;
	@BeanReference(type = com.liferay.contacts.service.EntryService.class)
	protected com.liferay.contacts.service.EntryService entryService;
	@BeanReference(type = EntryPersistence.class)
	protected EntryPersistence entryPersistence;
	@BeanReference(type = EntryFinder.class)
	protected EntryFinder entryFinder;
	@BeanReference(type = com.liferay.contacts.service.FlaskGroupMessagesLocalService.class)
	protected com.liferay.contacts.service.FlaskGroupMessagesLocalService flaskGroupMessagesLocalService;
	@BeanReference(type = com.liferay.contacts.service.FlaskGroupMessagesService.class)
	protected com.liferay.contacts.service.FlaskGroupMessagesService flaskGroupMessagesService;
	@BeanReference(type = FlaskGroupMessagesPersistence.class)
	protected FlaskGroupMessagesPersistence flaskGroupMessagesPersistence;
	@BeanReference(type = com.liferay.contacts.service.FlaskGroupRecipientsLocalService.class)
	protected com.liferay.contacts.service.FlaskGroupRecipientsLocalService flaskGroupRecipientsLocalService;
	@BeanReference(type = com.liferay.contacts.service.FlaskGroupRecipientsService.class)
	protected com.liferay.contacts.service.FlaskGroupRecipientsService flaskGroupRecipientsService;
	@BeanReference(type = FlaskGroupRecipientsPersistence.class)
	protected FlaskGroupRecipientsPersistence flaskGroupRecipientsPersistence;
	@BeanReference(type = com.liferay.contacts.service.FlaskMessagesLocalService.class)
	protected com.liferay.contacts.service.FlaskMessagesLocalService flaskMessagesLocalService;
	@BeanReference(type = com.liferay.contacts.service.FlaskMessagesService.class)
	protected com.liferay.contacts.service.FlaskMessagesService flaskMessagesService;
	@BeanReference(type = FlaskMessagesPersistence.class)
	protected FlaskMessagesPersistence flaskMessagesPersistence;
	@BeanReference(type = com.liferay.contacts.service.FlaskRecipientsLocalService.class)
	protected com.liferay.contacts.service.FlaskRecipientsLocalService flaskRecipientsLocalService;
	@BeanReference(type = com.liferay.contacts.service.FlaskRecipientsService.class)
	protected com.liferay.contacts.service.FlaskRecipientsService flaskRecipientsService;
	@BeanReference(type = FlaskRecipientsPersistence.class)
	protected FlaskRecipientsPersistence flaskRecipientsPersistence;
	@BeanReference(type = com.liferay.contacts.service.FlaskUserDeviceRegistrationLocalService.class)
	protected com.liferay.contacts.service.FlaskUserDeviceRegistrationLocalService flaskUserDeviceRegistrationLocalService;
	@BeanReference(type = com.liferay.contacts.service.FlaskUserDeviceRegistrationService.class)
	protected com.liferay.contacts.service.FlaskUserDeviceRegistrationService flaskUserDeviceRegistrationService;
	@BeanReference(type = FlaskUserDeviceRegistrationPersistence.class)
	protected FlaskUserDeviceRegistrationPersistence flaskUserDeviceRegistrationPersistence;
	@BeanReference(type = com.liferay.contacts.service.NotificationAuditLogLocalService.class)
	protected com.liferay.contacts.service.NotificationAuditLogLocalService notificationAuditLogLocalService;
	@BeanReference(type = com.liferay.contacts.service.NotificationAuditLogService.class)
	protected com.liferay.contacts.service.NotificationAuditLogService notificationAuditLogService;
	@BeanReference(type = NotificationAuditLogPersistence.class)
	protected NotificationAuditLogPersistence notificationAuditLogPersistence;
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
	private FlaskRecipientsLocalServiceClpInvoker _clpInvoker = new FlaskRecipientsLocalServiceClpInvoker();
}