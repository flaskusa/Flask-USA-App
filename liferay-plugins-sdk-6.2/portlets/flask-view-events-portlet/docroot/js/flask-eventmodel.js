var _venueModel = {};

_venueModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
	GET_VENUE 					: "/flask-rest-events-portlet.venue/get-all-venues",
	ADD_VENUE 					: "/flask-rest-events-portlet.venue/add-venue",
	ADD_VENUE_IMAGE				: "/flask-rest-events-portlet.venue/add-venue-image",
	UPDATE_VENUE				: "/flask-rest-events-portlet.venue/update-venue",
	DELETE_VENUE				: "/flask-rest-events-portlet.venue/delete-venue",
	DELETE_VENUES				: "/flask-rest-events-portlet.venue/delete-venues",
	DELETE_VENUE_IMAGE			: "/flask-rest-events-portlet.venue/delete-venue-image",
	GET_ALL_EVENTS				: "/flask-rest-events-portlet.event/get-all-events",
	GET_ALL_FILES				: "/dlapp/get-file-entries"
};

_venueModel.DATA_MODEL= {
	VENUE: 
		[
             { name: 'venueId', type: 'long' },
			 { name: 'eventName', type: 'string' },
			 { name: 'description', type: 'string' },
			 { name: 'eventDate', type: 'string' },
			 { name: 'startTime', type: 'string' },
			 { name: 'endTime', type: 'string' },
			 { name: 'eventTypeId', type:'long' },
			 { name: 'eventImagePath', type:'string' }
		]
	};

_venueModel.MESSAGES= {
		GET_ERROR: "There was an error in getting data",
		ADD: "Event successfully added",
		SAVE: "Event successfully saved",
		ERROR: "There was an error in saving venue",
		DEL_SUCCESS: "Event successfully deleted",
		DEL_ERR: "Error in deleting Event",
 };