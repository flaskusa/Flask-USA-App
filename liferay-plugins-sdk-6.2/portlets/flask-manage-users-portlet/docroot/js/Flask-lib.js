var username ="test@liferay.com";
var password ="test"; 

var SERVICE_ENDPOINTS = {
	GET_FLASK_ADMIN_ENDPOINT 	: "/api/jsonws/flask-rest-users-portlet.flaskadmin/get-flask-admins",
	ADD_FLASK_ADMIN_ENDPOINT 	: "/api/jsonws/flask-rest-users-portlet.flaskadmin/add-flask-admin",
	UPDATE_FLASK_ADMIN_ENDPOINT	: "http://localhost:8080/api/jsonws/flask-rest-users-portlet.flaskadmin/update-flask-admin",
	DELETE_FLASK_ADMIN_ENDPOINT	: "/api/jsonws/flask-rest-users-portlet.flaskadmin/delete-flask-admin",
	TERMS_AND_CONDITION         : "http://www.rumbasolutions.com", 
	SERVICE_TIMEOUT 			: 30000	
};

var DATA_SOURCE  = {
	GET_FLASK_ADMIN_GRID: [{ name: 'userId', type: 'string' },
						 { name: 'firstName', type: 'string' },
						 { name: 'lastName', type: 'string' },
						 { name: 'email', type: 'string' }]
}

var MESSAGES = {
		MANDATORY_FIRST_NAME        : "Please enter first name.",
		MANDATORY_FIRST_NAME        : "Please enter last name.",
    	MANDATORY_EMAIL				: "Please Enter Email ID",
    	ERRORR_REGISTER_USER        : "Error Registering New User. Please verify details and try again.",
    	ERROR_VERIFY_USER           : "Invalid User ID. Please Check User ID and try again.",
    	REQUEST_SUBMIT_SUCCESSFULY  : "Request Submitted Successfully.",
		FORGOTUSERNAME_EMAIL_SENT  	: "Username has been sent to your email address.",
		FORGOTPASSWORD_EMAIL_SENT	: "Password has been sent to your email address.",
    	END_USER_AGGREMENT          : "By clicking <strong>Accept</strong> , you are accepting to the <a class='decorate-link' onclick='showTermsAndCondition();'> Terms and Conditions</a> of VARStreet's End User License Agreement which will enable you to use VARStreet A2Q application on your mobile device."
};
var APP_CONFIG = {
		PAGE_SIZE : 10,
		JQX_THEME : "custom",
		PAYMENT_TYPE : { 
			CASH_ON_DELIVERY : "Cash On Delivery",
			MONEY_ORDER : "Money Order",
			COMPANY_CHECK : "Company Check",
			CASHIERS_CHECK : "Cashiers Check",
			CREDIT_CARD : "Credit Card",
			COMPANY_PO : "Company PO",
			PURCHASE_CARD:"Purchase Card",
			PERSONAL_CHECK:"Personal Check",
			PAYROLL_DEDUCTION:"Payroll Deductions",
			GOVT_ISSUED_CREDIT_CARD:"Govt. Issued Credit Card",
			GOVT_ISSUED_PURCHASE_ORDER:"Govt. Issued Purchase Order"
		}
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
        beforeSend:function(xhr){
        	xhr.setRequestHeader('Authorization',make_base_auth(username, password));
        },
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

function make_base_auth(user, password) {
  var tok = user + ':' + password;
  var hash = btoa(tok);
  return "Basic " + hash;
}

// ************************************ APIS FOR FLASK
// **************************************






