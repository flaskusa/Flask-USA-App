package com.rumbasolutions.flask.email.util;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreatePlatformEndpointRequest;
import com.amazonaws.services.sns.model.PublishRequest;
import com.liferay.portal.kernel.util.PropsUtil;

public class SnsUtil {

	@SuppressWarnings("deprecation")
	public static boolean sendSnsEmail(String subject, String message){
		boolean mailSent = false;
		try {
			PublishRequest req = new PublishRequest(PropsUtil.get("flask.push.arn"), message, subject);
			AWSCredentials cred = new BasicAWSCredentials(PropsUtil.get("flask.push.accessKey"), PropsUtil.get("flask.push.secretKey"));
			AmazonSNSClient client = new AmazonSNSClient(cred);
			
			req.setRequestCredentials(cred);
			client.publish(req);
			mailSent = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mailSent;
	}
}
