var imageContainer = $("#eventImage");
var eventForm;
var dropZoneLogo;
var edit = false;
function addClickHandlers() {
	eventForm = $("#eventForm");
	/*	Initialize display elements*/

	$(".cssDelete").hide();
	/* Click handler for add user button*/

	$(".cssAddUser").click(function() {
			$("#eventId").val(0);
			eventForm.trigger('reset')
			$("#eventDataTable").hide();
			$("#formContainer").show();
			_eventModel.loadVenues('venueId');
			_eventModel.loadEventType('eventTypeId');
			fnBuildEventUpload(imageContainer);
			if (parseInt($("#eventId").val())==0) {
				$("#mcontents").attr("data-toggle","");
				$("#mcontents").css("cursor","not-allowed");
			}
	});
	/* Click handler for save button*/

	$(".clsSave").click(function() {
		if ($('#eventForm').jqxValidator('validate'))
			saveEvent();
	});

	/* Click handler for cancel button*/

	$(".clsCancel").click(function() {
		 location.reload();
	});

	$(".cssDelUser").click(function() {
			GRID_PARAM.toggleSelectionMode();
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
			var eventList = GRID_PARAM.getCheckedIdList();
			if (eventList.length > 0) {
					deleteMultipleEvents(eventList) ;
			}
			 $(".cssDelete").hide();
			 $(".cssDelUser").show();
			 GRID_PARAM.toggleSelectionMode();
	    });

		/*	Toggle search boxes */
		$(".cssSearchUser").click(GRID_PARAM.toggleSearchBoxes);

		$("#mcontents").click(function() {
			if (parseInt($("#eventId").val())==0) {
				_flaskLib.showWarningMessage('action-msg-warning', _eventModel.MESSAGES.ADD_EVENT_FIRST_ERR);
			}
		});
}

function loadData() {
	var flaskRequest = new Request();
	params = {};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_EVENT, params,
	function(data){/*success handler*/
		var events = eval(data);
		GRID_PARAM.updateGrid(events.Events);
	} , function(error){ /*failure handler*/
		_flaskLib.showErrorMessage('action-msg',_eventModel.MESSAGES.GET_ERROR);
		console.log("Error in getting data: " + error);
	});
}

function contextMenuHandler(menuItemText, rowData) {
	var args = event.args;
	if (menuItemText  == "Edit") {
		editEvent(rowData);
		return false;
	}else if (menuItemText == "Delete") {
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteEvent(rowData.eventId);
		}
		return false;
	}
};

