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
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.rumbasolutions.flask.model.EventDetailImage;
import com.rumbasolutions.flask.model.EventDetailImageEventDetailImageDataBlobModel;
import com.rumbasolutions.flask.service.EventDetailImageLocalService;
import com.rumbasolutions.flask.service.persistence.EventDetailImagePersistence;
import com.rumbasolutions.flask.service.persistence.EventDetailPersistence;
import com.rumbasolutions.flask.service.persistence.EventPersistence;
import com.rumbasolutions.flask.service.persistence.EventTypePersistence;
import com.rumbasolutions.flask.service.persistence.InfoTypeCategoryPersistence;
import com.rumbasolutions.flask.service.persistence.InfoTypePersistence;
import com.rumbasolutions.flask.service.persistence.VenueDetailImagePersistence;
import com.rumbasolutions.flask.service.persistence.VenueDetailPersistence;
import com.rumbasolutions.flask.service.persistence.VenueImagePersistence;
import com.rumbasolutions.flask.service.persistence.VenuePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the event detail image local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rumbasolutions.flask.service.impl.EventDetailImageLocalServiceImpl}.
 * </p>
 *
 * @author Ashutosh Rai
 * @see com.rumbasolutions.flask.service.impl.EventDetailImageLocalServiceImpl
 * @see com.rumbasolutions.flask.service.EventDetailImageLocalServiceUtil
 * @generated
 */
