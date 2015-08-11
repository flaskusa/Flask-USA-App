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
			String sql = CustomSQLUtil.get("getCampaignList");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.addScalar("campaignId", Type.LONG);
			queryObj.addScalar("campaignName", Type.STRING);
			queryObj.addScalar("customerId", Type.LONG);
			queryObj.addScalar("customerName", Type.STRING);
			queryObj.addScalar("eventTypeId", Type.LONG);
			queryObj.addScalar("eventTypeName", Type.STRING);
			queryObj.addScalar("eventDisplayTime", Type.STRING);
			queryObj.addScalar("frequencyPerHour", Type.LONG);


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
