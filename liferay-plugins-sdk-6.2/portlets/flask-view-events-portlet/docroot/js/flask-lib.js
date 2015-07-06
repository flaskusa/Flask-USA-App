var SERVICE_ENDPOINTS = {
		GET_ALL_EVENTS:"/api/jsonws/flask-rest-events-portlet.event/get-all-events",
		GET_ALL_IMAGES:"/api/jsonws/dlapp/get-file-entries",
		GET_ALL_FOLDERS:"/api/jsonws/dlapp/get-folder"
};

var DATA_SOURCE  = {
	GET_FLASK_EVENT_LIST: 
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
}


var STATUS_CODE = {
	SUCCESS :1,
	TIMEDOUT:2,
	ERROR:3,
	UNEXPECTED_ERROR: 4 
}

var curSession = null;

//Class Resposne 
function Response(){
	this.responseStatus = 0;
	this.responseJson;
}
// Methods of response
Response.prototype.setResponseStatus = function(statusCode){
	this.responseStatus = statusCode;
}
Response.prototype.setResponseJson = function(json){
	this.responseJson = json;
}
Response.prototype.getResponseStatus = function(){
	return this.responseStatus;
}
Response.prototype.getResponseJson = function(){
	return this.responseJson;
}
//Class Request
function Request(){
}

Request.prototype.sendGETRequest = function(url, params, responseHandler){
	var resObj = new Response();
	var headerData = {};
	resObj.responseJson = "";
	$.ajax({
        type: "GET",
        url:  url,
        data: params,
        cache:false,
        timeout:SERVICE_ENDPOINTS.SERVICE_TIMEOUT,
        success: function(data){
			resObj.setResponseStatus(STATUS_CODE.SUCCESS);
			resObj.setResponseJson(data);
			responseHandler(resObj);
		},
		error:function(){ 
			resObj.setResponseStatus(STATUS_CODE.UNEXPECTED_ERROR);
			resObj.setResponseJson("{\"Message\":[\"Unexpected error occurred.\"],\"Success\":false}");			
			responseHandler(resObj);
		}
	});
}
Request.prototype.sendPOSTRequest = function(url, params, responseHandler){
	var resObj = new Response();
	resObj.responseJson = "";
	try{
	$.ajax({
        type: "POST",
        url:  url,
        data: params,
        cache:false,
        dataType: "text",
        contentType: "application/json",
        timeout:SERVICE_ENDPOINTS.SERVICE_TIMEOUT,
        success: function(data){
			resObj.setResponseStatus(STATUS_CODE.SUCCESS);
			resObj.setResponseJson(data);
			responseHandler(resObj);
		},
		error:function(){ 
			resObj.setResponseStatus(STATUS_CODE.UNEXPECTED_ERROR);
			resObj.setResponseJson("{\"Message\":[\"Unexpected error occurred.\"],\"Success\":false}");
			responseHandler(resObj);
		}
	});
	} catch (ex){
		resObj.setResponseStatus(STATUS_CODE.UNEXPECTED_ERROR);
		resObj.setResponseJson("{\"Message\":[\"Unexpected error occurred.\"],\"Success\":false}");
		responseHandler(resObj);
	}
}

function responseHandler(msg){
	console.log(msg);
	return false;
}
// ************************************ APIS FOR FLASK
// **************************************
