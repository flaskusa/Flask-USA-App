package com.rumbasolutions.flask.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.rumbasolutions.flask.model.FlaskGroupUsers;
import com.rumbasolutions.flask.model.impl.FlaskGroupUsersImpl;

public class FlaskGroupUsersFinderImpl extends BasePersistenceImpl<FlaskGroupUsers> implements FlaskGroupUsersFinder {
	private static Log LOGGER = LogFactoryUtil.getLog(FlaskGroupUsersFinderImpl.class);

	@Override
	public List<FlaskGroupUsers> getGroupUsersListByGroupId(long groupId){
		Session session = null;
		List<FlaskGroupUsers> groupUserList = null;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get("getGroupUsersListByGroupId");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.setCacheable(true);
			queryObj.addEntity("FlaskGroupUsers", FlaskGroupUsersImpl.class);
			QueryPos qPosition = QueryPos.getInstance(queryObj);
			qPosition.add(groupId);
			groupUserList = queryObj.list();
		}catch(Exception e)
		{
			LOGGER.error("Exception in get Group Users : "+ e.getMessage());
		}finally{
			closeSession(session);
		}
		return groupUserList;
	}
	
	@Override
	public int addGroupOwner(long groupId, long userId){
		Session session = null;
		int res = 0;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get("addGroupOwner");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.setCacheable(false);
			queryObj.addEntity("FlaskGroupUsers", FlaskGroupUsersImpl.class);
			QueryPos qPosition = QueryPos.getInstance(queryObj);
			qPosition.add(groupId);
			qPosition.add(userId);
			res = queryObj.executeUpdate();
		}catch(Exception e){
			LOGGER.error("Exception in get Group Users : "+ e.getMessage());
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public int deleteGroupUser(long groupId, long userId){
		Session session = null;
		int res = 0;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get("deleteGroupUser");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.setCacheable(false);
			queryObj.addEntity("FlaskGroupUsers", FlaskGroupUsersImpl.class);
			QueryPos qPosition = QueryPos.getInstance(queryObj);
			qPosition.add(groupId);
			qPosition.add(userId);
			res = queryObj.executeUpdate();
		}catch(Exception e){
			LOGGER.error("Exception in get Group Users : "+ e.getMessage());
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public int deleteGroupUsers(long groupId, String userIds){
		Session session = null;
		int res = 0;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get("deleteGroupUsers");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.setCacheable(false);
			queryObj.addEntity("FlaskGroupUsers", FlaskGroupUsersImpl.class);
			QueryPos qPosition = QueryPos.getInstance(queryObj);
			qPosition.add(groupId);
			qPosition.add(userIds);
			res = queryObj.executeUpdate();
		}catch(Exception e){
			LOGGER.error("Exception in get Group Users : "+ e.getMessage());
			e.printStackTrace();
		}
		return res;
	}
}
