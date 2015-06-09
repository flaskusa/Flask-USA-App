var _venueModel = {};

_venueModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
	GET_VENUE 					: "/flask-rest-events-portlet.venue/get-all-venues",
	ADD_VENUE 					: "/flask-rest-events-portlet.venue/add-venue",
	ADD_VENUE_IMAGE				: "/flask-rest-events-portlet.venue/add-venue-image",
	UPDATE_VENUE				: "/flask-rest-events-portlet.venue/update-venue",
	DELETE_VENUE				: "/flask-rest-events-portlet.venue/delete-venue",
	DELETE_VENUES				: "/flask-rest-events-portlet.venue/delete-venues",
	DELETE_VENUE_IMAGE			: "/flask-rest-events-portlet.venue/delete-venue-image"
};

_venueModel.DATA_MODEL= {
	VENUE: 
		[
             { name: 'venueId', type: 'long' },
			 { name: 'venueName', type: 'string' },
			 { name: 'venueDescription', type: 'string' },
			 { name: 'addrLine1', type: 'string' },
			 { name: 'addrLine2', type: 'string' },
			 { name: 'venueCity', type: 'string' },
			 { name: 'venueStateId', type:'long' },
			 { name: 'venueStateName', type:'string' },
			 { name: 'venueCountryId', type:'long' },
			 { name: 'venueCountryName', type:'string' },
			 { name: 'venueZipCode', type:'string' },
			 { name: 'venueMetroArea', type:'string' }
		]
	};


var MESSAGE= {
		ADD: "Venue successfully added",
		SAVE: "Venue successfully saved",
		ERROR: "There was an error in saving venue",
		DEL_SUCCESS: "Venue successfully deleted",
		DEL_ERR: "Error in deleting venue",
 };