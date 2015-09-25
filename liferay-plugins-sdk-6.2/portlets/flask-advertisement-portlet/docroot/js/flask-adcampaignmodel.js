var _adCampaignModel = {};

_adCampaignModel.SERVICE_ENDPOINTS = {
	API_PREFIX 				: "/api/jsonws",
	GET_CAMPAIGN 			: "/flask-advertisement-portlet.adcampaign/get-all-campaign",
	ADD_CAMPAIGN 			: "/flask-advertisement-portlet.adcampaign/add-campaign",
	UPDATE_CAMPAIGN 		: "/flask-advertisement-portlet.adcampaign/update-campaign",
	DELETE_CAMPAIGN 		: "/flask-advertisement-portlet.adcampaign/delete-campaign",
	DELETE_CAMPAIGNS 		: "/flask-advertisement-portlet.adcampaign/delete-campaigns",
	GET_INFO_TYPES 			: "/flask-rest-events-portlet.infotype/get-info-types",
	GET_EVENT 	   			: "/flask-rest-events-portlet.event/get-all-events",
	GET_CAMPAIGN_IMAGES   	: "/flask-advertisement-portlet.adcampaign/get-campaign-images",
	DELETE_CAMPAIGN_IMAGE	: "/flask-advertisement-portlet.adcampaign/delete-campaign-image",
	GET_CAMPAIGN_EVENTS		: "/flask-advertisement-portlet.campaignevent/get-campaign-events"
};

_adCampaignModel.DATA_MODEL = {
		CAMPAIGN : [ {
			name : 'campaignId',
			type : 'long',
			fieldName : 'Campaign Id'
		}, {
			name : 'campaignName',
			type : 'string',
			fieldName : 'Campaign Name'
		}, 
		{
			name : 'customerId',
			type : 'string',
			fieldName : 'Customer ID'
		},
		{
			name : 'customerName',
			type : 'string',
			fieldName : 'Customer Name'
		},
		{
			name : 'eventTypeId',
			type : 'long',
			fieldName : 'Event Type ID'
		},
		{
			name : 'eventTypeName',
			type : 'string',
			fieldName : 'Event Type'
		},
		{
			name : 'eventIds',
			type : 'string',
			fieldName : 'Events Ids'
		},
		{
			name : 'displayGeneral',
			type : 'boolean',
			fieldName : 'displayGeneral'
		},
		{
			name : 'displayPreEvent',
			type : 'boolean',
			fieldName : 'displayPreEvent'
		},
		{
			name : 'displayDuringEvent',
			type : 'boolean',
			fieldName : 'displayDuringEvent'
		},
		{
			name : 'displayPostEvent',
			type : 'boolean',
			fieldName : 'displayPostEvent'
		},
		{
			name : 'frequencyPerHour',
			type : 'long',
			fieldName : 'Frequency'
		},
		{
			name : 'adDisplayTime',   /* display only*/
			type : 'string',
			fieldName : 'adDisplayTime'
		},
		{
			name : 'imageUUID',   /* display only*/
			type : 'string',
			fieldName : 'imageUUID'
		},
		{
			name : 'imageGroupId',   /* display only*/
			type : 'string',
			fieldName : 'imageGroupId'
		}]
	};

_adCampaignModel.MESSAGES = {
	GET_ERROR : "There was an error in getting data",
	ADD : "Campaign successfully added",
	SAVE : "Campaign successfully saved",
	ERROR : "There was an error in saving campaign",
	DEL_SUCCESS : "Campaign successfully deleted",
	DEL_ERR : "Error in deleting campaign"
};