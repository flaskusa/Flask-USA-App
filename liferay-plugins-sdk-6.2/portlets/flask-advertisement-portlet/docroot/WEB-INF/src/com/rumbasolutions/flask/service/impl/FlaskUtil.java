package com.rumbasolutions.flask.service.impl;

import java.util.HashMap;
import java.util.List;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.LogFactory;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.rumbasolutions.flask.model.AdCampaign;

public class FlaskUtil {

	private static Log LOGGER = LogFactoryUtil.getLog(FlaskUtil.class);

	
	

	public static HashMap<Long, String> _eventType = new HashMap<Long, String>();
	public static HashMap<Long, String> _infoType = new HashMap<Long, String>();

	public static long repositoryId = 0;
	public static long getFlaskRepositoryId() throws PortalException, SystemException{
		if(repositoryId==0){
			long companyId = PortalUtil.getDefaultCompanyId();
			Group group = GroupLocalServiceUtil.getGroup(companyId, "guest");
			repositoryId = group.getGroupId();
		}
		return repositoryId;	
	}
	
	
	
	public static JSONArray setStringNamesForCampaigns(List<AdCampaign> campaignList){
		JSONArray campaignListJsonArr =  JSONFactoryUtil.createJSONArray();

		for (AdCampaign adCampaign : campaignList){
			setStringNamesForCampaign(adCampaign);
			try {
				JSONObject obj = JSONFactoryUtil.createJSONObject(JSONFactoryUtil.looseSerialize(adCampaign));
			
				campaignListJsonArr.put(obj);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return campaignListJsonArr;
	}



	private static void setStringNamesForCampaign(AdCampaign adCampaign) {
		
	}
	
	public static String sanitizeIdList(String idList){
		StringBuilder sb  = new StringBuilder();
		if(Validator.isNotNull(idList)){
			String[] idArr = idList.split(",");
			for(String id : idArr){
				Integer val = Integer.valueOf(id.trim());
				sb.append(val.intValue());
				sb.append(", ");
			}
			sb.delete(sb.length() - 2, sb.length());
		}	
		return sb.toString();
	}
	
	
}
