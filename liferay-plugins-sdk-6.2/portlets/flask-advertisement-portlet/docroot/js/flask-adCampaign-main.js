var adCampaignForm;
var campaignId = 0;
function adCampaignClickHandlers() {
	adCampaignForm = $("#adCampaignForm");
	/* Initialize display elements */

	$("#delCampaignTrash").hide();

	/* Click handler for add user button */

	$("#addCampaign").click(function() {
		adCampaignForm.trigger('reset')
		$("#adCampaignDataTable").hide();
		$("#adCampaignModal").modal({
			show : true,
			backdrop : 'static'
		});
		prepareCustomerDropDownList();
		prepareEventTypeDropdown();
		prepareInfoTypesCheckBox();
		adCampaignForm.show();
		filterData("1");
		campaignId = 0;
	});

	/* Click handler for save button */

	$(".clsSaveCampaign").click(
			function() {
				if (_flaskLib.validateFormData('adCampaignForm','campaign-valid-msg',
						_adCampaignModel.DATA_MODEL.CAMPAIGN, function(formId,
								model, isValid) {
								var x = GRID_PARAM_CAMPAIGN
										.getCheckedEventIdList('eventId');
								if (x.length == 0) {
									_flaskLib.showErrorMessage(
											'campaign-valid-msg',
											'Please select Events.');
									isValid = false;
								}
							return isValid;
						})) {
					saveCampaign();
					$("#adCampaignDataTable").show();
					$("#adCampaignModal").modal('hide');
					adCampaignForm.hide();
				}
			});

	/* Click handler for cancel button */

	$(".clsCancelCampaign").click(function() {
		$("#adCampaignDataTable").show();
		$("#adCampaignModal").modal("hide");
		adCampaignForm.hide();
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

function loadCampaignData() {
	var flaskRequest = new Request();
	params = {};
	flaskRequest.sendGETRequest(
			_adCampaignModel.SERVICE_ENDPOINTS.GET_CAMPAIGN, params, function(
					data) {
				var gridData = prepareDataForCampaignGrid(data);
				GRID_PARAM_CAMPAIGN.updateGrid(gridData);
			}, function(error) { /* failure handler */
				_flaskLib.showErrorMessage(_adCampaignModel.MESSAGES.GET_ERROR);
				console.log("Error in getting data: " + error);
			});
}

function prepareDataForCampaignGrid(data) {
	var gridData = [];
	$
			.each(
					data,
					function(index, campaign) {
						var rowData = {};
						rowData.campaignId = campaign.campaignId;
						rowData.campaignName = campaign.campaignName;
						rowData.frequency = campaign.frequency;
						// rowData.customerName =
						// getCustomerInfo(campaign.customerId).customerName;
						rowData.customerName = _flaskLib.CustomerList[campaign.customerId].customerName;
						rowData.eventType = _flaskLib.EventTypeList[campaign.eventType].eventTypeName;
						rowData.events = prepareEventsNameList(campaign.events);
						rowData.displayAt = prepareDisplayAtList(campaign.displayAt);
						rowData.customerId = campaign.customerId;
						rowData.eventsId = campaign.events;
						rowData.displayAtId = campaign.displayAt;
						rowData.eventTypeId = campaign.eventType;
						gridData.push(rowData);
					});
	return gridData;
}

function prepareEventsNameList(eventsList) {
	var eventsName = "";
	var eventsArray = eventsList.split(",");
	$.each(eventsArray, function(index, event) {
		eventsName += _flaskLib.EventList[event].eventName;
		if (index !== eventsArray.length - 1)
			eventsName += ",";
	});
	return eventsName;
}
function prepareDisplayAtList(displayAt) {
	var displayAtName = "";
	var displayAtArray = displayAt.split(",");
	$.each(displayAtArray, function(index, displayAt) {
		displayAtName += _flaskLib.infoTypeList[displayAt].infoTypeName;
		if (index !== displayAtArray.length - 1)
			displayAtName += ",";
	});
	return displayAtName;
}

function campaignContextMenuHandler(menuItemText, rowData) {
	// var args = event.args;
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
	$("#adCampaignModal").modal({
		show : true,
		backdrop : 'static'
	});
	prepareCustomerDropDownList(rowData.customerId);
	prepareEventTypeDropdown(rowData.eventTypeId);
	prepareInfoTypesCheckBox(rowData.displayAtId);
	adCampaignForm.show();
	filterData(rowData.eventTypeId, rowData.eventsId);
	// _flaskLib.loadUSARegions('CampaignStateId', rowData.CampaignStateId);

}

function saveCampaign() {
	params = _flaskLib.getFormData('adCampaignForm',
			_adCampaignModel.DATA_MODEL.CAMPAIGN, function(formId, model,
					formData) {
				var displayAt = [];
				formData["events"] = GRID_PARAM_CAMPAIGN
						.getCheckedEventIdList('eventId');
				$("input[name='displayAt']:checked").each(function(i) {
					displayAt.push($(this).val());
				});
				formData["displayAt"] = displayAt.toString();
				return formData;
			});
	var flaskRequest = new Request();
	var url = ""
	params.campaignId = campaignId;
	if (params.campaignId == 0) {
		url = _adCampaignModel.SERVICE_ENDPOINTS.ADD_CAMPAIGN;
	} else {
		url = _adCampaignModel.SERVICE_ENDPOINTS.UPDATE_CAMPAIGN;
	}

	flaskRequest.sendPOSTRequest(url, params, function(data) {
		_flaskLib.showSuccessMessage('campaign-action-msg',
				_adCampaignModel.MESSAGES.SAVE);
		loadCampaignData();
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
	var events = _flaskLib.events;
	for (var i = 0; i < events.length; i++) {
		if (events[i].eventTypeId == evenType) {
			// Add Venue Name here
			events[i].venueName = _flaskLib.venues[events[i].venueId].venueName;
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
function prepareCustomerDropDownList(customerId) {
	$(".customerName").remove();
	var customerList = _flaskLib.customers;
	$.each(customerList, function(i, obj) {
		if (customerId) {
			if (customerId == obj.customerId) {
				$("#customerName").append(
						"<option value=" + obj.customerId
								+ " class=customerName selected=selected >"
								+ obj.customerName + "</option>");
			} else {
				$("#customerName").append(
						"<option value=" + obj.customerId
								+ " class=customerName >" + obj.customerName
								+ "</option>");
			}
		} else {
			$("#customerName").append(
					"<option value=" + obj.customerId + " class=customerName >"
							+ obj.customerName + "</option>");
		}
	});
}

function prepareEventTypeDropdown(eventTypeId) {
	$(".eventTypeName").remove();
	var eventTypeList = _flaskLib.eventTypes;
	$.each(eventTypeList, function(i, obj) {
		if (eventTypeId) {
			if (eventTypeId == obj.eventTypeId) {
				$("#eventType").append(
						"<option value=" + obj.eventTypeId
								+ " class=eventTypeName selected=selected >"
								+ obj.eventTypeName + "</option>");
			} else {
				$("#eventType").append(
						"<option value=" + obj.eventTypeId
								+ " class=eventTypeName >" + obj.eventTypeName
								+ "</option>");
			}
		} else {
			$("#eventType").append(
					"<option value=" + obj.eventTypeId
							+ " class=eventTypeName >" + obj.eventTypeName
							+ "</option>");
		}
	});
}

function prepareInfoTypesCheckBox(displayAtId) {
	var displayAtIdList = [];
	if (displayAtId) {
		displayAtIdList = displayAtId.split(",");
	}
	$(".displayAtChk").remove();
	var infoTypeList = _flaskLib.infoTypes;
	$
			.each(
					infoTypeList,
					function(i, obj) {
						if (displayAtId) {
							if (displayAtIdList.indexOf(obj.infoTypeId
									.toString()) >= 0) {
								$("#displayAttemp")
										.append(
												"<span class='displayAtChk'><input type ='checkbox' checked='checked'  name='displayAt' id = 'displayAt'"
														+ i
														+ "' value ="
														+ obj.infoTypeId
														+ " >"
														+ obj.infoTypeName
														+ "</span>&nbsp;&nbsp;");
							} else {
								$("#displayAttemp")
										.append(
												"<span class='displayAtChk'><input type ='checkbox'  name='displayAt' id = 'displayAt'"
														+ i
														+ "' value ="
														+ obj.infoTypeId
														+ " >"
														+ obj.infoTypeName
														+ "</span>&nbsp;&nbsp;");
							}
						} else {
							$("#displayAttemp")
									.append(
											"<span class='displayAtChk'><input type ='checkbox'  name='displayAt' id = 'displayAt'"
													+ i
													+ "' value ="
													+ obj.infoTypeId
													+ " >"
													+ obj.infoTypeName
													+ "</span>&nbsp;&nbsp;");
						}

					});
}
