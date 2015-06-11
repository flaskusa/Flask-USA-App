var _eventModel = {};

_eventModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
	GET_VENUE 					: "/flask-rest-events-portlet.venue/get-all-venues",
	ADD_VENUE 					: "/flask-rest-events-portlet.venue/add-venue",
	ADD_VENUE_IMAGE				: "/flask-rest-events-portlet.venue/add-venue-image",
	UPDATE_EVENT				: "/flask-rest-events-portlet.venue/update-venue",
	DELETE_EVENT				: "/flask-rest-events-portlet.venue/delete-venue",
};

_eventModel.DATA_MODEL= {
	EVENT: 
		[
             { name: 'venueId', type: 'long' },
			 { name: 'eventName', type: 'string' },
			 { name: 'description', type: 'string' },
			 { name: 'eventDate', type: 'string' },
			 { name: 'startTime', type: 'string' },
			 { name: 'endTime', type: 'string' },
			 { name: 'eventTypeId', type:'long' },
			 { name: 'venueCountryId', type:'long' },
			 { name: 'venueCountryName', type:'string' },
		]
	};


_eventModel.MESSAGES= {
		GET_ERROR: "There was an error in getting data",
		ADD: "Venue successfully added",
		SAVE: "Venue successfully saved",
		ERROR: "There was an error in saving venue",
		DEL_SUCCESS: "Venue successfully deleted",
		DEL_ERR: "Error in deleting venue",
 };