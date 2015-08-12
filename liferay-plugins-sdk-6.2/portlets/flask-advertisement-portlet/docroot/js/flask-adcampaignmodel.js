var _adCampaignModel = {};

_adCampaignModel.SERVICE_ENDPOINTS = {
	API_PREFIX : "/api/jsonws",
	GET_CAMPAIGN : "/flask-advertisement-portlet.adcampaign/get-all-campaign",
	ADD_CAMPAIGN : "/flask-advertisement-portlet.adcampaign/add-campaign",
	UPDATE_CAMPAIGN : "/flask-advertisement-portlet.adcampaign/update-campaign",
	DELETE_CAMPAIGN : "/flask-advertisement-portlet.adcampaign/delete-campaign",
	DELETE_CAMPAIGNS : "/flask-advertisement-portlet.adcampaign/delete-campaigns",
	GET_INFO_TYPES : "/flask-rest-events-portlet.infotype/get-info-types",
	GET_EVENT 	   : "/flask-rest-events-portlet.event/get-all-events",

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
			type : 'string',
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
			type : 'string',
			fieldName : 'Events Ids'
		},
		{
			name : 'displayDuringEvent',
			type : 'string',
			fieldName : 'Events Ids'
		},
		{
			name : 'displayPostEvent',
			type : 'string',
			fieldName : 'Events Ids'
		},
		{
			name : 'adDisplayTime',
			type : 'string',
			fieldName : 'Display Time'
		},
		{
			name : 'frequencyPerHour',
			type : 'long',
			fieldName : 'Frequency'
		}
		]
	};

_adCampaignModel.MESSAGES = {
	GET_ERROR : "There was an error in getting data",
	ADD : "Campaign successfully added",
	SAVE : "Campaign successfully saved",
	ERROR : "There was an error in saving campaign",
	DEL_SUCCESS : "Campaign successfully deleted",
	DEL_ERR : "Error in deleting campaign"
};