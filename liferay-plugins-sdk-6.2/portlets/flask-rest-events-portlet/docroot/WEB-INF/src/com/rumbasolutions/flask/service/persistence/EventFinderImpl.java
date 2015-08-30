package com.rumbasolutions.flask.service.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.rumbasolutions.flask.model.Event;
import com.rumbasolutions.flask.model.impl.EventDetailImageImpl;
import com.rumbasolutions.flask.model.impl.EventDetailImpl;
import com.rumbasolutions.flask.model.impl.EventImpl;

public class EventFinderImpl extends BasePersistenceImpl<Event> implements EventFinder {
	
	private static Log LOGGER = LogFactoryUtil
			.getLog(EventFinderImpl.class);

	@Override
	public List<Event> getSimpleFilteredEvents(String eventTypeIds, String startDate, String endDate, String stringFilter, Map<String, Double> geoRange) {
		Session session = null;
		List eventsList = null;
		try {
			session = openSession();
			StringBuilder sbSql = new StringBuilder("SELECT eventId, eventName, description, eventDate, startTime, endTime,"
					   	+ " eventTypeId, eventTypeName, "
						+ " eventImageUUID, eventImageGroupId,"
						+ " ev.companyId,  ev.userId, ev.createdDate, ev.modifiedDate, " 
				        + " v.venueId, v.venueName, venueMetroArea, venueCity "
						+ " FROM flaskevents_event ev INNER JOIN flaskevents_venue v "
				        + " ON ev.venueId =  v.venueId ");
			
			List<String> criteria = new ArrayList<String>();
			
			if(Validator.isNotNull(eventTypeIds)){
				criteria.add("ev.eventTypeId in (?)");
			}
			if(Validator.isNotNull(startDate)){
				criteria.add("ev.eventDate >= ?");
			}
			if(Validator.isNotNull(endDate)){
				criteria.add("ev.eventDate <= ?");
			}
			if(Validator.isNotNull(stringFilter)){
				stringFilter = stringFilter.trim();
				String[] filterArr = stringFilter.split(" ");
				StringBuilder sb = new StringBuilder();
				
				for(int i=0; i < filterArr.length; i++){
					String sfClause = " (ev.eventName like ? "
								+ " OR ev.description like ?"
								+ " OR v.venueDescription like ?"
								+ " OR v.venueMetroArea like ?"
								+ " OR v.venueCity like ?)";
					criteria.add(sfClause);
				}
			}
		// ignore geo coordinates when using string search 
		if(stringFilter.isEmpty() && Validator.isNotNull(geoRange) && geoRange.size() == 4){
			String geoClause = " ( cast(v.latitude as DECIMAL(10,6) ) <= ? AND cast(v.latitude as DECIMAL(10,6) ) >= ? AND " + 
					   " ABS(cast(v.longitude as DECIMAL(10,6) )) <= ? AND ABS(cast(v.longitude as DECIMAL(10,6) )) >= ?) ";
			criteria.add(geoClause);

		}
			
		if (!criteria.isEmpty()) {
			 sbSql.append("WHERE ");
			 sbSql.append(criteria.remove(0) + " ");
                for (String criterion : criteria) {
                	sbSql.append(" AND "+ criterion);
                }
            }
		 
			SQLQuery queryObj = session.createSQLQuery(sbSql.toString());
			queryObj.setCacheable(false);
			
			queryObj.addEntity("Event", EventImpl.class);
			
			QueryPos qPosition = QueryPos.getInstance(queryObj);

			if(Validator.isNotNull(eventTypeIds)){
				qPosition.add(eventTypeIds);
			}
			if(Validator.isNotNull(startDate)){
				qPosition.add(startDate );
			}
			if(Validator.isNotNull(endDate)){
				qPosition.add(endDate);
			}
			if(Validator.isNotNull(stringFilter)){
				String[] filterArr = stringFilter.split(" ");
				for(String filterStr : filterArr){
					stringFilter ="%" + filterStr + "%";
					qPosition.add(stringFilter);
					qPosition.add(stringFilter);
					qPosition.add(stringFilter);
					qPosition.add(stringFilter);
					qPosition.add(stringFilter);
				}
			}
			// ignore geo coordinates when using string search
			if(stringFilter.isEmpty() && Validator.isNotNull(geoRange) && geoRange.size() == 4){
				qPosition.add(geoRange.get("latitudeNorth"));
				qPosition.add(geoRange.get("latitudeSouth"));
				qPosition.add(geoRange.get("longitudeEast"));
				qPosition.add(geoRange.get("longitudeWest"));
			}
			
			eventsList = (List)queryObj.list();
		} catch (Exception e) {
			LOGGER.error("Exception in get Group Users : " + e.getMessage());
		} finally {
			closeSession(session);
		}
		return eventsList;
	}
	
	

}
