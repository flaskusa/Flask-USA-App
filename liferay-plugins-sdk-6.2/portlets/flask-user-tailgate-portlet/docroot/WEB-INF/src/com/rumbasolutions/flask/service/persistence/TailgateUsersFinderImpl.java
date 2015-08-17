package com.rumbasolutions.flask.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.rumbasolutions.flask.model.TailgateUsers;
import com.rumbasolutions.flask.model.impl.TailgateUsersImpl;

public class TailgateUsersFinderImpl extends BasePersistenceImpl<TailgateUsers> implements TailgateUsersFinder {
	private static Log LOGGER = LogFactoryUtil.getLog(TailgateUsersFinderImpl.class);

	@Override
	public List<TailgateUsers> getTailgateUsersByTailgateId(long tailgateId){
		Session session = null;
		List<TailgateUsers> tailgateUserList = null;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get("getTailgateUsersListByTailgateId");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.setCacheable(true);
			queryObj.addEntity("TailgateUsers", TailgateUsersImpl.class);
			QueryPos qPosition = QueryPos.getInstance(queryObj);
			qPosition.add(tailgateId);
			tailgateUserList = queryObj.list();
		}catch(Exception e)
		{
			LOGGER.error("Exception in get Tailgate Members : "+ e.getMessage());
		}finally{
			closeSession(session);
		}
		return tailgateUserList;
	}
	
	@Override
	public int deleteTailgateUser(long tailgateId, long userId){
		Session session = null;
		int res = 0;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get("deleteTailgateUser");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.setCacheable(false);
			queryObj.addEntity("TailgateUsers", TailgateUsersImpl.class);
			QueryPos qPosition = QueryPos.getInstance(queryObj);
			qPosition.add(tailgateId);
			qPosition.add(userId);
			res = queryObj.executeUpdate();
		}catch(Exception e){
			LOGGER.error("Exception in delete Tailgate Member : "+ e.getMessage());
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public int deleteTailgateUsers(long tailgateId, String userIds){
		Session session = null;
		int res = 0;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get("deleteTailgateUsers");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.setCacheable(false);
			queryObj.addEntity("TailgateUsers", TailgateUsersImpl.class);
			QueryPos qPosition = QueryPos.getInstance(queryObj);
			qPosition.add(tailgateId);
			qPosition.add(userIds);
			res = queryObj.executeUpdate();
		}catch(Exception e){
			LOGGER.error("Exception in delete Tailgate Members : "+ e.getMessage());
			e.printStackTrace();
		}
		return res;
	}
}
