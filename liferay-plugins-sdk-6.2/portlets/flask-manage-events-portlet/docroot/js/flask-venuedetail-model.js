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
	DELETE_FILE_BY_TITLE		: "/dlapp/delete-file-entry-by-title"
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
			[{ text: 'Name', columntype: 'textbox',  datafield: 'infoTitle', width: '40%' },
      		 {text: 'Description', datafield: 'infoDesc', width: '40%'},
      		 {text: 'Info Type', datafield: 'infoTypeName', width: '10%'},
      		 { text: 'Edit',  datafield: 'venueDetailId', width: '10%', cellsalign: 'center', cellsrenderer: _venueDetailModel.GRID_CONTEXT_MENU.VENUEDETAILS }
      		 ]
		};

_venueDetailModel.MESSAGES= {
		DETAIL_GET_ERROR: "There was an error in getting data",
		DETAIL_ADD: "Venue details successfully added",
		DETAIL_SAVE: "Venue Details successfully saved",
		DETAIL_ERROR: "There was an error in saving details",
		DETAIL_DEL_SUCCESS: "Venue details successfully deleted",
		DETAIL_DEL_ERR: "Error in deleting venue details"
 };

_venueDetailModel.loadContentType = function(elementId,selectedId){
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_INFO_CATEGORY , {}, 
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
							selectList.change();
					} ,
					function (data){
						console.log("Error in getting content types: " + data );
					});
	
}

_venueDetailModel.loadInfoType = function(elementId,selectedId){
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.GET_INFO_TYPES , {}, 
					function (data){
							selectList.empty();
							selectList.append($("<option/>", {
								value: 0,
								text: '-Select content type-'
							}));
							$.each(data, function(key, Content) {
								selectList.append($("<option/>", {
									value: Content.infoTypeId,
									text: Content.infoTypeName
								}));
							});
							selectList.val(selectedId);
							selectList.change();
					} ,
					function (data){
						console.log("Error in getting infotype types: " + data );
					});
	
}


