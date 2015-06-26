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
	
	$(".cssVdSave").click(function(){
		saveVenueDetails();
	});	

	$(".cssVdCancel").click(function(){
		$("#eventDataTable").hide();
		$("#venueDetailsContainer").hide();
		eventForm.show();
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
		
	$("#AddVenue").click(function(){
		window.location.href="/web/flask/mvenues"
	});
	
	$(".cssAddVenueDetails").click(function(){
		$('#venueDetailsForm').show();
		$('#venueDetailsDataTable').hide();
	});	

	$(".cssGoToEvents").click(function(){
		$("#eventDataTable").hide();
		$("#venueDetailsContainer").hide();
		eventForm.show();
	});	
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

function loadVenueDetailsData(venueId){
	var flaskRequest = new Request();
	params = {'venueId':venueId};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_VENUE_DETAILS, params, 
	function(data){/*success handler*/
		console.log(venueId);
		GRID_PARAM.updateGrid(data);
	} , function(error){ /*failure handler*/
		console.log(error);
		_flaskLib.showErrorMessage('action-msg',_eventModel.MESSAGES.GET_ERROR);
		console.log("Error in getting data: " + error);
	});
}

function contextMenuHandler(menuItemText, rowData){
	var args = event.args;
	if (menuItemText  == "Edit") {
		console.log(rowData);
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

function contextMenuHandlerDetails(menuItemText, rowData){
	var args = event.args;
	if (menuItemText  == "Edit") {
		editVenueDetail(rowData);
		return false;
	}else if(menuItemText == "Delete"){
		var a = window.confirm("Are you sure ?");
		if (a) {
			deleteVenueDetail(rowData.venueDetailId,rowData.venueId);
		}
		return false;			
	}
};
//

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
		eventForm.show();
		_eventModel.loadVenues('venueId',  rowData.venueId);
		_eventModel.loadEventType('eventTypeId',  rowData.eventTypeId);
		var date = new Date(parseInt(rowData.eventDate));
		$('#eventDate').jqxDateTimeInput('setDate', date);
		var sTime = new Date(parseInt(rowData.startTime));
		$('#startTime').jqxDateTimeInput('setDate', sTime);
		var eTime = new Date(parseInt(rowData.endTime));
		$('#endTime').jqxDateTimeInput('setDate', eTime);
		fnRenderEvents(repositoryId,0,"Events");
		$(".AddContent").click(function(){
			loadVenueDetailsData(rowData.venueId);
			_eventModel.loadContentType('infoTypeCategoryId');
			fnRenderContentType($(this).attr("alt"));
		})
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
		$("#startTime").jqxDateTimeInput({ width: '100px', height: '23px', formatString: 'hh:mm tt', showCalendarButton: false});
		$("#endTime").jqxDateTimeInput({ width: '250px', height: '25px', formatString: 'hh:mm tt', showCalendarButton: false});
		$('#jqxtabs').bind('selected', function (event) {
			    var item = event.args.item;
			    var title = $('#jqxtabs').jqxTabs('getTitleAt', item);
		});
		$("#venueDetailsContainer").hide();
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
			   console.log("Error in creating Folder: "+obj);
		   });
}

/* creates folder for Event */
function eventFolder(repositoryId, eventsFolderId, eventName){
	var flaskRequest = new Request();
	params= {'repositoryId': repositoryId, 'parentFolderId': eventsFolderId, 'name': eventName};
	flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , params, 
			  function(data){
				    return data.folderId;
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
			        eventFolder($("#repositoryId").val(), data.folderId, eventName);
			} ,
			function (data){
					console.log("Error in getting Folder: " + data );
			});
}

function fnRenderEvents(repositoryId,parentFolderId,folderName){
	var folderId = 0;
	var flaskRequest = new Request();
		params= {'repositoryId': repositoryId, 'parentFolderId': parentFolderId, 'name': folderName};
		flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , params, 
			function (data){
				folderId = data.folderId;
				fnGetEventFolder(repositoryId,folderId,$("#eventName").val());
			} ,
			function (data){
				folderId = 0;
				console.log("Error in getting Folder: " + data );
			});
		return folderId;
}

