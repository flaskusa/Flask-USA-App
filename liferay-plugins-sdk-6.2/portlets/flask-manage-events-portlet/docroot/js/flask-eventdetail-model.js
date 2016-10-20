var _eventDetailModel = {};

_eventDetailModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
	GET_INFO_TYPES 				: "/flask-rest-events-portlet.infotype/get-info-types",
	GET_INFO_CATEGORY 			: "/flask-rest-events-portlet.infotypecategory/get-info-type-categories",
	ADD_EVENT_DETAILS			: "/flask-rest-events-portlet.event/add-event-detail",
	GET_EVENT_DETAILS			: "/flask-rest-events-portlet.event/get-event-details",
	UPDATE_EVENT_DETAILS		: "/flask-rest-events-portlet.event/update-event-detail",
	DELETE_EVENT_DETAIL			: "/flask-rest-events-portlet.event/delete-event-detail",
	DELETE_ALL_EVENT_DETAILS	: "/flask-rest-events-portlet.event/delete-all-event-details",
	GET_FOLDER					: "/dlapp/get-folder",
	GET_FILES					: "/dlapp/get-file-entries",
	GET_FILE_BY_TITLE			: "/dlapp/get-file-entry",
	DELETE_FILES				: "/dlapp/delete-file-entry",
	DELETE_FILE_BY_TITLE		: "/dlapp/delete-file-entry-by-title",
	GET_EVENTDETAIL_IMAGES		: "/flask-rest-events-portlet.event/get-event-detail-images",
	GET_IMAGE_BY_UUID_GROUPID	: "/dlapp/get-file-entry-by-uuid-and-group-id",
	DELETE_EVENTDETAIL_IMAGE	: "/flask-rest-events-portlet.event/delete-event-detail-image"
};

_eventDetailModel.DATA_MODEL= {
		EVENTDETAILS:
			[
	             { name: 'eventDetailId', type: 'long' },
	             { name: 'eventId', type: 'long' },
	             { name: 'infoTypeId', type: 'long' },
	             { name: 'infoTypeName', type: 'string' },
	             { name: 'infoTypeCategoryId', type: 'long' },
	             { name: 'infoTypeCategoryName', type: 'string' },
				 { name: 'infoTitle', type: 'string' },
				 { name: 'infoShortDesc', type: 'string' },
				 { name: 'infoDesc', type: 'string' },
				 { name: 'addrLine1', type: 'string'},
				 { name: 'addrLine2', type: 'string'},
				 { name: 'zipCode', type: 'string'},
				 { name: 'city', type: 'string'},
				 { name: 'stateId', type: 'long' },
				 { name: 'countryId', type: 'long' },
				 { name: 'latitude', type: 'string'},
				 { name: 'longitude', type: 'string'},
				 { name: 'phone', type: 'string'},
				 { name: 'mobileAppName', type: 'string'},
				 { name: 'website', type: 'string'},
				 { name: 'cost', type: 'long' },
				 { name: 'hoursOfOperation', type:'string'},
				 { name: 'showDescription', type:'boolean'}
			]
	};

_eventDetailModel.GRID_CONTEXT_MENU = {
		EVENTDETAILS:function(row, columnfield, value, defaulthtml, columnproperties) {
			return '<i class="icon-wrench" style="margin:3px;"></i>'
		}
}

_eventDetailModel.GRID_DATA_MODEL= {
		EVENTDETAILS:
			[{ text: 'Name', columntype: 'textbox',  datafield: 'infoTitle', width: '20%'},
			 { text: 'Name', columntype: 'textbox',  datafield: 'infoShortDesc', width: '20%'},
	  		 {text: 'Content Type', datafield: 'infoTypeCategoryName'},
	  		 { text: 'Edit',  datafield: 'eventDetailId', width: '60px', cellsalign: 'center', cellsrenderer: _eventDetailModel.GRID_CONTEXT_MENU.EVENTDETAILS }]
		};

_eventDetailModel.MESSAGES= {
		DETAIL_GET_ERROR: "There was an error in getting data",
		DETAIL_ADD: "Event details successfully added",
		DETAIL_SAVE: "Event Details successfully saved",
		DETAIL_ERROR: "There was an error in saving details",
		DETAIL_DEL_SUCCESS: "Event details successfully deleted",
		DETAIL_DEL_ERR: "Error in deleting event details",
		DETAIL_DUPLICATE: "Event detail with same title already exist",
		DETAIL_NO_IMAGES_INFO: "No images found",
		DETAIL_IMAGE_DELETE: "Deleted successfully",
		CHECK_INTERNET_CONNECTION: "Internet is not connected, Please check your internet connection"
};

