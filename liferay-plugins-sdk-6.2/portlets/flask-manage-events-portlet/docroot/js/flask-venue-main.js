var repositoryId;// = $("#repositoryId").val();
var imageContainer = $("#venueImage");
var venueForm;
var dropZoneLogo;
var iSelected;
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
			var geocoder = new google.maps.Geocoder(); 
		geocoder.geocode({
				address : $('#addrLine1').val(), 
				region: 'no'
			},
		    function(results, status) {
		    	if (status.toLowerCase() == 'ok') {
					// Get center
					var coords = new google.maps.LatLng(
						results[0]['geometry']['location'].lat(),
						results[0]['geometry']['location'].lng()
					);
				
					$('#latitude').val(coords.lat());
					$('#longitude').val(coords.lng());
					saveVenue();
		    	}
		    });
		
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
		iSelected = false;
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
				var flag = false;
				var flaskRequest = new Request();
				params = {};
				flaskRequest.sendGETRequest(_venueModel.SERVICE_ENDPOINTS.GET_ALL_EVENTS, params, 
				function(data){/*success handler*/
					var obj = data.Events;
					for(var i=0; i<obj.length; i++){
							if(obj[i].venueId == rowData.venueId){
								flag = true;
							}
						};					
					if(!flag)
						{
							deleteVenue(rowData.venueId);
						}
					else
						{
							_flaskLib.showErrorMessage('action-msg',_venueModel.MESSAGES.CAN_NOT_DELETE);
						}
				} , function(error){ /*failure handler*/
					console.log(error);
				});
			
			
			
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
								deleteVenueFolder(venueId);
								_flaskLib.showSuccessMessage('action-msg', _venueModel.MESSAGES.DEL_SUCCESS);
								loadData();
						},
						function (data){
								_flaskLib.showErrorMessage('action-msg', _venueModel.MESSAGES.DEL_ERR);
						});
	
}

/* Delete Multiple Venues */
function deleteMultipleVenues(venueList) {
	var param = {'venueList': venueList};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_venueModel.SERVICE_ENDPOINTS.DELETE_VENUES, param, 
					function (data){
							var strVenueIdArray = venueList.split(",");
							for(var iCount=0;iCount<strVenueIdArray.length;iCount++){
								var _venueId = parseInt(strVenueIdArray[iCount]);
								deleteVenueFolder(_venueId);
							}
							_flaskLib.showSuccessMessage('action-msg', _venueModel.MESSAGES.DEL_SUCCESS);
							loadData();
							$('#grid').jqxGrid('clearselection');
					} ,
					function (data){
							_flaskLib.showErrorMessage('action-msg', _venueModel.MESSAGES.DEL_ERR);
					});
	
}

/* Edit Venue */
function editVenue(rowData) {
		var container = $('#venueGallery');
		container.html("");
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
		createDetailsTable({},_venueDetailModel.DATA_MODEL.VENUEDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_venueDetailModel.GRID_DATA_MODEL.VENUEDETAILS);
		loadVenueDetailsData(rowData.venueId);
		console.log(rowData);
		fnGetVenueImages(rowData.venueId,container,true);  
}


/* Save Venue */
function saveVenue(){
		params = _flaskLib.getFormData('venueForm',_venueModel.DATA_MODEL.VENUE,
					function(formId, model, formData){
							return formData;
					});
		var flaskRequest = new Request();
		var url = "";
			console.log(params);
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
									$('.nav-tabs > .active').next('li').find('a').trigger('click');
									loadVenueDetailsData(data.venueId);
								}
						}
					} ,
					function (data){
						_flaskLib.showErrorMessage('action-msg', _venueModel.MESSAGES.ERROR);
					});
}

