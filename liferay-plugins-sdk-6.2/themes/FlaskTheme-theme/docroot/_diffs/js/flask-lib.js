var _flaskLib = {};

_flaskLib.UTILITY = {
		IMAGES_PATH			: "/c/document_library/get_file",
		DEFAULT_PROFILE_PIC	: "/document_library/DefaultProfilePic",
		DEFAULT_NO_IMAGE	: "/document_library/NoImageFound",
		GRID_GROUP_EXPAND   : true
}

_flaskLib.SERVICE_ENDPOINTS = {
		API_PREFIX					: "/api/jsonws",
		GET_COUNTRIES 				: "/flask-rest-users-portlet.flaskadmin/get-countries",
		GET_REGION 					: "/flask-rest-users-portlet.flaskadmin/get-region",
		GET_USA_REGION 				: "/flask-rest-users-portlet.flaskadmin/get-usa-regions",
		DELETE_FILES				: "/dlapp/delete-file-entry",
		GET_FILE_ENTRY_ID   		: "/dlapp/get-file-entry-by-uuid-and-group-id",
		GET_EVENT_TYPES 			: "/flask-rest-events-portlet.eventtype/get-event-types",
		GET_EVENT_CAMPAIGNS			: "/flask-advertisement-portlet.campaignevent/get-event-campaigns",
		GET_CAMPAIGN_EVENTS			: "/flask-advertisement-portlet.campaignevent/get-campaign-events",
		GET_CAMPAIGN_EVENTS			: "/flask-advertisement-portlet.campaignevent/get-campaign-events",
		GET_CAMPAIGN_IMAGES			: "/flask-advertisement-portlet.adcampaign/get-campaign-with-images"
			
}

_flaskLib.getFormData = function(formId, model, customGetData){
	var formData = {};
	try {
			$.each(model, function(index, column){
					var ele = $('#'+ formId + ' #'+column.name);
					if(ele.length == 1 ){
						var val = $.trim(ele.val());
						if(column.type == 'long' && val !=''){
							val = Number(val)
						}
						if(column.type == 'booelan'){
							val = ele.checked;
							
						}
						formData[column.name] = val;
					}
			});
			
			if (typeof customGetData != undefined) {
				formData = customGetData(formId, model, formData)
			}
			
		} catch (e) {
		console.log("Error in getting form data. Excception: " + e.message);
	}
	return formData;
}

_flaskLib.loadDataToForm = function(formId, model, data,  customSetData){
	try {
		$.each(model, function(index, column){
				var ele = $('#'+ formId + ' #'+column.name);
				if( ele.length == 1 && typeof ele[0].tagName != undefined){
					if(ele[0].tagName.toLowerCase() =='input'){
						var tempVal =eval("data." + column.name);
						tempVal = tempVal == undefined ? "" : tempVal;
						if(column.datatype=="boolean"){
							tempVal = tempVal =="" ? false:tempVal;
							ele.checked = tempVal;
						}else{
							ele.val(tempVal)
						}
					}
				}
		});
		if (typeof customSetData != undefined) {
			customSetData(formId, model, data)
		}
	} catch (e) {
		console.log("Error in setting form data. Excception: " + e.message);
	}
}

_flaskLib.loadCountries = function(elementId,selectedId){
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_flaskLib.SERVICE_ENDPOINTS.GET_COUNTRIES , {}, 
					function (data){
							selectList.empty();
							$.each(data, function(key, country) {
								selectList.append($("<option/>", {
							        value: country.countryId,
							        text: country.nameCurrentValue
							    }));
							});
							selectList.val(selectedId);
					} ,
					function (data){
						console.log("Error in getting countries: " + data );
					});
	
}

/**
 * 
 */
_flaskLib.loadRegions = function(elementId, countryId, selectedId){
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	var param = {countryId: countryId};
	flaskRequest.sendGETRequest(_flaskLib.SERVICE_ENDPOINTS.GET_REGION , param, 
					function (data){
							selectList.empty();
							$.each(data, function(key, country) {
								selectList.append($("<option/>", {
							        value: country.countryId,
							        text: country.name
							    }));
							});
							selectList.val(selectedId);
					} ,
					function (data){
						console.log("Error in getting regions: " + data );
					});
	
	
}

