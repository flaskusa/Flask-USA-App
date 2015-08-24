package com.rumbasolutions.flask.email.util;

import javax.mail.internet.InternetAddress;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.ContentUtil;

public class EmailInvitationUtil {
	private static Log LOGGER = LogFactoryUtil.getLog(EmailInvitationUtil.class);
	
	public static void sendEmailInvitation(String name, String toMail, String description, ServiceContext serviceContext){
		try {
			String fromEmail = UserLocalServiceUtil.getUser(serviceContext.getUserId()).getEmailAddress();
			InternetAddress fromAddress = new InternetAddress(fromEmail); // from address
	        InternetAddress toAddress = new InternetAddress(toMail);  // to address

	        String body = ContentUtil.get("/template/emailTemplate.tmpl", true);  // email body , here we are getting email structure creating the content folder in the src and create the file with the extension as tmpl.
	        String subject = "Inviation"; // email subject
	                
	                body = StringUtil.replace(body, new String []{"[$NAME$]","[$DESC$]"}, new String []{name,description}); // replacing the body with our content.

	                MailMessage mailMessage = new MailMessage();
	                mailMessage.setTo(toAddress);
	                mailMessage.setFrom(fromAddress);
	                mailMessage.setSubject(subject);
	                mailMessage.setBody(body);
	                mailMessage.setHTMLFormat(true);
	                
	                MailServiceUtil.sendEmail(mailMessage); // Sending message

		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error(" Error in sending Email Invitation : " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
