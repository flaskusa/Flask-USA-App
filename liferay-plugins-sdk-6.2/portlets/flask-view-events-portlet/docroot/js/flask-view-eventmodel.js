var _eventModel = {};

_eventModel.SERVICE_ENDPOINTS = {
	API_PREFIX					:"/api/jsonws",
	GET_EVENT 					:"/flask-rest-events-portlet.event/get-all-events",
	GET_USER_EVENT 				:"/flask-rest-events-portlet.event/get-user-selected-events",
	GET_EVENTDETAIL_WITH_IMAGES :"/flask-rest-events-portlet.event/get-event-details-with-images",
	GET_FOLDER					:"/dlapp/get-folder",
	GET_FOLDERS					:"/dlapp/get-folders",
	GET_FILES					:"/dlapp/get-file-entries",
	GET_FILE_BY_TITLE			:"/dlapp/get-file-entry",
	ADD_USER_EVENT				:"/flask-rest-events-portlet.event/add-user-event",
	REMOVE_USER_EVENT			:"/flask-rest-events-portlet.event/remove-user-event",
    GET_VENUE     				:"/flask-rest-events-portlet.venue/get-venue",
    GET_FILTERED_EVENTS			:"/flask-rest-events-portlet.event/get-simple-filtered-events",
    GET_ALL_CAMPAIGN			:"/flask-advertisement-portlet.adcampaign/get-all-campaign",
    GET_EVENT_VENUE_DETAIL_WITH_IMAGES :"/flask-rest-events-portlet.event/get-event-venue-details-with-images"    	
};

_eventModel.detroitGeoLocation = {latitude: 42.3400 ,longitude: 83.0456 };
_eventModel.currentGeoLocation = {latitude: "" ,longitude: "" };

_eventModel.setDetroitAsGeoLocation = function(){
	_eventModel.currentGeoLocation.latitude= _eventModel.detroitGeoLocation.latitude;
	_eventModel.currentGeoLocation.longitude = _eventModel.detroitGeoLocation.longitude;
}

_eventModel.INFO_TYPE = {
		PreEvent : 1,
		DuringEvent : 2,
		PostEvent: 3
}
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
			]
		};

_eventModel.MESSAGES= {
		GET_ERROR: "There was an error in getting data",
		ADD: "Event successfully added",
		SAVE: "Event successfully saved",
		ERROR: "There was an error in saving venue",
		DEL_SUCCESS: "Event successfully deleted",
		DEL_ERR: "Error in deleting Event",
		SEARCH_ERR: "No search result found",
		WEATHER_ERROR: "Error in getting weather information",
		LOCATION_ERROR : "Failed to determine location, showing events from michigan area. User search to find events in your area."
		
 };

_eventModel.getObjectFields = function(infoTypeCategory){
	var renderer;
	switch(infoTypeCategory) {
		case "tradition":
			renderer = _eventModel.DETAIL_DATA_MODEL.TRADITION;
			break;
		case "parking":
			renderer = _eventModel.DETAIL_DATA_MODEL.PARKING;
			break;
		case "bar & restaurants":
			renderer = _eventModel.DETAIL_DATA_MODEL.BAR;
			break;
		case "nightlife":
			renderer = _eventModel.DETAIL_DATA_MODEL.NIGHTLIFE;
			break;
		case "safety":
			renderer = _eventModel.DETAIL_DATA_MODEL.FOOD;
			break;
		case "liquor store":
			renderer = _eventModel.DETAIL_DATA_MODEL.LIQUOR;
			break;
		case "supplies":
			renderer = _eventModel.DETAIL_DATA_MODEL.GENERAL;
			break;
		case "getting home":
			renderer = _eventModel.DETAIL_DATA_MODEL.GENERAL;
			break;
		case "flask us":
			renderer = _eventModel.DETAIL_DATA_MODEL.GENERAL;
			break;
		default:
			renderer =_eventModel.DETAIL_DATA_MODEL.GENERAL;
			break;
	}
	return renderer;
}

