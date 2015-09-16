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
			String sqlSelect = "  select campaignId, campaignName,  flaskads_adcustomer.customerId, " +
						" flaskads_adcustomer.customerName, displayGeneral, displayPreEvent, " +
						" displayDuringEvent, displayPostEvent, eventTypeId, frequencyPerHour, " +
						"CONCAT_WS(', ', IF(displayGeneral=1, 'General',null) , IF(displayPreEvent=1, 'Pre-Event',null) ," + 
						"IF(displayDuringEvent = 1, 'During-Event',null) , IF(displayPostEvent = 1, 'Post-Event', null)) " +
						" as 'adDisplayTime'";
			String sqlFrom = "  from flaskads_adcampaign inner join flaskads_adcustomer " + 
							" on flaskads_adcustomer.customerId = flaskads_adcampaign.customerId ";
			
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
			queryObj.addScalar("eventTypeId", Type.LONG);
			queryObj.addScalar("frequencyPerHour", Type.LONG);
			queryObj.addScalar("adDisplayTime", Type.STRING);

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
	private List createCustomModelCampaignList(List list){
		String serilizeString = null;
		JSONArray groupJsonArray = null;
		Map<String, String> groupMap = null;
		List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
		try{
		for (Object ob : list) {
			serilizeString = JSONFactoryUtil.serialize(ob);
			groupJsonArray = JSONFactoryUtil.createJSONArray(serilizeString);
			groupMap = new HashMap<String, String>();
			groupMap.put("campaignId", groupJsonArray.getString(0));
			groupMap.put("campaignName", groupJsonArray.getString(1));
			groupMap.put("customerId", groupJsonArray.getString(2));
			groupMap.put("customerName", groupJsonArray.getString(3));
			groupMap.put("displayGeneral", groupJsonArray.getString(4));
			groupMap.put("displayPreEvent", groupJsonArray.getString(5));
			groupMap.put("displayDuringEvent", groupJsonArray.getString(6));
			groupMap.put("displayPostEvent", groupJsonArray.getString(7));
			groupMap.put("eventTypeId", groupJsonArray.getString(8));
			groupMap.put("frequencyPerHour", groupJsonArray.getString(9));
			groupMap.put("adDisplayTime", groupJsonArray.getString(10));
			
			mapList.add(groupMap);
		}
		}catch(JSONException e){
			LOGGER.error("Exception in createCustomModelList for My Tailgate "
					+ e.getMessage());
		}
		return mapList;
	}
	
}
