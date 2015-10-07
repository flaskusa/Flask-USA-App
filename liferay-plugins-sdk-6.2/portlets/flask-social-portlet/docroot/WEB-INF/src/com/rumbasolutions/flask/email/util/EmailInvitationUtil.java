package com.rumbasolutions.flask.email.util;

import javax.mail.internet.InternetAddress;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.util.ContentUtil;

public class EmailInvitationUtil {
	private static Log LOGGER = LogFactoryUtil.getLog(EmailInvitationUtil.class);
	
	public static void emailMessage(String name, String fromEmail, String toEmail, String message, ServiceContext serviceContext){
		try {
			InternetAddress fromAddress = new InternetAddress(fromEmail); // from address
	        InternetAddress toAddress = new InternetAddress(toEmail);  // to address

	        String body = ContentUtil.get("/template/messageEmailTemplate.tmpl", true);  // email body , here we are getting email structure creating the content folder in the src and create the file with the extension as tmpl.
	        String subject = "Flask Message from "+name; // email subject
	                
	                body = StringUtil.replace(body, new String []{"[$NAME$]","[$MESSAGE$]"}, new String []{name, message}); // replacing the body with our content.

	                MailMessage mailMessage = new MailMessage();
	                mailMessage.setTo(toAddress);
	                mailMessage.setFrom(fromAddress);
	                mailMessage.setSubject(subject);
	                mailMessage.setBody(body);
	                mailMessage.setHTMLFormat(true);
	                MailServiceUtil.sendEmail(mailMessage); // Sending message
	                System.out.println("msg sent");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error(" Error in sending Email Invitation : " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
