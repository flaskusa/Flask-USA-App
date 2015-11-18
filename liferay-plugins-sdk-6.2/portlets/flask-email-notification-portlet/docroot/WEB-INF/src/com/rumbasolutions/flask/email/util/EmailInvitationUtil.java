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
	private static String DEFAULT_EMAIL = "info@flaskus.com";
	private static String DEFAULT_SUBJECT = "FlaskUS Invitation";
	
	public static void sendEmailInvitation(String name, String toMail, String description, ServiceContext serviceContext){
		try {
			String fromEmail = UserLocalServiceUtil.getUser(serviceContext.getUserId()).getEmailAddress();
			InternetAddress fromAddress = new InternetAddress(DEFAULT_EMAIL); // from address
	        InternetAddress toAddress = new InternetAddress(toMail);  // to address

	        String body = ContentUtil.get("/template/emailTemplate.tmpl", true);  // email body , here we are getting email structure creating the content folder in the src and create the file with the extension as tmpl.
	        String subject = "Inviation"; // email subject
	                
	                body = StringUtil.replace(body, new String []{"[$NAME$]","[$DESC$]"}, new String []{name,description}); // replacing the body with our content.

	                MailMessage mailMessage = new MailMessage();
	                mailMessage.setTo(toAddress);
	                mailMessage.setFrom(fromAddress);
	                mailMessage.setSubject(DEFAULT_SUBJECT);
	                mailMessage.setBody(body);
	                mailMessage.setHTMLFormat(true);
	                
	                MailServiceUtil.sendEmail(mailMessage); // Sending message

		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error(" Error in sending Email Invitation : " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public static void emailReply(String name, String toMail, String mobile, String comment, ServiceContext serviceContext){
		try {
			InternetAddress fromAddress = new InternetAddress("info@flaskus.com"); // from address
	        InternetAddress toAddress = new InternetAddress(toMail);  // to address

	        String body = ContentUtil.get("/template/replyEmailTemplate.tmpl", true);  // email body , here we are getting email structure creating the content folder in the src and create the file with the extension as tmpl.
	        String subject = "Thank You"; // email subject
	                
	                body = StringUtil.replace(body, new String []{"[$NAME$]","[$DESC$]"}, new String []{name,comment}); // replacing the body with our content.

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
	
	public static void emailToFlask(String name, String fromEmail, String mobile, String comment, ServiceContext serviceContext){
		try {
			InternetAddress fromAddress = new InternetAddress(fromEmail); // from address
	        InternetAddress toAddress = new InternetAddress("info@flaskus.com");  // to address

	        String body = ContentUtil.get("/template/replyFlaskEmailTemplate.tmpl", true);  // email body , here we are getting email structure creating the content folder in the src and create the file with the extension as tmpl.
	        String subject = "Comment"; // email subject
	                
	                body = StringUtil.replace(body, new String []{"[$NAME$]","[$EMAIL$]","[$MOBILE$]","[$COMMENT$]"}, new String []{name,fromEmail,mobile,comment}); // replacing the body with our content.

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
	
	public static void emailAskUs(String fromMail, String subject, String description, ServiceContext serviceContext){
		try {
			InternetAddress fromAddress = new InternetAddress(fromMail);
	        InternetAddress toAddress = new InternetAddress("info@flaskus.com");  // to address

	        String body = ContentUtil.get("/template/emailAskUsTemplate.tmpl", true);  // email body , here we are getting email structure creating the content folder in the src and create the file with the extension as tmpl.
	                
	                body = StringUtil.replace(body, new String []{"[$SUBJECT$]","[$DESC$]"}, new String []{subject,description}); // replacing the body with our content.
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
