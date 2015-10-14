var imageContainer = $("#venueImage");
var venueForm;
var dropZoneLogo;
var iSelected;
function addClickHandlers() {
	$("#mvenues").click(function(){
		window.location.hash = '#ManageVenue';
	});
	$("#mvcontents").click(function(){
		window.location.hash = '#ManageVenueContent';
	});
	venueForm = $("#venueForm");
	/*	Initialize display elements*/

	$(".cssDelete").hide();
	/* Click handler for add user button*/

	$(".cssAddUser").click(function() {
		window.location.hash = '#ManageVenue';
			$("#venueId").val(0);
			venueForm.trigger('reset');
			_flaskLib.loadCountries('venueCountryId');
			_flaskLib.loadUSARegions('venueStateId');
			$("#venueDataTable").hide();
			$("#formContainer").show();
			fnBuildVenueUpload(imageContainer);
			if (parseInt($("#venueId").val())==0) {
				$("#mvcontents").attr("data-toggle","");
				$("#mvcontents").css("cursor","not-allowed");
			}
	});
	/* Click handler for save button*/

	$(".clsSave").click(function() {
		if ($('#venueForm').jqxValidator('validate'))
			var geocoder = new google.maps.Geocoder();
		geocoder.geocode({
				address : $('#addrLine1').val() +' , '+ $('#venueCity').val()  +' , '+ $('#venueStateId option:selected').text() + ' , '  + $('#venueZipCode').val()  + ' , '  + $('#venueCountryId option:selected').text() ,
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
		    	}else{
		    		_flaskLib.showErrorMessage('action-msg',"Unable to get geo-coordinates for the address. Reason:" + status);

		    	}
		    });

	});


	/* Click handler for cancel button*/

	$(".clsCancel").click(function() {
		location.reload();
	});

	$(".cssDelUser").click(function() {
			GRID_PARAM_VENUE.toggleSelectionMode();
			var flag1=true;
			 if (flag1==true) {
					 $(".cssDelete").show();
					 $(".cssDelUser").hide();
			}
			else {
					 $(".cssDelete").hide();
					 $(".cssDelUser").show();
			}
	});

	$(".cssDelete").click(function() {
			var venueList = GRID_PARAM_VENUE.getCheckedIdList();
			if (venueList.length > 0) {
					deleteMultipleVenues(venueList) ;
			}
			 $(".cssDelete").hide();
			 $(".cssDelUser").show();
			 GRID_PARAM_VENUE.toggleSelectionMode();
	    });

	/*	Toggle search boxes */
	$(".cssSearchUser").click(GRID_PARAM_VENUE.toggleSearchBoxes);
	$("#mvcontents").click(function() {
		if (parseInt($("#venueId").val())==0) {
			_flaskLib.showWarningMessage('action-msg-warning', _venueModel.MESSAGES.ADD_VENUE_FIRST_ERR);
		}
	});
	$("#venueCountryId").change(function() {
		  _flaskLib.loadRegions('venueStateId', $("#venueCountryId").val());
	});
	$(window).hashchange( function(){
		var hash = location.hash;
		switch(hash) {
	    case "#venue":
	    	window.location.reload();
			break;
	    case "#ManageVenue":
	    	$("#mvenues").click();
	        break;
	    case "#ManageVenueContent":
	    	$("#mvcontents").click();
	        break;	        
	    default:
	    	//alert("This is default");
		}		
	});
}

