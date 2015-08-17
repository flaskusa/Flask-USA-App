package com.rumbasolutions.flask.service.persistence;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.rumbasolutions.flask.model.TailgateMarker;
import com.rumbasolutions.flask.model.impl.TailgateMarkerImpl;

public class TailgateMarkerFinderImpl extends BasePersistenceImpl<TailgateMarker> implements TailgateMarkerFinder {
	
	private static Log LOGGER = LogFactoryUtil.getLog(TailgateMarkerFinderImpl.class);

	@Override
	public TailgateMarker getTailgateMarker(long tailgateId){
		Session session = null;
		TailgateMarker tailgateMarker = null;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get("getTailgateMarker");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.setCacheable(true);
			queryObj.addEntity("TailgateMarker", TailgateMarkerImpl.class);
			QueryPos qPosition = QueryPos.getInstance(queryObj);
			qPosition.add(tailgateId);
			tailgateMarker = (TailgateMarker)queryObj.list().get(0);
		}catch(Exception e)
		{
			e.printStackTrace();
			LOGGER.error("Exception in get Tailgate Marker : "+ e.getMessage());
		}finally{
			closeSession(session);
		}
		return tailgateMarker;
	}
	
	@Override
	public int deleteTailgateMarker(long tailgateId){
		Session session = null;
		int res = 0;
		try{
			session = openSession();
			String sql = CustomSQLUtil.get("deleteTailgateMarker");
			SQLQuery queryObj = session.createSQLQuery(sql);
			queryObj.setCacheable(false);
			queryObj.addEntity("TailgateMarker", TailgateMarkerImpl.class);
			QueryPos qPosition = QueryPos.getInstance(queryObj);
			qPosition.add(tailgateId);
			res = queryObj.executeUpdate();
		}catch(Exception e){
			LOGGER.error("Exception in delete Tailgate Marker : "+ e.getMessage());
			e.printStackTrace();
		}
		return res;
	}
}
