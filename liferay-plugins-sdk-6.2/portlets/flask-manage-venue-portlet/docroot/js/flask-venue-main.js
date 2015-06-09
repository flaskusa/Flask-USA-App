var venueForm;
function addClickHandlers(){
	venueForm = $("#venueForm");
	$(".cssAddUser").click(function(){
		venueForm.trigger('reset')
		$("#venueDataTable").hide();
		venueForm.show();
		_flaskLib.loadCountries('venueCountryId');
		_flaskLib.loadUSARegions('venueStateId');
		
		
	});
	
	$(".clsSave").click(function(){
		saveVenue();
	});
	
	$(".clsCancel").click(function(){
		$("#venueDataTable").show();
		$("#venueForm").hide();
	});
	
	$(".cssDelUser").click(function() {
		$("#grid").jqxGrid({selectionmode:'checkbox'});
    });
	
	$(".cssSearchUser").click(function() {
		$("#grid").jqxGrid({
            showfilterrow: true,
            filterable: true,
            filterrowheight: 34
		});
    });		
	
	$("#venueCountryId").change(function() {
		_flaskLib.loadRegions('venueStateId', $("#venueCountryId").val());
    });		
}

function contextMenuHandler(menuItemText, rowData){
	var args = event.args;
	if (menuItemText  == "Edit") {
		editVenue(rowData);
		return false;
	}else if(menuItemText == "Delete"){
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteVenue(rowData.venueId);
		}
		return false;			

	}
};

function deleteVenue(venueId) {
	var param = {'venueId': venueId};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_venueModel.SERVICE_ENDPOINTS.DELETE_VENUE, param, 
					function (data){
							_flaskLib.showSuccessMessage('action-msg', MESSAGE.DEL_SUCCESS);
					} ,
					function (data){
							_flaskLib.showErrorMessage('action-msg', MESSAGE.DEL_ERR);
					});
	
}

function deleteMultipleVenues(venueList) {
	var param = {venueList: venueList};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_venueModel.SERVICE_ENDPOINTS.DELETE_VENUES, param, 
					function (data){
							_flaskLib.showSuccessMessage('action-msg', MESSAGE.DEL_SUCCESS);
					} ,
					function (data){
							_flaskLib.showErrorMessage('action-msg', MESSAGE.DEL_ERR);
					});
	
}

function editVenue(rowData) {
	_flaskLib.loadDataToForm("venueForm",  _venueModel.DATA_MODEL.VENUE, rowData, function(){
		
	});
	$("#venueDataTable").hide();
	venueForm.show();
	_flaskLib.loadCountries('venueCountryId', rowData.venueCountryId);
	_flaskLib.loadUSARegions('venueStateId', rowData.venueStateId);
	
}

function saveVenue(){
	
	params = _flaskLib.getFormData('venueForm',_venueModel.DATA_MODEL.VENUE,
				function(formId, model, formData){
	//						delete formData.venueStateName;
	//						delete formData.venueCountryName;
							return formData;
				});
	var flaskRequest = new Request();
	var url = ""
		if(params.venueId == 0){
			url = _venueModel.SERVICE_ENDPOINTS.ADD_VENUE;
		}else{
			url =_venueModel.SERVICE_ENDPOINTS.UPDATE_VENUE
		}
	
	flaskRequest.sendGETRequest(url, params, 
				function (data){
					_flaskLib.showSuccessMessage('action-msg', MESSAGE.SAVE);
				} ,
				function (data){
					_flaskLib.showErrorMessage('action-msg', MESSAGE.ERROR);
				});

}
