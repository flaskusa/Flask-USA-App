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
		_eventModel.loadEvents('eventVenueId');
	});

	/* Click handler for save button*/
	
	$(".clsSave").click(function(){
		saveEvent();
		var eventName,eventDesc;
		var repositoryId = $("#repositoryId").val();
		if(typeof(eventfolder)=='undefined' || eventfolder=='undefined'){
			createFolder(repositoryId, 0, "Events", "This folder will contain all the events content");
			getFolderId(repositoryId,0,"Events");
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
			deleteMultipleVenues(eventList) ;	
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
			deleteVenue(rowData.eventId);
		}
		return false;			
	}
};

function deleteVenue(eventId) {
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

function deleteMultipleVenues(eventList) {
	var param = {eventList: eventList};
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

function editEvent(rowData) {
	_flaskLib.loadDataToForm("eventForm",  _eventModel.DATA_MODEL.EVENT, rowData, function(){
		
	});
	$("#eventDataTable").hide();
	eventForm.show();
	_eventModel.loadEvents('eventVenueId',  rowData.eventVenueId);
}


function saveEvent(){
	params = _flaskLib.getFormData('eventForm',_eventModel.DATA_MODEL.EVENT,
				function(formId, model, formData){
						formData.eventVenueName=$('#eventVenueId').children(':selected').text();;
						return formData;
				});
	var flaskRequest = new Request();
	var url = ""
		console.log(params.eventId);
		console.log(params);
		if(parseInt(params.eventId) > 0){
			url =_eventModel.SERVICE_ENDPOINTS.UPDATE_EVENT
		}else{
			url = _eventModel.SERVICE_ENDPOINTS.ADD_EVENT;
		}
	console.log(url);
	flaskRequest.sendGETRequest(url, params, 
				function (data){
					_flaskLib.showSuccessMessage('action-msg', _eventModel.MESSAGES.SAVE);
					loadData();
				} ,
				function (data){
					console.log(data);
					_flaskLib.showErrorMessage('action-msg', _eventModel.MESSAGES.ERROR);
				});

}

function initForm(){
	$("#eventDate").jqxDateTimeInput({width: '260px', height: '35px',formatString: "MM-dd-yyyy" });
	$("#Active").jqxCheckBox({ width: 120, height: 25 });
	$('#jqxtabs').jqxTabs({width: '100%',height: 350});
	$("#startTime").jqxDateTimeInput({ formatString: 'hh:mm tt', showCalendarButton: false});
	$("#endTime").jqxDateTimeInput({ formatString: 'hh:mm tt', showCalendarButton: false});
	$('#jqxtabs').bind('selected', function (event) {
	    var item = event.args.item;
	    var title = $('#jqxtabs').jqxTabs('getTitleAt', item);
	});
}

/* Need to change code as per standard*/

function createFolder(repositoryId,parentFolderId,folderName,folderDesc){
	 Liferay.Service(
	   '/dlapp/add-folder',
	   {
	     repositoryId: repositoryId,
	     parentFolderId: parentFolderId,
	     name: folderName,
	     description: folderDesc
	   },
	   function(obj) {
	    if(obj=="com.liferay.portlet.documentlibrary.DuplicateFolderNameException")
	    {
		     Liferay.Service(
		       '/dlapp/get-folder',
		       {
			         repositoryId: repositoryId,
			         parentFolderId: parentFolderId,
			         name: folderName
		       },
		       function(obj) {
		        	 console.log(obj);
		       });
	    }
	    else
	    {
	    	 return obj.folderId;
	    }
	   }
	 );
}

function eventFolder(repositoryId, eventsFolderId, eventName){
	Liferay.Service(
			  '/dlapp/get-folder',
			  {
				    repositoryId: repositoryId,
				    parentFolderId: eventsFolderId,
				    name: eventName
			  },
			  function(obj) {
				    console.log(obj);
				    if(obj=="com.liferay.portlet.documentlibrary.NoSuchFolderException")
				    	{
				    		createFolder(repositoryId, eventsFolderId, eventName, eventName);
				    		setTimeout(function(){createInfoTypeFolders(repositoryId, eventsFolderId, eventName)},100);
				    			
				    	}
				    else
				    	{
				    		return obj;
				    	}
			  }
			);
}

function getFolderId(repositoryId,parentFolderId,folderName){
	   Liferay.Service('/dlapp/get-folder',
	     {
		       repositoryId: repositoryId,
		       parentFolderId: parentFolderId,
		       name: folderName
	     },
	     function(obj) {
		    	eventName=$("#eventName").val();
		 		eventDesc=$("#eventName").val();
		        console.log(obj);
		        eventFolder($("#repositoryId").val(), obj.folderId, eventName);
	     });
}

function createInfoTypeFolders(repositoryId, eventsFolderId, eventName)
{
	 Liferay.Service('/dlapp/get-folder',
		     {
		       repositoryId: repositoryId,
		       parentFolderId: eventsFolderId,
		       name: eventName
		     },
		     function(obj) {
			       console.log(obj);
			       createFolder(repositoryId, obj.folderId, "General", "This folder will contain general files");
			       createFolder(repositoryId, obj.folderId, "Pre-Event", "This folder will contain Pre-Event related files");
			       createFolder(repositoryId, obj.folderId, "Durring-Event", "This folder will contain Durring-Event related files");
			       createFolder(repositoryId, obj.folderId, "Post-Event", "This folder will contain Post-Event related files");
			       console.log("info type folders created successfully");
		     });
}
/*End*/