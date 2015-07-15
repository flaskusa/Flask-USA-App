var _eventModel = {};

_eventModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
	GET_EVENT 					: "/flask-rest-events-portlet.event/get-all-events",
	GET_ALL_VENUES	 			: "/api/jsonws/flask-rest-events-portlet.venue/get-all-venues",
	GET_FOLDER					: "/api/jsonws/dlapp/get-folder",
	GET_FOLDERS					: "/api/jsonws/dlapp/get-folders",
	ADD_FOLDER					: "/api/jsonws/dlapp/add-folder",
	GET_FOLDER					: "/api/jsonws/dlapp/get-folder",
	GET_FILES					: "/api/jsonws/dlapp/get-file-entries",
	GET_ALL_EVENT_DETAILS		: "/flask-rest-events-portlet.event/get-event-details"
};

_eventModel.DATA_MODEL= {
		EVENT: 
			[
			 	 { name: 'eventId', type: 'long' },
			 	 { name: 'eventName', type: 'string' },
			 	 { name: 'description', type: 'string' },
			 	 { name: 'eventDate', type: 'string' },
			 	 { name: 'startTime', type: 'string' },
			 	 { name: 'endTime', type: 'string' },
			 	 { name: 'eventTypeId', type: 'long' },
			 	 { name: 'eventTypeName', type: 'string' },
			 	 { name: 'venueId', type:'long' },
			 	 { name: 'venueName', type:'string' },
			 	 { name: 'eventImagePath', type:'string' }
			]
		};

_eventModel.MESSAGES= {
		GET_ERROR: "There was an error in getting data",
		ADD: "Event successfully added",
		SAVE: "Event successfully saved",
		ERROR: "There was an error in saving venue",
		DEL_SUCCESS: "Event successfully deleted",
		DEL_ERR: "Error in deleting Event",
 };