_venueDetailModel.FORM_DATA_MODEL = {
		GENERAL:[{//GENERAL
            "type":"text",
            "attr":[{ 
                "caption":"Title",
                "id":"infoTitle",
                "value":"",
                "placeholder":"Enter title here",
                "maxlength":"30",
                "Class":""
                }]
            },
            {                                
            "type":"text",
            "attr":[{ 
                "caption":"Description",
                "id":"infoDesc",
                "value":"",
                "placeholder":"Enter description here",
                "maxlength":"255",
                "Class":""
                }]
            },
            {                                
            "type":"upload",
            "attr":[{ 
            	"caption":"Upload Pictures",
                "action":$("#imgActionUrl").val(),
                "id":"eventId",
                "value":$("#eventId").val(),
                "Class":""
                }]
            }],
       TRADITION:[{//TRADITION
            "type":"text",
            "attr":[{ 
                "caption":"Name",
                "id":"infoTitle",
                "value":"",
                "placeholder":"Enter title here",
                "maxlength":"30",
                "Class":""
                }]
            },
            {                                
            "type":"text",
            "attr":[{ 
                "caption":"Description",
                "id":"infoDesc",
                "value":"",
                "placeholder":"Enter description here",
                "maxlength":"255",
                "Class":""
                }]
            },
            {                                
            "type":"text",
            "attr":[{ 
                "caption":"Comment",
                "id":"Comment",
                "value":"",
                "placeholder":"Enter Comment here",
                "maxlength":"255",
                "Class":""
                }]
            },
        	{                                
            "type":"upload",
            "attr":[{ 
            	"caption":"Upload Pictures",
                "action":$("#imgActionUrl").val(),
                "id":"eventId",
                "value":$("#venueId").val(),
                "Class":""
                }]
    		}],
    WEATHER:[{//WEATHER
    	"type":"text",
        "attr":[{ 
            "caption":"Name",
            "id":"infoTitle",
            "value":"",
            "placeholder":"Enter Name here",
            "maxlength":"30",
            "Class":""
            }]
        },
        {                                
        "type":"text",
        "attr":[{ 
            "caption":"Description",
            "id":"infoDesc",
            "value":"",
            "placeholder":"Enter description here",
            "maxlength":"255",
            "Class":""
            }]
        }],    		
    PARKING:[{//PARKING
            "type":"text",
            "attr":[{ 
                "caption":"Name",
                "id":"infoTitle",
                "value":"",
                "placeholder":"Enter Name here",
                "maxlength":"30",
                "Class":""
                }]
            },
            {                                
            "type":"text",
            "attr":[{ 
                "caption":"Address",
                "id":"infoDesc",
                "value":"",
                "placeholder":"Enter Address here",
                "maxlength":"255",
                "Class":""
                }]
            },
            {                                
            "type":"text",
            "attr":[{ 
                "caption":"Cost",
                "id":"cost",
                "value":"",
                "placeholder":"Enter Cost here",
                "maxlength":"10",
                "Class":""
                }]
            },
            {                                
            "type":"boolean",
            "attr":[{ 
                "id":"hoursOfOperation",
                "name":"IsAvailable",
                "caption":"Is Available?",
                "value":"Yes",
                "items":["Yes","No"]
                }]
            }],
    TRAFFIC:[{//TRAFFIC
        	"type":"text",
            "attr":[{ 
                "caption":"Name",
                "id":"infoTitle",
                "value":"",
                "placeholder":"Enter Name here",
                "maxlength":"30",
                "Class":""
                }]
            },
            {                                
            "type":"text",
            "attr":[{ 
                "caption":"Description",
                "id":"infoDesc",
                "value":"",
                "placeholder":"Enter description here",
                "maxlength":"255",
                "Class":""
                }]
            }],
    FOOD:[{//FOOD
    	"type":"text",
        "attr":[{ 
            "caption":"Name",
            "id":"infoTitle",
            "value":"",
            "placeholder":"Enter Name here",
            "maxlength":"30",
            "Class":""
            }]
        },
        {                                
        "type":"text",
        "attr":[{ 
            "caption":"Type of Establishment",
            "id":"infoDesc",
            "value":"",
            "placeholder":"",
            "maxlength":"50",
            "Class":""
            }]
        },
        {                                
        "type":"text",
        "attr":[{ 
            "caption":"Address",
            "id":"addrLine1",
            "value":"",
            "placeholder":"",
            "maxlength":"255",
            "Class":""
            }]
        },
        {                                
        "type":"text",
        "attr":[{ 
            "caption":"Phone",
            "id":"phone",
            "value":"",
            "placeholder":"",
            "maxlength":"10",
            "Class":""
            }]
        },
        {                                
        "type":"text",
        "attr":[{ 
            "caption":"Website",
            "id":"website",
            "value":"",
            "placeholder":"",
            "maxlength":"30",
            "Class":""
            }]
        },
        {                                
        "type":"text",
        "attr":[{ 
            "caption":"Local Knowledge",
            "id":"infoDesc",
            "value":"",
            "placeholder":"",
            "maxlength":"255",
            "Class":""
            }]
        }],
    LIQUOR:[{//liquor
        "type":"text",
        "attr":[{ 
            "caption":"Name",
            "id":"infoTitle",
            "value":"",
            "placeholder":"Enter Name here",
            "maxlength":"30",
            "Class":""
            }]
        },
        {                                
        "type":"text",
        "attr":[{ 
            "caption":"Address",
            "id":"infoDesc",
            "value":"",
            "placeholder":"Enter Address here",
            "maxlength":"255",
            "Class":""
            }]
        },
        {                                
        "type":"text",
        "attr":[{ 
            "caption":"Cost",
            "id":"cost",
            "value":"",
            "placeholder":"Enter Cost here",
            "maxlength":"10",
            "Class":""
            }]
        }],
    ADVERTISEMENTS:[{//Advertisements
        	"type":"text",
            "attr":[{ 
                "caption":"Name",
                "id":"infoTitle",
                "value":"",
                "placeholder":"Enter Name here",
                "maxlength":"30",
                "Class":""
                }]
            },
            {                                
            "type":"text",
            "attr":[{ 
                "caption":"Description",
                "id":"infoDesc",
                "value":"",
                "placeholder":"Enter description here",
                "maxlength":"255",
                "Class":""
                }]
            }],     
    HOSPITALS:[{//Hospitals
        	"type":"text",
            "attr":[{ 
                "caption":"Name",
                "id":"infoTitle",
                "value":"",
                "placeholder":"Enter Name here",
                "maxlength":"30",
                "Class":""
                }]
            },
            {                                
            "type":"text",
            "attr":[{ 
                "caption":"Description",
                "id":"infoDesc",
                "value":"",
                "placeholder":"Enter description here",
                "maxlength":"255",
                "Class":""
                }]
            }],    
     FIRSTAID:[{//First Aid
    	"type":"text",
        "attr":[{ 
            "caption":"Name",
            "id":"infoTitle",
            "value":"",
            "placeholder":"Enter Name here",
            "maxlength":"30",
            "Class":""
            }]
        },
        {                                
        "type":"text",
        "attr":[{ 
            "caption":"Description",
            "id":"infoDesc",
            "value":"",
            "placeholder":"Enter description here",
            "maxlength":"255",
            "Class":""
            }]
        }],    
    POLICESTATIONS:[{//Police Stations
    	"type":"text",
        "attr":[{ 
            "caption":"Name",
            "id":"infoTitle",
            "value":"",
            "placeholder":"Enter Name here",
            "maxlength":"30",
            "Class":""
            }]
        },
        {                                
        "type":"text",
        "attr":[{ 
            "caption":"Description",
            "id":"infoDesc",
            "value":"",
            "placeholder":"Enter description here",
            "maxlength":"255",
            "Class":""
            }]
        }],   
    FIRESTATIONS:[{//Fire Stations
    	"type":"text",
        "attr":[{ 
            "caption":"Name",
            "id":"infoTitle",
            "value":"",
            "placeholder":"Enter Name here",
            "maxlength":"30",
            "Class":""
            }]
        },
        {                                
        "type":"text",
        "attr":[{ 
            "caption":"Description",
            "id":"infoDesc",
            "value":"",
            "placeholder":"Enter description here",
            "maxlength":"255",
            "Class":""
            }]
        }] 
}