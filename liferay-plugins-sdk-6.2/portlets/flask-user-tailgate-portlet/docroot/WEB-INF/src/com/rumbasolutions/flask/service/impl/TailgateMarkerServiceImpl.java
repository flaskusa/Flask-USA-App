/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rumbasolutions.flask.service.impl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.rumbasolutions.flask.model.TailgateMarker;
import com.rumbasolutions.flask.model.impl.TailgateMarkerImpl;
import com.rumbasolutions.flask.service.TailgateMarkerLocalServiceUtil;
import com.rumbasolutions.flask.service.base.TailgateMarkerServiceBaseImpl;
import com.rumbasolutions.flask.service.persistence.TailgateMarkerFinderUtil;

/**
 * The implementation of the tailgate marker remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rumbasolutions.flask.service.TailgateMarkerService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author rajeshj
 * @see com.rumbasolutions.flask.service.base.TailgateMarkerServiceBaseImpl
 * @see com.rumbasolutions.flask.service.TailgateMarkerServiceUtil
 */
public class TailgateMarkerServiceImpl extends TailgateMarkerServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rumbasolutions.flask.service.TailgateMarkerServiceUtil} to access the tailgate marker remote service.
	 */
	private static Log LOGGER = LogFactoryUtil.getLog(TailgateMarkerServiceImpl.class);
	
	@Override
	public TailgateMarker getTailgateMarker(long tailgateId){
		TailgateMarker tailgateMarker = null;
//		tailgateMarker = TailgateMarkerFinderUtil.getTailgateMarker(tailgateId);
		try {
			DynamicQuery tailgateQuery = DynamicQueryFactoryUtil.forClass(TailgateMarkerImpl.class);
			tailgateQuery.add(PropertyFactoryUtil.forName("tailgateid").eq(new Long(tailgateId)));
			List<TailgateMarker> tailgateMarkerList = TailgateMarkerLocalServiceUtil.dynamicQuery(tailgateQuery);
			if(tailgateMarkerList.size() > 0)
			tailgateMarker = tailgateMarkerList.get(0);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tailgateMarker;
	}
	@Override
	public void deleteTailgateMarker(long tailgateId){
		TailgateMarkerFinderUtil.deleteTailgateMarker(tailgateId);
	}
	
	@Override
	public TailgateMarker addTailgateMarker(long tailgateId, String latitude, String longitude, String name, String description){
		TailgateMarker tailgateMarker = null;
		
		try{
			tailgateMarker = TailgateMarkerLocalServiceUtil.createTailgateMarker(CounterLocalServiceUtil.increment());
			tailgateMarker.setTailgateid(tailgateId);
			tailgateMarker.setLatitude(latitude);
			tailgateMarker.setLongitude(longitude);
			tailgateMarker.setName(name);
			tailgateMarker.setDescription(description);
			
			tailgateMarker = TailgateMarkerLocalServiceUtil.addTailgateMarker(tailgateMarker);
		}catch(SystemException e){
			LOGGER.error("Exception in Add Tailgate Marker :" + e.getMessage());
			e.printStackTrace();
		}
		return tailgateMarker;
	}
	
	
}