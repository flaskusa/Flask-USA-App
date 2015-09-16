var adCampaignForm;
var campaignId = 0;
var dropZoneImages;
var infoTypeJson;
var allEvents = [];

function adCampaignClickHandlers() {
	adCampaignForm = $("#addCampaignForm");
	/* Initialize display elements */

	$("#delCampaignTrash").hide();

	/* Click handler for add user button */

	$("#addCampaign").click(function() {
		adCampaignForm.reset();
		$("#adCampaignDataTable").hide();
		prepareCustomerDropDownList('customerId');
		prepareEventTypeDropdown('eventTypeId', 1);
		loadEventData("1");
		setCampaignFormVisible(true);
		campaignId = 0;
	});

	/* Click handler for save button */

	$("#saveCampaign").click(
			function() {
					saveCampaign();
			});

	/* Click handler for cancel button */

	$("#cancelCampaign").click(function() {
		$("#adCampaignDataTable").show();
		setCampaignFormVisible(false);
	});

	$("#delCampaignList").click(function() {
		GRID_PARAM_CAMPAIGN.toggleSelectionMode();
		var flag1 = true;
		if (flag1 == true) {
			$("#delCampaignTrash").show();
			$("#delCampaignList").hide();
		} else {
			$("#delCampaignTrash").hide();
			$("#delCampaignList").show();
		}
	});

	$("#delCampaignTrash").click(function() {
		var CampaignList = GRID_PARAM_CAMPAIGN.getCheckedIdList();
		if (CampaignList.length > 0) {
			deleteMultipleCampaigns(CampaignList);
		}
		$("#delCampaignTrash").hide();
		$("#delCampaignList").show();
		GRID_PARAM_CAMPAIGN.toggleSelectionMode();
	});

	/* Toggle search boxes */
	$("#searchCampaign").click(GRID_PARAM_CAMPAIGN.toggleSearchBoxes);

}

function setCampaignFormVisible(visible){
	if(visible == true){
		$("#adCampaignFormContainer").show();
		fnBuildCampaignUpload($("#FileUploadComponent"))
		adCampaignForm.show();
	}else{
		$("#adCampaignFormContainer").hide();
		adCampaignForm.hide;
	}
	
	
}
function loadEvents(){
	var flaskRequest = new Request();
	var params = {};
	flaskRequest.sendGETRequest(_adCampaignModel.SERVICE_ENDPOINTS.GET_EVENT, params, 
	function(data){/*success handler*/
		allEvents = eval(data);
		var date;
		$.each(allEvents.Events, function(index, event){
			var eventDate = event.eventDate;
			date = new Date(eventDate);
			event.eventDate = date.getMonth()+"/"+date.getDate()+"/"+date.getFullYear();
		});
	} , function(error){ /*failure handler*/
		_flaskLib.showErrorMessage('action-msg',_eventModel.MESSAGES.GET_ERROR);
		console.log("Error in getting data: " + error);
	});
}

function loadCampaignData() {
	var flaskRequest = new Request();
	params = {};
	flaskRequest.sendGETRequest(
			_adCampaignModel.SERVICE_ENDPOINTS.GET_CAMPAIGN, params, function(
					data) {
				GRID_PARAM_CAMPAIGN.updateGrid(data);
			}, function(error) { /* failure handler */
				_flaskLib.showErrorMessage(_adCampaignModel.MESSAGES.GET_ERROR);
				console.log("Error in getting data: " + error);
			});
}


function loadEventData(eventTypeId){
	var flaskRequest = new Request();
	params = {};
	flaskRequest.sendGETRequest(_adCampaignModel.SERVICE_ENDPOINTS.GET_EVENT, params, 
	function(data){/*success handler*/
		var events = eval(data);
		createEventsTable(events.Events, $("#campaignEvents"));
			
	} , function(error){ /*failure handler*/
		_flaskLib.showErrorMessage('action-msg',_eventModel.MESSAGES.GET_ERROR);
		console.log("Error in getting data: " + error);
	});
}

function campaignContextMenuHandler(menuItemText, rowData) {
	campaignId = rowData.campaignId;
	if (menuItemText == "Edit") {
		editCampaign(rowData);
		return false;
	} else if (menuItemText == "Delete") {
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteCampaign(rowData.campaignId);
		}
		return false;
	}
};

