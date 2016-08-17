var imageContainer = $("#eventImage");
var eventForm;
var dropZoneLogo;
var edit = false;

function addClickHandlers() {
	$("#mevent").click(function(){
		window.location.hash = '#ManageEvent';
	});
	$("#mcontents").click(function(){
		window.location.hash = '#ManageEventContent';
	});
	$(window).hashchange( function(){
		var hash = location.hash;
		switch(hash) {
	    case "#mevents":
	    	window.location.reload();
			break;
	    case "#ManageEvent":
	    	$("#mevent").click();
	        break;
	    case "#ManageEventContent":
	    	$("#mcontents").click();
	        break;	        
	    default:
	    	//alert("This is default");
		}		
	});
	eventForm = $("#eventForm");
	/*	Initialize display elements*/

	$(".cssDelete").hide();
	/* Click handler for add user button*/

	$(".cssAddUser").click(function() {
		window.location.hash = '#ManageEvent';
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
	
	if(!edit){
		$("#clsLogo").click(function(){
			if($("#logoList").find(".bs-glyphicons").length==0)
				renderEventLogos();
			
			 $(this).val() == "Choose existing logo" ? logo_upload() : logo_choose();
			 $("#eventImage").toggle(630,"swing");
			 $("#eventLogoList").toggle(630,"swing");
		});
	}
	else{
		$("#clsLogo").hide();
	}
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
		
		
		jQuery.expr[':'].case_insensitive_contains = function(a, i, m) {
			return jQuery(a).text().toUpperCase().indexOf(m[3].toUpperCase()) >= 0;
		};	
		
		$("#txtSearchLogo").keyup(function(){
			$("#logoList ul li span:case_insensitive_contains("+$(this).val()+")").closest("li").show(250, function() {});
			$("#logoList ul li span:not(:case_insensitive_contains("+$(this).val()+"))").closest("li").hide(500, function() {});
			if($("#logoList ul li:visible").length==0){
				$("#noMatchMessage").show(500);
			}
			else{
				$("#noMatchMessage").hide(500);
			}
			
		});
}

function loadData() {
	var flaskRequest = new Request();
	params = {};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_EVENT, params,
	function(data){/*success handler*/
		var events = eval(data);
		$.each(events.Events, function(index, event) {
			event.eventDate = _flaskLib.formatDateInMillis(event.eventDate);
			event.startTime = _flaskLib.formatTimeInMillis(event.startTime);
			event.endTime  = _flaskLib.formatTimeInMillis(event.endTime);
		});

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
	window.location.hash = '#ManageEvent';
		edit = true;
		var repositoryId = $("#repositoryId").val();
		_flaskLib.loadDataToForm("eventForm",  _eventModel.DATA_MODEL.EVENT, rowData, function(){});
		$("#eventDataTable").hide();
		$("#formContainer").show();
		_eventModel.loadVenues('venueId',  rowData.venueId);
		_eventModel.loadEventType('eventTypeId',  rowData.eventTypeId);

		
		$(".AddContent").click(function() {
			$("#formContainer").hide();
			$('#eventDetailsForm').hide();
			$("#eventDetailsContainer").show();
			$("#eventDetailsDataTable").show();
			$("#infoTypeId").val($(this).attr("alt"));
			$(".clsLogo").hide();
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
	    var sTime=Date.parse('1970-01-01 ' + st);
	    var eTime=Date.parse('1970-01-01 ' + et);
	    var eventDate = Date.parse(d);
		params = _flaskLib.getFormData('eventForm',_eventModel.DATA_MODEL.EVENT,
					function(formId, model, formData) {
							formData.venueId=$('#eventForm #venueId').val();
							formData.venueName = $('#eventForm #venueId').children(':selected').text();
							formData.eventTypeId=$('#eventTypeId').val();
							formData.eventTypeName = $('#eventTypeName').children(':selected').text();
		                    formData.startTime= sTime;
		                    formData.endTime= eTime;
		                    formData.eventDate = eventDate;
		                    //formData.eventImageUUID 
							return formData;
					});
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
						$("#eventForm #eventName").val(data.eventName);
						_flaskLib.showSuccessMessage('action-msg', _eventModel.MESSAGES.SAVE);
						if (parseInt(params.eventId) == 0 && parseInt(data.eventId) > 0) {
							$("#mcontents").attr("data-toggle","tab");
							$("#mcontents").css("cursor","default");
							IsNew = true;
						}
						if ($('#eventLogoImage').find('.dz-image').length>0) {
							alert("here is the validation place");
							fnSaveEventLogo(data.eventId,data.eventName,IsNew);
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
	
	dropZoneLogo.on("addedfile", function(file) {
		  file._captionBox = Dropzone.createElement("<input id='_eventLogoCaption' type='text' name='_eventLogoCaption' class='dropzone_caption' style='width:inherit' placeholder='Caption here..'/>");
		  file.previewElement.appendChild(file._captionBox);
	});	
	
}

function fnSaveEventLogo(eventId,eventName,IsNew) {
	$("#_eventId").val(eventId);
	$("#_eventName").val(eventName);
	//$("#_eventName").val(eventName);
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
	window.location.hash = '#mevents';
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
		               { input: '#eventDate', message: 'Date must be between today and two years in future', action: 'keyup, blur', rule: function(input, commit) {
		            	   if (edit) {
		            		   return true;
		            	   }else {
	            		   		   var inputDate = Date.parse($('#eventDate').val()); 		
			            		   var currentDate = new Date();
			            		   currentDate.setHours(0,0,0,0);//remove time part
			            		   var twoYear = currentDate.setFullYear(currentDate.getFullYear() +2);
			            		   if( inputDate < currentDate || inputDate > twoYear){
			            			   return true;
			            		   }
			            		   return true;
							}
		            	   }

		               },
		               {input: '#endTime', message: 'End time always greater than start time!', action: 'keyup, focus', rule: 'required'}
			   ]
	});
}

function renderEventLogos(){
	var flaskRequest = new Request();
	params = {};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_EVENT_LOGOS, params, 
	function(data){
		generateLogoIcons(data);	
	} , function(error){
		console.log(error);
	});
}

function generateLogoIcons(logos){
	var logoListDiv = $("#logoList");
	var tempHMTL = "";
	tempHMTL = "<div class='bs-glyphicons'><ul class='bs-glyphicons-list'>";
	$(logos).each(function(a,b){
		tempHMTL = tempHMTL+"<li onclick='setSelectedLogo(this);' data-uuid='"+b.uuid+"'>";
		var img = "<img src='/documents/"+b.groupId+"/"+b.folderId+"/"+b.title+"/"+b.uuid+"' data-title='"+b.title+"'>"
		var span = "<span class='logoTitle'>"+b.title+"</span>"
		tempHMTL = tempHMTL+img;
		tempHMTL = tempHMTL+span;
		tempHMTL = tempHMTL+"</li>";
	})
	tempHMTL = tempHMTL+"</ul></div>";
	logoListDiv.html(tempHMTL);
}

function logo_choose() {
    $('#clsLogo').val("Choose existing logo");
    // do play
}

function logo_upload() {
    $('#clsLogo').val("Upload new logo");
    // do pause
}

function setSelectedLogo(obj){
	$("#eventImageUUID").val($(obj).attr("data-uuid"));
	$("#eventImageGroupId").val(Liferay.ThemeDisplay.getScopeGroupId());
	$(".bs-glyphicons-list li").removeClass("selected");
	$(obj).toggleClass("selected");
}