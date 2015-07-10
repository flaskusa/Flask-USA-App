var imageContainer = $("#venueImage");
var venueForm;
var dropZoneLogo;
function addClickHandlers(){
	venueForm = $("#venueForm");
	/*	Initialize display elements*/
	
	$(".cssDelete").hide();	
	/* Click handler for add user button*/
	
	$(".cssAddUser").click(function(){
			$("#venueId").val(0);
			venueForm.trigger('reset')
			$("#venueDataTable").hide();
			$("#formContainer").show();
			fnBuildVenueUpload(imageContainer);		
	});
	/* Click handler for save button*/
	
	$(".clsSave").click(function(){
		saveVenue();
	});
	
	
	/* Click handler for cancel button*/

	$(".clsCancel").click(function(){
			loadData();
			$("#venueDataTable").show();
			$("#formContainer").hide();
	});
	
	$(".cssDelUser").click(function() {
			GRID_PARAM_VENUE.toggleSelectionMode();
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
			var venueList = GRID_PARAM_VENUE.getCheckedIdList();
			if(venueList.length > 0){
					deleteMultipleVenues(venueList) ;	
			}
			 $(".cssDelete").hide();	
			 $(".cssDelUser").show();	
			 GRID_PARAM_VENUE.toggleSelectionMode();
	    });
	
		/*	Toggle search boxes */
		$(".cssSearchUser").click(GRID_PARAM_VENUE.toggleSearchBoxes);
}

function loadData(){
	var flaskRequest = new Request();
	params = {};
	flaskRequest.sendGETRequest(_venueModel.SERVICE_ENDPOINTS.GET_VENUE, params, 
	function(data){/*success handler*/
		GRID_PARAM_VENUE.updateGrid(data);
	} , function(error){ /*failure handler*/
		_flaskLib.showErrorMessage('action-msg',_venueModel.MESSAGES.GET_ERROR);
		console.log("Error in getting data: " + error);
	});
}

function contextMenuHandler(menuItemText, rowData){
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

/* Delete Single Venue */
function deleteVenue(venueId) {
		var param = {'venueId': venueId};
		var request = new Request();
		var flaskRequest = new Request();
		flaskRequest.sendPOSTRequest(_venueModel.SERVICE_ENDPOINTS.DELETE_VENUE , param, 
						function (data){
								_flaskLib.showSuccessMessage('action-msg', _venueModel.MESSAGES.DEL_SUCCESS);
								loadData();
						} ,
						function (data){
								_flaskLib.showErrorMessage('action-msg', _venueModel.MESSAGES.DEL_ERR);
						});
	
}

/* Delete Multiple Venues */
function deleteMultipleVenues(venueList) {
	var param = {'venueIds': venueList};
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

/* Edit Venue */
function editVenue(rowData) {
		var repositoryId = $("#repositoryId").val();
		_flaskLib.loadDataToForm("venueForm",  _venueModel.DATA_MODEL.VENUE, rowData, function(){});
		_flaskLib.loadCountries('venueCountryId');
		_flaskLib.loadUSARegions('venueStateId');
		$("#venueDataTable").hide();
		//venueForm.show();
		$("#formContainer").show();
		$(".AddContent").click(function(){
			$("#formContainer").hide();
			$('#venueDetailsForm').hide();
			$("#venueDetailsContainer").show();
			$("#venueDetailsDataTable").show();			
			$("#infoTypeId").val($(this).attr("alt"));
		})
		fnShowVenueLogo(repositoryId,rowData.venueId,$("#venueImage"), true)
}


/* Save Venue */
function saveVenue(){
		params = _flaskLib.getFormData('venueForm',_venueModel.DATA_MODEL.VENUE,
					function(formId, model, formData){
							/*formData.venueId=$('#venueForm #venueId').val();
							formData.venueName = $('#venueForm #venueId').children(':selected').text();*/
							return formData;
					});
		var flaskRequest = new Request();
		var url = "";
			if(params.venueId == 0){
				url =_venueModel.SERVICE_ENDPOINTS.ADD_VENUE;
			}else{
				url = _venueModel.SERVICE_ENDPOINTS.UPDATE_VENUE;
			}
		flaskRequest.sendGETRequest(url, params, 
					function (data){
						_flaskLib.showSuccessMessage('action-msg', _venueModel.MESSAGES.SAVE);
						fnSaveVenueLogo(data.venueId);
						$("#venueDataTable").show();
						$("#formContainer").hide();
						loadData();
					} ,
					function (data){
						_flaskLib.showErrorMessage('action-msg', _venueModel.MESSAGES.ERROR);
					});
}

function initForm(){
		var repositoryId = $("#repositoryId").val();
		$("#venueDate").jqxDateTimeInput({width: '260px', height: '35px',formatString: "MM-dd-yyyy" });
		$("#Active").jqxCheckBox({ width: 120, height: 25 });
		$("#startTime").jqxDateTimeInput({ width: '100px', height: '23px', formatString: 'hh:mm tt', showCalendarButton: false});
		$("#endTime").jqxDateTimeInput({ width: '250px', height: '25px', formatString: 'hh:mm tt', showCalendarButton: false});
}

function fnBuildVenueUpload(imageContainer){
	$(imageContainer).html(""); 
  	var strSelected = "";
  	dropZoneLogo = "";
    var objForm = $('<form/>',{'class':'dropzone','id':'venueLogoImage','action':$("#imgActionUrl").val()});
    $(objForm).appendTo(imageContainer);
    var objVenueId = $('<input/>',{'name':'_venueId','id':'_venueId','type':'hidden','value':$("#venueId").val()});
    $(objVenueId).appendTo(objForm);
    var objIsLogo = $('<input/>',{'name':'_isLogo','id':'_isLogo','type':'hidden','value':'Y'});
    $(objIsLogo).appendTo(objForm);
    
    dropZoneLogo = new Dropzone($(objForm).get(0),{
    	autoProcessQueue: false,
    	maxFiles: 1,
    	addRemoveLinks : true
    });
}

function fnSaveVenueLogo(venueId){
	$("#_venueId").val(venueId);
	dropZoneLogo.options.autoProcessQueue = true;
	dropZoneLogo.processQueue();
	dropZoneLogo.on("queuecomplete", function (file) {
		$("#venueImage").html(""); // Clear upload component
	});	
}

function fnDeleteFileByTitle(_repositoryId,_folderId,_title,_objDel){
	params= {repositoryId:_repositoryId ,folderId: _folderId,title:_title};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.DELETE_FILE_BY_TITLE , params, 
		function (data){
			if(typeof data=="object"){
				
			}		
		},
		function (data){
			
		});	
}


