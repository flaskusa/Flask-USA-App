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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.rumbasolutions.flask.model.AdCampaign;
import com.rumbasolutions.flask.service.AdCampaignService;
import com.rumbasolutions.flask.service.persistence.AdCampaignPersistence;
import com.rumbasolutions.flask.service.persistence.AdCustomerPersistence;
import com.rumbasolutions.flask.service.persistence.CampaignEventPersistence;
import com.rumbasolutions.flask.service.persistence.CampaignImagePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the ad campaign remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.rumbasolutions.flask.service.impl.AdCampaignServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.rumbasolutions.flask.service.impl.AdCampaignServiceImpl
 * @see com.rumbasolutions.flask.service.AdCampaignServiceUtil
 * @generated
 */
public abstract class AdCampaignServiceBaseImpl extends BaseServiceImpl
	implements AdCampaignService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.rumbasolutions.flask.service.AdCampaignServiceUtil} to access the ad campaign remote service.
	 */

	/**
	 * Returns the ad campaign local service.
	 *
	 * @return the ad campaign local service
	 */
	public com.rumbasolutions.flask.service.AdCampaignLocalService getAdCampaignLocalService() {
		return adCampaignLocalService;
	}

	/**
	 * Sets the ad campaign local service.
	 *
	 * @param adCampaignLocalService the ad campaign local service
	 */
	public void setAdCampaignLocalService(
		com.rumbasolutions.flask.service.AdCampaignLocalService adCampaignLocalService) {
		this.adCampaignLocalService = adCampaignLocalService;
	}

	/**
	 * Returns the ad campaign remote service.
	 *
	 * @return the ad campaign remote service
	 */
	public com.rumbasolutions.flask.service.AdCampaignService getAdCampaignService() {
		return adCampaignService;
	}

	/**
	 * Sets the ad campaign remote service.
	 *
	 * @param adCampaignService the ad campaign remote service
	 */
	public void setAdCampaignService(
		com.rumbasolutions.flask.service.AdCampaignService adCampaignService) {
		this.adCampaignService = adCampaignService;
	}

	/**
	 * Returns the ad campaign persistence.
	 *
	 * @return the ad campaign persistence
	 */
	public AdCampaignPersistence getAdCampaignPersistence() {
		return adCampaignPersistence;
	}

	/**
	 * Sets the ad campaign persistence.
	 *
	 * @param adCampaignPersistence the ad campaign persistence
	 */
	public void setAdCampaignPersistence(
		AdCampaignPersistence adCampaignPersistence) {
		this.adCampaignPersistence = adCampaignPersistence;
	}

	/**
	 * Returns the ad customer local service.
	 *
	 * @return the ad customer local service
	 */
	public com.rumbasolutions.flask.service.AdCustomerLocalService getAdCustomerLocalService() {
		return adCustomerLocalService;
	}

	/**
	 * Sets the ad customer local service.
	 *
	 * @param adCustomerLocalService the ad customer local service
	 */
	public void setAdCustomerLocalService(
		com.rumbasolutions.flask.service.AdCustomerLocalService adCustomerLocalService) {
		this.adCustomerLocalService = adCustomerLocalService;
	}

	/**
	 * Returns the ad customer remote service.
	 *
	 * @return the ad customer remote service
	 */
	public com.rumbasolutions.flask.service.AdCustomerService getAdCustomerService() {
		return adCustomerService;
	}

	/**
	 * Sets the ad customer remote service.
	 *
	 * @param adCustomerService the ad customer remote service
	 */
	public void setAdCustomerService(
		com.rumbasolutions.flask.service.AdCustomerService adCustomerService) {
		this.adCustomerService = adCustomerService;
	}

	/**
	 * Returns the ad customer persistence.
	 *
	 * @return the ad customer persistence
	 */
	public AdCustomerPersistence getAdCustomerPersistence() {
		return adCustomerPersistence;
	}

	/**
	 * Sets the ad customer persistence.
	 *
	 * @param adCustomerPersistence the ad customer persistence
	 */
	public void setAdCustomerPersistence(
		AdCustomerPersistence adCustomerPersistence) {
		this.adCustomerPersistence = adCustomerPersistence;
	}

	/**
	 * Returns the campaign event local service.
	 *
	 * @return the campaign event local service
	 */
	public com.rumbasolutions.flask.service.CampaignEventLocalService getCampaignEventLocalService() {
		return campaignEventLocalService;
	}

	/**
	 * Sets the campaign event local service.
	 *
	 * @param campaignEventLocalService the campaign event local service
	 */
	public void setCampaignEventLocalService(
		com.rumbasolutions.flask.service.CampaignEventLocalService campaignEventLocalService) {
		this.campaignEventLocalService = campaignEventLocalService;
	}

	/**
	 * Returns the campaign event remote service.
	 *
	 * @return the campaign event remote service
	 */
	public com.rumbasolutions.flask.service.CampaignEventService getCampaignEventService() {
		return campaignEventService;
	}

	/**
	 * Sets the campaign event remote service.
	 *
	 * @param campaignEventService the campaign event remote service
	 */
	public void setCampaignEventService(
		com.rumbasolutions.flask.service.CampaignEventService campaignEventService) {
		this.campaignEventService = campaignEventService;
	}

	/**
	 * Returns the campaign event persistence.
	 *
	 * @return the campaign event persistence
	 */
	public CampaignEventPersistence getCampaignEventPersistence() {
		return campaignEventPersistence;
	}

	/**
	 * Sets the campaign event persistence.
	 *
	 * @param campaignEventPersistence the campaign event persistence
	 */
	public void setCampaignEventPersistence(
		CampaignEventPersistence campaignEventPersistence) {
		this.campaignEventPersistence = campaignEventPersistence;
	}

	/**
	 * Returns the campaign image local service.
	 *
	 * @return the campaign image local service
	 */
	public com.rumbasolutions.flask.service.CampaignImageLocalService getCampaignImageLocalService() {
		return campaignImageLocalService;
	}

	/**
	 * Sets the campaign image local service.
	 *
	 * @param campaignImageLocalService the campaign image local service
	 */
	public void setCampaignImageLocalService(
		com.rumbasolutions.flask.service.CampaignImageLocalService campaignImageLocalService) {
		this.campaignImageLocalService = campaignImageLocalService;
	}

	/**
	 * Returns the campaign image remote service.
	 *
	 * @return the campaign image remote service
	 */
	public com.rumbasolutions.flask.service.CampaignImageService getCampaignImageService() {
		return campaignImageService;
	}

	/**
	 * Sets the campaign image remote service.
	 *
	 * @param campaignImageService the campaign image remote service
	 */
	public void setCampaignImageService(
		com.rumbasolutions.flask.service.CampaignImageService campaignImageService) {
		this.campaignImageService = campaignImageService;
	}

	/**
	 * Returns the campaign image persistence.
	 *
	 * @return the campaign image persistence
	 */
	public CampaignImagePersistence getCampaignImagePersistence() {
		return campaignImagePersistence;
	}

	/**
	 * Sets the campaign image persistence.
	 *
	 * @param campaignImagePersistence the campaign image persistence
	 */
	public void setCampaignImagePersistence(
		CampaignImagePersistence campaignImagePersistence) {
		this.campaignImagePersistence = campaignImagePersistence;
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
	}

	public void destroy() {
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
		return AdCampaign.class;
	}

	protected String getModelClassName() {
		return AdCampaign.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = adCampaignPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.rumbasolutions.flask.service.AdCampaignLocalService.class)
	protected com.rumbasolutions.flask.service.AdCampaignLocalService adCampaignLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.AdCampaignService.class)
	protected com.rumbasolutions.flask.service.AdCampaignService adCampaignService;
	@BeanReference(type = AdCampaignPersistence.class)
	protected AdCampaignPersistence adCampaignPersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.AdCustomerLocalService.class)
	protected com.rumbasolutions.flask.service.AdCustomerLocalService adCustomerLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.AdCustomerService.class)
	protected com.rumbasolutions.flask.service.AdCustomerService adCustomerService;
	@BeanReference(type = AdCustomerPersistence.class)
	protected AdCustomerPersistence adCustomerPersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.CampaignEventLocalService.class)
	protected com.rumbasolutions.flask.service.CampaignEventLocalService campaignEventLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.CampaignEventService.class)
	protected com.rumbasolutions.flask.service.CampaignEventService campaignEventService;
	@BeanReference(type = CampaignEventPersistence.class)
	protected CampaignEventPersistence campaignEventPersistence;
	@BeanReference(type = com.rumbasolutions.flask.service.CampaignImageLocalService.class)
	protected com.rumbasolutions.flask.service.CampaignImageLocalService campaignImageLocalService;
	@BeanReference(type = com.rumbasolutions.flask.service.CampaignImageService.class)
	protected com.rumbasolutions.flask.service.CampaignImageService campaignImageService;
	@BeanReference(type = CampaignImagePersistence.class)
	protected CampaignImagePersistence campaignImagePersistence;
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
	private AdCampaignServiceClpInvoker _clpInvoker = new AdCampaignServiceClpInvoker();
}