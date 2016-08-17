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
	GET_ALL_VENUES	 			: "/flask-rest-events-portlet.venue/get-all-venues",
	GET_FOLDER		 			: "/dlapp/get-folder",
	GET_EVENT_LOGOS		 		:"/flask-rest-events-portlet.event/get-event-logos",
	DELETE_FOLDER		 		: "/dlapp/delete-folder"
};

_eventModel.DATA_MODEL= {
	EVENT:
		[
		 	 { name: 'eventId', type: 'long' },
		 	 { name: 'eventName', type: 'string' },
		 	 { name: 'description', type: 'string' },
		 	 { name: 'eventDate', type: 'string' },
		 	 { name: 'startTime', type: 'long' },
		 	 { name: 'endTime', type: 'long' },
		 	 { name: 'eventTypeId', type: 'long' },
		 	 { name: 'eventTypeName', type: 'string' },
		 	 { name: 'venueId', type:'long' },
		 	 { name: 'venueName', type:'string' },
		 	 { name: 'eventImageUUID', type:'string' },
		 	 { name: 'eventImageGroupId', type:'string' },
		 	 { name: 'showDescription', type:'boolean' }
		]
	};

_eventModel.GRID_CONTEXT_MENU = {
		EVENT:function(row, columnfield, value, defaulthtml, columnproperties) {
			return '<i class="icon-wrench" style="margin:3px;"></i>'
		}
}

_eventModel.GRID_DATA_MODEL= {
		EVENT:
			[{ text: 'Name', columntype: 'textbox',  datafield: 'eventName', width: '25%'},
	  		 {text: 'Description', datafield: 'description'},
	  		{text: 'Date', datafield: 'eventDate', width: '25%'},
	  		 { text: 'Edit',  datafield: 'eventId', width: '34px', cellsalign: 'center', cellsrenderer: _eventModel.GRID_CONTEXT_MENU.EVENT }]
		};

_eventModel.MESSAGES= {
		GET_ERROR: "There was an error in getting data",
		ADD: "Event successfully added",
		SAVE: "Event successfully saved",
		ERROR: "There was an error in saving Event",
		DEL_SUCCESS: "Event successfully deleted",
		DEL_ERR: "Error in deleting Event",
		ADD_EVENT_FIRST_ERR: "Please save event first"
};

_eventModel.loadVenues = function(elementId,selectedId) {
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_ALL_VENUES , {},
					function(data) {
							selectList.empty();
							$.each(data, function(key, venue) {
								selectList.append($("<option/>", {
							        value: venue.venueId,
							        text: venue.venueName
							    }));
							});
							selectList.val(selectedId);
					} ,
					function(data) {
						console.log("Error in getting venues: " + data );
					});

}
_eventModel.loadEventType = function(elementId,selectedId) {
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_EVENT_TYPES , {},
					function(data) {
							selectList.empty();
							$.each(data, function(key, eventType) {
								selectList.append($("<option/>", {
							        value: eventType.eventTypeId,
							        text: eventType.eventTypeName
							    }));
							});
							selectList.val(selectedId);
					} ,
					function(data) {
						console.log("Error in getting Event Type: " + data );
					});

}

_eventModel.loadContentType = function(elementId,selectedId) {
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_INFO_CATEGORY , {},
					function(data) {
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
							selectList.change();
					} ,
					function(data) {
						console.log("Error in getting content types: " + data );
					});

}