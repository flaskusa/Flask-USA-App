package com.rumbasolutions.flask.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class FlaskUtil {
	
	private static Log LOGGER = LogFactoryUtil.getLog(FlaskUtil.class);

	
	public static Calendar parseDate(String dateVal){
		Calendar cal = Calendar.getInstance();
		Date dt =null;
		String[] validFormats = {"MM-dd-yyyy", "yyyy-MM-dd", "MM/dd/yyyy" };
		for(String format : validFormats ){
				SimpleDateFormat sf  =new SimpleDateFormat(format, Locale.US);
				try {
					dt= sf.parse(dateVal);
					LOGGER.debug(dt);
					LOGGER.debug(sf.format(dt));
					cal.setTime(dt);				
					return cal;
				}catch (Exception e) {
					
				}
		}	
		return cal;
	}
	
	public static Calendar parseTime(String timeVal){
		Calendar cal = Calendar.getInstance();
		Date dt =null;
		String[] validFormats = {"hh:mm a", "hh:mm"};
		for(String format : validFormats ){
				SimpleDateFormat sf  =new SimpleDateFormat(format, Locale.US);
				try {
					dt= sf.parse(timeVal);
					LOGGER.debug(dt);
					LOGGER.debug(sf.format(dt));
					cal.setTime(dt);				
					return cal;
				}catch (Exception e) {
					
				}
		}	
		return cal;
	}

}