function loadData() {
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

function contextMenuHandler(menuItemText, rowData) {
	var args = event.args;
	if (menuItemText  == "Edit") {
		editVenue(rowData);
		return false;
	}else if (menuItemText == "Delete") {
		var a = window.confirm("Are you sure ?");
		if (a) {
				var flag = false;
				var flaskRequest = new Request();
				params = {};
				flaskRequest.sendGETRequest(_venueModel.SERVICE_ENDPOINTS.GET_ALL_EVENTS, params,
				function(data){/*success handler*/
					var obj = data.Events;
					for (var i=0; i<obj.length; i++) {
							if (obj[i].venueId == rowData.venueId) {
								flag = true;
							}
						};
					if (!flag)
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
						function(data) {
								deleteVenueFolder(venueId);
								_flaskLib.showSuccessMessage('action-msg', _venueModel.MESSAGES.DEL_SUCCESS);
								loadData();
						},
						function(data) {
								_flaskLib.showErrorMessage('action-msg', _venueModel.MESSAGES.DEL_ERR);
						});

}

/* Delete Multiple Venues */
function deleteMultipleVenues(venueList) {
	var param = {'venueList': venueList};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_venueModel.SERVICE_ENDPOINTS.DELETE_VENUES, param,
					function(data) {
							var strVenueIdArray = venueList.split(",");
							for (var iCount=0;iCount<strVenueIdArray.length;iCount++) {
								var _venueId = parseInt(strVenueIdArray[iCount]);
								deleteVenueFolder(_venueId);
							}
							_flaskLib.showSuccessMessage('action-msg', _venueModel.MESSAGES.DEL_SUCCESS);
							loadData();
							$('#grid').jqxGrid('clearselection');
					} ,
					function(data) {
							_flaskLib.showErrorMessage('action-msg', _venueModel.MESSAGES.DEL_ERR);
					});

}

/* Edit Venue */
function editVenue(rowData) {
	window.location.hash = '#ManageVenue';
		var container = $('#venueGallery');
		container.html("");
		_flaskLib.loadDataToForm("venueForm",  _venueModel.DATA_MODEL.VENUE, rowData, function(){});
		_flaskLib.loadCountries('venueCountryId',rowData.venueCountryId);
		_flaskLib.loadUSARegions('venueStateId',rowData.venueStateId);
		$("#venueDataTable").hide();
		$("#formContainer").show();
		$(".AddContent").click(function() {
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
function saveVenue() {
		params = _flaskLib.getFormData('venueForm',_venueModel.DATA_MODEL.VENUE,
					function(formId, model, formData) {
							return formData;
					});
		var flaskRequest = new Request();
		var url = "";
			console.log(params);
			if (params.venueId == 0) {
				url =_venueModel.SERVICE_ENDPOINTS.ADD_VENUE;
			}else {
				url = _venueModel.SERVICE_ENDPOINTS.UPDATE_VENUE;
			}
		flaskRequest.sendGETRequest(url, params,
					function(data) {
						var IsNew = false;
						$("#venueForm #venueId").val(data.venueId);
						_flaskLib.showSuccessMessage('action-msg', _venueModel.MESSAGES.SAVE);
						if (parseInt(params.venueId) == 0 && parseInt(data.venueId) > 0) {
							$("#mvcontents").attr("data-toggle","tab");
							$("#mvcontents").css("cursor","default");
							IsNew = true;
						}
						if ($(".dz-image").length>0) {
							fnSaveVenueLogo(data.venueId, IsNew);
						}
						else {
							if (IsNew) {
										$('.nav-tabs > .active').next('li').find('a').trigger('click');
										createDetailsTable({},_venueDetailModel.DATA_MODEL.VENUEDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_venueDetailModel.GRID_DATA_MODEL.VENUEDETAILS);
										loadVenueDetailsData(data.venueId);
									}
							else {
									$('.nav-tabs > .active').next('li').find('a').trigger('click');
									loadVenueDetailsData(data.venueId);
								}
						}
					} ,
					function(data) {
						_flaskLib.showErrorMessage('action-msg', _venueModel.MESSAGES.ERROR);
					});
}

function initForm() {
	repositoryId = $("#repositoryId").val();
}

function fnBuildVenueUpload(imageContainer) {
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

function fnSaveVenueLogo(venueId, IsNew) {
	$("#_venueId").val(venueId);
	dropZoneLogo.options.autoProcessQueue = true;
	dropZoneLogo.processQueue();
	dropZoneLogo.on("queuecomplete", function(file) {

		if (IsNew) {
			$('.nav-tabs > .active').next('li').find('a').trigger('click');
			createDetailsTable({},_venueDetailModel.DATA_MODEL.VENUEDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_venueDetailModel.GRID_DATA_MODEL.VENUEDETAILS);
			loadVenueDetailsData(venueId);
		}
		else {
			$("#venueImage").html(""); // Clear upload component
			$("#venueDataTable").show();
			$("#formContainer").hide();
			loadData();
		}
	});
}

function fnDeleteFileByTitle(_repositoryId,_folderId,_title,_objDel) {
	params= {repositoryId:_repositoryId ,folderId: _folderId,title:_title};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_venueDetailModel.SERVICE_ENDPOINTS.DELETE_FILE_BY_TITLE , params,
		function(data) {
			if (typeof data=="object") {

			}
		},
		function(data) {

		});
}

$(document).ready(function() {
	window.location.hash = '#venue';
	if($('#venueForm').length == 0)
		return;
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

function fnDeleteVenueImage(venueImageId) {
	params= {'venueImageId': venueImageId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_venueModel.SERVICE_ENDPOINTS.DELETE_VENUE_IMAGE , params,
		function(data) {
			console.log(data);
		},
		function(data) {
			console.log(data);
		});
}

function fnGetVenueImages(venueId,container,editable) {
	params= {'venueId': venueId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_venueModel.SERVICE_ENDPOINTS.GET_VENUE_IMAGES , params,
		function(data) {
			$.each(data, function(idx, obj) {
				fnRenderVenueImage(obj.venueImageUUId,obj.venueImageGroupId, container, obj.venueImageId, editable);
			});
		},
		function(data) {
			console.log(data);
		});
}

function fnRenderVenueImage(venueImageUUId,venueImageGroupId, container,venueImageId,editable) {
	var imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+venueImageUUId+"&groupId="+venueImageGroupId;
	if (editable) {
		var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+imgURL+')','data-uuid':venueImageUUId, 'data-venueImageId': venueImageId,'data-imageURL':imgURL});
		$(objdiv).appendTo($(container));
		$(objdiv).click(function() {
	    	$(this).toggleClass("activeImage");
	    	if ($(".activeImage").length>0) {
	    		if (iSelected==false) {
	    			var objVenueDel = $('<input/>',{'class':'btn btn-info cssDelImages','type':'button','value':'Delete selected'});
	    			$(objVenueDel).appendTo($(container));
	    			iSelected = true;
	    			$(objVenueDel).click(function() {
	    				$("#spinningSquaresG").show();
	    				$(".activeImage").each(function() {
	    					_flaskLib.deleteImage($(this).attr("data-uuid"), venueImageGroupId, objVenueDel);
	    					fnDeleteVenueImage($(this).attr("data-venueImageId"));
	    					$(this).remove();
	    				});
	    				if ($(".activeImage").length==0) {
	    					$("#spinningSquaresG").hide();
	    					$(this).remove();
	    					iSelected = false;
	    				}
	    			});
	    		}
	    	}
	    	else {
	    		$(".cssDelImages").remove();
	    		iSelected = false;
	    	}
	    });
	}
	else{
		var objdiv = $('<div/>',{'class':'GridSlides','style':'background-image:url('+imgURL+')','data-uuid':venueImageUUId, 'data-venueImageId': venueImageId,'data-imageURL':imgURL});
		$(container).owlCarousel({
			items:3,
			navigation:true,
			navigationText:["<i class='icon-chevron-left icon-white'></i>","<i class='icon-chevron-right icon-white'></i>"],
			pagination:true,
		    items : 5,
		    itemsCustom : false,
		    itemsDesktop : [1199,4],
		    itemsDesktopSmall : [980,3],
		    itemsTablet: [768,2],
		    itemsTabletSmall: false,
		    itemsMobile : [479,1],
		    singleItem : false,
		    itemsScaleUp : false,		
		});
		$(container).data('owlCarousel').addItem(objdiv);
		$(objdiv).click(function() {
			var imgContainer = $('.imageContainer');
			imgContainer.html('');
			var objImage = $('<img/>',{'src':$(this).attr('data-imageURL')});
			imgContainer.append(objImage);
	    	$('.md-trigger').click();
		});		
    }	
}


function deleteVenueFolder(_venueId) {
	var param = {'repositoryId': repositoryId,'parentFolderId':0,'name':'Venue'};
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_venueModel.SERVICE_ENDPOINTS.GET_FOLDER , param,
		function(data) {
			var venueFolderName = 'Venue-'+_venueId;
			var param1 = {'repositoryId': repositoryId,'parentFolderId':data.folderId,'name':venueFolderName};
			var flaskRequest1 = new Request();
			flaskRequest1.sendPOSTRequest(_venueModel.SERVICE_ENDPOINTS.DELETE_FOLDER , param1,
					function(data) {
						console.log(data);
					},
					function(data) {
						console.log(data);
					});
		} ,
		function(data) {
			console.log(data);
		});
}
