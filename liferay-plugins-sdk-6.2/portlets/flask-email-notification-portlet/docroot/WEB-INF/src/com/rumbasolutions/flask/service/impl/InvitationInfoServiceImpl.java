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

package com.rumbasolutions.flask.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.ServiceContext;
import com.rumbasolutions.flask.email.util.EmailInvitationUtil;
import com.rumbasolutions.flask.model.InvitationInfo;
import com.rumbasolutions.flask.service.InvitationInfoLocalServiceUtil;
import com.rumbasolutions.flask.service.base.InvitationInfoServiceBaseImpl;

/**
 * The implementation of the invitation info remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.InvitationInfoService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Tejas
 * @see com.rumbasolutions.flask.service.base.InvitationInfoServiceBaseImpl
 * @see com.rumbasolutions.flask.service.InvitationInfoServiceUtil
 */
public class InvitationInfoServiceImpl extends InvitationInfoServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.InvitationInfoServiceUtil} to access the invitation info remote service.
	 */
	private static Log LOGGER = LogFactoryUtil.getLog(InvitationInfoServiceImpl.class);
	
	@Override
	public void sendInivitation(String email, String name, String description, String invitedDate, ServiceContext serviceContext){
		InvitationInfo invitationInfo = null;
		try {
			invitationInfo = InvitationInfoLocalServiceUtil.createInvitationInfo(CounterLocalServiceUtil.increment());
			invitationInfo.setEmail(email);
			invitationInfo.setName(name);
			invitationInfo.setDescription(description);
			invitationInfo.setInvitedDate(invitedDate);
			
			invitationInfo = InvitationInfoLocalServiceUtil.addInvitationInfo(invitationInfo);
			//Send Email Invitation
			EmailInvitationUtil.sendEmailInvitation(name, email, description, serviceContext);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOGGER.error("Error in saving Invitation : "+ e.getMessage());
		}
		
	}
	
	@AccessControlled(guestAccessEnabled =true)
	@Override
	public void replyToFeedback(String name, String email, String mobile, String comment, ServiceContext serviceContext){
		InvitationInfo invitationInfo = null;
		try {
			//Send Email Invitation
			EmailInvitationUtil.emailReply(name, email, mobile, comment, serviceContext);
			EmailInvitationUtil.emailToFlask(name, email, mobile, comment, serviceContext);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOGGER.error("Error in saving Invitation : "+ e.getMessage());
		}
		
	}

}