var _flaskLib = {};
_flaskLib.SERVICE_ENDPOINTS = {
				API_PREFIX					:"/api/jsonws",
				GET_COUNTRIES 				: "/flask-rest-users-portlet.flaskadmin/get-countries",
				GET_REGION 					: "/flask-rest-users-portlet.flaskadmin/get-region",
				GET_USA_REGION 				: "/flask-rest-users-portlet.flaskadmin/get-usa-regions",
}

_flaskLib.getFormData = function(formId, model, customGetData){
	var formData = {};
	try {
			$.each(model, function(index, column){
					var ele = $('#'+ formId + ' #'+column.name);
					if(ele !=null){
						var val = ele.val();
						if(val == null || val == undefined){
							if(column.type =='string'){
								val = "";
							}else if(column.type =='long'){
								val = 0;
							}else if(column.type =='date'){
								val = "";
							}else{
								val = "";
							}
						}
						formData[column.name] = val;
					}
			});
			
			if (typeof customGetData == undefined) {
				formData = customGetData(formId, model, formData)
			}
			
		} catch (e) {
		console.log("Error in getting form data. Excception: " + e.message);
	}
	return formData;
}

_flaskLib.loadDataToForm = function(formId, data, model, customSetData){
	try {
		if (customSetData) {
			customSetData(formId, data, model);
		}
	} catch (e) {
		console.log("Error in setting form data. Excception: " + e.message);
	}
}

_flaskLib.loadCountries = function(elementId){
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_flaskLib.SERVICE_ENDPOINTS.GET_COUNTRIES , params, 
					function (data){
							$.each(data, function(key, country) {
								selectList.append($("<option/>", {
							        value: country.countryId,
							        text: country.nameCurrentValue
							    }));
							});
					} ,
					function (data){
						console.log("Error in getting countries: " + data );
					});
	
}

_flaskLib.loadRegions = function(elementId, countryId){
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	var param = {'countryId': countryId};
	flaskRequest.sendGETRequest(_flaskLib.SERVICE_ENDPOINTS.GET_REGION , params, 
					function (data){
							$.each(data, function(key, country) {
								selectList.append($("<option/>", {
							        value: country.countryId,
							        text: country.name
							    }));
							});
					} ,
					function (data){
						console.log("Error in getting regions: " + data );
					});
	
	
}

_flaskLib.loadUSARegions = function(elementId){
	var param = {};
	var request = new Request();
	var selectList = $('#' + elementId);
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_flaskLib.SERVICE_ENDPOINTS.GET_USA_REGION , params, 
					function (data){
							$.each(data, function(key, region) {
								selectList.append($("<option/>", {
							        value: region.regionId,
							        text: region.name
							    }));
							});
					} ,
					function (data){
						console.log("Error in getting USA regions: " + data );
					});
	
}

function showErrorMessage(elementId, msg){
	var ele = $('#'+ elementId);
	ele.text(msg);
	ele.removeClass().addClass('alert alert-error');
	ele.show();
}
function showSuccessMessage(elementId, msg){
	var ele = $('#'+ elementId);
	ele.text(msg);
	ele.removeClass().addClass('alert alert-success');
	ele.show();
}

function hideMessage(elementId){
	var ele = $('#'+ elementId);
	ele.text('');
	ele.hide();
}
