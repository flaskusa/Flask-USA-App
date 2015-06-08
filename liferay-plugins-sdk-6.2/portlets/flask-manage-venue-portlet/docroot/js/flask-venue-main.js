function addClickHandlers(){
	$(".cssAddUser").click(function(){
		$("#venueDataTable").hide();
		$("#venueForm").show();
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
	
}


function fnDelete(id) {
	alert("fnDelete" + id)
	//show spinner
	 //call rest 
	//on success remove from row update message
	//on failure just update message
}

function fnEdit(rowData) {
	//show form
	 //hide table 
	alert("fnDelete" + rowData)
	
		// make ajax calls for any new data
	
}

function saveVenue(){
	params = _flaskLib.getFormData('venueForm',DATA_MODEL.VENUE,function(formId, model, formData){
		return formData;
	});
	params.countryId = 19;
	params.stateId = 19023;
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(SERVICE_ENDPOINTS.ADD_VENUE, params, 
				function (data){
					showSuccessMessage('action-msg', MESSAGE.SAVE);
				} ,
				function (data){
					showErrorMessage('action-msg', MESSAGE.ERROR);
				});

}