function deleteCampaign(campaignId) {
	var param = {
		'campaignId' : campaignId
	};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(
			_adCampaignModel.SERVICE_ENDPOINTS.DELETE_CAMPAIGN, param,
			function(data) {
				_flaskLib.showSuccessMessage('campaign-action-msg',
						_adCampaignModel.MESSAGES.DEL_SUCCESS);
				loadCampaignData();
			}, function(data) {
				_flaskLib.showErrorMessage('campaign-action-msg',
						_adCampaignModel.MESSAGES.DEL_ERR);
			});

}

function deleteMultipleCampaigns(CampaignList) {
	var param = {
		campaignList : CampaignList
	};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(
			_adCampaignModel.SERVICE_ENDPOINTS.DELETE_CAMPAIGNS, param,
			function(data) {
				_flaskLib.showSuccessMessage('campaign-action-msg',
						_adCampaignModel.MESSAGES.DEL_SUCCESS);
				loadCampaignData();
			}, function(data) {
				_flaskLib.showErrorMessage('campaign-action-msg',
						_adCampaignModel.MESSAGES.DEL_ERR);
			});

}

function editCampaign(rowData) {
	_flaskLib.loadDataToForm("adCampaignForm",
			_adCampaignModel.DATA_MODEL.CAMPAIGN, rowData, function(formId,
					model, data) {
			});
	$("#adCampaignDataTable").hide();
	prepareEventTypeDropdown('eventTypeId',rowData.eventTypeId);
	prepareCustomerDropDownList('customerId', rowData.customerId);
	fnGetCampaignImages(rowData.campaignId,$("#campaignDetailGallery"), true);
	var param = {campaignId : rowData.campaignId};
		var flaskRequest = new Request();
		flaskRequest.sendGETRequest(
				_adCampaignModel.SERVICE_ENDPOINTS.GET_CAMPAIGN_EVENTS, param,
				function(data) {
					var eventsId = "";
					for(var i = 0; i < data.length; i++){
						var campEvent = data[i];
						eventsId += campEvent.eventId;
						if(i < data.length - 1)
							eventsId += ",";
					}
					filterData(rowData.eventTypeId,eventsId);
				}, function(data) {
					_flaskLib.showErrorMessage('campaign-action-msg',
							_adCampaignModel.MESSAGES.DEL_ERR);
				});
	setCampaignFormVisible(true);
}

function saveCampaign() {
	params = _flaskLib.getFormData('adCampaignForm',
			_adCampaignModel.DATA_MODEL.CAMPAIGN, function(formId, model,
					formData) {
				var displayAt = [];
				formData["events"] = GRID_PARAM_CAMPAIGN.getCheckedEventIdList('eventId');
				formData["customerId"] = $('#customerId').val();
				formData["customerName"] = null;
				$("input[name^='display']").each(function(i) {
					if($(this).attr("checked")=='checked'){
						formData[$(this).attr("name")] = true;
					}
					else{
						formData[$(this).attr("name")] = false;
					}
				});
				return formData;
			});
	var flaskRequest = new Request();
	var url = ""
	params.adDisplayTime = null;
	if (campaignId == 0) {
		url = _adCampaignModel.SERVICE_ENDPOINTS.ADD_CAMPAIGN;
	} else {
		params.campaignId = campaignId;
		url = _adCampaignModel.SERVICE_ENDPOINTS.UPDATE_CAMPAIGN;
	}

	flaskRequest.sendPOSTRequest(url, params, function(data) {
		_flaskLib.showSuccessMessage('campaign-action-msg',
				_adCampaignModel.MESSAGES.SAVE);
		if($(".dz-image").length>0) {					
			$("#_campaignId").val(data.campaignId);
			dropZoneImages.options.autoProcessQueue = true;
			dropZoneImages.processQueue();
			dropZoneImages.on("queuecomplete", function (file) {
				loadCampaignData();
				$("#adCampaignDataTable").show();
				setCampaignFormVisible(false);
			});			
		}
		else{
			loadCampaignData();
			$("#adCampaignDataTable").show();
			setCampaignFormVisible(false);
		}			
	}, function(data) {
		_flaskLib.showErrorMessage('campaign-action-msg',
				_adCampaignModel.MESSAGES.ERROR);
	});

}

