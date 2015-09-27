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
import com.rumbasolutions.flask.model.TailgateInfo;
import com.rumbasolutions.flask.model.impl.TailgateInfoImpl;

public class TailgateInfoFinderImpl extends BasePersistenceImpl<TailgateInfo> implements TailgateInfoFinder {
	private static Log LOGGER = LogFactoryUtil.getLog(TailgateInfoFinderImpl.class);

	@Override
	public List getAllMyTailgate(long userId){
		Session session = null;
		List groupList = null;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get("getMyAllTailgate");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.setCacheable(true);
			queryObj.addScalar("tailgateId", Type.LONG);
			queryObj.addScalar("tailgateName", Type.STRING);
			queryObj.addScalar("tailgateDescription", Type.STRING);
			queryObj.addScalar("eventId", Type.LONG);
			queryObj.addScalar("eventName", Type.STRING);
			queryObj.addScalar("tailgateDate", Type.DATE);
			queryObj.addScalar("startTime", Type.LONG);
			queryObj.addScalar("endTime", Type.LONG);
			queryObj.addScalar("isActive", Type.INTEGER);
			queryObj.addScalar("isDelete", Type.INTEGER);
			queryObj.addScalar("venmoAccountId", Type.STRING);
			queryObj.addScalar("amountToPay", Type.DOUBLE);
			queryObj.addScalar("isAdmin", Type.INTEGER);
			QueryPos qPosition = QueryPos.getInstance(queryObj);
			qPosition.add(userId);
			groupList = createCustomModelGroupList(queryObj.list());
		}catch(Exception e)
		{
			LOGGER.error("Exception in get All My Tailgate : "+ e.getMessage());
			e.printStackTrace();
		}finally{
			closeSession(session);
		}
		return groupList;
	}
	
	/*
	 * Utility method
	 */
	private List createCustomModelGroupList(List list){
		String serilizeString = null;
		JSONArray groupJsonArray = null;
		Map<String, String> groupMap = null;
		List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
		try{
		for (Object ob : list) {
			serilizeString = JSONFactoryUtil.serialize(ob);
			
			groupJsonArray = JSONFactoryUtil.createJSONArray(serilizeString);
			groupMap = new HashMap<String, String>();
			groupMap.put("tailgateId", groupJsonArray.getString(0));
			groupMap.put("tailgateName", groupJsonArray.getString(1));
			groupMap.put("tailgateDescription", groupJsonArray.getString(2));
			groupMap.put("eventId", groupJsonArray.getString(3));
			groupMap.put("eventName", groupJsonArray.getString(4));
			groupMap.put("tailgateDate",groupJsonArray.getJSONObject(5).getString("time"));
			groupMap.put("startTime", groupJsonArray.getString(6));
			groupMap.put("endTime", groupJsonArray.getString(7));
			groupMap.put("isActive", groupJsonArray.getString(8));
			groupMap.put("isDelete", groupJsonArray.getString(9));
			groupMap.put("venmoAccountId", groupJsonArray.getString(10));
			groupMap.put("amountToPay", groupJsonArray.getString(11));
			groupMap.put("isAdmin", groupJsonArray.getString(12));
			mapList.add(groupMap);
		}
		}catch(JSONException e){
			LOGGER.error("Exception in createCustomModelList for My Tailgate "
					+ e.getMessage());
		}
		return mapList;
	}
	@Override
	public int deleteTailgate(long tailgateId){
		Session session = null;
		int res = 0;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get("deleteGroup");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.setCacheable(false);
			queryObj.addEntity("TailgateInfo", TailgateInfoImpl.class);
			QueryPos qPosition = QueryPos.getInstance(queryObj);
			qPosition.add(tailgateId);
			res = queryObj.executeUpdate();
		}catch(Exception e){
			LOGGER.error("Exception in delete Tailgate : "+ e.getMessage());
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public int deleteTailgates(String tailgateIds){
		Session session = null;
		int res = 0;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get("deleteGroups");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.setCacheable(false);
			queryObj.addEntity("TailgateInfo", TailgateInfoImpl.class);
			QueryPos qPosition = QueryPos.getInstance(queryObj);
			qPosition.add(tailgateIds);
			res = queryObj.executeUpdate();
		}catch(Exception e){
			LOGGER.error("Exception in delete Tailgates : "+ e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

}
