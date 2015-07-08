var imageContainer = $("#eventImage");
var eventForm;
var dropZoneLogo;
function addClickHandlers(){
	eventForm = $("#eventForm");
	/*	Initialize display elements*/
	
	$(".cssDelete").hide();	
	/* Click handler for add user button*/
	
	$(".cssAddUser").click(function(){
			$("#eventId").val(0);
			eventForm.trigger('reset')
			$("#eventDataTable").hide();
			$("#formContainer").show();
			_eventModel.loadVenues('venueId');
			_eventModel.loadEventType('eventTypeId');
			fnBuildEventUpload(imageContainer);		
	});
	/* Click handler for save button*/
	
	$(".clsSave").click(function(){
		saveEvent();
	});
	
	
	/* Click handler for cancel button*/

	$(".clsCancel").click(function(){
			loadData();
			$("#eventDataTable").show();
			$("#formContainer").hide();
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
			var eventList = GRID_PARAM.getCheckedIdList();
			if(eventList.length > 0){
					deleteMultipleEvents(eventList) ;	
			}
			 $(".cssDelete").hide();	
			 $(".cssDelUser").show();	
			 GRID_PARAM.toggleSelectionMode();
	    });
	
		/*	Toggle search boxes */
		$(".cssSearchUser").click(GRID_PARAM.toggleSearchBoxes);
}

function loadData(){
	var flaskRequest = new Request();
	params = {};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_EVENT, params, 
	function(data){/*success handler*/
		GRID_PARAM.updateGrid(data);
	} , function(error){ /*failure handler*/
		_flaskLib.showErrorMessage('action-msg',_eventModel.MESSAGES.GET_ERROR);
		console.log("Error in getting data: " + error);
	});
}

function contextMenuHandler(menuItemText, rowData){
	var args = event.args;
	if (menuItemText  == "Edit") {
		editEvent(rowData);
		return false;
	}else if(menuItemText == "Delete"){
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteEvent(rowData.eventId);
		}
		return false;			
	}
};

/* Delete Single Event */
function deleteEvent(eventId) {
		var param = {'eventId': eventId};
		var request = new Request();
		var flaskRequest = new Request();
		flaskRequest.sendPOSTRequest(_eventModel.SERVICE_ENDPOINTS.DELETE_EVENT , param, 
						function (data){
								_flaskLib.showSuccessMessage('action-msg', _eventModel.MESSAGES.DEL_SUCCESS);
								loadData();
						} ,
						function (data){
								_flaskLib.showErrorMessage('action-msg', _eventModel.MESSAGES.DEL_ERR);
						});
	
}

/* Delete Multiple Events */
function deleteMultipleEvents(eventList) {
	var param = {'eventIds': eventList};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_eventModel.SERVICE_ENDPOINTS.DELETE_EVENTS, param, 
					function (data){
							_flaskLib.showSuccessMessage('action-msg', _eventModel.MESSAGES.DEL_SUCCESS);
							loadData();
					} ,
					function (data){
							_flaskLib.showErrorMessage('action-msg', _eventModel.MESSAGES.DEL_ERR);
					});
	
}

/* Edit Event */
function editEvent(rowData) {
		var repositoryId = $("#repositoryId").val();
		_flaskLib.loadDataToForm("eventForm",  _eventModel.DATA_MODEL.EVENT, rowData, function(){});
		$("#eventDataTable").hide();
		//eventForm.show();
		$("#formContainer").show();
		_eventModel.loadVenues('venueId',  rowData.venueId);
		_eventModel.loadEventType('eventTypeId',  rowData.eventTypeId);
		var date = new Date(parseInt(rowData.eventDate));
		$('#eventDate').jqxDateTimeInput('setDate', date);
		var sTime = new Date(parseInt(rowData.startTime));
		$('#startTime').jqxDateTimeInput('setDate', sTime);
		var eTime = new Date(parseInt(rowData.endTime));
		$('#endTime').jqxDateTimeInput('setDate', eTime);
		$(".AddContent").click(function(){
			$("#formContainer").hide();
			$('#eventDetailsForm').hide();
			$("#eventDetailsContainer").show();
			$("#eventDetailsDataTable").show();			
			$("#infoTypeId").val($(this).attr("alt"));
		})
		fnShowEventLogo(repositoryId,rowData.eventId,$("#eventImage"), true)
}


/* Save Event */
function saveEvent(){
		params = _flaskLib.getFormData('eventForm',_eventModel.DATA_MODEL.EVENT,
					function(formId, model, formData){
							formData.venueId=$('#eventForm #venueId').val();
							formData.venueName = $('#eventForm #venueId').children(':selected').text();
							formData.eventTypeId=$('#eventTypeId').val();
							formData.eventTypeName = $('#eventTypeName').children(':selected').text();
							return formData;
					});
		var flaskRequest = new Request();
		var url = "";
			if(params.eventId == 0){
				url =_eventModel.SERVICE_ENDPOINTS.ADD_EVENT;
			}else{
				url = _eventModel.SERVICE_ENDPOINTS.UPDATE_EVENT;
			}
		flaskRequest.sendGETRequest(url, params, 
					function (data){
						_flaskLib.showSuccessMessage('action-msg', _eventModel.MESSAGES.SAVE);
						fnSaveEventLogo(data.eventId);
						$("#eventDataTable").show();
						$("#formContainer").hide();
						loadData();
					} ,
					function (data){
						_flaskLib.showErrorMessage('action-msg', _eventModel.MESSAGES.ERROR);
					});
}

function initForm(){
		var repositoryId = $("#repositoryId").val();
		$("#eventDate").jqxDateTimeInput({width: '260px', height: '35px',formatString: "MM-dd-yyyy" });
		$("#Active").jqxCheckBox({ width: 120, height: 25 });
		$("#startTime").jqxDateTimeInput({ width: '100px', height: '23px', formatString: 'hh:mm tt', showCalendarButton: false});
		$("#endTime").jqxDateTimeInput({ width: '250px', height: '25px', formatString: 'hh:mm tt', showCalendarButton: false});
}

function fnBuildEventUpload(imageContainer){
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

function fnSaveEventLogo(eventId){
	$("#_eventId").val(eventId);
	dropZoneLogo.options.autoProcessQueue = true;
	dropZoneLogo.processQueue();
	dropZoneLogo.on("queuecomplete", function (file) {
		$("#eventImage").html(""); // Clear upload component
	});	
}

function fnDeleteFileByTitle(_repositoryId,_folderId,_title,_objDel){
	params= {repositoryId:_repositoryId ,folderId: _folderId,title:_title};
	var flaskRequest = new Request();
	flaskRequest.sendGETRequest(_eventDetailModel.SERVICE_ENDPOINTS.DELETE_FILE_BY_TITLE , params, 
		function (data){
			if(typeof data=="object"){
				
			}		
		},
		function (data){
			
		});	
}
