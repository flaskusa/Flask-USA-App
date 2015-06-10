var venueForm;
function addClickHandlers(){
	venueForm = $("#venueForm");
	/*	Initialize display elements*/
	
	$(".cssDelete").hide();	
	
	/* Click handler for add user button*/
	
	$(".cssAddUser").click(function(){
		venueForm.trigger('reset')
		$("#venueDataTable").hide();
		venueForm.show();
		_flaskLib.loadCountries('venueCountryId');
		_flaskLib.loadUSARegions('venueStateId');
	});

	/* Click handler for save button*/
	
	$(".clsSave").click(function(){
		saveVenue();
	});


	/* Click handler for cancel button*/

	$(".clsCancel").click(function(){
		$("#venueDataTable").show();
		venueForm.hide();
	});
	
	$(".cssDelUser").click(function() {
		GRID_PARAM.toggleSelectionMode();
		var flag1=true;
		 if (flag1==true) {
			 $(".cssDelete").show();	
			 $(".cssDelUser").hide();	
		}
		else{
			 $(".cssDelete").hide();	
			 $(".cssDelUser").show();	
		}
    });
	
	$(".cssDelete").click(function () {
		var venueList = GRID_PARAM.getCheckedIdList();
		if(venueList.length > 0){
			deleteMultipleVenues(venueList) ;	
		}
		 $(".cssDelete").hide();	
		 $(".cssDelUser").show();	
		 GRID_PARAM.toggleSelectionMode();
    });

	/*	Toggle search boxes */
	$(".cssSearchUser").click(GRID_PARAM.toggleSearchBoxes);			
	
	$("#venueCountryId").change(function() {
		_flaskLib.loadRegions('venueStateId', $("#venueCountryId").val());
    });		
}


function loadData(){
	var flaskRequest = new Request();
	params = {};
	flaskRequest.sendGETRequest(_venueModel.SERVICE_ENDPOINTS.GET_VENUE, params, 
	function(data){/*success handler*/
		GRID_PARAM.updateGrid(data);
	} , function(error){ /*failure handler*/
		showErrorMessage(_venueModel.MESSAGES.GET_ERROR);
		console.log("Error in getting data: " + error);
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
							_flaskLib.showSuccessMessage('action-msg', _venueModel.MESSAGES.DEL_SUCCESS);
							loadData();
					} ,
					function (data){
							_flaskLib.showErrorMessage('action-msg', _venueModel.MESSAGES.DEL_ERR);
					});
	
}

function deleteMultipleVenues(venueList) {
	var param = {venueList: venueList};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_venueModel.SERVICE_ENDPOINTS.DELETE_VENUES, param, 
					function (data){
							_flaskLib.showSuccessMessage('action-msg', _venueModel.MESSAGES.DEL_SUCCESS);
							loadData();
					} ,
					function (data){
							_flaskLib.showErrorMessage('action-msg', _venueModel.MESSAGES.DEL_ERR);
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
						formData.venueStateName = $('#venueStateId').children(':selected').text();
						formData.venueCountryName=$('#venueCountryId').children(':selected').text();;
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
					_flaskLib.showSuccessMessage('action-msg', _venueModel.MESSAGES.SAVE);
					loadData();
				} ,
				function (data){
					_flaskLib.showErrorMessage('action-msg', _venueModel.MESSAGES.ERROR);
				});

}
