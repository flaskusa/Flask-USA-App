var eventForm;
function addClickHandlers(){
	eventForm = $("#eventForm");
	/*	Initialize display elements*/
	
	$(".cssDelete").hide();	
	
	/* Click handler for add user button*/
	
	$(".cssAddUser").click(function(){
			eventForm.trigger('reset')
			$("#eventDataTable").hide();
			eventForm.show();
			_eventModel.loadVenues('venueId');
			_eventModel.loadEventType('eventTypeId');
	});

	/* Click handler for save button*/
	
	$(".clsSave").click(function(){
			saveEvent();
			var eventName,eventDesc;
			var repositoryId = $("#repositoryId").val();
			if(typeof(eventfolder)=='undefined' || eventfolder=='undefined'){
				createFolder(repositoryId, 0, "Events", "This folder will contain all the events content");
				setTimeout(function(){getFolderId(repositoryId,0,"Events");},400);
				eventName=$("#eventName").val();
				eventDesc=$("#eventName").val();
			}
			else{
				eventName=$("#eventName").val();
				eventDesc=$("#eventName").val();
				createFolder(repositoryId, eventfolder, eventName, eventDesc);
				getFolderId(repositoryId,0,"Events");
			}		
	});


	/* Click handler for cancel button*/

	$(".clsCancel").click(function(){
			$("#eventDataTable").show();
			eventForm.hide();
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
	for(var i=0;i<eventList.length;i++)
	{
		var temp = eventList[i].eventId;
		deleteEvent(temp);
	}	
}

/* Edit Event */
function editEvent(rowData) {
		_flaskLib.loadDataToForm("eventForm",  _eventModel.DATA_MODEL.EVENT, rowData, function(){});
		$("#eventDataTable").hide();
		eventForm.show();
		_eventModel.loadVenues('venueId',  rowData.venueId);
		_eventModel.loadEventType('eventTypeId',  rowData.eventTypeId);
		var date = new Date(parseInt(rowData.eventDate));
		$('#eventDate').jqxDateTimeInput('setDate', date);
		var sTime = new Date(parseInt(rowData.startTime));
		$('#startTime').jqxDateTimeInput('setDate', sTime);
		var eTime = new Date(parseInt(rowData.endTime));
		$('#endTime').jqxDateTimeInput('setDate', eTime);
		console.log(sTime);
		console.log(eTime);
}

/* Save Event */
function saveEvent(){
		params = _flaskLib.getFormData('eventForm',_eventModel.DATA_MODEL.EVENT,
					function(formId, model, formData){
							formData.venueId=$('#venueId').val();
							formData.venueName = $('#venueId').children(':selected').text();
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
						loadData();
					} ,
					function (data){
						_flaskLib.showErrorMessage('action-msg', _eventModel.MESSAGES.ERROR);
					});
}

function initForm(){
		$("#eventDate").jqxDateTimeInput({width: '260px', height: '35px',formatString: "MM-dd-yyyy" });
		$("#Active").jqxCheckBox({ width: 120, height: 25 });
		$('#jqxtabs').jqxTabs({width: '100%',height: 350});
		$("#startTime").jqxDateTimeInput({ width: '100px', height: '23px', formatString: 'T', showCalendarButton: false});
		$("#endTime").jqxDateTimeInput({ width: '250px', height: '25px', formatString: 'T', showCalendarButton: false});
		$('#jqxtabs').bind('selected', function (event) {
			    var item = event.args.item;
			    var title = $('#jqxtabs').jqxTabs('getTitleAt', item);
		});
}

/* Need to change code as per standard*/
/* Creates Folder */
function createFolder(repositoryId,parentFolderId,folderName,folderDesc){
	
	var flaskRequest = new Request();
	params= {'repositoryId': repositoryId, 'parentFolderId': parentFolderId, 'name': folderName, 'description': folderDesc};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.ADD_FOLDER , params,
		   function(obj) {
			    
		   },
		   function(obj) {
			   console.log("Error in creating Folder: " + data );
		   });
}

/* creates folder for Event */
function eventFolder(repositoryId, eventsFolderId, eventName){
	var flaskRequest = new Request();
	params= {'repositoryId': repositoryId, 'parentFolderId': eventsFolderId, 'name': eventName};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , params, 
			  function(data){
				    console.log(data);
			  },
			  function (data){
				  if(data=="com.liferay.portlet.documentlibrary.NoSuchFolderException")
			    	{
			    		createFolder(repositoryId, eventsFolderId, eventName, eventName);
			    		setTimeout(function(){createInfoTypeFolders(repositoryId, eventsFolderId, eventName)},500);	
			    	}
		      });
}

/* Get complete folder details */
function getFolderId(repositoryId,parentFolderId,folderName){
	var flaskRequest = new Request();
		params= {'repositoryId': repositoryId, 'parentFolderId': parentFolderId, 'name': folderName};
		flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , params, 
			function (data){
					eventName=$("#eventName").val();
			 		eventDesc=$("#eventName").val();
			        console.log(data);
			        eventFolder($("#repositoryId").val(), data.folderId, eventName);
			} ,
			function (data){
					console.log("Error in getting Folder: " + data );
			});
}

/* creates folders for each info type */
function createInfoTypeFolders(repositoryId, eventsFolderId, eventName)
{
	var flaskRequest = new Request();
	params= {'repositoryId': repositoryId, 'parentFolderId': eventsFolderId, 'name': eventName};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , params, 
		function (data){
		 var EventsFolderId = data.folderId;
		 flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_INFO_TYPES , {}, 
					function (obj){
						 	for(var i=0; i<obj.length; i++)
					    	{
					    		createFolder(repositoryId, EventsFolderId, obj[i].infoTypeName, "This folder will contain "+ obj[i].infoTypeName +" related files");
					    	}
						 	console.log("info type folders created successfully");
					} ,
					function (data){
							console.log("Error in creating Info-Type Folders: " + data );
					});
		} ,
		function (data){
				console.log("Error in getting Event Folder Id for creating Info-Type Folders: " + data );
		});
}
/*End*/