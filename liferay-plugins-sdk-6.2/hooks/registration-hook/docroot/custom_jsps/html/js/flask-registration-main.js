var SERVICE_ENDPOINTS = {
		GET_FLASK_ADMIN_ENDPOINT 	: "/api/jsonws/flask-rest-users-portlet.flaskadmin/get-flask-admins",
		ADD_FLASK_ADMIN_ENDPOINT 	: "/flask-rest-users-portlet.flaskadmin/add-flask-admin",
		UPDATE_FLASK_ADMIN_ENDPOINT	: "/flask-rest-users-portlet.flaskadmin/update-flask-admin",
		DELETE_FLASK_ADMIN_ENDPOINT	: "/flask-rest-users-portlet.flaskadmin/delete-flask-admin",
		TERMS_AND_CONDITION         : "http://www.rumbasolutions.com", 
		GET_COUNTRY_ENDPOINT		: "/flask-rest-users-portlet.flaskadmin/get-country-by-name",
		GET_REGION_ENDPOINT			: "/flask-rest-users-portlet.flaskadmin/get-region",
		ADD_USER_ENDPOINT			: "/flask-rest-users-portlet.flaskadmin/add-flask-user",
		SIGN_UP						: "/flask-rest-users-portlet.flaskadmin/sign-up",
		UPDATE_USER_ENDPOINT		: "/flask-rest-users-portlet.flaskadmin/update-logged-in-user",
		GET_FLASK_USER_ENDPOINT 	: "/api/jsonws/user/get-user-by-id", // -user-id
		GET_USER_BY_ID				: "/flask-rest-users-portlet.flaskadmin/get-user-by-id",
		SERVICE_TIMEOUT 			: 30000	
	};

	var DATA_SOURCE  = {
		GET_FLASK_ADMIN_GRID: 
			[
		                     { name: 'userId', type: 'string' },
							 { name: 'firstName', type: 'string' },
							 { name: 'middleName', type: 'string' },
							 { name: 'lastName', type: 'string' },
							 { name: 'email', type: 'string' },
							 { name: 'mobileNumber', type: 'string' },
							 { name: 'screenName', type: 'string' },
							 { name: 'DOB', type: 'date' },
							 { name: 'streetName', type: 'string' },
							 { name: 'aptNo', type: 'string' },
							 { name: 'areaCode', type: 'string' },
							 { name: 'city', type: 'string' },
							 { name: 'stateId', type: 'string' },
							 { name: 'stateName', type: 'string' },
							 { name: 'countryId', type: 'string' },
							 { name: 'countryName', type: 'string' }
							 
			]
	}

	var ALLOWED_COUNTRIES = ['united-states','canada']
	var DEFAULT_COUNTRY = 'united-states';

	var MESSAGES = {
			MANDATORY_FIRST_NAME        : "Please enter first name.",
			MANDATORY_LAST_NAME         : "Please enter last name.",
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

	function fnSave() {
		console.log('insave');
		console.log(SERVICE_ENDPOINTS.ADD_USER_ENDPOINT);
		if($("#streetName").val()==""){
			$("#streetName").val($("#email").val());
		}
		var params = {
						firstName : $("#firstName").val(),
						middleName : $("#middleName").val(),
						lastName : $("#lastName").val(),
						isMale : true,
						screenName : $("#screenName").val(),
						email : $("#email").val(),
						// DOB: '05-10-2015',
						DOB : $("#DOB").val(),
						streetName : $("#streetName").val(),
						aptNo : $("#aptNo").val(),
						areaCode : $("#areaCode").val(),
						city : $("#city").val(),
						stateId : $("#stateId").val(),
						countryId : $("#countryId").val(),
						password1 : $("#password1").val(),
						password2 : $("#password2").val(),
						mobileNumber : $("#mobileNumber").val(),
						userInterests : fnGetCheckBoxSelected()//fnGet
					};
					console.log(params);
					if(Liferay.ThemeDisplay.isSignedIn()){
						url = SERVICE_ENDPOINTS.ADD_USER_ENDPOINT;
					}else{
						var params = {
								firstName : $("#firstName").val(),
								lastName : $("#lastName").val(),
								email : $("#email").val(),
								screenName : $("#firstName").val()+$("#lastName").val()+$("#mobileNumber").val(),
								password1 : $("#password1").val(),
								password2 : $("#password2").val(),
								DOB : $("#DOB").val(),
								isMale : true,
								areaCode : $("#areaCode").val(),
								mobileNumber : $("#mobileNumber").val(),
								// DOB: '05-10-2015',	
							};
						url = SERVICE_ENDPOINTS.SIGN_UP;
					}
					console.log(params);
					console.log(url);
					Liferay.Service(url, params,
					function(obj) {
										console.log(obj);
										if(typeof obj =='object')
										{
											$("#spinningSquaresG").show();
											$.wait(function() {
												$("#spinningSquaresG").hide();
											}, 3);	
										}
										else
										{
										  console.log(obj);
										  return false;
										}
										console.log('end insave');			
								});
	//window.location = "http://146.148.83.30/web/flask/events?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_58_struts_action=%2Flogin%2Flogin";
		  var url = "/web/flask/events?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_58_struts_action=%2Flogin%2Flogin";
		  $(location).attr('href',url);
	}


	function fnUpdate(uid) {
		console.log("fnUpdate called");
		var params = {
						userId : $("#userId").val(),
						firstName : $("#firstName").val(),
						middleName : $("#middleName").val(),
						lastName : $("#lastName").val(),
						email : $("#email").val(),
						screenName : $("#screenName").val(),
						password1 : $("#password1").val(),
						password2 : $("#password2").val(),
						DOB : $("#DOB").val(),
						isMale : true,
						streetName : $("#streetName").val(),
						aptNo : $("#aptNo").val(),
						areaCode : $("#areaCode").val(),
						city : $("#city").val(),
						stateId : $("#stateId").val(),
						countryId : $("#countryId").val(),
						mobileNumber : $("#mobileNumber").val(),
						userInterests : fnGetCheckBoxSelected()
					};
					console.log(params);
					Liferay.Service(SERVICE_ENDPOINTS.UPDATE_USER_ENDPOINT, params,
					function(obj){
								console.log(obj);
								if(typeof obj =='object')
								{
									console.log('inUpdate');
								}
								else
								{
								  console.log(obj);
								  return false;
								}
								console.log('end Update');			
						});	
	}

	function fnShowForm(userId) {
		console.log("m in showForm: "+userId);
		/*var request = new Request();
		var params = {'userId': userId};
		request.sendGETRequest(SERVICE_ENDPOINTS.GET_USER_BY_ID, params, function(obj) {
				console.log(obj);
				    if(typeof obj =='object')
					{
						$("#userId").val(obj.userId);
						$("#firstName").val(obj.firstName);
						$("#middleName").val(obj.middleName);
						$("#lastName").val(obj.lastName);
						$("#email").val(obj.email);
						$("#screenName").val(obj.screenName);
						$("#password1").val("");//GlobalJSON_Admin[rowIndex].password1
						$("#password2").val("");//objUser.password2
						$("#city").val(obj.city);
						$("#mobileNumber").val(obj.mobileNumber);
						$("#countryId").val(obj.countryId);
						fnFillRegionList(obj.countryId,obj.stateId);
						var date = new Date(parseInt(obj.DOB))
						$('#DOB').jqxDateTimeInput('setDate', date);
						$("#streetName").val(obj.streetName);
						$("#aptNo").val(obj.aptNo);
						$("#areaCode").val(obj.areaCode);
						console.log(obj.userInterests);
						fnSetCheckBoxSelected(obj.userInterests);
						$("#adminForm").show();						
					}
					else
					{
					  console.log(obj);
					  return false;
					}		    
			  	},function(error){ 
					console.log("Error in getting data: " + error);
				});		*/
		Liferay.Service(
					  '/flask-rest-users-portlet.flaskadmin/get-user-by-id',
					  {
					    userId: userId
					  },
					  function(obj) {
					    console.log(obj);
					    if(typeof obj =='object')
						{
							$("#userId").val(obj.userId);
							$("#firstName").val(obj.firstName);
							$("#middleName").val(obj.middleName);
							$("#lastName").val(obj.lastName);
							$("#email").val(obj.email);
							$("#screenName").val(obj.screenName);
							$("#password1").val("");//GlobalJSON_Admin[rowIndex].password1
							$("#password2").val("");//objUser.password2
							$("#city").val(obj.city);
							$("#mobileNumber").val(obj.mobileNumber);
							$("#countryId").val(obj.countryId);
							fnFillRegionList(obj.countryId,obj.stateId);
							var date = new Date(parseInt(obj.DOB))
							$('#DOB').jqxDateTimeInput('setDate', date);
							$("#streetName").val(obj.streetName);
							$("#aptNo").val(obj.aptNo);
							$("#areaCode").val(obj.areaCode);
							console.log(obj.userInterests);
							fnSetCheckBoxSelected(obj.userInterests);
							$("#adminForm").show();						
						}
						else
						{
						  console.log(obj);
						  return false;
						}		
					  }
					);
	}

	function fnPasswordReset() {
		alert("fnPasswordReset");
	}

	$(document).ready(function () {
		$("#heading").hide();
			    $('.cssSave').on('click', function () {
			    	if($('#adminForm').jqxValidator('validate'))
			    	{
			    		console.log($("#userId").val());
			    		if(parseInt($("#userId").val())>0){
			    			fnUpdate();
			    		}
			    		else{
			    			console.log("fnSave called");
			    			fnSave();
			    			var myStateList = $("#stateId");
			    			myStateList.empty();
			    			myStateList.append($("<option></option>").val(0).html("-Select your region-"));
			    		}
			    		return false;
			    	}	
			    	else
			    	{
			    		console.log("test False");
			    		return false;
			    	}
				});
			    // initialize validator.
			    $('#adminForm').jqxValidator
			    ({
			        hintType: 'label',
			        animationDuration: 0,
			        rules: [
			               { input: '#firstName', message: 'First name is required!', action: 'keyup, blur', rule: 'required' },
			               { input: '#lastName', message: 'Last name is required!', action: 'keyup, blur', rule: 'required' },
			               { input: '#areaCode', message: 'Zip code is required!', action: 'keyup, blur', rule: 'required' },
			               { input: '#password1', message: 'Password is required!', action: 'keyup, blur', rule: 'required' },
			               { input: '#password2', message: 'Password is required!', action: 'keyup, blur', rule: 'required' },
			               {
			                   input: '#password2', message: 'Passwords doesn\'t match!', action: 'keyup, focus', rule: function (input, commit) {
			                       // call commit with false, when you are doing server validation and you want to display a validation error on this field. 
			                       if (input.val() === $('#password1').val()) {
			                           return true;
			                       }
			                       return false;
			                   }
			               },
			               { input: '#email', message: 'E-mail is required!', action: 'keyup, blur', rule: 'required' },
			               { input: '#email', message: 'Invalid e-mail!', action: 'keyup', rule: 'email' }]
			    });
			    $(".jqx-checkbox").css("margin-top","6.5px");
	});

	$.wait = function(callback, seconds) {
			console.log("start>>" + callback);
			return window.setTimeout(callback, seconds * 1000);
			console.log("finish>>" + callback);
	}

	function fnGetCheckBoxSelected() {
		var ItemArray = new Array();
		$(".userInterests").each(function(){
			var Items = $(this).jqxTree('getItems');
			$.each(Items, function() {
				if (this.checked) {
					var tempid = "#" + this.id;
					ItemArray.push($(tempid).attr("id"));
				};
			});
		});
		console.log(ItemArray.join("#"));
		return ItemArray.join("#");
	}

	function fnSetCheckBoxSelected(strCheckList) {
		var tempArray = new Array();
		tempArray = strCheckList.split("#");
		var i;
		for (i = 0; i < tempArray.length; i++) {
			var tempObj = "#" + tempArray[i];
			$(".userInterests").jqxTree('checkItem', $(tempObj)[0], true);
		}
	}

	function fnFillCountryList() {
		var params = "";
		var request = new Request();
		var myDropDownList = $("#countryId");
		myDropDownList.append($("<option></option>").val(0).html("-Select your country-"));
		$.each(ALLOWED_COUNTRIES, function(index, value) {
			if(value==DEFAULT_COUNTRY){
				
			}
			request.sendGETRequest("/api/jsonws/flask-rest-users-portlet.flaskadmin/get-country-by-name/name/"+value,params, function(data) {
				if (data.responseStatus == 1) {
					var countryObj = data.responseJson;
					myDropDownList.append($("<option></option>").val(countryObj.countryId).html(countryObj.nameCurrentValue));
				} else {
					alert("MESSAGES.ERRORR_REGISTER_USER");
				}
			});
		  
		});	
	}

	function fnFillRegionList(countryId,defStateId) {
		var params = "";
		var request = new Request();
		request.sendGETRequest("/api/jsonws/flask-rest-users-portlet.flaskadmin/get-region/country-id/"+countryId, params, function(data) {
			if (data.responseStatus == 1) {
				var regionObj = data.responseJson;
				console.log(regionObj);
				var myStateList = $("#stateId");
				myStateList.empty();
				
				myStateList.append($("<option></option>").val(0).html("-Select your region-"));
				for (var i = 0; i < regionObj.length; i++) {
					myStateList.append($("<option></option>").val(regionObj[i].regionId).html(regionObj[i].name));
				}
				myStateList.val(defStateId);
			} else {
				alert("MESSAGES.ERRORR_REGISTER_USER");
			}
		});
	}

	$(document).ready(function() {
			fnFillCountryList();
			$("#countryId").change(function() {
				fnFillRegionList($(this).val(),0);
				return false;
			});
			console.log($("#countryId").val());
			if($("#countryId").val()=="0")
			{
				fnFillRegionList(0,0);
			}
			//$("#DOB").jqxDateTimeInput({ width: '257px', height: '35px', formatString: "MM-dd-yyyy" });
			$('.userInterests').jqxTree({ height: 'auto', hasThreeStates: true, checkboxes: true});	  
			$(".jqx-checkbox").css("margin-top","6.5px");
			$.wait(function(){
				$(".icon-folder-open").hide();
			},1);
			if(!Liferay.ThemeDisplay.isSignedIn())	{
				$(".update").hide();
			}else{
				fnShowForm(Liferay.ThemeDisplay.getUserId());
			}	
			$('#DOB').combodate({
				firstItem: 'name',
			    minYear: 1960,
			    maxYear: 2016,
			    smartDays: true
			});
			
			 $(".cssCancel").click(function(){
				  var url = "/home?p_p_id=58&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_58_struts_action=%2Flogin%2Flogin";
				  $(location).attr('href',url);
				 });
	});