function fnGetEventFolder(repositoryId,parentFolderId,folderName){
	var folderId = 0;
	//var eventType = [{"General":1,"PreEvent":2,"DuringEvent":3,"PostEvent":4}];
	var flaskRequest = new Request();
		params= {'repositoryId': repositoryId, 'parentFolderId': parentFolderId, 'name': folderName};
		flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , params, 
			function (data){
					folderId = data.folderId;
					fnRenderSliders(repositoryId,folderId,"General",1);
					fnRenderSliders(repositoryId,folderId,"Pre-Event",2);
					fnRenderSliders(repositoryId,folderId,"During-Event",3);
					fnRenderSliders(repositoryId,folderId,"Post-Event",4);
			} ,
			function (data){
				folderId = 0;
				console.log("Error in getting Folder: " + data );
			});
		return folderId;
}

function fnRenderSliders(repositoryId,parentFolderId,folderName,Count){
	var folderId = 0;
	var ws_images = "#ws_images"+Count;
	var wowslider_container = "#wowslider-container"+Count;
	var flaskRequest = new Request();
		params= {'repositoryId': repositoryId, 'parentFolderId': parentFolderId, 'name': folderName};
		flaskRequest.sendGETRequest(_eventModel.SERVICE_ENDPOINTS.GET_FOLDER , params, 
			function (data){
				folderId = data.folderId;
				displayImages(repositoryId, folderId, ws_images, wowslider_container)
			} ,
			function (data){
				folderId = 0;
				console.log("Error in getting Folder:"+data);
			});
		return folderId;
}

