var _venueDetailModel = {};

_venueDetailModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
	GET_INFO_TYPES 				: "/flask-rest-events-portlet.infotype/get-info-types",
	GET_INFO_CATEGORY 			: "/flask-rest-events-portlet.infotypecategory/get-info-type-categories",
	ADD_VENUE_DETAILS			: "/flask-rest-events-portlet.venue/add-venue-detail",
	GET_VENUE_DETAILS			: "/flask-rest-events-portlet.venue/get-venue-details",
	UPDATE_VENUE_DETAILS		: "/flask-rest-events-portlet.venue/update-venue-detail",
	DELETE_VENUE_DETAIL			: "/flask-rest-events-portlet.venue/delete-venue-detail",
	DELETE_ALL_VENUE_DETAILS	: "/flask-rest-events-portlet.venue/delete-all-venue-details",
	GET_FOLDER					: "/dlapp/get-folder",
	GET_FILE_BY_TITLE			: "/dlapp/get-file-entry",
	GET_FILES					: "/dlapp/get-file-entries",
	DELETE_FILES				: "/dlapp/delete-file-entry",
	DELETE_FILE_BY_TITLE		: "/dlapp/delete-file-entry-by-title",
	GET_VENUEDETAIL_IMAGES		: "/flask-rest-events-portlet.venue/get-venue-detail-images",
	GET_IMAGE_BY_UUID_GROUPID	: "/dlapp/get-file-entry-by-uuid-and-group-id",
	DELETE_VENUEDETAIL_IMAGE	: "/flask-rest-events-portlet.venue/delete-venue-detail-image",
	COPY_VENUEDETAILS_WITH_IMAGE: "/flask-rest-events-portlet.venue/copy-venue-details-with-images"
};

_venueDetailModel.InfoType = ["General", "Pre-Event","During Event","Post-Event"];

_venueDetailModel.DATA_MODEL= {
		VENUEDETAILS:
			[
	             { name: 'venueDetailId', type: 'long' },
	             { name: 'venuetId', type: 'long' },
	             { name: 'infoTypeId', type: 'long' },
	             { name: 'infoTypeName', type: 'string' },
	             { name: 'infoTypeCategoryId', type: 'long' },
	             { name: 'infoTypeCategoryName', type: 'string' },
				 { name: 'infoTitle', type: 'string' },
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
				 { name: 'website', type: 'string'},
				 { name: 'cost', type: 'long' },
				 { name: 'hoursOfOperation', type:'string'}
			]
	};

_venueDetailModel.GRID_CONTEXT_MENU = {
		VENUEDETAILS:function(row, columnfield, value, defaulthtml, columnproperties) {
			return '<i class="icon-wrench" style="margin:3px;"></i>'
		}
}

_venueDetailModel.GRID_DATA_MODEL= {
		VENUEDETAILS:
			[{ text: 'Name', columntype: 'textbox',  datafield: 'infoTitle'},
	  		 {text: 'Content Type', datafield: 'infoTypeCategoryName', width: '30%' },
	  		 { text: 'Edit',  datafield: 'venueDetailId', width: '60px', cellsalign: 'center', cellsrenderer: _venueDetailModel.GRID_CONTEXT_MENU.VENUEDETAILS }
	  		 ]
		};

_venueDetailModel.MESSAGES= {
		DETAIL_GET_ERROR: "There was an error in getting data",
		DETAIL_ADD: "Venue details successfully added",
		DETAIL_SAVE: "Venue Details successfully saved",
		DETAIL_ERROR: "There was an error in saving details",
		DETAIL_DEL_SUCCESS: "Venue details successfully deleted",
		DETAIL_DEL_ERR: "Error in deleting venue details",
		DETAIL_DUPLICATE: "Venue detail with same title already exist",
		DETAIL_NO_IMAGES_INFO: "No images found",
		COPY_VENUEDETAIL_SUCCESS: "Venue details imported successfully"
};