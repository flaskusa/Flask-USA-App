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
			venueForm.trigger('reset');
			_flaskLib.loadCountries('venueCountryId');
			_flaskLib.loadUSARegions('venueStateId');
			$("#venueDataTable").hide();
			$("#formContainer").show();
			fnBuildVenueUpload(imageContainer);	
			if(parseInt($("#venueId").val())==0){
				$("#mcontents").attr("data-toggle","");
				$("#mcontents").css("cursor","not-allowed");
			}
	});
	/* Click handler for save button*/
	
	$(".clsSave").click(function(){
		if($('#venueForm').jqxValidator('validate'))
		saveVenue();
	});
	
	
	/* Click handler for cancel button*/

	$(".clsCancel").click(function(){
		location.reload();
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
	$("#mcontents").click(function(){
		if(parseInt($("#venueId").val())==0){
			_flaskLib.showWarningMessage('action-msg-warning', _venueModel.MESSAGES.ADD_VENUE_FIRST_ERR);
		}
	});
	$("#venueCountryId").change(function() {
		  _flaskLib.loadRegions('venueStateId', $("#venueCountryId").val());
	});		
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
		_flaskLib.loadCountries('venueCountryId',rowData.venueCountryId);
		_flaskLib.loadUSARegions('venueStateId',rowData.venueStateId);
		$("#venueDataTable").hide();
		$("#formContainer").show();
		$(".AddContent").click(function(){
			$("#formContainer").hide();
			$('#venueDetailsForm').hide();
			$("#venueDetailsContainer").show();
			$("#venueDetailsDataTable").show();			
			$("#infoTypeId").val($(this).attr("alt"));
		});
		fnBuildVenueUpload(imageContainer);
		fnShowVenueImages(rowData.venueId,$("#venueGallery"));
		createDetailsTable({},_venueDetailModel.DATA_MODEL.VENUEDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_venueDetailModel.GRID_DATA_MODEL.VENUEDETAILS);
		loadVenueDetailsData(rowData.venueId);
}


/* Save Venue */
function saveVenue(){
		params = _flaskLib.getFormData('venueForm',_venueModel.DATA_MODEL.VENUE,
					function(formId, model, formData){
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
						var IsNew = false; 
						$("#venueForm #venueId").val(data.venueId);
						_flaskLib.showSuccessMessage('action-msg', _venueModel.MESSAGES.SAVE);
						
						if(parseInt(params.venueId) == 0 && parseInt(data.venueId) > 0){
							$("#mcontents").attr("data-toggle","tab");
							$("#mcontents").css("cursor","default");
							IsNew = true;
						}
						if($(".dz-image").length>0) {					
							fnSaveVenueLogo(data.venueId, IsNew);
						}
						else{
							if(IsNew){
										$('.nav-tabs > .active').next('li').find('a').trigger('click');
										createDetailsTable({},_venueDetailModel.DATA_MODEL.VENUEDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_venueDetailModel.GRID_DATA_MODEL.VENUEDETAILS);
										loadVenueDetailsData(data.venueId);
									}
							else{
									$("#venueDataTable").show();
									$("#formContainer").hide();
									loadData();
								}
						}
					} ,
					function (data){
						_flaskLib.showErrorMessage('action-msg', _venueModel.MESSAGES.ERROR);
					});
}

function initForm(){
		var repositoryId = $("#repositoryId").val();
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
    	autoProcessQueue: false
    });
}