_eventModel.DETAIL_DATA_MODEL = {
		GENERAL:[{
                "infoTitle":"Title",
	        	"infoDesc":"Description"
				}],
		TRADITION:[{//TRADITION
                "infoTitle":"Name",
                "infoDesc":"Description",
                "Comment":"Comment"
            	}],
        WEATHER:[{//WEATHER
            	"infoTitle":"Name",
            	"infoDesc":"Description"
        		}],    		
        PARKING:[{//PARKING
	            "infoTitle":"Name",
	            "addrLine1":"Address",
	            "cost":"Cost",
	            "hoursOfOperation":"Is Available?",	            
            }],
        TRAFFIC:[{//TRAFFIC
                "infoTitle":"Name",
                "infoDesc":"Description",
            }],
        FOOD:[{//FOOD
            "infoTitle":"Name",
            "infoDesc":"Type of Establishment",
            "addrLine1":"Address",
            "phone":"Phone",
            "website":"Website"
            }],
         LIQUOR:[{//TRAFFIC
                "infoTitle":"Name",
                "infoDesc":"Address",
                "phone":"Phone"
         }],
         BAR:[{//TRAFFIC
             "infoTitle":"Name",
             "infoDesc":"Type of Establishment",
             "addrLine1":"Address",
             "phone":"Phone",
             "website":"Website"
         }],
         NIGHTLIFE:[{//TRAFFIC
             "infoTitle":"Name",
             "infoDesc":"Type of Establishment",
             "addrLine1":"Address",
             "phone":"Phone",
             "website":"Website"
         }]          
}

_eventModel.getBackgroundImage = function(infoTypeCategory){
	var renderer;
	switch(infoTypeCategory) {
		case "tradition":
			renderer = 'Flask_Tradition.jpg';
			break;
		case "parking":
			renderer = 'Flask_Parking.jpg';
			break;
		case "bar & restaurants":
			renderer = 'Flask_Bars.jpg';
			break;
		case "traffic":
			renderer = 'Flask_Traffic.jpg';
			break;
		case "supplies":
			renderer = 'Flask_Supplies.jpg';
			break;			
		case "getting home":
			renderer = 'flask_GettingHome.jpg';
			break;
		case "nightlife":
			renderer = 'flask_nightlife.jpg';
			break;
		case "liquor store":
			renderer = 'flask_restaurantBar_post.jpg';
			break;
		case "flask us":
			renderer = 'Flask_FlaskUs.jpg'
			break;				
		default:
			renderer = 'Flask_Default_Image.jpg';
			break;
	}
	return renderer;
}

_eventModel.BACKGROUNDIMAGE = {
	BARS:'Flask_Bars.jpg',
	DEFAULT:'Flask_Default_Image.jpg',
    FLASKUS:'Flask_FlaskUs.jpg',
    SUPPLIES:'Flask_Supplies.jpg',
    TRADITION:'Flask_Tradition.jpg',
    TRAFFIC:'Flask_Traffic.jpg'
}

_eventModel.GET_EVENT_DETAIL_TYPE_COUNT = function(objJSON,distinctInfoTypeCategory){
	var elementPosition;// = $.inArray(objJSON.infoTypeCategoryName, distinctInfoTypeCategory[0]);
	
	for(var iCount=0;iCount<distinctInfoTypeCategory.length;iCount++){
		if(distinctInfoTypeCategory[iCount][0]==objJSON.infoTypeCategoryName){
			elementPosition = iCount;
			break;
		}
	}
	
	if(elementPosition == undefined){
		distinctInfoTypeCategory.push([objJSON.infoTypeCategoryName,1]);
	}
	else{
		distinctInfoTypeCategory[elementPosition][1] = distinctInfoTypeCategory[elementPosition][1] + 1; 
	}
	/*if(objJSON.infoTypeCategoryName=='Parking'){
		console.log(distinctInfoTypeCategory);
	}*/
}