function filterData(evenType, eventsId) {
	var filterdData = [];
	if (eventsId)
		var selectedEventsArray = eventsId.split(",");
	var eventsIndex = [];
	var events = allEvents.Events;
	for (var i = 0; i < events.length; i++) {
		if (events[i].eventTypeId == evenType) {
			// Add Venue Name here
//			events[i].venueName = _flaskLib.venues[events[i].venueId].venueName;
			filterdData.push(events[i]);
			if (eventsId
					&& selectedEventsArray
							.indexOf(events[i].eventId.toString()) >= 0) {
				eventsIndex.push(filterdData.length - 1);
			}
		}
	}
	createEventsTable(filterdData, $("#campaignEvents"), eventsIndex);
}
function prepareCustomerDropDownList(elementId, selectedId) {
	var flaskRequest = new Request();
	var selectList = $('#' + elementId);
	flaskRequest.sendGETRequest(
			_adCustomerModel.SERVICE_ENDPOINTS.GET_ALL_CUSTOMER, {}, function(
					data) {
				selectList.empty();
				$.each(data, function(key, customer) {
					selectList.append($("<option/>", {
						value : customer.customerId,
						text : customer.customerName
					}));
				});
				if(selectedId) selectList.val(selectedId);
				
			}, function(data) {
				console.log("Error in getting Customers: " + data);
			});

}

function prepareEventTypeDropdown(elementId, selectedEventTypeId) {
	_flaskLib.loadEventType(elementId, selectedEventTypeId);
}

function getInfoTypes(){
		var flaskRequest = new Request();
		flaskRequest.sendGETRequest(
				_adCampaignModel.SERVICE_ENDPOINTS.GET_INFO_TYPES, {},
				function(data) {
					infoTypeJson = data;
				}, function(data) {
					console.log("Error in getting get info type: " + data);
				});

}

function fnBuildCampaignUpload(imageContainer){
	$(imageContainer).html(""); 
  	var strSelected = "";
  	dropZoneImages = "";
    var objForm = $('<form/>',{'class':'dropzone','id':'campaignImages','action':$("#imgActionUrl").val()});
    $(objForm).appendTo(imageContainer);
    var objCampaignId = $('<input/>',{'name':'_campaignId','id':'_campaignId','type':'hidden','value':$("#campaignId").val()});
    $(objCampaignId).appendTo(objForm);
    
    dropZoneImages = new Dropzone($(objForm).get(0),{
    	autoProcessQueue: false,
    	uploadMultiple: true,
    	addRemoveLinks : true
    });
}

function fnGetCampaignImages(campaignId,container,editable){
	params= {'campaignId': campaignId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_adCampaignModel.SERVICE_ENDPOINTS.GET_CAMPAIGN_IMAGES , params, 
		function (data){
			$.each(data, function(idx, obj) {
				fnRenderImage(obj.imageUUID, obj.imageGroupId, container, obj.campaignImageId, editable);
			});			
		},
		function (data){
			console.log(data);
		});	
}

function fnRenderImage(imageUUID, imageGroupId, container, eventDetailImageId, editable){
	var imgURL = _flaskLib.UTILITY.IMAGES_PATH + "?uuid="+imageUUID+"&groupId="+imageGroupId;
	var objdiv = $('<div/>',{'class':'eventLogo','style':'background-image:url('+imgURL+')','data-uuid':imageUUID, 'data-campaignImageId': eventDetailImageId});
	$(objdiv).appendTo($(container));
	if(editable){
    	$(objdiv).click(function(){
	    	$(this).toggleClass("activeImage");
	    	if($(".activeImage").length>0){
	    		if(iSelected==false){
	    			var objDel = $('<input/>',{'class':'btn btn-info cssDelImages','type':'button','value':'Delete selected'});
	    			$(objDel).appendTo($(container));
	    			iSelected = true;
	    			$(objDel).click(function(){
	    				$("#spinningSquaresG").show();
	    				$(".activeImage").each(function(){
	    					_flaskLib.deleteImage($(this).attr("data-uuid"), imageGroupId, objDel);
	    					fnDeleteCampaignImage($(this).attr("data-campaignImageId"));
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

function fnDeleteCampaignImage(campaignImageId){
	params= {'campaignImageId': campaignImageId};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_adCampaignModel.SERVICE_ENDPOINTS.DELETE_CAMPAIGN_IMAGE , params, 
		function (data){
			console.log(data);
		},
		function (data){
			console.log(data);
		});	
}