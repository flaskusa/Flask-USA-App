var _adCampaignModel = {};

_adCampaignModel.SERVICE_ENDPOINTS = {
	API_PREFIX : "/api/jsonws",
	GET_CAMPAIGN : "/flask-manage-advertisement-portlet.adcampaign/get-all-campaign",
	ADD_CAMPAIGN : "/flask-manage-advertisement-portlet.adcampaign/add-campaign",
	UPDATE_CAMPAIGN : "/flask-manage-advertisement-portlet.adcampaign/update-campaign",
	DELETE_CAMPAIGN : "/flask-manage-advertisement-portlet.adcampaign/delete-campaign",
	DELETE_CAMPAIGNS : "/flask-manage-advertisement-portlet.adcampaign/delete-campaigns",
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
	}, {
		name : 'customerName',
		type : 'string',
		fieldName : 'Customer Name'
	}, {
		name : 'eventType',
		type : 'string',
		fieldName : 'Event Type'
	}, {
		name : 'events',
		type : 'string',
		fieldName : 'Events'
	}, {
		name : 'displayAt',
		type : 'string',
		fieldName : 'Display At'
	}, {
		name : 'frequency',
		type : 'long',
		fieldName : 'Frequency'
	},{
		name : 'eventsId',
		type : 'string',
		fieldName : 'Events Id'
	},{
		name : 'eventTypeId',
		type : 'long',
		fieldName : 'Event Type Id'
	},{
		name : 'customerId',
		type : 'long',
		fieldName : 'Customer Id'
	},{
		name : 'displayAtId',
		type : 'string',
		fieldName : 'Display At Id'
	} ]
};

_adCampaignModel.MESSAGES = {
	GET_ERROR : "There was an error in getting data",
	ADD : "Campaign successfully added",
	SAVE : "Campaign successfully saved",
	ERROR : "There was an error in saving campaign",
	DEL_SUCCESS : "Campaign successfully deleted",
	DEL_ERR : "Error in deleting campaign"
};