public abstract class EventDetailImageLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements EventDetailImageLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rumbasolutions.flask.service.EventDetailImageLocalServiceUtil} to access the event detail image local service.
	 */

	/**
	 * Adds the event detail image to the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventDetailImage the event detail image
	 * @return the event detail image that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EventDetailImage addEventDetailImage(
		EventDetailImage eventDetailImage) throws SystemException {
		eventDetailImage.setNew(true);

		return eventDetailImagePersistence.update(eventDetailImage);
	}

	/**
	 * Creates a new event detail image with the primary key. Does not add the event detail image to the database.
	 *
	 * @param eventDetailImageId the primary key for the new event detail image
	 * @return the new event detail image
	 */
	@Override
	public EventDetailImage createEventDetailImage(long eventDetailImageId) {
		return eventDetailImagePersistence.create(eventDetailImageId);
	}

	/**
	 * Deletes the event detail image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventDetailImageId the primary key of the event detail image
	 * @return the event detail image that was removed
	 * @throws PortalException if a event detail image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EventDetailImage deleteEventDetailImage(long eventDetailImageId)
		throws PortalException, SystemException {
		return eventDetailImagePersistence.remove(eventDetailImageId);
	}

	/**
	 * Deletes the event detail image from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventDetailImage the event detail image
	 * @return the event detail image that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public EventDetailImage deleteEventDetailImage(
		EventDetailImage eventDetailImage) throws SystemException {
		return eventDetailImagePersistence.remove(eventDetailImage);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(EventDetailImage.class,
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
		return eventDetailImagePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return eventDetailImagePersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return eventDetailImagePersistence.findWithDynamicQuery(dynamicQuery,
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
		return eventDetailImagePersistence.countWithDynamicQuery(dynamicQuery);
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
		return eventDetailImagePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public EventDetailImage fetchEventDetailImage(long eventDetailImageId)
		throws SystemException {
		return eventDetailImagePersistence.fetchByPrimaryKey(eventDetailImageId);
	}

	/**
	 * Returns the event detail image with the primary key.
	 *
	 * @param eventDetailImageId the primary key of the event detail image
	 * @return the event detail image
	 * @throws PortalException if a event detail image with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EventDetailImage getEventDetailImage(long eventDetailImageId)
		throws PortalException, SystemException {
		return eventDetailImagePersistence.findByPrimaryKey(eventDetailImageId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return eventDetailImagePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the event detail images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rumbasolutions.flask.model.impl.EventDetailImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event detail images
	 * @param end the upper bound of the range of event detail images (not inclusive)
	 * @return the range of event detail images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EventDetailImage> getEventDetailImages(int start, int end)
		throws SystemException {
		return eventDetailImagePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of event detail images.
	 *
	 * @return the number of event detail images
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getEventDetailImagesCount() throws SystemException {
		return eventDetailImagePersistence.countAll();
	}

	/**
	 * Updates the event detail image in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param eventDetailImage the event detail image
	 * @return the event detail image that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public EventDetailImage updateEventDetailImage(
		EventDetailImage eventDetailImage) throws SystemException {
		return eventDetailImagePersistence.update(eventDetailImage);
	}

	@Override
	public EventDetailImageEventDetailImageDataBlobModel getEventDetailImageDataBlobModel(
		Serializable primaryKey) throws SystemException {
		Session session = null;

		try {
			session = eventDetailImagePersistence.openSession();

			return (com.rumbasolutions.flask.model.EventDetailImageEventDetailImageDataBlobModel)session.get(EventDetailImageEventDetailImageDataBlobModel.class,
				primaryKey);
		}
		catch (Exception e) {
			throw eventDetailImagePersistence.processException(e);
		}
		finally {
			eventDetailImagePersistence.closeSession(session);
		}
	}

	/**
	 * Returns the event local service.
	 *
	 * @return the event local service
	 */
	public com.rumbasolutions.flask.service.EventLocalService getEventLocalService() {
		return eventLocalService;
	}

	/**
	 * Sets the event local service.
	 *
	 * @param eventLocalService the event local service
	 */
	public void setEventLocalService(
		com.rumbasolutions.flask.service.EventLocalService eventLocalService) {
		this.eventLocalService = eventLocalService;
	}

	/**
	 * Returns the event remote service.
	 *
	 * @return the event remote service
	 */
	public com.rumbasolutions.flask.service.EventService getEventService() {
		return eventService;
	}

	/**
	 * Sets the event remote service.
	 *
	 * @param eventService the event remote service
	 */
	public void setEventService(
		com.rumbasolutions.flask.service.EventService eventService) {
		this.eventService = eventService;
	}

	/**
	 * Returns the event persistence.
	 *
	 * @return the event persistence
	 */
	public EventPersistence getEventPersistence() {
		return eventPersistence;
	}

	/**
	 * Sets the event persistence.
	 *
	 * @param eventPersistence the event persistence
	 */
	public void setEventPersistence(EventPersistence eventPersistence) {
		this.eventPersistence = eventPersistence;
	}

	/**
	 * Returns the event detail local service.
	 *
	 * @return the event detail local service
	 */
	public com.rumbasolutions.flask.service.EventDetailLocalService getEventDetailLocalService() {
		return eventDetailLocalService;
	}

	/**
	 * Sets the event detail local service.
	 *
	 * @param eventDetailLocalService the event detail local service
	 */
	public void setEventDetailLocalService(
		com.rumbasolutions.flask.service.EventDetailLocalService eventDetailLocalService) {
		this.eventDetailLocalService = eventDetailLocalService;
	}

	/**
	 * Returns the event detail remote service.
	 *
	 * @return the event detail remote service
	 */
	public com.rumbasolutions.flask.service.EventDetailService getEventDetailService() {
		return eventDetailService;
	}

	/**
	 * Sets the event detail remote service.
	 *
	 * @param eventDetailService the event detail remote service
	 */
	public void setEventDetailService(
		com.rumbasolutions.flask.service.EventDetailService eventDetailService) {
		this.eventDetailService = eventDetailService;
	}

	/**
	 * Returns the event detail persistence.
	 *
	 * @return the event detail persistence
	 */
	public EventDetailPersistence getEventDetailPersistence() {
		return eventDetailPersistence;
	}

	/**
	 * Sets the event detail persistence.
	 *
	 * @param eventDetailPersistence the event detail persistence
	 */
	public void setEventDetailPersistence(
		EventDetailPersistence eventDetailPersistence) {
		this.eventDetailPersistence = eventDetailPersistence;
	}

	/**
	 * Returns the event detail image local service.
	 *
	 * @return the event detail image local service
	 */
	public com.rumbasolutions.flask.service.EventDetailImageLocalService getEventDetailImageLocalService() {
		return eventDetailImageLocalService;
	}

	/**
	 * Sets the event detail image local service.
	 *
	 * @param eventDetailImageLocalService the event detail image local service
	 */
	public void setEventDetailImageLocalService(
		com.rumbasolutions.flask.service.EventDetailImageLocalService eventDetailImageLocalService) {
		this.eventDetailImageLocalService = eventDetailImageLocalService;
	}

	/**
	 * Returns the event detail image remote service.
	 *
	 * @return the event detail image remote service
	 */
	public com.rumbasolutions.flask.service.EventDetailImageService getEventDetailImageService() {
		return eventDetailImageService;
	}

	/**
	 * Sets the event detail image remote service.
	 *
	 * @param eventDetailImageService the event detail image remote service
	 */
	public void setEventDetailImageService(
		com.rumbasolutions.flask.service.EventDetailImageService eventDetailImageService) {
		this.eventDetailImageService = eventDetailImageService;
	}

	/**
	 * Returns the event detail image persistence.
	 *
	 * @return the event detail image persistence
	 */
	public EventDetailImagePersistence getEventDetailImagePersistence() {
		return eventDetailImagePersistence;
	}

	/**
	 * Sets the event detail image persistence.
	 *
	 * @param eventDetailImagePersistence the event detail image persistence
	 */
	public void setEventDetailImagePersistence(
		EventDetailImagePersistence eventDetailImagePersistence) {
		this.eventDetailImagePersistence = eventDetailImagePersistence;
	}

	/**
	 * Returns the event type local service.
	 *
	 * @return the event type local service
	 */
	public com.rumbasolutions.flask.service.EventTypeLocalService getEventTypeLocalService() {
		return eventTypeLocalService;
	}

	/**
	 * Sets the event type local service.
	 *
	 * @param eventTypeLocalService the event type local service
	 */
	public void setEventTypeLocalService(
		com.rumbasolutions.flask.service.EventTypeLocalService eventTypeLocalService) {
		this.eventTypeLocalService = eventTypeLocalService;
	}

	/**
	 * Returns the event type remote service.
	 *
	 * @return the event type remote service
	 */
	public com.rumbasolutions.flask.service.EventTypeService getEventTypeService() {
		return eventTypeService;
	}

	/**
	 * Sets the event type remote service.
	 *
	 * @param eventTypeService the event type remote service
	 */
	public void setEventTypeService(
		com.rumbasolutions.flask.service.EventTypeService eventTypeService) {
		this.eventTypeService = eventTypeService;
	}

	/**
	 * Returns the event type persistence.
	 *
	 * @return the event type persistence
	 */
	public EventTypePersistence getEventTypePersistence() {
		return eventTypePersistence;
	}

	/**
	 * Sets the event type persistence.
	 *
	 * @param eventTypePersistence the event type persistence
	 */
	public void setEventTypePersistence(
		EventTypePersistence eventTypePersistence) {
		this.eventTypePersistence = eventTypePersistence;
	}

	/**
	 * Returns the info type local service.
	 *
	 * @return the info type local service
	 */
	public com.rumbasolutions.flask.service.InfoTypeLocalService getInfoTypeLocalService() {
		return infoTypeLocalService;
	}

	/**
	 * Sets the info type local service.
	 *
	 * @param infoTypeLocalService the info type local service
	 */
	public void setInfoTypeLocalService(
		com.rumbasolutions.flask.service.InfoTypeLocalService infoTypeLocalService) {
		this.infoTypeLocalService = infoTypeLocalService;
	}

	/**
	 * Returns the info type remote service.
	 *
	 * @return the info type remote service
	 */
	public com.rumbasolutions.flask.service.InfoTypeService getInfoTypeService() {
		return infoTypeService;
	}

	/**
	 * Sets the info type remote service.
	 *
	 * @param infoTypeService the info type remote service
	 */
	public void setInfoTypeService(
		com.rumbasolutions.flask.service.InfoTypeService infoTypeService) {
		this.infoTypeService = infoTypeService;
	}

	/**
	 * Returns the info type persistence.
	 *
	 * @return the info type persistence
	 */
	public InfoTypePersistence getInfoTypePersistence() {
		return infoTypePersistence;
	}

	/**
	 * Sets the info type persistence.
	 *
	 * @param infoTypePersistence the info type persistence
	 */
	public void setInfoTypePersistence(InfoTypePersistence infoTypePersistence) {
		this.infoTypePersistence = infoTypePersistence;
	}

	/**
	 * Returns the info type category local service.
	 *
	 * @return the info type category local service
	 */
	public com.rumbasolutions.flask.service.InfoTypeCategoryLocalService getInfoTypeCategoryLocalService() {
		return infoTypeCategoryLocalService;
	}

	/**
	 * Sets the info type category local service.
	 *
	 * @param infoTypeCategoryLocalService the info type category local service
	 */
	public void setInfoTypeCategoryLocalService(
		com.rumbasolutions.flask.service.InfoTypeCategoryLocalService infoTypeCategoryLocalService) {
		this.infoTypeCategoryLocalService = infoTypeCategoryLocalService;
	}

	/**
	 * Returns the info type category remote service.
	 *
	 * @return the info type category remote service
	 */
	public com.rumbasolutions.flask.service.InfoTypeCategoryService getInfoTypeCategoryService() {
		return infoTypeCategoryService;
	}

	/**
	 * Sets the info type category remote service.
	 *
	 * @param infoTypeCategoryService the info type category remote service
	 */
	public void setInfoTypeCategoryService(
		com.rumbasolutions.flask.service.InfoTypeCategoryService infoTypeCategoryService) {
		this.infoTypeCategoryService = infoTypeCategoryService;
	}

	/**
	 * Returns the info type category persistence.
	 *
	 * @return the info type category persistence
	 */
	public InfoTypeCategoryPersistence getInfoTypeCategoryPersistence() {
		return infoTypeCategoryPersistence;
	}

	/**
	 * Sets the info type category persistence.
	 *
	 * @param infoTypeCategoryPersistence the info type category persistence
	 */
	public void setInfoTypeCategoryPersistence(
		InfoTypeCategoryPersistence infoTypeCategoryPersistence) {
		this.infoTypeCategoryPersistence = infoTypeCategoryPersistence;
	}

	/**
	 * Returns the venue local service.
	 *
	 * @return the venue local service
	 */
	public com.rumbasolutions.flask.service.VenueLocalService getVenueLocalService() {
		return venueLocalService;
	}

	/**
	 * Sets the venue local service.
	 *
	 * @param venueLocalService the venue local service
	 */
	public void setVenueLocalService(
		com.rumbasolutions.flask.service.VenueLocalService venueLocalService) {
		this.venueLocalService = venueLocalService;
	}

	/**
	 * Returns the venue remote service.
	 *
	 * @return the venue remote service
	 */
	public com.rumbasolutions.flask.service.VenueService getVenueService() {
		return venueService;
	}

	/**
	 * Sets the venue remote service.
	 *
	 * @param venueService the venue remote service
	 */
	public void setVenueService(
		com.rumbasolutions.flask.service.VenueService venueService) {
		this.venueService = venueService;
	}

	/**
	 * Returns the venue persistence.
	 *
	 * @return the venue persistence
	 */
	public VenuePersistence getVenuePersistence() {
		return venuePersistence;
	}

	/**
	 * Sets the venue persistence.
	 *
	 * @param venuePersistence the venue persistence
	 */
	public void setVenuePersistence(VenuePersistence venuePersistence) {
		this.venuePersistence = venuePersistence;
	}

	/**
	 * Returns the venue detail local service.
	 *
	 * @return the venue detail local service
	 */
	public com.rumbasolutions.flask.service.VenueDetailLocalService getVenueDetailLocalService() {
		return venueDetailLocalService;
	}

	/**
	 * Sets the venue detail local service.
	 *
	 * @param venueDetailLocalService the venue detail local service
	 */
	public void setVenueDetailLocalService(
		com.rumbasolutions.flask.service.VenueDetailLocalService venueDetailLocalService) {
		this.venueDetailLocalService = venueDetailLocalService;
	}

	/**
	 * Returns the venue detail remote service.
	 *
	 * @return the venue detail remote service
	 */
	public com.rumbasolutions.flask.service.VenueDetailService getVenueDetailService() {
		return venueDetailService;
	}

	/**
	 * Sets the venue detail remote service.
	 *
	 * @param venueDetailService the venue detail remote service
	 */
	public void setVenueDetailService(
		com.rumbasolutions.flask.service.VenueDetailService venueDetailService) {
		this.venueDetailService = venueDetailService;
	}

	/**
	 * Returns the venue detail persistence.
	 *
	 * @return the venue detail persistence
	 */
	public VenueDetailPersistence getVenueDetailPersistence() {
		return venueDetailPersistence;
	}

	/**
	 * Sets the venue detail persistence.
	 *
	 * @param venueDetailPersistence the venue detail persistence
	 */
	public void setVenueDetailPersistence(
		VenueDetailPersistence venueDetailPersistence) {
		this.venueDetailPersistence = venueDetailPersistence;
	}

	/**
	 * Returns the venue detail image local service.
	 *
	 * @return the venue detail image local service
	 */
	public com.rumbasolutions.flask.service.VenueDetailImageLocalService getVenueDetailImageLocalService() {
		return venueDetailImageLocalService;
	}

	/**
	 * Sets the venue detail image local service.
	 *
	 * @param venueDetailImageLocalService the venue detail image local service
	 */
	public void setVenueDetailImageLocalService(
		com.rumbasolutions.flask.service.VenueDetailImageLocalService venueDetailImageLocalService) {
		this.venueDetailImageLocalService = venueDetailImageLocalService;
	}

	/**
	 * Returns the venue detail image remote service.
	 *
	 * @return the venue detail image remote service
	 */
	public com.rumbasolutions.flask.service.VenueDetailImageService getVenueDetailImageService() {
		return venueDetailImageService;
	}

	/**
	 * Sets the venue detail image remote service.
	 *
	 * @param venueDetailImageService the venue detail image remote service
	 */
	public void setVenueDetailImageService(
		com.rumbasolutions.flask.service.VenueDetailImageService venueDetailImageService) {
		this.venueDetailImageService = venueDetailImageService;
	}

	/**
	 * Returns the venue detail image persistence.
	 *
	 * @return the venue detail image persistence
	 */
	public VenueDetailImagePersistence getVenueDetailImagePersistence() {
		return venueDetailImagePersistence;
	}

	/**
	 * Sets the venue detail image persistence.
	 *
	 * @param venueDetailImagePersistence the venue detail image persistence
	 */
	public void setVenueDetailImagePersistence(
		VenueDetailImagePersistence venueDetailImagePersistence) {
		this.venueDetailImagePersistence = venueDetailImagePersistence;
	}

	/**
	 * Returns the venue image local service.
	 *
	 * @return the venue image local service
	 */
	public com.rumbasolutions.flask.service.VenueImageLocalService getVenueImageLocalService() {
		return venueImageLocalService;
	}

	/**
	 * Sets the venue image local service.
	 *
	 * @param venueImageLocalService the venue image local service
	 */
	public void setVenueImageLocalService(
		com.rumbasolutions.flask.service.VenueImageLocalService venueImageLocalService) {
		this.venueImageLocalService = venueImageLocalService;
	}

	/**
	 * Returns the venue image remote service.
	 *
	 * @return the venue image remote service
	 */
	public com.rumbasolutions.flask.service.VenueImageService getVenueImageService() {
		return venueImageService;
	}

	/**
	 * Sets the venue image remote service.
	 *
	 * @param venueImageService the venue image remote service
	 */
	public void setVenueImageService(
		com.rumbasolutions.flask.service.VenueImageService venueImageService) {
		this.venueImageService = venueImageService;
	}

	/**
	 * Returns the venue image persistence.
	 *
	 * @return the venue image persistence
	 */
	public VenueImagePersistence getVenueImagePersistence() {
		return venueImagePersistence;
	}

	/**
	 * Sets the venue image persistence.
	 *
	 * @param venueImagePersistence the venue image persistence
	 */
	public void setVenueImagePersistence(
		VenueImagePersistence venueImagePersistence) {
		this.venueImagePersistence = venueImagePersistence;
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

		PersistedModelLocalServiceRegistryUtil.register("com.rumbasolutions.flask.model.EventDetailImage",
			eventDetailImageLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.rumbasolutions.flask.model.EventDetailImage");
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
		return EventDetailImage.class;
	}

	protected String getModelClassName() {
		return EventDetailImage.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = eventDetailImagePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rumbasolutions.flask.service.EventLocalService.class)
	protected com.rumbasolutions.flask.service.EventLocalService eventLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.EventService.class)
	protected com.rumbasolutions.flask.service.EventService eventService;
	@BeanReference(type = EventPersistence.class)
	protected EventPersistence eventPersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.EventDetailLocalService.class)
	protected com.rumbasolutions.flask.service.EventDetailLocalService eventDetailLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.EventDetailService.class)
	protected com.rumbasolutions.flask.service.EventDetailService eventDetailService;
	@BeanReference(type = EventDetailPersistence.class)
	protected EventDetailPersistence eventDetailPersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.EventDetailImageLocalService.class)
	protected com.rumbasolutions.flask.service.EventDetailImageLocalService eventDetailImageLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.EventDetailImageService.class)
	protected com.rumbasolutions.flask.service.EventDetailImageService eventDetailImageService;
	@BeanReference(type = EventDetailImagePersistence.class)
	protected EventDetailImagePersistence eventDetailImagePersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.EventTypeLocalService.class)
	protected com.rumbasolutions.flask.service.EventTypeLocalService eventTypeLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.EventTypeService.class)
	protected com.rumbasolutions.flask.service.EventTypeService eventTypeService;
	@BeanReference(type = EventTypePersistence.class)
	protected EventTypePersistence eventTypePersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.InfoTypeLocalService.class)
	protected com.rumbasolutions.flask.service.InfoTypeLocalService infoTypeLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.InfoTypeService.class)
	protected com.rumbasolutions.flask.service.InfoTypeService infoTypeService;
	@BeanReference(type = InfoTypePersistence.class)
	protected InfoTypePersistence infoTypePersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.InfoTypeCategoryLocalService.class)
	protected com.rumbasolutions.flask.service.InfoTypeCategoryLocalService infoTypeCategoryLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.InfoTypeCategoryService.class)
	protected com.rumbasolutions.flask.service.InfoTypeCategoryService infoTypeCategoryService;
	@BeanReference(type = InfoTypeCategoryPersistence.class)
	protected InfoTypeCategoryPersistence infoTypeCategoryPersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.VenueLocalService.class)
	protected com.rumbasolutions.flask.service.VenueLocalService venueLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.VenueService.class)
	protected com.rumbasolutions.flask.service.VenueService venueService;
	@BeanReference(type = VenuePersistence.class)
	protected VenuePersistence venuePersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.VenueDetailLocalService.class)
	protected com.rumbasolutions.flask.service.VenueDetailLocalService venueDetailLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.VenueDetailService.class)
	protected com.rumbasolutions.flask.service.VenueDetailService venueDetailService;
	@BeanReference(type = VenueDetailPersistence.class)
	protected VenueDetailPersistence venueDetailPersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.VenueDetailImageLocalService.class)
	protected com.rumbasolutions.flask.service.VenueDetailImageLocalService venueDetailImageLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.VenueDetailImageService.class)
	protected com.rumbasolutions.flask.service.VenueDetailImageService venueDetailImageService;
	@BeanReference(type = VenueDetailImagePersistence.class)
	protected VenueDetailImagePersistence venueDetailImagePersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.VenueImageLocalService.class)
	protected com.rumbasolutions.flask.service.VenueImageLocalService venueImageLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.VenueImageService.class)
	protected com.rumbasolutions.flask.service.VenueImageService venueImageService;
	@BeanReference(type = VenueImagePersistence.class)
	protected VenueImagePersistence venueImagePersistence;
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
	private EventDetailImageLocalServiceClpInvoker _clpInvoker = new EventDetailImageLocalServiceClpInvoker();
}