function fnSaveVenueLogo(venueId, IsNew){
	$("#_venueId").val(venueId);
	dropZoneLogo.options.autoProcessQueue = true;
	dropZoneLogo.processQueue();
	dropZoneLogo.on("queuecomplete", function (file) {
		
		if(IsNew){
			$('.nav-tabs > .active').next('li').find('a').trigger('click');
			createDetailsTable({},_venueDetailModel.DATA_MODEL.VENUEDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_venueDetailModel.GRID_DATA_MODEL.VENUEDETAILS);
			loadVenueDetailsData(venueId);
		}
		else{
			$("#venueImage").html(""); // Clear upload component
			$("#venueDataTable").show();
			$("#formContainer").hide();
			loadData();
		}		
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

$(document).ready(function(){
	$('#venueForm').jqxValidator
    ({
        hintType: 'label',
        animationDuration: 0,
        rules: [
	               { input: '#venueName', message: 'Venue name is required!', action: 'keyup, blur', rule: 'required' },
	               //{ input: '#venueDescription', message: 'Description is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#addrLine1', message: 'Address 1 is required!', action: 'keyup, blur', rule: 'required' },
	               //{ input: '#addrLine2', message: 'Address 2 is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#venueZipCode', message: 'Zip code is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#venueCity', message: 'City is required!', action: 'keyup, blur', rule: 'required' },
	               { input: '#venueMetroArea', message: 'Metro area is required!', action: 'keyup, blur', rule: 'required' }
               ]
    });
});


function fnShowVenueImages(_eventId,_divObj){
	console.log(_eventId);
	var repositoryId = $("#repositoryId").val();
	var eventId = _eventId;
	var flaskRequest = new Request();
	params= {'repositoryId': repositoryId, 'parentFolderId': 0, 'name': 'Venue'};
	flaskRequest.sendGETRequest(_venueModel.SERVICE_ENDPOINTS.GET_FOLDER , params, 
		function (data){
			folderName = 'Venue-'+eventId;
			var flaskRequestChild = new Request();
			paramsChild= {'repositoryId': repositoryId, 'parentFolderId': data.folderId, 'name': folderName};
			flaskRequestChild.sendGETRequest(_venueModel.SERVICE_ENDPOINTS.GET_FOLDER , paramsChild, 
				function (data){
					fnRenderImages(data.folderId,_divObj);
				} ,
				function (data){console.log(2);});
		} ,
		function (data){console.log(1);});
}

function fnRenderImages(folderId,_divObj){
	$(".eventLogo").removeClass("activeImage");
	//$(_divObj).html("");
	clearImageGallery();
	var flaskRequest = new Request();
	params= {'repositoryId': $("#repositoryId").val(), 'folderId': folderId};
	flaskRequest.sendGETRequest(_venueModel.SERVICE_ENDPOINTS.GET_FILES , params, 
		function (data){
			if(typeof data=="object"){
				console.log(data);
				var iSelected = false;
		    	for(var iCount=0;iCount<data.length;iCount++){
		    		var imgURL = '/documents/'+data[iCount].groupId+'/'+data[iCount].folderId+'/'+data[iCount].title;
				    var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+imgURL+')','data-fileEntryId':data[iCount].fileEntryId});
				    $(objdiv).appendTo($(_divObj));
				    $(objdiv).click(function(){
				    	$(this).toggleClass("activeImage");
				    	if($(".activeImage").length>0){
				    		if(iSelected==false){
				    			var objDel = $('<input/>',{'class':'btn btn-info cssDelImages','type':'button','value':'Delete selected'});
				    			$(objDel).appendTo($(_divObj));
				    			iSelected = true;
				    			$(objDel).click(function(){
				    				$("#spinningSquaresG").show();
				    				$(".activeImage").each(function(){
				    					fnDeleteFileByEntryId($(this).attr("data-fileEntryId"),objDel);
				    					$(this).remove();
				    				});
				    				if($(".activeImage").length==0){
				    					$("#spinningSquaresG").hide();
				    					$(this).remove();
				    					iSelected = false;
				    				}
				    			});
				    		}
				    	}
				    	else{
				    		$(".cssDelImages").remove();
				    		iSelected = false;
				    	}
				    });
		    	}
		    }		
		} ,
		function (data){
			console.log("Error in getting Folder: " + data );
		});	
}

function clearImageGallery(){
	$(".eventLogo").remove();
}