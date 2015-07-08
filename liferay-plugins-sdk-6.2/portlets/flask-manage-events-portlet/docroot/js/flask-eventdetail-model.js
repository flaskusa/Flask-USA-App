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
	GET_FILE_BY_TITLE			: "/dlapp/get-file-entry",
	GET_FILES					: "/dlapp/get-file-entries",	
	DELETE_FILES				: "/dlapp/delete-file-entry",
	DELETE_FILE_BY_TITLE		: "/dlapp/delete-file-entry-by-title"
};

_eventDetailModel.DATA_MODEL= {
		EVENTDETAILS: 
			[
	             { name: 'eventDetailId', type: 'long' },
	             { name: 'eventId', type: 'long' },
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
				 { name: 'hoursOfOperation', type:'string'}
			]
	};

_eventDetailModel.GRID_CONTEXT_MENU = {
		EVENTDETAILS:function(row, columnfield, value, defaulthtml, columnproperties) {
			return '<i class="icon-wrench" style="margin:3px;"></i>'
		}
}

_eventDetailModel.GRID_DATA_MODEL= {
		EVENTDETAILS: 
			[{ text: 'Name', columntype: 'textbox',  datafield: 'infoTitle', width: '45%' },
      		 {text: 'Description', datafield: 'infoDesc', width: '45%'},
      		 { text: 'Edit',  datafield: 'venueDetailId', width: '10%', cellsalign: 'center', cellsrenderer: _eventDetailModel.GRID_CONTEXT_MENU.EVENTDETAILS }]
		};

_eventDetailModel.MESSAGES= {
		DETAIL_GET_ERROR: "There was an error in getting data",
		DETAIL_ADD: "Event details successfully added",
		DETAIL_SAVE: "Event successfully saved",
		DETAIL_ERROR: "There was an error in saving details",
		DETAIL_DEL_SUCCESS: "Event details successfully deleted",
		DETAIL_DEL_ERR: "Error in deleting event details"
 };

_eventDetailModel.loadContentType = function(elementId,selectedId){
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventDetailModel.SERVICE_ENDPOINTS.GET_INFO_CATEGORY , {}, 
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

_eventDetailModel.FORM_DATA_MODEL = {
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
                "value":$("#eventId").val(),
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
            "id":"addrLine1",
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
                "id":"addrLine1",
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
                "id":"addrLine1",
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
            "maxlength":"10",
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
            "maxlength":"10",
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
            "id":"addrLine1",
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
                "id":"addrLine1",
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
                "id":"addrLine1",
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
            "id":"addrLine1",
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
            "id":"addrLine1",
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
            "id":"addrLine1",
            "value":"",
            "placeholder":"Enter description here",
            "maxlength":"255",
            "Class":""
            }]
        }] 
}