_flaskLib.loadUSARegions = function(elementId, selectedId){
	var param = {};
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_flaskLib.SERVICE_ENDPOINTS.GET_USA_REGION , param, 
					function (data){
							selectList.empty();
							$.each(data, function(key, region) {
								selectList.append($("<option/>", {
							        value: region.regionId,
							        text: region.name
							    }));
							});
							selectList.val(selectedId);
					} ,
					function (data){
						console.log("Error in getting USA regions: " + data );
					});
	
}

_flaskLib.showErrorMessage =   function (elementId, msg){
	if(typeof elementId=="object")
		var ele = $(elementId);
	else
		var ele = $('#'+ elementId);

	ele.text(msg);
	ele.removeClass().addClass('alert alert-error');
	ele.show();
	$('html').click(function() {
		$("#action-msg").delay(500).fadeOut(500);
	});	
}
_flaskLib.showSuccessMessage = function (elementId, msg){
	if(typeof elementId=="object")
		var ele = $(elementId);
	else
		var ele = $('#'+ elementId);

	ele.text(msg);
	ele.removeClass().addClass('alert alert-success');
	ele.show();
	$(ele).delay(3000).fadeOut(1000);	
}
_flaskLib.showWarningMessage = function (elementId, msg){
	if(typeof elementId=="object")
		var ele = $(elementId);
	else
		var ele = $('#'+ elementId);
	ele.text(msg);
	ele.removeClass().addClass('alert alert-warning');
	ele.show();
	$(ele).delay(3000).fadeOut(1000);
}
_flaskLib.showInformationMessage = function (elementId, msg){
	if(typeof elementId=="object")
		var ele = $(elementId);
	else
		var ele = $('#'+ elementId);
	ele.text(msg);
	ele.removeClass().addClass('alert alert-info');
	ele.show();
	$(ele).delay(5000).fadeOut(1000);
}

_flaskLib.hideMessage = function (elementId){
	var ele = $('#'+ elementId);
	ele.text('');
	ele.hide();
}

_flaskLib.loadCountries = function(elementId,selectedId){
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_flaskLib.SERVICE_ENDPOINTS.GET_COUNTRIES , {}, 
			function (data){
					selectList.empty();
					$.each(data, function(key, country) {
						selectList.append($("<option/>", {
					        value: country.countryId,
					        text: country.nameCurrentValue
					    }));
					});
					selectList.val(selectedId);
			} ,
			function (data){
				console.log("Error in getting countries: " + data );
			});
}

_flaskLib.loadEventType = function(elementId,selectedId){
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_flaskLib.SERVICE_ENDPOINTS.GET_EVENT_TYPES , {}, 
					function (data){
							selectList.empty();
							$.each(data, function(key, eventType) {
								selectList.append($("<option/>", {
							        value: eventType.eventTypeId,
							        text: eventType.eventTypeName
							    }));
							});
							selectList.val(selectedId);
					} ,
					function (data){
						console.log("Error in getting Event Type: " + data );
					});
	
}

_flaskLib.deleteImage = function(uuid, groupId, objDel){
	var params = {'uuid': uuid, 'groupId': groupId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_flaskLib.SERVICE_ENDPOINTS.GET_FILE_ENTRY_ID , params, 
			function (data){
					console.log(data);
					params2= {'fileEntryId': data.fileEntryId};
					var flaskRequest2 = new Request();
					flaskRequest2.sendGETRequest(_flaskLib.SERVICE_ENDPOINTS.DELETE_FILES , params2, 
						function (data){
							if(typeof data=="object"){
								console.log("Deleted Image successfully");    		
							}		
						},
						function (data){
							$("#spinningSquaresG").hide();
						});	
					console.log("Image Deleted successfully");
			} ,
			function (data){
				console.log("Error in deleting image");
			});
}

_flaskLib.setCookie = function(key, value) {
    var expires = new Date();
    expires.setTime(expires.getTime() + (1 * 24 * 60 * 60 * 1000));
    document.cookie = key + '=' + value + ';expires=' + expires.toUTCString();
}

_flaskLib.getCookie = function(key) {
    var keyValue = document.cookie.match('(^|;) ?' + key + '=([^;]*)(;|$)');
    return keyValue ? keyValue[2] : null;
}