function displayImages(repositoryId, folderId, ws_images, wowslider_container)
{
 var images;
 Liferay.Service('/dlapp/get-file-entries',{
      repositoryId: repositoryId,
      folderId: folderId
    },
    function(obj) {
      if(typeof obj=="object" && obj.length > 0){
			var temp_html;
			var imageUrl;
			var uploadedby;
			temp_html="<ul>";
			for(var i=0;i<obj.length;i++)
			{
				imageUrl = "/documents/"+repositoryId+"/"+folderId+"/"+obj[i].title;
				uploadedby = "uploaded by " + obj[i].userName;
				temp_html=temp_html+"<li><img src="+imageUrl+" alt='"+uploadedby+"' title='"+uploadedby+"' id='wows1_0'/></li>";
			}
			temp_html=temp_html+"</ul>";
			$(ws_images).html(temp_html);
			$(wowslider_container).wowSlider();
      }
      else{
    	  //$(wowslider_container).html("No images found");
      }
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

/* Dynamic content type generation logic [Start]*/
var formArea;
var JsonObj;

function fnRenderContentType(InfoTypeID){
	$("#infoTypeId").val(InfoTypeID);
	$("#venueDetailsContainer").show();
	createTable({},_eventModel.DATA_MODEL.VENUEDETAILS, $('#gridDetails'), "actionMenuDetails", "Edit", contextMenuHandlerDetails, ["Images"],_eventModel.GRID_DATA_MODEL.VENUEDETAILS);
	$("#eventForm").hide();
}

$(document).ready(function(){
    formArea = $("#contentTypeForm"); // Parent Div        
    JsonObj = [{                    // JSON Field List, Content Type Wise
            "general":[{
                    "type":"text",
                    "attr":[{ 
                        "caption":"Title",
                        "id":"infoTitle",
                        "value":"",
                        "placeholder":"Enter title here",
                        "maxlength":"30",
                        "Class":""
                        }]
                    },
                    {                                
                    "type":"text",
                    "attr":[{ 
                        "caption":"Description",
                        "id":"infoDesc",
                        "value":"",
                        "placeholder":"Enter description here",
                        "maxlength":"30",
                        "Class":""
                        }]
                    },
                    {                                
                    "type":"upload",
                    "attr":[{ 
                    	"caption":"Upload Pictures",
                        "action":$("#imgActionUrl").val(),
                        "id":"venueId",
                    	"value":$("#venueId").val(),
                        "Class":""
                        }]
                    }],
            "tradition":[{
                    "type":"text",
                    "attr":[{ 
                        "caption":"Name",
                        "id":"infoTitle",
                        "value":"",
                        "placeholder":"Enter title here",
                        "maxlength":"30",
                        "Class":""
                        }]
                    },
                    {                                
                    "type":"text",
                    "attr":[{ 
                        "caption":"Description",
                        "id":"infoDesc",
                        "value":"",
                        "placeholder":"Enter description here",
                        "maxlength":"30",
                        "Class":""
                        }]
                    },
                    {                                
                    "type":"text",
                    "attr":[{ 
                        "caption":"Comment",
                        "id":"Comment",
                        "value":"",
                        "placeholder":"Enter Comment here",
                        "maxlength":"30",
                        "Class":""
                        }]
                    }],
            "parking":[{
                    "type":"text",
                    "attr":[{ 
                        "caption":"Name",
                        "id":"Title",
                        "value":"",
                        "placeholder":"Enter Name here",
                        "maxlength":"30",
                        "Class":""
                        }]
                    },
                    {                                
                    "type":"text",
                    "attr":[{ 
                        "caption":"Address",
                        "id":"Description",
                        "value":"",
                        "placeholder":"Enter Address here",
                        "maxlength":"30",
                        "Class":""
                        }]
                    },
                    {                                
                    "type":"text",
                    "attr":[{ 
                        "caption":"Cost",
                        "id":"Cost",
                        "value":"",
                        "placeholder":"Enter Cost here",
                        "maxlength":"30",
                        "Class":""
                        }]
                    },
                    {                                
                    "type":"boolean",
                    "attr":[{ 
                        "id":"IsAvailable",
                        "name":"IsAvailable",
                        "caption":"Is Available?",
                        "value":"Yes",
                        "items":["Yes","No"]
                        }]
                    }]                            
            }];
                      
    $("#infoTypeCategoryId").change(function(){
        $(formArea).html("");
        var selectedContentType = $("option:selected", this).text().toLowerCase();;
        fnRenderForm(selectedContentType);
    });
});

function fnRenderForm(contentType){
    var ObjJSON = fnSelectJSON(contentType)
    fnBuildHtml(ObjJSON);
}

function fnSelectJSON(cType){
    switch(cType) {
        case "general":
            return JsonObj[0].general;
            break;
        case "tradition":
            return JsonObj[0].tradition;
            break;
        case "parking":
            return JsonObj[0].parking;
            break;
        default:
            console.log("Nothing selected");
    }        
}

function fnBuildHtml(Obj){
    var items = Obj.filter(function(item) {
        switch(item.type) {
            case "text":
                return fnBuildInput(item.attr);
                break;
            case "select":
                return fnBuildSelect(item.attr);
                break;
            case "boolean":
                return fnBuildBoolean(item.attr);
                break;
            case "upload":
                return fnBuildUpload(item.attr);
                break;
            default:
                console.log("Nothing selected");
        }        
    });        
}

function fnBuildInput(Obj){
    var objFormGroup = $('<div/>',{'class':'form-group'}).appendTo($(formArea));
    var objControlLable = $('<label/>',{'class':'control-label','for':Obj[0].id}).appendTo(objFormGroup);
    $(objControlLable).html(Obj[0].caption);
    var objControls = $('<div/>',{'class':'controls'}).appendTo(objFormGroup);
    $('<input/>', {
        'type': 'Text',
        'id':Obj[0].id,
        'value':Obj[0].value,
        'placeholder':Obj[0].placeholder,   
        'maxlength':Obj[0].maxlength
    }).appendTo(objControls);
}

function fnBuildBoolean(Obj){
    var strSelected = "";
    var objFormGroup = $('<div/>',{'class':'form-group'}).appendTo($(formArea));
    var objControlLable = $('<label/>',{'class':'control-label','for':Obj[0].id}).appendTo(objFormGroup);
    $(objControlLable).html(Obj[0].caption);
    var objControls = $('<div/>',{'class':'controls'}).appendTo(objFormGroup);
    for(var iCount=0;iCount<Obj[0].items.length;iCount++){
        if(Obj[0].items[0].value==Obj[0].value)
            strSelected = "selected"    
        else
            strSelected = ""                                            
            
         $('<input/>', {
            'type': 'Radio',
            'id':Obj[0].id,
            'name':Obj[0].name,
            'value':Obj[0].value,
            'Selected':strSelected
        }).appendTo(objControls);
        var objItemCaptionLable = $('<span/>',{'class':'control-label'}).appendTo(objControls);
        $(objItemCaptionLable).html(Obj[0].items[iCount]);
    }
}

function fnBuildUpload(Obj){
	  var strSelected = "";
	    var objFormGroup = $('<div/>',{'class':'form-group'}).appendTo($(formArea));
	    var objControlLable = $('<label/>',{'class':'control-label','for':Obj[0].caption}).appendTo(objFormGroup);
	    $(objControlLable).html(Obj[0].caption);
	    var objControls = $('<div/>',{'class':'controls'}).appendTo(objFormGroup);
	    var objForm = $('<form/>',{'class':'dropzone','id':'venueImages','action':Obj[0].action}).appendTo(objFormGroup);
	    $(objForm).appendTo(objControls);
	    var objHiddenId = $('<input/>',{'id':Obj[0].id,'type':'hidden','value':'24490'}).appendTo($(formArea));
	    $(objHiddenId).appendTo(objForm);
	    var dropZone = new Dropzone($(objForm).get(0),{});	
	    dropZone.on("addedfile", function(file) {
	        //alert("Do you wish to add information about images?");
	    });	    
}
/* Dynamic content type generation logic [End]*/
function saveVenueDetails(){
	params = _flaskLib.getFormData('venueDetailsForm',_eventModel.DATA_MODEL.VENUEDETAILS,
			function(formId, model, formData){
				$.each(model, function(i, item) {
					var ele = $('#'+ formId + ' #'+item.name);
					var val = $.trim(ele.val());
					if(item.type == 'long' && val ==''){
						val = Number(val)
					}
					formData[item.name] = val;	
				});
				formData.venueId=$('#eventForm #venueId').val();
				return formData;
			});
	var flaskRequest = new Request();
	var url = ""
		if(params.venueDetailId == 0){
			url = _eventModel.SERVICE_ENDPOINTS.ADD_VENUE_DETAILS;
		}else{
			url =_eventModel.SERVICE_ENDPOINTS.UPDATE_VENUE_DETAILS;
		}
	flaskRequest.sendGETRequest(url, params, 
				function (data){
					_flaskLib.showSuccessMessage('action-msg', _eventModel.MESSAGES.V_SAVE);
					loadVenueDetailsData(params.venueId);
					$('#venueDetailsForm').hide();
					$('#venueDetailsDataTable').show();	
				} ,
				function (data){
					_flaskLib.showErrorMessage('action-msg', _eventModel.MESSAGES.V_ERROR);
				});
	$("#venueDetailId").val(0);
	$("#infoTypeCategoryId").val(0);
	$("#infoTypeCategoryId").change();
}

//

/* Delete Single Event */
function deleteVenueDetail(venueDetailId,venueId) {
		var param = {'venueDetailId': venueDetailId};
		var request = new Request();
		var flaskRequest = new Request();
		flaskRequest.sendPOSTRequest(_eventModel.SERVICE_ENDPOINTS.DELETE_VENUE_DETAIL , param, 
			function (data){
					_flaskLib.showSuccessMessage('action-msg', _eventModel.MESSAGES.DEL_SUCCESS);
					loadVenueDetailsData(venueId);
			} ,
			function (data){
					_flaskLib.showErrorMessage('action-msg', _eventModel.MESSAGES.DEL_ERR);
			});
}

/* Delete Multiple Events */
function deleteMultipleVenueDetail(eventList) {
	var param = {'eventIds': eventList};
	var request = new Request();
	var flaskRequest = new Request();
	flaskRequest.sendPOSTRequest(_eventModel.SERVICE_ENDPOINTS.DELETE_ALL_VENUE_DETAILS, param, 
		function (data){
				_flaskLib.showSuccessMessage('action-msg', _eventModel.MESSAGES.DEL_SUCCESS);
				//loadVenueDetailsData(venueId);
		} ,
		function (data){
				_flaskLib.showErrorMessage('action-msg', _eventModel.MESSAGES.DEL_ERR);
		});
}

/* Edit Event */
function editVenueDetail(rowData) {
		var repositoryId = $("#repositoryId").val();
		$('#venueDetailsForm #venueId').val($('#eventForm #venueId').val());
		$("#venueDetailId").val(rowData.venueDetailId);
		$("#infoTypeCategoryId").val(rowData.infoTypeCategoryId);
		$("#infoTypeCategoryId").change();
		$('#venueDetailsForm').show();
		$('#venueDetailsDataTable').hide();
		_flaskLib.loadDataToForm("venueDetailsForm",  _eventModel.DATA_MODEL.VENUEDETAILS, rowData, function(){});
}

function formatUnixToTime(tdate){var date = new Date(tdate);
	var hours = date.getHours();
	var minutes = "0" + date.getMinutes();
	var seconds = "0" + date.getSeconds();
	return hours + ':' + minutes.substr(-2) + ':' + seconds.substr(-2);
}