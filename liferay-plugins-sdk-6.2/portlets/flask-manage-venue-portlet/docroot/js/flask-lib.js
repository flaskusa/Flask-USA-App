var _flaskLib = {};
_flaskLib.SERVICE_ENDPOINTS = {
				API_PREFIX					:"/api/jsonws",
				GET_COUNTRIES 				: "/flask-rest-users-portlet.flaskadmin/get-countries",
				GET_REGION 					: "/flask-rest-users-portlet.flaskadmin/get-region",
				GET_USA_REGION 				: "/flask-rest-users-portlet.flaskadmin/get-usa-regions",
				GET_EVENT_TYPES 			: "/flask-rest-events-portlet.eventtype/get-event-types",
				GET_INFO_TYPE 				: "/flask-rest-events-portlet.infotype/get-info-types",
}

_flaskLib.getFormData = function(formId, model, customGetData){
	var formData = {};
	try {
			$.each(model, function(index, column){
					var ele = $('#'+ formId + ' #'+column.name);
					if(ele.length == 1 ){
						var val = $.trim(ele.val());
						if(column.type == 'long' && val ==''){
							val = Number(val)
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
						ele.val(tempVal)
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

_flaskLib.loadEventTypes = function(elementId, selectedId){
	var param = {};
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_flaskLib.SERVICE_ENDPOINTS.GET_EVENT_TYPES , param, 
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
						console.log("Error in getting EventTypes: " + data );
					});
	
}
_flaskLib.showErrorMessage =   function (elementId, msg){
	var ele = $('#'+ elementId);
	ele.text(msg);
	ele.removeClass().addClass('alert alert-error');
	ele.show();
}
_flaskLib.showSuccessMessage = function (elementId, msg){
	var ele = $('#'+ elementId);
	ele.text(msg);
	ele.removeClass().addClass('alert alert-success');
	ele.show();
}

_flaskLib.hideMessage = function (elementId){
	var ele = $('#'+ elementId);
	ele.text('');
	ele.hide();
}


