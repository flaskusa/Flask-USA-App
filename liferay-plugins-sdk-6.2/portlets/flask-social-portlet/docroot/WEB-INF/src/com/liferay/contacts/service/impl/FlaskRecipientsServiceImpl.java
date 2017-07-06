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

package com.liferay.contacts.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.contacts.model.FlaskRecipients;
import com.liferay.contacts.service.FlaskRecipientsLocalServiceUtil;
import com.liferay.contacts.service.base.FlaskRecipientsServiceBaseImpl;
import com.liferay.contacts.service.persistence.FlaskRecipientsUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the flask recipients remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.contacts.service.FlaskRecipientsService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Kiran
 * @see com.liferay.contacts.service.base.FlaskRecipientsServiceBaseImpl
 * @see com.liferay.contacts.service.FlaskRecipientsServiceUtil
 */
public class FlaskRecipientsServiceImpl extends FlaskRecipientsServiceBaseImpl {
	
	
	@Override
	public FlaskRecipients addFlaskRecipient(long userId, long messageId, boolean read, ServiceContext serviceContext){
		FlaskRecipients flaskRecipients = null;
		try {
			User user = UserLocalServiceUtil.getUserById(userId);
			flaskRecipients = FlaskRecipientsLocalServiceUtil.createFlaskRecipients(CounterLocalServiceUtil.increment());
			flaskRecipients.setUserId(userId);
			flaskRecipients.setEmail(user.getEmailAddress());
			flaskRecipients.setMessageId(messageId);
			flaskRecipients.setRead(read);
			flaskRecipients.setSenderId(serviceContext.getUserId());
			flaskRecipients.setDeletedBy("");
			Date date = new Date();
			flaskRecipients.setReceivedDateTime(serviceContext.getCreateDate(date));
			flaskRecipients = FlaskRecipientsLocalServiceUtil.addFlaskRecipients(flaskRecipients);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flaskRecipients;
	}
	
	@Override
	 public boolean setRead(long messageId, ServiceContext serviceContext){
	  boolean ret = false;
	  try {
		   List<FlaskRecipients> flaskRecipients = FlaskRecipientsUtil.findBymessageId(messageId);
		   for(FlaskRecipients recp: flaskRecipients){
			   if((recp.getUserId() == serviceContext.getUserId()) && (recp.getRead() == false)){
				   ret = true;
				   recp.setRead(ret);
				   FlaskRecipientsLocalServiceUtil.updateFlaskRecipients(recp);
			   }
		   }
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	  return ret;
	 }
}