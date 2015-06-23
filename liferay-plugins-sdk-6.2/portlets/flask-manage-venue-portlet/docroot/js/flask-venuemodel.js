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
	GET_INFO_CATEGORY 			: "/flask-rest-events-portlet.infotypecategory/get-info-type-categories",
	ADD_VENUE_DETAILS			: "/flask-rest-events-portlet.venue/add-venue-detail",
	UPDATE_VENUE_DETAILS		: "/flask-rest-events-portlet.venue/update-venue-detail"	
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
		],
	VENUEDETAILS: 
		[
             { name: 'venueId', type: 'long' },
             { name: 'infoTypeId', type: 'long' },
             { name: 'infoTypeCategoryId', type: 'long' },
			 { name: 'infoTitle', type: 'string' },
			 { name: 'infoDesc', type: 'string' },
			 { name: 'addrLine1', type: 'string'},
			 { name: 'addrLine2', type: 'string'},
			 { name: 'zipCode', type: 'string'},
			 { name: 'City', type: 'string'},
			 { name: 'stateId', type: 'long' },
			 { name: 'countryId', type: 'long' },
			 { name: 'lattitude', type: 'string'},
			 { name: 'longitude', type: 'string'},
			 { name: 'Phone', type: 'string'},
			 { name: 'Website', type: 'string'},
			 { name: 'cost', type: 'long' },
			 { name: 'hoursOfOperation', type: 'string' }
		]		
	};


_venueModel.MESSAGES= {
		GET_ERROR: "There was an error in getting data",
		ADD: "Venue successfully added",
		SAVE: "Venue successfully saved",
		ERROR: "There was an error in saving venue",
		DEL_SUCCESS: "Venue successfully deleted",
		DEL_ERR: "Error in deleting venue",
 };

_venueModel.loadContentType = function(elementId,selectedId){
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_venueModel.SERVICE_ENDPOINTS.GET_INFO_CATEGORY , {}, 
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