function initForm(){
	repositoryId = $("#repositoryId").val();
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

function fnDeleteVenueImage(venueImageId){
	params= {'venueImageId': venueImageId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_venueModel.SERVICE_ENDPOINTS.DELETE_VENUE_IMAGE , params, 
		function (data){
			console.log(data);
		},
		function (data){
			console.log(data);
		});	
}

function fnGetVenueImages(venueId,container,editable){
	params= {'venueId': venueId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_venueModel.SERVICE_ENDPOINTS.GET_VENUE_IMAGES , params, 
		function (data){
			$.each(data, function(idx, obj) {
				fnRenderVenueImage(obj.venueImageUUId,obj.venueImageGroupId, container, obj.venueImageId, editable);
			});			
		},
		function (data){
			console.log(data);
		});	
}

function fnRenderVenueImage(venueImageUUId,venueImageGroupId, container,venueImageId,editable){
	var imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+venueImageUUId+"&groupId="+venueImageGroupId;
	var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+imgURL+')','data-uuid':venueImageUUId, 'data-venueImageId': venueImageId});
	$(objdiv).appendTo($(container));
	if(editable){
		$(objdiv).click(function(){
	    	$(this).toggleClass("activeImage");
	    	if($(".activeImage").length>0){
	    		if(iSelected==false){
	    			var objVenueDel = $('<input/>',{'class':'btn btn-info cssDelImages','type':'button','value':'Delete selected'});
	    			$(objVenueDel).appendTo($(container));
	    			iSelected = true;
	    			$(objVenueDel).click(function(){
	    				$("#spinningSquaresG").show();
	    				$(".activeImage").each(function(){
	    					_flaskLib.deleteImage($(this).attr("data-uuid"), venueImageGroupId, objVenueDel);
	    					fnDeleteVenueImage($(this).attr("data-venueImageId"));
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


function deleteVenueFolder(_venueId){
	var param = {'repositoryId': repositoryId,'parentFolderId':0,'name':'Venue'};
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_venueModel.SERVICE_ENDPOINTS.GET_FOLDER , param, 
		function (data){
			var venueFolderName = 'Venue-'+_venueId;
			var param1 = {'repositoryId': repositoryId,'parentFolderId':data.folderId,'name':venueFolderName};
			var flaskRequest1 = new Request();
			flaskRequest1.sendPOSTRequest(_venueModel.SERVICE_ENDPOINTS.DELETE_FOLDER , param1,
					function (data){
						console.log(data);
					},
					function (data){
						console.log(data);
					});	
		} ,
		function (data){
			console.log(data);
		});		
}



window.google = window.google || {};
google.maps = google.maps || {};
(function() {
  
  function getScript(src) {
    document.write('<' + 'script src="' + src + '"><' + '/script>');
  }
  
  var modules = google.maps.modules = {};
  google.maps.__gjsload__ = function(name, text) {
    modules[name] = text;
  };
  
  google.maps.Load = function(apiLoad) {
    delete google.maps.Load;
    apiLoad([0.009999999776482582,[[["https://mts0.googleapis.com/vt?lyrs=m@317000000\u0026src=api\u0026hl=en-US\u0026","https://mts1.googleapis.com/vt?lyrs=m@317000000\u0026src=api\u0026hl=en-US\u0026"],null,null,null,null,"m@317000000",["https://mts0.google.com/vt?lyrs=m@317000000\u0026src=api\u0026hl=en-US\u0026","https://mts1.google.com/vt?lyrs=m@317000000\u0026src=api\u0026hl=en-US\u0026"]],[["https://khms0.googleapis.com/kh?v=178\u0026hl=en-US\u0026","https://khms1.googleapis.com/kh?v=178\u0026hl=en-US\u0026"],null,null,null,1,"178",["https://khms0.google.com/kh?v=178\u0026hl=en-US\u0026","https://khms1.google.com/kh?v=178\u0026hl=en-US\u0026"]],null,[["https://mts0.googleapis.com/vt?lyrs=t@132,r@317000000\u0026src=api\u0026hl=en-US\u0026","https://mts1.googleapis.com/vt?lyrs=t@132,r@317000000\u0026src=api\u0026hl=en-US\u0026"],null,null,null,null,"t@132,r@317000000",["https://mts0.google.com/vt?lyrs=t@132,r@317000000\u0026src=api\u0026hl=en-US\u0026","https://mts1.google.com/vt?lyrs=t@132,r@317000000\u0026src=api\u0026hl=en-US\u0026"]],null,null,[["https://cbks0.googleapis.com/cbk?","https://cbks1.googleapis.com/cbk?"]],[["https://khms0.googleapis.com/kh?v=86\u0026hl=en-US\u0026","https://khms1.googleapis.com/kh?v=86\u0026hl=en-US\u0026"],null,null,null,null,"86",["https://khms0.google.com/kh?v=86\u0026hl=en-US\u0026","https://khms1.google.com/kh?v=86\u0026hl=en-US\u0026"]],[["https://mts0.googleapis.com/mapslt?hl=en-US\u0026","https://mts1.googleapis.com/mapslt?hl=en-US\u0026"]],[["https://mts0.googleapis.com/mapslt/ft?hl=en-US\u0026","https://mts1.googleapis.com/mapslt/ft?hl=en-US\u0026"]],[["https://mts0.googleapis.com/vt?hl=en-US\u0026","https://mts1.googleapis.com/vt?hl=en-US\u0026"]],[["https://mts0.googleapis.com/mapslt/loom?hl=en-US\u0026","https://mts1.googleapis.com/mapslt/loom?hl=en-US\u0026"]],[["https://mts0.googleapis.com/mapslt?hl=en-US\u0026","https://mts1.googleapis.com/mapslt?hl=en-US\u0026"]],[["https://mts0.googleapis.com/mapslt/ft?hl=en-US\u0026","https://mts1.googleapis.com/mapslt/ft?hl=en-US\u0026"]],[["https://mts0.googleapis.com/mapslt/loom?hl=en-US\u0026","https://mts1.googleapis.com/mapslt/loom?hl=en-US\u0026"]]],["en-US","US",null,0,null,null,"https://maps.gstatic.com/mapfiles/","https://csi.gstatic.com","https://maps.googleapis.com","https://maps.googleapis.com",null,"https://maps.google.com","https://gg.google.com","https://maps.gstatic.com/maps-api-v3/api/images/","https://www.google.com/maps",0],["https://maps.gstatic.com/maps-api-v3/api/js/21/9a","3.21.9a"],[3357517692],1,null,null,null,null,null,"",null,null,1,"https://khms.googleapis.com/mz?v=178\u0026",null,"https://earthbuilder.googleapis.com","https://earthbuilder.googleapis.com",null,"https://mts.googleapis.com/vt/icon",[["https://mts0.googleapis.com/vt","https://mts1.googleapis.com/vt"],["https://mts0.googleapis.com/vt","https://mts1.googleapis.com/vt"],null,null,null,null,null,null,null,null,null,null,["https://mts0.google.com/vt","https://mts1.google.com/vt"],"/maps/vt",317000000,132],2,500,[null,"https://g0.gstatic.com/landmark/tour","https://g0.gstatic.com/landmark/config",null,"https://www.google.com/maps/preview/log204","","https://static.panoramio.com.storage.googleapis.com/photos/",["https://geo0.ggpht.com/cbk","https://geo1.ggpht.com/cbk","https://geo2.ggpht.com/cbk","https://geo3.ggpht.com/cbk"]],["https://www.google.com/maps/api/js/master?pb=!1m2!1u21!2s9a!2sen-US!3sUS!4s21/9a","https://www.google.com/maps/api/js/widget?pb=!1m2!1u21!2s9a!2sen-US"],null,1,null,"/maps/api/js/ApplicationService.GetEntityDetails",0,null,null,[null,null,null,null,null,null,null,null,null,[0,0],[0,null,0,"0","0"]]], loadScriptTime);
  };
  var loadScriptTime = (new Date).getTime();
  getScript("https://maps.gstatic.com/maps-api-v3/api/js/21/9a/main.js");
})();