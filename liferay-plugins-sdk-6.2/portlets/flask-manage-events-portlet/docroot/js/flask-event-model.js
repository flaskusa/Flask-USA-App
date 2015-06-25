var _eventModel = {};

_eventModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
	GET_EVENT 					: "/flask-rest-events-portlet.event/get-all-events",
	ADD_EVENT 					: "/flask-rest-events-portlet.event/add-event",
	ADD_EVENT_IMAGE				: "/flask-rest-events-portlet.event/add-event-image",
	UPDATE_EVENT				: "/flask-rest-events-portlet.event/update-event",
	DELETE_EVENT				: "/flask-rest-events-portlet.event/delete-event",
	DELETE_EVENTS				: "/flask-rest-events-portlet.event/delete-events",
	GET_EVENT_TYPES 			: "/flask-rest-events-portlet.eventtype/get-event-types",
	GET_INFO_TYPES 				: "/flask-rest-events-portlet.infotype/get-info-types",
	GET_INFO_CATEGORY 			: "/flask-rest-events-portlet.infotypecategory/get-info-type-categories",
	GET_ALL_VENUES	 			: "/flask-rest-events-portlet.venue/get-all-venues",
	GET_FOLDER					: "/dlapp/get-folder",
	ADD_FOLDER					: "/dlapp/add-folder",
	ADD_VENUE_DETAILS			: "/flask-rest-events-portlet.venue/add-venue-detail",
	GET_VENUE_DETAILS			: "/flask-rest-events-portlet.venue/get-venue-details",
	UPDATE_VENUE_DETAILS		: "/flask-rest-events-portlet.venue/update-venue-detail",
	DELETE_VENUE_DETAIL			: "/flask-rest-events-portlet.venue/delete-venue-detail",
	DELETE_ALL_VENUE_DETAILS	: "/flask-rest-events-portlet.venue/delete-all-venue-details"
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
		],
		VENUEDETAILS: 
			[
	             { name: 'venueDetailId', type: 'long' },
	             { name: 'venueId', type: 'long' },
	             { name: 'infoTypeId', type: 'long' },
	             { name: 'infoTypeCategoryId', type: 'long' },
				 { name: 'infoTitle', type: 'string' },
				 { name: 'infoDesc', type: 'string' },
				 { name: 'addrLine1', type: 'string'},
				 { name: 'addrLine2', type: 'string'},
				 { name: 'zipCode', type: 'string'},
				 { name: 'city', type: 'string'},
				 { name: 'stateId', type: 'long' },
				 { name: 'countryId', type: 'long' },
				 { name: 'lattitude', type: 'string'},
				 { name: 'longitude', type: 'string'},
				 { name: 'phone', type: 'string'},
				 { name: 'website', type: 'string'},
				 { name: 'cost', type: 'long' },
				 { name: 'hoursOfOperation', type: 'string' }
			]
	};

var actionRenderer = function(row, columnfield, value, defaulthtml, columnproperties) {
	return '<i class="icon-wrench" style="margin:3px;"></i>'
}
_eventModel.GRID_CONTEXT_MENU = {
		EVENT:function(row, columnfield, value, defaulthtml, columnproperties) {
			return '<i class="icon-wrench" style="margin:3px;"></i>'
		},
		VENUEDETAILS:function(row, columnfield, value, defaulthtml, columnproperties) {
			return '<i class="icon-wrench" style="margin:3px;"></i>'
		}
}

_eventModel.GRID_DATA_MODEL= {
		EVENT: 
			[{ text: 'Name', columntype: 'textbox',  datafield: 'eventName', width: '45%' },
      		 {text: 'Description', datafield: 'description', width: '45%'},
      		 { text: 'Edit',  datafield: 'eventId', width: '10%', cellsalign: 'center', cellsrenderer: _eventModel.GRID_CONTEXT_MENU.EVENT }],
		VENUEDETAILS: 
			[{ text: 'Name', columntype: 'textbox',  datafield: 'infoTitle', width: '45%' },
      		 {text: 'Description', datafield: 'infoDesc', width: '45%'},
      		 { text: 'Edit',  datafield: 'venueDetailId', width: '10%', cellsalign: 'center', cellsrenderer: _eventModel.GRID_CONTEXT_MENU.VENUEDETAILS }]
		};

_eventModel.MESSAGES= {
		GET_ERROR: "There was an error in getting data",
		ADD: "Event successfully added",
		SAVE: "Event successfully saved",
		ERROR: "There was an error in saving Event",
		DEL_SUCCESS: "Event successfully deleted",
		DEL_ERR: "Error in deleting Event",
		V_GET_ERROR: "There was an error in getting data",
		V_ADD: "Venue details successfully added",
		V_SAVE: "Venue successfully saved",
		V_ERROR: "There was an error in saving details",
		V_DEL_SUCCESS: "Venue details successfully deleted",
		V_DEL_ERR: "Error in deleting venue details"
 };

_eventModel.loadVenues = function(elementId,selectedId){
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_ALL_VENUES , {}, 
					function (data){
							selectList.empty();
							$.each(data, function(key, venue) {
								selectList.append($("<option/>", {
							        value: venue.venueId,
							        text: venue.venueName
							    }));
							});
							selectList.val(selectedId);
					} ,
					function (data){
						console.log("Error in getting venues: " + data );
					});
	
}
_eventModel.loadEventType = function(elementId,selectedId){
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_EVENT_TYPES , {}, 
					function (data){
							selectList.empty();
							$.each(data, function(key, eventType) {
								selectList.append($("<option/>", {
							        value: eventType.eventTypeId,
							        text: eventType.eventTypeName
							    }));
							});
							selectList.val(selectedId);
					} ,
					function (data){
						console.log("Error in getting Event Type: " + data );
					});
	
}

_eventModel.loadContentType = function(elementId,selectedId){
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_INFO_CATEGORY , {}, 
					function (data){
							selectList.empty();
							selectList.append($("<option/>", {
								value: 0,
								text: '-Select content type-'
							}));
							$.each(data, function(key, Content) {
								selectList.append($("<option/>", {
									value: Content.infoTypeCategoryId,
									text: Content.infoTypeCategoryName
								}));
							});
							selectList.val(selectedId);
					} ,
					function (data){
						console.log("Error in getting content types: " + data );
					});
	
}