function deleteEventFolder(_eventId) {
	var param = {'repositoryId': _repositoryId,'parentFolderId':0,'name':'Event'};
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , param,
		function(data) {
			var eventFolderName = 'Event-'+_eventId;
			var param1 = {'repositoryId': _repositoryId,'parentFolderId':data.folderId,'name':eventFolderName};
			var flaskRequest1 = new Request();
			flaskRequest1.sendPOSTRequest(_eventModel.SERVICE_ENDPOINTS.DELETE_FOLDER , param1,
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

/* Delete Single Event */
function deleteEvent(eventId) {
		var param = {'eventId': eventId};
		var request = new Request();
		var flaskRequest = new Request();
		flaskRequest.sendPOSTRequest(_eventModel.SERVICE_ENDPOINTS.DELETE_EVENT , param,
			function(data) {
					_flaskLib.showSuccessMessage('action-msg', _eventModel.MESSAGES.DEL_SUCCESS);
					deleteEventFolder(eventId);
					loadData();
			} ,
			function(data) {
					_flaskLib.showErrorMessage('action-msg', _eventModel.MESSAGES.DEL_ERR);
			});
}

/* Delete Multiple Events */
function deleteMultipleEvents(eventList) {
	var param = {'eventIds': eventList};
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_eventModel.SERVICE_ENDPOINTS.DELETE_EVENTS, param,
					function(data) {
							var strEventIdArray = eventList.split(",");
							for (var iCount=0;iCount<strEventIdArray.length;iCount++) {
								var _eventId = parseInt(strEventIdArray[iCount]);
								deleteEventFolder(_eventId);
							}
							_flaskLib.showSuccessMessage('action-msg', _eventModel.MESSAGES.DEL_SUCCESS);
							loadData();
							$('#grid').jqxGrid('clearselection');
					} ,
					function(data) {
							_flaskLib.showErrorMessage('action-msg', _eventModel.MESSAGES.DEL_ERR);
					});
}

/* Edit Event */
function editEvent(rowData) {
	function formatUnixToTime(tdate)
	{
		var date = new Date(tdate);
		var hours = date.getHours();
		var minutes = "0" + date.getMinutes();
		var ampm = hours >= 12 ? 'PM' : 'AM';
		hours = hours % 12;
		return hours + ':' + minutes.substr(-2) + ' ' + ampm;
	}
		edit = true;
		var repositoryId = $("#repositoryId").val();
		_flaskLib.loadDataToForm("eventForm",  _eventModel.DATA_MODEL.EVENT, rowData, function(){});
		$("#eventDataTable").hide();
		$("#formContainer").show();
		_eventModel.loadVenues('venueId',  rowData.venueId);
		_eventModel.loadEventType('eventTypeId',  rowData.eventTypeId);
		var date = new Date(parseInt(rowData.eventDate));
		 var dd = date.getDate()
		   if ( dd < 10 ) dd = '0' + dd;
		   var mm = date.getMonth()+1;
		   if ( mm < 10 ) mm = '0' + mm;
		   var yy = date.getFullYear();
		   console.log(mm+'-'+dd+'-'+yy);
		$('#eventDate').val(mm+'-'+dd+'-'+yy);
		var sTime = new Date(parseInt(rowData.startTime));
		$('#startTime').val(formatUnixToTime(sTime));
		var eTime = new Date(parseInt(rowData.endTime));
		$('#endTime').val(formatUnixToTime(eTime));
		$(".AddContent").click(function() {
			$("#formContainer").hide();
			$('#eventDetailsForm').hide();
			$("#eventDetailsContainer").show();
			$("#eventDetailsDataTable").show();
			$("#infoTypeId").val($(this).attr("alt"));
		})
		fnRenderLogo(rowData.eventImageUUID, rowData.eventImageGroupId, $("#eventImage"),true);
		createDetailsTable({},_eventDetailModel.DATA_MODEL.EVENTDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_eventDetailModel.GRID_DATA_MODEL.EVENTDETAILS);
		loadEventDetailsData(rowData.eventId);
		validate();
}


/* Save Event */
function saveEvent() {
		var st=$("#startTime").val();
	    var et=$("#endTime").val();
	    var d= $("#eventDate").val();
	    var sTime=Date.parse(d+" "+st);
	    var eTime=Date.parse(d+" "+et);
		params = _flaskLib.getFormData('eventForm',_eventModel.DATA_MODEL.EVENT,
					function(formId, model, formData) {
							formData.venueId=$('#eventForm #venueId').val();
							formData.venueName = $('#eventForm #venueId').children(':selected').text();
							formData.eventTypeId=$('#eventTypeId').val();
							formData.eventTypeName = $('#eventTypeName').children(':selected').text();
		                    formData.startTime= sTime;
		                    formData.endTime= eTime;
							return formData;
					});
		console.log(params);
		var flaskRequest = new Request();
		var url = "";
			if (params.eventId == 0) {
				url =_eventModel.SERVICE_ENDPOINTS.ADD_EVENT;
			}else {
				url = _eventModel.SERVICE_ENDPOINTS.UPDATE_EVENT;
			}
		flaskRequest.sendGETRequest(url, params,
					function(data) {
						var IsNew = false;
						$("#eventForm #eventId").val(data.eventId);
						_flaskLib.showSuccessMessage('action-msg', _eventModel.MESSAGES.SAVE);
						if (parseInt(params.eventId) == 0 && parseInt(data.eventId) > 0) {
							$("#mcontents").attr("data-toggle","tab");
							$("#mcontents").css("cursor","default");
							IsNew = true;
						}
						if ($("#eventLogoImage").length>0) {
							fnSaveEventLogo(data.eventId,IsNew);
						}
						else {
							if (IsNew) {
									$('.nav-tabs > .active').next('li').find('a').trigger('click');
									createDetailsTable({},_eventDetailModel.DATA_MODEL.EVENTDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_eventDetailModel.GRID_DATA_MODEL.EVENTDETAILS);
									loadEventDetailsData(data.eventId);}
							else {
									$('.nav-tabs > .active').next('li').find('a').trigger('click');
									$('#eventDetailsDataTable').show();
									loadEventDetailsData(data.eventId);
								}
						}
					} ,
					function(data) {
						_flaskLib.showErrorMessage('action-msg', _eventModel.MESSAGES.ERROR);
					});
}

function initForm() {
		var repositoryId = $("#repositoryId").val();
		//$("#eventDate").jqxDateTimeInput({width: '260px', height: '35px',formatString: "MM-dd-yyyy" });
		$("#Active").jqxCheckBox({ width: 120, height: 25 });
		//$("#startTime").jqxDateTimeInput({ width: '100px', height: '23px', formatString: 'hh:mm tt', showTimeButton: true, showCalendarButton: false});
		//$("#endTime").jqxDateTimeInput({ width: '250px', height: '25px', formatString: 'hh:mm tt', showTimeButton: true, showCalendarButton: false});
}

function fnBuildEventUpload(imageContainer) {
	$(imageContainer).html("");
	var strSelected = "";
	dropZoneLogo = "";
	var objForm = $('<form/>',{'class':'dropzone','id':'eventLogoImage','action':$("#imgActionUrl").val()});
	$(objForm).appendTo(imageContainer);
	var objEventId = $('<input/>',{'name':'_eventId','id':'_eventId','type':'hidden','value':$("#eventId").val()});
	$(objEventId).appendTo(objForm);
	var objIsLogo = $('<input/>',{'name':'_isLogo','id':'_isLogo','type':'hidden','value':'Y'});
	$(objIsLogo).appendTo(objForm);

	dropZoneLogo = new Dropzone($(objForm).get(0),{
		autoProcessQueue: false,
		maxFiles: 1,
		addRemoveLinks : true
	});
}

function fnSaveEventLogo(eventId,IsNew) {
	$("#_eventId").val(eventId);
	dropZoneLogo.options.autoProcessQueue = true;
	dropZoneLogo.processQueue();
	dropZoneLogo.on("queuecomplete", function(file) {
		if (IsNew) {
			$('.nav-tabs > .active').next('li').find('a').trigger('click');
			createDetailsTable({},_eventDetailModel.DATA_MODEL.EVENTDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_eventDetailModel.GRID_DATA_MODEL.EVENTDETAILS);
			loadEventDetailsData(eventId);
		}
		else {
			$("#eventImage").html(""); // Clear upload component
			$("#eventDataTable").show();
			$("#formContainer").hide();
			loadData();
		}
	});
}

function fnDeleteFileByTitle(_repositoryId,_folderId,_title,_objDel) {
	params= {repositoryId:_repositoryId ,folderId: _folderId,title:_title};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventDetailModel.SERVICE_ENDPOINTS.DELETE_FILE_BY_TITLE , params,
		function(data) {
			if (typeof data=="object") {

			}
		},
		function(data) {

		});
}

$(document).ready(function() {
	_repositoryId = $("#repositoryId").val();
	validate();
});

function validate() {
	$('#eventForm').jqxValidator
	({
		hintType: 'label',
		animationDuration: 0,
		rules: [
		               { input: '#eventName', message: 'Event name is required!', action: 'keyup, blur', rule: 'required' },
		               { input: '#eventDate', message: 'Date must be current date or greater', action: 'keyup, blur', rule: function(input, commit) {
		            	   if (edit) {
		            		   return true;
		            	   }else {
		            		   var date = new Date();
			            	   var day = date.getDate();
			            	   var monthIndex = date.getMonth()+1;
			            	   var year = date.getFullYear();
			            	   var currentdate= "0"+monthIndex+"-"+day+"-"+year;
			            	   var inputdate= $("#eventDate").val();
			            	   var cdate=Date.parse(currentdate);
			            	   var indate=Date.parse(inputdate);

			            	   if (cdate<=indate){return true;}
			            	   else {return false;}
							}
		            	   }

		               },

		               {input: '#endTime', message: 'End time always greater than start time!', action: 'keyup, focus', rule: 'required'}
			   ]
	});
}