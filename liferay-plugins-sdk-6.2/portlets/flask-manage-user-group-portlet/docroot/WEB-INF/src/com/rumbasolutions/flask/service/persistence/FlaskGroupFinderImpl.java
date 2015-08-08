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
import com.rumbasolutions.flask.model.FlaskGroup;
import com.rumbasolutions.flask.model.impl.FlaskGroupImpl;

public class FlaskGroupFinderImpl extends BasePersistenceImpl<FlaskGroup> implements FlaskGroupFinder {
	
	private static Log LOGGER = LogFactoryUtil.getLog(FlaskGroupFinderImpl.class);

	@Override
	public List<FlaskGroup> getGroupList(long userId, int isAdmin){
		Session session = null;
		List<FlaskGroup> groupList = null;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get("getGroupList");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.setCacheable(true);
			queryObj.addEntity("FlaskGroup", FlaskGroupImpl.class);
			QueryPos qPosition = QueryPos.getInstance(queryObj);
			qPosition.add(userId);
			qPosition.add(isAdmin);
			groupList = queryObj.list();
		}catch(Exception e)
		{
			LOGGER.error("Exception in get Group Users : "+ e.getMessage());
		}finally{
			closeSession(session);
		}
		return groupList;
	}
	
	@Override
	public List getAllMyGroups(long userId){
		Session session = null;
		List groupList = null;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get("getAllMyGroups");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.setCacheable(true);
			queryObj.addScalar("groupId", Type.LONG);
			queryObj.addScalar("groupName", Type.STRING);
			queryObj.addScalar("groupDescription", Type.STRING);
			queryObj.addScalar("createdDate", Type.STRING);
			queryObj.addScalar("createdBy", Type.STRING);
			queryObj.addScalar("isActive", Type.INTEGER);
			queryObj.addScalar("isDelete", Type.INTEGER);
			queryObj.addScalar("isAdmin", Type.INTEGER);
			QueryPos qPosition = QueryPos.getInstance(queryObj);
			qPosition.add(userId);
			groupList = createCustomModelGroupList(queryObj.list());
		}catch(Exception e)
		{
			LOGGER.error("Exception in get Group Users : "+ e.getMessage());
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
			groupMap.put("groupId", groupJsonArray.getString(0));
			groupMap.put("groupName", groupJsonArray.getString(1));
			groupMap.put("groupDescription", groupJsonArray.getString(2));
			groupMap.put("createdDate", groupJsonArray.getString(3));
			groupMap.put("createdBy", groupJsonArray.getString(4));
			groupMap.put("isActive", groupJsonArray.getString(5));
			groupMap.put("isDelete", groupJsonArray.getString(6));
			groupMap.put("isAdmin", groupJsonArray.getString(7));
			mapList.add(groupMap);
		}
		}catch(JSONException e){
			LOGGER.error("Exception in createCustomModelList for searchEvent "
					+ e.getMessage());
		}
		return mapList;
	}
	@Override
	public int deleteGroup(long groupId){
		Session session = null;
		int res = 0;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get("deleteGroup");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.setCacheable(false);
			queryObj.addEntity("FlaskGroup", FlaskGroupImpl.class);
			QueryPos qPosition = QueryPos.getInstance(queryObj);
			qPosition.add(groupId);
			res = queryObj.executeUpdate();
		}catch(Exception e){
			LOGGER.error("Exception in get Group Users : "+ e.getMessage());
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public int deleteGroups(String groupIds){
		Session session = null;
		int res = 0;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get("deleteGroups");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.setCacheable(false);
			queryObj.addEntity("FlaskGroup", FlaskGroupImpl.class);
			QueryPos qPosition = QueryPos.getInstance(queryObj);
			qPosition.add(groupIds);
			res = queryObj.executeUpdate();
		}catch(Exception e){
			LOGGER.error("Exception in get Group Users : "+ e.getMessage());
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public int deActivateGroup(long groupId){
		Session session = null;
		int res = 0;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get("deActivateGroup");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.setCacheable(false);
			queryObj.addEntity("FlaskGroup", FlaskGroupImpl.class);
			QueryPos qPosition = QueryPos.getInstance(queryObj);
			qPosition.add(groupId);
			res = queryObj.executeUpdate();
		}catch(Exception e){
			LOGGER.error("Exception in get Group Users : "+ e.getMessage());
			e.printStackTrace();
		}
		return res;
	}
}
