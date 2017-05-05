package com.rumbasolutions.flask.service.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.rumbasolutions.flask.model.AdCampaign;
public class AdCampaignFinderImpl extends BasePersistenceImpl<AdCampaign> implements AdCampaignFinder {
	
	private static Log LOGGER = LogFactoryUtil.getLog(AdCampaignFinderImpl.class);

	@Override
	public List getAdCampaginList(){
		Session session = null;
		List campaignList = null;
		try{
			session = openSession();
			StringBuilder sb = new StringBuilder();
			String sqlSelect = "  select campaignId, campaignName,  flaskads_AdCustomer.customerId, " +
						" flaskads_AdCustomer.customerName, displayGeneral, displayPreEvent, " +
						" displayDuringEvent, displayPostEvent, showAlways, eventTypeId, frequencyPerHour, " +
						"CONCAT_WS(', ', IF(displayGeneral=1, 'General',null) , IF(displayPreEvent=1, 'Pre-Event',null) ," + 
						"IF(displayDuringEvent = 1, 'During-Event',null) , IF(displayPostEvent = 1, 'Post-Event', null)) " +
						" as 'adDisplayTime', flaskads_AdCampaign.imageTitle, flaskads_AdCampaign.imageDesc, "
						+ "flaskads_AdCampaign.imageUUID, flaskads_AdCampaign.imageGroupId";
			String sqlFrom = "  from flaskads_AdCampaign inner join flaskads_AdCustomer " + 
							" on flaskads_AdCustomer.customerId = flaskads_AdCampaign.customerId ";
			
			sb.append(sqlSelect);
			sb.append(sqlFrom);

			sb.append(" LIMIT 1000 ");
			SQLQuery queryObj = session.createSQLQuery(sb.toString());
			queryObj.addScalar("campaignId", Type.LONG);
			queryObj.addScalar("campaignName", Type.STRING);
			queryObj.addScalar("customerId", Type.LONG);
			queryObj.addScalar("customerName", Type.STRING);
			queryObj.addScalar("displayGeneral", Type.BOOLEAN);
			queryObj.addScalar("displayPreEvent", Type.BOOLEAN);
			queryObj.addScalar("displayDuringEvent", Type.BOOLEAN);
			queryObj.addScalar("displayPostEvent", Type.BOOLEAN);
			queryObj.addScalar("showAlways", Type.BOOLEAN);
			queryObj.addScalar("eventTypeId", Type.LONG);
			queryObj.addScalar("frequencyPerHour", Type.LONG);
			queryObj.addScalar("adDisplayTime", Type.STRING);
			
			queryObj.addScalar("imageTitle", Type.STRING);
			queryObj.addScalar("imageDesc", Type.STRING);
			queryObj.addScalar("imageUUID", Type.STRING);
			queryObj.addScalar("imageGroupId", Type.LONG);


			queryObj.setCacheable(true);
			QueryPos qPosition = QueryPos.getInstance(queryObj);

			campaignList = queryObj.list();
		}catch(Exception e)
		{
			LOGGER.error("Exception in getAdCampaginList : "+ e.getMessage());
		}finally{
			closeSession(session);
		}
		return campaignList;
	}
	
	@Override
	public List getCampaignDetailsForEvents(String eventList){
		Session session = null;
		List campaignList = null;
		eventList = eventList.trim();
		if(eventList.isEmpty())  return null;
		
		try{
			session = openSession();
			StringBuilder sb = new StringBuilder();
			String sqlSelect = "select distinct fac.campaignId, fac.campaignName, customerName, addrLine1,"
								+ " addrLine2, city, Region.regionCode 'State', zipCode, "
								+ " email, websiteURL 'url', businessPhoneNumber 'phone', "					
								+ " fac.imageTitle 'fullScreenTitle',"
								+ " fac.imageDesc 'fullScreenDesc', fac.imageGroupId 'fullScreenGroupId', "
								+ " fac.imageUUID 'fullScreenUUID', fac.frequencyPerHour, fci.imageTitle, "
								+ " fci.imageDesc, fci.imageGroupId, fci.imageUUID ";
			
			String sqlFrom = " from flaskads_CampaignEvent  fce "
					+ " inner join  flaskads_AdCampaign fac on  fce.campaignId = fac.campaignId "
					+ " inner join flaskevents_Event fe on fe.eventId = fce.eventId "
					+ " inner join flaskads_CampaignImage fci on fci.campaignId = fac.campaignId"
					+ "	inner join flaskads_AdCustomer on flaskads_AdCustomer.customerId = fac.customerId"
					+ " inner join Region on Region.regionId = flaskads_AdCustomer.stateId"; 
			
			String sqlWhere = " where fce.eventId in ( " + eventList + ")" ;
			
			sb.append(sqlSelect);
			sb.append(sqlFrom);
			
			if(!eventList.isEmpty()){
				sb.append(sqlWhere);
			}

			sb.append(" LIMIT 1000 ");
			SQLQuery queryObj = session.createSQLQuery(sb.toString());
			queryObj.addScalar("campaignId", Type.LONG);
			queryObj.addScalar("campaignName", Type.STRING);
			queryObj.addScalar("fullScreenTitle", Type.STRING);
			queryObj.addScalar("fullScreenDesc", Type.STRING);
			queryObj.addScalar("fullScreenGroupId", Type.LONG);
			queryObj.addScalar("fullScreenUUID", Type.STRING);
			queryObj.addScalar("frequencyPerHour", Type.LONG);
			queryObj.addScalar("imageTitle", Type.STRING);
			queryObj.addScalar("imageDesc", Type.STRING);
			queryObj.addScalar("imageGroupId", Type.LONG);
			queryObj.addScalar("imageUUID", Type.STRING);
			queryObj.addScalar("customerName", Type.STRING);
			queryObj.addScalar("addrLine1", Type.STRING);
			queryObj.addScalar("addrLine2", Type.STRING);
			queryObj.addScalar("city", Type.STRING);
			queryObj.addScalar("State", Type.STRING);
			queryObj.addScalar("zipCode", Type.STRING);
			queryObj.addScalar("email", Type.STRING);
			queryObj.addScalar("url", Type.STRING);
			queryObj.addScalar("phone", Type.STRING);			


			queryObj.setCacheable(true);
			QueryPos qPosition = QueryPos.getInstance(queryObj);

			campaignList = queryObj.list();
		}catch(Exception e)
		{
			LOGGER.error("Exception in getAdCampaginList : "+ e.getMessage());
		}finally{
			closeSession(session);
		}
		return campaignList;
	}	
}
