package com.rumbasolutions.flask.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.rumbasolutions.flask.model.Event;
import com.rumbasolutions.flask.model.Venue;
import com.rumbasolutions.flask.service.persistence.VenueUtil;


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
	public static List<Event> setVenueName(List<Event> eventList){
		
		
		for (Event event : eventList){
			
			try {
				Venue venue = VenueUtil.fetchByPrimaryKey(event.getVenueId());
				event.setVenueName(venue.getVenueName());
			}
			catch (SystemException e) {
				LOGGER.error(e);
				e.printStackTrace();
			}
		}
		
		return eventList;
		
	}
	

}
